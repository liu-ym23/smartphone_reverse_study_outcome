package androidx.core.graphics;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(Paint r10, BlendModeCompat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return PaintCompat.setBlendMode(r10, r11);
    }
}
