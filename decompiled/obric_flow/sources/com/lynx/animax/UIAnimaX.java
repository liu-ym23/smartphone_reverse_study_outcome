package com.lynx.animax;

import ai.p;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter$ExecutionPriority;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
@e0
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class UIAnimaX extends LynxUI<View> implements com.lynx.tasm.behavior.g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f9557p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f9558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zl.a f9559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f9560c;
    public AnimaXPlayer d;
    public final im.a e;
    public final p f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DisplayMode f9562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f9564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9568o;

    public static final enum DisplayMode extends Enum<DisplayMode> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DisplayMode f9569b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DisplayMode f9570c = null;
        public static final DisplayMode d = null;
        public static final /* synthetic */ DisplayMode[] e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9571a;

        static {
            DisplayMode r5 = new DisplayMode("IMAGE", 0, "image");
            f9569b = r5;
            DisplayMode r10 = new DisplayMode("SURFACE", 1, "surface");
            f9570c = r10;
            DisplayMode r11 = new DisplayMode("AUTO", 2, "auto");
            d = r11;
            e = new DisplayMode[]{r5, r10, r11};
        }

        public DisplayMode(String r5, int r10, String r11) {
            super(r5, r10);
            this.f9571a = r11;
        }

        public static DisplayMode valueOf(String r5) {
            return (DisplayMode) Enum.valueOf(DisplayMode.class, r5);
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) e.clone();
        }
    }

    public UIAnimaX(LynxContext r5) {
        super(r5, null);
        this.f = new p(9);
        this.g = false;
        this.f9561h = false;
        this.f9562i = DisplayMode.f9570c;
        this.f9564k = false;
        this.f9565l = false;
        this.f9566m = false;
        this.f9568o = false;
        this.f9558a = r5;
        if ((this.mView instanceof im.a) == true) goto L5;
        j();
    L5:
        this.e = (im.a) this.mView;
    }

    public static void b(Callback r5, String r10) {
        if (r5 == null) goto L5;
        r5.invoke(new Object[]{1, r10});
        return;
    }

    @Override // com.lynx.tasm.behavior.g
    public final void a() {
        if (this.f9565l == true) goto L10;
        AnimaXPlayer r5 = this.d;
        if (r5 == null) goto L9;
        r5.g(false, VisibilityState.f9581b);
        return;
    L9:
        return;
    }

    public final void c(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L18;
        LynxContext r10 = this.f9558a;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.f9568o == true) goto L20;
        ILynxTrailService r11 = (ILynxTrailService) r.g().e(ILynxTrailService.class);
        if (r11 != null) goto L12;
        boolean r12 = false;
    L13:
        if (r12 == false) goto L21;
        this.f9568o = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", r10.A, new c(r5, 2));
        return;
    L21:
        return;
    L12:
        r12 = "true".equals(r11.stringValueForTrailKey("enable_motion_ui_report"));
        goto L13
    L20:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        if ((r5 instanceof LynxContext) == true) goto L6;
        LynxLog.b(4, "UIAnimaX", "context is not LynxContext, create AnimaXView fail");
        return new View(r5);
    L6:
        LynxContext r10 = (LynxContext) r5;
        this.f9559b = new zl.a(this, r10);
        return new im.a(r10);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, im.h] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "UIAnimaX", "UIAnimaX destroy");
        ?? r5 = this.f9560c;
        if (r5 == 0) goto L5;
        r5.release();
    L8:
        this.f9560c = null;
        this.d = null;
        return;
    L5:
        AnimaXPlayer r10 = this.d;
        if (r10 == null) goto L8;
        r10.p();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean dispatchTouch(MotionEvent r10) {
        if (this.f9564k == false) goto L20;
        if (this.f9560c == null) goto L20;
        if (isUserInteractionEnabled() == false) goto L20;
        if (r10.getAction() != 0) goto L20;
        RectF r5 = i.a.o(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
        MotionEvent r11 = MotionEvent.obtain(r10);
        float r12 = r10.getRawX() - r5.left;
        float r13 = r10.getRawY() - r5.top;
        im.a r14 = this.e;
        if (r14 != null) goto L13;
        r11.setLocation(r12, r13);
    L14:
        im.h r15 = (im.h) this.f9560c;
        r15.getClass();
        if (r11 == null) goto L20;
        if (r11.getAction() != 0) goto L20;
        r15.getPlayer().b(r11.getX(), r11.getY());
        goto L20
    L13:
        r11.setLocation(r12 - r14.getPaddingLeft(), r13 - r14.getPaddingTop());
    L20:
        return super.dispatchTouch(r10);
    }

    @f0
    public void getCurrentFrame(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        if (r10 == null) goto L9;
        r10.invoke(new Object[]{0, Double.valueOf(this.d.getCurrentFrame())});
        return;
    }

    @f0
    public void getDuration(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        if (r10 == null) goto L9;
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putDouble("data", this.d.getDurationMs());
        r10.invoke(new Object[]{0, r11});
        return;
    }

    public final void i(String r5) {
        if (this.f9567n != null) goto L14;
        LynxContext r10 = this.f9558a;
        if (r10 != null) goto L7;
        return;
    L7:
        if (this.mView == 0) goto L16;
        if (r5 != null) goto L11;
        r5 = "unknown";
    L12:
        this.mView.setTag("url: " + i.a.i(r10.f10149q) + ", src: " + r5);
        return;
    L11:
        this.f9567n = r5;
        goto L12
    L16:
        return;
    }

    @f0
    public void isAnimating(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        if (r10 == null) goto L9;
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.putBoolean("data", this.d.l());
        r10.invoke(new Object[]{0, r11});
        return;
    }

    public final void j() {
        this.mView.post(new androidx.fragment.app.d(this, 18));
    }

    @f0
    public void listenAnimationUpdate(ReadableMap r5, Callback r10) {
        zl.a r11 = this.f9559b;
        if (r11 != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        if (r5 == null) goto L8;
        r11.f = r5.getBoolean("isListen");
    L8:
        if (r10 == null) goto L11;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putBoolean("data", this.f9559b.f);
        r10.invoke(new Object[]{0, r12});
        return;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, im.h] */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        im.a r5 = this.e;
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f9560c == null) goto L9;
        int r10 = getBorderLeftWidth();
        int r11 = getPaddingLeft() + r10;
        int r12 = getBorderTopWidth();
        int r13 = getPaddingTop() + r12;
        int r14 = getBorderRightWidth();
        int r15 = getPaddingRight() + r14;
        int r16 = getBorderBottomWidth();
        r5.setPadding(r11, r13, r15, getPaddingBottom() + r16);
        this.f9560c.requestLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        AnimaXPlayer r5 = this.d;
        if (r5 == null) goto L6;
        r5.q();
        return;
    }

    @f0
    public void pause(ReadableMap r5, Callback r10) {
        AnimaXPlayer r11 = this.d;
        if (r11 != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        r11.m();
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void play(ReadableMap r5, Callback r10) {
        AnimaXPlayer r11 = this.d;
        if (r11 != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        r11.o();
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void playSegment(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        int r11 = r5.getInt("startFrame");
        int r12 = r5.getInt("endFrame");
        if (r12 <= 0) goto L11;
        if (r11 <= r12) goto L11;
        b(r10, "startFrame and endFrame are not valid!");
        return;
    L11:
        this.d.d(r11, r12);
        if (r10 == null) goto L15;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void resume(ReadableMap r5, Callback r10) {
        AnimaXPlayer r11 = this.d;
        if (r11 != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        r11.r();
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void seek(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        int r11 = r5.getInt("frame");
        this.d.c(r11);
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @c0(name = "anti-aliasing")
    public void setAntiAliasing(String r5) {
        c r10 = new c(r5, 1);
        this.f.i(r10);
    }

    @c0(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(boolean r5) {
        d r10 = new d(r5, 1);
        this.f.i(r10);
    }

    @c0(name = "display-mode")
    public void setDisplayMode(String r10) {
        if (r10 != null) goto L4;
        DisplayMode r11 = DisplayMode.f9570c;
    L11:
        this.f9562i = r11;
        return;
    L4:
        DisplayMode[] r5 = DisplayMode.values();
        int r12 = r5.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        DisplayMode r14 = r5[r13];
        if (r14.f9571a.equals(r10) == true) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        r11 = r14;
        goto L11
    L10:
        r11 = DisplayMode.f9570c;
        goto L11
    }

    @c0(name = "dynamic-resource")
    public void setDynamicResource(boolean r5) {
        d r10 = new d(r5, 2);
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = UIAnimaXPropsPrioritySetter$ExecutionPriority.f9694b;
        this.f.j(r10, r11);
    }

    @c0(name = "android-enable-screenshot")
    public void setEnableScreenshot(boolean r5) {
        this.f9566m = r5;
    }

    @c0(defaultInt = -1, name = "end-frame")
    public void setEndFrame(int r5) {
        b r10 = new b(r5, 2);
        this.f.i(r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f9564k = r10;
        return;
    L5:
        if (r5.containsKey("taplayers") == false) goto L7;
        r10 = true;
        goto L8
    }

    @c0(name = "fps-event-interval")
    public void setFpsEventInterval(int r5) {
        b r10 = new b(r5, 0);
        this.f.i(r10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, im.h] */
    @c0(defaultBoolean = false, name = "ignore-attach-status")
    public void setIgnoreAttachStatus(boolean r5) {
        ?? r10 = this.f9560c;
        if (r10 == 0) goto L6;
        r10.setIgnoreAttachStatus(r5);
        return;
    L6:
        this.f9561h = r5;
    }

    @c0(defaultBoolean = false, name = "ignore-lynx-lifecycle")
    public void setIgnoreLynxLifecycle(boolean r5) {
        this.f9565l = r5;
    }

    @c0(name = "json")
    public void setJson(String r5) {
        f r10 = new f(this, r5, 1);
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = UIAnimaXPropsPrioritySetter$ExecutionPriority.d;
        this.f.j(r10, r11);
    }

    @c0(defaultBoolean = true, name = "keeplastframe")
    public void setKeepLastFrame(boolean r5) {
        d r10 = new d(r5, 4);
        this.f.i(r10);
    }

    @c0(defaultBoolean = false, name = "loop")
    public void setLoop(boolean r5) {
        d r10 = new d(r5, 3);
        this.f.i(r10);
    }

    @c0(defaultInt = 1, name = "loop-count")
    public void setLoopCount(int r5) {
        b r10 = new b(r5, 3);
        this.f.i(r10);
    }

    @c0(name = "max-frame-rate")
    public void setMaxFrameRate(final double r5) {
        hm.a r10 = new h(r5);
        this.f.i(r10);
    }

    @c0(defaultBoolean = true, name = "multi-thread-accelerate")
    public void setMultiThreadAccelerate(boolean r5) {
        this.g = r5;
    }

    @c0(name = "objectfit")
    public void setObjectFit(String r5) {
        c r10 = new c(r5, 0);
        this.f.i(r10);
    }

    @c0(name = "object-position")
    public void setObjectPosition(String r5) {
        c r10 = new c(r5, 3);
        this.f.i(r10);
    }

    @c0(name = NotificationCompat.CATEGORY_PROGRESS)
    public void setProgress(float r5) {
        e r10 = new e(r5, 0);
        this.f.i(r10);
    }

    @c0(defaultBoolean = false, name = "auto-reverse")
    public void setReverseMode(boolean r5) {
        d r10 = new d(r5, 0);
        this.f.i(r10);
    }

    @c0(name = "speed")
    public void setSpeed(float r5) {
        e r10 = new e(r5, 1);
        this.f.i(r10);
    }

    @c0(name = "src")
    public void setSrc(String r5) {
        f r10 = new f(this, r5, 2);
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = UIAnimaXPropsPrioritySetter$ExecutionPriority.d;
        this.f.j(r10, r11);
    }

    @c0(name = "src-format")
    public void setSrcFormat(String r5) {
        f r10 = new f(this, r5, 0);
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = UIAnimaXPropsPrioritySetter$ExecutionPriority.d;
        this.f.j(r10, r11);
    }

    @c0(name = "src-polyfill")
    public void setSrcPolyfill(ReadableMap r5) {
        if ((r5 instanceof JavaOnlyMap) == false) goto L6;
        a r10 = new a(0, this, r5);
        UIAnimaXPropsPrioritySetter$ExecutionPriority r11 = UIAnimaXPropsPrioritySetter$ExecutionPriority.f9694b;
        this.f.j(r10, r11);
        return;
    L6:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UIAnimaX", "setSrcPolyfill fail");
    }

    @c0(defaultInt = 0, name = "start-frame")
    public void setStartFrame(int r5) {
        b r10 = new b(r5, 1);
        this.f.i(r10);
    }

    @c0(name = "tag")
    public void setTag(String r5) {
        this.f9563j = r5;
        this.f9559b.e.d.put("tag", r5);
    }

    @c0(name = "video-frame-timeout")
    public void setVideoFrameTimeout(int r5) {
        zl.a r10 = this.f9559b;
        if (r10 == null) goto L6;
        r10.d.f9665a = r5;
        return;
    }

    @f0
    public void stop(ReadableMap r5, Callback r10) {
        AnimaXPlayer r11 = this.d;
        if (r11 != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        r11.s();
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void subscribeUpdateEvent(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        int r11 = r5.getInt("frame");
        this.d.j(r11);
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void subscribeUpdateEvents(ReadableMap r10, Callback r11) {
        if (this.d != null) goto L6;
        b(r11, "animax view is not inited.");
        return;
    L6:
        ReadableArray r12 = r10.getArray("frames");
        if (r12 != null) goto L9;
        int[] r13 = null;
    L14:
        if (r13 != null) goto L17;
        b(r11, "animax view is not inited.");
        return;
    L17:
        this.d.h(r13, true);
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{0});
        return;
    L22:
        return;
    L9:
        int[] r5 = new int[r12.size()];
        int r14 = 0;
    L11:
        if (r14 >= r12.size()) goto L13;
        r5[r14] = r12.getInt(r14);
        r14 = r14 + 1;
        goto L11
    L13:
        r13 = r5;
        goto L14
    }

    @f0
    public void unsubscribeUpdateEvent(ReadableMap r5, Callback r10) {
        if (this.d != null) goto L6;
        b(r10, "animax view is not inited.");
        return;
    L6:
        int r11 = r5.getInt("frame");
        this.d.n(r11);
        if (r10 == null) goto L10;
        r10.invoke(new Object[]{0});
        return;
    }

    @f0
    public void unsubscribeUpdateEvents(ReadableMap r10, Callback r11) {
        if (this.d != null) goto L6;
        b(r11, "animax view is not inited.");
        return;
    L6:
        ReadableArray r12 = r10.getArray("frames");
        if (r12 != null) goto L9;
        int[] r13 = null;
    L14:
        if (r13 != null) goto L17;
        b(r11, "animax view is not inited.");
        return;
    L17:
        this.d.h(r13, false);
        if (r11 == null) goto L22;
        r11.invoke(new Object[]{0});
        return;
    L22:
        return;
    L9:
        int[] r5 = new int[r12.size()];
        int r14 = 0;
    L11:
        if (r14 >= r12.size()) goto L13;
        r5[r14] = r12.getInt(r14);
        r14 = r14 + 1;
        goto L11
    L13:
        r13 = r5;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r9v20, types: [android.view.View, im.h] */
    /* JADX WARN: Type inference failed for: r9v21, types: [android.view.View, im.h] */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(y0 r10) {
        super.updatePropertiesInterval(r10);
        AnimaXPlayer r11 = this.d;
        p r5 = this.f;
        LynxContext r12 = this.f9558a;
        if (r11 != null) goto L9;
        zl.a r13 = this.f9559b;
        if (r13 == null) goto L9;
        c5.a r14 = new c5.a(r13, r12.a());
        r14.f1118b = this.g;
        im.b r15 = new im.b(r14);
        zl.a r16 = this.f9559b;
        ((ConcurrentHashMap) r16.f9577c.f9657b).put(IAnimaXMonitorService.class, new fm.a(r12));
        zl.a r17 = this.f9559b;
        ((ConcurrentHashMap) r17.f9577c.f9657b).put(g.class, new g(this));
        AnimaXPlayer r18 = new AnimaXPlayer(r15);
        this.d = r18;
        r5.getClass();
        r5.f288c = new WeakReference(r18);
    L9:
        if (this.f9560c != null) goto L40;
        zl.a r19 = this.f9559b;
        if (r19 == null) goto L39;
        if (r12 == null) goto L39;
        im.a r20 = this.e;
        if (r20 != null) goto L18;
        LynxLog.b(4, "UIAnimaX", "AnimaXContainerView is not created");
        j();
        goto L40
    L18:
        if (this.d != null) goto L21;
        LynxLog.b(4, "UIAnimaX", "AnimaXPlayer is not created");
        j();
        goto L40
    L21:
        if (jm.b.c("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r19) == false) goto L23;
        LynxLog.b(4, "UIAnimaX", "Device is not support, create AnimaXView fail");
        j();
        goto L40
    L23:
        DisplayMode r21 = this.f9562i;
        if (r21 != DisplayMode.f9569b) goto L26;
    L37:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "UIAnimaX", "create AnimaXImageView");
        this.f9559b.e.d.put("display_mode", "image");
        im.d r22 = new im.d(this.d);
        this.f9560c = r22;
        r20.f17578c = r22;
        r22.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r20.addView(r22);
        r20.f17576a = null;
    L38:
        this.f9560c.setEnableTapLayerEvent(false);
        this.f9560c.setIgnoreAttachStatus(this.f9561h);
        goto L40
    L26:
        if (r21 != DisplayMode.d) goto L36;
        zl.a r23 = this.f9559b;
        String r24 = this.f9563j;
        if (r24 != null) goto L30;
    L33:
        boolean r25 = false;
    L34:
        if (r25 == false) goto L36;
    L30:
        if (r24.isEmpty() == true) goto L33;
        r25 = jm.b.b(jm.b.a("ANIMAX_USE_IMAGE_VIEW_".concat(r24), r23));
    L36:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "UIAnimaX", "create AnimaXView");
        this.f9559b.e.d.put("display_mode", "surface");
        im.e r26 = new im.e(this.d);
        this.f9560c = r26;
        bd.d r27 = new bd.d(this);
        r20.f17577b = r26;
        r26.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r20.addView(r26);
        r20.f17576a = r27;
    L39:
        LynxLog.b(4, "UIAnimaX", "LynxAbility or LynxContext is not created");
        j();
    L40:
        AnimaXPlayer r28 = (AnimaXPlayer) ((WeakReference) r5.f288c).get();
        if (r28 == null) goto L51;
    L43:
        PriorityQueue r29 = (PriorityQueue) r5.f287b;
        if (r29.isEmpty() == true) goto L59;
        hm.b r30 = (hm.b) r29.poll();
        if (r30 == null) goto L43;
        r30.f17339a.a(r28);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "UIAnimaXPropsPrioritySetter", androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("Failed to run pending tasks with exception: ")));
        goto L43
    L59:
        return;
    }

    @Override // com.lynx.tasm.behavior.g
    public final void c() {
        if (this.f9565l == true) goto L10;
        AnimaXPlayer r5 = this.d;
        if (r5 == null) goto L9;
        r5.g(true, VisibilityState.f9581b);
        return;
    L9:
        return;
    }
}
