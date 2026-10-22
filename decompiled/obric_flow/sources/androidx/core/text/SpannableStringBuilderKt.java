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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "color", "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder r5, @ColorInt int r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        BackgroundColorSpan r12 = new BackgroundColorSpan(r10);
        int r13 = r5.length();
        r11.invoke(r5);
        r5.setSpan(r12, r13, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        StyleSpan r11 = new StyleSpan(1);
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> r5) {
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        r5.invoke(r10);
        return new SpannedString(r10);
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder r5, @ColorInt int r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        ForegroundColorSpan r12 = new ForegroundColorSpan(r10);
        int r13 = r5.length();
        r11.invoke(r5);
        r5.setSpan(r12, r13, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r5, Object[] r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        int r12 = r5.length();
        r11.invoke(r5);
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r5.setSpan(r10[r14], r12, r5.length(), 17);
        r14 = r14 + 1;
        goto L3
    L5:
        return r5;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        StyleSpan r11 = new StyleSpan(2);
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder r5, float r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        RelativeSizeSpan r12 = new RelativeSizeSpan(r10);
        int r13 = r5.length();
        r11.invoke(r5);
        r5.setSpan(r12, r13, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        StrikethroughSpan r11 = new StrikethroughSpan();
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        SubscriptSpan r11 = new SubscriptSpan();
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        SuperscriptSpan r11 = new SuperscriptSpan();
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder r5, Function1<? super SpannableStringBuilder, Unit> r10) {
        UnderlineSpan r11 = new UnderlineSpan();
        int r12 = r5.length();
        r10.invoke(r5);
        r5.setSpan(r11, r12, r5.length(), 17);
        return r5;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r5, Object r10, Function1<? super SpannableStringBuilder, Unit> r11) {
        int r12 = r5.length();
        r11.invoke(r5);
        r5.setSpan(r10, r12, r5.length(), 17);
        return r5;
    }
}
