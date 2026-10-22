package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {
    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final boolean a(co.e r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        if (Intrinsics.areEqual(r5.f1227b, "js_blocking") == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final Map b(co.e r5) {
        Intrinsics.checkNotNullParameter(r5, "entry");
        return com.lynx.jsbridge.a.g(null, r5.f1228c);
    }

    @Override // com.bytedance.lynx.service.reporter.performance.a
    public final void onInitialize(Context r5) {
    }
}
