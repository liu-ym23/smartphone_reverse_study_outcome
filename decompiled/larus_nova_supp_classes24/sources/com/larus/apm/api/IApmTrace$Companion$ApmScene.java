package com.larus.apm.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/apm/api/IApmTrace$Companion$ApmScene;", "", "<init>", "(Ljava/lang/String;I)V", "DORA_QUERY", "TTS_PLAY", "REALTIME_CALL", "NAVIGATION_LOCATING", "MUSIC_PLAY", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum IApmTrace$Companion$ApmScene extends Enum<IApmTrace$Companion$ApmScene> {
    public static final IApmTrace$Companion$ApmScene DORA_QUERY = null;
    public static final IApmTrace$Companion$ApmScene MUSIC_PLAY = null;
    public static final IApmTrace$Companion$ApmScene NAVIGATION_LOCATING = null;
    public static final IApmTrace$Companion$ApmScene REALTIME_CALL = null;
    public static final IApmTrace$Companion$ApmScene TTS_PLAY = null;
    public static final /* synthetic */ IApmTrace$Companion$ApmScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IApmTrace$Companion$ApmScene> getEntries() {
        return b;
    }

    static {
        IApmTrace$Companion$ApmScene r0 = new IApmTrace$Companion$ApmScene("DORA_QUERY", 0);
        DORA_QUERY = r0;
        IApmTrace$Companion$ApmScene r1 = new IApmTrace$Companion$ApmScene("TTS_PLAY", 1);
        TTS_PLAY = r1;
        IApmTrace$Companion$ApmScene r3 = new IApmTrace$Companion$ApmScene("REALTIME_CALL", 2);
        REALTIME_CALL = r3;
        IApmTrace$Companion$ApmScene r5 = new IApmTrace$Companion$ApmScene("NAVIGATION_LOCATING", 3);
        NAVIGATION_LOCATING = r5;
        IApmTrace$Companion$ApmScene r7 = new IApmTrace$Companion$ApmScene("MUSIC_PLAY", 4);
        MUSIC_PLAY = r7;
        IApmTrace$Companion$ApmScene[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static IApmTrace$Companion$ApmScene[] values() {
        return (IApmTrace$Companion$ApmScene[]) a.clone();
    }

    public static IApmTrace$Companion$ApmScene valueOf(String r1) {
        return (IApmTrace$Companion$ApmScene) a.a(IApmTrace$Companion$ApmScene.class, r1);
    }

    public IApmTrace$Companion$ApmScene(String r1, int r2) {
        super(r1, r2);
    }
}
