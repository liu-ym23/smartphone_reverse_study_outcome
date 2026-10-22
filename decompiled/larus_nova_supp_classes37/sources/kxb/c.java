package kxb;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.hang.detect.JSPingCheckSource;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<T> implements ValueCallback {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r7) {
        String r0 = (String) r7;
        Lazy<Handler> r8 = ThreadUtil.a;
        ThreadUtil.a.e(this.a.m);
        if (this.a.g == false) goto L14;
        if (r0 == null) goto L7;
        String r9 = StringsKt.replace$default(r0, "\"", "", false, 4, null);
    L9:
        if (Intrinsics.areEqual(r9, "complete") == false) goto L11;
        b.a(this.a, JSPingCheckSource.AFTER_READY.getValue());
        return;
    L11:
        j.e("RunJSPingHangDetector", "page is " + r9 + ", not ready, wait " + this.a.e + "ms to ping");
        b r10 = this.a;
        ThreadUtil.a.d(r10.l, r10.e);
        return;
    L7:
        r9 = null;
        goto L9
    }
}
