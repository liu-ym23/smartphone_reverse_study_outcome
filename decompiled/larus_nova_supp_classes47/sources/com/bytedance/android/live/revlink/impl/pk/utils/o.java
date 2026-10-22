package com.bytedance.android.live.revlink.impl.pk.utils;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void b() {
        int r0 = l51.a.j();
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.m0;
        KProperty[] r2 = l51.a.a;
        r1.setValue(null, r2[74], Integer.valueOf(r0));
        int r3 = l51.a.k();
        l51.a.n0.setValue(null, r2[75], Integer.valueOf(r3));
    }

    static {
    }

    @JvmStatic
    public static final boolean a(long r6) {
        c51.a r0 = c51.a.h;
        r0.getClass();
        ReadOnlyProperty r1 = c51.a.b;
        KProperty[] r2 = c51.a.a;
        String r3 = (String) r1.getValue(r0, r2[0]);
        r0.getClass();
        String r4 = (String) c51.a.c.getValue(r0, r2[1]);
        SimpleDateFormat r5 = new SimpleDateFormat("HH:mm:ss");
        Date r7 = r5.parse(r3);     // Catch: ParseException -> L9
        Date r8 = r5.parse(r4);     // Catch: ParseException -> L9
        Date r9 = r5.parse(r5.format(new Date(r6)));     // Catch: ParseException -> L9
        Calendar r10 = Calendar.getInstance();     // Catch: ParseException -> L9
        r10.setTime(r7);     // Catch: ParseException -> L9
        Calendar r12 = Calendar.getInstance();     // Catch: ParseException -> L9
        r12.setTime(r8);     // Catch: ParseException -> L9
        Calendar r13 = Calendar.getInstance();     // Catch: ParseException -> L9
        r13.setTime(r9);     // Catch: ParseException -> L9
        if (r13.after(r10) == false) goto L12;
        if (r13.before(r12) == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    @JvmStatic
    public static final void c(int r7, int r8, boolean r9) {
        String r0 = String.valueOf(Calendar.getInstance().get(6));
        if (r9 == true) goto L5;
    L7:
        if (r9 == true) goto L9;
    L12:
        l51.a.I(r7);
        l51.a.J(r8);
        if (r9 == true) goto L16;
        b();
        return;
    L16:
        return;
    L9:
        if (l51.a.k() > 1) goto L11;
        b();
    L11:
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.p0;
        KProperty[] r4 = l51.a.a;
        r3.setValue(null, r4[77], Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        l51.a.o0.setValue(null, r4[76], r0);
        goto L12
    L5:
        if (TextUtils.equals((String) l51.a.o0.getValue(null, l51.a.a[76]), r0) == false) goto L7;
    }
}
