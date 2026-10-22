package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.open.api.CounterPlayer")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterPlayerFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/e;", "", "openId$delegate", "Ljava/lang/Object;", "getOpenId", "()Ljava/lang/String;", "openId", "", "roomId$delegate", "getRoomId", "()J", "roomId", "points$delegate", "getPoints", "points", "", "creator$delegate", "getCreator", "()Z", "creator", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterPlayerFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("creator")
    protected boolean _$$creator;

    @SerializedName("open_id")
    protected String _$$openId;

    @SerializedName("points")
    protected String _$$points;

    @SerializedName("room_id")
    protected long _$$roomId;

    public CounterPlayerFlexImpl() {
        super(e.class);
        this._$$openId = "";
        this._$$points = "";
        this._$$creator = false;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.e
    public final boolean getCreator() {
        return this._$$creator;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.e
    public final String getOpenId() {
        return this._$$openId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.e
    public final String getPoints() {
        return this._$$points;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.e
    public final long getRoomId() {
        return this._$$roomId;
    }

    public CounterPlayerFlexImpl(am3.g r9) {
        super(e.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L17;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$openId = am3.h.c(r9);
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this._$$roomId = r9.j();
        r3 = r3 | 1;
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this._$$points = am3.h.c(r9);
        goto L3
    L11:
        if (r4 != 4) goto L12;
        this._$$creator = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L12:
        am3.h.d(r5, r9);
        goto L3
    L17:
        r9.d(r1);
        setThreadSafe(true);
        if (this._$$openId != null) goto L21;
        this._$$openId = "";
    L21:
        if (this._$$points != null) goto L24;
        this._$$points = "";
    L24:
        if ((r3 & 2) != 0) goto L42;
        this._$$creator = false;
        return;
    }
}
