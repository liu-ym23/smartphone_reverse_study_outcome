package com.bytedance.android.anya.dsl;

import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.p0;
import com.bytedance.android.anya.u0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class i<SUPER_STATE extends MVIState<?>, STATE extends MVIState<?>, ACTION extends p> {
    public final b0<SUPER_STATE, STATE, ACTION> a;
    public final Function2<p0<SUPER_STATE>, SUPER_STATE, u0<SUPER_STATE, STATE>> b;
    public final Class<ACTION> c;

    public i(b0 r1, Function2 r10, Class r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
