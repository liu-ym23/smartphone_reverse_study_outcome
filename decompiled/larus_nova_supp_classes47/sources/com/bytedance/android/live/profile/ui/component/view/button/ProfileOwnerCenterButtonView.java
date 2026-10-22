package com.bytedance.android.live.profile.ui.component.view.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/button/ProfileOwnerCenterButtonView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "Lst0/b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileOwnerCenterButtonView extends ProfileButtonView {
    public TextView f;

    public ProfileOwnerCenterButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileOwnerCenterButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void b(b r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_OWNER_CENTER_BUTTON, r4, LayoutInflater.from(r4), this, true);
    L6:
        setContentView((ViewGroup) findViewById(2131380841));
        this.f = (TextView) findViewById(2131380842);
        return;
    L5:
        LayoutInflater.from(r4).inflate(2131567209, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(b r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(b r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        getContentView().setBackgroundResource(2131249762);
        TextView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("text");
    L5:
        r0.setTextColor(s1.h(2131107936));
        ImageView r1 = (ImageView) findViewById(2131380840);
        if (r1 == null) goto L8;
        r1.clearColorFilter();
    L8:
        ProfileSkin r5 = r4.mProfileSkin;
        if (r5 == null) goto L12;
        g(r3, r5);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(b r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileOwnerCenterButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileOwnerCenterButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
