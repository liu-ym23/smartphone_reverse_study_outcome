package com.bytedance.android.live.revlink.link.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/UILayoutIOSIndex;", "", "None", "DoublePK", "PKWithGuest", "PKGame", "MultiNormal", "MultiFocus", "MultiFullIncludeScreenV", "MultiFullScreenH", "LinkGameHorizontal", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayoutIOSIndex extends Enum<UILayoutIOSIndex> {
    public static final UILayoutIOSIndex DoublePK = null;
    public static final UILayoutIOSIndex LinkGameHorizontal = null;
    public static final UILayoutIOSIndex MultiFocus = null;
    public static final UILayoutIOSIndex MultiFullIncludeScreenV = null;
    public static final UILayoutIOSIndex MultiFullScreenH = null;
    public static final UILayoutIOSIndex MultiNormal = null;
    public static final UILayoutIOSIndex None = null;
    public static final UILayoutIOSIndex PKGame = null;
    public static final UILayoutIOSIndex PKWithGuest = null;
    public static final /* synthetic */ UILayoutIOSIndex[] a = null;

    static {
        UILayoutIOSIndex r1 = new UILayoutIOSIndex("None", 0);
        None = r1;
        UILayoutIOSIndex r2 = new UILayoutIOSIndex("DoublePK", 1);
        DoublePK = r2;
        UILayoutIOSIndex r3 = new UILayoutIOSIndex("PKWithGuest", 2);
        PKWithGuest = r3;
        UILayoutIOSIndex r4 = new UILayoutIOSIndex("PKGame", 3);
        PKGame = r4;
        UILayoutIOSIndex r5 = new UILayoutIOSIndex("MultiNormal", 4);
        MultiNormal = r5;
        UILayoutIOSIndex r6 = new UILayoutIOSIndex("MultiFocus", 5);
        MultiFocus = r6;
        UILayoutIOSIndex r7 = new UILayoutIOSIndex("MultiFullIncludeScreenV", 6);
        MultiFullIncludeScreenV = r7;
        UILayoutIOSIndex r8 = new UILayoutIOSIndex("MultiFullScreenH", 7);
        MultiFullScreenH = r8;
        UILayoutIOSIndex r9 = new UILayoutIOSIndex("LinkGameHorizontal", 8);
        LinkGameHorizontal = r9;
        a = new UILayoutIOSIndex[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static UILayoutIOSIndex valueOf(String r1) {
        return (UILayoutIOSIndex) a.a(UILayoutIOSIndex.class, r1);
    }

    public static UILayoutIOSIndex[] values() {
        return (UILayoutIOSIndex[]) a.clone();
    }

    public UILayoutIOSIndex(String r1, int r2) {
        super(r1, r2);
    }
}
