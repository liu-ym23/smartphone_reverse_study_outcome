package com.bytedance.android.live.recharge.nopassword;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/nopassword/NoPasswordScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SCENE_UNKNOWN", "SCENE_PK", "SCENE_FANS_CLUB_JOIN", "SCENE_FANS_CLUB_SEND_GIFT", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordScene extends Enum<NoPasswordScene> {
    public static final NoPasswordScene SCENE_FANS_CLUB_JOIN = null;
    public static final NoPasswordScene SCENE_FANS_CLUB_SEND_GIFT = null;
    public static final NoPasswordScene SCENE_PK = null;
    public static final NoPasswordScene SCENE_UNKNOWN = null;
    public static final /* synthetic */ NoPasswordScene[] a = null;
    private final String value;

    static {
        NoPasswordScene r1 = new NoPasswordScene("SCENE_UNKNOWN", 0, "unknown");
        SCENE_UNKNOWN = r1;
        NoPasswordScene r2 = new NoPasswordScene("SCENE_PK", 1, "pk");
        SCENE_PK = r2;
        NoPasswordScene r3 = new NoPasswordScene("SCENE_FANS_CLUB_JOIN", 2, "fansclub");
        SCENE_FANS_CLUB_JOIN = r3;
        NoPasswordScene r4 = new NoPasswordScene("SCENE_FANS_CLUB_SEND_GIFT", 3, "fansclub_send_gift");
        SCENE_FANS_CLUB_SEND_GIFT = r4;
        a = new NoPasswordScene[]{r1, r2, r3, r4};
    }

    public static NoPasswordScene valueOf(String r1) {
        return (NoPasswordScene) r27.a.a(NoPasswordScene.class, r1);
    }

    public static NoPasswordScene[] values() {
        return (NoPasswordScene[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public NoPasswordScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
