package com.bytedance.android.anniex.container.holder;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.container.ui.AnnieXSLDialog;
import com.bytedance.android.anniex.salamander.SLPopup;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.l;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements ja.a {
    public final com.bytedance.android.anniex.base.builder.c a;
    public AnnieXSLDialog b;
    public final SLPopup c;
    public final ka.a d;

    public c(com.bytedance.android.anniex.base.builder.c r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.a = r10;
        int r0 = SLPopup.y;
        this.c = SLPopup.a.a(r10);
        this.d = r10.k;
    }

    @Override // ja.c
    public final void loadSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        AnnieXSLDialog r11 = this.b;
        if (r11 == null) goto L13;
        AnnieXBaseViewModel r12 = r11.d;
        g3 r0 = null;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("slPopupViewModel");
        r12 = null;
    L7:
        r12.getClass();
        l r1 = new l(r12);
        g3 r13 = r12.a().a;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
    L11:
        r0.b(r1);
        return;
    L10:
        r0 = r13;
        goto L11
    }

    @Override // ja.a
    public final void show(String r10) {
        AnnieXSLDialog r0 = this.b;
        if (r0 != null) goto L9;
        r0 = new AnnieXSLDialog();
        r0.setArguments(this.a.c);
        SLPopup r1 = this.c;
        Intrinsics.checkNotNullParameter(r1, "slPopup");
        r0.e = r1;
        r0.d = r1.n();
        ka.a r11 = this.d;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r11, "listener");
    L8:
        this.b = r0;
    L9:
        FragmentManager r12 = this.a.e().getSupportFragmentManager();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r10, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r0, r13) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        r0.show(r12, r10);
        return;
    }
}
