package com.obric.aikernel;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f4481a = null;

    static {
        f4481a = new f();
    }

    private f() {
    }

    public final InferServiceWrapper a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return InferEntryHolder.b(InferEntryHolder.f4392a, null, 1, null);
    }
}
