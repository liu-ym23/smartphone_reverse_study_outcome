package cr0;

import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameDialogFragment;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ PreviewMiniGameDialogFragment a;

    public d(PreviewMiniGameDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        OpenPlatformContext r5 = this.a.e;
        if (r5 == null) goto L8;
        AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
        if (r6 == null) goto L9;
        HashMap<String, String> r7 = new HashMap();
        r7.put("screen_split_rate", "0.3");
        r7.put("click_type", "cancel");
        Unit r0 = Unit.INSTANCE;
        r6.reportPreviewMgAppLog("livesdk_takepage_mg_remove_pop_click", r7);
        return;
    L9:
        return;
    }
}
