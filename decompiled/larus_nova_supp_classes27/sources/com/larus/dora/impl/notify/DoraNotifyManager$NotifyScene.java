package com.larus.dora.impl.notify;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/notify/DoraNotifyManager$NotifyScene;", "", "<init>", "(Ljava/lang/String;I)V", "SCENE_BATTERY_CHANGE", "SCENE_LINK_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraNotifyManager$NotifyScene extends Enum<DoraNotifyManager$NotifyScene> {
    public static final DoraNotifyManager$NotifyScene SCENE_BATTERY_CHANGE = null;
    public static final DoraNotifyManager$NotifyScene SCENE_LINK_CONNECTED = null;
    public static final /* synthetic */ DoraNotifyManager$NotifyScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraNotifyManager$NotifyScene> getEntries() {
        return b;
    }

    static {
        DoraNotifyManager$NotifyScene r0 = new DoraNotifyManager$NotifyScene("SCENE_BATTERY_CHANGE", 0);
        SCENE_BATTERY_CHANGE = r0;
        DoraNotifyManager$NotifyScene r1 = new DoraNotifyManager$NotifyScene("SCENE_LINK_CONNECTED", 1);
        SCENE_LINK_CONNECTED = r1;
        DoraNotifyManager$NotifyScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraNotifyManager$NotifyScene[] values() {
        return (DoraNotifyManager$NotifyScene[]) a.clone();
    }

    public static DoraNotifyManager$NotifyScene valueOf(String r1) {
        return (DoraNotifyManager$NotifyScene) a.a(DoraNotifyManager$NotifyScene.class, r1);
    }

    public DoraNotifyManager$NotifyScene(String r1, int r2) {
        super(r1, r2);
    }
}
