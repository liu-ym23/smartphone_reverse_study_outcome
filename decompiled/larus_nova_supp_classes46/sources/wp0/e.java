package wp0;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCard;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements TextWatcher {
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public e(ShelfManagementSellingPointSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r4) {
        if (r4 == null) goto L5;
        String r5 = r4.toString();
        if (r5 == null) goto L5;
    L6:
        ShelfManagementCard r0 = (ShelfManagementCard) this.a.S90(2131386214);
        if (r5.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        String r2 = r5;
    L13:
        if (r2 != null) goto L15;
        r2 = s1.B(2131920946);
    L15:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "sellingPoint");
        ((TextView) r0.a(2131385888)).setText(r2);
        this.a.X90(r5);
        return;
    L12:
        r2 = null;
        goto L13
    L9:
        r1 = false;
    L5:
        r5 = "";
        goto L6
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        ShelfManagementSellingPointSettingDialog r5 = this.a;
        if (r5.h == true) goto L24;
        r5.h = true;
        so0.a r6 = r5.e;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r7 = r6.a();
        if (r7 == null) goto L25;
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
        if (r8 == null) goto L26;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r9 = AnchorMiniAppDataContext.a.a();
        if (r9 == null) goto L21;
        n<ShelfInfo> r10 = r9.m618getShelfInfo();
        if (r10 == null) goto L21;
        ShelfInfo r11 = (ShelfInfo) r10.getValue();
        if (r11 == null) goto L21;
        ShelfMicroAppInfo r12 = r11.appInfo;
        if (r12 == null) goto L21;
        String r13 = r12.appId;
        if (r13 == null) goto L21;
    L22:
        r8.reportEditSellingPointStart(r13);
        return;
    L21:
        r13 = "";
        goto L22
    L26:
        return;
    L25:
        return;
    }
}
