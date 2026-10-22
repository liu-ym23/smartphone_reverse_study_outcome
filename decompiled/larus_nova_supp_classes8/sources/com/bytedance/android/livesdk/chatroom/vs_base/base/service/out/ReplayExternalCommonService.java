package com.bytedance.android.livesdk.chatroom.vs_base.base.service.out;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import h80.d;
import jm1.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import mq1.g;
import nm1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ReplayExternalCommonService implements o, e {
    public final Lazy a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public ReplayExternalCommonService() {
        this.a = LazyKt.lazy(ReplayExternalCommonService$commonService$2.INSTANCE);
    }

    public final lm1.a c() {
        mq1.c r0 = q.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final ReplayDataContext d(DataCenter r1) {
        return h(r1);
    }

    public final boolean f(DataCenter r2) {
        if (r2 == null) goto L6;
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.b(r2) != null) goto L8;
    L9:
        return false;
    L8:
        return true;
    L6:
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.a() == null) goto L9;
        goto L8
    }

    public final d<Pair<Fragment, FragmentManager>> g(DataCenter r2) {
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r3 = ReplayDataContext.a.b(r2);
        if (r3 == null) goto L7;
        n<d<Pair<Fragment, FragmentManager>>> r4 = r3.getInteractionFragmentInfoGetter();
        if (r4 == null) goto L7;
        return (d) r4.getValue();
    L7:
        return null;
    }

    public final ReplayDataContext h(DataCenter r2) {
        if (r2 != null) goto L5;
        ReplayDataContext.Companion.getClass();
        return ReplayDataContext.a.a();
    L5:
        ReplayDataContext.Companion.getClass();
        return ReplayDataContext.a.b(r2);
    }

    public final f a(long r2, Bundle r4) {
        g r0 = (g) this.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2, r4);
    }
}
