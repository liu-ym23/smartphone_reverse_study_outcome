package com.lynx.tasm.performance.fsp;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import y7a.g;
import z7a.a;
import z7a.b;
import z7a.c;
import z7a.d;
import z7a.e;
import z7a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class FSPTracer {
    public a a;
    public final AtomicBoolean b;
    public volatile b c;
    public final int d;
    public final WeakReference<PerformanceController> e;

    public static final enum ResultStatus extends Enum<ResultStatus> {
        public static final ResultStatus CANCEL_BY_TIMEOUT = null;
        public static final ResultStatus CANCEL_BY_USER_INTERACTION = null;
        public static final ResultStatus ERROR = null;
        public static final ResultStatus STOP = null;
        public static final ResultStatus SUCCESS = null;
        public static final /* synthetic */ ResultStatus[] a = null;
        private final String value;

        static {
            ResultStatus r0 = new ResultStatus("SUCCESS", 0, "success");
            SUCCESS = r0;
            ResultStatus r1 = new ResultStatus("CANCEL_BY_USER_INTERACTION", 1, "cancelByUserInteraction");
            CANCEL_BY_USER_INTERACTION = r1;
            ResultStatus r2 = new ResultStatus("CANCEL_BY_TIMEOUT", 2, "timeout");
            CANCEL_BY_TIMEOUT = r2;
            ResultStatus r4 = new ResultStatus("STOP", 3, "stop");
            STOP = r4;
            ResultStatus r6 = new ResultStatus("ERROR", 4, "error");
            ERROR = r6;
            a = new ResultStatus[]{r0, r1, r2, r4, r6};
        }

        public static ResultStatus[] values() {
            return (ResultStatus[]) a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static ResultStatus fromValue(String r5) {
            ResultStatus[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ResultStatus r3 = r0[r2];
            if (r3.value.equals(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static ResultStatus valueOf(String r1) {
            return (ResultStatus) r27.a.a(ResultStatus.class, r1);
        }

        public ResultStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public final boolean b() {
        PerformanceController r0 = this.e.get();
        if (r0 != null) goto L6;
        return LynxEnv.inst().enableFSP();
    L6:
        return r0.l();
    }

    public FSPTracer(PerformanceController r3) {
        this.b = new AtomicBoolean(false);
        this.d = -1;
        this.e = new WeakReference(null);
        this.e = new WeakReference(r3);
        this.d = r3.h;
    }

    public final void c(final h r5) {
        if (this.a.i <= 0) goto L6;
        final WeakReference r0 = new WeakReference(this);
        UIThreadUtils.runOnUiThread(new c(r0, r5), this.a.i);
        return;
    }

    public final void a(ResultStatus r5, final b r6, final long r7) {
        final PerformanceController r0 = this.e.get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r6 != null) goto L15;
        final HashMap r8 = new HashMap(1);
        r8.put("fspStatus", r5.getValue());
        if (r0.e == true) goto L12;
        r0.q(new g(r0, r7, r8));
    L12:
        if (TraceEvent.isTracingStarted() == false) goto L23;
        r8.put("instance_id", String.valueOf(r0.h));
        UIThreadUtils.runOnUiThread(new d(r8));
        return;
    L23:
        return;
    L15:
        final HashMap r9 = new HashMap(1);
        r9.put("fspStatus", r5.getValue());
        r9.put("contentFillPercentageX", String.valueOf(r6.j));
        r9.put("contentFillPercentageY", String.valueOf(r6.k));
        r9.put("contentFillPercentageTotalArea", String.valueOf(r6.l));
        r9.put("containerFillPercentageContainerArea", String.valueOf(r6.m));
        final long r2 = r6.i;
        if (r0.e == true) goto L20;
        r0.q(new g(r0, r2, r9));
    L20:
        if (TraceEvent.isTracingStarted() == false) goto L24;
        r9.put("instance_id", String.valueOf(r0.h));
        UIThreadUtils.runOnUiThread(new e(r6, r9));
        return;
    }
}
