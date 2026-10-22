package androidx.fragment.app;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.room.InvalidationTracker;
import com.bytedance.ai.applet.render.core.relax.RelaxViewAIBridgePort$RTSInterface;
import com.bytedance.ai.model.widgets.LynxViewFloatingPage;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.android.monitorV2.forest.ForestMonitorHelper;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;
import com.lynx.animax.UIAnimaX;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.r;
import com.obric.clockwidgets.ui.SquareClockView;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import com.obric.flow.cardlistpage.data.MiniAppWidgetCardModel;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.s;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.ControllerState;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.b0;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.u;
import com.obric.launcher.widget.R$id;
import com.obric.oui.banner.OBanner;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.text.OTextView;
import com.relax.RelaxView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.i2;
import obric.flow.miniappwidget.l;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f531b;

    public /* synthetic */ d(Object r5, int r10) {
        this.f530a = r10;
        this.f531b = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v73, types: [java.lang.Object, kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        Object r5 = null;
        int r10 = 0;
        switch(this.f530a) {
            case 0: goto L236;
            case 1: goto L234;
            case 2: goto L232;
            case 3: goto L230;
            case 4: goto L225;
            case 5: goto L212;
            case 6: goto L203;
            case 7: goto L201;
            case 8: goto L187;
            case 9: goto L185;
            case 10: goto L181;
            case 11: goto L173;
            case 12: goto L171;
            case 13: goto L144;
            case 14: goto L142;
            case 15: goto L140;
            case 16: goto L138;
            case 17: goto L136;
            case 18: goto L134;
            case 19: goto L130;
            case 20: goto L128;
            case 21: goto L124;
            case 22: goto L122;
            case 23: goto L120;
            case 24: goto L38;
            case 25: goto L32;
            case 26: goto L10;
            case 27: goto L8;
            case 28: goto L6;
            default: goto L4;
        };
    L4:
        ((com.obric.oui.common.style.h) this.f531b).f12477b = true;
        return;
    L6:
        int r11 = OBanner.A;
        OBanner r15 = (OBanner) this.f531b;
        Intrinsics.checkNotNullParameter(r15, "this$0");
        r15.e();
        return;
    L8:
        com.obric.flow.cardlistpage.util.a r16 = (com.obric.flow.cardlistpage.util.a) this.f531b;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        r16.a();
        return;
    L10:
        com.obric.flow.cardlistpage.ui.view.i r17 = (com.obric.flow.cardlistpage.ui.view.i) this.f531b;
        Intrinsics.checkNotNullParameter(r17, "this$0");
        int r12 = r17.getWidth();
        int r13 = r17.getHeight();
        if (r12 <= 0) goto L263;
        if (r13 <= 0) goto L266;
        Size r14 = new Size(r12, r13);
        if (Intrinsics.areEqual(r17.f, r14) == true) goto L267;
        r17.f = r14;
        int r18 = com.lynx.tasm.utils.a.y(r17.getContext(), r13);
        OTextView r19 = r17.e;
        if (r19 != null) goto L20;
        int r20 = 0;
    L21:
        LinearLayout r21 = r17.d;
        if (r21 == null) goto L26;
        if (r18 <= 650) goto L25;
        r21.setPadding(0, (int) (r14.getHeight() * 0.135f), 0, (int) ((r14.getHeight() * 0.10375f) - r20));
        goto L26
    L25:
        r21.setPadding(0, androidx.room.jarjarred.org.antlr.runtime.a.a(20, 1), 0, androidx.room.jarjarred.org.antlr.runtime.a.a(12, 1));
    L26:
        RecyclerView r110 = r17.f11854b;
        if (r110 == null) goto L264;
        if (r18 <= 650) goto L30;
        float r22 = 16;
        r110.setPadding(0, androidx.room.jarjarred.org.antlr.runtime.a.a(r22, 1), 0, androidx.room.jarjarred.org.antlr.runtime.a.a(r22, 1));
        return;
    L30:
        r110.setPadding(0, 0, 0, 0);
        return;
    L264:
        return;
    L20:
        r19.measure(View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(r14.getWidth() - (MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())) * 2), 0), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        r20 = r19.getLineHeight() * (RangesKt.coerceAtLeast(r19.getLineCount(), 1) - 1);
        goto L21
    L267:
        return;
    L266:
        return;
    L263:
        return;
    L32:
        p r111 = (p) this.f531b;
        Intrinsics.checkNotNullParameter(r111, "this$0");
        if (r111.f11694n == ControllerState.HIDDEN) goto L35;
        return;
    L35:
        if (((Boolean) ((u) ((com.obric.flow.cardlistpage.mvi.a) r111.f11531a).b()).f11708h.getValue()).booleanValue() == false) goto L269;
        r111.d(new b0(false));
        return;
    L269:
        return;
    L38:
        s r112 = (s) this.f531b;
        Intrinsics.checkNotNullParameter(r112, "this$0");
        r112.f11610r = false;
        long r23 = r112.w();
        if (r23 <= 0) goto L41;
        r112.v(r23);
        return;
    L41:
        long r24 = r112.w();
        if (r24 <= 0) goto L44;
        r112.v(r24);
        return;
    L44:
        List r25 = r112.f11602j.f7569a;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L46:
        if (r27.hasNext() == false) goto L50;
        Object r28 = r27.next();
        if ((r28 instanceof MiniAppWidgetCardModel) == false) goto L46;
        r26.add(r28);
        goto L46
    L50:
        Iterator r29 = r26.iterator();
    L52:
        if (r29.hasNext() == false) goto L271;
        MiniAppWidgetCardModel r30 = (MiniAppWidgetCardModel) r29.next();
        if (r112.f11600h.f20496j.get() == false) goto L91;
        Iterator r31 = r112.f11602j.f7569a.iterator();
        int r32 = 0;
    L57:
        if (r31.hasNext() == false) goto L69;
        Object r33 = r31.next();
        if ((r33 instanceof BaseCardModel) == false) goto L61;
        BaseCardModel r34 = (BaseCardModel) r33;
    L62:
        if (r34 == null) goto L64;
        String r35 = r34.getId();
    L66:
        if (Intrinsics.areEqual(r35, r30.getId()) == true) goto L70;
        r32 = r32 + 1;
    L70:
        if (r32 != (-1)) goto L72;
    L71:
        boolean r36 = false;
    L89:
        if (r36 == false) goto L91;
        boolean r37 = true;
    L92:
        l r38 = r112.f11600h;
        String r39 = r30.getInstanceId();
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "instanceId");
        obric.flow.miniappwidget.a r40 = (obric.flow.miniappwidget.a) r38.f.get(r39);
        if (r40 != null) goto L95;
        boolean r41 = false;
    L112:
        String r42 = r112.f11600h.f20491a;
        String r43 = r30.getId();
        String r113 = r30.getInstanceId();
        String r114 = r30.getAppletId();
        String r44 = r30.getWidgetId();
        StringBuilder r45 = androidx.constraintlayout.motion.widget.a.y("miniAppWidget visibility hostId=", r42, " cardId=", r43, " instanceId=");
        androidx.constraintlayout.motion.widget.a.C(r45, r113, " appletId=", r114, " widgetId=");
        r45.append(r44);
        r45.append(" visible=");
        r45.append(r37);
        r45.append(" dispatched=");
        r45.append(r41);
        String r46 = r45.toString();
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r46, "msg");
        org.koin.core.a r47 = su.a.f22013b;
        if (r47 == null) goto L116;
        ((ju.b) r47.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FeedListComponent", r46);
        goto L52
    L116:
        throw new IllegalStateException("KoinApplication has not been started");
    L95:
        monitor-enter(r40);
        if (Intrinsics.areEqual(r40.f20462k, Boolean.valueOf(r37)) == false) goto L100;
        monitor-exit(r40);
        r41 = true;
        goto L112
    L100:
        Boolean r48 = r40.f20462k;     // Catch: Throwable -> L103
        if (r37 == false) goto L105;
        r40.f20462k = Boolean.TRUE;     // Catch: Throwable -> L103
    L105:
        if (r37 == false) goto L107;
        r41 = r40.e();     // Catch: Throwable -> L103
    L108:
        if (r41 == false) goto L110;
        r40.f20462k = Boolean.valueOf(r37);     // Catch: Throwable -> L103
    L111:
        monitor-exit(r40);
        goto L112
    L110:
        r40.f20462k = r48;     // Catch: Throwable -> L103
        goto L111
    L107:
        r41 = r40.d();     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        throw th;
    L72:
        androidx.recyclerview.widget.RecyclerView r49 = r112.e;
        androidx.recyclerview.widget.RecyclerView.ViewHolder r50 = r49.findViewHolderForAdapterPosition(r32);
        if (r50 == null) goto L71;
        View r51 = r50.itemView;
        if (r51.isShown() == false) goto L71;
        if (r51.getWidth() <= 0) goto L71;
        if (r51.getHeight() <= 0) goto L71;
        Rect r52 = r112.f11609q;
        if (r49.getGlobalVisibleRect(r52) == false) goto L71;
        Rect r53 = r112.f11608p;
        if (r51.getGlobalVisibleRect(r53) == false) goto L71;
        r36 = r53.intersect(r52);
        goto L89
    L64:
        r35 = null;
        goto L66
    L61:
        r34 = null;
        goto L62
    L69:
        r32 = -1;
    L91:
        r37 = false;
        goto L92
    L271:
        return;
    L120:
        ?? r115 = (Lambda) this.f531b;
        Intrinsics.checkNotNullParameter(r115, "$endFun");
        r115.invoke();
        return;
    L122:
        int r54 = CardFeedLayout.f11536c0;
        hq.h r116 = (hq.h) this.f531b;
        Intrinsics.checkNotNullParameter(r116, "$effect");
        i2 r55 = obric.flow.externalcard.a.f20437a;
        hq.a r117 = (hq.a) r116;
        obric.flow.externalcard.a.a(r117.f17357a, r117.f17358b);
        return;
    L124:
        int r56 = CardFeedLayout.f11536c0;
        CardFeedLayout r118 = (CardFeedLayout) this.f531b;
        Intrinsics.checkNotNullParameter(r118, "this$0");
        if (r118.f11546l == true) goto L272;
        r118.f11547m = false;
        return;
    L272:
        return;
    L128:
        SquareClockView.a((SquareClockView) this.f531b);
        return;
    L130:
        LynxTemplateRender r119 = (LynxTemplateRender) this.f531b;
        r119.v0();
        UIBody.UIBodyView r120 = r119.f10041v;
        if (r120 == null) goto L273;
        r120.removeAllViews();
        return;
    L273:
        return;
    L134:
        UIAnimaX r121 = (UIAnimaX) this.f531b;
        r r57 = r121.f9558a.g;
        int r122 = r121.getSign();
        HashMap r58 = new HashMap();
        r58.put("code", 5);
        r58.put("msg", "The device is not support.");
        r57.b(new com.lynx.animax.i(r58, "error", r122, 0));
        return;
    L136:
        ((MaterialBackOrchestrator) this.f531b).startListeningForBackCallbacksWithPriorityOverlay();
        return;
    L138:
        DateSelector.a((EditText) this.f531b);
        return;
    L140:
        CarouselLayoutManager.a((CarouselLayoutManager) this.f531b);
        return;
    L142:
        BottomAppBar.a((View) this.f531b);
        return;
    L144:
        ((com.bytedance.android.monitorV2.h) this.f531b).getClass();
        Class<?> r59 = Class.forName("com.bytedance.webx.monitor.weboffline.NewWebOfflineMonitor");     // Catch: Throwable -> L147 ClassNotFoundException -> L149
        sj.g.i(r59, "beginMonitor", new Object[]{sj.g.i(r59, "getInstance", new Object[0])});     // Catch: Throwable -> L147 ClassNotFoundException -> L149
    L244:
        Class<?> r60 = Class.forName("com.bytedance.webx.monitor.falconx.NewFalconXMonitor");     // Catch: Throwable -> L152 ClassNotFoundException -> L154
        sj.g.i(r60, "beginMonitor", new Object[]{sj.g.i(r60, "getInstance", new Object[0])});     // Catch: Throwable -> L152 ClassNotFoundException -> L154
    L250:
        ForestMonitorHelper r61 = ForestMonitorHelper.INSTANCE;     // Catch: Throwable -> L158 ClassNotFoundException -> L169
        Field r62 = ForestMonitorHelper.class.getDeclaredField("INSTANCE");     // Catch: Throwable -> L158 IllegalAccessException -> L160 NoSuchFieldException -> L162 ClassNotFoundException -> L169
        r62.setAccessible(true);     // Catch: Throwable -> L158 IllegalAccessException -> L160 NoSuchFieldException -> L162 ClassNotFoundException -> L169
        r5 = r62.get(null);     // Catch: Throwable -> L158 IllegalAccessException -> L160 NoSuchFieldException -> L162 ClassNotFoundException -> L169
    L166:
        sj.g.i(ForestMonitorHelper.class, "startMonitor", new Object[]{r5});     // Catch: Throwable -> L158 ClassNotFoundException -> L169
    L275:
        return;
    L160:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L158 ClassNotFoundException -> L169
    L162:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L158 ClassNotFoundException -> L169
    L169:
        d5.b.f("HybridMultiMonitor", "Not Found ForestMonitorHelper");
        return;
    L158:
        th = move-exception;
        mn.h.g("startup_handle", th);
        return;
    L154:
        d5.b.f("HybridMultiMonitor", "Not Found NewFalconXMonitor");
    L152:
        th = move-exception;
        mn.h.g("startup_handle", th);
        goto L250
    L149:
        d5.b.f("HybridMultiMonitor", "Not Found NewWebOfflineMonitor");
    L147:
        th = move-exception;
        mn.h.g("startup_handle", th);
        goto L244
    L171:
        com.bytedance.ai.utils.c.g(((AppletWidgetContainer) this.f531b).f3019b, Lifecycle.Event.ON_DESTROY);
        return;
    L173:
        LynxViewFloatingPage r123 = (LynxViewFloatingPage) this.f531b;
        com.bytedance.ai.lynx.g r63 = r123.e;
        if (r63 == null) goto L176;
        r63.setTag(R$id.applet_ai_container_tag, null);
    L176:
        com.bytedance.ai.lynx.g r64 = r123.e;
        if (r64 == null) goto L179;
        r64.destroy();
    L179:
        r123.e = null;
        r123.j(r123.f2302h, Lifecycle.Event.ON_DESTROY);
        return;
    L181:
        com.bytedance.ai.model.widgets.a r124 = (com.bytedance.ai.model.widgets.a) this.f531b;
        m1.i r65 = r124.f2329a.r();
        if (r65 == null) goto L276;
        JsonObject r66 = new JsonObject();
        r66.addProperty("viewId", r124.f2331c);
        Unit r125 = Unit.INSTANCE;
        r65.e("onPageOpened", r66);
        return;
    L276:
        return;
    L185:
        RelaxViewAIBridgePort$RTSInterface.a((RelaxView) this.f531b);
        return;
    L187:
        int r67 = FirstFrameAwareSurfaceTexture.f9607h;
        FirstFrameAwareSurfaceTexture r126 = (FirstFrameAwareSurfaceTexture) ((WeakReference) this.f531b).get();
        if (r126 == null) goto L199;
        AnimaXLog.LogLevel r68 = AnimaXLog.LogLevel.f9713a;
        AnimaXLog.a(r68, "AnimaXFirstFrameAwareSurfaceTexture", "clearInternalFrameRateListenerAsync: Executing cleanup");
        if (Build.VERSION.SDK_INT >= 35) goto L193;
        return;
    L193:
        if (r126.c() == false) goto L238;
        AnimaXLog.a(r68, "AnimaXFirstFrameAwareSurfaceTexture", "setNullOnSetFrameRateListener fail, handler is already null.");
        return;
    L238:
        Method r69 = SurfaceTexture.class.getMethod("setOnSetFrameRateListener", new Class[]{Class.forName("android.graphics.SurfaceTexture$OnSetFrameRateListener"), Handler.class});     // Catch: Throwable -> L197
        r69.setAccessible(true);     // Catch: Throwable -> L197
        r69.invoke(r126, new Object[]{null, null});     // Catch: Throwable -> L197
        AnimaXLog.a(r68, "AnimaXFirstFrameAwareSurfaceTexture", "setNullOnSetFrameRateListener result: " + r126.c());     // Catch: Throwable -> L197
        return;
    L197:
        th = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXFirstFrameAwareSurfaceTexture", androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("setNullOnSetFrameRateListener fail: ")));
        return;
    L199:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "clearInternalFrameRateListenerAsync: Skipped, reference lost");
        return;
    L201:
        int r70 = FirstFrameAwareSurfaceTexture.f9607h;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "Triggering layer update via opacity toggle");
        TextureView r127 = (TextureView) this.f531b;
        boolean r71 = r127.isOpaque();
        r127.setOpaque(!r71);
        r127.setOpaque(r71);
        return;
    L203:
        jk.a r128 = (jk.a) this.f531b;
        r128.getClass();
        r128.f18349a = new LocalServerSocket("JsEngine_" + kk.a.e() + "_devtools_remote");     // Catch: IOException -> L209
        r128.f18351c = r128.g();     // Catch: IOException -> L209
    L206:
        if (Thread.interrupted() == true) goto L281;
        ck.c r72 = new ck.c(r128, ((LocalServerSocket) r128.f18349a).accept());     // Catch: IOException -> L209
        r72.setName("LocalSocketServer_WorkerThread_" + ((AtomicInteger) r128.f18350b).incrementAndGet());     // Catch: IOException -> L209
        r72.setDaemon(true);     // Catch: IOException -> L209
        r72.start();     // Catch: IOException -> L209
        goto L206
    L281:
        return;
    L209:
        e = move-exception;
        Log.e("LocalSocketServer", e.getMessage());
        return;
    L212:
        BaseLynxViewPager r129 = (BaseLynxViewPager) this.f531b;
        Intrinsics.checkNotNullParameter(r129, "this$0");
        TabLayout r73 = r129.j().getMTabLayout();
        if (r73 == null) goto L215;
        Integer r74 = Integer.valueOf(r73.getSelectedTabPosition());
    L216:
        TabLayout r75 = r129.j().getMTabLayout();
        if (r75 == null) goto L221;
        if (r74 == null) goto L220;
        r10 = r74.intValue();
    L220:
        r5 = r75.getTabAt(r10);
    L221:
        bf.c r130 = r129.g;
        if (r130 == null) goto L282;
        r130.onTabSelected(r5);
        return;
    L282:
        return;
    L215:
        r74 = null;
        goto L216
    L225:
        float[] r76 = PrivacyTopDownAlphaMaskRecyclerView.b1;
        PrivacyTopDownAlphaMaskRecyclerView r131 = (PrivacyTopDownAlphaMaskRecyclerView) this.f531b;
        Intrinsics.checkNotNullParameter(r131, "this$0");
        if (r131.G0 == false) goto L228;
        r131.Z0 = false;
        r131.b0(false);
        return;
    L228:
        r131.J0 = 1.0f;
        r131.K0 = 1.0f;
        r131.a0();
        r131.invalidate();
        return;
    L230:
        InvalidationTracker.a((InvalidationTracker) this.f531b);
        return;
    L232:
        ProcessLifecycleOwner.a((ProcessLifecycleOwner) this.f531b);
        return;
    L234:
        Fragment.a((Fragment) this.f531b);
        return;
    L236:
        DefaultSpecialEffectsController.g((ArrayList) this.f531b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ d(Function0 r5) {
        this.f530a = 23;
        this.f531b = (Lambda) r5;
    }
}
