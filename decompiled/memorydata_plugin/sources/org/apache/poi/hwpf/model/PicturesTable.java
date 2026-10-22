package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PicturesTable {
    private static final c LOG = null;
    private final byte[] _dataStream;

    @Deprecated
    private OfficeArtContent _dgg;
    private final HWPFDocument _document;

    @Deprecated
    private FSPATable _fspa;
    private final byte[] _mainStream;

    static {
        LOG = b.a(PicturesTable.class);
    }

    @Deprecated
    public PicturesTable(HWPFDocument r1, byte[] r2, byte[] r3, FSPATable r4, OfficeArtContent r5) {
        this._document = r1;
        this._dataStream = r2;
        this._mainStream = r3;
        this._fspa = r4;
        this._dgg = r5;
    }

    private static short getBlockType(byte[] r0, int r1) {
        return LittleEndian.getShort(r0, r1 + 14);
    }

    private static short getMmMode(byte[] r0, int r1) {
        return LittleEndian.getShort(r0, r1 + 6);
    }

    private boolean isBlockContainsImage(int r3) {
        return isPictureRecognized(getBlockType(this._dataStream, r3), getMmMode(this._dataStream, r3));
    }

    private boolean isPictureRecognized(short r2, short r3) {
        if (r2 != 8) goto L5;
    L14:
        return true;
    L5:
        if (r2 == 10) goto L14;
        if (r2 != 0) goto L10;
        if (r3 == 100) goto L14;
    L10:
        if (r2 != 2) goto L13;
        if (r3 == 100) goto L14;
    L13:
        return false;
    }

    private void searchForPictures(List<EscherRecord> r7, List<Picture> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        EscherRecord r0 = (EscherRecord) ZeusTransformUtils.preCheckCast(r11.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, EscherBSERecord.class) == false) goto L4;
        EscherBSERecord r1 = (EscherBSERecord) ZeusTransformUtils.preCheckCast(r0, EscherBSERecord.class, "com.obric.memorydata.plugin");
        EscherBlipRecord r2 = r1.getBlipRecord();
        if (r2 != null) goto L9;
        if (r1.getOffset() <= 0) goto L4;
        EscherRecordFactory r3 = new DefaultEscherRecordFactory();     // Catch: Exception -> L16
        EscherRecord r4 = r3.createRecord(this._mainStream, r1.getOffset());     // Catch: Exception -> L16
        if (ZeusTransformUtils.instanceOf(r4, EscherBlipRecord.class) == false) goto L4;
        r4.fillFields(this._mainStream, r1.getOffset(), r3);     // Catch: Exception -> L16
        r10.add(new Picture((EscherBlipRecord) ZeusTransformUtils.preCheckCast(r4, EscherBlipRecord.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        LOG.atWarn().a(e).a("Unable to load picture from BLIP record at offset #{}", v.a(r1.getOffset()));
        goto L4
    L9:
        r10.add(new Picture(r2));
        goto L4
    }

    public Picture extractPicture(CharacterRun r2, boolean r3) {
        if (hasPicture(r2) == true) goto L5;
        return null;
    L5:
        return new Picture(r2.getPicOffset(), this._dataStream, r3);
    }

    public List<Picture> getAllPictures() {
        ArrayList r0 = new ArrayList();
        Range r1 = this._document.getOverallRange();
        int r3 = 0;
    L4:
        if (r3 >= r1.numCharacterRuns()) goto L12;
        CharacterRun r4 = r1.getCharacterRun(r3);
        if (r4 == null) goto L11;
        Picture r5 = extractPicture(r4, false);
        if (r5 == null) goto L11;
        r0.add(r5);
    L11:
        r3 = r3 + 1;
        goto L4
    L12:
        EscherContainerRecord r2 = this._dgg.getBStoreContainer();
        if (r2 == null) goto L15;
        searchForPictures(r2.getChildRecords(), r0);
    L15:
        return r0;
    }

    public boolean hasPicture(CharacterRun r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.isSpecialCharacter() == true) goto L8;
    L19:
        return false;
    L8:
        if (r4.isObj() == true) goto L19;
        if (r4.isOle2() == true) goto L19;
        if (r4.isData() == true) goto L19;
        if ("\u0001".equals(r4.text()) == true) goto L18;
        if ("\u0001\u0015".equals(r4.text()) == false) goto L19;
    L18:
        return isBlockContainsImage(r4.getPicOffset());
    }
}
