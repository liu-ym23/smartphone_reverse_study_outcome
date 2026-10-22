package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.live.LiveNoticeViewHolder;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements b90.a {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r6, Object[] r7) {
        View r8 = LayoutInflater.from(r6.getContext()).inflate(2131565979, r6, false);
        if (r7.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L14;
        Object r1 = r7[0];
        if ((r1 instanceof mv1.l) == false) goto L14;
        if (r1 == null) goto L13;
        mv1.l r2 = (mv1.l) r1;
        r2.a();
        r2.b();
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.feed.adapter.IPayloadProvider");
    L14:
        PublishSubject r3 = null;
        if (r7.length <= 2) goto L22;
        Object r4 = r7[2];
        if ((r4 instanceof PublishSubject) == false) goto L22;
        if (r4 == null) goto L21;
        PublishSubject r5 = (PublishSubject) r4;
    L24:
        if (r7.length <= 3) goto L31;
        Object r9 = r7[3];
        if ((r9 instanceof PublishSubject) == false) goto L31;
        if (r9 == null) goto L30;
        PublishSubject r10 = (PublishSubject) r9;
    L33:
        if (r7.length <= 4) goto L41;
        Object r11 = r7[4];
        if ((r11 instanceof PublishSubject) == false) goto L41;
        if (r11 == null) goto L39;
        r3 = (PublishSubject) r11;
        goto L41
    L39:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L41:
        return new LiveNoticeViewHolder(r8, r5, r10, r3);
    L30:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L31:
        r10 = null;
        goto L33
    L21:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Any?>");
    L22:
        r5 = null;
        goto L24
    L5:
        r0 = false;
        goto L7
    }
}
