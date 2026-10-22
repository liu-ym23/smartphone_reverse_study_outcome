package com.bytedance.android.livesdk.interactivity.common.adjuster.delegates;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.base.a;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.PageUIContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractUIContextDelegate implements e {
    public final Lazy a;
    public final o b;
    public final DataCenter c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final int DM() {
        Object r2 = null;
        z0 r0 = (z0) this.c.get("cmd_pk_state_change", null);
        if (r0 == null) goto L5;
        Object r1 = r0.b;
    L7:
        if ((r1 instanceof Integer) == false) goto L10;
        r2 = r1;
    L10:
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L15;
        return 0;
    L15:
        return r3.intValue();
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final m<Integer> IM() {
        PageUIContext r0 = (PageUIContext) this.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVideoBottom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final boolean Nt() {
        Object r2 = null;
        Object r0 = this.c.get("data_live_mode", null);
        if ((r0 instanceof LiveMode) == false) goto L7;
        r2 = r0;
    L7:
        if (((LiveMode) r2) != LiveMode.AUDIO) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final int WN() {
        PageUIContext r0 = (PageUIContext) this.a.getValue();
        if (r0 == null) goto L9;
        m<Integer> r1 = r0.getVideoBottom();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final boolean g1() {
        Boolean r0 = this.b.isPortraitInteraction();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final int lV() {
        return ((Number) this.c.get("cast_game_panel_height_change", 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.base.a
    public final int pT() {
        PageUIContext r0 = (PageUIContext) this.a.getValue();
        if (r0 == null) goto L9;
        n<a> r1 = r0.getInteractUIInfo();
        if (r1 == null) goto L9;
        a r2 = (a) r1.getValue();
        if (r2 == null) goto L9;
        int r3 = r2.pT();
    L10:
        int r4 = 0;
        if (a0.l(this.c, true) == false) goto L13;
        r4 = ((Number) this.c.get("data_feedback_bottombar_height", 0)).intValue();
    L13:
        int r5 = r3 - r4;
        if (r4 <= 0) goto L24;
        StringBuilder r6 = new StringBuilder("[roomId:");
        o r7 = this.b;
        if (r7 == null) goto L22;
        m r8 = r7.getRoom();
        if (r8 == null) goto L22;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L22;
        String r10 = r9.getIdStr();
    L23:
        r6.append(r10);
        r6.append("]the feedback bottombar height is ");
        r6.append(r4);
        ALogger.i("feedbackInteractHeight", r6.toString());
    L22:
        r10 = null;
    L24:
        if (r5 > 0) goto L27;
        ALogger.e("feedbackInteractHeight", "change interact height fail.the interactHeight is " + r3 + "\tthe feedbackBottomBarHeight is " + r4);
        return r3;
    L27:
        return r5;
    L9:
        r3 = s1.w();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.base.a, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.g
    public final boolean xa() {
        PageUIContext r0 = (PageUIContext) this.a.getValue();
        if (r0 == null) goto L9;
        n<a> r1 = r0.getInteractUIInfo();
        if (r1 == null) goto L9;
        a r2 = (a) r1.getValue();
        if (r2 == null) goto L9;
        return r2.xa();
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e
    public final boolean o70() {
        int r0 = pT();
        int r1 = s1.j(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.a.a(Boolean.valueOf(a0.d(this.c, false)))) + s1.j(2131169060);
        if ((s1.f(308.0f) + r1) <= r0) goto L6;
        return true;
    L6:
        return false;
    }

    public InteractUIContextDelegate(o r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(new InteractUIContextDelegate$pageUIContext$2(this));
    }
}
