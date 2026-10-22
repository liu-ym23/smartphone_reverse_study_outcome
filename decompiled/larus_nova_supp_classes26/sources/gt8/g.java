package gt8;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements d.b {
    public final /* synthetic */ d a;

    @Override // gt8.d.b
    public int getType() {
        return 0;
    }

    public g(d r1) {
        this.a = r1;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.f.onTouchEvent(r2);
    }
}
