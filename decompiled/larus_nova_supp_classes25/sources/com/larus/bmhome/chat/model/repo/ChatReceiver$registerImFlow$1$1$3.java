package com.larus.bmhome.chat.model.repo;

import android.app.Activity;
import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.IMCmd;
import com.larus.utils.logger.FLogger;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatReceiver$registerImFlow$1$1$3", f = "ChatReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatReceiver$registerImFlow$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMCmd $it;
    int label;

    public ChatReceiver$registerImFlow$1$1$3(IMCmd r1, Continuation<? super ChatReceiver$registerImFlow$1$1$3> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatReceiver$registerImFlow$1$1$3(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L41;
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("ChatReceiver", "Risk Toast Alert!");
        Map r8 = this.$it.getExt();
        if (r8 == null) goto L39;
        String r2 = (String) r8.get("toast");
        if (r2 == null) goto L39;
        Map r9 = this.$it.getExt();
        if (r9 == null) goto L11;
        String r10 = (String) r9.get("toast_type");
    L12:
        t19.s r0 = t19.s.a;
        AppHost.Companion r1 = AppHost.a;
        Activity r3 = r1.a().getCurrentActivity();
        if (r3 != null) goto L15;
        Context r4 = r1.getApplication();
    L16:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        if (r10 == null) goto L37;
        int r5 = r10.hashCode();
        if (r5 == (-1867169789)) goto L34;
        if (r5 == (-1086574198)) goto L30;
        if (r5 != 1124446108) goto L37;
        if (r10.equals("warning") == false) goto L37;
        t19.s.t(r4, r2);
        goto L39
    L30:
        if (r10.equals("failure") == false) goto L37;
        t19.s.c(r4, r2);
        goto L39
    L34:
        if (r10.equals("success") == false) goto L37;
        t19.s.p(r4, r2);
    L37:
        t19.s.j(r0, r4, r2, null, false, 28);
        goto L39
    L15:
        r4 = r3;
        goto L16
    L11:
        r10 = null;
    L39:
        return Unit.INSTANCE;
    L41:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
