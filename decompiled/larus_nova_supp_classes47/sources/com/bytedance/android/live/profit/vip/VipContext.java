package com.bytedance.android.live.profit.vip;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u000bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u000bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u000bR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profit/vip/VipContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/i;", "", "isAnchor$delegate", "Lcom/bytedance/live/datacontext/p;", "isAnchor", "()Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/live/datacontext/m;", "isEmojiPanelShow$delegate", "isEmojiPanelShow", "()Lcom/bytedance/live/datacontext/m;", "isFirstTimeOpenEmoji$delegate", "isFirstTimeOpenEmoji", "hasNewSubscribeEmoji$delegate", "getHasNewSubscribeEmoji", "hasNewSubscribeEmoji", "canShowVipSingleBadge$delegate", "getCanShowVipSingleBadge", "canShowVipSingleBadge", "Lcom/bytedance/android/live/profit/vip/h;", "subscribeInfo$delegate", "getSubscribeInfo", "subscribeInfo", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VipContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p canShowVipSingleBadge$delegate;
    private final com.bytedance.live.datacontext.p hasNewSubscribeEmoji$delegate;
    private final com.bytedance.live.datacontext.p isAnchor$delegate;
    private final com.bytedance.live.datacontext.p isEmojiPanelShow$delegate;
    private final com.bytedance.live.datacontext.p isFirstTimeOpenEmoji$delegate;
    private final com.bytedance.live.datacontext.p subscribeInfo$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(VipContext.class, "isAnchor", "isAnchor()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VipContext.class, "isEmojiPanelShow", "isEmojiPanelShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VipContext.class, "isFirstTimeOpenEmoji", "isFirstTimeOpenEmoji()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VipContext.class, "hasNewSubscribeEmoji", "getHasNewSubscribeEmoji()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VipContext.class, "canShowVipSingleBadge", "getCanShowVipSingleBadge()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(VipContext.class, "subscribeInfo", "getSubscribeInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final com.bytedance.live.datacontext.i<Boolean> getCanShowVipSingleBadge() {
        return (com.bytedance.live.datacontext.i) this.canShowVipSingleBadge$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getHasNewSubscribeEmoji() {
        return (com.bytedance.live.datacontext.m) this.hasNewSubscribeEmoji$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<h> getSubscribeInfo() {
        return (com.bytedance.live.datacontext.m) this.subscribeInfo$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.i<Boolean> isAnchor() {
        return (com.bytedance.live.datacontext.i) this.isAnchor$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isEmojiPanelShow() {
        return (com.bytedance.live.datacontext.m) this.isEmojiPanelShow$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isFirstTimeOpenEmoji() {
        return (com.bytedance.live.datacontext.m) this.isFirstTimeOpenEmoji$delegate.a(this, $$delegatedProperties[2]);
    }

    public VipContext() {
        Boolean r0 = Boolean.FALSE;
        this.isAnchor$delegate = ConstantKt.d(this, r0);
        this.isEmojiPanelShow$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.isFirstTimeOpenEmoji$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
        this.hasNewSubscribeEmoji$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.canShowVipSingleBadge$delegate = ConstantKt.d(this, r0);
        this.subscribeInfo$delegate = com.bytedance.live.datacontext.q.d(this, new h(2047));
    }
}
