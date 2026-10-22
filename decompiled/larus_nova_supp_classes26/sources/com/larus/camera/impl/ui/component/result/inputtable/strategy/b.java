package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Fragment a;

    public /* synthetic */ b(Fragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Fragment r0 = this.a;
        FragmentTransaction r4 = (FragmentTransaction) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$inTransaction");
        return r4.show(r0);
    }
}
