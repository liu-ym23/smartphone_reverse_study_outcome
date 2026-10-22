package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.intercomment.InteractCommentDataContext;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/PkAnchorMicDialog$onCreate$2$1"}, k = 3, mv = {1, 5, 1})
public final class PkAnchorMicDialog$onCreate$$inlined$apply$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InteractCommentDataContext $interactCommentDataContext$inlined;
    final /* synthetic */ PkAnchorMicDialog this$0;

    public PkAnchorMicDialog$onCreate$$inlined$apply$lambda$2(PkAnchorMicDialog r1, InteractCommentDataContext r2) {
        this.this$0 = r1;
        this.$interactCommentDataContext$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m641invoke() {
        HashMap r0 = new HashMap();
        w31.c r1 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r1 == null) goto L5;
        Map<String, String> r2 = r1.f();
    L6:
        r0.putAll(r2);
        String r3 = this.this$0.d;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.put("click_anchor_id", r3);
        InteractCommentDataContext r4 = this.$interactCommentDataContext$inlined;
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.intercomment.b> r5 = r4.getService();
        if (r5 == null) goto L18;
        com.bytedance.android.live.revlink.impl.intercomment.b r6 = (com.bytedance.android.live.revlink.impl.intercomment.b) r5.getValue();
        if (r6 == null) goto L18;
        if (r6.a0() != true) goto L18;
        String r7 = DataType.FALSE;
    L19:
        r0.put("is_open", r7);
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r9.putAll(r0);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        List<Object> r12 = r8.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_connection_comment_exchange_click", r8.a, r8.b);
        InteractCommentDataContext r16 = InteractCommentDataContext.Companion.getContext();
        if (r16 == null) goto L24;
        com.bytedance.live.datacontext.k<Object> r17 = r16.getOnIconClickEvent();
        if (r17 == null) goto L24;
        r17.post(Boolean.TRUE);
    L24:
        INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_dialog_fragment_PkAnchorMicDialog$onCreate$$inlined$apply$lambda$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.this$0);
        return;
    L18:
        r7 = DataType.TRUE;
        goto L19
    L5:
        r2 = MapsKt.emptyMap();
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m641invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void INVOKEVIRTUAL_com_bytedance_android_live_revlink_impl_multianchor_dialog_fragment_PkAnchorMicDialog$onCreate$$inlined$apply$lambda$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(PkAnchorMicDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }
}
