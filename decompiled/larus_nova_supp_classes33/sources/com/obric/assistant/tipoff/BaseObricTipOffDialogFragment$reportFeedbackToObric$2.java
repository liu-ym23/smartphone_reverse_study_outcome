package com.obric.assistant.tipoff;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.feedback.IObricFeedbackService$b;
import com.obric.assistant.feedback.IObricFeedbackService$c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.tipoff.BaseObricTipOffDialogFragment$reportFeedbackToObric$2", f = "BaseObricTipOffDialogFragment.kt", i = {}, l = {423}, m = "invokeSuspend", n = {}, s = {})
final class BaseObricTipOffDialogFragment$reportFeedbackToObric$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $feedbackBizType;
    final /* synthetic */ String $feedbackMsgId;
    final /* synthetic */ String $feedbackSource;
    final /* synthetic */ List<String> $filePathList;
    final /* synthetic */ Boolean $isConsentChecked;
    final /* synthetic */ List<String> $messageIdList;
    final /* synthetic */ boolean $needUploadImage;
    final /* synthetic */ String $omniTaskId;
    final /* synthetic */ Integer $score;
    final /* synthetic */ String $searchTool;
    final /* synthetic */ List<String> $tagList;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    final /* synthetic */ BaseObricTipOffDialogFragment this$0;

    public static final class a implements Function1<IObricFeedbackService$b, Unit> {
        public final /* synthetic */ BaseObricTipOffDialogFragment a;
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;

        public a(BaseObricTipOffDialogFragment r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke(Object r5) {
            IObricFeedbackService$b r6 = (IObricFeedbackService$b) r5;
            Intrinsics.checkNotNullParameter(r6, "params");
            FLogger.a.i(this.a.getLogTag(), "reportToObric onCompleteCallback isPrivacyNotAgree = " + r6.a + ", continuation.isActive = " + this.b.isActive());
            if (this.b.isActive() == false) goto L6;
            kotlinx.coroutines.i<Boolean> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Boolean.valueOf(!r6.a)));
        L6:
            return Unit.INSTANCE;
        }
    }

    public BaseObricTipOffDialogFragment$reportFeedbackToObric$2(BaseObricTipOffDialogFragment r1, List<String> r2, String r3, List<String> r4, String r5, String r6, String r7, String r8, Boolean r9, Integer r10, boolean r11, List<String> r12, String r13, Continuation<? super BaseObricTipOffDialogFragment$reportFeedbackToObric$2> r14) {
        this.this$0 = r1;
        this.$tagList = r2;
        this.$content = r3;
        this.$messageIdList = r4;
        this.$feedbackMsgId = r5;
        this.$feedbackSource = r6;
        this.$feedbackBizType = r7;
        this.$searchTool = r8;
        this.$isConsentChecked = r9;
        this.$score = r10;
        this.$needUploadImage = r11;
        this.$filePathList = r12;
        this.$omniTaskId = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new BaseObricTipOffDialogFragment$reportFeedbackToObric$2(this.this$0, this.$tagList, this.$content, this.$messageIdList, this.$feedbackMsgId, this.$feedbackSource, this.$feedbackBizType, this.$searchTool, this.$isConsentChecked, this.$score, this.$needUploadImage, this.$filePathList, this.$omniTaskId, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        String r3 = (String) this.L$11;
        List r4 = (List) this.L$10;
        Integer r5 = (Integer) this.L$9;
        Boolean r6 = (Boolean) this.L$8;
        String r7 = (String) this.L$7;
        String r8 = (String) this.L$6;
        String r9 = (String) this.L$5;
        String r10 = (String) this.L$4;
        List r11 = (List) this.L$3;
        String r12 = (String) this.L$2;
        List r13 = (List) this.L$1;
        BaseObricTipOffDialogFragment r14 = (BaseObricTipOffDialogFragment) this.L$0;
        ResultKt.throwOnFailure(r26);
        return r26;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        BaseObricTipOffDialogFragment r15 = this.this$0;
        List<String> r16 = this.$tagList;
        String r17 = this.$content;
        List<String> r18 = this.$messageIdList;
        String r19 = this.$feedbackMsgId;
        String r110 = this.$feedbackSource;
        String r111 = this.$feedbackBizType;
        String r112 = this.$searchTool;
        Boolean r113 = this.$isConsentChecked;
        Integer r114 = this.$score;
        boolean r115 = this.$needUploadImage;
        List<String> r20 = this.$filePathList;
        String r21 = this.$omniTaskId;
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r17;
        this.L$3 = r18;
        this.L$4 = r19;
        this.L$5 = r110;
        this.L$6 = r111;
        this.L$7 = r112;
        this.L$8 = r113;
        this.L$9 = r114;
        this.L$10 = r20;
        this.L$11 = r21;
        this.Z$0 = r115;
        this.label = 1;
        kotlinx.coroutines.j r22 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r22.C();
        IObricFeedbackService.a.getClass();
        IObricFeedbackService r0 = IObricFeedbackService.a.a();
        if (r0 != null) goto L11;
        FLogger.a.i(r15.getLogTag(), "reportToObric feedbackService is null");
        Result.Companion r23 = Result.Companion;
        r22.resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
        kotlinx.coroutines.j r24 = r22;
    L12:
        Object r25 = r24.B();
        if (r25 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(this);
    L16:
        if (r25 != r1) goto L19;
        return r1;
    L19:
        return r25;
    L11:
        r24 = r22;
        r0.a(new IObricFeedbackService$c(r16, r17, null, r18, r19, r110, r111, r112, r113, r114, r115, r20, true, false, false, r21, false, new a(r15, r24), 221184));
        goto L12
    }
}
