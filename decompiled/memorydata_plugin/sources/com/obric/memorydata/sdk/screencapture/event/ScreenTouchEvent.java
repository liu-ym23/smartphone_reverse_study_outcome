package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002)*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "action", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "endTouchInfo", "scrollDirection", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAction", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "getTouchInfo", "()Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "getEndTouchInfo", "getScrollDirection", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "TouchAction", "ScrollDirection", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenTouchEvent extends ScreenEvent {
    private final TouchAction action;
    private final TouchInfo endTouchInfo;
    private final ScreenEvent.EventType eventType;
    private final ScrollDirection scrollDirection;
    private final TouchInfo touchInfo;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ScrollDirection[] $VALUES = null;
        public static final ScrollDirection DOWN = null;
        public static final ScrollDirection LEFT = null;
        public static final ScrollDirection RIGHT = null;
        public static final ScrollDirection UP = null;

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{UP, DOWN, LEFT, RIGHT};
        }

        static {
            UP = new ScrollDirection("UP", 0);
            DOWN = new ScrollDirection("DOWN", 1);
            LEFT = new ScrollDirection("LEFT", 2);
            RIGHT = new ScrollDirection("RIGHT", 3);
            ScrollDirection[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<ScrollDirection> getEntries() {
            return $ENTRIES;
        }

        public static ScrollDirection valueOf(String r2) {
            return (ScrollDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScrollDirection.class, r2), ScrollDirection.class, "com.obric.memorydata.plugin");
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScrollDirection[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "", "<init>", "(Ljava/lang/String;I)V", "TAP", "DOUBLE_TAP", "LONG_PRESS", "SCROLL_START", "SCROLLED", "BACK_KEY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum TouchAction extends Enum<TouchAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TouchAction[] $VALUES = null;
        public static final TouchAction BACK_KEY = null;
        public static final TouchAction DOUBLE_TAP = null;
        public static final TouchAction LONG_PRESS = null;
        public static final TouchAction SCROLLED = null;
        public static final TouchAction SCROLL_START = null;
        public static final TouchAction TAP = null;

        private static final /* synthetic */ TouchAction[] $values() {
            return new TouchAction[]{TAP, DOUBLE_TAP, LONG_PRESS, SCROLL_START, SCROLLED, BACK_KEY};
        }

        static {
            TAP = new TouchAction("TAP", 0);
            DOUBLE_TAP = new TouchAction("DOUBLE_TAP", 1);
            LONG_PRESS = new TouchAction("LONG_PRESS", 2);
            SCROLL_START = new TouchAction("SCROLL_START", 3);
            SCROLLED = new TouchAction("SCROLLED", 4);
            BACK_KEY = new TouchAction("BACK_KEY", 5);
            TouchAction[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private TouchAction(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<TouchAction> getEntries() {
            return $ENTRIES;
        }

        public static TouchAction valueOf(String r2) {
            return (TouchAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(TouchAction.class, r2), TouchAction.class, "com.obric.memorydata.plugin");
        }

        public static TouchAction[] values() {
            return (TouchAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TouchAction[].class, "com.obric.memorydata.plugin");
        }
    }

    public ScreenTouchEvent(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        String r0 = r6.readString();
        Intrinsics.checkNotNull(r0);
        TouchAction r1 = TouchAction.valueOf(r0);
        Parcelable r2 = r6.readParcelable(ScreenEvent.class.getClassLoader());
        Intrinsics.checkNotNull(r2);
        TouchInfo r3 = (TouchInfo) ZeusTransformUtils.preCheckCast(r2, TouchInfo.class, "com.obric.memorydata.plugin");
        TouchInfo r4 = (TouchInfo) ZeusTransformUtils.preCheckCast(r6.readParcelable(ScreenEvent.class.getClassLoader()), TouchInfo.class, "com.obric.memorydata.plugin");
        String r7 = r6.readString();
        if (r7 == null) goto L5;
        ScrollDirection r8 = ScrollDirection.valueOf(r7);
    L6:
        this(r1, r3, r4, r8);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public ScreenTouchEvent(TouchAction r2, TouchInfo r3, TouchInfo r4, ScrollDirection r5) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "touchInfo");
        super(null);
        this.action = r2;
        this.touchInfo = r3;
        this.endTouchInfo = r4;
        this.scrollDirection = r5;
        this.eventType = ScreenEvent.EventType.TOUCH;
    }

    public /* synthetic */ ScreenTouchEvent(TouchAction r2, TouchInfo r3, TouchInfo r4, ScrollDirection r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ ScreenTouchEvent copy$default(ScreenTouchEvent r0, TouchAction r1, TouchInfo r2, TouchInfo r3, ScrollDirection r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.touchInfo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.endTouchInfo;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.scrollDirection;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final TouchAction component1() {
        return this.action;
    }

    public final TouchInfo component2() {
        return this.touchInfo;
    }

    public final TouchInfo component3() {
        return this.endTouchInfo;
    }

    public final ScrollDirection component4() {
        return this.scrollDirection;
    }

    public final ScreenTouchEvent copy(TouchAction r1, TouchInfo r2, TouchInfo r3, ScrollDirection r4) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Intrinsics.checkNotNullParameter(r2, "touchInfo");
        return new ScreenTouchEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenTouchEvent.class) == true) goto L8;
        return false;
    L8:
        ScreenTouchEvent r6 = (ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r5, ScreenTouchEvent.class, "com.obric.memorydata.plugin");
        if (this.action == r6.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.touchInfo, r6.touchInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTouchInfo, r6.endTouchInfo) == true) goto L18;
        return false;
    L18:
        if (this.scrollDirection == r6.scrollDirection) goto L20;
        return false;
    L20:
        return true;
    }

    public final TouchAction getAction() {
        return this.action;
    }

    public final TouchInfo getEndTouchInfo() {
        return this.endTouchInfo;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public final ScrollDirection getScrollDirection() {
        return this.scrollDirection;
    }

    public final TouchInfo getTouchInfo() {
        return this.touchInfo;
    }

    public int hashCode() {
        int r0 = ((this.action.hashCode() * 31) + this.touchInfo.hashCode()) * 31;
        TouchInfo r1 = this.endTouchInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ScrollDirection r5 = this.scrollDirection;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenTouchEvent(action=" + this.action + ", touchInfo=" + this.touchInfo + ", endTouchInfo=" + this.endTouchInfo + ", scrollDirection=" + this.scrollDirection + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        super.writeToParcel(r4, r5);
        r4.writeString(this.action.name());
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.touchInfo, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.endTouchInfo, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        ScrollDirection r3 = this.scrollDirection;
        if (r3 == null) goto L5;
        String r6 = r3.name();
    L6:
        r4.writeString(r6);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
