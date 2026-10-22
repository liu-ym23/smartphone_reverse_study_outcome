package la1;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static boolean a;
    public static long b;
    public static Disposable c;
    public static InterfaceC0269a d;

    /* JADX INFO: renamed from: la1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0269a {
        boolean a();

        void b();

        long d();
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            com.bytedance.android.live.schema.api.utils.a.d("RedirectPollHelper", "updatePollConfig");
            a.c();
            InterfaceC0269a r4 = a.d;
            if (r4 == null) goto L6;
            r4.b();
            return;
        }
    }

    static {
        b = 180;
    }

    public static String a() {
        InterfaceC0269a r0 = d;
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        if (r1 == false) goto L9;
        return "poll:true, internal:" + b();
    L9:
        return "poll:false, internal:" + b();
    L5:
        r1 = false;
        goto L6
    }

    public static long b() {
        InterfaceC0269a r0 = d;
        if (r0 != null) goto L7;
        return 180;
    L7:
        return r0.d();
    }

    public static void c() {
        StringBuilder r0 = new StringBuilder("check poll config switch:");
        InterfaceC0269a r1 = d;
        boolean r2 = false;
        if (r1 == null) goto L5;
        boolean r3 = r1.a();
    L6:
        r0.append(r3);
        r0.append(", internal ");
        r0.append(b());
        com.bytedance.android.live.schema.api.utils.a.d("RedirectPollHelper", r0.toString());
        boolean r4 = a;
        InterfaceC0269a r5 = d;
        if (r5 == null) goto L9;
        boolean r6 = r5.a();
    L10:
        if (r4 == r6) goto L12;
    L13:
        InterfaceC0269a r7 = d;
        if (r7 == null) goto L16;
        r2 = r7.a();
    L16:
        a = r2;
        b = b();
        if (a == false) goto L22;
        Disposable r8 = c;
        if (r8 == null) goto L21;
        r8.dispose();
    L21:
        c = du2.a.b(10, b, TimeUnit.SECONDS).subscribe(b.a);
        return;
    L22:
        Disposable r9 = c;
        if (r9 == null) goto L25;
        r9.dispose();
    L25:
        c = null;
        return;
    L12:
        if (b != b()) goto L13;
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }
}
