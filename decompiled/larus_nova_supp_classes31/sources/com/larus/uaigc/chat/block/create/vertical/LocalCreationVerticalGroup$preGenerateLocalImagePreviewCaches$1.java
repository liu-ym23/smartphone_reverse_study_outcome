package com.larus.uaigc.chat.block.create.vertical;

import com.larus.im.bean.message.CreationItem;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.vertical.LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1", f = "LocalCreationVerticalGroup.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LocalCreationVerticalGroup this$0;

    public LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1(LocalCreationVerticalGroup r1, Continuation<? super LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalCreationVerticalGroup$preGenerateLocalImagePreviewCaches$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        LocalCreationVerticalGroup r3 = this.this$0;
        int r0 = LocalCreationVerticalGroup.u;
        List<CreationItem> r4 = r3.m;
        if (r4 != null) goto L7;
        r4 = CollectionsKt.emptyList();
    L7:
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        bz9.c.i((CreationItem) r5.next());
        goto L9
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
