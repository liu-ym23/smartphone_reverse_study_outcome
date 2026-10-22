package u52;

import com.bytedance.speech.speechengine.SpeechEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements SpeechEngine.SpeechListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void onSpeechMessage(int r1, byte[] r2, int r3) {
        this.a.g(r1, r2);
    }
}
