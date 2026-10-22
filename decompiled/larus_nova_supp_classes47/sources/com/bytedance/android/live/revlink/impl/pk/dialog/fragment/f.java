package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ InteractLinkRecordFragment a;

    public f(InteractLinkRecordFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (((LinearLayout) this.a.fa0(2131378691)).isShown() == true) goto L5;
        UtilityKotlinExtentionsKt.w(this.a.fa0(2131378691));
        mz0.n r5 = new mz0.n();
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.ROOM);
        List<Object> r1 = r5.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r0.a);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((mz0.i) ((f80.a) r6)).w3("livesdk_all_pk_records_choice_panel_show", r5.a, r5.b);
    L6:
        mz0.n r7 = new mz0.n();
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r9 = r7.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_all_pk_records_entry_click", r7.a, r7.b);
        return;
    L5:
        UtilityKotlinExtentionsKt.t(this.a.fa0(2131378691));
        goto L6
    }
}
