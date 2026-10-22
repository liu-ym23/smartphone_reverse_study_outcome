package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Intent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseFunction;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.logger.Logger;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static final Map<String, BaseFunction> b = null;
    public static final Lazy c = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager", f = "ActionManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {74, 79, 93}, m = "handleAction", n = {"action", "dispatchContext", "targetAction", WindowEvent.Params.RESULT, "action", "dispatchContext", "targetAction", WindowEvent.Params.RESULT, WindowEvent.Params.RESULT}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public final /* synthetic */ b g;
        public int h;

        public a(b r1, Continuation<? super a> r2) {
            this.g = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.f = r2;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$2", f = "ActionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0035b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Ref.ObjectRef<BaseResult> b;
        public final /* synthetic */ DispatchContext c;

        public C0035b(Ref.ObjectRef<BaseResult> r1, DispatchContext r2, Continuation<? super C0035b> r3) {
            this.b = r1;
            this.c = r2;
            super(2, r3);
        }

        public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C0035b(this.b, this.c, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) goto L21;
            ResultKt.throwOnFailure(r8);
            ((BaseResult) this.b.element).getUiType();
            if ((((BaseResult) this.b.element).getUiType() & 8) == 0) goto L19;
            Lazy r9 = b.c;
            if (((KeyguardManager) r9.getValue()).isKeyguardLocked() == false) goto L19;
            boolean r1 = false;
            Method r2 = KeyguardManager.class.getMethod("dismissKeyguardToLaunch", new Class[]{Intent.class});     // Catch: Exception -> L13
            r2.setAccessible(true);     // Catch: Exception -> L13
            Object r10 = r2.invoke((KeyguardManager) r9.getValue(), new Object[]{null});     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L13
            r1 = ((Boolean) r10).booleanValue();     // Catch: Exception -> L13
        L15:
            Logger.INSTANCE.d("ActionManager", "handleAction,dismissKeyguardToLaunch: " + r1);
            if (r1 == true) goto L19;
            ((BaseResult) this.b.element).setDetails(this.c.getContext().getString(2131912073));
        L13:
            e = move-exception;
            Logger.INSTANCE.e("ActionManager", "handleAction,dismissKeyguardToLaunch failed", e);
        L19:
            return Unit.INSTANCE;
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/capabilitykit/common/BaseResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.capabilitykit.ActionManager$handleAction$result$1", f = "ActionManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseResult>, Object> {
        public int a;
        public final /* synthetic */ BaseFunction b;
        public final /* synthetic */ Ref.ObjectRef<JsonObject> c;
        public final /* synthetic */ DispatchContext d;

        public c(BaseFunction r1, Ref.ObjectRef<JsonObject> r2, DispatchContext r3, Continuation<? super c> r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super BaseResult> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new c(this.b, this.c, this.d, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return a((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            BaseFunction r6 = this.b;
            JsonObject r2 = ((JsonObject) this.c.element).getAsJsonObject();
            DispatchContext r3 = this.d;
            this.a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/app/KeyguardManager;", "invoke", "()Landroid/app/KeyguardManager;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class d extends Lambda implements Function0<KeyguardManager> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r0 = AppHost.Companion.getApplication().getSystemService("keyguard");
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r0;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return a();
        }
    }

    static {
        a = new b();
        b = new LinkedHashMap();
        c = LazyKt.lazy(d.a);
    }

    public b() {
    }

    public final Object a(IMAppAction r25, Continuation<? super BaseResult> r26) {
        IMAppAction r0 = r25;
        if ((r26 instanceof a) == false) goto L7;
        a r2 = (a) r26;
        int r3 = r2.h;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.h = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.h;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        Ref.ObjectRef r6 = (Ref.ObjectRef) r2.a;
        ResultKt.throwOnFailure(r1);
    L54:
        return r6.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r2.e;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r2.d;
        BaseFunction r9 = (BaseFunction) r2.c;
        DispatchContext r10 = (DispatchContext) r2.b;
        IMAppAction r11 = (IMAppAction) r2.a;
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r12 = r7;
        r0 = r11;
    L46:
        r12.element = (BaseResult) r1;
        if (r8.element != null) goto L49;
        r8.element = new BaseResult(null, null, 0, AppHost.Companion.getApplication().getString(2131911935), null, 0, null, null, 243, null);
    L49:
        ((BaseResult) r8.element).setQuestionId(r0.getQuestionId());
        ((BaseResult) r8.element).setReplyId(r0.getMessageId());
        ((BaseResult) r8.element).setReplyFor(r9.getName());
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        C0035b r14 = new C0035b(r8, r10, null);
        r2.a = r8;
        r2.b = null;
        r2.c = null;
        r2.d = null;
        r2.e = null;
        r2.h = 3;
        if (BuildersKt.withContext(r13, r14, r2) != r4) goto L52;
        return r4;
    L52:
        r6 = r8;
        goto L54
    L17:
        ResultKt.throwOnFailure(r1);
        Logger.INSTANCE.d("ActionManager", "handleAction questionId:" + r25.getQuestionId());
        String r15 = r25.getContent();
        if (r15 != null) goto L20;
    L23:
        boolean r16 = true;
    L24:
        if (r16 == false) goto L26;
        JsonObject r17 = new JsonObject();
    L27:
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = new JsonObject();
        JsonElement r19 = r17.get("Params");     // Catch: Exception -> L32
        if (r19.isJsonNull() == true) goto L33;
        r18.element = JsonParserExt.INSTANCE.parseString(r19.getAsString()).getAsJsonObject();     // Catch: Exception -> L32
    L33:
        String r20 = r17.get("OperationId").getAsString();
        DispatchContext r110 = new DispatchContext(AppHost.Companion.getApplication(), r25.getQuestionId(), null, 4, null);
        BaseFunction r21 = (BaseFunction) ((LinkedHashMap) b).get(r20);
        String r111 = r110.getContext().getString(2131911938);
        if (r21 == null) goto L36;
        r12 = new Ref.ObjectRef();
        if (r21.isBlock() == false) goto L42;
        JsonObject r22 = ((JsonObject) r18.element).getAsJsonObject();
        r2.a = r0;
        DispatchContext r112 = r110;
        r2.b = r112;
        r2.c = r21;
        r2.d = r12;
        r2.e = r12;
        r2.h = 1;
        Object r23 = r21.doAction(r22, r112, r2);
        if (r23 != r4) goto L45;
        return r4;
    L45:
        r9 = r21;
        r1 = r23;
        r8 = r12;
        r10 = r112;
        goto L46
    L42:
        r112 = r110;
        c r24 = new c(r21, r18, r112, null);
        r2.a = r0;
        r2.b = r112;
        r2.c = r21;
        r2.d = r12;
        r2.e = r12;
        r2.h = 2;
        r23 = TimeoutKt.c(3000, r24, r2);
        if (r23 != r4) goto L45;
        return r4;
    L36:
        return new BaseResult(r25.getQuestionId(), r25.getMessageId(), 1, r111, null, 0, null, null, 224, null);
    L32:
        r18.element = JsonParserExt.INSTANCE.parseString("{}").getAsJsonObject();
        goto L33
    L26:
        r17 = JsonParserExt.INSTANCE.parseString(r25.getContent()).getAsJsonObject();
        goto L27
    L20:
        if (r15.length() == 0) goto L23;
        r16 = false;
    L7:
        r2 = new a(this, r26);
        goto L8
    }
}
