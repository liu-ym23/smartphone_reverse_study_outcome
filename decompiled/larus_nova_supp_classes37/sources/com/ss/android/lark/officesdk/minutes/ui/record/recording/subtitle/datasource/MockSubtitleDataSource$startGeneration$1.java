package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.datasource;

import bwb.b;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.datasource.MockSubtitleDataSource$startGeneration$1", f = "MockSubtitleDataSource.kt", i = {0, 1}, l = {61, 66}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class MockSubtitleDataSource$startGeneration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public MockSubtitleDataSource$startGeneration$1(a r1, Continuation<? super MockSubtitleDataSource$startGeneration$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MockSubtitleDataSource$startGeneration$1 r0 = new MockSubtitleDataSource$startGeneration$1(null, r4);
        r0.L$0 = r3;
        return r0;
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
        if (r1 != 0) goto L5;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        int r2 = b.a;
        b.g(MmUiLogScene.SUBTITLE, "startGeneration", "Starting mock subtitle generation", null, 8);
        CoroutineScope r3 = r8;
    L21:
        if (CoroutineScopeKt.isActive(r3) == false) goto L23;
        throw null;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        int r4 = b.a;
        b.d(MmUiLogScene.SUBTITLE, "startGeneration", "Error in generation loop e:" + e, null);
        goto L21
    L23:
        return Unit.INSTANCE;
    L5:
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L25
        goto L21
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L17
        this.L$0 = r5;     // Catch: Exception -> L17
        this.label = 2;     // Catch: Exception -> L17
        if (DelayKt.delay(1000, this) != r0) goto L16;
        return r0;
    L16:
        r3 = r5;
    L17:
        e = move-exception;
        r3 = r5;
        int r6 = b.a;
        b.d(MmUiLogScene.SUBTITLE, "startGeneration", "Error in generation loop e:" + e, null);
        goto L21
    }
}
