package com.larus.profile.impl.mine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.profile.impl.databinding.LarusFragmentMineTabPageBinding;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s0 extends AppBarLayoutStateListener {
    public final /* synthetic */ PageMineTabFragment b;
    public final /* synthetic */ LarusFragmentMineTabPageBinding c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppBarLayoutStateListener.State.values().length];
            r0[AppBarLayoutStateListener.State.EXPANDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AppBarLayoutStateListener.State.COLLAPSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public s0(PageMineTabFragment r1, LarusFragmentMineTabPageBinding r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void a(AppBarLayout r4, AppBarLayoutStateListener.State r5, AppBarLayoutStateListener.State r6) {
        Intrinsics.checkNotNullParameter(r4, "appBarLayout");
        Intrinsics.checkNotNullParameter(r5, "lastState");
        Intrinsics.checkNotNullParameter(r6, "state");
        FLogger.a.i(this.b.j, "[onStateChange] state=" + r6);
        this.b.q = r6;
        MyInfoAdapter r7 = this.c.n.getAdapter();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larus.profile.impl.mine.MyInfoAdapter");
        MyInfoAdapter r8 = r7;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r6, "state");
        Iterator<ProfileInfoBaseFragment> r9 = r8.b.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r9.next().U90(r6);
        goto L4
    L6:
        int r10 = a.a[r6.ordinal()];
        if (r10 != 1) goto L9;
        this.c.m.V5(8);
        this.b.Y90(false, true);
        return;
    L9:
        if (r10 == 2) goto L11;
        this.c.m.V5(8);
        return;
    L11:
        final LarusFragmentMineTabPageBinding r11 = this.c;
        ConstraintLayout r12 = r11.m;
        final PageMineTabFragment r13 = this.b;
        r12.post(new r0(r11, r13));
    }
}
