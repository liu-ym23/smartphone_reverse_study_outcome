package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.core.utils.c1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.e;
import tt0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileSubscribeVIPCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileSubscribeVIPCardView extends ProfileHonourCardView {
    public d f;

    public ProfileSubscribeVIPCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileSubscribeVIPCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 4;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        super.b(r3, r4);
        d r5 = new d(getContainer());
        this.f = r5;
        SubscribeInfo r6 = r4.subscribeInfo;
        int r0 = m.a;
        m.a(r5.b);
        if (r6 != null) goto L5;
        Pair r7 = c1.b(0);
    L10:
        TextView r1 = r5.b;
        if (r1 == null) goto L13;
        r1.setText(((String) r7.first).toString());
    L13:
        TextView r8 = r5.c;
        if (r8 == null) goto L30;
        Object[] r2 = new Object[1];
        String r9 = (String) r7.second;
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r2[0] = r9;
        r8.setText(s1.C(2131920685, r2));
        return;
    L30:
        return;
    L5:
        String r10 = r6.memberCountStr;
        if (r10 == null) goto L8;
    L20:
        if (r10 == null) goto L24;
        TextView r12 = r5.b;
        if (r12 == null) goto L24;
        r12.setText(r10);
    L24:
        String r13 = r6.memberCountSubStr;
        if (r13 == null) goto L32;
        TextView r14 = r5.c;
        if (r14 == null) goto L33;
        r14.setText(r13);
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (r6.memberCountSubStr != null) goto L20;
        r7 = c1.b(r6.memberCount);
        goto L10
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
        String r7 = r5.contentColor;
        int r0 = m.a;
        m.e(getTitleView(), r6);
        m.e(getArrowIcon(), r6);
        d r8 = this.f;
        if (r8 == null) goto L12;
        Intrinsics.checkNotNullParameter(r7, "color");
        m.e(r8.a, r7);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ProfileSubscribeVIPCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileSubscribeVIPCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
