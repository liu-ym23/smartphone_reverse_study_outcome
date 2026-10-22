package com.larus.bmhome.upload;

import com.larus.platform.api.c4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k implements c4.c {
    public final /* synthetic */ Function1<String, Unit> a;
    public final /* synthetic */ Function1<String, Unit> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function1<Float, Unit> d;

    public final void onCompileDone() {
        this.b.invoke(this.c);
    }

    public final void onCompileProgress(float r2) {
        this.d.invoke(Float.valueOf(r2));
    }

    public final void a(int r2, String r3) {
        this.a.invoke(r2 + ':' + r3);
    }

    public k(com.larus.uploader.impl.f r1, com.larus.uploader.impl.e r2, String r3, com.larus.uploader.impl.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
