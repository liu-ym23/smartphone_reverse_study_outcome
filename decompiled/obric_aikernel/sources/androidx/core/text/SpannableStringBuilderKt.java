package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder r10, @ColorInt int r11, Function1<? super SpannableStringBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        BackgroundColorSpan r13 = new BackgroundColorSpan(r11);
        int r14 = r10.length();
        r12.invoke(r10);
        r10.setSpan(r13, r14, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        StyleSpan r12 = new StyleSpan(1);
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        SpannableStringBuilder r11 = new SpannableStringBuilder();
        r10.invoke(r11);
        return new SpannedString(r11);
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder r10, @ColorInt int r11, Function1<? super SpannableStringBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        ForegroundColorSpan r13 = new ForegroundColorSpan(r11);
        int r14 = r10.length();
        r12.invoke(r10);
        r10.setSpan(r13, r14, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r10, Object r11, Function1<? super SpannableStringBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "span");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        int r13 = r10.length();
        r12.invoke(r10);
        r10.setSpan(r11, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r10, Object[] r11, Function1<? super SpannableStringBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "spans");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        int r13 = r10.length();
        r12.invoke(r10);
        int r14 = r11.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        r10.setSpan(r11[r15], r13, r10.length(), 17);
        r15 = r15 + 1;
        goto L3
    L5:
        return r10;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        StyleSpan r12 = new StyleSpan(2);
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder r10, float r11, Function1<? super SpannableStringBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        RelativeSizeSpan r13 = new RelativeSizeSpan(r11);
        int r14 = r10.length();
        r12.invoke(r10);
        r10.setSpan(r13, r14, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        StrikethroughSpan r12 = new StrikethroughSpan();
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        SubscriptSpan r12 = new SubscriptSpan();
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        SuperscriptSpan r12 = new SuperscriptSpan();
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "builderAction");
        UnderlineSpan r12 = new UnderlineSpan();
        int r13 = r10.length();
        r11.invoke(r10);
        r10.setSpan(r12, r13, r10.length(), 17);
        return r10;
    }
}
