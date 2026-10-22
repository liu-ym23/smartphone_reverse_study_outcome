package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements lc0.c {
    public final kc0.o a;

    @Override // lc0.c
    public final String a() {
        String r0 = this.a.a();
        if (r0 != null) goto L6;
        return "0";
    L6:
        return r0;
    }

    @Override // lc0.c
    public final long getChannelId() {
        return this.a.getChannelId();
    }

    @Override // lc0.c
    public final long getDuration() {
        return this.a.getDuration();
    }

    @Override // lc0.c
    public final int getInviteType() {
        return this.a.getInviteType();
    }

    @Override // lc0.c
    public final int getMatchType() {
        return this.a.getMatchType();
    }

    @Override // lc0.c
    public final long getPkId() {
        return this.a.getPkId();
    }

    @Override // lc0.c
    public final String u() {
        return this.a.u();
    }

    @Override // lc0.c
    public final am2.l v() {
        kc0.o r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "$this$getLinkCrossRoomLog");
        am2.l r1 = new am2.l();
        r1.a = r0.getChannelId();
        r1.b = r0.a();
        r1.c = (int) r0.getDuration();
        r1.d = r0.A();
        r1.e = r0.getPkId();
        r1.h = r0.B();
        r1.i = r0.getRequestId();
        r1.a(Boolean.valueOf(r0.isOnceMore()));
        r1.f = r0.getTheme();
        return r1;
    }

    @Override // lc0.c
    public final String w() {
        return this.a.w();
    }

    @Override // lc0.c
    public final String x() {
        return this.a.x();
    }

    @Override // lc0.c
    public final String y() {
        return this.a.y();
    }

    @Override // lc0.c
    public final String z() {
        return this.a.z();
    }

    public m(kc0.o r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }
}
