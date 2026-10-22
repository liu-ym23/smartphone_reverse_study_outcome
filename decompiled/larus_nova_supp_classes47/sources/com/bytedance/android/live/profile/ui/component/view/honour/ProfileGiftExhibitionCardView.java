package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.e;
import tt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileGiftExhibitionCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileGiftExhibitionCardView extends ProfileHonourCardView {
    public c f;

    public ProfileGiftExhibitionCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileGiftExhibitionCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        super.b(r4, r5);
        GiftExhibitionHomeStats r6 = r5.giftExhibitionInfo;
        if (r6 == null) goto L19;
        c r7 = new c(getContainer());
        Intrinsics.checkNotNullParameter(r6, "exhibitionInfo");
        int r0 = r6.lightedNum;
        int r8 = r6.unlightedNum + r0;
        int r1 = m.a;
        m.a(r7.a);
        m.a(r7.c);
        TextView r2 = r7.a;
        if (r2 == null) goto L7;
        r2.setText(String.valueOf(r0));
    L7:
        TextView r3 = r7.c;
        if (r3 == null) goto L10;
        r3.setText(String.valueOf(r8));
    L10:
        ImageView r9 = r7.d;
        if (r9 == null) goto L17;
        if (r0 != r8) goto L15;
        if (r0 == 0) goto L15;
        int r10 = 0;
    L16:
        r9.setVisibility(r10);
    L15:
        r10 = 4;
    L17:
        this.f = r7;
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(e r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(e r1, ProfileSkin r2) {
        f(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void f(e r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L10;
        ProfileCustomSkin.HonorWallUI r5 = r4.honorWallSkin;
        if (r5 == null) goto L11;
        String r6 = r5.titleColor;
        int r0 = m.a;
        m.e(getTitleView(), r6);
        m.e(getArrowIcon(), r6);
        c r7 = this.f;
        if (r7 == null) goto L12;
        String r8 = r5.contentColor;
        m.e(r7.a, r8);
        m.e(r7.b, r8);
        m.e(r7.c, r8);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ProfileGiftExhibitionCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileGiftExhibitionCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
