package com.larus.drive.sdk.impl.service;

import android.os.Bundle;
import com.larus.ui.arch.component.external.api.receiver.Container;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements Function1<fp8.b, Unit> {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ Container b;

    public b(Bundle r1, Container r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        fp8.b r5 = (t1a.c) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        fp8.b r6 = fp8.b.a(r5, null, this.a.getInt("bottom_tab_height", 0), 3);
        t1a.e r0 = s1a.d.a(this.b).p(Reflection.getOrCreateKotlinClass(fp8.b.class));
        if (r0 == null) goto L5;
        r0.a(new c(r6));
    L9:
        return Unit.INSTANCE;
    L5:
        x1a.b r7 = x1a.a.c;
        if (r7 == null) goto L9;
        r7.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());
        goto L9
    }
}
