package com.bytedance.android.live.liveinteract.interactivesong.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.live.datacontext.n;
import fd2.v;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ boolean a;

    public e(boolean r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        i r5 = (i) r4;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L7;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L7;
        v r2 = (v) r1.getValue();
    L8:
        int r3 = r5.b;
        if (r3 != 27) goto L11;
        return;
    L11:
        if (r3 != 30) goto L13;
        return;
    L13:
        if (r3 == 26) goto L15;
    L16:
        ALogger.i("SpeechRecognitionProxy", "uiLayout Changed, uiLayout: " + r5.b + ", stop recognize");
        if (r2 == null) goto L23;
        r2.i();
        return;
    L23:
        return;
    L15:
        if (this.a == false) goto L16;
        return;
    L7:
        r2 = null;
        goto L8
    }
}
