package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannableStringKt {
    public static final void clearSpans(Spannable r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        Spanned r0 = (Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), Object.class);
        int r2 = r1.length;
    L3:
        if (r3 >= r2) goto L5;
        r5.removeSpan(r1[r3]);
        r3 = r3 + 1;
        goto L3
    }

    public static final void set(Spannable r2, int r3, int r4, Object r5) {
        ((Spannable) ZeusTransformUtils.wrapperContextForParams(r2, Spannable.class, "com.obric.memorydata.plugin")).setSpan(r5, r3, r4, 17);
    }

    public static final void set(Spannable r2, IntRange r3, Object r4) {
        ((Spannable) ZeusTransformUtils.wrapperContextForParams(r2, Spannable.class, "com.obric.memorydata.plugin")).setSpan(r4, r3.getStart().intValue(), r3.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(CharSequence r2) {
        return (Spannable) ZeusTransformUtils.preCheckCast(SpannableString.valueOf((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin")), Spannable.class, "com.obric.memorydata.plugin");
    }
}
