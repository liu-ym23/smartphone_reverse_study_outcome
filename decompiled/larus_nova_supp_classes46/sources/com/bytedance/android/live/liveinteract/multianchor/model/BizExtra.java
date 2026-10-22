package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.e0;
import com.bytedance.android.livesdk.link.model.bridge.y1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic.ListBizExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/BizExtra;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/e0;", "Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "openGameInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "getOpenGameInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/y1;", "setOpenGameInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/y1;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BizExtra extends FlexModelBase<e0> implements e0, vh7.h {

    @SerializedName("open_game")
    protected y1 openGameInfo;

    public BizExtra() {
        super(e0.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.bridge.y1, java.lang.Object] */
    public BizExtra(am3.g r6) {
        super(e0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 3) goto L7;
        this.openGameInfo = vh7.f.a(r6, y1.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    public y1 getOpenGameInfo() {
        return this.openGameInfo;
    }

    public void setOpenGameInfo(y1 r1) {
        this.openGameInfo = r1;
    }
}
