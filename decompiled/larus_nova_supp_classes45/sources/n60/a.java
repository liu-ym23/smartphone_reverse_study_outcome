package n60;

import android.content.Context;
import android.media.AudioRecord;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements d {
    public static final TokenCert a = null;

    public a() {
    }

    static {
        a = TokenCert.with("bpea-live_audiorecordchecker_check_audio_record");
    }

    public static boolean b(TokenCert r11) {
        int r2 = AudioRecord.getMinBufferSize(44100, 3, 2);     // Catch: Exception -> L17
        AudioRecord r3 = new AudioRecord(1, 44100, 3, 2, r2);     // Catch: Exception -> L17
        g80.a.d(r3, r11);     // Catch: Exception -> L15
        if (r2 <= 0) goto L11;
        int r4 = r3.read(new byte[r2], 0, r2);
        g80.a.c(r3, r11);     // Catch: Exception -> L9
    L12:
        if (r4 <= 0) goto L34;
        return true;
    L34:
        return false;
    L9:
        e = move-exception;
        ALogger.e("AudioRecorderChecker", e);
        goto L12
    L11:
        r4 = 0;
    L15:
        e = e;
    L19:
        ALogger.e("AudioRecorderChecker", e);
        if (r3 != null) goto L26;
    L25:
        return false;
    L26:
        g80.a.c(r3, r11);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        ALogger.e("AudioRecorderChecker", e);
    L17:
        e = e;
        r3 = null;
        goto L19
    }

    @Override // n60.d
    public final boolean a(Context r1, String r2) {
        return b(a);
    }
}
