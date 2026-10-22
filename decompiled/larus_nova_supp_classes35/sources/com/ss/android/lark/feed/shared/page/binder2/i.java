package com.ss.android.lark.feed.shared.page.binder2;

import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ FeedCommonViewHolder a;

    public i(FeedCommonViewHolder r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Intrinsics.checkNotNullParameter((FeedSlideActionSetting) r2, "it");
        FeedCommonViewHolder r3 = this.a;
        r3.w = false;
        r3.x = true;
    }
}
