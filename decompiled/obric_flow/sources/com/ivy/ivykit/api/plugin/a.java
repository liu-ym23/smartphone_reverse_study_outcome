package com.ivy.ivykit.api.plugin;

import ai.j0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9478a;

    public a(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "templateJS");
        this.f9478a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 == null) goto L7;
        Class<?> r10 = r5.getClass();
    L9:
        if (Intrinsics.areEqual(a.class, r10) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService.AppletResponse.ComparableByteArray");
        return Arrays.equals(this.f9478a, ((a) r5).f9478a);
    L7:
        r10 = null;
        goto L9
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9478a);
    }

    public final String toString() {
        return j0.k("ComparableByteArray(templateJS=", Arrays.toString(this.f9478a), ")");
    }
}
