package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.common.utility.UIUtils;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public d0(f0 r1, Context r2) {
        this.a = r1;
        this.b = r2;
        this.c = "巅峰赛已开启";
    }

    public final void a() {
        View r0 = this.a.a;
        if (r0 == null) goto L7;
        TabLayout r1 = r0.findViewById(2131387986);
        if (r1 == null) goto L7;
        KProperty[] r2 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        TabLayout.Tab r3 = r1.getTabAt(2);
    L8:
        Object r4 = JavaCalls.getField(r3, "view");
        if ((r4 instanceof View) == true) goto L11;
        r4 = null;
    L11:
        View r5 = (View) r4;
        if (r5 != null) goto L14;
        return;
    L14:
        f0 r6 = this.a;
        yo2.d<?> r7 = r6.b;
        if (r7 == null) goto L17;
        Intrinsics.checkNotNull(r7);
        r7.d();
        r6.b = null;
    L17:
        View r8 = LayoutInflater.from(this.b).inflate(2131567816, null);
        ((TextView) r8.findViewById(2131390805)).setText(this.c);
        f0 r9 = this.a;
        yo2.e r10 = new yo2.e(this.b);
        ((yo2.d) r10).d = r8;
        ((yo2.d) r10).e = 0;
        ((yo2.d) r10).m = 5;
        ((yo2.d) r10).l = true;
        r10.a();
        r9.b = r10;
        yo2.d<?> r12 = this.a.b;
        if (r12 == null) goto L20;
        r12.i(r5, 1, 0, s1.f(25.0f), s1.f(15.0f));
    L20:
        UIUtils.updateLayoutMargin(r8.findViewById(2131376322), s1.f(14.0f), -3, -3, -3);
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
