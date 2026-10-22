package com.obric.aiproactive.ui.entry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/StartupInspirationStage;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAITING_NOW", "WAITING_ALL", "COMPLETED", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum StartupInspirationStage extends Enum<StartupInspirationStage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StartupInspirationStage[] $VALUES = null;
    public static final StartupInspirationStage COMPLETED = null;
    public static final StartupInspirationStage IDLE = null;
    public static final StartupInspirationStage WAITING_ALL = null;
    public static final StartupInspirationStage WAITING_NOW = null;

    private static final /* synthetic */ StartupInspirationStage[] $values() {
        return new StartupInspirationStage[]{IDLE, WAITING_NOW, WAITING_ALL, COMPLETED};
    }

    static {
        IDLE = new StartupInspirationStage("IDLE", 0);
        WAITING_NOW = new StartupInspirationStage("WAITING_NOW", 1);
        WAITING_ALL = new StartupInspirationStage("WAITING_ALL", 2);
        COMPLETED = new StartupInspirationStage("COMPLETED", 3);
        StartupInspirationStage[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private StartupInspirationStage(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<StartupInspirationStage> getEntries() {
        return $ENTRIES;
    }

    public static StartupInspirationStage valueOf(String r2) {
        return (StartupInspirationStage) ZeusTransformUtils.preCheckCast(Enum.valueOf(StartupInspirationStage.class, r2), StartupInspirationStage.class, "com.obric.memorydata.plugin");
    }

    public static StartupInspirationStage[] values() {
        return (StartupInspirationStage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StartupInspirationStage[].class, "com.obric.memorydata.plugin");
    }
}
