package com.bytedance.android.livesdk.gift.platform.format.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.FormatGiftDialog;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements o, m {
    public FormatGiftDialog a;
    public GiftViewModelManager b;
    public long c;
    public final i12.e d;
    public final Context e;
    public final DataCenter f;

    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.format.service.m
    public final void c() {
        FormatGiftDialog r0 = this.a;
        if (r0 != null) goto L20;
    L10:
        this.a = null;
        com.bytedance.android.scope.j r1 = q12.b.a;
        if (r1 != null) goto L13;
    L18:
        q12.b.a = null;
        this.b = null;
        return;
    L13:
        if (com.bytedance.android.scope.l.b(r1) == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        com.bytedance.android.scope.l.c(r1);
        goto L18
    L20:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L10;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.format.service.m
    public final long getToUserId() {
        return this.c;
    }

    public final void onStop() {
        c();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.format.service.m
    public final void a(long r4) {
        if (r4 <= 0) goto L6;
        this.c = r4;
    L6:
        if (this.a == null) goto L8;
        c();
    L8:
        q12.c r5 = new q12.c(this.d);
        Intrinsics.checkNotNullParameter(r5, "scope");
        Object r6 = e33.k.a;
        if (r5.e != r6) goto L12;
        String r7 = "context";
    L24:
        if (r7 != null) goto L32;
        q12.b.a = r5;
        com.bytedance.android.scope.l.a(r5);
        FragmentActivity r8 = this.e;
        if (r8 == null) goto L30;
        GiftViewModelManager r9 = (GiftViewModelManager) ViewModelProviders.of(r8).get(GiftViewModelManager.class);
        r9.setAllCommonData(this.e, this.f);
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.l.b);
        this.b = r9;
        DataCenter r10 = this.f;
        Context r0 = this.e;
        GiftViewModelManager r2 = this.b;
        Intrinsics.checkNotNull(r2);
        this.a = new FormatGiftDialog(r10, r0, r2);
        GiftStateMachineConfig.Event.v r11 = new GiftStateMachineConfig.Event.v(false, true, 3, false);
        r11.b = new GiftStateMachineConfig.c(null, 63);
        com.bytedance.android.livesdk.gift.util.b.f(r11);
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L32:
        throw new UninitializedPropertyAccessException(r7);
    L12:
        if (r5.f != r6) goto L15;
        r7 = "dataCenter";
        goto L24
    L15:
        if (r5.g != r6) goto L18;
        r7 = "isInLive";
        goto L24
    L18:
        if (r5.h != r6) goto L21;
        r7 = "roomContext";
        goto L24
    L21:
        if (r5.i != r6) goto L23;
        r7 = "roomInstance";
        goto L24
    L23:
        r7 = null;
        goto L24
    }

    public n(i12.e r2, Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }
}
