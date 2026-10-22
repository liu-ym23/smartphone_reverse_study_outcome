package com.obric.aiagent.assistant.utils;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NoInstalled", "AppDisabled", "Enabled", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum AppEnableStatus extends Enum<AppEnableStatus> {
    public static final AppEnableStatus AppDisabled = null;
    public static final AppEnableStatus Enabled = null;
    public static final AppEnableStatus NoInstalled = null;
    public static final /* synthetic */ AppEnableStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AppEnableStatus> getEntries() {
        return b;
    }

    static {
        AppEnableStatus r0 = new AppEnableStatus("NoInstalled", 0);
        NoInstalled = r0;
        AppEnableStatus r1 = new AppEnableStatus("AppDisabled", 1);
        AppDisabled = r1;
        AppEnableStatus r3 = new AppEnableStatus("Enabled", 2);
        Enabled = r3;
        AppEnableStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AppEnableStatus[] values() {
        return (AppEnableStatus[]) a.clone();
    }

    public static AppEnableStatus valueOf(String r1) {
        return (AppEnableStatus) a.a(AppEnableStatus.class, r1);
    }

    public AppEnableStatus(String r1, int r2) {
        super(r1, r2);
    }
}
