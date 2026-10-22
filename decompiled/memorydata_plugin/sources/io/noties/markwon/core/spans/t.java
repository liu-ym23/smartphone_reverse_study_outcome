package io.noties.markwon.core.spans;

import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<TextView> f16482a;

    public t(TextView r2) {
        this.f16482a = new WeakReference(r2);
    }

    public static TextView a(Spanned r4) {
        Spanned r5 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin");
        t[] r6 = (t[]) ZeusTransformUtils.preCheckCast(r5.getSpans(0, r5.length(), t.class), t[].class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L7:
        return null;
    L5:
        if (r6.length <= 0) goto L7;
        return r6[0].a();
    }

    public static TextView a(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Spanned.class) == true) goto L5;
        return null;
    L5:
        return a((Spanned) ZeusTransformUtils.preCheckCast(r3, Spanned.class, "com.obric.memorydata.plugin"));
    }

    public static void a(Spannable r5, TextView r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.memorydata.plugin");
        t[] r0 = (t[]) ZeusTransformUtils.preCheckCast(r7.getSpans(0, r7.length(), t.class), t[].class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r7.removeSpan(r0[r2]);
        r2 = r2 + 1;
    L7:
        r7.setSpan(new t(r6), 0, r7.length(), 18);
    }

    public TextView a() {
        return (TextView) ZeusTransformUtils.preCheckCast(this.f16482a.get(), TextView.class, "com.obric.memorydata.plugin");
    }
}
