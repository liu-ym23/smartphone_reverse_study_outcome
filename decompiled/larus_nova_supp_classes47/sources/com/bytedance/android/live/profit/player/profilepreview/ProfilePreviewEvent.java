package com.bytedance.android.live.profit.player.profilepreview;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import uu0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfilePreviewEvent {
    public final EventType a;
    public final b b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/player/profilepreview/ProfilePreviewEvent$EventType;", "", "EnterStart", "EnterEnd", "ExitStart", "ExitEnd", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType EnterEnd = null;
        public static final EventType EnterStart = null;
        public static final EventType ExitEnd = null;
        public static final EventType ExitStart = null;
        public static final /* synthetic */ EventType[] a = null;

        static {
            EventType r1 = new EventType("EnterStart", 0);
            EnterStart = r1;
            EventType r2 = new EventType("EnterEnd", 1);
            EnterEnd = r2;
            EventType r3 = new EventType("ExitStart", 2);
            ExitStart = r3;
            EventType r4 = new EventType("ExitEnd", 3);
            ExitEnd = r4;
            a = new EventType[]{r1, r2, r3, r4};
        }

        public static EventType valueOf(String r1) {
            return (EventType) a.a(EventType.class, r1);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public EventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ProfilePreviewEvent) == false) goto L10;
        ProfilePreviewEvent r4 = (ProfilePreviewEvent) r3;
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
        b r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProfilePreviewEvent(type=" + this.a + ", data=" + this.b + ")";
    }

    public final EventType getType() {
        return this.a;
    }

    public ProfilePreviewEvent(EventType r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.a = r2;
        this.b = r3;
    }
}
