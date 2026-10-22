package lx0;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements IMiddlewareHostBusiness.OnLiveHighlightPublish {
    public final /* synthetic */ LiveScreenRecordPublishGuideDialog a;

    public a(LiveScreenRecordPublishGuideDialog r1) {
        this.a = r1;
    }

    public final void onPublish(int r3) {
        if (r3 != 1) goto L6;
        f2.c("发布失败", 0);
    L6:
        LiveScreenRecordPublishGuideDialog r4 = this.a;
        int r0 = LiveScreenRecordPublishGuideDialog.G;
        r4.W0(false);
        PublishDialogInfo r5 = this.a.F;
        if (r5.a == false) goto L10;
        int r1 = z22.c.a;
        z22.c.b(r5.g);
        return;
    }
}
