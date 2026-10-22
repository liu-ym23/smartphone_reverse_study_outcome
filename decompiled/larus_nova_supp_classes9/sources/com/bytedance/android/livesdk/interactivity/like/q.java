package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.base.model.user.IUser;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T, R> implements Function {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final Object apply(Object r2) {
        IUser r3 = (IUser) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return com.bytedance.android.livesdk.chatroom.utils.a1.k(r3.getAvatarThumb());
    }
}
