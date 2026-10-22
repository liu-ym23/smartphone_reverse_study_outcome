package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline;

import am2.x;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public String a;
    public String b;
    public long c;
    public long d;
    public long e;
    public long f;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.a$a, reason: collision with other inner class name */
    public static final class C0103a {
    }

    static {
    }

    public static String c() {
        SelfDisciplineContext.Companion.getClass();
        return String.valueOf(SelfDisciplineContext.access$getRoomIntro$cp());
    }

    public a() {
        this.a = "auto_start";
        this.b = "null";
    }

    public static String a() {
        o r0 = j0.l().c(x.class);
        if (r0 == null) goto L7;
        Map r1 = r0.getMap();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get("enter_from_merge");
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    public static String b() {
        o r0 = j0.l().c(x.class);
        if (r0 == null) goto L7;
        Map r1 = r0.getMap();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get("enter_method");
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }
}
