package com.bytedance.ai.applet.app;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication$onOptionsItemSelected$1$1", f = "AppletApplication.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
public final class AppletApplication$onOptionsItemSelected$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletAppActivity $activity;
    final /* synthetic */ com.bytedance.ai.applet.app.view.m $item;
    int label;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$onOptionsItemSelected$1$1(AppletApplication r1, com.bytedance.ai.applet.app.view.m r10, AppletAppActivity r11, Continuation<? super AppletApplication$onOptionsItemSelected$1$1> r12) {
        this.this$0 = r1;
        this.$item = r10;
        this.$activity = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletApplication$onOptionsItemSelected$1$1(this.this$0, this.$item, this.$activity, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.bytedance.ai.applet.app.AppletAppActivity] */
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
        boolean r11 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        AppMeta r12 = (AppMeta) r10;
        if (r12 == null) goto L15;
        String r13 = r12.getAppName();
        if (r13 == null) goto L15;
    L16:
        String r14 = r13;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == 0) goto L27;
        com.bytedance.ai.applet.app.view.m r16 = this.$item;
        ?? r17 = this.$activity;
        AppletApplication r18 = this.this$0;
        Integer r19 = r16.c;
        if (r19 != null) goto L22;
    L24:
        r11 = false;
    L25:
        LinkedHashMap r20 = new LinkedHashMap();
        r20.put("isPin", Boxing.boxBoolean(r11));
        r15.d(r17, r16.a, r18.getAppId(), r14, r20);
        r18.c(r17, r11);
        goto L27
    L22:
        if (r19.intValue() != 2131235797) goto L24;
    L27:
        return Unit.INSTANCE;
    L15:
        r13 = this.this$0.j().a;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletApplication r110 = this.this$0;
        this.label = 1;
        r10 = r110.k(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
