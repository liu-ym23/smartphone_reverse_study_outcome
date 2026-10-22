package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/onboarding/ActionEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TOAST", "DIALOG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionEvent extends Enum<ActionEvent> {
    public static final ActionEvent DIALOG = null;
    public static final ActionEvent TOAST = null;
    public static final ActionEvent UNKNOWN = null;
    public static final /* synthetic */ ActionEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionEvent> getEntries() {
        return b;
    }

    static {
        ActionEvent r0 = new ActionEvent("UNKNOWN", 0);
        UNKNOWN = r0;
        ActionEvent r1 = new ActionEvent("TOAST", 1);
        TOAST = r1;
        ActionEvent r3 = new ActionEvent("DIALOG", 2);
        DIALOG = r3;
        ActionEvent[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ActionEvent[] values() {
        return (ActionEvent[]) a.clone();
    }

    public static ActionEvent valueOf(String r1) {
        return (ActionEvent) r27.a.a(ActionEvent.class, r1);
    }

    public ActionEvent(String r1, int r2) {
        super(r1, r2);
    }
}
