package com.bytedance.android.live.profit.format.voicechat.view;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ VoiceChatAvatarView a;
    public final /* synthetic */ Function0 b;

    public i(VoiceChatAvatarView r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Float r4 = (Float) r3;
        CircleProgressView r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.setProgress(r4.floatValue());
    L6:
        if (Intrinsics.areEqual(r4, 0.0f) == false) goto L11;
        this.b.invoke();
        Disposable r5 = this.a.e;
        if (r5 == null) goto L12;
        r5.dispose();
        return;
    L12:
        return;
    }
}
