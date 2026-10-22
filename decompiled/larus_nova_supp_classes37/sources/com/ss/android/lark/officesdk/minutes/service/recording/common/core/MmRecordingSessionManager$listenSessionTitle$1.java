package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.u;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$listenSessionTitle$1", f = "MmRecordingSessionManager.kt", i = {}, l = {1601}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSessionManager$listenSessionTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmRecordingSession a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ MmRecordingSessionManager c;

        public a(MmRecordingSession r1, Ref.ObjectRef<String> r2, MmRecordingSessionManager r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r6, Continuation r7) {
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b) r6;
            String r0 = this.a.e();
            String r1 = r8.c;
            if (StringsKt.isBlank(r1) == true) goto L12;
            if (Intrinsics.areEqual(r1, this.b.element) == true) goto L12;
            this.b.element = r1;
            lvb.a.a(this.c.b, "emit MmRecordingTitleData: recordId=" + r0 + ", title=" + r1);
            Object r9 = this.c.C.emit(new u(r0, r8.a, r8.b, r1), r7);
            if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            return r9;
        L13:
            return Unit.INSTANCE;
        L12:
            return Unit.INSTANCE;
        }
    }

    public MmRecordingSessionManager$listenSessionTitle$1(MmRecordingSession r1, MmRecordingSessionManager r2, Continuation<? super MmRecordingSessionManager$listenSessionTitle$1> r3) {
        this.$session = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingSessionManager$listenSessionTitle$1(this.$session, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L20:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = "";
        MmRecordingRepo r2 = this.$session.f();
        if (r2 == null) goto L22;
        MmRecordingMetaRepo r3 = r2.w();
        if (r3 == null) goto L22;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r4 = r3.l();
        if (r4 == null) goto L22;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b> r5 = r4.b();
        if (r5 == null) goto L22;
        a r6 = new a(this.$session, r8, this.this$0);
        this.label = 1;
        if (r5.collect(r6, this) != r0) goto L20;
        return r0;
    L22:
        return Unit.INSTANCE;
    }
}
