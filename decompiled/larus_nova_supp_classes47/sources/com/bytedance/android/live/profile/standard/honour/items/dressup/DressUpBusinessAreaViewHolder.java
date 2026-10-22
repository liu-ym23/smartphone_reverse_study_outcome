package com.bytedance.android.live.profile.standard.honour.items.dressup;

import android.view.View;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DressUpBusinessAreaViewHolder extends ct0.b implements b {
    public static final /* synthetic */ int e = 0;
    public boolean c;
    public final Lazy d;

    public DressUpBusinessAreaViewHolder() {
        this.d = LazyKt.lazy(new DressUpBusinessAreaViewHolder$imageView$2(this));
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public final void setDressIconAlpha(float r2) {
        if (this.c == false) goto L5;
        return;
    L5:
        View r0 = (View) this.d.getValue();
        if (r0 == null) goto L9;
        r0.setAlpha(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.standard.honour.items.dressup.b
    public final void setDressIconScale(float r2) {
        if (this.c == false) goto L5;
        return;
    L5:
        View r0 = (View) this.d.getValue();
        if (r0 == null) goto L8;
        r0.setScaleX(r2);
    L8:
        View r1 = (View) this.d.getValue();
        if (r1 == null) goto L12;
        r1.setScaleY(r2);
        return;
    }

    @Override // ct0.b, bt0.b
    public final void h(ProfileText r2, HonorWallElement r3, NewProfileUser r4, h r5) {
        Intrinsics.checkNotNullParameter(r3, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "profileUser");
        Intrinsics.checkNotNullParameter(r5, "profileContext");
        super.h(r2, r3, r4, r5);
        DressSuitInfo r6 = r4.getDressSuitInfo();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.getScene() != 1) goto L9;
        this.c = true;
        return;
    }
}
