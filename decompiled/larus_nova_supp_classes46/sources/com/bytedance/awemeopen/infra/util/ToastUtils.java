package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bytedance.awemeopen.servicesapi.toast.AoToastService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ToastUtils {
    public static final Lazy a = null;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "GravityParams(gravity=" + this.a + ", offsetX=" + this.b + ", offsetY=" + this.c + ')';
        }

        public a() {
            this.a = 49;
            this.b = 0;
            this.c = 0;
        }
    }

    static {
        a = LazyKt.lazy(ToastUtils$uiHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void b(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        d(r2, r2.getResources().getString(r3), 0, null);
    }

    @JvmStatic
    public static final void c(Context r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "text");
        d(r2, r3, 0, null);
    }

    @JvmStatic
    public static final void a(Context r1, CharSequence r2, int r3, a r4) {
        AoToastService r0 = (AoToastService) j64.a.a(AoToastService.class);
        if (r0 == null) goto L8;
        if (r4 != null) goto L6;
        r0.showToast(r1, r2.toString(), r3);
        return;
    L6:
        r0.G1(r1, r2.toString(), r3, r4.a);
        return;
    L8:
        Toast r5 = Toast.makeText(r1, r2, r3);
        if (r4 == null) goto L11;
        r5.setGravity(r4.a, r4.b, r4.c);
    L11:
        r5.show();
    }

    @JvmStatic
    public static final void d(Context r4, final CharSequence r5, int r6, final a r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "text");
        final Ref.IntRef r0 = new Ref.IntRef();
        boolean r1 = false;
        if (r6 != 1) goto L5;
        int r8 = 1;
    L6:
        r0.element = r8;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        r1 = true;
    L9:
        final Context r9 = r4.getApplicationContext();
        if (r1 == true) goto L12;
        ((Handler) a.getValue()).post(new n(r9, r5, r0, r7));
        return;
    L12:
        a(r9, r5, r0.element, r7);
        return;
    L5:
        r8 = 0;
        goto L6
    }
}
