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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", TypedValues.Custom.S_COLOR, "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder r2, int r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        BackgroundColorSpan r0 = new BackgroundColorSpan(r3);
        int r6 = r2.length();
        r5.invoke(r2);
        r2.setSpan(r0, r6, r2.length(), 17);
        return r2;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        StyleSpan r0 = new StyleSpan(1);
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r4.invoke(r0);
        return new SpannedString((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder r2, int r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        ForegroundColorSpan r0 = new ForegroundColorSpan(r3);
        int r6 = r2.length();
        r5.invoke(r2);
        r2.setSpan(r0, r6, r2.length(), 17);
        return r2;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r2, Object r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.length();
        r5.invoke(r2);
        r2.setSpan(r3, r0, r2.length(), 17);
        return r2;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder r5, Object[] r6, Function1<? super SpannableStringBuilder, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r5.length();
        r8.invoke(r5);
        int r9 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L5;
        r5.setSpan(r6[r1], r0, r5.length(), 17);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        StyleSpan r0 = new StyleSpan(2);
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder r2, float r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        RelativeSizeSpan r0 = new RelativeSizeSpan(r3);
        int r6 = r2.length();
        r5.invoke(r2);
        r2.setSpan(r0, r6, r2.length(), 17);
        return r2;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        StrikethroughSpan r0 = new StrikethroughSpan();
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        SubscriptSpan r0 = new SubscriptSpan();
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        SuperscriptSpan r0 = new SuperscriptSpan();
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder r3, Function1<? super SpannableStringBuilder, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        UnderlineSpan r0 = new UnderlineSpan();
        int r1 = r3.length();
        r5.invoke(r3);
        r3.setSpan(r0, r1, r3.length(), 17);
        return r3;
    }
}
