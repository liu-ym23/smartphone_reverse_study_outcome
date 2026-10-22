package com.bytedance.android.live.revlink.impl.player;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\u0010\u0002\u001a\u00150\u0003j\u0002`\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0015\u0010\b\u001a\u00110\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n2\u0019\u0010\u000b\u001a\u00150\fj\u0002`\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u000f"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/Matrix;", "Lcom/bytedance/live/platform/api/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "gridMatrix", "p2", "Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;", "seiFrame", "p3", "Landroid/graphics/RectF;", "Lcom/bytedance/live/platform/api/graphics/RectF;", "contentVisibleArea", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevenueLayoutCore$onBizUpdate$broadcastFunc$1 extends FunctionReferenceImpl implements Function3<Matrix, RevSeiFrame, RectF, Unit> {
    public RevenueLayoutCore$onBizUpdate$broadcastFunc$1(j r8) {
        super(3, r8, j.class, "onBizUpdateFeed", "onBizUpdateFeed(Landroid/graphics/Matrix;Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;Landroid/graphics/RectF;)V", 0);
    }

    public final void invoke(Matrix r12, RevSeiFrame r13, RectF r14) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        Intrinsics.checkNotNullParameter(r13, "p2");
        Intrinsics.checkNotNullParameter(r14, "p3");
        j r0 = (j) ((CallableReference) this).receiver;
        int r1 = j.m;
        r0.getClass();
        Integer r2 = r13.n();
        if (r2 != null) goto L6;
    L15:
        boolean r4 = false;
    L16:
        Function1<? super b, Unit> r3 = r0.l.p;
        if (r3 == null) goto L20;
        Unit r15 = (Unit) r3.invoke(new b(r14, r4, r13.n(), r0.l.h, r12, r13.C));
        return;
    L20:
        return;
    L6:
        if (r2.intValue() != 6) goto L15;
        Integer r5 = r13.m();
        int r6 = UILayoutServerIndex.Full.ordinal();
        if (r5 == null) goto L13;
        if (r5.intValue() == r6) goto L15;
    L13:
        if (r0.l.i == true) goto L15;
        r4 = true;
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Matrix) r1, (RevSeiFrame) r2, (RectF) r3);
        return Unit.INSTANCE;
    }
}
