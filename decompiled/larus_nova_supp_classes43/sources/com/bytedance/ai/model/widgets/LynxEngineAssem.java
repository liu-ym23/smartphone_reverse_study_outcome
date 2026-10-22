package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.applet.render.core.lynx.LynxAIBridgePort;
import com.bytedance.ai.applet.render.core.lynx.LynxAppletBridgeSyncModule;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.method.ui.AIBridgeSetTitleMethod;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.assem.arch.core.UIAssem;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.view.UIContentAssem;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.q1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import m5.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001$\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0002TUB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020'H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u0004\u0018\u00010.H\u0082@¢\u0006\u0002\u00100J\b\u00101\u001a\u000202H\u0002J4\u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0010\u00106\u001a\f\u0012\b\u0012\u000608j\u0002`9072\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020,H\u0002J\"\u0010=\u001a\u00020'2\u0010\u00106\u001a\f\u0012\b\u0012\u000608j\u0002`9072\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010>\u001a\u00020'H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010@\u001a\u00020'H\u0016J\b\u0010A\u001a\u00020,H\u0016J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u001dH\u0016J\u001c\u0010D\u001a\u00020'2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020G0FH\u0016J\b\u0010H\u001a\u00020'H\u0002J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010)H\u0016J\n\u0010L\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u001dH\u0016J\u001a\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020\u001d2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020'H\u0016R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006V"}, d2 = {"Lcom/bytedance/ai/model/widgets/LynxEngineAssem;", "Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "<init>", "()V", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "getLynxView$annotations", "getLynxView", "()Lcom/bytedance/ai/lynx/AppletLynxView;", "setLynxView", "(Lcom/bytedance/ai/lynx/AppletLynxView;)V", "mRenderData", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "getMRenderData", "()Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "mRenderData$delegate", "Lcom/bytedance/assem/arch/extensions/HierarchyLazy;", "mRenderStateVM", "Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "getMRenderStateVM", "()Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "mRenderStateVM$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "mHandler", "Landroid/os/Handler;", "traceId", "", "eventType", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifeCycleListener", "com/bytedance/ai/model/widgets/LynxEngineAssem$lifeCycleListener$1", "Lcom/bytedance/ai/model/widgets/LynxEngineAssem$lifeCycleListener$1;", "onViewCreated", "", "view", "Landroid/view/View;", "initLynxView", "renderTemplate", "", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "loadTemplateBundleFromPackage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemplateData", "Lcom/lynx/tasm/TemplateData;", "createLynxView", "context", "Landroid/content/Context;", "lynxRemoteBridgeMessages", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/utils/LynxReadableMap;", "lynxViewClient", "Lcom/bytedance/ai/model/widgets/LynxEngineAssem$AppletLynxViewClient;", "enableZoom", "initLynxBridge", "doRefresh", com.bytedance.android.ec.core.event.a.KEY_URL, "onBackPress", "goBack", "setTitle", "title", "setTitleBar", "settings", "", "", "registerAIBridgeMethods", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "realView", "engineView", "onMessageToJS", com.bytedance.android.ec.core.event.a.KEY_MSG, "onMessageToAIBridge", "eventName", "params", "Lcom/google/gson/JsonObject;", "onDestroy", "Companion", "AppletLynxViewClient", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxEngineAssem extends UIContentAssem implements k2.q {
    public static final /* synthetic */ int r = 0;
    public com.bytedance.ai.lynx.g j;
    public final com.bytedance.assem.arch.extensions.f k;
    public final com.bytedance.assem.arch.viewModel.b l;
    public d3.w m;
    public final Handler n;
    public String o;
    public String p;
    public final c q;

    public static final class a extends q1 {
        public final boolean a;
        public d3.w b;

        public final void onLynxViewAndJSRuntimeDestroy() {
            super.onLynxViewAndJSRuntimeDestroy();
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            r0.i("LynxEngineAssem", "onLynxViewAndJSRuntimeDestroy, isStandaloneMode = " + this.a);
            if (this.a == false) goto L5;
            return;
        L5:
            d3.w r1 = this.b;
            if (r1 == null) goto L8;
            r0.e("LynxEngineAssem", r1 + " release aiBridgeRef: " + this.b);
            r1.g();
        L8:
            this.b = null;
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.ai.lynx.r {
        public final /* synthetic */ LynxEngineAssem a;

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

        public c(LynxEngineAssem r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageUpdate(com.bytedance.ai.lynx.g r10) {
            com.bytedance.ai.utils.g.a.i("LynxEngineAssem", "onPageUpdate");
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onLoadUriSuccess(Uri r10, com.bytedance.ai.lynx.g r11) {
            com.bytedance.ai.utils.g.a.i("LynxEngineAssem", "onLoadUriSuccess isActive=" + this.a.o() + ' ' + r10);
            if (this.a.o() == true) goto L5;
            return;
        L5:
            RenderStateVM r12 = (RenderStateVM) this.a.l.getValue();
            String r1 = null;
            if (r10 == null) goto L8;
            String r13 = r10.toString();
        L9:
            r12.updateState(new i5.c(r13));
            k2.b r14 = this.a.t();
            if (r14 == null) goto L17;
            k2.j r15 = r14.n;
            if (r15 == null) goto L18;
            if (r10 == null) goto L15;
            r1 = r10.toString();
        L15:
            r15.onViewFinish(r1);
            return;
        L18:
            return;
        L17:
            return;
        L8:
            r13 = null;
            goto L9
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageStart(com.bytedance.ai.lynx.g r10, String r11) {
            com.bytedance.ai.utils.g.a.i("LynxEngineAssem", "onPageStart isActive=" + this.a.o() + ' ' + r11);
            if (this.a.o() == true) goto L5;
            return;
        L5:
            k2.b r12 = this.a.t();
            if (r12 == null) goto L10;
            k2.j r13 = r12.n;
            if (r13 == null) goto L10;
            r13.onViewStart(r11);
        L10:
            ((RenderStateVM) this.a.l.getValue()).updateState(new i5.d(r11));
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onReceivedError(com.bytedance.ai.lynx.g r10, LynxError r11) {
            com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
            r12.e("LynxEngineAssem", "onReceivedError " + r11);
            boolean r0 = false;
            if (r11 == null) goto L7;
            Intrinsics.checkNotNullParameter(r11, "<this>");
            if (CollectionsKt.listOf(new Integer[]{100, 102, 103, 1201}).contains(Integer.valueOf(r11.getErrorCode())) != true) goto L7;
            r0 = true;
        L7:
            if (r0 == false) goto L10;
            r12.e("LynxEngineAssem", "onReceivedError FatalError " + r11);
            return;
        }
    }

    static {
    }

    public final /* synthetic */ void f() {
    }

    @Override // k2.q
    public final boolean goBack() {
        return false;
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(long r1, long r10) {
    }

    @Override // k2.q
    public final void onBackPress() {
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
    }

    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.d("LynxEngineAssem", "onDestroy");
        this.n.postDelayed(new l(this), 2000);
        String r0 = this.o;
        if (r0 == null) goto L8;
        String r1 = this.p;
        if (r1 == null) goto L9;
        i1 r10 = m5.y0.a;
        m5.y0.o(r0, r1);
        return;
    L9:
        return;
    }

    public final k2.b t() {
        return (k2.b) this.k.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.view.View, android.widget.FrameLayout, com.bytedance.ai.lynx.g, com.lynx.tasm.LynxView] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.FrameLayout, com.bytedance.ai.lynx.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void u() {
        s4.c<ReadableMap> r10 = new s4.c();
        k2.b r0 = t();
        if (r0 == null) goto L11;
        k2.j r1 = r0.n;
        if (r1 == null) goto L11;
        AppletRuntime r11 = r1.getAppletRuntime();
        if (r11 == null) goto L11;
        Applet r12 = r11.h;
        if (r12 == null) goto L11;
        String r13 = r12.C;
    L12:
        a r14 = new a(c3.b.a(r13));
        final Context r15 = getContext();
        if (r15 == null) goto L86;
        final boolean r16 = true;
        ?? r17 = this.j;
        if (r17 == 0) goto L17;
        r17.setTag(2131363149, null);
        r17.destroy();
    L17:
        com.bytedance.ai.utils.g r18 = com.bytedance.ai.utils.g.a;
        r18.i("LynxEngineAssem", "createLynxView");
        final ArrayList r19 = new ArrayList();
        com.lynx.jsbridge.f r20 = new com.lynx.jsbridge.f();
        r20.a = "AppletBridgeModule";
        r20.b = AppletBridgeModule.class;
        r20.c = new AppletBridgeModule.b(r10, new LynxEngineAssem$createLynxView$lynxNativeModels$1$1$1(s4.d.a), new g(this), ContainerType.PAGE);
        r19.add(r20);
        com.lynx.jsbridge.f r21 = new com.lynx.jsbridge.f();
        r21.a = LynxAppletBridgeSyncModule.NAME;
        r21.b = LynxAppletBridgeSyncModule.class;
        r21.c = new ArrayList(CollectionsKt.mutableListOf(new LynxAppletBridgeSyncModule.b[]{new LynxAppletBridgeSyncModule.b(new h(this))}));
        r19.add(r21);
        k2.b r22 = t();
        if (r22 == null) goto L26;
        k2.j r23 = r22.n;
        if (r23 == null) goto L26;
        AppletRuntime r24 = r23.getAppletRuntime();
        if (r24 == null) goto L26;
        Applet r25 = r24.h;
        if (r25 == null) goto L26;
        String r110 = r25.x;
    L27:
        k2.b r26 = t();
        if (r26 == null) goto L36;
        k2.j r27 = r26.n;
        if (r27 == null) goto L36;
        AppletRuntime r28 = r27.getAppletRuntime();
        if (r28 == null) goto L36;
        Applet r29 = r28.h;
        if (r29 == null) goto L36;
        String r111 = r29.b;
    L37:
        k2.b r30 = t();
        if (r30 == null) goto L44;
        k2.j r31 = r30.n;
        if (r31 == null) goto L44;
        AppletRuntime r32 = r31.getAppletRuntime();
        if (r32 == null) goto L44;
        Applet r112 = r32.h;
    L45:
        int r33 = AppletLynxViewApi.a;
        h2.a r34 = f2.b.c;
        if (r34 == null) goto L49;
        String r35 = r34.m;
        if (r35 == null) goto L49;
    L50:
        final Applet r36 = r112;
        ?? r37 = AppletLynxViewApi.a(r15, r35, r110, r111, null, new i(this), new j(r36, this, r19, r16, r15), 16);
        r37.addLynxViewClient(r14);
        com.bytedance.ai.debug.f.a r113 = com.bytedance.ai.debug.f.a;
        if (r36 != null) goto L53;
    L55:
        boolean r114 = false;
    L56:
        r113.a(r37, r114);
        k2.b r38 = t();
        if (r38 == null) goto L61;
        final k2.j r39 = r38.n;
        if (r39 == null) goto L61;
        r37.setTag(2131363149, new WeakReference(r39));
        new com.bytedance.ai.debug.d(true, new k(r39)).a(r37);
    L61:
        View r40 = ((UIAssem) this).h;
        if (r40 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L65:
        if ((r40 instanceof ViewGroup) == false) goto L67;
        ViewGroup r41 = (ViewGroup) r40;
    L68:
        if (r41 == 0) goto L70;
        r41.removeAllViews();
        r41.addView(r37, new ViewGroup.LayoutParams(-1, -1));
    L70:
        this.j = r37;
        r37.setClickable(true);
        r37.setFocusable(true);
        r37.setFocusableInTouchMode(true);
        com.bytedance.ai.lynx.g r42 = this.j;
        if (r42 == null) goto L84;
        k2.b r43 = t();
        if (r43 == null) goto L84;
        final k2.j r44 = r43.n;
        if (r44 == null) goto L84;
        LynxAIBridgePort r45 = r42.h(r10);
        d3.w r46 = new d3.w();
        r18.e("LynxEngineAssem", r14 + " setAIBridge: " + r46);
        r14.b = r46;
        LynxView r47 = this.j;
        if (r47 == null) goto L81;
        r46.j(r47);
    L81:
        r46.i.e(d3.a0.class, new n(r44, String.valueOf(System.currentTimeMillis())));
        e3.d.a.a(r46.i, k2.j.class, r44);
        e3.d.a.a(r46.i, AppletRuntime.class, r44.getAppletRuntime());
        r46.i.e(d3.z.class, new m(r44));
        this.m = r46;
        Intrinsics.checkNotNullParameter(AIBridgeSetTitleMethod.class, "clazz");
        r46.b.b(AIBridgeSetTitleMethod.class);
        d3.w r48 = this.m;
        if (r48 == null) goto L84;
        r48.k(r45);
    L84:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new LynxEngineAssem$initLynxView$3(this, null), 2, null);
        return;
    L67:
        r41 = 0;
        goto L68
    L53:
        if (r36.A != true) goto L55;
        r114 = true;
    L49:
        r35 = "";
    L44:
        r112 = null;
    L36:
        r111 = null;
    L26:
        r110 = null;
        goto L27
    L86:
        com.bytedance.ai.utils.g.a.w("LynxEngineAssem", "context is null");
        return;
    L11:
        r13 = null;
        goto L12
    }

    @Override // k2.q
    public final String url() {
        com.bytedance.ai.lynx.g r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTemplateUrl();
    }

    public LynxEngineAssem() {
        if (((Assem) this).d == null) goto L5;
        boolean r1 = true;
    L6:
        this.k = new com.bytedance.assem.arch.extensions.f(r1, com.bytedance.assem.arch.extensions.d.a(this, k2.b.class));
        com.bytedance.assem.arch.viewModel.g.c r0 = com.bytedance.assem.arch.viewModel.g.c.a;
        final KClass r10 = Reflection.getOrCreateKotlinClass(RenderStateVM.class);
        Function0<String> r11 = new LynxEngineAssem$special$$inlined$assemViewModel$default$1(r10);
        LynxEngineAssem$special$$inlined$assemViewModel$default$2 r12 = LynxEngineAssem$special$$inlined$assemViewModel$default$2.INSTANCE;
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.a.a) == false) goto L10;
        com.bytedance.assem.arch.viewModel.b r13 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.c(this, true), VMExtKt.f(this, true), VMExtKt.b(), r12, VMExtKt.a(this, true), VMExtKt.e(this, true));
    L19:
        this.l = r13;
        this.n = new Handler(Looper.getMainLooper());
        this.q = new c(this);
        return;
    L10:
        if (Intrinsics.areEqual(r0, r0) == false) goto L12;
        r13 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.c(this, false), VMExtKt.f(this, false), VMExtKt.b(), r12, VMExtKt.a(this, false), VMExtKt.e(this, false));
        goto L19
    L12:
        if (r0 != null) goto L14;
    L18:
        r13 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.b(), r12, VMExtKt.j(this), VMExtKt.k(this));
        goto L19
    L14:
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.b.a) == true) goto L18;
        throw new IllegalArgumentException("Don't support this VMScope here.");
    L5:
        r1 = false;
        goto L6
    }

    @Override // k2.q
    public final void doRefresh() {
        u();
    }

    @Override // k2.o
    public final View engineView() {
        return this.j;
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        return this.m;
    }

    public final Lifecycle getLifecycle() {
        return ((Assem) this).c;
    }

    @Override // k2.o
    public final View realView() {
        return this.j;
    }

    @Override // k2.q
    public final void b(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        ((RenderStateVM) this.l.getValue()).updateState(new i5.k(r10));
    }

    public final void r(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        k2.b r11 = t();
        String r0 = null;
        if (r11 == null) goto L11;
        k2.j r12 = r11.n;
        if (r12 == null) goto L11;
        PageInfo r13 = r12.getPageInfo();
        if (r13 == null) goto L11;
        Map<String, Object> r14 = r13.getTraceInfo();
        if (r14 == null) goto L11;
        Object r15 = r14.get("trace_id");
    L13:
        if ((r15 instanceof String) == false) goto L15;
        String r16 = (String) r15;
    L16:
        this.o = r16;
        k2.b r17 = t();
        if (r17 == null) goto L25;
        k2.j r18 = r17.n;
        if (r18 == null) goto L25;
        PageInfo r19 = r18.getPageInfo();
        if (r19 == null) goto L25;
        Map<String, Object> r20 = r19.getTraceInfo();
        if (r20 == null) goto L25;
        Object r21 = r20.get("eventName");
    L27:
        if ((r21 instanceof String) == false) goto L29;
        r0 = (String) r21;
    L29:
        this.p = r0;
        u();
        return;
    L25:
        r21 = null;
        goto L27
    L15:
        r16 = null;
    L11:
        r15 = null;
        goto L13
    }

    @Override // k2.q
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        ((RenderStateVM) this.l.getValue()).updateState(new i5.f(r10));
    }

    public static final Object s(LynxEngineAssem r14, Continuation r15) {
        r14.getClass();
        if ((r15 instanceof LynxEngineAssem$loadTemplateBundleFromPackage$1) == false) goto L7;
        LynxEngineAssem$loadTemplateBundleFromPackage$1 r0 = (LynxEngineAssem$loadTemplateBundleFromPackage$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        LynxEngineAssem$loadTemplateBundleFromPackage$1 r10 = r0;
        Object r16 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r10.label;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        String r17 = (String) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L65:
        r11 = (TemplateBundle) r16;
        String r18 = r17;
    L67:
        com.bytedance.ai.utils.g.a.i("LynxEngineAssem", "loadTemplateBundleFromPackage: end loading " + r18);
    L68:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        com.bytedance.ai.utils.g.a.i("LynxEngineAssem", "loadTemplateBundleFromPackage: start loading");
        k2.b r19 = r14.t();
        if (r19 == null) goto L23;
        k2.j r110 = r19.n;
        if (r110 == null) goto L23;
        AppletRuntime r111 = r110.getAppletRuntime();
        if (r111 == null) goto L23;
        Applet r112 = r111.h;
        if (r112 == null) goto L23;
        r18 = r112.x;
    L24:
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        k2.b r22 = r14.t();
        if (r22 == null) goto L37;
        k2.j r23 = r22.n;
        if (r23 == null) goto L37;
        AppletRuntime r24 = r23.getAppletRuntime();
        if (r24 == null) goto L37;
        Applet r25 = r24.h;
        if (r25 == null) goto L37;
        if (r25.E != 1) goto L35;
        boolean r26 = true;
    L36:
        r13.element = r26;
        r20.element = r25.b;
        goto L37
    L35:
        r26 = false;
    L37:
        k2.b r27 = r14.t();
        if (r27 == null) goto L44;
        k2.j r28 = r27.n;
        if (r28 == null) goto L44;
        PageInfo r29 = r28.getPageInfo();
        if (r29 == null) goto L44;
        String r30 = r29.getPageName();
    L45:
        r21.element = r30;
        com.bytedance.ai.lynx.g r31 = r14.j;
        if (r31 == null) goto L53;
        k2.b r113 = r14.t();
        if (r113 == null) goto L51;
        String r114 = r113.b;
        if (r114 == null) goto L51;
    L52:
        r31.k(r114, (String) r20.element, (String) r21.element);
    L51:
        r114 = "";
    L53:
        k2.b r115 = r14.t();
        if (r115 == null) goto L66;
        String r116 = r115.b;
        if (r116 == null) goto L66;
        int r32 = AppletLynxViewApi.a;
        if (r18 != null) goto L60;
        String r33 = "";
    L61:
        boolean r34 = r13.element;
        String r35 = (String) r20.element;
        String r36 = (String) r21.element;
        r10.L$0 = r18;
        r10.label = 1;
        Object r117 = AppletLynxViewApi.b(r33, r116, r34, r35, r36, r10);
        if (r117 == r11) goto L68;
        String r118 = r18;
        r16 = r117;
        r17 = r118;
        goto L65
    L60:
        r33 = r18;
    L66:
        r11 = null;
    L44:
        r30 = null;
    L23:
        r18 = null;
    L7:
        r0 = new LynxEngineAssem$loadTemplateBundleFromPackage$1(r14, r15);
        goto L8
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        d3.w r0 = this.m;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }
}
