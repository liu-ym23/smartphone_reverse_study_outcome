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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setBilingual$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {550}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$setBilingual$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo this$0;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setBilingual$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$setBilingual$1$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {555, 577}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ String $meetingId;
        int label;
        final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
        final /* synthetic */ MmRecordingLanguageRepo this$1;

        public AnonymousClass1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, MmRecordingLanguageRepo r2, boolean r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.this$1 = r2;
            this.$enabled = r3;
            this.$meetingId = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.this$1, this.$enabled, this.$meetingId, r8);
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
            boolean r2 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L29:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            Object r15 = ((Result) r14).unbox-impl();
        L17:
            MmRecordingLanguageRepo$opt$2.AnonymousClass1 r3 = this.this$0;
            boolean r5 = this.$enabled;
            Throwable r6 = Result.exceptionOrNull-impl(r15);
            if (r6 != null) goto L30;
            UpdateLiveRecordingSettingResponse r16 = (UpdateLiveRecordingSettingResponse) r15;
            this.this$0.getClass();
            if (r16.mstatus != UpdateLiveRecordingSettingResponse.Status.SUCCESS) goto L22;
            r2 = true;
        L22:
            if (r2 == true) goto L25;
            MmRecordingLanguageRepo$opt$2.AnonymousClass1 r4 = this.this$0;
            r4.W0(r4.f, "setBilingual", "enabled=" + this.$enabled + ", status=" + r16.mstatus);
            return Unit.INSTANCE;
        L25:
            lvb.a.e(this.this$1.m, "[setBilingual] success, enabled=" + this.$enabled);
            MmRecordingLanguageRepo r17 = this.this$1;
            f r7 = f.a((f) this.this$0.m(), null, null, null, null, this.$enabled, false, false, 111);
            this.label = 2;
            if (r17.b(r7, this) != r0) goto L29;
            return r0;
        L30:
            r3.W0(r3.f, "setBilingual", "enabled=" + r5 + ", error=" + r6);
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r14);
            if (this.this$0.h.get() == true) goto L13;
            lvb.a.e(this.this$1.m, "[setBilingual] enabled=" + this.$enabled);
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r18 = this.this$0.b;
            String r8 = this.$meetingId;
            boolean r9 = this.$enabled;
            this.label = 1;
            r15 = r18.i(r8, r9, false, this);
            if (r15 != r0) goto L17;
            return r0;
        L13:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingLanguageRepo$opt$2$1$setBilingual$1(MmRecordingLanguageRepo r1, MmRecordingLanguageRepo$opt$2.AnonymousClass1 r2, boolean r3, String r4, Continuation<? super MmRecordingLanguageRepo$opt$2$1$setBilingual$1> r5) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$enabled = r3;
        this.$meetingId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingLanguageRepo$opt$2$1$setBilingual$1(this.this$0, this.this$1, this.$enabled, this.$meetingId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MmRecordingLanguageRepo r11 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$1, r11, this.$enabled, this.$meetingId, null);
        this.label = 1;
        if (r11.e.b(r2, this) != r0) goto L12;
        return r0;
    }
}
