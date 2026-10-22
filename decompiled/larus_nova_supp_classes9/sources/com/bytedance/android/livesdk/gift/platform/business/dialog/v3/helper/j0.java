package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 {
    public static final boolean a(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isBigGift");
        if (r2.getType() != 2) goto L5;
        return true;
    L5:
        if (r2.getType() != 8) goto L7;
        return true;
    L7:
        if (r2.getType() != 4) goto L9;
        return true;
    L9:
        if (r2.getType() == 13) goto L16;
        return false;
    L16:
        return true;
    }

    public static final boolean b(AbsPanel<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isBigPanel");
        Object r4 = r3.h;
        if ((r4 instanceof h1) == true) goto L5;
        Object r0 = null;
    L6:
        h1 r1 = (h1) r0;
        if (r1 == null) goto L11;
        return a(r1);
    L11:
        if ((r4 instanceof l2) == true) goto L13;
        r4 = null;
    L13:
        l2 r5 = (l2) r4;
        if (r5 == null) goto L24;
        Intrinsics.checkNotNullParameter(r5, "$this$isBigProp");
        if (r5.getGift().getType() != 2) goto L18;
    L22:
        return true;
    L18:
        if (r5.getGift().getType() == 8) goto L22;
        if (r5.getGift().getType() == 4) goto L22;
        return false;
    L24:
        return false;
    L5:
        r0 = r4;
        goto L6
    }

    public static final boolean c(AbsPanel<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMessageBoardPanel");
        Object r3 = r2.h;
        if ((r3 instanceof h1) == true) goto L5;
        r3 = null;
    L5:
        h1 r4 = (h1) r3;
        if (r4 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "$this$isMessageBoardGift");
        GiftMsgBoard r5 = r4.getGiftMsgBoard();
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.forMsgBoard;
    L11:
        return false;
    }

    public static final w1 d(w1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$provideMainGiftPageWithClone");
        w1 r0 = (w1) vh7.f.c(w1.class);
        r0.setPageType(r2.getPageType());
        r0.setPageName(r2.getPageName());
        r0.setGifts(r2.getGifts());
        r0.setDisplay(r2.getDisplay());
        r0.setEventName(r2.getEventName());
        r0.setTopicList(r2.getTopicList());
        r0.setPageSortStrategy(r2.getPageSortStrategy());
        r0.setBackgroundImage(r2.getBackgroundImage());
        r0.setPageInfo(r2.getPageInfo());
        r0.setReceiversModBg(r2.getReceiversModBg());
        r0.setReceiversLongModBg(r2.getReceiversLongModBg());
        r0.setSectionList(r2.getSectionList());
        r0.setBaseGifts(r2.getBaseGifts());
        r0.setPageNameStyleInfo(r2.getPageNameStyleInfo());
        r0.setLynxConfig(r2.getLynxConfig());
        return r0;
    }

    public static final boolean e(h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$shouldLockGiftStatus");
        if (r4.getGiftPreviewInfo() == null) goto L11;
        com.bytedance.android.livesdk.gift.model.k0 r5 = r4.getGiftPreviewInfo();
        if (r5 == null) goto L11;
        if (r5.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.LOCKED_GRAY) goto L11;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean f(h1 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$shouldLockNormal");
        if (r4.getGiftPreviewInfo() == null) goto L11;
        com.bytedance.android.livesdk.gift.model.k0 r5 = r4.getGiftPreviewInfo();
        if (r5 == null) goto L11;
        if (r5.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.LOCKED_NORMAL) goto L11;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L11;
        return true;
    L11:
        return false;
    }
}
