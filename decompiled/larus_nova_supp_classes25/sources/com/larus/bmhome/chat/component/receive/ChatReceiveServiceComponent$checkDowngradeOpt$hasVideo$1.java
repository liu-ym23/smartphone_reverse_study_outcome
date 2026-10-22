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
@DebugMetadata(c = "com.larus.bmhome.chat.component.receive.ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1", f = "ChatReceiveServiceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Uri> $uris;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1(List<? extends Uri> r1, Continuation<? super ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1> r2) {
        this.$uris = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatReceiveServiceComponent$checkDowngradeOpt$hasVideo$1(this.$uris, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        List<Uri> r4 = this.$uris;
        if ((r4 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        Uri r0 = (Uri) r5.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r0) == false) goto L11;
        boolean r6 = true;
    L17:
        return Boxing.boxBoolean(r6);
    L15:
        r6 = false;
        goto L17
    L7:
        if (r4.isEmpty() == false) goto L9;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
