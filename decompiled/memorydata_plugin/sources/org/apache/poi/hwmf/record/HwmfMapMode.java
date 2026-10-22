package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfMapMode extends Enum<HwmfMapMode> {
    private static final /* synthetic */ HwmfMapMode[] $VALUES = null;
    public static final HwmfMapMode MM_ANISOTROPIC = null;
    public static final HwmfMapMode MM_HIENGLISH = null;
    public static final HwmfMapMode MM_HIMETRIC = null;
    public static final HwmfMapMode MM_ISOTROPIC = null;
    public static final HwmfMapMode MM_LOENGLISH = null;
    public static final HwmfMapMode MM_LOMETRIC = null;
    public static final HwmfMapMode MM_TEXT = null;
    public static final HwmfMapMode MM_TWIPS = null;
    public final int flag;
    public final int scale;

    static {
        HwmfMapMode r0 = new HwmfMapMode("MM_TEXT", 0, 1, 0);
        MM_TEXT = r0;
        HwmfMapMode r1 = new HwmfMapMode("MM_LOMETRIC", 1, 2, 254);
        MM_LOMETRIC = r1;
        HwmfMapMode r4 = new HwmfMapMode("MM_HIMETRIC", 2, 3, 2540);
        MM_HIMETRIC = r4;
        HwmfMapMode r6 = new HwmfMapMode("MM_LOENGLISH", 3, 4, 100);
        MM_LOENGLISH = r6;
        HwmfMapMode r8 = new HwmfMapMode("MM_HIENGLISH", 4, 5, 1000);
        MM_HIENGLISH = r8;
        HwmfMapMode r10 = new HwmfMapMode("MM_TWIPS", 5, 6, 1440);
        MM_TWIPS = r10;
        HwmfMapMode r12 = new HwmfMapMode("MM_ISOTROPIC", 6, 7, -1);
        MM_ISOTROPIC = r12;
        HwmfMapMode r14 = new HwmfMapMode("MM_ANISOTROPIC", 7, 8, -1);
        MM_ANISOTROPIC = r14;
        $VALUES = new HwmfMapMode[]{r0, r1, r4, r6, r8, r10, r12, r14};
    }

    private HwmfMapMode(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.flag = r3;
        this.scale = r4;
    }

    public static HwmfMapMode valueOf(int r5) {
        HwmfMapMode[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        HwmfMapMode r3 = r0[r2];
        if (r3.flag == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return MM_ISOTROPIC;
    }

    public static HwmfMapMode valueOf(String r2) {
        return (HwmfMapMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfMapMode.class, r2), HwmfMapMode.class, "com.obric.memorydata.plugin");
    }

    public static HwmfMapMode[] values() {
        return (HwmfMapMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfMapMode[].class, "com.obric.memorydata.plugin");
    }
}
