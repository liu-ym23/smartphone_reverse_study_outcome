package com.bytedance.android.live.profit.dress;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T, R> implements Function {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r3) {
        List<? extends p> r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "list");
        if ((!r4.isEmpty()) == false) goto L8;
        j.c.a(r4);
        j.d.getClass();
        String r0 = i.c;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        j.h = r0;
    L8:
        jy0.b.d("DressRepository", "loaded " + r4.size() + " models from storage, version=" + j.h);
        return j.h;
    }
}
