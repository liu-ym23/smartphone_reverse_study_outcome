package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final g mListener;
    private final WsChannelMsg origin;

    MainProcessMsg(WsChannelMsg r3, g r4) {
        g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        super(r3);
        this.origin = r3;
        this.mListener = r5;
    }

    public g getListener() {
        return this.mListener;
    }

    WsChannelMsg getOrigin() {
        return this.origin;
    }
}
