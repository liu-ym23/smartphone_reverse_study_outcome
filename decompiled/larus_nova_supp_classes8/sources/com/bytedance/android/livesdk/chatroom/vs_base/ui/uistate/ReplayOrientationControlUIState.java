package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayOrientationControlUIState extends ir1.c {
    @Override // ir1.c
    public final void n() {
    }

    public ReplayOrientationControlUIState() {
    }

    public final void o(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = fr1.a.a;
        if (l() == false) goto L5;
        int r2 = 1;
    L6:
        Intrinsics.checkNotNullParameter(r3, "context");
        VideoContext r0 = VideoContext.n0(r3);
        if (r0 == null) goto L9;
        r0.H0(r2);
    L9:
        fr1.a.b(b(), r3, l());
        return;
    L5:
        r2 = e5.a();
        goto L6
    }

    public static void p(Context r1, Boolean r2, DataCenter r3, final Function1 r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 != null) goto L5;
        r2 = Boolean.valueOf(!VideoContext.n0(r1).s0());
    L5:
        int r5 = fr1.a.a;
        fr1.a.a(!r2.booleanValue() ? 1 : 0, 1);
        if (r4 == null) goto L17;
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r6 = ReplayDataContext.a.b(r3);
        if (r6 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.isPortrait();
        if (r7 == null) goto L19;
        Observable r8 = r7.a();
        if (r8 == null) goto L20;
        Observable r9 = r8.take(1);
        if (r9 == null) goto L21;
        RxUtilKt.n(r9, new ReplayOrientationControlUIState$onUserClick$1(r4));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
