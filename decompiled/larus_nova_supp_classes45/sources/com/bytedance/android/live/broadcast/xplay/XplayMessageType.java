package com.bytedance.android.live.broadcast.xplay;

import b10.b;
import b10.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/xplay/XplayMessageType;", "", "", "messageKey", "Ljava/lang/String;", "getMessageKey", "()Ljava/lang/String;", "Ljava/lang/Class;", "La10/a;", "messageType", "Ljava/lang/Class;", "getMessageType", "()Ljava/lang/Class;", "Companion", "a", "UNKNOWN", "CO_HOST_GAME_STATUS", "CO_HOST_GAME_QUIT", "CO_HOST_CHANGE_SCREEN", "XPLAY_SWITCH_GUIDE_PLAYER", "XPLAY_INTERACT_CUSTOM", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum XplayMessageType extends Enum<XplayMessageType> {
    public static final XplayMessageType CO_HOST_CHANGE_SCREEN = null;
    public static final XplayMessageType CO_HOST_GAME_QUIT = null;
    public static final XplayMessageType CO_HOST_GAME_STATUS = null;
    public static final a Companion = null;
    public static final XplayMessageType UNKNOWN = null;
    public static final XplayMessageType XPLAY_INTERACT_CUSTOM = null;
    public static final XplayMessageType XPLAY_SWITCH_GUIDE_PLAYER = null;
    public static final /* synthetic */ XplayMessageType[] a = null;
    public static final Map<String, XplayMessageType> b = null;
    private final String messageKey;
    private final Class<? extends a10.a> messageType;

    public static final class a {
        public a() {
        }
    }

    static {
        int r4 = 0;
        XplayMessageType r1 = new XplayMessageType("UNKNOWN", 0, "unknown", a10.a.class);
        UNKNOWN = r1;
        XplayMessageType r2 = new XplayMessageType("CO_HOST_GAME_STATUS", 1, "game_status", c.class);
        CO_HOST_GAME_STATUS = r2;
        XplayMessageType r3 = new XplayMessageType("CO_HOST_GAME_QUIT", 2, "game_quit", b.class);
        CO_HOST_GAME_QUIT = r3;
        XplayMessageType r5 = new XplayMessageType("CO_HOST_CHANGE_SCREEN", 3, "screen", b10.a.class);
        CO_HOST_CHANGE_SCREEN = r5;
        XplayMessageType r6 = new XplayMessageType("XPLAY_SWITCH_GUIDE_PLAYER", 4, "anchor_guide", a10.b.class);
        XPLAY_SWITCH_GUIDE_PLAYER = r6;
        XplayMessageType r7 = new XplayMessageType("XPLAY_INTERACT_CUSTOM", 5, "interact_custom", a10.c.class);
        XPLAY_INTERACT_CUSTOM = r7;
        a = new XplayMessageType[]{r1, r2, r3, r5, r6, r7};
        Companion = new a();
        XplayMessageType[] r0 = values();
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
        int r9 = r0.length;
    L3:
        if (r4 >= r9) goto L5;
        XplayMessageType r11 = r0[r4];
        r8.put(r11.messageKey, r11);
        r4 = r4 + 1;
        goto L3
    L5:
        b = r8;
    }

    public static XplayMessageType valueOf(String r1) {
        return (XplayMessageType) r27.a.a(XplayMessageType.class, r1);
    }

    public static XplayMessageType[] values() {
        return (XplayMessageType[]) a.clone();
    }

    public static final /* synthetic */ Map access$getTypeMap$cp() {
        return b;
    }

    public final String getMessageKey() {
        return this.messageKey;
    }

    public final Class<? extends a10.a> getMessageType() {
        return this.messageType;
    }

    public XplayMessageType(String r1, int r2, String r3, Class r4) {
        super(r1, r2);
        this.messageKey = r3;
        this.messageType = r4;
    }
}
