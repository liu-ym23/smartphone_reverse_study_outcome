package com.ss.android.lark.officesdk;

import com.bytedance.ee.bear.document.r5;
import com.bytedance.ee.bear.document.t5;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class v implements e0c.m {
    public com.ss.android.lark.passportc.internal.f0 a;
    public String b;
    public UserSession c;
    public w0 d;

    @Override // e0c.m
    public final e0c.l build() {
        Preconditions.checkBuilderRequirement(this.a, com.ss.android.lark.passportc.internal.f0.class);
        Preconditions.checkBuilderRequirement(this.b, String.class);
        Preconditions.checkBuilderRequirement(this.c, UserSession.class);
        Preconditions.checkBuilderRequirement(this.d, w0.class);
        return new y(new com.bytedance.ee.bear.integrator.di.d(), new com.bytedance.ee.bear.middleground.unbundle.a(), new com.ss.android.lark.chat.chatwindow.chat.v2.push.b(), new tz4.b(), new com.bytedance.ee.bear.basesdk.services.container.b(), new com.bytedance.ee.bear.drive.cache.u(), new eeb.a(), new com.bytedance.lark.lark_biz_feed_android_wrapper.a(), new gkb.a(), new nb5.b(), new r5(), new t5(), new jg5.r(), this.d, this.a, this.b, this.c);
    }

    public v() {
    }

    @Override // e0c.m
    public final e0c.m a(com.ss.android.lark.passportc.internal.f0 r1) {
        this.a = (com.ss.android.lark.passportc.internal.f0) Preconditions.checkNotNull(r1);
        return this;
    }

    @Override // e0c.m
    public final e0c.m b(String r1) {
        this.b = (String) Preconditions.checkNotNull(r1);
        return this;
    }

    @Override // e0c.m
    public final e0c.m userSession(UserSession r1) {
        this.c = (UserSession) Preconditions.checkNotNull(r1);
        return this;
    }
}
