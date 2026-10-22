package com.larus.bot.impl.feature.edit;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.im.bean.bot.BgImage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel$_autoFillModel$2$1$updateBotInfo$1", f = "BotCreateViewModel.kt", i = {}, l = {296, 299, 308}, m = "invokeSuspend", n = {}, s = {})
public final class BotCreateViewModel$_autoFillModel$2$1$updateBotInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<wu8.c> $itemsData;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BotCreateViewModel this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public BotCreateViewModel$_autoFillModel$2$1$updateBotInfo$1(List<? extends wu8.c> r1, BotCreateViewModel r2, Continuation<? super BotCreateViewModel$_autoFillModel$2$1$updateBotInfo$1> r3) {
        this.$itemsData = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotCreateViewModel$_autoFillModel$2$1$updateBotInfo$1(this.$itemsData, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Iterator r2 = (Iterator) this.L$1;
        BotCreateViewModel r5 = (BotCreateViewModel) this.L$0;
        ResultKt.throwOnFailure(r13);
    L14:
        if (r2.hasNext() == false) goto L83;
        wu8.c r6 = (wu8.c) r2.next();
        if ((r6 instanceof wu8.c.a) == true) goto L17;
        if ((r6 instanceof wu8.c.C0140c) == true) goto L58;
        if ((r6 instanceof wu8.c.d) == true) goto L63;
        if ((r6 instanceof wu8.c.e) == true) goto L68;
        if ((r6 instanceof wu8.c.f) == true) goto L71;
        if ((r6 instanceof wu8.c.g) == true) goto L74;
        if ((r6 instanceof wu8.c.b) == false) goto L81;
        BotCreateViewModel.access$get_bioModel(r5).P6(((wu8.c.b) r6).a);
        goto L14
    L81:
        throw new NoWhenBranchMatchedException();
    L74:
        MutableSharedFlow<e0> r7 = r5.getUiEvent();
        e0.b r8 = new e0.b(new wu8.c.g(((wu8.c.g) r6).a));
        this.L$0 = r5;
        this.L$1 = r2;
        this.label = 3;
        if (r7.emit(r8, this) != r0) goto L14;
        return r0;
    L71:
        BotCreateViewModel.access$get_firstMetModel(r5).Ma(((wu8.c.f) r6).a);
        goto L14
    L68:
        BotCreateViewModel.access$get_firstMetModel(r5).F9(((wu8.c.e) r6).a);
        goto L14
    L63:
        MutableSharedFlow<e0> r9 = r5.getUiEvent();
        e0.b r10 = new e0.b(new wu8.c.d(((wu8.c.d) r6).a));
        this.L$0 = r5;
        this.L$1 = r2;
        this.label = 2;
        if (r9.emit(r10, this) != r0) goto L14;
        return r0;
    L58:
        MutableSharedFlow<e0> r11 = r5.getUiEvent();
        e0.b r12 = new e0.b(new wu8.c.C0140c(((wu8.c.C0140c) r6).a));
        this.L$0 = r5;
        this.L$1 = r2;
        this.label = 1;
        if (r11.emit(r12, this) != r0) goto L14;
        return r0;
    L17:
        wu8.c.a r14 = (wu8.c.a) r6;
        BotAvatarIconData r15 = r14.a.a;
        String r16 = null;
        if (r15 == null) goto L20;
        String r17 = r15.getIconUrl();
    L21:
        String r18 = "";
        if (r17 != null) goto L24;
        r17 = "";
    L24:
        if (r15 == null) goto L26;
        String r19 = r15.getIconUri();
    L27:
        if (r19 == null) goto L30;
        r18 = r19;
    L30:
        r5.updateIconUri(r17, r18);
        if (r15 == null) goto L33;
        String r20 = r15.getPrompt();
    L34:
        r5.updateAvatarPrompt(r20);
        if (r5.getCanAddBgImage() == false) goto L44;
        BgImage r21 = r14.a.b;
        if (r21 == null) goto L39;
        r5.updateBgImage(r21);
    L39:
        r5.updateOriginalUserImgUri(null);
        com.larus.bot.impl.feature.edit.feature.bgimage.t r110 = BotCreateViewModel.access$get_bgImageModel(r5);
        if (r15 == null) goto L42;
        String r111 = r15.getIconUrl();
    L43:
        r110.o(r111, r21);
    L49:
        if (r15 == null) goto L51;
        String r22 = r15.getIconUrl();
    L52:
        r5.updateOriginalAvatarImgUri(r22);
        BgImage r23 = r14.a.b;
        if (r23 == null) goto L55;
        r16 = r23.bgImgUrl;
    L55:
        r5.updateOriginalBackgroundImgUri(r16);
        goto L14
    L51:
        r22 = null;
        goto L52
    L42:
        r111 = null;
        goto L43
    L44:
        com.larus.bot.impl.feature.edit.feature.avatar.t r24 = BotCreateViewModel.access$get_avatarModel(r5);
        if (r15 == null) goto L47;
        String r112 = r15.getIconUrl();
    L48:
        r24.o(r112, null);
        goto L49
    L47:
        r112 = null;
        goto L48
    L33:
        r20 = null;
        goto L34
    L26:
        r19 = null;
        goto L27
    L20:
        r17 = null;
        goto L21
    L83:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r13);
        List<wu8.c> r113 = this.$itemsData;
        r5 = this.this$0;
        r2 = r113.iterator();
        goto L14
    }
}
