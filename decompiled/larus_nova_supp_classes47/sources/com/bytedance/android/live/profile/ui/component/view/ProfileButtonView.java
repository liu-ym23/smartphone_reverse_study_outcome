package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR\"\u0010\u0016\u001a\u00020\u000f8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "", "text", "setText", "", "id", "setTextResId", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "setContentView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileButtonView extends FrameLayout implements e<st0.b> {
    public static final /* synthetic */ int e = 0;
    public ViewGroup a;
    public ImageView b;
    public ImageView c;
    public TextView d;

    public ProfileButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ViewGroup getContentView() {
        ViewGroup r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void e(st0.b r1) {
        i(r1);
    }

    public void f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_BUTTON, r4, LayoutInflater.from(r4), this, true);
    L6:
        this.a = (ViewGroup) findViewById(2131380778);
        this.b = (ImageView) findViewById(2131380775);
        this.c = (ImageView) findViewById(2131380777);
        this.d = (TextView) findViewById(2131380779);
        return;
    L5:
        LayoutInflater.from(r4).inflate(2131567198, this, true);
        goto L6
    }

    public void i(st0.b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r2, "$this$getDefaultContentDescription");
        switch(r2.getType()) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L20;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L20;
            case 13: goto L20;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L5;
            default: goto L20;
        };
    L5:
        String r3 = s1.B(2131921746);
    L21:
        if (r3 == null) goto L24;
        setContentDescription(r3);
        return;
    L24:
        return;
    L6:
        r3 = s1.B(2131921744);
        goto L21
    L7:
        r3 = s1.B(2131921743);
        goto L21
    L8:
        r3 = s1.B(2131921740);
        goto L21
    L9:
        r3 = s1.B(2131921739);
        goto L21
    L10:
        r3 = s1.B(2131921741);
        goto L21
    L11:
        r3 = s1.B(2131921747);
        goto L21
    L12:
        r3 = s1.B(2131921745);
        goto L21
    L13:
        r3 = s1.B(2131921750);
        goto L21
    L14:
        r3 = s1.B(2131921749);
        goto L21
    L15:
        r3 = s1.B(2131921748);
        goto L21
    L16:
        r3 = s1.B(2131921751);
        goto L21
    L17:
        r3 = s1.B(2131921738);
        goto L21
    L18:
        r3 = s1.B(2131921742);
        goto L21
    L19:
        r3 = s1.B(2131921745);
        goto L21
    L20:
        r3 = null;
        goto L21
    }

    public final void setContentView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L15;
        TextView r1 = this.d;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L11:
        r1.setText(r3);
        TextView r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L14:
        UtilityKotlinExtentionsKt.w(r4);
        return;
    L15:
        TextView r5 = this.d;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L18:
        UtilityKotlinExtentionsKt.t(r5);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setTextResId(int r2) {
        setText(getResources().getString(r2));
    }

    public void b(st0.b r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        if (r4.getType() != (-1)) goto L10;
        ViewGroup r6 = this.a;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L7:
        UtilityKotlinExtentionsKt.u(r6);
        return;
    L10:
        if (r4.f == false) goto L18;
        ImageView r7 = this.b;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L14:
        a1.p(r7, UtilityKotlinExtentionsKt.i(24));
        ImageView r8 = this.b;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L17:
        a1.k(r8, UtilityKotlinExtentionsKt.i(24));
    L18:
        j(Integer.valueOf(r4.d), Integer.valueOf(r4.e));
        setText(r4.b);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void c(st0.b r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void d(st0.b r1, ProfileSkin r2) {
        g(r1, r2);
    }

    public void g(st0.b r4, ProfileSkin r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "skin");
        ProfileCustomSkin r6 = r5.skin;
        if (r6 == null) goto L17;
        ProfileCustomSkin.SecondaryButtonUI r7 = r6.secondaryButtonSkin;
        if (r7 == null) goto L18;
        String r8 = r7.iconColor;
        String r0 = r7.borderColor;
        String r9 = r7.backgroundColor;
        int r1 = m.a;
        ViewGroup r2 = this.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L9:
        m.f(r2, r9);
        ViewGroup r10 = this.a;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L12:
        m.c(r10, r0);
        ViewGroup r12 = this.a;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L15:
        m.e(r12, r8);
        return;
    L18:
        return;
    }

    public final void j(Integer r4, Integer r5) {
        if (r4 == null) goto L17;
        r4.intValue();
        if (r4.intValue() == (-1)) goto L13;
        ImageView r1 = this.b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L9:
        r1.setImageResource(r4.intValue());
        ImageView r6 = this.b;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L12:
        UtilityKotlinExtentionsKt.w(r6);
        goto L17
    L13:
        ImageView r7 = this.b;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L16:
        UtilityKotlinExtentionsKt.t(r7);
    L17:
        if (r5 == null) goto L32;
        r5.intValue();
        if (r5.intValue() == (-1)) goto L27;
        ImageView r8 = this.c;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rightImage");
    L23:
        r8.setImageResource(r5.intValue());
        ImageView r9 = this.c;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rightImage");
    L26:
        UtilityKotlinExtentionsKt.w(r9);
        return;
    L27:
        ImageView r10 = this.c;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rightImage");
    L30:
        UtilityKotlinExtentionsKt.t(r10);
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(st0.b r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        e.a.update(this, r3, r4);
        ViewGroup r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
    L5:
        r0.setBackgroundResource(2131249762);
        ImageView r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("leftImage");
    L8:
        r1.clearColorFilter();
        ImageView r2 = this.c;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rightImage");
    L11:
        r2.clearColorFilter();
        TextView r5 = this.d;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L14:
        r5.setTextColor(s1.h(2131107936));
        b(r3, r4);
        ProfileSkin r6 = r4.mProfileSkin;
        if (r6 == null) goto L18;
        g(r3, r6);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(st0.b r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        f(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void a(st0.b r1, NewProfileUser r2, f r3) {
        h(r1, r2, r3);
    }

    public void h(st0.b r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfileButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
