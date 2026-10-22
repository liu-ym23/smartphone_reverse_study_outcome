package com.bytedance.android.live.revlink.impl.multianchor.pk.control;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/control/TeamTaskBackgroundDef;", "", "VOTE_PAD", "VOTE", "PAD", "NORMAL", "SIMPLE_PAD", "SIMPLE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TeamTaskBackgroundDef extends Enum<TeamTaskBackgroundDef> {
    public static final TeamTaskBackgroundDef NORMAL = null;
    public static final TeamTaskBackgroundDef PAD = null;
    public static final TeamTaskBackgroundDef SIMPLE = null;
    public static final TeamTaskBackgroundDef SIMPLE_PAD = null;
    public static final TeamTaskBackgroundDef VOTE = null;
    public static final TeamTaskBackgroundDef VOTE_PAD = null;
    public static final /* synthetic */ TeamTaskBackgroundDef[] a = null;

    static {
        TeamTaskBackgroundDef r1 = new TeamTaskBackgroundDef("VOTE_PAD", 0);
        VOTE_PAD = r1;
        TeamTaskBackgroundDef r2 = new TeamTaskBackgroundDef("VOTE", 1);
        VOTE = r2;
        TeamTaskBackgroundDef r3 = new TeamTaskBackgroundDef("PAD", 2);
        PAD = r3;
        TeamTaskBackgroundDef r4 = new TeamTaskBackgroundDef("NORMAL", 3);
        NORMAL = r4;
        TeamTaskBackgroundDef r5 = new TeamTaskBackgroundDef("SIMPLE_PAD", 4);
        SIMPLE_PAD = r5;
        TeamTaskBackgroundDef r6 = new TeamTaskBackgroundDef("SIMPLE", 5);
        SIMPLE = r6;
        a = new TeamTaskBackgroundDef[]{r1, r2, r3, r4, r5, r6};
    }

    public static TeamTaskBackgroundDef valueOf(String r1) {
        return (TeamTaskBackgroundDef) a.a(TeamTaskBackgroundDef.class, r1);
    }

    public static TeamTaskBackgroundDef[] values() {
        return (TeamTaskBackgroundDef[]) a.clone();
    }

    public TeamTaskBackgroundDef(String r1, int r2) {
        super(r1, r2);
    }
}
