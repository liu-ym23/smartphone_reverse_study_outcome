package com.obric.miniapp.utils;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i0 implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ g b;

    public i0(AtomicBoolean r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Throwable r5 = (Throwable) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        FLogger.a.e("DatePickerUtils", "showDateTimePickerV2 show() failed: " + r5.getMessage());
        a0.t(this.a, this.b, null);
        return Unit.INSTANCE;
    }
}
