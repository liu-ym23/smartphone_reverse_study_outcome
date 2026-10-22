package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdk.message.model.va;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends c {
    public long q;
    public long r;
    public final String s;

    public k() {
        this.s = "enter_message";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.r = 0;
        this.q = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r8) {
        z32.d.a(PSNoMessageValueNode.MemberMessageCount);
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.v) == false) goto L37;
        this.c++;
        long r0 = this.f;
        com.bytedance.android.livesdk.interactivity.textmessage.model.v r4 = (com.bytedance.android.livesdk.interactivity.textmessage.model.v) r8;
        IBaseUser r5 = r4.x();
        if (r5 == null) goto L12;
        py.d r6 = r5.getUserHonor();
        if (r6 == null) goto L12;
        int r7 = r6.getLevel();
    L13:
        this.f = r0 + ((long) r7);
        IBaseUser r1 = r4.x();
        if (r1 == null) goto L21;
        int r2 = r1.getGender();
        if (r2 != this.a) goto L19;
        this.d++;
    L19:
        if (r2 != this.b) goto L21;
        this.e++;
    L21:
        this.g += r8.o.longValue();
        this.h += r8.p.longValue();
        va r9 = r4.b;
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.Z0() != 1) goto L26;
    L27:
        this.q++;
    L29:
        if (r9.Z0() != 2) goto L31;
    L32:
        this.r++;
        return;
    L31:
        if (r9.z1() == 2) goto L32;
        return;
    L26:
        if (r9.z1() != 1) goto L29;
    L12:
        r7 = 0;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void b(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "statMap");
        r6.put(this.s + this.j, String.valueOf(this.c));
        r6.put(this.s + this.o, String.valueOf(c(this.f, this.c)));
        r6.put(this.s + this.k, String.valueOf(c(this.g, this.c)));
        r6.put(this.s + this.l, String.valueOf(c(this.h, this.c)));
        r6.put(this.s + this.m, String.valueOf(this.d));
        r6.put(this.s + this.n, String.valueOf(this.e));
        r6.put(this.s + "_fans_pv", String.valueOf(this.q));
        r6.put(this.s + "_fresh_pv", String.valueOf(this.r));
    }
}
