package com.bytedance.android.livesdk.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerFollowViewHolder;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements b90.a {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final BaseViewHolder<Object> a(ViewGroup r4, Object[] r5) {
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131565967, r4, false);
        if (r5.length <= 4) goto L11;
        Object r7 = r5[4];
        if ((r7 instanceof PublishSubject) == false) goto L11;
        if (r7 == null) goto L9;
        PublishSubject r8 = (PublishSubject) r7;
        goto L11
    L9:
        throw new NullPointerException("null cannot be cast to non-null type io.reactivex.subjects.PublishSubject<kotlin.Boolean?>");
    L11:
        return new DrawerFollowViewHolder(r6);
    }
}
