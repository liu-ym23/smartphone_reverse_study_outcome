package com.larus.bmhome.block.holder.content.lynx;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LynxBlock;
import com.larus.platform.api.e4;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.block.holder.content.lynx.LynxCardBlockHolder$initLynxView$2", f = "LynxCardBlockHolder.kt", i = {0, 0}, l = {255, 259}, m = "invokeSuspend", n = {"$this$launch", "data"}, s = {"L$0", "L$1"})
final class LynxCardBlockHolder$initLynxView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fb8.g $blockModel;
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ long $initGeneration;
    final /* synthetic */ String $initLynxUrl;
    final /* synthetic */ Message $initMessage;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LynxCardBlockHolder this$0;

    public LynxCardBlockHolder$initLynxView$2(fb8.g r1, String r2, LynxCardBlockHolder r3, Message r4, long r5, FrameLayout r7, Continuation<? super LynxCardBlockHolder$initLynxView$2> r8) {
        this.$blockModel = r1;
        this.$initLynxUrl = r2;
        this.this$0 = r3;
        this.$initMessage = r4;
        this.$initGeneration = r5;
        this.$container = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        LynxCardBlockHolder$initLynxView$2 r9 = new LynxCardBlockHolder$initLynxView$2(this.$blockModel, this.$initLynxUrl, this.this$0, this.$initMessage, this.$initGeneration, this.$container, r12);
        r9.L$0 = r11;
        return r9;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r5 = true;
        String r6 = "";
        if (r3 == 0) goto L13;
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L9;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L104
    L46:
        e4 r14 = (e4) r13;     // Catch: Throwable -> L104
    L48:
        fb8.g r0 = this.this$0.s;     // Catch: Throwable -> L104
        if (r0 == null) goto L51;
        Message r1 = r0.j();     // Catch: Throwable -> L104
    L52:
        if (r1 != null) goto L54;
    L56:
        r5 = false;
    L57:
        long r4 = this.$initGeneration;     // Catch: Throwable -> L104
        LynxCardBlockHolder r7 = this.this$0;     // Catch: Throwable -> L104
        if (r4 != r7.r) goto L87;
        if (r5 == false) goto L87;
        r7.i = this.$initLynxUrl;     // Catch: Throwable -> L104
        r7.h = r14;     // Catch: Throwable -> L104
        if (r14 == null) goto L64;
        View r15 = r14.getView();     // Catch: Throwable -> L104
    L65:
        if (r15 != null) goto L70;
        LynxCardBlockHolder r16 = this.this$0;     // Catch: Throwable -> L104
        r16.h = null;     // Catch: Throwable -> L104
        r16.i = null;     // Catch: Throwable -> L104
        View r17 = r16.t;     // Catch: Throwable -> L104
        if (r17 == null) goto L69;
        r17.setVisibility(0);     // Catch: Throwable -> L104
    L69:
        FLogger.a.e(this.this$0.f, "lynxView?.getView() return null");     // Catch: Throwable -> L104
    L78:
        Runnable r18 = this.this$0.m;     // Catch: Throwable -> L104
        if (r18 == null) goto L81;
        r18.run();     // Catch: Throwable -> L104
    L81:
        LynxCardBlockHolder r19 = this.this$0;     // Catch: Throwable -> L104
        r19.m = null;     // Catch: Throwable -> L104
        if (this.$initGeneration != r19.r) goto L86;
        r19.l = null;
        r19.q = false;
        r19.j = null;
    L86:
        return Unit.INSTANCE;
    L70:
        View r110 = this.this$0.t;     // Catch: Throwable -> L104
        if (r110 == null) goto L73;
        r110.setVisibility(8);     // Catch: Throwable -> L104
    L73:
        e4 r111 = this.this$0.h;     // Catch: Throwable -> L104
        if (r111 == null) goto L78;
        View r112 = r111.getView();     // Catch: Throwable -> L104
        if (r112 == null) goto L78;
        this.$container.addView(r112, new FrameLayout.LayoutParams(this.this$0.u, -2));     // Catch: Throwable -> L104
        goto L78
    L64:
        r15 = null;
    L87:
        if (r14 == null) goto L95;
        String r8 = this.$initLynxUrl;     // Catch: Throwable -> L104
        eh8.b r9 = (eh8.b) r7.p.getValue();     // Catch: Throwable -> L104
        if (r9 == null) goto L94;
        if (r8 == null) goto L93;
        r6 = r8;
    L93:
        r9.a(r6, r14);     // Catch: Throwable -> L104
        goto L95
    L94:
        r7.m(r14);     // Catch: Throwable -> L104
    L95:
        FLogger r113 = FLogger.a;     // Catch: Throwable -> L104
        String r10 = this.this$0.f;     // Catch: Throwable -> L104
        StringBuilder r11 = new StringBuilder("initLynxView aborted, bind changed. current=");     // Catch: Throwable -> L104
        if (r1 == null) goto L98;
        String r12 = r1.getMessageId();     // Catch: Throwable -> L104
    L99:
        r11.append(r12);     // Catch: Throwable -> L104
        r11.append(", initFor=");     // Catch: Throwable -> L104
        r11.append(this.$initMessage.getMessageId());     // Catch: Throwable -> L104
        r113.i(r10, r11.toString());     // Catch: Throwable -> L104
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L104
        long r20 = this.$initGeneration;
        LynxCardBlockHolder r21 = this.this$0;
        if (r20 != r21.r) goto L103;
        r21.l = null;
        r21.q = false;
        r21.j = null;
    L103:
        return r114;
    L98:
        r12 = null;
        goto L99
    L54:
        if (k.a(this.$initMessage.getMessageId(), this.$initMessage.getLocalMessageId(), r1.getMessageId(), r1.getLocalMessageId()) == false) goto L56;
    L51:
        r1 = null;
        goto L52
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Ref.ObjectRef r22 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r23 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L104
    L37:
        r14 = (e4) r13;     // Catch: Throwable -> L104
        if (r14 != null) goto L48;
        Ref.ObjectRef r24 = r22;
    L40:
        LynxCardBlockHolder r115 = this.this$0;     // Catch: Throwable -> L104
        String r25 = this.$initLynxUrl;     // Catch: Throwable -> L104
        if (r25 != null) goto L43;
        r25 = "";
    L43:
        String r26 = (String) r24.element;     // Catch: Throwable -> L104
        this.L$0 = null;     // Catch: Throwable -> L104
        this.L$1 = null;     // Catch: Throwable -> L104
        this.label = 2;     // Catch: Throwable -> L104
        r13 = LynxCardBlockHolder.j(r115, r25, r26, this);     // Catch: Throwable -> L104
        if (r13 != r2) goto L46;
        return r2;
    L13:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r116 = (CoroutineScope) this.L$0;
        r24 = new Ref.ObjectRef();     // Catch: Throwable -> L104
        BlockContent r27 = this.$blockModel.a.getContent();     // Catch: Throwable -> L104
        if (r27 == null) goto L19;
        LynxBlock r28 = r27.getLynxBlock();     // Catch: Throwable -> L104
        if (r28 == null) goto L19;
        String r29 = r28.lynxData;     // Catch: Throwable -> L104
    L20:
        r24.element = r29;     // Catch: Throwable -> L104
        if (o0.d(this.$initLynxUrl) == false) goto L47;
        String r30 = (String) r24.element;     // Catch: Throwable -> L104
        if (r30 == null) goto L25;
        LynxCardBlockHolder r117 = this.this$0;     // Catch: Throwable -> L104
        int r118 = LynxCardBlockHolder.y;     // Catch: Throwable -> L104
        String r31 = r117.o(r30);     // Catch: Throwable -> L104
    L26:
        if (r31 != null) goto L28;
        r31 = "";
    L28:
        r24.element = r31;     // Catch: Throwable -> L104
        FLogger.a.i(this.this$0.f, "initLynx hasLynxUrl=true, dataLength=" + ((String) r24.element).length());     // Catch: Throwable -> L104
        eh8.b r32 = (eh8.b) this.this$0.p.getValue();     // Catch: Throwable -> L104
        if (r32 == null) goto L40;
        String r33 = this.$initLynxUrl;     // Catch: Throwable -> L104
        if (r33 != null) goto L33;
        r33 = "";
    L33:
        String r119 = (String) r24.element;     // Catch: Throwable -> L104
        this.L$0 = r116;     // Catch: Throwable -> L104
        this.L$1 = r24;     // Catch: Throwable -> L104
        this.label = 1;     // Catch: Throwable -> L104
        r13 = r32.b(r33, r119);     // Catch: Throwable -> L104
        if (r13 != r2) goto L36;
        return r2;
    L36:
        r22 = r24;
        goto L37
    L25:
        r31 = null;
        goto L26
    L47:
        LynxCardBlockHolder.r(this.this$0);     // Catch: Throwable -> L104
        r14 = null;
    L19:
        r29 = null;
    L104:
        th = move-exception;
        long r34 = this.$initGeneration;
        LynxCardBlockHolder r35 = this.this$0;
        if (r34 != r35.r) goto L108;
        r35.l = null;
        r35.q = false;
        r35.j = null;
    L108:
        throw th;
    }
}
