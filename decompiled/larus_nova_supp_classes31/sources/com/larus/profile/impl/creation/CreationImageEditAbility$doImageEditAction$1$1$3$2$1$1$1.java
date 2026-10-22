package com.larus.profile.impl.creation;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility$doImageEditAction$1$1$3$2$1$1$1", f = "CreationImageEditAbility.kt", i = {2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {211, 236, 269, 270, 292}, m = "invokeSuspend", n = {"mainBotId", "attachmentInfo", "targetCvsId", "mainBotId", "attachmentInfo", "targetCvsId", "mainBotId", "sendCvsId", "sendConfig"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class CreationImageEditAbility$doImageEditAction$1$1$3$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ com.larus.bmhome.actionbar.model.r $conf;
    final /* synthetic */ CreationImageEditAbility$doImageEditAction$1.a $hitPointData;
    final /* synthetic */ Map<String, String> $instructionParamMap;
    final /* synthetic */ String $instructionParams;
    final /* synthetic */ com.larus.bmhome.actionbar.model.p1 $msgTemplate;
    final /* synthetic */ com.larus.uaigc.api.q $result;
    final /* synthetic */ String $upScreenText;
    final /* synthetic */ String $uri;
    final /* synthetic */ List<com.larus.bmhome.actionbar.model.u> $userSelectedInstructionItemList;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ CreationImageEditAbility this$0;

    public CreationImageEditAbility$doImageEditAction$1$1$3$2$1$1$1(CreationImageEditAbility r1, Bitmap r2, String r3, com.larus.uaigc.api.q r4, com.larus.bmhome.actionbar.model.p1 r5, String r6, CreationImageEditAbility$doImageEditAction$1.a r7, List<com.larus.bmhome.actionbar.model.u> r8, Map<String, String> r9, com.larus.bmhome.actionbar.model.r r10, String r11, Continuation<? super CreationImageEditAbility$doImageEditAction$1$1$3$2$1$1$1> r12) {
        this.this$0 = r1;
        this.$bitmap = r2;
        this.$uri = r3;
        this.$result = r4;
        this.$msgTemplate = r5;
        this.$upScreenText = r6;
        this.$hitPointData = r7;
        this.$userSelectedInstructionItemList = r8;
        this.$instructionParamMap = r9;
        this.$conf = r10;
        this.$instructionParams = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        return new CreationImageEditAbility$doImageEditAction$1$1$3$2$1$1$1(this.this$0, this.$bitmap, this.$uri, this.$result, this.$msgTemplate, this.$upScreenText, this.$hitPointData, this.$userSelectedInstructionItemList, this.$instructionParamMap, this.$conf, this.$instructionParams, r15);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r58) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        String r11 = "";
        int r16 = 0;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L11;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$2;
        String r2 = (String) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r58);
        int r4 = 3;
        int r15 = 1;
        char r18 = 2;
    L136:
        Pair[] r5 = new Pair[r4];
        r5[0] = TuplesKt.to("argBotId", r3);
        r5[r15] = TuplesKt.to("argBotType", Boxing.boxInt(r15));
        r5[r18] = TuplesKt.to("creation_send_ui_event", new CreationSendUiEvent(r2, null, false, false, true, true, true, false, false, true, true, true, true, r1.getClearInputContent(), true, 398, null));
        Bundle r6 = com.larus.utils.f.c(r5);
        r6.putString("argConversationId", r2);
        CreationImageEditAbility.b(this.this$0, r6);
    L139:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        String r7 = (String) this.L$2;
        AttachmentInfo r9 = (AttachmentInfo) this.L$1;
        r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r58);
        String r13 = r7;
        r15 = 1;
        r18 = 2;
        Object r10 = r58;
    L106:
        wc9.e r12 = (wc9.e) r10;
        if (r12 != null) goto L109;
        r12 = (wc9.e) AuthModelDelegate.b.u().getValue();
    L109:
        if (r12 == null) goto L111;
        String r17 = r12.a;
    L112:
        if (r17 == null) goto L116;
        r11 = r17;
    L116:
        if (r11.length() != 0) goto L118;
        boolean r14 = true;
    L119:
        if (r14 == false) goto L122;
        r11 = r13;
    L122:
        if (r11.length() != 0) goto L124;
        boolean r19 = true;
    L125:
        if (r19 == false) goto L128;
        FLogger.a.e("creationImageEditAbility", "sendCreationMessage cvsId is empty");
        return Unit.INSTANCE;
    L128:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r20 = new CreationSendMessageConfig.a();
        r20.j(r12);
        r20.l(r11);
        r20.f(r3);
        r20.i(this.$upScreenText);
        r20.s("edit");
        r20.u("edit");
        r20.m(this.$hitPointData.getEnterMethod());
        r20.r(this.$hitPointData.b());
        Integer r21 = this.$conf.a;
        if (r21 == null) goto L131;
        int r22 = r21.intValue();
    L132:
        r20.d(Boxing.boxInt(r22));
        r20.c(this.$instructionParamMap);
        r20.e(r9);
        CreationImageEditAbility r23 = this.this$0;
        CreationImageEditAbility$doImageEditAction$1.a r24 = this.$hitPointData;
        r23.getClass();
        Pair[] r25 = new Pair[r15];
        r25[0] = TuplesKt.to("instruction_hit_point_params", ny9.v.a(r24));
        r20.n(new ny9.u(new ny9.s(com.larus.utils.f.c(r25))));
        r20.b("image_edit");
        r1 = r20.a;
        ICreationWorkflowService.Companion r26 = ICreationWorkflowService.a;
        this.L$0 = r3;
        this.L$1 = r11;
        this.L$2 = r1;
        this.label = 5;
        if (r26.W(r1, this) != r8) goto L135;
        return r8;
    L135:
        r2 = r11;
        r4 = 3;
        goto L136
    L131:
        r22 = 0;
        goto L132
    L124:
        r19 = false;
        goto L125
    L118:
        r14 = false;
        goto L119
    L111:
        r17 = null;
        goto L112
    L13:
        String r27 = (String) this.L$2;
        r9 = (AttachmentInfo) this.L$1;
        r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r58);
        r13 = r27;
        r15 = 1;
        r18 = 2;
        Object r28 = r58;
    L101:
        r12 = (wc9.e) r28;
        if (r12 != null) goto L109;
        RepoDispatcher.a.getClass();
        ConversationRepo r29 = RepoDispatcher.f;
        this.L$0 = r3;
        this.L$1 = r9;
        this.L$2 = r13;
        this.label = 4;
        r10 = r29.f(this);
        if (r10 != r8) goto L106;
        return r8;
    L14:
        int r110 = this.I$0;
        String r30 = (String) this.L$3;
        Pair[] r31 = (Pair[]) this.L$2;
        com.bytedance.router.i r32 = (com.bytedance.router.i) this.L$1;
        Pair[] r33 = (Pair[]) this.L$0;
        ResultKt.throwOnFailure(r58);
        String r111 = r30;
        boolean r112 = true;
        Object r34 = r58;
    L72:
        r31[r110] = TuplesKt.to(r111, r34);
        r33[5] = TuplesKt.to("open_new_chat_page", Boxing.boxBoolean(r112));
        r32.c.putExtras(com.larus.utils.f.c(r33));
        r32.d = 2130772343;
        r32.e = 2130772399;
        r32.d();
        goto L139
    L15:
        ResultKt.throwOnFailure(r58);
        Object r35 = r58;
    L19:
        File r36 = (File) r35;
        String r37 = this.this$0.c.a;
        String r113 = this.$uri;
        com.larus.uaigc.api.q r114 = this.$result;
        if (r114 == null) goto L28;
        com.larus.uaigc.api.p r115 = r114.b();
        if (r115 == null) goto L28;
        com.larus.uaigc.api.n r116 = r115.a();
        if (r116 == null) goto L28;
        com.larus.uaigc.api.m r117 = r116.a();
        if (r117 == null) goto L28;
        Long r118 = r117.a();
    L29:
        com.larus.uaigc.api.q r119 = this.$result;
        if (r119 == null) goto L38;
        com.larus.uaigc.api.p r120 = r119.b();
        if (r120 == null) goto L38;
        com.larus.uaigc.api.n r121 = r120.a();
        if (r121 == null) goto L38;
        com.larus.uaigc.api.m r122 = r121.a();
        if (r122 == null) goto L38;
        Long r123 = r122.b();
    L39:
        MediaAttachment r38 = new MediaAttachment(r37, r113, new ImageUploadInfo(r123, r118), null, com.larus.utils.y0.k(Uri.fromFile(r36)), null, null, null, null, null, null, null, 4072, null);
        AuthModelDelegate r39 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r40 = (com.larus.bmhome.chat.api.e0) r39.e().getValue();
        if (r40 == null) goto L45;
        LaunchInfo r41 = r40.a;
        if (r41 == null) goto L45;
        String r42 = r41.W();
        if (r42 == null) goto L45;
    L47:
        if (com.larus.utils.o0.d(this.$msgTemplate.g) == false) goto L73;
        com.bytedance.router.i r43 = SmartRouter.buildRoute(this.this$0.a, this.$msgTemplate.g);
        Pair[] r124 = new Pair[6];
        r124[0] = TuplesKt.to("actionbar_instruction_prompt", this.$upScreenText);
        r124[1] = TuplesKt.to("media_attachment", r38);
        r124[2] = TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(this.$hitPointData))}));
        Iterator<T> r44 = this.$userSelectedInstructionItemList.iterator();
    L50:
        if (r44.hasNext() == false) goto L60;
        Object r45 = r44.next();
        Integer r46 = ((com.larus.bmhome.actionbar.model.u) r45).b;
        if (r46 != null) goto L55;
    L57:
        boolean r47 = false;
    L58:
        if (r47 == false) goto L50;
    L61:
        com.larus.bmhome.actionbar.model.u r48 = (com.larus.bmhome.actionbar.model.u) r45;
        if (r48 == null) goto L64;
        String r125 = r48.d;
    L65:
        r124[3] = TuplesKt.to("actionbar_instruction_default_params", r125);
        CreationImageEditAbility r49 = this.this$0;
        String r50 = this.$upScreenText;
        Map<String, String> r51 = this.$instructionParamMap;
        Integer r52 = this.$conf.a;
        if (r52 == null) goto L68;
        r16 = r52.intValue();
    L68:
        CreationImageEditAbility$doImageEditAction$1.a r126 = this.$hitPointData;
        this.L$0 = r124;
        this.L$1 = r43;
        this.L$2 = r124;
        r111 = "creation_send_message_config";
        this.L$3 = "creation_send_message_config";
        this.I$0 = 4;
        this.label = 2;
        r112 = true;
        r34 = CreationImageEditAbility.a(r49, r42, r50, r51, r16, r126, this);
        if (r34 != r8) goto L71;
        return r8;
    L71:
        r32 = r43;
        r31 = r124;
        r33 = r31;
        r110 = 4;
        goto L72
    L64:
        r125 = null;
        goto L65
    L55:
        if (r46.intValue() != 8) goto L57;
        r47 = true;
        goto L58
    L60:
        r45 = null;
        goto L61
    L73:
        r15 = 1;
        com.larus.bmhome.chat.api.e0 r53 = (com.larus.bmhome.chat.api.e0) r39.e().getValue();
        if (r53 == null) goto L81;
        LaunchInfo r54 = r53.a;
        if (r54 == null) goto L81;
        String r55 = r54.W();
        if (r55 == null) goto L81;
        String r127 = r55;
    L82:
        Bundle r56 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r127), TuplesKt.to("argBotType", Boxing.boxInt(1)), TuplesKt.to("actionbar_instruction_template", this.$instructionParams)});
        String r57 = this.$uri;
        if (r57 != null) goto L85;
        String r310 = "";
    L86:
        fs9.g r59 = this.this$0.c;
        int r60 = (int) r59.c;
        int r61 = (int) r59.b;
        AttachmentInfo r62 = new AttachmentInfo(true, r310, Boxing.boxInt(r60), Boxing.boxInt(r61), "", "", "edit", null, null, null, null, r59.a, null, null, null, null, null, 128896, null);
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L137;
        com.larus.bmhome.chat.api.e0 r63 = (com.larus.bmhome.chat.api.e0) r39.e().getValue();
        if (r63 == null) goto L93;
        LaunchInfo r64 = r63.a;
        if (r64 == null) goto L93;
        String r65 = r64.Y();
    L94:
        if (r65 != null) goto L96;
        r13 = "";
    L97:
        RepoDispatcher.a.getClass();
        ConversationRepo r66 = RepoDispatcher.f;
        this.L$0 = r127;
        this.L$1 = r62;
        this.L$2 = r13;
        this.label = 3;
        r18 = 2;
        r28 = IConversationRepoService.a.c(r66, r13, false, null, this, 6);
        if (r28 != r8) goto L100;
        return r8;
    L100:
        r3 = r127;
        r9 = r62;
        goto L101
    L96:
        r13 = r65;
    L93:
        r65 = null;
        goto L94
    L137:
        CreationImageEditAbility r67 = this.this$0;
        Bundle r68 = new Bundle(r56);
        r68.putAll(com.larus.utils.f.c(new Pair[]{TuplesKt.to("actionbar_instruction_prompt", this.$upScreenText), TuplesKt.to("actionbar_instruction_type", Boxing.boxInt(16)), TuplesKt.to("actionbar_creation_type", "image_edit"), TuplesKt.to("actionbar_remote_image", r62), TuplesKt.to("instruction_hit_point_params", com.larus.utils.f.c(new Pair[]{TuplesKt.to("instruction_hit_point_params", ny9.v.a(this.$hitPointData))}))}));
        CreationImageEditAbility.b(r67, r68);
        goto L139
    L85:
        r310 = r57;
    L81:
        r127 = "7234781073513644036";
    L45:
        r42 = "7234781073513644036";
    L38:
        r123 = null;
    L28:
        r118 = null;
        goto L29
    L16:
        ResultKt.throwOnFailure(r58);
        IUgcAIGCService.Companion r69 = IUgcAIGCService.a;
        Context r70 = this.this$0.a;
        Bitmap r71 = this.$bitmap;
        this.label = 1;
        r35 = r69.m(r70, r71, "image_selector_default_image.jpeg", this);
        if (r35 != r8) goto L19;
        return r8;
    }
}
