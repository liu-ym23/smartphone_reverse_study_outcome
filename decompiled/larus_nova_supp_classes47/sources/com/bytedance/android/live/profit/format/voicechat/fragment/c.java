package com.bytedance.android.live.profit.format.voicechat.fragment;

import io.reactivex.functions.Consumer;
import nu0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ FormatVoiceChatFragment.f a;

    public c(FormatVoiceChatFragment.f r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        FormatVoiceChatFragment r0 = this.a.a;
        j.c(r0, "on load avatar failed", (Throwable) r4, 4);
    }
}
