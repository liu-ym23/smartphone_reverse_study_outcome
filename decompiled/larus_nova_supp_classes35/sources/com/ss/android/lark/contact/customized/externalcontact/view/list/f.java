package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.department.DepartmentStructureActivity;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;
import mtb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends OnSingleClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ m b;

    public final void onSingleClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = DepartmentStructureActivity.b;
        Context r5 = this.a;
        mtb.i r0 = this.b;
        DepartmentStructureActivity.a.a(r5, r0.b, r0.a);
    }

    public f(Context r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
