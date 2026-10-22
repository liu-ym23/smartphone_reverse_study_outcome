package com.obric.memorydata.screencapture.monitor;

import android.app.KeyguardManager;
import android.content.Context;
import android.view.GestureDetector;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.event.TouchInfo;
import com.obric.memorydata.utils.af;
import com.obric.memorydata.utils.x;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002?@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020\u0017H\u0003J\b\u0010 \u001a\u00020\u0017H\u0002J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0015J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0019H\u0017J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0019H\u0016J*\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0019H\u0016J*\u0010/\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0016J \u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0002J\u0010\u00105\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0019H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u0010#\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020,H\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\b\u0010<\u001a\u00020\u0007H\u0003J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/UserInputDetector;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Lcom/obric/memorydata/screencapture/monitor/InputMonitorManager$InputEventListener;", "Lcom/obric/memorydata/screencapture/INotificationPanelStateChangeListener;", "<init>", "()V", "scrolling", "", "lastDownTouchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "gestureDetector", "Landroid/view/GestureDetector;", "navigationBarHeight", "", "screenHeight", "getScreenHeight", "()I", "screenHeight$delegate", "Lkotlin/Lazy;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/screencapture/monitor/UserInputDetector$ScreenTouchEventListener;", "onReceiveInput", "", "inputEvent", "Landroid/view/MotionEvent;", "onScrolled", "endEvent", "monitorInputEvent", "addListener", "listener", "registerSystemEvent", "unregisterSystemEvent", "removeListener", "notifyEvent", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "onSingleTapUp", "e", "onLongPress", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onDown", "onScroll", "distanceX", "distanceY", "invokeScroll", "touchAction", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "onDoubleTap", "onInputEvent", "Landroid/view/InputEvent;", "isClickIme", "y", "isClickNavigationBar", "canCapture", "isKeyguardLocked", "onChange", "shown", "Companion", "ScreenTouchEventListener", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends GestureDetector.SimpleOnGestureListener implements com.obric.memorydata.screencapture.b, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12808b;
    private TouchInfo c;
    private final GestureDetector d;
    private final int e;
    private final Lazy f;
    private final CopyOnWriteArrayList<b> g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/UserInputDetector$Companion;", "", "<init>", "()V", "TAG", "", "IME_WINDOW_TOP_POSITION", "", "BACK_INTENT_ACTION", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/screencapture/monitor/UserInputDetector$ScreenTouchEventListener;", "", "onScreenTouchEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void a(ScreenTouchEvent r1);
    }

    static {
        f12807a = new a(null);
    }

    public e() {
        com.obric.memorydata.screencapture.c.f12795a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.d = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(this, GestureDetector.OnGestureListener.class, "com.obric.memorydata.plugin"), d.f12805a.a());
        this.e = x.f13267a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f = LazyKt.lazy($$Lambda$e$DwIYJeTQrIofxs1sMgiXEWro7o.INSTANCE);
        this.g = new CopyOnWriteArrayList();
    }

    private final int a() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private static final Unit a(InputEvent r2, e r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.MotionEvent");
        r3.a((MotionEvent) ZeusTransformUtils.preCheckCast(r2, MotionEvent.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void a(MotionEvent r3) {
        this.d.onTouchEvent(r3);
        if (r3.getActionMasked() == 1) goto L7;
        if (r3.getActionMasked() == 3) goto L7;
        return;
    L7:
        if (this.f12808b == false) goto L9;
        b(r3);
    L9:
        this.c = null;
    }

    public static final /* synthetic */ void a(e r0, ScreenTouchEvent r1) {
        r0.a(r1);
    }

    private final void a(ScreenTouchEvent.TouchAction r4, TouchInfo r5, TouchInfo r6) {
        float r0 = Math.abs(r5.getY() - r6.getY());
        if (Math.abs(r5.getX() - r6.getX()) < r0) goto L9;
        if (r5.getX() <= r6.getX()) goto L7;
        ScreenTouchEvent.ScrollDirection r1 = ScreenTouchEvent.ScrollDirection.RIGHT;
    L12:
        a(new ScreenTouchEvent(r4, r6, r5, r1));
        return;
    L7:
        r1 = ScreenTouchEvent.ScrollDirection.LEFT;
        goto L12
    L9:
        if (r5.getY() <= r6.getY()) goto L11;
        r1 = ScreenTouchEvent.ScrollDirection.DOWN;
        goto L12
    L11:
        r1 = ScreenTouchEvent.ScrollDirection.UP;
        goto L12
    }

    private final void a(ScreenTouchEvent r4) {
        if (e() == true) goto L6;
        return;
    L6:
        if (c.f12803a.a() == true) goto L8;
    L10:
        r4.setPackageName(af.f13160a.b());
        r4.setAppName(af.f13160a.a());
        RunLog.INSTANCE.debug("UserInputDetector", "notifyEvent " + r4);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ((b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin")).a(r4);
        goto L12
    L14:
        return;
    L8:
        if (a(r4.getTouchInfo().getY()) == false) goto L10;
    }

    private final boolean a(float r1) {
        if (r1 < 1736.0f) goto L5;
        return true;
    L5:
        return false;
    }

    private final void b() {
        d.f12805a.a((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.memorydata.plugin"));
    }

    private final void b(MotionEvent r4) {
        RunLog.INSTANCE.debug("UserInputDetector", "onScrolled " + r4);
        this.f12808b = false;
        if (this.c != null) goto L5;
        return;
    L5:
        ScreenTouchEvent.TouchAction r0 = ScreenTouchEvent.TouchAction.SCROLLED;
        TouchInfo r5 = TouchInfo.Companion.a(r4);
        TouchInfo r1 = this.c;
        Intrinsics.checkNotNull(r1);
        a(r0, r5, r1);
    }

    private final boolean b(float r2) {
        if (r2 < (a() - (this.e * 2))) goto L5;
        return true;
    L5:
        return false;
    }

    private final void c() {
        com.obric.memorydata.utils.c.b.a((com.obric.memorydata.utils.c.b.InterfaceC0719b) ZeusTransformUtils.preCheckCast(new UserInputDetector$registerSystemEvent$1(this), com.obric.memorydata.utils.c.b.InterfaceC0719b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        RunLog.INSTANCE.error("UserInputDetector", "registerBackAction error", th);
    }

    private final void d() {
        com.obric.memorydata.utils.c.b.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        RunLog.INSTANCE.error("UserInputDetector", "unregisterBackAction error", th);
    }

    private final boolean e() {
        if (f() == false) goto L6;
        return false;
    L6:
        return true;
    }

    private final boolean f() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) ZeusTransformUtils.preCheckCast(r2, KeyguardManager.class, "com.obric.memorydata.plugin")).isKeyguardLocked();
    }

    private static final int g() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin")).getCurrentWindowMetrics().getBounds().height();
    }

    /* JADX INFO: renamed from: lambda$-DwIYJeTQrIofxs1sMgiXEWro7o, reason: not valid java name */
    public static /* synthetic */ int m1179lambda$DwIYJeTQrIofxs1sMgiXEWro7o() {
        return g();
    }

    public static /* synthetic */ Unit lambda$r50TMPzQcSOBatJxaoErhxKVw9o(InputEvent r0, e r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.screencapture.monitor.d.a
    public void a(final InputEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        y.a(null, new $$Lambda$e$r50TMPzQcSOBatJxaoErhxKVw9o(r2, this), 1, null);
    }

    public final void a(b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        if (this.g.contains(r5) == false) goto L5;
        return;
    L5:
        boolean r0 = this.g.isEmpty();
        this.g.add(r5);
        if (r0 == false) goto L9;
        b();
        c();
        com.obric.memorydata.screencapture.c.f12795a.a((com.obric.memorydata.screencapture.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.b.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.memorydata.screencapture.b
    public void a(boolean r1) {
    }

    public final void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.g.contains(r4) == false) goto L8;
        this.g.remove(r4);
        if (this.g.isEmpty() == false) goto L9;
        d.f12805a.b((d.a) ZeusTransformUtils.preCheckCast(this, d.a.class, "com.obric.memorydata.plugin"));
        d();
        com.obric.memorydata.screencapture.c.f12795a.b((com.obric.memorydata.screencapture.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.screencapture.b.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        a(new ScreenTouchEvent(ScreenTouchEvent.TouchAction.DOUBLE_TAP, TouchInfo.Companion.a(r9), null, null, 12, null));
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.f12808b = false;
        this.c = TouchInfo.Companion.a(r2);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "e2");
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        a(new ScreenTouchEvent(ScreenTouchEvent.TouchAction.LONG_PRESS, TouchInfo.Companion.a(r9), null, null, 12, null));
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
        Intrinsics.checkNotNullParameter(r5, "e2");
        TouchInfo r8 = this.c;
        TouchInfo r9 = null;
        Float r10 = null;
        if (r8 == null) goto L12;
        Intrinsics.checkNotNull(r8);
        if (b(r8.getY()) == false) goto L12;
        RunLog r11 = RunLog.INSTANCE;
        StringBuilder r12 = new StringBuilder().append("ignore navigation bar scroll, y = ");
        TouchInfo r3 = this.c;
        if (r3 == null) goto L9;
        r10 = Float.valueOf(r3.getY());
    L9:
        r11.debug("UserInputDetector", r12.append(r10).toString());
        return true;
    L12:
        if (this.f12808b == true) goto L20;
        this.f12808b = true;
        RunLog.INSTANCE.debug("UserInputDetector", "onScroll start");
        TouchInfo r13 = this.c;
        if (r13 != null) goto L17;
        if (r4 == null) goto L18;
        r9 = TouchInfo.Companion.a(r4);
    L18:
        if (r9 == null) goto L20;
        a(ScreenTouchEvent.TouchAction.SCROLL_START, TouchInfo.Companion.a(r5), r9);
        goto L20
    L17:
        r9 = r13;
    L20:
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "e");
        RunLog.INSTANCE.debug("UserInputDetector", "onSingleTapUp");
        a(new ScreenTouchEvent(ScreenTouchEvent.TouchAction.TAP, TouchInfo.Companion.a(r11), null, null, 12, null));
        return true;
    }
}
