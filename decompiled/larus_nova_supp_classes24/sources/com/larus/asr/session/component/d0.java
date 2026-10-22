package com.larus.asr.session.component;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d0 {
    public final List<p0> a;
    public final List<o0> b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(List<? extends p0> r2, List<? extends o0> r3) {
        Intrinsics.checkNotNullParameter(r2, "pre");
        Intrinsics.checkNotNullParameter(r3, "post");
        this.a = r2;
        this.b = r3;
    }
}
