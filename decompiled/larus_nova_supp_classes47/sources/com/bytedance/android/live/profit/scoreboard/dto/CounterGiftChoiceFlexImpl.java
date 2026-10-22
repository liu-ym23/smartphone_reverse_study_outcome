package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.open.api.CounterGiftChoice")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterGiftChoiceFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/c;", "", "index$delegate", "Ljava/lang/Object;", "getIndex", "()J", "index", "", "giftName$delegate", "getGiftName", "()Ljava/lang/String;", "giftName", "icon$delegate", "getIcon", "icon", "value$delegate", "getValue", "value", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterGiftChoiceFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("icon")
    protected String _$$icon;

    @SerializedName("index")
    protected long _$$index;

    @SerializedName("value")
    protected long _$$value;

    public CounterGiftChoiceFlexImpl() {
        super(c.class);
        this._$$giftName = "";
        this._$$icon = "";
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.c
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.c
    public final String getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.c
    public final long getIndex() {
        return this._$$index;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.c
    public final long getValue() {
        return this._$$value;
    }

    public CounterGiftChoiceFlexImpl(am3.g r6) {
        super(c.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$index = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$giftName = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$icon = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$value = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$giftName != null) goto L22;
        this._$$giftName = "";
    L22:
        if (this._$$icon != null) goto L40;
        this._$$icon = "";
        return;
    }
}
