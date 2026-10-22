package com.bytedance.android.livesdk.chorusconcert.descriptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import d90.d;
import d90.e;
import h70.b;
import j70.f;
import j70.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lu2.c;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends n<d> {
    public final boolean h() {
        return false;
    }

    public a() {
    }

    public final Class<? extends Widget> c() {
        return VSChorusConcertWidget.class;
    }

    public final boolean B(b r7) {
        d r8 = (d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        IRoom r0 = e.k(r8);
        boolean r1 = false;
        if (r0 != null) goto L6;
    L42:
        return r1;
    L6:
        if (((Boolean) VSSettingKeys.LIVE_VS_CHORUS_ENABLE_ACTIVE.getValue()).booleanValue() == true) goto L9;
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause live_vs_chorus_enable_active is false");
        goto L42
    L9:
        if (MultiTabManagerImpl.e.h(r8.h) == false) goto L12;
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause room ismultitabroom");
        goto L42
    L12:
        if (c.c(r0) == false) goto L14;
    L41:
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause room.hasMultiCamera()" + c.c(r0) + " || room.hasLinkedRoom()" + c.b(r0) + ' ');
        goto L42
    L14:
        if (c.b(r0) == true) goto L41;
        IRoom r2 = e.k(r8);
        if (r2 == null) goto L24;
        z5 r3 = r2.getLinkerDetail();
        if (r3 == null) goto L24;
        List r4 = r3.getPlayModes();
        if (r4 == null) goto L24;
        if (r4.contains(Long.valueOf(39)) != true) goto L24;
    L28:
        boolean r5 = true;
    L30:
        IRoom r6 = e.k(r8);
        if (r6 != null) goto L33;
    L36:
        StringBuilder r9 = new StringBuilder("return");
        r9.append(r1);
        r9.append("  isChorusRoom");
        r9.append(r5);
        r9.append(" isMergeVSRoom");
        IRoom r10 = e.k(r8);
        if (r10 == null) goto L39;
        Boolean r11 = Boolean.valueOf(r10.isMergeVSRoom());
    L40:
        r9.append(r11);
        ALogger.i("VsChorusConcertWidgetDescriptor", r9.toString());
        goto L42
    L39:
        r11 = null;
        goto L40
    L33:
        if (r6.isMergeVSRoom() != true) goto L36;
        if (r5 == false) goto L36;
        r1 = true;
    L24:
        es1.a r12 = es1.a.j.c(r0.getId(), r8.getContext(), true);
        if (r12 != null) goto L27;
    L29:
        r5 = false;
        goto L30
    L27:
        if (r12.c != true) goto L29;
        goto L28
    }

    public final f C(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d.a.I3;
    }

    public final LayerIndex E(b r2) {
        d r3 = (d) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.f.a(r3) == false) goto L6;
        return LayerIndex.INDEX_6;
    L6:
        return LayerIndex.INDEX_3;
    }

    public final double H(b r3) {
        Intrinsics.checkNotNullParameter((d) r3, "layerContext");
        return 0.1d;
    }

    public final ElementConstraint J(b r7) {
        d r8 = (d) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        if (d90.f.a(r8) == false) goto L12;
        u r0 = r.u(r8.h, null, 2);
        if (r0 == null) goto L12;
        m<Boolean> r1 = r0.A();
        if (r1 == null) goto L12;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L12;
        ElementConstraint r9 = new ElementConstraint(-1.0f, 110.0f);
        r9.a(f.d, VsChorusConcertWidgetDescriptor$generateConstraint$1.INSTANCE);
        return r9;
    L12:
        if (d90.f.a(r8) == false) goto L20;
        u r2 = r.u(r8.h, null, 2);
        if (r2 == null) goto L20;
        m<Boolean> r3 = r2.A();
        if (r3 == null) goto L20;
        if (((Boolean) r3.getValue()).booleanValue() == true) goto L20;
        ElementConstraint r4 = new ElementConstraint(-1.0f, 110.0f);
        r8.f.getClass();
        r4.k(d.a.f1, VsChorusConcertWidgetDescriptor$generateConstraint$2.INSTANCE);
        return r4;
    L20:
        ElementConstraint r10 = new ElementConstraint(-1.0f, 110.0f);
        r10.a(f.d, VsChorusConcertWidgetDescriptor$generateConstraint$3.INSTANCE);
        return r10;
    }
}
