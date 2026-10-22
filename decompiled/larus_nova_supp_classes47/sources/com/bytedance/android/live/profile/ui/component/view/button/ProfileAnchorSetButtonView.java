package com.bytedance.android.live.profile.ui.component.view.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ns0.a;
import ns0.c;
import st0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/button/ProfileAnchorSetButtonView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "Lst0/b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileAnchorSetButtonView extends ProfileButtonView {
    public ViewGroup f;
    public ImageView g;
    public View h;

    public ProfileAnchorSetButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileAnchorSetButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_ECOM_SET_BUTTON, r4, LayoutInflater.from(r4), this, true);
    L6:
        this.f = (ViewGroup) findViewById(2131380778);
        this.g = (ImageView) findViewById(2131380775);
        this.h = findViewById(2131380776);
        return;
    L5:
        LayoutInflater.from(r4).inflate(2131567196, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void b(b r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        a r4 = c.a();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.showAnchorSetButtonRedDot() != true) goto L11;
        View r5 = this.h;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(b r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(b r1, ProfileSkin r2) {
        g(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void g(b r3, ProfileSkin r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "skin");
        ProfileCustomSkin r5 = r4.skin;
        if (r5 == null) goto L13;
        ProfileCustomSkin.SecondaryButtonUI r6 = r5.secondaryButtonSkin;
        if (r6 == null) goto L14;
        String r7 = r6.iconColor;
        String r0 = r6.borderColor;
        String r8 = r6.backgroundColor;
        ViewGroup r1 = this.f;
        if (r1 == null) goto L9;
        m.f(r1, r8);
        m.c(r1, r0);
    L9:
        ImageView r9 = this.g;
        if (r9 == null) goto L15;
        m.e(r9, r7);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(b r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        ViewGroup r0 = this.f;
        if (r0 == null) goto L5;
        r0.setBackgroundResource(2131249762);
    L5:
        ImageView r1 = this.g;
        if (r1 == null) goto L8;
        r1.clearColorFilter();
    L8:
        b(r3, r4);
        ProfileSkin r5 = r4.mProfileSkin;
        if (r5 == null) goto L12;
        g(r3, r5);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(b r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileAnchorSetButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileAnchorSetButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
