package o89;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o extends PanelItem.OnClickListener {
    public final /* synthetic */ q89.b a;

    public o(q89.b r1) {
        this.a = r1;
    }

    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        String r0 = this.a.d();
        if (r0 == null) goto L14;
        Uri r1 = y0.h(r0);
        if (r1 == null) goto L16;
        Uri.Builder r2 = r1.buildUpon();
        String r3 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b88263.c21281.d375196", PageFinder.via(r8), null, 4, null);
        if (o0.d(r3) == false) goto L10;
        r2.appendQueryParameter("source_btm_token", r3);
    L10:
        IECommerceService r4 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r4 == null) goto L15;
        r4.c(r8.getContext(), r2.build());
        return;
    L15:
        return;
    L16:
        return;
    }
}
