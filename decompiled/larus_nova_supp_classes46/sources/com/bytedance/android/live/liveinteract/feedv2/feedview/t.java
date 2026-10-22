package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public t(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        IRoomLinkMicSyncData r10 = (IRoomLinkMicSyncData) r9;
        if (r10 == null) goto L13;
        this.a.H = r10.getLinkerBaseInfo();
        IPreviewMultiLinkOuterConfigProvider r1 = MultiLinkCommonVoiceFeedPreview.x(this.a);
        int r3 = this.a.hashCode();
        StringBuilder r0 = new StringBuilder("update wrdsLinkerBaseInfo, playModes = ");
        com.bytedance.android.live.liveinteract.plantform.model.q r4 = r10.getLinkerBaseInfo();
        Integer r5 = null;
        if (r4 == null) goto L7;
        List<Long> r6 = r4.getPlayModes();
    L8:
        r0.append(r6);
        r0.append(", uiLayout = ");
        com.bytedance.android.live.liveinteract.plantform.model.q r11 = r10.getLinkerBaseInfo();
        if (r11 == null) goto L11;
        r5 = Integer.valueOf(r11.getUiLayout());
    L11:
        r0.append(r5);
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(r1, "MultiLinkCommonVoiceFeedPreview", r3, r0.toString(), false, 8, null);
        return;
    L7:
        r6 = null;
        goto L8
    }
}
