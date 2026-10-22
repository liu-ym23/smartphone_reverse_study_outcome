package sga;

import android.view.View;
import com.obric.assistant.spi.office.OfficeSdkLazyInitServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (OfficeSdkLazyInitServiceDelegate.a.b() == true) goto L5;
        return;
    L5:
        r2.getViewTreeObserver().addOnPreDrawListener(new d(r2));
    }
}
