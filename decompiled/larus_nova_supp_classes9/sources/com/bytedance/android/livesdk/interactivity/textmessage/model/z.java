package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends com.bytedance.android.livesdk.interactivity.api.entity.f<com.bytedance.android.live.base.model.message.t> implements com.bytedance.android.livesdk.interactivity.api.n {
    public final com.bytedance.android.live.base.model.message.t G;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.i H;

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Boolean B() {
        return Boolean.valueOf(this.H.i());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final DisplayTimeRecorder I() {
        return this.H.j();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Long p() {
        return Long.valueOf(this.H.d());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final PersonalizedDisplayInfo t() {
        IPublicAreaCommon r0 = this.H.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPersonalizedInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.n
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.i a() {
        return this.H;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.i s() {
        return this.H;
    }

    public z(com.bytedance.android.livesdk.interactivity.publicscreen.framework.a r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3) {
        Intrinsics.checkNotNullParameter(r2, "liveMessage");
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        super(r2, 0);
        this.G = r2;
        this.H = r3;
        this.B = r3.b;
    }
}
