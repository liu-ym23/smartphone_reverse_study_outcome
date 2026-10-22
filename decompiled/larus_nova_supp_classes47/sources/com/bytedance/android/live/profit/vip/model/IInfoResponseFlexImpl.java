package com.bytedance.android.live.profit.vip.model;

import com.bytedance.android.live.profit.vip.ISubscribeUserDataFlexImpl;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.subscribe.SubscribeInfoResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u00100R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u0019R\u001b\u0010$\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010(R\u001d\u0010.\u001a\u0004\u0018\u00010*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/IInfoResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/model/g;", "", "Lcom/bytedance/android/live/profit/vip/model/a;", "emojiList", "Ljava/util/List;", "getEmojiList", "()Ljava/util/List;", "setEmojiList", "(Ljava/util/List;)V", "", "emojiStatus$delegate", "Ljava/lang/Object;", "getEmojiStatus", "()J", "emojiStatus", "Lcom/bytedance/android/live/profit/vip/model/IEmojiTabInfoFlexImpl;", "emojiTabInfo$delegate", "getEmojiTabInfo", "()Lcom/bytedance/android/live/profit/vip/model/IEmojiTabInfoFlexImpl;", "emojiTabInfo", "", "isMember$delegate", "isMember", "()Z", "entrance$delegate", "getEntrance", "entrance", "entranceTab$delegate", "getEntranceTab", "entranceTab", "", "memberType$delegate", "getMemberType", "()I", "memberType", "Lcom/bytedance/android/live/profit/vip/ISubscribeUserDataFlexImpl;", "userData$delegate", "getUserData", "()Lcom/bytedance/android/live/profit/vip/ISubscribeUserDataFlexImpl;", "userData", "Lcom/bytedance/android/live/profit/vip/model/ISubscribeAnchorDataFlexImpl;", "anchorData$delegate", "getAnchorData", "()Lcom/bytedance/android/live/profit/vip/model/ISubscribeAnchorDataFlexImpl;", "anchorData", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IInfoResponseFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("anchor_data")
    protected ISubscribeAnchorDataFlexImpl _$$anchorData;

    @SerializedName("emoji_status")
    protected long _$$emojiStatus;

    @SerializedName("emoji_tab_info")
    protected IEmojiTabInfoFlexImpl _$$emojiTabInfo;

    @SerializedName("entrance")
    protected boolean _$$entrance;

    @SerializedName("entrance_tab")
    protected boolean _$$entranceTab;

    @SerializedName("is_member")
    protected boolean _$$isMember;

    @SerializedName("member_type")
    protected int _$$memberType;

    @SerializedName("user_data")
    protected ISubscribeUserDataFlexImpl _$$userData;

    @SerializedName("emoji_list")
    protected List<? extends a> emojiList;

    public IInfoResponseFlexImpl() {
        super(g.class);
        this._$$isMember = false;
        this._$$entrance = false;
        this._$$entranceTab = false;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public /* bridge */ /* synthetic */ h getAnchorData() {
        return getAnchorData();
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public /* bridge */ /* synthetic */ d getEmojiTabInfo() {
        return getEmojiTabInfo();
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public /* bridge */ /* synthetic */ com.bytedance.android.live.profit.vip.d getUserData() {
        return getUserData();
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public List<a> getEmojiList() {
        return this.emojiList;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final long getEmojiStatus() {
        return this._$$emojiStatus;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final boolean getEntrance() {
        return this._$$entrance;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final boolean getEntranceTab() {
        return this._$$entranceTab;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final int getMemberType() {
        return this._$$memberType;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final boolean isMember() {
        return this._$$isMember;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final ISubscribeAnchorDataFlexImpl getAnchorData() {
        return this._$$anchorData;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final IEmojiTabInfoFlexImpl getEmojiTabInfo() {
        return this._$$emojiTabInfo;
    }

    @Override // com.bytedance.android.live.profit.vip.model.g
    public final ISubscribeUserDataFlexImpl getUserData() {
        return this._$$userData;
    }

    public IInfoResponseFlexImpl(am3.g r7) {
        super(g.class);
        this.emojiList = new ArrayList();
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L17;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L16;
            case 2: goto L7;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this._$$anchorData = new ISubscribeAnchorDataFlexImpl(r7);
        goto L3
    L9:
        this._$$userData = new ISubscribeUserDataFlexImpl(r7);
        goto L3
    L10:
        this._$$emojiTabInfo = new IEmojiTabInfoFlexImpl(r7);
        goto L3
    L11:
        this._$$memberType = r7.i();
        r3 = r3 | 16;
        goto L3
    L12:
        this._$$entranceTab = am3.h.a(r7);
        r3 = r3 | 8;
        goto L3
    L13:
        this._$$entrance = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L14:
        this._$$isMember = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L15:
        this.emojiList.add(vh7.f.a(r7, a.class));
        goto L3
    L16:
        this._$$emojiStatus = r7.j();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L17:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L21;
        this._$$isMember = false;
    L21:
        if ((r3 & 4) != 0) goto L24;
        this._$$entrance = false;
    L24:
        if ((r3 & 8) != 0) goto L49;
        this._$$entranceTab = false;
        return;
    }

    public void setEmojiList(List<? extends a> r1) {
        this.emojiList = r1;
    }
}
