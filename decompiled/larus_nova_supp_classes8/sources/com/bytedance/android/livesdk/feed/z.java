package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.live.HotsoonLiveAdViewHolder;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z implements b90.a {
    public final /* synthetic */ f a;
    public final /* synthetic */ j b;
    public final /* synthetic */ ILiveRoomListDataSource c;

    public z(tv1.c r1, f r2, NewTabRepository r3, LiveRoomListDataSource r4) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final BaseViewHolder<Object> a(ViewGroup r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "payloads");
        View r4 = LayoutInflater.from(r11.getContext()).inflate(2131566257, r11, false);
        if (r12.length != 0) goto L5;
        boolean r13 = true;
    L7:
        if ((!r13) == false) goto L14;
        Object r14 = r12[0];
        if ((r14 instanceof mv1.l) == false) goto L14;
        if (r14 == null) goto L13;
        FeedDataKey r6 = ((mv1.l) r14).a();
    L16:
        if (r12.length <= 1) goto L24;
        Object r15 = r12[1];
        if ((r15 instanceof PublishSubject) == false) goto L24;
        if (r15 == null) goto L22;
        PublishSubject r16 = (PublishSubject) r15;
        goto L24
    L22:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<com.bytedance.android.live.base.model.feed.FeedItem?>");
    L24:
        if (r12.length <= 2) goto L31;
        Object r17 = r12[2];
        if ((r17 instanceof PublishSubject) == false) goto L31;
        if (r17 == null) goto L30;
        PublishSubject r8 = (PublishSubject) r17;
    L33:
        if (r12.length <= 3) goto L40;
        Object r18 = r12[3];
        if ((r18 instanceof PublishSubject) == false) goto L40;
        if (r18 == null) goto L39;
        PublishSubject r9 = (PublishSubject) r18;
    L42:
        if (r12.length <= 4) goto L50;
        Object r19 = r12[4];
        if ((r19 instanceof PublishSubject) == false) goto L50;
        if (r19 == null) goto L48;
        PublishSubject r110 = (PublishSubject) r19;
        goto L50
    L48:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L50:
        return new HotsoonLiveAdViewHolder(r4, this.a, r6, this.b, r8, r9);
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L40:
        r9 = null;
        goto L42
    L30:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L31:
        r8 = null;
        goto L33
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        r6 = null;
        goto L16
    L5:
        r13 = false;
        goto L7
    }
}
