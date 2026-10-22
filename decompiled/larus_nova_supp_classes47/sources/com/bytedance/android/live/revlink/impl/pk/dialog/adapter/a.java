package com.bytedance.android.live.revlink.impl.pk.dialog.adapter;

import android.view.View;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder a;

    public a(PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r10 = this.a;
        PKRivalsSearchHistoryAdapter r0 = r10.f;
        r0.f.j(r10.e, 0, 20, "", true, r0.d);
        PKRivalsSearchHistoryAdapter.SearchHistoryViewHolder r12 = this.a;
        r12.f.g.onSearch(r12.e);
        HashMap r13 = new HashMap();
        r13.put("pksearch_type", "2");
        boolean r1 = false;
        if (this.a.f.d.length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        String r3 = "activity";
    L9:
        r13.put("pk_description", r3);
        if (this.a.f.d.length() <= 0) goto L12;
        r1 = true;
    L12:
        String r4 = "";
        if (r1 == false) goto L15;
        String r5 = this.a.f.d;
    L16:
        r13.put("pk_activity_type", r5);
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r6 == null) goto L20;
        String r7 = r6.a();
        if (r7 == null) goto L20;
    L21:
        r13.put("anchor_connect_status", r7);
        d31.d r8 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r8 == null) goto L24;
        r4 = r8.s();
    L24:
        r13.put("room_status", r4);
        r13.put("source", this.a.f.h.b);
        n r14 = new n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r15.putAll(r13);
        m r16 = new m();
        r16.b(LogCommon.ROOM);
        List<Object> r17 = r14.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r16.a);
        e.a.getClass();
        j r19 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r20);
        ((i) ((f80.a) r20)).w3("livesdk_pksearch_launch", r14.a, r14.b);
        return;
    L20:
        r7 = "";
        goto L21
    L15:
        r5 = "";
        goto L16
    L8:
        r3 = "routine";
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
