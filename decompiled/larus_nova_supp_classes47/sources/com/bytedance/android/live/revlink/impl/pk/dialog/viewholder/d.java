package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ NewPkRecordViewHolder a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f2 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public d(NewPkRecordViewHolder r1, String r2, f2 r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        NewPkRecordViewHolder r8 = this.a;
        String r0 = this.b;
        int r1 = NewPkRecordViewHolder.z;
        r8.getClass();
        com.bytedance.android.live.revenuelink.connect.g r2 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r2 == null) goto L22;
        boolean r3 = true;
        if (r2.v1() != true) goto L22;
        com.bytedance.android.live.revlink.impl.pk.service.b r9 = r8.a;
        Object r4 = null;
        if (r9 == null) goto L20;
        i11.b r10 = r9.getLinkUserCenter();
        if (r10 == null) goto L20;
        List<IBaseUser> r12 = r10.getInviteeList();
        if (r12 == null) goto L20;
        Iterator<T> r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Object r5 = r13.next();
        if (Intrinsics.areEqual(iz.a.a((IBaseUser) r5), r0) == false) goto L15;
        r4 = r5;
    L19:
        r4 = (IBaseUser) r4;
    L20:
        if (r4 == null) goto L22;
    L23:
        if (r3 == false) goto L26;
        ToastUtil.a(2131921456, 0);
    L31:
        HashMap r14 = new HashMap();
        r14.put("oncemore_click_from", "pk_history");
        mz0.n r6 = new mz0.n();
        Map<String, String> r15 = r6.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r15.putAll(r14);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        List<Object> r17 = r6.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_pk_oncemore_click", r6.a, r6.b);
        return;
    L26:
        if (this.c.getRivalLivingRoomId() != 0) goto L28;
        return;
    L28:
        x31.o r22 = this.a.c;
        if (r22 == null) goto L31;
        r22.a50(this.d, this.c, this.e);
    L22:
        r3 = false;
        goto L23
    }
}
