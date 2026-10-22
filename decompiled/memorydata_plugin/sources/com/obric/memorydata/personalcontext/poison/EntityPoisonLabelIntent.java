package com.obric.memorydata.personalcontext.poison;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePCEntityPoisonLabelIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCEntityPoisonLabelParams;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelIntent;", "Lcom/obric/capabilitykit/common/intent/BasePCEntityPoisonLabelIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/PCEntityPoisonLabelParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PCEntityPoisonLabelParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "failure", "details", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityPoisonLabelIntent extends BasePCEntityPoisonLabelIntent {
    private static final a Companion = null;

    @Deprecated
    public static final String TAG = "EntityPoisonLabelIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelIntent$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.poison.EntityPoisonLabelIntent$doAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.poison.EntityPoisonLabelIntent", f = "EntityPoisonLabelIntent.kt", i = {0}, l = {26}, m = "doAction", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EntityPoisonLabelIntent this$0;

        AnonymousClass1(EntityPoisonLabelIntent r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public EntityPoisonLabelIntent() {
    }

    private final IntentResult<Empty> failure(String r14) {
        return new IntentResult(1, null, null, r14, false, false, 256, null, null, null, 950, null);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCEntityPoisonLabelIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((PCEntityPoisonLabelParams) ZeusTransformUtils.preCheckCast(r6, PCEntityPoisonLabelParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCEntityPoisonLabelIntent
    public Object doAction(PCEntityPoisonLabelParams r24, DispatchContext r25, Continuation<? super IntentResult<Empty>> r26) {
        EntityPoisonLabelIntent r1 = this;
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        r1 = (EntityPoisonLabelIntent) ZeusTransformUtils.preCheckCast(r3.L$0, EntityPoisonLabelIntent.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L14 IllegalArgumentException -> L16
    L27:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14 IllegalArgumentException -> L16
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "label callback completed, updated=" + r6.a() + ", skipped=" + r6.b(), false, 4, null);     // Catch: Exception -> L14 IllegalArgumentException -> L16
    L38:
        return new IntentResult(0, null, null, new JSONObject().put("updatedCount", r6.a()).put("skippedCount", r6.b()).toString(), false, false, 256, null, null, null, 950, null);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r2);
        String r7 = r24.getOperateList();
        if (r7 == null) goto L23;
        b r8 = d.f12250a.a(r24.getLabelVersion(), r7);     // Catch: Exception -> L14 IllegalArgumentException -> L16
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14 IllegalArgumentException -> L16
        Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new EntityPoisonLabelIntent$doAction$result$1(r8, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14 IllegalArgumentException -> L16
        r3.L$0 = r1;     // Catch: Exception -> L14 IllegalArgumentException -> L16
        r3.label = 1;     // Catch: Exception -> L14 IllegalArgumentException -> L16
        r2 = i.a(r9, r10, r3);     // Catch: Exception -> L14 IllegalArgumentException -> L16
        if (r2 != r4) goto L27;
        return r4;
    L23:
        return r1.failure("operateList is required");
    L16:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid label callback: " + e.getMessage(), null, 4, null);
        String r11 = e.getMessage();
        if (r11 != null) goto L34;
        r11 = "invalid label callback";
    L34:
        return r1.failure(r11);
    L14:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "label callback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return r1.failure("label callback failed");
    L7:
        r3 = new AnonymousClass1(r1, r0);
        goto L8
    }
}
