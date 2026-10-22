package com.larus.bmhome.chat.component.ext;

import android.os.Bundle;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final de8.c a(ChatFragment r18, Bundle r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        if (r20 != null) goto L5;
        Bundle r2 = r19;
    L6:
        if (r2 == null) goto L8;
        RecommendFrom r4 = (RecommendFrom) r2.getParcelable("argBotRecommendFrom");
    L9:
        if (r2 == null) goto L11;
        SearchMobParam r5 = (SearchMobParam) r2.getParcelable("argSearchMobParam");
    L13:
        if (r2 == null) goto L15;
        boolean r6 = r2.getBoolean("argCvsBgImgOpen");
    L16:
        if (r6 == false) goto L19;
        if (r2 == null) goto L19;
        String r7 = r2.getString("argCvsBgImgUrl");
    L20:
        if (r6 == false) goto L23;
        if (r2 == null) goto L23;
        String r8 = r2.getString("argCvsBgImgColor");
    L24:
        if (r6 == false) goto L28;
        if (r2 == null) goto L27;
        int r3 = Integer.valueOf(r2.getInt("immerseOrientation"));
    L29:
        Integer r10 = r3;
    L30:
        if (r6 == false) goto L33;
        if (r2 == null) goto L33;
        String r9 = r2.getString("argCvsBgVideoModel");
    L35:
        if (r2 != null) goto L37;
        boolean r11 = false;
    L55:
        if (z2.a.getChatNavigatorConfig().a == false) goto L61;
        if (r2 == null) goto L58;
        boolean r0 = r2.getBoolean("is_unread_dot_enable", true);
    L59:
        if (r0 == false) goto L61;
        boolean r12 = true;
    L62:
        if (r2 == null) goto L64;
        BotRecommendMobInfo r13 = (BotRecommendMobInfo) r2.getParcelable("recommend_bot_mob_segment");
    L66:
        return new de8.c(r19, r2, false, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, 0, 24580);
    L64:
        r13 = null;
        goto L66
    L58:
        r0 = true;
    L61:
        r12 = false;
        goto L62
    L37:
        if (r2.getInt("argBotConversationType", 0) != 3) goto L39;
        boolean r14 = true;
    L41:
        if (r14 == false) goto L43;
    L45:
        boolean r15 = r2.getBoolean("arg_need_to_show_ime", false);
        boolean r16 = z2.a.subConvKeyboardConfig().b();
        if (r16 == true) goto L50;
        if (r15 == true) goto L50;
        boolean r17 = false;
    L51:
        FLogger.a.i("ChatFragment", "[parseArgument] shouldShowImeOnce:" + r17 + ", needToShowFromCreate:" + r15 + ", needToShowFromOpen:" + r16);
    L52:
        r11 = r17;
    L50:
        r17 = true;
        goto L51
    L43:
        if (AppHost.a.isPlugin() == true) goto L45;
        FLogger.a.i("ChatFragment", "[parseArgument] isCocoSub:false, shouldShowImeOnce:false");
        r17 = false;
        goto L52
    L39:
        r14 = false;
    L33:
        r9 = null;
        goto L35
    L27:
        r10 = null;
        goto L30
    L28:
        r3 = -1;
    L23:
        r8 = null;
    L19:
        r7 = null;
        goto L20
    L15:
        r6 = false;
        goto L16
    L11:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    L5:
        r2 = r20;
        goto L6
    }
}
