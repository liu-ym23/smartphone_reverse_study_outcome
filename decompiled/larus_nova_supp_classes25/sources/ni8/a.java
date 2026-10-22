package ni8;

import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final int b(BotModel r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = r1.getBotStatus();
        if (r2 != null) goto L7;
        return 10;
    L7:
        return r2.intValue();
    }

    public static final GetMatchVoiceRequest a(BotModel r11, RecommendScene r12) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        if (r11 == null) goto L8;
        String r1 = r11.getName();
        if (r1 == null) goto L8;
        String r2 = r1;
    L9:
        if (r11 == null) goto L14;
        String r3 = r11.getDescriptionForHuman();
        if (r3 == null) goto L14;
        String r4 = r3;
    L15:
        if (r11 == null) goto L22;
        SpeakerVoice r5 = r11.getVoiceType();
        if (r5 == null) goto L22;
        String r6 = r5.getId();
        if (r6 == null) goto L22;
        String r7 = r6;
    L23:
        if (r11 == null) goto L28;
        String r8 = r11.getBotId();
        if (r8 == null) goto L28;
        String r9 = r8;
    L29:
        if (r11 == null) goto L33;
        ModelItem r10 = r11.getModel();
        if (r10 == null) goto L33;
        long r13 = r10.getModelType();
    L34:
        if (r11 == null) goto L41;
        SpeakerVoice r14 = r11.getVoiceType();
        if (r14 == null) goto L41;
        String r15 = r14.getLanguageCode();
        if (r15 == null) goto L41;
        String r16 = r15;
    L43:
        return new GetMatchVoiceRequest(r2, r4, r7, r9, r13, r16, null, 64);
    L41:
        r16 = "";
    L33:
        r13 = 0;
    L28:
        r9 = "";
    L22:
        r7 = "";
    L14:
        r4 = "";
    L8:
        r2 = "";
        goto L9
    }
}
