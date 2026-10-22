package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileLevelCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileLevelCardView extends ProfileHonourCardView {
    public final HSImageView f;

    public ProfileLevelCardView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileLevelCardView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 1;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        super.b(r4, r5);
        k r6 = r5.grade;
        if (r6 == null) goto L10;
        List r7 = r6.getUrls();
        if (r7 != null) goto L7;
        return;
    L7:
        if ((!r7.isEmpty()) != true) goto L12;
        int r8 = s1.f(r6.getWidth());
        int r0 = s1.f(r6.getHeight());
        HSImageView r1 = this.f;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.width = r8;
        r2.height = r0;
        Unit r9 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        ImageLoader.bindImage(this.f, r6);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(e r1, NewProfileUser r2) {
        b(r1, r2);
    }

    public ProfileLevelCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = new HSImageView(r2);
        this.f = r5;
        FrameLayout r6 = getContainer();
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.topMargin = UtilityKotlinExtentionsKt.i(3);
        Unit r0 = Unit.INSTANCE;
        r6.addView(r5, r7);
    }

    public /* synthetic */ ProfileLevelCardView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
