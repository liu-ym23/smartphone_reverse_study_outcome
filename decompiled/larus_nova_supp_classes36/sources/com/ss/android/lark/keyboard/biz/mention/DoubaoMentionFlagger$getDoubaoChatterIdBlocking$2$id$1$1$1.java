package com.ss.android.lark.keyboard.biz.mention;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1", f = "IMCommonAtStrategy.kt", i = {}, l = {198}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1(Continuation<? super DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoubaoMentionFlagger$getDoubaoChatterIdBlocking$2$id$1$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Chatter r5 = (Chatter) r4;
        if (r5 != null) goto L16;
        return null;
    L16:
        return r5.getId();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        KeyboardModel r6 = new KeyboardModel();
        SyncDataStrategy r2 = SyncDataStrategy.FORCE_SERVER;
        this.label = 1;
        r4 = r6.a(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
