package com.bytedance.android.live.revlink.impl.multianchor.pk.team;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/team/TeamStatus;", "", "LEFT", "RIGHT", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TeamStatus extends Enum<TeamStatus> {
    public static final TeamStatus LEFT = null;
    public static final TeamStatus RIGHT = null;
    public static final /* synthetic */ TeamStatus[] a = null;

    static {
        TeamStatus r1 = new TeamStatus("LEFT", 0);
        LEFT = r1;
        TeamStatus r2 = new TeamStatus("RIGHT", 1);
        RIGHT = r2;
        a = new TeamStatus[]{r1, r2};
    }

    public static TeamStatus valueOf(String r1) {
        return (TeamStatus) a.a(TeamStatus.class, r1);
    }

    public static TeamStatus[] values() {
        return (TeamStatus[]) a.clone();
    }

    public TeamStatus(String r1, int r2) {
        super(r1, r2);
    }
}
