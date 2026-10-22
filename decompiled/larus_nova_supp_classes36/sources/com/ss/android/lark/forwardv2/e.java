package com.ss.android.lark.forwardv2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.ForwardHitPoint;
import com.ss.android.lark.forwardv2.impl.ForwardPickActivity;
import com.ss.android.lark.forwardv2.impl.ForwardPickResponsiveActivity;
import com.ss.android.lark.forwardv3.utils.n;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import nnc.t;
import z5c.c4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static hib.d a;

    public static final class a {
        @JvmStatic
        public static hib.d a() {
            if (e.a != null) goto L6;
            e.a = (hib.d) PluginServiceLoader.loadFirst(hib.d.class);
        L6:
            if (e.a != null) goto L8;
            e.a = new d();
        L8:
            hib.d r0 = e.a;
            Intrinsics.checkNotNull(r0);
            return r0;
        }
    }

    static {
    }

    @JvmStatic
    public static final hib.d d() {
        return a.a();
    }

    public static Intent a(Context r2) {
        if (ForsetiFGHelpers.d() == false) goto L6;
        Intent r3 = new Intent(r2, ForwardPickResponsiveActivity.class).addFlags(65536);
        Intrinsics.checkNotNull(r3);
        return r3;
    L6:
        return new Intent(r2, ForwardPickActivity.class);
    }

    public static /* synthetic */ void c(Context r2, ForwardTemplate r3) {
        b(r2, r3, -1, null, null);
    }

    public static void b(Context r2, ForwardTemplate r3, final int r4, int[] r5, int[] r6) {
        if (r2 == null) goto L48;
        boolean r0 = zib.b.d;
        s5c.a r1 = c4.c;
        ForwardHitPoint r7 = r3.f;
        if (r7 == null) goto L8;
        String r8 = r7.b;
        if (r8 == null) goto L8;
    L9:
        zib.b.e(r1, r8);
        Intent r9 = a(r2);
        r9.putExtra("parcelable_forward_template", r3);
        if (r5 == null) goto L12;
        r9.putExtra("key_transition_anim_in", r5);
    L12:
        if (r6 == null) goto L14;
        r9.putExtra("key_transition_anim_out", r6);
    L14:
        r9.putExtra("start_time", SystemClock.elapsedRealtime());
        Bundle r10 = r3.g;
        if (r10 == null) goto L20;
        if (r10.getBoolean("sdkshare") == false) goto L20;
        r9.addFlags(335544320);
    L20:
        if (ForsetiFGHelpers.d() == true) goto L22;
        int r11 = n.a;
        if (n.f(r2) == false) goto L37;
        if ((r2 instanceof FragmentActivity) == true) goto L30;
        r9.addFlags(268435456);
        r2.startActivity(r9);
    L41:
        if (ForsetiFGHelpers.d() == true) goto L43;
        return;
    L43:
        if ((r2 instanceof Activity) == false) goto L47;
        ((Activity) r2).overridePendingTransition(0, 0);
        return;
    L47:
        return;
    L30:
        g r12 = f.c((FragmentActivity) r2, true);
        if (r12 == null) goto L41;
        t r13 = t.a;
        Bundle r14 = r9.getExtras();
        if (r14 != null) goto L35;
        r14 = new Bundle();
    L35:
        Intrinsics.checkNotNullParameter(r14, "args");
        r12.f(new onc.g(r14), new ForwardModuleV2$safeStartActivity$1(r4));
        goto L41
    L37:
        if ((r2 instanceof Activity) == true) goto L39;
        r9.addFlags(268435456);
        r2.startActivity(r9);
        goto L41
    L39:
        ((Activity) r2).startActivityForResult(r9, r4);
        goto L41
    L22:
        if ((r2 instanceof Activity) == true) goto L24;
        r9.addFlags(268435456);
        r2.startActivity(r9);
        goto L41
    L24:
        ((Activity) r2).startActivityForResult(r9, r4);
    L8:
        r8 = "v2_default";
        goto L9
    }
}
