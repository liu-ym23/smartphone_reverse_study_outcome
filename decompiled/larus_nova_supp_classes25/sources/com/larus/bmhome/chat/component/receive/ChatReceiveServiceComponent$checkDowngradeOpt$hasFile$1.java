package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ImFileUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1", f = "ChatReceiveServiceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Uri> $uris;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1(List<? extends Uri> r1, Continuation<? super ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1> r2) {
        this.$uris = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatReceiveServiceComponent$checkDowngradeOpt$hasFile$1(this.$uris, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r5);
        List<Uri> r6 = this.$uris;
        boolean r1 = false;
        if ((r6 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L21;
        Uri r0 = (Uri) r7.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r0) == false) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L11;
        r1 = true;
        goto L21
    L15:
        if (ImFileUtil.y(r0) == true) goto L17;
        r2 = true;
    L21:
        return Boxing.boxBoolean(r1);
    L7:
        if (r6.isEmpty() == false) goto L9;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
