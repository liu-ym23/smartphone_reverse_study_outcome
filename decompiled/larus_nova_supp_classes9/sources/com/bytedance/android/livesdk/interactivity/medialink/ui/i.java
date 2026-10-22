package com.bytedance.android.livesdk.interactivity.medialink.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ MediaMultiAnchorWindowV2 a;

    public i(MediaMultiAnchorWindowV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        MediaMultiAnchorWindowV2 r0 = this.a;
        User.Companion.getClass();
        MediaMultiAnchorWindowV2.d(r0, User.a.a((IBaseUser) r3));
    }
}
