package ve8;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final int a(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ContextCompat.getColor(r2, r1);
    }
}
