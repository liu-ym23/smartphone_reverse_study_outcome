package fu1;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements yt1.f<fu1.a> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.f
    public final <D> void a(yt1.b<D, fu1.a> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewDelegate");
        Intrinsics.checkNotNullParameter(r3, "props");
    }

    @Override // yt1.f
    public int getType() {
        return 1;
    }

    @Override // yt1.f
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        fu1.a r0 = new fu1.a(r2);
        r0.setTypeface(Typeface.SANS_SERIF);
        return r0;
    }

    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r1, com.bytedance.android.ecom.arch.slice.render.elements.g r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
    }
}
