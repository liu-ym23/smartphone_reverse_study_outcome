package com.bytedance.android.live.profile.ui.util;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profile/ui/util/DressType;", "", "PanelBgPng", "PanelEnterWebp", "PanelLoopWebp", "Border9Png", "BorderEnterWebp", "BorderLoopWebp", "BorderPng", "PanelRightBgPng", "PanelExitWebp", "MainButton9Png", "MainButtonWebp", "ParallaxAsset", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DressType extends Enum<DressType> {
    public static final DressType Border9Png = null;
    public static final DressType BorderEnterWebp = null;
    public static final DressType BorderLoopWebp = null;
    public static final DressType BorderPng = null;
    public static final DressType MainButton9Png = null;
    public static final DressType MainButtonWebp = null;
    public static final DressType PanelBgPng = null;
    public static final DressType PanelEnterWebp = null;
    public static final DressType PanelExitWebp = null;
    public static final DressType PanelLoopWebp = null;

    @Deprecated(message = "此装扮坑位和代码已删除")
    public static final DressType PanelRightBgPng = null;
    public static final DressType ParallaxAsset = null;
    public static final /* synthetic */ DressType[] a = null;

    static {
        DressType r1 = new DressType("PanelBgPng", 0);
        PanelBgPng = r1;
        DressType r2 = new DressType("PanelEnterWebp", 1);
        PanelEnterWebp = r2;
        DressType r3 = new DressType("PanelLoopWebp", 2);
        PanelLoopWebp = r3;
        DressType r4 = new DressType("Border9Png", 3);
        Border9Png = r4;
        DressType r5 = new DressType("BorderEnterWebp", 4);
        BorderEnterWebp = r5;
        DressType r6 = new DressType("BorderLoopWebp", 5);
        BorderLoopWebp = r6;
        DressType r7 = new DressType("BorderPng", 6);
        BorderPng = r7;
        DressType r8 = new DressType("PanelRightBgPng", 7);
        PanelRightBgPng = r8;
        DressType r9 = new DressType("PanelExitWebp", 8);
        PanelExitWebp = r9;
        DressType r10 = new DressType("MainButton9Png", 9);
        MainButton9Png = r10;
        DressType r12 = new DressType("MainButtonWebp", 10);
        MainButtonWebp = r12;
        DressType r13 = new DressType("ParallaxAsset", 11);
        ParallaxAsset = r13;
        a = new DressType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13};
    }

    public static DressType valueOf(String r1) {
        return (DressType) r27.a.a(DressType.class, r1);
    }

    public static DressType[] values() {
        return (DressType[]) a.clone();
    }

    public DressType(String r1, int r2) {
        super(r1, r2);
    }
}
