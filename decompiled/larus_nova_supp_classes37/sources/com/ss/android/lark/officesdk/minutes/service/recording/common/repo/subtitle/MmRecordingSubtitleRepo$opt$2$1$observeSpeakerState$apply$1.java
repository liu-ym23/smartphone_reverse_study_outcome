package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSubtitleRepo this$0;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1$1", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {1297}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingSubtitleRepo$opt$2.AnonymousClass1 this$0;
        final /* synthetic */ MmRecordingSubtitleRepo this$1;

        public AnonymousClass1(MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r1, MmRecordingSubtitleRepo r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.this$1 = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.this$1, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            d r3 = (d) this.this$0.m();
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.f r16 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.f) this.this$1.k.h().l().b().getValue();
            MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2 = this.this$0;
            List<h> r4 = r3.a;
            r2.getClass();
            boolean r5 = r16.a;
            List<h> r6 = r4;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L10:
            if (r8.hasNext() == false) goto L18;
            h r9 = (h) r8.next();
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r10 = r16.b.get(r9.i);
            if (r5 == true) goto L14;
        L16:
            boolean r11 = false;
        L17:
            r7.add(h.a(r9, null, null, r10, r11, false, 32127));
            goto L10
        L14:
            if (r9.j == false) goto L16;
            r11 = true;
            goto L17
        L18:
            MmRecordingSubtitleRepo r17 = this.this$1;
            d r12 = d.a(r3, r7, 0, false, null, false, false, false, 126);
            this.label = 1;
            if (r17.b(r12, this) != r0) goto L22;
            return r0;
        }
    }

    public MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1(MmRecordingSubtitleRepo r1, MmRecordingSubtitleRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$apply$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        MmRecordingSubtitleRepo r5 = this.this$0;
        r5.j(new AnonymousClass1(this.this$1, r5, null));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
