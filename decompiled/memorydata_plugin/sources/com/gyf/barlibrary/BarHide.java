package com.gyf.barlibrary;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum BarHide extends Enum<BarHide> {
    private static final /* synthetic */ BarHide[] $VALUES = null;
    public static final BarHide FLAG_HIDE_BAR = null;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR = null;
    public static final BarHide FLAG_HIDE_STATUS_BAR = null;
    public static final BarHide FLAG_SHOW_BAR = null;

    static {
        BarHide r0 = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_STATUS_BAR = r0;
        BarHide r1 = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_NAVIGATION_BAR = r1;
        BarHide r3 = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_HIDE_BAR = r3;
        BarHide r5 = new BarHide("FLAG_SHOW_BAR", 3);
        FLAG_SHOW_BAR = r5;
        $VALUES = new BarHide[]{r0, r1, r3, r5};
    }

    private BarHide(String r1, int r2) {
        super(r1, r2);
    }

    public static BarHide valueOf(String r2) {
        return (BarHide) ZeusTransformUtils.preCheckCast(Enum.valueOf(BarHide.class, r2), BarHide.class, "com.obric.memorydata.plugin");
    }

    public static BarHide[] values() {
        return (BarHide[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BarHide[].class, "com.obric.memorydata.plugin");
    }
}
