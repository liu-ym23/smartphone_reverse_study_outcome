package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final f mListener;
    private final WsChannelMsg origin;

    MainProcessMsg(WsChannelMsg r10, f r11) {
        super(r10);
        this.origin = r10;
        this.mListener = r11;
    }

    public f getListener() {
        return this.mListener;
    }

    WsChannelMsg getOrigin() {
        return this.origin;
    }
}
