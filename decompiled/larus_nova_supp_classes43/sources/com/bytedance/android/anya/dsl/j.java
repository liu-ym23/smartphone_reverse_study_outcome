package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.u0;
import com.bytedance.android.anya.z;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class j<SUPER_STATE extends MVIState<?>, STATE extends MVIState<?>> {
    public final z<SUPER_STATE, STATE, ?> a;
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, u0<SUPER_STATE, STATE>> b;

    public j(z r1, Function2 r10) {
        this.a = r1;
        this.b = r10;
    }
}
