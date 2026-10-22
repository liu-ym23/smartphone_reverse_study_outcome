package ko1;

import android.content.Context;
import android.view.GestureDetector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends GestureDetector {
    /* JADX WARN: Multi-variable type inference failed */
    public h(Context r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "scrollGestureListener");
        super(r2, r3);
        new GestureDetector(r2, r3);
    }
}
