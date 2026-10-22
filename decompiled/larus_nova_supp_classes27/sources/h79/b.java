package h79;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final AtomicLong a = null;
    public static volatile long b;

    static {
        a = new AtomicLong(0);
    }

    public static void a(long r3, Function0 r5) {
        if (b != r3) goto L5;
        b = 0;
    L5:
        s.a.a();
        if (r5 == null) goto L9;
        r5.invoke();
        return;
    }

    public static long b(FragmentActivity r9, final Fragment r10, final CharSequence r11) {
        Intrinsics.checkNotNullParameter(r11, "text");
        final long r7 = a.incrementAndGet();
        b = r7;
        if (r9 != null) goto L9;
        if (r10 == null) goto L6;
        r9 = r10.getActivity();
    L7:
        if (r9 != null) goto L9;
        return r7;
    L6:
        r9 = null;
    L9:
        final FragmentActivity r6 = r9;
        Window r12 = r6.getWindow();
        if (r12 == null) goto L18;
        View r13 = r12.getDecorView();
        if (c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L16;
        c.a(r0, "getDecorView");
    L16:
        if (r13 == null) goto L18;
        r13.post(new a(r7, r10, r11, r6));
    L18:
        return r7;
    }

    public static void c(long r3, Context r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r6, "text");
        if (b != r3) goto L5;
        b = 0;
    L5:
        s.a.a();
        s r4 = s.a;
        String r7 = r6.toString();
        r4.getClass();
        s.t(r5, r7);
        Unit r8 = Unit.INSTANCE;
    }
}
