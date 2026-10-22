package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T, R> implements Function {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r3) {
        d4 r4 = (d4) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        return Observable.zip(Observable.just(r4), a1.k(r4.b().getAvatarThumb()), g.a);
    }
}
