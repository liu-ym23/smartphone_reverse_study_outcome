package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class c implements k {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.config.k
    public j create() {
        j r0 = new j();
        GiftConfigKey r1 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        r0.b(r1, new DiamondConfig(r3.a(), r3.c(), r3.b(), 8));
        GiftConfigKey r2 = GiftConfigKey.KEY_GIFT_DIALOG_SYNC_XG_COIN;
        Boolean r3 = Boolean.FALSE;
        r0.b(r2, r3);
        DiamondConfig.d.getClass();
        r0.b(r1, DiamondConfig.a.a());
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_ITEM_HEIGHT_DIP, 104);
        GiftConfigKey r4 = GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_FIRST_CHARGE;
        Boolean r5 = Boolean.TRUE;
        r0.b(r4, r5);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_HONOR_LEVEL, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, 2131917181);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_GROUP_DESC, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_NEED_PROMOTION_AD, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_ENABLE_NEW_STYLE_VH, r5);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_SHOW_FIRST_RECHARGE_NOT_LOGIN, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_SEND_GIFT_FANS_CLUB_PRE_CHECK, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_PROP_PANEL_UPDATE_ON_SEND_FINISH, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_NEW_GROUP, r5);
        r0.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_TRAY_BG_EFFECT, r3);
        r0.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_DISPLAY_USER_NAME, r3);
        r0.b(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, r3);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_ENABLE_LANDSCAPE_ANIM_IN_MEDIA, r5);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_NEED_RESET_VISIBILITY, r3);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_NEED_HAND_SHOW, r3);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_COMBO_ANIM_STYLE, 0);
        r0.b(GiftConfigKey.KEY_NORMAL_GIFT_ENABLE_TRAY_GRADIENT, r3);
        r0.b(GiftConfigKey.KEY_GIFT_SHOW_HONOR_ICON, r5);
        r0.b(GiftConfigKey.KEY_GIFT_SHOW_AVATAR_BORDER, r5);
        r0.b(GiftConfigKey.KEY_GIFT_TRAY_ADJUST_WITH_DIALOG_IN_LANDSCAPE, r3);
        r0.b(GiftConfigKey.KEY_CORE_DOWNLOAD_RES_MAX_TASK_COUNT, 3);
        r0.b(GiftConfigKey.KEY_CORE_DOWNLOAD_ENSURE_INIT_IN_SDK, r3);
        r0.b(GiftConfigKey.KEY_CORE_EFFECT_MESSAGE_DES_NEED_DETAIL, r3);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_DATA_SOURCE, r3);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_USE_NEW_MARGIN, r3);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR, r3);
        r0.b(GiftConfigKey.KEY_CORE_HONOR_VIEW_USE_PIC, r3);
        r0.b(GiftConfigKey.KEY_GIFT_DEFAULT_ICON, 2131250964);
        r0.b(GiftConfigKey.KEY_GIFT_SELECTED_IMAGE_BG, 2131249186);
        r0.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_ICON, TuplesKt.to(2131249175, 2131249176));
        r0.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_MARGIN_TOP, 8);
        r0.b(GiftConfigKey.KEY_PAGER_BOTTOM_SHOWER_MARGIN, 0);
        r0.b(GiftConfigKey.KEY_GIFT_DIALOG_LANDSCAPE_SINGLE_LIST, r3);
        r0.b(GiftConfigKey.KEY_GIFT_LIST_EMPTY_ICON, 2131250536);
        r0.b(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_TEXT, 2131917089);
        r0.b(GiftConfigKey.KEY_BACKPACK_GIFT_LIST_EMPTY_CHECK_RECORD_ICON, 2131253159);
        r0.b(GiftConfigKey.KEY_GIFT_TAB_TEXT_COLOR, TuplesKt.to(2131107552, 2131107551));
        r0.b(GiftConfigKey.KEY_GIFT_BOTTOM_RECHARGE_COLOR, 2131107550);
        r0.b(GiftConfigKey.KEY_GIFT_EMPTY_SEND_VIEW_ICON, 2131249468);
        r0.b(GiftConfigKey.KEY_GIFT_SEND_VIEW_ICON, 2131249427);
        r0.b(GiftConfigKey.KEY_GIFT_GRAY_SEND_GROUP_COUNT_BTN_RTL, 2131249429);
        r0.b(GiftConfigKey.KEY_GIFT_GRAY_SEND_GROUP_COUNT_BTN, 2131249428);
        r0.b(GiftConfigKey.KEY_GROUP_SELECTOR_BACKGROUND_ICON, 2131249166);
        r0.b(GiftConfigKey.KEY_GROUP_SELECTOR_SIZE, TuplesKt.to(2131168716, 2131168714));
        r0.b(GiftConfigKey.KEY_CORE_HONOR_WIDGET_NEED_LABEL_COLOR_RES, TuplesKt.to(2131107741, 2131107742));
        r0.b(GiftConfigKey.KEY_SHOW_SPECIAL_RECHARGE_GUIDE, r3);
        r0.b(GiftConfigKey.KEY_NEED_INIT_RECHARGE_GUIDE, r3);
        r0.b(GiftConfigKey.KET_GIFT_GUIDE_SHOW_BLANK_HINT, r3);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SEND_GIFT_TIP_STR, 2131922450);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_PROTECT_UNDERAGE_STR, 2131919796);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_FIRST_CHARGE_GUIDE, r3);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_AUTO_DISMISS, r3);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW, r5);
        r0.b(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_SPECIAL_NICK, r3);
        r0.b(GiftConfigKey.KEY_GIFT_SPLIT_NAME, r3);
        r0.b(GiftConfigKey.KEY_PROP_SHOW_NUM, r5);
        r0.b(GiftConfigKey.KEY_PROP_FIX_TEXT, r3);
        r0.a(m.class, new e());
        r0.a(n12.f.class, new n12.d());
        r0.a(o.class, new g());
        r0.a(l.class, new d());
        if (PadConfigUtils.c() == false) goto L5;
    L8:
        p r6 = new w02.e();
    L9:
        r0.a(w02.g.class, r6);
        r0.a(n.class, new f());
        r0.a(w02.h.class, new w02.a());
        r0.a(w02.i.class, new w02.b());
        if (PadConfigUtils.c() == false) goto L12;
    L15:
        p r7 = new w02.f();
    L16:
        r0.a(w02.j.class, r7);
        return r0;
    L12:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L15;
        r7 = new w02.d();
        goto L16
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L8;
        r6 = new w02.c();
        goto L9
    }
}
