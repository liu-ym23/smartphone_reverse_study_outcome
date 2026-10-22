package com.bytedance.android.live.base.model.proto;

import am3.c;
import com.bytedance.android.live.liveinteract.plantform.model.InviteSearchData;
import com.bytedance.android.live.liveinteract.plantform.model._InviteSearchData_ProtoDecoder;
import com.bytedance.android.livesdk.chatroom.model.interact.RivalsSearchAnchorInfo;
import com.bytedance.android.livesdk.chatroom.model.interact._RivalsSearchAnchorInfo_ProtoDecoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class _ProtoDecoders_LIVEBASE {
    private static final Map<Class, c> DECODER_MAP = null;

    public _ProtoDecoders_LIVEBASE() {
    }

    static {
        DECODER_MAP = new HashMap();
    }

    public final void inject(Map<Class, c> r3) {
        r3.put(RivalsSearchAnchorInfo.class, new _RivalsSearchAnchorInfo_ProtoDecoder());
        r3.put(InviteSearchData.class, new _InviteSearchData_ProtoDecoder());
    }
}
