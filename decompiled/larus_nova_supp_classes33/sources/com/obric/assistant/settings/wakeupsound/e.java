package com.obric.assistant.settings.wakeupsound;

import com.obric.assistant.WakeupSoundEffectSettings;
import com.obric.assistant.t1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    @WakeupSoundEffectSettings
    public static final String a() {
        t1 r0 = t1.a;
        String r1 = r0.d0();
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        return b(r1);
    L7:
        return b(r0.x1().getDefaultSoundId());
    }

    @WakeupSoundEffectSettings
    public static final String b(String r3) {
        if (r3 == null) goto L19;
        int r1 = r3.hashCode();
        if (r1 != 109549001) goto L7;
        String r2 = "smart";
        if (r3.equals("smart") == true) goto L18;
        return "classic";
    L18:
        return r2;
    L7:
        if (r1 != 853620882) goto L9;
        r3.equals("classic");
        return "classic";
    L9:
        if (r1 != 2093206386) goto L22;
        r2 = "doubao_same_voice";
        if (r3.equals("doubao_same_voice") == true) goto L18;
        return "classic";
    L22:
        return "classic";
    L19:
        return "classic";
    }
}
