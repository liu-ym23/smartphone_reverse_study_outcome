package com.larus.bmhome.instruction.handler;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.m1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.instruction.c2;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.uaigc.service.ICreationWorkflowService;
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
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.handler.PromptImageToVideoHandler$toVideoGenerateByImage$1", f = "PromptImageToVideoHandler.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class PromptImageToVideoHandler$toVideoGenerateByImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Image $image;
    final /* synthetic */ com.larus.bmhome.actionbar.model.r $instructionConf;
    int label;
    final /* synthetic */ PromptImageToVideoHandler this$0;

    public PromptImageToVideoHandler$toVideoGenerateByImage$1(PromptImageToVideoHandler r1, com.larus.bmhome.actionbar.model.r r2, Image r3, String r4, Continuation<? super PromptImageToVideoHandler$toVideoGenerateByImage$1> r5) {
        this.this$0 = r1;
        this.$instructionConf = r2;
        this.$image = r3;
        this.$conversationId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PromptImageToVideoHandler$toVideoGenerateByImage$1(this.this$0, this.$instructionConf, this.$image, this.$conversationId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r48) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r48);
        Object r3 = r48;
    L11:
        com.larus.bmhome.view.actionbar.edit.b r1 = IInstructionService.a.a(IInstructionService.a, this.$instructionConf, new com.larus.bmhome.view.actionbar.edit.d((Map) r3), null, null, 12);
        c2 r5 = c2.a;
        final com.larus.bmhome.actionbar.model.r r6 = com.larus.bmhome.instruction.j.a.a(Boxing.boxInt(this.this$0.n), this.this$0.f(), r1, this.$instructionConf);
        com.larus.bmhome.instruction.n r7 = this.this$0.m;
        if (r7 == null) goto L17;
        aq8.e r8 = r7.b;
        if (r8 == null) goto L17;
        final Map<String, String> r9 = r8.e;
        if (r9 == null) goto L17;
    L18:
        PromptImageToVideoHandler r10 = this.this$0;
        com.larus.bmhome.instruction.p r11 = r10.j;
        z0 r12 = r10.l;
        String r13 = r10.f();
        r11.getClass();
        final String r15 = com.larus.bmhome.instruction.p.c(r12, r13, r1);
        String r14 = this.$image.key;
        if (r14 != null) goto L21;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L52;
        ICreationWorkflowService.Companion r17 = ICreationWorkflowService.a;
        Fragment r18 = this.this$0.d();
        String r19 = this.$image.localResPath;
        String r20 = this.$conversationId;
        if (r6 == null) goto L29;
        String r110 = HttpExtKt.p(r6);
    L30:
        Bundle r21 = new Bundle();
        PromptImageToVideoHandler r22 = this.this$0;
        com.larus.bmhome.instruction.n r111 = r22.m;
        if (r111 == null) goto L35;
        aq8.e r112 = r111.b;
        if (r112 == null) goto L35;
        String r113 = r112.g;
    L36:
        r21.putString("enter_method", r113);
        com.larus.bmhome.instruction.n r114 = r22.m;
        if (r114 == null) goto L41;
        aq8.e r115 = r114.b;
        if (r115 == null) goto L41;
        String r116 = r115.h;
    L42:
        r21.putString("click_from", r116);
        r21.putString("action_bar_template_id", String.valueOf(r22.n));
        z0 r23 = r22.l;
        if (r23 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r24 = r23.q;
        if (r24 == null) goto L47;
        String r25 = r24.g;
    L48:
        r21.putString("action_bar_template_type", r25);
        Unit r26 = Unit.INSTANCE;
        ny9.u r117 = new ny9.u(new ny9.s(r21));
        com.larus.bmhome.chat.component.cvs.y r27 = this.this$0.b();
        if (r27 == null) goto L51;
        r4 = r27.getBotId();
    L51:
        hy9.f r28 = new hy9.f(r18, r19, r20, r15, r110, r117, r9, r4, (u7) this.this$0.c.getValue(), (IChatDoubleTabAbility) this.this$0.d.getValue(), this.this$0.c(), null, null, 61440);
        final PromptImageToVideoHandler r29 = this.this$0;
        ICreationWorkflowService.a.a(r17, r28, r29.n, false, new y(r29, r9, r6, r15), 4);
    L159:
        return Unit.INSTANCE;
    L47:
        r25 = null;
    L41:
        r116 = null;
    L35:
        r113 = null;
        goto L36
    L29:
        r110 = null;
        goto L30
    L52:
        PromptImageToVideoHandler r118 = this.this$0;
        Image r30 = this.$image;
        r118.getClass();
        String r31 = r30.key;
        if (r31 != null) goto L55;
        r31 = "";
    L55:
        FLogger.a.i("PromptImageToVideoHandler", "ai beautify upload image success, tosKey = ".concat(r31));
        ImageObj r32 = r30.imageOri;
        if (r32 == null) goto L58;
        Integer r119 = Integer.valueOf(r32.height);
    L59:
        ImageObj r33 = r30.imageOri;
        if (r33 == null) goto L62;
        Integer r210 = Integer.valueOf(r33.width);
    L63:
        String r34 = r30.localResPath;
        if (r34 == null) goto L159;
        com.larus.bmhome.instruction.n r35 = r118.m;
        if (r35 == null) goto L74;
        aq8.e r36 = r35.b;
        if (r36 == null) goto L74;
        String r37 = r36.i;
        if (r37 == null) goto L74;
        String r211 = r37;
    L75:
        AttachmentInfo r46 = new AttachmentInfo(true, r31, r119, r210, r34, null, r211, null, null, null, null, null, null, null, null, null, null, 130944, null);
        z0 r38 = r118.l;
        if (r38 == null) goto L95;
        com.larus.bmhome.actionbar.model.r r39 = r38.q;
        if (r39 == null) goto L95;
        List r40 = r39.b;
        if (r40 == null) goto L95;
        Iterator r41 = r40.iterator();
    L83:
        if (r41.hasNext() == false) goto L93;
        Object r42 = r41.next();
        Integer r120 = ((com.larus.bmhome.actionbar.model.u) r42).b;
        if (r120 != null) goto L88;
    L90:
        boolean r121 = false;
    L91:
        if (r121 == false) goto L83;
    L94:
        com.larus.bmhome.actionbar.model.u r43 = (com.larus.bmhome.actionbar.model.u) r42;
    L96:
        if (r43 != null) goto L162;
        PromptImageToVideoHandler r310 = r118;
    L130:
        c2 r44 = c2.a;
        PromptImageToVideoHandler r45 = r310;
        z0 r47 = r45.l;
        if (r47 == null) goto L136;
        String r49 = r47.b;
        if (r49 == null) goto L136;
        String r50 = r49;
    L137:
        String r51 = String.valueOf(r45.n);
        if (r6 == null) goto L140;
        String r52 = HttpExtKt.p(r6);
    L141:
        Map r122 = com.larus.bmhome.instruction.j.a.c(r44, r50, r51, r52, o0.d(r45.f()), r9, null, 32);
        ICoreInputAbility r53 = r45.c();
        if (r53 == null) goto L151;
        int r54 = r45.n;
        com.larus.bmhome.instruction.n r55 = r45.m;
        if (r55 == null) goto L149;
        aq8.e r56 = r55.b;
        if (r56 == null) goto L149;
        String r57 = r56.h;
        if (r57 == null) goto L149;
    L150:
        boolean r58 = false;
        r53.E0(new ICoreInputAbility.OnSendParams(r15, "", r46, null, null, r122, null, null, r54, false, "", false, false, false, null, null, null, null, false, null, null, null, r57, null, null, null, null, null, null, r45.e().a(ChatPageContext.class), null, null, null, -541329216, 1, null));
    L152:
        g1 r59 = (g1) r45.i.getValue();
        if (r59 == null) goto L155;
        r59.W0();
    L155:
        ICoreInputAbility r60 = r45.c();
        if (r60 == null) goto L159;
        r60.C1(r58, r58, "");
    L149:
        r57 = "album";
        goto L150
    L151:
        r58 = false;
        goto L152
    L140:
        r52 = null;
    L136:
        r50 = "";
        goto L137
    L162:
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L114
        ouc.v r62 = xt7.d.b;     // Catch: Throwable -> L114
        m1.b r63 = m1.Companion;     // Catch: Throwable -> L114
        juc.c r123 = r63.serializer();     // Catch: Throwable -> L114
        String r124 = r43.d;     // Catch: Throwable -> L114
        if (r124 != null) goto L100;
        r124 = "";
    L100:
        m1 r125 = (m1) r62.c(r123, r124);     // Catch: Throwable -> L114
        ImageObj r64 = r30.imageOri;     // Catch: Throwable -> L114
        if (r64 == null) goto L105;
        r310 = r118;
        Long r65 = Long.valueOf(r64.width);     // Catch: Throwable -> L112
    L106:
        ImageObj r66 = r30.imageOri;     // Catch: Throwable -> L112
        if (r66 == null) goto L109;
        Long r67 = Long.valueOf(r66.height);     // Catch: Throwable -> L112
    L110:
        r125.d = new MediaAttachment(null, r31, new ImageUploadInfo(r65, r67), null, null, null, null, null, null, null, null, null, 4089, null);     // Catch: Throwable -> L112
        Object r68 = Result.constructor-impl(r62.a(r63.serializer(), r125));     // Catch: Throwable -> L112
    L118:
        if (Result.isFailure-impl(r68) == false) goto L120;
        r68 = null;
    L120:
        com.larus.bmhome.actionbar.model.u r69 = com.larus.bmhome.actionbar.model.u.a(r43, (String) r68, 247);
        if (r6 == null) goto L130;
        List r70 = r6.b;
        if (r70 == null) goto L127;
        List r71 = CollectionsKt.toMutableList(r70);
        if (r71 == null) goto L127;
        r71.add(r69);
    L128:
        r6.b = r71;
    L127:
        r71 = null;
        goto L128
    L109:
        r67 = null;
    L112:
        th = th;
    L116:
        Result.Companion r72 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L118
    L105:
        r310 = r118;
        r65 = null;
    L114:
        th = th;
        r310 = r118;
        goto L116
    L88:
        if (r120.intValue() != 14) goto L90;
        r121 = true;
        goto L91
    L93:
        r42 = null;
    L95:
        r43 = null;
    L74:
        r211 = "";
        goto L75
    L62:
        r210 = null;
        goto L63
    L58:
        r119 = null;
        goto L59
    L21:
        if (r14.length() == 0) goto L24;
        r16 = false;
    L17:
        r9 = MapsKt.emptyMap();
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r48);
        PromptImageToVideoHandler r73 = this.this$0;
        com.larus.bmhome.actionbar.model.r r74 = this.$instructionConf;
        Image r75 = this.$image;
        this.label = 1;
        r73.getClass();
        r3 = BuildersKt.withContext(Dispatchers.getIO(), new PromptImageToVideoHandler$getInstructionDefaultParams$2(r74, r75, null), this);
        if (r3 != r0) goto L11;
        return r0;
    }
}
