package com.bytedance.android.livesdk.feed;

import android.os.SystemClock;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g0<T> implements Observer {
    public final /* synthetic */ h0 a;

    public g0(h0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        BaseFeedRepository.ApiDataStatus r10 = (BaseFeedRepository.ApiDataStatus) r9;
        if (r10 == null) goto L17;
        int r11 = i0.b[r10.ordinal()];
        if (r11 != 1) goto L8;
        h0 r12 = this.a;
        r12.b = SystemClock.elapsedRealtime();
        return;
    L8:
        if (r11 == 2) goto L11;
        return;
    L11:
        if (this.a.b <= 0) goto L13;
        long r0 = SystemClock.elapsedRealtime();
        h0 r13 = this.a;
        long r1 = r0 - r13.b;
        int r4 = v0.a;
        String r5 = r13.k;
        String r6 = r13.i;
        String r14 = r13.j;
        Intrinsics.checkNotNullParameter(r5, "drawerPage");
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r14, "enterMethod");
        HashMap r7 = new HashMap();
        r7.put("drawer_page", r5);
        r7.put("enter_from_merge", r6);
        r7.put("enter_method", r14);
        r7.put("duration", String.valueOf(r1));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_pull_down_load_duration", r7, new Object[0]);
    L13:
        this.a.b = 0;
        return;
    }
}
