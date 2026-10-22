package vo1;

import android.view.View;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.c0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends b7.a {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ String b;

    public final void onLoadSuccess(View r2) {
        super.onLoadSuccess(r2);
        if (r2 == null) goto L11;
        d0 r0 = this.a;
        if (r0 == null) goto L7;
        r0.g(r2);
    L7:
        d0 r1 = this.a;
        if (r1 == null) goto L12;
        r1.d(r2);
        return;
    L12:
        return;
    }

    public b(d0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean onFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        d0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        return super.onFallback(r2, r3);
    }

    public final void onLoadStart(View r2, boolean r3) {
        super.onLoadStart(r2, r3);
        if (r2 == null) goto L8;
        d0 r4 = this.a;
        if (r4 == null) goto L9;
        r4.e(r2, this.b);
        return;
    L9:
        return;
    }

    public final void onContainerError(View r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        super.onContainerError(r2, r3, r4);
        if (r2 == null) goto L7;
        d0 r5 = this.a;
        if (r5 == null) goto L7;
        r5.f(r2, r4);
    L7:
        int r6 = c0.a;
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        v.a();
    }
}
