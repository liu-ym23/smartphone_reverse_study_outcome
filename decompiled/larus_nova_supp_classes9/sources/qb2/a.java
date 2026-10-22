package qb2;

import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    static {
    }

    public static LottieDrawable a(Spanned r7) {
        Intrinsics.checkNotNullParameter(r7, "spanned");
        DynamicDrawableSpan[] r8 = (DynamicDrawableSpan[]) r7.getSpans(0, r7.length(), DynamicDrawableSpan.class);
        if (r8 == null) goto L13;
        ArrayList r1 = new ArrayList();
        int r3 = r8.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L14;
        Drawable r5 = r8[r4].getDrawable();
        if ((r5 instanceof LottieDrawable) == true) goto L9;
        r5 = null;
    L9:
        LottieDrawable r6 = (LottieDrawable) r5;
        if (r6 == null) goto L12;
        r1.add(r6);
    L12:
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L16;
        return null;
    L16:
        return (LottieDrawable) CollectionsKt.getOrNull(r1, 0);
    L13:
        r1 = null;
        goto L14
    }
}
