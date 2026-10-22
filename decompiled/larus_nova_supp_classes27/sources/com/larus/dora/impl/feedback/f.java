package com.larus.dora.impl.feedback;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements Function1<ResourceUploadError, Unit> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object invoke(Object r2) {
        Intrinsics.checkNotNullParameter((ResourceUploadError) r2, "it");
        return Unit.INSTANCE;
    }
}
