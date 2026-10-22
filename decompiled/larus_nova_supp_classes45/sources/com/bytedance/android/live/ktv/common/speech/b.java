package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LinkSpeechRecognizer a;
    public final /* synthetic */ kd2.a b;

    public b(LinkSpeechRecognizer r1, kd2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        LinkSpeechRecognizer r11 = this.a;
        kd2.a r0 = this.b;
        r11.getClass();
        ALogger.i("LinkSpeechRecognizer", "doCheckTask，isSpeechRecognizing: " + r11.t + ", similarity: null");
        if (r11.t == true) goto L5;
        return;
    L5:
        if (r11.d != null) goto L7;
        return;
    L7:
        if (r11.c != null) goto L9;
        return;
    L9:
        if (KtvSettingHelper.A().k() == false) goto L15;
        r11.j(r11.d, r11.c, new kd2.a(null, true, r0.d, r0.e));
        return;
    }
}
