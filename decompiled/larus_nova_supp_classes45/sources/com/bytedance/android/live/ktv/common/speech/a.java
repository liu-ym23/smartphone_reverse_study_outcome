package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LinkSpeechRecognizer a;

    public a(LinkSpeechRecognizer r1) {
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
