package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.lark.pb.openplatform.v1.TransSer2CliUniversalCardEntityRequest;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.cardcontainer.render.CardRenderByServerEntityImpl$render$1", f = "CardRenderByServerEntityImpl.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
final class CardRenderByServerEntityImpl$render$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardContext $cardContext;
    final /* synthetic */ fz7.a $cardRenderEntityConfig;
    final /* synthetic */ bz7.c $lifecycle;
    final /* synthetic */ String $serverEntityJson;
    int label;
    final /* synthetic */ d this$0;

    public CardRenderByServerEntityImpl$render$1(fz7.a r1, d r2, String r3, bz7.c r4, CardContext r5, Continuation<? super CardRenderByServerEntityImpl$render$1> r6) {
        this.$cardRenderEntityConfig = r1;
        this.this$0 = r2;
        this.$serverEntityJson = r3;
        this.$cardContext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CardRenderByServerEntityImpl$render$1(this.$cardRenderEntityConfig, this.this$0, this.$serverEntityJson, null, this.$cardContext, r9);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22
    L15:
        UniversalCardEntity r10 = (UniversalCardEntity) r9;     // Catch: Throwable -> L22
    L19:
        Log.e("CardRenderByServerEntityImpl", "convert entity success");
        this.this$0.c.setEntity(r10);
        this.this$0.getClass();
        CardConfig r2 = new CardConfig(null, null, null, null, 15, null);
        CardDataUtils.a.getClass();
        this.this$0.b(CardDataUtils.b(r10), this.$cardContext, r2);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        if (this.$cardRenderEntityConfig.c == false) goto L16;
        d r11 = this.this$0;     // Catch: Throwable -> L22
        String r3 = this.$serverEntityJson;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        r9 = d.c(r11, r3, this);     // Catch: Throwable -> L22
        if (r9 != r0) goto L15;
        return r0;
    L16:
        d r12 = this.this$0;     // Catch: Throwable -> L22
        String r4 = this.$serverEntityJson;     // Catch: Throwable -> L22
        int r5 = d.d;     // Catch: Throwable -> L22
        r12.getClass();     // Catch: Throwable -> L22
        SdkSender.d r13 = SdkSender.syncSendMayError(Command.TRANS_SER2CLI_UNIVERSAL_CARD_ENTITY, new TransSer2CliUniversalCardEntityRequest.Builder().universal_card_entity(r4), e.a);     // Catch: Throwable -> L22
        ErrorResult r6 = r13.b;     // Catch: Throwable -> L22
        if (r6 != null) goto L21;
        r10 = (UniversalCardEntity) r13.a;     // Catch: Throwable -> L22
        goto L19
    L21:
        throw r6;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Log.e("CardRenderByServerEntityImpl", "convert entity fail, " + th.getMessage());
        return Unit.INSTANCE;
    }
}
