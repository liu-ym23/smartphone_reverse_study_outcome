package com.larus.bmhome.taskskill.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/taskskill/view/PcConnectionStatusAction;", "", "<init>", "(Ljava/lang/String;I)V", "RetryGetAllDevices", "RequestAuthorizedPermission", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcConnectionStatusAction extends Enum<PcConnectionStatusAction> {
    public static final PcConnectionStatusAction RequestAuthorizedPermission = null;
    public static final PcConnectionStatusAction RetryGetAllDevices = null;
    public static final /* synthetic */ PcConnectionStatusAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PcConnectionStatusAction> getEntries() {
        return b;
    }

    static {
        PcConnectionStatusAction r0 = new PcConnectionStatusAction("RetryGetAllDevices", 0);
        RetryGetAllDevices = r0;
        PcConnectionStatusAction r1 = new PcConnectionStatusAction("RequestAuthorizedPermission", 1);
        RequestAuthorizedPermission = r1;
        PcConnectionStatusAction[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PcConnectionStatusAction[] values() {
        return (PcConnectionStatusAction[]) a.clone();
    }

    public static PcConnectionStatusAction valueOf(String r1) {
        return (PcConnectionStatusAction) r27.a.a(PcConnectionStatusAction.class, r1);
    }

    public PcConnectionStatusAction(String r1, int r2) {
        super(r1, r2);
    }
}
