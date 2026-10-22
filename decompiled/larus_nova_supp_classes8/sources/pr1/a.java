package pr1;

import android.webkit.WebView;
import ib.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements f {
    public final Function1<Object, Unit> a;
    public final Function2<String, Throwable, Unit> b;

    public final void onLoadStart(String r1, WebView r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<Object, Unit> r1, Function2<? super String, ? super Throwable, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onLoadUriSuccess(String r1, WebView r2) {
        Function1<Object, Unit> r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(r2);
        return;
    }

    public final void onLoadFail(String r1, WebView r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Function2<String, Throwable, Unit> r4 = this.b;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke(r1, r3);
        return;
    }
}
