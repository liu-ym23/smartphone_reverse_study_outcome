package ut1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerPresenter$innerDrawerListener$1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public LiveDrawerLayout a;
    public View b;
    public View c;
    public Fragment d;
    public Fragment e;
    public Fragment f;
    public DouyinLoadingLayout g;
    public View h;
    public RelativeLayout i;
    public boolean j;
    public RelativeLayout k;
    public View l;
    public final LiveDrawerPresenter$innerDrawerListener$1 m;
    public final Context n;
    public final Activity o;
    public final FragmentManager p;
    public final DataCenter q;
    public final List<? extends DrawerLayout.DrawerListener> r;
    public final Bundle s;
    public final a t;

    public interface a {
        void H();

        boolean er();
    }

    public static final class b {
    }

    static {
    }

    public final Activity getActivity() {
        return this.o;
    }

    public final Context getContext() {
        return this.n;
    }

    public static float a(float r2) {
        if (PadConfigUtils.c() == true) goto L7;
        return 0.0f;
    L7:
        return (s1.G(s1.y()) - 358.0f) - r2;
    }

    public final void b(Fragment r4, Fragment r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.f == r5) goto L22;
        this.f = r5;
        FragmentTransaction r0 = this.p.beginTransaction();
        if (r5.isAdded() == true) goto L17;
        if (r4 == null) goto L13;
        if (r4.isAdded() == false) goto L13;
        r0.hide(r4);
    L13:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131381873) == true) goto L16;
        r0 = r0.add(2131381873, r5);
    L16:
        r0.commitAllowingStateLoss();
        goto L22
    L17:
        if (r4 != null) goto L19;
    L21:
        r0.show(r5).commitAllowingStateLoss();
        goto L22
    L19:
        if (r4.isAdded() == false) goto L21;
        r0.hide(r4);
    L22:
        Fragment r6 = this.e;
        if ((r6 instanceof pa1.a) == false) goto L32;
        if (r6 == null) goto L31;
        pa1.a r7 = (pa1.a) r6;
        if (this.f != r6) goto L28;
        boolean r8 = true;
    L29:
        r7.Bp(r8);
        return;
    L28:
        r8 = false;
        goto L29
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.search.api.ILiveSearchFragment");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.drawer.LiveDrawerPresenter$innerDrawerListener$1] */
    public k(Context r2, FragmentActivity r3, FragmentManager r4, a r5) {
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        Intrinsics.checkNotNullParameter(r5, "containerCallBack");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = r5;
        this.m = new LiveDrawerPresenter$innerDrawerListener$1(this);
    }
}
