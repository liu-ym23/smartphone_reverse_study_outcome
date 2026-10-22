package com.bytedance.android.livesdk.chatroom.vs_base.log;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import fq1.t;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public final Handler a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public long j;
    public long k;
    public long l;
    public boolean m;
    public final a n;
    public final DataCenter o;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public final void a() {
            if (this.a.g == false) goto L5;
            long r4 = SystemClock.elapsedRealtime();
            g r0 = this.a;
            long r5 = 60000 - (((r4 - r0.k) - r0.j) % 60000);
            r0.g = false;
        L6:
            this.a.a.postDelayed(this, r5);
            g r1 = this.a;
            if (r1.i == false) goto L9;
        L13:
            r1.i = false;
            return;
        L9:
            if (r5 != 60000) goto L13;
            d.a(r1.o).d("watch_onemin", null, new Object[0]);
            return;
        L5:
            r5 = 60000;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r1) {
            this.a = r1;
        }
    }

    public final void b() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.m = true;
        if (this.k != (-1)) goto L8;
        return;
    L8:
        if (this.h == true) goto L13;
        this.l = SystemClock.elapsedRealtime();
        this.a.removeCallbacksAndMessages(null);
        this.g = true;
        return;
    }

    public g(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.o = r3;
        this.a = new Handler(Looper.getMainLooper());
        this.i = true;
        this.k = -1;
        this.l = -1;
        this.n = new a(this);
    }

    public final void c(boolean r7) {
        if (this.e == false) goto L5;
        return;
    L5:
        this.m = false;
        if (this.l != (-1)) goto L8;
        return;
    L8:
        if (this.h == true) goto L32;
        if (r7 == false) goto L24;
        ReplayDataContext.a r8 = ReplayDataContext.Companion;
        DataCenter r0 = this.o;
        r8.getClass();
        ReplayDataContext r9 = ReplayDataContext.a.b(r0);
        if (r9 == null) goto L18;
        m<Long> r10 = r9.getTotalStopTime();
        if (r10 == null) goto L18;
        Long r11 = (Long) r10.getValue();
        if (r11 == null) goto L18;
        long r1 = r11.longValue();
    L19:
        this.j = (r1 + SystemClock.elapsedRealtime()) - this.l;
        ReplayDataContext r12 = ReplayDataContext.a.b(this.o);
        if (r12 == null) goto L29;
        m<Long> r13 = r12.getTotalStopTime();
        if (r13 == null) goto L29;
        r13.setValue(Long.valueOf(this.j));
    L29:
        this.l = -1;
        this.a.post(this.n);
        return;
    L18:
        r1 = this.j;
        goto L19
    L24:
        this.j = 0;
        ReplayDataContext.a r14 = ReplayDataContext.Companion;
        DataCenter r2 = this.o;
        r14.getClass();
        ReplayDataContext r15 = ReplayDataContext.a.b(r2);
        if (r15 == null) goto L29;
        m<Long> r16 = r15.getTotalStopTime();
        if (r16 == null) goto L29;
        r16.setValue(Long.valueOf(this.j));
        goto L29
    }

    public final void a(boolean r4, boolean r5) {
        if (this.b == true) goto L5;
    L7:
        if (r4 == false) goto L9;
        this.b = r4;
    L9:
        if (r5 == false) goto L12;
        this.c = r5;
    L12:
        if (this.b == true) goto L14;
        return;
    L14:
        if (this.c == true) goto L16;
        return;
    L16:
        if (this.d == true) goto L55;
        this.d = true;
        ReplayDataContext.a r6 = ReplayDataContext.Companion;
        DataCenter r0 = this.o;
        r6.getClass();
        ReplayDataContext r7 = ReplayDataContext.a.b(r0);
        Pair[] r1 = new Pair[1];
        if (r7 == null) goto L25;
        m<Integer> r8 = r7.getSeekType();
        if (r8 == null) goto L25;
        Integer r9 = (Integer) r8.getValue();
        if (r9 == null) goto L25;
        String r10 = String.valueOf(r9.intValue());
    L26:
        r1[0] = TuplesKt.to("seek_type", String.valueOf(r10));
        Map<String, String> r11 = MapsKt.mutableMapOf(r1);
        fq1.a r2 = fq1.b.a();
        if (r2 == null) goto L51;
        Episode r3 = r2.a;
        if (r3 == null) goto L51;
        IMainEpisode r12 = r3.castToOrNull(IMainEpisode.class);
        if (r12 == null) goto L51;
        PrivilegeInfo r13 = r12.subscribeReplayInfo();
        if (r13 == null) goto L51;
        PrivilegeBaseInfo r14 = r13.paidLiveInfo;
        if (r14 != null) goto L37;
    L39:
        String r15 = "inactive";
    L40:
        r11.put("member_status", r15);
        fq1.a r16 = fq1.b.a();
        if (r16 == null) goto L49;
        Episode r17 = r16.a;
        if (r17 == null) goto L49;
        String r18 = EpisodeExtKt.getOwnerIdString(r17);
        if (r18 == null) goto L49;
        if (r18.equals(t.a().getCurrentUserId()) != true) goto L49;
        String r19 = "1";
    L50:
        r11.put("is_anchor", r19);
    L49:
        r19 = "0";
        goto L50
    L37:
        if (r14.hasViewRight() != true) goto L39;
        r15 = "active";
    L51:
        d.a(this.o).d("play", r11, new Object[0]);
        return;
    L25:
        r10 = null;
        goto L26
    L55:
        return;
    L5:
        if (this.c == false) goto L7;
    }
}
