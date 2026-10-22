package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0004 !\"#¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "Landroid/os/Parcelable;", "<init>", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "EventType", "CREATOR", "Lcom/obric/memorydata/sdk/screencapture/event/AppAccessibilityEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/InputMethodEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public abstract class ScreenEvent implements Parcelable {
    public static final a CREATOR = null;
    public long a;
    public String b;
    public String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "TOUCH", "INPUT_METHOD", "APP_STATE", "ACCESSIBILITY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final enum EventType extends Enum<EventType> {
        public static final EventType ACCESSIBILITY = null;
        public static final EventType APP_STATE = null;
        public static final EventType INPUT_METHOD = null;
        public static final EventType TOUCH = null;
        public static final /* synthetic */ EventType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EventType> getEntries() {
            return b;
        }

        static {
            EventType r0 = new EventType("TOUCH", 0);
            TOUCH = r0;
            EventType r1 = new EventType("INPUT_METHOD", 1);
            INPUT_METHOD = r1;
            EventType r3 = new EventType("APP_STATE", 2);
            APP_STATE = r3;
            EventType r5 = new EventType("ACCESSIBILITY", 3);
            ACCESSIBILITY = r5;
            EventType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static EventType[] values() {
            return (EventType[]) a.clone();
        }

        public static EventType valueOf(String r1) {
            return (EventType) r27.a.a(EventType.class, r1);
        }

        public EventType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements Parcelable.Creator<ScreenEvent> {
        public a() {
        }

        public static ScreenEvent a(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            String r0 = r6.readString();
            Intrinsics.checkNotNull(r0);
            EventType r1 = EventType.valueOf(r0);
            long r2 = r6.readLong();
            String r3 = r6.readString();
            Intrinsics.checkNotNull(r3);
            String r4 = r6.readString();
            Intrinsics.checkNotNull(r4);
            int r5 = a.a[r1.ordinal()];
            if (r5 != 1) goto L5;
            ScreenEvent r7 = new ScreenTouchEvent(r6);
        L16:
            r7.a = r2;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r7.b = r3;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r7.c = r4;
            return r7;
        L5:
            if (r5 != 2) goto L7;
            r7 = new InputMethodEvent(r6);
            goto L16
        L7:
            if (r5 != 3) goto L9;
            r7 = new AppStateEvent(r6);
            goto L16
        L9:
            if (r5 != 4) goto L12;
            r7 = new AppAccessibilityEvent(r6);
            goto L16
        L12:
            throw new NoWhenBranchMatchedException();
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScreenEvent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final ScreenEvent[] newArray(int r1) {
            return new ScreenEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public abstract EventType a();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ScreenEvent() {
        this.a = System.currentTimeMillis();
        this.b = "";
        this.c = "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(a().name());
        r3.writeLong(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
    }
}
