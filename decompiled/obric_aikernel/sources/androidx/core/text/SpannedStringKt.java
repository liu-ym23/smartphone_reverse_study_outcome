package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        T[] r13 = (T[]) r10.getSpans(r11, r12, Object.class);
        Intrinsics.checkNotNullExpressionValue(r13, "getSpans(start, end, T::class.java)");
        return r13;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = r10.length();
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object[] r15 = r10.getSpans(r11, r12, Object.class);
        Intrinsics.checkNotNullExpressionValue(r15, "getSpans(start, end, T::class.java)");
        return r15;
    }

    public static final Spanned toSpanned(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SpannedString r11 = SpannedString.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }
}
