package com.larus.bot.impl.feature.edit.component;

import androidx.fragment.app.FragmentActivity;
import com.larus.bot.impl.feature.edit.BotUpdateViewModel;
import com.larus.im.bean.bot.BotModel;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.component.BotUpdateButtonComponent$handleUpdateSuccess$1", f = "BotUpdateButtonComponent.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
public final class BotUpdateButtonComponent$handleUpdateSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $newBotInfo;
    final /* synthetic */ BotUpdateViewModel $updateViewModel;
    Object L$0;
    int label;
    final /* synthetic */ BotUpdateButtonComponent this$0;

    public BotUpdateButtonComponent$handleUpdateSuccess$1(BotUpdateViewModel r1, BotModel r2, BotUpdateButtonComponent r3, Continuation<? super BotUpdateButtonComponent$handleUpdateSuccess$1> r4) {
        this.$updateViewModel = r1;
        this.$newBotInfo = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotUpdateButtonComponent$handleUpdateSuccess$1(this.$updateViewModel, this.$newBotInfo, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        BotModel r2 = (BotModel) this.L$0;
        ResultKt.throwOnFailure(r8);
    L56:
        FragmentActivity r9 = s1a.a.c(this.this$0).getActivity();
        if (r9 == null) goto L60;
        r9.finish();
    L60:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (this.$updateViewModel.getCanAddBgImage() == false) goto L56;
        BotModel r10 = this.$newBotInfo;
        if (r10 == null) goto L56;
        BotUpdateButtonComponent r3 = this.this$0;
        BotUpdateViewModel r4 = this.$updateViewModel;
        ru8.f r5 = r3.L2();
        boolean r6 = false;
        if (r5 == null) goto L19;
        BotModel r7 = r5.FH();
        if (r7 == null) goto L19;
        if (true != r4.hasEditBgImage(r7)) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L56;
        String r12 = "";
        if (r10.getBgImgOpen() == false) goto L47;
        String r13 = r10.getBgImgUrl();
        if (r13 != null) goto L26;
    L42:
        String r14 = r10.getBotId();
        if (r14 == null) goto L46;
        r12 = r14;
    L46:
        nq9.b r15 = new nq9.b(r12, null, null);
    L52:
        nq9.b r16 = r15;
    L53:
        MutableSharedFlow<nq9.b> r17 = com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.d;
        this.L$0 = r10;
        this.label = 1;
        if (r17.emit(r16, this) != r0) goto L56;
        return r0;
    L26:
        if ((!StringsKt.isBlank(r13)) == true) goto L28;
    L30:
        if (r6 == true) goto L33;
        r13 = null;
    L33:
        if (r13 == null) goto L42;
        String r18 = r10.getBotId();
        if (r18 != null) goto L37;
        r18 = "";
    L37:
        String r19 = r10.getBgImgColor();
        if (r19 == null) goto L41;
        r12 = r19;
    L41:
        r16 = new nq9.b(r18, r13, r12);
        goto L53
    L28:
        if (com.larus.utils.o0.d(r10.getBgImgColor()) == false) goto L30;
        r6 = true;
        goto L30
    L47:
        String r20 = r10.getBotId();
        if (r20 == null) goto L51;
        r12 = r20;
    L51:
        r15 = new nq9.b(r12, null, null);
    L19:
        r11 = false;
        goto L20
    }
}
