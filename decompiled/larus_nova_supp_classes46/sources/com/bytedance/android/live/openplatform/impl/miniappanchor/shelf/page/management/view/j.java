package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Runnable {
    public final /* synthetic */ ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder a;

    public j(ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder r1) {
        this.a = r1;
    }

    public final void a() {
        ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder r0 = this.a;
        ShelfManagementCardListAdapterV2 r1 = r0.n;
        TextView r2 = r0.g;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.K3;
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.f.d(r3, Boolean.FALSE);
        c90.a.a r4 = new c90.a.a(r1.g);
        r4.a(s1.B(2131921067));
        c90.a r5 = new c90.a(r4);
        r5.f();
        float r6 = r5.e();
        r5.o = (r2.getMeasuredWidth() + ((UtilityKotlinExtentionsKt.i(7) * 8) / 3)) - r5.e();
        r5.h = r6;
        r5.i(r2, 80, false);
        ShelfManagementCardListAdapterV2.a r7 = r1.e;
        if (r7 == null) goto L9;
        r7.a();
        return;
    L9:
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
