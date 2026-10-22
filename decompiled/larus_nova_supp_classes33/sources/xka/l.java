package xka;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l implements vka.b<Long> {
    public static final /* synthetic */ int I = 0;
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final String G;
    public final String H;
    public final Long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final Long i;
    public final String j;
    public final Long k;
    public final String l;
    public final Integer m;
    public final Long n;
    public final String o;
    public final String p;
    public final Long q;
    public final Long r;
    public final Long s;
    public final Integer t;
    public final String u;
    public final String v;
    public final String w;
    public final Long x;
    public final String y;
    public final String z;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        ContentValues r1 = new ContentValues();
        r1.put("name", this.b);
        r1.put("account_type", this.e);
        r1.put("account_name", this.d);
        r1.put("calendar_location", this.c);
        r1.put("calendar_color", this.f);
        r1.put("calendar_color_index", this.g);
        r1.put("_sync_id", this.h);
        r1.put("dirty", this.i);
        r1.put("mutators", this.j);
        r1.put("deleted", this.k);
        r1.put("calendar_displayName", this.l);
        r1.put("calendar_access_level", this.m);
        r1.put("visible", this.n);
        r1.put("calendar_timezone", this.o);
        r1.put("ownerAccount", this.p);
        r1.put("sync_events", this.q);
        r1.put("canOrganizerRespond", this.r);
        r1.put("canModifyTimeZone", this.s);
        r1.put("maxReminders", this.t);
        r1.put("allowedReminders", this.u);
        r1.put("allowedAvailability", this.v);
        r1.put("allowedAttendeeTypes", this.w);
        r1.put("isPrimary", this.x);
        r1.put("cal_sync1", this.y);
        r1.put("cal_sync2", this.z);
        r1.put("cal_sync3", this.A);
        r1.put("cal_sync4", this.B);
        r1.put("cal_sync5", this.C);
        r1.put("cal_sync6", this.D);
        r1.put("cal_sync7", this.E);
        r1.put("cal_sync8", this.F);
        r1.put("cal_sync9", this.G);
        r1.put("cal_sync10", this.H);
        if (this.a == null) goto L8;
        if (r0.update(new ala.a(this.a, this.d), r1, null, null) > 0) goto L10;
        return null;
    L10:
        return this.a;
    L8:
        return r0.insert(new ala.a(null, this.d), r1);
    }

    public l(Long r3, String r4, String r5, String r6, String r7, Integer r8, String r9, String r10, Long r11, String r12, Long r13, String r14, Integer r15, Long r16, String r17, String r18, Long r19, Long r20, Long r21, Integer r22, String r23, String r24, String r25, Long r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r35;
        this.H = r36;
    }
}
