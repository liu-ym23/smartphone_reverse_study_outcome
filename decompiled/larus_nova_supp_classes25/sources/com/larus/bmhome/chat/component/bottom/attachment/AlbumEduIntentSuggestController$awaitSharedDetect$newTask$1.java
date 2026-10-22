package com.larus.bmhome.chat.component.bottom.attachment;

import android.util.LruCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1", f = "AlbumEduIntentSuggestController.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
final class AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ix8.d>, Object> {
    final /* synthetic */ String $imageKey;
    final /* synthetic */ g $snapshot;
    int label;
    final /* synthetic */ AlbumEduIntentSuggestController this$0;

    public AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1(AlbumEduIntentSuggestController r1, g r2, String r3, Continuation<? super AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1> r4) {
        this.this$0 = r1;
        this.$snapshot = r2;
        this.$imageKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlbumEduIntentSuggestController$awaitSharedDetect$newTask$1(this.this$0, this.$snapshot, this.$imageKey, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ix8.d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        String r2 = this.$imageKey;
        ix8.d r3 = (ix8.d) r5;
        if (r3 == null) goto L14;
        ix8.e r4 = r3.b();
    L16:
        if (Intrinsics.areEqual(r4, ix8.e.d.a) == false) goto L18;
        LruCache<String, ix8.d> r6 = AlbumEduIntentSuggestController.h;
        AlbumEduIntentSuggestController.h.put(r2, r3);
    L18:
        return r5;
    L14:
        r4 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AlbumEduIntentSuggestController r7 = this.this$0;
        g r8 = this.$snapshot;
        this.label = 1;
        r5 = AlbumEduIntentSuggestController.b(r7, r8, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
