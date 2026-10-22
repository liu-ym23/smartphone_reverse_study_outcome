package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ a a;

    public s(a r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Unit) r3, "it");
        return Observable.timer(this.a.a.b.getDynamicAnimDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
    }
}
