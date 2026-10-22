package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements qub.b {

    public static final class a implements qub.a {
        public final rub.a a;
        public final Handler b;
        public final RunnableC0074a c;
        public ujb.f d;
        public boolean e;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.style.provider.g$a$a, reason: collision with other inner class name */
        public static final class RunnableC0074a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0074a(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.hide();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // qub.a
        public final void hide() {
            if (this.e == false) goto L5;
            return;
        L5:
            this.b.removeCallbacks(this.c);
            ujb.f r0 = this.d;
            this.d = null;
            if (r0 == null) goto L8;
            r0.close();
        L8:
            if (r0 == null) goto L10;
            return;
        L10:
            if (this.e == true) goto L18;
            this.e = true;
            this.b.removeCallbacks(this.c);
            this.d = null;
            Function0<Unit> r1 = this.a.n;
            if (r1 == null) goto L17;
            r1.invoke();
            return;
        L17:
            return;
        }

        @Override // qub.a
        public final boolean isShowing() {
            ujb.f r0 = this.d;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.d() != true) goto L9;
            return true;
        L9:
            return false;
        }

        public a(rub.a r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a = r2;
            this.b = new Handler(Looper.getMainLooper());
            this.c = new RunnableC0074a(this);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmBubbleDirection.values().length];
            r0[MmBubbleDirection.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MmBubbleDirection.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MmBubbleDirection.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MmBubbleDirection.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements ujb.b {
        public final /* synthetic */ a a;

        public final void onDismiss() {
            a r0 = this.a;
            if (r0.e == true) goto L10;
            r0.e = true;
            r0.b.removeCallbacks(r0.c);
            r0.d = null;
            Function0<Unit> r1 = r0.a.n;
            if (r1 == null) goto L9;
            r1.invoke();
            return;
        L9:
            return;
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    public g() {
    }

    @Override // qub.b
    public final qub.a L(Activity r13, rub.a r14) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "config");
        a r2 = new a(r14);
        View r3 = r14.a;
        MmBubbleDirection r5 = r14.d;
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        AnchorConfig.AnchorGravity r7 = AnchorConfig.AnchorGravity.START;
    L16:
        Point r8 = r14.l;
        if (r8 != null) goto L19;
        r8 = new Point();
    L19:
        AnchorConfig r4 = new AnchorConfig(r3, r7, r8);
        CharSequence r9 = r14.c;
        if (r9 == null) goto L22;
        String r10 = r14.b;
    L23:
        if (r9 == null) goto L26;
        String r11 = r9.toString();
        if (r11 == null) goto L26;
    L29:
        ujb.e r12 = new ujb.e(r4, r10, r11, r14.h, r14.m, r14.i, r14.j);
        ((ujb.a) r12).a = Boolean.valueOf(r14.e);
        ((ujb.a) r12).b = new c(r2);
        int r15 = qjb.a.a;
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r12, "config");
        r2.d = new tjb.d(new WeakReference(r13), r12).o();
        rub.a r16 = r2.a;
        if (r16.f == false) goto L32;
        r2.b.postDelayed(r2.c, r16.g);
    L32:
        return r2;
    L26:
        r11 = r14.b;
        if (r11 != null) goto L29;
        r11 = "";
        goto L29
    L22:
        r10 = null;
        goto L23
    L5:
        if (r6 != 2) goto L7;
        r7 = AnchorConfig.AnchorGravity.BOTTOM;
        goto L16
    L7:
        if (r6 != 3) goto L9;
        r7 = AnchorConfig.AnchorGravity.END;
        goto L16
    L9:
        if (r6 != 4) goto L12;
        r7 = AnchorConfig.AnchorGravity.TOP;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
