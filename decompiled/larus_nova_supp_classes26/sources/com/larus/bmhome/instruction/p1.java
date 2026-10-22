package com.larus.bmhome.instruction;

import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p1 implements Function0<ViewModelProvider.Factory> {
    public static final p1 a = null;

    static {
        a = new p1();
    }

    public p1() {
    }

    public final Object invoke() {
        return new ViewModelProvider.NewInstanceFactory();
    }
}
