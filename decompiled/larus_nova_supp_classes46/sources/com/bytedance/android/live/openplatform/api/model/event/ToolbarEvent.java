package com.bytedance.android.live.openplatform.api.model.event;

import ko0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ToolbarEvent {
    public final EventType a;
    public final Object b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/event/ToolbarEvent$EventType;", "", "ShowToolbarAnimation", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType ShowToolbarAnimation = null;
        public static final /* synthetic */ EventType[] a = null;

        static {
            EventType r1 = new EventType();
            ShowToolbarAnimation = r1;
            a = new EventType[]{r1};
        }

        public static EventType valueOf(String r1) {
            return (EventType) a.a(EventType.class, r1);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public EventType() {
            super("ShowToolbarAnimation", 0);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ToolbarEvent) == false) goto L10;
        ToolbarEvent r4 = (ToolbarEvent) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        EventType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ToolbarEvent(eventType=" + this.a + ", data=" + this.b + ")";
    }

    public ToolbarEvent(EventType r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        this.a = r2;
        this.b = r3;
    }
}
