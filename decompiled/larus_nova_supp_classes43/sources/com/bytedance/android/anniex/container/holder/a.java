package com.bytedance.android.anniex.container.holder;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.container.ui.AnnieXDialog;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends d implements ja.a {
    public final com.bytedance.android.anniex.base.builder.c a;
    public AnnieXDialog b;
    public final ia.b c;
    public final ka.a d;

    @Override // com.bytedance.android.anniex.container.holder.d
    public final ia.b a() {
        return this.c;
    }

    public a(com.bytedance.android.anniex.base.builder.c r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.a = r10;
        if (r10.i == false) goto L5;
        ia.b r0 = new AnnieXFlowPopupContainer(r10);
    L6:
        this.c = r0;
        this.d = r10.k;
        return;
    L5:
        r0 = new com.bytedance.android.anniex.container.d(r10);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [ia.b, ia.f, java.lang.Object] */
    @Override // ja.a
    public final void show(String r10) {
        Bundle r0 = this.a.c;
        Intrinsics.checkNotNullParameter(r0, "bundle");
        String r1 = r0.getString("__x_session_id");
        if (r1 == null) goto L8;
        long r11 = r0.getLong("open_time", 0);
        if (r11 <= 0) goto L7;
        Map<String, i36.d> r12 = MonitorManager.a;
        MonitorManager.e(r1, Long.valueOf(r11));
        goto L8
    L7:
        Map<String, i36.d> r13 = MonitorManager.a;
        MonitorManager.e(r1, Long.valueOf(System.currentTimeMillis()));
    L8:
        Context r14 = this.c.getSystemContext();
        if (r14 == null) goto L11;
        boolean r15 = BulletSdk.a;
        BulletSdk.c(r14);
    L11:
        AnnieXDialog r16 = this.b;
        if (r16 != null) goto L18;
        r16 = new AnnieXDialog();
        r16.setArguments(this.a.c);
        ?? r17 = this.c;
        Intrinsics.checkNotNullParameter(r17, "popupContainer");
        r16.d = r17;
        ka.a r18 = this.d;
        if (r18 == null) goto L17;
        Intrinsics.checkNotNullParameter(r18, "listener");
    L17:
        this.b = r16;
    L18:
        FragmentManager r19 = this.a.e().getSupportFragmentManager();
        LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, r10, r20);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r16, r20) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L22:
        r16.show(r19, r10);
        return;
    }
}
