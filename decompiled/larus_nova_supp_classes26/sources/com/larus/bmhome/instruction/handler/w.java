package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w extends i {
    public final com.larus.bmhome.instruction.p j;
    public final AiBeautifyPickPhotoHelper k;
    public final z0 l;
    public com.larus.bmhome.instruction.n m;
    public final int n;

    public final String f() {
        com.larus.bmhome.instruction.n r0 = this.m;
        if (r0 == null) goto L8;
        aq8.e r1 = r0.b;
        if (r1 == null) goto L8;
        String r2 = r1.a;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r30) {
        Intrinsics.checkNotNullParameter(r30, "inputData");
        this.m = r30;
        String r3 = "";
        if (this.l == null) goto L30;
        AiBeautifyPickPhotoHelper r2 = this.k;
        if (r2 == null) goto L7;
        com.larus.bmhome.instruction.helper.f.a.a(r2, d().requireActivity(), 6);
    L7:
        ChatParam r4 = e().a(ChatParam.class);
        String r5 = null;
        if (r4 != null) goto L19;
        com.larus.bmhome.chat.component.cvs.y r6 = b();
        if (r6 == null) goto L14;
        BotModel r7 = r6.j0();
        if (r7 == null) goto L14;
        String r8 = r7.getBotId();
    L15:
        if (r8 != null) goto L17;
        String r9 = "";
    L18:
        r4 = new ChatParam(null, r9, null, null, null, 253);
        goto L19
    L17:
        r9 = r8;
    L14:
        r8 = null;
    L19:
        String r10 = r4.b;
        String r11 = r4.e;
        aq8.e r1 = r30.b;
        if (r1 == null) goto L22;
        String r12 = r1.g;
    L23:
        if (r1 == null) goto L25;
        String r13 = r1.g;
    L26:
        String r14 = String.valueOf(this.n);
        com.larus.bmhome.actionbar.model.r r15 = this.l.q;
        if (r15 == null) goto L29;
        r5 = r15.g;
    L29:
        tx9.c0.H(r10, r12, r13, null, r11, "chat", null, r14, r5, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return;
    L25:
        r13 = null;
        goto L26
    L22:
        r12 = null;
        goto L23
    L30:
        eq8.a r16 = new eq8.a();
        aq8.e r17 = r30.b;
        if (r17 == null) goto L37;
        String r18 = r17.g;
        if (r18 == null) goto L37;
        r3 = r18;
    L37:
        if (r30.c == false) goto L39;
        String r19 = InstructionHandlerType.IMAGE_TO_IMAGE;
    L40:
        r16.d(r3, r19, f());
        eq8.a.b(r16, "get actionBarItem null", "instructionType:" + this.n);
        return;
    L39:
        r19 = "ALBUM_IMAGE";
        goto L40
    }

    public w(com.larus.bmhome.instruction.p r2, AiBeautifyPickPhotoHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        super(r2);
        this.j = r2;
        this.k = r3;
        this.n = 4;
        if (r3 == null) goto L5;
        r3.b = new t(this);
    L5:
        this.l = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4);
    }
}
