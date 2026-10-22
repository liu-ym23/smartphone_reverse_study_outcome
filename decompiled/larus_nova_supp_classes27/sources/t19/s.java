package t19;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.assistant.common.spi.toast.ObricToastHelperDelegate;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s {
    public static final s a = null;
    public static final AtomicReference<u19.f> b = null;

    public static final class a {
        public final u19.f a;

        public a(u19.f r2) {
            Intrinsics.checkNotNullParameter(r2, "toastHolder");
            this.a = r2;
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LottieAdapterView b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.setAnimation("lottie/toast_loading.json");
            this.b.playAnimation();
        }

        public b(View r1, LottieAdapterView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ LottieAdapterView b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            this.a.removeOnAttachStateChangeListener(this);
            this.b.setAnimation("lottie/toast_loading.json");
            this.b.playAnimation();
        }

        public c(View r1, LottieAdapterView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public s() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        FLogger.a.d("ToastLogger", "toast util dismiss");     // Catch: Throwable -> L6
        t0.e(new n());     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        a = new s();
        b = new AtomicReference(null);
    }

    public static Context f(Context r1) {
        Context r0 = ObricToastHelperDelegate.b.resolveContext(r1);
        if (r0 != null) goto L6;
        return r1;
    L6:
        return r0;
    }

    public final synchronized void r(final u19.f r2) {
        monitor-enter(this);
        t0.e(new p(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void c(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r8, "text");
        l(r7, 2131243493, r8, null, null, false);
    }

    public static void p(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r8, "text");
        l(r7, v19.c.b(2130972335, null, 2131243494), r8, null, null, false);
    }

    public static void s(Context r3, int r4) {
        t0.e(new i(r3, r4, v19.c.b(2130972336, null, 2131243497), false));
    }

    public static void t(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        k(r3, v19.c.b(2130972336, null, 2131243497), r4, null);
    }

    public static void b(Context r2, int r3, boolean r4) {
        t0.e(new i(r2, r3, 2131243493, r4));
    }

    public static void e(FragmentActivity r2, CharSequence r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        m(r2, r3, 0, r4, new h());
    }

    public static void o(Context r3, int r4, boolean r5) {
        t0.e(new i(r3, r4, v19.c.b(2130972335, null, 2131243494), r5));
    }

    public static void q(Context r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r8, "text");
        l(r7, v19.c.b(2130972335, null, 2131243494), r8, Integer.valueOf(r9), null, false);
    }

    public static void u(Context r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        k(r3, v19.c.b(2130972336, null, 2131243497), r4, Integer.valueOf(r5));
    }

    public final void g(Context r8, int r9, boolean r10) {
        if (r8 != null) goto L4;
        Context r0 = AppHost.a.getApplication();
    L5:
        String r3 = r0.getResources().getString(r9);
        FLogger.a.d("ToastLogger", "toast utils show, method name: show");
        j(this, r8, r3, null, r10, 12);
        return;
    L4:
        r0 = r8;
        goto L5
    }

    public static void d(Context r8, CharSequence r9, Integer r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "text");
        FragmentActivity r1 = f(r8);
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        if (r2 != null) goto L9;
        String r3 = r9.toString();
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r3, "text");
        i(r8, r3, r10, false, false, null);
        return;
    L9:
        if (r10 == null) goto L11;
        int r12 = r10.intValue();
    L12:
        m(r2, r9, r12, r11, new m());
        return;
    L11:
        r12 = 0;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static void k(Context r7, int r8, String r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r9, "text");
        l(r7, r8, r9, r10, null, false);
    }

    public static void n(s r6, final Fragment r7, final CharSequence r8, final Function1 r9) {
        final int r3 = 0;
        final boolean r4 = false;
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "config");
        t0.e(new d(r8, r9, r3, r4, r7));
    }

    public static void h(Context r7, String r8, Integer r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "text");
        i(r7, r8, r9, r10, r11, null);
    }

    public static void m(Context r7, final CharSequence r8, final int r9, final boolean r10, final Function1 r11) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r11, "config");
        final Context r6 = f(r7);
        if (r6 != null) goto L5;
        return;
    L5:
        t0.e(new t19.c(r8, r11, r9, r10, r6));
    }

    public static void i(Context r8, final String r9, final Integer r10, final boolean r11, final boolean r12, final Integer r13) {
        Intrinsics.checkNotNullParameter(r9, "text");
        final Context r4 = f(r8);
        if (r4 != null) goto L5;
        return;
    L5:
        t0.e(new k(r9, r13, r4, r12, r10, r11));
    }

    public static /* synthetic */ void j(s r2, Context r3, String r4, Integer r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r7 & 16) == 0) goto L12;
        r6 = false;
    L12:
        r2.getClass();
        h(r3, r4, r5, r0, r6);
        return;
    L8:
        r0 = false;
        goto L10
    }

    public static void l(Context r8, final int r9, final String r10, final Integer r11, final Integer r12, final boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "text");
        final Context r6 = f(r8);
        if (r6 != null) goto L5;
        return;
    L5:
        t0.e(new l(r9, r10, r12, r11, r6, r13));
    }
}
