package com.bytedance.android.live.browser.jsbridge.newmethods;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/LoadingType;", "", "", "type", "I", "getType", "()I", "PRE_LOADING", "PLAY_LOADING", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadingType extends Enum<LoadingType> {
    public static final LoadingType PLAY_LOADING = null;
    public static final LoadingType PRE_LOADING = null;
    public static final /* synthetic */ LoadingType[] a = null;
    private final int type;

    static {
        LoadingType r1 = new LoadingType("PRE_LOADING", 0, 0);
        PRE_LOADING = r1;
        LoadingType r2 = new LoadingType("PLAY_LOADING", 1, 1);
        PLAY_LOADING = r2;
        a = new LoadingType[]{r1, r2};
    }

    public static LoadingType valueOf(String r1) {
        return (LoadingType) r27.a.a(LoadingType.class, r1);
    }

    public static LoadingType[] values() {
        return (LoadingType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LoadingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
