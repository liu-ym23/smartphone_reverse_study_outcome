package com.bytedance.android.ec.core.toolbox.rxanimation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Completable;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Completable a(Completable... r10) {
        Intrinsics.checkNotNullParameter(r10, "completables");
        Completable r0 = (Completable) ArraysKt.first(r10);
        if (r10.length <= 1) goto L9;
        List r11 = ArraysKt.toMutableList(r10);
        ListProtector.remove(r11, 0);
        Unit r12 = Unit.INSTANCE;
        Object[] r13 = r11.toArray(new Completable[0]);
        if (r13 == null) goto L8;
        Completable[] r14 = (Completable[]) r13;
        return r0.andThen(a((Completable[]) Arrays.copyOf(r14, r14.length)));
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        return r0;
    }
}
