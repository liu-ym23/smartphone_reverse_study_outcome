package com.larus.bmhome.chat.component.share;

import android.graphics.Bitmap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import by7.e;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.immerse.k0;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.b;
import com.larus.bmhome.share.panel.h;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$onShareLongImageButtonClick$1", f = "ChatShareBottomComponent.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {1728, 1752, 1762}, m = "invokeSuspend", n = {"$this$launch", "qrcodeUrl", "shareUrl", "shareUrlUpdated", "qrcodeUrlUpdated", "$this$launch", "qrcodeUrl", "shareUrl", "shareUrlUpdated", "qrcodeUrlUpdated", "loadingDeferred", "$this$launch", "qrcodeUrl", "shareUrl", "shareUrlUpdated", "qrcodeUrlUpdated", "immersiveBgColor"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6"})
final class ChatShareBottomComponent$onShareLongImageButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    public ChatShareBottomComponent$onShareLongImageButtonClick$1(ChatShareBottomComponent r1, Continuation<? super ChatShareBottomComponent$onShareLongImageButtonClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatShareBottomComponent$onShareLongImageButtonClick$1 r0 = new ChatShareBottomComponent$onShareLongImageButtonClick$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r101) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        e r9 = null;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        Integer r3 = (Integer) this.L$6;
        ChatShareBottomComponent r4 = (ChatShareBottomComponent) this.L$5;
        Ref.BooleanRef r5 = (Ref.BooleanRef) this.L$4;
        Ref.BooleanRef r6 = (Ref.BooleanRef) this.L$3;
        Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$2;
        Ref.ObjectRef r10 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r101);
        Object r8 = r101;
        Integer r18 = r3;
        Ref.BooleanRef r20 = r5;
        Ref.BooleanRef r23 = r6;
        Ref.ObjectRef r24 = r7;
        Ref.ObjectRef r21 = r10;
    L64:
        b r12 = (b) r8;
        if (r12 != null) goto L67;
        t19.s.a.g(s1a.a.c(r4).getContext(), 2131900870, false);
    L73:
        return Unit.INSTANCE;
    L67:
        ShareServiceDelegate r13 = ShareServiceDelegate.b;
        FragmentActivity r14 = s1a.a.c(r4).getActivity();
        int r15 = ChatShareBottomComponent.R;
        boolean r17 = r4.W3().g().C();
        h r16 = new h(r4.h(), r4.E3(), null, null, null, null, ChatShareBottomComponent.z3(r4), null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r4.c4(), null, null, null, false, null, null, null, null, -132, -1, 1021);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Fragment r19 = com.larus.ui.arch.component.internal.attach.a.b(r4, r4);
        if ((r19 instanceof e) == false) goto L70;
        r9 = (e) r19;
    L70:
        r13.j(r14, new com.larus.bmhome.share.panel.e(r17, r18, r16, r9, true, new ChatShareBottomComponent$onShareLongImageButtonClick$1$2$1(r20, r21, r4, r23, r24, null), 8), r12);
        goto L73
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Deferred r22 = (Deferred) this.L$5;
        Ref.BooleanRef r25 = (Ref.BooleanRef) this.L$4;
        Ref.BooleanRef r110 = (Ref.BooleanRef) this.L$3;
        Ref.ObjectRef r111 = (Ref.ObjectRef) this.L$2;
        Ref.ObjectRef r112 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r101);
        Object r26 = r101;
        Ref.BooleanRef r27 = r25;
    L11:
        Ref.BooleanRef r28 = r110;
        Pair r29 = (Pair) r26;
        if (r29 == null) goto L73;
        ChatShareBottomComponent r30 = this.this$0;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
        int r31 = ChatShareBottomComponent.R;
        u7 r32 = r30.Z3();
        if (r32 == null) goto L53;
        r32.dismissLoading();
    L53:
        int r33 = ((Number) r29.getSecond()).intValue();
        Bitmap r34 = (Bitmap) r29.getFirst();
        FLogger.a.i("ChatShareBottomComponent", "showLongImageSharePanel: code = " + r33);
        if (r33 != 0) goto L71;
        if (r34 == null) goto L71;
        Integer r35 = r30.W3().g().m();
        if (r35 == null) goto L59;
        Integer r36 = Boxing.boxInt(k0.a(r35.intValue(), 0.4f, 0.15f));
    L60:
        String r37 = (String) r111.element;
        ShareServiceDelegate r114 = ShareServiceDelegate.b;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        String r115 = r114.p(com.larus.ui.arch.component.internal.attach.a.b(r30, r30).getContext(), r30.E3());
        Intrinsics.checkNotNullParameter(r30, "<this>");
        String r116 = com.larus.ui.arch.component.internal.attach.a.b(r30, r30).getString(2131909359);
        this.L$0 = r113;
        this.L$1 = r112;
        this.L$2 = r111;
        this.L$3 = r28;
        this.L$4 = r27;
        this.L$5 = r30;
        this.L$6 = r36;
        this.label = 3;
        r8 = ChatShareBottomComponent.m3(r30, r34, r37, r115, r116);
        if (r8 != r1) goto L63;
        return r1;
    L63:
        r18 = r36;
        r4 = r30;
        r20 = r27;
        r23 = r28;
        r24 = r111;
        r21 = r112;
        goto L64
    L59:
        r36 = null;
    L71:
        t19.s r38 = t19.s.a;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        r38.g(com.larus.ui.arch.component.internal.attach.a.b(r30, r30).getContext(), 2131900870, false);
        goto L73
    L12:
        Ref.BooleanRef r39 = (Ref.BooleanRef) this.L$4;
        r110 = (Ref.BooleanRef) this.L$3;
        r111 = (Ref.ObjectRef) this.L$2;
        r112 = (Ref.ObjectRef) this.L$1;
        r113 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r101);
        Object r117 = r101;
    L32:
        BizResponse r118 = (BizResponse) r117;
        if (r118 == null) goto L42;
        SaveMessageShareInfo r119 = (SaveMessageShareInfo) r118.getData();
        if (r119 == null) goto L42;
        String r40 = r119.getQrCodeUrl();
        if (r40 == null) goto L39;
        FLogger.a.i("ChatShareBottomComponent", "longImageButtonDeffer is completed, and set to qrcodeUrl");
        r112.element = r40;
        r39.element = true;
    L39:
        String r41 = r119.getShareUrl();
        if (r41 == null) goto L42;
        FLogger.a.i("ChatShareBottomComponent", "longImageButtonDeffer is completed, and set to shareUrl");
        r111.element = r41;
        r110.element = true;
    L42:
        FLogger.a.i("ChatShareBottomComponent", "onShareLongImageButtonClick");
        Deferred r42 = BuildersKt.async$default(r113, Dispatchers.getMain(), null, new ChatShareBottomComponent$onShareLongImageButtonClick$1$loadingDeferred$1(this.this$0, null), 2, null);
        Deferred r43 = this.this$0.N;
        if (r43 == null) goto L73;
        this.L$0 = r113;
        this.L$1 = r112;
        this.L$2 = r111;
        this.L$3 = r110;
        this.L$4 = r39;
        this.L$5 = r42;
        this.label = 2;
        r26 = r43.await(this);
        if (r26 != r1) goto L47;
        return r1;
    L47:
        r27 = r39;
        r22 = r42;
        goto L11
    L13:
        ResultKt.throwOnFailure(r101);
        r113 = (CoroutineScope) this.L$0;
        r112 = new Ref.ObjectRef();
        r112.element = ChatShareBottomComponent.p3(this.this$0);
        r111 = new Ref.ObjectRef();
        BotModel r44 = this.this$0.E3();
        if (r44 == null) goto L19;
        ShareInfo r45 = r44.getShareInfo();
        if (r45 == null) goto L19;
        String r46 = r45.getShareBotUrl();
        if (r46 == null) goto L19;
    L20:
        r111.element = r46;
        r110 = new Ref.BooleanRef();
        r39 = new Ref.BooleanRef();
        Deferred r120 = this.this$0.M;
        if (r120 != null) goto L23;
    L25:
        boolean r121 = false;
    L26:
        if (r121 == false) goto L42;
        Deferred r122 = this.this$0.M;
        if (r122 == null) goto L42;
        this.L$0 = r113;
        this.L$1 = r112;
        this.L$2 = r111;
        this.L$3 = r110;
        this.L$4 = r39;
        this.label = 1;
        r117 = r122.await(this);
        if (r117 != r1) goto L32;
        return r1;
    L23:
        if (r120.isCompleted() != true) goto L25;
        r121 = true;
    L19:
        r46 = AppHost.a.d();
        goto L20
    }
}
