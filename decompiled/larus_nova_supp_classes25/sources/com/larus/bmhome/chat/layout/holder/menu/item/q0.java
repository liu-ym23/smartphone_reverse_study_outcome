package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.b3;
import com.larus.platform.service.z1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q0 extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    public static final class a {
    }

    static {
    }

    public q0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != MenuActionType.REPORT_MUSIC.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r7, final View r8, final ef8.b r9) {
        Intrinsics.checkNotNullParameter(r7, "item");
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "menuContext");
        ChatFragment r10 = ViewExtKt.i(r8);     // Catch: Exception -> L27
        if (r10 == null) goto L6;
        final long r0 = r10.getChatUniqueKey();     // Catch: Exception -> L27
    L7:
        ChatControlTrace r11 = ChatControlTrace.b;     // Catch: Exception -> L27
        Message r3 = r9.a;     // Catch: Exception -> L27
        Fragment r4 = e1.k(r8);     // Catch: Exception -> L27
        r11.getClass();     // Catch: Exception -> L27
        ChatControlTrace.S("long_press_answer", r3, r4, r0);     // Catch: Exception -> L27
        ChatFragment r12 = ViewExtKt.i(r8);     // Catch: Exception -> L27
        ChatConstraintLayout r2 = null;
        if (r12 == null) goto L10;
        View r13 = r12.getView();     // Catch: Exception -> L27
    L12:
        if (AppHost.a.isOversea() == false) goto L18;
        if (r13 == null) goto L32;
        z1 r14 = z1.a;     // Catch: Exception -> L27
        BotModel r15 = r9.a();     // Catch: Exception -> L27
        if (r15 == null) goto L17;
        r2 = r15.getBotId();     // Catch: Exception -> L27
    L17:
        b3.a.a(r13, 2, r2, r9.a.getMessageId(), null, 16);     // Catch: Exception -> L27
        return true;
    L32:
        return true;
    L18:
        if (r13 == null) goto L24;
        ViewExtKt.g(r13);     // Catch: Exception -> L27
        if ((r13 instanceof ChatConstraintLayout) == false) goto L22;
        r2 = (ChatConstraintLayout) r13;     // Catch: Exception -> L27
    L22:
        if (r2 == null) goto L24;
        ViewExtKt.g(r2);     // Catch: Exception -> L27
    L24:
        if (r13 == null) goto L34;
        r13.postDelayed(new p0(r0, r8, r9), 200);     // Catch: Exception -> L27
        return true;
    L34:
        return true;
    L10:
        r13 = null;
        goto L12
    L6:
        r0 = 0;
    L27:
        e = move-exception;
        FLogger.a.e("ReportMenu", "ReportMenu findFragment() found exception: " + e);
        return true;
    }
}
