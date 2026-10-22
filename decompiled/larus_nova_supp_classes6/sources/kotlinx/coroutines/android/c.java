package kotlinx.coroutines.android;

import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class c implements m0 {
    public final /* synthetic */ HandlerContext a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ c(HandlerContext r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void dispose() {
        HandlerContext r0 = this.a;
        Runnable r1 = this.b;
        r0.a.removeCallbacks(r1);
    }
}
