package com.bytedance.android.live.profile.standard.tag.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.LiveAnchorRankHonor;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import jt0.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lt0.b;
import py.k;
import st0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profile/standard/tag/view/LiveLifeHonorView;", "Landroid/widget/FrameLayout;", "Ljt0/c;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/f;", "", "width", "", "setIconWidth", "Lcom/bytedance/android/live/base/model/user/ProfileTagContent;", "tagContent", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "Lcom/bytedance/android/live/profile/ui/base/h;", "profileContext", "Ljt0/b;", "tagItem", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLifeHonorView extends FrameLayout implements c, e<f> {
    public final TextView a;
    public final ImageView b;

    public static final class a {
    }

    static {
    }

    public LiveLifeHonorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveLifeHonorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setIconWidth(int r2) {
        ViewGroup.LayoutParams r0 = this.b.getLayoutParams();
        r0.width = r2;
        this.b.setLayoutParams(r0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    public final void g(NewProfileUser r6) {
        LiveAnchorRankHonor r7 = r6.liveAnchorRankHonor;
        if (r7 == null) goto L36;
        LiveAnchorRankHonor.a r8 = r7.getLiveLifeHonorInfo();
        if (r8 == null) goto L37;
        String r0 = r8.lifeLiveHonorTestIconUrl;
        boolean r1 = false;
        if (r0 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L17;
        k r4 = vh7.f.c(k.class);
        r4.setUrls(CollectionsKt.listOf(r0));
        ImageUtil.loadImage(this.b, r4, new b(this));
    L17:
        String r2 = r8.lifeLiveHonorRank;
        String r5 = "";
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        String r9 = r8.lifeLiveHonorDate;
        if (r9 == null) goto L24;
        r5 = r9;
    L24:
        StringBuilder r10 = new StringBuilder(r2);
        if (r2.length() != 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
    L34:
        r10.append(r5);
        this.a.setText(r10.toString());
        return;
    L30:
        if (r5.length() != 0) goto L32;
        r1 = true;
    L32:
        if (r1 == true) goto L34;
        r10.append("·");
        goto L34
    L27:
        r12 = false;
        goto L28
    L10:
        if (r0.length() == 0) goto L13;
        r3 = false;
        goto L14
    L37:
        return;
    }

    public static final /* synthetic */ void f(LiveLifeHonorView r0, int r1) {
        r0.setIconWidth(r1);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(f r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        g(r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(f r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(f r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        e.a.update(this, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(f r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public LiveLifeHonorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_LIVE_HONOR_TAG, r2, LayoutInflater.from(r2), this, true);
    L6:
        this.a = (TextView) findViewById(2131383272);
        this.b = (ImageView) findViewById(2131383266);
        return;
    L5:
        LayoutInflater.from(r2).inflate(2131567183, this, true);
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(f r2, NewProfileUser r3, ut0.f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ LiveLifeHonorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // jt0.c
    public final void b(ProfileTagContent r2, NewProfileUser r3, h r4, jt0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r5, "tagItem");
        g(r3);
    }

    @Override // jt0.c
    public void update(ProfileTagContent r2, NewProfileUser r3, h r4, jt0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "tagContent");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r5, "tagItem");
        g(r3);
    }
}
