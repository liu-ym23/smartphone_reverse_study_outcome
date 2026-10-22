package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public n(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Integer r2 = (Integer) r1;
        this.a.invoke();
    }
}
