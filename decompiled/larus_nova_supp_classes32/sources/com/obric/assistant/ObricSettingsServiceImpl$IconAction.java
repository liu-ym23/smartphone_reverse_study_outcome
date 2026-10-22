package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/ObricSettingsServiceImpl$IconAction;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ENABLE", "DISABLE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricSettingsServiceImpl$IconAction extends Enum<ObricSettingsServiceImpl$IconAction> {
    public static final ObricSettingsServiceImpl$IconAction DISABLE = null;
    public static final ObricSettingsServiceImpl$IconAction ENABLE = null;
    public static final /* synthetic */ ObricSettingsServiceImpl$IconAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricSettingsServiceImpl$IconAction> getEntries() {
        return b;
    }

    static {
        ObricSettingsServiceImpl$IconAction r0 = new ObricSettingsServiceImpl$IconAction("ENABLE", 0);
        ENABLE = r0;
        ObricSettingsServiceImpl$IconAction r1 = new ObricSettingsServiceImpl$IconAction("DISABLE", 1);
        DISABLE = r1;
        ObricSettingsServiceImpl$IconAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ObricSettingsServiceImpl$IconAction[] values() {
        return (ObricSettingsServiceImpl$IconAction[]) a.clone();
    }

    public static ObricSettingsServiceImpl$IconAction valueOf(String r1) {
        return (ObricSettingsServiceImpl$IconAction) r27.a.a(ObricSettingsServiceImpl$IconAction.class, r1);
    }

    public ObricSettingsServiceImpl$IconAction(String r1, int r2) {
        super(r1, r2);
    }
}
