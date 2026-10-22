package com.bytedance.android.live.profile;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements Runnable {
    public final /* synthetic */ ProfileEcomSetDialogFragment a;
    public final /* synthetic */ View b;

    public i(ProfileEcomSetDialogFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        View r0 = this.a.f;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        Activity r2 = ContextUtil.contextToActivity(r1);
        if (r2 != null) goto L9;
        return;
    L9:
        c90.a.a r3 = new c90.a.a(r2);
        r3.f = false;
        TextView r4 = new TextView(this.b.getContext());
        r4.setText(s1.B(2131921707));
        r4.setTextSize(1, 12.0f);
        r4.setTextColor(-1);
        Unit r5 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "view");
        r3.g = r4;
        r3.c = UtilityKotlinExtentionsKt.i(-16);
        r3.a = ColorProtector.parseColor("#393B44");
        c90.a r6 = new c90.a(r3);
        r6.f();
        r6.i(this.a.j, 48, false);
        return;
    L5:
        r1 = null;
        goto L6
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
