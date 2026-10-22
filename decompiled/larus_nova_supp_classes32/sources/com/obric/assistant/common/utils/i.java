package com.obric.assistant.common.utils;

import android.os.Build;
import android.os.Trace;
import com.miui.easygo.constant.EasyGoDbTable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final boolean a = false;
    public static final AtomicInteger b = null;

    public static final class a {
        public final String a;
        public final int b;
        public final AtomicBoolean c;

        public final void a() {
            if (i.a == true) goto L5;
            return;
        L5:
            if (this.c.compareAndSet(false, true) == false) goto L9;
            Trace.endAsyncSection(this.a, this.b);
            return;
        }

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
            this.a = r2;
            this.b = r3;
            this.c = new AtomicBoolean(false);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r0 = true;
    L6:
        a = r0;
        b = new AtomicInteger(0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @JvmStatic
    public static final a a(String r2) {
        Intrinsics.checkNotNullParameter(r2, EasyGoDbTable.Server.NAME);
        if (a == true) goto L5;
        return null;
    L5:
        if (Trace.isEnabled() == false) goto L11;
        int r0 = b.updateAndGet(new h());
        Trace.beginAsyncSection(r2, r0);
        return new a(r2, r0);
    L11:
        return null;
    }

    @JvmStatic
    public static final boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, EasyGoDbTable.Server.NAME);
        if (a == true) goto L5;
        return false;
    L5:
        if (Trace.isEnabled() == false) goto L11;
        Trace.beginSection(r1);
        return true;
    L11:
        return false;
    }
}
