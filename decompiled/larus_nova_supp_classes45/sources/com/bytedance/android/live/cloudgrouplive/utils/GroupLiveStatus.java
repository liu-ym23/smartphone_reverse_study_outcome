package com.bytedance.android.live.cloudgrouplive.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/utils/GroupLiveStatus;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "WAIT", "PRE", "ING", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GroupLiveStatus extends Enum<GroupLiveStatus> {
    public static final GroupLiveStatus ING = null;
    public static final GroupLiveStatus PRE = null;
    public static final GroupLiveStatus WAIT = null;
    public static final /* synthetic */ GroupLiveStatus[] a = null;
    private final String des;

    static {
        GroupLiveStatus r1 = new GroupLiveStatus("WAIT", 0, "wait");
        WAIT = r1;
        GroupLiveStatus r2 = new GroupLiveStatus("PRE", 1, "pre");
        PRE = r2;
        GroupLiveStatus r3 = new GroupLiveStatus("ING", 2, "ing");
        ING = r3;
        a = new GroupLiveStatus[]{r1, r2, r3};
    }

    public static GroupLiveStatus valueOf(String r1) {
        return (GroupLiveStatus) a.a(GroupLiveStatus.class, r1);
    }

    public static GroupLiveStatus[] values() {
        return (GroupLiveStatus[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public GroupLiveStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.des = r3;
    }
}
