package io.noties.markwon.g;

import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d {
    public static boolean a(int r2, CharSequence r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpanStart(r4) != r2) goto L7;
        return true;
    }

    public static boolean b(int r2, CharSequence r3, Object r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Spanned.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Spanned) ZeusTransformUtils.preCheckCast(r5, Spanned.class, "com.obric.memorydata.plugin")).getSpanEnd(r4) != r2) goto L7;
        return true;
    }
}
