package com.bytedance.android.live.broadcast.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/CategoryScene;", "", "", "value", "I", "getValue", "()I", "VIDEO", "GAME", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CategoryScene extends Enum<CategoryScene> {
    public static final CategoryScene GAME = null;
    public static final CategoryScene VIDEO = null;
    public static final /* synthetic */ CategoryScene[] a = null;
    private final int value;

    static {
        CategoryScene r2 = new CategoryScene("VIDEO", 0, 1);
        VIDEO = r2;
        CategoryScene r3 = new CategoryScene("GAME", 1, 2);
        GAME = r3;
        a = new CategoryScene[]{r2, r3};
    }

    public static CategoryScene valueOf(String r1) {
        return (CategoryScene) r27.a.a(CategoryScene.class, r1);
    }

    public static CategoryScene[] values() {
        return (CategoryScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CategoryScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
