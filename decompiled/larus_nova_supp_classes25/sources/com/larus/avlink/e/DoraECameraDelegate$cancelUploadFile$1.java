package com.larus.avlink.e;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.DoraECameraDelegate$cancelUploadFile$1", f = "DoraECameraDelegate.kt", i = {}, l = {1029}, m = "invokeSuspend", n = {}, s = {})
final class DoraECameraDelegate$cancelUploadFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $imageId;
    final /* synthetic */ List<b49.h> $images;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $status;
    int label;

    public DoraECameraDelegate$cancelUploadFile$1(Integer r1, int r2, int r3, List<b49.h> r4, Continuation<? super DoraECameraDelegate$cancelUploadFile$1> r5) {
        this.$imageId = r1;
        this.$mode = r2;
        this.$status = r3;
        this.$images = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraECameraDelegate$cancelUploadFile$1(this.$imageId, this.$mode, this.$status, this.$images, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        m r3 = m.a;
        int r5 = this.$imageId.intValue();
        int r6 = this.$mode;
        int r13 = this.$status;
        String r8 = a98.a.a;
        String r9 = a98.a.b;
        l r4 = l.a;
        int r10 = l.d(Boxing.boxInt(r6));
        int r12 = o.b();
        List<b49.h> r11 = this.$images;
        final Integer r7 = this.$imageId;
        final int r14 = this.$mode;
        Function1 r15 = new e(r7, r14);
        this.label = 1;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraENetworkUtil$cancelUpload$2(r5, r6, r15, r8, r9, r10, r11, r12, r13, null), 3, null);
        if (Unit.INSTANCE != r1) goto L12;
        return r1;
    }
}
