package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.POIDocument;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hslf.exceptions.CorruptPowerPointFileException;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.exceptions.OldPowerPointFormatException;
import org.apache.poi.hslf.record.CurrentUserAtom;
import org.apache.poi.hslf.record.Document;
import org.apache.poi.hslf.record.DocumentEncryptionAtom;
import org.apache.poi.hslf.record.ExOleObjStg;
import org.apache.poi.hslf.record.PersistPtrHolder;
import org.apache.poi.hslf.record.PersistRecord;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.hslf.record.UserEditAtom;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFSlideShowImpl extends POIDocument implements Closeable {
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH;
    private byte[] _docstream;
    private HSLFObjectData[] _objects;
    private List<HSLFPictureData> _pictures;
    private Record[] _records;
    private CurrentUserAtom currentUser;

    static final class PictureFactory {
        final byte[] imageData;
        private final int offset;
        private EscherBSERecord record;
        private final EscherContainerRecord recordContainer;
        private final int signature;
        private final PictureData.PictureType type;

        PictureFactory(EscherContainerRecord r3, PictureData.PictureType r4, byte[] r5, int r6, int r7) {
            this.recordContainer = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3), EscherContainerRecord.class, "com.obric.memorydata.plugin");
            this.type = (PictureData.PictureType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), PictureData.PictureType.class, "com.obric.memorydata.plugin");
            this.imageData = (byte[]) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r5), byte[].class, "com.obric.memorydata.plugin");
            this.offset = r6;
            this.signature = r7;
        }

        static /* synthetic */ int access$000(PictureFactory r0) {
            return r0.offset;
        }

        static /* synthetic */ PictureData.PictureType access$100(PictureFactory r0) {
            return r0.type;
        }

        HSLFPictureData build() {
            Objects.requireNonNull(this.record, "Can't build an instance until the record has been assigned.");
            return HSLFPictureData.createFromSlideshowData(this.type, this.recordContainer, this.record, this.imageData, this.signature);
        }

        int getOffset() {
            return this.offset;
        }

        PictureFactory setRecord(EscherBSERecord r1) {
            this.record = r1;
            return this;
        }
    }

    static {
        LOG = b.a(HSLFSlideShowImpl.class);
        MAX_RECORD_LENGTH = 200000000;
    }

    public HSLFSlideShowImpl(InputStream r2) {
        this(new POIFSFileSystem(r2));
    }

    public HSLFSlideShowImpl(DirectoryNode r2) {
        super(handleDualStorage(r2));
        readCurrentUserStream();     // Catch: Throwable -> L5
        readPowerPointStream();     // Catch: Throwable -> L5
        buildRecords();     // Catch: Throwable -> L5
        readOtherStreams();     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        r2.getFileSystem().close();
        throw e;
    }

    public HSLFSlideShowImpl(POIFSFileSystem r1) {
        this(r1.getRoot());
    }

    private void buildRecords() {
        this._records = read(this._docstream, (int) this.currentUser.getCurrentEditOffset());
    }

    public static HSLFSlideShowImpl create() {
        InputStream r0 = HSLFSlideShowImpl.class.getResourceAsStream("/org/apache/poi/hslf/data/empty.ppt");     // Catch: IOException -> L20
        if (r0 == null) goto L11;
        HSLFSlideShowImpl r1 = new HSLFSlideShowImpl(r0);     // Catch: Throwable -> L8
        if (r0 == null) goto L7;
        r0.close();     // Catch: IOException -> L20
    L7:
        return r1;
    L11:
        throw new HSLFException("Missing resource 'empty.ppt'");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 != null) goto L26;
    L19:
        throw th;     // Catch: IOException -> L20
    L26:
        r0.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new HSLFException(e);
    }

    private EscherContainerRecord getBlipStore() {
        Record[] r8 = this._records;
        int r0 = r8.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        Record r3 = r8[r1];
        if (r3.getRecordType() == RecordTypes.Document.typeID) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        Document r9 = (Document) ZeusTransformUtils.preCheckCast(r3, Document.class, "com.obric.memorydata.plugin");
    L10:
        if (r9 == null) goto L16;
        EscherContainerRecord r10 = r9.getPPDrawingGroup().getDggContainer();
        EscherContainerRecord r2 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(HSLFShape.getEscherChild(r10, EscherContainerRecord.BSTORE_CONTAINER), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L19;
        EscherContainerRecord r4 = new EscherContainerRecord();
        r4.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
        r10.addChildBefore(r4, EscherOptRecord.RECORD_ID);
        return r4;
    L19:
        return r2;
    L16:
        throw new CorruptPowerPointFileException("Document record is missing");
    L9:
        r9 = null;
        goto L10
    }

    private static DirectoryNode handleDualStorage(DirectoryNode r2) {
        if (r2.hasEntry("PP97_DUALSTORAGE") == true) goto L6;
        return r2;
    L6:
        return (DirectoryNode) ZeusTransformUtils.preCheckCast(r2.getEntry("PP97_DUALSTORAGE"), DirectoryNode.class, "com.obric.memorydata.plugin");
    }

    private void initRecordOffsets(byte[] r5, int r6, NavigableMap<Integer, Record> r7, Map<Integer, Integer> r8) {
        NavigableMap r4 = (NavigableMap) ZeusTransformUtils.wrapperContextForParams(r7, NavigableMap.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
    L3:
        if (r6 == 0) goto L31;
        UserEditAtom r10 = (UserEditAtom) ZeusTransformUtils.preCheckCast(Record.buildRecordAtOffset(r5, r6), UserEditAtom.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L30;
        r4.put(Integer.valueOf(r6), r10);
        int r11 = r10.getPersistPointersOffset();
        PersistPtrHolder r1 = (PersistPtrHolder) ZeusTransformUtils.preCheckCast(Record.buildRecordAtOffset(r5, r11), PersistPtrHolder.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L28;
        r4.put(Integer.valueOf(r11), r1);
        Iterator<Map.Entry<Integer, Integer>> r12 = r1.getSlideLocationsLookup().entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.memorydata.plugin");
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin");
        r4.put(r3, null);
        r9.put(r3, r13);
        goto L10
    L12:
        r6 = r10.getLastUserEditAtomOffset();
        if (r6 <= 0) goto L3;
        if (r4.containsKey(Integer.valueOf(r6)) == false) goto L3;
        r6 = ((Integer) ZeusTransformUtils.preCheckCast(r4.firstKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() - 36;
        int r14 = LittleEndian.getUShort(r5, r6);
        int r15 = LittleEndian.getUShort(r5, r6 + 2);
        int r16 = LittleEndian.getInt(r5, r6 + 4);
        if (r14 != 0) goto L26;
        if (r15 != 4085) goto L26;
        if (r16 != 28) goto L23;
    L24:
        LOG.atWarn().a("Repairing invalid user edit atom");
        r10.setLastUserEditAtomOffset(r6);
        goto L3
    L23:
        if (r16 == 32) goto L24;
    L26:
        throw new CorruptPowerPointFileException("Powerpoint document contains invalid user edit atom");
    L28:
        throw new CorruptPowerPointFileException("Powerpoint document is missing a PersistPtrHolder at " + r11);
    L30:
        throw new CorruptPowerPointFileException("Powerpoint document contains no user edit atom");
    }

    static /* synthetic */ List lambda$matchPicturesAndRecords$0(Integer r0) {
        return new ArrayList();
    }

    private static void matchPicturesAndRecords(List<PictureFactory> r11, EscherContainerRecord r12) {
        LinkedList r0 = new LinkedList((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"));
        r0.sort(Comparator.comparingInt($$Lambda$UlmBbO7yKgRDreLfTUVbErdydkw.INSTANCE));
        HashMap r13 = new HashMap();
        Iterator<EscherRecord> r2 = r12.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        EscherBSERecord r3 = (EscherBSERecord) ZeusTransformUtils.preCheckCast((EscherRecord) ZeusTransformUtils.preCheckCast(r2.next(), EscherRecord.class, "com.obric.memorydata.plugin"), EscherBSERecord.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.preCheckCast(r13.computeIfAbsent(Integer.valueOf(r3.getOffset()), $$Lambda$HSLFSlideShowImpl$3hfyPYFK8MAjZrDjAy5YEYmMrKs.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(r3);
        goto L4
    L6:
        Iterator r4 = r0.iterator();
    L7:
        int r5 = 0;
        if (r4.hasNext() == false) goto L25;
        PictureFactory r6 = (PictureFactory) ZeusTransformUtils.preCheckCast(r4.next(), PictureFactory.class, "com.obric.memorydata.plugin");
        int r7 = r6.getOffset();
        List r8 = (List) ZeusTransformUtils.preCheckCast(r13.get(Integer.valueOf(r7)), List.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L24;
        if (r8.isEmpty() == true) goto L24;
        if (r8.size() == 1) goto L16;
    L19:
        if (r5 >= r8.size()) goto L7;
        EscherBSERecord r9 = (EscherBSERecord) ZeusTransformUtils.preCheckCast(r8.get(r5), EscherBSERecord.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(r9.getUid(), Arrays.copyOf(r6.imageData, 16)) == true) goto L22;
        r5 = r5 + 1;
        goto L19
    L22:
        r6.setRecord(r9);
        r8.remove(r5);
    L17:
        r4.remove();
        goto L7
    L16:
        r6.setRecord((EscherBSERecord) ZeusTransformUtils.preCheckCast(r8.get(0), EscherBSERecord.class, "com.obric.memorydata.plugin"));
        r13.remove(Integer.valueOf(r7));
    L24:
        LOG.atDebug().a("No records with offset {}", v.a(r7));
        goto L7
    L25:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r13.values().stream().flatMap($$Lambda$2uajARPg7zs3QXdN3ekutEAqAgM.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L27:
        if (r1.hasNext() == false) goto L36;
        PictureFactory r10 = (PictureFactory) ZeusTransformUtils.preCheckCast(r1.next(), PictureFactory.class, "com.obric.memorydata.plugin");
        int r15 = r14.size() - 1;
        boolean r16 = false;
    L29:
        if (r15 < 0) goto L34;
        EscherBSERecord r17 = (EscherBSERecord) ZeusTransformUtils.preCheckCast(r14.get(r15), EscherBSERecord.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(r17.getUid(), Arrays.copyOf(r10.imageData, 16)) == false) goto L33;
        r14.remove(r15);
        r10.setRecord(r17);
        r17.setOffset(r10.getOffset());
        r16 = true;
    L33:
        r15 = r15 - 1;
        goto L29
    L34:
        if (r16 == true) goto L27;
        LOG.atDebug().a("No record found for picture at offset {}", v.a(PictureFactory.access$000(r10)));
        r10.setRecord(HSLFSlideShow.addNewEscherBseRecord(r12, PictureFactory.access$100(r10), r10.imageData, PictureFactory.access$000(r10)));
        goto L27
    L36:
        LOG.atDebug().a("Found {} unmatched records.", v.a(r14.size()));
    }

    private Record[] read(byte[] r9, int r10) {
        TreeMap r0 = new TreeMap();
        Map<Integer, Integer> r1 = new HashMap();
        initRecordOffsets(r9, r10, r0, r1);
        HSLFSlideShowEncrypted r8 = new HSLFSlideShowEncrypted(r9, r0);
        Iterator<Map.Entry<Integer, Record>> r11 = r0.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin");
        Record r5 = (Record) ZeusTransformUtils.preCheckCast(r2.getValue(), Record.class, "com.obric.memorydata.plugin");
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r1.get(r4), Integer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        r8.decryptRecord(r9, r6.intValue(), r4.intValue());
        r5 = Record.buildRecordAtOffset(r9, r4.intValue());
        r2.setValue(r5);
    L9:
        if (ZeusTransformUtils.instanceOf(r5, PersistRecord.class) == false) goto L4;
        ((PersistRecord) ZeusTransformUtils.preCheckCast(r5, PersistRecord.class, "com.obric.memorydata.plugin")).setPersistId(r6.intValue());
        goto L4
    L11:
        r8.close();
        return (Record[]) ZeusTransformUtils.preCheckCast(r0.values().toArray(new Record[0]), Record[].class, "com.obric.memorydata.plugin");
    }

    private void readCurrentUserStream() {
        this.currentUser = new CurrentUserAtom(getDirectory());     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        LOG.atError().a(e).a("Error finding Current User Atom");
        this.currentUser = new CurrentUserAtom();
    }

    private void readOtherStreams() {
    }

    private void readPictures() {
        if (getDirectory().hasEntry("Pictures") == true) goto L6;
        this._pictures = new ArrayList();
        return;
    L6:
        DocumentEntry r0 = (DocumentEntry) ZeusTransformUtils.preCheckCast(getDirectory().getEntry("Pictures"), DocumentEntry.class, "com.obric.memorydata.plugin");
        EscherContainerRecord r1 = getBlipStore();
        DocumentInputStream r3 = getDirectory().createDocumentInputStream(r0);
        byte[] r2 = IOUtils.toByteArray(r3, r0.getSize());     // Catch: Throwable -> L48
        if (r3 == null) goto L10;
        r3.close();
    L10:
        ArrayList r9 = new ArrayList();
        HSLFSlideShowEncrypted r10 = new HSLFSlideShowEncrypted(getDocumentEncryptionAtom());
        int r7 = 0;
    L59:
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L45
    L47:
        throw th;
    L45:
        th = move-exception;
        th.addSuppressed(th);
        goto L47
    L12:
        if (r7 > (r2.length - 8)) goto L30;
        r10.decryptPicture(r2, r7);     // Catch: Throwable -> L40
        int r8 = LittleEndian.getUShort(r2, r7);     // Catch: Throwable -> L40
        int r4 = r7 + 2;     // Catch: Throwable -> L40
        int r5 = LittleEndian.getUShort(r2, r4);     // Catch: Throwable -> L40
        int r6 = r4 + 2;     // Catch: Throwable -> L40
        int r11 = LittleEndian.getInt(r2, r6);     // Catch: Throwable -> L40
        int r12 = r6 + 4;     // Catch: Throwable -> L40
        if (r5 == 61447) goto L19;
        if (r5 < 61464) goto L30;
        if (r5 > 61719) goto L30;
    L19:
        if (r11 < 0) goto L29;
        PictureData.PictureType r13 = PictureData.PictureType.forNativeID(r5 - 61464);     // Catch: Throwable -> L40
        if (r13 != null) goto L24;
        LOG.atError().a("Problem reading picture: Invalid image type 0, on picture with length {}.\nYour document will probably become corrupted if you save it! Position: {}", v.a(r11), v.a(r12));     // Catch: Throwable -> L40
    L27:
        r7 = r12 + r11;     // Catch: Throwable -> L40
        goto L59
    L24:
        if ((r12 + r11) > r2.length) goto L25;
        r9.add(new PictureFactory(r1, r13, IOUtils.safelyClone(r2, r12, r11, MAX_RECORD_LENGTH), r7, r8));     // Catch: Throwable -> L40
        goto L27
    L25:
        LOG.atWarn().a("\"Pictures\" stream may have ended early. In some circumstances, this is not a problem; in others, this could indicate a corrupt file");     // Catch: Throwable -> L40
        goto L30
    L29:
        throw new CorruptPowerPointFileException("The file contains a picture, at position " + r9.size() + ", which has a negatively sized data length, so we can't trust any of the picture data");     // Catch: Throwable -> L40
    L30:
        r10.close();
        matchPicturesAndRecords(r9, r1);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r9.iterator();
    L32:
        if (r15.hasNext() == false) goto L38;
        HSLFPictureData r16 = ((PictureFactory) ZeusTransformUtils.preCheckCast(r15.next(), PictureFactory.class, "com.obric.memorydata.plugin")).build();     // Catch: IllegalArgumentException -> L36
        r16.setIndex(r14.size() + 1);     // Catch: IllegalArgumentException -> L36
        r14.add(r16);     // Catch: IllegalArgumentException -> L36
    L36:
        e = move-exception;
        LOG.atError().a(e).a("Problem reading picture. Your document will probably become corrupted if you save it!");
        goto L32
    L38:
        this._pictures = r14;
        return;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (r3 != null) goto L64;
    L56:
        throw th;
    L64:
        r3.close();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.addSuppressed(th);
        goto L56
    }

    private void readPowerPointStream() {
        DirectoryNode r0 = getDirectory();
        if (r0.hasEntry("PowerPoint Document") == false) goto L5;
    L9:
        DocumentEntry r1 = (DocumentEntry) ZeusTransformUtils.preCheckCast(r0.getEntry("PowerPoint Document"), DocumentEntry.class, "com.obric.memorydata.plugin");
        int r2 = r1.getSize();
        DocumentInputStream r3 = r0.createDocumentInputStream(r1);
        this._docstream = IOUtils.toByteArray(r3, r2, 100000000);     // Catch: Throwable -> L14
        if (r3 == null) goto L29;
        r3.close();
        return;
    L29:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r3 != null) goto L27;
    L22:
        throw th;
    L27:
        r3.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L5:
        if (r0.hasEntry("PP40") == false) goto L9;
        throw new OldPowerPointFormatException("You seem to have supplied a PowerPoint95 file, which isn't supported");
    }

    void clearDirectoryImpl() {
        super.clearDirectory();
    }

    @Override // org.apache.poi.POIDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (getDirectory().getParent() != null) goto L5;
    L6:
        POIFSFileSystem r2 = getDirectory().getFileSystem();
        if (r2 == null) goto L11;
        r2.close();
        return;
    L11:
        return;
    L5:
        if ("PP97_DUALSTORAGE".equals(getDirectory().getName()) == true) goto L6;
    }

    public DocumentEncryptionAtom getDocumentEncryptionAtom() {
        Record[] r4 = this._records;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Record r2 = r4[r1];
        if (ZeusTransformUtils.instanceOf(r2, DocumentEncryptionAtom.class) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return (DocumentEncryptionAtom) ZeusTransformUtils.preCheckCast(r2, DocumentEncryptionAtom.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public HSLFObjectData[] getEmbeddedObjects() {
        if (this._objects != null) goto L13;
        ArrayList r0 = new ArrayList();
        Record[] r1 = this._records;
        int r2 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L11;
        Record r6 = r1[r4];
        if (ZeusTransformUtils.instanceOf(r6, ExOleObjStg.class) == false) goto L10;
        r0.add(new HSLFObjectData((ExOleObjStg) ZeusTransformUtils.preCheckCast(r6, ExOleObjStg.class, "com.obric.memorydata.plugin")));
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        this._objects = (HSLFObjectData[]) ZeusTransformUtils.preCheckCast(r0.toArray(new HSLFObjectData[0]), HSLFObjectData[].class, "com.obric.memorydata.plugin");
    L13:
        return this._objects;
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        DocumentEncryptionAtom r0 = getDocumentEncryptionAtom();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEncryptionInfo();
    }

    public List<HSLFPictureData> getPictureData() {
        if (this._pictures != null) goto L10;
        readPictures();     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new CorruptPowerPointFileException(e.getMessage());
    L10:
        return Collections.unmodifiableList(this._pictures);
    }

    public Record[] getRecords() {
        return this._records;
    }
}
