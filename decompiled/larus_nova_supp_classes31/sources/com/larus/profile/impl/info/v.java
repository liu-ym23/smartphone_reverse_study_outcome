package com.larus.profile.impl.info;

import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.profile.impl.databinding.LarusPageTabProfileInfoBinding;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v extends AppBarLayoutStateListener {
    public final /* synthetic */ ProfileInfoFragment b;
    public final /* synthetic */ LarusPageTabProfileInfoBinding c;

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

    public v(ProfileInfoFragment r1, LarusPageTabProfileInfoBinding r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void a(AppBarLayout r3, AppBarLayoutStateListener.State r4, AppBarLayoutStateListener.State r5) {
        Intrinsics.checkNotNullParameter(r3, "appBarLayout");
        Intrinsics.checkNotNullParameter(r4, "lastState");
        Intrinsics.checkNotNullParameter(r5, "state");
        FLogger.a.i(this.b.m, "[onStateChange] state=" + r5);
        this.b.j = r5;
        int r6 = a.a[r5.ordinal()];
        String r1 = "";
        if (r6 != 1) goto L5;
        this.c.h.setText("");
        this.c.h.setVisibility(8);
        this.b.V90(false, true);
        return;
    L5:
        if (r6 == 2) goto L7;
        this.c.h.setText("");
        this.c.h.setVisibility(8);
        return;
    L7:
        this.c.h.setVisibility(0);
        AppCompatTextView r7 = this.c.h;
        r38.b r8 = this.b.n;
        if (r8 == null) goto L12;
        String r9 = r8.d();
        if (r9 == null) goto L12;
        r1 = r9;
    L12:
        r7.setText(r1);
    }
}
