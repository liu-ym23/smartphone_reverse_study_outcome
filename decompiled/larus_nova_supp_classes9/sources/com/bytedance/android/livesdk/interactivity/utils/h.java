package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends c {
    public long q;
    public long r;
    public final String s;
    public long t;

    public h() {
        this.s = "comment";
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void e() {
        super.e();
        this.q = 0;
        this.r = 0;
        this.t = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.utils.c
    public final void a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r13) {
        super.a(r13);
        z32.d.a(PSNoMessageValueNode.ChatMessageCount);
        k0 r1 = null;
        if ((r13 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.d) == true) goto L5;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r0 = null;
    L6:
        com.bytedance.android.livesdk.interactivity.textmessage.model.d r2 = (com.bytedance.android.livesdk.interactivity.textmessage.model.d) r0;
        boolean r3 = false;
        if (r2 == null) goto L33;
        long r5 = this.q;
        k0 r7 = r2.b;
        if (r7 == null) goto L21;
        String r8 = r7.getContent();
        if (r8 == null) goto L21;
        int r9 = r8.length();
        k0 r10 = r2.b;
        if (r10 == null) goto L19;
        IBaseUser r11 = r10.getUserInfo();
        if (r11 == null) goto L19;
        String r14 = r11.getNickName();
        if (r14 == null) goto L19;
        int r15 = r14.length();
    L20:
        int r16 = r9 + r15;
    L22:
        this.q = r5 + ((long) r16);
        this.r += r2.u() % ((long) 100);
        k0 r4 = r2.b;
        if (r4 == null) goto L29;
        IPublicAreaCommon r6 = r4.getOrInitPublicAreaCommon();
        if (r6 == null) goto L29;
        Map r17 = r6.getTrackingParams();
        if (r17 == null) goto L29;
        String r18 = (String) r17.get("is_potential_flag");
    L31:
        if (Intrinsics.areEqual(r18, "1") == false) goto L33;
        this.i++;
    L29:
        r18 = null;
    L19:
        r15 = 0;
    L21:
        r16 = 0;
    L33:
        if (r13 == null) goto L49;
        k0 r19 = r13.b;
        if (r19 != null) goto L37;
        return;
    L37:
        if ((r19 instanceof k0) == true) goto L39;
        r19 = null;
    L39:
        k0 r110 = r19;
        if (r110 != null) goto L42;
        return;
    L42:
        if (r110.getChatSource() != 13) goto L44;
        r3 = true;
    L44:
        if (r3 == false) goto L46;
        r1 = r110;
    L46:
        if (r1 == null) goto L52;
        this.t++;
        return;
    L52:
        return;
    L49:
        return;
    L5:
        r0 = r13;
        goto L6
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
        r6.put(this.s + "_length_avg", String.valueOf(c(this.q, this.c)));
        r6.put(this.s + "_score_avg", String.valueOf(c(this.r, this.c)));
        r6.put("comment_pv_potential", String.valueOf(this.i));
        r6.put("comment_from_interaction_theme_num", String.valueOf(this.t));
    }
}
