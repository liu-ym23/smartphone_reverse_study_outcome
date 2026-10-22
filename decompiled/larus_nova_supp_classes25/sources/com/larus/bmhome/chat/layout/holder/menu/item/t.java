package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public static com.larus.bmhome.view.screenmenu.l0 a(Message r48, com.larus.bmhome.chat.api.q0.a r49) {
        Intrinsics.checkNotNullParameter(r48, "data");
        if (r49 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r2 = r49.u0();
        if (r2 == null) goto L7;
        BotModel r3 = r2.j0();
    L8:
        z2 r4 = z2.a;
        boolean r5 = true;
        if (r4.exportFileConfig().getEnableMenuExportFile() == false) goto L25;
        String r1 = r48.getConversationId();
        if (r1 == null) goto L16;
        Lazy r6 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (com.larus.im.j.f(r1) != true) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L25;
        List r8 = CollectionsKt.listOf(new Integer[]{-30, -20, -10});
        if (r3 == null) goto L22;
        Integer r9 = r3.getBotStatus();
    L24:
        if (CollectionsKt.contains(r8, r9) == true) goto L25;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L57;
        int r11 = MenuActionType.EXPORT_FILE.getType();
        AppHost.Companion r12 = AppHost.a;
        if (r12.isOversea() == false) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r13 == false) goto L45;
        Integer r14 = Integer.valueOf(r12.getApplication().getResources().getIdentifier("larus_export_as_AIdocument_cn", "string", r12.getApplication().getPackageName()));
        if (r14.intValue() == 0) goto L38;
        boolean r15 = true;
    L39:
        if (r15 == true) goto L42;
        r14 = null;
    L42:
        if (r14 == null) goto L44;
        int r16 = r14.intValue();
    L47:
        if (r12.isOversea() == false) goto L49;
    L51:
        r5 = false;
    L52:
        if (r5 == false) goto L54;
        int r0 = v19.c.b(2130971703, null, 2131241207);
    L56:
        return new com.larus.bmhome.view.screenmenu.l0(r11, r16, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(r0), null, false, false, null, null, "export_files", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127);
    L54:
        r0 = v19.c.b(2130971817, null, 2131241940);
        goto L56
    L49:
        if (r4.exportFileConfig().getEnableMenuExportToDoc() == false) goto L51;
    L44:
        r16 = 2131899580;
        goto L47
    L38:
        r15 = false;
        goto L39
    L45:
        r16 = 2131905586;
        goto L47
    L31:
        if (r4.exportFileConfig().getEnableMenuExportToDoc() == false) goto L33;
        r13 = true;
        goto L34
    L57:
        return null;
    L22:
        r9 = null;
    L16:
        r7 = false;
    L25:
        r10 = false;
    L7:
        r3 = null;
        goto L8
    }
}
