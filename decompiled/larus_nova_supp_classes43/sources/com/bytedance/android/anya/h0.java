package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0<STATE extends MVIState<?>, ACTION extends p, VIEW extends BaseMVIView<STATE, ACTION>> extends DelegatingMVIBindingImpl<STATE, ACTION, VIEW> {
    public final int g;

    public h0(com.bytedance.android.anya.internal.m<?, ACTION> r1, VIEW r10, STATE r11, int r12, Function1<? super DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> r13) {
        super(r1, r10, r11, r13);
        this.g = r12;
    }
}
