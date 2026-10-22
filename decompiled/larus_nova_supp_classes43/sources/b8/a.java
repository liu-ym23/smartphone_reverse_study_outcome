package b8;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final List<c> b = null;
    public static final List<d> c = null;
    public static Runnable d;
    public static final Integer e = null;

    /* JADX INFO: renamed from: b8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0004a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LogLevel.values().length];
            r0[LogLevel.INFO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LogLevel.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LogLevel.DEBUG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements Runnable {
        public static final b a = null;

        /* JADX INFO: renamed from: b8.a$b$a, reason: collision with other inner class name */
        public static final class RunnableC0005a implements Runnable {
            public final /* synthetic */ List<d> a;

            public RunnableC0005a(List<d> r1) {
                this.a = r1;
            }

            public final void a() {
                Iterator<T> r0 = this.a.iterator();
            L4:
                if (r0.hasNext() == false) goto L15;
                d r1 = (d) r0.next();
                a r10 = a.a;
                b8.b r11 = r1.a;
                if (r11 == null) goto L8;
                a.b(a.a, r11);
            L8:
                b8.b r12 = r1.b;
                if (r12 == null) goto L11;
                a.c(a.a, r12);
            L11:
                Iterator r13 = ((ArrayList) a.b).iterator();
            L13:
                if (r13.hasNext() == false) goto L4;
                ((c) r13.next()).a();
                goto L13
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
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList r0 = new ArrayList();     // Catch: Throwable -> L4
            List<d> r1 = a.c;     // Catch: Throwable -> L4
            r0.addAll(r1);     // Catch: Throwable -> L4
            ((ArrayList) r1).clear();     // Catch: Throwable -> L4
            Schedulers.single().scheduleDirect(new RunnableC0005a(r0));     // Catch: Throwable -> L4
            a.d = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new ArrayList();
        c = new ArrayList();
        e = AnnieConfigSettingKeys.LIVE_HYBRID_ALOG_INTERVAL_TIME.a();
    }

    public static void d(b8.b r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        e(new d(null, r10, false, r10.a, 13));
    }

    public static void e(d r10) {
        if (r10.d == false) goto L11;
        Integer r0 = e;
        if (r0.intValue() <= 0) goto L11;
        if (ThreadUtils.b() == false) goto L11;
        ((ArrayList) c).add(r10);
        if (d != null) goto L21;
        b r11 = b.a;
        d = r11;
        ThreadUtils.a().postDelayed(r11, r0.intValue());
        return;
    L21:
        return;
    L11:
        b8.b r1 = r10.a;
        a r12 = a;
        if (r1 == null) goto L14;
        b(r12, r1);
    L14:
        b8.b r13 = r10.b;
        if (r13 == null) goto L17;
        c(r12, r13);
    L17:
        Iterator<T> r14 = b.iterator();
    L19:
        if (r14.hasNext() == false) goto L24;
        ((c) r14.next()).a();
        goto L19
    }

    public static void a(b8.b r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "params");
        if (g.g == true) goto L5;
    L7:
        e(new d(r13, null, r14, r13.a, 6));
        return;
    L5:
        if (g.b().a.a == false) goto L7;
        e(new d(r13, r13, r14, r13.a, 4));
    }

    public static final void b(a r10, b8.b r11) {
        r10.getClass();
        LogLevel r12 = r11.b;
        int r13 = C0004a.a[r12.ordinal()];
        String r14 = null;
        if (r13 == 1) goto L15;
        if (r13 == 2) goto L10;
        if (r13 != 3) goto L29;
        d(r11);
        return;
    L29:
        return;
    L10:
        if (r11.c == null) goto L13;
        ((x8.d) Annie.getService$default(x8.d.class, null, 2, null)).e(r11.a, r11.c);
        return;
    L13:
        if (r11.d == null) goto L27;
        x8.d r15 = (x8.d) Annie.getService$default(x8.d.class, null, 2, null);
        String r0 = r11.a;
        String r16 = r11.d;
        Intrinsics.checkNotNull(r16);
        r15.e(r0, r16);
        return;
    L27:
        return;
    L15:
        x8.d r17 = (x8.d) Annie.getService$default(x8.d.class, null, 2, null);
        String r1 = r11.a;
        String r18 = r11.d;
        if (r18 != null) goto L23;
        Throwable r19 = r11.c;
        if (r19 == null) goto L20;
        r14 = r19.getMessage();
    L20:
        if (r14 != null) goto L22;
        r18 = "";
        goto L23
    L22:
        r18 = r14;
    L23:
        r17.i(r1, r18);
    }

    public static final void c(a r0, b8.b r1) {
        r0.getClass();
        if (g.g == true) goto L5;
        return;
    L5:
        if (g.b().a.a == false) goto L10;
        LogLevel r10 = r1.b;
        int r11 = C0004a.a[r10.ordinal()];
        return;
    }
}
