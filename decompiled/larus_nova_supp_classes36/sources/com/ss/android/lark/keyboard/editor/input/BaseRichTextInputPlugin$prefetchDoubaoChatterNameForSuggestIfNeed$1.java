package com.ss.android.lark.keyboard.editor.input;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1", f = "BaseRichTextInputPlugin.kt", i = {}, l = {698}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseRichTextInputPlugin this$0;

    public BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1(BaseRichTextInputPlugin r1, Continuation<? super BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1 r0 = new BaseRichTextInputPlugin$prefetchDoubaoChatterNameForSuggestIfNeed$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        BaseRichTextInputPlugin r2 = (BaseRichTextInputPlugin) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L8
    L17:
        Object r7 = Result.constructor-impl((Chatter) r6);     // Catch: Throwable -> L8
    L23:
        if (Result.isFailure-impl(r7) == false) goto L25;
        r7 = null;
    L25:
        r2.k = (Chatter) r7;
        String r8 = com.ss.android.lark.chat.utils.m.b(this.this$0.k, ChatterNameDisplayRule.ALIAS_NAME, false);
        BaseRichTextInputPlugin r3 = this.this$0;
        if (StringsKt.isBlank(r8) == false) goto L28;
        r3.getClass();
        r8 = BaseRichTextInputPlugin.R();
    L28:
        r3.j = r8;
        return Unit.INSTANCE;
    L8:
        Throwable th = th;
    L21:
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        BaseRichTextInputPlugin r10 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        KeyboardModel r11 = new KeyboardModel();     // Catch: Throwable -> L19
        SyncDataStrategy r12 = SyncDataStrategy.TRY_LOCAL;     // Catch: Throwable -> L19
        this.L$0 = r10;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        Object r13 = r11.a(r12, this);     // Catch: Throwable -> L19
        if (r13 != r0) goto L16;
        return r0;
    L16:
        r2 = r10;
        r6 = r13;
    L19:
        th = move-exception;
        r2 = r10;
        th = th;
        goto L21
    }
}
