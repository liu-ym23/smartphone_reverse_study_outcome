package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002)*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "action", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "endTouchInfo", "scrollDirection", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAction", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "getTouchInfo", "()Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "getEndTouchInfo", "getScrollDirection", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "TouchAction", "ScrollDirection", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenTouchEvent extends ScreenEvent {
    public final TouchAction d;
    public final TouchInfo e;
    public final TouchInfo f;
    public final ScrollDirection g;
    public final ScreenEvent.EventType h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection DOWN = null;
        public static final ScrollDirection LEFT = null;
        public static final ScrollDirection RIGHT = null;
        public static final ScrollDirection UP = null;
        public static final /* synthetic */ ScrollDirection[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return b;
        }

        static {
            ScrollDirection r0 = new ScrollDirection("UP", 0);
            UP = r0;
            ScrollDirection r1 = new ScrollDirection("DOWN", 1);
            DOWN = r1;
            ScrollDirection r3 = new ScrollDirection("LEFT", 2);
            LEFT = r3;
            ScrollDirection r5 = new ScrollDirection("RIGHT", 3);
            RIGHT = r5;
            ScrollDirection[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) a.clone();
        }

        public static ScrollDirection valueOf(String r1) {
            return (ScrollDirection) a.a(ScrollDirection.class, r1);
        }

        public ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "", "<init>", "(Ljava/lang/String;I)V", "TAP", "DOUBLE_TAP", "LONG_PRESS", "SCROLL_START", "SCROLLED", "BACK_KEY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final enum TouchAction extends Enum<TouchAction> {
        public static final TouchAction BACK_KEY = null;
        public static final TouchAction DOUBLE_TAP = null;
        public static final TouchAction LONG_PRESS = null;
        public static final TouchAction SCROLLED = null;
        public static final TouchAction SCROLL_START = null;
        public static final TouchAction TAP = null;
        public static final /* synthetic */ TouchAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TouchAction> getEntries() {
            return b;
        }

        static {
            TouchAction r0 = new TouchAction("TAP", 0);
            TAP = r0;
            TouchAction r1 = new TouchAction("DOUBLE_TAP", 1);
            DOUBLE_TAP = r1;
            TouchAction r3 = new TouchAction("LONG_PRESS", 2);
            LONG_PRESS = r3;
            TouchAction r5 = new TouchAction("SCROLL_START", 3);
            SCROLL_START = r5;
            TouchAction r7 = new TouchAction("SCROLLED", 4);
            SCROLLED = r7;
            TouchAction r9 = new TouchAction("BACK_KEY", 5);
            BACK_KEY = r9;
            TouchAction[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static TouchAction[] values() {
            return (TouchAction[]) a.clone();
        }

        public static TouchAction valueOf(String r1) {
            return (TouchAction) a.a(TouchAction.class, r1);
        }

        public TouchAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ScreenTouchEvent) == true) goto L8;
        return false;
    L8:
        ScreenTouchEvent r6 = (ScreenTouchEvent) r5;
        if (this.d == r6.d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r6.g) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.d.hashCode() * 31) + this.e.hashCode()) * 31;
        TouchInfo r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ScrollDirection r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScreenTouchEvent(action=" + this.d + ", touchInfo=" + this.e + ", endTouchInfo=" + this.f + ", scrollDirection=" + this.g + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public final ScreenEvent.EventType a() {
        return this.h;
    }

    public ScreenTouchEvent(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        String r0 = r5.readString();
        Intrinsics.checkNotNull(r0);
        TouchAction r1 = TouchAction.valueOf(r0);
        Parcelable r2 = r5.readParcelable(ScreenEvent.class.getClassLoader());
        Intrinsics.checkNotNull(r2);
        TouchInfo r3 = (TouchInfo) r2;
        TouchInfo r4 = (TouchInfo) r5.readParcelable(ScreenEvent.class.getClassLoader());
        String r6 = r5.readString();
        if (r6 == null) goto L5;
        ScrollDirection r7 = ScrollDirection.valueOf(r6);
    L6:
        Intrinsics.checkNotNullParameter(r1, "action");
        Intrinsics.checkNotNullParameter(r3, "touchInfo");
        this.d = r1;
        this.e = r3;
        this.f = r4;
        this.g = r7;
        this.h = ScreenEvent.EventType.TOUCH;
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeString(this.d.name());
        r2.writeParcelable(this.e, r3);
        r2.writeParcelable(this.f, r3);
        ScrollDirection r4 = this.g;
        if (r4 == null) goto L5;
        String r5 = r4.name();
    L6:
        r2.writeString(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
