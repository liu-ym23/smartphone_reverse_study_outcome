package com.ss.android.lark.insets;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AndroidQInsetsDispatchCompat {
    public static final int a = 0;

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ Function0<Unit> a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ Space c;

        public a(Function0<Unit> r1, ViewGroup r2, Space r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
            Intrinsics.checkNotNullParameter(r4, "<unused var>");
            Intrinsics.checkNotNullParameter(r5, "insets");
            this.a.invoke();
            Sequence r6 = ViewGroupKt.getChildren(this.b);
            Space r0 = this.c;
            Iterator r7 = r6.iterator();
        L4:
            if (r7.hasNext() == false) goto L9;
            View r1 = (View) r7.next();
            if (Intrinsics.areEqual(r1, r0) == true) goto L4;
            r1.dispatchApplyWindowInsets(r5.toWindowInsets());
            goto L4
        L9:
            return WindowInsetsCompat.CONSUMED;
        }
    }

    static {
        a = View.generateViewId();
    }

    @JvmStatic
    public static final synchronized void a(final ViewGroup r3) {
        monitor-enter(AndroidQInsetsDispatchCompat.class);
        Intrinsics.checkNotNullParameter(r3, "viewGroup");     // Catch: Throwable -> L17
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L10:
        if (r3.getId() == 16908290) goto L14;
        b(r3, AndroidQInsetsDispatchCompat$resolveInner$1.INSTANCE);     // Catch: Throwable -> L17
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L14:
        b(r3, new AndroidQInsetsDispatchCompat$resolve$1(r3));     // Catch: Throwable -> L17
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void b(ViewGroup r4, Function0<Unit> r5) {
        monitor-enter(AndroidQInsetsDispatchCompat.class);
        Intrinsics.checkNotNullParameter(r4, "viewGroup");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r5, "onDispatchWindowInset");     // Catch: Throwable -> L11
        int r1 = a;     // Catch: Throwable -> L11
        if (((Space) r4.findViewById(r1)) == null) goto L8;
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L8:
        Space r2 = new Space(r4.getContext());     // Catch: Throwable -> L11
        r2.setId(r1);     // Catch: Throwable -> L11
        ViewCompat.setOnApplyWindowInsetsListener(r2, new a(r5, r4, r2));     // Catch: Throwable -> L11
        r4.addView(r2, 0);     // Catch: Throwable -> L11
        monitor-exit(AndroidQInsetsDispatchCompat.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
