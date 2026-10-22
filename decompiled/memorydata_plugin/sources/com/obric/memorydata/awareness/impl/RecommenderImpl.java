package com.obric.memorydata.awareness.impl;

import com.bytedance.rpc.model.ActionType;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.api.IRecommender;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/impl/RecommenderImpl;", "Lcom/obric/memorydata/awareness/api/IRecommender;", "<init>", "()V", "getInst", "recommend", "", "data", "Lorg/json/JSONArray;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommenderImpl implements IRecommender {
    public static final RecommenderImpl INSTANCE = null;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.RecommenderImpl$recommend$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.impl.RecommenderImpl$recommend$1", f = "RecommenderImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new RecommenderImpl();
    }

    private RecommenderImpl() {
    }

    @JvmStatic
    public static final RecommenderImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.awareness.api.IRecommender
    public void recommend(JSONArray r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        int r14 = r15.length();
        int r0 = 0;
    L3:
        if (r0 >= r14) goto L22;
        JSONObject r1 = r15.getJSONObject(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "getJSONObject(...)");
        Object r2 = r1.opt("type");
        Object r3 = r1.opt("title");
        Object r4 = r1.opt(Params.CONTENT);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "type " + r2 + " title " + r3 + " content " + r4 + " action " + r1.opt("action"), false, 4, null);
        if (Intrinsics.areEqual(r2, Integer.valueOf(ActionType.Push.getValue())) == false) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L21;
        new com.obric.memorydata.awareness.d().a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    L21:
        r0 = r0 + 1;
        goto L3
    L12:
        if (Intrinsics.areEqual(r2, Integer.valueOf(ActionType.Proactive_Dialogue.getValue())) == false) goto L21;
        if (b.f8632a.c() == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L21;
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 1, null);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "notifyActiveMessage error " + e.getMessage(), null, 4, null);
        goto L21
    }
}
