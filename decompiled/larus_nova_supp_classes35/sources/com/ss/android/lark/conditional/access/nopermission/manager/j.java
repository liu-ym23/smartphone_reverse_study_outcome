package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.conditional.access.display.CustomDisplayModel;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T, R> implements Function {
    public static final j<T, R> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r2) {
        CustomDisplayModel r3 = (CustomDisplayModel) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.getConfig();
    }
}
