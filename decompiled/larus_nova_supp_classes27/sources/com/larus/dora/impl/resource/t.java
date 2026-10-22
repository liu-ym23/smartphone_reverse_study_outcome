package com.larus.dora.impl.resource;

import java.io.File;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ DoraResourceTheme a;
    public final /* synthetic */ x b;
    public final /* synthetic */ File c;
    public final /* synthetic */ DoraResourceType d;
    public final /* synthetic */ String e;

    public /* synthetic */ t(DoraResourceTheme r1, x r2, File r3, DoraResourceType r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r8) {
        DoraResourceTheme r0 = this.a;
        final x r2 = this.b;
        final File r3 = this.c;
        final DoraResourceType r5 = this.d;
        final String r6 = this.e;
        final DoraResourceDeviceType r4 = (DoraResourceDeviceType) r8;
        Intrinsics.checkNotNullParameter(r4, "candidateDeviceType");
        return SequencesKt.flatMap(CollectionsKt.asSequence(r0.getLookupOrder$impl_mainlandRelease()), new v(r2, r3, r4, r5, r6));
    }
}
