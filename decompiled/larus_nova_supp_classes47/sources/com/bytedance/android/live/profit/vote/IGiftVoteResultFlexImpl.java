package com.bytedance.android.live.profit.vote;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.GiftVoteResult")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001b\u0010\u001d\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010 \u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u0013R\u001b\u0010#\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000e¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/profit/vote/IGiftVoteResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vote/a;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "text", "", "count$delegate", "getCount", "()J", "count", "giftId$delegate", "getGiftId", "giftId", "giftName$delegate", "getGiftName", "giftName", "diamondCount$delegate", "getDiamondCount", "diamondCount", "giftType$delegate", "getGiftType", "giftType", "countStr$delegate", "getCountStr", "countStr", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftVoteResultFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("count")
    protected long _$$count;

    @SerializedName("count_str")
    protected String _$$countStr;

    @SerializedName("diamond_count")
    protected long _$$diamondCount;

    @SerializedName("gift_id")
    protected long _$$giftId;

    @SerializedName("name")
    protected String _$$giftName;

    @SerializedName("gift_type")
    protected long _$$giftType;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("icon")
    protected py.k icon;

    public IGiftVoteResultFlexImpl() {
        super(a.class);
        this._$$text = "";
        this._$$giftName = "";
        this._$$countStr = "";
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final long getCount() {
        return this._$$count;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final String getCountStr() {
        return this._$$countStr;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final long getGiftType() {
        return this._$$giftType;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.live.profit.vote.a
    public final String getText() {
        return this._$$text;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IGiftVoteResultFlexImpl(am3.g r5) {
        super(a.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$countStr = am3.h.c(r5);
        goto L3
    L9:
        this._$$giftType = r5.j();
        goto L3
    L10:
        this._$$diamondCount = r5.j();
        goto L3
    L11:
        this._$$giftName = am3.h.c(r5);
        goto L3
    L12:
        this._$$giftId = r5.j();
        goto L3
    L13:
        this.icon = vh7.f.a(r5, py.k.class);
        goto L3
    L14:
        this._$$count = r5.j();
        goto L3
    L15:
        this._$$text = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L20;
        this._$$text = "";
    L20:
        if (this._$$giftName != null) goto L23;
        this._$$giftName = "";
    L23:
        if (this._$$countStr != null) goto L46;
        this._$$countStr = "";
        return;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }
}
