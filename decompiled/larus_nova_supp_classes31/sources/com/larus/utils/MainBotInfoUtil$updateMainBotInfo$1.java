package com.larus.utils;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import ic8.n;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.utils.MainBotInfoUtil$updateMainBotInfo$1", f = "MainBotInfoUtil.kt", i = {}, l = {42, 45}, m = "invokeSuspend", n = {}, s = {})
public final class MainBotInfoUtil$updateMainBotInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MainBotInfoUtil$updateMainBotInfo$1(Continuation<? super MainBotInfoUtil$updateMainBotInfo$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MainBotInfoUtil$updateMainBotInfo$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L25:
        MainBotInfoUtil.a = (BotModel) r12;
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L15:
        List r13 = (List) r12;
        if (r13 == null) goto L30;
        String r5 = (String) CollectionsKt.firstOrNull(r13);
        if (r5 == null) goto L30;
        FLogger r14 = FLogger.a;
        r14.i("MainBotInfoUtil", "updateMainBotInfo, mainBotId = ".concat(r5));
        if ((!StringsKt.isBlank(r5)) == false) goto L26;
        IBotRepoService r4 = zh8.a.e;
        this.label = 2;
        r12 = IBotRepoService.b.a(r4, r5, false, null, false, this, 28);
        if (r12 != r0) goto L25;
        return r0;
    L26:
        r14.e("MainBotInfoUtil", "findMainBotInfo failed mainBotId is empty");
    L30:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r12);
        wc9.e r15 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r15 == null) goto L30;
        this.label = 1;
        r12 = n.c(r15, this);
        if (r12 != r0) goto L15;
        return r0;
    }
}
