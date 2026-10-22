package com.ss.android.lark.custom.repeat.entity;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.log.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class EventRecurrence {
    public static final String A = null;
    public static final HashMap<String, o> B = null;
    public static final HashMap<String, Integer> y = null;
    public static final HashMap<String, Integer> z = null;
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int[] f;
    public int g;
    public int[] h;
    public int i;
    public int[] j;
    public int k;
    public int[] l;
    public int[] m;
    public int n;
    public int[] o;
    public int p;
    public int[] q;
    public int r;
    public int[] s;
    public int t;
    public int[] u;
    public int v;
    public int[] w;
    public int x;

    public static class InvalidFormatException extends RuntimeException {
        private static final long serialVersionUID = -6734979874313418099L;

        public InvalidFormatException(String r1) {
            super(r1);
        }
    }

    public static class a extends o {
        public a(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r6, EventRecurrence r7) {
            int r2 = 0;
            if (r6.indexOf(",") >= 0) goto L5;
            int r0 = 1;
            int[] r1 = new int[1];
            int[] r3 = new int[1];
            d(r6, r1, r3, 0);
        L8:
            r7.l = r1;
            r7.m = r3;
            r7.n = r0;
            return 128;
        L5:
            String[] r8 = r6.split(",");
            r0 = r8.length;
            r1 = new int[r0];
            r3 = new int[r0];
        L6:
            if (r2 >= r0) goto L8;
            d(r8[r2], r1, r3, r2);
            r2 = r2 + 1;
            goto L6
        }

        public static void d(String r5, int[] r6, int[] r7, int r8) {
            int r0 = r5.length() - 2;
            if (r0 <= 0) goto L5;
            r7[r8] = o.a(r5.substring(0, r0), -53, 53, false);
            String r9 = r5.substring(r0);
        L6:
            Integer r10 = EventRecurrence.z.get(r9);
            if (r10 == null) goto L11;
            r6[r8] = r10.intValue();
            return;
        L11:
            throw new InvalidFormatException("Invalid BYDAY value: ".concat(r5));
        L5:
            r9 = r5;
            goto L6
        }
    }

    public static class b extends o {
        public b(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, 0, 23, true);
            r5.j = r6;
            r5.k = r6.length;
            return 64;
        }
    }

    public static class c extends o {
        public c(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, 0, 59, true);
            r5.h = r6;
            r5.i = r6.length;
            return 32;
        }
    }

    public static class d extends o {
        public d(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, 1, 12, false);
            r5.u = r6;
            r5.v = r6.length;
            return 2048;
        }
    }

    public static class e extends o {
        public e(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, -31, 31, false);
            r5.o = r6;
            r5.p = r6.length;
            return 256;
        }
    }

    public static class f extends o {
        public f(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, 0, 59, true);
            r5.f = r6;
            r5.g = r6.length;
            return 16;
        }
    }

    public static class g extends o {
        public g(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, PluginList.LEVEL_NOT_SET, Integer.MAX_VALUE, true);
            r5.w = r6;
            r5.x = r6.length;
            return 4096;
        }
    }

    public static class h extends o {
        public h(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, -53, 53, false);
            r5.s = r6;
            r5.t = r6.length;
            return ChameleonContainerUtils.MAX_URL_LENGTH;
        }
    }

    public static class i extends o {
        public i(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int[] r6 = o.b(r4, -366, 366, false);
            r5.q = r6;
            r5.r = r6.length;
            return 512;
        }
    }

    public static class j extends o {
        public j(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int r0 = o.a(r4, PluginList.LEVEL_NOT_SET, Integer.MAX_VALUE, true);
            r5.c = r0;
            if (r0 >= 0) goto L7;
            Log.d(EventRecurrence.A, "Invalid Count. Forcing COUNT to 1 from ".concat(r4));
            r5.c = 1;
            return 4;
        L7:
            return 4;
        }
    }

    public static class k extends o {
        public k(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r2, EventRecurrence r3) {
            Integer r0 = EventRecurrence.y.get(r2);
            if (r0 == null) goto L7;
            r3.a = r0.intValue();
            return 1;
        L7:
            throw new InvalidFormatException("Invalid FREQ value: ".concat(r2));
        }
    }

    public static class l extends o {
        public l(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r4, EventRecurrence r5) {
            int r0 = o.a(r4, PluginList.LEVEL_NOT_SET, Integer.MAX_VALUE, true);
            r5.d = r0;
            if (r0 >= 1) goto L7;
            Log.d(EventRecurrence.A, "Invalid Interval. Forcing INTERVAL to 1 from ".concat(r4));
            r5.d = 1;
            return 8;
        L7:
            return 8;
        }
    }

    public static class m extends o {
        public m(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r1, EventRecurrence r2) {
            r2.b = r1;
            return 2;
        }
    }

    public static class n extends o {
        public n(int r1) {
        }

        @Override // com.ss.android.lark.custom.repeat.entity.EventRecurrence.o
        public final int c(String r2, EventRecurrence r3) {
            Integer r0 = EventRecurrence.z.get(r2);
            if (r0 == null) goto L7;
            r3.e = r0.intValue();
            return 8192;
        L7:
            throw new InvalidFormatException("Invalid WKST value: ".concat(r2));
        }
    }

    public static abstract class o {
        public o() {
        }

        public abstract int c(String r1, EventRecurrence r2);

        public static int a(String r3, int r4, int r5, boolean r6) {
            if (r3.charAt(0) != '+') goto L6;
            r3 = r3.substring(1);     // Catch: NumberFormatException -> L14
        L6:
            int r1 = CastIntegerProtector.parseInt(r3);     // Catch: NumberFormatException -> L14
            if (r1 < r4) goto L13;
            if (r1 > r5) goto L13;
            if (r1 != 0) goto L11;
            if (r6 == false) goto L13;
        L11:
            return r1;
        L13:
            throw new InvalidFormatException("Integer value out of range: " + r3);     // Catch: NumberFormatException -> L14
        L15:
            throw new InvalidFormatException("Invalid integer value: " + r3);
        }

        public static int[] b(String r4, int r5, int r6, boolean r7) {
            int r2 = 0;
            if (r4.indexOf(",") < 0) goto L11;
            String[] r8 = r4.split(",");
            int r0 = r8.length;
            int[] r1 = new int[r0];
        L6:
            if (r2 >= r0) goto L9;
            r1[r2] = a(r8[r2], r5, r6, r7);
            r2 = r2 + 1;
            goto L6
        L9:
            return r1;
        L11:
            return new int[]{a(r4, r5, r6, r7)};
        }
    }

    public EventRecurrence() {
    }

    static {
        HashMap<String, Integer> r0 = new HashMap();
        y = r0;
        HashMap<String, Integer> r1 = new HashMap();
        z = r1;
        A = "EventRecur";
        HashMap<String, o> r2 = new HashMap();
        B = r2;
        r2.put("FREQ", new k(0));
        r2.put("UNTIL", new m(0));
        r2.put("COUNT", new j(0));
        r2.put("INTERVAL", new l(0));
        r2.put("BYSECOND", new f(0));
        r2.put("BYMINUTE", new c(0));
        r2.put("BYHOUR", new b(0));
        r2.put("BYDAY", new a(0));
        r2.put("BYMONTHDAY", new e(0));
        r2.put("BYYEARDAY", new i(0));
        r2.put("BYWEEKNO", new h(0));
        r2.put("BYMONTH", new d(0));
        r2.put("BYSETPOS", new g(0));
        r2.put("WKST", new n(0));
        r0.put("SECONDLY", 1);
        r0.put("MINUTELY", 2);
        r0.put("HOURLY", 3);
        r0.put("DAILY", 4);
        r0.put("WEEKLY", 5);
        r0.put("MONTHLY", 6);
        r0.put("YEARLY", 7);
        r1.put("SU", 65536);
        r1.put("MO", 131072);
        r1.put("TU", 262144);
        r1.put("WE", 524288);
        r1.put("TH", 1048576);
        r1.put("FR", Integer.valueOf(Bridge.TRANSFER_MAX_SIZE));
        r1.put("SA", 4194304);
    }

    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FREQ=");
        switch(this.a) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        r0.append("YEARLY");
        goto L13
    L6:
        r0.append("MONTHLY");
        goto L13
    L7:
        r0.append("WEEKLY");
        goto L13
    L8:
        r0.append("DAILY");
        goto L13
    L9:
        r0.append("HOURLY");
        goto L13
    L10:
        r0.append("MINUTELY");
        goto L13
    L11:
        r0.append("SECONDLY");
    L13:
        if (TextUtils.isEmpty(this.b) == true) goto L19;
        r0.append(";UNTIL=");
        if (TextUtils.isEmpty(null) == true) goto L17;
        r0.append(null);
        goto L19
    L17:
        r0.append(this.b);
    L19:
        if (this.c == 0) goto L22;
        r0.append(";COUNT=");
        r0.append(this.c);
    L22:
        if (this.d == 0) goto L25;
        r0.append(";INTERVAL=");
        r0.append(this.d);
    L25:
        if (this.e == 0) goto L27;
        r0.append(";WKST=");
        r0.append(c(this.e));
    L27:
        a(r0, ";BYSECOND=", this.g, this.f);
        a(r0, ";BYMINUTE=", this.i, this.h);
        a(r0, ";BYSECOND=", this.k, this.j);
        int r1 = this.n;
        if (r1 <= 0) goto L39;
        r0.append(";BYDAY=");
        int r2 = r1 - 1;
        int r3 = 0;
    L30:
        if (r3 >= r2) goto L35;
        int r4 = this.m[r3];
        if (r4 == 0) goto L34;
        r0.append(r4);
    L34:
        r0.append(c(this.l[r3]));
        r0.append(",");
        r3 = r3 + 1;
        goto L30
    L35:
        int r5 = this.m[r2];
        if (r5 == 0) goto L38;
        r0.append(r5);
    L38:
        r0.append(c(this.l[r2]));
    L39:
        a(r0, ";BYMONTHDAY=", this.p, this.o);
        a(r0, ";BYYEARDAY=", this.r, this.q);
        a(r0, ";BYWEEKNO=", this.t, this.s);
        a(r0, ";BYMONTH=", this.v, this.u);
        a(r0, ";BYSETPOS=", this.x, this.w);
        return r0.toString();
    }

    public static String c(int r3) {
        if (r3 != 65536) goto L5;
        return "SU";
    L5:
        if (r3 != 131072) goto L7;
        return "MO";
    L7:
        if (r3 != 262144) goto L9;
        return "TU";
    L9:
        if (r3 != 524288) goto L11;
        return "WE";
    L11:
        if (r3 != 1048576) goto L13;
        return "TH";
    L13:
        if (r3 != 2097152) goto L15;
        return "FR";
    L15:
        if (r3 != 4194304) goto L19;
        return "SA";
    L19:
        throw new IllegalArgumentException("bad day argument: " + r3);
    }

    public static EventRecurrence d(String r10) {
        EventRecurrence r0 = new EventRecurrence();
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r0;
    L5:
        r0.b = null;
        r0.x = 0;
        r0.v = 0;
        r0.t = 0;
        r0.r = 0;
        r0.p = 0;
        r0.n = 0;
        r0.k = 0;
        r0.i = 0;
        r0.g = 0;
        r0.d = 0;
        r0.c = 0;
        r0.a = 0;
        String[] r2 = r10.toUpperCase().split(";");
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r3) goto L32;
        String r6 = r2[r4];
        if (TextUtils.isEmpty(r6) == true) goto L24;
        int r7 = r6.indexOf(61);
        if (r7 <= 0) goto L30;
        String r8 = r6.substring(0, r7);
        String r9 = r6.substring(r7 + 1);
        if (r9.length() == 0) goto L28;
        o r11 = B.get(r8);
        if (r11 == null) goto L17;
        int r12 = r11.c(r9, r0);
        if ((r5 & r12) != 0) goto L26;
        r5 = r5 | r12;
        goto L24
    L26:
        throw new InvalidFormatException("Part " + r8 + " was specified twice");
    L17:
        if (r8.startsWith("X-") == true) goto L24;
        throw new InvalidFormatException("Couldn't find parser for ".concat(r8));
    L28:
        throw new InvalidFormatException("Missing RHS in ".concat(r6));
    L30:
        throw new InvalidFormatException("Missing LHS in ".concat(r6));
    L24:
        r4 = r4 + 1;
        goto L6
    L32:
        if ((r5 & 8192) != 0) goto L35;
        r0.e = 131072;
    L35:
        if ((r5 & 1) == 0) goto L41;
        if ((r5 & 6) != 6) goto L39;
        Log.w(A, "Warning: rrule has both UNTIL and COUNT: ".concat(r10));
    L39:
        return r0;
    L41:
        throw new InvalidFormatException("Must specify a FREQ value");
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof EventRecurrence) == true) goto L8;
        return false;
    L8:
        EventRecurrence r8 = (EventRecurrence) r7;
        r8.getClass();
        if (this.a != r8.a) goto L44;
        String r1 = this.b;
        if (r1 != null) goto L16;
        if (r8.b != null) goto L44;
    L18:
        if (this.c != r8.c) goto L44;
        if (this.d != r8.d) goto L44;
        if (this.e != r8.e) goto L44;
        if (b(this.f, this.g, r8.f, r8.g) == false) goto L44;
        if (b(this.h, this.i, r8.h, r8.i) == false) goto L44;
        if (b(this.j, this.k, r8.j, r8.k) == false) goto L44;
        if (b(this.l, this.n, r8.l, r8.n) == false) goto L44;
        if (b(this.m, this.n, r8.m, r8.n) == false) goto L44;
        if (b(this.o, this.p, r8.o, r8.p) == false) goto L44;
        if (b(this.q, this.r, r8.q, r8.r) == false) goto L44;
        if (b(this.s, this.t, r8.s, r8.t) == false) goto L44;
        if (b(this.u, this.v, r8.u, r8.v) == false) goto L44;
        if (b(this.w, this.x, r8.w, r8.x) == false) goto L44;
        return true;
    L16:
        if (r1.equals(r8.b) == true) goto L18;
    L44:
        return false;
    }

    public static void a(StringBuilder r1, String r2, int r3, int[] r4) {
        if (r3 <= 0) goto L9;
        r1.append(r2);
        int r5 = r3 - 1;
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L6;
        r1.append(r4[r6]);
        r1.append(",");
        r6 = r6 + 1;
        goto L4
    L6:
        r1.append(r4[r5]);
        return;
    }

    public static boolean b(int[] r3, int r4, int[] r5, int r6) {
        if (r4 == r6) goto L5;
        return false;
    L5:
        int r7 = 0;
    L6:
        if (r7 >= r4) goto L11;
        if (r3[r7] != r5[r7]) goto L9;
        r7 = r7 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
