package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LinkSpeechServerRecognizer a;

    public e(LinkSpeechServerRecognizer r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = ((pv0.c) r2).a;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.a.onSei(r3);
    }
}
