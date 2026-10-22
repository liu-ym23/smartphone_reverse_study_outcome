package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ActivityBadges;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.c;
import com.bytedance.android.live.profile.ui.util.d;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.utils.u5;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import st0.a;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileHonourActivityBadgeView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/a;", "Lpy/k;", "imageModel", "", "setBadgeIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileHonourActivityBadgeView extends FrameLayout implements e<a> {
    public final ViewGroup a;
    public final TextView b;
    public final HSImageView c;
    public final HSImageView d;
    public final ImageView e;

    public ProfileHonourActivityBadgeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileHonourActivityBadgeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setBadgeIcon(k r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List r0 = r5.getUrls();
        if (r0 != null) goto L7;
        return;
    L7:
        if ((!r0.isEmpty()) != true) goto L11;
        int r1 = s1.f(r5.getWidth());
        int r2 = s1.f(r5.getHeight());
        HSImageView r3 = this.c;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = r1;
        r4.height = r2;
        Unit r6 = Unit.INSTANCE;
        r3.setLayoutParams(r4);
        ImageLoader.bindImage(this.c, r5);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(a r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(a r6, NewProfileUser r7) {
        a r8 = r6;
        Intrinsics.checkNotNullParameter(r8, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r7, "user");
        ActivityBadges.NewProfileBadge r9 = r8.d;
        this.b.setText(r9.name);
        ActivityBadges.GradientColor r10 = r9.bgColor;
        k r0 = r9.rightIcon;
        int r1 = d.a;
        HSImageView r2 = this.d;
        if (r2 == null) goto L5;
        r2.post(new c(r2, r0));
    L5:
        if (r10 == null) goto L11;
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setGradientType(1);
        r3.setCornerRadius(UtilityKotlinExtentionsKt.h(4));
        r3.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r3.setGradientCenter(0.0f, 0.0f);
        int r4 = u5.a;
        if (TextUtils.isEmpty(r10.from) == true) goto L11;
        if (TextUtils.isEmpty(r10.to) == true) goto L11;
        r3.setColors(new int[]{ColorProtector.parseColor(r10.from), ColorProtector.parseColor(r10.to)});
        this.a.setBackground(r3);
    L11:
        setBadgeIcon(r9.image);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(a r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L8;
        ProfileCustomSkin.HonorWallUI r5 = r4.honorWallSkin;
        if (r5 == null) goto L9;
        String r6 = r5.titleColor;
        int r7 = m.a;
        m.e(this.b, r6);
        m.e(this.e, r6);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(a r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        e.a.update(this, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(a r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileHonourActivityBadgeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567203, this, true);
        this.a = (ViewGroup) findViewById(2131380821);
        this.b = (TextView) findViewById(2131380819);
        this.c = findViewById(2131380816);
        this.d = findViewById(2131380818);
        this.e = (ImageView) findViewById(2131380820);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(a r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfileHonourActivityBadgeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
