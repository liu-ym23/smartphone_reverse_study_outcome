package com.bytedance.android.live.broadcastgame.api.channel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/channel/DelayType;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "NO_DELAY", "DELAY_FLOW_STREAM", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DelayType extends Enum<DelayType> {
    public static final a Companion = null;
    public static final DelayType DELAY_FLOW_STREAM = null;
    public static final DelayType NO_DELAY = null;
    public static final /* synthetic */ DelayType[] a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.broadcastgame.api.channel.DelayType$a] */
    static {
        DelayType r1 = new DelayType("NO_DELAY", 0, 0);
        NO_DELAY = r1;
        DelayType r2 = new DelayType("DELAY_FLOW_STREAM", 1, 1);
        DELAY_FLOW_STREAM = r2;
        a = new DelayType[]{r1, r2};
        Companion = new a();
    }

    public static DelayType valueOf(String r1) {
        return (DelayType) r27.a.a(DelayType.class, r1);
    }

    public static DelayType[] values() {
        return (DelayType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DelayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
