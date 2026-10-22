package com.bytedance.ai.applet.page;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletShowMode;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader;
import com.bytedance.ai.applet.app.foundation.performance.r;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import d3.a0;
import d3.w;
import d3.z;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.page.AppletPageFragment$loadLynxView$1", f = "AppletPageFragment.kt", i = {0}, l = {427}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AppletPageFragment$loadLynxView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnlineAppletApplication $app;
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Page $page;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletPageFragment this$0;

    public AppletPageFragment$loadLynxView$1(AppletPageFragment r1, Page r10, OnlineAppletApplication r11, ViewGroup r12, Continuation<? super AppletPageFragment$loadLynxView$1> r13) {
        this.this$0 = r1;
        this.$page = r10;
        this.$app = r11;
        this.$container = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletPageFragment$loadLynxView$1 r12 = new AppletPageFragment$loadLynxView$1(this.this$0, this.$page, this.$app, this.$container, r11);
        r12.L$0 = r10;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.View, android.widget.FrameLayout, com.bytedance.ai.lynx.g, com.lynx.tasm.LynxView] */
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
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r12 = ((Result) r19).unbox-impl();
    L15:
        Page r13 = this.$page;
        AppletPageFragment r14 = this.this$0;
        Throwable r15 = Result.exceptionOrNull-impl(r12);
        AppletShowMode r16 = null;
        if (r15 != null) goto L67;
        TemplateBundle r17 = (TemplateBundle) r12;
        r r18 = this.this$0.p;
        if (r18 == null) goto L20;
        Boxing.boxBoolean(r18.m());
    L20:
        this.this$0.d.c("loadLynxView: load templateBundle success");
        Context r110 = this.this$0.getContext();
        if (r110 != null) goto L24;
        AppletPageFragment r20 = this.this$0;
        r20.d.a("loadLynxView: context is null", null);
        r20.U90("context is null", AppletErrorCode.LYNX_VIEW_CREATE_ERROR.getType());
        return Unit.INSTANCE;
    L24:
        r r21 = this.this$0.p;
        if (r21 == null) goto L27;
        Boxing.boxBoolean(r21.j());
    L27:
        final AppletPageFragment r22 = this.this$0;
        final OnlineAppletApplication r23 = this.$app;
        final Applet r24 = r23.j();
        AppletPageTimelineTracker r25 = r22.m;
        if (r25 == null) goto L30;
        i1 r26 = y0.a;
        y0.g(r25.a, "applet_page_timeline_full");
    L30:
        String r27 = r24.x;
        if (r27 != null) goto L33;
        String r111 = "";
    L34:
        final s4.c r28 = new s4.c();
        int r29 = AppletLynxViewApi.a;
        h2.a r30 = f2.b.c;
        if (r30 == null) goto L40;
        String r31 = r30.m;
        if (r31 == null) goto L40;
        String r112 = r31;
    L41:
        final ?? r32 = AppletLynxViewApi.a(r110, r112, r111, r22.e, null, new c(r22), new d(r24, r23, r28, r22), 16);
        r32.addLynxViewClient(new l(r22));
        com.bytedance.ai.debug.f.a.a(r32, r24.A);
        new com.bytedance.ai.debug.d(true, new e(r22, r32, r24)).a(r32);
        w r33 = r22.o;
        r33.j(r32);
        r33.i.e(a0.class, new k(r23, r22));
        r33.i.e(z.class, new f(r23));
        r33.d(new o4.b());
        r33.d(new k4.a());
        r22.o.k(r32.h(r28));
        this.this$0.i = r32;
        r32.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.$container.addView(r32);
        r r34 = this.this$0.p;
        if (r34 == null) goto L44;
        Boxing.boxBoolean(r34.i(r32.i));
    L44:
        this.this$0.d.c("loadLynxView: url = " + this.this$0.f);
        String r35 = this.$app.j().b;
        TemplateData r113 = TemplateData.empty();
        Pair[] r36 = new Pair[2];
        boolean r37 = false;
        r36[0] = TuplesKt.to("__LOCATION__", this.this$0.f);
        AppletAppActivity r38 = this.this$0.getActivity();
        if ((r38 instanceof AppletAppActivity) == false) goto L47;
        AppletAppActivity r39 = r38;
    L48:
        if (r39 == null) goto L51;
        r16 = r39.L1();
    L51:
        if (r16 != AppletShowMode.EIGHT_SCREEN) goto L53;
        r37 = true;
    L53:
        r36[1] = TuplesKt.to("__PAGE_META__", MapsKt.mapOf(TuplesKt.to("isInChat", Boxing.boxBoolean(r37))));
        Map r114 = MapsKt.mapOf(r36);
        String r40 = this.this$0.f;
        if (r40 != null) goto L56;
        r40 = "";
    L56:
        r32.k(r40, r35, this.$page.getId());
        r r41 = this.this$0.p;
        if (r41 == null) goto L59;
        Boxing.boxBoolean(r41.l());
    L59:
        AppletPageFragment r42 = this.this$0;
        String r43 = r42.f;
        if (r43 != null) goto L62;
        r43 = "";
    L62:
        r32.i(r43, r17, r113, r42.q, r114);
        r r44 = this.this$0.p;
        if (r44 == null) goto L66;
        Boxing.boxBoolean(r44.k());
    L66:
        return Unit.INSTANCE;
    L47:
        r39 = null;
    L40:
        r112 = "";
        goto L41
    L33:
        r111 = r27;
        goto L34
    L67:
        StringBuilder r45 = new StringBuilder("loadPageTemplateBundle failed, page = ");
        r45.append(r13.getPath());
        r45.append(", reason = ");
        String r46 = r15.getMessage();
        if (r46 != null) goto L70;
        r46 = "unknown";
    L70:
        r45.append(r46);
        String r47 = r45.toString();
        AtomicInteger r48 = com.bytedance.ai.applet.base.log.d.d;
        r14.d.a("loadLynxView: " + r47, null);
        r14.U90(r47, AppletErrorCode.TEMPLATE_BUNDLE_EMPTY.getType());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r49 = (CoroutineScope) this.L$0;
        this.this$0.d.c("loadLynxView: page = " + this.$page.getPath());
        r r50 = this.this$0.p;
        if (r50 == null) goto L11;
        Boxing.boxBoolean(r50.n());
    L11:
        AppletAppResourceLoader r51 = this.$app.h().m;
        Page r52 = this.$page;
        this.L$0 = r49;
        this.label = 1;
        Object r53 = r51.e(r52, this);
        if (r53 != r1) goto L14;
        return r1;
    L14:
        r12 = r53;
        goto L15
    }
}
