package com.bytedance.ai.widget.contianer;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import com.bytedance.ai.applet.app.foundation.performance.PendingWidgetPerformanceTracker;
import com.bytedance.ai.applet.app.foundation.performance.s;
import com.bytedance.ai.applet.app.foundation.performance.v;
import com.bytedance.ai.applet.app.foundation.performance.x;
import com.bytedance.ai.applet.app.view.AppletThemeMode;
import com.bytedance.ai.applet.components.view.RenderViewFactory;
import com.bytedance.ai.applet.db.WidgetContextHelper;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.ai.applet.render.core.lynx.LynxRenderView;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$Gravity;
import com.bytedance.ai.lynx.q;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.settings.provider.LynxThreadStrategy;
import com.bytedance.ai.settings.provider.WidgetReusedSettings;
import com.bytedance.ai.utils.LifecycleRegistryExtKt;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.widget.WidgetRenderType;
import com.bytedance.ai.widget.cache.WidgetResourceLoader;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import d3.a0;
import d3.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import m5.i1;
import m5.k0;
import m5.l0;
import m5.v0;
import m5.w;
import m5.w0;
import m5.y0;
import org.json.JSONException;
import org.json.JSONObject;
import t5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0003\u001f\"%\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020.H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000201H\u0016J\u001e\u00103\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0086@¢\u0006\u0002\u00108J\u001a\u00109\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\tH\u0002J\u001e\u0010;\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\tH\u0083@¢\u0006\u0002\u0010<J\b\u0010=\u001a\u000201H\u0002J&\u0010>\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010@J \u0010A\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0018\u0010B\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000bH\u0002J\u001e\u0010C\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010E0D2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020,H\u0002J\u0012\u0010K\u001a\u0002012\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010N\u001a\u0002012\u0006\u00104\u001a\u000205H\u0016J\u001c\u0010O\u001a\u0002012\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020E0DH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006R"}, d2 = {"Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer;", "Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "widgetBoxView", "Lcom/bytedance/ai/widget/view/WidgetBoxView;", "widgetLoader", "Lcom/bytedance/ai/widget/cache/IWidgetResourceLoader;", "widgetRenderView", "Lcom/bytedance/ai/applet/render/core/RenderView;", "createWidgetJob", "Lkotlinx/coroutines/Job;", "widget", "Lcom/bytedance/ai/model/objects/Widget;", "widgetMonitorInfo", "Lcom/bytedance/ai/widget/WidgetMonitorInfo;", "renderViewReusedPool", "Lcom/bytedance/ai/applet/render/core/reuse/RenderViewReusedPool;", "viewHeight", "", "logger", "Lcom/bytedance/ai/applet/base/log/TraceLogger;", "widgetPerformanceTracker", "Lcom/bytedance/ai/applet/app/foundation/performance/WidgetPerformanceTracker;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "focusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "attachStateChangeListener", "com/bytedance/ai/widget/contianer/AppletWidgetContainer$attachStateChangeListener$1", "Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer$attachStateChangeListener$1;", "widgetTouchEventListener", "com/bytedance/ai/widget/contianer/AppletWidgetContainer$widgetTouchEventListener$1", "Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer$widgetTouchEventListener$1;", "viewClient", "com/bytedance/ai/widget/contianer/AppletWidgetContainer$viewClient$1", "Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer$viewClient$1;", "renderType", "Lcom/bytedance/ai/widget/WidgetRenderType;", "getRenderType", "()Lcom/bytedance/ai/widget/WidgetRenderType;", "getCardId", "", "realView", "Landroid/view/View;", "engineView", "onCreated", "", "onHostDestroy", "bindData", "widgetContainerData", "Lcom/bytedance/ai/widget/contianer/WidgetContainerData;", "pendingTracker", "Lcom/bytedance/ai/applet/app/foundation/performance/PendingWidgetPerformanceTracker;", "(Lcom/bytedance/ai/widget/contianer/WidgetContainerData;Lcom/bytedance/ai/applet/app/foundation/performance/PendingWidgetPerformanceTracker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRenderView", "resourceLoader", "bindDataByType", "(Lcom/bytedance/ai/model/objects/Widget;Lcom/bytedance/ai/widget/cache/IWidgetResourceLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindLongPressController", "renderByNewView", "renderView", "(Lcom/bytedance/ai/model/objects/Widget;Lcom/bytedance/ai/widget/cache/IWidgetResourceLoader;Lcom/bytedance/ai/applet/render/core/RenderView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderByReusedView", "initBridge", "getViewContext", "", "", "getWidgetData", "Lorg/json/JSONObject;", "widgetInNoTitleBL", "", "widgetId", "updateStyle", "config", "Lcom/bytedance/ai/model/objects/WidgetConfig;", "updateData", "updateGlobal", "props", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletWidgetContainer extends WidgetContainer {
    public static final /* synthetic */ int O = 0;
    public com.bytedance.ai.widget.cache.b A;
    public w2.a B;
    public Job C;
    public Widget D;
    public com.bytedance.ai.widget.m E;
    public x2.a F;
    public int G;
    public final com.bytedance.ai.applet.base.log.i H;
    public x I;
    public final com.bytedance.ai.widget.contianer.b J;
    public final com.bytedance.ai.widget.contianer.c K;
    public final c L;
    public final f M;
    public final e N;
    public final Context y;
    public final WidgetBoxView z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderType.values().length];
            r0[RenderType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RenderType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ AppletWidgetContainer a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
        }

        public c(AppletWidgetContainer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            i1 r11 = y0.a;
            y0.p(this.a.A(), "applet_widget_timeline_full", false);
        }
    }

    public static final class d extends ViewOutlineProvider {
        public final /* synthetic */ AppletWidgetContainer a;

        public d(AppletWidgetContainer r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r10, Outline r11) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r11 != null) goto L6;
            return;
        L6:
            int r12 = r10.getWidth();
            int r13 = r10.getHeight();
            h5.j r14 = this.a.j;
            if (r14 == null) goto L9;
            float r15 = r14.d;
        L10:
            r11.setRoundRect(0, 0, r12, r13, r15);
            return;
        L9:
            r15 = 0.0f;
            goto L10
        }
    }

    public static final class e implements w2.b {
        public final /* synthetic */ AppletWidgetContainer a;

        public e(AppletWidgetContainer r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [int] */
        @Override // w2.b
        public final void a(w2.a r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.H.c("onDidReadResource " + r11);
            i1 r12 = y0.a;
            String r13 = this.a.A();
            w2.a r14 = this.a.B;
            if (r14 == null) goto L5;
            ?? r15 = r14.d();
        L6:
            Map r16 = MapsKt.mapOf(TuplesKt.to("isReused", Integer.valueOf(r15)));
            Intrinsics.checkNotNullParameter(r13, "traceId");
            Intrinsics.checkNotNullParameter(r16, "eventInfo");
            y0.r(new w(r13, System.currentTimeMillis(), r16));
            x r17 = this.a.I;
            if (r17 == null) goto L10;
            r17.m();
            return;
        L10:
            return;
        L5:
            r15 = 0;
            goto L6
        }

        @Override // w2.b
        public final void c(LynxRenderView r10, Map r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.a.H.c("onTimingSetup " + this + ' ' + r11);
            i1 r12 = y0.a;
            String r13 = this.a.A();
            if (r11 == null) goto L5;
            Map r1 = MapsKt.toMutableMap(r11);
        L6:
            y0.n(r13, r1, "applet_widget_timeline_full");
            x r14 = this.a.I;
            if (r11 != null) goto L10;
            if (r14 == null) goto L12;
            r14.c(AppletPerformanceErrorCode.INVALID_RENDER_TIMING, "timingInfo is missing");
        L12:
            AppletWidgetContainer r15 = this.a;
            r15.I = null;
            com.bytedance.ai.widget.m r16 = r15.E;
            if (r16 == null) goto L17;
            com.bytedance.ai.widget.l r17 = y0.d;
            if (r17 == null) goto L17;
            r17.c(r16);
        L17:
            this.a.E = null;
            return;
        L10:
            if (r14 == null) goto L12;
            r14.o(r11);
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        @Override // w2.b
        public final void d(w2.a r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.H.c("onPageStart ".concat(r11));
            this.a.r(WidgetContainer.LifecycleEvent.ON_LOAD_START);
        }

        @Override // w2.b
        public final void e(w2.a r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.H.c("onPageFinished ".concat(r11));
            this.a.r(WidgetContainer.LifecycleEvent.ON_LOAD_FINISHED);
        }

        @Override // w2.b
        public final void g(w2.a r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.H.c("onWillReadResource " + r11);
            i1 r12 = y0.a;
            y0.c(this.a.A());
            x r13 = this.a.I;
            if (r13 == null) goto L6;
            r13.n();
            return;
        }

        @Override // w2.b
        public final void b(LynxRenderView r10, Map r11, Map r12, final String r13) {
            Intrinsics.checkNotNullParameter(r10, "view");
            i1 r14 = y0.a;
            final String r15 = this.a.A();
            final Map r0 = null;
            if (r11 == null) goto L5;
            final Map r16 = MapsKt.toMutableMap(r11);
        L6:
            if (r12 == null) goto L8;
            r0 = MapsKt.toMutableMap(r12);
        L8:
            Intrinsics.checkNotNullParameter(r15, "traceId");
            Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
            if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L12;
            y0.r(new k0(r15, r16, r0, r13));
            return;
        L12:
            if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L16;
            y0.r(new l0(r15, r16, r0, r13));
            return;
        L16:
            return;
        L5:
            r16 = null;
            goto L6
        }

        @Override // w2.b
        public final void f(w2.a r10, boolean r11, int r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r13, "errorMsg");
            this.a.H.b("onReceivedError, isFatal = " + r11 + ", errorCode = " + r12 + ", errorMsg = " + r13, null);
            if (r11 == false) goto L19;
            this.a.r(WidgetContainer.LifecycleEvent.ON_LOAD_ERROR);
            i1 r14 = y0.a;
            y0.b(this.a.A(), r13, r12, "applet_widget_timeline_full");
            x r15 = this.a.I;
            if (r15 == null) goto L9;
            boolean r16 = true;
            if (r15.c(AppletPerformanceErrorCode.WIDGET_RENDER_ERROR, "sourceErrorCode=" + r12 + ", " + r13) != true) goto L9;
        L10:
            if (r16 == false) goto L12;
            this.a.I = null;
        L12:
            com.bytedance.ai.widget.m r17 = this.a.E;
            if (r17 == null) goto L17;
            com.bytedance.ai.widget.l r18 = y0.d;
            if (r18 == null) goto L17;
            r18.b(r17, r13);
        L17:
            this.a.E = null;
            return;
        L9:
            r16 = false;
            goto L10
        }
    }

    public static final class f implements w2.a.c {
        public final /* synthetic */ AppletWidgetContainer a;

        public static final class a implements k5.j {
            public final /* synthetic */ AppletWidgetContainer a;

            public a(AppletWidgetContainer r1) {
                this.a = r1;
            }

            @Override // k5.j
            public final void a(AppletMonitorableEvent r10) {
                Intrinsics.checkNotNullParameter(r10, "event");
                AppletWidgetContainer r0 = this.a;
                m r1 = r0.g;
                String r11 = null;
                if (r1 == null) goto L5;
                String r12 = r1.a;
            L6:
                r10.f = r12;
                if (r1 == null) goto L9;
                r11 = r1.b;
            L9:
                r10.g = r11;
                w2.a r13 = r0.B;
                if (r13 == null) goto L20;
                int r14 = b.a[r13.getRenderType().ordinal()];
                if (r14 != 1) goto L14;
                WidgetRenderType r15 = WidgetRenderType.WEBVIEW;
            L19:
                if (r15 == null) goto L20;
            L21:
                r10.f("renderType", r15.getType());
                r10.f("message_id", this.a.A());
                m r16 = this.a.g;
                if (r16 == null) goto L25;
                String r17 = r16.d;
                if (r17 == null) goto L25;
            L26:
                r10.f("botId", r17);
                return;
            L25:
                r17 = "";
                goto L26
            L14:
                if (r14 != 2) goto L17;
                r15 = WidgetRenderType.LYNX;
                goto L19
            L17:
                throw new NoWhenBranchMatchedException();
            L20:
                r15 = WidgetRenderType.UNKNOWN;
                goto L21
            L5:
                r12 = null;
                goto L6
            }
        }

        public f(AppletWidgetContainer r1) {
            this.a = r1;
        }

        @Override // w2.a.c
        public final void onTouchEvent(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "ev");
            if (r10.getAction() != 1) goto L6;
            AtomicBoolean r11 = com.bytedance.ai.monitor.b.a;
            com.bytedance.ai.monitor.b.d("widget_click", new a(this.a));
            return;
        }
    }

    static {
    }

    public final String A() {
        m r0 = this.g;
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final JSONObject C() {
        m r1 = this.g;     // Catch: JSONException -> L9
        if (r1 == null) goto L6;
        String r10 = r1.c;     // Catch: JSONException -> L9
        if (r10 == null) goto L6;
    L7:
        return new JSONObject(r10);
    L6:
        r10 = "{}";
    L9:
        e = move-exception;
        this.H.b("getWidgetData: JSONException", e);
        return new JSONObject();
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer, k2.o
    public final View engineView() {
        w2.a r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.realView();
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer, k2.i
    public final void onHostDestroy() {
        super.onHostDestroy();
        x r0 = this.I;
        if (r0 == null) goto L5;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r0, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "closed_before_complete", 2);
    L5:
        this.I = null;
        Widget r1 = this.D;
        if (r1 == null) goto L8;
        r1.g();
    L8:
        i1 r10 = y0.a;
        y0.p(A(), "applet_widget_timeline_full", true);
        y0.o(A(), "applet_widget_timeline_full");
        Job r11 = this.C;
        if (r11 == null) goto L11;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L11:
        IAISDKDebugService.a.H(this.z);
        this.z.j = null;
        w2.a r12 = this.B;
        if (r12 == null) goto L32;
        r12.c();
        r12.a();
        r12.asView().removeOnLayoutChangeListener(this.J);
        r12.asView().removeOnAttachStateChangeListener(this.L);
        r12.asView().setOnFocusChangeListener(null);
        x2.a r13 = this.F;
        if (r13 == null) goto L31;
        this.H.c("onHostDestroy: releaseRenderView");
        Iterator<i3.b> r14 = r12.getBridge().d.a.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        r14.next().reset();
        goto L17
    L19:
        Intrinsics.checkNotNullParameter(r12, "view");
        if (r13.c == false) goto L23;
        com.bytedance.ai.applet.base.log.a.d("RenderViewPool", "releaseRenderView: pool is destroyed", null);
        r12.destroy();
        goto L32
    L23:
        if (r13.b.size() >= r13.a) goto L30;
        ViewParent r15 = r12.asView().getParent();
        if (r15 != null) goto L27;
    L29:
        r12.setReused(true);
        com.bytedance.ai.applet.base.log.a.c("RenderViewPool", "releaseRenderView: add pool");
        r13.b.add(r12);
        goto L32
    L27:
        if ((r15 instanceof ViewGroup) == false) goto L29;
        ((ViewGroup) r15).removeView(r12.asView());
        goto L29
    L30:
        com.bytedance.ai.applet.base.log.a.c("RenderViewPool", "releaseRenderView: destroy");
        r12.destroy();
        goto L32
    L31:
        this.H.c("onHostDestroy: destroyRenderView");
        r12.destroy();
    L32:
        this.B = null;
        LifecycleRegistryExtKt.a(this.c, Lifecycle.Event.ON_DESTROY);
        m r16 = this.g;
        if (r16 == null) goto L42;
        String r17 = r16.a;
        if (r17 == null) goto L42;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r18 = AppletAppManagerService.b(r17);
        if (r18 == null) goto L41;
        Intrinsics.checkNotNullParameter(this, "widget");
        r18.r.remove(this);
        if (r18.r.isEmpty() == false) goto L45;
        r18.i().c("detachWidget: widgetCount is 0, reschedule destruction");
        r18.G();
        return;
    L45:
        return;
    L41:
        this.H.b("onHostDestroy: detachWidget failed", null);
        return;
    L42:
        this.H.b("onHostDestroy: packageName is null", null);
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer, k2.o
    public final View realView() {
        return this.z;
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer
    public final Widget x() {
        return this.D;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.ai.widget.contianer.b] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.bytedance.ai.widget.contianer.c] */
    public AppletWidgetContainer(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.y = r10;
        if (t2.a.b(r10) == true) goto L5;
        AppletThemeMode r1 = AppletThemeMode.FOLLOW_SYSTEM;
    L14:
        this.z = new WidgetBoxView(com.bytedance.ai.applet.app.view.k.b(r10, r1), null, 6, 0);
        this.H = new com.bytedance.ai.applet.base.log.i("AppletWidgetContainer", new com.bytedance.ai.applet.base.log.e(com.bytedance.ai.applet.base.log.f.a()));
        this.J = new com.bytedance.ai.widget.contianer.b(this);
        this.K = new com.bytedance.ai.widget.contianer.c(this);
        this.L = new c(this);
        this.M = new f(this);
        this.N = new e(this);
        return;
    L5:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r11 = AppletRuntimeManager.d;
        if (r11 == null) goto L10;
        boolean r12 = true;
        if (r11.v(r10) != true) goto L10;
    L11:
        if (r12 == false) goto L13;
        r1 = AppletThemeMode.DARK;
        goto L14
    L13:
        r1 = AppletThemeMode.LIGHT;
    L10:
        r12 = false;
        goto L11
    }

    public final Map<String, Object> B(Widget r10) {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L6;
        String r1 = r0.r;
        if (r1 == null) goto L6;
    L7:
        Pair[] r11 = new Pair[12];
        boolean r12 = false;
        r11[0] = TuplesKt.to("viewId", this.f);
        m r13 = this.g;
        String r14 = "";
        if (r13 == null) goto L11;
        String r15 = r13.a;
        if (r15 == null) goto L11;
    L12:
        r11[1] = TuplesKt.to("appletId", r15);
        m r16 = this.g;
        if (r16 == null) goto L16;
        String r17 = r16.b;
        if (r17 == null) goto L16;
    L17:
        r11[2] = TuplesKt.to("pageName", r17);
        m r18 = this.g;
        if (r18 == null) goto L21;
        String r19 = r18.d;
        if (r19 == null) goto L21;
    L22:
        r11[3] = TuplesKt.to("botId", r19);
        m r20 = this.g;
        if (r20 == null) goto L26;
        String r21 = r20.e;
        if (r21 == null) goto L26;
    L27:
        r11[4] = TuplesKt.to("msgId", r21);
        m r22 = this.g;
        if (r22 == null) goto L31;
        String r23 = r22.j;
        if (r23 == null) goto L31;
    L32:
        r11[5] = TuplesKt.to("mixtureCardId", r23);
        m r24 = this.g;
        if (r24 == null) goto L38;
        String r25 = r24.g;
        if (r25 == null) goto L38;
        r14 = r25;
    L38:
        r11[6] = TuplesKt.to("replyFor", r14);
        r11[7] = TuplesKt.to("conversationId", this.b);
        m r26 = this.g;
        String r27 = null;
        if (r26 == null) goto L43;
        Map<String, Object> r28 = r26.i;
        if (r28 == null) goto L43;
        Object r29 = r28.get("createTime");
    L44:
        r11[8] = TuplesKt.to("msgCreateTime", r29);
        int r30 = com.bytedance.ai.utils.b.a;
        r11[9] = TuplesKt.to("appSettings", com.bytedance.ai.utils.b.a(r10.T));
        r11[10] = TuplesKt.to("lang", r1);
        m r31 = this.g;
        if (r31 == null) goto L47;
        String r32 = r31.o;
    L48:
        r11[11] = TuplesKt.to("mcpName", r32);
        Map<String, Object> r33 = MapsKt.mutableMapOf(r11);
        m r34 = this.g;
        if (r34 == null) goto L56;
        Map<String, String> r35 = r34.h;
        if (r35 == null) goto L56;
        Iterator<Map.Entry<String, String>> r36 = r35.entrySet().iterator();
    L54:
        if (r36.hasNext() == false) goto L56;
        Map.Entry<String, String> r37 = r36.next();
        r33.put(r37.getKey(), r37.getValue());
    L56:
        m r38 = this.g;
        if (r38 == null) goto L59;
        Map<String, Object> r39 = r38.n;
    L60:
        r33.put("extra", r39);
        m r40 = this.g;
        if (r40 == null) goto L71;
        String r41 = r40.j;
        if (r41 == null) goto L71;
        if (r41.length() <= 0) goto L67;
        r12 = true;
    L67:
        if (r12 == false) goto L69;
        r27 = r41;
    L69:
        if (r27 == null) goto L71;
        r33.put("widgetInstanceId", r27);
    L71:
        return r33;
    L59:
        r39 = null;
        goto L60
    L47:
        r32 = null;
    L43:
        r29 = null;
    L31:
        r23 = "";
    L26:
        r21 = "";
    L21:
        r19 = "";
    L16:
        r17 = "";
    L11:
        r15 = "";
    L6:
        r1 = "zh";
        goto L7
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer, com.bytedance.ai.widget.contianer.h
    public final void o(m r19) {
        Intrinsics.checkNotNullParameter(r19, "widgetContainerData");
        Widget r10 = this.D;
        if (r10 == null) goto L5;
        String r11 = r10.C;
    L7:
        if (c3.b.a(r11) == false) goto L14;
        this.g = r19;
        w2.a r1 = this.B;
        if (r1 != null) goto L12;
        this.H.c("updateData: widgetRenderView is not ready, use latest data when rendering");
        return;
    L12:
        this.H.c("updateData: update applet widget data");
        r1.setViewData(C());
        r1.e(MapsKt.mapOf(new Pair[]{TuplesKt.to("__RENDER_DATA__", r1.getComposition().d.toString()), TuplesKt.to("__VIEW_CONTEXT__", r1.getComposition().c)}));
        return;
    L14:
        com.bytedance.ai.widget.cache.b r12 = this.A;
        if (r12 == null) goto L20;
        String r13 = r19.a;
        String r14 = r19.b;
        String r15 = r19.e;
        String r16 = r19.d;
        String r17 = r19.k;
        if (r17 != null) goto L19;
        r17 = "";
    L19:
        r12.b(new ConversationWidgetData(r13, r14, r15, r16, r17, r19.l, r19.c, null, r19.s, 128, null));
    L20:
        com.bytedance.ai.widget.cache.b r18 = this.A;
        if (r18 == null) goto L28;
        TemplateData r20 = r18.e();
        if (r20 == null) goto L28;
        this.H.c("updateData: reload custom template data");
        w2.a r21 = this.B;
        if (r21 == null) goto L27;
        w2.a.b.a(r21, new JSONObject(r20.toMap()), false, 2);
        return;
    L27:
        this.H.b("updateData: widgetRenderView is NULL", null);
        return;
    L28:
        this.H.b("updateData: widgetLoader is NULL", null);
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // com.bytedance.ai.widget.contianer.WidgetContainer
    public final void w(h5.j r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.j = r10;
        ViewParent r11 = this.z.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L7;
        ViewGroup r12 = (ViewGroup) r11;
    L8:
        if (r12 != null) goto L10;
        return;
    L10:
        Widget r0 = this.D;
        if (r0 != null) goto L13;
        return;
    L13:
        boolean r13 = false;
        if (r0.O == true) goto L16;
    L29:
        h5.j r1 = this.j;
        if (r1 != null) goto L32;
    L34:
        if (r13 == true) goto L37;
        r12.setOutlineProvider(new d(this));
        r12.setClipToOutline(true);
        return;
    L37:
        return;
    L32:
        if (r0.P != r1.e) goto L34;
        r13 = true;
        goto L34
    L16:
        if (Build.VERSION.SDK_INT < 23) goto L29;
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(0);
        h5.j r15 = this.j;
        if (r15 == null) goto L20;
        int r16 = r15.b;
    L21:
        if (r15 == null) goto L23;
        int r17 = r15.c;
    L24:
        r14.setStroke(r16, r17);
        h5.j r18 = this.j;
        if (r18 == null) goto L27;
        float r19 = r18.d;
    L28:
        r14.setCornerRadius(r19);
        r12.setForeground(r14);
        goto L29
    L27:
        r19 = 0.0f;
        goto L28
    L23:
        r17 = 0;
        goto L24
    L20:
        r16 = 1;
        goto L21
    L7:
        r12 = null;
        goto L8
    }

    public final Object y(m r26, PendingWidgetPerformanceTracker r27, Continuation<? super Unit> r28) {
        if ((r28 instanceof AppletWidgetContainer$bindData$1) == false) goto L7;
        AppletWidgetContainer$bindData$1 r10 = (AppletWidgetContainer$bindData$1) r28;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 == 2) goto L18;
        if (r14 == 3) goto L17;
        if (r14 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L207:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Widget r0 = (Widget) r10.L$3;
        com.bytedance.ai.widget.cache.b r15 = (com.bytedance.ai.widget.cache.b) r10.L$2;
        PendingWidgetPerformanceTracker r16 = (PendingWidgetPerformanceTracker) r10.L$1;
        m r17 = (m) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L162:
        m r18 = this.g;
        com.bytedance.ai.utils.g r19 = com.bytedance.ai.utils.g.a;
        StringBuilder r20 = new StringBuilder("getThreadStrategy strategy=");
        com.bytedance.ai.settings.a<t> r21 = com.bytedance.ai.settings.b.d;
        r20.append(r21.a().b());
        r20.append(" cache_limit=");
        r20.append(r21.a().a());
        r19.i("WidgetContainer", r20.toString());
        List<LynxThreadStrategy> r22 = r21.a().b();
        if (r22 == null) goto L198;
        Iterator<T> r23 = r22.iterator();
    L166:
        if (r23.hasNext() == false) goto L198;
        LynxThreadStrategy r24 = (LynxThreadStrategy) r23.next();
        List<String> r25 = r24.getWidgets();
        if (r25 == null) goto L166;
        Iterator<T> r29 = r25.iterator();
    L171:
        if (r29.hasNext() == false) goto L166;
        String r30 = (String) r29.next();
        String r110 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r30, new String[]{"@"}, false, 0, 6, null), 0);
        String r111 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r30, new String[]{"@"}, false, 0, 6, null), 1);
        if (r18 == null) goto L175;
        String r112 = r18.a;
    L177:
        if (Intrinsics.areEqual(r110, r112) == false) goto L171;
        if (r18 == null) goto L180;
        String r31 = r18.b;
    L182:
        if (Intrinsics.areEqual(r111, r31) == false) goto L171;
        ThreadStrategyForRendering[] r32 = ThreadStrategyForRendering.values();
        int r33 = r24.getThreadStrategy();
        if (r33 >= 0) goto L186;
    L188:
        boolean r34 = false;
    L189:
        if (r34 == false) goto L191;
        ThreadStrategyForRendering r35 = r32[r33];
    L193:
        if (r24.getAsyncCreateView() <= 0) goto L195;
        boolean r113 = true;
    L196:
        Pair r36 = new Pair(Boolean.valueOf(r113), r35);
    L199:
        boolean r37 = ((Boolean) r36.getFirst()).booleanValue();
        this.H.c("asyncCreateView = " + r37);
        if (r37 == false) goto L203;
        this.C = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new AppletWidgetContainer$bindData$5(this, r0, r15, null), 3, null);
        return Unit.INSTANCE;
    L203:
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.label = 4;
        if (z(r0, r15, r10) != r13) goto L207;
        return r13;
    L195:
        r113 = false;
        goto L196
    L191:
        r35 = ThreadStrategyForRendering.ALL_ON_UI;
        goto L193
    L186:
        if (r33 >= r32.length) goto L188;
        r34 = true;
        goto L189
    L180:
        r31 = null;
        goto L182
    L175:
        r112 = null;
    L198:
        r36 = new Pair(Boolean.FALSE, ThreadStrategyForRendering.ALL_ON_UI);
        goto L199
    L18:
        r0 = (Widget) r10.L$3;
        r15 = (com.bytedance.ai.widget.cache.b) r10.L$2;
        PendingWidgetPerformanceTracker r114 = (PendingWidgetPerformanceTracker) r10.L$1;
        m r115 = (m) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L59:
        Applet r38 = (Applet) r12;
        if (r38 == null) goto L161;
        this.H.c("bindData: loadApplet end");
        r114.j(r38.a);
        r114.e();
        if (c3.b.a(r0.C) == false) goto L158;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r39 = AppletAppManagerService.c(r38);
        if (r39 == null) goto L100;
        s r40 = r114.a();
        if (r40 == null) goto L102;
        com.bytedance.ai.applet.app.foundation.performance.c r41 = r39.h().c();
        long r116 = r40.b;
        long r42 = r40.c;
        long r43 = r40.d;
        String r117 = r115.b;
        m r118 = this.g;
        if (r118 == null) goto L71;
        String r119 = r118.j;
        if (r119 == null) goto L71;
    L72:
        v r120 = new v(r116, r42, r43, r117, r119, r40.a);
        r41.getClass();
        Intrinsics.checkNotNullParameter(r120, "config");
        if (com.bytedance.ai.applet.app.foundation.performance.h.a(r120.a) == true) goto L75;
    L83:
        boolean r44 = false;
    L84:
        if (r44 == true) goto L86;
        com.bytedance.ai.applet.app.foundation.performance.c.k("createWidgetTracker", "invalid config: " + r120);
    L95:
        x r45 = null;
    L96:
        this.I = r45;
        goto L102
    L86:
        Object r46 = r41.c;
        monitor-enter(r46);
    L97:
        th = move-exception;
        throw th;
    L89:
        if (r41.i == false) goto L91;
        r45 = null;
    L92:
        monitor-exit(r46);
        if (r45 != null) goto L96;
        com.bytedance.ai.applet.app.foundation.performance.c.k("createWidgetTracker", "component destroyed");
        goto L95
    L91:
        r45 = new x(r41, r120);     // Catch: Throwable -> L97
        r41.e.put(Long.valueOf(r45.c), r45);     // Catch: Throwable -> L97
        goto L92
    L75:
        if (r120.b < 0) goto L83;
        if (r120.c < 0) goto L83;
        if ((!StringsKt.isBlank(r120.d)) == false) goto L83;
        if ((!StringsKt.isBlank(r120.e)) == false) goto L83;
        r44 = true;
    L71:
        r119 = "";
    L102:
        if (r0.P == 4) goto L162;
        if (SetsKt.setOf(new String[]{"mcp-agree-card", "mcp-login-card", "mcp-agree-login-card", "mcp-privacy-login-card"}).contains(r0.K) == true) goto L162;
        WidgetBoxView r47 = this.z;
        String r48 = r38.a;
        String r49 = r38.b();
        Widget r50 = this.D;
        if (r50 == null) goto L108;
        Integer r51 = r50.Q;
    L109:
        Iterator r52 = WidgetBoxView.TitleType.getEntries().iterator();
    L111:
        if (r52.hasNext() == false) goto L121;
        Object r121 = r52.next();
        int r122 = ((WidgetBoxView.TitleType) r121).getValue();
        if (r51 != null) goto L116;
    L118:
        boolean r123 = false;
    L119:
        if (r123 == false) goto L111;
    L122:
        WidgetBoxView.TitleType r124 = (WidgetBoxView.TitleType) r121;
        if (r124 != null) goto L125;
        r124 = WidgetBoxView.TitleType.NORMAL;
    L125:
        r47.getClass();
        Intrinsics.checkNotNullParameter(r48, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r124, "titleType");
        int[] r53 = WidgetBoxView.c.a;
        int r54 = r53[r124.ordinal()];
        if (r54 != 1) goto L128;
        r47.a.setVisibility(8);
        r47.b.setVisibility(8);
        r47.e.setVisibility(8);
    L136:
        int r55 = t2.a.c(r47.getContext(), 2130968839, 2131100405);
        int r56 = t2.a.c(r47.getContext(), 2130968842, 2131100409);
        int r125 = t2.a.c(r47.getContext(), 2130968843, 2131100432);
        if (Build.VERSION.SDK_INT < 23) goto L139;
        GradientDrawable r126 = new GradientDrawable();
        r126.setShape(0);
        float r127 = WidgetBoxView.l;
        r126.setCornerRadius(r127);
        r126.setColor(r55);
        r47.setBackground(r126);
        GradientDrawable r57 = new GradientDrawable();
        r57.setShape(0);
        r57.setCornerRadius(r127);
        r57.setColor(0);
        r57.setStroke(WidgetBoxView.m, r56);
        r47.setForeground(r57);
    L140:
        r47.setClipToOutline(true);
        r47.b.setBackgroundColor(r56);
        r47.d.setTextColor(r125);
        r47.g.setTextColor(r125);
        r47.e.setBackground(ContextCompat.getDrawable(r47.getContext(), 2131256579));
        if (r49 != null) goto L143;
    L146:
        boolean r58 = true;
    L147:
        if (r58 == true) goto L162;
        int r59 = r53[r124.ordinal()];
        if (r59 == 1) goto L162;
        if (r59 != 2) goto L153;
        r47.c.setImageURI(r49);
        goto L162
    L153:
        if (r59 != 3) goto L156;
        r47.f.setImageURI(r49);
        goto L162
    L156:
        throw new NoWhenBranchMatchedException();
    L143:
        if (r49.length() == 0) goto L146;
        r58 = false;
        goto L147
    L139:
        GradientDrawable r128 = new GradientDrawable();
        r128.setShape(0);
        r128.setCornerRadius(WidgetBoxView.l);
        r128.setColor(r55);
        r128.setStroke(WidgetBoxView.m, r56);
        r47.setBackground(r128);
        goto L140
    L128:
        if (r54 != 2) goto L130;
        r47.e.setVisibility(8);
        r47.a.setVisibility(0);
        r47.b.setVisibility(0);
        r47.d.setText(r48);
        goto L136
    L130:
        if (r54 != 3) goto L133;
        r47.a.setVisibility(8);
        r47.b.setVisibility(8);
        r47.e.setVisibility(0);
        r47.g.setText(r48);
        goto L136
    L133:
        throw new NoWhenBranchMatchedException();
    L116:
        if (r122 != r51.intValue()) goto L118;
        r123 = true;
        goto L119
    L121:
        r121 = null;
        goto L122
    L108:
        r51 = null;
        goto L109
    L100:
        Boxing.boxBoolean(r114.c(AppletPerformanceErrorCode.INTERRUPTED, "bindData: installApp failed, appletId:" + r115.a));
        goto L102
    L158:
        this.H.c("bindData: runtimeVersion is invalid, packageName = " + r115.a + ", widgetId = " + r115.b);
        r114.a();
        Context r60 = this.y;
        r10.L$0 = r115;
        r10.L$1 = r114;
        r10.L$2 = r15;
        r10.L$3 = r0;
        r10.label = 3;
        if (r15.g(r60, r115, r10) != r13) goto L162;
        return r13;
    L161:
        String r61 = "bindData: loadApplet failed, appletId:" + r115.a;
        this.H.b(r61, null);
        Boxing.boxBoolean(r114.c(AppletPerformanceErrorCode.LOAD_PACKAGE_ERROR, r61));
        goto L162
    L19:
        com.bytedance.ai.widget.cache.b r1 = (com.bytedance.ai.widget.cache.b) r10.L$2;
        PendingWidgetPerformanceTracker r62 = (PendingWidgetPerformanceTracker) r10.L$1;
        m r129 = (m) r10.L$0;
        ResultKt.throwOnFailure(r12);
        Object r63 = r12;
        PendingWidgetPerformanceTracker r64 = r62;
    L44:
        Widget r65 = (Widget) r63;
        this.H.c("bindData: loadWidget end");
        if (r65 != null) goto L48;
        String r66 = "widget is NULL, packageName = " + r129.a + ", widgetId = " + r129.b;
        i1 r67 = y0.a;
        y0.b(r129.a(), r66, AppletErrorCode.WIDGET_LOAD_ERROR.getType(), "applet_widget_timeline_full");
        this.H.b(r66, null);
        r(WidgetContainer.LifecycleEvent.ON_LOAD_ERROR);
        r64.c(AppletPerformanceErrorCode.LOAD_PACKAGE_ERROR, r66);
        return Unit.INSTANCE;
    L48:
        i1 r68 = y0.a;
        final String r69 = r129.a();
        Pair[] r130 = new Pair[3];
        String r131 = r65.B;
        if (r131 != null) goto L51;
        r131 = "";
    L51:
        r130[0] = TuplesKt.to("widget_res_from", r131);
        r130[1] = TuplesKt.to("version_code", Boxing.boxLong(r65.c));
        r130[2] = TuplesKt.to("render_type", r65.o);
        final Map r70 = MapsKt.mapOf(r130);
        Intrinsics.checkNotNullParameter(r69, "traceId");
        Intrinsics.checkNotNullParameter(r70, "eventInfo");
        final long r132 = System.currentTimeMillis();
        y0.r(new v0(r69, r132, r70));
        r64.g();
        this.D = r65;
        r65.e();
        r64.f();
        this.H.c("bindData: loadApplet start");
        AIManager r71 = AIManager.a;
        String r72 = r129.a;
        String r133 = r129.s;
        if (r133 == null) goto L54;
        Map<String, Object> r134 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("version_tag", r133)});
    L55:
        r10.L$0 = r129;
        r10.L$1 = r64;
        r10.L$2 = r1;
        r10.L$3 = r65;
        r10.label = 2;
        Object r73 = r71.D(r72, r134, r10);
        if (r73 != r13) goto L58;
        return r13;
    L58:
        r115 = r129;
        r114 = r64;
        r12 = r73;
        r15 = r1;
        r0 = r65;
        goto L59
    L54:
        r134 = null;
        goto L55
    L20:
        ResultKt.throwOnFailure(r12);
        String r135 = r26.a;
        String r136 = r26.b;
        String r74 = r26.e;
        String r137 = r26.d;
        String r138 = r26.k;
        if (r138 != null) goto L23;
        r138 = "";
    L23:
        ConversationWidgetData r75 = new ConversationWidgetData(r135, r136, r74, r137, r138, r26.l, r26.c, null, r26.s, 128, null);
        this.g = r26;
        this.G = this.k.getInt(r26.a(), 0);
        this.E = new com.bytedance.ai.widget.m(r26.e, r26.a(), r26.g, r26.a, r26.b);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r76 = AppletRuntimeManager.d;
        if (r76 == null) goto L27;
        WidgetResourceLoader r77 = r76.B(r75);
        if (r77 == null) goto L27;
    L28:
        this.A = r77;
        i1 r78 = y0.a;
        final String r79 = r26.a();
        final Map r80 = MapsKt.mapOf(new Pair[]{TuplesKt.to(BdpAwemeConstant.KEY_APP_ID, r26.b), TuplesKt.to("packageId", r26.a)});
        Intrinsics.checkNotNullParameter(r79, "traceId");
        Intrinsics.checkNotNullParameter(r80, "eventInfo");
        final long r139 = System.currentTimeMillis();
        y0.r(new w0(r79, r139, r80));
        r27.h();
        String r81 = r26.j;
        if (r81 != null) goto L31;
    L34:
        boolean r82 = true;
    L35:
        if (r82 == true) goto L40;
        this.H.c("bindData: cardId = " + r81 + " insert database");
        WidgetContextHelper r83 = WidgetContextHelper.a;
        String r84 = r26.a();
        String r85 = r26.e;
        String r86 = r26.k;
        if (r86 != null) goto L39;
        r86 = "";
    L39:
        WidgetContextHelper.b(r84, r85, r86, r26.d);
    L40:
        this.H.c("bindData: loadWidget start");
        r10.L$0 = r26;
        r64 = r27;
        r10.L$1 = r64;
        r10.L$2 = r77;
        r10.label = 1;
        r63 = r77.a(r10);
        if (r63 != r13) goto L43;
        return r13;
    L43:
        r129 = r26;
        r1 = r77;
        goto L44
    L31:
        if (r81.length() == 0) goto L34;
        r82 = false;
    L27:
        r77 = new WidgetResourceLoader(r75);
    L7:
        r10 = new AppletWidgetContainer$bindData$1(this, r28);
        goto L8
    }

    public final Object z(Widget r23, com.bytedance.ai.widget.cache.b r24, Continuation<? super Unit> r25) {
        if ((r25 instanceof AppletWidgetContainer$bindDataByType$1) == false) goto L7;
        AppletWidgetContainer$bindDataByType$1 r10 = (AppletWidgetContainer$bindDataByType$1) r25;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        boolean r15 = true;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L112:
        if (this.p != null) goto L114;
        this.p = new com.bytedance.ai.widget.d(this);
    L114:
        com.bytedance.ai.utils.i r1 = this.p;
        if (r1 == null) goto L121;
        WidgetBoxView r16 = this.z;
        m r17 = this.g;
        if (r17 == null) goto L119;
        String r18 = r17.a;
    L120:
        r1.a(r16, r18);
        goto L121
    L119:
        r18 = null;
    L121:
        this.z.setLongPressController(this.p);
        m r19 = this.g;
        if (r19 == null) goto L129;
        String r20 = r19.a;
        if (r20 == null) goto L129;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r21 = AppletAppManagerService.b(r20);
        if (r21 == null) goto L128;
        Intrinsics.checkNotNullParameter(this, "widget");
        r21.r.add(this);
        r21.i().c("attachWidget: widgetCount = " + r21.r.size());
    L131:
        return Unit.INSTANCE;
    L128:
        this.H.b("bindDataByType: attachWidget failed", null);
    L129:
        this.H.b("bindDataByType: packageName is null", null);
        goto L131
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        i1 r22 = y0.a;
        y0.i(A(), "applet_widget_timeline_full");
        x r26 = this.I;
        if (r26 == null) goto L17;
        Boxing.boxBoolean(r26.j());
    L17:
        String r27 = r23.o;
        Intrinsics.checkNotNullParameter(r27, "<this>");
        RenderType r28 = RenderType.WEB;
        if (Intrinsics.areEqual(r27, r28.getType()) == true) goto L25;
        r28 = RenderType.LYNX;
        if (Intrinsics.areEqual(r27, r28.getType()) == true) goto L25;
        r28 = null;
    L25:
        if (r28 != null) goto L28;
        this.H.b("renderType is NULL, " + r23.o + " is not support", null);
        AppletWidgetContainer$bindDataByType$1 r110 = r10;
        w2.a r29 = null;
    L55:
        if (r29 != null) goto L66;
        this.H.b("createRenderView failed, renderView is NULL", null);
        r(WidgetContainer.LifecycleEvent.ON_LOAD_ERROR);
        i1 r30 = y0.a;
        y0.b(A(), "createRenderView failed, renderView is NULL", AppletErrorCode.RENDER_VIEW_CREATE_ERROR.getType(), "applet_widget_timeline_full");
        x r31 = this.I;
        if (r31 != null) goto L59;
    L61:
        r15 = false;
    L62:
        if (r15 == false) goto L65;
        this.I = null;
    L65:
        return Unit.INSTANCE;
    L59:
        if (r31.c(AppletPerformanceErrorCode.RENDER_VIEW_CREATE_ERROR, "createRenderView failed, renderView is NULL") != true) goto L61;
    L66:
        this.B = r29;
        String r32 = r29.getRenderType().getType().toUpperCase(Locale.getDefault());
        if (r29.d() == false) goto L69;
        r32 = r32 + "-RE";
    L69:
        IAISDKDebugService.Companion r33 = IAISDKDebugService.a;
        boolean r111 = r33.O(r23.b);
        if (r29.getRenderType() != RenderType.LYNX) goto L72;
        final boolean r112 = true;
    L73:
        final WeakReference r113 = new WeakReference(this);
        WidgetBoxView r114 = this.z;
        r114.j = null;
        r33.E(r114, r23.b, IAISDKDebugService$Gravity.TOP_RIGHT, null, new com.bytedance.ai.widget.contianer.a(r113, r112));
        if (r111 == true) goto L76;
        this.z.setDebugOverlay(null);
        com.bytedance.ai.debug.f.a r34 = com.bytedance.ai.debug.f.a;
        View r115 = r29.asView();
        r34.getClass();
        Intrinsics.checkNotNullParameter(r115, "view");
        Intrinsics.checkNotNullParameter(r32, "badge");
    L76:
        if (r112 == false) goto L78;
        com.bytedance.ai.debug.f.a.a(r29.asView(), r111);
    L78:
        r29.setViewClient(this.N);
        r29.setOnTouchEventListener(this.M);
        r29.asView().setOnFocusChangeListener(this.K);
        this.z.addOnLayoutChangeListener(this.J);
        this.z.addOnAttachStateChangeListener(this.L);
        this.z.setContent(r29.asView());
        d3.w r35 = r29.getBridge();
        this.o = r35;
        r35.i.e(a0.class, new g(r23, this));
        e3.d.a.a(r35.i, WidgetContainer.class, this);
        r35.i.e(z.class, new com.bytedance.ai.widget.contianer.e(this));
        LifecycleRegistryExtKt.a(this.c, Lifecycle.Event.ON_CREATE);
        i1 r36 = y0.a;
        y0.h(A(), "applet_widget_timeline_full");
        x r37 = this.I;
        if (r37 == null) goto L81;
        Boxing.boxBoolean(r37.i(r29.d()));
    L81:
        y0.c(A());
        if (r29.d() == false) goto L108;
        this.H.c("bindDataByType: renderView is reused");
        y0.c(A());
        x r38 = this.I;
        if (r38 == null) goto L86;
        r38.n();
    L86:
        String r39 = A();
        Map r40 = MapsKt.mapOf(TuplesKt.to("isReused", 1));
        Intrinsics.checkNotNullParameter(r39, "traceId");
        Intrinsics.checkNotNullParameter(r40, "eventInfo");
        y0.r(new w(r39, System.currentTimeMillis(), r40));
        x r41 = this.I;
        if (r41 == null) goto L89;
        r41.m();
    L89:
        r(WidgetContainer.LifecycleEvent.ON_LOAD_START);
        y0.k(A(), "applet_widget_timeline_full", MapsKt.emptyMap());
        x r42 = this.I;
        if (r42 == null) goto L92;
        r42.l();
    L92:
        TemplateData r43 = r24.e();
        if (r43 == null) goto L95;
        this.H.c("renderByReusedView: reload custom template data");
        w2.a.b.a(r29, new JSONObject(r43.toMap()), false, 2);
    L96:
        y0.j(A(), "applet_widget_timeline_full");
        x r44 = this.I;
        if (r44 == null) goto L99;
        r44.k();
    L99:
        String r45 = A();
        LinkedHashMap r46 = new LinkedHashMap();
        HashMap r47 = new HashMap();
        r47.put("draw_end", Long.valueOf(System.currentTimeMillis()));
        Unit r48 = Unit.INSTANCE;
        r46.put("setup_timing", r47);
        y0.n(r45, r46, "applet_widget_timeline_full");
        x r49 = this.I;
        if (r49 == null) goto L102;
        LinkedHashMap r50 = new LinkedHashMap();
        HashMap r51 = new HashMap();
        r51.put("draw_end", Long.valueOf(System.currentTimeMillis()));
        r50.put("setup_timing", r51);
        r49.o(r50);
    L102:
        com.bytedance.ai.widget.m r52 = this.E;
        if (r52 == null) goto L107;
        com.bytedance.ai.widget.l r53 = y0.d;
        if (r53 == null) goto L107;
        r53.c(r52);
    L107:
        this.E = null;
        r(WidgetContainer.LifecycleEvent.ON_LOAD_FINISHED);
        goto L112
    L95:
        this.H.c("renderByReusedView: reload default template data");
        r29.setViewContext(B(r23));
        r29.setViewData(C());
        w2.a.b.a(r29, null, c3.b.a(r23.C), 1);
        goto L96
    L108:
        this.H.c("bindDataByType: renderView is new created");
        AppletWidgetContainer$bindDataByType$1 r54 = r110;
        r54.label = 1;
        if (D(r23, r24, r29, r54) != r13) goto L112;
        return r13;
    L72:
        r112 = false;
        goto L73
    L28:
        if (r28.getCanReuse() == false) goto L53;
        com.bytedance.ai.widget.cache.d r116 = com.bytedance.ai.widget.cache.d.a;
        String r117 = r23.b;
        String r118 = r23.K;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "appletId");
        Intrinsics.checkNotNullParameter(r118, "widgetId");
        List<WidgetReusedSettings> r119 = com.bytedance.ai.widget.cache.d.b.a();
        if (r119 == null) goto L39;
        Iterator<WidgetReusedSettings> r120 = r119.iterator();
    L33:
        if (r120.hasNext() == false) goto L39;
        WidgetReusedSettings r121 = r120.next();
        if (Intrinsics.areEqual(r121.getAppletId(), r117) == false) goto L33;
        if (Intrinsics.areEqual(r121.getWidgetId(), r118) == false) goto L33;
    L40:
        if (r121 == null) goto L42;
        int r122 = r121.getReusedMaxSize();
    L43:
        if (r122 <= 0) goto L53;
        this.H.c("createRenderView: packageName = " + r23.b + ", widgetId = " + r23.K + ", maxSize = " + r122);
        r110 = r10;
        x2.c r123 = new x2.c(this.y, new String[]{r23.b, r23.K, String.valueOf(r23.c)});
        x2.b.a.getClass();
        Intrinsics.checkNotNullParameter(r123, "key");
        Map<x2.c, x2.a> r55 = x2.b.b;
        x2.a r56 = (x2.a) ((LinkedHashMap) r55).get(r123);
        if (r56 != null) goto L47;
        r56 = new x2.a(r122);
        r55.put(r123, r56);
    L47:
        this.F = r56;
        com.bytedance.ai.applet.base.log.b r57 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("RenderViewPool", "acquireRenderView: pool size = " + r56.b.size());
        if (r56.b.isEmpty() == false) goto L50;
        r29 = null;
    L51:
        if (r29 != null) goto L55;
    L54:
        int r58 = RenderViewFactory.a;
        r29 = RenderViewFactory.b(this.y, r28, r23, r24);
        r29.getBridge().d(new q4.a());
        goto L55
    L50:
        r29 = (w2.a) r56.b.removeLast();
        goto L51
    L42:
        r122 = 0;
    L39:
        r121 = null;
    L53:
        r110 = r10;
    L7:
        r10 = new AppletWidgetContainer$bindDataByType$1(this, r25);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object D(Widget r10, com.bytedance.ai.widget.cache.b r11, w2.a r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof AppletWidgetContainer$renderByNewView$1) == false) goto L7;
        AppletWidgetContainer$renderByNewView$1 r0 = (AppletWidgetContainer$renderByNewView$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L17;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
    L16:
        ResultKt.throwOnFailure(r14);
    L52:
        i1 r17 = y0.a;
        y0.j(A(), "applet_widget_timeline_full");
        x r18 = this.I;
        if (r18 == null) goto L56;
        Boxing.boxBoolean(r18.k());
    L56:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r19 = (String) r0.L$2;
        w2.a r110 = (w2.a) r0.L$1;
        Widget r111 = (Widget) r0.L$0;
        goto L16
    L17:
        ResultKt.throwOnFailure(r14);
        i1 r112 = y0.a;
        y0.c(A());
        String r113 = AppletResourceTool.m(AppletResourceTool.a, r10, r10.L);
        q r20 = q.a;
        h2.a r21 = f2.b.c;
        if (r21 == null) goto L21;
        String r22 = r21.m;
        if (r22 == null) goto L21;
    L22:
        Map r23 = q.c(r22);
        Map r24 = q.f(this.y);
        if (r24 == null) goto L28;
        Iterator r25 = r24.entrySet().iterator();
    L26:
        if (r25.hasNext() == false) goto L28;
        Map.Entry r26 = (Map.Entry) r25.next();
        r23.put(r26.getKey(), r26.getValue());
    L28:
        m r27 = this.g;
        if (r27 == null) goto L36;
        Map<String, Object> r28 = r27.m;
        if (r28 == null) goto L36;
        Iterator<Map.Entry<String, Object>> r29 = r28.entrySet().iterator();
    L34:
        if (r29.hasNext() == false) goto L36;
        Map.Entry<String, Object> r30 = r29.next();
        r23.put(r30.getKey(), r30.getValue());
    L36:
        r23.put("__AI_SDK_VERSION__", "1.15.0-rc.7");
        h2.a r31 = f2.b.c;
        if (r31 == null) goto L41;
        Integer r32 = r31.s;
        if (r32 == null) goto L41;
        r23.put("__TEXT_ZOOM_RATIO__", Boxing.boxFloat(r32.intValue() / o.a(17.0f)));
    L41:
        r12.setGlobalProperties(r23);
        Map r33 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r113)});
        i1 r34 = y0.a;
        y0.k(A(), "applet_widget_timeline_full", r33);
        x r35 = this.I;
        if (r35 == null) goto L44;
        Boxing.boxBoolean(r35.l());
    L44:
        TemplateData r114 = r11.e();
        if (r114 == null) goto L49;
        this.H.c("renderByNewView: load custom template data");
        JSONObject r36 = new JSONObject(r114.toMap());
        r0.L$0 = r10;
        r0.L$1 = r12;
        r0.L$2 = r113;
        r0.label = 1;
        if (r12.f(r113, r36, r0) != r15) goto L52;
        return r15;
    L49:
        this.H.c("renderByNewView: load default template data");
        r12.setViewContext(B(r10));
        r12.setViewData(C());
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r12.f(r113, new JSONObject(), r0) != r15) goto L52;
        return r15;
    L21:
        r22 = "";
    L7:
        r0 = new AppletWidgetContainer$renderByNewView$1(this, r13);
        goto L8
    }
}
