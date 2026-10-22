package ly;

import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.f {
    public final /* synthetic */ b7.a a;
    public final /* synthetic */ Uri b;

    public final void onRuntimeReady(View r2) {
        this.a.onLoadSuccess(r2);
    }

    public b(h.c r1, Uri r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onLoadFailed(View r3, String r4) {
        this.a.onLoadFail(r3, this.b.toString(), r4);
    }

    public final void onLoadStart(Uri r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.a.onLoadStart(r3, true);
    }
}
