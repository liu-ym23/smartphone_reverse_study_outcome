package com.lynx.tasm.ui.image;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s implements Supplier<DataSource<Object>> {
    public final /* synthetic */ q a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ LynxAbstractDraweeControllerBuilder.CacheLevel d;
    public final /* synthetic */ LynxAbstractDraweeControllerBuilder e;

    public final Object get() {
        return this.e.a(this.a, this.b, this.c, this.d);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("request", this.b.toString()).toString();
    }

    public s(LynxAbstractDraweeControllerBuilder r1, u r2, String r3, Object r4, Object r5, LynxAbstractDraweeControllerBuilder.CacheLevel r6) {
        this.e = r1;
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
