package com.larus.setting.api.data;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/setting/api/data/FlowSettingsScene;", "", "<init>", "(Ljava/lang/String;I)V", "FIND_MY_WAY", "ADD_MY_WAY", "NOTIFY", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum FlowSettingsScene extends Enum<FlowSettingsScene> {
    public static final FlowSettingsScene ADD_MY_WAY = null;
    public static final FlowSettingsScene FIND_MY_WAY = null;
    public static final FlowSettingsScene NOTIFY = null;
    public static final /* synthetic */ FlowSettingsScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FlowSettingsScene> getEntries() {
        return b;
    }

    static {
        FlowSettingsScene r0 = new FlowSettingsScene("FIND_MY_WAY", 0);
        FIND_MY_WAY = r0;
        FlowSettingsScene r1 = new FlowSettingsScene("ADD_MY_WAY", 1);
        ADD_MY_WAY = r1;
        FlowSettingsScene r3 = new FlowSettingsScene("NOTIFY", 2);
        NOTIFY = r3;
        FlowSettingsScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FlowSettingsScene[] values() {
        return (FlowSettingsScene[]) a.clone();
    }

    public static FlowSettingsScene valueOf(String r1) {
        return (FlowSettingsScene) a.a(FlowSettingsScene.class, r1);
    }

    public FlowSettingsScene(String r1, int r2) {
        super(r1, r2);
    }
}
