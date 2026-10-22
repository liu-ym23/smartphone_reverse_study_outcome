package y3;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import c4.l;
import c4.m;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import i4.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<String> f13964k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f13965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, u4.b> f13966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m4.b f13967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13969j;

    static {
        f13964k = Collections.singletonList("Sender");
    }

    public i(c r8) {
        super(r8);
        this.f13965f = new long[]{10000};
        this.f13966g = new ConcurrentHashMap();
        this.f13969j = 0;
        this.f13967h = null;
        this.f13968i = "Sender";
    }

    public static void i(r3.c r8, r4.i r10, boolean r11) {
        boolean r12 = r8.f11417y.f();
        i4.f r13 = r8.f11417y;
        if (r12 == false) goto L12;
        Iterator r14 = r10.s().iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        i4.i r15 = (i4.i) r14.next();
        if (r11 == false) goto L10;
        i4.a r16 = i4.a.J;
    L11:
        l6.a.O0(r13, r16, r15);
        goto L6
    L10:
        r16 = i4.a.I;
    L12:
        int r17 = r10.f11487f0;
        if (r17 <= 0) goto L18;
        if (r11 == false) goto L16;
        k r18 = k.f8266r;
    L17:
        r13.b(r18, r17);
        goto L18
    L16:
        r18 = k.f8267s;
    L18:
        int r19 = r10.f11488g0;
        if (r19 <= 0) goto L24;
        if (r11 == false) goto L22;
        k r20 = k.f8268t;
    L23:
        r13.b(r20, r19);
        goto L24
    L22:
        r20 = k.f8269u;
    L24:
        int r21 = (r10.f11489h0 + r10.f11490i0) + r10.f11491j0;
        if (r21 <= 0) goto L31;
        if (r11 == false) goto L28;
        k r22 = k.f8264p;
    L29:
        r13.b(r22, r21);
        goto L31
    L28:
        r22 = k.f8265q;
    L31:
        if (l.b() == true) goto L43;
        String r23 = r8.f11401i;
        HashSet r24 = r10.r();
        if (r24.isEmpty() == false) goto L36;
        return;
    L36:
        if (l.b() == true) goto L45;
        l.c("event_upload_eid", new h(r23, r24, r11));
        return;
    L45:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // y3.a
    public final synchronized boolean c(int r28) {
        int r8 = r28;
        monitor-enter(this);
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L172
        c r11 = this.f13930a;     // Catch: Throwable -> L172
        j r12 = r11.f13945u;     // Catch: Throwable -> L172
        m r13 = r11.f13937m.H;     // Catch: Throwable -> L172
        List<String> r14 = f13964k;     // Catch: Throwable -> L172
        Object[] r15 = new Object[4];     // Catch: Throwable -> L172
        boolean r16 = 0;
        int r17 = 0;
        r15[0] = this.f13968i;     // Catch: Throwable -> L172
        int r18 = 1;
        r15[1] = Long.valueOf(r10);     // Catch: Throwable -> L172
        if (r12 == null) goto L7;
        String r19 = r12.f13979e;     // Catch: Throwable -> L172
    L8:
        r15[2] = r19;     // Catch: Throwable -> L172
        r15[3] = Integer.valueOf(r28);     // Catch: Throwable -> L172
        r13.l(0, r14, "{} start doWork curTs={}, curSid={}, requestFrom={}", r15);     // Catch: Throwable -> L172
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L172
        this.f13930a.E.getClass();     // Catch: Throwable -> L172
        if (r12 == null) goto L17;
        monitor-enter(r12);     // Catch: Throwable -> L172
        r12.f13976b.f13938n.f6758b.getClass();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L172
        goto L17
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L172
    L17:
        r4.b r20 = this.f13930a.b();     // Catch: Throwable -> L172
        d4.d r21 = this.f13930a.f13942r;     // Catch: Throwable -> L172
        Cursor r22 = null;
        if (r21.f6776c == false) goto L168;
        JSONObject r23 = r21.a();     // Catch: Throwable -> L172
        defpackage.c.n0(r23);     // Catch: Throwable -> L172
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L172
        m4.b r24 = this.f13967h;     // Catch: Throwable -> L172
        if (r24 == null) goto L22;
        r24.getClass();     // Catch: Throwable -> L172
        r20.o(r23, r24, r8);     // Catch: Throwable -> L172
    L23:
        r4.b r25 = this.f13930a.b();     // Catch: Throwable -> L172
        int r26 = this.f13930a.f13937m.f11415w;     // Catch: Throwable -> L172
        if (r8 != 4) goto L26;
        r26 = 8;
    L30:
        ArrayList r27 = new ArrayList();     // Catch: Throwable -> L172
        ArrayList r29 = new ArrayList();     // Catch: Throwable -> L172
        ArrayList r30 = new ArrayList();     // Catch: Throwable -> L172
        m4.b r31 = this.f13967h;     // Catch: Throwable -> L172
        c r110 = r25.f11465a;     // Catch: Throwable -> L172
        r4.i r111 = (r4.i) r25.f11467c.get("pack");     // Catch: Throwable -> L172
        r22 = r25.f11466b.getWritableDatabase().rawQuery(r4.b.C(r26, r31), null);     // Catch: Throwable -> L38
        ArrayList r32 = new ArrayList();     // Catch: Throwable -> L38
    L33:
        if (r22.moveToNext() == false) goto L36;
        r111 = (r4.i) r111.a();     // Catch: Throwable -> L38
        r111.j(r22);     // Catch: Throwable -> L38
        r32.add(r111);     // Catch: Throwable -> L38
    L36:
        r22.close();     // Catch: Throwable -> L172
    L45:
        c r33 = this.f13930a;     // Catch: Throwable -> L172
        r33.f13937m.getClass();     // Catch: Throwable -> L172
        r33.f13937m.getClass();     // Catch: Throwable -> L172
        Iterator r34 = r32.iterator();     // Catch: Throwable -> L172
    L47:
        if (r34.hasNext() == false) goto L61;
        r4.i r35 = (r4.i) r34.next();     // Catch: Throwable -> L172
        r33.f13937m.getClass();     // Catch: Throwable -> L172
        if (r35.f11487f0 <= 0) goto L51;
        Object[] r36 = true;
    L52:
        if (r36 == true) goto L53;
        if (r35.f11488g0 <= 0) goto L57;
        Object[] r37 = true;
    L58:
        if (r37 == true) goto L59;
        r27.add(r35);     // Catch: Throwable -> L172
        goto L47
    L59:
        r30.add(r35);     // Catch: Throwable -> L172
        goto L47
    L57:
        r37 = false;
        goto L58
    L53:
        r29.add(r35);     // Catch: Throwable -> L172
        goto L47
    L51:
        r36 = false;
        goto L52
    L61:
        r33.f13937m.getClass();     // Catch: Throwable -> L172
        if (r30.isEmpty() == true) goto L65;
        r29.addAll(r30);     // Catch: Throwable -> L172
    L65:
        if (r29.isEmpty() == false) goto L67;
    L74:
        r27.size();     // Catch: Throwable -> L172
        if (r27.isEmpty() == true) goto L163;
        c r38 = this.f13930a;     // Catch: Throwable -> L172
        d4.c r39 = r38.f13938n;     // Catch: Throwable -> L172
        String[] r40 = r38.f13937m.f11396d.d(r38, false, this.f13967h);     // Catch: Throwable -> L172
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L172
        c.d r41 = new c.d();     // Catch: Throwable -> L172
        Iterator r42 = r27.iterator();     // Catch: Throwable -> L172
    L78:
        if (r42.hasNext() == false) goto L163;
        r4.i r43 = (r4.i) r42.next();     // Catch: Throwable -> L172
        c r44 = this.f13930a;     // Catch: Throwable -> L172
        m r45 = r44.f13937m.H;     // Catch: Throwable -> L172
        String r112 = this.f13968i;     // Catch: Throwable -> L172
        List<String> r113 = f13964k;     // Catch: Throwable -> L172
        r45.l(r17, r113, "{} work start send pack...", new Object[]{r112});     // Catch: Throwable -> L172
        r44.E.getClass();     // Catch: Throwable -> L172
        HashMap r46 = new HashMap();     // Catch: Throwable -> L172
        r44.d().getClass();     // Catch: Throwable -> L172
        byte[] r114 = r43.H;     // Catch: Throwable -> L172
        r3.c r115 = r44.f13937m;     // Catch: Throwable -> L172
        if (r114 == null) goto L161;
        if (r114.length == 0) goto L161;
        m4.b r116 = this.f13967h;     // Catch: Throwable -> L172
        if (r116 == null) goto L87;
        u4.a r117 = null;
        r116.getClass();     // Catch: Throwable -> L172
    L88:
        if (r117 != null) goto L90;
    L92:
        r115.getClass();     // Catch: Throwable -> L172
        r115.H.l(r17, r113, "{} send pack start: {}", new Object[]{r112, r43});     // Catch: Throwable -> L172
        if (r115.f11417y.f() == false) goto L98;
        Iterator r47 = r43.s().iterator();     // Catch: Throwable -> L172
    L96:
        if (r47.hasNext() == false) goto L98;
        l6.a.O0(r115.f11417y, i4.a.H, (i4.i) r47.next());     // Catch: Throwable -> L172
    L98:
        int r48 = r40.length;     // Catch: Throwable -> L172
        int r49 = 0;
        int r118 = 0;
    L99:
        if (r49 >= r48) goto L139;
        String r119 = r40[r49];     // Catch: Throwable -> L172
        if (v4.i.g(r119) == false) goto L103;
        r40 = r40;
        int r210 = r48;
        r39 = r39;
        r42 = r42;
        c.d r211 = r41;
        int r120 = r118;
        m4.b r121 = r116;
    L111:
        boolean r50 = false;
    L112:
        if (r50 == true) goto L114;
        r115.f11417y.b(k.L, 1);     // Catch: Throwable -> L172
        r115.H.f(0, r113, "{} CongestionController not allowed uri:{} to send pack: {}", new Object[]{r112, r119, r43});     // Catch: Throwable -> L172
        boolean r212 = r50;
        r46 = r46;
        r3.c r51 = r115;
        List<String> r52 = r113;
        r118 = r120;
        m4.b r53 = r121;
        r44 = r44;
    L138:
        r49 = r49 + 1;     // Catch: Throwable -> L172
        r115 = r51;
        r116 = r53;
        r113 = r52;
        r44 = r44;
        r46 = r46;
        r40 = r40;
        r48 = r210;
        r39 = r39;
        r41 = r211;
        r42 = r42;
        goto L99
    L114:
        r115.H.l(0, r113, "{} send pack:{} to uri: {}", new Object[]{r112, r43, r119});     // Catch: Throwable -> L172
        r53 = r121;
        r212 = r50;
        r51 = r115;
        r52 = r113;
        int r54 = r44.f13937m.f11397e.f(new String[]{r119}, r43.H, r44, new String[]{r43.U, r43.V}, r43.X, r43.Y, r46, true);     // Catch: Throwable -> L172
        if (r54 >= 500) goto L117;
    L119:
        boolean r55 = false;
    L121:
        if (r55 == false) goto L127;
        u4.b r56 = h(r119);     // Catch: Throwable -> L172
        r56.f12466b.f6758b.getClass();     // Catch: Throwable -> L172
        if (r56.f12467c >= (r56.f12473i.length - 1)) goto L125;
        long r122 = System.currentTimeMillis();     // Catch: Throwable -> L172
        r56.f12467c++;     // Catch: Throwable -> L172
        r56.f12468d = 1;     // Catch: Throwable -> L172
        r56.f12469e = 1.0f;     // Catch: Throwable -> L172
        r56.f12470f = 0;     // Catch: Throwable -> L172
        r56.f12471g = r122;     // Catch: Throwable -> L172
        r56.f12472h = r122;     // Catch: Throwable -> L172
        SharedPreferences.Editor r57 = r56.f12466b.f6761e.edit();     // Catch: Throwable -> L172
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L172
        String r58 = r56.f12465a;     // Catch: Throwable -> L172
        r123.append(r58);     // Catch: Throwable -> L172
        r123.append("downgrade_time");     // Catch: Throwable -> L172
        r57.putLong(r123.toString(), r122).putInt(r58 + "downgrade_index", r56.f12467c).apply();     // Catch: Throwable -> L172
    L137:
        r118 = r54;
        goto L138
    L125:
        r56.f12470f = 0;     // Catch: Throwable -> L172
        goto L137
    L127:
        if (r54 != 200) goto L137;
        u4.b r59 = h(r119);     // Catch: Throwable -> L172
        r59.f12466b.f6758b.getClass();     // Catch: Throwable -> L172
        long r60 = System.currentTimeMillis();     // Catch: Throwable -> L172
        int r61 = r59.f12470f;     // Catch: Throwable -> L172
        long r124 = r61;
        long[][] r125 = r59.f12473i;     // Catch: Throwable -> L172
        int r62 = r59.f12467c;     // Catch: Throwable -> L172
        if (r124 < r125[r62][1]) goto L131;
    L134:
        if (r62 <= 0) goto L136;
        long r63 = System.currentTimeMillis();     // Catch: Throwable -> L172
        r59.f12467c--;     // Catch: Throwable -> L172
        r59.f12468d = 1;     // Catch: Throwable -> L172
        r59.f12469e = 1.0f;     // Catch: Throwable -> L172
        r59.f12470f = 1;     // Catch: Throwable -> L172
        r59.f12471g = r63;     // Catch: Throwable -> L172
        r59.f12472h = r63;     // Catch: Throwable -> L172
        SharedPreferences.Editor r64 = r59.f12466b.f6761e.edit();     // Catch: Throwable -> L172
        StringBuilder r65 = new StringBuilder();     // Catch: Throwable -> L172
        String r126 = r59.f12465a;     // Catch: Throwable -> L172
        r65.append(r126);     // Catch: Throwable -> L172
        r65.append("downgrade_time");     // Catch: Throwable -> L172
        r64.putLong(r65.toString(), r63).putInt(r126 + "downgrade_index", r59.f12467c).apply();     // Catch: Throwable -> L172
    L136:
        int r127 = r54;
    L140:
        r51.H.l(0, r52, "{} send pack end: {}, resp code: {}", new Object[]{r112, r43, Integer.valueOf(r127)});     // Catch: Throwable -> L172
        List<String> r66 = q4.a.f10132d;     // Catch: Throwable -> L172
        if (r127 >= 500) goto L143;
    L145:
        boolean r67 = false;
    L146:
        if (r67 == true) goto L147;
        if (r127 != 200) goto L151;
        j(r43, true);     // Catch: Throwable -> L172
        i(r51, r43, true);     // Catch: Throwable -> L172
        this.f13969j++;     // Catch: Throwable -> L172
        r18 = 1;
    L159:
        r17 = 0;
        r41 = r211;
    L162:
        r41 = r41;
        r40 = r40;
        r39 = r39;
        r42 = r42;
        r8 = r28;
        goto L78
    L151:
        j(r43, false);     // Catch: Throwable -> L172
        i(r51, r43, false);     // Catch: Throwable -> L172
        if (r53 != null) goto L154;
    L158:
        r51.f11417y.b(k.F, 1);     // Catch: Throwable -> L172
        r18 = 1;
        goto L159
    L154:
        if (404 != r127) goto L156;
        boolean r68 = true;
    L157:
        r53.f9262b = r68;     // Catch: Throwable -> L172
        goto L158
    L156:
        r68 = false;
        goto L157
    L147:
        j(r43, false);     // Catch: Throwable -> L172
        i(r51, r43, false);     // Catch: Throwable -> L172
        r51.f11417y.b(k.F, 1);     // Catch: Throwable -> L172
        r16 = 1;
    L169:
        this.f13930a.E.getClass();     // Catch: Throwable -> L172
        monitor-exit(this);
        return r16;
    L143:
        if (r127 >= 600) goto L145;
        r67 = true;
        goto L146
    L131:
        if ((r60 - r59.f12472h) > 1800000) goto L134;
        r59.f12470f = r61 + 1;     // Catch: Throwable -> L172
        goto L136
    L117:
        if (r54 >= 600) goto L119;
        r55 = true;
        goto L121
    L103:
        r40 = r40;
        u4.b r69 = h(r119);     // Catch: Throwable -> L172
        r210 = r48;
        r69.f12466b.f6758b.getClass();     // Catch: Throwable -> L172
        r39 = r39;
        long r70 = System.currentTimeMillis();     // Catch: Throwable -> L172
        r42 = r42;
        r211 = r41;
        long r71 = r70 - r69.f12471g;     // Catch: Throwable -> L172
        r120 = r118;
        r121 = r116;
        long[] r128 = r69.f12473i[r69.f12467c];     // Catch: Throwable -> L172
        if (r71 < r128[0]) goto L106;
        r69.f12468d = 1;     // Catch: Throwable -> L172
        r69.f12471g = r70;     // Catch: Throwable -> L172
    L109:
        r50 = true;
        goto L112
    L106:
        int r72 = r69.f12468d;     // Catch: Throwable -> L172
        if (r72 >= r128[2]) goto L110;
        r69.f12468d = r72 + 1;     // Catch: Throwable -> L172
        goto L109
    L110:
        m.u().b("Congestion forbidden send by mTableIndex={}, mLastSendTime={}, mHasSendCount={}", new Object[]{Integer.valueOf(r69.f12467c), Long.valueOf(r69.f12471g), Integer.valueOf(r69.f12468d)});     // Catch: Throwable -> L172
        goto L111
    L139:
        r40 = r40;
        r39 = r39;
        r42 = r42;
        r211 = r41;
        r53 = r116;
        r51 = r115;
        r52 = r113;
        r127 = r118;
        goto L140
    L90:
        if (r117.a(r8) == false) goto L92;
        r115.f11417y.b(k.M, r18);     // Catch: Throwable -> L172
        r115.H.f(r17, r113, "{} backoff request as ratio not allowed to send: {}", new Object[]{r112, r43});     // Catch: Throwable -> L172
        r40 = r40;
        r39 = r39;
        r42 = r42;
        r41 = r41;
        goto L162
    L87:
        r117 = r39.f6767k;     // Catch: Throwable -> L172
    L161:
        r41.f13953a.add(r43);     // Catch: Throwable -> L172
        r115.H.f(0, r113, "{} send empty pack: {}", new Object[]{r112, r43});     // Catch: Throwable -> L172
        r17 = 0;
    L163:
        r16 = r18;
        goto L169
    L67:
        if (this.f13969j <= 0) goto L69;
    L72:
        int r73 = 0;
    L73:
        r27.addAll(r73, r29);     // Catch: Throwable -> L172
        goto L74
    L69:
        if (r27.isEmpty() == true) goto L72;
        r73 = 1;
    L38:
        th = move-exception;
        boolean r74 = th instanceof SQLiteBlobTooBigException;     // Catch: Throwable -> L164
        ((m) r25.g()).k(th, 5, "query pack failed", new Object[0]);     // Catch: Throwable -> L164
        r110.f13937m.f11417y.b(k.O, 1);     // Catch: Throwable -> L164
        r110.f13937m.f11417y.g("query pack failed", th);     // Catch: Throwable -> L164
        if (r22 == null) goto L42;
        r22.close();     // Catch: Throwable -> L172
    L42:
        if (r74 == false) goto L44;
        r25.F();     // Catch: Throwable -> L172
    L44:
        r32 = new ArrayList();     // Catch: Throwable -> L172
        goto L45
    L164:
        th = move-exception;
        if (r22 == null) goto L167;
        r22.close();     // Catch: Throwable -> L172
    L167:
        throw th;     // Catch: Throwable -> L172
    L26:
        if (r8 != 12) goto L30;
        r26 = 16;
        goto L30
    L22:
        this.f13930a.f13937m.getClass();     // Catch: Throwable -> L172
        r20.n(r23, r24, r8);     // Catch: Throwable -> L172
        goto L23
    L168:
        this.f13930a.f13937m.f11417y.g("Sender failed due to invalid did", null);     // Catch: Throwable -> L172
        f4.a[] r75 = f4.a.f7322a;     // Catch: Throwable -> L172
        goto L169
    L7:
        r19 = "null";
    L172:
        th = move-exception;
        throw th;
    }

    @Override // y3.a
    public final String d() {
        return this.f13968i;
    }

    @Override // y3.a
    public final long[] e() {
        return this.f13965f;
    }

    @Override // y3.a
    public final boolean f() {
        return !this.f13932c;
    }

    @Override // y3.a
    public final long g() {
        if (this.f13967h == null) goto L7;
        this.f13930a.f13938n.getClass();
        this.f13967h.getClass();
        return 0;
    L7:
        return this.f13930a.f13938n.b();
    }

    public final u4.b h(String r8) {
        if (v4.i.g(r8) == false) goto L11;
    L5:
        ConcurrentHashMap<String, u4.b> r10 = this.f13966g;
        boolean r11 = r10.containsKey(r8);
        String r12 = this.f13968i;
        c r13 = this.f13930a;
        if (r11 == true) goto L8;
        r10.put(r8, new u4.b(defpackage.a.f(r12, BdimCategoryConstants.SEPARATOR_COLON, r8), r13.f13938n, this.f13967h));
    L8:
        u4.b r14 = r10.get(r8);
        Object[] r15 = {r12, r8, r14};
        r13.f13937m.H.g(0, f13964k, "{} congestion for host:{} is {}", r15);
        return r14;
    L11:
        r8 = Uri.parse(r8).getHost();     // Catch: Throwable -> L10
        goto L5
    }

    public final void j(r4.i r17, boolean r18) {
        r4.b r8 = this.f13930a.b();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        if (r18 == false) goto L5;
        r10.add(r17);
    L6:
        r4.b.C0145b r12 = r8.f11466b;
        ((m) r8.g()).l(5, null, "setResult: del -> {}, fail -> {}", new Object[]{r10, r11});
        Iterator r13 = r11.iterator();
        ArrayList r14 = new ArrayList();
        r3.c r15 = r8.f11465a.f13937m;
        r15.getClass();
        s4.b r16 = (s4.b) s4.a.f12022a.b(new Object[0]);
    L8:
        if (r13.hasNext() == false) goto L52;
        r4.i r19 = (r4.i) r13.next();
        r16.b();
        if (Math.abs(System.currentTimeMillis() - r19.f11450b) >= 1209600000) goto L11;
        r16.a();
        goto L8
    L11:
        r10.add(r19);
        r14.add(r19);
        r13.remove();
        goto L8
    L52:
        SQLiteDatabase r20 = r12.getWritableDatabase();     // Catch: Throwable -> L27
        Iterator r21 = r10.iterator();     // Catch: Throwable -> L27
    L16:
        if (r21.hasNext() == false) goto L30;
        r4.i r110 = (r4.i) r21.next();     // Catch: Throwable -> L27
        int r22 = r20.delete("pack", "_id = ?", new String[]{String.valueOf(r110.f11449a)});     // Catch: Throwable -> L27
        if (r22 > 0) goto L16;
        ((m) r8.g()).t("delete from db failed, pack: {}, rows: {}", new Object[]{r110, Integer.valueOf(r22)});     // Catch: Throwable -> L27
        r15.f11417y.b(k.O, 1);     // Catch: Throwable -> L27
        Object r23 = r15.f11416x.f11296a;     // Catch: Throwable -> L27
        if (((CopyOnWriteArraySet) r23).isEmpty() == true) goto L26;
        Iterator r24 = ((CopyOnWriteArraySet) r23).iterator();     // Catch: Throwable -> L27
    L24:
        if (r24.hasNext() == false) goto L26;
        ((r3.k) r24.next()).a();     // Catch: Throwable -> L27
    L26:
        r15.f11417y.g("delete pack failed for zero", null);     // Catch: Throwable -> L27
        goto L16
    L30:
        Iterator r25 = r11.iterator();     // Catch: Throwable -> L27
    L31:
        if (r25.hasNext() == false) goto L42;
        r4.i r26 = (r4.i) r25.next();     // Catch: Throwable -> L27
        long r27 = r26.f11449a;     // Catch: Throwable -> L27
        int r111 = r26.I + 1;     // Catch: Throwable -> L27
        r26.I = r111;     // Catch: Throwable -> L27
        r20.execSQL("UPDATE pack SET _fail=" + r111 + " WHERE _id=" + r27);     // Catch: Throwable -> L27
    L42:
        r12.getClass();
        Iterator r28 = r14.iterator();
    L44:
        if (r28.hasNext() == false) goto L46;
        ((r4.i) r28.next()).t();
        goto L44
    L46:
        return;
    L27:
        th = move-exception;
        ((m) r8.g()).k(th, 5, "set result failed", new Object[0]);     // Catch: Throwable -> L47
        r15.f11417y.b(k.O, 1);     // Catch: Throwable -> L47
        Object r29 = r15.f11416x.f11296a;     // Catch: Throwable -> L47
        if (((CopyOnWriteArraySet) r29).isEmpty() == true) goto L41;
        th.toString();     // Catch: Throwable -> L47
        Iterator r30 = ((CopyOnWriteArraySet) r29).iterator();     // Catch: Throwable -> L47
    L39:
        if (r30.hasNext() == false) goto L41;
        ((r3.k) r30.next()).a();     // Catch: Throwable -> L47
    L41:
        r15.f11417y.g("handle pack send result failed", th);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        r12.getClass();
        throw th;
    L5:
        r11.add(r17);
        goto L6
    }

    public i(c r8, m4.b r10) {
        super(r8);
        long[] r11 = {10000};
        this.f13965f = r11;
        this.f13966g = new ConcurrentHashMap();
        this.f13969j = 0;
        this.f13967h = r10;
        StringBuilder r12 = new StringBuilder("Sender_p_");
        r10.getClass();
        r12.append(0);
        this.f13968i = r12.toString();
        r10.getClass();
        if (0 >= 10000) goto L6;
        r11[0] = 0;
        return;
    }
}
