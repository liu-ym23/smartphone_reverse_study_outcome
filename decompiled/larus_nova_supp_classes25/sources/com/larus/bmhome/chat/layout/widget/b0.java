package com.larus.bmhome.chat.layout.widget;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.ConversationCellIcon;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b0 implements Function1 {
    public final /* synthetic */ CvsItemRightAction.b a;
    public final /* synthetic */ ConversationCellIcon b;
    public final /* synthetic */ CvsItemRightAction c;

    public /* synthetic */ b0(CvsItemRightAction.b r1, ConversationCellIcon r2, CvsItemRightAction r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r13) {
        CvsItemRightAction.b r0 = this.a;
        ConversationCellIcon r1 = this.b;
        CvsItemRightAction r2 = this.c;
        int r3 = CvsItemRightAction.c;
        Intrinsics.checkNotNullParameter((View) r13, "it");
        wc9.e r14 = r0.d;
        if (r14 == null) goto L54;
        by7.e r4 = by7.h.h(r0.e);
        by7.e r5 = null;
        if (r4 == null) goto L8;
        HashMap r6 = by7.h.a(r4).getParams();
    L10:
        if (r6 == null) goto L12;
        Object r7 = r6.get("current_page");
    L14:
        if ((r7 instanceof String) == false) goto L16;
        String r8 = (String) r7;
    L17:
        String r9 = "";
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        if (Intrinsics.areEqual(r8, "chat") == false) goto L32;
        if (r6 == null) goto L24;
        Object r10 = r6.get("previous_page");
    L26:
        if ((r10 instanceof String) == false) goto L28;
        String r11 = (String) r10;
    L29:
        if (r11 == null) goto L33;
        r9 = r11;
    L33:
        String r12 = r1.getSchema();
        if (r12 != null) goto L37;
        return Unit.INSTANCE;
    L37:
        if (StringsKt.contains$default(r12, "//flow/realtime_chat", false, 2, null) == true) goto L39;
    L41:
        Uri r15 = UriProtector.parse(r12);
        Uri.Builder r16 = r15.buildUpon();
        if (UriProtector.getQueryParameter(r15, "conversation_id") != null) goto L44;
        r16.appendQueryParameter("conversation_id", r14.a);
    L44:
        r16.build();
        String r17 = r16.toString();
        FLogger.a.i("CvsItemRightAction", "[onRealtimeCallAction] url:" + r17);
        RecommendFrom r18 = r0.g;
        if (r18 != null) goto L47;
        r18 = new RecommendFrom("chat_list", null, null, 6);
    L47:
        com.bytedance.router.i r19 = SmartRouter.buildRoute(r2.getContext(), r17);
        Bundle r20 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat_list"), TuplesKt.to("enter_method", "chat_list_cell"), TuplesKt.to("current_page", r8), TuplesKt.to("previous_page", r9), TuplesKt.to("argBotRecommendFrom", r18), TuplesKt.to("argBotPosition", r0.h)});
        Fragment r21 = r0.e;
        if ((r21 instanceof by7.e) == false) goto L50;
        r5 = (by7.e) r21;
    L50:
        if (r5 == null) goto L52;
        by7.h.k(r20, r5);
    L52:
        r19.c.putExtras(r20);
        r19.d();
        return Unit.INSTANCE;
    L39:
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L41;
        t19.s r110 = t19.s.a;
        Application r22 = AppHost.a.getApplication();
        r110.getClass();
        t19.s.s(r22, 2131907325);
        return Unit.INSTANCE;
    L28:
        r11 = null;
        goto L29
    L24:
        r10 = null;
        goto L26
    L32:
        r9 = r8;
        goto L33
    L16:
        r8 = null;
        goto L17
    L12:
        r7 = null;
        goto L14
    L8:
        r6 = null;
        goto L10
    L54:
        return Unit.INSTANCE;
    }
}
