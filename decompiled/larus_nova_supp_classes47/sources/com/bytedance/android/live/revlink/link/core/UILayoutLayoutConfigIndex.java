package com.bytedance.android.live.revlink.link.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/UILayoutLayoutConfigIndex;", "", "", "layoutKey", "I", "getLayoutKey", "()I", "Normal", "Focus", "Full", "FullRecord", "FullRecordNormal", "PK", "PKWithAudience", "PKGame", "PKGameFull", "LinkGameHorizontal", "LinkGameLandscape", "MediaNormal", "MediaFocus", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayoutLayoutConfigIndex extends Enum<UILayoutLayoutConfigIndex> {
    public static final UILayoutLayoutConfigIndex Focus = null;
    public static final UILayoutLayoutConfigIndex Full = null;
    public static final UILayoutLayoutConfigIndex FullRecord = null;
    public static final UILayoutLayoutConfigIndex FullRecordNormal = null;
    public static final UILayoutLayoutConfigIndex LinkGameHorizontal = null;
    public static final UILayoutLayoutConfigIndex LinkGameLandscape = null;
    public static final UILayoutLayoutConfigIndex MediaFocus = null;
    public static final UILayoutLayoutConfigIndex MediaNormal = null;
    public static final UILayoutLayoutConfigIndex Normal = null;
    public static final UILayoutLayoutConfigIndex PK = null;
    public static final UILayoutLayoutConfigIndex PKGame = null;
    public static final UILayoutLayoutConfigIndex PKGameFull = null;
    public static final UILayoutLayoutConfigIndex PKWithAudience = null;
    public static final /* synthetic */ UILayoutLayoutConfigIndex[] a = null;
    private final int layoutKey;

    public static UILayoutLayoutConfigIndex valueOf(String r1) {
        return (UILayoutLayoutConfigIndex) a.a(UILayoutLayoutConfigIndex.class, r1);
    }

    public static UILayoutLayoutConfigIndex[] values() {
        return (UILayoutLayoutConfigIndex[]) a.clone();
    }

    static {
        UILayoutLayoutConfigIndex r1 = new UILayoutLayoutConfigIndex("Normal", 0, 0);
        Normal = r1;
        UILayoutLayoutConfigIndex r2 = new UILayoutLayoutConfigIndex("Focus", 1, 1);
        Focus = r2;
        UILayoutLayoutConfigIndex r3 = new UILayoutLayoutConfigIndex("Full", 2, 2);
        Full = r3;
        UILayoutLayoutConfigIndex r4 = new UILayoutLayoutConfigIndex("FullRecord", 3, 3);
        FullRecord = r4;
        UILayoutLayoutConfigIndex r5 = new UILayoutLayoutConfigIndex("FullRecordNormal", 4, 4);
        FullRecordNormal = r5;
        UILayoutLayoutConfigIndex r6 = new UILayoutLayoutConfigIndex("PK", 5, 5);
        PK = r6;
        UILayoutLayoutConfigIndex r7 = new UILayoutLayoutConfigIndex("PKWithAudience", 6, 6);
        PKWithAudience = r7;
        UILayoutLayoutConfigIndex r8 = new UILayoutLayoutConfigIndex("PKGame", 7, 7);
        PKGame = r8;
        UILayoutLayoutConfigIndex r9 = new UILayoutLayoutConfigIndex("PKGameFull", 8, 8);
        PKGameFull = r9;
        UILayoutLayoutConfigIndex r10 = new UILayoutLayoutConfigIndex("LinkGameHorizontal", 9, 9);
        LinkGameHorizontal = r10;
        UILayoutLayoutConfigIndex r12 = new UILayoutLayoutConfigIndex("LinkGameLandscape", 10, 10);
        LinkGameLandscape = r12;
        UILayoutLayoutConfigIndex r13 = new UILayoutLayoutConfigIndex("MediaNormal", 11, 10000);
        MediaNormal = r13;
        UILayoutLayoutConfigIndex r14 = new UILayoutLayoutConfigIndex("MediaFocus", 12, 10001);
        MediaFocus = r14;
        a = new UILayoutLayoutConfigIndex[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14};
    }

    public final int getLayoutKey() {
        return this.layoutKey;
    }

    public UILayoutLayoutConfigIndex(String r1, int r2, int r3) {
        super(r1, r2);
        this.layoutKey = r3;
    }
}
