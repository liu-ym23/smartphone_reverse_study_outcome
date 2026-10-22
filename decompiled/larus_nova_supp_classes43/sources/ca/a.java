package ca;

import android.app.Activity;
import android.view.ViewParent;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // ca.b
    public final boolean G1(ViewParent r10) {
        Intrinsics.checkNotNullParameter(r10, "parentView");
        return false;
    }

    @Override // ca.b
    public final void m0(Activity r1, WebView r10, String r11, String r12, String r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r10, "webView");
    }
}
