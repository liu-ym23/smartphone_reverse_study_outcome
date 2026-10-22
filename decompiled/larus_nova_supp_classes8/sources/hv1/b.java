package hv1;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends b7.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r1) {
        super.onLoadSuccess(r1);
        this.a.c.onRuntimeReady();
    }
}
