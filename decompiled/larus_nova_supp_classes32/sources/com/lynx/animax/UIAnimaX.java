package com.lynx.animax;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.AnimaXImageView;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIAnimaX extends LynxUI<View> implements com.lynx.tasm.behavior.j {
    public static final UIAnimaXPropsPrioritySetter.ExecutionPriority p = null;
    public static final UIAnimaXPropsPrioritySetter.ExecutionPriority q = null;
    public final LynxContext a;
    public o4a.b b;
    public x4a.g c;
    public AnimaXPlayer d;
    public final x4a.a e;
    public final UIAnimaXPropsPrioritySetter f;
    public boolean g;
    public boolean h;
    public DisplayMode i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;

    public static final enum DisplayMode extends Enum<DisplayMode> {
        public static final DisplayMode AUTO = null;
        public static final DisplayMode IMAGE = null;
        public static final DisplayMode SURFACE = null;
        public static final /* synthetic */ DisplayMode[] a = null;
        private final String value;

        static {
            DisplayMode r0 = new DisplayMode("IMAGE", 0, "image");
            IMAGE = r0;
            DisplayMode r1 = new DisplayMode("SURFACE", 1, "surface");
            SURFACE = r1;
            DisplayMode r2 = new DisplayMode("AUTO", 2, "auto");
            AUTO = r2;
            a = new DisplayMode[]{r0, r1, r2};
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) a.clone();
        }

        public static /* synthetic */ String access$000(DisplayMode r0) {
            return r0.value;
        }

        public static DisplayMode fromString(String r5) {
            if (r5 == null) goto L4;
            DisplayMode[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L12;
            DisplayMode r3 = r0[r2];
            if (r3.value.equals(r5) == true) goto L9;
            r2 = r2 + 1;
            goto L6
        L9:
            return r3;
        L12:
            return SURFACE;
        L4:
            return SURFACE;
        }

        public static DisplayMode valueOf(String r1) {
            return (DisplayMode) r27.a.a(DisplayMode.class, r1);
        }

        public DisplayMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public UIAnimaX() {
        throw null;
    }

    static {
        p = UIAnimaXPropsPrioritySetter.ExecutionPriority.LOW;
        q = UIAnimaXPropsPrioritySetter.ExecutionPriority.HIGH;
    }

    @Override // com.lynx.tasm.behavior.j
    public final void B() {
        if (this.l == false) goto L5;
        return;
    L5:
        AnimaXPlayer r0 = this.d;
        if (r0 == null) goto L9;
        r0.z(false, VisibilityState.BACKGROUND);
        return;
    }

    public final void O() {
        this.mView.post(new n(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final long getMemoryUsageBytes() {
        AnimaXPlayer r0 = this.d;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.q();
    }

    @Override // com.lynx.tasm.behavior.j
    public final void p() {
        if (this.l == false) goto L5;
        return;
    L5:
        AnimaXPlayer r0 = this.d;
        if (r0 == null) goto L9;
        r0.z(true, VisibilityState.BACKGROUND);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        AnimaXLog.b("UIAnimaX", "UIAnimaX destroy");
        x4a.g r0 = this.c;
        if (r0 == null) goto L5;
        r0.release();
    L8:
        this.c = null;
        this.d = null;
        return;
    L5:
        AnimaXPlayer r1 = this.d;
        if (r1 == null) goto L8;
        r1.s();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (this.e != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L9;
        int r0 = getBorderLeftWidth() + getPaddingLeft();
        int r1 = getBorderTopWidth() + getPaddingTop();
        int r2 = getBorderRightWidth() + getPaddingRight();
        int r3 = getBorderBottomWidth() + getPaddingBottom();
        this.e.setPadding(r0, r1, r2, r3);
        this.c.requestLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        AnimaXPlayer r0 = this.d;
        if (r0 == null) goto L6;
        r0.t();
        return;
    }

    public UIAnimaX(LynxContext r3) {
        super(r3, null);
        this.f = new UIAnimaXPropsPrioritySetter();
        this.g = false;
        this.h = false;
        this.i = DisplayMode.SURFACE;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = false;
        this.a = r3;
        if ((this.mView instanceof x4a.a) == true) goto L5;
        O();
    L5:
        this.e = (x4a.a) this.mView;
    }

    public static int[] M(ReadableMap r3) {
        ReadableArray r4 = r3.getArray("frames");
        if (r4 != null) goto L6;
        return null;
    L6:
        int[] r0 = new int[r4.size()];
        int r1 = 0;
    L8:
        if (r1 >= r4.size()) goto L10;
        r0[r1] = r4.getInt(r1);
        r1 = r1 + 1;
        goto L8
    L10:
        return r0;
    }

    public static void N(Callback r4) {
        if (r4 == null) goto L5;
        r4.invoke(new Object[]{1, "animax view is not inited."});
        return;
    }

    public final void P(final String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L20;
        LynxContext r0 = this.a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.enableEventReporter() == true) goto L10;
        return;
    L10:
        if (this.o == true) goto L23;
        ILynxTrailService r1 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if (r1 != null) goto L14;
        boolean r2 = false;
    L15:
        if (r2 == false) goto L24;
        this.o = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", this.a.getInstanceId(), new p(r3));
        return;
    L24:
        return;
    L14:
        r2 = "true".equals(r1.stringValueForTrailKey("enable_motion_ui_report"));
        goto L15
    L23:
        return;
    }

    public final void Q(String r3) {
        if (this.n == null) goto L5;
        return;
    L5:
        if (this.a != null) goto L7;
        return;
    L7:
        if (this.mView == 0) goto L16;
        if (r3 != null) goto L11;
        r3 = "unknown";
    L12:
        this.mView.setTag("url: " + v4a.a.a(this.a.getTemplateUrl()) + ", src: " + r3);
        return;
    L11:
        this.n = r3;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r3) {
        if ((r3 instanceof LynxContext) == true) goto L6;
        LLog.e("UIAnimaX", "context is not LynxContext, create AnimaXView fail");
        return new View(r3);
    L6:
        LynxAnimaX.inst().init();
        this.b = new o4a.b(this, (LynxContext) r3);
        return new x4a.a(r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchTouch(MotionEvent r5) {
        if (this.k == false) goto L16;
        if (this.c == null) goto L16;
        if (isUserInteractionEnabled() == false) goto L16;
        if (r5.getAction() != 0) goto L16;
        RectF r0 = com.lynx.tasm.behavior.ui.utils.h.f(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
        MotionEvent r1 = MotionEvent.obtain(r5);
        float r2 = r5.getRawX() - r0.left;
        float r3 = r5.getRawY() - r0.top;
        x4a.a r4 = this.e;
        if (r4 != null) goto L13;
        r1.setLocation(r2, r3);
    L14:
        this.c.d(r1);
        goto L16
    L13:
        r1.setLocation(r2 - r4.getPaddingLeft(), r3 - this.e.getPaddingTop());
    L16:
        return super.dispatchTouch(r5);
    }

    @LynxProp(name = "anti-aliasing")
    public void setAntiAliasing(final String r3) {
        this.f.a(new g(r3));
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(final boolean r3) {
        this.f.a(new l(r3));
    }

    @LynxProp(name = "display-mode")
    public void setDisplayMode(String r1) {
        this.i = DisplayMode.fromString(r1);
    }

    @LynxProp(name = "dynamic-resource")
    public void setDynamicResource(final boolean r3) {
        this.f.b(new i(r3), q);
    }

    @LynxProp(defaultBoolean = false, name = "enable-audio")
    public void setEnableAudio(final boolean r3) {
        this.f.b(new f(r3), q);
    }

    @LynxProp(name = "android-enable-screenshot")
    public void setEnableScreenshot(boolean r1) {
        this.m = r1;
    }

    @LynxProp(defaultInt = -1, name = "end-frame")
    public void setEndFrame(final int r3) {
        this.f.a(new v(r3));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.k = r3;
        return;
    L5:
        if (r2.containsKey("taplayers") == false) goto L7;
        r3 = true;
        goto L8
    }

    @LynxProp(name = "fps-event-interval")
    public void setFpsEventInterval(final int r3) {
        this.f.a(new x(r3));
    }

    @LynxProp(defaultBoolean = false, name = "ignore-attach-status")
    public void setIgnoreAttachStatus(boolean r2) {
        x4a.g r0 = this.c;
        if (r0 == null) goto L5;
        r0.setIgnoreAttachStatus(r2);
        return;
    L5:
        this.h = r2;
    }

    @LynxProp(defaultBoolean = false, name = "ignore-lynx-lifecycle")
    public void setIgnoreLynxLifecycle(boolean r1) {
        this.l = r1;
    }

    @LynxProp(name = "json")
    public void setJson(final String r3) {
        this.f.b(new q(this, r3), p);
    }

    @LynxProp(defaultBoolean = true, name = "keeplastframe")
    public void setKeepLastFrame(final boolean r3) {
        this.f.a(new d(r3));
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public void setLoop(final boolean r3) {
        this.f.a(new h(r3));
    }

    @LynxProp(defaultInt = 1, name = "loop-count")
    public void setLoopCount(final int r3) {
        this.f.a(new k(r3));
    }

    @LynxProp(name = "max-frame-rate")
    public void setMaxFrameRate(final double r3) {
        this.f.a(new a(r3));
    }

    @LynxProp(defaultBoolean = true, name = "multi-thread-accelerate")
    public void setMultiThreadAccelerate(boolean r1) {
        this.g = r1;
    }

    @LynxProp(defaultBoolean = false, name = "muted")
    public void setMuted(final boolean r3) {
        this.f.a(new b(r3));
    }

    @LynxProp(name = "objectfit")
    public void setObjectFit(final String r3) {
        this.f.a(new j(r3));
    }

    @LynxProp(name = "object-position")
    public void setObjectPosition(final String r3) {
        this.f.a(new c(r3));
    }

    @LynxProp(name = "progress")
    public void setProgress(final float r3) {
        this.f.a(new w(r3));
    }

    @LynxProp(defaultBoolean = false, name = "auto-reverse")
    public void setReverseMode(final boolean r3) {
        this.f.a(new t(r3));
    }

    @LynxProp(name = "speed")
    public void setSpeed(final float r3) {
        this.f.a(new s(r3));
    }

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSrc(final String r3) {
        this.f.b(new u(this, r3), p);
    }

    @LynxProp(name = "src-format")
    public void setSrcFormat(final String r3) {
        this.f.b(new o(this, r3), p);
    }

    @LynxProp(name = "src-polyfill")
    public void setSrcPolyfill(final ReadableMap r3) {
        if ((r3 instanceof JavaOnlyMap) == false) goto L5;
        this.f.b(new e(this, r3), q);
        return;
    L5:
        AnimaXLog.a("UIAnimaX", "setSrcPolyfill fail");
    }

    @LynxProp(defaultInt = 0, name = "start-frame")
    public void setStartFrame(final int r3) {
        this.f.a(new y(r3));
    }

    @LynxProp(name = "tag")
    public void setTag(String r3) {
        this.j = r3;
        ((ConcurrentHashMap) this.b.e.d).put("tag", r3);
    }

    @LynxProp(name = "video-frame-timeout")
    public void setVideoFrameTimeout(int r4) {
        o4a.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.d.c = r4;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(x0 r7) {
        super.updatePropertiesInterval(r7);
        boolean r0 = true;
        if (this.d != null) goto L15;
        o4a.b r8 = this.b;
        if (r8 == null) goto L15;
        AnimaXContext.a r2 = new AnimaXContext.a(r8, this.a.getContext());
        if (this.g == false) goto L12;
        String r9 = y4a.a.a;
        if ("HUAWEI".equals(Build.MANUFACTURER) == true) goto L12;
        boolean r10 = true;
    L13:
        r2.c = r10;
        AnimaXContext r11 = new AnimaXContext(r2);
        o4a.b r3 = this.b;
        ((ConcurrentHashMap) r3.c.a).put(IAnimaXMonitorService.class, new v4a.b(this.a));
        o4a.b r4 = this.b;
        ((ConcurrentHashMap) r4.c.a).put(w4a.b.class, new m(this));
        this.d = new AnimaXPlayer(r11);
        UIAnimaXPropsPrioritySetter r12 = this.f;
        AnimaXPlayer r5 = this.d;
        r12.getClass();
        r12.b = new WeakReference(r5);
    L12:
        r10 = false;
    L15:
        if (this.c != null) goto L50;
        o4a.b r13 = this.b;
        if (r13 != null) goto L19;
    L49:
        LLog.e("UIAnimaX", "LynxAbility or LynxContext is not created");
        O();
        goto L50
    L19:
        if (this.a == null) goto L49;
        if (this.e != null) goto L25;
        LLog.e("UIAnimaX", "AnimaXContainerView is not created");
        O();
        goto L50
    L25:
        if (this.d != null) goto L28;
        LLog.e("UIAnimaX", "AnimaXPlayer is not created");
        O();
        goto L50
    L28:
        if ((!y4a.a.d("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r13)) == true) goto L30;
        LLog.e("UIAnimaX", "Device is not support, create AnimaXView fail");
        O();
        goto L50
    L30:
        DisplayMode r14 = this.i;
        DisplayMode r6 = DisplayMode.IMAGE;
        if (r14 == r6) goto L45;
        if (r14 != DisplayMode.AUTO) goto L43;
        o4a.b r15 = this.b;
        String r16 = this.j;
        if (r16 != null) goto L37;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L43;
    L37:
        if (r16.isEmpty() == true) goto L40;
        r17 = y4a.a.e(y4a.a.b("ANIMAX_USE_IMAGE_VIEW_".concat(r16), r15));
    L43:
        r0 = false;
    L45:
        if (r0 == false) goto L47;
        AnimaXLog.b("UIAnimaX", "create AnimaXImageView");
        v4a.d r1 = this.b.e;
        ((ConcurrentHashMap) r1.d).put("display_mode", DisplayMode.access$000(r6));
        AnimaXImageView r18 = new AnimaXImageView(this.d);
        this.c = r18;
        this.e.a(r18, null);
    L48:
        this.c.setEnableTapLayerEvent(false);
        this.c.setIgnoreAttachStatus(this.h);
        goto L50
    L47:
        AnimaXLog.b("UIAnimaX", "create AnimaXView");
        v4a.d r19 = this.b.e;
        ((ConcurrentHashMap) r19.d).put("display_mode", DisplayMode.access$000(DisplayMode.SURFACE));
        AnimaXView r20 = new AnimaXView(this.d);
        this.c = r20;
        this.e.a(r20, new a0(this));
    L50:
        UIAnimaXPropsPrioritySetter r21 = this.f;
        AnimaXPlayer r22 = r21.b.get();
        if (r22 != null) goto L54;
        return;
    L54:
        if (r21.a.isEmpty() == true) goto L69;
        UIAnimaXPropsPrioritySetter.b r23 = r21.a.poll();
        if (r23 == null) goto L54;
        r23.a.a(r22);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        AnimaXLog.a("UIAnimaXPropsPrioritySetter", "Failed to run pending tasks with exception: " + e.getMessage());
        goto L54
    }

    public void getCurrentFrame(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        if (r4 == null) goto L9;
        r4.invoke(new Object[]{0, Double.valueOf(this.d.getCurrentFrame())});
        return;
    }

    public void getDuration(ReadableMap r4, Callback r5) {
        if (this.d != null) goto L6;
        N(r5);
        return;
    L6:
        if (r5 == null) goto L9;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.putDouble(LynxResourceModule.DATA_KEY, this.d.getDurationMs());
        r5.invoke(new Object[]{0, r6});
        return;
    }

    public void isAnimating(ReadableMap r4, Callback r5) {
        if (this.d != null) goto L6;
        N(r5);
        return;
    L6:
        if (r5 == null) goto L9;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.putBoolean(LynxResourceModule.DATA_KEY, this.d.isAnimating());
        r5.invoke(new Object[]{0, r6});
        return;
    }

    public void listenAnimationUpdate(ReadableMap r4, Callback r5) {
        o4a.b r0 = this.b;
        if (r0 != null) goto L6;
        N(r5);
        return;
    L6:
        if (r4 == null) goto L8;
        r0.h = r4.getBoolean("isListen");
    L8:
        if (r5 == null) goto L11;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.putBoolean(LynxResourceModule.DATA_KEY, this.b.h);
        r5.invoke(new Object[]{0, r6});
        return;
    }

    public void pause(ReadableMap r3, Callback r4) {
        AnimaXPlayer r5 = this.d;
        if (r5 != null) goto L6;
        N(r4);
        return;
    L6:
        r5.pause();
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void play(ReadableMap r3, Callback r4) {
        AnimaXPlayer r5 = this.d;
        if (r5 != null) goto L6;
        N(r4);
        return;
    L6:
        r5.play();
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void playSegment(ReadableMap r5, Callback r6) {
        if (this.d != null) goto L6;
        N(r6);
        return;
    L6:
        int r0 = r5.getInt("startFrame");
        int r7 = r5.getInt("endFrame");
        if (r7 <= 0) goto L12;
        if (r0 <= r7) goto L12;
        if (r6 == null) goto L16;
        r6.invoke(new Object[]{1, "startFrame and endFrame are not valid!"});
        return;
    L16:
        return;
    L12:
        this.d.r(r0, r7);
        if (r6 == null) goto L17;
        r6.invoke(new Object[]{0});
        return;
    }

    public void resume(ReadableMap r3, Callback r4) {
        AnimaXPlayer r5 = this.d;
        if (r5 != null) goto L6;
        N(r4);
        return;
    L6:
        r5.resume();
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void seek(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        this.d.a(r3.getInt("frame"));
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void stop(ReadableMap r3, Callback r4) {
        AnimaXPlayer r5 = this.d;
        if (r5 != null) goto L6;
        N(r4);
        return;
    L6:
        r5.v();
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void subscribeUpdateEvent(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        this.d.w(r3.getInt("frame"));
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void subscribeUpdateEvents(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        int[] r5 = M(r3);
        if (r5 != null) goto L10;
        N(r4);
        return;
    L10:
        this.d.b(r5, true);
        if (r4 == null) goto L14;
        r4.invoke(new Object[]{0});
        return;
    }

    public void unsubscribeUpdateEvent(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        this.d.x(r3.getInt("frame"));
        if (r4 == null) goto L10;
        r4.invoke(new Object[]{0});
        return;
    }

    public void unsubscribeUpdateEvents(ReadableMap r3, Callback r4) {
        if (this.d != null) goto L6;
        N(r4);
        return;
    L6:
        int[] r5 = M(r3);
        if (r5 != null) goto L10;
        N(r4);
        return;
    L10:
        this.d.b(r5, false);
        if (r4 == null) goto L14;
        r4.invoke(new Object[]{0});
        return;
    }
}
