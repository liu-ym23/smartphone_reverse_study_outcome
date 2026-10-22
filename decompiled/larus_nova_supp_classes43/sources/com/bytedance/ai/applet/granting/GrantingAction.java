package com.bytedance.ai.applet.granting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantingAction;", "", "<init>", "(Ljava/lang/String;I)V", "AGREED", "REJECTED", "DISMISSED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GrantingAction extends Enum<GrantingAction> {
    public static final GrantingAction AGREED = null;
    public static final GrantingAction DISMISSED = null;
    public static final GrantingAction REJECTED = null;
    public static final /* synthetic */ GrantingAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GrantingAction> getEntries() {
        return b;
    }

    static {
        GrantingAction r0 = new GrantingAction("AGREED", 0);
        AGREED = r0;
        GrantingAction r1 = new GrantingAction("REJECTED", 1);
        REJECTED = r1;
        GrantingAction r10 = new GrantingAction("DISMISSED", 2);
        DISMISSED = r10;
        GrantingAction[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static GrantingAction[] values() {
        return (GrantingAction[]) a.clone();
    }

    public static GrantingAction valueOf(String r1) {
        return (GrantingAction) a.a(GrantingAction.class, r1);
    }

    public GrantingAction(String r1, int r10) {
        super(r1, r10);
    }
}
