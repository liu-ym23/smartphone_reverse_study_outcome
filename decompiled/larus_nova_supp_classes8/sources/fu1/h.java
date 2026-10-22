package fu1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<V extends View> extends yt1.b<com.bytedance.android.ecom.arch.slice.render.elements.g, V> {
    @Override // yt1.b
    public final int b() {
        T r0 = this.a;
        if ((r0 instanceof com.bytedance.android.ecom.arch.slice.render.elements.f) == false) goto L9;
        if (r0 == 0) goto L8;
        return ((com.bytedance.android.ecom.arch.slice.render.elements.f) r0).getChildCount();
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.render.elements.ISlcViewGroupManager");
    L9:
        return 0;
    }

    @Override // yt1.b
    public final int c() {
        return a1.f(((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).getView());
    }

    @Override // yt1.b
    public final int d() {
        return a1.g(((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).getView());
    }

    @Override // yt1.b
    public final Object e() {
        Intrinsics.checkNotNullParameter("is_separate", LiveEndPageData.TAG_NAME);
        return ((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).o("is_separate");
    }

    @Override // yt1.b
    public final int f() {
        if ((((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).getView() instanceof TextView) == false) goto L9;
        View r0 = ((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).getView();
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0;
        return (int) r1.getPaint().measureText(r1.getText().toString());
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        com.bytedance.android.ecom.arch.slice.render.elements.g r2 = (com.bytedance.android.ecom.arch.slice.render.elements.g) this.a;
        if (r2 == null) goto L14;
        View r3 = r2.getView();
        if (r3 == null) goto L14;
        Integer r4 = Integer.valueOf(r3.getWidth());
    L15:
        int r5 = r4.intValue();
        com.bytedance.android.ecom.arch.slice.render.elements.g r6 = (com.bytedance.android.ecom.arch.slice.render.elements.g) this.a;
        if (r6 == null) goto L22;
        View r7 = r6.getView();
        if (r7 == null) goto L22;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L22;
        int r9 = r8.width;
    L24:
        return Math.max(r5, r9);
    L22:
        r9 = 0;
    L14:
        r4 = null;
        goto L15
    }

    @Override // yt1.b
    public final void g() {
        ((com.bytedance.android.ecom.arch.slice.render.elements.g) this.a).getView().setVisibility(8);
    }

    @Override // yt1.b
    public final yt1.b<com.bytedance.android.ecom.arch.slice.render.elements.g, ? extends View> a(int r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r2 = this.a;     // Catch: Throwable -> L12
        if ((r2 instanceof com.bytedance.android.ecom.arch.slice.render.elements.f) == true) goto L6;
        r2 = null;
    L6:
        com.bytedance.android.ecom.arch.slice.render.elements.f r3 = (com.bytedance.android.ecom.arch.slice.render.elements.f) r2;     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        BaseSlcViewManager r5 = r3.getChildAt(r4);     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r6) == false) goto L17;
        r6 = null;
    L17:
        BaseSlcViewManager r7 = (BaseSlcViewManager) r6;
        if (r7 != null) goto L20;
        return null;
    L20:
        return new h(r7, r7.getView());
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public h(com.bytedance.android.ecom.arch.slice.render.elements.g r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        super(r2, r3);
    }
}
