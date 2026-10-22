package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConcatAdapter$Config$StableIdMode extends Enum<ConcatAdapter$Config$StableIdMode> {
    public static final ConcatAdapter$Config$StableIdMode ISOLATED_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode NO_STABLE_IDS = null;
    public static final ConcatAdapter$Config$StableIdMode SHARED_STABLE_IDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConcatAdapter$Config$StableIdMode[] f13719a = null;

    static {
        ConcatAdapter$Config$StableIdMode r5 = new ConcatAdapter$Config$StableIdMode("NO_STABLE_IDS", 0);
        NO_STABLE_IDS = r5;
        ConcatAdapter$Config$StableIdMode r10 = new ConcatAdapter$Config$StableIdMode("ISOLATED_STABLE_IDS", 1);
        ISOLATED_STABLE_IDS = r10;
        ConcatAdapter$Config$StableIdMode r11 = new ConcatAdapter$Config$StableIdMode("SHARED_STABLE_IDS", 2);
        SHARED_STABLE_IDS = r11;
        f13719a = new ConcatAdapter$Config$StableIdMode[]{r5, r10, r11};
    }

    public static ConcatAdapter$Config$StableIdMode valueOf(String r5) {
        return (ConcatAdapter$Config$StableIdMode) Enum.valueOf(ConcatAdapter$Config$StableIdMode.class, r5);
    }

    public static ConcatAdapter$Config$StableIdMode[] values() {
        return (ConcatAdapter$Config$StableIdMode[]) f13719a.clone();
    }
}
