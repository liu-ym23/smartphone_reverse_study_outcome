package com.obric.matrix.platform.sdk.ones.location;

import android.net.Uri;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends MatrixEventObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Function0<Unit> f5912d;

    public a() {
        super("/location/status", false, null, 4, null);
    }

    @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixEventObserver
    public void c(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (this.f5912d != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r10.getPath(), "/location/status") == false) goto L11;
        Function0<Unit> r11 = this.f5912d;
        if (r11 == null) goto L12;
        r11.invoke();
        return;
    L12:
        return;
    }
}
