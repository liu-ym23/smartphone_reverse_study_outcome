package com.bytedance.android.live.profit.privilege;

import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/PrivilegeContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/profit/privilege/model/danmu/DanmakuTabList;", "danmakuTabList$delegate", "Lcom/bytedance/live/datacontext/p;", "getDanmakuTabList", "()Lcom/bytedance/live/datacontext/m;", "danmakuTabList", "", "isInDanmakuMode$delegate", "isInDanmakuMode", "", "bubbleRefId$delegate", "getBubbleRefId", "bubbleRefId", "Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionData;", "touchPositionData$delegate", "getTouchPositionData", "touchPositionData", "Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", "payGrade$delegate", "getPayGrade", "payGrade", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchData;", "giftPanelTouchData$delegate", "getGiftPanelTouchData", "giftPanelTouchData", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p bubbleRefId$delegate;
    private final p danmakuTabList$delegate;
    private final p giftPanelTouchData$delegate;
    private final p isInDanmakuMode$delegate;
    private final p payGrade$delegate;
    private final p touchPositionData$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "danmakuTabList", "getDanmakuTabList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "isInDanmakuMode", "isInDanmakuMode()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "bubbleRefId", "getBubbleRefId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "touchPositionData", "getTouchPositionData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "payGrade", "getPayGrade()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PrivilegeContext.class, "giftPanelTouchData", "getGiftPanelTouchData()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Long> getBubbleRefId() {
        return (m) this.bubbleRefId$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<DanmakuTabList> getDanmakuTabList() {
        return (m) this.danmakuTabList$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<GiftPanelTouchData> getGiftPanelTouchData() {
        return (m) this.giftPanelTouchData$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<PayGrade> getPayGrade() {
        return (m) this.payGrade$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<TouchPositionData> getTouchPositionData() {
        return (m) this.touchPositionData$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> isInDanmakuMode() {
        return (m) this.isInDanmakuMode$delegate.a(this, $$delegatedProperties[1]);
    }

    public PrivilegeContext() {
        this.danmakuTabList$delegate = q.d(this, new DanmakuTabList(null, false, false, 0, 0, null, 63, null));
        this.isInDanmakuMode$delegate = q.d(this, Boolean.FALSE);
        this.bubbleRefId$delegate = q.d(this, 0L);
        this.touchPositionData$delegate = q.d(this, new TouchPositionData(null, false, null, 7, null));
        this.payGrade$delegate = q.d(this, new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null));
        this.giftPanelTouchData$delegate = q.d(this, new GiftPanelTouchData(null, 1, null));
    }
}
