package com.bytedance.android.livesdk.feed;

import android.os.SystemClock;
import com.bytedance.android.livesdk.feed.repository.BaseFeedRepository;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ h0 a;

    public f0(h0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r21) {
        BaseFeedRepository.ApiDataStatus r1 = (BaseFeedRepository.ApiDataStatus) r21;
        if (r1 == null) goto L52;
        int r2 = i0.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        h0 r3 = this.a;
        r3.a = SystemClock.elapsedRealtime();
        h0 r4 = this.a;
        long r5 = r4.a;
        r4.f = r5 - h0.m;
        long r6 = h0.p;
        if (r6 <= 0) goto L51;
        r4.f = r5 - r6;
        return;
    L51:
        return;
    L8:
        if (r2 != 2) goto L53;
        h0 r7 = this.a;
        if (r7.a > 0) goto L13;
    L45:
        this.a.d = true;
        return;
    L13:
        if (r7.d == true) goto L31;
        int r8 = h0.l;
        if (r8 == 4) goto L17;
        String r18 = "click";
        String r19 = "actionType";
        if (r8 == 5) goto L25;
        if (r8 == 6) goto L25;
    L32:
        h0 r9 = this.a;
        int r10 = r9.e;
        int r11 = h0.l;
        if (r10 == 3) goto L37;
        if (r10 == 1) goto L37;
    L44:
        h0 r12 = this.a;
        long r13 = SystemClock.elapsedRealtime();
        h0 r14 = this.a;
        r12.g = r13 - r14.a;
        r14.h = SystemClock.elapsedRealtime();
    L37:
        if (r9.a <= 0) goto L43;
        long r15 = SystemClock.elapsedRealtime();
        h0 r16 = this.a;
        long r17 = r15 - r16.a;
        int r20 = v0.a;
        String r22 = r16.k;
        String r23 = r16.i;
        String r110 = r16.j;
        if (r16.e != 3) goto L41;
        String r24 = r18;
    L42:
        Intrinsics.checkNotNullParameter(r22, "drawerPage");
        Intrinsics.checkNotNullParameter(r23, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r110, "enterMethod");
        Intrinsics.checkNotNullParameter(r24, r19);
        HashMap r25 = new HashMap();
        r25.put("drawer_page", r22);
        r25.put("enter_from_merge", r23);
        r25.put("enter_method", r110);
        r25.put("duration", String.valueOf(r17));
        r25.put("action_type", r24);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_tab_load_duration", r25, new Object[0]);
        goto L43
    L41:
        r24 = "pull";
    L43:
        this.a.a = 0;
    L25:
        if (h0.p <= 0) goto L32;
        long r26 = SystemClock.elapsedRealtime() - h0.p;
        int r27 = v0.a;
        h0 r28 = this.a;
        String r29 = r28.k;
        String r30 = r28.i;
        String r31 = r28.j;
        if (h0.l != 5) goto L29;
        String r32 = r18;
    L30:
        Intrinsics.checkNotNullParameter(r29, "drawerPage");
        Intrinsics.checkNotNullParameter(r30, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r31, "enterMethod");
        Intrinsics.checkNotNullParameter(r32, r19);
        HashMap r111 = new HashMap();
        r111.put("drawer_page", r29);
        r111.put("enter_from_merge", r30);
        r111.put("enter_method", r31);
        r111.put("duration", String.valueOf(r26));
        r111.put("action_type", r32);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_tab_change_load_duration", r111, new Object[0]);
        goto L32
    L29:
        r32 = "draw";
        goto L30
    L17:
        if (h0.m <= 0) goto L31;
        long r33 = SystemClock.elapsedRealtime() - h0.m;
        int r112 = v0.a;
        h0 r34 = this.a;
        String r35 = r34.k;
        String r36 = r34.i;
        String r37 = r34.j;
        r18 = "click";
        String r38 = h0.o;
        Intrinsics.checkNotNullParameter(r35, "drawerPage");
        Intrinsics.checkNotNullParameter(r36, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r37, "enterMethod");
        Intrinsics.checkNotNullParameter(r38, "actionType");
        r19 = "actionType";
        HashMap r113 = new HashMap();
        r113.put("drawer_page", r35);
        r113.put("enter_from_merge", r36);
        r113.put("enter_method", r37);
        r113.put("duration", String.valueOf(r33));
        r113.put("action_type", r38);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_first_cover_load_duration", r113, new Object[0]);
        h0.n = h0.m;
        h0.m = 0;
    L31:
        r18 = "click";
        r19 = "actionType";
        goto L32
    L53:
        return;
    }
}
