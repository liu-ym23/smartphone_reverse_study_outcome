package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.gameplay.api.CollectResponse")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/h;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/h$a;", "data", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/h$a;", "<init>", "()V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("data")
    public a data;

    @ProtoMessage("webcast.gameplay.api.CollectResponse.Data")
    public static final class a implements vh7.h {
        public a(am3.g r5) {
            long r0 = r5.c();
        L4:
            if (r5.f() == (-1)) goto L6;
            am3.h.e(r5);
            goto L4
        L6:
            r5.d(r0);
        }
    }

    public h() {
    }

    public h(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.data = new a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }
}
