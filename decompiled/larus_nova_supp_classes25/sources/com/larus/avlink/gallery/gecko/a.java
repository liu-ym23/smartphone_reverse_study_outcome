package com.larus.avlink.gallery.gecko;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements Function1<String, Unit> {
    public final /* synthetic */ MorphoGeckoFileHelper a;
    public final /* synthetic */ i<String> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(MorphoGeckoFileHelper r1, i<? super String> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        String r5 = (String) r4;
        Intrinsics.checkNotNullParameter(r5, "filePath");
        MorphoGeckoFileHelper r0 = this.a;
        MorphoGeckoFileHelper r2 = MorphoGeckoFileHelper.a;
        r0.getClass();
        MorphoGeckoFileHelper.h("[download] getResPath: filePath=" + r5);
        if (this.b.isActive() == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(r5));
    L6:
        return Unit.INSTANCE;
    }
}
