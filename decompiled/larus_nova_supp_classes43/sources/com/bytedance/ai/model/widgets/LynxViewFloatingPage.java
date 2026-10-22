package com.bytedance.ai.model.widgets;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.AIPrivateViewModel;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001,\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001gB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010)\u001a\u00020!*\u00020*H\u0002J\b\u0010.\u001a\u00020/H\u0002J,\u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\n\u0010;\u001a\u0004\u0018\u00010:H\u0016JY\u0010<\u001a\u0004\u0018\u00010:2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010>2\u0016\u0010?\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020/\u0018\u00010@2#\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020/\u0018\u00010@H\u0016J\b\u0010E\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010F\u001a\u00020/H\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\u000fH\u0016JY\u0010I\u001a\u0004\u0018\u00010:2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010>2\u0016\u0010?\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020/\u0018\u00010@2#\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020/\u0018\u00010@H\u0002J\u0018\u0010J\u001a\u00020/2\u0006\u0010 \u001a\u00020*2\u0006\u0010\"\u001a\u00020*H\u0016J\b\u0010K\u001a\u00020/H\u0016J\b\u0010L\u001a\u00020/H\u0016J\b\u0010M\u001a\u00020/H\u0016J\b\u0010N\u001a\u00020/H\u0016J\u0010\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020\u0018H\u0002J\u0012\u0010Q\u001a\u00020\u000f2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010T\u001a\u0004\u0018\u00010SH\u0082@¢\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020/H\u0016J\u001a\u0010Y\u001a\u0004\u0018\u00010\u00192\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0018H\u0016J\u0010\u0010\\\u001a\u00020/2\u0006\u0010]\u001a\u00020\u0018H\u0016J\u001a\u0010^\u001a\u00020/2\u0006\u0010_\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010`H\u0016J\n\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0014\u0010c\u001a\u00020/*\u00020\u00112\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010f\u001a\u00020/H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006h"}, d2 = {"Lcom/bytedance/ai/model/widgets/LynxViewFloatingPage;", "Lcom/bytedance/ai/model/widgets/AIContainerViewBase;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/bytedance/ai/api/model/view/IFloatingPage;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "<init>", "(Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/model/objects/PageInfo;)V", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "isShowing", "", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lynxRemoteBridgeMessages", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/utils/LynxReadableMap;", "aiViewModelMap", "", "", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", "width", "", "height", "_onAppBackGroundListener", "Lcom/bytedance/ai/api/model/ability/OnAppBackGroundCallback;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "scaleSize", "", "lifeCycleListener", "com/bytedance/ai/model/widgets/LynxViewFloatingPage$lifeCycleListener$1", "Lcom/bytedance/ai/model/widgets/LynxViewFloatingPage$lifeCycleListener$1;", "initLynxBridge", "", "createContainer", "root", "Landroid/view/ViewGroup;", "params", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "realView", "Landroid/view/View;", "engineView", "createPage", "context", "Landroid/content/Context;", "onSuccess", "Lkotlin/Function1;", "onFail", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, MessageIndication.MESSAGE_TYPE_MSG, "getRenderType", "createLynxView", "onFocusChange", "hasFocus", "createRealPage", "handleContentSizeChange", "floatingViewDestroy", "floatingViewShow", "floatingViewHide", "onMaskClicked", "dispatchLifecycleEventToWeb", "lifecycleEventName", "renderTemplate", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "loadTemplateBundleFromPackage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemplateData", "Lcom/lynx/tasm/TemplateData;", "onDestroy", "getViewModel", "isShared", "groupId", "onMessageToJS", com.bytedance.android.ec.core.event.a.KEY_MSG, "onMessageToAIBridge", "eventName", "Lcom/google/gson/JsonObject;", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "changeTo", "event", "Landroidx/lifecycle/Lifecycle$Event;", "checkFloatingPageTheme", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxViewFloatingPage extends com.bytedance.ai.model.widgets.c implements LifecycleOwner, k2.s {
    public static final /* synthetic */ int l = 0;
    public com.bytedance.ai.lynx.g a;
    public final a b;
    public boolean c;
    public final LifecycleRegistry d;
    public final s4.c<ReadableMap> e;
    public final Map<String, a6.a> f;
    public d3.w g;
    public int h;
    public int i;
    public final g2.f j;
    public final c k;

    public static final class a extends q1 {
        public final /* synthetic */ PageInfo a;

        public final void onFirstScreen() {
            com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onFirstScreen " + this.a.getPageName() + ' ');
        }

        public final void onLoadSuccess() {
            com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onLoadSuccess " + this.a.getPageName());
        }

        public a(PageInfo r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.ai.lynx.r {
        public c() {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onDetachedFromWindow(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onFirstScreen(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onRuntimeReady(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingSetup(com.bytedance.ai.lynx.g r1, Map<String, Object> r10) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingUpdate(com.bytedance.ai.lynx.g r1, Map<String, Object> r10, Map<String, Long> r11, String r12) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageUpdate(com.bytedance.ai.lynx.g r10) {
            com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onPageUpdate");
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onLoadUriSuccess(Uri r10, com.bytedance.ai.lynx.g r11) {
            com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onLoadUriSuccess " + r10);
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageStart(com.bytedance.ai.lynx.g r10, String r11) {
            com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onPageStart " + r11);
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onReceivedError(com.bytedance.ai.lynx.g r10, LynxError r11) {
            com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
            r12.e("LynxViewFloatingPage", "onReceivedError " + r11);
            boolean r0 = false;
            if (r11 == null) goto L7;
            Intrinsics.checkNotNullParameter(r11, "<this>");
            if (CollectionsKt.listOf(new Integer[]{100, 102, 103, 1201}).contains(Integer.valueOf(r11.getErrorCode())) != true) goto L7;
            r0 = true;
        L7:
            if (r0 == false) goto L10;
            r12.e("LynxViewFloatingPage", "onReceivedError FatalError " + r11);
            return;
        }
    }

    static {
    }

    @Override // k2.k
    public final void createContainer(ViewGroup r1, k2.b r10, Activity r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r1, "root");
        Intrinsics.checkNotNullParameter(r10, "params");
    }

    @Override // k2.s
    public final void a() {
        if (this.c == false) goto L6;
        com.bytedance.ai.utils.g.a.d("LynxViewFloatingPage", "floatingViewShow: widget " + getPageID() + " is showing");
        return;
    L6:
        this.c = true;
        k("onShow");
        j(this.d, Lifecycle.Event.ON_RESUME);
    }

    @Override // k2.s
    public final void c() {
        d3.w r0 = this.g;
        if (r0 == null) goto L6;
        JsonObject r1 = new JsonObject();
        r1.addProperty("viewId", getPageInfo().getPageId());
        Unit r10 = Unit.INSTANCE;
        r0.a("applet.floatingMaskClicked", r1);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c
    public final String getRenderType() {
        return RenderType.LYNX.getTypeName();
    }

    @Override // k2.s
    public final void i() {
        if (this.c == true) goto L6;
        com.bytedance.ai.utils.g.a.d("LynxViewFloatingPage", "floatingViewShow: widget " + getPageID() + " is hide");
        return;
    L6:
        this.c = false;
        com.bytedance.ai.utils.g.a.d("LynxViewFloatingPage", "floatingViewHide: ");
        k("onHide");
        j(this.d, Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.i
    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.d("LynxViewFloatingPage", "floating onDestroy");
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        r0.i(this.j);
    L5:
        AppletRuntime r1 = getAppletRuntime();
        r1.h.g();
        r1.f();
        AppletRuntimeManager.m(getPageID());
        k("onDestroy");
        p2.c.e(new o(this), 2000);
    }

    @Override // k2.s
    public final void e() {
        onDestroy();
    }

    @Override // k2.o
    public final View engineView() {
        return this.a;
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        return this.g;
    }

    public final Lifecycle getLifecycle() {
        return this.d;
    }

    @Override // k2.s
    public final int height() {
        return this.i;
    }

    @Override // k2.o
    public final View realView() {
        return this.a;
    }

    @Override // k2.s
    public final int width() {
        return this.h;
    }

    public static int l(double r10) {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L8;
        Integer r1 = r0.s;
        if (r1 == null) goto L8;
        float r11 = r1.intValue() / com.bytedance.ai.utils.o.a(17.0f);
        com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "scale size: viewZoom: " + r11 + "; origin: " + r10);
        return (int) (com.bytedance.ai.utils.o.c(Double.valueOf(r10)) * r11);
    L8:
        int r12 = com.bytedance.ai.utils.o.a;
        return com.bytedance.ai.utils.o.c(Double.valueOf(r10));
    }

    public final void k(String r10) {
        com.bytedance.ai.utils.g.a.d("LynxViewFloatingPage", "dispatchLifecycleEventToWeb " + this + " lifecycle ==> " + r10);
        d3.w r0 = this.g;
        if (r0 == null) goto L6;
        JsonObject r1 = new JsonObject();
        r1.addProperty("eventName", viewContext());
        Unit r11 = Unit.INSTANCE;
        r0.a(r10, r1);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c
    public final void onFocusChange(boolean r10) {
        com.bytedance.ai.lynx.g r0 = this.a;
        if (r0 == null) goto L7;
        Map r11 = MapsKt.mapOf(TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("containerID", getPageID()), TuplesKt.to("focusState", Boolean.valueOf(r10))})));
        Intrinsics.checkNotNullParameter("onFocusChange", "eventName");
        com.ivy.ivykit.api.bridge.g r1 = r0.e;
        if (r1 == null) goto L7;
        r1.b(r11);
    L7:
        d3.w r12 = this.g;
        if (r12 == null) goto L11;
        JsonObject r13 = new JsonObject();
        r13.addProperty("containerID", getPageID());
        r13.addProperty("focusState", Boolean.valueOf(r10));
        Unit r14 = Unit.INSTANCE;
        r12.a("onFocusChange", r13);
        return;
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "onMessageToJS: " + r10);
    }

    public LynxViewFloatingPage(AppletRuntime r10, PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        super(r10, r11);
        this.d = new LifecycleRegistry(this);
        this.e = new s4.c();
        this.f = new LinkedHashMap();
        g2.f r12 = new g2.f(new t(this), new u(this), 12);
        this.j = r12;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        r0.w(r12);
    L5:
        r11.setPageId(getPageID());
        this.b = new a(r11);
        this.k = new c();
    }

    public static final Object h(LynxViewFloatingPage r11, Continuation r12) {
        r11.getClass();
        if ((r12 instanceof LynxViewFloatingPage$loadTemplateBundleFromPackage$1) == false) goto L7;
        LynxViewFloatingPage$loadTemplateBundleFromPackage$1 r0 = (LynxViewFloatingPage$loadTemplateBundleFromPackage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        LynxViewFloatingPage$loadTemplateBundleFromPackage$1 r10 = r0;
        Object r13 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        String r16 = (String) r10.L$1;
        String r17 = (String) r10.L$0;
        ResultKt.throwOnFailure(r13);
    L33:
        String r18 = r16;
        String r19 = r17;
        r14 = (TemplateBundle) r13;
        String r110 = r19;
    L35:
        Trace.endSection();
        com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "loadTemplateBundleFromPackage: end loading, packageName = " + r110 + ", widgetId = " + r18);
    L36:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r110 = r11.getAppletId();
        r18 = r11.getPageInfo().getPageName();
        com.bytedance.ai.lynx.g r20 = r11.a;
        if (r20 == null) goto L20;
        String r21 = r11.getPageInfo().getPageUrl();
        if (r21 != null) goto L19;
        r21 = "";
    L19:
        r20.k(r21, r110, r18);
    L20:
        com.bytedance.ai.utils.g.a.i("LynxViewFloatingPage", "loadTemplateBundleFromPackage: start loading, packageName = " + r110 + ", widgetId = " + r18);
        StringBuilder r22 = new StringBuilder("loadTemplateBundle_");
        r22.append(r11.getPageInfo().getPageName());
        Trace.beginSection(r22.toString());
        String r23 = r11.getPageInfo().getPageUrl();
        if (r23 == null) goto L34;
        int r24 = AppletLynxViewApi.a;
        String r25 = r11.getAppletRuntime().h.x;
        if (r25 != null) goto L26;
        r25 = "";
    L26:
        if (r11.getAppletRuntime().h.E != 1) goto L28;
        boolean r26 = true;
    L29:
        String r27 = r11.getPageInfo().getPackageName();
        String r111 = r11.getPageInfo().getPageName();
        r10.L$0 = r110;
        r10.L$1 = r18;
        r10.label = 1;
        Object r112 = AppletLynxViewApi.b(r25, r23, r26, r27, r111, r10);
        if (r112 == r14) goto L36;
        r17 = r110;
        r13 = r112;
        r16 = r18;
        goto L33
    L28:
        r26 = false;
        goto L29
    L34:
        r14 = null;
    L7:
        r0 = new LynxViewFloatingPage$loadTemplateBundleFromPackage$1(r11, r12);
        goto L8
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == true) goto L9;
        a6.a r12 = (a6.a) ((LinkedHashMap) this.f).get(r11);
        if (r12 != null) goto L10;
        AIPrivateViewModel.a r13 = new AIPrivateViewModel.a(r11);
        this.f.put(r11, r13);
        return r13;
    L10:
        return r12;
    L9:
        return SharedViewModelExtKt.b(this, r11);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final void handleContentSizeChange(double r1, double r10) {
        this.h = l(r1);
        this.i = l(r10);
        i2.j r11 = i2.i.a;
        i2.i.a.a().f(this, this.h, this.i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.model.widgets.r, kotlin.jvm.functions.Function0] */
    public final void j(final LifecycleRegistry r10, final Lifecycle.Event r11) {
        ?? r0 = new r(r11, r10);
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L5;
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LynxViewFloatingPage$changeTo$1(r10, r11, r0, null), 3, null);
        return;
    L5:
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L7;
        r0.invoke();
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        d3.w r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }

    /* JADX WARN: Type inference failed for: r13v12, types: [android.widget.FrameLayout, com.bytedance.ai.lynx.g, com.lynx.tasm.LynxView] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ai.model.widgets.q] */
    @Override // com.bytedance.ai.model.widgets.c, k2.p
    public final View createPage(PageInfo r12, Context r13, Function1<? super Integer, Unit> r14, final Function1<? super String, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        super.createPage(r12, r13, null, null);
        ?? r1 = new q(this, r15);
        if (r12.getPageName() != null) goto L5;
    L53:
        r1.invoke("pageInfo is null, context=" + r13 + ", pageName=" + r12.getPageName() + ", pageUrl=" + r12.getPageUrl());
    L54:
        return null;
    L5:
        if (r12.getPageUrl() == null) goto L53;
        setPageInfo(r12);
        com.bytedance.vmsdk.jsbridge.utils.ReadableMap r16 = r12.getPageSettings();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        if (r16 == null) goto L13;
        String r18 = r16.getString("width");     // Catch: Throwable -> L22
        if (r18 == null) goto L13;
        int r19 = l(CastDoubleProtector.parseDouble(r18));     // Catch: Throwable -> L22
    L14:
        this.h = r19;     // Catch: Throwable -> L22
        if (r16 == null) goto L19;
        String r110 = r16.getString("height");     // Catch: Throwable -> L22
        if (r110 == null) goto L19;
        int r111 = l(CastDoubleProtector.parseDouble(r110));     // Catch: Throwable -> L22
    L20:
        this.i = r111;     // Catch: Throwable -> L22
        Object r112 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r113 = Result.exceptionOrNull-impl(r112);
        if (r113 == null) goto L27;
        r1.invoke("get page width/height exception: " + ExceptionsKt.stackTraceToString(r113));
        goto L54
    L27:
        Trace.beginSection("createLynxFloatingView");
        final ArrayList r114 = new ArrayList();
        com.lynx.jsbridge.f r115 = new com.lynx.jsbridge.f();
        r115.a = "AppletBridgeModule";
        r115.b = AppletBridgeModule.class;
        r115.c = new AppletBridgeModule.b(this.e, new LynxViewFloatingPage$createLynxView$lynxNativeModels$1$1$1(s4.d.a), new v(this), ContainerType.PAGE);
        r114.add(r115);
        final Context r116 = f2.k.a();
        int r10 = AppletLynxViewApi.a;
        Context r11 = f2.k.a();
        h2.a r20 = f2.b.c;
        if (r20 == null) goto L31;
        String r21 = r20.m;
        if (r21 == null) goto L31;
    L32:
        ?? r117 = AppletLynxViewApi.a(r11, r21, getAppletRuntime().h.x, getPageInfo().getPackageName(), null, new w(this), new x(this, r114, r116), 16);
        r117.setTag(2131363149, new WeakReference(this));
        this.a = r117;
        r117.addLynxViewClient(this.b);
        LynxView r118 = this.a;
        if (r118 == null) goto L35;
        r118.addOnLayoutChangeListener(new y());
    L35:
        LynxView r119 = this.a;
        if (r119 == null) goto L38;
        r119.setClickable(true);
        r119.setFocusable(true);
        r119.setFocusableInTouchMode(true);
        r119.setOnFocusChangeListener(new p(this));
    L38:
        Trace.endSection();
        com.bytedance.ai.lynx.g r120 = this.a;
        if (r120 == null) goto L48;
        m4.c r121 = r120.h(this.e);
        com.bytedance.ai.lynx.g r122 = this.a;
        if (r122 == null) goto L44;
        r122.addLynxViewClient(new a0(this));
    L44:
        d3.w r123 = new d3.w();
        r123.d(new q4.a());
        LynxView r22 = this.a;
        if (r22 == null) goto L47;
        r123.j(r22);
    L47:
        r123.i.e(d3.a0.class, new b0(this));
        e3.d.a.a(r123.i, k2.j.class, this);
        e3.d.a.a(r123.i, AppletRuntime.class, getAppletRuntime());
        r123.i.e(d3.z.class, new s(this));
        r123.k(r121);
        this.g = r123;
    L48:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new LynxViewFloatingPage$createRealPage$3(this, null), 2, null);
        com.bytedance.ai.monitor.b.d("create_floating_page", new z(r12));
        j(this.d, Lifecycle.Event.ON_CREATE);
        i2.j r124 = i2.i.a;
        int r125 = i2.i.a.a().d(this, r12, null);
        if (r125 <= 0) goto L52;
        if (r14 == null) goto L54;
        r14.invoke(Integer.valueOf(r125));
        goto L54
    L52:
        r1.invoke("fail to show floating page");
    L31:
        r21 = "";
    L19:
        r111 = this.i;     // Catch: Throwable -> L22
    L13:
        r19 = this.h;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
