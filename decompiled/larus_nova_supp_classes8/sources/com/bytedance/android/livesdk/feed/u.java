package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerBannerViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u implements b90.a {
    public final /* synthetic */ l a;

    public u() {
        this.a = o.a;
    }

    public final BaseViewHolder<Object> a(ViewGroup r13, Object[] r14) {
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "payloads");
        View r4 = LayoutInflater.from(r13.getContext()).inflate(2131566007, r13, false);
        if (r14.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L14;
        Object r1 = r14[0];
        if ((r1 instanceof mv1.l) == false) goto L14;
        if (r1 == null) goto L13;
        mv1.l r2 = (mv1.l) r1;
        FeedDataKey r3 = r2.a();
        BannerSwipeRefreshLayout.a r5 = r2.b();
        FeedDataKey r6 = r3;
    L16:
        if (r14.length <= 2) goto L23;
        Object r7 = r14[2];
        if ((r7 instanceof PublishSubject) == false) goto L23;
        if (r7 == null) goto L22;
        PublishSubject r8 = (PublishSubject) r7;
    L25:
        if (r14.length <= 3) goto L32;
        Object r9 = r14[3];
        if ((r9 instanceof PublishSubject) == false) goto L32;
        if (r9 == null) goto L31;
        PublishSubject r10 = (PublishSubject) r9;
    L34:
        if (r14.length <= 4) goto L41;
        Object r15 = r14[4];
        if ((r15 instanceof PublishSubject) == false) goto L41;
        if (r15 == null) goto L40;
        PublishSubject r11 = (PublishSubject) r15;
    L43:
        return new DrawerBannerViewHolder(r4, r5, r6, r8, r10, r11, this.a, r13);
    L40:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L41:
        r11 = null;
        goto L43
    L31:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L32:
        r10 = null;
        goto L34
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L23:
        r8 = null;
        goto L25
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r5 = null;
        r6 = null;
        goto L16
    L5:
        r0 = false;
        goto L7
    }
}
