package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i2 {
    public static final List<a> a = null;
    public static boolean b;
    public static Disposable c;
    public static int d;
    public static long e;
    public static String f;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            long r0 = i2.e;
            if (r0 != 0) goto L5;
            UtilityKotlinExtentionsKt.s(0, false, false, ScheduleCloseTimeManager$startCountDown$1$1.INSTANCE, 7);
            return;
        L5:
            i2.e = r0 - 1000;
            Iterator r11 = ((ArrayList) i2.a).iterator();
        L7:
            if (r11.hasNext() == false) goto L11;
            a r1 = (a) r11.next();
            List<a> r2 = i2.a;
            r1.a();
            goto L7
        }
    }

    public static void a() {
        d = 0;
        e = -2;
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).c();
        goto L4
    }

    static {
        a = new ArrayList();
        e = -2;
        f = "";
    }

    public static void b(long r3) {
        Disposable r0 = c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        e = r3;
        com.bytedance.android.live.core.utils.rxutils.j.a r4 = com.bytedance.android.live.core.utils.rxutils.j.a;
        c = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(b.a);
    }
}
