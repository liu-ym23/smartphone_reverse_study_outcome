package com.larus.bmhome.bigimg;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g0 implements Function1 {
    public final /* synthetic */ BigImagePhotoViewerDialog a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ g0(BigImagePhotoViewerDialog r1, String r2, int r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r7) {
        final BigImagePhotoViewerDialog r0 = this.a;
        final String r1 = this.b;
        final int r2 = this.c;
        final Function1<? super Continuation<? super Unit>, ? extends Object> r3 = this.d;
        String r8 = (String) r7;
        if (r8 == null) goto L7;
        Function2<? super String, ? super Function2<? super Boolean, ? super String, Unit>, Unit> r4 = r0.P0;
        if (r4 == null) goto L9;
        r4.invoke(r8, new h0(r0, r2, r1, r3));
    L9:
        return Unit.INSTANCE;
    L7:
        int r9 = BigImagePhotoViewerDialog.V0;
        FLogger.a.e("BigImagePhotoViewer", "saveBitmapWithCheckWatermark: failed to get local path for " + r1);
        r0.s(r2, r1, r3);
        goto L9
    }
}
