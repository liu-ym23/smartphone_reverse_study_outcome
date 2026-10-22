package com.larus.bmhome.upload.audio;

import com.larus.network.http.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements v {
    public final /* synthetic */ Function1<Float, Unit> a;

    public f(e r1) {
        this.a = r1;
    }

    public final void G0(float r2) {
        this.a.invoke(Float.valueOf(r2));
    }
}
