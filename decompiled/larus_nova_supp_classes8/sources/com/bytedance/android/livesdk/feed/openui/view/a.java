package com.bytedance.android.livesdk.feed.openui.view;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ DouyinSmallLiveCardView a;

    public a(DouyinSmallLiveCardView r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        yv1.b r7 = (yv1.b) r6;
        long r0 = r7.b;
        Room r2 = this.a.c;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L6:
        if (r0 != r2.id) goto L12;
        DouyinSmallLiveCardView r1 = this.a;
        if (r7.a == false) goto L10;
        r1.a(2131378272).setVisibility(8);
        return;
    L10:
        r1.a(2131378272).setVisibility(0);
        return;
    }
}
