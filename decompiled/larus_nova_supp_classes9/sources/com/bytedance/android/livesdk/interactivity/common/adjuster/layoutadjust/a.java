package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.InteractivityContext;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final int g = 0;
    public static final int h = 0;
    public final DataCenter a;
    public final LiveRoomEnvStateHolder b;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e c;
    public final Room d;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i e;
    public final RoomContext f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.a$a, reason: collision with other inner class name */
    public static final class C0153a {
    }

    static {
        g = s1.f(65.0f);
        h = s1.f(30.0f);
    }

    public final void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r17, String r18, boolean r19) {
        int r3 = r17.b;
        if (r3 != (-10086)) goto L5;
    L7:
        boolean r4 = false;
    L8:
        int r6 = r17.a;
        if (r6 == (-10086)) goto L39;
        if (r6 <= 0) goto L39;
        if (r6 >= h) goto L15;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.c(r17, this.d, r18);
        goto L39
    L15:
        if (r6 <= ((this.c.pT() / 3) * 2)) goto L17;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j r5 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c;
        Room r7 = this.d;
        Intrinsics.checkNotNullParameter(r17, "heightInfo");
        Intrinsics.checkNotNullParameter(r7, "room");
        Intrinsics.checkNotNullParameter(r18, "source");
        r5.a("on height change error!! , too high !!!, height is " + r17.a);
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenHeightError, r7, 1, r18, 16);
    L17:
        this.e.c(r17);
        if ((!Intrinsics.areEqual(r17.d, "default")) == false) goto L38;
        RoomContext r8 = this.f;
        if (r8 == null) goto L24;
        com.bytedance.live.datacontext.j r9 = r8.getInteractivityContext();
        if (r9 == null) goto L24;
        ViewModel r10 = (ViewModel) r9.getValue();
    L26:
        if ((r10 instanceof InteractivityContext) == true) goto L28;
        r10 = null;
    L28:
        InteractivityContext r11 = (InteractivityContext) r10;
        if (r11 == null) goto L38;
        com.bytedance.live.datacontext.i<k> r13 = r11.getPsHeightPlatformStrategyReporter();
        if (r13 == null) goto L38;
        k r14 = (k) r13.getValue();
        if (r14 == null) goto L38;
        String r15 = r17.d;
        Intrinsics.checkNotNullParameter(r15, "level");
        if (Intrinsics.areEqual(r14.a, "default") == false) goto L37;
        r14.a = r15;
    L37:
        r14.b++;
    L24:
        r10 = null;
    L38:
        r4 = true;
    L39:
        if (r4 == false) goto L52;
        this.e.f(r17.c);
        this.e.g();
        this.b.G.put("cmd_data_interact_public_screen_height_change", new i32.a(this.e.getHeight(), this.e.getBottomMargin(), r17.c));
        InteractionWidgetsPosContext r16 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, this.d.getRoomId(), 1);
        if (r16 == null) goto L43;
        r16.getPublicScreenHeight().setValue(Integer.valueOf(this.e.getHeight()));
        r16.getPublicScreenBottomMargin().setValue(Integer.valueOf(this.e.getBottomMargin()));
        r16.getPublicScreenLeftMargin().setValue(Integer.valueOf(this.e.b()));
        r16.getPublicScreenRightMargin().setValue(Integer.valueOf(this.e.e()));
    L43:
        if (r19 == false) goto L45;
        PublicScreenTraceMonitor.AdjustStep r20 = PublicScreenTraceMonitor.AdjustStep.INTERCEPT;
    L46:
        PublicScreenTraceMonitor.g(r18, Boolean.FALSE, Boolean.TRUE, r20, "expectedHeight:" + r17.a + ",bottomMargin:" + r17.b);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j r21 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c;
        r21.d("on textmessage height change  roomID :::   " + this.d.getRoomId() + "  : height,  " + this.e.getHeight() + " + source ," + r18);
        Room r23 = this.d;
        Intrinsics.checkNotNullParameter(r17, "heightInfo");
        Intrinsics.checkNotNullParameter(r23, "room");
        Intrinsics.checkNotNullParameter(r18, "source");
        r21.a("height: " + r17.a + ",  bottomMargin : " + r17.b);
        int r1 = r17.a;
        if (r1 != (-10086)) goto L49;
        return;
    L49:
        if (r1 >= com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.b) goto L54;
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenHeightError, r23, 3, r18, 16);
        return;
    L54:
        return;
    L45:
        r20 = PublicScreenTraceMonitor.AdjustStep.RESULT;
        goto L46
    L52:
        return;
    L5:
        if (r3 == this.e.getBottomMargin()) goto L7;
        this.e.d(r17.b);
        r4 = true;
        goto L8
    }

    public static com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d b(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r7, Object r8, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r9, LiveRoomEnvStateHolder r10) {
        h.b.getClass();
        Iterator r0 = ((HashMap) h.a.a).values().iterator();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r3 = r7;
    L4:
        if (r0.hasNext() == false) goto L7;
        r3 = ((h) r0.next()).e(r8, r3, r9, r10, r10);
        goto L4
    L7:
        if (r3.b == r7.b) goto L9;
        PublicScreenTraceMonitor.g("PostProcessor", Boolean.FALSE, Boolean.TRUE, PublicScreenTraceMonitor.AdjustStep.POST_PROCESSOR, "expectedHeight:" + r7.a + ",bottomMargin:" + r7.b);
    L9:
        return r3;
    }

    public a(DataCenter r2, LiveRoomEnvStateHolder r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r4, Room r5, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.i r6, RoomContext r7) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "liveRoomEnvStateHolder");
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "container");
        Intrinsics.checkNotNullParameter(r7, "roomContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
