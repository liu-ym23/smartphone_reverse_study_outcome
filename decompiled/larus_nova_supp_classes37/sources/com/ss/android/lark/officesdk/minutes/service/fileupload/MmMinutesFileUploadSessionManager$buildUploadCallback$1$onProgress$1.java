package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0}, l = {2297}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fub.d $progress;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $uploadTaskId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1(MmMinutesFileUploadSessionManager r1, String r2, String r3, fub.d r4, Continuation<? super MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1> r5) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$uploadTaskId = r3;
        this.$progress = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1(this.this$0, this.$taskId, this.$uploadTaskId, this.$progress, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        fub.d r3 = (fub.d) this.L$4;
        String r4 = (String) this.L$3;
        String r5 = (String) this.L$2;
        MmMinutesFileUploadSessionManager r6 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
    L31:
        MmMinutesFileUploadSessionManager.e r16 = r6.p.get(r5);     // Catch: Throwable -> L28
        if (r16 != null) goto L16;
    L25:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r7.unlock(null);
        return Unit.INSTANCE;
    L16:
        if (r16.c(r4) == true) goto L19;
        lvb.a.e(r6.d, "uploadCallback.onProgress: skip stale callback. taskId=" + r5 + ", uploadTaskId=" + r4);     // Catch: Throwable -> L28
        goto L25
    L19:
        if (Intrinsics.areEqual(((LinkedHashMap) r16.f).get(r4), Boxing.boxBoolean(true)) == true) goto L25;
        long r8 = r3.b;     // Catch: Throwable -> L28
        if (r8 <= 0) goto L23;
        r16.h.put(r4, Boxing.boxLong(r8));     // Catch: Throwable -> L28
        r16.g.put(r4, Boxing.boxLong(RangesKt.coerceIn(r3.a, 0, r3.b)));     // Catch: Throwable -> L28
        MmMinutesFileUploadSessionManager.g(r6, r5, r16);     // Catch: Throwable -> L28
    L24:
        r6.w();     // Catch: Throwable -> L28
        goto L25
    L23:
        r16.j.put(r4, Boxing.boxInt(RangesKt.coerceIn(r3.c, 0, 100)));     // Catch: Throwable -> L28
        MmMinutesFileUploadSessionManager.f(r6, r5, r16);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r6 = this.this$0;
        r7 = r6.g;
        r5 = this.$taskId;
        r4 = this.$uploadTaskId;
        fub.d r18 = this.$progress;
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r5;
        this.L$3 = r4;
        this.L$4 = r18;
        this.label = 1;
        if (r7.a(null, this) != r1) goto L11;
        return r1;
    L11:
        r3 = r18;
        goto L31
    }
}
