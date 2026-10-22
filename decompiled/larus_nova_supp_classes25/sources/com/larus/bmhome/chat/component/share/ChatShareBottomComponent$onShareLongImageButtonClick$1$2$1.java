package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.g;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/share/panel/NewShareData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1", f = "ChatShareBottomComponent.kt", i = {1}, l = {1792, 1797}, m = "invokeSuspend", n = {"newQRCodeUrl"}, s = {"L$0"})
public final class ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1 extends SuspendLambda implements Function1<Continuation<? super g>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $qrcodeUrl;
    final /* synthetic */ Ref.BooleanRef $qrcodeUrlUpdated;
    final /* synthetic */ Ref.ObjectRef<String> $shareUrl;
    final /* synthetic */ Ref.BooleanRef $shareUrlUpdated;
    Object L$0;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1(Ref.BooleanRef r1, Ref.ObjectRef<String> r2, ChatShareBottomComponent r3, Ref.BooleanRef r4, Ref.ObjectRef<String> r5, Continuation<? super ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1> r6) {
        this.$qrcodeUrlUpdated = r1;
        this.$qrcodeUrl = r2;
        this.this$0 = r3;
        this.$shareUrlUpdated = r4;
        this.$shareUrl = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1(this.$qrcodeUrlUpdated, this.$qrcodeUrl, this.this$0, this.$shareUrlUpdated, this.$shareUrl, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super g> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);
    L37:
        BizResponse r8 = (BizResponse) r7;
        if (r8 == null) goto L45;
        SaveMessageShareInfo r9 = (SaveMessageShareInfo) r8.getData();
        if (r9 == null) goto L45;
        String r10 = r9.getShareUrl();
        if (r10 == null) goto L45;
        String r5 = r2;
        String r3 = r10;
        String r11 = r5;
    L47:
        ChatShareBottomComponent r4 = this.this$0;
        int r6 = ChatShareBottomComponent.R;
        u7 r12 = r4.Z3();
        if (r12 == null) goto L51;
        r12.dismissLoading();
    L51:
        return new g(r11, (String) this.$qrcodeUrl.element, r3, (String) this.$shareUrl.element);
    L45:
        r11 = r2;
    L46:
        r3 = ChatShareBottomComponent.p3(this.this$0);
        goto L47
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L21:
        BizResponse r13 = (BizResponse) r7;
        if (r13 == null) goto L27;
        SaveMessageShareInfo r14 = (SaveMessageShareInfo) r13.getData();
        if (r14 == null) goto L27;
        r11 = r14.getQrCodeUrl();
        if (r11 == null) goto L27;
    L29:
        if (this.$shareUrlUpdated.element == false) goto L31;
        r3 = (String) this.$shareUrl.element;
        goto L47
    L31:
        Deferred r15 = this.this$0.M;
        if (r15 == null) goto L46;
        this.L$0 = r11;
        this.label = 2;
        Object r16 = r15.await(this);
        if (r16 != r0) goto L36;
        return r0;
    L36:
        r2 = r11;
        r7 = r16;
    L27:
        r11 = ChatShareBottomComponent.p3(this.this$0);
        goto L29
    L10:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("ChatShareBottomComponent", "shareContentGetter invoke:");
        if (this.$qrcodeUrlUpdated.element == false) goto L13;
        r11 = (String) this.$qrcodeUrl.element;
        goto L29
    L13:
        ChatShareBottomComponent r17 = this.this$0;
        int r18 = ChatShareBottomComponent.R;
        u7 r19 = r17.Z3();
        if (r19 == null) goto L16;
        r19.showLoading();
    L16:
        Deferred r20 = this.this$0.M;
        if (r20 == null) goto L27;
        this.label = 1;
        r7 = r20.await(this);
        if (r7 != r0) goto L21;
        return r0;
    }
}
