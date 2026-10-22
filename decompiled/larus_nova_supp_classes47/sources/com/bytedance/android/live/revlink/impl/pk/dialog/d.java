package com.bytedance.android.live.revlink.impl.pk.dialog;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.ui.PkFeedbackView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ PkFeedbackSwitchDialog a;
    public final /* synthetic */ Ref.BooleanRef b;

    public d(PkFeedbackSwitchDialog r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        ExtraResponse r10 = (ExtraResponse) r9;
        if (this.a.isShowing() == true) goto L46;
    L19:
        HashMap r12 = new HashMap();
        r12.put("action_from", "page");
        boolean r1 = this.a.g;
        String r2 = DataType.TRUE;
        if (r1 == false) goto L22;
        String r3 = DataType.TRUE;
    L23:
        r12.put("is_anchor", r3);
        if (this.b.element == true) goto L27;
        r2 = "2";
    L27:
        r12.put("toast_content", r2);
        long r4 = 0;
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        long r6 = 0;
        if (r5 != null) goto L30;
    L35:
        long r7 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r8 == null) goto L38;
        r6 = r8.getPkStartTimeMs();
    L38:
        String r13 = String.valueOf((r7 - r6) / ((long) WebcastRedirectException.UNKNOWN));
        r12.put("source", "feedback_page");
        String r14 = ((PkFeedbackView) this.a.S90(2131382348)).getSelectTag();
        if (r14 != null) goto L41;
        r14 = "";
    L41:
        r12.put("contect", r14);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r12, "map");
        r16.putAll(r12);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        r17.b(LogCommon.PAGE_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.h r18 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r18, "linkInfoLog");
        r18.c(r4);
        Intrinsics.checkNotNullParameter(r13, "connectionTime");
        r18.b(r13);
        ((ArrayList) r17.a).add(r18.a);
        LinkCrossRoomDataHolder.a r19 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r17);
        ((ArrayList) r15.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_pk_start_feedback_submit_success", r15.a, r15.b);
        if (this.b.element == false) goto L44;
        ToastUtil.a(2131921424, 0);
        return;
    L44:
        int r23 = ToastUtil.a;
        ToastUtil.b(s1.C(2131921426, new Object[]{this.a.j}), 0);
        return;
    L30:
        if (r5.i() != 0) goto L35;
        LinkCrossRoomDataHolder r24 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r24 == null) goto L34;
        r4 = r24.f();
        goto L35
    L34:
        r4 = 0;
        goto L35
    L22:
        r3 = DataType.FALSE;
        goto L23
    L46:
        this.a.dismiss();     // Catch: Exception -> L7
    L12:
        if (y.c() == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r25 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r25 == null) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r25, 0, 0, null, 7);
        goto L19
    L16:
        com.bytedance.android.live.revlink.impl.pk.service.h r26 = com.bytedance.android.live.revlink.impl.global.b.U();
        if (r26 == null) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.h.a.a(r26, null, 3);
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L12;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }
}
