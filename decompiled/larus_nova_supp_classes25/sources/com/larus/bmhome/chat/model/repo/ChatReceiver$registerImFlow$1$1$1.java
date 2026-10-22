package com.larus.bmhome.chat.model.repo;

import android.app.Application;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMCmd;
import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatReceiver$registerImFlow$1$1$1", f = "ChatReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatReceiver$registerImFlow$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $app;
    final /* synthetic */ IMCmd $it;
    int label;

    public ChatReceiver$registerImFlow$1$1$1(IMCmd r1, Application r2, Continuation<? super ChatReceiver$registerImFlow$1$1$1> r3) {
        this.$it = r1;
        this.$app = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatReceiver$registerImFlow$1$1$1(this.$it, this.$app, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        AccountService.a.K(null);
        Map r4 = this.$it.getExt();
        if (r4 == null) goto L10;
        String r5 = (String) r4.get("err_msg");
        if (r5 == null) goto L10;
        Application r0 = this.$app;
        t19.s.a.getClass();
        t19.s.t(r0, r5);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
