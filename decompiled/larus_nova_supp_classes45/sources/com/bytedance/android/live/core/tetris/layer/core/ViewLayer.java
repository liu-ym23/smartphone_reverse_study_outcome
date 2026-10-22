package com.bytedance.android.live.core.tetris.layer.core;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.layout.CircleDependException;
import com.bytedance.android.live.core.tetris.layer.core.layout.c;
import com.bytedance.android.live.core.tetris.layer.core.layout.e;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import i70.a;
import j70.d;
import j70.f;
import j70.g;
import j70.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00050\u000bH\u0016R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/ViewLayer;", "Lcom/bytedance/android/live/core/tetris/layer/view/staticlayout/StaticFullScreenViewLayer;", "Li70/a;", "", "Lj70/h;", "Lh70/b;", "getDescriptorSet", "Lf70/b;", "getLayerTypeV2", "Lcom/bytedance/android/live/core/tetris/layer/initialization/LayerIndex;", "getLayerIndex", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "getLayerDelegate", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "d", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "getLayerDelegate$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "setLayerDelegate$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;)V", "layerDelegate", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "e", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "getLayoutListener$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "setLayoutListener$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;)V", "layoutListener", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "f", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "getGlobalElementCenter$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "setGlobalElementCenter$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;)V", "globalElementCenter", "", "g", "Z", "isInLayout$tetris_saasRelease", "()Z", "setInLayout$tetris_saasRelease", "(Z)V", "isInLayout", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewLayer extends StaticFullScreenViewLayer implements a {
    public ViewLayerDelegate<b> d;
    public e e;
    public com.bytedance.android.live.core.tetris.layer.core.layout.a f;
    public boolean g;
    public final f70.b h;
    public final LayerIndex i;

    @Override // i70.a
    public Set<h<b>> getDescriptorSet() {
        Set r0 = this.d.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>>");
    }

    public final com.bytedance.android.live.core.tetris.layer.core.layout.a getGlobalElementCenter$tetris_saasRelease() {
        return this.f;
    }

    @Override // i70.a
    public LayerDelegate<? extends a, ? extends b> getLayerDelegate() {
        return this.d;
    }

    public final ViewLayerDelegate<b> getLayerDelegate$tetris_saasRelease() {
        return this.d;
    }

    @Override // i70.a
    public LayerIndex getLayerIndex() {
        return this.i;
    }

    @Override // i70.a
    public f70.b getLayerTypeV2() {
        return this.h;
    }

    public final e getLayoutListener$tetris_saasRelease() {
        return this.e;
    }

    @Override // i70.a
    public final void F(d<b> r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        ViewLayerDelegate<b> r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        r1.e.add(r3);
    }

    public final void R5(Element<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        if ((r3.d instanceof g) == false) goto L7;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r1 = this.f;
        if (r1 == null) goto L7;
        r1.d(this, r3);
    L7:
        ViewLayerDelegate<b> r2 = this.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "element");
        r2.d.put(r3.d, r3);
    }

    public final void S5(Element<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "element");
        this.d.b(r3);
        int r1 = f90.a.a;
        Intrinsics.checkNotNullParameter(r3, "element");
    }

    public final int T5(f r3) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        ViewLayerDelegate<b> r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Element r4 = (Element) ((LinkedHashMap) r1.d).get(r3);
        if (r4 == null) goto L7;
        View r5 = r4.b;
        if (r5 == null) goto L7;
        return r5.getId();
    L7:
        return -1;
    }

    public final List<h<b>> U5(b r13) {
        Intrinsics.checkNotNullParameter(r13, "layerContext");
        int r1 = com.bytedance.android.live.core.tetris.layer.core.layout.d.a;
        Intrinsics.checkNotNullParameter(this, "layer");
        Intrinsics.checkNotNullParameter(r13, "layerContext");
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashMap r2 = new LinkedHashMap();
        int r5 = 0;
        LocalTestManager.a(new Class[]{wy.a.class});
        Iterator<T> r3 = getDescriptorSet().iterator();
    L4:
        if (r3.hasNext() == false) goto L28;
        h r4 = (h) r3.next();
        com.bytedance.android.live.core.tetris.layer.view.b r6 = r4.K(r13);
        if (r6 == null) goto L4;
        f r7 = r4.C(r13);
        Iterator r8 = ((ArrayList) r6.a).iterator();
    L8:
        boolean r9 = r8.hasNext();
        int r11 = com.bytedance.android.live.core.tetris.layer.core.layout.d.a;
        if (r9 == false) goto L18;
        f r12 = (f) r8.next();
        if (Intrinsics.areEqual(r7, r12) == true) goto L17;
        LocalTestManager.a(new Class[]{wy.a.class});
        com.bytedance.android.live.core.tetris.layer.core.layout.d.b(r0, r2, r7, r12);     // Catch: CircleDependException -> L15
    L15:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L8
    L17:
        throw new RuntimeException(r4.getClass().getSimpleName().concat(" zOrder 中不能对自己作比较"));
    L18:
        Iterator r14 = ((ArrayList) r6.b).iterator();
    L20:
        if (r14.hasNext() == false) goto L4;
        f r15 = (f) r14.next();
        if (Intrinsics.areEqual(r7, r15) == true) goto L27;
        com.bytedance.android.live.core.tetris.layer.core.layout.d.b(r0, r2, r15, r7);     // Catch: CircleDependException -> L25
    L25:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L20
    L27:
        throw new RuntimeException(r4.getClass().getSimpleName().concat(" zOrder 中不能对自己作比较"));
    L28:
        Set<h<b>> r16 = getDescriptorSet();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L30:
        if (r18.hasNext() == false) goto L39;
        Object r19 = r18.next();
        com.bytedance.android.live.core.tetris.layer.view.b r21 = ((h) r19).K(r13);
        if (r21 != null) goto L34;
    L36:
        boolean r22 = false;
    L37:
        if (r22 == false) goto L30;
        r17.add(r19);
        goto L30
    L34:
        if (r21.c != true) goto L36;
        r22 = true;
        goto L37
    L39:
        Set<h<b>> r23 = getDescriptorSet();
        ArrayList r24 = new ArrayList();
        Iterator<T> r25 = r23.iterator();
    L41:
        if (r25.hasNext() == false) goto L50;
        Object r26 = r25.next();
        com.bytedance.android.live.core.tetris.layer.view.b r27 = ((h) r26).K(r13);
        if (r27 != null) goto L45;
    L47:
        boolean r28 = false;
    L48:
        if (r28 == false) goto L41;
        r24.add(r26);
        goto L41
    L45:
        if (r27.d != true) goto L47;
        r28 = true;
        goto L48
    L50:
        ArrayList r29 = new ArrayList();
        Iterator r31 = CollectionsKt.sortedWith(MapsKt.toList(r2), new c()).iterator();
    L52:
        if (r31.hasNext() == false) goto L69;
        Pair r32 = (Pair) r31.next();
        Iterator<T> r33 = getDescriptorSet().iterator();
    L55:
        if (r33.hasNext() == false) goto L59;
        Object r34 = r33.next();
        if (Intrinsics.areEqual(((h) r34).C(r13), (f) r32.getFirst()) == false) goto L55;
    L60:
        h r35 = (h) r34;
        if (r35 == null) goto L52;
        if (r29.contains(r35) == true) goto L52;
        if (r17.contains(r35) == true) goto L52;
        if (r24.contains(r35) == true) goto L52;
        r29.add(r35);
        goto L52
    L59:
        r34 = null;
        goto L60
    L69:
        Iterator<T> r110 = getDescriptorSet().iterator();
    L71:
        if (r110.hasNext() == false) goto L79;
        h r36 = (h) r110.next();
        if (r29.contains(r36) == true) goto L71;
        if (r17.contains(r36) == true) goto L71;
        if (r24.contains(r36) == true) goto L71;
        r29.add(r36);
        goto L71
    L79:
        Iterator r111 = r17.iterator();
    L81:
        if (r111.hasNext() == false) goto L83;
        ListProtector.add(r29, 0, (h) r111.next());
        goto L81
    L83:
        Iterator r112 = r24.iterator();
    L85:
        if (r112.hasNext() == false) goto L87;
        r29.add((h) r112.next());
        goto L85
    L87:
        Iterator r113 = r29.iterator();
    L89:
        if (r113.hasNext() == false) goto L91;
        ((h) r113.next()).a = r5;
        r5 = r5 + 1;
        goto L89
    L91:
        return r29;
    }

    public final void V5(f r3) {
        Intrinsics.checkNotNullParameter(r3, "elementType");
        Element<?> r0 = f2(r3);
        if (r0 == null) goto L7;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r1 = this.f;
        if (r1 == null) goto L7;
        r1.g(r0, this);
    L7:
        if (r0 == null) goto L10;
        this.d.l(r3);
        removeView(r0.b);
        return;
    }

    @Override // i70.a
    public final Element<?> f2(f r2) {
        Intrinsics.checkNotNullParameter(r2, "elementType");
        return this.d.f(r2);
    }

    public final void setGlobalElementCenter$tetris_saasRelease(com.bytedance.android.live.core.tetris.layer.core.layout.a r1) {
        this.f = r1;
    }

    public final void setInLayout$tetris_saasRelease(boolean r1) {
        this.g = r1;
    }

    public final void setLayerDelegate$tetris_saasRelease(ViewLayerDelegate<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setLayoutListener$tetris_saasRelease(e r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer
    public final void onMeasure(int r3, int r4) {
        this.g = true;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r1 = this.f;
        if (r1 != null) goto L5;
    L9:
        super.onMeasure(r3, r4);
        com.bytedance.android.live.core.tetris.layer.core.layout.a r5 = this.f;
        if (r5 != null) goto L12;
        return;
    L12:
        if (r5.a(this) != true) goto L18;
        e r6 = this.e;
        if (r6 == null) goto L19;
        r6.e(this);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r1.b(this) != true) goto L9;
        e r2 = this.e;
        if (r2 == null) goto L9;
        r2.f(this);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewLayer(f70.b r2, LayerIndex r3, b r4, Context r5, Class<ViewLayerDelegate<b>> r6) {
        Intrinsics.checkNotNullParameter(r2, "layerType");
        Intrinsics.checkNotNullParameter(r3, "layerIndex");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.h = r2;
        this.i = r3;
        setClipChildren(false);
        setClipToPadding(false);
        if (r6 == null) goto L9;
        ViewLayerDelegate<b> r7 = r6.newInstance();
        if (r7 == null) goto L8;
        ViewLayerDelegate<b> r8 = r7;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r8.a = this;
        v70.c r9 = new v70.c(this);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.i = r9;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.c = r4;
        r8.t();
        this.d = r8;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r8 = new DefaultViewLayerDelegate();
        goto L10
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.g = false;
    }
}
