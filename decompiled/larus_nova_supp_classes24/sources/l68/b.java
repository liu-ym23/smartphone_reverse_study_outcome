package l68;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r8, TtsEventEnum r9, String r10, int r11, String r12, Map r13, int r14) {
            if ((r14 & 2) == 0) goto L5;
            String r4 = "";
        L7:
            if ((r14 & 4) == 0) goto L9;
            int r5 = -1;
        L11:
            if ((r14 & 8) == 0) goto L13;
            String r6 = "";
        L15:
            if ((r14 & 16) == 0) goto L17;
            r13 = MapsKt.emptyMap();
        L17:
            r8.c(r9, r4, r5, r6, r13);
            return;
        L13:
            r6 = r12;
            goto L15
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }
    }

    void a(TtsTracer r1);

    void b(byte[] r1, boolean r2);

    void c(TtsEventEnum r1, String r2, int r3, String r4, Map<String, ? extends Object> r5);

    void d(TtsState r1);

    void e(TtsLifeState r1, String r2, Map<String, String> r3);
}
