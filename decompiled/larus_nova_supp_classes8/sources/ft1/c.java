package ft1;

import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Integer r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = EpisodeMod.EpisodeStageType.UNKNOWN;
        if (r3.intValue() == r1) goto L26;
        int r0 = EpisodeMod.EpisodeStageType.LIVE;
        if (r3.intValue() != r0) goto L11;
        return "LIVE";
    L11:
        int r2 = EpisodeMod.EpisodeStageType.PREMIERE;
        if (r3.intValue() != r2) goto L14;
        return "PREMIERE";
    L14:
        int r4 = EpisodeMod.EpisodeStageType.RECORD;
        if (r3.intValue() != r4) goto L17;
        return "RECORD";
    L17:
        int r5 = EpisodeMod.EpisodeStageType.REPLAY;
        if (r3.intValue() != r5) goto L21;
        return SourceType.REPLAY;
    L21:
        return String.valueOf(r3.intValue());
    L26:
        return null;
    }

    public static String b(EpisodeExtraInfo r3) {
        if (r3 == null) goto L36;
        MultiTab r1 = r3.getMultiTab();
        if ((r1 instanceof MultiTab) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L13;
        List r2 = r1.getValidTabs();
        if (r2 == null) goto L13;
        if ((!r2.isEmpty()) != true) goto L13;
        return "multi_tab";
    L13:
        IBaseEpisodeMod r4 = r3.getMod();
        if (r4 == null) goto L16;
        Integer r5 = Integer.valueOf(r4.getEpisodeSubType());
    L17:
        int r6 = EpisodeMod.EpisodeSubType.UNKNOWN;
        if (r5 != null) goto L21;
    L23:
        int r7 = EpisodeMod.EpisodeSubType.NORMAL;
        if (r5 != null) goto L27;
    L29:
        int r8 = EpisodeMod.EpisodeSubType.GUIDE;
        if (r5 != null) goto L33;
        return null;
    L33:
        if (r5.intValue() != r8) goto L39;
        return "GUIDE";
    L39:
        return null;
    L27:
        if (r5.intValue() != r7) goto L29;
        return "NORMAL";
    L21:
        if (r5.intValue() != r6) goto L23;
        return null;
    L16:
        r5 = null;
        goto L17
    L36:
        return null;
    }
}
