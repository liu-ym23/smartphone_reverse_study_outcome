package com.obric.oui.texteffects.render;

import android.graphics.BlurMaskFilter;
import android.util.Log;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0003R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/texteffects/render/BlurMaskFilterCache;", "", "maxRadiusPx", "", "granularityPx", "(FF)V", "cache", "Landroid/util/SparseArray;", "Landroid/graphics/BlurMaskFilter;", "clear", "", "get", "radiusPx", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f14653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f14654b;
    private final float c;
    private final SparseArray<BlurMaskFilter> d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/render/BlurMaskFilterCache$Companion;", "", "()V", "Tag", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14653a = new a(null);
    }

    public b(float r1, float r2) {
        this.f14654b = r1;
        this.c = r2;
        this.d = new SparseArray();
    }

    public final BlurMaskFilter a(float r6) {
        if (Float.isNaN(r6) == false) goto L5;
    L23:
        return null;
    L5:
        if (Float.isInfinite(r6) == true) goto L23;
        if (r6 <= 0.01f) goto L23;
        int r7 = RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r6, this.f14654b), this.c) / this.c), 1);
        BlurMaskFilter r0 = (BlurMaskFilter) ZeusTransformUtils.preCheckCast(this.d.get(r7), BlurMaskFilter.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        return r0;
    L12:
        float r1 = r7 * this.c;
        BlurMaskFilter r2 = new BlurMaskFilter(r1, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
        if (com.obric.oui.texteffects.a.a() == false) goto L21;
        Log.d(Intrinsics.stringPlus("OTextEff/", "BlurMaskFilterCache"), "create BlurMaskFilter key=" + r7 + " radius=" + r1);
    L21:
        this.d.put(r7, r2);
        return r2;
    L15:
        r2 = (BlurMaskFilter) ZeusTransformUtils.preCheckCast(null, BlurMaskFilter.class, "com.obric.memorydata.plugin");
        goto L16
    }

    public final void a() {
        this.d.clear();
    }
}
