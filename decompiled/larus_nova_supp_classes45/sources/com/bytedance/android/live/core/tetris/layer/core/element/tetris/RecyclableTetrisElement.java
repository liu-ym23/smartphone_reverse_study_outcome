package com.bytedance.android.live.core.tetris.layer.core.element.tetris;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import h70.b;
import j70.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k70.c;
import k70.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t70.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/tetris/RecyclableTetrisElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Lh70/b;", "Lk70/d;", "a", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RecyclableTetrisElement extends Element<Tetris<? extends b>> implements d {
    public static final Map<Class<k>, View> t = null;
    public static final a u = null;
    public final Lazy l;
    public final Lazy m;
    public final List<Element<?>> n;
    public final k o;
    public final c p;
    public final b q;
    public final p70.b r;
    public final com.bytedance.android.live.core.tetris.layer.core.data.b s;

    public static final class a {
        public a() {
        }
    }

    public final Tetris<b> l() {
        return (Tetris) this.m.getValue();
    }

    static {
        u = new a();
        t = new HashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Tetris<? extends b> i() {
        return l();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        if ((l() instanceof o70.a) == false) goto L9;
        LifecycleOwnerCompat r0 = l();
        if (r0 == null) goto L8;
        return (o70.a) r0;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        l().J();
        if (this.o.k() == false) goto L10;
        View r0 = l().L();
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L7;
        r1 = null;
    L7:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L10;
        r2.removeView(r0);
    L10:
        ((ArrayList) this.n).clear();
        getLifecycle().removeObserver(l());
        com.bytedance.android.live.core.tetris.componentx.component.b r3 = this.c;
        if (r3 == null) goto L14;
        r3.e(this, l());
        return;
    }

    @Override // k70.d
    public final void a(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        ((ArrayList) this.n).remove(r2);
    }

    @Override // k70.d
    public final void b(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (((ArrayList) this.n).contains(r2) == true) goto L6;
        ((ArrayList) this.n).add(r2);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r2) {
        com.bytedance.android.live.core.tetris.componentx.component.b r3 = this.c;
        if (r3 == null) goto L5;
        r3.c(this, l());
    L5:
        getLifecycle().addObserver(l());
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r4 = l().G((g) this.l.getValue());
        Map<Class<k>, View> r5 = t;
        HashMap r6 = (HashMap) r5;
        r6.put(this.o.getClass(), r4);
        Tetris<b> r7 = l();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.h = r4;
        return r4;
    }

    public RecyclableTetrisElement(k r2, c r3, b r4, p70.b r5, com.bytedance.android.live.core.tetris.layer.core.data.b r6) {
        Intrinsics.checkNotNullParameter(r2, "tetrisAttribute");
        Intrinsics.checkNotNullParameter(r3, "elementFactory");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "processChains");
        Intrinsics.checkNotNullParameter(r6, "vmProvider");
        super(r4);
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.l = LazyKt.lazy(new RecyclableTetrisElement$recyclableTetrisLayoutInflater$2(this));
        this.m = LazyKt.lazy(new RecyclableTetrisElement$tetris$2(this));
        this.n = new ArrayList();
    }
}
