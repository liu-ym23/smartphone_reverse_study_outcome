package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.standard.honour.items.dressup.b;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileDressUpCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "Lcom/bytedance/android/live/profile/standard/honour/items/dressup/b;", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "setIgnoreIconAnim", "", "getWallBgUiIndex", "", "scale", "setDressIconScale", "alpha", "setDressIconAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileDressUpCardView extends ProfileHonourCardView implements b {
    public final HSImageView f;
    public boolean g;

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 5;
    }

    private final void setIgnoreIconAnim(NewProfileUser r5) {
        DressSuitInfo r6 = r5.getDressSuitInfo();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getScene() != 1) goto L9;
        this.g = true;
        return;
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconAlpha(float r2) {
        if (this.g == false) goto L5;
        return;
    L5:
        this.f.setAlpha(r2);
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public void setDressIconScale(float r2) {
        if (this.g == false) goto L5;
        return;
    L5:
        this.f.setScaleX(r2);
        this.f.setScaleY(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        super.b(r4, r5);
        setIgnoreIconAnim(r5);
        DressSuitInfo r6 = r5.getDressSuitInfo();
        if (r6 == null) goto L5;
        k r7 = r6.getBadge();
    L6:
        if (r7 == null) goto L13;
        List r8 = r7.getUrls();
        if (r8 != null) goto L10;
        return;
    L10:
        if ((!r8.isEmpty()) != true) goto L15;
        int r9 = s1.f(r7.getWidth());
        int r0 = s1.f(r7.getHeight());
        HSImageView r1 = this.f;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.width = r9;
        r2.height = r0;
        Unit r10 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        ImageLoader.bindImage(this.f, r7);
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(e r1, NewProfileUser r2) {
        b(r1, r2);
    }

    public ProfileDressUpCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = new HSImageView(r2);
        this.f = r5;
        setId(2131389677);
        FrameLayout r6 = getContainer();
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.topMargin = UtilityKotlinExtentionsKt.i(3);
        Unit r0 = Unit.INSTANCE;
        r6.addView(r5, r7);
    }
}
