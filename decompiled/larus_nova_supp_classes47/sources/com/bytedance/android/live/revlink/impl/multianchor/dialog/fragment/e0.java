package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ f0 a;

    public e0(f0 r1) {
        this.a = r1;
    }

    public final void a() {
        TabLayout.Tab r2 = null;
        if (((Boolean) l51.a.c.getValue(null, l51.a.a[1])).booleanValue() == true) goto L17;
        View r0 = this.a.a;
        if (r0 == null) goto L9;
        TabLayout r1 = r0.findViewById(2131387986);
        if (r1 == null) goto L9;
        KProperty[] r3 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r2 = r1.getTabAt(2);
    L9:
        if (r2 == null) goto L20;
        Object r4 = JavaCalls.getField(r2, "view");
        if ((r4 instanceof LinearLayout) == false) goto L18;
        LinearLayout r5 = (LinearLayout) r4;
        if (r5.getChildCount() <= 0) goto L19;
        r5.setOrientation(0);
        ImageView r6 = new ImageView(s1.getContext());
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        r7.gravity = 48;
        r7.topMargin = UtilityKotlinExtentionsKt.i(17);
        Unit r8 = Unit.INSTANCE;
        r6.setLayoutParams(r7);
        r6.setImageResource(2131252597);
        r5.addView(r6);
        return;
    L19:
        return;
    L18:
        return;
    L20:
        return;
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
