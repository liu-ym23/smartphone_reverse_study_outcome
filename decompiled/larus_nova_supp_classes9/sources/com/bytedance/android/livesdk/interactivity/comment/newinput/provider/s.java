package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T, R> implements Function {
    public final /* synthetic */ Bitmap a;

    public s() {
        this.a = null;
    }

    public final Object apply(Object r2) {
        com.bytedance.android.live.base.model.data.activityemoji.b r3 = (com.bytedance.android.live.base.model.data.activityemoji.b) r2;
        Intrinsics.checkNotNullParameter(r3, "emoji");
        Bitmap r0 = this.a;
        if (r0 == null) goto L6;
        return Observable.just(r0);
    L6:
        return com.bytedance.android.livesdk.chatroom.utils.a1.k(r3.getEmoji()).compose(RxUtil.rxSchedulerHelper());
    }
}
