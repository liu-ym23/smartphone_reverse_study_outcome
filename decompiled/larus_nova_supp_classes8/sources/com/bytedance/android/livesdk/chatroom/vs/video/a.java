package com.bytedance.android.livesdk.chatroom.vs.video;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ FullHybridViewFragment a;

    public a(FullHybridViewFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        SubscriberJsEvent r2 = (SubscriberJsEvent) r1;
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }
}
