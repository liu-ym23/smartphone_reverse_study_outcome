package com.larus.setting.api.data;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/setting/api/data/SettingsItemAction;", "", "<init>", "(Ljava/lang/String;I)V", "TOGGLE", "TAP", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SettingsItemAction extends Enum<SettingsItemAction> {
    public static final SettingsItemAction TAP = null;
    public static final SettingsItemAction TOGGLE = null;
    public static final /* synthetic */ SettingsItemAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SettingsItemAction> getEntries() {
        return b;
    }

    static {
        SettingsItemAction r0 = new SettingsItemAction("TOGGLE", 0);
        TOGGLE = r0;
        SettingsItemAction r1 = new SettingsItemAction("TAP", 1);
        TAP = r1;
        SettingsItemAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SettingsItemAction[] values() {
        return (SettingsItemAction[]) a.clone();
    }

    public static SettingsItemAction valueOf(String r1) {
        return (SettingsItemAction) a.a(SettingsItemAction.class, r1);
    }

    public SettingsItemAction(String r1, int r2) {
        super(r1, r2);
    }
}
