package com.bytedance.android.live.core.tetris.layer.core.delegate;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.layout.LayoutManager;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import j70.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "Lh70/b;", "C", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "Lcom/bytedance/android/live/core/tetris/layer/core/ViewLayer;", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/b;", "<init>", "()V", "a", "b", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ViewLayerDelegate<C extends h70.b> extends LayerDelegate<ViewLayer, C> implements com.bytedance.android.live.core.tetris.layer.core.delegate.b {
    public static final Lazy l = null;
    public LayoutManager g;
    public com.bytedance.android.live.core.tetris.layer.core.delegate.a h;
    public v70.a i;
    public final Lazy j;
    public final Map<f, l70.a<C>> k;

    public static final class a {
    }

    public final class b implements Runnable {
        public boolean a;
        public final f b;
        public final ElementConstraint c;
        public final /* synthetic */ ViewLayerDelegate d;

        public final void a() {
            if (this.a == true) goto L6;
            ALogger.i("ShadowPlayerPosition", "Runnable[" + hashCode() + "] is expired");
            return;
        L6:
            ALogger.i("ShadowPlayerPosition", "ViewLayerDelegate delay refresh in Runnable[" + hashCode() + ']');
            if (this.d.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L12;
            LayoutManager r0 = this.d.g;
            if (r0 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        L11:
            r0.b(this.b, this.c, this.d.h(), this.d.i());
        L12:
            ViewLayerDelegate r1 = this.d;
            Lazy r2 = ViewLayerDelegate.l;
            r1.r().remove(this.b);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ViewLayerDelegate r2, f r3, ElementConstraint r4) {
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r4, "elementConstraint");
            this.d = r2;
            this.b = r3;
            this.c = r4;
            this.a = true;
        }
    }

    public final HashMap<f, ViewLayerDelegate<C>.b> r() {
        return (HashMap) this.j.getValue();
    }

    public void t() {
    }

    static {
        l = LazyKt.lazy(ViewLayerDelegate$Companion$fixOnMeasureNotInvoke$2.INSTANCE);
    }

    public final v70.a s() {
        v70.a r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewProxy");
    L5:
        return r0;
    }

    public ViewLayerDelegate() {
        this.j = LazyKt.lazy(ViewLayerDelegate$postRunnableMap$2.INSTANCE);
        this.k = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public void onDestroy() {
        super.onDestroy();
        r().clear();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void b(Element<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "element");
        super.b(r4);
        if (this.k.containsKey(r4.d) == false) goto L19;
        l70.a r0 = (l70.a) ((LinkedHashMap) this.k).get(r4.d);
        if (r0 == null) goto L7;
        C r2 = i();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.a = r2;
    L7:
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r0.d = this;
    L9:
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r0.c = this;
    L11:
        if (r0 == null) goto L17;
        v70.c r3 = r4.h();
        if (r3 == null) goto L16;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.b = r3;
        goto L17
    L16:
        throw new RuntimeException(r4.d + " is invalid.");
    L17:
        if (r0 == null) goto L19;
        r0.c();
    L19:
        LocalTestManager.a(new Class[]{wy.a.class});
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate
    public final void e(Element<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        super.e(r3);
        if (this.k.containsKey(r3.d) == false) goto L8;
        Map<f, l70.a<C>> r0 = this.k;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        l70.a r4 = (l70.a) r1.get(r3.d);
        if (r4 == null) goto L9;
        r4.d();
        return;
    L9:
        return;
    }

    public final void m(l70.a<C> r3) {
        Intrinsics.checkNotNullParameter(r3, "elementDelegate");
        if (this.k.containsKey(r3.f) == true) goto L6;
        this.k.put(r3.f, r3);
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r3.e = this;
        return;
    }

    public final v70.c p(f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        Element<?> r3 = h().f2(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.h();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.delegate.b
    public final void a(f r2, ElementConstraint r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "elementConstraint");
        o(r2, r3);
    }

    public final void o(f r7, ElementConstraint r8) {
        Intrinsics.checkNotNullParameter(r7, "target");
        Intrinsics.checkNotNullParameter(r8, "elementConstraint");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (((Boolean) l.getValue()).booleanValue() == false) goto L17;
        ALogger.i("ShadowPlayerPosition", "fixApplyConstraint " + r7 + " , layer isInLayout: " + h().g);
        if (h().g == true) goto L13;
        ViewLayerDelegate<C>.b r0 = r().get(r7);
        if (r0 == null) goto L9;
        ALogger.i("ShadowPlayerPosition", "ViewLayerDelegate remove delay refresh Runnable[" + r0.hashCode() + ']');
        r0.a = false;
        ((ViewLayer) h()).removeCallbacks(r0);
        ViewLayerDelegate<C>.b r1 = r().remove(r7);
    L9:
        LayoutManager r2 = this.g;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L12:
        r2.b(r7, r8, h(), i());
        return;
    L13:
        ViewLayerDelegate<C>.b r3 = new b(this, r7, r8);
        ViewLayerDelegate<C>.b r9 = r().get(r7);
        if (r9 == null) goto L16;
        r9.a = false;
        ((ViewLayer) h()).removeCallbacks(r9);
    L16:
        r().put(r7, r3);
        ((ViewLayer) h()).post(r3);
        return;
    L17:
        LayoutManager r4 = this.g;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L20:
        r4.b(r7, r8, h(), i());
    }
}
