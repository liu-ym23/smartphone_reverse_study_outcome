package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.live.datacontext.n;
import fd2.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        if (r4.intValue() > 0) goto L5;
        return;
    L5:
        if (r4.intValue() >= 4) goto L23;
        ALogger.i("SpeechRecognitionProxy", "start team fight, stop recognize");
        InteractiveSongContext r5 = InteractiveSongContext.Companion.getContext();
        if (r5 == null) goto L11;
        n<v> r6 = r5.getLyricsRecognizer();
        if (r6 == null) goto L11;
        v r7 = (v) r6.getValue();
    L13:
        if (this.a.f("") == false) goto L15;
    L19:
        if (r7 == null) goto L26;
        r7.i();
        return;
    L26:
        return;
    L15:
        if (this.a.b.b() == true) goto L19;
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.c() == true) goto L19;
        return;
    L11:
        r7 = null;
        goto L13
    }
}
