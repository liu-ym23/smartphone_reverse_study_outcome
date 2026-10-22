package com.larus.dora.impl;

import com.larus.bmhome.auth.c1;
import com.larus.bmhome.auth.h0;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1", f = "DoraServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1(DoraServiceImpl r1, Continuation<? super DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1$onGetId$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r5);
        c1 r6 = (c1) AuthModelDelegate.b.a().getValue();
        if (r6 == null) goto L26;
        DoraServiceImpl r0 = this.this$0;
        if (r0.P.get() == false) goto L26;
        h0 r1 = (h0) r6.d;
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.b();
    L13:
        if (r3 != null) goto L15;
    L18:
        boolean r4 = true;
    L20:
        if ((!r4) == false) goto L26;
        h0 r7 = (h0) r6.d;
        if (r7 == null) goto L24;
        r2 = r7.h();
    L24:
        r0.H1(r2);
        goto L26
    L15:
        if (StringsKt.isBlank(r3) == true) goto L18;
        r4 = false;
        goto L20
    L11:
        r3 = null;
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
