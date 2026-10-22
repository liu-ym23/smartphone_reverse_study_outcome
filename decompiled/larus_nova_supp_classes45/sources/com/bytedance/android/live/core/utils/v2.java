package com.bytedance.android.live.core.utils;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v2 {
    public static u2 a(Function0 r8, Function0 r9, Function0 r11) {
        Intrinsics.checkNotNullParameter(r8, "onStart");
        Intrinsics.checkNotNullParameter(r9, "onEnd");
        Intrinsics.checkNotNullParameter(r11, "onFailure");
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = AnimationStatus.IDLE;
        RxUtilKt.c(Observable.timer(j40.o.a.getValue().longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t2(r1, null)), null);
        return new u2(r1, null, r11, r8, r9, null);
    }
}
