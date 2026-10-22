package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.LargeLiveViewHolder;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v implements b90.a {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ tv1.c b;
    public final /* synthetic */ f c;
    public final /* synthetic */ j d;
    public final /* synthetic */ ILiveRoomListDataSource e;

    public v(e0 r1, tv1.c r2, f r3, NewTabRepository r4, LiveRoomListDataSource r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final BaseViewHolder<Object> a(ViewGroup r14, Object[] r15) {
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r15, "payloads");
        View r4 = LayoutInflater.from(r14.getContext()).inflate(2131566258, r14, false);
        if (r15.length != 0) goto L5;
        boolean r16 = true;
    L7:
        if ((!r16) == false) goto L14;
        Object r17 = r15[0];
        if ((r17 instanceof mv1.l) == false) goto L14;
        if (r17 == null) goto L13;
        FeedDataKey r7 = ((mv1.l) r17).a();
    L16:
        if (r15.length <= 1) goto L23;
        Object r18 = r15[1];
        if ((r18 instanceof PublishSubject) == false) goto L23;
        if (r18 == null) goto L22;
        PublishSubject r10 = (PublishSubject) r18;
    L25:
        if (r15.length <= 2) goto L33;
        Object r19 = r15[2];
        if ((r19 instanceof PublishSubject) == false) goto L33;
        if (r19 == null) goto L31;
        PublishSubject r110 = (PublishSubject) r19;
        goto L33
    L31:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L33:
        if (r15.length <= 3) goto L41;
        Object r111 = r15[3];
        if ((r111 instanceof PublishSubject) == false) goto L41;
        if (r111 == null) goto L39;
        PublishSubject r112 = (PublishSubject) r111;
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L41:
        if (r15.length <= 4) goto L48;
        Object r113 = r15[4];
        if ((r113 instanceof PublishSubject) == false) goto L48;
        if (r113 == null) goto L47;
        PublishSubject r11 = (PublishSubject) r113;
    L50:
        return new LargeLiveViewHolder(r4, this.b, this.c, r7, this.d, this.e, r10, r11, this.a.e);
    L47:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L48:
        r11 = null;
        goto L50
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<com.bytedance.android.live.base.model.feed.FeedItem?>");
    L23:
        r10 = null;
        goto L25
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r7 = null;
        goto L16
    L5:
        r16 = false;
        goto L7
    }
}
