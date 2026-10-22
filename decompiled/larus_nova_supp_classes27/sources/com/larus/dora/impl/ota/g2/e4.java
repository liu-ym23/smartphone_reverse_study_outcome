package com.larus.dora.impl.ota.g2;

import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e4 {
    public static final e49.a a(e5 r15) {
        Intrinsics.checkNotNullParameter(r15, "<this>");
        return new e49.a(new z39.a(CollectionsKt.listOf(new OTAUpdatePackage(Integer.valueOf((int) r15.h().c()), r15.h().d(), r15.g(), Integer.valueOf((int) r15.h().e()), r15.h().getType(), r15.i(), r15.h().f(), r15.b(), Long.valueOf(r15.c()))), new OTAUpdateMeta(r15.e(), r15.f(), r15.d()), r15.l(), r15.k()), r15.j(), false, 4);
    }
}
