package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {
    public a() {
    }

    public abstract String a();

    public abstract ModuleKey b();

    public String c() {
        return null;
    }

    public a d(List<? extends a> r2) {
        Intrinsics.checkNotNullParameter(r2, "records");
        return this;
    }
}
