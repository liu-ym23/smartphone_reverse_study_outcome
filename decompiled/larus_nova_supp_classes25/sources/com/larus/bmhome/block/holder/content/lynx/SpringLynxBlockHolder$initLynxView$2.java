package com.larus.bmhome.block.holder.content.lynx;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SpringLynxBlock;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import s09.a;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.SpringLynxBlockHolder$initLynxView$2", f = "SpringLynxBlockHolder.kt", i = {0, 0, 0, 1}, l = {203, 208}, m = "invokeSuspend", n = {"$this$launch", "data", "isFromCache", "isFromCache"}, s = {"L$0", "L$1", "L$2", "L$0"})
final class SpringLynxBlockHolder$initLynxView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fb8.k $blockModel;
    final /* synthetic */ FrameLayout $container;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SpringLynxBlockHolder this$0;

    public SpringLynxBlockHolder$initLynxView$2(SpringLynxBlockHolder r1, fb8.k r2, FrameLayout r3, Continuation<? super SpringLynxBlockHolder$initLynxView$2> r4) {
        this.this$0 = r1;
        this.$blockModel = r2;
        this.$container = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SpringLynxBlockHolder$initLynxView$2 r0 = new SpringLynxBlockHolder$initLynxView$2(this.this$0, this.$blockModel, this.$container, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r5 = "";
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        SpringLynxBlockHolder r3 = (SpringLynxBlockHolder) this.L$1;
        Ref.BooleanRef r4 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r6 = r18;
    L99:
        Ref.BooleanRef r10 = r4;
        e4 r7 = (e4) r6;
        SpringLynxBlockHolder r8 = r3;
    L100:
        r8.g = r7;
    L111:
        if (r10.element == false) goto L115;
        View r9 = this.this$0.n;
        if (r9 == null) goto L115;
        r9.setVisibility(8);
    L115:
        e4 r11 = this.this$0.g;
        if (r11 == null) goto L118;
        View r12 = r11.getView();
    L119:
        if (r12 != null) goto L124;
        SpringLynxBlockHolder r13 = this.this$0;
        r13.g = null;
        r13.h = null;
        View r14 = r13.o;
        if (r14 == null) goto L123;
        r14.setVisibility(0);
    L123:
        FLogger.a.e("SpringLynxBlockHolder", "lynxView?.getView() return null");
    L136:
        Runnable r15 = this.this$0.i;
        if (r15 == null) goto L139;
        r15.run();
    L139:
        SpringLynxBlockHolder r16 = this.this$0;
        r16.i = null;
        r16.l = false;
        return Unit.INSTANCE;
    L124:
        View r17 = this.this$0.o;
        if (r17 == null) goto L127;
        r17.setVisibility(8);
    L127:
        e4 r19 = this.this$0.g;
        if (r19 == null) goto L136;
        View r20 = r19.getView();
        if (r20 == null) goto L136;
        FrameLayout r21 = this.$container;
        SpringLynxBlockHolder r22 = this.this$0;
        r21.addView(r20);
        ViewGroup.LayoutParams r23 = r20.getLayoutParams();
        if (r23 == null) goto L135;
        r23.width = r22.p;
        r20.setLayoutParams(r23);
        goto L136
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L118:
        r12 = null;
        goto L119
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        SpringLynxBlockHolder r24 = (SpringLynxBlockHolder) this.L$3;
        Ref.BooleanRef r25 = (Ref.BooleanRef) this.L$2;
        Ref.ObjectRef r26 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        r8 = r24;
        Object r27 = r18;
    L86:
        r7 = (e4) r27;
        if (r7 == null) goto L89;
        r10 = r25;
        goto L100
    L89:
        r4 = r25;
    L91:
        SpringLynxBlockHolder r28 = this.this$0;
        r4.element = false;
        String r111 = r28.h;
        if (r111 == null) goto L95;
        r5 = r111;
    L95:
        String r29 = (String) r26.element;
        this.L$0 = r4;
        this.L$1 = r8;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        r6 = SpringLynxBlockHolder.j(r28, r5, r29, this);
        if (r6 != r1) goto L98;
        return r1;
    L98:
        r3 = r8;
        goto L99
    L10:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r30 = (CoroutineScope) this.L$0;
        SpringLynxBlockHolder r31 = this.this$0;
        BlockContent r112 = this.$blockModel.a.getContent();
        if (r112 == null) goto L15;
        SpringLynxBlock r113 = r112.getSpringLynxBlock();
        if (r113 == null) goto L15;
        String r114 = r113.lynxUrl;
    L16:
        r31.h = r114;
        r26 = new Ref.ObjectRef();
        BlockContent r115 = this.$blockModel.a.getContent();
        if (r115 == null) goto L21;
        SpringLynxBlock r116 = r115.getSpringLynxBlock();
        if (r116 == null) goto L21;
        String r117 = r116.data;
    L22:
        r26.element = r117;
        r10 = new Ref.BooleanRef();
        r10.element = true;
        FLogger r118 = FLogger.a;
        StringBuilder r119 = new StringBuilder("lynxUrl: ");
        r119.append(this.this$0.h);
        r119.append(", data: ");
        String r120 = (String) r26.element;
        if (r120 == null) goto L25;
        Integer r121 = Boxing.boxInt(r120.length());
    L26:
        r119.append(r121);
        r118.i("SpringLynxBlockHolder", r119.toString());
        if (o0.d(this.this$0.h) == false) goto L101;
        SpringLynxBlockHolder r122 = this.this$0;
        String r123 = r122.h;
        if (r123 == null) goto L68;
        String r124 = this.$blockModel.j().getMessageId();
        if (r124 != null) goto L33;
        r124 = "";
    L33:
        a r125 = PollingConfigService.a.d();
        if (r125 == null) goto L40;
        Map r126 = r125.a;
        if (r126 == null) goto L40;
        String r32 = (String) r126.get("builtin_dg_c");
        if (r32 == null) goto L40;
        int r33 = l3.e(r32, 0);
    L41:
        if (r125 == null) goto L47;
        Map r127 = r125.a;
        if (r127 == null) goto L47;
        String r128 = (String) r127.get("gecko_dg");
        if (r128 == null) goto L47;
        int r129 = l3.e(r128, 0);
    L48:
        Uri r130 = y0.j(r123);
        if (r130 == null) goto L69;
        Uri r34 = y0.l(y0.l(y0.l(y0.l(y0.l(y0.l(r130, "disable_builtin", String.valueOf(r33)), "disable_gecko", String.valueOf(r129)), "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1"), "larus_message_id", r124);
        if (AppHost.a.isTestChannel() == false) goto L67;
        IFlowSdkDepend r131 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r131 == null) goto L60;
        FlowAppletServiceImpl r132 = r131.g0();
        if (r132 == null) goto L60;
        if (r132.e() != true) goto L60;
        boolean r133 = true;
    L61:
        if (r133 == false) goto L67;
        IFlowSdkDepend r134 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r134 == null) goto L67;
        FlowAppletServiceImpl r135 = r134.g0();
        if (r135 == null) goto L67;
        r34 = y0.a(r34, r135.f());
    L60:
        r133 = false;
    L67:
        r123 = r34.toString();
    L69:
        if (r123 != null) goto L71;
        r123 = "";
    L71:
        r122.h = r123;
        String r35 = (String) r26.element;
        if (r35 == null) goto L74;
        String r36 = this.this$0.k(r35);
    L75:
        if (r36 != null) goto L77;
        r36 = "";
    L77:
        r26.element = r36;
        r8 = this.this$0;
        eh8.b r136 = (eh8.b) r8.k.getValue();
        if (r136 == null) goto L90;
        String r137 = this.this$0.h;
        if (r137 != null) goto L82;
        r137 = "";
    L82:
        String r138 = (String) r26.element;
        this.L$0 = r30;
        this.L$1 = r26;
        this.L$2 = r10;
        this.L$3 = r8;
        this.label = 1;
        r27 = r136.b(r137, r138);
        if (r27 != r1) goto L85;
        return r1;
    L85:
        r25 = r10;
        goto L86
    L90:
        r4 = r10;
        goto L91
    L74:
        r36 = null;
    L47:
        r129 = 0;
    L40:
        r33 = 0;
        goto L41
    L68:
        r123 = null;
        goto L69
    L101:
        SpringLynxBlockHolder r37 = this.this$0;
        fb8.k r38 = r37.m;
        if (r38 == null) goto L104;
        Message r39 = r38.j();
    L105:
        if (r39 == null) goto L107;
        boolean r40 = com.larus.bmhome.chat.bean.d.t0(r39);
    L108:
        if (r40 == false) goto L111;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r37), null, null, new SpringLynxBlockHolder$reportPocketMessageCardError$1(r37, DoraCallStateCode.DOUBAO_STOP_CALL_BY_CONVERSATION_MODE, null, null), 3, null);
        goto L111
    L107:
        r40 = false;
        goto L108
    L104:
        r39 = null;
        goto L105
    L25:
        r121 = null;
    L21:
        r117 = null;
    L15:
        r114 = null;
        goto L16
    }
}
