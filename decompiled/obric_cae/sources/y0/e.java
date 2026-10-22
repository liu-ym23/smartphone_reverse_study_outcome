package y0;

import android.database.Cursor;
import androidx.room.g;
import com.obric.cae.location.database.StarCellDbManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import ne.j;
import yd.l;
import zd.f;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f13906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<b> f13907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<d> f13908d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f13910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f13911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f13913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f13914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f13915g;

        /* JADX INFO: renamed from: y0.e$a$a, reason: collision with other inner class name */
        public static final class C0196a {
            public static boolean a(String r8, String r10) {
                i.f(r8, "current");
                if (i.a(r8, r10) == false) goto L6;
                return true;
            L6:
                if (r8.length() != 0) goto L8;
                boolean r11 = true;
            L9:
                if (r11 == true) goto L30;
                int r12 = 0;
                int r13 = 0;
                int r14 = 0;
            L13:
                if (r12 >= r8.length()) goto L28;
                char r15 = r8.charAt(r12);
                int r16 = r14 + 1;
                if (r14 != 0) goto L18;
                if (r15 != '(') goto L30;
            L18:
                if (r15 != '(') goto L21;
                r13 = r13 + 1;
            L27:
                r12 = r12 + 1;
                r14 = r16;
                goto L13
            L21:
                if (r15 != ')') goto L27;
                r13 = r13 - 1;
                if (r13 != 0) goto L27;
                if (r14 == (r8.length() - 1)) goto L27;
            L28:
                if (r13 != 0) goto L30;
                boolean r17 = true;
            L31:
                if (r17 == false) goto L34;
                String r18 = r8.substring(1, r8.length() - 1);
                i.e(r18, "this as java.lang.String…ing(startIndex, endIndex)");
                return i.a(j.H0(r18).toString(), r10);
            L34:
                return false;
            L30:
                r17 = false;
                goto L31
            L8:
                r11 = false;
                goto L9
            }
        }

        public a(String r8, String r10, boolean r11, int r12, String r13, int r14) {
            this.f13909a = r8;
            this.f13910b = r10;
            this.f13911c = r11;
            this.f13912d = r12;
            this.f13913e = r13;
            this.f13914f = r14;
            Locale r15 = Locale.US;
            i.e(r15, "US");
            String r16 = r10.toUpperCase(r15);
            i.e(r16, "this as java.lang.String).toUpperCase(locale)");
            if (j.w0(r16, "INT") == false) goto L6;
            int r17 = 3;
        L25:
            this.f13915g = r17;
            return;
        L6:
            if (j.w0(r16, "CHAR") == false) goto L8;
        L24:
            r17 = 2;
            goto L25
        L8:
            if (j.w0(r16, "CLOB") == true) goto L24;
            if (j.w0(r16, "TEXT") == true) goto L24;
            if (j.w0(r16, "BLOB") == false) goto L16;
            r17 = 5;
            goto L25
        L16:
            if (j.w0(r16, "REAL") == false) goto L18;
        L23:
            r17 = 4;
            goto L25
        L18:
            if (j.w0(r16, "FLOA") == true) goto L23;
            if (j.w0(r16, "DOUB") == true) goto L23;
            r17 = 1;
            goto L25
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f13912d == r11.f13912d) goto L12;
            return false;
        L12:
            if (i.a(this.f13909a, r11.f13909a) == true) goto L15;
            return false;
        L15:
            if (this.f13911c == r11.f13911c) goto L17;
            return false;
        L17:
            String r8 = r11.f13913e;
            int r12 = r11.f13914f;
            String r13 = this.f13913e;
            int r14 = this.f13914f;
            if (r14 != 1) goto L24;
            if (r12 != 2) goto L24;
            if (r13 == null) goto L24;
            if (C0196a.a(r13, r8) == true) goto L24;
            return false;
        L24:
            if (r14 != 2) goto L30;
            if (r12 != 1) goto L30;
            if (r8 == null) goto L30;
            if (C0196a.a(r8, r13) == true) goto L30;
            return false;
        L30:
            if (r14 == 0) goto L42;
            if (r14 != r12) goto L42;
            if (r13 != null) goto L34;
            if (r8 == null) goto L38;
        L37:
            boolean r15 = true;
        L39:
            if (r15 == false) goto L42;
            return false;
        L38:
            r15 = false;
            goto L39
        L34:
            if (C0196a.a(r13, r8) == true) goto L38;
        L42:
            if (this.f13915g != r11.f13915g) goto L45;
            return true;
        L45:
            return false;
        }

        public final int hashCode() {
            int r8 = ((this.f13909a.hashCode() * 31) + this.f13915g) * 31;
            if (this.f13911c == false) goto L5;
            int r10 = 1231;
        L7:
            return ((r8 + r10) * 31) + this.f13912d;
        L5:
            r10 = 1237;
            goto L7
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("Column{name='");
            r8.append(this.f13909a);
            r8.append("', type='");
            r8.append(this.f13910b);
            r8.append("', affinity='");
            r8.append(this.f13915g);
            r8.append("', notNull=");
            r8.append(this.f13911c);
            r8.append(", primaryKeyPosition=");
            r8.append(this.f13912d);
            r8.append(", defaultValue='");
            String r10 = this.f13913e;
            if (r10 != null) goto L6;
            r10 = "undefined";
        L6:
            return android.aimedia.a.i(r8, r10, "'}");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f13917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f13918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f13919d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f13920e;

        public b(String r8, String r10, String r11, List<String> r12, List<String> r13) {
            i.f(r12, "columnNames");
            i.f(r13, "referenceColumnNames");
            this.f13916a = r8;
            this.f13917b = r10;
            this.f13918c = r11;
            this.f13919d = r12;
            this.f13920e = r13;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r10 = (b) r8;
            String r11 = r10.f13916a;
            if (i.a(this.f13916a, r11) == true) goto L12;
            return false;
        L12:
            if (i.a(this.f13917b, r10.f13917b) == true) goto L15;
            return false;
        L15:
            if (i.a(this.f13918c, r10.f13918c) == true) goto L18;
            return false;
        L18:
            if (i.a(this.f13919d, r10.f13919d) == true) goto L21;
            return false;
        L21:
            return i.a(this.f13920e, r10.f13920e);
        }

        public final int hashCode() {
            int r8 = this.f13916a.hashCode() * 31;
            int r10 = defpackage.a.b(this.f13917b, r8, 31);
            int r11 = defpackage.a.b(this.f13918c, r10, 31);
            int r12 = (this.f13919d.hashCode() + r11) * 31;
            return this.f13920e.hashCode() + r12;
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.f13916a + "', onDelete='" + this.f13917b + " +', onUpdate='" + this.f13918c + "', columnNames=" + this.f13919d + ", referenceColumnNames=" + this.f13920e + '}';
        }
    }

    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13922b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f13923m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f13924n;

        public c(int r8, int r10, String r11, String r12) {
            this.f13921a = r8;
            this.f13922b = r10;
            this.f13923m = r11;
            this.f13924n = r12;
        }

        @Override // java.lang.Comparable
        public final int compareTo(c r8) {
            c r10 = r8;
            i.f(r10, "other");
            int r11 = this.f13921a - r10.f13921a;
            if (r11 == 0) goto L5;
            return r11;
        L5:
            return this.f13922b - r10.f13922b;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f13927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f13928d;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public d(String r8, boolean r10, List<String> r11, List<String> r12) {
            i.f(r11, "columns");
            i.f(r12, "orders");
            this.f13925a = r8;
            this.f13926b = r10;
            this.f13927c = r11;
            this.f13928d = r12;
            if (r12.isEmpty() == false) goto L7;
            int r13 = r11.size();
            r12 = new ArrayList(r13);
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L7;
            g[] r15 = g.f2619a;
            r12.add("ASC");
            r14 = r14 + 1;
        L7:
            this.f13928d = r12;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L8;
            return false;
        L8:
            d r10 = (d) r8;
            boolean r11 = r10.f13926b;
            if (this.f13926b == r11) goto L12;
            return false;
        L12:
            if (i.a(this.f13927c, r10.f13927c) == true) goto L15;
            return false;
        L15:
            if (i.a(this.f13928d, r10.f13928d) == true) goto L17;
            return false;
        L17:
            String r12 = this.f13925a;
            boolean r13 = ne.g.v0(r12, "index_");
            String r14 = r10.f13925a;
            if (r13 == false) goto L21;
            return ne.g.v0(r14, "index_");
        L21:
            return i.a(r12, r14);
        }

        public final int hashCode() {
            String r8 = this.f13925a;
            if (ne.g.v0(r8, "index_") == false) goto L5;
            int r10 = -1184239155;
        L6:
            int r11 = ((r10 * 31) + (this.f13926b ? 1 : 0)) * 31;
            int r12 = (this.f13927c.hashCode() + r11) * 31;
            return this.f13928d.hashCode() + r12;
        L5:
            r10 = r8.hashCode();
            goto L6
        }

        public final String toString() {
            return "Index{name='" + this.f13925a + "', unique=" + this.f13926b + ", columns=" + this.f13927c + ", orders=" + this.f13928d + "'}";
        }
    }

    public e(String r8, Map r10, AbstractSet r11, AbstractSet r12) {
        this.f13905a = r8;
        this.f13906b = r10;
        this.f13907c = r11;
        this.f13908d = r12;
    }

    public static final e a(a1.b r30, String r31) {
        a1.b r8 = r30;
        i.f(r8, "database");
        StringBuilder r10 = new StringBuilder("PRAGMA table_info(`");
        r10.append(r31);
        String r11 = "`)";
        r10.append("`)");
        Cursor r12 = r8.a0(r10.toString());
        int r13 = r12.getColumnCount();     // Catch: Throwable -> L118
        String r14 = QesdkUtils.TAGS.JSON_TAG_NAME;
        if (r13 > 0) goto L7;
        Map r15 = l.f14120a;     // Catch: Throwable -> L118
    L17:
        defpackage.c.A(r12, null);
        Cursor r16 = r8.a0("PRAGMA foreign_key_list(`" + r31 + "`)");
        int r17 = r16.getColumnIndex("id");     // Catch: Throwable -> L112
        int r18 = r16.getColumnIndex("seq");     // Catch: Throwable -> L112
        int r19 = r16.getColumnIndex("table");     // Catch: Throwable -> L112
        int r110 = r16.getColumnIndex("on_delete");     // Catch: Throwable -> L112
        int r111 = r16.getColumnIndex("on_update");     // Catch: Throwable -> L112
        int r20 = r16.getColumnIndex("id");     // Catch: Throwable -> L112
        int r21 = r16.getColumnIndex("seq");     // Catch: Throwable -> L112
        int r112 = r16.getColumnIndex("from");     // Catch: Throwable -> L112
        int r113 = r16.getColumnIndex("to");     // Catch: Throwable -> L112
        zd.a r22 = new zd.a();     // Catch: Throwable -> L112
    L20:
        if (r16.moveToNext() == false) goto L22;
        String r114 = r14;
        int r23 = r16.getInt(r20);     // Catch: Throwable -> L112
        int r24 = r20;
        int r25 = r16.getInt(r21);     // Catch: Throwable -> L112
        int r26 = r21;
        String r27 = r16.getString(r112);     // Catch: Throwable -> L112
        int r28 = r112;
        i.e(r27, "cursor.getString(fromColumnIndex)");     // Catch: Throwable -> L112
        String r115 = r16.getString(r113);     // Catch: Throwable -> L112
        i.e(r115, "cursor.getString(toColumnIndex)");     // Catch: Throwable -> L112
        r22.add(new c(r23, r25, r27, r115));     // Catch: Throwable -> L112
        r15 = r15;
        r14 = r114;
        r20 = r24;
        r21 = r26;
        r112 = r28;
        r113 = r113;
        goto L20
    L22:
        Map r116 = r15;
        String r117 = r14;
        l6.a.q(r22);     // Catch: Throwable -> L112
        if (r22.a() > 1) goto L25;
        List r29 = yd.i.n1(r22);     // Catch: Throwable -> L112
    L29:
        r16.moveToPosition(-1);     // Catch: Throwable -> L112
        f r32 = new f();     // Catch: Throwable -> L112
    L31:
        if (r16.moveToNext() == false) goto L50;
        if (r16.getInt(r18) != 0) goto L31;
        int r33 = r16.getInt(r17);     // Catch: Throwable -> L112
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L112
        ArrayList r119 = new ArrayList();     // Catch: Throwable -> L112
        ArrayList r34 = new ArrayList();     // Catch: Throwable -> L112
        Iterator r210 = r29.iterator();     // Catch: Throwable -> L112
    L37:
        if (r210.hasNext() == false) goto L45;
        Object r35 = r210.next();     // Catch: Throwable -> L112
        List r211 = r29;
        if (((c) r35).f13921a != r33) goto L41;
        boolean r36 = true;
    L42:
        if (r36 == false) goto L44;
        r34.add(r35);     // Catch: Throwable -> L112
    L44:
        r29 = r211;
        goto L37
    L41:
        r36 = false;
        goto L42
    L45:
        List r212 = r29;
        Iterator r37 = r34.iterator();     // Catch: Throwable -> L112
    L47:
        if (r37.hasNext() == false) goto L49;
        c r38 = (c) r37.next();     // Catch: Throwable -> L112
        r118.add(r38.f13923m);     // Catch: Throwable -> L112
        r119.add(r38.f13924n);     // Catch: Throwable -> L112
        goto L47
    L49:
        String r39 = r16.getString(r19);     // Catch: Throwable -> L112
        i.e(r39, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L112
        String r40 = r16.getString(r110);     // Catch: Throwable -> L112
        i.e(r40, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L112
        String r41 = r16.getString(r111);     // Catch: Throwable -> L112
        i.e(r41, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L112
        r32.add(new b(r39, r40, r41, r118, r119));     // Catch: Throwable -> L112
        r17 = r17;
        r29 = r212;
        goto L31
    L50:
        l6.a.r(r32);     // Catch: Throwable -> L112
        defpackage.c.A(r16, null);
        Cursor r42 = r8.a0("PRAGMA index_list(`" + r31 + "`)");
        String r43 = r117;
        int r44 = r42.getColumnIndex(r43);     // Catch: Throwable -> L106
        int r45 = r42.getColumnIndex("origin");     // Catch: Throwable -> L106
        int r46 = r42.getColumnIndex("unique");     // Catch: Throwable -> L106
        if (r44 == (-1)) goto L103;
        if (r45 == (-1)) goto L103;
        if (r46 == (-1)) goto L103;
        f r47 = new f();     // Catch: Throwable -> L106
    L59:
        if (r42.moveToNext() == false) goto L101;
        if (i.a("c", r42.getString(r45)) == false) goto L59;
        String r120 = r42.getString(r44);     // Catch: Throwable -> L106
        if (r42.getInt(r46) != 1) goto L66;
        boolean r121 = true;
    L67:
        i.e(r120, r43);     // Catch: Throwable -> L106
        Cursor r122 = r8.a0("PRAGMA index_xinfo(`" + r120 + r11);     // Catch: Throwable -> L106
        int r123 = r122.getColumnIndex("seqno");     // Catch: Throwable -> L94
        int r124 = r122.getColumnIndex(StarCellDbManager.CellInfoEntry.CID);     // Catch: Throwable -> L94
        int r125 = r122.getColumnIndex(r43);     // Catch: Throwable -> L94
        int r48 = r122.getColumnIndex("desc");     // Catch: Throwable -> L94
        String r126 = r43;
        if (r123 == (-1)) goto L88;
        if (r124 == (-1)) goto L88;
        if (r125 == (-1)) goto L88;
        if (r48 == (-1)) goto L88;
        TreeMap r49 = new TreeMap();     // Catch: Throwable -> L94
        TreeMap r50 = new TreeMap();     // Catch: Throwable -> L94
    L76:
        if (r122.moveToNext() == false) goto L85;
        if (r122.getInt(r124) < 0) goto L76;
        int r213 = r122.getInt(r123);     // Catch: Throwable -> L94
        int r214 = r45;
        String r51 = r122.getString(r125);     // Catch: Throwable -> L94
        if (r122.getInt(r48) <= 0) goto L83;
        String r215 = "DESC";
    L84:
        int r216 = r48;
        String r52 = r215;
        String r217 = r11;
        Integer r53 = Integer.valueOf(r213);     // Catch: Throwable -> L94
        i.e(r51, "columnName");     // Catch: Throwable -> L94
        r49.put(r53, r51);     // Catch: Throwable -> L94
        r50.put(Integer.valueOf(r213), r52);     // Catch: Throwable -> L94
        r45 = r214;
        r11 = r217;
        r48 = r216;
        r46 = r46;
        goto L76
    L83:
        r215 = "ASC";
        goto L84
    L85:
        int r218 = r45;
        String r219 = r11;
        int r220 = r46;
        Collection r54 = r49.values();     // Catch: Throwable -> L94
        i.e(r54, "columnsMap.values");     // Catch: Throwable -> L94
        List r55 = yd.i.n1(r54);     // Catch: Throwable -> L94
        Collection r56 = r50.values();     // Catch: Throwable -> L94
        i.e(r56, "ordersMap.values");     // Catch: Throwable -> L94
        d r57 = new d(r120, r121, r55, yd.i.n1(r56));     // Catch: Throwable -> L94
        defpackage.c.A(r122, null);     // Catch: Throwable -> L106
        Throwable r58 = null;
    L90:
        if (r57 == null) goto L91;
        r47.add(r57);     // Catch: Throwable -> L106
        r8 = r30;
        r43 = r126;
        r44 = r44;
        r45 = r218;
        r11 = r219;
        r46 = r220;
        goto L59
    L91:
        defpackage.c.A(r42, r58);
        f r59 = null;
    L105:
        return new e(r31, r116, r32, r59);
    L88:
        r218 = r45;
        r219 = r11;
        r220 = r46;
        r58 = null;
        defpackage.c.A(r122, null);     // Catch: Throwable -> L106
        r57 = null;
        goto L90
    L94:
        th = move-exception;
        throw th;     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        defpackage.c.A(r122, th);     // Catch: Throwable -> L106
        throw th;     // Catch: Throwable -> L106
    L66:
        r121 = false;
        goto L67
    L101:
        l6.a.r(r47);     // Catch: Throwable -> L106
        defpackage.c.A(r42, null);
        r59 = r47;
    L103:
        r59 = null;
        defpackage.c.A(r42, null);
    L106:
        th = move-exception;
        throw th;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        defpackage.c.A(r42, th);
        throw th;
    L25:
        Object[] r60 = r22.toArray(new Comparable[0]);     // Catch: Throwable -> L112
        Comparable[] r61 = (Comparable[]) r60;     // Catch: Throwable -> L112
        if (r61.length <= 1) goto L28;
        Arrays.sort(r61);     // Catch: Throwable -> L112
    L28:
        r29 = yd.e.r0(r60);     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        throw th;     // Catch: Throwable -> L115
    L115:
        th = move-exception;
        defpackage.c.A(r16, th);
        throw th;
    L7:
        int r62 = r12.getColumnIndex(QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: Throwable -> L118
        int r127 = r12.getColumnIndex("type");     // Catch: Throwable -> L118
        int r128 = r12.getColumnIndex("notnull");     // Catch: Throwable -> L118
        int r129 = r12.getColumnIndex("pk");     // Catch: Throwable -> L118
        int r130 = r12.getColumnIndex("dflt_value");     // Catch: Throwable -> L118
        zd.b r131 = new zd.b();     // Catch: Throwable -> L118
    L9:
        if (r12.moveToNext() == false) goto L15;
        String r63 = r12.getString(r62);     // Catch: Throwable -> L118
        String r132 = r12.getString(r127);     // Catch: Throwable -> L118
        if (r12.getInt(r128) == 0) goto L13;
        boolean r221 = true;
    L14:
        int r222 = r12.getInt(r129);     // Catch: Throwable -> L118
        String r223 = r12.getString(r130);     // Catch: Throwable -> L118
        i.e(r63, QesdkUtils.TAGS.JSON_TAG_NAME);     // Catch: Throwable -> L118
        i.e(r132, "type");     // Catch: Throwable -> L118
        r131.put(r63, new a(r63, r132, r221, r222, r223, 2));     // Catch: Throwable -> L118
        r62 = r62;
        goto L9
    L13:
        r221 = false;
        goto L14
    L15:
        r131.c();     // Catch: Throwable -> L118
        r131.f14357v = true;     // Catch: Throwable -> L118
        r15 = r131;
    L118:
        th = move-exception;
        throw th;     // Catch: Throwable -> L121
    L121:
        th = move-exception;
        defpackage.c.A(r12, th);
        throw th;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r8;
        String r11 = r10.f13905a;
        if (i.a(this.f13905a, r11) == true) goto L12;
        return false;
    L12:
        if (i.a(this.f13906b, r10.f13906b) == true) goto L15;
        return false;
    L15:
        if (i.a(this.f13907c, r10.f13907c) == true) goto L17;
        return false;
    L17:
        Set<d> r12 = this.f13908d;
        if (r12 == null) goto L24;
        Set<d> r13 = r10.f13908d;
        if (r13 != null) goto L23;
        return true;
    L23:
        return i.a(r12, r13);
    L24:
        return true;
    }

    public final int hashCode() {
        int r8 = this.f13905a.hashCode() * 31;
        int r10 = (this.f13906b.hashCode() + r8) * 31;
        return this.f13907c.hashCode() + r10;
    }

    public final String toString() {
        return "TableInfo{name='" + this.f13905a + "', columns=" + this.f13906b + ", foreignKeys=" + this.f13907c + ", indices=" + this.f13908d + '}';
    }
}
