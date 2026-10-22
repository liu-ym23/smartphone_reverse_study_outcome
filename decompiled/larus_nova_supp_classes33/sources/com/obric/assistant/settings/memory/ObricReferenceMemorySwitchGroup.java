package com.obric.assistant.settings.memory;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/settings/memory/ObricReferenceMemorySwitchGroup;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.MAIN, "CHILD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricReferenceMemorySwitchGroup extends Enum<ObricReferenceMemorySwitchGroup> {
    public static final ObricReferenceMemorySwitchGroup CHILD = null;
    public static final ObricReferenceMemorySwitchGroup MAIN = null;
    public static final /* synthetic */ ObricReferenceMemorySwitchGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricReferenceMemorySwitchGroup> getEntries() {
        return b;
    }

    static {
        ObricReferenceMemorySwitchGroup r0 = new ObricReferenceMemorySwitchGroup(AccountType.MAIN, 0);
        MAIN = r0;
        ObricReferenceMemorySwitchGroup r1 = new ObricReferenceMemorySwitchGroup("CHILD", 1);
        CHILD = r1;
        ObricReferenceMemorySwitchGroup[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ObricReferenceMemorySwitchGroup[] values() {
        return (ObricReferenceMemorySwitchGroup[]) a.clone();
    }

    public static ObricReferenceMemorySwitchGroup valueOf(String r1) {
        return (ObricReferenceMemorySwitchGroup) r27.a.a(ObricReferenceMemorySwitchGroup.class, r1);
    }

    public ObricReferenceMemorySwitchGroup(String r1, int r2) {
        super(r1, r2);
    }
}
