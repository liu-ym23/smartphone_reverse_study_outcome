package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/component/ObricIntercomComponent$TouchTerminalIntent;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SUBMIT_ON_START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIntercomComponent$TouchTerminalIntent extends Enum<ObricIntercomComponent$TouchTerminalIntent> {
    public static final ObricIntercomComponent$TouchTerminalIntent NONE = null;
    public static final ObricIntercomComponent$TouchTerminalIntent SUBMIT_ON_START = null;
    public static final /* synthetic */ ObricIntercomComponent$TouchTerminalIntent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricIntercomComponent$TouchTerminalIntent> getEntries() {
        return b;
    }

    static {
        ObricIntercomComponent$TouchTerminalIntent r0 = new ObricIntercomComponent$TouchTerminalIntent("NONE", 0);
        NONE = r0;
        ObricIntercomComponent$TouchTerminalIntent r1 = new ObricIntercomComponent$TouchTerminalIntent("SUBMIT_ON_START", 1);
        SUBMIT_ON_START = r1;
        ObricIntercomComponent$TouchTerminalIntent[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ObricIntercomComponent$TouchTerminalIntent[] values() {
        return (ObricIntercomComponent$TouchTerminalIntent[]) a.clone();
    }

    public static ObricIntercomComponent$TouchTerminalIntent valueOf(String r1) {
        return (ObricIntercomComponent$TouchTerminalIntent) r27.a.a(ObricIntercomComponent$TouchTerminalIntent.class, r1);
    }

    public ObricIntercomComponent$TouchTerminalIntent(String r1, int r2) {
        super(r1, r2);
    }
}
