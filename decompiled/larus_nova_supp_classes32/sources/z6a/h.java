package z6a;

import android.graphics.Matrix;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class h extends ClickableSpan implements EventTarget {
    public final int a;
    public int b;
    public WeakReference<EventTarget> c;
    public final Map<String, EventsListener> d;
    public final EventTarget.EnableStatus e;
    public final EventTarget.EnableStatus f;
    public final EventTarget.PointerEventsValue g;
    public final ReadableMap h;
    public final Matrix i;
    public final boolean j;

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean blockNativeEvent(MotionEvent r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean consumeSlideEvent(float r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r1, float r2) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r1, float r2, boolean r3) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchEvent(LynxEventDetail r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchTouch(MotionEvent r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final int getGestureArenaMemberId() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final Map<Integer, s7a.a> getGestureDetectorMap() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget getParentLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget getRootLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean hasConsumeSlideEventAngles() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r1, float r2) {
        return this;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r1, float r2, boolean r3) {
        return this;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isFocusable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isOnResponseChain() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isUserInteractionEnabled() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void offResponseChain() {
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventBubble(boolean r1, long r2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventCapture(boolean r1, long r2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventFire(boolean r1, long r2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onFocusChanged(boolean r1, boolean r2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onResponseChain() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setChildrenLynxPageUI(HashMap<String, EventTarget> r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setEventID(long r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setParentLynxPageUI(EventTarget r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventBubble(long r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventCapture(long r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventFire(boolean r1, long r2) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final Matrix getTransformMatrix() {
        this.i.reset();
        return this.i;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean ignoreFocus() {
        EventTarget.EnableStatus r0 = this.e;
        if (r0 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r0 != EventTarget.EnableStatus.Disable) goto L10;
        return false;
    L10:
        if (parent() != null) goto L12;
        return false;
    L12:
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isClickable() {
        Map<String, EventsListener> r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((HashMap) r0).containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isLongClickable() {
        Map<String, EventsListener> r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((HashMap) r0).containsKey(LynxTouchEvent.EVENT_LONG_PRESS) == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget parent() {
        return this.c.get();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final v6a.a parentResponder() {
        WeakReference<EventTarget> r0 = this.c;
        if ((r0 instanceof v6a.a) == true) goto L5;
        return null;
    L5:
        return r0.get();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PointerEventsValue pointerEvents() {
        EventTarget.PointerEventsValue r0 = this.g;
        if (r0 == EventTarget.PointerEventsValue.Unset) goto L6;
        return r0;
    L6:
        if (parent() == null) goto L10;
        return parent().pointerEvents();
    L10:
        return EventTarget.PointerEventsValue.Auto;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean enableTouchPseudoPropagation() {
        return this.j;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final ReadableMap getDataset() {
        return this.h;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final Map<String, EventsListener> getEvents() {
        return this.d;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final int getPseudoStatus() {
        return this.b;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final int getSign() {
        return this.a;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PanInterceptDirection panInterceptDirection() {
        return EventTarget.PanInterceptDirection.None;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PanInterceptScope panInterceptScope() {
        return EventTarget.PanInterceptScope.None;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean eventThrough(float r4, float r5) {
        EventTarget.EnableStatus r0 = this.f;
        if (r0 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r0 != EventTarget.EnableStatus.Disable) goto L9;
        return false;
    L9:
        EventTarget r1 = parent();
        if (r1 != null) goto L12;
        return false;
    L12:
        return r1.eventThrough(r4, r5);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onPseudoStatusChanged(int r1, int r2) {
        this.b = r2;
    }

    public h(int r2, Map<String, EventsListener> r3, EventTarget.EnableStatus r4, boolean r5, EventTarget.EnableStatus r6, EventTarget.PointerEventsValue r7, ReadableMap r8) {
        this.h = new JavaOnlyMap();
        this.i = new Matrix();
        this.a = r2;
        this.c = null;
        this.e = r4;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.j = r5;
        if (r3 == null) goto L5;
        HashMap r9 = new HashMap();
        this.d = r9;
        r9.putAll(r3);
        return;
    L5:
        this.d = null;
    }
}
