package com.bytedance.android.livesdk.interactivity.interactive.episode;

import am2.x;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.EpisodeInteractiveContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.o;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements c0.b {
    public DataCenter a;

    public d() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r7) {
        ViewModel r1 = null;
        u r0 = r.u(this.a, null, 2);
        if (r0 == null) goto L5;
        ViewModel r2 = r0.c();
    L7:
        if ((r2 instanceof EpisodeInteractiveContext) == false) goto L10;
        r1 = r2;
    L10:
        EpisodeInteractiveContext r3 = (EpisodeInteractiveContext) r1;
        if (r3 != null) goto L13;
        return;
    L13:
        boolean r4 = ((Boolean) r3.getEnableInteractive().getValue()).booleanValue();
        r3.getEnableInteractive().setValue(Boolean.valueOf(!r4));
        if (r7 == null) goto L17;
        r7.setSelected(((Boolean) r3.getEnableInteractive().getValue()).booleanValue());
    L17:
        if (((Boolean) r3.getEnableInteractive().getValue()).booleanValue() == false) goto L19;
        f2.c(s1.B(2131918115), 0);
    L21:
        if (this.a == null) goto L28;
        o r8 = r.l();
        Pair[] r5 = new Pair[1];
        if (r4 == false) goto L25;
        String r6 = "on";
    L26:
        r5[0] = TuplesKt.to("vs_switch_status", r6);
        r8.sendLog("interactive_switch_icon_click", MapsKt.mutableMapOf(r5), new Object[]{IRoom.class, x.class});
        return;
    L25:
        r6 = "off";
        goto L26
    L28:
        return;
    L19:
        f2.c(s1.B(2131918114), 0);
        goto L21
    L5:
        r2 = null;
        goto L7
    }

    public final void p4(View r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "center");
        this.a = r7;
        ViewModel r0 = null;
        u r8 = r.u(r7, null, 2);
        if (r8 == null) goto L5;
        ViewModel r9 = r8.c();
    L7:
        if ((r9 instanceof EpisodeInteractiveContext) == false) goto L10;
        r0 = r9;
    L10:
        EpisodeInteractiveContext r1 = (EpisodeInteractiveContext) r0;
        if (r1 == null) goto L17;
        m<Boolean> r2 = r1.getEnableInteractive();
        if (r2 == null) goto L17;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L17;
        boolean r3 = true;
    L18:
        r6.setSelected(r3);
        if (this.a == null) goto L26;
        o r10 = r.l();
        Pair[] r4 = new Pair[1];
        if (r3 == false) goto L23;
        String r5 = "on";
    L24:
        r4[0] = TuplesKt.to("vs_switch_status", r5);
        r10.sendLog("interactive_switch_icon_show", MapsKt.mutableMapOf(r4), new Object[]{IRoom.class, x.class});
        return;
    L23:
        r5 = "off";
        goto L24
    L26:
        return;
    L17:
        r3 = false;
        goto L18
    L5:
        r9 = null;
        goto L7
    }
}
