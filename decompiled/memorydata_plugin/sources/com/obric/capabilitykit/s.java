package com.obric.capabilitykit;

import android.app.Application;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u0012*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentDispatcherClient;", "", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onIntentReceived", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/IMAppAction;", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "jobId", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toBaseResultExt", "Lcom/obric/capabilitykit/common/BaseResultExt;", "Ljava/util/concurrent/ConcurrentHashMap;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f7605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7606b = "IntentDispatcher";
    private static final al c = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentDispatcherClient", f = "IntentDispatcherClient.kt", i = {0, 0, 0}, l = {36}, m = "onIntentReceived", n = {"intentCalling", "context", CommonConsts.APM_INNER_EVENT_COST_START}, s = {"L$0", "L$1", "J$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f7608b;
        public long c;
        public /* synthetic */ Object d;
        public final /* synthetic */ s e;
        public int f;

        public a(s r3, Continuation<? super a> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.e = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.e.a(null, null, this);
        }
    }

    static {
        f7605a = new s();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$s$jFgaDheJ95aBB_Zbd0wlHZGU9Jw.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …intent-dispatcher\")\n    }");
        c = am.a(bo.a(r0));
    }

    private s() {
    }

    private final BaseResultExt a(ConcurrentHashMap<String, String> r1) {
        BaseResultExt r0 = new BaseResultExt();
        r0.putAll(r1);
        return r0;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "intent-dispatcher");
    }

    public static /* synthetic */ Thread lambda$jFgaDheJ95aBB_Zbd0wlHZGU9Jw(Runnable r0) {
        return a(r0);
    }

    public final Object a(IntentCalling r38, String r39, Continuation<? super Pair<? extends IntentResult<?>, IMAppAction>> r40) {
        IntentCalling r0 = r38;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r40, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");
        int r4 = r3.f;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.f = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.d;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.f;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r3.c;
        Application r8 = (Application) ZeusTransformUtils.preCheckCast(r3.f7608b, Application.class, "com.obric.memorydata.plugin");
        IntentCalling r9 = (IntentCalling) ZeusTransformUtils.preCheckCast(r3.f7607a, IntentCalling.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        Application r10 = r8;
        r0 = r9;
        Object r11 = r2;
    L18:
        IntentResult r12 = (IntentResult) ZeusTransformUtils.preCheckCast(r11, IntentResult.class, "com.obric.memorydata.plugin");
        long r13 = System.currentTimeMillis() - r7;
        String r14 = r10.getString(ZeusTransformUtils.mapRes(R.string.obric_action_success, TypedValues.Custom.S_STRING, "obric_action_success"));
        Intrinsics.checkNotNullExpressionValue(r14, "context.getString(R.string.obric_action_success)");
        String r15 = r10.getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, TypedValues.Custom.S_STRING, "obric_action_failed"));
        Intrinsics.checkNotNullExpressionValue(r15, "context.getString(R.string.obric_action_failed)");
        if (r12.getRet() != 0) goto L25;
        String r16 = r12.getDetails();
        if (r16 == null) goto L24;
        r14 = r16;
    L24:
        r12.setDetails(r14);
    L25:
        Gson r17 = UtilsKt.getGson();
        int r18 = r12.getRet();
        String r19 = r12.getDetails();
        if (r19 != null) goto L28;
        String r110 = r15;
    L29:
        String r26 = r17.toJson(new FeedbackResult(r18, r110, null, r12.getUiType(), String.valueOf(r0.getReplyFor()), false, 36, null));
        if ((r12.getUiType() & 32) == 0) goto L32;
    L69:
        String r21 = UUID.randomUUID().toString();
        long r22 = r0.getMessageId();
        long r20 = r0.getQuestionId();
        long r23 = r0.getMessageId();
        long r28 = r0.getActionId();
        long r30 = r0.getJobId();
        IMAppActionExt r24 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r25 = r12.getExt();
        if (r25 == null) goto L74;
        BaseResultExt r27 = f7605a.a(r25);
        if (r27 == null) goto L74;
        String r29 = r27.getResultDetailExtras();
    L75:
        r24.setActionDetailExtras(r29);
        r24.put("app_cost", String.valueOf(r13));
        ConcurrentHashMap<String, String> r31 = r12.getExt();
        if (r31 == null) goto L79;
        r24.putAll(r31);
    L79:
        return new Pair(r12, new IMAppAction(0, Boxing.boxLong(r23), r21, r22, Boxing.boxLong(r20), null, r26, null, r28, r30, 0, r24, 1185, null));
    L74:
        r29 = null;
        goto L75
    L32:
        if ((r12.getUiType() & 64) != 0) goto L69;
        if ((r12.getUiType() & 128) != 0) goto L69;
        if ((r12.getUiType() & 512) != 0) goto L69;
        if ((r12.getUiType() & 1024) != 0) goto L69;
        if ((r12.getUiType() & 2048) != 0) goto L69;
        if ((r12.getUiType() & 4096) != 0) goto L69;
        if ((r12.getUiType() & 8192) != 0) goto L69;
        if ((r12.getUiType() & 16384) != 0) goto L69;
        if ((r12.getUiType() & 32768) != 0) goto L69;
        if ((r12.getUiType() & 524288) != 0) goto L69;
        if ((r12.getUiType() & 65536) != 0) goto L69;
        if ((r12.getUiType() & 131072) != 0) goto L69;
        if ((r12.getUiType() & 1048576) != 0) goto L69;
        if ((r12.getUiType() & 262144) != 0) goto L69;
        if ((r12.getUiType() & 2097152) != 0) goto L69;
        if ((r12.getUiType() & 8388608) != 0) goto L69;
        String r210 = UUID.randomUUID().toString();
        long r211 = r0.getMessageId();
        long r32 = r0.getQuestionId();
        long r33 = r0.getMessageId();
        long r212 = r0.getActionId();
        long r34 = r0.getJobId();
        IMAppActionExt r35 = new IMAppActionExt();
        r35.put("app_cost", String.valueOf(r13));
        ConcurrentHashMap<String, String> r36 = r12.getExt();
        if (r36 == null) goto L68;
        r35.putAll(r36);
    L68:
        return new Pair(r12, new IMAppAction(0, Boxing.boxLong(r33), r210, r211, Boxing.boxLong(r32), null, r26, null, r212, r34, 0, r35, 1185, null));
    L28:
        r110 = r19;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        long r37 = System.currentTimeMillis();
        t r41 = t.f7622a;
        r3.f7607a = r0;
        r3.f7608b = r10;
        r3.c = r37;
        r3.f = 1;
        r11 = r41.a(r10, r0, r39, r3);
        if (r11 != r5) goto L17;
        return r5;
    L17:
        r7 = r37;
    L7:
        r3 = new a(this, r1);
        goto L8
    }

    public final al a() {
        return c;
    }
}
