package com.bytedance.android.live.room.api.record;

import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveRecordMonitorServiceWidget a;
    public final /* synthetic */ String b;

    public c(LiveRecordMonitorServiceWidget r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        LiveRecordMonitorServiceWidget r0 = this.a;
        String r1 = this.b;
        String r6 = ((ILiveRecordService.RecordMetaData) r5).getNewFile();
        r0.getClass();
        PublishDialogInfo r2 = new PublishDialogInfo(((Widget) r0).context, r1, r6);
        r2.c = ((Widget) r0).dataCenter;
        ILiveScreenRecordService r7 = (ILiveScreenRecordService) k.f(ILiveScreenRecordService.class);
        if (r7 == null) goto L5;
        com.bytedance.android.live.room.api.record.guide.a r8 = r7.getPublishGuideDialog(r2);
    L6:
        if (r8 == null) goto L11;
        com.bytedance.android.live.room.api.record.guide.b r9 = r8.a;
        if (r9 == null) goto L12;
        r9.show();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r8 = null;
        goto L6
    }
}
