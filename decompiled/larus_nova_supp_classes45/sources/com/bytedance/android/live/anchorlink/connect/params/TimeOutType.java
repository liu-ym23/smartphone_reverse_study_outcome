package com.bytedance.android.live.anchorlink.connect.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/anchorlink/connect/params/TimeOutType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Invite_Time_Out", "Apply_Time_Out", "Be_Invite_Time_Out", "liverevenue-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TimeOutType extends Enum<TimeOutType> {
    public static final TimeOutType Apply_Time_Out = null;
    public static final TimeOutType Be_Invite_Time_Out = null;
    public static final TimeOutType Invite_Time_Out = null;
    public static final /* synthetic */ TimeOutType[] a = null;
    private final String type;

    static {
        TimeOutType r1 = new TimeOutType("Invite_Time_Out", 0, "invite_time_out");
        Invite_Time_Out = r1;
        TimeOutType r2 = new TimeOutType("Apply_Time_Out", 1, "apply_time_out");
        Apply_Time_Out = r2;
        TimeOutType r3 = new TimeOutType("Be_Invite_Time_Out", 2, "be_invite_time_out");
        Be_Invite_Time_Out = r3;
        a = new TimeOutType[]{r1, r2, r3};
    }

    public static TimeOutType valueOf(String r1) {
        return (TimeOutType) a.a(TimeOutType.class, r1);
    }

    public static TimeOutType[] values() {
        return (TimeOutType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public TimeOutType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
