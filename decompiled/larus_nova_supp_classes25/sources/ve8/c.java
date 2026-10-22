package ve8;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final String b(boolean r0) {
        if (r0 == false) goto L4;
        return "1";
    L4:
        return "0";
    }

    public static final boolean a(wc9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Integer r0 = r2.j;
        if (r0 != null) goto L6;
    L7:
        Integer r3 = r2.j;
        if (r3 != null) goto L11;
    L13:
        return false;
    L11:
        if (r3.intValue() != 2) goto L13;
        return true;
    L6:
        if (r0.intValue() != 1) goto L7;
        return true;
    }

    public static final boolean c(BotModel r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getMuted() == true) goto L15;
        SpeakerVoice r3 = r2.getVoiceType();
        if (r3 == null) goto L10;
        String r4 = r3.getId();
    L12:
        if (Intrinsics.areEqual(r4, "0") == true) goto L16;
        return true;
    L16:
        return false;
    L10:
        r4 = null;
        goto L12
    L15:
        return false;
    }
}
