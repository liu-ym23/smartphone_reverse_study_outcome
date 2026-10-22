package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.m;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $language;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ boolean $showSuccessToast;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo this$0;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {493, 527, 528}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ h $language;
        final /* synthetic */ String $meetingId;
        final /* synthetic */ boolean $showSuccessToast;
        int label;
        final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
        final /* synthetic */ MmRecordingLanguageRepo this$1;

        public AnonymousClass1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, MmRecordingLanguageRepo r2, h r3, String r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.this$1 = r2;
            this.$language = r3;
            this.$meetingId = r4;
            this.$showSuccessToast = r5;
            super(1, r6);
        }

        public final Continuation<Unit> create(Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.this$1, this.$language, this.$meetingId, this.$showSuccessToast, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r15);
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r15);
        L35:
            MmRecordingLanguageRepo r16 = this.this$1;
            g.b r3 = new g.b(this.$language);
            this.label = 3;
            if (r16.k(r3, this) != r0) goto L39;
            return r0;
        L11:
            ResultKt.throwOnFailure(r15);
            Object r17 = ((Result) r15).unbox-impl();
        L19:
            MmRecordingLanguageRepo$opt$2.AnonymousClass1 r4 = this.this$0;
            h r6 = this.$language;
            Throwable r7 = Result.exceptionOrNull-impl(r17);
            if (r7 != null) goto L40;
            UpdateLiveRecordingSettingResponse r18 = (UpdateLiveRecordingSettingResponse) r17;
            this.this$0.getClass();
            if (r18.mstatus != UpdateLiveRecordingSettingResponse.Status.SUCCESS) goto L24;
            r2 = true;
        L24:
            if (r2 == true) goto L28;
            MmRecordingLanguageRepo$opt$2.AnonymousClass1 r5 = this.this$0;
            r5.W0(r5.e, "setTranslateLanguage", "language=" + this.$language + ", status=" + r18.mstatus);
            return Unit.INSTANCE;
        L28:
            if (this.$showSuccessToast == true) goto L30;
        L32:
            lvb.a.e(this.this$1.m, "[setTranslateLanguage] success, language=" + this.$language);
            m r19 = (m) this.this$1.k.N().i.getValue();
            String r8 = this.this$1.j.e();
            String r9 = this.$language.a;
            r19.getClass();
            Intrinsics.checkNotNullParameter(r8, "sessionId");
            Intrinsics.checkNotNullParameter(r9, "translationLanguage");
            r19.a(r8, r9, "user_click");
            MmRecordingLanguageRepo r110 = this.this$1;
            f r10 = f.a((f) this.this$0.m(), null, null, null, this.$language, false, false, false, 119);
            this.label = 2;
            if (r110.b(r10, this) != r0) goto L35;
            return r0;
        L30:
            if (Intrinsics.areEqual(this.$language.a, "source") == true) goto L32;
            MmRecordingUILaunchMode r111 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(UIHelper.mustacheFormat(2131889396, "language", this.$language.b));
            goto L32
        L40:
            r4.W0(r4.e, "setTranslateLanguage", "language=" + r6 + ", error=" + r7);
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r15);
            if (this.this$0.h.get() == true) goto L15;
            this.this$0.i = false;
            lvb.a.e(this.this$1.m, "[setTranslateLanguage] language=" + this.$language);
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r112 = this.this$0.b;
            String r11 = this.$meetingId;
            h r12 = this.$language;
            this.label = 1;
            r17 = r112.d(r11, r12, false, this);
            if (r17 != r0) goto L19;
            return r0;
        L15:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1(MmRecordingLanguageRepo r1, MmRecordingLanguageRepo$opt$2.AnonymousClass1 r2, h r3, String r4, boolean r5, Continuation<? super MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1> r6) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$language = r3;
        this.$meetingId = r4;
        this.$showSuccessToast = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MmRecordingLanguageRepo$opt$2$1$setTranslateLanguage$1(this.this$0, this.this$1, this.$language, this.$meetingId, this.$showSuccessToast, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MmRecordingLanguageRepo r12 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$1, r12, this.$language, this.$meetingId, this.$showSuccessToast, null);
        this.label = 1;
        if (r12.e.b(r2, this) != r0) goto L12;
        return r0;
    }
}
