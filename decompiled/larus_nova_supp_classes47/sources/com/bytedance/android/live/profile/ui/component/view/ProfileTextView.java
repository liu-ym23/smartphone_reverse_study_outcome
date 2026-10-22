package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import st0.g;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileTextView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/g;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "", "c", "Z", "getCanClick", "()Z", "setCanClick", "(Z)V", "canClick", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileTextView extends FrameLayout implements e<g> {
    public final TextView a;
    public int b;
    public boolean c;

    public ProfileTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getCanClick() {
        return this.c;
    }

    public final TextView getTextView() {
        return this.a;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        if (this.c == true) goto L6;
        setOnClickListener(null);
        setClickable(false);
        return;
    }

    public final void setCanClick(boolean r1) {
        this.c = r1;
    }

    public static void g(SpannableStringBuilder r6, String r7) {
        int r8 = StringsKt.indexOf$default(r6, r7, 0, false, 6, null);
        if (r8 > 0) goto L5;
        return;
    L5:
        r6.setSpan(new AbsoluteSizeSpan(s1.f(8.0f)), r8 - 1, r8, 33);
    }

    public final void b(g r6, NewProfileUser r7) {
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r7, "user");
        this.b = r6.getType();
        boolean r0 = false;
        if (r6.getType() != 2) goto L5;
    L10:
        this.a.setTextSize(2, 13.0f);
        this.a.setTextColor(getResources().getColor(2131107930));
    L12:
        if (r6.b.length() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == false) goto L17;
        SpannableStringBuilder r8 = new SpannableStringBuilder(r6.b);
        g(r8, s1.B(2131919752));
        g(r8, s1.B(2131919751));
        g(r8, s1.B(2131920688));
        this.a.setText(r8);
        return;
    L17:
        return;
    L5:
        if (r6.getType() == 3) goto L10;
        if (r6.getType() != 4) goto L12;
        this.a.setTextSize(2, 13.0f);
        this.a.setTextColor(getResources().getColor(2131107930));
        this.a.setSingleLine(false);
        this.a.setMaxLines(10);
        goto L12
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(g r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(g r1, ProfileSkin r2) {
        f(r1, r2);
    }

    public final void f(g r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        ProfileCustomSkin r4 = r3.skin;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.b != 0) goto L7;
        String r5 = r4.followInfoColor;
    L8:
        int r6 = m.a;
        m.e(this.a, r5);
        return;
    L7:
        r5 = r4.signatureColor;
        goto L8
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(g r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        e.a.update(this, r3, r4);
        this.a.setTextColor(s1.h(2131107936));
        b(r3, r4);
        ProfileSkin r5 = r4.mProfileSkin;
        if (r5 == null) goto L6;
        f(r3, r5);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(g r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = 2;
        this.c = true;
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_TEXT_INFO, r2, LayoutInflater.from(r2), this, true);
    L6:
        this.a = (TextView) findViewById(2131380779);
        return;
    L5:
        LayoutInflater.from(r2).inflate(2131567212, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(g r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfileTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
