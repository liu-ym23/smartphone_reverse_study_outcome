package com.bytedance.android.livesdk.feed;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h0 {
    public static int l;
    public static long m;
    public static long n;
    public static String o;
    public static long p;
    public static boolean q;
    public long a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public long f;
    public long g;
    public long h;
    public final String i;
    public final String j;
    public final String k;

    public static final class a {
        public static void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            int r0 = r2.hashCode();
            if (r0 == (-1377687758)) goto L11;
            if (r0 == 3091780) goto L8;
        L13:
            String r3 = "";
        L14:
            h0.o = r3;
            return;
        L8:
            if (r2.equals("draw") == false) goto L13;
            r3 = "pull";
            goto L14
        L11:
            if (r2.equals("button") == false) goto L13;
            r3 = "click";
            goto L14
        }
    }

    static {
        l = 4;
        o = "";
    }

    public final void b() {
        if (this.c <= 0) goto L10;
        long r0 = SystemClock.elapsedRealtime() - this.c;
        int r4 = v0.a;
        String r5 = this.k;
        String r6 = this.i;
        String r7 = this.j;
        if (l != 5) goto L7;
        String r8 = "click";
    L8:
        Intrinsics.checkNotNullParameter(r5, "drawerPage");
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        Intrinsics.checkNotNullParameter(r8, "actionType");
        HashMap r9 = new HashMap();
        r9.put("action_type", r8);
        r9.put("drawer_page", r5);
        r9.put("enter_from_merge", r6);
        r9.put("enter_method", r7);
        r9.put("duration", String.valueOf(r0));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_tab_stay_duration", r9, new Object[0]);
        this.c = 0;
        return;
    L7:
        r8 = "draw";
        goto L8
    }

    public final void a() {
        long r0 = SystemClock.elapsedRealtime() - this.h;
        int r2 = l;
        String r4 = "tab";
        if (r2 != 5) goto L6;
        String r3 = "click";
    L9:
        int r5 = v0.a;
        long r6 = this.f;
        long r7 = this.g;
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        com.bytedance.android.livesdk.log.g r9 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("init", String.valueOf(r6));
        r10.put("fetch", String.valueOf(r7));
        r10.put("render", String.valueOf(r0));
        r10.put("all", String.valueOf((r6 + r7) + r0));
        r10.put("type", r4);
        if (r3.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        r10.put("action_type", r3);
    L15:
        Unit r8 = Unit.INSTANCE;
        r9.sendLog("livesdk_drawer_afmp", r10, new Object[]{Room.class});
        return;
    L12:
        r1 = false;
        goto L13
    L6:
        if (r2 != 6) goto L8;
        r3 = "draw";
        goto L9
    L8:
        r3 = "";
        r4 = "afmp";
        goto L9
    }

    public final void c(int r3) {
        this.e = r3;
        if (r3 != 3) goto L5;
    L6:
        this.a = SystemClock.elapsedRealtime();
        return;
    L5:
        if (r3 == 1) goto L6;
    }

    public h0(BaseFragment r3, LiveData r4, LiveData r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "refreshApiStatus");
        Intrinsics.checkNotNullParameter(r5, "loadMoreApiStatus");
        Intrinsics.checkNotNullParameter(r6, "enterFromMerge");
        Intrinsics.checkNotNullParameter("drawer_cover", "enterMethod");
        Intrinsics.checkNotNullParameter(r7, "drawerPage");
        this.i = r6;
        this.j = "drawer_cover";
        this.k = r7;
        this.e = 0;
        r4.observe(r3, new f0(this));
        r5.observe(r3, new g0(this));
    }
}
