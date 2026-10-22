package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends AbsChameleonHandler<PanelOptions> {
    public final String a;
    public final swb.c b;

    public h() {
        this.a = LKAPIModules.Widget.ShowPanel.getValue();
        this.b = new swb.c();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final String getName() {
        return this.a;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
    public final void handle(PanelOptions r9, final Callback r10) {
        PanelOptions r11 = r9;
        Intrinsics.checkNotNullParameter(r11, "req");
        Intrinsics.checkNotNullParameter(r10, "callback");
        swb.c r0 = this.b;
        monitor-enter(r0);
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        if ((r1 - r0.a) <= 1000) goto L8;
        r0.a = r1;     // Catch: Throwable -> L25
        boolean r2 = true;
    L9:
        monitor-exit(r0);
        if (r2 == true) goto L13;
        r10.error(new LKAPIError(-1, "invoke too frequently"));
        return;
    L13:
        IChameleonHandlerContext r3 = getContext();
        if (r3 != null) goto L16;
        r10.error(new LKAPIError(-1, "context is null"));
        return;
    L16:
        int r4 = PanelBottomDialog.y;
        Function2<PanelPickerResult, Integer, Unit> r5 = new ShowPanelHandler$showPanelBottomSheet$bottomSheet$1(r10);
        Intrinsics.checkNotNullParameter(r11, "options");
        PanelBottomDialog r6 = new PanelBottomDialog();
        r6.e = r11;
        r6.f = r5;
        Fragment r12 = r3.getFragment();
        if (r12 == null) goto L23;
        FragmentManager r13 = r12.getChildFragmentManager();
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "CmlPanelBottomSheet", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r6, r14) == true) goto L36;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L22:
        r6.show(r13, "CmlPanelBottomSheet");
        return;
    L36:
        return;
    L23:
        r10.error(new LKAPIError(-1, "context is null"));
        return;
    L8:
        r2 = false;
    L25:
        th = move-exception;
        throw th;
    }
}
