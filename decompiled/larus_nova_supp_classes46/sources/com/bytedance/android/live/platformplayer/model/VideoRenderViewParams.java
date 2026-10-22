package com.bytedance.android.live.platformplayer.model;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ds0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/platformplayer/model/VideoRenderViewParams;", "Lds0/e;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoRenderViewParams implements e, Observer<KVData> {
    public final MutableLiveData<VideoViewParams> a;

    @Override // ds0.e
    public final MutableLiveData<VideoViewParams> getParams() {
        return this.a;
    }

    public VideoRenderViewParams(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        MutableLiveData<VideoViewParams> r0 = new MutableLiveData();
        this.a = r0;
        if (r5.get("live_render_view_params", null) == null) goto L5;
        r0.setValue(r5.get("live_render_view_params", null));
    L5:
        r5.observe("live_render_view_params", this);
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L17;
        MutableLiveData<VideoViewParams> r0 = null;
        VideoViewParams r1 = (VideoViewParams) r5.getData(null);
        if (r1 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5.getKey(), "live_render_view_params") == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L19;
        MutableLiveData<VideoViewParams> r6 = this.a;
        if ((!Intrinsics.areEqual((VideoViewParams) r6.getValue(), r1)) == false) goto L14;
        r0 = r6;
    L14:
        if (r0 == null) goto L20;
        r0.setValue(r1);
        return;
    L20:
        return;
    L19:
        return;
    }
}
