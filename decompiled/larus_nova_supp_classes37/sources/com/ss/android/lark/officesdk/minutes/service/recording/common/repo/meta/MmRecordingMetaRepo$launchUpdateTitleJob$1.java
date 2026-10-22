package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo$launchUpdateTitleJob$1", f = "MmRecordingMetaRepo.kt", i = {0}, l = {197, 206}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class MmRecordingMetaRepo$launchUpdateTitleJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $newTitle;
    final /* synthetic */ String $oldTitle;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingMetaRepo this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo$launchUpdateTitleJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo$launchUpdateTitleJob$1$1", f = "MmRecordingMetaRepo.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newTitle;
        int label;
        final /* synthetic */ MmRecordingMetaRepo this$0;

        public AnonymousClass1(MmRecordingMetaRepo r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$newTitle = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$newTitle, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            MmRecordingMetaRepo r14 = this.this$0;
            b r2 = b.a(r14.h(), null, null, this.$newTitle, 0, null, null, 59);
            this.label = 1;
            if (r14.b(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingMetaRepo$launchUpdateTitleJob$1(MmRecordingMetaRepo r1, String r2, String r3, String r4, Continuation<? super MmRecordingMetaRepo$launchUpdateTitleJob$1> r5) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.$newTitle = r3;
        this.$oldTitle = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingMetaRepo$launchUpdateTitleJob$1 r6 = new MmRecordingMetaRepo$launchUpdateTitleJob$1(this.this$0, this.$meetingId, this.$newTitle, this.$oldTitle, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L13:
        MmRecordingMetaRepo r4 = this.this$0;
        if (Result.isSuccess-impl(r10) == false) goto L16;
        String r5 = (String) r10;
        lvb.a.e(r4.k, "[updateTitle] success");
    L16:
        MmRecordingMetaRepo r6 = this.this$0;
        String r7 = this.$oldTitle;
        Throwable r8 = Result.exceptionOrNull-impl(r10);
        if (r8 == null) goto L22;
        CoroutineScopeKt.ensureActive(r2);
        r6.j(new MmRecordingMetaRepo$launchUpdateTitleJob$1$3$1(r6, r7, null));
        lvb.a.b(r6.k, "[updateTitle] failed, error=" + r8);
        c.a r3 = new c.a(r7, com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a());
        this.L$0 = r10;
        this.label = 2;
        if (r6.k(r3, this) != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        r2 = (CoroutineScope) this.L$0;
        MmRecordingMetaRepo r11 = this.this$0;
        r11.j(new AnonymousClass1(r11, this.$newTitle, null));
        lvb.a.e(this.this$0.k, "[updateTitle] meetingId=" + this.$meetingId + ", newTitle=" + this.$newTitle);
        MmRecordingNetHelper r12 = this.this$0.j.G();
        String r13 = this.$meetingId;
        String r14 = this.$newTitle;
        this.L$0 = r2;
        this.label = 1;
        r10 = r12.y(r13, r14, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
