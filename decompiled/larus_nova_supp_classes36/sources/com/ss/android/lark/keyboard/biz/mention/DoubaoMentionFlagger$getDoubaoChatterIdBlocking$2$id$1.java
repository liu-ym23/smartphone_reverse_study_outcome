package com.ss.android.lark.keyboard.biz.mention;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1", f = "IMCommonAtStrategy.kt", i = {0}, l = {192, 197}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
final class DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(Continuation<? super DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1 r0 = new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r5 = null;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L39:
        Object r9 = Result.constructor-impl((String) r8);     // Catch: Throwable -> L8
    L43:
        if (Result.isFailure-impl(r9) == true) goto L46;
        r5 = r9;
    L46:
        String r6 = (String) r5;
        if (r6 != null) goto L50;
        return "";
    L50:
        return r6;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25
    L19:
        Chatter r10 = (Chatter) r8;     // Catch: Throwable -> L25
        if (r10 == null) goto L22;
        String r11 = r10.getId();     // Catch: Throwable -> L25
    L23:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r12) == false) goto L30;
        r12 = null;
    L30:
        String r13 = (String) r12;
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        if ((!StringsKt.isBlank(r13)) == false) goto L36;
        return r13;
    L36:
        DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1 r14 = new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1(null);     // Catch: Throwable -> L8
        this.L$0 = null;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        r8 = TimeoutKt.b(1500, r14, this);     // Catch: Throwable -> L8
        if (r8 != r0) goto L39;
        return r0;
    L22:
        r11 = null;
        goto L23
    L15:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L25
        KeyboardModel r4 = new KeyboardModel();     // Catch: Throwable -> L25
        SyncDataStrategy r7 = SyncDataStrategy.TRY_LOCAL;     // Catch: Throwable -> L25
        this.L$0 = r15;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        r8 = r4.a(r7, this);     // Catch: Throwable -> L25
        if (r8 != r0) goto L19;
        return r0;
    L25:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    }
}
