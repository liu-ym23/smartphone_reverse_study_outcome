package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmAutoLanguageSettingResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2", f = "MmRecordingLanguageRepo.kt", i = {}, l = {589}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2 extends SuspendLambda implements Function1<Continuation<? super MmAutoLanguageSettingResult>, Object> {
    final /* synthetic */ long $expectedManualRevision;
    final /* synthetic */ h $language;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingLanguageRepo this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/videochat/UpdateLiveRecordingSettingResponse;", "meetingId", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {594}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Result<? extends UpdateLiveRecordingSettingResponse>>, Object> {
        final /* synthetic */ h $language;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;

        public AnonymousClass1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, h r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$language = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$language, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((String) r1, (Continuation) r2);
        }

        public final Object invoke(String r1, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L12:
            return Result.box-impl(r6);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            String r7 = (String) this.L$0;
            this.this$0.i = false;
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r2 = this.this$0.b;
            h r3 = this.$language;
            this.label = 1;
            r6 = r2.d(r7, r3, true, this);
            if (r6 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2$2", f = "MmRecordingLanguageRepo.kt", i = {}, l = {601, 602}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ h $language;
        int label;
        final /* synthetic */ MmRecordingLanguageRepo this$0;
        final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$1;

        public AnonymousClass2(MmRecordingLanguageRepo r1, MmRecordingLanguageRepo$opt$2.AnonymousClass1 r2, h r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.this$1 = r2;
            this.$language = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.this$1, this.$language, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
        L13:
            MmRecordingLanguageRepo r15 = this.this$0;
            g.b r2 = new g.b(this.$language);
            this.label = 2;
            if (r15.k(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r14);
            MmRecordingLanguageRepo r16 = this.this$0;
            f r3 = f.a((f) this.this$1.m(), null, null, null, this.$language, false, false, false, 119);
            this.label = 1;
            if (r16.b(r3, this) != r0) goto L13;
            return r0;
        }
    }

    public MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, h r2, long r3, MmRecordingLanguageRepo r5, Continuation<? super MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2> r6) {
        this.this$0 = r1;
        this.$language = r2;
        this.$expectedManualRevision = r3;
        this.this$1 = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingLanguageRepo$opt$2$1$setTranslateLanguageAutomatically$2(this.this$0, this.$language, this.$expectedManualRevision, this.this$1, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super MmAutoLanguageSettingResult> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MmRecordingLanguageRepo$opt$2.AnonymousClass1 r2 = this.this$0;
        String r13 = "setTranslateLanguageAutomatically(language=" + this.$language + ')';
        long r3 = this.$expectedManualRevision;
        AnonymousClass1 r5 = new AnonymousClass1(this.this$0, this.$language, null);
        AnonymousClass2 r6 = new AnonymousClass2(this.this$1, this.this$0, this.$language, null);
        this.label = 1;
        r12 = MmRecordingLanguageRepo$opt$2.AnonymousClass1.T0(r2, r13, r3, r5, r6, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
