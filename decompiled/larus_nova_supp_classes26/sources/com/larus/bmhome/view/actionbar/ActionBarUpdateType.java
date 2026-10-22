package com.larus.bmhome.view.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/view/actionbar/ActionBarUpdateType;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_WITH_BOT", "UPDATE_WITH_ORDER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarUpdateType extends Enum<ActionBarUpdateType> {
    public static final ActionBarUpdateType UPDATE_WITH_BOT = null;
    public static final ActionBarUpdateType UPDATE_WITH_ORDER = null;
    public static final /* synthetic */ ActionBarUpdateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionBarUpdateType> getEntries() {
        return b;
    }

    static {
        ActionBarUpdateType r0 = new ActionBarUpdateType("UPDATE_WITH_BOT", 0);
        UPDATE_WITH_BOT = r0;
        ActionBarUpdateType r1 = new ActionBarUpdateType("UPDATE_WITH_ORDER", 1);
        UPDATE_WITH_ORDER = r1;
        ActionBarUpdateType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ActionBarUpdateType[] values() {
        return (ActionBarUpdateType[]) a.clone();
    }

    public static ActionBarUpdateType valueOf(String r1) {
        return (ActionBarUpdateType) a.a(ActionBarUpdateType.class, r1);
    }

    public ActionBarUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
