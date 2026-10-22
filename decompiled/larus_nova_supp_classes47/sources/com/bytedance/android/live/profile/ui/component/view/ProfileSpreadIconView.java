package com.bytedance.android.live.profile.ui.component.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.ui.component.base.e;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import st0.g;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/ProfileSpreadIconView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profile/ui/component/base/e;", "Lst0/g;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileSpreadIconView extends FrameLayout implements e<g> {
    public final ImageView a;

    public static final class a {
    }

    static {
    }

    public ProfileSpreadIconView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileSpreadIconView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void c(g r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void d(g r4, ProfileSkin r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "skin");
        ProfileCustomSkin r6 = r5.skin;
        if (r6 == null) goto L13;
        int r7 = Color.parseColor(r6.followInfoColor);     // Catch: Exception -> L8
        ImageView r8 = this.a;     // Catch: Exception -> L8
        if (r8 == null) goto L14;
        r8.setColorFilter(Color.argb(51, Color.red(r7), Color.green(r7), Color.blue(r7)));     // Catch: Exception -> L8
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        ALogger.e("ProfileSpreadIconView", "loadSkin error: " + e.getMessage());
        Unit r10 = Unit.INSTANCE;
        return;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(g r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        e.a.update(this, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(g r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileSpreadIconView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567188, this, true);
        this.a = (ImageView) findViewById(2131380568);
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.e
    public final void a(g r2, NewProfileUser r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "logUseCase");
        e.a.a(r3, r4);
    }

    public /* synthetic */ ProfileSpreadIconView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
