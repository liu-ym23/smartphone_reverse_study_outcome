package fu1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements yt1.f<d> {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // yt1.f
    public final <D> void a(yt1.b<D, d> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewDelegate");
        Intrinsics.checkNotNullParameter(r3, "props");
    }

    @Override // yt1.f
    public int getType() {
        return 3;
    }

    @Override // yt1.f
    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new d(r2);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, fu1.d] */
    @Override // yt1.f
    public final void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r1, com.bytedance.android.ecom.arch.slice.render.elements.g r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "viewManger");
        Intrinsics.checkNotNullParameter(r2, "childViewManager");
        boolean r7 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r1.o("default_hide"));
        Object r8 = r1.getView();
        if ((r8 instanceof d) == true) goto L5;
        r8 = null;
    L5:
        ?? r9 = (d) r8;
        if (r9 != 0) goto L8;
        return;
    L8:
        if (r7 == true) goto L10;
        return;
    L10:
        if (r5 <= r9.getWidth()) goto L20;
        if (r2.getView().getVisibility() != 0) goto L29;
        UtilityKotlinExtentionsKt.t(r2.getView());
        View r10 = r9.getLastSeparateView();
        if (r10 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r10);
    L16:
        r9.getAutoGoneViewSet().add(r2.getView());
        View r11 = r9.getLastSeparateView();
        if (r11 == null) goto L29;
        r9.getAutoGoneViewSet().add(r11);
    L29:
        int r12 = com.bytedance.android.livesdk.dsl.util.c.a;
        Object r13 = r2.o("is_separate");
        if (r13 == null) goto L32;
        boolean r14 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r13);
    L33:
        if (r14 == false) goto L35;
        r9.setLastSeparateView(r2.getView());
        return;
    L35:
        r9.setLastSeparateView(null);
        return;
    L32:
        r14 = false;
        goto L33
    L20:
        if (r2.getView().getVisibility() != 8) goto L29;
        Iterator<T> r15 = r9.getAutoGoneViewSet().iterator();
    L23:
        if (r15.hasNext() == false) goto L29;
        View r16 = (View) r15.next();
        if (Intrinsics.areEqual(r16, r2.getView()) == true) goto L28;
        if (Intrinsics.areEqual(r16, r9.getLastSeparateView()) == false) goto L23;
    L28:
        UtilityKotlinExtentionsKt.w(r16);
        goto L23
    }
}
