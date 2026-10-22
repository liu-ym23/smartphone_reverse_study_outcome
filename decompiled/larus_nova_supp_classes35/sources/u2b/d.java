package u2b;

import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public d() {
    }

    public static y6b.b a(ChatChatter r7) {
        y6b.b r0 = new y6b.b(r7.getId());
        ChatterNameDisplayRule r1 = ChatterNameDisplayRule.NICKNAME_NAME;
        r0.b = com.ss.android.lark.chat.utils.m.b(r7, r1, false);
        ChatterNameDisplayRule r3 = ChatterNameDisplayRule.ALIAS_NAME;
        r0.c = com.ss.android.lark.chat.utils.m.b(r7, r3, false);
        ChatterNameDisplayRule r4 = ChatterNameDisplayRule.NICKNAME_ALIAS_NAME;
        r0.d = com.ss.android.lark.chat.utils.m.b(r7, r4, false);
        ChatterNameDisplayRule r5 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        r0.e = com.ss.android.lark.chat.utils.m.b(r7, r5, false);
        r0.f = com.ss.android.lark.chat.utils.m.b(r7, r1, true);
        r0.g = com.ss.android.lark.chat.utils.m.b(r7, r3, true);
        r0.h = com.ss.android.lark.chat.utils.m.b(r7, r4, true);
        r0.i = com.ss.android.lark.chat.utils.m.b(r7, r5, true);
        r7.getNickName();
        r0.j = r7.getType();
        r0.k = r7.getAvatarKey();
        r0.l = r7.getWorkStatus();
        r0.m = r7.isFrozen();
        r0.n = r7.getZenModeEndTime();
        r0.o = r7.getDescription();
        r0.p = r7.getPrivateDescription();
        r0.q = r7.isDimission();
        r0.r = r7.isProfileEnable();
        r0.s = r7.getWithBotTag();
        r7.getBotExtraType();
        r0.t = r7.isBotAgent();
        r0.v = com.ss.android.lark.chat.utils.m.b(r7, ChatterNameDisplayRule.NAME, false);
        r7.getName();
        r0.w = r7.getTenantId();
        r7.isCustomer();
        r0.y = r7.getTagInfos();
        r0.x = r7.isAnonymous();
        r0.B = ChatterCustomStatus.fromPB(ChatCoreModule.a().getOpenedUserStatus(ChatterCustomStatus.toPB(r7.getChatter().getCustomStatus())));
        r0.C = r7.getChatter().getCustomStatus();
        r0.z = r7.getAvatarMedal();
        r0.A = r7.isSpecialFocus();
        r0.D = r7.getMajorLanguage();
        r0.u = r7.getOpenAppId();
        return r0;
    }
}
