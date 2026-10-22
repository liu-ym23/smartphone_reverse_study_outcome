package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ FrequentChatPresenter a;

    public h(FrequentChatPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        int r0 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a((Throwable) r3, "remove", s1.B(2131897046));
        this.a.k = false;
    }
}
