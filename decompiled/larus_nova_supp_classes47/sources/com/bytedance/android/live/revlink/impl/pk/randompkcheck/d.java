package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.PkPanelService;
import com.bytedance.android.live.revlink.impl.pk.service.j;
import com.bytedance.android.live.revlink.impl.pk.ui.x;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ RandomPKCheckFragment a;

    public d(RandomPKCheckFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ExtraResponse r5 = (ExtraResponse) r4;
        jy0.b.c("random_pk_check_fragment", "on confirm autocheck succeed", null, 4);
        RandomCheckDataContext.Companion.c(true, true);
        this.a.dismiss();     // Catch: Exception -> L5
    L10:
        if (Intrinsics.areEqual(this.a.g, Boolean.TRUE) == false) goto L17;
        l51.a.y(true);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        PkPanelService r6 = com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.a.a();
        if (r6 == null) goto L33;
        String r0 = this.a.h;
        if (r0 != null) goto L16;
        r0 = "";
    L16:
        r6.startTeamPkMatch(r0);
        return;
    L33:
        return;
    L17:
        RandomPKCheckFragment r7 = this.a;
        j r1 = r7.k;
        if (r1 == null) goto L23;
        com.bytedance.android.live.revlink.impl.pk.service.a r8 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r8 == null) goto L35;
        r8.a(r1);
        return;
    L35:
        return;
    L23:
        if (r7.e == RandomMatchCheckSource.AttentionFragment) goto L37;
        d51.c r9 = d51.c.A0;
        r9.getClass();
        if (((Boolean) d51.c.v0.getValue(r9, d51.c.a[72])).booleanValue() == false) goto L29;
        x r10 = this.a.l;
        if (r10 == null) goto L29;
        r10.Fy("announcement_page");
        return;
    L29:
        RandomCheckDataContext.Companion.e("announcement_page");
        return;
    L37:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L10;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
