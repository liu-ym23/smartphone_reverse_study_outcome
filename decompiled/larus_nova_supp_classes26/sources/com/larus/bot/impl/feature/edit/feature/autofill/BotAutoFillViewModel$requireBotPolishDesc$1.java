package com.larus.bot.impl.feature.edit.feature.autofill;

import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.larus.bot.impl.bean.BotPolishDescResp;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.DescPolishStatus;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$requireBotPolishDesc$1", f = "BotAutoFillViewModel.kt", i = {}, l = {897}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$requireBotPolishDesc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$requireBotPolishDesc$1(BotAutoFillViewModel r1, Continuation<? super BotAutoFillViewModel$requireBotPolishDesc$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAutoFillViewModel$requireBotPolishDesc$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        boolean r5 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        String r10 = (com.larus.network.http.a) r9;
        if ((r10 instanceof y) == false) goto L32;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("requireBotPolishDesc success, desc = ");
        y r11 = (y) r10;
        BotPolishDescResp r6 = (BotPolishDescResp) ((com.larus.network.http.a) r11).b;
        if (r6 == null) goto L20;
        String r7 = r6.getDesc();
    L21:
        r3.append(r7);
        r2.d("BotAutoFillViewModel", r3.toString());
        BotPolishDescResp r8 = (BotPolishDescResp) ((com.larus.network.http.a) r11).b;
        if (r8 == null) goto L24;
        r4 = r8.getDesc();
    L24:
        if (r4 != null) goto L26;
        r4 = "";
    L26:
        wu8.c.C0140c r12 = new wu8.c.C0140c(r4);
        ((HashMap) this.this$0.h).put(ContentType.DESC.getValue(), CollectionsKt.listOf(r12.a));
        BotAutoFillViewModel r13 = this.this$0;
        r13.r = true;
        r13.s++;
        r13.g.d = false;
        BotAutoFillViewModel r14 = this.this$0;
        BotPolishDescResp r15 = (BotPolishDescResp) ((com.larus.network.http.a) r11).b;
        if (r15 == null) goto L31;
        Boolean r16 = r15.getUseInternet();
        if (r16 == null) goto L31;
        r5 = r16.booleanValue();
    L31:
        r14.v = r5;
        this.this$0.n(true);
        this.this$0.m(CollectionsKt.listOf(r12));
        this.this$0.h(true, DescPolishStatus.AFTER_POLISH);
    L54:
        return Unit.INSTANCE;
    L20:
        r7 = null;
        goto L21
    L32:
        this.this$0.g.c = false;
        this.this$0.g.d = false;
        this.this$0.n(false);
        this.this$0.h(true, DescPolishStatus.BEFORE_POLISH);
        this.this$0.b();
        this.this$0.I();
        boolean r17 = r10 instanceof com.larus.network.http.f;
        if (r17 == false) goto L35;
        com.larus.network.http.f r18 = (com.larus.network.http.f) r10;
    L36:
        if (r18 == null) goto L40;
        AsyncThrowable r19 = r18.d;
        if (r19 == null) goto L40;
        Throwable r20 = r19.getCause();
    L42:
        if ((r20 instanceof NetworkNotAvailabeException) == false) goto L44;
        int r21 = j0.a;
        String r22 = j0.d(2131908080);
    L52:
        FLogger.a.d("BotAutoFillViewModel", "requireBotPolishDesc fail, msg = " + r22);
        BotAutoFillViewModel r23 = this.this$0;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        r23.L(new b.C0054b(new TextRes.PlainText(r22)));
        goto L54
    L44:
        if (r17 == false) goto L46;
        r4 = (com.larus.network.http.f) r10;
    L46:
        if (r4 == null) goto L51;
        AsyncThrowable r24 = ((com.larus.network.http.f) r4).d;
        if (r24 == null) goto L51;
        r22 = r24.getMessage();
        if (r22 != null) goto L52;
    L51:
        int r25 = j0.a;
        r22 = j0.d(2131908080);
    L40:
        r20 = null;
        goto L42
    L35:
        r18 = null;
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L12;
        FLogger.a.d("BotAutoFillViewModel", "requireBotPolishDesc, network not available");
        BotAutoFillViewModel r26 = this.this$0;
        b.C0054b r27 = new b.C0054b(new TextRes.StringResId(2131908080));
        int r28 = BotAutoFillViewModel.x;
        r26.L(r27);
        return Unit.INSTANCE;
    L12:
        FLogger.a.d("BotAutoFillViewModel", "requireBotPolishDesc, start");
        this.this$0.g.c = true;
        this.this$0.g.d = true;
        this.this$0.h(false, DescPolishStatus.IN_POLISH);
        this.this$0.b();
        this.this$0.I();
        BotAutoFillViewModel r29 = this.this$0;
        UgcBotRepo r30 = r29.n;
        int r31 = r29.u + 1;
        r29.u = r31;
        BotEnrichParam r32 = r29.z(r31);
        this.label = 1;
        Lazy<UgcBotRepo> r33 = UgcBotRepo.d;
        r30.getClass();
        r9 = UgcBotRepo.g(r32, null, this);
        if (r9 != r0) goto L15;
        return r0;
    }
}
