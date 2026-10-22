package com.obric.audio.enroll.model;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/audio/enroll/model/TeamMember;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", AccountType.ALL, "TITLE", "UPPER", "MIDDLE", "LOWER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamMember extends Enum<TeamMember> {
    public static final TeamMember ALL = null;
    public static final a Companion = null;
    public static final TeamMember LOWER = null;
    public static final TeamMember MIDDLE = null;
    public static final TeamMember TITLE = null;
    public static final TeamMember UPPER = null;
    public static final /* synthetic */ TeamMember[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int order;

    public static final class a {
        public a() {
        }

        public static TeamMember a(int r6) {
            TeamMember[] r0 = TeamMember.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            TeamMember r4 = r0[r3];
            if (r4.getOrder() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return TeamMember.ALL;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static EnumEntries<TeamMember> getEntries() {
        return b;
    }

    static {
        TeamMember r0 = new TeamMember(AccountType.ALL, 0, -1);
        ALL = r0;
        TeamMember r1 = new TeamMember("TITLE", 1, 0);
        TITLE = r1;
        TeamMember r3 = new TeamMember("UPPER", 2, 1);
        UPPER = r3;
        TeamMember r5 = new TeamMember("MIDDLE", 3, 2);
        MIDDLE = r5;
        TeamMember r7 = new TeamMember("LOWER", 4, 3);
        LOWER = r7;
        TeamMember[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static TeamMember[] values() {
        return (TeamMember[]) a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static TeamMember valueOf(String r1) {
        return (TeamMember) r27.a.a(TeamMember.class, r1);
    }

    public TeamMember(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }
}
