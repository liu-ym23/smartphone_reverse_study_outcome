package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ NewPkRecordViewHolder a;
    public final /* synthetic */ f2 b;

    public e(NewPkRecordViewHolder r1, f2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        x31.o r5 = this.a.c;
        if (r5 == null) goto L5;
        r5.op(this.b);
    L5:
        mz0.n r6 = new mz0.n();
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.ROOM);
        r0.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r1 = r6.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r0.a);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r7 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r7);
        ((mz0.i) ((f80.a) r7)).w3("livesdk_pk_start_feedback_icon_click", r6.a, r6.b);
    }
}
