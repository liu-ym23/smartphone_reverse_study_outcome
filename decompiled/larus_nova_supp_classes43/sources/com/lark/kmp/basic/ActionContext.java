package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/lark/kmp/basic/ActionContext;", "", "<init>", "(Ljava/lang/String;I)V", "LoginContext", "LogoutContext", "SwitchContext", "InternalContext", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionContext extends Enum<ActionContext> {
    public static final ActionContext InternalContext = null;
    public static final ActionContext LoginContext = null;
    public static final ActionContext LogoutContext = null;
    public static final ActionContext SwitchContext = null;
    public static final /* synthetic */ ActionContext[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionContext> getEntries() {
        return b;
    }

    static {
        ActionContext r0 = new ActionContext("LoginContext", 0);
        LoginContext = r0;
        ActionContext r1 = new ActionContext("LogoutContext", 1);
        LogoutContext = r1;
        ActionContext r10 = new ActionContext("SwitchContext", 2);
        SwitchContext = r10;
        ActionContext r11 = new ActionContext("InternalContext", 3);
        InternalContext = r11;
        ActionContext[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ActionContext[] values() {
        return (ActionContext[]) a.clone();
    }

    public static ActionContext valueOf(String r1) {
        return (ActionContext) a.a(ActionContext.class, r1);
    }

    public ActionContext(String r1, int r10) {
        super(r1, r10);
    }
}
