package vt8;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import com.larus.platform.model.MarkDownSelectorSettings;
import io.noties.markwon.ext.tables.TableRowSpan2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import lw8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final Lazy a = null;
    public static int b;

    static {
        a = LazyKt.lazy(new b());
        b = -1;
    }

    public static MarkDownSelectorSettings a() {
        return (MarkDownSelectorSettings) a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d b(int r3, TextView r4) {
        CustomMarkdownTextView r1 = null;
        if (r3 == 1) goto L27;
        if (r3 == 2) goto L23;
        if (r3 == 3) goto L34;
        if (r3 == 4) goto L18;
        if (r3 == 5) goto L32;
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L31;
        r1 = (CustomMarkdownTextView) r4;
    L31:
        return new f(r1);
    L32:
        return new a();
    L18:
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L33;
        r1 = (CustomMarkdownTextView) r4;
    L33:
        return new f(r1);
    L34:
        return new e();
    L23:
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L35;
        r1 = (CustomMarkdownTextView) r4;
    L35:
        return new h(r1);
    L27:
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L30;
        r1 = (CustomMarkdownTextView) r4;
    L30:
        return new i(r3, r1);
    }

    public static boolean c(int r7, CustomMarkdownTextView r8) {
        if (r8 == null) goto L30;
        l r9 = r8.getMarkdownContent();
        if (r9 == null) goto L30;
        SpannableStringBuilder r10 = r9.e();
        if (r10 == null) goto L30;
        Object[] r1 = r10.getSpans(0, r10.length(), CodeBlockWithLineNumberScrollableSpan.class);
        int r2 = r1.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L20;
        CodeBlockWithLineNumberScrollableSpan r5 = (CodeBlockWithLineNumberScrollableSpan) r1[r3];
        int r6 = r10.getSpanStart(r5);
        if (r7 >= r10.getSpanEnd(r5)) goto L16;
        if (r6 > r7) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == true) goto L18;
        r3 = r3 + 1;
        goto L11
    L18:
        return true;
    L16:
        r11 = false;
        goto L17
    L20:
        Object[] r4 = r10.getSpans(0, r10.length(), TableRowSpan2.class);
        int r12 = r4.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L30;
        TableRowSpan2 r14 = (TableRowSpan2) r4[r13];
        int r15 = r10.getSpanStart(r14);
        if (r7 >= r10.getSpanEnd(r14)) goto L26;
        if (r15 > r7) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == true) goto L28;
        r13 = r13 + 1;
        goto L21
    L28:
        return true;
    L26:
        r16 = false;
    L30:
        return false;
    }

    public static Pair d(String r5, Pair r6) {
        Intrinsics.checkNotNullParameter(r5, "txt");
        if (r6 != null) goto L6;
        return null;
    L6:
        String r7 = r5.substring(((Number) r6.getFirst()).intValue(), ((Number) r6.getSecond()).intValue());
        int r0 = ((Number) r6.getFirst()).intValue();
        int r1 = r7.length();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L12;
        if (CharsKt.isWhitespace(r7.charAt(r3)) == false) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        String r2 = r7.substring(0, r3);
    L13:
        int r4 = r0 + r2.length();
        int r8 = ((Number) r6.getSecond()).intValue();
        int r9 = StringsKt.getLastIndex(r7);
    L15:
        if ((-1) >= r9) goto L21;
        if (CharsKt.isWhitespace(r7.charAt(r9)) == false) goto L18;
        r9 = r9 - 1;
        goto L15
    L18:
        r7 = r7.substring(r9 + 1);
    L21:
        return TuplesKt.to(Integer.valueOf(r4), Integer.valueOf(r8 - r7.length()));
    L12:
        r2 = r7;
        goto L13
    }
}
