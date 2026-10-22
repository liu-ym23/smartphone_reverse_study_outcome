package it0;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends ct0.a {
    public a() {
    }

    @Override // ct0.a, bt0.a
    public final void d(Fragment r2, View r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "honourCardView");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        ct0.a.r(this, r4);
        FragmentActivity r7 = r2.getActivity();
        if (r7 == null) goto L6;
        r6.showSubscribePanel(r7, false);
        return;
    }
}
