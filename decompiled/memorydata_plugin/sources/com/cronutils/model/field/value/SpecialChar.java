package com.cronutils.model.field.value;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SpecialChar extends Enum<SpecialChar> {
    private static final /* synthetic */ SpecialChar[] $VALUES = null;
    public static final SpecialChar HASH = null;
    public static final SpecialChar L = null;
    public static final SpecialChar LW = null;
    public static final SpecialChar NONE = null;
    public static final SpecialChar QUESTION_MARK = null;
    public static final SpecialChar W = null;

    static {
        SpecialChar r0 = new SpecialChar("LW", 0);
        LW = r0;
        SpecialChar r1 = new SpecialChar(i.u, 1);
        L = r1;
        SpecialChar r3 = new SpecialChar(ExifInterface.LONGITUDE_WEST, 2);
        W = r3;
        SpecialChar r5 = new SpecialChar("HASH", 3);
        HASH = r5;
        SpecialChar r7 = new SpecialChar("QUESTION_MARK", 4);
        QUESTION_MARK = r7;
        SpecialChar r9 = new SpecialChar("NONE", 5);
        NONE = r9;
        $VALUES = new SpecialChar[]{r0, r1, r3, r5, r7, r9};
    }

    private SpecialChar(String r1, int r2) {
        super(r1, r2);
    }

    public static SpecialChar valueOf(String r2) {
        return (SpecialChar) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpecialChar.class, r2), SpecialChar.class, "com.obric.memorydata.plugin");
    }

    public static SpecialChar[] values() {
        return (SpecialChar[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpecialChar[].class, "com.obric.memorydata.plugin");
    }
}
