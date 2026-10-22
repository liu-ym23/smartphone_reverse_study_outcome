package com.larus.voice_setting.voice.editvoice;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p0 implements Runnable {
    public final /* synthetic */ SpeakerVoiceEditModel a;
    public final /* synthetic */ float b;

    public /* synthetic */ p0(SpeakerVoiceEditModel r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpeakerVoiceEditModel r0 = this.a;
        float r1 = this.b;
        MutableLiveData<b1> r2 = r0.B;
        b1 r3 = (b1) r2.getValue();
        if (r3 == null) goto L5;
        b1 r4 = b1.a(r3, r1, 0.0f, 2);
    L6:
        r2.setValue(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
