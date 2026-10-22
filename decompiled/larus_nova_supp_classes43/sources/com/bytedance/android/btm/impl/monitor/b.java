package com.bytedance.android.btm.impl.monitor;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static volatile long a;
    public static final HashMap<Integer, Integer> b = null;

    public static final class a implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public a(long r1, int r10, long r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void a() {
            long r0 = this.a;
            HashMap<Integer, Integer> r10 = b.b;
            if (r0 < b.a) goto L22;
            HashMap<Integer, Integer> r1 = b.b;
            Integer r11 = r1.get(Integer.valueOf(this.b));
            if (r11 != null) goto L7;
        L8:
            if (r11 == null) goto L10;
            int r12 = r11.intValue();
        L11:
            r1.put(Integer.valueOf(this.b), Integer.valueOf(r12 - 1));
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
            BtmHostDependManager r14 = BtmHostDependManager.F;     // Catch: Throwable -> L17
            r14.getClass();     // Catch: Throwable -> L17
            Function3 r15 = (Function3) BtmHostDependManager.C.getValue(r14, BtmHostDependManager.a[23]);     // Catch: Throwable -> L17
            if (r15 == null) goto L15;
            r15.invoke(Long.valueOf(this.a), Long.valueOf(this.c), this.d);     // Catch: Throwable -> L17
        L15:
            b.a = this.c;     // Catch: Throwable -> L17
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L10:
            r12 = BtmSetting.d.c().c().Q();
            goto L11
        L7:
            if (r11.intValue() > 0) goto L8;
            return;
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
    }

    /* JADX INFO: renamed from: com.bytedance.android.btm.impl.monitor.b$b, reason: collision with other inner class name */
    public static final class RunnableC0108b implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public RunnableC0108b(long r1, int r10, long r11, String r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        public final void a() {
            long r0 = this.a;
            HashMap<Integer, Integer> r10 = b.b;
            if (r0 < b.a) goto L22;
            HashMap<Integer, Integer> r1 = b.b;
            Integer r11 = r1.get(Integer.valueOf(this.b));
            if (r11 != null) goto L7;
        L8:
            if (r11 == null) goto L10;
            int r12 = r11.intValue();
        L11:
            r1.put(Integer.valueOf(this.b), Integer.valueOf(r12 - 1));
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
            BtmHostDependManager r14 = BtmHostDependManager.F;     // Catch: Throwable -> L17
            r14.getClass();     // Catch: Throwable -> L17
            Function3 r15 = (Function3) BtmHostDependManager.C.getValue(r14, BtmHostDependManager.a[23]);     // Catch: Throwable -> L17
            if (r15 == null) goto L15;
            r15.invoke(Long.valueOf(this.a), Long.valueOf(this.c), this.d);     // Catch: Throwable -> L17
        L15:
            b.a = this.c;     // Catch: Throwable -> L17
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return;
        L10:
            r12 = BtmSetting.d.c().c().Q();
            goto L11
        L7:
            if (r11.intValue() > 0) goto L8;
            return;
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
    }

    static {
        b = new HashMap();
    }

    public static void a(int r11, String r12) {
        long r10 = System.currentTimeMillis() / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
        long r13 = r10 - BtmSetting.d.c().c().P();
        com.bytedance.android.btm.impl.thread.b r0 = com.bytedance.android.btm.impl.thread.b.e;
        a r1 = new a(r13, r11, r10, r12);
        r0.getClass();
        com.bytedance.android.btm.impl.thread.b.d(r1);
    }

    public static void b(int r12, String r13) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().c().N() == 1) goto L5;
        return;
    L5:
        if (r0.c().c().O().contains(Integer.valueOf(r12)) == false) goto L9;
        long r10 = System.currentTimeMillis() / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
        long r11 = r10 - r0.c().c().P();
        com.bytedance.android.btm.impl.thread.b r1 = com.bytedance.android.btm.impl.thread.b.e;
        RunnableC0108b r14 = new RunnableC0108b(r11, r12, r10, r13);
        r1.getClass();
        com.bytedance.android.btm.impl.thread.b.d(r14);
        return;
    }
}
