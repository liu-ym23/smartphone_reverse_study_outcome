package pea;

import android.app.PendingIntent;
import com.google.gson.JsonObject;
import com.obric.assistant.live.gr.island.island.GRLiveCardType;
import com.obric.assistant.live.gr.island.island.impl.GRIslandImpl;
import com.obric.assistant.live.strategy.GRIslandStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public final Boolean A;
    public final Integer B;
    public final Boolean C;
    public final Integer D;
    public final k a;
    public final k b;
    public final k c;
    public PendingIntent d;
    public final nea.a e;
    public final Long f;
    public long g;
    public final GRLiveCardType h;
    public final k i;
    public Boolean j;
    public final JsonObject k;
    public volatile long l;
    public final Object m;
    public final String n;
    public boolean o;
    public final boolean p;
    public final boolean q;
    public final Integer r;
    public final String s;
    public final String t;
    public final String u;
    public final Integer v;
    public final String w;
    public final String x;
    public final Integer y;
    public final Integer z;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "GRIslandSession(collapseWidget=" + this.a + ", expandWidget=" + this.b + ", smallCollapseWidget=" + this.c + ", intent=" + this.d + ", callback=" + this.e + ", autoDismissDuration=" + this.f + ", taskId=" + this.g + ", type=" + this.h + ", currWidget=" + this.i + ", canFrontShow=" + this.j + ", ext=" + this.k + ", flags=" + this.l + ", sessionContext=" + this.m + ", business=" + this.n + ", enableFloat=" + this.o + ", islandFirstFloat=" + this.p + ", updatable=" + this.q + ", timeout=" + this.r + ", reopen=" + this.s + ", ticker=" + this.t + ", tickerPic=" + this.u + ", tickerPicResId=" + this.v + ", aodTitle=" + this.w + ", aodPic=" + this.x + ", aodPicResId=" + this.y + ", islandProperty=" + this.z + ", islandOrder=" + this.A + ", islandTimeout=" + this.B + ", dismissIsland=" + this.C + ", expandedTime=" + this.D + ')';
    }

    public final boolean a() {
        if ((this.l & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        nea.c.a.a();
        GRIslandImpl r0 = nea.b.c;
        if (r0 == null) goto L6;
        r0.e(this);
        return;
    }

    public final int hashCode() {
        long r0 = this.g;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final GRLiveCardType getType() {
        return this.h;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (Intrinsics.areEqual(j.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.entity.GRIslandSession");
        if (this.g == ((j) r8).g) goto L17;
        return false;
    L17:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void update(k r2) {
        Intrinsics.checkNotNullParameter(r2, "targetWidget");
        nea.c.a.a();
        GRIslandImpl r0 = nea.b.c;
        if (r0 == null) goto L6;
        r0.f(this, r2);
        return;
    }

    public j(k r12, k r13, k r14, PendingIntent r15, GRIslandStrategy.b r16, GRLiveCardType r17, JsonObject r18, long r19, String r21, String r22, String r23) {
        Boolean r4 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r12, "collapseWidget");
        Intrinsics.checkNotNullParameter(r14, "smallCollapseWidget");
        Intrinsics.checkNotNullParameter(r21, "business");
        this.a = r12;
        this.b = r13;
        this.c = r14;
        this.d = r15;
        this.e = r16;
        this.f = null;
        this.g = 0;
        this.h = r17;
        this.i = null;
        this.j = r4;
        this.k = r18;
        this.l = r19;
        this.m = null;
        this.n = r21;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = 720;
        this.s = "reopen";
        this.t = r22;
        this.u = null;
        this.v = null;
        this.w = r23;
        this.x = null;
        this.y = null;
        this.z = 2;
        this.A = null;
        this.B = 3600;
        this.C = r4;
        this.D = 10;
    }
}
