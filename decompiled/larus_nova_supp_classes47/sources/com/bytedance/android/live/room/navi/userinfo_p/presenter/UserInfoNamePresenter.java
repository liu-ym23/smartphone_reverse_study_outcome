package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.widget.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoNamePresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoNamePresenter extends BaseElementPresenter {
    public TextView f;
    public HSImageView g;
    public ViewGroup.MarginLayoutParams h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final ViewGroup n;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
        if (this.h == null) goto L18;
        TextView r0 = this.f;
        if (r0 == null) goto L18;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L10:
        if (r1 == null) goto L16;
        ViewGroup.MarginLayoutParams r2 = this.h;
        if (r2 == null) goto L14;
        Integer r3 = Integer.valueOf(r2.height);
    L15:
        Intrinsics.checkNotNull(r3);
        r1.height = r3.intValue();
        goto L16
    L14:
        r3 = null;
    L16:
        TextView r4 = this.f;
        ViewGroup.MarginLayoutParams r5 = this.h;
        Intrinsics.checkNotNull(r5);
        int r6 = r5.leftMargin;
        ViewGroup.MarginLayoutParams r7 = this.h;
        Intrinsics.checkNotNull(r7);
        int r8 = r7.topMargin;
        ViewGroup.MarginLayoutParams r9 = this.h;
        Intrinsics.checkNotNull(r9);
        int r10 = r9.rightMargin;
        ViewGroup.MarginLayoutParams r12 = this.h;
        Intrinsics.checkNotNull(r12);
        UIUtils.updateLayoutMargin(r4, r6, r8, r10, r12.bottomMargin);
        this.h = null;
        goto L18
    L9:
        r1 = null;
    L18:
        if (this.f != null) goto L20;
    L22:
        UIUtils.setViewVisibility(this.g, 8);
        return;
    L20:
        if (d() == false) goto L22;
        TextView r13 = this.f;
        Intrinsics.checkNotNull(r13);
        r13.setIncludeFontPadding(false);
        goto L22
    }

    public final void h(int r3) {
        ViewGroup.LayoutParams r0 = this.n.getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == false) goto L6;
        ((LinearLayout.LayoutParams) r0).rightMargin = r3;
        this.n.setLayoutParams(r0);
        return;
    }

    public final void i(Boolean r5) {
        IRoom r0 = b();
        if (r0 == null) goto L58;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L61;
        boolean r2 = false;
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L31;
        o r6 = z51.a.h(a(), 2);
        if (r6 == null) goto L30;
        n r7 = r6.getTemplateContext();
        if (r7 == null) goto L30;
        z70.b r8 = (z70.b) r7.getValue();
        if (r8 == null) goto L30;
        if (r8.j("anchor_avatar") != true) goto L30;
        IRoom r9 = b();
        if (r9 == null) goto L31;
        RoomAvator r10 = gb2.b.c(r9);
        if (r10 == null) goto L31;
        k r12 = r10.getAuthenticationInfo();
        if (r12 == null) goto L31;
        int r3 = r.a;
        HSImageView r4 = this.g;
        Intrinsics.checkNotNullParameter(r12, "image");
        if (r.b() == false) goto L31;
        if (r12.isValid() == false) goto L29;
        UIUtils.setViewVisibility(r4, 0);
        ImageUtil.loadImage(r4, r12, 0);
        goto L31
    L29:
        UIUtils.setViewVisibility(r4, 8);
    L30:
        int r13 = r.a;
        r.a(this.g, r1);
    L31:
        String r14 = this.e.getName();
        if (r14 != null) goto L34;
        r14 = "";
    L34:
        TextView r15 = this.f;
        if (r15 != null) goto L38;
        return;
    L38:
        if (TextUtils.isEmpty(r15.getText()) == true) goto L46;
        TextView r16 = this.f;
        if (r16 == null) goto L42;
        CharSequence r17 = r16.getText();
    L44:
        if (TextUtils.equals(r17, r14) == false) goto L46;
        return;
    L42:
        r17 = null;
    L46:
        TextView r18 = this.f;
        if (r18 == null) goto L50;
        r18.setText(r14);
    L50:
        if (d() == false) goto L59;
        TextView r19 = this.f;
        Intrinsics.checkNotNull(r19);
        if (r19.getIncludeFontPadding() == true) goto L60;
        TextView r20 = this.f;
        Intrinsics.checkNotNull(r20);
        r20.measure(0, 0);
        TextView r22 = this.f;
        Intrinsics.checkNotNull(r22);
        TextView r23 = this.f;
        Intrinsics.checkNotNull(r23);
        if (r23.getMeasuredHeight() <= s1.f(18.0f)) goto L56;
        r2 = true;
    L56:
        r22.setIncludeFontPadding(r2);
        return;
    L60:
        return;
    L59:
        return;
    L61:
        return;
    }

    public UserInfoNamePresenter(m91.c r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserNameLayout");
        super(r2);
        this.n = r3;
        this.i = 500;
        this.j = 100;
        this.k = s1.f(32.0f);
        this.l = 150;
        this.m = 84;
    }
}
