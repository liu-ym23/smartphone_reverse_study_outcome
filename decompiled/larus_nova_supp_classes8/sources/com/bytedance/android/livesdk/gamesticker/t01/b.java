package com.bytedance.android.livesdk.gamesticker.t01;

import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Predicate {
    public final /* synthetic */ ArrayList a;

    public b(ArrayList r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Long r3 = (Long) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return this.a.contains(r3);
    }
}
