package com.obric.capabilitykit;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.logger.Logger;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.ci;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/ActionManager;", "", "()V", "ACTION_TOAST_DURATION", "", "REGISTERED_ACTIONS", "", "", "Lcom/obric/capabilitykit/common/BaseFunction;", "TAG", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "addTool", "", "action", "getTool", ActivityLifecycle.NAME, "handleAction", "Lcom/obric/capabilitykit/common/BaseResult;", "Lcom/obric/capabilitykit/common/IMAppAction;", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTool", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7468b = "ActionManager";
    private static final long c = 2000;
    private static final Map<String, BaseFunction> d = null;
    private static final Lazy e = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager", f = "ActionManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {74, 79, 93}, m = "handleAction", n = {"action", "dispatchContext", "targetAction", "result", "action", "dispatchContext", "targetAction", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7470b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public final /* synthetic */ b g;
        public int h;

        public a(b r3, Continuation<? super a> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.f = r2;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$2", f = "ActionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0368b extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<BaseResult> f7472b;
        public final /* synthetic */ DispatchContext c;

        public C0368b(Ref.ObjectRef<BaseResult> r3, DispatchContext r4, Continuation<? super C0368b> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.f7472b = r3;
            this.c = r4;
            super(2, r6);
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((C0368b) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C0368b.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new C0368b(this.f7472b, this.c, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f7471a != 0) goto L21;
            ResultKt.throwOnFailure(r9);
            ((BaseResult) ZeusTransformUtils.preCheckCast(this.f7472b.element, BaseResult.class, "com.obric.memorydata.plugin")).getUiType();
            if ((((BaseResult) ZeusTransformUtils.preCheckCast(this.f7472b.element, BaseResult.class, "com.obric.memorydata.plugin")).getUiType() & 8) == 0) goto L19;
            b r10 = b.f7467a;
            if (b.a(r10).isKeyguardLocked() == false) goto L19;
            boolean r1 = false;
            Method r3 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L13
            r3.setAccessible(true);     // Catch: Exception -> L13
            Object r11 = r3.invoke(b.a(r10), new Object[]{null});     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
            r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Exception -> L13
        L15:
            Logger.INSTANCE.d(b.f7468b, "handleAction,dismissKeyguardToLaunch: " + r1);
            if (r1 == true) goto L19;
            ((BaseResult) ZeusTransformUtils.preCheckCast(this.f7472b.element, BaseResult.class, "com.obric.memorydata.plugin")).setDetails(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_dismiss_keyguard_failed, TypedValues.Custom.S_STRING, "obric_dismiss_keyguard_failed")));
        L13:
            e = move-exception;
            Logger.INSTANCE.e(b.f7468b, "handleAction,dismissKeyguardToLaunch failed", e);
        L19:
            return Unit.INSTANCE;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/BaseResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$result$1", f = "ActionManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<al, Continuation<? super BaseResult>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseFunction f7474b;
        public final /* synthetic */ Ref.ObjectRef<JsonObject> c;
        public final /* synthetic */ DispatchContext d;

        public c(BaseFunction r3, Ref.ObjectRef<JsonObject> r4, DispatchContext r5, Continuation<? super c> r6) {
            BaseFunction r7 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r3, BaseFunction.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.f7474b = r7;
            this.c = r4;
            this.d = r5;
            super(2, r8);
        }

        public final Object a(al r3, Continuation<? super BaseResult> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return new c(this.f7474b, this.c, this.d, r5);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super BaseResult> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7473a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BaseFunction r7 = this.f7474b;
            JsonObject r2 = ((JsonObject) ZeusTransformUtils.preCheckCast(this.c.element, JsonObject.class, "com.obric.memorydata.plugin")).getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(r2, "params.asJsonObject");
            DispatchContext r3 = this.d;
            this.f7473a = 1;
            r6 = r7.doAction(r2, r3, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7475a = null;

        static {
            f7475a = new d();
        }

        public d() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(r2, KeyguardManager.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f7467a = new b();
        d = new LinkedHashMap();
        e = LazyKt.lazy(d.f7475a);
    }

    private b() {
    }

    private final KeyguardManager a() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(e.getValue(), KeyguardManager.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ KeyguardManager a(b r0) {
        return r0.a();
    }

    public final BaseFunction a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Map<String, BaseFunction> r1 = d;
        if (r1.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (BaseFunction) ZeusTransformUtils.preCheckCast(r1.get(r2), BaseFunction.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference failed for: r11v25, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, com.google.gson.JsonObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v24, types: [T, com.obric.capabilitykit.common.BaseResult] */
    /* JADX WARN: Type inference failed for: r1v41, types: [T, com.obric.capabilitykit.common.BaseResult] */
    public final Object a(IMAppAction r26, Continuation<? super BaseResult> r27) {
        IMAppAction r0 = r26;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");
        int r4 = r3.h;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.h = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.h;
        if (r6 == 0) goto L17;
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.f7469a, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L54:
        return r7.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r8 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.e, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r9 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.d, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        BaseFunction r10 = (BaseFunction) ZeusTransformUtils.preCheckCast(r3.c, BaseFunction.class, "com.obric.memorydata.plugin");
        DispatchContext r11 = (DispatchContext) ZeusTransformUtils.preCheckCast(r3.f7470b, DispatchContext.class, "com.obric.memorydata.plugin");
        IMAppAction r12 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f7469a, IMAppAction.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        Ref.ObjectRef r13 = r8;
        r0 = r12;
    L46:
        r13.element = (BaseResult) ZeusTransformUtils.preCheckCast(r2, BaseResult.class, "com.obric.memorydata.plugin");
        if (r9.element != 0) goto L49;
        String r15 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_exe_success, TypedValues.Custom.S_STRING, "obric_action_exe_success"));
        Intrinsics.checkNotNullExpressionValue(r15, "AppHost.application.getS…obric_action_exe_success)");
        r9.element = new BaseResult(null, null, 0, r15, null, 0, null, null, 243, null);
    L49:
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.element, BaseResult.class, "com.obric.memorydata.plugin")).setQuestionId(r0.getQuestionId());
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.element, BaseResult.class, "com.obric.memorydata.plugin")).setReplyId(r0.getMessageId());
        ((BaseResult) ZeusTransformUtils.preCheckCast(r9.element, BaseResult.class, "com.obric.memorydata.plugin")).setReplyFor(r10.getName());
        ci r14 = ba.b();
        C0368b r16 = new C0368b(r9, r11, null);
        r3.f7469a = r9;
        r3.f7470b = null;
        r3.c = null;
        r3.d = null;
        r3.e = null;
        r3.h = 3;
        if (kotlinx.coroutines.i.a(r14, r16, r3) != r5) goto L52;
        return r5;
    L52:
        r7 = r9;
        goto L54
    L17:
        ResultKt.throwOnFailure(r2);
        Logger.INSTANCE.d(f7468b, "handleAction questionId:" + r26.getQuestionId());
        String r17 = r26.getContent();
        if (r17 != null) goto L20;
    L23:
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        JsonObject r19 = new JsonObject();
    L27:
        Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = new JsonObject();
        JsonElement r110 = r19.get("Params");     // Catch: Exception -> L32
        if (r110.isJsonNull() == true) goto L33;
        ?? r111 = JsonParserExt.INSTANCE.parseString(r110.getAsString()).getAsJsonObject();     // Catch: Exception -> L32
        Intrinsics.checkNotNullExpressionValue(r111, "JsonParserExt.parseStrin…tr.asString).asJsonObject");     // Catch: Exception -> L32
        r20.element = r111;     // Catch: Exception -> L32
    L33:
        String r21 = r19.get("OperationId").getAsString();
        DispatchContext r112 = new DispatchContext((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), r26.getQuestionId(), null, 4, null);
        BaseFunction r22 = (BaseFunction) ZeusTransformUtils.preCheckCast(d.get(r21), BaseFunction.class, "com.obric.memorydata.plugin");
        String r113 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r112.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_not_support, TypedValues.Custom.S_STRING, "obric_action_not_support"));
        Intrinsics.checkNotNullExpressionValue(r113, "dispatchContext.context.…obric_action_not_support)");
        if (r22 == null) goto L36;
        r13 = new Ref.ObjectRef();
        if (r22.isBlock() == false) goto L42;
        JsonObject r23 = ((JsonObject) ZeusTransformUtils.preCheckCast(r20.element, JsonObject.class, "com.obric.memorydata.plugin")).getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r23, "params.asJsonObject");
        r3.f7469a = r0;
        DispatchContext r114 = r112;
        r3.f7470b = r114;
        r3.c = r22;
        r3.d = r13;
        r3.e = r13;
        r3.h = 1;
        Object r24 = r22.doAction(r23, r114, r3);
        if (r24 != r5) goto L45;
        return r5;
    L45:
        r10 = r22;
        r2 = r24;
        r9 = r13;
        r11 = r114;
        goto L46
    L42:
        r114 = r112;
        c r25 = new c(r22, r20, r114, null);
        r3.f7469a = r0;
        r3.f7470b = r114;
        r3.c = r22;
        r3.d = r13;
        r3.e = r13;
        r3.h = 2;
        r24 = da.b(3000, r25, r3);
        if (r24 != r5) goto L45;
        return r5;
    L36:
        return new BaseResult(r26.getQuestionId(), r26.getMessageId(), 1, r113, null, 0, null, null, 224, null);
    L32:
        ?? r115 = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
        Intrinsics.checkNotNullExpressionValue(r115, "JsonParserExt.parseString(\"{}\").asJsonObject");
        r20.element = r115;
        goto L33
    L26:
        r19 = JsonParserExt.INSTANCE.parseString(r26.getContent()).getAsJsonObject();
        goto L27
    L20:
        if (r17.length() == 0) goto L23;
        r18 = false;
    L7:
        r3 = new a(this, r1);
        goto L8
    }

    public final void a(BaseFunction r2) {
        BaseFunction r1 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r2, BaseFunction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "action");
        d.put(r1.getName(), r1);
    }

    public final void b(BaseFunction r2) {
        BaseFunction r1 = (BaseFunction) ZeusTransformUtils.wrapperContextForParams(r2, BaseFunction.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "action");
        d.remove(r1.getName());
    }
}
