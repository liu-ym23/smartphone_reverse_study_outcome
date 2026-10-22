package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.hslf.usermodel.HSLFFontInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class FontCollection extends RecordContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private byte[] _header;
    private final Map<Integer, HSLFFontInfo> fonts;

    static {
    }

    FontCollection(byte[] r5, int r6, int r7) {
        this.fonts = new LinkedHashMap();
        int r0 = r6 + 8;
        this._header = Arrays.copyOfRange(r5, r6, r0);
        this._children = Record.findChildRecords(r5, r0, r7 - 8);
        Record[] r8 = this._children;
        int r9 = r8.length;
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L12;
        Record r1 = r8[r10];
        if (ZeusTransformUtils.instanceOf(r1, FontEntityAtom.class) == false) goto L8;
        HSLFFontInfo r2 = new HSLFFontInfo((FontEntityAtom) ZeusTransformUtils.preCheckCast(r1, FontEntityAtom.class, "com.obric.memorydata.plugin"));
        this.fonts.put(r2.getIndex(), r2);
    L11:
        r10 = r10 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r1, FontEmbeddedData.class) == false) goto L10;
        FontEmbeddedData r3 = (FontEmbeddedData) ZeusTransformUtils.preCheckCast(r1, FontEmbeddedData.class, "com.obric.memorydata.plugin");
        addFont(r3.getFontHeader()).addFacet(r3);
        goto L11
    L10:
        LOG.atWarn().a("FontCollection child wasn't a FontEntityAtom, was {}", r1.getClass().getSimpleName());
        goto L11
    }

    private static Predicate<HSLFFontInfo> findFont(final String r1, final FontCharset r2) {
        return new $$Lambda$FontCollection$LWY9tMfxRxJM0dnlAWjb10owpXI(r1, r2);
    }

    static /* synthetic */ boolean lambda$findFont$0(String r1, FontCharset r2, HSLFFontInfo r3) {
        if (r1.equals(r3.getTypeface()) == false) goto L8;
        if (r2 != null) goto L6;
    L7:
        return true;
    L6:
        if (r2.equals(r3.getCharset()) == true) goto L7;
    L8:
        return false;
    }

    public HSLFFontInfo addFont(FontInfo r3) {
        FontInfo r4 = (FontInfo) ZeusTransformUtils.wrapperContextForParams(r3, FontInfo.class, "com.obric.memorydata.plugin");
        HSLFFontInfo r0 = getFontInfo(r4.getTypeface(), r4.getCharset());
        if (r0 == null) goto L5;
        return r0;
    L5:
        HSLFFontInfo r1 = new HSLFFontInfo(r4);
        r1.setIndex(this.fonts.size());
        this.fonts.put(r1.getIndex(), r1);
        appendChildRecord(r1.createRecord());
        return r1;
    }

    public HSLFFontInfo getFontInfo(String r1, FontCharset r2) {
        return (HSLFFontInfo) ZeusTransformUtils.preCheckCast(this.fonts.values().stream().filter(findFont(r1, r2)).findFirst().orElse(null), HSLFFontInfo.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hslf.record.RecordContainer, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.FontCollection.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], getRecordType(), this._children, r10);
    }
}
