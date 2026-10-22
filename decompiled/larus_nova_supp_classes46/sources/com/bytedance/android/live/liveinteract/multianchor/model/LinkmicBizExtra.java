package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.v0;
import com.bytedance.android.livesdk.link.model.bridge.x1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.LinkMicBizExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicBizExtra;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/v0;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameConfig;", "openGameInfo", "Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameConfig;", "getOpenGameInfo", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameConfig;", "setOpenGameInfo", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/OpenGameConfig;)V", "Lcom/bytedance/android/livesdk/link/model/bridge/x1;", "getOpenGameConfig", "()Lcom/bytedance/android/livesdk/link/model/bridge/x1;", "openGameConfig", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicBizExtra extends FlexModelBase<v0> implements v0, vh7.h {

    @SerializedName("open_game_config")
    protected OpenGameConfig openGameInfo;

    public LinkmicBizExtra() {
        super(v0.class);
    }

    public LinkmicBizExtra(am3.g r6) {
        super(v0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.openGameInfo = new OpenGameConfig(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    public x1 getOpenGameConfig() {
        OpenGameConfig r0 = this.openGameInfo;
        if ((r0 instanceof x1) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public final OpenGameConfig getOpenGameInfo() {
        return this.openGameInfo;
    }

    public final void setOpenGameInfo(OpenGameConfig r1) {
        this.openGameInfo = r1;
    }
}
