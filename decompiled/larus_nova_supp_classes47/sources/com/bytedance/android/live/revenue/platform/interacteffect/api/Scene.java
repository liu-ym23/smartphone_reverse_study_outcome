package com.bytedance.android.live.revenue.platform.interacteffect.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/interacteffect/api/Scene;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "GIFT", "ATMOSPHERE", "UNKNOWN", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Scene extends Enum<Scene> {
    public static final Scene ATMOSPHERE = null;
    public static final a Companion = null;
    public static final Scene GIFT = null;
    public static final Scene UNKNOWN = null;
    public static final /* synthetic */ Scene[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.revenue.platform.interacteffect.api.Scene$a] */
    static {
        Scene r1 = new Scene("GIFT", 0, 100);
        GIFT = r1;
        Scene r2 = new Scene("ATMOSPHERE", 1, 101);
        ATMOSPHERE = r2;
        Scene r3 = new Scene("UNKNOWN", 2, -1);
        UNKNOWN = r3;
        a = new Scene[]{r1, r2, r3};
        Companion = new a();
    }

    public static Scene valueOf(String r1) {
        return (Scene) r27.a.a(Scene.class, r1);
    }

    public static Scene[] values() {
        return (Scene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Scene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
