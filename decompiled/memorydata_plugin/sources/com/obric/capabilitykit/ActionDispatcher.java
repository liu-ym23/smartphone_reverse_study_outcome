package com.obric.capabilitykit;

import android.app.Application;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.logger.Logger;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004J3\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001bJ?\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062'\u0010\u001f\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0019\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/ActionDispatcher;", "", "()V", "TAG", "", "<set-?>", "", "dispatchStartedQuestion", "getDispatchStartedQuestion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parallelScope", "Lkotlinx/coroutines/CoroutineScope;", "getParallelScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "getScope", "getAppActionFailResult", "Lcom/obric/capabilitykit/common/IMAppAction;", Ext.KEY_REQUEST, "code", "", NotificationCompat.CATEGORY_MESSAGE, "getIntentFailResult", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "duration", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;ILjava/lang/String;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/IMAppAction;", "launchWithTrace", "", "questionId", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;)V", "markDispatchEnded", "markDispatchStarted", "onActionReceived", "action", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActionDispatcher {
    public static final ActionDispatcher INSTANCE = null;
    private static final String TAG = "ActionDispatcher";
    private static Long dispatchStartedQuestion;
    private static final al parallelScope = null;
    private static final al scope = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher$launchWithTrace$1", f = "ActionDispatcher.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f7416b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function2<al, Continuation<? super Unit>, Object> d;

        public a(long r3, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super a> r6) {
            Function2<al, Continuation<? super Unit>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.d = r7;
            super(2, r8);
        }

        public final Object a(al r3, Continuation<? super Unit> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), a.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            a r0 = new a(this.c, this.d, r6);
            r0.f7416b = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return a((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7415a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            ActionDispatcher.access$markDispatchEnded(ActionDispatcher.INSTANCE, this.c);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            al r7 = (al) ZeusTransformUtils.preCheckCast(this.f7416b, al.class, "com.obric.memorydata.plugin");
            ActionDispatcher.access$markDispatchStarted(ActionDispatcher.INSTANCE, this.c);
            Function2<al, Continuation<? super Unit>, Object> r2 = this.d;
            this.f7415a = 1;
            if (r2.invoke(r7, this) != r0) goto L11;
            return r0;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher", f = "ActionDispatcher.kt", i = {0, 0}, l = {58}, m = "onActionReceived", n = {"action", CommonConsts.APM_INNER_EVENT_COST_START}, s = {"L$0", "J$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7418b;
        public /* synthetic */ Object c;
        public final /* synthetic */ ActionDispatcher d;
        public int e;

        public b(ActionDispatcher r3, Continuation<? super b> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.d = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.c = r2;
            this.e |= Integer.MIN_VALUE;
            return this.d.onActionReceived(null, this);
        }
    }

    static {
        INSTANCE = new ActionDispatcher();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$ActionDispatcher$aywdmJbp20ZmM29BzRWOXx9Uxvo.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …action-dispatcher\")\n    }");
        scope = am.a(bo.a(r0));
        ExecutorService r1 = Executors.newCachedThreadPool($$Lambda$ActionDispatcher$FQPYtXqtKDxYM7JfWjJo1lWPFzo.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r1, "newCachedThreadPool {\n  …spatcher-parallel\")\n    }");
        parallelScope = am.a(bo.a(r1));
    }

    private ActionDispatcher() {
    }

    public static final /* synthetic */ void access$markDispatchEnded(ActionDispatcher r0, long r1) {
        r0.markDispatchEnded(r1);
    }

    public static final /* synthetic */ void access$markDispatchStarted(ActionDispatcher r0, long r1) {
        r0.markDispatchStarted(r1);
    }

    public static /* synthetic */ IMAppAction getAppActionFailResult$default(ActionDispatcher r0, IMAppAction r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.getAppActionFailResult(r1, r2, r3);
    }

    public static /* synthetic */ IMAppAction getIntentFailResult$default(ActionDispatcher r1, IntentCalling r2, int r3, String r4, Long r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.getIntentFailResult(r2, r3, r4, r5);
    }

    public static /* synthetic */ Thread lambda$FQPYtXqtKDxYM7JfWjJo1lWPFzo(Runnable r0) {
        return parallelScope$lambda$1(r0);
    }

    public static /* synthetic */ Thread lambda$aywdmJbp20ZmM29BzRWOXx9Uxvo(Runnable r0) {
        return scope$lambda$0(r0);
    }

    private final void markDispatchEnded(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [ended qId=" + r3 + ']');
        dispatchStartedQuestion = null;
    }

    private final void markDispatchStarted(long r3) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [started qId=" + r3 + ']');
        dispatchStartedQuestion = Long.valueOf(r3);
    }

    private static final Thread parallelScope$lambda$1(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "action-dispatcher-parallel");
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "action-dispatcher");
    }

    public final IMAppAction getAppActionFailResult(IMAppAction r32, int r33, String r34) {
        Intrinsics.checkNotNullParameter(r32, Ext.KEY_REQUEST);
        Gson r0 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyId()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyId();
        Long r19 = r32.getQuestionId();
        return new IMAppAction(0, r32.getMessageId(), r16, r17, r19, null, r21, null, r32.getActionId(), r32.getJobId(), 0, null, 3233, null);
    L5:
        r4 = r34;
        goto L6
    }

    public final Long getDispatchStartedQuestion() {
        return dispatchStartedQuestion;
    }

    public final IMAppAction getIntentFailResult(IntentCalling r32, int r33, String r34, Long r35) {
        Intrinsics.checkNotNullParameter(r32, "intentCalling");
        Gson r0 = UtilsKt.getGson();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = r0.toJson(new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyFor()), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r17 = r32.getReplyFor();
        long r2 = r32.getQuestionId();
        long r5 = r32.getMessageId();
        long r23 = r32.getActionId();
        long r25 = r32.getJobId();
        if (r35 == null) goto L9;
        long r1 = r35.longValue();
        IMAppActionExt r6 = new IMAppActionExt();
        r6.put("app_cost", String.valueOf(r1));
        IMAppActionExt r28 = r6;
    L11:
        return new IMAppAction(0, Long.valueOf(r5), r16, r17, Long.valueOf(r2), null, r21, null, r23, r25, 0, r28, 1185, null);
    L9:
        r28 = null;
        goto L11
    L5:
        r4 = r34;
        goto L6
    }

    public final al getParallelScope() {
        return parallelScope;
    }

    public final al getScope() {
        return scope;
    }

    public final void launchWithTrace(long r7, Function2<? super al, ? super Continuation<? super Unit>, ? extends Object> r9) {
        Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "block");
        kotlinx.coroutines.i.a(scope, null, null, new a(r7, r6, null), 3, null);
    }

    public final Object onActionReceived(IMAppAction r37, Continuation<? super IMAppAction> r38) {
        IMAppAction r0 = r37;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r38, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
        int r4 = r3.e;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.e = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.c;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.e;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        long r7 = r3.f7418b;
        r0 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f7417a, IMAppAction.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L18:
        BaseResult r8 = (BaseResult) ZeusTransformUtils.preCheckCast(r2, BaseResult.class, "com.obric.memorydata.plugin");
        long r9 = System.currentTimeMillis() - r7;
        Gson r10 = new Gson();
        AppHost.Companion r11 = AppHost.Companion;
        String r12 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_success, TypedValues.Custom.S_STRING, "obric_action_success"));
        Intrinsics.checkNotNullExpressionValue(r12, "AppHost.application.getS…ing.obric_action_success)");
        String r13 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, TypedValues.Custom.S_STRING, "obric_action_failed"));
        Intrinsics.checkNotNullExpressionValue(r13, "AppHost.application.getS…ring.obric_action_failed)");
        if (r8.getRet() != 0) goto L25;
        String r14 = r8.getDetails();
        if (r14 == null) goto L24;
        r12 = r14;
    L24:
        r8.setDetails(r12);
    L25:
        int r15 = r8.getRet();
        String r16 = r8.getDetails();
        if (r16 != null) goto L28;
        String r17 = r13;
    L29:
        String r26 = r10.toJson(new FeedbackResult(r15, r17, null, r8.getUiType(), r8.getReplyFor(), false, 36, null));
        long r18 = 0;
        if ((r8.getUiType() & 32) == 0) goto L32;
    L76:
        String r21 = UUID.randomUUID().toString();
        Long r19 = r8.getReplyId();
        if (r19 == null) goto L79;
        r18 = r19.longValue();
    L79:
        long r22 = r18;
        Long r24 = r8.getQuestionId();
        Long r20 = r0.getMessageId();
        long r28 = r0.getActionId();
        long r30 = r0.getJobId();
        IMAppActionExt r23 = new IMAppActionExt();
        ConcurrentHashMap<String, String> r25 = r8.getExt();
        String r27 = null;
        if (ZeusTransformUtils.instanceOf(r25, BaseResultExt.class) == false) goto L82;
        BaseResultExt r29 = (BaseResultExt) ZeusTransformUtils.preCheckCast(r25, BaseResultExt.class, "com.obric.memorydata.plugin");
    L83:
        if (r29 == null) goto L85;
        r27 = r29.getResultDetailExtras();
    L85:
        r23.setActionDetailExtras(r27);
        r23.put("app_cost", String.valueOf(r9));
        ConcurrentHashMap<String, String> r31 = r8.getExt();
        if (r31 == null) goto L89;
        r23.putAll(r31);
    L89:
        return new IMAppAction(0, r20, r21, r22, r24, null, r26, null, r28, r30, 0, r23, 1185, null);
    L82:
        r29 = null;
        goto L83
    L32:
        if ((r8.getUiType() & 64) != 0) goto L76;
        if ((r8.getUiType() & 128) != 0) goto L76;
        if ((r8.getUiType() & 512) != 0) goto L76;
        if ((r8.getUiType() & 1024) != 0) goto L76;
        if ((r8.getUiType() & 2048) != 0) goto L76;
        if ((r8.getUiType() & 4096) != 0) goto L76;
        if ((r8.getUiType() & 8192) != 0) goto L76;
        if ((r8.getUiType() & 16384) != 0) goto L76;
        if ((r8.getUiType() & 32768) != 0) goto L76;
        if ((r8.getUiType() & 524288) != 0) goto L76;
        if ((r8.getUiType() & 65536) != 0) goto L76;
        if ((r8.getUiType() & 131072) != 0) goto L76;
        if ((r8.getUiType() & 1048576) != 0) goto L76;
        if ((r8.getUiType() & 262144) != 0) goto L76;
        if ((r8.getUiType() & 2097152) != 0) goto L76;
        if ((r8.getUiType() & 8388608) != 0) goto L76;
        String r210 = UUID.randomUUID().toString();
        Long r32 = r8.getReplyId();
        if (r32 == null) goto L67;
        long r211 = r32.longValue();
    L68:
        Long r212 = r8.getQuestionId();
        Long r213 = r0.getMessageId();
        long r214 = r0.getActionId();
        long r33 = r0.getJobId();
        IMAppActionExt r34 = r0.getExt();
        if (r34 != null) goto L71;
        r34 = new IMAppActionExt();
    L71:
        r34.put("app_cost", String.valueOf(r9));
        ConcurrentHashMap<String, String> r35 = r8.getExt();
        if (r35 == null) goto L75;
        r34.putAll(r35);
    L75:
        return new IMAppAction(0, r213, r210, r211, r212, null, r26, null, r214, r33, 0, r34, 1185, null);
    L67:
        r211 = 0;
        goto L68
    L28:
        r17 = r16;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        long r36 = System.currentTimeMillis();
        com.obric.capabilitykit.b r39 = com.obric.capabilitykit.b.f7467a;
        r3.f7417a = r0;
        r3.f7418b = r36;
        r3.e = 1;
        r2 = r39.a(r0, r3);
        if (r2 != r5) goto L17;
        return r5;
    L17:
        r7 = r36;
    L7:
        r3 = new b(this, r1);
        goto L8
    }
}
