package com.bytedance.android.livesdk.gift.fastgift;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.z a;
    public final /* synthetic */ PopupGiftDialogFragment b;

    public d0(com.bytedance.android.livesdk.gift.platform.core.model.z r1, PopupGiftDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Context r7 = this.b.requireContext();
        com.bytedance.android.livesdk.gift.platform.core.model.z r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.d();
        if (r1 == null) goto L6;
    L7:
        zz0.h.b(r7, r1);
        FastGiftViewModel r8 = this.b.e;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        if (r8.getRechargedState() != 2) goto L13;
        boolean r9 = true;
    L14:
        GiftManagerKt.z.getClass();
        long r2 = GiftManagerKt.r();
        FastGiftViewModel r3 = this.b.e;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        String r4 = r3.getPopupGiftClickSource();
        int r5 = a.a;
        Intrinsics.checkNotNullParameter(r4, "clickSource");
        HashMap r10 = new HashMap();
        r10.put("gift_id", String.valueOf(r2));
        r10.put("click_source", r4);
        if (r9 == false) goto L20;
        String r11 = "1";
    L21:
        r10.put("is_charged", r11);
        mz0.n r13 = new mz0.n();
        Map r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r14.putAll(r10);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        r15.b(LogCommon.PAGE_SOURCE_LOG);
        List r16 = r13.b;
        ArrayList r17 = (ArrayList) r16;
        r17.addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_norecharge_gift_guide_click", r13.a, r13.b);
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r20 = DialogFragmentLancet.sLastShowStack;
        if (r20 == null) goto L31;
        com.bytedance.crash.d.d(r20, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L31:
        return;
    L20:
        r11 = "0";
        goto L21
    L13:
        r9 = false;
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }
}
