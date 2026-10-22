package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public i(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        so0.a r5 = this.a.h;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r6 = r5.a();
        if (r6 == null) goto L10;
        AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
        if (r7 == null) goto L10;
        r7.reportReSetMiniCardCover();
    L10:
        so0.a r8 = this.a.h;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L13:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L22;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L22;
        String r0 = this.a.z1().getAppId();
        if (r0 != null) goto L20;
        r0 = "";
    L20:
        r10.reportExplainCardSettingChangeCover(r0);
    L22:
        if (this.a.z1().canModifyCover() == true) goto L25;
        f2.b(2131920923, 0);
        return;
    L25:
        ExplainCardCoverActionSheetDialog r11 = new ExplainCardCoverActionSheetDialog();
        Bundle r1 = new Bundle();
        r1.putParcelable("cover_action_sheet_dialog_config", this.a.z1().buildCoverActionConfig());
        Unit r2 = Unit.INSTANCE;
        r11.setArguments(r1);
        FragmentManager r3 = this.a.getSupportFragmentManager();
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "ExplainCardCoverActionSheetDialog", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r11, r12) == true) goto L34;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L29:
        r11.show(r3, "ExplainCardCoverActionSheetDialog");
        return;
    }
}
