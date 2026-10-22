package s89;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d extends PanelItem.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public final void onClick(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        String r0 = this.a;
        if (r0 == null) goto L10;
        Uri.Builder r1 = y0.h(r0).buildUpon();
        String r2 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b88263.c21281.d375196", PageFinder.via(r10), null, 4, null);
        if (o0.d(r2) == false) goto L7;
        r1.appendQueryParameter("source_btm_token", r2);
    L7:
        IECommerceService r3 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r3 == null) goto L10;
        r3.c(r10.getContext(), r1.build());
    L10:
        String r4 = this.b;
        if (r4 == null) goto L14;
        EventCenter.enqueueEvent(new Event(r4, System.currentTimeMillis(), null, 4, null));
        return;
    }

    public d(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
