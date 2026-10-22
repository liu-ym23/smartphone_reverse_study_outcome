package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0004 !\"#¨\u0006$"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "Landroid/os/Parcelable;", "<init>", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "appName", "getAppName", "setAppName", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "EventType", "CREATOR", "Lcom/obric/memorydata/sdk/screencapture/event/AppAccessibilityEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/InputMethodEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScreenEvent implements Parcelable {
    public static final a CREATOR = null;
    private String appName;
    private long eventTime;
    private String packageName;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "TOUCH", "INPUT_METHOD", "APP_STATE", "ACCESSIBILITY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum EventType extends Enum<EventType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ EventType[] $VALUES = null;
        public static final EventType ACCESSIBILITY = null;
        public static final EventType APP_STATE = null;
        public static final EventType INPUT_METHOD = null;
        public static final EventType TOUCH = null;

        private static final /* synthetic */ EventType[] $values() {
            return new EventType[]{TOUCH, INPUT_METHOD, APP_STATE, ACCESSIBILITY};
        }

        static {
            TOUCH = new EventType("TOUCH", 0);
            INPUT_METHOD = new EventType("INPUT_METHOD", 1);
            APP_STATE = new EventType("APP_STATE", 2);
            ACCESSIBILITY = new EventType("ACCESSIBILITY", 3);
            EventType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private EventType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }

        public static EventType valueOf(String r2) {
            return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.memorydata.plugin");
        }

        public static EventType[] values() {
            return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ScreenEvent> {

        /* JADX INFO: renamed from: com.obric.memorydata.sdk.screencapture.event.ScreenEvent$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class C0702a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12852a = null;

            static {
                int[] r0 = new int[EventType.values().length];
                r0[EventType.TOUCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[EventType.INPUT_METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[EventType.APP_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[EventType.ACCESSIBILITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f12852a = r0;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ScreenEvent a(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            String r6 = r7.readString();
            Intrinsics.checkNotNull(r6);
            EventType r8 = EventType.valueOf(r6);
            long r0 = r7.readLong();
            String r2 = r7.readString();
            Intrinsics.checkNotNull(r2);
            String r3 = r7.readString();
            Intrinsics.checkNotNull(r3);
            int r9 = C0702a.f12852a[r8.ordinal()];
            if (r9 != 1) goto L5;
            Object r10 = new ScreenTouchEvent(r7);
        L16:
            ScreenEvent r11 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r10, ScreenEvent.class, "com.obric.memorydata.plugin");
            r11.setEventTime(r0);
            r11.setPackageName(r2);
            r11.setAppName(r3);
            return r11;
        L5:
            if (r9 != 2) goto L7;
            r10 = new InputMethodEvent(r7);
            goto L16
        L7:
            if (r9 != 3) goto L9;
            r10 = new AppStateEvent(r7);
            goto L16
        L9:
            if (r9 != 4) goto L12;
            r10 = new AppAccessibilityEvent(r7);
            goto L16
        L12:
            throw new NoWhenBranchMatchedException();
        }

        public ScreenEvent[] a(int r1) {
            return new ScreenEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenEvent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenEvent[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    private ScreenEvent() {
        this.eventTime = System.currentTimeMillis();
        this.packageName = "";
        this.appName = "";
    }

    public /* synthetic */ ScreenEvent(DefaultConstructorMarker r1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public abstract EventType getEventType();

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setAppName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appName = r2;
    }

    public final void setEventTime(long r1) {
        this.eventTime = r1;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(getEventType().name());
        r3.writeLong(this.eventTime);
        r3.writeString(this.packageName);
        r3.writeString(this.appName);
    }
}
