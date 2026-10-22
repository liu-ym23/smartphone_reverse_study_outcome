package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ LinkSpeechServerRecognizer a;
    public final /* synthetic */ Ref.IntRef b;

    public j(LinkSpeechServerRecognizer r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        Ref.IntRef r7 = this.b;
        int r0 = r7.element;
        if (r0 > 0) goto L7;
        Disposable r8 = this.a.m;
        if (r8 == null) goto L11;
        r8.dispose();
        return;
    L11:
        return;
    L7:
        r7.element = r0 - 1;
        LinkSpeechServerRecognizer r9 = this.a;
        if (r9.w == true) goto L13;
        r9.s(null, 0, 0);
        return;
    }
}
