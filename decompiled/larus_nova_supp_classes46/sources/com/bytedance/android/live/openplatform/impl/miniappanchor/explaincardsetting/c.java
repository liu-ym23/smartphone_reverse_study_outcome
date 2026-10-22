package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public c(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        so0.a r5 = this.a.h;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r6 = r5.a();
        if (r6 == null) goto L13;
        AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
        if (r7 == null) goto L13;
        String r1 = this.a.z1().getAppId();
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        r7.reportExplainCardClickEdit(r1);
    L13:
        so0.a r8 = this.a.h;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L16:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L21;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L21;
        r10.reportReSetMiniCardTitle();
    L21:
        ExplainCardTitleEditorDialog r11 = new ExplainCardTitleEditorDialog();
        Bundle r0 = new Bundle();
        r0.putInt("editor_type", 1);
        r0.putString("editor_label_title", s1.B(2131920944));
        r0.putString("editor_title", this.a.z1().getExplainCardTitle());
        Unit r2 = Unit.INSTANCE;
        r11.setArguments(r0);
        FragmentManager r3 = this.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "MiniAppTitleEditorDialogFragment", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r11, r12) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        r11.show(r3, "MiniAppTitleEditorDialogFragment");
        return;
    }
}
