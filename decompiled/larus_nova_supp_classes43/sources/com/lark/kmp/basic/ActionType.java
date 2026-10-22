package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/lark/kmp/basic/ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "Offline", "Online", "BringOnline", "BringForeground", "Clean", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType BringForeground = null;
    public static final ActionType BringOnline = null;
    public static final ActionType Clean = null;
    public static final ActionType Offline = null;
    public static final ActionType Online = null;
    public static final /* synthetic */ ActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionType> getEntries() {
        return b;
    }

    static {
        ActionType r0 = new ActionType("Offline", 0);
        Offline = r0;
        ActionType r1 = new ActionType("Online", 1);
        Online = r1;
        ActionType r10 = new ActionType("BringOnline", 2);
        BringOnline = r10;
        ActionType r11 = new ActionType("BringForeground", 3);
        BringForeground = r11;
        ActionType r12 = new ActionType("Clean", 4);
        Clean = r12;
        ActionType[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static ActionType[] values() {
        return (ActionType[]) a.clone();
    }

    public static ActionType valueOf(String r1) {
        return (ActionType) a.a(ActionType.class, r1);
    }

    public ActionType(String r1, int r10) {
        super(r1, r10);
    }
}
