package com.ss.android.lark.qrcode.ui;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b0 {
    public final FragmentActivity a;
    public final Function2<Integer, Integer, Unit> b;
    public int c;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(FragmentActivity r2, Function2<? super Integer, ? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r3, "doOnRotationChanged");
        this.a = r2;
        this.b = r3;
        this.c = r2.getWindowManager().getDefaultDisplay().getRotation();
    }
}
