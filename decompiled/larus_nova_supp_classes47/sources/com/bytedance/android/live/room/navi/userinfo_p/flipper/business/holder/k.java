package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.navi.userinfo_p.UserInfoContextExtKt;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.widget.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k extends CommonTabHolder {
    public static final int k = 0;
    public TextView h;
    public HSImageView i;
    public ViewGroup.MarginLayoutParams j;

    public static final class a {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void k(u91.a r1) {
    }

    static {
        k = s1.f(32.0f);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final q91.a c() {
        return new q91.a();
    }

    public final boolean r() {
        if (a0.i(this.e) == false) goto L5;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return false;
    L15:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(this.e) == false) goto L17;
    L18:
        return true;
    L17:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewStyleForTTLite(this.e) == true) goto L18;
        return false;
    L5:
        if (a0.h(this.e) == true) goto L12;
        if (a0.f(this.e) == true) goto L12;
        if (a0.g(this.e) == true) goto L12;
        r0 = false;
        goto L13
    }

    public final void s() {
        IRoom r0 = this.d;
        if (r0 == null) goto L23;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L24;
        UserInfoVM.Companion.getClass();
        aa1.a r2 = UserInfoVM.b.b();
        if (r2 == null) goto L11;
        ElementBasicVM r3 = r2.getBasicVm();
        if (r3 == null) goto L11;
        ElementBasicVM.updateAccessibilityDesc$default(r3, r1.getRemarkNameOrRealNickName(), null, 2, null);
    L11:
        String r4 = r1.getRemarkNameOrNickname();
        TextView r5 = this.h;
        if (r5 == null) goto L27;
        r5.setText(r4);
        if (r() == true) goto L17;
        return;
    L17:
        if (r5.getIncludeFontPadding() == true) goto L26;
        boolean r6 = false;
        r5.measure(0, 0);
        if (r5.getMeasuredHeight() <= s1.f(18.0f)) goto L21;
        r6 = true;
    L21:
        r5.setIncludeFontPadding(r6);
        return;
    L26:
        return;
    L27:
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void l() {
        HSImageView r3 = null;
        if (r() == true) goto L5;
    L20:
        HSImageView r0 = this.f.findViewById(2131392049);
        if ((r0 instanceof TextView) == false) goto L24;
        r3 = r0;
    L24:
        this.h = (TextView) r3;
    L26:
        if (UIUtils.getScreenWidth(this.f.getContext()) >= 500) goto L31;
        TextView r1 = this.h;
        if (r1 == null) goto L31;
        r1.setMaxWidth(100);
    L31:
        if (r.b() == false) goto L35;
        int r2 = s1.f(26.0f);
        TextView r4 = this.h;
        if (r4 == null) goto L38;
        r4.setMinWidth(r2);
    L38:
        UIUtils.setViewVisibility(this.h, 0);
        return;
    L35:
        int r5 = k;
        TextView r6 = this.h;
        if (r6 == null) goto L38;
        r6.setMinWidth(r5);
        goto L38
    L5:
        if (r.b() == false) goto L20;
        View r7 = this.f.findViewById(2131392049);
        if ((r7 instanceof View) == true) goto L9;
        r7 = null;
    L9:
        UIUtils.setViewVisibility(r7, 8);
        View r8 = this.f.findViewById(2131392056);
        if ((r8 instanceof View) == true) goto L12;
        r8 = null;
    L12:
        UIUtils.setViewVisibility(r8, 0);
        View r9 = this.f.findViewById(2131392053);
        if ((r9 instanceof TextView) == true) goto L15;
        r9 = null;
    L15:
        this.h = (TextView) r9;
        HSImageView r10 = this.f.findViewById(2131392073);
        if ((r10 instanceof HSImageView) == false) goto L19;
        r3 = r10;
    L19:
        this.i = r3;
        goto L26
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void n() {
        s();
        UserInfoVM.Companion.getClass();
        aa1.a r0 = UserInfoVM.b.b();
        if (r0 == null) goto L8;
        ElementMiddleVM r1 = r0.getMiddleVm();
        if (r1 == null) goto L9;
        j(UserInfoContextExtKt.b(r1.getUserNameViewVisibility(), new UserInfoNicknameHolder$initEvent$$inlined$run$lambda$1(this)));
        j(RxUtilKt.h(r1.getChangeHeightWhenEmpty().onEvent()).subscribe(new l(this)));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void p() {
        super.p();
        ViewGroup.MarginLayoutParams r0 = this.j;
        if (r0 == null) goto L11;
        TextView r1 = this.h;
        if (r1 == null) goto L9;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L9;
        r2.height = r0.height;
    L9:
        UIUtils.updateLayoutMargin(this.f, r0.leftMargin, r0.topMargin, r0.rightMargin, r0.bottomMargin);
    L11:
        if (this.h != null) goto L13;
    L17:
        UIUtils.setViewVisibility(this.i, 8);
        return;
    L13:
        if (r() == false) goto L17;
        TextView r3 = this.h;
        if (r3 == null) goto L17;
        r3.setIncludeFontPadding(false);
        goto L17
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder, w91.f
    public final w91.a g() {
        return r91.e.b;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder.CommonTabHolder
    public final void o(IRoom r2) {
        this.d = r2;
        if (r2 == null) goto L7;
        IBaseUser r3 = r2.getOwner();
        if (r3 == null) goto L7;
        int r0 = r.a;
        r.a(this.i, r3);
    L7:
        s();
    }

    public k(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r2, r3, r4);
    }
}
