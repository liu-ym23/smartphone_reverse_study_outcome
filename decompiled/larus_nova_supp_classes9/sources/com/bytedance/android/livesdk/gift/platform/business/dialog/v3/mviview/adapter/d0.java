package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangePinupStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickPinupHintIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PinTopState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowMostlyUsedPinupPopup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowMostlyUsedTabPinStatusChangeToast;
import com.bytedance.dux.popover.DuxPopoverLayout;
import com.bytedance.dux.popover.PopoverTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 extends BaseMVIListItem<ItemListData, GiftAction> {
    public final LiveSwitchButton l;
    public final ImageView m;
    public boolean n;
    public boolean o;
    public xl4.a p;
    public final int q;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ d0 a;

        public b(d0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.o(new ClickPinupHintIcon());
        }
    }

    public static final class c implements LiveSwitchButton.e {
        public final /* synthetic */ d0 a;

        public c(d0 r1) {
            this.a = r1;
        }

        public final void d0(LiveSwitchButton r3, boolean r4) {
            d0 r5 = this.a;
            if (r4 == false) goto L5;
            int r6 = 1;
        L6:
            r5.o(new ChangePinupStatus(r6, r5.q));
            return;
        L5:
            r6 = 2;
            goto L6
        }
    }

    public static final class d implements LiveSwitchButton.f {
        public final /* synthetic */ d0 a;

        public d(d0 r1) {
            this.a = r1;
        }

        public final Boolean a(boolean r2) {
            d0 r3 = this.a;
            if (r3.o == true) goto L7;
            f2.c("当前不支持设置", 0);
            return Boolean.TRUE;
        L7:
            if (r3.n == true) goto L9;
            r3.n = true;
            return Boolean.FALSE;
        L9:
            return Boolean.TRUE;
        }
    }

    static {
    }

    public final void i() {
        this.m.setOnClickListener(null);
        this.l.setToggleEventInterceptor(null);
        this.l.setOnCheckedChangeListener(null);
        xl4.a r0 = this.p;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.p = null;
    }

    public final void g() {
        String r0 = com.bytedance.android.livesdk.gift.platform.business.i.n().Q2();
        if (r0 != null) goto L5;
    L13:
        this.m.setVisibility(8);
    L14:
        this.l.setEnableDrag(false);
        this.l.setOnCheckedChangeListener(new c(this));
        this.l.setToggleEventInterceptor(new d(this));
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        this.m.setVisibility(0);
        this.m.setOnClickListener(new b(this));
        goto L14
    L7:
        r2 = false;
        goto L8
    }

    public final boolean d(com.bytedance.android.anya.a0 r15) {
        Intrinsics.checkNotNullParameter(r15, "e");
        String r1 = null;
        boolean r3 = false;
        if ((r15 instanceof ShowMostlyUsedTabPinStatusChangeToast) == false) goto L14;
        int r16 = ((ShowMostlyUsedTabPinStatusChangeToast) r15).getSortStrategy();
        if (r16 == 1) goto L9;
        if (r16 != 2) goto L10;
        r1 = "已取消设置，再次打开即可生效";
    L10:
        if (r1 == null) goto L12;
        f2.c(r1, 0);
    L12:
        return true;
    L9:
        r1 = "设置成功，再次打开即可生效";
        goto L10
    L14:
        if ((r15 instanceof ShowMostlyUsedPinupPopup) == false) goto L41;
        xl4.a r17 = this.p;
        if (r17 == null) goto L18;
        PopupWindowLancet.handleDismissBeforeOrigin(r17);
        r17.dismiss();
    L18:
        this.p = null;
        Context r18 = ((BaseMVIListItem) this).j.getContext();
        if ((r18 instanceof Activity) == true) goto L21;
        r18 = null;
    L21:
        Activity r19 = (Activity) r18;
        if (r19 == null) goto L40;
        xl4.a.a r0 = new xl4.a.a(r19);
        r0.d = ColorProtector.parseColor("#393B44");
        r0.A = true;
        r0.z = true;
        r0.i = -1;
        r0.v = true;
        int r110 = xl4.a.I;
        r0.b = xl4.a.b.a(80);
        r0.j = false;
        PopoverTextView r111 = new PopoverTextView(((BaseMVIListItem) this).j.getContext(), null);
        r111.setTextColor(s1.h(2131109391));
        r111.setTextSize(1, 12.0f);
        r111.setTextAlignment(5);
        r111.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r111.setMaxLines(1);
        r111.setEllipsize(TextUtils.TruncateAt.END);
        wh6.a r2 = vh6.c.b(wh6.a.class);
        if (r2 != null) goto L27;
    L29:
        boolean r4 = false;
    L30:
        wh6.a r5 = vh6.c.b(wh6.a.class);
        if (r5 != null) goto L33;
    L35:
        if (r3 == false) goto L38;
        if (r4 == true) goto L38;
        String r6 = com.bytedance.android.livesdk.gift.platform.business.i.n().Q2();
    L39:
        r111.setText(r6);
        r111.setGravity(17);
        int r7 = UtilityKotlinExtentionsKt.i(10);
        int r8 = DuxPopoverLayout.z;
        r111.setPadding(r7, r8, UtilityKotlinExtentionsKt.i(10), r8);
        Intrinsics.checkNotNullParameter(r111, "view");
        r0.k = r111;
        xl4.a r9 = new xl4.a(r0);
        this.p = r9;
        xl4.b.c(xl4.b.a, r9, this.m, 80, false, -((r8 + UtilityKotlinExtentionsKt.i(10)) - (this.m.getMeasuredWidth() / 2)), UtilityKotlinExtentionsKt.i(4), 144);
    L38:
        r6 = com.bytedance.android.livesdk.gift.platform.business.i.n().V8();
        goto L39
    L33:
        if (r5.isPersonalRecommendOn() != true) goto L35;
        r3 = true;
        goto L35
    L27:
        if (r2.isAppInGuestMode() != true) goto L29;
        r4 = true;
    L40:
        return true;
    L41:
        return false;
    }

    public d0(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a() == false) goto L7;
        GiftPanelViewPreloadService.l.getClass();
        View r0 = GiftPanelViewPreloadService.a.a(2131565258);
        if (r0 == null) goto L7;
    L8:
        super(r0, new ItemListData());
        this.q = r5;
        this.l = ((BaseMVIListItem) this).j.findViewById(2131382331);
        this.m = (ImageView) ((BaseMVIListItem) this).j.findViewById(2131380335);
        return;
    L7:
        r0 = LayoutInflater.from(r4.getContext()).inflate(2131565258, r4, false);
        goto L8
    }

    public final void b(com.bytedance.android.anya.k r5, MVIState r6) {
        ItemListData r7 = (ItemListData) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        r0<ItemListData, PinTopState> r8 = r7.getPinTopStatus();
        Object r0 = r5.c.a(r8);
        if (r0 == null) goto L23;
        r5.b.a.invoke(r8);
        PinTopState r1 = (PinTopState) r0;
        if (r1.getPinStrategy() == 0) goto L21;
        boolean r9 = true;
        if (r1.getDisableSwitchToPinTop() == true) goto L9;
    L11:
        this.l.setAlpha(1.0f);
        this.o = true;
    L12:
        boolean r10 = this.l.isChecked();
        int r3 = r1.getPinStrategy();
        if (r10 == false) goto L15;
        if (r3 != 1) goto L15;
    L19:
        if (r9 == true) goto L21;
        this.l.f(false, false);
    L15:
        if (r10 == true) goto L18;
        if (r3 == 2) goto L19;
    L18:
        r9 = false;
        goto L19
    L9:
        if (r1.getPinStrategy() != 2) goto L11;
        this.l.setAlpha(0.5f);
        this.o = false;
    L21:
        this.n = r1.isSwitching();
        return;
    }
}
