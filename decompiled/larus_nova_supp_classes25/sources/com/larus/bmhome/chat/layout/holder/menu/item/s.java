package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.IChatAzerothService;
import com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends a {
    public s() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.EXPORT_FILE.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r26, View r27, ef8.b r28) {
        Intrinsics.checkNotNullParameter(r26, "item");
        Intrinsics.checkNotNullParameter(r27, "view");
        Intrinsics.checkNotNullParameter(r28, "menuContext");
        if (AppHost.a.isOversea() == false) goto L5;
    L18:
        FLogger.a.d("ExportFileMenuHandler", "export message, id = " + r28.a.getMessageId());
        String r2 = r28.a.getConversationId();
        List r10 = CollectionsKt.listOf(new com.larus.bmhome.chat.component.share.v0(r28.a.getMessageId(), Integer.valueOf(r28.a.getContentType())));
        String r4 = UUID.randomUUID().toString();
        int r7 = FileExportTypeChooseDialog.w;
        if (r2 != null) goto L21;
        String r9 = "";
    L22:
        BotModel r3 = r28.a();
        if (r3 == null) goto L25;
        String r5 = r3.getName();
    L26:
        if (r5 != null) goto L28;
        String r12 = "";
    L29:
        BotModel r6 = r28.a();
        if (r6 == null) goto L32;
        String r8 = r6.getBotId();
    L33:
        if (r8 != null) goto L35;
        String r13 = "";
    L36:
        long r15 = r28.b();
        Map r11 = r28.a.getExt();
        if (r11 == null) goto L39;
        String r14 = (String) r11.get("deep_research_id");
    L40:
        if (r14 != null) goto L42;
        String r18 = "";
    L43:
        IChatAzerothService r16 = com.larus.bmhome.x.a();
        boolean r17 = false;
        if (r16 != null) goto L46;
    L48:
        boolean r21 = false;
    L49:
        FileExportTypeChooseDialog r19 = FileExportTypeChooseDialog.a.b(r9, r10, null, r12, r13, r4, r15, null, r18, null, null, r21, null, null, 13956);
        Intrinsics.checkNotNullParameter(r27, "<this>");     // Catch: IllegalStateException -> L52
        FragmentManager r0 = FragmentManager.findFragment(r27).getChildFragmentManager();     // Catch: IllegalStateException -> L52
    L53:
        if (r0 == null) goto L55;
        int r20 = FileExportTypeChooseDialog.w;
        FileExportTypeChooseDialog.a.c(r19, r0);
    L55:
        ef8.a r1 = r28.i;
        if (r1 != null) goto L58;
    L60:
        if (r17 == false) goto L62;
        String r22 = "long_press_answer_more";
    L63:
        String r110 = r22;
        ChatControlTrace r111 = ChatControlTrace.b;
        String r23 = r28.a.getMessageId();
        if (r23 != null) goto L66;
        String r112 = "";
    L67:
        r111.La(r110, r112, r4, r28.b());
        return true;
    L66:
        r112 = r23;
        goto L67
    L62:
        r22 = "long_press_answer";
        goto L63
    L58:
        if (r1.a(r26.getId()) != true) goto L60;
        r17 = true;
    L52:
        r0 = null;
        goto L53
    L46:
        if (r16.a(r28.a) != true) goto L48;
        r21 = true;
        goto L49
    L42:
        r18 = r14;
        goto L43
    L39:
        r14 = null;
        goto L40
    L35:
        r13 = r8;
        goto L36
    L32:
        r8 = null;
        goto L33
    L28:
        r12 = r5;
        goto L29
    L25:
        r5 = null;
        goto L26
    L21:
        r9 = r2;
        goto L22
    L5:
        if (z2.a.exportFileConfig().getEnableMenuExportToDoc() == false) goto L18;
        int r24 = com.larus.bmhome.chat.layout.holder.helper.r.a;
        Intrinsics.checkNotNullParameter(r28, "menuContext");
        com.larus.bmhome.chat.api.q0 r25 = r28.c;
        if (r25 == null) goto L12;
        Function0<Fragment> r29 = r25.getHostFragment();
        if (r29 == null) goto L12;
        Fragment r30 = (Fragment) r29.invoke();
        if (r30 == null) goto L12;
    L17:
        return com.larus.bmhome.chat.layout.holder.helper.r.a(r30, r28.a, r28.b, null, null);
    L12:
        if (r27 != null) goto L70;
    L15:
        r30 = null;
        goto L17
    L70:
        Intrinsics.checkNotNullParameter(r27, "<this>");     // Catch: IllegalStateException -> L69
        r30 = FragmentManager.findFragment(r27);     // Catch: IllegalStateException -> L69
        goto L17
    }
}
