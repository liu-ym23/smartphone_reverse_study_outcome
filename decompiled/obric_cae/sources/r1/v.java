package r1;

import android.database.Cursor;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.room.r f11368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f11369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f11370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f11371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f11372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f11373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f11374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k f11375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f11376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f11377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f11378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f11379l;

    public class a extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class b extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class c extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public class d extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    public class e extends androidx.room.f<t> {
        @Override // androidx.room.f
        public final void bind(a1.f r10, t r11) {
            t r12 = r11;
            String r13 = r12.f11339a;
            if (r13 != null) goto L5;
            r10.g0(1);
        L6:
            r10.W(2, l6.a.Q0(r12.f11340b));
            String r8 = r12.f11341c;
            if (r8 != null) goto L9;
            r10.g0(3);
        L10:
            String r14 = r12.f11342d;
            if (r14 != null) goto L13;
            r10.g0(4);
        L14:
            byte[] r15 = androidx.work.e.e(r12.f11343e);
            if (r15 != null) goto L17;
            r10.g0(5);
        L18:
            byte[] r16 = androidx.work.e.e(r12.f11344f);
            if (r16 != null) goto L21;
            r10.g0(6);
        L22:
            r10.W(7, r12.f11345g);
            r10.W(8, r12.f11346h);
            r10.W(9, r12.f11347i);
            r10.W(10, r12.f11349k);
            r10.W(11, l6.a.o(r12.f11350l));
            r10.W(12, r12.f11351m);
            r10.W(13, r12.f11352n);
            r10.W(14, r12.f11353o);
            r10.W(15, r12.f11354p);
            r10.W(16, r12.f11355q ? 1 : 0);
            r10.W(17, l6.a.w0(r12.f11356r));
            r10.W(18, r12.d());
            r10.W(19, r12.c());
            androidx.work.d r17 = r12.f11348j;
            if (r17 == null) goto L25;
            r10.W(20, l6.a.q0(r17.d()));
            r10.W(21, r17.f() ? 1 : 0);
            r10.W(22, r17.g() ? 1 : 0);
            r10.W(23, r17.e() ? 1 : 0);
            r10.W(24, r17.h() ? 1 : 0);
            r10.W(25, r17.b());
            r10.W(26, r17.a());
            r10.Y(27, l6.a.M0(r17.c()));
            return;
        L25:
            r10.g0(20);
            r10.g0(21);
            r10.g0(22);
            r10.g0(23);
            r10.g0(24);
            r10.g0(25);
            r10.g0(26);
            r10.g0(27);
            return;
        L21:
            r10.Y(6, r16);
            goto L22
        L17:
            r10.Y(5, r15);
            goto L18
        L13:
            r10.R(4, r14);
            goto L14
        L9:
            r10.R(3, r8);
            goto L10
        L5:
            r10.R(1, r13);
            goto L6
        }

        @Override // androidx.room.x
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class f extends androidx.room.e<t> {
        @Override // androidx.room.e
        public final void bind(a1.f r11, t r12) {
            t r13 = r12;
            String r10 = r13.f11339a;
            if (r10 != null) goto L5;
            r11.g0(1);
        L6:
            r11.W(2, l6.a.Q0(r13.f11340b));
            String r8 = r13.f11341c;
            if (r8 != null) goto L9;
            r11.g0(3);
        L10:
            String r14 = r13.f11342d;
            if (r14 != null) goto L13;
            r11.g0(4);
        L14:
            byte[] r15 = androidx.work.e.e(r13.f11343e);
            if (r15 != null) goto L17;
            r11.g0(5);
        L18:
            byte[] r16 = androidx.work.e.e(r13.f11344f);
            if (r16 != null) goto L21;
            r11.g0(6);
        L22:
            r11.W(7, r13.f11345g);
            r11.W(8, r13.f11346h);
            r11.W(9, r13.f11347i);
            r11.W(10, r13.f11349k);
            r11.W(11, l6.a.o(r13.f11350l));
            r11.W(12, r13.f11351m);
            r11.W(13, r13.f11352n);
            r11.W(14, r13.f11353o);
            r11.W(15, r13.f11354p);
            r11.W(16, r13.f11355q ? 1 : 0);
            r11.W(17, l6.a.w0(r13.f11356r));
            r11.W(18, r13.d());
            r11.W(19, r13.c());
            androidx.work.d r17 = r13.f11348j;
            if (r17 == null) goto L25;
            r11.W(20, l6.a.q0(r17.d()));
            r11.W(21, r17.f() ? 1 : 0);
            r11.W(22, r17.g() ? 1 : 0);
            r11.W(23, r17.e() ? 1 : 0);
            r11.W(24, r17.h() ? 1 : 0);
            r11.W(25, r17.b());
            r11.W(26, r17.a());
            r11.Y(27, l6.a.M0(r17.c()));
        L26:
            String r18 = r13.f11339a;
            if (r18 != null) goto L29;
            r11.g0(28);
            return;
        L29:
            r11.R(28, r18);
            return;
        L25:
            r11.g0(20);
            r11.g0(21);
            r11.g0(22);
            r11.g0(23);
            r11.g0(24);
            r11.g0(25);
            r11.g0(26);
            r11.g0(27);
            goto L26
        L21:
            r11.Y(6, r16);
            goto L22
        L17:
            r11.Y(5, r15);
            goto L18
        L13:
            r11.R(4, r14);
            goto L14
        L9:
            r11.R(3, r8);
            goto L10
        L5:
            r11.R(1, r10);
            goto L6
        }

        @Override // androidx.room.e, androidx.room.x
        public final String createQuery() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }
    }

    public class g extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class h extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    public class i extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    public class j extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class k extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    public class l extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class m extends androidx.room.x {
        @Override // androidx.room.x
        public final String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public v(androidx.room.r r8) {
        this.f11368a = r8;
        this.f11369b = new e(r8);
        this.f11370c = new f(r8);
        this.f11371d = new g(r8);
        this.f11372e = new h(r8);
        this.f11373f = new i(r8);
        this.f11374g = new j(r8);
        this.f11375h = new k(r8);
        this.f11376i = new l(r8);
        this.f11377j = new m(r8);
        this.f11378k = new a(r8);
        this.f11379l = new b(r8);
        new c(r8);
        new d(r8);
    }

    @Override // r1.u
    public final void a(String r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        i r11 = this.f11373f;
        a1.f r12 = r11.acquire();
        if (r8 != null) goto L5;
        r12.g0(1);
    L6:
        r10.beginTransaction();
        r12.g();     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        r11.release(r12);
        return;
    L10:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    L5:
        r12.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final int b(long r8, String r10) {
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        a r12 = this.f11378k;
        a1.f r13 = r12.acquire();
        r13.W(1, r8);
        if (r10 != null) goto L5;
        r13.g0(2);
    L6:
        r11.beginTransaction();
        int r14 = r13.g();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        r12.release(r13);
        return r14;
    L10:
        th = move-exception;
        r11.endTransaction();
        r12.release(r13);
        throw th;
    L5:
        r13.R(2, r10);
        goto L6
    }

    @Override // r1.u
    public final ArrayList c(long r70) {
        androidx.room.t r8 = androidx.room.t.k(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        r8.W(1, r70);
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L58
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L58
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L58
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L58
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        androidx.room.t r114 = r8;
        int r71 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r72 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r115 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r116 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L56
        int r117 = y0.a.b(r11, "generation");     // Catch: Throwable -> L56
        int r22 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L56
        int r23 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L56
        int r24 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r210 = r21;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        byte[] r211 = null;
        if (r11.isNull(r12) == false) goto L11;
        String r31 = null;
    L12:
        androidx.work.u.a r32 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r33 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r34 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r35 = null;
    L24:
        androidx.work.e r36 = androidx.work.e.a(r35);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r37 = null;
    L28:
        androidx.work.e r38 = androidx.work.e.a(r37);     // Catch: Throwable -> L56
        long r39 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r310 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r44 = r11.getInt(r111);     // Catch: Throwable -> L56
        androidx.work.a r45 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L56
        long r46 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r48 = r11.getLong(r20);     // Catch: Throwable -> L56
        int r40 = r210;
        long r50 = r11.getLong(r40);     // Catch: Throwable -> L56
        int r212 = r12;
        int r42 = r71;
        long r52 = r11.getLong(r42);     // Catch: Throwable -> L56
        r71 = r42;
        int r43 = r72;
        int r311 = r11.getInt(r43);     // Catch: Throwable -> L56
        r72 = r43;
        int r47 = r115;
        if (r311 == 0) goto L31;
        boolean r54 = true;
    L32:
        androidx.work.q r55 = l6.a.Z(r11.getInt(r47));     // Catch: Throwable -> L56
        r115 = r47;
        int r49 = r116;
        int r56 = r11.getInt(r49);     // Catch: Throwable -> L56
        r116 = r49;
        int r51 = r117;
        int r57 = r11.getInt(r51);     // Catch: Throwable -> L56
        r117 = r51;
        int r53 = r22;
        androidx.work.n r59 = l6.a.Y(r11.getInt(r53));     // Catch: Throwable -> L56
        r22 = r53;
        r23 = r23;
        if (r11.getInt(r23) == 0) goto L35;
        boolean r60 = true;
    L37:
        if (r11.getInt(r24) == 0) goto L39;
        boolean r61 = true;
    L41:
        if (r11.getInt(r25) == 0) goto L43;
        boolean r62 = true;
    L45:
        if (r11.getInt(r26) == 0) goto L47;
        boolean r63 = true;
    L48:
        long r64 = r11.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r58 = r28;
        long r66 = r11.getLong(r58);     // Catch: Throwable -> L56
        r28 = r58;
        int r65 = r29;
        if (r11.isNull(r65) == true) goto L52;
        r211 = r11.getBlob(r65);     // Catch: Throwable -> L56
    L52:
        r29 = r65;
        r30.add(new t(r31, r32, r33, r34, r36, r38, r39, r310, r41, new androidx.work.d(r59, r60, r61, r62, r63, r64, r66, l6.a.s(r211)), r44, r45, r46, r48, r50, r52, r54, r55, r56, r57));     // Catch: Throwable -> L56
        r12 = r212;
        r210 = r40;
        goto L6
    L47:
        r63 = false;
        goto L48
    L43:
        r62 = false;
        goto L45
    L39:
        r61 = false;
        goto L41
    L35:
        r60 = false;
        goto L37
    L31:
        r54 = false;
        goto L32
    L27:
        r37 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r35 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r34 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r33 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r31 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r114.n();
        return r30;
    L56:
        th = th;
    L60:
        r11.close();
        r114.n();
        throw th;
    L58:
        th = th;
        r114 = r8;
        goto L60
    }

    @Override // r1.u
    public final ArrayList d() {
        androidx.room.t r8 = androidx.room.t.k(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L58
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L58
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L58
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L58
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r114 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r20 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        androidx.room.t r115 = r8;
        int r70 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r116 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r117 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r118 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L56
        int r21 = y0.a.b(r11, "generation");     // Catch: Throwable -> L56
        int r22 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L56
        int r23 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L56
        int r24 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r210 = r20;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        byte[] r31 = null;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        androidx.work.u.a r33 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.e r37 = androidx.work.e.a(r36);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.e r39 = androidx.work.e.a(r38);     // Catch: Throwable -> L56
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        androidx.work.a r46 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r114);     // Catch: Throwable -> L56
        int r41 = r210;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L56
        int r211 = r12;
        int r43 = r70;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L56
        r70 = r43;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        androidx.work.q r56 = l6.a.Z(r11.getInt(r117));     // Catch: Throwable -> L56
        r117 = r117;
        int r44 = r118;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L56
        r118 = r44;
        int r48 = r21;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L56
        r21 = r48;
        int r50 = r22;
        androidx.work.n r60 = l6.a.Y(r11.getInt(r50));     // Catch: Throwable -> L56
        r22 = r50;
        r23 = r23;
        if (r11.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r52 = r28;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L56
        r28 = r52;
        int r54 = r29;
        if (r11.isNull(r54) == true) goto L52;
        r31 = r11.getBlob(r54);     // Catch: Throwable -> L56
    L52:
        r29 = r54;
        r30.add(new t(r32, r33, r34, r35, r37, r39, r310, r40, r42, new androidx.work.d(r60, r61, r62, r63, r64, r65, r67, l6.a.s(r31)), r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r211;
        r210 = r41;
        goto L6
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r115.n();
        return r30;
    L56:
        th = th;
    L60:
        r11.close();
        r115.n();
        throw th;
    L58:
        th = th;
        r115 = r8;
        goto L60
    }

    @Override // r1.u
    public final void delete(String r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        g r11 = this.f11371d;
        a1.f r12 = r11.acquire();
        if (r8 != null) goto L5;
        r12.g0(1);
    L6:
        r10.beginTransaction();
        r12.g();     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        r11.release(r12);
        return;
    L10:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    L5:
        r12.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final ArrayList e(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r10.n();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final androidx.work.u.a f(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT state FROM workspec WHERE id=?");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        androidx.work.u.a r13 = null;
        if (r12.moveToFirst() == true) goto L10;
    L16:
        r12.close();
        r10.n();
        return r13;
    L10:
        if (r12.isNull(0) == false) goto L12;
        Integer r14 = null;
    L13:
        if (r14 == null) goto L16;
        r13 = l6.a.a0(r14.intValue());     // Catch: Throwable -> L18
        goto L16
    L12:
        r14 = Integer.valueOf(r12.getInt(0));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final t g(String r59) {
        androidx.room.t r8 = androidx.room.t.k(1, "SELECT * FROM workspec WHERE id=?");
        if (r59 != null) goto L5;
        r8.g0(1);
    L6:
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L60
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L60
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L60
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L60
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L60
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L60
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L60
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L60
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L60
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L60
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L60
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L60
        int r20 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L60
        int r21 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L60
        androidx.room.t r114 = r8;
        int r22 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L58
        int r23 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L58
        int r24 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L58
        int r25 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L58
        int r26 = y0.a.b(r11, "generation");     // Catch: Throwable -> L58
        int r27 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L58
        int r28 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L58
        int r29 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L58
        int r30 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L58
        int r31 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L58
        int r32 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L58
        int r33 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L58
        int r34 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L58
        t r210 = null;
        byte[] r211 = null;
        if (r11.moveToFirst() == true) goto L12;
    L56:
        r11.close();
        r114.n();
        return r210;
    L12:
        if (r11.isNull(r12) == false) goto L14;
        String r35 = null;
    L15:
        androidx.work.u.a r36 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L58
        if (r11.isNull(r14) == false) goto L18;
        String r37 = null;
    L20:
        if (r11.isNull(r15) == false) goto L22;
        String r38 = null;
    L24:
        if (r11.isNull(r16) == false) goto L26;
        byte[] r39 = null;
    L27:
        androidx.work.e r310 = androidx.work.e.a(r39);     // Catch: Throwable -> L58
        if (r11.isNull(r17) == false) goto L30;
        byte[] r40 = null;
    L31:
        androidx.work.e r311 = androidx.work.e.a(r40);     // Catch: Throwable -> L58
        long r312 = r11.getLong(r18);     // Catch: Throwable -> L58
        long r313 = r11.getLong(r19);     // Catch: Throwable -> L58
        long r41 = r11.getLong(r110);     // Catch: Throwable -> L58
        int r44 = r11.getInt(r111);     // Catch: Throwable -> L58
        androidx.work.a r45 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L58
        long r46 = r11.getLong(r113);     // Catch: Throwable -> L58
        long r48 = r11.getLong(r20);     // Catch: Throwable -> L58
        long r50 = r11.getLong(r21);     // Catch: Throwable -> L58
        long r52 = r11.getLong(r22);     // Catch: Throwable -> L58
        if (r11.getInt(r23) == 0) goto L34;
        boolean r54 = true;
    L35:
        androidx.work.q r55 = l6.a.Z(r11.getInt(r24));     // Catch: Throwable -> L58
        int r56 = r11.getInt(r25);     // Catch: Throwable -> L58
        int r57 = r11.getInt(r26);     // Catch: Throwable -> L58
        androidx.work.n r42 = l6.a.Y(r11.getInt(r27));     // Catch: Throwable -> L58
        if (r11.getInt(r28) == 0) goto L38;
        boolean r43 = true;
    L40:
        if (r11.getInt(r29) == 0) goto L42;
        boolean r47 = true;
    L44:
        if (r11.getInt(r30) == 0) goto L46;
        boolean r49 = true;
    L48:
        if (r11.getInt(r31) == 0) goto L50;
        boolean r115 = true;
    L51:
        long r116 = r11.getLong(r32);     // Catch: Throwable -> L58
        long r117 = r11.getLong(r33);     // Catch: Throwable -> L58
        if (r11.isNull(r34) == true) goto L55;
        r211 = r11.getBlob(r34);     // Catch: Throwable -> L58
    L55:
        r210 = new t(r35, r36, r37, r38, r310, r311, r312, r313, r41, new androidx.work.d(r42, r43, r47, r49, r115, r116, r117, l6.a.s(r211)), r44, r45, r46, r48, r50, r52, r54, r55, r56, r57);     // Catch: Throwable -> L58
        goto L56
    L50:
        r115 = false;
        goto L51
    L46:
        r49 = false;
        goto L48
    L42:
        r47 = false;
        goto L44
    L38:
        r43 = false;
        goto L40
    L34:
        r54 = false;
        goto L35
    L30:
        r40 = r11.getBlob(r17);     // Catch: Throwable -> L58
        goto L31
    L26:
        r39 = r11.getBlob(r16);     // Catch: Throwable -> L58
        goto L27
    L22:
        r38 = r11.getString(r15);     // Catch: Throwable -> L58
        goto L24
    L18:
        r37 = r11.getString(r14);     // Catch: Throwable -> L58
        goto L20
    L14:
        r35 = r11.getString(r12);     // Catch: Throwable -> L58
    L58:
        th = th;
    L62:
        r11.close();
        r114.n();
        throw th;
    L60:
        th = th;
        r114 = r8;
        goto L62
    L5:
        r8.R(1, r59);
        goto L6
    }

    @Override // r1.u
    public final ArrayList h(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r10.n();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final ArrayList i(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        byte[] r14 = null;
    L14:
        r13.add(androidx.work.e.a(r14));     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getBlob(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r10.n();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final int j() {
        androidx.room.r r8 = this.f11368a;
        r8.assertNotSuspendingTransaction();
        b r10 = this.f11379l;
        a1.f r11 = r10.acquire();
        r8.beginTransaction();
        int r12 = r11.g();     // Catch: Throwable -> L6
        r8.setTransactionSuccessful();     // Catch: Throwable -> L6
        r8.endTransaction();
        r10.release(r11);
        return r12;
    L6:
        th = move-exception;
        r8.endTransaction();
        r10.release(r11);
        throw th;
    }

    @Override // r1.u
    public final ArrayList k() {
        androidx.room.t r8 = androidx.room.t.k(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        r8.W(1, 200);
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L58
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L58
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L58
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L58
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        androidx.room.t r114 = r8;
        int r115 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r116 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r117 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r22 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L56
        int r23 = y0.a.b(r11, "generation");     // Catch: Throwable -> L56
        int r24 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L56
        int r25 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L56
        int r26 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r27 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r28 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r29 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r210 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r211 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r21;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        byte[] r32 = null;
        if (r11.isNull(r12) == false) goto L11;
        String r33 = null;
    L12:
        androidx.work.u.a r34 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r35 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r36 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r37 = null;
    L24:
        androidx.work.e r38 = androidx.work.e.a(r37);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r39 = null;
    L28:
        androidx.work.e r310 = androidx.work.e.a(r39);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r43 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r46 = r11.getInt(r111);     // Catch: Throwable -> L56
        androidx.work.a r47 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L56
        long r48 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r50 = r11.getLong(r20);     // Catch: Throwable -> L56
        int r40 = r30;
        long r52 = r11.getLong(r40);     // Catch: Throwable -> L56
        int r312 = r12;
        int r42 = r115;
        long r54 = r11.getLong(r42);     // Catch: Throwable -> L56
        r115 = r42;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r56 = true;
    L32:
        androidx.work.q r57 = l6.a.Z(r11.getInt(r117));     // Catch: Throwable -> L56
        r117 = r117;
        int r44 = r22;
        int r58 = r11.getInt(r44);     // Catch: Throwable -> L56
        r22 = r44;
        int r45 = r23;
        int r59 = r11.getInt(r45);     // Catch: Throwable -> L56
        r23 = r45;
        int r49 = r24;
        androidx.work.n r61 = l6.a.Y(r11.getInt(r49));     // Catch: Throwable -> L56
        r24 = r49;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r62 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r63 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r64 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r65 = true;
    L48:
        long r66 = r11.getLong(r29);     // Catch: Throwable -> L56
        r29 = r29;
        int r51 = r210;
        long r68 = r11.getLong(r51);     // Catch: Throwable -> L56
        r210 = r51;
        int r53 = r211;
        if (r11.isNull(r53) == true) goto L52;
        r32 = r11.getBlob(r53);     // Catch: Throwable -> L56
    L52:
        r211 = r53;
        r31.add(new t(r33, r34, r35, r36, r38, r310, r311, r41, r43, new androidx.work.d(r61, r62, r63, r64, r65, r66, r68, l6.a.s(r32)), r46, r47, r48, r50, r52, r54, r56, r57, r58, r59));     // Catch: Throwable -> L56
        r12 = r312;
        r30 = r40;
        goto L6
    L47:
        r65 = false;
        goto L48
    L43:
        r64 = false;
        goto L45
    L39:
        r63 = false;
        goto L41
    L35:
        r62 = false;
        goto L37
    L31:
        r56 = false;
        goto L32
    L27:
        r39 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r37 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r36 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r35 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r33 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r114.n();
        return r31;
    L56:
        th = th;
    L60:
        r11.close();
        r114.n();
        throw th;
    L58:
        th = th;
        r114 = r8;
        goto L60
    }

    @Override // r1.u
    public final ArrayList l(String r8) {
        androidx.room.t r10 = androidx.room.t.k(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (r8 != null) goto L5;
        r10.g0(1);
    L6:
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(new t.a(l6.a.a0(r12.getInt(1)), r14));     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r10.n();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L5:
        r10.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final ArrayList m(int r71) {
        androidx.room.t r8 = androidx.room.t.k(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))");
        r8.W(1, r71);
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L58
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L58
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L58
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L58
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        androidx.room.t r114 = r8;
        int r72 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r115 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r116 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r117 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L56
        int r22 = y0.a.b(r11, "generation");     // Catch: Throwable -> L56
        int r23 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L56
        int r24 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L56
        int r25 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r26 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r27 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r28 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r29 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r210 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r211 = r21;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        byte[] r31 = null;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        androidx.work.u.a r33 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.e r37 = androidx.work.e.a(r36);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.e r39 = androidx.work.e.a(r38);     // Catch: Throwable -> L56
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        androidx.work.a r46 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r20);     // Catch: Throwable -> L56
        int r41 = r211;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L56
        int r212 = r12;
        int r43 = r72;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L56
        r72 = r43;
        r115 = r115;
        if (r11.getInt(r115) == 0) goto L31;
        boolean r55 = true;
    L32:
        androidx.work.q r56 = l6.a.Z(r11.getInt(r116));     // Catch: Throwable -> L56
        r116 = r116;
        int r44 = r117;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L56
        r117 = r44;
        int r48 = r22;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L56
        r22 = r48;
        int r50 = r23;
        androidx.work.n r60 = l6.a.Y(r11.getInt(r50));     // Catch: Throwable -> L56
        r23 = r50;
        r24 = r24;
        if (r11.getInt(r24) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r25) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r26) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r27) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r28);     // Catch: Throwable -> L56
        r28 = r28;
        int r52 = r29;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L56
        r29 = r52;
        int r54 = r210;
        if (r11.isNull(r54) == true) goto L52;
        r31 = r11.getBlob(r54);     // Catch: Throwable -> L56
    L52:
        r210 = r54;
        r30.add(new t(r32, r33, r34, r35, r37, r39, r310, r40, r42, new androidx.work.d(r60, r61, r62, r63, r64, r65, r67, l6.a.s(r31)), r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r212;
        r211 = r41;
        goto L6
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r114.n();
        return r30;
    L56:
        th = th;
    L60:
        r11.close();
        r114.n();
        throw th;
    L58:
        th = th;
        r114 = r8;
        goto L60
    }

    @Override // r1.u
    public final int n(androidx.work.u.a r8, String r10) {
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        h r12 = this.f11372e;
        a1.f r13 = r12.acquire();
        r13.W(1, l6.a.Q0(r8));
        if (r10 != null) goto L5;
        r13.g0(2);
    L6:
        r11.beginTransaction();
        int r14 = r13.g();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        r12.release(r13);
        return r14;
    L10:
        th = move-exception;
        r11.endTransaction();
        r12.release(r13);
        throw th;
    L5:
        r13.R(2, r10);
        goto L6
    }

    @Override // r1.u
    public final void o(String r8, androidx.work.e r10) {
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        j r12 = this.f11374g;
        a1.f r13 = r12.acquire();
        byte[] r14 = androidx.work.e.e(r10);
        if (r14 != null) goto L5;
        r13.g0(1);
    L7:
        if (r8 != null) goto L9;
        r13.g0(2);
    L10:
        r11.beginTransaction();
        r13.g();     // Catch: Throwable -> L14
        r11.setTransactionSuccessful();     // Catch: Throwable -> L14
        r11.endTransaction();
        r12.release(r13);
        return;
    L14:
        th = move-exception;
        r11.endTransaction();
        r12.release(r13);
        throw th;
    L9:
        r13.R(2, r8);
        goto L10
    L5:
        r13.Y(1, r14);
        goto L7
    }

    @Override // r1.u
    public final void p(long r8, String r10) {
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        k r12 = this.f11375h;
        a1.f r13 = r12.acquire();
        r13.W(1, r8);
        if (r10 != null) goto L5;
        r13.g0(2);
    L6:
        r11.beginTransaction();
        r13.g();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        r12.release(r13);
        return;
    L10:
        th = move-exception;
        r11.endTransaction();
        r12.release(r13);
        throw th;
    L5:
        r13.R(2, r10);
        goto L6
    }

    @Override // r1.u
    public final void q(t r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11370c.handle(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @Override // r1.u
    public final ArrayList r() {
        androidx.room.t r8 = androidx.room.t.k(0, "SELECT * FROM workspec WHERE state=1");
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        Cursor r11 = y0.b.b(r10, r8, false);
        int r12 = y0.a.b(r11, "id");     // Catch: Throwable -> L58
        int r13 = y0.a.b(r11, "state");     // Catch: Throwable -> L58
        int r14 = y0.a.b(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = y0.a.b(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = y0.a.b(r11, QesdkUtils.TAGS.TAG_INPUT);     // Catch: Throwable -> L58
        int r17 = y0.a.b(r11, QesdkUtils.TAGS.TAG_OUTPUT);     // Catch: Throwable -> L58
        int r18 = y0.a.b(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = y0.a.b(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = y0.a.b(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = y0.a.b(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = y0.a.b(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = y0.a.b(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r114 = y0.a.b(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r20 = y0.a.b(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        androidx.room.t r115 = r8;
        int r70 = y0.a.b(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r116 = y0.a.b(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r117 = y0.a.b(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r118 = y0.a.b(r11, "period_count");     // Catch: Throwable -> L56
        int r21 = y0.a.b(r11, "generation");     // Catch: Throwable -> L56
        int r22 = y0.a.b(r11, "required_network_type");     // Catch: Throwable -> L56
        int r23 = y0.a.b(r11, "requires_charging");     // Catch: Throwable -> L56
        int r24 = y0.a.b(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = y0.a.b(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = y0.a.b(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = y0.a.b(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = y0.a.b(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = y0.a.b(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r210 = r20;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        byte[] r31 = null;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        androidx.work.u.a r33 = l6.a.a0(r11.getInt(r13));     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r34 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r36 = null;
    L24:
        androidx.work.e r37 = androidx.work.e.a(r36);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r38 = null;
    L28:
        androidx.work.e r39 = androidx.work.e.a(r38);     // Catch: Throwable -> L56
        long r310 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r40 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        androidx.work.a r46 = l6.a.X(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r114);     // Catch: Throwable -> L56
        int r41 = r210;
        long r51 = r11.getLong(r41);     // Catch: Throwable -> L56
        int r211 = r12;
        int r43 = r70;
        long r53 = r11.getLong(r43);     // Catch: Throwable -> L56
        r70 = r43;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        androidx.work.q r56 = l6.a.Z(r11.getInt(r117));     // Catch: Throwable -> L56
        r117 = r117;
        int r44 = r118;
        int r57 = r11.getInt(r44);     // Catch: Throwable -> L56
        r118 = r44;
        int r48 = r21;
        int r58 = r11.getInt(r48);     // Catch: Throwable -> L56
        r21 = r48;
        int r50 = r22;
        androidx.work.n r60 = l6.a.Y(r11.getInt(r50));     // Catch: Throwable -> L56
        r22 = r50;
        r23 = r23;
        if (r11.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r52 = r28;
        long r67 = r11.getLong(r52);     // Catch: Throwable -> L56
        r28 = r52;
        int r54 = r29;
        if (r11.isNull(r54) == true) goto L52;
        r31 = r11.getBlob(r54);     // Catch: Throwable -> L56
    L52:
        r29 = r54;
        r30.add(new t(r32, r33, r34, r35, r37, r39, r310, r40, r42, new androidx.work.d(r60, r61, r62, r63, r64, r65, r67, l6.a.s(r31)), r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r211;
        r210 = r41;
        goto L6
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r38 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r36 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r35 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r34 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r115.n();
        return r30;
    L56:
        th = th;
    L60:
        r11.close();
        r115.n();
        throw th;
    L58:
        th = th;
        r115 = r8;
        goto L60
    }

    @Override // r1.u
    public final boolean s() {
        boolean r8 = false;
        androidx.room.t r10 = androidx.room.t.k(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
        androidx.room.r r11 = this.f11368a;
        r11.assertNotSuspendingTransaction();
        Cursor r12 = y0.b.b(r11, r10, false);
    L10:
        th = move-exception;
        r12.close();
        r10.n();
        throw th;
    L4:
        if (r12.moveToFirst() == false) goto L8;
        if (r12.getInt(0) == 0) goto L8;
        r8 = true;
    L8:
        r12.close();
        r10.n();
        return r8;
    }

    @Override // r1.u
    public final int t(String r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        m r11 = this.f11377j;
        a1.f r12 = r11.acquire();
        if (r8 != null) goto L5;
        r12.g0(1);
    L6:
        r10.beginTransaction();
        int r13 = r12.g();     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        r11.release(r12);
        return r13;
    L10:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    L5:
        r12.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final ArrayList u(String r19) {
        androidx.room.t r8 = androidx.room.t.k(1, "SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)");
        if (r19 != null) goto L5;
        r8.g0(1);
    L6:
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        Cursor r11 = y0.b.b(r10, r8, true);     // Catch: Throwable -> L43
        n.b<String, ArrayList<String>> r12 = new n.b();     // Catch: Throwable -> L35
        n.b<String, ArrayList<androidx.work.e>> r13 = new n.b();     // Catch: Throwable -> L35
    L10:
        if (r11.moveToNext() == false) goto L17;
        String r14 = r11.getString(0);     // Catch: Throwable -> L35
        if (r12.getOrDefault(r14, null) != null) goto L14;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L35
    L14:
        String r15 = r11.getString(0);     // Catch: Throwable -> L35
        if (r13.getOrDefault(r15, null) != null) goto L10;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L35
        goto L10
    L17:
        r11.moveToPosition(-1);     // Catch: Throwable -> L35
        z(r12);     // Catch: Throwable -> L35
        y(r13);     // Catch: Throwable -> L35
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L35
    L19:
        if (r11.moveToNext() == false) goto L37;
        if (r11.isNull(0) == false) goto L23;
        String r17 = null;
    L24:
        androidx.work.u.a r18 = l6.a.a0(r11.getInt(1));     // Catch: Throwable -> L35
        if (r11.isNull(2) == false) goto L27;
        byte[] r20 = null;
    L28:
        androidx.work.e r110 = androidx.work.e.a(r20);     // Catch: Throwable -> L35
        int r111 = r11.getInt(3);     // Catch: Throwable -> L35
        int r112 = r11.getInt(4);     // Catch: Throwable -> L35
        ArrayList<String> r21 = r12.getOrDefault(r11.getString(0), null);     // Catch: Throwable -> L35
        if (r21 != null) goto L31;
        r21 = new ArrayList();     // Catch: Throwable -> L35
    L31:
        ArrayList<String> r113 = r21;
        ArrayList<androidx.work.e> r22 = r13.getOrDefault(r11.getString(0), null);     // Catch: Throwable -> L35
        if (r22 != null) goto L34;
        r22 = new ArrayList();     // Catch: Throwable -> L35
    L34:
        r16.add(new t.b(r17, r18, r110, r111, r112, r113, r22));     // Catch: Throwable -> L35
        goto L19
    L27:
        r20 = r11.getBlob(2);     // Catch: Throwable -> L35
        goto L28
    L23:
        r17 = r11.getString(0);     // Catch: Throwable -> L35
        goto L24
    L37:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L35
        r11.close();     // Catch: Throwable -> L43
        r8.n();     // Catch: Throwable -> L43
        r10.endTransaction();
        return r16;
    L35:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L43
        r8.n();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r10.endTransaction();
        throw th;
    L5:
        r8.R(1, r19);
        goto L6
    }

    @Override // r1.u
    public final androidx.room.v v(List r8) {
        StringBuilder r10 = android.aimedia.a.j("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r11 = r8.size();
        y0.d.a(r10, r11);
        r10.append(")");
        int r12 = 0;
        int r13 = r11 + 0;
        androidx.room.t r14 = androidx.room.t.k(r13, r10.toString());
        Iterator r15 = r8.iterator();
        int r16 = 1;
    L4:
        if (r15.hasNext() == false) goto L10;
        String r17 = (String) r15.next();
        if (r17 != null) goto L8;
        r14.g0(r16);
    L9:
        r16 = r16 + 1;
        goto L4
    L8:
        r14.R(r16, r17);
        goto L9
    L10:
        androidx.room.i r18 = this.f11368a.getInvalidationTracker();
        w r19 = new w(this, r14);
        r18.getClass();
        String[] r20 = r18.e(new String[]{"WorkTag", "WorkProgress", "workspec"});
        int r21 = r20.length;
    L11:
        if (r12 >= r21) goto L17;
        String r22 = r20[r12];
        LinkedHashMap r23 = r18.f2626d;
        Locale r24 = Locale.US;
        he.i.e(r24, "US");
        String r25 = r22.toLowerCase(r24);
        he.i.e(r25, "this as java.lang.String).toLowerCase(locale)");
        if (r23.containsKey(r25) == false) goto L16;
        r12 = r12 + 1;
        goto L11
    L16:
        throw new IllegalArgumentException("There is no table with name ".concat(r22).toString());
    L17:
        androidx.room.h r26 = r18.f2632j;
        r26.getClass();
        return new androidx.room.v((androidx.room.r) r26.f2620a, r26, r19, r20);
    }

    @Override // r1.u
    public final int w(String r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        l r11 = this.f11376i;
        a1.f r12 = r11.acquire();
        if (r8 != null) goto L5;
        r12.g0(1);
    L6:
        r10.beginTransaction();
        int r13 = r12.g();     // Catch: Throwable -> L10
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        r10.endTransaction();
        r11.release(r12);
        return r13;
    L10:
        th = move-exception;
        r10.endTransaction();
        r11.release(r12);
        throw th;
    L5:
        r12.R(1, r8);
        goto L6
    }

    @Override // r1.u
    public final void x(t r8) {
        androidx.room.r r10 = this.f11368a;
        r10.assertNotSuspendingTransaction();
        r10.beginTransaction();
        this.f11369b.insert(r8);     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    public final void y(n.b<String, ArrayList<androidx.work.e>> r10) {
        n.g.c r8 = (n.g.c) r10.keySet();
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.f9401m <= 999) goto L15;
        n.b<String, ArrayList<androidx.work.e>> r11 = new n.b(999);
        int r12 = r10.f9401m;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L12;
        r11.put(r10.i(r13), r10.k(r13));
        r13 = r13 + 1;
        r14 = r14 + 1;
        if (r14 != 999) goto L8;
        y(r11);
        r11 = new n.b(999);
        r14 = 0;
        goto L8
    L12:
        if (r14 <= 0) goto L59;
        y(r11);
        return;
    L59:
        return;
    L15:
        StringBuilder r15 = android.aimedia.a.j("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int r16 = r8.size();
        y0.d.a(r15, r16);
        r15.append(")");
        androidx.room.t r17 = androidx.room.t.k(r16 + 0, r15.toString());
        Iterator r18 = r8.iterator();
        int r19 = 1;
    L16:
        n.g.a r20 = (n.g.a) r18;
        if (r20.hasNext() == false) goto L23;
        String r21 = (String) r20.next();
        if (r21 != null) goto L21;
        r17.g0(r19);
    L22:
        r19 = r19 + 1;
        goto L16
    L21:
        r17.R(r19, r21);
        goto L22
    L23:
        Cursor r22 = y0.b.b(this.f11368a, r17, false);
        int r23 = y0.a.a(r22, "work_spec_id");     // Catch: Throwable -> L41
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L39;
        byte[] r24 = null;
        ArrayList<androidx.work.e> r25 = r10.getOrDefault(r22.getString(r23), null);     // Catch: Throwable -> L41
        if (r25 == null) goto L29;
        if (r22.isNull(0) == true) goto L37;
        r24 = r22.getBlob(0);     // Catch: Throwable -> L41
    L37:
        r25.add(androidx.work.e.a(r24));     // Catch: Throwable -> L41
        goto L29
    L39:
        r22.close();
        return;
    L41:
        th = move-exception;
        r22.close();
        throw th;
    }

    public final void z(n.b<String, ArrayList<String>> r10) {
        n.g.c r8 = (n.g.c) r10.keySet();
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.f9401m <= 999) goto L15;
        n.b<String, ArrayList<String>> r11 = new n.b(999);
        int r12 = r10.f9401m;
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L12;
        r11.put(r10.i(r13), r10.k(r13));
        r13 = r13 + 1;
        r14 = r14 + 1;
        if (r14 != 999) goto L8;
        z(r11);
        r11 = new n.b(999);
        r14 = 0;
        goto L8
    L12:
        if (r14 <= 0) goto L59;
        z(r11);
        return;
    L59:
        return;
    L15:
        StringBuilder r15 = android.aimedia.a.j("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int r16 = r8.size();
        y0.d.a(r15, r16);
        r15.append(")");
        androidx.room.t r17 = androidx.room.t.k(r16 + 0, r15.toString());
        Iterator r18 = r8.iterator();
        int r19 = 1;
    L16:
        n.g.a r20 = (n.g.a) r18;
        if (r20.hasNext() == false) goto L23;
        String r21 = (String) r20.next();
        if (r21 != null) goto L21;
        r17.g0(r19);
    L22:
        r19 = r19 + 1;
        goto L16
    L21:
        r17.R(r19, r21);
        goto L22
    L23:
        Cursor r22 = y0.b.b(this.f11368a, r17, false);
        int r23 = y0.a.a(r22, "work_spec_id");     // Catch: Throwable -> L41
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L39;
        String r24 = null;
        ArrayList<String> r25 = r10.getOrDefault(r22.getString(r23), null);     // Catch: Throwable -> L41
        if (r25 == null) goto L29;
        if (r22.isNull(0) == true) goto L37;
        r24 = r22.getString(0);     // Catch: Throwable -> L41
    L37:
        r25.add(r24);     // Catch: Throwable -> L41
        goto L29
    L39:
        r22.close();
        return;
    L41:
        th = move-exception;
        r22.close();
        throw th;
    }
}
