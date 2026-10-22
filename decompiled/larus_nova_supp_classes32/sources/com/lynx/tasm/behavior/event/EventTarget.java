package com.lynx.tasm.behavior.event;

import android.graphics.Matrix;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import v6a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface EventTarget extends a {

    public static final enum EnableStatus extends Enum<EnableStatus> {
        public static final EnableStatus Disable = null;
        public static final EnableStatus Enable = null;
        public static final EnableStatus Undefined = null;
        public static final /* synthetic */ EnableStatus[] a = null;

        static {
            EnableStatus r0 = new EnableStatus("Enable", 0);
            Enable = r0;
            EnableStatus r1 = new EnableStatus("Disable", 1);
            Disable = r1;
            EnableStatus r3 = new EnableStatus("Undefined", 2);
            Undefined = r3;
            a = new EnableStatus[]{r0, r1, r3};
        }

        public static EnableStatus[] values() {
            return (EnableStatus[]) a.clone();
        }

        public static EnableStatus valueOf(String r1) {
            return (EnableStatus) r27.a.a(EnableStatus.class, r1);
        }

        public EnableStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum PanInterceptDirection extends Enum<PanInterceptDirection> {
        public static final PanInterceptDirection Horizontal = null;
        public static final PanInterceptDirection None = null;
        public static final PanInterceptDirection Vertical = null;
        public static final /* synthetic */ PanInterceptDirection[] a = null;

        static {
            PanInterceptDirection r0 = new PanInterceptDirection("Horizontal", 0);
            Horizontal = r0;
            PanInterceptDirection r1 = new PanInterceptDirection("Vertical", 1);
            Vertical = r1;
            PanInterceptDirection r3 = new PanInterceptDirection("None", 2);
            None = r3;
            a = new PanInterceptDirection[]{r0, r1, r3};
        }

        public static PanInterceptDirection[] values() {
            return (PanInterceptDirection[]) a.clone();
        }

        public static PanInterceptDirection valueOf(String r1) {
            return (PanInterceptDirection) r27.a.a(PanInterceptDirection.class, r1);
        }

        public PanInterceptDirection(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum PanInterceptScope extends Enum<PanInterceptScope> {
        public static final PanInterceptScope All = null;
        public static final PanInterceptScope Ancestors = null;
        public static final PanInterceptScope Descendants = null;
        public static final PanInterceptScope None = null;
        public static final PanInterceptScope Self = null;
        public static final PanInterceptScope SelfAndAncestors = null;
        public static final PanInterceptScope SelfAndDescendants = null;
        public static final /* synthetic */ PanInterceptScope[] a = null;

        static {
            PanInterceptScope r0 = new PanInterceptScope("Self", 0);
            Self = r0;
            PanInterceptScope r1 = new PanInterceptScope("Ancestors", 1);
            Ancestors = r1;
            PanInterceptScope r3 = new PanInterceptScope("Descendants", 2);
            Descendants = r3;
            PanInterceptScope r5 = new PanInterceptScope("SelfAndAncestors", 3);
            SelfAndAncestors = r5;
            PanInterceptScope r7 = new PanInterceptScope("SelfAndDescendants", 4);
            SelfAndDescendants = r7;
            PanInterceptScope r9 = new PanInterceptScope("All", 5);
            All = r9;
            PanInterceptScope r11 = new PanInterceptScope("None", 6);
            None = r11;
            a = new PanInterceptScope[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static PanInterceptScope[] values() {
            return (PanInterceptScope[]) a.clone();
        }

        public static PanInterceptScope valueOf(String r1) {
            return (PanInterceptScope) r27.a.a(PanInterceptScope.class, r1);
        }

        public PanInterceptScope(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum PointerEventsValue extends Enum<PointerEventsValue> {
        public static final PointerEventsValue Auto = null;
        public static final PointerEventsValue None = null;
        public static final PointerEventsValue Unset = null;
        public static final /* synthetic */ PointerEventsValue[] a = null;

        static {
            PointerEventsValue r0 = new PointerEventsValue("Auto", 0);
            Auto = r0;
            PointerEventsValue r1 = new PointerEventsValue("None", 1);
            None = r1;
            PointerEventsValue r3 = new PointerEventsValue("Unset", 2);
            Unset = r3;
            a = new PointerEventsValue[]{r0, r1, r3};
        }

        public static PointerEventsValue[] values() {
            return (PointerEventsValue[]) a.clone();
        }

        public static PointerEventsValue valueOf(String r1) {
            return (PointerEventsValue) r27.a.a(PointerEventsValue.class, r1);
        }

        public PointerEventsValue(String r1, int r2) {
            super(r1, r2);
        }
    }

    boolean blockNativeEvent(MotionEvent r1);

    boolean consumeSlideEvent(float r1);

    boolean containsPoint(float r1, float r2);

    boolean containsPoint(float r1, float r2, boolean r3);

    boolean dispatchEvent(LynxEventDetail r1);

    boolean dispatchTouch(MotionEvent r1);

    boolean enableTouchPseudoPropagation();

    boolean eventThrough(float r1, float r2);

    HashMap<String, EventTarget> getChildrenLynxPageUI();

    /* synthetic */ ReadableMap getDataset();

    Map<String, EventsListener> getEvents();

    int getGestureArenaMemberId();

    Map<Integer, s7a.a> getGestureDetectorMap();

    EventTarget getParentLynxPageUI();

    int getPseudoStatus();

    EventTarget getRootLynxPageUI();

    int getSign();

    Matrix getTransformMatrix();

    boolean hasConsumeSlideEventAngles();

    EventTarget hitTest(float r1, float r2);

    EventTarget hitTest(float r1, float r2, boolean r3);

    boolean ignoreFocus();

    boolean isClickable();

    boolean isFocusable();

    boolean isLongClickable();

    boolean isOnResponseChain();

    boolean isScrollable();

    boolean isUserInteractionEnabled();

    void offResponseChain();

    void onEventBubble(boolean r1, long r2);

    void onEventCapture(boolean r1, long r2);

    void onEventFire(boolean r1, long r2);

    void onFocusChanged(boolean r1, boolean r2);

    void onPseudoStatusChanged(int r1, int r2);

    void onResponseChain();

    PanInterceptDirection panInterceptDirection();

    PanInterceptScope panInterceptScope();

    EventTarget parent();

    /* synthetic */ a parentResponder();

    PointerEventsValue pointerEvents();

    void setChildrenLynxPageUI(HashMap<String, EventTarget> r1);

    void setEventID(long r1);

    void setPanInterceptAncestors(boolean r1);

    void setPanInterceptDescendants(boolean r1);

    void setPanInterceptSelf(boolean r1);

    void setParentLynxPageUI(EventTarget r1);

    void startEventBubble(long r1);

    void startEventCapture(long r1);

    void startEventFire(boolean r1, long r2);
}
