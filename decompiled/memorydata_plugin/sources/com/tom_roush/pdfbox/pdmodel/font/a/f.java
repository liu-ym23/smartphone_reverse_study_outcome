package com.tom_roush.pdfbox.pdmodel.font.a;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f extends g {
    public static final f c = null;
    private static final Object[][] e = null;

    static {
        e = new Object[][]{new Object[]{255, "notequal"}, new Object[]{260, "infinity"}, new Object[]{262, "lessequal"}, new Object[]{263, "greaterequal"}, new Object[]{266, "partialdiff"}, new Object[]{267, "summation"}, new Object[]{Integer.valueOf(SubsamplingScaleImageView.ORIENTATION_270), "product"}, new Object[]{271, "pi"}, new Object[]{272, "integral"}, new Object[]{275, "Omega"}, new Object[]{303, "radical"}, new Object[]{305, "approxequal"}, new Object[]{306, "Delta"}, new Object[]{327, "lozenge"}, new Object[]{333, "Euro"}, new Object[]{360, "apple"}};
        c = new f();
    }

    public f() {
        Object[][] r0 = e;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        Object[] r4 = r0[r3];
        a(((Integer) ZeusTransformUtils.preCheckCast(r4[0], Integer.class, "com.obric.memorydata.plugin")).intValue(), r4[1].toString());
        r3 = r3 + 1;
        goto L3
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.a.g, com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return null;
    }
}
