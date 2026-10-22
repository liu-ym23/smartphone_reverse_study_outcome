package com.bytedance.android.live.ktv.common.speech;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ LinkSpeechServerRecognizer a;
    public final /* synthetic */ kd2.a b;

    public h(LinkSpeechServerRecognizer r1, kd2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        Long r9 = (Long) r8;
        LinkSpeechServerRecognizer r11 = this.a;
        kd2.a r0 = this.b;
        r11.getClass();
        StringBuilder r1 = new StringBuilder("doCheckTask，isSpeechRecognizing: ");
        r1.append(r11.v);
        r1.append(", similarity: ");
        k r2 = r11.o;
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.f);
    L6:
        r1.append(r3);
        ALogger.i("LinkSpeechServerRecognizer", r1.toString());
        if (r11.v == true) goto L9;
        return;
    L9:
        if (r11.d != null) goto L11;
        return;
    L11:
        if (r11.c != null) goto L13;
        return;
    L13:
        if (KtvSettingHelper.A().k() == false) goto L23;
        k r4 = r11.o;
        if (r4 != null) goto L17;
    L18:
        r11.j(r11.d, r11.c, new kd2.a(null, true, r0.d, r0.e));
        return;
    L17:
        if (r4.f < KtvSettingHelper.A().n()) goto L18;
        return;
    L23:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
