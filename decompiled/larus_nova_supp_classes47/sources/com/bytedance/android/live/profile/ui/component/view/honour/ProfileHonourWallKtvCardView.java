package com.bytedance.android.live.profile.ui.component.view.honour;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileHighScoreSong;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import st0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/honour/ProfileHonourWallKtvCardView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileHonourCardView;", "", "getWallBgUiIndex", "Landroid/view/View;", "f", "Landroid/view/View;", "getTextLayout", "()Landroid/view/View;", "setTextLayout", "(Landroid/view/View;)V", "textLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileHonourWallKtvCardView extends ProfileHonourCardView {
    public View f;

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public int getWallBgUiIndex() {
        return 8;
    }

    public final View getTextLayout() {
        return this.f;
    }

    public final void setTextLayout(View r1) {
        this.f = r1;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileHonourCardView
    public final void b(e r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        super.b(r4, r5);
        View r6 = this.f;
        String r0 = null;
        if (r6 == null) goto L5;
        TextView r7 = (TextView) r6.findViewById(2131367794);
    L6:
        View r1 = this.f;
        if (r1 == null) goto L9;
        TextView r2 = (TextView) r1.findViewById(2131387527);
    L10:
        m.a(r7);
        if (r7 == null) goto L17;
        ProfileHighScoreSong r3 = r5.highScoreSong;
        if (r3 == null) goto L15;
        String r8 = r3.getCountStr();
    L16:
        r7.setText(r8);
        goto L17
    L15:
        r8 = null;
    L17:
        if (r2 == null) goto L23;
        ProfileHighScoreSong r9 = r5.highScoreSong;
        if (r9 == null) goto L21;
        r0 = r9.getCountSubStr();
    L21:
        r2.setText(r0);
        return;
    L23:
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
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
        super.f(r2, r3);
    }

    public ProfileHonourWallKtvCardView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = LayoutInflater.from(getContainer().getContext()).inflate(2131567206, getContainer(), true);
    }
}
