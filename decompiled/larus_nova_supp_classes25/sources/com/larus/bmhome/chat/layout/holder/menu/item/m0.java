package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.b3;
import com.larus.platform.service.z1;
import com.larus.security.api.ReportDialogHelper;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 extends com.larus.bmhome.chat.layout.holder.menu.item.a {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r2) {
        if (r2 != 2131900233) goto L5;
        return true;
    L5:
        return false;
    }

    public m0() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r13, final View r14, final ef8.b r15) {
        Intrinsics.checkNotNullParameter(r13, "item");
        Intrinsics.checkNotNullParameter(r14, "view");
        Intrinsics.checkNotNullParameter(r15, "menuContext");
        ChatFragment r16 = ViewExtKt.i(r14);     // Catch: Exception -> L32
        if (r16 == null) goto L6;
        long r0 = r16.getChatUniqueKey();     // Catch: Exception -> L32
    L7:
        final long r4 = r0;
        ChatControlTrace r17 = ChatControlTrace.b;     // Catch: Exception -> L32
        Message r1 = r15.a;     // Catch: Exception -> L32
        Fragment r2 = e1.k(r14);     // Catch: Exception -> L32
        r17.getClass();     // Catch: Exception -> L32
        ChatControlTrace.S("long_press_answer", r1, r2, r4);     // Catch: Exception -> L32
        ChatFragment r18 = ViewExtKt.i(r14);     // Catch: Exception -> L32
        String r3 = null;
        if (r18 == null) goto L10;
        View r19 = r18.getView();     // Catch: Exception -> L32
    L12:
        if (AppHost.a.isOversea() == false) goto L18;
        if (r19 == null) goto L37;
        z1 r110 = z1.a;     // Catch: Exception -> L32
        BotModel r111 = r15.a();     // Catch: Exception -> L32
        if (r111 == null) goto L17;
        r3 = r111.getBotId();     // Catch: Exception -> L32
    L17:
        b3.a.a(r19, 2, r3, r15.a.getMessageId(), null, 16);     // Catch: Exception -> L32
        return true;
    L37:
        return true;
    L18:
        if (r19 == null) goto L25;
        ViewExtKt.g(r19);     // Catch: Exception -> L32
        if ((r19 instanceof ChatConstraintLayout) == false) goto L22;
        ChatConstraintLayout r5 = (ChatConstraintLayout) r19;     // Catch: Exception -> L32
    L23:
        if (r5 == null) goto L25;
        ViewExtKt.g(r5);     // Catch: Exception -> L32
        goto L25
    L22:
        r5 = null;
    L25:
        Context r6 = r14.getContext();     // Catch: Exception -> L32
        if ((r6 instanceof FragmentActivity) == false) goto L28;
        r3 = (FragmentActivity) r6;     // Catch: Exception -> L32
    L28:
        String r7 = r3;
        if (r7 == null) goto L39;
        final View r8 = r19;
        ReportDialogHelper.d(ReportDialogHelper.a, r7, CollectionsKt.listOf(r15.a), null, o0.a(r15), new k0(r8, r4, r14, r15), 4);     // Catch: Exception -> L32
        return true;
    L39:
        return true;
    L10:
        r19 = null;
        goto L12
    L6:
        r0 = 0;
    L32:
        e = move-exception;
        FLogger.a.e("ReportMenu", "ReportMenu findFragment() found exception: " + e);
        return true;
    }
}
