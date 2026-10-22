package dt0;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bt0.b;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.SubscribeInfo;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.live.profile.ui.base.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends ct0.a {
    @Override // ct0.a, bt0.a
    public final b i() {
        return new et0.b();
    }

    public a() {
    }

    @Override // ct0.a, bt0.a
    public final void j(HonorWallElement r4) {
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        h r5 = this.a;
        boolean r0 = false;
        if (r5 != null) goto L5;
    L11:
        boolean r6 = false;
    L12:
        h r2 = this.a;
        if (r2 != null) goto L15;
    L16:
        h r3 = this.a;
        if (r3 != null) goto L19;
    L21:
        h r7 = this.a;
        if (r7 == null) goto L35;
        NewProfileUser r8 = r7.getTargetUser();
        if (r8 == null) goto L36;
        SubscribeInfo r9 = r8.subscribeInfo;
        if (r9 != null) goto L28;
        return;
    L28:
        if (r9.isMember != true) goto L38;
        if (r6 == true) goto L39;
        if (r0 == true) goto L40;
        h r10 = this.a;
        if (r10 == null) goto L41;
        r10.logSubscribeVIPCardShow();
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L36:
        return;
    L35:
        return;
    L19:
        if (i.l(r3) != true) goto L21;
        r0 = true;
        goto L21
    L15:
        if (i.k(r2) == true) goto L21;
    L5:
        if (i.k(r5) != true) goto L11;
        h r12 = this.a;
        if (r12 == null) goto L11;
        if (i.m(r12) != true) goto L11;
        r6 = true;
        goto L12
    }

    @Override // ct0.a, bt0.a
    public final void d(Fragment r2, View r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "honourCardView");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        FragmentActivity r7 = r2.getActivity();
        if (r7 == null) goto L14;
        SubscribeInfo r8 = r5.subscribeInfo;
        boolean r9 = false;
        if (r8 == null) goto L7;
        boolean r10 = r8.isMember;
    L8:
        if (r10 == true) goto L10;
    L12:
        r6.showFansClub(r7, "mini_card", r9);
        return;
    L10:
        if (i.l(r6) == true) goto L12;
        r9 = true;
        goto L12
    L7:
        r10 = false;
        goto L8
    }
}
