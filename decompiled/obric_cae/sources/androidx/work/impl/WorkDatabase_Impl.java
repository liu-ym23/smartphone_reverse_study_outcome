package androidx.work.impl;

import a1.b;
import android.content.Context;
import androidx.room.s;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r1.c;
import r1.g;
import r1.h;
import r1.j;
import r1.k;
import r1.n;
import r1.o;
import r1.q;
import r1.r;
import r1.u;
import r1.v;
import r1.y;
import r1.z;
import y0.e;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile v f2835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile c f2836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile z f2837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile k f2838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile o f2839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile r f2840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile g f2841g;

    public class a extends s.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WorkDatabase_Impl f2842a;

        public a(WorkDatabase_Impl r8) {
            this.f2842a = r8;
            super(16);
        }

        @Override // androidx.room.s.a
        public final void createAllTables(b r8) {
            r8.e("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r8.e("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            r8.e("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            r8.e("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            r8.e("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            r8.e("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            r8.e("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r8.e("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            r8.e("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r8.e("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r8.e("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            r8.e("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r8.e("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            r8.e("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r8.e("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
        }

        @Override // androidx.room.s.a
        public final void dropAllTables(b r8) {
            r8.e("DROP TABLE IF EXISTS `Dependency`");
            r8.e("DROP TABLE IF EXISTS `WorkSpec`");
            r8.e("DROP TABLE IF EXISTS `WorkTag`");
            r8.e("DROP TABLE IF EXISTS `SystemIdInfo`");
            r8.e("DROP TABLE IF EXISTS `WorkName`");
            r8.e("DROP TABLE IF EXISTS `WorkProgress`");
            r8.e("DROP TABLE IF EXISTS `Preference`");
            WorkDatabase_Impl r10 = this.f2842a;
            if (WorkDatabase_Impl.h(r10) == null) goto L7;
            int r11 = WorkDatabase_Impl.i(r10).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((androidx.room.r.b) WorkDatabase_Impl.k(r10).get(r12)).getClass();
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.s.a
        public final void onCreate(b r8) {
            WorkDatabase_Impl r10 = this.f2842a;
            if (WorkDatabase_Impl.l(r10) == null) goto L7;
            int r11 = WorkDatabase_Impl.m(r10).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((androidx.room.r.b) WorkDatabase_Impl.n(r10).get(r12)).getClass();
            i.f(r8, "db");
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.s.a
        public final void onOpen(b r8) {
            WorkDatabase_Impl r10 = this.f2842a;
            WorkDatabase_Impl.o(r10, r8);
            r8.e("PRAGMA foreign_keys = ON");
            r10.internalInitInvalidationTracker(r8);
            if (WorkDatabase_Impl.p(r10) == null) goto L7;
            int r11 = WorkDatabase_Impl.q(r10).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((androidx.room.r.b) WorkDatabase_Impl.j(r10).get(r12)).a(r8);
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.s.a
        public final void onPostMigrate(b r8) {
        }

        @Override // androidx.room.s.a
        public final void onPreMigrate(b r8) {
            y0.b.a(r8);
        }

        @Override // androidx.room.s.a
        public final s.b onValidateSchema(b r40) {
            HashMap r8 = new HashMap(2);
            r8.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, null, 1));
            r8.put("prerequisite_id", new e.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet r10 = new HashSet(2);
            r10.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            r10.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r11 = new HashSet(2);
            r11.add(new e.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            r11.add(new e.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"ASC"})));
            e r12 = new e("Dependency", r8, r10, r11);
            e r13 = e.a(r40, "Dependency");
            if (r12.equals(r13) == false) goto L5;
            HashMap r14 = new HashMap(27);
            r14.put("id", new e.a("id", "TEXT", true, 1, null, 1));
            r14.put("state", new e.a("state", "INTEGER", true, 0, null, 1));
            r14.put("worker_class_name", new e.a("worker_class_name", "TEXT", true, 0, null, 1));
            r14.put("input_merger_class_name", new e.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            r14.put(QesdkUtils.TAGS.TAG_INPUT, new e.a(QesdkUtils.TAGS.TAG_INPUT, "BLOB", true, 0, null, 1));
            r14.put(QesdkUtils.TAGS.TAG_OUTPUT, new e.a(QesdkUtils.TAGS.TAG_OUTPUT, "BLOB", true, 0, null, 1));
            r14.put("initial_delay", new e.a("initial_delay", "INTEGER", true, 0, null, 1));
            r14.put("interval_duration", new e.a("interval_duration", "INTEGER", true, 0, null, 1));
            r14.put("flex_duration", new e.a("flex_duration", "INTEGER", true, 0, null, 1));
            r14.put("run_attempt_count", new e.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            r14.put("backoff_policy", new e.a("backoff_policy", "INTEGER", true, 0, null, 1));
            r14.put("backoff_delay_duration", new e.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            r14.put("last_enqueue_time", new e.a("last_enqueue_time", "INTEGER", true, 0, null, 1));
            r14.put("minimum_retention_duration", new e.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            r14.put("schedule_requested_at", new e.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            r14.put("run_in_foreground", new e.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            r14.put("out_of_quota_policy", new e.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            r14.put("period_count", new e.a("period_count", "INTEGER", true, 0, "0", 1));
            r14.put("generation", new e.a("generation", "INTEGER", true, 0, "0", 1));
            r14.put("required_network_type", new e.a("required_network_type", "INTEGER", true, 0, null, 1));
            r14.put("requires_charging", new e.a("requires_charging", "INTEGER", true, 0, null, 1));
            r14.put("requires_device_idle", new e.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            r14.put("requires_battery_not_low", new e.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            r14.put("requires_storage_not_low", new e.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            r14.put("trigger_content_update_delay", new e.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            r14.put("trigger_max_content_delay", new e.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            r14.put("content_uri_triggers", new e.a("content_uri_triggers", "BLOB", true, 0, null, 1));
            HashSet r15 = new HashSet(0);
            HashSet r16 = new HashSet(2);
            r16.add(new e.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"}), Arrays.asList(new String[]{"ASC"})));
            r16.add(new e.d("index_WorkSpec_last_enqueue_time", false, Arrays.asList(new String[]{"last_enqueue_time"}), Arrays.asList(new String[]{"ASC"})));
            e r17 = new e("WorkSpec", r14, r15, r16);
            e r18 = e.a(r40, "WorkSpec");
            if (r17.equals(r18) == false) goto L9;
            HashMap r19 = new HashMap(2);
            r19.put(LocationMonitorConst.TAG, new e.a(LocationMonitorConst.TAG, "TEXT", true, 1, null, 1));
            r19.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet r20 = new HashSet(1);
            r20.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r21 = new HashSet(1);
            r21.add(new e.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            e r110 = new e("WorkTag", r19, r20, r21);
            e r22 = e.a(r40, "WorkTag");
            if (r110.equals(r22) == false) goto L13;
            HashMap r23 = new HashMap(3);
            r23.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, null, 1));
            r23.put("generation", new e.a("generation", "INTEGER", true, 2, "0", 1));
            r23.put("system_id", new e.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet r24 = new HashSet(1);
            r24.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            e r25 = new e("SystemIdInfo", r23, r24, new HashSet(0));
            e r26 = e.a(r40, "SystemIdInfo");
            if (r25.equals(r26) == false) goto L17;
            HashMap r27 = new HashMap(2);
            r27.put(QesdkUtils.TAGS.JSON_TAG_NAME, new e.a(QesdkUtils.TAGS.JSON_TAG_NAME, "TEXT", true, 1, null, 1));
            r27.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet r28 = new HashSet(1);
            r28.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r29 = new HashSet(1);
            r29.add(new e.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            e r30 = new e("WorkName", r27, r28, r29);
            e r31 = e.a(r40, "WorkName");
            if (r30.equals(r31) == false) goto L21;
            HashMap r32 = new HashMap(2);
            r32.put("work_spec_id", new e.a("work_spec_id", "TEXT", true, 1, null, 1));
            r32.put("progress", new e.a("progress", "BLOB", true, 0, null, 1));
            HashSet r33 = new HashSet(1);
            r33.add(new e.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            e r34 = new e("WorkProgress", r32, r33, new HashSet(0));
            e r35 = e.a(r40, "WorkProgress");
            if (r34.equals(r35) == false) goto L25;
            HashMap r36 = new HashMap(2);
            r36.put("key", new e.a("key", "TEXT", true, 1, null, 1));
            r36.put("long_value", new e.a("long_value", "INTEGER", false, 0, null, 1));
            e r37 = new e("Preference", r36, new HashSet(0), new HashSet(0));
            e r38 = e.a(r40, "Preference");
            if (r37.equals(r38) == true) goto L31;
            return new s.b("Preference(androidx.work.impl.model.Preference).\n Expected:\n" + r37 + "\n Found:\n" + r38, false);
        L31:
            return new s.b(null, true);
        L25:
            return new s.b("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + r34 + "\n Found:\n" + r35, false);
        L21:
            return new s.b("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + r30 + "\n Found:\n" + r31, false);
        L17:
            return new s.b("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + r25 + "\n Found:\n" + r26, false);
        L13:
            return new s.b("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + r110 + "\n Found:\n" + r22, false);
        L9:
            return new s.b("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + r17 + "\n Found:\n" + r18, false);
        L5:
            return new s.b("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + r12 + "\n Found:\n" + r13, false);
        }
    }

    public WorkDatabase_Impl() {
    }

    public static /* synthetic */ List h(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List i(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List j(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List k(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List l(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List m(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List n(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ void o(WorkDatabase_Impl r8, b r10) {
        r8.mDatabase = r10;
    }

    public static /* synthetic */ List p(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ List q(WorkDatabase_Impl r8) {
        return r8.mCallbacks;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final r1.b a() {
        if (this.f2836b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2836b != null) goto L10;
        this.f2836b = new c(this);     // Catch: Throwable -> L13
    L10:
        c r8 = this.f2836b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2836b;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final r1.e b() {
        if (this.f2841g != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2841g != null) goto L10;
        this.f2841g = new g(this);     // Catch: Throwable -> L13
    L10:
        g r8 = this.f2841g;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2841g;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final j c() {
        if (this.f2838d != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2838d != null) goto L10;
        this.f2838d = new k(this);     // Catch: Throwable -> L13
    L10:
        k r8 = this.f2838d;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2838d;
    }

    @Override // androidx.room.r
    public final void clearAllTables() {
        super.assertNotMainThread();
        b r8 = super.getOpenHelper().Z();
        super.beginTransaction();     // Catch: Throwable -> L8
        r8.e("PRAGMA defer_foreign_keys = TRUE");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `Dependency`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `WorkSpec`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `WorkTag`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `SystemIdInfo`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `WorkName`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `WorkProgress`");     // Catch: Throwable -> L8
        r8.e("DELETE FROM `Preference`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r8.a0("PRAGMA wal_checkpoint(FULL)").close();
        if (r8.j0() == true) goto L15;
        r8.e("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r8.a0("PRAGMA wal_checkpoint(FULL)").close();
        if (r8.j0() == true) goto L12;
        r8.e("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.r
    public final androidx.room.i createInvalidationTracker() {
        return new androidx.room.i(this, new HashMap(0), new HashMap(0), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    @Override // androidx.room.r
    public final a1.c createOpenHelper(androidx.room.c r8) {
        s r10 = new s(r8, new a(this), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e");
        Context r11 = r8.f2602a;
        i.f(r11, "context");
        a1.c.b.a r12 = new a1.c.b.a(r11);
        r12.f23b = r8.f2603b;
        r12.f24c = r10;
        a1.c.b r13 = r12.a();
        return r8.f2604c.a(r13);
    }

    @Override // androidx.work.impl.WorkDatabase
    public final n d() {
        if (this.f2839e != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2839e != null) goto L10;
        this.f2839e = new o(this);     // Catch: Throwable -> L13
    L10:
        o r8 = this.f2839e;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2839e;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final q e() {
        if (this.f2840f != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2840f != null) goto L10;
        this.f2840f = new r(this);     // Catch: Throwable -> L13
    L10:
        r r8 = this.f2840f;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2840f;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final u f() {
        if (this.f2835a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2835a != null) goto L10;
        this.f2835a = new v(this);     // Catch: Throwable -> L13
    L10:
        v r8 = this.f2835a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2835a;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final y g() {
        if (this.f2837c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2837c != null) goto L10;
        this.f2837c = new z(this);     // Catch: Throwable -> L13
    L10:
        z r8 = this.f2837c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r8;
    L5:
        return this.f2837c;
    }

    @Override // androidx.room.r
    public final List<x0.a> getAutoMigrations(Map<Class<Object>, Object> r8) {
        return Arrays.asList(new x0.a[]{new j1.y(), new j1.z()});
    }

    @Override // androidx.room.r
    public final Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.r
    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r8 = new HashMap();
        r8.put(u.class, Collections.emptyList());
        r8.put(r1.b.class, Collections.emptyList());
        r8.put(y.class, Collections.emptyList());
        r8.put(j.class, Collections.emptyList());
        r8.put(n.class, Collections.emptyList());
        r8.put(q.class, Collections.emptyList());
        r8.put(r1.e.class, Collections.emptyList());
        r8.put(h.class, Collections.emptyList());
        return r8;
    }
}
