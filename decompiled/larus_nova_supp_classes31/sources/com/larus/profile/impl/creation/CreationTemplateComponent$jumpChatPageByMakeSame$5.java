package com.larus.profile.impl.creation;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationTemplateComponent$jumpChatPageByMakeSame$5", f = "CreationTemplateComponent.kt", i = {1}, l = {327, 334}, m = "invokeSuspend", n = {"sendConfig"}, s = {"L$0"})
final class CreationTemplateComponent$jumpChatPageByMakeSame$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileLocalPath;
    final /* synthetic */ w1 $hitPointData;
    final /* synthetic */ String $instructionDefaultParams;
    final /* synthetic */ String $mainBotId;
    final /* synthetic */ String $prompt;
    final /* synthetic */ UserCreation $userCreation;
    Object L$0;
    int label;
    final /* synthetic */ u1 this$0;

    public CreationTemplateComponent$jumpChatPageByMakeSame$5(u1 r1, String r2, String r3, String r4, w1 r5, String r6, UserCreation r7, Continuation<? super CreationTemplateComponent$jumpChatPageByMakeSame$5> r8) {
        this.this$0 = r1;
        this.$prompt = r2;
        this.$fileLocalPath = r3;
        this.$instructionDefaultParams = r4;
        this.$hitPointData = r5;
        this.$mainBotId = r6;
        this.$userCreation = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CreationTemplateComponent$jumpChatPageByMakeSame$5(this.this$0, this.$prompt, this.$fileLocalPath, this.$instructionDefaultParams, this.$hitPointData, this.$mainBotId, this.$userCreation, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r51) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        CreationSendMessageConfig r1 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r51);
    L110:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(this.this$0.a, "//flow/chat_page");
        Pair[] r3 = new Pair[4];
        r3[0] = TuplesKt.to("argBotId", this.$mainBotId);
        r3[1] = TuplesKt.to("argBotType", Boxing.boxInt(1));
        gs9.b r4 = this.this$0.g;
        if (r4 == null) goto L114;
        String r5 = r4.a;
        if (r5 == null) goto L114;
    L115:
        r3[2] = TuplesKt.to("argPreviousPage", r5);
        this.this$0.getClass();
        String r14 = r1.getCvsId();
        boolean r27 = r1.getClearInputContent();
        if (r1.getAttachmentInfo() == null) goto L118;
    L121:
        boolean r28 = true;
    L122:
        r3[3] = TuplesKt.to("creation_send_ui_event", new CreationSendUiEvent(r14, null, false, false, true, true, true, false, false, true, true, true, true, r27, r28, 398, null));
        r2.c.putExtras(com.larus.utils.f.c(r3));
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
        return Unit.INSTANCE;
    L118:
        if (r1.getImageEditDataWithMask() != null) goto L121;
        r28 = false;
    L114:
        r5 = "creation_detail";
        goto L115
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r51);
        Object r6 = r51;
    L107:
        r1 = (CreationSendMessageConfig) r6;
        ICreationWorkflowService.Companion r7 = ICreationWorkflowService.a;
        this.L$0 = r1;
        this.label = 2;
        if (r7.W(r1, this) != r9) goto L110;
        return r9;
    L10:
        ResultKt.throwOnFailure(r51);
        u1 r8 = this.this$0;
        String r10 = this.$prompt;
        String r11 = this.$fileLocalPath;
        String r12 = this.$instructionDefaultParams;
        w1 r13 = this.$hitPointData;
        String r15 = this.$mainBotId;
        int r16 = u1.h;
        r8.getClass();
        String r17 = "";
        if (r10 != null) goto L13;
        String r18 = "";
    L14:
        if (r11 != null) goto L16;
    L19:
        boolean r19 = true;
    L20:
        String r20 = null;
        if (r19 == false) goto L23;
        AttachmentInfo r110 = null;
    L53:
        com.larus.bmhome.instruction.c2 r111 = com.larus.bmhome.instruction.c2.a;
        if (r12 != null) goto L56;
    L59:
        boolean r21 = true;
    L60:
        if (r21 == true) goto L104;
        List r22 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r15);
        if (r22 == null) goto L82;
        Iterator r23 = r22.iterator();
    L66:
        if (r23.hasNext() == false) goto L78;
        Object r24 = r23.next();
        com.larus.bmhome.actionbar.model.r r25 = ((com.larus.bmhome.actionbar.model.z0) r24).q;
        if (r25 == null) goto L75;
        Integer r26 = r25.a;
        if (r26 == null) goto L75;
        if (r26.intValue() != 16) goto L75;
        boolean r29 = true;
    L76:
        if (r29 == false) goto L66;
    L79:
        com.larus.bmhome.actionbar.model.z0 r30 = (com.larus.bmhome.actionbar.model.z0) r24;
        if (r30 == null) goto L82;
        com.larus.bmhome.actionbar.model.r r31 = r30.q;
    L83:
        if (r31 == null) goto L102;
        List r32 = r31.b;
        if (r32 == null) goto L102;
        Iterator r33 = r32.iterator();
    L88:
        if (r33.hasNext() == false) goto L98;
        Object r34 = r33.next();
        Integer r35 = ((com.larus.bmhome.actionbar.model.u) r34).b;
        if (r35 != null) goto L93;
    L95:
        boolean r36 = false;
    L96:
        if (r36 == false) goto L88;
    L99:
        com.larus.bmhome.actionbar.model.u r37 = (com.larus.bmhome.actionbar.model.u) r34;
        if (r37 == null) goto L102;
        r37.d = r12;
        goto L102
    L93:
        if (r35.intValue() != 8) goto L95;
        r36 = true;
        goto L96
    L98:
        r34 = null;
    L102:
        if (r31 == null) goto L104;
        r20 = HttpExtKt.p(r31);
    L75:
        r29 = false;
        goto L76
    L78:
        r24 = null;
    L82:
        r31 = null;
    L104:
        Map r112 = r111.b("coco_instruction", "16", r20, false, null, null);
        r13.getClass();
        ICoreInputAbility.OnSendParams r38 = new ICoreInputAbility.OnSendParams(r18, "", r110, null, null, r112, null, null, 16, false, "", false, false, false, null, null, null, null, false, "use_template", null, null, "edit", "edit", "creation_detail", null, null, null, null, null, null, null, null, -30148416, 1, null);
        u1 r39 = this.this$0;
        UserCreation r40 = this.$userCreation;
        w1 r41 = this.$hitPointData;
        String r42 = this.$mainBotId;
        this.label = 1;
        r6 = u1.a(r39, r38, r40, r41, r42, "image_edit", this);
        if (r6 != r9) goto L107;
        return r9;
    L56:
        if (r12.length() == 0) goto L59;
        r21 = false;
        goto L60
    L23:
        Uri r43 = UriProtector.parse(r11);
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L26
        Object r45 = Result.constructor-impl(vqc.d.d(AppHost.a.getApplication(), r43));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r45) == false) goto L31;
        r45 = null;
    L31:
        String r46 = (String) r45;
        if (r46 != null) goto L35;
        r46 = "";
    L35:
        if (r46.length() != 0) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == false) goto L51;
        String r47 = r43.getPath();
        if (r47 == null) goto L44;
        r17 = r47;
    L44:
        if (r17.length() != 0) goto L46;
        boolean r48 = true;
    L47:
        if (r48 == true) goto L50;
        r11 = r17;
    L50:
        String r210 = r11;
    L52:
        r110 = new AttachmentInfo(true, "", null, null, r210, null, "edit", null, null, null, null, null, null, null, null, null, null, 130956, null);
        goto L53
    L46:
        r48 = false;
        goto L47
    L51:
        r210 = r46;
        goto L52
    L37:
        r113 = false;
    L26:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L16:
        if (r11.length() == 0) goto L19;
        r19 = false;
        goto L20
    L13:
        r18 = r10;
        goto L14
    }
}
