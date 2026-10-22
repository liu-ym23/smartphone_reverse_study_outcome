package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/platform/model/ApmScene;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_QUERY", "TTS_PLAY", "REALTIME_CALL", "NAVIGATION_LOCATING", "MUSIC_PLAY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ApmScene extends Enum<ApmScene> {
    public static final ApmScene DORA_QUERY = null;
    public static final ApmScene MUSIC_PLAY = null;
    public static final ApmScene NAVIGATION_LOCATING = null;
    public static final ApmScene REALTIME_CALL = null;
    public static final ApmScene TTS_PLAY = null;
    public static final /* synthetic */ ApmScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ApmScene> getEntries() {
        return b;
    }

    static {
        ApmScene r0 = new ApmScene("DORA_QUERY", 0);
        DORA_QUERY = r0;
        ApmScene r1 = new ApmScene("TTS_PLAY", 1);
        TTS_PLAY = r1;
        ApmScene r3 = new ApmScene("REALTIME_CALL", 2);
        REALTIME_CALL = r3;
        ApmScene r5 = new ApmScene("NAVIGATION_LOCATING", 3);
        NAVIGATION_LOCATING = r5;
        ApmScene r7 = new ApmScene("MUSIC_PLAY", 4);
        MUSIC_PLAY = r7;
        ApmScene[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ApmScene[] values() {
        return (ApmScene[]) a.clone();
    }

    public static ApmScene valueOf(String r1) {
        return (ApmScene) a.a(ApmScene.class, r1);
    }

    public ApmScene(String r1, int r2) {
        super(r1, r2);
    }
}
