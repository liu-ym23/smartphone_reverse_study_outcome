package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.setting.bean.UserConfigPullReason;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.bmhome.setting.UserSettingRepo;
import hq9.y4;
import java.util.List;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatReceiver$registerImFlow$1$1$2", f = "ChatReceiver.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
public final class ChatReceiver$registerImFlow$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ChatReceiver$registerImFlow$1$1$2(Continuation<? super ChatReceiver$registerImFlow$1$1$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ChatReceiver$registerImFlow$1$1$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        y4 r6 = (y4) r5;
        if (r6 == null) goto L15;
        UserSettingCacheManager.o(UserSettingCacheManager.a, r6.a(), false, null, 6);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        UserSettingRepo r7 = UserSettingRepo.a;
        UserConfigKey.Companion.getClass();
        List r2 = UserConfigKey.a.b();
        int r3 = UserConfigPullReason.NOTIFIED.getValue();
        this.label = 1;
        r5 = r7.d(r2, r3, "cmd", this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
