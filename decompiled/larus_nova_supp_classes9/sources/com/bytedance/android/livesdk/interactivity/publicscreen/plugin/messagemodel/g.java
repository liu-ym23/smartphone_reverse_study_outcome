package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class g extends s {
    public final m1 l;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public final IBaseUser f() {
        return this.l.getUserInMessage();
    }

    public g(m1 r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.l = r3;
        this.e = Long.valueOf(r3.getMessageId());
        this.f = r3.getMessageMethod();
        this.g = Long.valueOf(r3.getTimestamp());
    }
}
