package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static a a(ChatChatter r24) {
        String r1 = null;
        if (r24 != null) goto L5;
        return null;
    L5:
        User r2 = com.ss.android.lark.mention.base.b.a().getForegroundUser();
        if (r2 == null) goto L21;
        Tenant r4 = r2.tenant;
        if (r4 != null) goto L10;
        String r5 = "";
    L11:
        User r6 = com.ss.android.lark.mention.base.b.a().getForegroundUser();
        if (r6 == null) goto L16;
        Tenant r7 = r6.tenant;
        if (r7 == null) goto L16;
        r1 = r7.tenantId;
    L16:
        int r8 = com.ss.android.lark.passport.signinsdk_api.contants.a.a;
        boolean r3 = Intrinsics.areEqual(r1, "0");
        boolean r9 = r2.isSmallB();
        if ((!TextUtils.equals(r24.getTenantId(), r5)) == false) goto L21;
        if (r3 == true) goto L21;
        if (r9 == true) goto L21;
        boolean r18 = true;
    L22:
        int r10 = com.ss.android.lark.mention.base.a.a;
        boolean r11 = FeatureGatingModule.getFeatureGatingService().isEnable("im.signature.visibility.view");
        UserPrivateDescription r12 = r24.getPrivateDescription();
        if (r11 == false) goto L32;
        if (r12 == null) goto L32;
        if (r12.getDescriptionId() == null) goto L32;
        if (r12.getDescriptionId().longValue() <= 0) goto L32;
        if (r12.hasContent() == false) goto L32;
        ChatterDescription r13 = new ChatterDescription(r12.getContent(), ChatterDescription.Type.DEFAULT, r12.getDescriptionId().longValue());
    L33:
        List r20 = ChatterCustomStatus.toPB(r24.getCustomStatus());
        String r14 = r24.getId();
        r24.getAvatarKey();
        a r15 = new a(r14, r24.getAvatarKey(), m.b(r24, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true), "", new ArrayList(), new ArrayList(), r24.getType(), r13, r24.getRegistered(), r24.getNamePy(), r24.getWorkStatus(), r24.getZenModeEndTime(), r18, r24.getTagInfos(), r20, r24.getTagData(), r24.showBotTag(), r24.showAgentTag());
        r15.k = r24.isFrozen();
        r24.getBotExtraType();
        ChatterSensitiveInfo r16 = new ChatterSensitiveInfo();
        if (r24.getChatterSensitiveInfo() == null) goto L36;
        r16.setChatterDepartmentName(r24.getChatterSensitiveInfo().getChatterDepartmentName());
        r15.q = r16;
    L36:
        return r15;
    L32:
        r13 = r24.getDescription();
        goto L33
    L10:
        r5 = r4.tenantId;
    L21:
        r18 = false;
        goto L22
    }
}
