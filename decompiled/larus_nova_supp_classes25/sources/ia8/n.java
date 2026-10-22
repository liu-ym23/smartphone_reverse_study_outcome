package ia8;

import com.larus.avlink.dora.DoraMode;
import com.larus.avlink.model.ProactiveSummaryScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.SystemNotify.getValue())) == false) goto L6;
        return "dora_system_notification_broadcast";
    L6:
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.Music.getValue())) == false) goto L9;
        return "dora_proactive_music_recommendation";
    L9:
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.News.getValue())) == false) goto L12;
        return "dora_daily_news_broadcast";
    L12:
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.Remind.getValue())) == false) goto L15;
        return "dora_reminder_broadcast";
    L15:
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.ProactiveMsg.getValue())) == false) goto L18;
        return "dora_proactive_chat";
    L18:
        if (Intrinsics.areEqual(r1, String.valueOf(ProactiveSummaryScene.DeepResearch.getValue())) == false) goto L20;
        return "dora_deep_research";
    L20:
        return null;
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneMode");
        int r0 = r2.hashCode();
        if (r0 == (-1449454789)) goto L16;
        if (r0 == 407405714) goto L13;
        if (r0 == 785611651) goto L10;
    L17:
        return null;
    L10:
        if (r2.equals("dora_call") == false) goto L17;
        return "dora_call";
    L13:
        if (r2.equals("radio_single_turn_conversation") == false) goto L17;
    L18:
        return "dora_radio";
    L16:
        if (r2.equals("radio_multi_turn_conversation") == true) goto L18;
        goto L17
    }

    public static String c(int r1) {
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L20;
        if (r1 == 6) goto L18;
        if (r1 == 7) goto L20;
        if (r1 == 21) goto L21;
        return DoraMode.DORA_CALL.getValue();
    L20:
        return DoraMode.DORA_RADIO_MULTI_TURN.getValue();
    L21:
        return DoraMode.DORA_RADIO_SINGLE_TURN.getValue();
    L18:
        return DoraMode.DORA_CALL.getValue();
    }
}
