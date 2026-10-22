package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.r1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends c {
    public final String q;
    public boolean r;
    public IRoom s;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m t;
    public int u;
    public int v;
    public int w;

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void d() {
        this.s = null;
        this.t = null;
    }

    public a() {
        this.q = "low";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.u = 0;
        this.v = 0;
        this.w = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7) {
        super.a(r7);
        if (this.r == false) goto L11;
        IRoom r0 = this.s;
        if (r0 == null) goto L11;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L11;
        if (r1.isAnchorColdMessageTiled() != true) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r3 = this.t;
        if (r3 != null) goto L17;
    L19:
        if (r7 == null) goto L47;
        l4 r8 = r7.b;
        if (r8 == null) goto L53;
        m0 r4 = r8.getBaseMessage();
        if (r4 != null) goto L26;
        return;
    L26:
        if (r4.getAnchorFoldTypeV2() == 3) goto L29;
        return;
    L29:
        if ((r8 instanceof r1) == false) goto L32;
        this.u++;
        return;
    L32:
        if ((r8 instanceof l4) == false) goto L50;
        l4 r9 = r8;
        if (r9.getAction() != 1) goto L36;
    L45:
        this.v++;
        return;
    L36:
        if (r9.getAction() == 2) goto L45;
        if (r9.getAction() == 4) goto L45;
        if (r9.getAction() == 5) goto L45;
        if (r9.getAction() != 3) goto L51;
        this.w++;
        return;
    L51:
        return;
    L50:
        return;
    L53:
        return;
    L47:
        return;
    L17:
        if (((aa2.w) r3).a() == true) goto L19;
        return;
    L11:
        r2 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "statMap");
        if (this.r == false) goto L11;
        IRoom r0 = this.s;
        if (r0 == null) goto L11;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.isAnchorColdMessageTiled() != true) goto L11;
    L12:
        if (r2 == true) goto L14;
        return;
    L14:
        r4.put(this.q + "_like", String.valueOf(this.u));
        r4.put(this.q + "_follow", String.valueOf(this.v));
        r4.put(this.q + "_share", String.valueOf(this.w));
        r4.put(this.q + "_all", String.valueOf((this.u + this.v) + this.w));
        return;
    L11:
        r2 = false;
        goto L12
    }
}
