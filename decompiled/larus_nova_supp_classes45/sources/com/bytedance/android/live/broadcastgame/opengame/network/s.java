package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.open.api.GetPlayerPropInfoResponse.Data")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/s;", "", "", "openId", "Ljava/lang/String;", "", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/k0;", "propInfoMap", "Ljava/util/Map;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s implements vh7.h {

    @SerializedName("open_id")
    public String openId;

    @SerializedName("prop_info")
    public Map<Long, k0> propInfoMap;

    public s() {
    }

    public s(am3.g r12) {
        this.propInfoMap = new HashMap();
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L27;
        if (r2 != 1) goto L8;
        this.openId = am3.h.c(r12);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        long r6 = r12.c();
        Long r3 = null;
        k0 r8 = null;
    L11:
        int r9 = r12.f();
        if (r9 == (-1)) goto L18;
        if (r9 != 1) goto L14;
        r3 = Long.valueOf(r12.j());
        goto L11
    L14:
        if (r9 != 2) goto L15;
        r8 = new k0(r12);
        goto L11
    L15:
        am3.h.e(r12);
        goto L11
    L18:
        r12.d(r6);
        Map<Long, k0> r4 = this.propInfoMap;
        if (r3 == null) goto L25;
        if (r8 == null) goto L23;
        r4.put(r3, r8);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r12);
        goto L3
    L27:
        r12.d(r0);
    }
}
