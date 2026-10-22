package com.larus.bmhome.instruction;

import com.google.gson.Gson;
import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import com.larus.bmhome.instruction.handler.PromptImageToVideoHandler;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements f {
    public final ComponentFeature a;
    public final Gson b;
    public com.larus.bmhome.instruction.handler.l c;
    public com.larus.bmhome.instruction.handler.n d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.f
    public final void onAttach() {
        this.c = new com.larus.bmhome.instruction.handler.l(s1a.a.c(this.a), this);
    }

    public p(InstructionLogicComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.a = r2;
        this.b = new Gson();
    }

    @Override // com.larus.bmhome.instruction.f
    public final void a(com.larus.bmhome.instruction.handler.n r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.d = r2;
    }

    @Override // com.larus.bmhome.instruction.f
    public final void b(n r7) {
        Intrinsics.checkNotNullParameter(r7, "inputData");
        com.larus.bmhome.instruction.handler.l r1 = this.c;
        if (r1 == null) goto L68;
        Intrinsics.checkNotNullParameter(r7, "inputData");
        FLogger r0 = FLogger.a;
        r0.i("ConfigInstructionActionHandler", "InstructionActionData:" + r7);
        aq8.e r2 = r7.b;
        com.larus.bmhome.instruction.handler.m r4 = null;
        if (r2 == null) goto L7;
        String r3 = r2.a;
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r0.e("ConfigInstructionActionHandler", "InstructionActionData inputContent is null, dangerous");
    L16:
        aq8.e r6 = r7.b;
        if (r6 == null) goto L24;
        Map<String, String> r8 = r6.e;
        if (r8 == null) goto L24;
        String r9 = r6.g;
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        r8.put("enter_method_trace", r9);
    L24:
        String r10 = r7.a;
        com.larus.bmhome.instruction.handler.m r11 = (com.larus.bmhome.instruction.handler.m) ((LinkedHashMap) r1.b).get(r10);
        if (r11 == null) goto L28;
    L65:
        if (r11 == null) goto L69;
        r11.a(r7);
        return;
    L69:
        return;
    L28:
        switch(r10.hashCode()) {
            case -1142053025: goto L59;
            case -1053848247: goto L55;
            case 3571588: goto L51;
            case 73725445: goto L47;
            case 81665115: goto L43;
            case 505014344: goto L39;
            case 1368705275: goto L35;
            case 1942336857: goto L31;
            default: goto L62;
        };
    L62:
        if (r4 == null) goto L64;
        boolean r12 = w1.a;
        w1.c("ConfigInstructionActionHandler", "register ".concat(r10));
        r1.b.put(r10, r4);
    L64:
        r11 = r4;
        goto L65
    L31:
        if (r10.equals(InstructionHandlerType.AVATAR) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.a0(r1.a);
        goto L62
    L35:
        if (r10.equals(InstructionHandlerType.IMAGE_TO_IMAGE) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.w(r1.a, (AiBeautifyPickPhotoHelper) r1.c.getValue());
        goto L62
    L39:
        if (r10.equals(InstructionHandlerType.TEXT_TO_OPEN_CAMERA) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.z(r1.a);
        goto L62
    L43:
        if (r10.equals(InstructionHandlerType.VIDEO) == false) goto L62;
        r4 = new PromptImageToVideoHandler(r1.a, (AiBeautifyPickPhotoHelper) r1.d.getValue());
        goto L62
    L47:
        if (r10.equals(InstructionHandlerType.MUSIC) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.c0(r1.a);
        goto L62
    L51:
        if (r10.equals(InstructionHandlerType.SCHEMA_INTERCEPT) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.s(r1.a, (AiBeautifyPickPhotoHelper) r1.c.getValue());
        goto L62
    L55:
        if (r10.equals(InstructionHandlerType.TEXT_TO_IMAGE) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.b0(r1.a);
        goto L62
    L59:
        if (r10.equals(InstructionHandlerType.TEXT_TO_TEXT) == false) goto L62;
        r4 = new com.larus.bmhome.instruction.handler.d0(r1.a);
        goto L62
    L10:
        if (r3.length() == 0) goto L13;
        r5 = false;
        goto L14
    L7:
        r3 = null;
        goto L8
    }

    public static String c(com.larus.bmhome.actionbar.model.z0 r10, String r11, com.larus.bmhome.view.actionbar.edit.b r12) {
        Intrinsics.checkNotNullParameter(r11, "userInput");
        Intrinsics.checkNotNullParameter(r12, "dataFactory");
        com.larus.bmhome.view.actionbar.custom.e r1 = com.larus.bmhome.view.actionbar.custom.e.a;     // Catch: Exception -> L9
        if (r10 == null) goto L6;
        com.larus.bmhome.actionbar.model.r r13 = r10.q;     // Catch: Exception -> L9
    L7:
        return w2.a.a(r1, r11, r13, r12.b(), null, null, 0, null, 120);
    L6:
        r13 = null;
    L9:
        e = move-exception;
        FLogger.a.e("InstructionComponent", "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == true) goto L14;
        return r11;
    L14:
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    }
}
