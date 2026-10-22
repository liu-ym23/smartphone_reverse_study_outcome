package cz0;

import android.view.View;
import bz0.j;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends b7.a {
    public final j a;

    public final void onBeforeGlobalPropsInitialize() {
        this.a.o.b();
    }

    public final void onBeforeInitialPropsInitialize() {
        this.a.q.b();
    }

    public final void onBeforeJsbRegister() {
        this.a.m.b();
    }

    public final void onBeforeOpenContainer() {
        this.a.b.b();
    }

    public final void onCardLoadStart() {
        this.a.s.b();
    }

    public final void onContainerInitEnd() {
        this.a.d.b();
    }

    public final void onContainerInitStart() {
        this.a.c.b();
    }

    public final void onEngineLoadEnd() {
        this.a.u.b();
    }

    public final void onEngineLoadStart() {
        this.a.t.b();
    }

    public final void onGlobalPropsInitialized() {
        this.a.p.b();
    }

    public final void onInitialPropsInitialized() {
        this.a.r.b();
    }

    public final void onJsbRegistered() {
        this.a.n.b();
    }

    public final void onLynxEnvInitialized() {
        this.a.l.b();
    }

    public final void onPrepareComponentEnd() {
        this.a.j.b();
    }

    public final void onPrepareComponentStart() {
        this.a.i.b();
    }

    public final void onPrepareInitDataEnd() {
        this.a.f.b();
    }

    public final void onPrepareTemplateStart() {
        this.a.w.b();
    }

    public final void onRelease() {
        this.a.E.b();
    }

    public a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.a = r2;
    }

    public final void onBeforeCreateRenderData(View r4) {
        Intrinsics.checkNotNullParameter(r4, "hybridView");
        this.a.g.c(new Object[]{r4});
    }

    public final void onBeforeLynxEnvInitialize(boolean r4) {
        this.a.k.c(new Object[]{Boolean.valueOf(r4)});
    }

    public final void onInit(c7.a r2) {
        Intrinsics.checkNotNullParameter(r2, "annieContext");
        this.a.a.b();
    }

    public final void onLoadSuccess(View r4) {
        this.a.B.c(new Object[]{r4});
    }

    public final void onCreateRenderData(View r4, Set<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "hybridView");
        Intrinsics.checkNotNullParameter(r5, "stateKeys");
        this.a.h.c(new Object[]{r4, r5});
    }

    public final boolean onFallback(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        CompositeListenerUpTo6Args<Boolean, Function2<Integer, String, Boolean>> r0 = this.a.D;
        if (r0.a.size() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L23;
        Sequence<Boolean> r7 = r0.d(new Object[]{Integer.valueOf(r5), r6});
        if (r7 == null) goto L25;
        Iterator r8 = r7.iterator();
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
    L16:
        if (r8.hasNext() == false) goto L18;
        boolean r2 = ((Boolean) r8.next()).booleanValue();
        ((Boolean) r9).booleanValue();
        r9 = Boolean.valueOf(r2);
        goto L16
    L18:
        Boolean r10 = (Boolean) r9;
        if (r10 != null) goto L27;
        return false;
    L27:
        return r10.booleanValue();
    L22:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    L25:
        return false;
    L23:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final void onInnerFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        this.a.A.c(new Object[]{Integer.valueOf(r4), r5});
    }

    public final void onLoadStart(View r4, boolean r5) {
        this.a.z.c(new Object[]{r4, Boolean.valueOf(r5)});
    }

    public final void onPrepareTemplateEnd(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "resFrom");
        this.a.x.c(new Object[]{Boolean.valueOf(r4), r5});
    }

    public final void onAttachView(View r4, IHybridComponent.HybridType r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "hybridType");
        this.a.v.c(new Object[]{r4, b.a(r5), r6});
    }

    public final void onContainerError(View r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMessage");
        this.a.y.c(new Object[]{r4, Integer.valueOf(r5), r6});
    }

    public final void onLoadFail(View r4, String r5, String r6) {
        this.a.C.c(new Object[]{r4, r5, r6});
    }

    public final void onPrepareInitDataStart(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "scheme");
        Intrinsics.checkNotNullParameter(r5, "fallbackUrl");
        this.a.e.c(new Object[]{r4, r5, Boolean.valueOf(r6)});
    }

    public final void onBeforeLoadRequest(String r4, AnnieResType r5, IHybridComponent.HybridType r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "resType");
        Intrinsics.checkNotNullParameter(r6, "type");
        this.a.F.c(new Object[]{r4, r5, b.a(r6), r7});
    }
}
