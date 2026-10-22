package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayAdaptiveDialogUIState extends ir1.c {
    public Function0<Integer> c;

    public ReplayAdaptiveDialogUIState() {
        this.c = ReplayAdaptiveDialogUIState$shadowPlayerBottomWidgetHeight$1.INSTANCE;
    }

    public static /* synthetic */ int q(ReplayAdaptiveDialogUIState r1) {
        return r1.p((Integer) r1.c.invoke());
    }

    public final void o(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (h() == true) goto L5;
        return;
    L5:
        if (d() == false) goto L9;
        MatchRoomLandScapeAnimUtil.E.j(r2);
        return;
    }

    public final int p(Integer r5) {
        if (l() == false) goto L11;
        if (PadConfigUtils.c() == false) goto L7;
        float r6 = 618.0f;
    L9:
        return (int) r6;
    L7:
        r6 = 494.0f;
        goto L9
    L11:
        if (d() == true) goto L13;
        if (r5 == null) goto L16;
        int r7 = r5.intValue();
    L18:
        if (k() == false) goto L23;
        if (g() == false) goto L23;
        r7 = r7 - (com.bytedance.android.livesdk.chatroom.vs_base.util.o.b * 2);
    L25:
        int r8 = ((int) s1.G(r7)) + 1;
        if (r8 > 700) goto L28;
        return r8;
    L28:
        if (k() == true) goto L33;
        return 700;
    L33:
        return 700 - ((int) UtilityKotlinExtentionsKt.d(com.bytedance.android.livesdk.chatroom.vs_base.util.o.b));
    L23:
        if (j() == false) goto L25;
        r7 = com.bytedance.android.livesdk.chatroom.vs_base.util.o.c;
        goto L25
    L16:
        int r9 = t.a;
        r7 = (int) (((double) s1.l().heightPixels) * 0.7d);
        goto L18
    L13:
        return (int) UtilityKotlinExtentionsKt.d(t.j());
    }

    public final void r(View r3) {
        Intrinsics.checkNotNullParameter(r3, "contentView");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        r0.height = UtilityKotlinExtentionsKt.c(q(this));
        if (g() == false) goto L6;
        return;
    L6:
        if (k() == false) goto L9;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = t.j();
        return;
    }

    public final int t(Context r3) {
        d0 r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L5:
        boolean r4 = ReplayStatusBarUIState.q((FragmentActivity) r3, ((ReplayStatusBarUIState) r0.c(ReplayStatusBarUIState.class)).d());
        if (i() == false) goto L16;
        if (r4 == false) goto L13;
        if (g() == false) goto L11;
        return 2131954842;
    L11:
        return 2131954843;
    L13:
        if (g() == false) goto L15;
        return 2131954841;
    L15:
        return 2131954838;
    L16:
        if (r4 == false) goto L18;
        return 2131954840;
    L18:
        return 2131954839;
    }

    public final void s(Dialog r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        d0 r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L5:
        b r1 = (b) r0.c(b.class);
        r1.r(r3);
        r3.setOnShowListener(new a(r3, r1));
        if (r4 == null) goto L8;
        r(r4);
    L8:
        Window r5 = r3.getWindow();
        if (r5 == null) goto L18;
        View r6 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L15;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L15:
        if (r6 == null) goto L19;
        r6.invalidate();
        return;
    L19:
        return;
    }
}
