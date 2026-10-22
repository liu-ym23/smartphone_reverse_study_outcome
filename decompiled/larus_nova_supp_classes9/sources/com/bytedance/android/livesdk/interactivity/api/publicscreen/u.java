package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends s {
    public final PublicScreenConfig$MessageModelType l;
    public final IBaseUser m;
    public final IPublicAreaCommon n;
    public final s.c o;
    public final boolean p;
    public final boolean q;
    public PSMessageAction r;
    public final /* synthetic */ IBaseUser s;
    public final /* synthetic */ IPublicAreaCommon t;
    public final /* synthetic */ a5 u;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final PSMessageAction a() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IPublicAreaCommon c() {
        return this.n;
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
    public final boolean h() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.s
    public final s.c k() {
        return this.o;
    }

    public u(PublicScreenConfig$MessageModelType r1, IBaseUser r2, IPublicAreaCommon r3, Text r4, s.a r5, boolean r6, boolean r7, PSMessageAction r8) {
        this.s = r2;
        this.t = r3;
        this.u = r4;
        this.l = r1;
        this.m = r2;
        this.n = r3;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r9 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        Intrinsics.checkNotNullParameter(r4, "text");
        tb2.d r10 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.a(r4, r5);
        r10.d(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.e(r2, false, false));
        r10.b = r5;
        this.o = new s.c(r10, false, 6);
        this.p = r6;
        this.q = r7;
        if (r8 != PSMessageAction.UNKNOW) goto L11;
        if (r6 == false) goto L8;
        PSMessageAction r11 = PSMessageAction.BASIC;
    L7:
        r8 = r11;
        goto L11
    L8:
        if (r7 == false) goto L10;
        r11 = PSMessageAction.SYSTEM;
        goto L7
    L10:
        r11 = PSMessageAction.CHAT;
    L11:
        this.r = r8;
    }
}
