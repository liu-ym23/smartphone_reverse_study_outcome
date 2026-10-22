package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1", f = "MmRecordingAudioSaveRepo.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $hardwareSettings;
    int label;
    final /* synthetic */ MmRecordingAudioSaveRepo this$0;
    final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1$1", f = "MmRecordingAudioSaveRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingAudioSaveRepo this$0;
        final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$1;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1$1$1", f = "MmRecordingAudioSaveRepo.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00411 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ MmAudioSaveType $audioSaveType;
            int label;
            final /* synthetic */ MmRecordingAudioSaveRepo this$0;
            final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$1;

            public C00411(MmRecordingAudioSaveRepo r1, MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r2, MmAudioSaveType r3, Continuation<? super C00411> r4) {
                this.this$0 = r1;
                this.this$1 = r2;
                this.$audioSaveType = r3;
                super(1, r4);
            }

            public final Continuation<Unit> create(Continuation<?> r5) {
                return new C00411(this.this$0, this.this$1, this.$audioSaveType, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
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
                MmRecordingAudioSaveRepo r11 = this.this$0;
                f r2 = f.a((f) this.this$1.m(), this.$audioSaveType, false, false, null, 14);
                this.label = 1;
                if (r11.b(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(MmRecordingAudioSaveRepo r1, MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.this$1 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.this$1, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmAudioSaveType) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            MmAudioSaveType r6 = (MmAudioSaveType) this.L$0;
            MmRecordingAudioSaveRepo r0 = this.this$0;
            r0.j(new C00411(r0, this.this$1, r6, null));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1(a r1, MmRecordingAudioSaveRepo r2, MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1> r4) {
        this.this$0 = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveSettingPageShown$1(null, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r3);
        throw null;
    L5:
        if (r0 != 1) goto L9;
        ResultKt.throwOnFailure(r3);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
