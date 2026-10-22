package com.bytedance.android.live.liveinteract.videotalk.ui;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.i;
import d90.d;
import j70.f;
import j70.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends n<d> {
    public final boolean h() {
        return true;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return AnchorSilenceStatusWidget.class;
    }

    public final boolean B(h70.b r7) {
        d r8 = (d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        IRoomContextService r0 = r8.g;
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isAnchor();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        if (r3 == false) goto L24;
        IRoomContextService r9 = r8.g;
        if (r9 == null) goto L17;
        o r10 = IRoomContextService.a.a(r9, null, 0, 3);
        if (r10 == null) goto L17;
        i r11 = r10.getLiveMode();
        if (r11 == null) goto L17;
    L19:
        if (r11 == LiveMode.VIDEO) goto L21;
        return false;
    L21:
        if (((Boolean) vm2.d.r6.getValue(null, vm2.d.a[379(0x17b, float:5.31E-43)])).booleanValue() == true) goto L26;
        return true;
    L26:
        return false;
    L17:
        r11 = LiveMode.UNDEFINED;
        goto L19
    L24:
        return false;
    L9:
        r3 = false;
        goto L10
    }

    public final f C(h70.b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.X;
    }

    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    public final ElementConstraint J(h70.b r2) {
        final d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return I(new AnchorSilenceStatusDescriptor$generateConstraint$1(r3));
    }
}
