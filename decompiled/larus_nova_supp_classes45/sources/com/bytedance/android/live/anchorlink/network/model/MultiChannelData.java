package com.bytedance.android.live.anchorlink.network.model;

import am3.g;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.linkmic.GetCrossRoomRTCInfoResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/anchorlink/network/model/MultiChannelData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/r1;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "_multiChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "get_multiChannel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "set_multiChannel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;)V", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannel", "()Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "multiChannel", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiChannelData extends FlexModelBase<r1> implements r1, h {

    @SerializedName("multi_channel_info")
    protected MultiChannelInfo _multiChannel;

    public MultiChannelData() {
        super(r1.class);
    }

    public MultiChannelData(g r6) {
        super(r1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._multiChannel = new MultiChannelInfo(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    public s1 getMultiChannel() {
        return this._multiChannel;
    }

    public final MultiChannelInfo get_multiChannel() {
        return this._multiChannel;
    }

    public final void set_multiChannel(MultiChannelInfo r1) {
        this._multiChannel = r1;
    }
}
