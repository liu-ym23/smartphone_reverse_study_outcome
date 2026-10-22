package hnb;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements com.ss.android.lark.endpoint.security.detection.location.a {
    @Inject
    public a() {
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void isGpsSupported(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }
}
