package yt1;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a<T extends View> implements f<T> {
    public a() {
    }

    @Override // yt1.f
    public int getType() {
        return 2;
    }

    @Override // yt1.f
    public final <D> void a(b<D, T> r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "viewDelegate");
        Intrinsics.checkNotNullParameter(r7, "props");
        int r1 = zt1.a.e;
        Intrinsics.checkNotNullParameter(r7, "props");
        Object r2 = null;
        String r0 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r7, "container_type", null);
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r7, "container_name", null);
        String r4 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r7, "component_name", null);
        String r8 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r7, "component_params", null);
        zt1.a r5 = new zt1.a();
        r5.a = r0;
        r5.b = r3;
        r5.c = r4;
        r5.d = r8;
        Object r9 = r6.b;
        if ((r9 instanceof d) == false) goto L6;
        r2 = r9;
    L6:
        d r10 = (d) r2;
        if (r10 == null) goto L10;
        r10.setContainerData(r5);
        return;
    }

    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r1, com.bytedance.android.ecom.arch.slice.render.elements.g r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
    }
}
