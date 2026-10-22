package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel.GiftEffectConfigurationViewModelForAnchor;
import com.bytedance.android.livesdk.widget.x0;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftEffectConfigurationItemForAnchor implements n {
    public final boolean a;
    public GiftEffectConfigurationViewModelForAnchor b;
    public final Context c;

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final List<i> a() {
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1 r1 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$3 r3 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$4 r2 = new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$4(this);
        GiftEffectSwitchConfigType r13 = GiftEffectSwitchConfigType.EffectGame;
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$1 r4 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$2 r5 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$2(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$3 r6 = new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$3(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$1 r7 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$1(this);
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3 r8 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$4 r9 = new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$4(this);
        GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1 r10 = GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$1.INSTANCE;
        final GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$3 r11 = new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$3(this, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$2(this));
        final GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$4 r14 = new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$4(this);
        return CollectionsKt.listOf(new i[]{new i(r13, "接收玩法礼物", new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$5(r1), new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$6(r3), this.a, new GiftEffectConfigurationItemForAnchor$buildAnchorGameEffectSwitchItem$7(r2), "玩法礼物说明"), new i(GiftEffectSwitchConfigType.StickerGiftSwitch, "展示人脸礼物特效", new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$4(r4), new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$5(r6), this.a, new GiftEffectConfigurationItemForAnchor$buildAnchorStickerEffectSwitchItem$6(r5), "人脸礼物说明"), new i(r13, "展示角色技能特效", new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$5(r7), new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$6(r8), this.a, new GiftEffectConfigurationItemForAnchor$buildAnchorRoleSkillEffectSwitchItem$7(r9), "角色技能特效说明"), new i(GiftEffectSwitchConfigType.NormalGiftSwitch, "主播侧展示普通礼物特效", GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$5.INSTANCE, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$6(r11), this.a, new GiftEffectConfigurationItemForAnchor$buildAnchorNormalEffectSwitchItem$7(r14), "普通礼物特效说明"), GiftEffectConfigurationCommonItemKt.a(this.c, true, new GiftEffectConfigurationItemForAnchor$loadGiftEffectConfigurationItems$1(this))});
    }

    public GiftEffectConfigurationItemForAnchor(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = r3;
        if (((String) a.d.getValue(null, a.a[2])).length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        this.a = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.ui.configuration.n
    public final void b(GiftEffectConfigurationViewModelForAnchor r1) {
        this.b = r1;
    }

    public static final void c(GiftEffectConfigurationItemForAnchor r6, String r7) {
        r6.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        HashMap r3 = new HashMap();     // Catch: Throwable -> L17
        r3.put("gift_switch_type", r7);     // Catch: Throwable -> L17
        GiftEffectConfigurationViewModelForAnchor r8 = r6.b;     // Catch: Throwable -> L17
        boolean r4 = true;
        if (r8 != null) goto L6;
    L8:
        String r9 = "live_now_page";
    L9:
        r3.put("request_page", r9);     // Catch: Throwable -> L17
        String r10 = (String) a.d.getValue(null, a.a[2]);     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftEffectConfiguration", "openEffectIntroDialog " + r7 + ", schema [" + r10 + ']');     // Catch: Throwable -> L17
        if (r10.length() > 0) goto L13;
        r4 = false;
    L13:
        if (r4 == false) goto L15;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(s1.getContext(), u.b(r10, r3));     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r13 = Result.exceptionOrNull-impl(r11);
        if (r13 == null) goto L25;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftEffectConfiguration", "openEffectIntroDialog error, " + r7 + ", " + Log.getStackTraceString(r13));
        return;
    L25:
        return;
    L6:
        if (r8.isBeforeLive() != true) goto L8;
        r9 = "open_live_page";
    L17:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public static final void d(GiftEffectConfigurationItemForAnchor r3, String r4, Function1 r5) {
        r3.getClass();
        Context r6 = r3.c;
        x0.d r0 = new x0.d();
        r0.b = r6;
        r0.a = 0;
        r0.a = 4;
        r0.d = r4;
        j r7 = new j(r5);
        x0.c[] r1 = r0.g;
        x0.c r2 = r1[0];
        if (r2 != null) goto L5;
        r2 = new x0.c();
        r1[0] = r2;
    L5:
        r2.a = "确认关闭";
        r2.b = r7;
        k r8 = new k(r5);
        x0.c[] r9 = r0.g;
        x0.c r10 = r9[1];
        if (r10 != null) goto L8;
        r10 = new x0.c();
        r9[1] = r10;
    L8:
        r10.a = "取消";
        r10.b = r8;
        r0.h = new l(r5);
        x0.b.g(new x0(r0.b, r0));
    }
}
