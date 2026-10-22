package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;

    public g(MultiLinkCommonVideoFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        IRoomLinkMicSyncData r12 = (IRoomLinkMicSyncData) r11;
        if (r12 == null) goto L17;
        StringBuilder r0 = new StringBuilder("onWRDSDataUpdate, clientUIInfo update, data: ");
        ClientUIInfo r1 = r12.getClientUIInfo();
        Integer r2 = null;
        if (r1 == null) goto L7;
        List r3 = r1.getUiFeatureList();
    L8:
        r0.append(r3);
        ALogger.d("CommonVideoFeedPreview", r0.toString());
        MultiLinkCommonVideoFeedPreview r4 = this.a;
        ClientUIInfo r5 = r12.getClientUIInfo();
        int r6 = MultiLinkCommonVideoFeedPreview.H;
        r4.J(r5);
        this.a.r = r12.getLinkerBaseInfo();
        IPreviewMultiLinkOuterConfigProvider r7 = this.a.getConfigOuterProvider();
        int r8 = this.a.hashCode();
        StringBuilder r9 = new StringBuilder("update wrdsLinkerBaseInfo, playModes = ");
        com.bytedance.android.live.liveinteract.plantform.model.q r10 = r12.getLinkerBaseInfo();
        if (r10 == null) goto L11;
        List<Long> r13 = r10.getPlayModes();
    L12:
        r9.append(r13);
        r9.append(", uiLayout = ");
        com.bytedance.android.live.liveinteract.plantform.model.q r14 = r12.getLinkerBaseInfo();
        if (r14 == null) goto L15;
        r2 = Integer.valueOf(r14.getUiLayout());
    L15:
        r9.append(r2);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r7, "CommonVideoFeedPreview", r8, r9.toString(), false, 8, null);
        return;
    L11:
        r13 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }
}
