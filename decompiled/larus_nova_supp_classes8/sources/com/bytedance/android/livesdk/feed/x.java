package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.NewDrawerSmallLiveViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements b90.a {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ tv1.c b;
    public final /* synthetic */ f c;
    public final /* synthetic */ j d;
    public final /* synthetic */ ILiveRoomListDataSource e;

    public x(e0 r1, tv1.c r2, f r3, NewTabRepository r4, LiveRoomListDataSource r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final BaseViewHolder<Object> a(ViewGroup r16, Object[] r17) {
        Intrinsics.checkNotNullParameter(r16, "parent");
        Intrinsics.checkNotNullParameter(r17, "payloads");
        View r2 = LayoutInflater.from(r16.getContext()).inflate(2131565985, r16, false);
        if (r17.length != 0) goto L5;
        boolean r3 = true;
    L7:
        if ((!r3) == false) goto L14;
        Object r4 = r17[0];
        if ((r4 instanceof mv1.l) == false) goto L14;
        if (r4 == null) goto L13;
        FeedDataKey r7 = ((mv1.l) r4).a();
    L16:
        if (r17.length <= 1) goto L23;
        Object r5 = r17[1];
        if ((r5 instanceof PublishSubject) == false) goto L23;
        if (r5 == null) goto L22;
        PublishSubject r8 = (PublishSubject) r5;
    L25:
        if (r17.length <= 2) goto L33;
        Object r6 = r17[2];
        if ((r6 instanceof PublishSubject) == false) goto L33;
        if (r6 == null) goto L31;
        PublishSubject r9 = (PublishSubject) r6;
        goto L33
    L31:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L33:
        if (r17.length <= 3) goto L41;
        Object r10 = r17[3];
        if ((r10 instanceof PublishSubject) == false) goto L41;
        if (r10 == null) goto L39;
        PublishSubject r11 = (PublishSubject) r10;
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L41:
        if (r17.length <= 4) goto L48;
        Object r1 = r17[4];
        if ((r1 instanceof PublishSubject) == false) goto L48;
        if (r1 == null) goto L47;
        PublishSubject r12 = (PublishSubject) r1;
    L49:
        Map<String, String> r13 = this.a.f.DN();
        tv1.c r14 = this.b;
        f r15 = this.c;
        j r18 = this.d;
        ILiveRoomListDataSource r19 = this.e;
        LiveDrawerFeedCategoryFragment r110 = this.a.e;
        return new NewDrawerSmallLiveViewHolder(r2, r14, r15, r7, r18, r19, r8, r12, r16, r13, r110, r110);
    L47:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L48:
        r12 = null;
        goto L49
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<com.bytedance.android.live.base.model.feed.FeedItem?>");
    L23:
        r8 = null;
        goto L25
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r7 = null;
        goto L16
    L5:
        r3 = false;
        goto L7
    }
}
