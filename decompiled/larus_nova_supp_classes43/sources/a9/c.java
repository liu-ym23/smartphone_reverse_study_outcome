package a9;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements e {
    public c() {
    }

    @Override // a9.e
    public final void stop() {
    }

    @Override // a9.e
    public final void v(Application r10, a r11, f7.b r12) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "settings");
        Intrinsics.checkNotNullParameter(r12, "listener");
    }
}
