package com.bytedance.android.livesdk.interactivity.pin.container.v1;

import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import o32.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&R-\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR-\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\u0018R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001e\u0010\u0018R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\b\u001a\u0004\b \u0010\u0018R\u0014\u0010$\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/container/v1/HighlightDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lo32/b;", "Lcom/bytedance/live/datacontext/n;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "reviewingPinAndQAHighlightItems$delegate", "Lcom/bytedance/live/datacontext/p;", "getReviewingPinAndQAHighlightItems", "()Lcom/bytedance/live/datacontext/n;", "reviewingPinAndQAHighlightItems", "displayingPinAndQAHighLightItems$delegate", "getDisplayingPinAndQAHighLightItems", "displayingPinAndQAHighLightItems", "Lcom/bytedance/live/datacontext/k;", "itemDisplayEndEvent$delegate", "getItemDisplayEndEvent", "()Lcom/bytedance/live/datacontext/k;", "itemDisplayEndEvent", "Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "isPinContainerShown$delegate", "isPinContainerShown", "()Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "pinContainerBottom$delegate", "getPinContainerBottom", "pinContainerBottom", "isAnnouncementShown$delegate", "isAnnouncementShown", "announcementBottom$delegate", "getAnnouncementBottom", "announcementBottom", "getCleared", "()Z", "cleared", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightDataContext extends DataContext implements b {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p announcementBottom$delegate;
    private final p displayingPinAndQAHighLightItems$delegate;
    private final p isAnnouncementShown$delegate;
    private final p isPinContainerShown$delegate;
    private final p itemDisplayEndEvent$delegate;
    private final p pinContainerBottom$delegate;
    private final p reviewingPinAndQAHighlightItems$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "reviewingPinAndQAHighlightItems", "getReviewingPinAndQAHighlightItems()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "displayingPinAndQAHighLightItems", "getDisplayingPinAndQAHighLightItems()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "itemDisplayEndEvent", "getItemDisplayEndEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "isPinContainerShown", "isPinContainerShown()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "pinContainerBottom", "getPinContainerBottom()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "isAnnouncementShown", "isAnnouncementShown()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(HighlightDataContext.class, "announcementBottom", "getAnnouncementBottom()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    @Override // o32.b
    public m<Integer> getAnnouncementBottom() {
        return (m) this.announcementBottom$delegate.a(this, $$delegatedProperties[6]);
    }

    public n<Map<String, HighlightItem>> getDisplayingPinAndQAHighLightItems() {
        return (n) this.displayingPinAndQAHighLightItems$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // o32.b
    public k<HighlightItem> getItemDisplayEndEvent() {
        return (k) this.itemDisplayEndEvent$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // o32.b
    public m<Integer> getPinContainerBottom() {
        return (m) this.pinContainerBottom$delegate.a(this, $$delegatedProperties[4]);
    }

    @Override // o32.b
    public n<Map<String, HighlightItem>> getReviewingPinAndQAHighlightItems() {
        return (n) this.reviewingPinAndQAHighlightItems$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // o32.b
    public m<Boolean> isAnnouncementShown() {
        return (m) this.isAnnouncementShown$delegate.a(this, $$delegatedProperties[5]);
    }

    @Override // o32.b
    public m<Boolean> isPinContainerShown() {
        return (m) this.isPinContainerShown$delegate.a(this, $$delegatedProperties[3]);
    }

    public HighlightDataContext() {
        this.reviewingPinAndQAHighlightItems$delegate = q.c(this);
        this.displayingPinAndQAHighLightItems$delegate = q.c(this);
        this.itemDisplayEndEvent$delegate = e.b(this);
        Boolean r0 = Boolean.FALSE;
        this.isPinContainerShown$delegate = q.d(this, r0);
        this.pinContainerBottom$delegate = q.d(this, 0);
        this.isAnnouncementShown$delegate = q.d(this, r0);
        this.announcementBottom$delegate = q.d(this, Integer.valueOf(y.e));
    }

    @Override // o32.b
    public boolean getCleared() {
        return isCleared();
    }
}
