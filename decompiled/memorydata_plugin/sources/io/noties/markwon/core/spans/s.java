package io.noties.markwon.core.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Layout> f16481a;

    s(Layout r2) {
        this.f16481a = new WeakReference(r2);
    }

    public static Layout a(Spanned r4) {
        Spanned r5 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r4, Spanned.class, "com.obric.memorydata.plugin");
        s[] r6 = (s[]) ZeusTransformUtils.preCheckCast(r5.getSpans(0, r5.length(), s.class), s[].class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L7:
        return null;
    L5:
        if (r6.length <= 0) goto L7;
        return r6[0].a();
    }

    public static void a(Spannable r5, Layout r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.memorydata.plugin");
        s[] r0 = (s[]) ZeusTransformUtils.preCheckCast(r7.getSpans(0, r7.length(), s.class), s[].class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r7.removeSpan(r0[r2]);
        r2 = r2 + 1;
    L7:
        r7.setSpan(new s(r6), 0, r7.length(), 18);
    }

    public Layout a() {
        return (Layout) ZeusTransformUtils.preCheckCast(this.f16481a.get(), Layout.class, "com.obric.memorydata.plugin");
    }
}
