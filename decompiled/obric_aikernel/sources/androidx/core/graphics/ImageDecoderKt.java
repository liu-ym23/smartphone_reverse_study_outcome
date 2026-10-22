package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source r10, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Bitmap r12 = ImageDecoder.decodeBitmap(r10, new AnonymousClass1(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "crossinline action: Imag…ction(info, source)\n    }");
        return r12;
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source r10, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Drawable r12 = ImageDecoder.decodeDrawable(r10, new C03271(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "crossinline action: Imag…ction(info, source)\n    }");
        return r12;
    }
}
