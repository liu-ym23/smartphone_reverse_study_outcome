package com.bytedance.android.live.revenue.common;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ToastUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Context r0 = s1.getContext();
        if (r0 != null) goto L7;
        return;
    L7:
        Toast r1 = new Toast(r0);
        r1.setGravity(17, 0, 0);
        r1.setView(r3);
        r1.setDuration(0);
        r1.show();
    }

    public static void a(int r1, int r2) {
        Context r0 = s1.getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        b(r0.getString(r1), r2);
    }

    public static void b(final String r5, final int r6) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L15;
        Function0<Unit> r0 = new ToastUtil$centerToast$1(r5, r6);
        Intrinsics.checkNotNullParameter(r0, "action");
        com.bytedance.live.kmp.util.f.a(r0);
        return;
    L15:
        Context r2 = s1.getContext();
        if (r2 != null) goto L18;
        return;
    L18:
        kjc.c r3 = new kjc.c();
        if (3 != kjc.a.a()) goto L22;
        kjc.b r4 = r3.a;
        vh6.c.b(bi6.a.class).x(r5, r6);
        r4.a = Unit.INSTANCE;
        r3.b = true;
    L22:
        if (r3.b == true) goto L24;
        kjc.b r7 = r3.a;
        vh6.c.b(bi6.a.class).centerToast(r2, r5, r6);
        r7.a = Unit.INSTANCE;
    L24:
        Object r8 = r3.a.a;
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
