package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class TypedArrayApi26ImplKt {
    public static final TypedArrayApi26ImplKt INSTANCE = null;

    static {
        INSTANCE = new TypedArrayApi26ImplKt();
    }

    private TypedArrayApi26ImplKt() {
    }

    @JvmStatic
    @DoNotInline
    public static final Typeface getFont(TypedArray r10, @StyleableRes int r11) {
        Intrinsics.checkNotNullParameter(r10, "typedArray");
        Typeface r12 = r10.getFont(r11);
        Intrinsics.checkNotNull(r12);
        return r12;
    }
}
