package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ PkRandomMatchDialogV2 a;

    public i(PkRandomMatchDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        HashMap r10 = new HashMap();
        PkAutoMatchDataContext r0 = this.a.o;
        p0 r1 = null;
        if (r0 == null) goto L5;
        af2.e r2 = r0.getAutoMatchModel();
    L6:
        if (r2 == null) goto L23;
        long r3 = r2.getExpectTime();
        PkAutoMatchDataContext r4 = this.a.o;
        int r5 = 0;
        if (r4 == null) goto L14;
        LiveData<Long> r6 = r4.getWaitedTime();
        if (r6 == null) goto L14;
        Long r7 = (Long) r6.getValue();
        if (r7 == null) goto L14;
        int r8 = (int) r7.longValue();
    L15:
        r10.put("wait_time_left", String.valueOf(r3 - ((long) r8)));
        PkAutoMatchDataContext r12 = this.a.o;
        if (r12 == null) goto L22;
        LiveData<Long> r13 = r12.getWaitedTime();
        if (r13 == null) goto L22;
        Long r14 = (Long) r13.getValue();
        if (r14 == null) goto L22;
        r5 = (int) r14.longValue();
    L22:
        r10.put("total_wait_time", String.valueOf(r5));
        r10.put("system_assign_wait_time", String.valueOf(r2.getExpectTime()));
    L14:
        r8 = 0;
    L23:
        r10.put("source", "pk_banner");
        r10.put("anchor_connect_status", DataType.FALSE);
        r10.put("room_status", "live");
        r10.put("is_reinvite", DataType.FALSE);
        r10.put("click_from", "wait_banner");
        r10.put("pk_description", "routine");
        String r15 = "";
        r10.put("pk_activity_type", "");
        com.bytedance.android.live.revlink.impl.pk.service.a r16 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r16 == null) goto L29;
        h0 r17 = r16.d();
        if (r17 == null) goto L29;
        r17.a(r10);
    L29:
        if (this.a.W90() == false) goto L37;
        r10.put("match_type", "game_matching");
        r10.put("connection_type", "game_matching");
        PkAutoMatchDataContext r18 = this.a.o;
        if (r18 == null) goto L36;
        String r19 = r18.getCurrentGameId();
        if (r19 == null) goto L36;
        r15 = r19;
    L36:
        r10.put("open_game_app_id", r15);
    L38:
        PkAutoMatchDataContext r20 = this.a.o;
        if (r20 == null) goto L45;
        h0 r22 = r20.pkAutoMatchLogInfo();
        if (r22 == null) goto L45;
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.p r23 = r22.d;
        if (r23 == null) goto L45;
        r1 = r23.a;
    L45:
        mz0.n r24 = new mz0.n();
        mz0.o r25 = new mz0.o(r24.a);
        r25.b(r10);
        e21.c.e(r25, r1);
        mz0.m r26 = new mz0.m();
        LinkCrossRoomDataHolder.a r27 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r26);
        r26.b(LogCommon.ROOM);
        r26.b(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.h r28 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r28, "linkInfoLog");
        am2.m r29 = r28.a;
        r29.i = 300;
        ((ArrayList) r26.a).add(r29);
        ((ArrayList) r24.b).addAll(r26.a);
        cy0.e.a.getClass();
        cy0.j r30 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("match_cancel_click", r24.a, r24.b);
        com.bytedance.android.live.revlink.impl.pk.service.a r33 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r33 == null) goto L57;
        r33.f(AutoMatchSource.Manual);
    L57:
        this.a.dismiss();     // Catch: Exception -> L51
    L55:
        this.a.X90("cancel");
        return;
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r34 = DialogFragmentLancet.sLastShowStack;
        if (r34 == null) goto L55;
        com.bytedance.crash.d.d(r34, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L55
    L37:
        r10.put("match_type", "single");
        goto L38
    L5:
        r2 = null;
        goto L6
    }
}
