package com.larus.bmhome.chat.layout.holder.image.utils;

import android.content.Context;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.c2;
import com.larus.bmhome.instruction.j;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.common.apphost.AppHost;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.uaigc.api.m;
import com.larus.uaigc.api.n;
import com.larus.uaigc.api.p;
import com.larus.uaigc.api.q;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ny9.u;
import ouc.v;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils$handleImageBeautifyAction$5", f = "AiCreationEditUtils.kt", i = {0}, l = {228, 287}, m = "invokeSuspend", n = {"url"}, s = {"L$0"})
public final class AiCreationEditUtils$handleImageBeautifyAction$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z0 $actionBarItem;
    final /* synthetic */ String $botId;
    final /* synthetic */ Context $context;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function0<Unit> $dismissCreationPage;
    final /* synthetic */ Function1<ICoreInputAbility.OnSendParams, Unit> $doSend;
    final /* synthetic */ int $imageBeautifyId;
    final /* synthetic */ boolean $openNewChatPage;
    final /* synthetic */ ic8.f $params;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ Function4<ImageEditDataWithMask, String, String, u, Unit> $sendImageRemoveMessage;
    final /* synthetic */ Function1<xy9.b, Unit> $showDialogFragment;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AiCreationEditUtils$handleImageBeautifyAction$5(ic8.f r1, Context r2, z0 r3, int r4, CoroutineScope r5, boolean r6, String r7, String r8, String r9, wc9.e r10, Function4<? super ImageEditDataWithMask, ? super String, ? super String, ? super u, Unit> r11, Function1<? super xy9.b, Unit> r12, Function0<Unit> r13, Function1<? super ICoreInputAbility.OnSendParams, Unit> r14, Continuation<? super AiCreationEditUtils$handleImageBeautifyAction$5> r15) {
        this.$params = r1;
        this.$context = r2;
        this.$actionBarItem = r3;
        this.$imageBeautifyId = r4;
        this.$scope = r5;
        this.$openNewChatPage = r6;
        this.$creationTaskId = r7;
        this.$cvsId = r8;
        this.$botId = r9;
        this.$conversation = r10;
        this.$sendImageRemoveMessage = r11;
        this.$showDialogFragment = r12;
        this.$dismissCreationPage = r13;
        this.$doSend = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new AiCreationEditUtils$handleImageBeautifyAction$5(this.$params, this.$context, this.$actionBarItem, this.$imageBeautifyId, this.$scope, this.$openNewChatPage, this.$creationTaskId, this.$cvsId, this.$botId, this.$conversation, this.$sendImageRemoveMessage, this.$showDialogFragment, this.$dismissCreationPage, this.$doSend, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r42) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r42);
    L216:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r42);
        Object r3 = r42;
    L13:
        String r4 = r1;
        q r5 = (q) r3;
        if (r5 == null) goto L16;
        String r6 = r5.c();
    L18:
        if (o0.d(r6) == true) goto L21;
        FLogger.a.e("AiCreationEditUtils", "explain resource fail");
        s r2 = s.a;
        Context r7 = this.$context;
        r2.getClass();
        s.b(r7, 2131908080, false);
        return Unit.INSTANCE;
    L21:
        AiCreationEditUtils.a.getClass();
        if (r6 != null) goto L24;
        String r18 = "";
    L25:
        if (r5 == null) goto L35;
        p r8 = r5.b();
        if (r8 == null) goto L35;
        n r9 = r8.a();
        if (r9 == null) goto L35;
        m r10 = r9.a();
        if (r10 == null) goto L35;
        Long r11 = r10.a();
        if (r11 == null) goto L35;
        int r12 = (int) r11.longValue();
    L36:
        if (r5 == null) goto L46;
        p r13 = r5.b();
        if (r13 == null) goto L46;
        n r15 = r13.a();
        if (r15 == null) goto L46;
        m r16 = r15.a();
        if (r16 == null) goto L46;
        Long r17 = r16.b();
        if (r17 == null) goto L46;
        int r19 = (int) r17.longValue();
    L47:
        AttachmentInfo r110 = new AttachmentInfo(true, r18, Integer.valueOf(r12), Integer.valueOf(r19), "", "", "edit", null, null, null, null, r4, null, null, null, null, null, 128896, null);
        z0 r20 = this.$actionBarItem;
        if (r20 == null) goto L50;
        r r111 = r20.q;
    L52:
        if (r111 != null) goto L55;
        FLogger.a.e("AiCreationEditUtils", "instructionConf is null");
        s r21 = s.a;
        Context r22 = this.$context;
        r21.getClass();
        s.b(r22, 2131908214, false);
        return Unit.INSTANCE;
    L55:
        String r112 = HttpExtKt.p(new aq8.g(null, "0", String.valueOf(this.$imageBeautifyId), null, 9));
        IInstructionService.Companion r113 = IInstructionService.a;
        gq8.a r114 = gq8.a.a;
        Integer r23 = r111.a;
        r114.getClass();
        List r24 = IInstructionService.a.a(r113, r111, new com.larus.bmhome.view.actionbar.edit.d(gq8.a.b(r23, r112, null)), null, null, 12).b();
        if (r24 == null) goto L58;
        List r25 = CollectionsKt.toMutableList(r24);
    L59:
        List<com.larus.bmhome.actionbar.model.u> r26 = r111.b;
        if (r26 == null) goto L120;
        Iterator<T> r27 = r26.iterator();
    L63:
        if (r27.hasNext() == false) goto L74;
        Object r28 = r27.next();
        Integer r29 = ((com.larus.bmhome.actionbar.model.u) r28).b;
        if (r29 != null) goto L68;
    L70:
        boolean r30 = false;
    L71:
        if (r30 == false) goto L63;
    L75:
        com.larus.bmhome.actionbar.model.u r31 = (com.larus.bmhome.actionbar.model.u) r28;
        if (r31 == null) goto L120;
        Integer r32 = r31.a;
        AiCreationEditUtils r33 = AiCreationEditUtils.a;
        if (r5 == null) goto L86;
        p r115 = r5.b();
        if (r115 == null) goto L86;
        n r116 = r115.a();
        if (r116 == null) goto L86;
        m r117 = r116.a();
        if (r117 == null) goto L86;
        Long r118 = r117.a();
    L87:
        if (r5 == null) goto L95;
        p r119 = r5.b();
        if (r119 == null) goto L95;
        n r120 = r119.a();
        if (r120 == null) goto L95;
        m r121 = r120.a();
        if (r121 == null) goto L95;
        Long r122 = r121.b();
    L96:
        MediaAttachment r123 = new MediaAttachment(r4, r6, new ImageUploadInfo(r122, r118), null, null, null, null, null, null, null, null, null, 4088, null);
        r33.getClass();
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L114
        v r35 = xt7.d.b;     // Catch: Throwable -> L103
        juc.c r36 = m1.Companion.serializer();     // Catch: Throwable -> L103
        String r37 = r31.d;     // Catch: Throwable -> L103
        if (r37 != null) goto L101;
        r37 = "";
    L101:
        Object r38 = Result.constructor-impl((m1) r35.c(r36, r37));     // Catch: Throwable -> L103
    L106:
        if (Result.isFailure-impl(r38) == false) goto L108;
        r38 = null;
    L108:
        m1 r39 = (m1) r38;     // Catch: Throwable -> L114
        if (r39 == null) goto L111;
        String r40 = xt7.d.b.a(m1.Companion.serializer(), m1.a(r39, r123));     // Catch: Throwable -> L114
    L112:
        Object r41 = Result.constructor-impl(r40);     // Catch: Throwable -> L114
    L117:
        if (Result.isFailure-impl(r41) == false) goto L119;
        r41 = null;
    L119:
        com.larus.bmhome.actionbar.model.u r43 = new com.larus.bmhome.actionbar.model.u(r32, 14, null, (String) r41, null, null, null, 244);
    L121:
        if (r43 == null) goto L124;
        if (r25 == null) goto L124;
        r25.add(r43);
    L124:
        AiCreationEditUtils r44 = AiCreationEditUtils.a;
        int r45 = this.$imageBeautifyId;
        r44.getClass();
        if (r25 == null) goto L182;
        Iterator r46 = r25.iterator();
    L128:
        if (r46.hasNext() == false) goto L138;
        Object r47 = r46.next();
        Integer r48 = ((com.larus.bmhome.actionbar.model.u) r47).b;
        if (r48 != null) goto L133;
    L135:
        boolean r49 = false;
    L136:
        if (r49 == false) goto L128;
    L139:
        com.larus.bmhome.actionbar.model.u r50 = (com.larus.bmhome.actionbar.model.u) r47;
        if (r50 == null) goto L182;
        Result.Companion r51 = Result.Companion;     // Catch: Throwable -> L146
        v r52 = xt7.d.b;     // Catch: Throwable -> L146
        juc.c r53 = b0.Companion.serializer();     // Catch: Throwable -> L146
        String r54 = r50.d;     // Catch: Throwable -> L146
        if (r54 != null) goto L144;
        r54 = "";
    L144:
        Object r55 = Result.constructor-impl((b0) r52.c(r53, r54));     // Catch: Throwable -> L146
    L149:
        if (Result.isFailure-impl(r55) == false) goto L151;
        r55 = null;
    L151:
        b0 r56 = (b0) r55;
        if (r56 == null) goto L182;
        List<c0> r57 = r56.a;
        if (r57 == null) goto L182;
        Iterator<T> r58 = r57.iterator();
    L157:
        if (r58.hasNext() == false) goto L169;
        Object r59 = r58.next();
        c0 r60 = (c0) r59;
        Integer r61 = r60.a;
        if (r61 != null) goto L162;
    L166:
        boolean r62 = false;
    L167:
        if (r62 == false) goto L157;
    L170:
        c0 r63 = (c0) r59;
        if (r63 == null) goto L182;
        String r64 = r63.c;
        if (r64 == null) goto L182;
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L176
        Object r66 = Result.constructor-impl((p1) xt7.d.b.c(p1.Companion.serializer(), r64));     // Catch: Throwable -> L176
    L179:
        if (Result.isFailure-impl(r66) == false) goto L181;
        r66 = null;
    L181:
        p1 r67 = (p1) r66;
    L183:
        if (r67 != null) goto L186;
        FLogger.a.e("AiCreationEditUtils", "multiSelectorInstructionTemplate not has " + this.$imageBeautifyId + " info, or missing multi selector item");
        s r68 = s.a;
        Context r69 = this.$context;
        r68.getClass();
        s.b(r69, 2131908214, false);
        return Unit.INSTANCE;
    L186:
        AiCreationEditUtils.a.getClass();
        Result.Companion r70 = Result.Companion;     // Catch: Throwable -> L189
        v r71 = xt7.d.b;     // Catch: Throwable -> L189
        juc.n r72 = kuc.a.d(r.Companion.serializer());     // Catch: Throwable -> L189
        c2 r73 = c2.a;     // Catch: Throwable -> L189
        Object r74 = Result.constructor-impl(r71.a(r72, j.a.b(r111.a, "", r25, r111)));     // Catch: Throwable -> L189
    L192:
        if (Result.isFailure-impl(r74) == false) goto L194;
        r74 = null;
    L194:
        String r310 = (String) r74;
        c2 r124 = c2.a;
        String r75 = this.$actionBarItem.b;
        if (r75 != null) goto L197;
        String r125 = "";
    L198:
        Map r76 = j.a.c(r124, r125, String.valueOf(r111.a), r310, false, null, null, 48);
        AiCreationEditUtils r77 = AiCreationEditUtils.a;
        z0 r78 = this.$actionBarItem;
        r77.getClass();
        com.larus.bmhome.view.actionbar.custom.e r126 = com.larus.bmhome.view.actionbar.custom.e.a;     // Catch: Exception -> L205
        if (r78 == null) goto L202;
        r r127 = r78.q;     // Catch: Exception -> L205
    L203:
        String r210 = w2.a.a(r126, "", r127, r25, r67, null, 0, null, DoraCallStateCode.DOUBAO_CMD_12);     // Catch: Exception -> L205
    L209:
        AiCreationEditUtils r79 = AiCreationEditUtils.a;
        r79.getClass();
        f r311 = new f();
        if (o0.d(r67.g) == false) goto L212;
        Context r80 = this.$context;
        CoroutineScope r81 = this.$scope;
        String r211 = r6;
        q r212 = r5;
        r r213 = r111;
        List r214 = r25;
        BuildersKt.launch$default(r81, null, null, new AiCreationEditUtils$handleRedirectSchemaAction$1(r4, r81, r80, r211, r212, r210, r76, r213, this.$creationTaskId, this.$cvsId, this.$botId, this.$conversation, r214, r311, this.$imageBeautifyId, this.$openNewChatPage, r67, r310, this.$sendImageRemoveMessage, this.$showDialogFragment, this.$dismissCreationPage, null), 3, null);
        goto L216
    L212:
        Context r82 = this.$context;
        boolean r83 = this.$openNewChatPage;
        String r128 = this.$creationTaskId;
        String r129 = this.$cvsId;
        String r130 = this.$botId;
        wc9.e r131 = this.$conversation;
        Function1<ICoreInputAbility.OnSendParams, Unit> r84 = this.$doSend;
        Function0<Unit> r85 = this.$dismissCreationPage;
        this.L$0 = null;
        this.label = 2;
        Object r410 = r14;
        if (AiCreationEditUtils.a(r79, r82, r83, r210, r310, r76, r110, r111, r311, r128, r129, r130, r131, r84, r85, this) != r410) goto L216;
        return r410;
    L202:
        r127 = null;
    L205:
        e = move-exception;
        FLogger.a.e("AiCreationEditUtils", "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L218;
        r210 = "";
        goto L209
    L218:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    L197:
        r125 = r75;
    L189:
        th = move-exception;
        Result.Companion r86 = Result.Companion;
        r74 = Result.constructor-impl(ResultKt.createFailure(th));
    L176:
        th = move-exception;
        Result.Companion r87 = Result.Companion;
        r66 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L179
    L162:
        if (r61.intValue() != r45) goto L166;
        if (r60.b != 4) goto L166;
        r62 = true;
        goto L167
    L169:
        r59 = null;
    L146:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L149
    L133:
        if (r48.intValue() != 8) goto L135;
        r49 = true;
        goto L136
    L138:
        r47 = null;
    L182:
        r67 = null;
        goto L183
    L111:
        r40 = null;
    L103:
        th = move-exception;
        Result.Companion r89 = Result.Companion;     // Catch: Throwable -> L114
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        Result.Companion r90 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
    L95:
        r122 = null;
    L86:
        r118 = null;
        goto L87
    L68:
        if (r29.intValue() != 14) goto L70;
        r30 = true;
        goto L71
    L74:
        r28 = null;
    L120:
        r5 = r5;
        r110 = r110;
        r14 = r14;
        r43 = null;
        goto L121
    L58:
        r25 = null;
        goto L59
    L50:
        r111 = null;
    L46:
        r19 = 0;
    L35:
        r12 = 0;
        goto L36
    L24:
        r18 = r6;
        goto L25
    L16:
        r6 = null;
        goto L18
    L10:
        ResultKt.throwOnFailure(r42);
        r1 = this.$params.a;
        AiCreationEditUtils r91 = AiCreationEditUtils.a;
        this.L$0 = r1;
        this.label = 1;
        r3 = AiCreationEditUtils.b(r91, r1, this);
        if (r3 != r14) goto L13;
        return r14;
    }
}
