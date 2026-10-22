package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$startCaptureLoop$1", f = "MmExternalAudioCapturePipeline.kt", i = {0, 0, 1, 1, 2, 2}, l = {363, 380, 388}, m = "invokeSuspend", n = {"$this$launch", "byteArray", "$this$launch", "byteArray", "$this$launch", "byteArray"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class MmExternalAudioCapturePipeline$startCaptureLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmExternalAudioCapturePipeline this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$startCaptureLoop$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$startCaptureLoop$1$1", f = "MmExternalAudioCapturePipeline.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteBuffer $data;
        int label;
        final /* synthetic */ MmExternalAudioCapturePipeline this$0;

        public AnonymousClass1(MmExternalAudioCapturePipeline r1, ByteBuffer r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$data, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            Function1<ByteBuffer, Unit> r3 = this.this$0.c;
            ByteBuffer r0 = this.$data;
            Intrinsics.checkNotNull(r0);
            r3.invoke(r0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmExternalAudioCapturePipeline$startCaptureLoop$1(MmExternalAudioCapturePipeline r1, Continuation<? super MmExternalAudioCapturePipeline$startCaptureLoop$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmExternalAudioCapturePipeline$startCaptureLoop$1 r0 = new MmExternalAudioCapturePipeline$startCaptureLoop$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        byte[] r2 = (byte[]) this.L$1;
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L42
    L15:
        if (CoroutineScopeKt.isActive(r7) == false) goto L48;
        if (this.this$0.i == true) goto L19;
        MmExternalAudioCapturePipeline r13 = this.this$0;     // Catch: Exception -> L42
        int r14 = r13.b.read(r2, r13.w);     // Catch: Exception -> L42
        if (r14 > 0) goto L27;
        if (r14 == 0) goto L34;
        if (r14 >= 0) goto L15;
        lvb.a.b("MmExternalAudioCapturePipeline", "ExternalAudioSource read error: " + r14);     // Catch: Exception -> L42
        qvb.a r3 = qvb.a.a;     // Catch: Exception -> L42
        qvb.a.b(Boxing.boxInt(r14), "local_capture_read_error", this.this$0.b.getClass().getSimpleName(), null, 8);     // Catch: Exception -> L42
        goto L48
    L34:
        if (this.this$0.k == true) goto L36;
        lvb.a.h("MmExternalAudioCapturePipeline", "ExternalAudioSource read returned 0, retry later");     // Catch: Exception -> L42
        this.this$0.k = true;     // Catch: Exception -> L42
    L36:
        this.L$0 = r7;     // Catch: Exception -> L42
        this.L$1 = r2;     // Catch: Exception -> L42
        this.label = 3;     // Catch: Exception -> L42
        if (DelayKt.delay(10, this) != r0) goto L15;
        return r0;
    L27:
        if (this.this$0.k == false) goto L29;
        lvb.a.e("MmExternalAudioCapturePipeline", "ExternalAudioSource read recovered, bytesRead=" + r14);     // Catch: Exception -> L42
        this.this$0.k = false;     // Catch: Exception -> L42
    L29:
        ByteBuffer r8 = ByteBuffer.wrap(Arrays.copyOf(r2, r14));     // Catch: Exception -> L42
        MmExternalAudioCapturePipeline r9 = this.this$0;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L42
        MmExternalAudioCapturePipeline.a(r9, r8, r14);     // Catch: Exception -> L42
        MainCoroutineDispatcher r15 = Dispatchers.getMain();     // Catch: Exception -> L42
        AnonymousClass1 r10 = new AnonymousClass1(this.this$0, r8, null);     // Catch: Exception -> L42
        this.L$0 = r7;     // Catch: Exception -> L42
        this.L$1 = r2;     // Catch: Exception -> L42
        this.label = 2;     // Catch: Exception -> L42
        if (BuildersKt.withContext(r15, r10, this) != r0) goto L15;
        return r0;
    L19:
        if (this.this$0.j == true) goto L21;
        lvb.a.e("MmExternalAudioCapturePipeline", "capture loop paused, skip reading external source");     // Catch: Exception -> L42
        this.this$0.j = true;     // Catch: Exception -> L42
    L21:
        this.L$0 = r7;     // Catch: Exception -> L42
        this.L$1 = r2;     // Catch: Exception -> L42
        this.label = 1;     // Catch: Exception -> L42
        if (DelayKt.delay(10, this) != r0) goto L15;
        return r0;
    L48:
        return Unit.INSTANCE;
    L42:
        e = move-exception;
        lvb.a.b("MmExternalAudioCapturePipeline", "Error in capture loop: " + e);
        qvb.a r4 = qvb.a.a;
        String r5 = e.getMessage();
        if (r5 != null) goto L46;
        r5 = "";
    L46:
        qvb.a.b(null, "local_capture_read_error:".concat(r5), e.getClass().getSimpleName(), null, 9);
        goto L48
    L13:
        ResultKt.throwOnFailure(r12);
        r7 = (CoroutineScope) this.L$0;
        r2 = new byte[this.this$0.w];
        goto L15
    }
}
