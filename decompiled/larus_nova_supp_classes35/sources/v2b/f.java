package v2b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.ss.android.lark.widget.span.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static void a(SpannableStringBuilder r4, Context r5) {
        if (r4.getSpans(r4.length() - 1, r4.length(), ImageSpan.class).length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L10;
        r4.append("\n\n");
        e0.a r1 = new e0.a();
        r1.a = zz7.b.g(r5, 5);
        r4.setSpan(new e0(r1), r4.length() - 1, r4.length(), 33);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L7
    }
}
