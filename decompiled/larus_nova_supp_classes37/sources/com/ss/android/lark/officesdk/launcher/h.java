package com.ss.android.lark.officesdk.launcher;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class h implements eva.a {
    public final ConcurrentHashMap<Long, b> a;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "Entry(name=" + this.a + ", startNs=" + this.b + ')';
        }

        public b(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Inject
    public h() {
        this.a = new ConcurrentHashMap();
    }

    public final void endSection() {
        long r0 = ThreadMethodProxy.currentThread().getId();
        String r2 = ThreadMethodProxy.currentThread().getName();
        b r3 = this.a.remove(Long.valueOf(r0));
        if (r3 != null) goto L6;
        Log.w("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_End_WithoutBegin @tid=" + r0 + '/' + r2);
        return;
    L6:
        long r1 = (SystemClock.elapsedRealtimeNanos() - r3.b) / ((long) 1000000);
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_End: " + r3.a + ", cost: " + r1 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r4 = com.ss.android.lark.officesdk.internal.g.a;
        String r5 = r3.a;
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_Meta.NAME);
        com.ss.android.lark.officesdk.internal.g.a(r5, "init", r1);
    }

    public final void beginSection(String r10) {
        Intrinsics.checkNotNullParameter(r10, AppbrandHostConstants.Schema_Meta.NAME);
        long r0 = ThreadMethodProxy.currentThread().getId();
        String r2 = ThreadMethodProxy.currentThread().getName();
        b r3 = this.a.put(Long.valueOf(r0), new b(r10, SystemClock.elapsedRealtimeNanos()));
        if (r3 == null) goto L5;
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_Overlap: prev=" + r3.a + " replaced by " + r10 + " @tid=" + r0 + '/' + r2);
    L5:
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_Begin: " + r10 + " @tid=" + r0 + '/' + r2);
    }
}
