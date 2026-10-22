package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ PkMuteCheckDialogFragment a;

    public f(PkMuteCheckDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        HashMap r8 = new HashMap();
        r8.put("action_type", "click");
        r8.put("click_content", "cancel");
        d31.d r0 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r0 == null) goto L12;
        String r1 = r0.c();
    L13:
        r8.put("connection_type", r1);
        r8.put("anchor_cnt", ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkAnchorCount());
        if (l51.a.h() == false) goto L16;
        String r2 = DataType.FALSE;
    L17:
        r8.put("is_mention_again", r2);
        long r3 = 0;
        LinkCrossRoomDataHolder r4 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r4 == null) goto L26;
        if (r4.i() != 0) goto L26;
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L24;
        r3 = r5.f();
        goto L26
    L24:
        r3 = 0;
    L26:
        if (Intrinsics.areEqual(this.a.k, Boolean.TRUE) == false) goto L28;
        String r6 = "livesdk_connection_mute_all_window";
    L29:
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r10.putAll(r8);
        mz0.m r12 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r13 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r13, "linkInfoLog");
        r13.c(r3);
        ((ArrayList) r12.a).add(r13.a);
        LinkCrossRoomDataHolder.a r14 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r12);
        r12.b(LogCommon.ROOM);
        ((ArrayList) r9.b).addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3(r6, r9.a, r9.b);
        return;
    L28:
        r6 = "livesdk_connection_mute_window";
        goto L29
    L16:
        r2 = DataType.TRUE;
        goto L17
    L12:
        r1 = "";
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L9;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
