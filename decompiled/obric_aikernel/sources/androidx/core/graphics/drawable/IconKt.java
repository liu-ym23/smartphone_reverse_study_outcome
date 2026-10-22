package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Icon r11 = Icon.createWithAdaptiveBitmap(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "createWithAdaptiveBitmap(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Icon r11 = Icon.createWithBitmap(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "createWithBitmap(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Icon r11 = Icon.createWithContentUri(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "createWithContentUri(this)");
        return r11;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Icon r11 = Icon.createWithData(r10, 0, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "createWithData(this, 0, size)");
        return r11;
    }
}
