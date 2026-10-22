package com.bytedance.android.live.liveinteract.feedv2.feedview;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/liveinteract/api/fulllink/revenue/f;", "Lkotlin/collections/ArrayList;", "element", "", "add", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1 extends ArrayList<com.bytedance.android.live.liveinteract.api.fulllink.revenue.f> {
    final /* synthetic */ MultiLinkCommonVoiceFeedPreview this$0;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public MultiLinkCommonVoiceFeedPreview$nextDrawListeners$1(MultiLinkCommonVoiceFeedPreview r1) {
        this.this$0 = r1;
    }

    public boolean add(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (this.this$0.L1 == true) goto L7;
        return false;
    L7:
        return super.add(r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) == true) goto L7;
        return false;
    L7:
        return contains((com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) == true) goto L7;
        return -1;
    L7:
        return indexOf((com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) == true) goto L7;
        return false;
    L7:
        return remove((com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) r2);
    }

    public /* bridge */ com.bytedance.android.live.liveinteract.api.fulllink.revenue.f removeAt(int r1) {
        return remove(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return add((com.bytedance.android.live.liveinteract.api.fulllink.revenue.f) r1);
    }

    public /* bridge */ boolean contains(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r1) {
        return super.contains(r1);
    }

    public /* bridge */ int indexOf(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r1) {
        return super.indexOf(r1);
    }

    public /* bridge */ int lastIndexOf(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r1) {
        return super.lastIndexOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ com.bytedance.android.live.liveinteract.api.fulllink.revenue.f remove(int r1) {
        return removeAt(r1);
    }

    public /* bridge */ boolean remove(com.bytedance.android.live.liveinteract.api.fulllink.revenue.f r1) {
        return super.remove(r1);
    }
}
