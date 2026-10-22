package com.bytedance.android.live.core.utils;

import android.content.Context;
import java.io.File;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class z1 implements Function1 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ File b;

    public /* synthetic */ z1(Context r1, File r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return TTLiveFileProvider.b(this.a, this.b, (kjc.c) r3);
    }
}
