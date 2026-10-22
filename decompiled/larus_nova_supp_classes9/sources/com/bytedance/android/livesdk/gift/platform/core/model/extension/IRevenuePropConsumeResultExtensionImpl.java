package com.bytedance.android.livesdk.gift.platform.core.model.extension;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import g12.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010O\u001a\u00020\u0002¢\u0006\u0004\bP\u0010QJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010/\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0017R\u001c\u00104\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u001c\u00109\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0017R\u0014\u0010:\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010\u0011R\u0014\u0010<\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010\u0011R\u001e\u0010?\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001e\u0010B\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001c\u0010E\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\bC\u0010\u0011\"\u0004\bD\u0010\u0017R\u0014\u0010G\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010\u0011R\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020H\u0018\u0001008\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u00103R\u0014\u0010L\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010\u0011R\u0014\u0010N\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010\u001b¨\u0006R"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/extension/IRevenuePropConsumeResultExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/gift/model/m2;", "Lg12/b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "gift", BuildConfig.FLAVOR, "getClientGiftSource", "()J", "clientGiftSource", "getComboCount", "comboCount", "getConsumeDiamonds", "setConsumeDiamonds", "(J)V", "consumeDiamonds", BuildConfig.FLAVOR, "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", "describe", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "displayText", "getFanTicketCount", "fanTicketCount", BuildConfig.FLAVOR, "getGiftCnt", "()I", "setGiftCnt", "(I)V", "giftCnt", "getGiftId", "setGiftId", "giftId", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/y1;", "getGifts", "()Ljava/util/List;", "gifts", "getGroupCount", "groupCount", "getGroupId", "setGroupId", "groupId", "isAwemeFreeGift", "getLeftDiamonds", "leftDiamonds", "getLogId", "setLogId", "logId", "getMsgId", "setMsgId", "msgId", "getPropId", "setPropId", "propId", "getPropType", "propType", "Lcom/bytedance/android/livesdk/gift/model/l2;", "getProps", "props", "getRepeatCount", "repeatCount", "getTraceId", "traceId", "base", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/m2;)V", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IRevenuePropConsumeResultExtensionImpl extends ModelExtensionBase<m2, b> implements b, m2 {
    private final /* synthetic */ m2 $$delegate_0;

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public <R extends e<m2>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public <R extends e<m2>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getComboCount() {
        return this.$$delegate_0.getComboCount();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getConsumeDiamonds() {
        return this.$$delegate_0.getConsumeDiamonds();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public String getDescribe() {
        return this.$$delegate_0.getDescribe();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public a5 getDisplayText() {
        return this.$$delegate_0.getDisplayText();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getFanTicketCount() {
        return this.$$delegate_0.getFanTicketCount();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public int getGiftCnt() {
        return this.$$delegate_0.getGiftCnt();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getGiftId() {
        return this.$$delegate_0.getGiftId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public List<y1> getGifts() {
        return this.$$delegate_0.getGifts();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getGroupCount() {
        return this.$$delegate_0.getGroupCount();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getGroupId() {
        return this.$$delegate_0.getGroupId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getLeftDiamonds() {
        return this.$$delegate_0.getLeftDiamonds();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public String getLogId() {
        return this.$$delegate_0.getLogId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public String getMsgId() {
        return this.$$delegate_0.getMsgId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getPropId() {
        return this.$$delegate_0.getPropId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getPropType() {
        return this.$$delegate_0.getPropType();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public List<l2> getProps() {
        return this.$$delegate_0.getProps();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long getRepeatCount() {
        return this.$$delegate_0.getRepeatCount();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public String getTraceId() {
        return this.$$delegate_0.getTraceId();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public long isAwemeFreeGift() {
        return this.$$delegate_0.isAwemeFreeGift();
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setConsumeDiamonds(long r2) {
        this.$$delegate_0.setConsumeDiamonds(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setDescribe(String r2) {
        this.$$delegate_0.setDescribe(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setDisplayText(a5 r2) {
        this.$$delegate_0.setDisplayText(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setGiftCnt(int r2) {
        this.$$delegate_0.setGiftCnt(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setGiftId(long r2) {
        this.$$delegate_0.setGiftId(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setGroupId(long r2) {
        this.$$delegate_0.setGroupId(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setLogId(String r2) {
        this.$$delegate_0.setLogId(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setMsgId(String r2) {
        this.$$delegate_0.setMsgId(r2);
    }

    @Override // g12.b, com.bytedance.android.livesdk.gift.model.m2
    public void setPropId(long r2) {
        this.$$delegate_0.setPropId(r2);
    }

    @Override // g12.b
    public long getClientGiftSource() {
        return ((Number) get(18, b.class, 0L)).longValue();
    }

    @Override // g12.b
    public h1 getGift() {
        return (h1) get(17, b.class);
    }

    public IRevenuePropConsumeResultExtensionImpl(m2 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
