package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,68:1\n31#2,4:69\n13579#3,2:73\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n34#1:69,4\n34#1:73,2\n*E\n"})
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = 0;
        Object[] r12 = r10.getSpans(0, r10.length(), Object.class);
        Intrinsics.checkNotNullExpressionValue(r12, "getSpans(start, end, T::class.java)");
        int r13 = r12.length;
    L3:
        if (r11 >= r13) goto L5;
        r10.removeSpan(r12[r11]);
        r11 = r11 + 1;
        goto L3
    }

    public static final void set(Spannable r10, int r11, int r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "span");
        r10.setSpan(r13, r11, r12, 17);
    }

    public static final void set(Spannable r10, IntRange r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        Intrinsics.checkNotNullParameter(r12, "span");
        r10.setSpan(r12, r11.getStart().intValue(), r11.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        SpannableString r11 = SpannableString.valueOf(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "valueOf(this)");
        return r11;
    }
}
