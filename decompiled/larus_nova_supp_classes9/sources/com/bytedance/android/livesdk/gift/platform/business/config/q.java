package com.bytedance.android.livesdk.gift.platform.business.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends c {
    @Override // com.bytedance.android.livesdk.gift.platform.business.config.c, com.bytedance.android.livesdk.gift.platform.business.config.k
    public final j create() {
        j r0 = super.create();
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_ITEM_HEIGHT_DIP, 110);
        GiftConfigKey r1 = GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_HONOR_LEVEL;
        Boolean r2 = Boolean.TRUE;
        r0.b(r1, r2);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, 2131917180);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_SEND_GIFT_FANS_CLUB_PRE_CHECK, r2);
        r0.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_TRAY_BG_EFFECT, r2);
        GiftConfigKey r3 = GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT;
        Boolean r4 = Boolean.FALSE;
        r0.b(r3, r4);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_NEW_STYLE_VH, r2);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_COMBO_ANIM_STYLE, 1);
        r0.b(GiftConfigKey.KEY_GIFT_SHOW_HONOR_ICON, r4);
        r0.b(GiftConfigKey.KEY_GIFT_SHOW_AVATAR_BORDER, r4);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_MARGIN, r2);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR, r2);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, r2);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_FIRST_CHARGE_GUIDE, r2);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_AUTO_DISMISS, r2);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_SPECIAL_NICK, r2);
        r0.a(m.class, new n12.a());
        r0.a(n12.f.class, new n12.c());
        r0.a(o.class, new i());
        r0.a(l.class, new h());
        r0.a(n.class, new n12.b());
        return r0;
    }

    public q() {
    }
}
