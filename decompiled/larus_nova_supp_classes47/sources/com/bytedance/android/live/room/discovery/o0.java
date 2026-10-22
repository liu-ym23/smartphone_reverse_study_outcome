package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.config.qk0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 extends j70.j<d90.a> {
    public final Tetris<? extends h70.b> b() {
        return new PortraitDiscoveryTetris();
    }

    public o0() {
    }

    public final boolean B(h70.b r3) {
        d90.a r4 = (d90.a) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        ((d90.d) r4).f.getClass();
        d90.c.b(r4, d90.d.a.S, d90.c.i(r4));
        return d90.c.i(r4);
    }

    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        ((d90.d) r3).f.getClass();
        return d90.d.a.S;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final double F(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 1.1d;
    }

    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 1.1d;
    }

    public final ElementConstraint J(h70.b r7) {
        final d90.a r8 = (d90.a) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        z70.b r0 = ((h70.b) r8).a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        Room r2 = d90.c.q(r8);
        if (r2 != null) goto L10;
    L11:
        Room r3 = d90.c.q(r8);
        if (r3 != null) goto L14;
    L15:
        Room r4 = d90.c.q(r8);
        if (r4 != null) goto L18;
    L21:
        if (PadConfigUtils.c() == false) goto L23;
        float r5 = 20.0f;
    L25:
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L43;
        if (d90.c.i(r8) == false) goto L39;
        IRoomService r6 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r6 == null) goto L39;
        if (r6.isDrawerEnable(d90.c.q(r8)) != true) goto L39;
        if (jr1.b.b(r8) == false) goto L40;
        z70.b r9 = ((h70.b) r8).a;
        if (r9 == null) goto L39;
        ((d90.d) r8).f.getClass();
        if (r9.d(d90.d.a.A2) != true) goto L39;
    L40:
        if (r1 == false) goto L43;
        ElementConstraint r10 = new ElementConstraint(0.0f, 22.0f);
        ElementConstraint.Side r12 = ElementConstraint.Side.LEFT;
        r10.d(r12, r12, r5);
        ElementConstraint.Side r13 = ElementConstraint.Side.TOP;
        ((d90.d) r8).f.getClass();
        r10.b(r13, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 0.0f);
        ElementConstraint.Side r14 = ElementConstraint.Side.RIGHT;
        ((d90.d) r8).f.getClass();
        r10.b(r14, d90.d.a.U, r12, 10.0f);
    L49:
        return r10;
    L39:
        r1 = false;
    L43:
        if (jr1.b.a(r8) == true) goto L45;
    L47:
        r10 = new ElementConstraint(-1.0f, 22.0f);
        ElementConstraint.Side r15 = ElementConstraint.Side.LEFT;
        r10.d(r15, r15, r5);
        ElementConstraint.Side r16 = ElementConstraint.Side.TOP;
        ((d90.d) r8).f.getClass();
        r10.b(r16, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 0.0f);
        goto L49
    L45:
        if (((Boolean) qk0.a.getValue()).booleanValue() == false) goto L47;
        r10 = new ElementConstraint(240.0f, 22.0f);
        ElementConstraint.Side r17 = ElementConstraint.Side.LEFT;
        r10.d(r17, r17, r5);
        ElementConstraint.Side r18 = ElementConstraint.Side.TOP;
        ((d90.d) r8).f.getClass();
        r10.b(r18, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 0.0f);
        goto L49
    L23:
        r5 = 12.0f;
        goto L25
    L18:
        if (r4.isVsRoom() != true) goto L21;
    L19:
        ElementConstraint r19 = new ElementConstraint(-2.0f, 22.0f);
        ElementConstraint.Side r20 = ElementConstraint.Side.LEFT;
        ((d90.d) r8).f.getClass();
        r19.b(r20, d90.d.a.I2, ElementConstraint.Side.RIGHT, 6.0f);
        ElementConstraint.Side r22 = ElementConstraint.Side.TOP;
        ((d90.d) r8).f.getClass();
        r19.b(r22, d90.d.a.z2, ElementConstraint.Side.BOTTOM, 2.0f);
        return r19;
    L14:
        if (r3.isMergeVSRoom() == true) goto L19;
    L10:
        if (r2.isMediaRoom() == true) goto L21;
    L5:
        if (r0.k() != true) goto L7;
        return I(new PortraitRow2ndDiscoveryTetrisDescriptor$templateConstrait$1(r8));
    }
}
