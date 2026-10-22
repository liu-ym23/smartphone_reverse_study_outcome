package com.larus.bmhome.instruction.handler;

import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.c2;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.instruction.service.IInstructionService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 extends i {
    public final com.larus.bmhome.instruction.p j;

    public a0(com.larus.bmhome.instruction.p r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
        this.j = r2;
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r53) {
        Intrinsics.checkNotNullParameter(r53, "inputData");
        z0 r2 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(11);
        if (r2 != null) goto L14;
        eq8.a r5 = new eq8.a();
        aq8.e r6 = r53.b;
        if (r6 == null) goto L8;
        String r7 = r6.g;
        if (r7 == null) goto L8;
    L9:
        if (r6 == null) goto L12;
        String r8 = r6.a;
        if (r8 == null) goto L12;
    L13:
        r5.d(r7, InstructionHandlerType.AVATAR, r8);
        eq8.a.b(r5, "get actionBarItem null", "instructionType:11");
    L12:
        r8 = "";
    L8:
        r7 = "";
    L14:
        if (r2 == null) goto L21;
        Integer r9 = r2.g;
        int r10 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r9 == null) goto L21;
        if (r9.intValue() != r10) goto L21;
        boolean r11 = true;
    L22:
        Object r12 = null;
        String r13 = null;
        if (r11 == false) goto L40;
        com.bytedance.router.i r3 = SmartRouter.buildRoute(this.j.a.getContext(), "//flow/create_digital_avatar");
        com.larus.bmhome.chat.component.cvs.y r4 = b();
        if (r4 == null) goto L29;
        wc9.e r14 = r4.h();
        if (r14 == null) goto L29;
        String r15 = r14.a;
    L30:
        r3.c.putExtra("argConversationId", r15);
        aq8.e r16 = r53.b;
        if (r16 == null) goto L33;
        String r17 = r16.a;
    L34:
        r3.c.putExtra("actionbar_instruction_prompt", r17);
        aq8.e r0 = r53.b;
        if (r0 == null) goto L37;
        r13 = r0.g;
    L37:
        r3.c.putExtra("enter_method", r13);
        r3.c.addFlags(268435456);
        r3.d();
        return;
    L33:
        r17 = null;
    L29:
        r15 = null;
        goto L30
    L40:
        if (r53.c == false) goto L77;
        com.larus.bmhome.instruction.p r18 = this.j;
        aq8.e r1 = r53.b;
        if (r1 == null) goto L45;
        String r19 = r1.a;
        if (r19 == null) goto L45;
    L46:
        if (r1 == null) goto L48;
        Map<String, String> r110 = r1.e;
    L49:
        if (r1 == null) goto L51;
        String r38 = r1.h;
    L52:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "prompt");
        if (r2 == null) goto L78;
        com.larus.bmhome.actionbar.model.r r20 = r2.q;
        if (r20 == null) goto L79;
        com.larus.bmhome.view.actionbar.edit.b r21 = IInstructionService.a.a(IInstructionService.a, r20, null, null, null, 12);
        Gson r22 = r18.b;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L60
        c2 r112 = c2.a;     // Catch: Throwable -> L60
        Object r23 = Result.constructor-impl(r22.toJson(com.larus.bmhome.instruction.j.a.a(11, r19, r21, r20)));     // Catch: Throwable -> L60
    L63:
        if (Result.isFailure-impl(r23) == true) goto L66;
        r12 = r23;
    L66:
        String r113 = (String) r12;
        c2 r24 = c2.a;
        String r25 = r2.b;
        if (r25 != null) goto L69;
        String r114 = "";
    L70:
        ICoreInputAbility.OnSendParams r26 = new ICoreInputAbility.OnSendParams(com.larus.bmhome.instruction.p.c(r2, r19, r21), "", null, null, null, com.larus.bmhome.instruction.j.a.c(r24, r114, String.valueOf(11), r113, o0.d(r19), r110, null, 32), null, null, 11, false, "", false, false, false, null, null, null, null, false, null, MapsKt.mapOf(TuplesKt.to("original_content_source", "use_template")), null, r38, null, null, null, null, null, null, s1a.d.a(r18.a).a(ChatPageContext.class), null, null, null, -542392128, 1, null);
        n r27 = r18.d;
        if (r27 == null) goto L73;
        r27.E0(r26);
    L73:
        FLogger.a.i("InstructionCoreHandler", "sendMessageWithNoInput prompt:".concat(r19));
        return;
    L69:
        r114 = r25;
    L60:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    L79:
        return;
    L78:
        return;
    L51:
        r38 = null;
        goto L52
    L48:
        r110 = null;
    L45:
        r19 = "";
        goto L46
    L77:
        return;
    L21:
        r11 = false;
        goto L22
    }
}
