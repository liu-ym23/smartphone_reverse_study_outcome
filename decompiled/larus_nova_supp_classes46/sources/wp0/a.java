package wp0;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.CheckSellingPointRejectType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;
    public final /* synthetic */ String b;

    public a(ShelfManagementSellingPointSettingDialog r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.a) r8.data).c() == false) goto L5;
        ShelfManagementSellingPointSettingDialog r9 = this.a;
        String r0 = this.b;
        int r1 = ShelfManagementSellingPointSettingDialog.j;
        r9.W90(r0);
        return;
    L5:
        String r2 = "";
        if (((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.a) r8.data).b() != CheckSellingPointRejectType.SENSITIVE_WORDS.ordinal()) goto L12;
        ShelfManagementSellingPointSettingDialog r3 = this.a;
        String r4 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.a) r8.data).a();
        int r5 = ShelfManagementSellingPointSettingDialog.j;
        ((TextView) r3.S90(2131365637)).setVisibility(0);
        TextView r6 = (TextView) r3.S90(2131365637);
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r6.setText(r4);
    L13:
        so0.a r10 = this.a.e;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L16:
        OpenPlatformContext r11 = r10.a();
        if (r11 == null) goto L38;
        AnchorMiniAppAppLogContextService r12 = (AnchorMiniAppAppLogContextService) r11.getService(AnchorMiniAppAppLogContextService.class);
        if (r12 == null) goto L39;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r13 = AnchorMiniAppDataContext.a.a();
        if (r13 == null) goto L30;
        n<ShelfInfo> r14 = r13.m618getShelfInfo();
        if (r14 == null) goto L30;
        ShelfInfo r15 = (ShelfInfo) r14.getValue();
        if (r15 == null) goto L30;
        ShelfMicroAppInfo r16 = r15.appInfo;
        if (r16 == null) goto L30;
        String r17 = r16.appId;
        if (r17 == null) goto L30;
    L31:
        int r18 = this.b.length();
        String r19 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.a) r8.data).a();
        if (r19 == null) goto L35;
        r2 = r19;
    L35:
        r12.reportEditSellingPointResult(r17, false, r18, r2);
        return;
    L30:
        r17 = "";
        goto L31
    L39:
        return;
    L38:
        return;
    L12:
        f2.c(((com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.a) r8.data).a(), 0);
        goto L13
    }
}
