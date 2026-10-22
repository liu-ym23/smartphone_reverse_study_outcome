package com.ss.android.lark.monitor.callback;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CpuCallbackManager {
    public static volatile CpuCallbackManager f;
    public final List<a> a;
    public final List<b> b;
    public float c;
    public final int d;
    public final int e;

    public static final enum CpuIdleCallBackPriority extends Enum<CpuIdleCallBackPriority> {
        public static final CpuIdleCallBackPriority HIGH = null;
        public static final CpuIdleCallBackPriority LOW = null;
        public static final CpuIdleCallBackPriority MIDDLE = null;
        public static final /* synthetic */ CpuIdleCallBackPriority[] a = null;

        static {
            CpuIdleCallBackPriority r0 = new CpuIdleCallBackPriority("LOW", 0);
            LOW = r0;
            CpuIdleCallBackPriority r1 = new CpuIdleCallBackPriority("MIDDLE", 1);
            MIDDLE = r1;
            CpuIdleCallBackPriority r3 = new CpuIdleCallBackPriority("HIGH", 2);
            HIGH = r3;
            a = new CpuIdleCallBackPriority[]{r0, r1, r3};
        }

        public static CpuIdleCallBackPriority[] values() {
            return (CpuIdleCallBackPriority[]) a.clone();
        }

        public static CpuIdleCallBackPriority valueOf(String r1) {
            return (CpuIdleCallBackPriority) r27.a.a(CpuIdleCallBackPriority.class, r1);
        }

        public CpuIdleCallBackPriority(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void b(float r1);
    }

    public class b {
        public final c a;
        public final CpuIdleCallBackPriority b;

        public b(c r1, CpuIdleCallBackPriority r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
        void onIdle();
    }

    public interface d extends c {
    }

    public static CpuCallbackManager a() {
        if (f != null) goto L15;
        monitor-enter(MemoryCallbackManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new CpuCallbackManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MemoryCallbackManager.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public CpuCallbackManager() {
        this.c = -1.0f;
        this.d = 30;
        this.e = 5;
        this.a = new CopyOnWriteArrayList();
        this.b = new ArrayList();
        if (DevicePerfManager.b.a.e.h == false) goto L6;
        this.d = 44;
        this.e = 3;
        return;
    }

    public final void b(d r7) {
        CpuIdleCallBackPriority r0 = CpuIdleCallBackPriority.MIDDLE;
        List<b> r1 = this.b;
        monitor-enter(r1);
        b r2 = new b(r7, r0);     // Catch: Throwable -> L16
        int r3 = 0;
        if (((ArrayList) this.b).size() == 0) goto L13;
        int r4 = ((ArrayList) this.b).size() - 1;     // Catch: Throwable -> L16
        int r8 = 0;
    L7:
        if (r4 < 0) goto L12;
        if (((b) ((ArrayList) this.b).get(r4)).b.ordinal() >= r0.ordinal()) goto L10;
        int r5 = r4;
        r4 = r4 - 1;     // Catch: Throwable -> L16
        r8 = r5;
        goto L7
    L10:
        r3 = r4 + 1;     // Catch: Throwable -> L16
        goto L13
    L12:
        r3 = r8;
    L13:
        ((ArrayList) this.b).add(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
