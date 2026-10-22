package com.ss.android.lark.keyboard.biz.mention.inject;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.inject.AtDoubaoTopPlugin$getDoubaoChatter$1", f = "AtDoubaoTopPlugin.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
final class AtDoubaoTopPlugin$getDoubaoChatter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AtDoubaoTopPlugin this$0;

    public AtDoubaoTopPlugin$getDoubaoChatter$1(AtDoubaoTopPlugin r1, Continuation<? super AtDoubaoTopPlugin$getDoubaoChatter$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AtDoubaoTopPlugin$getDoubaoChatter$1(this.this$0, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        AtDoubaoTopPlugin r3 = (AtDoubaoTopPlugin) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        r3.e = (Chatter) r5;
        Chatter r6 = this.this$0.e;
        if (r6 == null) goto L15;
        String r7 = m.b(r6, ChatterNameDisplayRule.ALIAS_NAME, false);
        if (r7 != null) goto L19;
    L22:
        if (r2 == true) goto L24;
        RoundedIconTextView r4 = this.this$0.f;
        if (r4 == null) goto L29;
        r4.setText("@ " + r7);
    L29:
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L19:
        if (StringsKt.isBlank(r7) == true) goto L22;
        r2 = false;
        goto L22
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AtDoubaoTopPlugin r8 = this.this$0;
        KeyboardModel r9 = (KeyboardModel) r8.d.getValue();
        SyncDataStrategy r10 = SyncDataStrategy.TRY_LOCAL;
        this.L$0 = r8;
        this.label = 1;
        Object r11 = r9.a(r10, this);
        if (r11 != r0) goto L11;
        return r0;
    L11:
        r3 = r8;
        r5 = r11;
        goto L12
    }
}
