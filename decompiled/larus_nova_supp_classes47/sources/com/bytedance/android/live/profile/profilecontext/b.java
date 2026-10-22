package com.bytedance.android.live.profile.profilecontext;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.ui.base.m;
import com.bytedance.android.live.profile.ui.base.n;
import com.bytedance.android.live.profile.ui.base.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements m {
    public final View a;

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final int e() {
        View r0 = this.a;
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131380784);
        if (r1 == null) goto L7;
        return r1.getHeight();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer b() {
        ProfileNestedScrollView r0 = (ProfileNestedScrollView) f(2131380828);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getScrolledHeight());
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer c() {
        ProfileNestedScrollView r0 = (ProfileNestedScrollView) f(2131380828);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getMaxScrollHeight());
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void a(ProfileNestedScrollView.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ProfileNestedScrollView r1 = (ProfileNestedScrollView) f(2131380828);
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "listener");
        List<ProfileNestedScrollView.b> r0 = r1.b;
        if (r0 == null) goto L9;
        ((ArrayList) r0).remove(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void d(ProfileNestedScrollView.b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ProfileNestedScrollView r1 = (ProfileNestedScrollView) f(2131380828);
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.b != null) goto L7;
        r1.b = new ArrayList();
    L7:
        List<ProfileNestedScrollView.b> r0 = r1.b;
        if (r0 == null) goto L12;
        ((ArrayList) r0).add(r3);
        return;
    L12:
        return;
    }

    public final <T extends View> T f(int r2) {
        View r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findViewById(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final n findView(int r2) {
        View r3 = f(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new o(r3);
    }

    public b(Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        this.a = r3;
    }
}
