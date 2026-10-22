package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.utils.MessageCommonColorUtil;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends s {
    public final PublicScreenConfig$MessageModelType l;
    public final IBaseUser m;
    public final IPublicAreaCommon n;
    public final s.c o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public PSMessageAction s;
    public final /* synthetic */ IBaseUser t;
    public final /* synthetic */ IPublicAreaCommon u;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final PSMessageAction a() {
        return this.s;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IPublicAreaCommon c() {
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final boolean e() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IBaseUser f() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final boolean g() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public PublicScreenConfig$MessageModelType getType() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final boolean i() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final s.c k() {
        return this.o;
    }

    public t(PublicScreenConfig$MessageModelType r2, IBaseUser r3, IPublicAreaCommon r4, Integer r5, String r6, boolean r7, boolean r8, boolean r9, PSMessageAction r10) {
        this.t = r3;
        this.u = r4;
        this.l = r2;
        this.m = r3;
        this.n = r4;
        if (r5 == null) goto L5;
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r6));
        int r11 = r5.intValue();
        r0.b = new s.a(r11, r11);
        s.c r13 = new s.c(r0, false, 6);
    L6:
        this.o = r13;
        this.p = r7;
        this.q = r8;
        this.r = r9;
        if (r10 != PSMessageAction.UNKNOW) goto L13;
        if (r7 == false) goto L12;
        PSMessageAction r14 = PSMessageAction.BASIC;
    L11:
        r10 = r14;
        goto L13
    L12:
        r14 = PSMessageAction.CHAT;
    L13:
        this.s = r10;
        return;
    L5:
        tb2.d r15 = new tb2.d();
        r15.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r6));
        int r1 = MessageCommonColorUtil.a;
        int r16 = MessageCommonColorUtil.d();
        r15.b = new s.a(r16, r16);
        r13 = new s.c(r15, false, 6);
        goto L6
    }
}
