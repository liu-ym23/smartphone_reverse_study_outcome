package dq0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.bytedance.live.datacontext.n;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ Context b;

    public c(d r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Context r7 = this.b;
        if ((r7 instanceof FragmentActivity) == true) goto L5;
        r7 = null;
    L5:
        FragmentActivity r8 = (FragmentActivity) r7;
        if (r8 == null) goto L14;
        d r0 = this.a;
        ShelfCardInfo r1 = r0.b;
        if (r1 == null) goto L14;
        int r2 = ShelfManagementSellingPointSettingDialog.j;
        int r3 = r0.c;
        Intrinsics.checkNotNullParameter(r8, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r1, "cardInfo");
        ShelfManagementSellingPointSettingDialog r4 = new ShelfManagementSellingPointSettingDialog();
        Bundle r5 = new Bundle();
        r5.putParcelable("card_info", r1);
        r5.putInt("card_position", r3);
        Unit r9 = Unit.INSTANCE;
        r4.setArguments(r5);
        FragmentTransaction r10 = r8.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "ShelfManagementSellingPointSettingDialog", 0) == true) goto L13;
        r10 = r10.add(r4, "ShelfManagementSellingPointSettingDialog");
    L13:
        r10.commitAllowingStateLoss();
    L14:
        OpenPlatformContext r11 = this.a.getMiniAppAnchorService().a();
        if (r11 == null) goto L31;
        AnchorMiniAppAppLogContextService r12 = (AnchorMiniAppAppLogContextService) r11.getService(AnchorMiniAppAppLogContextService.class);
        if (r12 == null) goto L32;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r13 = AnchorMiniAppDataContext.a.a();
        if (r13 == null) goto L28;
        n<ShelfInfo> r14 = r13.m618getShelfInfo();
        if (r14 == null) goto L28;
        ShelfInfo r15 = (ShelfInfo) r14.getValue();
        if (r15 == null) goto L28;
        ShelfMicroAppInfo r16 = r15.appInfo;
        if (r16 == null) goto L28;
        String r17 = r16.appId;
        if (r17 == null) goto L28;
    L29:
        r12.reportCardMorePanelClick(r17, "click_sell_point");
        return;
    L28:
        r17 = "";
        goto L29
    L32:
        return;
    }
}
