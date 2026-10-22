package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PorterDuffColorFilter(r11, r10);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new PorterDuffXfermode(r10);
    }
}
