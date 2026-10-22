package com.bytedance.android.live.core.utils;

import android.content.Context;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class b2 implements Function0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ File b;

    public /* synthetic */ b2(Context r1, File r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        return TTLiveFileProvider.c(this.a, this.b);
    }
}
