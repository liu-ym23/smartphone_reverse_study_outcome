package com.obric.capabilitykit;

import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.BaseResult;
import com.obric.capabilitykit.common.BaseResultExt;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.logger.Logger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import wia.a;
import wia.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004J3\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001bJ?\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062'\u0010\u001f\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0019\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/ActionDispatcher;", "", "()V", "TAG", "", "<set-?>", "", "dispatchStartedQuestion", "getDispatchStartedQuestion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "parallelScope", "Lkotlinx/coroutines/CoroutineScope;", "getParallelScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "getScope", "getAppActionFailResult", "Lcom/obric/capabilitykit/common/IMAppAction;", "request", "code", "", "msg", "getIntentFailResult", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "duration", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;ILjava/lang/String;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/IMAppAction;", "launchWithTrace", "", "questionId", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;)V", "markDispatchEnded", "markDispatchStarted", "onActionReceived", "action", "(Lcom/obric/capabilitykit/common/IMAppAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ActionDispatcher {
    public static final ActionDispatcher INSTANCE = null;
    private static final String TAG = "ActionDispatcher";
    private static Long dispatchStartedQuestion;
    private static final CoroutineScope parallelScope = null;
    private static final CoroutineScope scope = null;

    static {
        INSTANCE = new ActionDispatcher();
        scope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new a())));
        parallelScope = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newCachedThreadPool(new b())));
    }

    private ActionDispatcher() {
    }

    public static /* synthetic */ Thread a(Runnable r0) {
        return parallelScope$lambda$1(r0);
    }

    public static final /* synthetic */ void access$markDispatchEnded(ActionDispatcher r0, long r1) {
        r0.markDispatchEnded(r1);
    }

    public static final /* synthetic */ void access$markDispatchStarted(ActionDispatcher r0, long r1) {
        r0.markDispatchStarted(r1);
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return scope$lambda$0(r0);
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

    private final void markDispatchEnded(long r4) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [ended qId=" + r4 + ']');
        dispatchStartedQuestion = null;
    }

    private final void markDispatchStarted(long r4) {
        Logger.INSTANCE.d(TAG, "** ActionDispatcher [started qId=" + r4 + ']');
        dispatchStartedQuestion = Long.valueOf(r4);
    }

    private static final Thread parallelScope$lambda$1(Runnable r2) {
        return new PthreadThreadV2(r2, "action-dispatcher-parallel");
    }

    private static final Thread scope$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "action-dispatcher");
    }

    public final IMAppAction getAppActionFailResult(IMAppAction r32, int r33, String r34) {
        Intrinsics.checkNotNullParameter(r32, "request");
        Gson r0 = UtilsKt.a();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = GsonProtectorUtils.toJson(r0, new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.getReplyId()), false, 36, null));
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

    public final CoroutineScope getParallelScope() {
        return parallelScope;
    }

    public final CoroutineScope getScope() {
        return scope;
    }

    public final void launchWithTrace(long r8, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        BuildersKt.launch$default(scope, null, null, new a(r8, r10, null), 3, null);
    }

    public final Object onActionReceived(IMAppAction r37, Continuation<? super IMAppAction> r38) {
        IMAppAction r0 = r37;
        if ((r38 instanceof b) == false) goto L7;
        b r2 = (b) r38;
        int r3 = r2.e;
        if ((r3 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r2.e = r3 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r1 = r2.c;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.e;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.b;
        r0 = (IMAppAction) r2.a;
        ResultKt.throwOnFailure(r1);
    L18:
        BaseResult r7 = (BaseResult) r1;
        long r8 = System.currentTimeMillis() - r6;
        Gson r9 = new Gson();
        AppHost.Companion r10 = AppHost.Companion;
        String r11 = r10.getApplication().getString(2131911939);
        String r12 = r10.getApplication().getString(2131911937);
        if (r7.getRet() != 0) goto L25;
        String r13 = r7.getDetails();
        if (r13 == null) goto L24;
        r11 = r13;
    L24:
        r7.setDetails(r11);
    L25:
        int r14 = r7.getRet();
        String r15 = r7.getDetails();
        if (r15 != null) goto L28;
        String r16 = r12;
    L29:
        String r26 = GsonProtectorUtils.toJson(r9, new FeedbackResult(r14, r16, null, r7.getUiType(), r7.getReplyFor(), false, 36, null));
        long r17 = 0;
        if ((r7.getUiType() & 32) == 0) goto L32;
    L75:
        String r21 = UUID.randomUUID().toString();
        Long r18 = r7.getReplyId();
        if (r18 == null) goto L78;
        r17 = r18.longValue();
    L78:
        long r22 = r17;
        Long r24 = r7.getQuestionId();
        Long r20 = r0.getMessageId();
        long r28 = r0.getActionId();
        long r30 = r0.getJobId();
        IMAppActionExt r19 = new IMAppActionExt();
        BaseResultExt r23 = r7.getExt();
        String r25 = null;
        if ((r23 instanceof BaseResultExt) == false) goto L81;
        BaseResultExt r27 = r23;
    L82:
        if (r27 == null) goto L84;
        r25 = r27.getResultDetailExtras();
    L84:
        r19.setActionDetailExtras(r25);
        r19.put("app_cost", String.valueOf(r8));
        ConcurrentHashMap r29 = r7.getExt();
        if (r29 == null) goto L88;
        r19.putAll(r29);
    L88:
        return new IMAppAction(0, r20, r21, r22, r24, null, r26, null, r28, r30, 0, r19, 1185, null);
    L81:
        r27 = null;
        goto L82
    L32:
        if ((r7.getUiType() & 64) != 0) goto L75;
        if ((r7.getUiType() & 128) != 0) goto L75;
        if ((r7.getUiType() & ISmModel.VERSION_0200) != 0) goto L75;
        if ((r7.getUiType() & ISmModel.VERSION_0400) != 0) goto L75;
        if ((r7.getUiType() & 2048) != 0) goto L75;
        if ((r7.getUiType() & 4096) != 0) goto L75;
        if ((r7.getUiType() & 8192) != 0) goto L75;
        if ((r7.getUiType() & 16384) != 0) goto L75;
        if ((r7.getUiType() & 32768) != 0) goto L75;
        if ((r7.getUiType() & 524288) != 0) goto L75;
        if ((r7.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST) != 0) goto L75;
        if ((r7.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ) != 0) goto L75;
        if ((r7.getUiType() & 1048576) != 0) goto L75;
        if ((r7.getUiType() & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION) != 0) goto L75;
        if ((r7.getUiType() & 2097152) != 0) goto L75;
        if ((r7.getUiType() & 8388608) != 0) goto L75;
        String r210 = UUID.randomUUID().toString();
        Long r31 = r7.getReplyId();
        if (r31 == null) goto L67;
        r17 = r31.longValue();
    L67:
        long r211 = r17;
        Long r212 = r7.getQuestionId();
        Long r213 = r0.getMessageId();
        long r214 = r0.getActionId();
        long r32 = r0.getJobId();
        IMAppActionExt r33 = r0.getExt();
        if (r33 != null) goto L70;
        r33 = new IMAppActionExt();
    L70:
        r33.put("app_cost", String.valueOf(r8));
        ConcurrentHashMap r34 = r7.getExt();
        if (r34 == null) goto L74;
        r33.putAll(r34);
    L74:
        return new IMAppAction(0, r213, r210, r211, r212, null, r26, null, r214, r32, 0, r33, 1185, null);
    L28:
        r16 = r15;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        long r35 = System.currentTimeMillis();
        b r36 = b.a;
        r2.a = r0;
        r2.b = r35;
        r2.e = 1;
        r1 = r36.a(r0, r2);
        if (r1 != r4) goto L17;
        return r4;
    L17:
        r6 = r35;
    L7:
        r2 = new b(this, r38);
        goto L8
    }

    public final IMAppAction getIntentFailResult(IntentCalling r32, int r33, String r34, Long r35) {
        Intrinsics.checkNotNullParameter(r32, "intentCalling");
        Gson r1 = UtilsKt.a();
        if (r34 != null) goto L5;
        String r4 = "failed";
    L6:
        String r21 = GsonProtectorUtils.toJson(r1, new FeedbackResult(r33, r4, null, 1, String.valueOf(r32.e), false, 36, null));
        String r16 = UUID.randomUUID().toString();
        long r2 = r32.e;
        long r3 = r32.a;
        long r5 = r32.b;
        long r7 = r32.c;
        long r9 = r32.d;
        if (r35 == null) goto L9;
        long r11 = r35.longValue();
        IMAppActionExt r0 = new IMAppActionExt();
        r0.put("app_cost", String.valueOf(r11));
    L10:
        Long r15 = Long.valueOf(r5);
        Long r19 = Long.valueOf(r3);
        return new IMAppAction(0, r15, r16, r2, r19, null, r21, null, r7, r9, 0, r0, 1185, null);
    L9:
        r0 = null;
        goto L10
    L5:
        r4 = r34;
        goto L6
    }
}
