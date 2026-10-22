package com.obric.oui.bouncelayout;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceOverscrollDelegate;", "", "sizePxProvider", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "maxOverscrollPx", "getMaxOverscrollPx", "()F", "applyMaxToEffects", "", "onSizeChanged", "setMaxOverscrollPx", EventBody.KEY_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Integer> f13368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<e[]> f13369b;
    private float c;

    public f(Function0<Integer> r3, Function0<e[]> r4) {
        Function0<Integer> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<e[]> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "sizePxProvider");
        Intrinsics.checkNotNullParameter(r6, "effectsProvider");
        this.f13368a = r5;
        this.f13369b = r6;
    }

    public final float a() {
        return this.c;
    }

    public final void a(float r2) {
        this.c = RangesKt.coerceAtLeast(r2, 0.0f);
        c();
    }

    public final void b() {
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(this.f13368a.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 <= 0) goto L5;
        a(r0);
        return;
    L5:
        c();
    }

    public final void c() {
        e[] r0 = (e[]) ZeusTransformUtils.preCheckCast(this.f13369b.invoke(), e[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        e r3 = r0[r2];
        r2 = r2 + 1;
        if (r3 == null) goto L3;
        r3.a(this.c);
        goto L3
    }
}
