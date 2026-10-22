package com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final List<InterfaceC0088a> a = null;
    public static boolean b;
    public static Disposable c;
    public static int d;
    public static long e;
    public static Function0<Unit> f;
    public static String g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vs_base.toolbar.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0088a {
        void a();

        void b();

        void c();

        void d();
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            long r0 = a.e;
            if (r0 != 0) goto L5;
            UtilityKotlinExtentionsKt.g(ReplayScheduleCloseTimeManager$startCountDown$1$1.INSTANCE);
            return;
        L5:
            a.e = r0 - 1000;
            Iterator r7 = ((ArrayList) a.a).iterator();
        L7:
            if (r7.hasNext() == false) goto L11;
            InterfaceC0088a r1 = (InterfaceC0088a) r7.next();
            List<InterfaceC0088a> r2 = a.a;
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
        ((InterfaceC0088a) r0.next()).c();
        goto L4
    }

    static {
        a = new ArrayList();
        e = -2;
        g = "";
    }

    public static void b(long r3) {
        Disposable r0 = c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        e = r3;
        j.a r4 = j.a;
        c = j.a(0, 1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(b.a);
    }
}
