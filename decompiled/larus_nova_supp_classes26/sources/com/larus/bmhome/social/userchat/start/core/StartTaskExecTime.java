package com.larus.bmhome.social.userchat.start.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/social/userchat/start/core/StartTaskExecTime;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StartTaskExecTime extends Enum<StartTaskExecTime> {
    public static final StartTaskExecTime BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED = null;
    public static final /* synthetic */ StartTaskExecTime[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StartTaskExecTime> getEntries() {
        return b;
    }

    static {
        StartTaskExecTime r0 = new StartTaskExecTime();
        BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED = r0;
        StartTaskExecTime[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public StartTaskExecTime() {
        super("BEFORE_MAIN_ACTIVITY_SUPER_ON_CREATED", 0);
    }

    public static StartTaskExecTime[] values() {
        return (StartTaskExecTime[]) a.clone();
    }

    public static StartTaskExecTime valueOf(String r1) {
        return (StartTaskExecTime) a.a(StartTaskExecTime.class, r1);
    }
}
