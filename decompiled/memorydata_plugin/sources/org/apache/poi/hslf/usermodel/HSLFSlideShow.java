package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.POIDocument;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.exceptions.CorruptPowerPointFileException;
import org.apache.poi.hslf.record.Document;
import org.apache.poi.hslf.record.FontCollection;
import org.apache.poi.hslf.record.MainMaster;
import org.apache.poi.hslf.record.Notes;
import org.apache.poi.hslf.record.PersistPtrHolder;
import org.apache.poi.hslf.record.PositionDependentRecord;
import org.apache.poi.hslf.record.PositionDependentRecordContainer;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.hslf.record.RecordContainer;
import org.apache.poi.hslf.record.RecordTypes;
import org.apache.poi.hslf.record.Slide;
import org.apache.poi.hslf.record.SlideListWithText;
import org.apache.poi.hslf.record.SlidePersistAtom;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFSlideShow extends POIDocument implements Closeable, GenericRecord, SlideShow<HSLFShape, HSLFTextParagraph> {
    private static final c LOG = null;
    private static int MAX_RECORD_LENGTH;
    private static final ThreadLocal<LoadSavePhase> loadSavePhase = null;
    private Document _documentRecord;
    private FontCollection _fonts;
    private final HSLFSlideShowImpl _hslfSlideShow;
    private final List<HSLFSlideMaster> _masters;
    private Record[] _mostRecentCoreRecords;
    private final List<HSLFNotes> _notes;
    private Map<Integer, Integer> _sheetIdToCoreRecordsLookup;
    private final List<HSLFSlide> _slides;
    private final List<HSLFTitleMaster> _titleMasters;

    static final enum LoadSavePhase extends Enum<LoadSavePhase> {
        private static final /* synthetic */ LoadSavePhase[] $VALUES = null;
        public static final LoadSavePhase INIT = null;
        public static final LoadSavePhase LOADED = null;

        static {
            LoadSavePhase r0 = new LoadSavePhase("INIT", 0);
            INIT = r0;
            LoadSavePhase r1 = new LoadSavePhase("LOADED", 1);
            LOADED = r1;
            $VALUES = new LoadSavePhase[]{r0, r1};
        }

        private LoadSavePhase(String r1, int r2) {
            super(r1, r2);
        }

        public static LoadSavePhase valueOf(String r2) {
            return (LoadSavePhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(LoadSavePhase.class, r2), LoadSavePhase.class, "com.obric.memorydata.plugin");
        }

        public static LoadSavePhase[] values() {
            return (LoadSavePhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LoadSavePhase[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(HSLFSlideShow.class);
        MAX_RECORD_LENGTH = PoissonDistribution.DEFAULT_MAX_ITERATIONS;
        loadSavePhase = new ThreadLocal();
    }

    public HSLFSlideShow() {
        this(HSLFSlideShowImpl.create());
    }

    public HSLFSlideShow(InputStream r2) {
        this(new HSLFSlideShowImpl(r2));
    }

    public HSLFSlideShow(HSLFSlideShowImpl r6) {
        super(r6.getDirectory());
        this._masters = new ArrayList();
        this._titleMasters = new ArrayList();
        this._slides = new ArrayList();
        this._notes = new ArrayList();
        loadSavePhase.set(LoadSavePhase.INIT);
        this._hslfSlideShow = r6;
        Record[] r7 = r6.getRecords();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Record r2 = r7[r1];
        if (ZeusTransformUtils.instanceOf(r2, RecordContainer.class) == false) goto L7;
        RecordContainer.handleParentAwareRecords((RecordContainer) ZeusTransformUtils.preCheckCast(r2, RecordContainer.class, "com.obric.memorydata.plugin"));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        findMostRecentCoreRecords();
        buildSlidesAndNotes();
        loadSavePhase.set(LoadSavePhase.LOADED);
    }

    static EscherBSERecord addNewEscherBseRecord(EscherContainerRecord r2, PictureData.PictureType r3, byte[] r4, int r5) {
        EscherBSERecord r0 = new EscherBSERecord();
        r0.setRecordId(EscherBSERecord.RECORD_ID);
        r0.setOptions((short) ((r3.nativeId << 4) | 2));
        r0.setSize(r4.length + 8);
        r0.setUid(Arrays.copyOf(r4, 16));
        r0.setBlipTypeMacOS((byte) r3.nativeId);
        r0.setBlipTypeWin32((byte) r3.nativeId);
        if (r3 != PictureData.PictureType.EMF) goto L6;
    L4:
        r0.setBlipTypeMacOS((byte) PictureData.PictureType.PICT.nativeId);
    L11:
        r0.setOffset(r5);
        r2.addChildRecord(r0);
        r2.setOptions((short) ((r2.getChildCount() << 4) | 15));
        return r0;
    L6:
        if (r3 == PictureData.PictureType.WMF) goto L4;
        if (r3 != PictureData.PictureType.PICT) goto L11;
        r0.setBlipTypeWin32((byte) PictureData.PictureType.WMF.nativeId);
        goto L11
    }

    private void buildSlidesAndNotes() {
        if (this._documentRecord == null) goto L7;
        findMasterSlides();
        HashMap r0 = new HashMap();
        findNotesSlides(r0);
        findSlides(r0);
        return;
    L7:
        throw new CorruptPowerPointFileException("The PowerPoint file didn't contain a Document Record in its PersistPtr blocks. It is probably corrupt.");
    }

    private void findMasterSlides() {
        SlideListWithText r0 = this._documentRecord.getMasterSlideListWithText();
        if (r0 != null) goto L5;
        return;
    L5:
        SlideListWithText.SlideAtomsSet[] r1 = r0.getSlideAtomsSets();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L15;
        SlideListWithText.SlideAtomsSet r4 = r1[r3];
        Record r5 = getCoreRecordForSAS(r4);
        int r6 = r4.getSlidePersistAtom().getSlideIdentifier();
        if (ZeusTransformUtils.instanceOf(r5, Slide.class) == false) goto L12;
        HSLFSheet r7 = new HSLFTitleMaster((Slide) ZeusTransformUtils.preCheckCast(r5, Slide.class, "com.obric.memorydata.plugin"), r6);
        r7.setSlideShow(this);
        List r8 = this._titleMasters;
    L10:
        r8.add(r7);
    L14:
        r3 = r3 + 1;
        goto L6
    L12:
        if (ZeusTransformUtils.instanceOf(r5, MainMaster.class) == false) goto L14;
        r7 = new HSLFSlideMaster((MainMaster) ZeusTransformUtils.preCheckCast(r5, MainMaster.class, "com.obric.memorydata.plugin"), r6);
        r7.setSlideShow(this);
        r8 = this._masters;
        goto L10
    }

    private void findMostRecentCoreRecords() {
        HashMap r0 = new HashMap();
        Record[] r1 = this._hslfSlideShow.getRecords();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L14;
        Record r6 = r1[r4];
        if (ZeusTransformUtils.instanceOf(r6, PersistPtrHolder.class) == false) goto L13;
        PersistPtrHolder r5 = (PersistPtrHolder) ZeusTransformUtils.preCheckCast(r6, PersistPtrHolder.class, "com.obric.memorydata.plugin");
        int[] r7 = r5.getKnownSlideIDs();
        int r8 = r7.length;
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L10;
        r0.remove(Integer.valueOf(r7[r9]));
        r9 = r9 + 1;
        goto L8
    L10:
        Map<Integer, Integer> r10 = r5.getSlideLocationsLookup();
        int r11 = r7.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L13;
        int r13 = r7[r12];
        r0.put(Integer.valueOf(r13), r10.get(Integer.valueOf(r13)));
        r12 = r12 + 1;
    L13:
        r4 = r4 + 1;
        goto L4
    L14:
        this._mostRecentCoreRecords = new Record[r0.size()];
        this._sheetIdToCoreRecordsLookup = new HashMap();
        Integer[] r14 = (Integer[]) ZeusTransformUtils.preCheckCast(r0.keySet().toArray(new Integer[0]), Integer[].class, "com.obric.memorydata.plugin");
        Arrays.sort(r14);
        int r15 = 0;
    L16:
        if (r15 >= r14.length) goto L18;
        this._sheetIdToCoreRecordsLookup.put(r14[r15], Integer.valueOf(r15));
        r15 = r15 + 1;
        goto L16
    L18:
        HashMap r16 = new HashMap(r0.size());
        Iterator r17 = r0.entrySet().iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r16.put(r18.getValue(), r18.getKey());
        goto L20
    L22:
        Record[] r19 = this._hslfSlideShow.getRecords();
        int r20 = r19.length;
        int r21 = 0;
    L23:
        if (r21 >= r20) goto L35;
        Record r22 = r19[r21];
        if (ZeusTransformUtils.instanceOf(r22, PositionDependentRecord.class) == false) goto L34;
        PositionDependentRecord r23 = (PositionDependentRecord) ZeusTransformUtils.preCheckCast(r22, PositionDependentRecord.class, "com.obric.memorydata.plugin");
        Integer r24 = (Integer) ZeusTransformUtils.preCheckCast(r16.get(Integer.valueOf(r23.getLastOnDiskOffset())), Integer.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L34;
        int r25 = ((Integer) ZeusTransformUtils.preCheckCast(this._sheetIdToCoreRecordsLookup.get(r24), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (ZeusTransformUtils.instanceOf(r23, PositionDependentRecordContainer.class) == false) goto L33;
        ((PositionDependentRecordContainer) ZeusTransformUtils.preCheckCast(r22, PositionDependentRecordContainer.class, "com.obric.memorydata.plugin")).setSheetId(r24.intValue());
    L33:
        this._mostRecentCoreRecords[r25] = r22;
    L34:
        r21 = r21 + 1;
        goto L23
    L35:
        Record[] r26 = this._mostRecentCoreRecords;
        int r27 = r26.length;
    L36:
        if (r3 >= r27) goto L45;
        Record r28 = r26[r3];
        if (r28 == null) goto L44;
        if (r28.getRecordType() != RecordTypes.Document.typeID) goto L44;
        Document r29 = (Document) ZeusTransformUtils.preCheckCast(r28, Document.class, "com.obric.memorydata.plugin");
        this._documentRecord = r29;
        if (r29.getEnvironment() == null) goto L44;
        this._fonts = this._documentRecord.getEnvironment().getFontCollection();
    L44:
        r3 = r3 + 1;
        goto L36
    }

    private void findNotesSlides(Map<Integer, Integer> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        SlideListWithText r0 = this._documentRecord.getNotesSlideListWithText();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = -1;
        SlideListWithText.SlideAtomsSet[] r1 = r0.getSlideAtomsSets();
        int r3 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L19;
        SlideListWithText.SlideAtomsSet r5 = r1[r4];
        r2 = r2 + 1;
        Record r6 = getCoreRecordForSAS(r5);
        SlidePersistAtom r7 = r5.getSlidePersistAtom();
        String r8 = "A Notes SlideAtomSet at " + r2 + " said its record was at refID " + r7.getRefID();
        if (r6 != null) goto L11;
        LOG.atWarn().a("{}, but that record didn't exist - record ignored.", r8);
    L16:
        r4 = r4 + 1;
        goto L6
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Notes.class) == true) goto L13;
        LOG.atError().a("{}, but that was actually a {}", r8, r6);
        goto L16
    L13:
        Notes r9 = (Notes) ZeusTransformUtils.preCheckCast(r6, Notes.class, "com.obric.memorydata.plugin");
        r11.put(Integer.valueOf(r7.getSlideIdentifier()), Integer.valueOf(r2));
        if (r9.getNotesAtom() == null) goto L18;
        HSLFNotes r12 = new HSLFNotes(r9);
        r12.setSlideShow(this);
        this._notes.add(r12);
        goto L16
    L18:
        throw new IllegalStateException("Could not read NotesAtom from the NotesRecord for " + r2);
    }

    private void findSlides(Map<Integer, Integer> r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        SlideListWithText r0 = this._documentRecord.getSlideSlideListWithText();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = -1;
        SlideListWithText.SlideAtomsSet[] r1 = r0.getSlideAtomsSets();
        int r3 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L25;
        SlideListWithText.SlideAtomsSet r8 = r1[r4];
        r2 = r2 + 1;
        SlidePersistAtom r5 = r8.getSlidePersistAtom();
        Record r6 = getCoreRecordForSAS(r8);
        if (ZeusTransformUtils.instanceOf(r6, Slide.class) == true) goto L10;
        LOG.atError().a("A Slide SlideAtomSet at {} said its record was at refID {}, but that was actually a {}", v.a(r2), v.a(r5.getRefID()), r6);
    L24:
        r4 = r4 + 1;
        goto L6
    L10:
        Slide r7 = (Slide) ZeusTransformUtils.preCheckCast(r6, Slide.class, "com.obric.memorydata.plugin");
        if (r7.getSlideAtom() != null) goto L13;
        LOG.atError().a("SlideAtomSet at {} at refID {} is null", v.a(r2), v.a(r5.getRefID()));
        goto L24
    L13:
        HSLFNotes r9 = null;
        int r10 = r7.getSlideAtom().getNotesID();
        if (r10 == 0) goto L23;
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r15.get(Integer.valueOf(r10)), Integer.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L18;
    L22:
        LOG.atError().a("Notes not found for noteId={}", v.a(r10));
        goto L23
    L18:
        if (r11.intValue() < 0) goto L22;
        if (r11.intValue() >= this._notes.size()) goto L22;
        r9 = (HSLFNotes) ZeusTransformUtils.preCheckCast(this._notes.get(r11.intValue()), HSLFNotes.class, "com.obric.memorydata.plugin");
    L23:
        HSLFSlide r12 = new HSLFSlide(r7, r9, r8, r5.getSlideIdentifier(), r2 + 1);
        r12.setSlideShow(this);
        this._slides.add(r12);
        goto L24
    }

    static LoadSavePhase getLoadSavePhase() {
        return (LoadSavePhase) ZeusTransformUtils.preCheckCast(loadSavePhase.get(), LoadSavePhase.class, "com.obric.memorydata.plugin");
    }

    public HSLFFontInfo addFont(FontInfo r3) {
        FontInfo r4 = (FontInfo) ZeusTransformUtils.wrapperContextForParams(r3, FontInfo.class, "com.obric.memorydata.plugin");
        return getDocumentRecord().getEnvironment().getFontCollection().addFont(r4);
    }

    @Override // org.apache.poi.POIDocument
    public void clearDirectory() {
        getSlideShowImpl().clearDirectoryImpl();
    }

    @Override // org.apache.poi.POIDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._hslfSlideShow.close();
    }

    public Record getCoreRecordForRefID(int r4) {
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this._sheetIdToCoreRecordsLookup.get(Integer.valueOf(r4)), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        LOG.atError().a("We tried to look up a reference to a core record, but there was no core ID for reference ID {}", v.a(r4));
        return null;
    L5:
        return this._mostRecentCoreRecords[r0.intValue()];
    }

    public Record getCoreRecordForSAS(SlideListWithText.SlideAtomsSet r1) {
        return getCoreRecordForRefID(r1.getSlidePersistAtom().getRefID());
    }

    @Override // org.apache.poi.POIDocument
    public DirectoryNode getDirectory() {
        return getSlideShowImpl().getDirectory();
    }

    public Document getDocumentRecord() {
        return this._documentRecord;
    }

    public HSLFObjectData[] getEmbeddedObjects() {
        return this._hslfSlideShow.getEmbeddedObjects();
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        return getSlideShowImpl().getEncryptionInfo();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return Arrays.asList(this._hslfSlideShow.getRecords());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("pictures", new $$Lambda$PXfVQuHyIW4EuNSJ8ZQ_lXZ0_ss(this), "embeddedObjects", new $$Lambda$KUoKRNUfiAx3o8bog_KwUBxLhWQ(this));
    }

    public List<HSLFPictureData> getPictureData() {
        return this._hslfSlideShow.getPictureData();
    }

    public List<HSLFSlideMaster> getSlideMasters() {
        return this._masters;
    }

    public HSLFSlideShowImpl getSlideShowImpl() {
        return this._hslfSlideShow;
    }

    @Override // org.apache.poi.sl.usermodel.SlideShow
    public List<HSLFSlide> getSlides() {
        return this._slides;
    }
}
