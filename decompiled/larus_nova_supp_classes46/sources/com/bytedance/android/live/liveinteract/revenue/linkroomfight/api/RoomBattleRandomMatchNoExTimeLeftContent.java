package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.l0;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleRandomMatchNoExTimeLeftContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/l0;", "", "waitingSec", "Ljava/lang/Long;", "getWaitingSec", "()Ljava/lang/Long;", "setWaitingSec", "(Ljava/lang/Long;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomBattleRandomMatchNoExTimeLeftContent extends FlexModelBase<l0> implements l0, h {

    @SerializedName("waiting_sec")
    protected Long waitingSec;

    public RoomBattleRandomMatchNoExTimeLeftContent() {
        super(l0.class);
        this.waitingSec = 0L;
    }

    public Long getWaitingSec() {
        return this.waitingSec;
    }

    public RoomBattleRandomMatchNoExTimeLeftContent(g r6) {
        super(l0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.waitingSec = Long.valueOf(r6.j());
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this.waitingSec != null) goto L19;
        this.waitingSec = 0L;
        return;
    }

    public void setWaitingSec(Long r1) {
        this.waitingSec = r1;
    }
}
