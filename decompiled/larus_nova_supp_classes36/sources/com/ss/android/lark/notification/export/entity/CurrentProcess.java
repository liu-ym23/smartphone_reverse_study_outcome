package com.ss.android.lark.notification.export.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/notification/export/entity/CurrentProcess;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "WSCHANNEL", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum CurrentProcess extends Enum<CurrentProcess> {
    public static final CurrentProcess MAIN = null;
    public static final CurrentProcess WSCHANNEL = null;
    public static final /* synthetic */ CurrentProcess[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CurrentProcess> getEntries() {
        return b;
    }

    static {
        CurrentProcess r0 = new CurrentProcess("MAIN", 0);
        MAIN = r0;
        CurrentProcess r1 = new CurrentProcess("WSCHANNEL", 1);
        WSCHANNEL = r1;
        CurrentProcess[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static CurrentProcess[] values() {
        return (CurrentProcess[]) a.clone();
    }

    public static CurrentProcess valueOf(String r1) {
        return (CurrentProcess) r27.a.a(CurrentProcess.class, r1);
    }

    public CurrentProcess(String r1, int r2) {
        super(r1, r2);
    }
}
