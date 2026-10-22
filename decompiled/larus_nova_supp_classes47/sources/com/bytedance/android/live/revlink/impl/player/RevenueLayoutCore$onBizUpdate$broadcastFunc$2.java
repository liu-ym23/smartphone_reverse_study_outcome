package com.bytedance.android.live.revlink.impl.player;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\u0010\u0002\u001a\u00150\u0003j\u0002`\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0015\u0010\b\u001a\u00110\t¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n2\u0019\u0010\u000b\u001a\u00150\fj\u0002`\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e¢\u0006\u0002\b\u000f"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/Matrix;", "Lcom/bytedance/live/platform/api/graphics/Matrix;", "Lkotlin/ParameterName;", "name", "gridMatrix", "p2", "Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;", "seiFrame", "p3", "Landroid/graphics/RectF;", "Lcom/bytedance/live/platform/api/graphics/RectF;", "contentVisibleArea", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RevenueLayoutCore$onBizUpdate$broadcastFunc$2 extends FunctionReferenceImpl implements Function3<Matrix, RevSeiFrame, RectF, Unit> {
    public RevenueLayoutCore$onBizUpdate$broadcastFunc$2(j r8) {
        super(3, r8, j.class, "onBizUpdateInnerDraw", "onBizUpdateInnerDraw(Landroid/graphics/Matrix;Lcom/bytedance/android/live/revenue/common/player/vendor/link/RevSeiFrame;Landroid/graphics/RectF;)V", 0);
    }

    public final void invoke(Matrix r9, RevSeiFrame r10, RectF r12) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        Intrinsics.checkNotNullParameter(r10, "p2");
        Intrinsics.checkNotNullParameter(r12, "p3");
        j r0 = (j) ((CallableReference) this).receiver;
        ld.a r1 = r0.k;
        Integer r2 = r10.n();
        boolean r3 = true;
        if (r2 != null) goto L6;
    L24:
        Integer r4 = r10.n();
        int r5 = 0;
        if (r4 != null) goto L28;
    L37:
        boolean r6 = false;
    L38:
        Integer r7 = r10.n();
        if (r7 != null) goto L42;
    L44:
        Integer r8 = r10.n();
        if (r8 == null) goto L51;
        if (r8.intValue() != 2) goto L51;
        r6 = true;
    L51:
        if (Intrinsics.areEqual(r10.o(), Boolean.TRUE) == false) goto L57;
        i r13 = r0.l;
        if (r13.h == true) goto L57;
        if (r13.f == true) goto L57;
        r6 = false;
    L57:
        i r14 = r0.l;
        if (r14.o == LiveMode.SCREEN_RECORD) goto L62;
        r3 = false;
    L62:
        if ((r10.t(r3, r14.h) instanceof o51.f.d) == false) goto L68;
        b03.a r15 = b03.a.a;
        float r16 = s1.w();
        float r17 = s1.y();
        float r18 = (9.0f * r16) / 13;
        RectF r19 = new RectF(0.0f, 0.0f, r18, r16);
        float r110 = r17 - r18;
        if (r18 > r17) goto L67;
        r110 = r110 / 2.0f;
    L67:
        Matrix r20 = new Matrix();
        r20.postScale(r18, r16);
        r20.postTranslate(r110, 0.0f);
        Pair r22 = TuplesKt.to(r19, r20);
    L69:
        RectF r111 = (RectF) r22.component1();
        Matrix r23 = (Matrix) r22.component2();
        if (r1 == null) goto L74;
        NextLiveData r24 = r1.Rm();
        if (r24 == null) goto L74;
        r24.setValue(new oq2.e(r111, r6, r10.n(), r0.l.h));
    L74:
        if (r1 == null) goto L81;
        NextLiveData r25 = r1.s9();
        if (r25 == null) goto L81;
        String r26 = r10.C;
        Integer r112 = r10.m();
        if (r112 == null) goto L80;
        r5 = r112.intValue();
    L80:
        r25.setValue(new g90.a(r23, r111, r26, r5));
    L81:
        StringBuilder r27 = new StringBuilder("send renderData: ");
        if (r1 == null) goto L86;
        NextLiveData r113 = r1.Rm();
        if (r113 == null) goto L86;
        oq2.e r114 = (oq2.e) r113.getValue();
    L87:
        r27.append(r114);
        r27.append(" interactStatus: ");
        if (r1 == null) goto L92;
        NextLiveData r115 = r1.s9();
        if (r115 == null) goto L92;
        g90.a r116 = (g90.a) r115.getValue();
    L93:
        r27.append(r116);
        jy0.b.c("RevenueLayoutCore", r27.toString(), null, 4);
        return;
    L92:
        r116 = null;
    L86:
        r114 = null;
        goto L87
    L68:
        r22 = TuplesKt.to(r12, r9);
        goto L69
    L42:
        if (r7.intValue() != 19) goto L44;
        r6 = true;
        goto L44
    L28:
        if (r4.intValue() != 6) goto L37;
        Integer r28 = r10.m();
        int r29 = UILayoutServerIndex.Full.ordinal();
        if (r28 == null) goto L35;
        if (r28.intValue() == r29) goto L37;
    L35:
        if (r0.l.i == true) goto L37;
        r6 = true;
        goto L38
    L6:
        if (r2.intValue() != 2) goto L24;
        if (r0.l.i == true) goto L24;
        r0.c = true;
        if (r1 == null) goto L14;
        NextLiveData r30 = r1.O1();
        if (r30 == null) goto L14;
        r30.setValue(Boolean.TRUE);
    L14:
        if (r1 == null) goto L18;
        NextLiveData r32 = r1.a2();
        if (r32 == null) goto L18;
        r32.setValue(Integer.valueOf((int) r12.left));
    L18:
        wq2.f r33 = r0.E();
        if (r33 == null) goto L21;
        r33.Zn(true);
    L21:
        wq2.f r34 = r0.E();
        if (r34 == null) goto L24;
        r34.nj((int) r12.left);
        goto L24
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Matrix) r1, (RevSeiFrame) r2, (RectF) r3);
        return Unit.INSTANCE;
    }
}
