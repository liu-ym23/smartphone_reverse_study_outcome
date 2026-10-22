package com.larus.chat.gallery.impl.preview;

import com.facebook.datasource.DataSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements Function1<Throwable, Unit> {
    public final /* synthetic */ DataSource<Void> a;

    public b(DataSource<Void> r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1) {
        Throwable r2 = (Throwable) r1;
        this.a.close();
        return Unit.INSTANCE;
    }
}
