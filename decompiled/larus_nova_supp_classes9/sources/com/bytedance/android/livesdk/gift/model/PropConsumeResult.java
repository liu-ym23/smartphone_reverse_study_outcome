package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.IgnoreStyleCheck;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bc\u0010dR.\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u00038W@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\"\u0010\u001f\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010\"\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R*\u0010%\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00128\u0016@WX\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\"\u0010(\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010,\u001a\u00020+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R$\u00105\u001a\u0004\u0018\u00010\u00038W@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0006\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\nR*\u00108\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00128V@VX\u0097\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\"\u0010;\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010=\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R*\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bJ\u0010C\u001a\u0004\bK\u0010ER\u001a\u0010L\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\bL\u0010\u0006\u001a\u0004\bM\u0010\bR\"\u0010N\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0014\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010\u0018R$\u0010Q\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010-\u001a\u0004\bX\u0010/\"\u0004\bY\u00101R\"\u0010Z\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0014\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R\"\u0010]\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010-\u001a\u0004\b^\u0010/\"\u0004\b_\u00101R$\u0010`\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0006\u001a\u0004\ba\u0010\b\"\u0004\bb\u0010\n¨\u0006e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PropConsumeResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/m2;", BuildConfig.FLAVOR, "<set-?>", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", BuildConfig.FLAVOR, "fanTicketCount", "J", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "leftDiamonds", "getLeftDiamonds", "setLeftDiamonds", "describe", "getDescribe", "setDescribe", "giftId", "getGiftId", "setGiftId", "groupCount", "getGroupCount", "setGroupCount", "groupId", "getGroupId", "setGroupId", "repeatCount", "getRepeatCount", "setRepeatCount", BuildConfig.FLAVOR, "giftCnt", "I", "getGiftCnt", "()I", "setGiftCnt", "(I)V", "comboCount", "getComboCount", "setComboCount", "msgId", "getMsgId", "setMsgId", "propId", "getPropId", "setPropId", "isAwemeFreeGift", "setAwemeFreeGift", "propType", "getPropType", "setPropType", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/l2;", "props", "Ljava/util/List;", "getProps", "()Ljava/util/List;", "setProps", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y1;", "gifts", "getGifts", "traceId", "getTraceId", "consumeDiamonds", "getConsumeDiamonds", "setConsumeDiamonds", "prop", "Lcom/bytedance/android/livesdk/gift/model/l2;", "getProp", "()Lcom/bytedance/android/livesdk/gift/model/l2;", "setProp", "(Lcom/bytedance/android/livesdk/gift/model/l2;)V", "sendType", "getSendType", "setSendType", "targetUserId", "getTargetUserId", "setTargetUserId", "reqIndex", "getReqIndex", "setReqIndex", "giftType", "getGiftType", "setGiftType", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PropConsumeResult extends FlexModelBase<m2> implements m2, vh7.h {

    @SerializedName("combo_count")
    protected long comboCount;
    private long consumeDiamonds;

    @SerializedName("describe")
    protected String describe;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("fan_ticket_count")
    protected long fanTicketCount;
    private int giftCnt;

    @SerializedName("gift_id")
    protected long giftId;

    @IgnoreStyleCheck
    private transient String giftType;

    @SerializedName("gifts")
    protected List<y1> gifts;

    @SerializedName("group_count")
    protected long groupCount;

    @IgnoreProtoFieldCheck
    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("is_aweme_free_gift")
    protected long isAwemeFreeGift;

    @SerializedName("left_diamond")
    protected long leftDiamonds;

    @IgnoreProtoFieldCheck
    private String logId;

    @SerializedName("msg_id")
    protected String msgId;

    @IgnoreStyleCheck
    private transient l2 prop;

    @SerializedName("prop_def_id")
    protected long propId;

    @SerializedName("prop_type")
    protected long propType;

    @SerializedName("props")
    protected List<l2> props;

    @SerializedName("repeat_count")
    protected long repeatCount;

    @IgnoreStyleCheck
    private transient int reqIndex;

    @IgnoreStyleCheck
    private transient int sendType;

    @IgnoreStyleCheck
    private transient long targetUserId;

    @IgnoreProtoFieldCheck
    private final String traceId;

    public PropConsumeResult() {
        super(m2.class);
        this.traceId = BuildConfig.FLAVOR;
        this.reqIndex = -1;
        this.propId = -1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getComboCount() {
        return this.comboCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getConsumeDiamonds() {
        return this.consumeDiamonds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public String getDescribe() {
        return this.describe;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public a5 getDisplayText() {
        return this.displayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getFanTicketCount() {
        return this.fanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public int getGiftCnt() {
        return this.giftCnt;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getGiftId() {
        return this.giftId;
    }

    public final String getGiftType() {
        return this.giftType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public List<y1> getGifts() {
        return this.gifts;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getGroupCount() {
        return this.groupCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getGroupId() {
        return this.groupId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getLeftDiamonds() {
        return this.leftDiamonds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public String getLogId() {
        return this.logId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public String getMsgId() {
        return this.msgId;
    }

    public final l2 getProp() {
        return this.prop;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getPropId() {
        return this.propId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getPropType() {
        return this.propType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public List<l2> getProps() {
        return this.props;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long getRepeatCount() {
        return this.repeatCount;
    }

    public final int getReqIndex() {
        return this.reqIndex;
    }

    public final int getSendType() {
        return this.sendType;
    }

    public final long getTargetUserId() {
        return this.targetUserId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public String getTraceId() {
        return this.traceId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public long isAwemeFreeGift() {
        return this.isAwemeFreeGift;
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public PropConsumeResult(am3.g r7) {
        super(m2.class);
        this.props = new ArrayList();
        this.gifts = new ArrayList();
        this.traceId = BuildConfig.FLAVOR;
        this.reqIndex = -1;
        boolean r1 = false;
        setThreadSafe(false);
        long r2 = r7.c();
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L24;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L7;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this.groupId = r7.j();
        goto L3
    L9:
        List r6 = this.gifts;
        Class r8 = y1.class;
    L13:
        r6.add(vh7.f.a(r7, r8));
        goto L3
    L10:
        this.displayText = vh7.f.a(r7, a5.class);
        goto L3
    L11:
        this.isAwemeFreeGift = r7.j();
        goto L3
    L12:
        r6 = this.props;
        r8 = l2.class;
        goto L13
    L14:
        this.propType = r7.j();
        goto L3
    L15:
        this.propId = r7.j();
        r1 = r1 | true;
        goto L3
    L16:
        this.comboCount = r7.j();
        goto L3
    L17:
        this.repeatCount = r7.j();
        goto L3
    L18:
        this.leftDiamonds = r7.j();
        goto L3
    L19:
        this.groupCount = r7.j();
        goto L3
    L20:
        this.giftId = r7.j();
        goto L3
    L21:
        this.describe = am3.h.c(r7);
        goto L3
    L22:
        this.fanTicketCount = r7.j();
        goto L3
    L23:
        this.msgId = am3.h.c(r7);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L24:
        r7.d(r2);
        setThreadSafe(true);
        if ((true & r1) == true) goto L61;
        this.propId = -1;
        return;
    }

    public void setAwemeFreeGift(long r1) {
        this.isAwemeFreeGift = r1;
    }

    public void setComboCount(long r1) {
        this.comboCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setConsumeDiamonds(long r1) {
        this.consumeDiamonds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setDescribe(String r1) {
        this.describe = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setDisplayText(a5 r1) {
        this.displayText = r1;
    }

    public void setFanTicketCount(long r1) {
        this.fanTicketCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setGiftCnt(int r1) {
        this.giftCnt = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setGiftId(long r1) {
        this.giftId = r1;
    }

    public final void setGiftType(String r1) {
        this.giftType = r1;
    }

    public void setGroupCount(long r1) {
        this.groupCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    @SerializedName("group_id")
    public void setGroupId(long r1) {
        this.groupId = r1;
    }

    public void setLeftDiamonds(long r1) {
        this.leftDiamonds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setLogId(String r1) {
        this.logId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setMsgId(String r1) {
        this.msgId = r1;
    }

    public final void setProp(l2 r1) {
        this.prop = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.m2
    public void setPropId(long r1) {
        this.propId = r1;
    }

    public void setPropType(long r1) {
        this.propType = r1;
    }

    public void setProps(List<l2> r1) {
        this.props = r1;
    }

    public void setRepeatCount(long r1) {
        this.repeatCount = r1;
    }

    public final void setReqIndex(int r1) {
        this.reqIndex = r1;
    }

    public final void setSendType(int r1) {
        this.sendType = r1;
    }

    public final void setTargetUserId(long r1) {
        this.targetUserId = r1;
    }
}
