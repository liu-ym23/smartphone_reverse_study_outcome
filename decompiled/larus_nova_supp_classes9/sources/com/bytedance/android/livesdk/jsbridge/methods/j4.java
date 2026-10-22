package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showDouPlusDialog")
public final class j4 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("enter_from")
        String entranceType;

        @SerializedName("sec_anchor_id")
        String secAnchorId;

        public a() {
        }
    }

    public j4() {
    }

    public final Object invoke(Object r10, final CallContext r11) throws Exception {
        final a r13 = (a) r10;
        final ILiveDouPlusService r0 = jc1.k.f(ILiveDouPlusService.class);
        if (r0 == null) goto L10;
        Room r1 = jc1.k.f(IRoomService.class).getCurrentRoom();
        if (r1 == null) goto L11;
        jc1.k.f(ILiveDouPlusService.class).showDouPlusLiveEntry(r1.author().getCastSecUid(), r1.getId(), r13.entranceType, new h4(this, r11, r13, r0));
        return null;
    L11:
        return null;
    L10:
        return null;
    }
}
