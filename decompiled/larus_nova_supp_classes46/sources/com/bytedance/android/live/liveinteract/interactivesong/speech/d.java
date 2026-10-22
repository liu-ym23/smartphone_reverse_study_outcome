package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.live.datacontext.n;
import fd2.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        jd0.d r4 = (jd0.d) r3;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L7;
        v r2 = (v) r1.getValue();
    L9:
        if (r4.a.getValue() > 0) goto L11;
        return;
    L11:
        if (this.a.f("") == false) goto L13;
    L17:
        ALogger.i("SpeechRecognitionProxy", "start ktv component, stop recognize");
        if (r2 == null) goto L24;
        r2.i();
        return;
    L24:
        return;
    L13:
        if (this.a.b.b() == true) goto L17;
        if (r2 != null) goto L16;
        return;
    L16:
        if (r2.c() == true) goto L17;
        return;
    L7:
        r2 = null;
        goto L9
    }
}
