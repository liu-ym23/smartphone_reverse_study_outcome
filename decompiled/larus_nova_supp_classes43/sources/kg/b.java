package kg;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import qf3.i;
import ti.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements d {
    public final pd.b a;

    public final View getHybridView() {
        View r0 = this.a.getHybridView();
        if (r0 != null) goto L5;
        Object r1 = "null";
    L6:
        r1.toString();
        return r0;
    L5:
        r1 = r0;
        goto L6
    }

    public final void release() {
        this.a.release();
    }

    public b(pd.b r10) {
        Intrinsics.checkNotNullParameter(r10, "component");
        this.a = r10;
        a.a("ECAnnieComponent");
    }

    public final void a(Object r10) {
        Intrinsics.checkNotNullParameter("H5_visibilityChange", "event");
        Intrinsics.checkNotNullParameter(r10, "params");
        this.a.sendJsEvent("H5_visibilityChange", r10);
    }

    public final void b(i r10) {
        Intrinsics.checkNotNullParameter("mallEndRefresh", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r10, "method");
        this.a.registerMethod("mallEndRefresh", r10);
    }

    public final void load(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a.load(r10, r11);
    }
}
