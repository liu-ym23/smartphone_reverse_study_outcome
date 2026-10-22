package w2a;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final String a(List<MixVoice> r2) {
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L19;
        MixVoice r0 = (MixVoice) r3.next();
        UgcVoiceLoader r1 = UgcVoiceLoader.a;
        SpeakerVoice r4 = r0.getVoiceItem();
        if (r4 == null) goto L9;
        String r5 = r4.getId();
    L11:
        if (UgcVoiceLoader.h(r5) == false) goto L5;
        return "1";
    L9:
        r5 = null;
        goto L11
    L19:
        return "0";
    L14:
        return "0";
    }

    public static final String b(List<MixVoice> r2) {
        if (r2 == null) goto L10;
        Iterator<T> r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L15;
        if (((MixVoice) r3.next()).getPercentage() == 100) goto L5;
        return "1";
    L15:
        return "0";
    L10:
        return "0";
    }
}
