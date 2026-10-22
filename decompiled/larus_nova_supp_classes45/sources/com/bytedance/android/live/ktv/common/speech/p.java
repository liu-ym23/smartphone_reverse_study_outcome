package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ SpeechRecognizer a;
    public final /* synthetic */ Ref.IntRef b;

    public p(SpeechRecognizer r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        Ref.IntRef r7 = this.b;
        int r0 = r7.element;
        if (r0 > 0) goto L7;
        Disposable r8 = this.a.l;
        if (r8 == null) goto L9;
        r8.dispose();
        return;
    L9:
        return;
    L7:
        r7.element = r0 - 1;
        this.a.getClass();
        this.a.g(null, 0, 0);
    }
}
