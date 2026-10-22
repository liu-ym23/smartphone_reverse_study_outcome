package com.bytedance.ai.applet.login;

import android.app.Activity;
import com.bytedance.ai.bridge.login.AbsLoginWithDoubaoWidgetMethodIDL;
import com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor;
import com.bytedance.ai.widget.WidgetManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$loadAddShowWidget$1", f = "LoginProcessor.kt", i = {0}, l = {468}, m = "invokeSuspend", n = {"widgetManager"}, s = {"L$0"})
public final class LoginProcessor$loadAddShowWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $appletId;
    final /* synthetic */ f $drawerContainer;
    final /* synthetic */ j $loginContext;
    final /* synthetic */ h5.k $renderContext;
    final /* synthetic */ String $widgetType;
    Object L$0;
    int label;

    public LoginProcessor$loadAddShowWidget$1(h5.k r1, String r10, j r11, f r12, Activity r13, String r14, Continuation<? super LoginProcessor$loadAddShowWidget$1> r15) {
        this.$renderContext = r1;
        this.$appletId = r10;
        this.$loginContext = r11;
        this.$drawerContainer = r12;
        this.$activity = r13;
        this.$widgetType = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LoginProcessor$loadAddShowWidget$1(this.$renderContext, this.$appletId, this.$loginContext, this.$drawerContainer, this.$activity, this.$widgetType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

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
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        l2.a r11 = (l2.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L8
        r11 = r11;
    L18:
        l2.a r12 = r11;
        com.bytedance.ai.widget.contianer.h r13 = (com.bytedance.ai.widget.contianer.h) r10;     // Catch: Exception -> L8
        l2.a r14 = r12;
    L24:
        if (r13 != null) goto L30;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "loadAddShowWidget: widgetContainer is null");
        LoginProcessor r15 = LoginProcessor.a;
        j r16 = this.$loginContext;
        AppletAuthTaskMonitor.ErrorCode r17 = AppletAuthTaskMonitor.ErrorCode.UI_RENDER_FAILED;
        r15.getClass();
        LoginProcessor.d(r16, r17, "Failed to build widgetContainer.");
        f3.h<AbsLoginWithDoubaoWidgetMethodIDL.b> r18 = this.$loginContext.g;
        if (r18 == null) goto L29;
        f3.h.a.a(r18, "Failed to build widgetContainer.", null, null, 14);
    L29:
        return Unit.INSTANCE;
    L30:
        this.$drawerContainer.f();
        this.$drawerContainer.a(r14, r13);
        this.$drawerContainer.b(this.$activity);
        String r19 = this.$widgetType;
        if (Intrinsics.areEqual(r19, "mcp-agree-card") == false) goto L34;
        final OperationType r20 = OperationType.PRIVACY;
    L37:
        AppletAuthTaskMonitor.Session r21 = this.$loginContext.h;
        if (r21 == null) goto L40;
        r21.b();
    L40:
        f r22 = this.$drawerContainer;
        final String r23 = this.$appletId;
        r22.d(new m(r23, r20));
        return Unit.INSTANCE;
    L34:
        if (Intrinsics.areEqual(r19, "mcp-login-card") == false) goto L36;
        r20 = OperationType.LOGIN;
        goto L37
    L36:
        r20 = OperationType.LOGIN;
    L8:
        Exception e = e;
    L22:
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "loadAddShowWidget: 创建失败", e);
        l2.a r24 = r11;
    L23:
        r13 = null;
        r14 = r24;
        goto L24
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        WidgetManager r25 = WidgetManager.h.b();
        r24 = r25;
        if (r25 == null) goto L23;
        h5.k r26 = this.$renderContext;     // Catch: Exception -> L20
        String r27 = this.$appletId;     // Catch: Exception -> L20
        this.L$0 = r25;     // Catch: Exception -> L20
        this.label = 1;     // Catch: Exception -> L20
        Object r28 = r25.i(r26, r27, "mcp-privacy-login-card", this);     // Catch: Exception -> L20
        if (r28 != r0) goto L17;
        return r0;
    L17:
        r11 = r25;
        r10 = r28;
    L20:
        e = move-exception;
        r11 = r25;
        e = e;
        goto L22
    }
}
