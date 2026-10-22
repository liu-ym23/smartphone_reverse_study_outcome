package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/EventType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CLICK", "CHECK", "UNCHECK", "MAP", "UNKNOWN", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum EventType extends Enum<EventType> {
    public static final EventType CHECK = null;
    public static final EventType CLICK = null;
    public static final EventType MAP = null;
    public static final EventType UNCHECK = null;
    public static final EventType UNKNOWN = null;
    public static final /* synthetic */ EventType[] a = null;
    private final String value;

    static {
        EventType r1 = new EventType("CLICK", 0, "click");
        CLICK = r1;
        EventType r10 = new EventType("CHECK", 1, "check");
        CHECK = r10;
        EventType r11 = new EventType("UNCHECK", 2, "uncheck");
        UNCHECK = r11;
        EventType r12 = new EventType("MAP", 3, "map");
        MAP = r12;
        EventType r13 = new EventType("UNKNOWN", 4, "unknown");
        UNKNOWN = r13;
        a = new EventType[]{r1, r10, r11, r12, r13};
    }

    public static EventType valueOf(String r1) {
        return (EventType) r27.a.a(EventType.class, r1);
    }

    public static EventType[] values() {
        return (EventType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public EventType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
