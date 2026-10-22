package io.noties.markwon.g;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.spans.s;
import io.noties.markwon.core.spans.t;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f {
    public static int a(Canvas r2, CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Spanned.class) == false) goto L13;
        Spanned r5 = (Spanned) ZeusTransformUtils.preCheckCast(r4, Spanned.class, "com.obric.memorydata.plugin");
        Layout r0 = s.a(r5);
        if (r0 != null) goto L7;
        TextView r6 = t.a(r5);
        if (r6 == null) goto L13;
        return (r6.getWidth() - r6.getPaddingLeft()) - r6.getPaddingRight();
    L7:
        return r0.getWidth();
    L13:
        return r2.getWidth();
    }
}
