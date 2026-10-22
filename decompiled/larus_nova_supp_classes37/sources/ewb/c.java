package ewb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements b {
    public final Context a;
    public final View b;
    public final ViewGroup c;

    @Override // ewb.b
    public Context getContext() {
        return this.a;
    }

    public c(Context r2, View r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "notificationContainer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
