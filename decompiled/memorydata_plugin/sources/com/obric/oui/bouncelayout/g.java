package com.obric.oui.bouncelayout;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000f\u001a\u00020\u000bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceTranslationDelegate;", "", "getTotalTranslation", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "callback", "Lkotlin/Function1;", "", "listener", "Lcom/obric/oui/bouncelayout/OnBounceTranslationListener;", "setOnBounceTranslationListener", "updateBounceListeners", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Float> f13370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<e[]> f13371b;
    private i c;
    private final Function1<Float, Unit> d;

    public g(Function0<Float> r3, Function0<e[]> r4) {
        Function0<Float> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<e[]> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "getTotalTranslation");
        Intrinsics.checkNotNullParameter(r6, "effectsProvider");
        this.f13370a = r5;
        this.f13371b = r6;
        this.d = (Function1) ZeusTransformUtils.preCheckCast(new BounceTranslationDelegate$callback$1(this), Function1.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ i a(g r0) {
        return r0.c;
    }

    public static final /* synthetic */ Function0 b(g r0) {
        return r0.f13370a;
    }

    public final void a() {
        e[] r0 = (e[]) ZeusTransformUtils.preCheckCast(this.f13371b.invoke(), e[].class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (this.c != null) goto L11;
        int r5 = r0.length;
    L5:
        if (r2 >= r5) goto L10;
        e r1 = r0[r2];
        r2 = r2 + 1;
        if (r1 == null) goto L5;
        r1.a(null);
        goto L5
    L10:
        return;
    L11:
        int r3 = r0.length;
    L12:
        if (r2 >= r3) goto L17;
        e r4 = r0[r2];
        r2 = r2 + 1;
        if (r4 == null) goto L12;
        r4.a(this.d);
        goto L12
    }

    public final void a(i r3) {
        this.c = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        a();
    }
}
