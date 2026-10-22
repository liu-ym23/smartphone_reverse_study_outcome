package com.bytedance.android.livesdk.clearscreen.utils;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements SingleOnSubscribe {
    public final /* synthetic */ boolean a;

    public d(boolean r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (this.a == false) goto L5;
        ClearScreenLogUtils.Companion r5 = ClearScreenLogUtils.a;
        Map r2 = MapsKt.emptyMap();
        r5.getClass();
        ClearScreenLogUtils.Companion.d(null, "slide_room", r2);
        return;
    L5:
        ClearScreenLogUtils.Companion r6 = ClearScreenLogUtils.a;
        Map r3 = MapsKt.emptyMap();
        r6.getClass();
        ClearScreenLogUtils.Companion.f(null, "slide_room", r3);
    }
}
