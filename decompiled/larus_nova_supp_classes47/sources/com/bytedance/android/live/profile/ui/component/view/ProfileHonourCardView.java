package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.HonorWallUi;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.d;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.livesdk.utils.u5;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00018\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010 \u001a\u00020\u001b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020!8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/e;", "Lcom/bytedance/android/live/base/model/user/HonorWallUi$HonorWallBg;", "bgUi", "", "setBgUi", "", "getWallBgUiIndex", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "rootView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "c", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "container", "Lcom/bytedance/android/live/core/widget/HSImageView;", "d", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getImageIcon", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "imageIcon", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "getArrowIcon", "()Landroid/widget/ImageView;", "arrowIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileHonourCardView extends FrameLayout implements e<st0.e> {
    public final ViewGroup a;
    public final TextView b;
    public final FrameLayout c;
    public final HSImageView d;
    public final ImageView e;

    public ProfileHonourCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileHonourCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getWallBgUiIndex() {
        return 0;
    }

    public final ImageView getArrowIcon() {
        return this.e;
    }

    public final FrameLayout getContainer() {
        return this.c;
    }

    public final HSImageView getImageIcon() {
        return this.d;
    }

    @Override // android.view.View
    public final ViewGroup getRootView() {
        return this.a;
    }

    public final TextView getTitleView() {
        return this.b;
    }

    private final void setBgUi(HonorWallUi.HonorWallBg r6) {
        if (r6 == null) goto L12;
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setGradientType(1);
        r0.setCornerRadius(UtilityKotlinExtentionsKt.h(4));
        r0.setGradientRadius(UtilityKotlinExtentionsKt.h(80));
        r0.setGradientCenter(0.0f, 0.0f);
        int r3 = u5.a;
        if (TextUtils.isEmpty(r6.gradientStart) == false) goto L6;
    L8:
        int r1 = d.a;
        HSImageView r2 = this.d;
        k r7 = r6.icon;
        if (r2 == null) goto L13;
        r2.post(new com.bytedance.android.live.profile.ui.util.c(r2, r7));
        return;
    L13:
        return;
    L6:
        if (TextUtils.isEmpty(r6.gradientEnd) == true) goto L8;
        r0.setColors(new int[]{ColorProtector.parseColor(r6.gradientStart), ColorProtector.parseColor(r6.gradientEnd)});
        this.a.setBackground(r0);
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(st0.e r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    public void b(st0.e r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        HonorWallUi r4 = r3.honorWallUi;
        if (r4 != null) goto L5;
    L7:
        ImageView r5 = this.e;
        if (r2.c == false) goto L10;
        int r0 = 0;
    L11:
        r5.setVisibility(r0);
        this.b.setText(r2.b);
        return;
    L10:
        r0 = 4;
        goto L11
    L5:
        if ((!r4.bgs.isEmpty()) == false) goto L7;
        setBgUi((HonorWallUi.HonorWallBg) r4.bgs.get(Integer.valueOf(getWallBgUiIndex())));
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void c(st0.e r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void d(st0.e r1, ProfileSkin r2) {
        f(r1, r2);
    }

    public void f(st0.e r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 == null) goto L8;
        ProfileCustomSkin.HonorWallUI r5 = r4.honorWallSkin;
        if (r5 == null) goto L9;
        String r6 = r5.titleColor;
        String r7 = r5.contentColor;
        int r0 = m.a;
        m.e(this.b, r6);
        m.e(this.e, r6);
        m.e(this.c, r7);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(st0.e r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        e.a.update(this, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(st0.e r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileHonourCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567205, this, true);
        this.a = (ViewGroup) findViewById(2131380821);
        this.b = (TextView) findViewById(2131380819);
        this.c = (FrameLayout) findViewById(2131380817);
        this.d = findViewById(2131380818);
        this.e = (ImageView) findViewById(2131380820);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(st0.e r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfileHonourCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
