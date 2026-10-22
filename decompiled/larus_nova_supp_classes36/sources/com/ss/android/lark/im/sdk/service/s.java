package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s<T> implements ObservableOnSubscribe {
    public static final s<T> a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final void subscribe(ObservableEmitter<Map<String, MessageInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "emitter");
        r2.onNext(MapsKt.emptyMap());
        r2.onComplete();
    }
}
