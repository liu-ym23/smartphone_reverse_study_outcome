package maa;

import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e$a {
    public static /* synthetic */ void b(e r1, int r2, Integer r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r1.nO(r2, null, r3);
    }

    public static /* synthetic */ void a(e r1, ExitClickSpeakerType r2, Map r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = ExitClickSpeakerType.MANUAL;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        r1.e70(r2, r3, r4);
    }
}
