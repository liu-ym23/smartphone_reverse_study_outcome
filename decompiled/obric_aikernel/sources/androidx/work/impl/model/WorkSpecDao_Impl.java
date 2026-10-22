package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueuedTime;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfWorkSpec = new AnonymousClass1(this, r10);
        this.__updateAdapterOfWorkSpec = new AnonymousClass2(this, r10);
        this.__preparedStmtOfDelete = new AnonymousClass3(this, r10);
        this.__preparedStmtOfSetState = new AnonymousClass4(this, r10);
        this.__preparedStmtOfIncrementPeriodCount = new AnonymousClass5(this, r10);
        this.__preparedStmtOfSetOutput = new AnonymousClass6(this, r10);
        this.__preparedStmtOfSetLastEnqueuedTime = new AnonymousClass7(this, r10);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new AnonymousClass8(this, r10);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new AnonymousClass9(this, r10);
        this.__preparedStmtOfMarkWorkSpecScheduled = new AnonymousClass10(this, r10);
        this.__preparedStmtOfResetScheduledState = new AnonymousClass11(this, r10);
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new AnonymousClass12(this, r10);
        this.__preparedStmtOfIncrementGeneration = new AnonymousClass13(this, r10);
    }

    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> r10) {
        Set<String> r11 = r10.keySet();
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<Data>> r12 = new ArrayMap(999);
        int r13 = r10.size();
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L12;
        r12.put(r10.keyAt(r14), r10.valueAt(r14));
        r14 = r14 + 1;
        r15 = r15 + 1;
        if (r15 != 999) goto L8;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r12);
        r12 = new ArrayMap(999);
        r15 = 0;
        goto L8
    L12:
        if (r15 <= 0) goto L59;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r12);
        return;
    L59:
        return;
    L15:
        StringBuilder r16 = StringUtil.newStringBuilder();
        r16.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int r17 = r11.size();
        StringUtil.appendPlaceholders(r16, r17);
        r16.append(")");
        RoomSQLiteQuery r18 = RoomSQLiteQuery.acquire(r16.toString(), r17 + 0);
        Iterator<String> r19 = r11.iterator();
        int r20 = 1;
    L17:
        if (r19.hasNext() == false) goto L23;
        String r21 = r19.next();
        if (r21 != null) goto L21;
        r18.bindNull(r20);
    L22:
        r20 = r20 + 1;
        goto L17
    L21:
        r18.bindString(r20, r21);
        goto L22
    L23:
        Cursor r22 = DBUtil.query(this.__db, r18, false, null);
        int r23 = CursorUtil.getColumnIndex(r22, "work_spec_id");     // Catch: Throwable -> L41
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L39;
        ArrayList<Data> r24 = r10.get(r22.getString(r23));     // Catch: Throwable -> L41
        if (r24 == null) goto L29;
        if (r22.isNull(0) == false) goto L36;
        byte[] r25 = null;
    L37:
        r24.add(Data.fromByteArray(r25));     // Catch: Throwable -> L41
        goto L29
    L36:
        r25 = r22.getBlob(0);     // Catch: Throwable -> L41
        goto L37
    L39:
        r22.close();
        return;
    L41:
        th = move-exception;
        r22.close();
        throw th;
    }

    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> r10) {
        Set<String> r11 = r10.keySet();
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<String>> r12 = new ArrayMap(999);
        int r13 = r10.size();
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L12;
        r12.put(r10.keyAt(r14), r10.valueAt(r14));
        r14 = r14 + 1;
        r15 = r15 + 1;
        if (r15 != 999) goto L8;
        __fetchRelationshipWorkTagAsjavaLangString(r12);
        r12 = new ArrayMap(999);
        r15 = 0;
        goto L8
    L12:
        if (r15 <= 0) goto L59;
        __fetchRelationshipWorkTagAsjavaLangString(r12);
        return;
    L59:
        return;
    L15:
        StringBuilder r16 = StringUtil.newStringBuilder();
        r16.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int r17 = r11.size();
        StringUtil.appendPlaceholders(r16, r17);
        r16.append(")");
        RoomSQLiteQuery r18 = RoomSQLiteQuery.acquire(r16.toString(), r17 + 0);
        Iterator<String> r19 = r11.iterator();
        int r20 = 1;
    L17:
        if (r19.hasNext() == false) goto L23;
        String r21 = r19.next();
        if (r21 != null) goto L21;
        r18.bindNull(r20);
    L22:
        r20 = r20 + 1;
        goto L17
    L21:
        r18.bindString(r20, r21);
        goto L22
    L23:
        Cursor r22 = DBUtil.query(this.__db, r18, false, null);
        int r23 = CursorUtil.getColumnIndex(r22, "work_spec_id");     // Catch: Throwable -> L41
        if (r23 != (-1)) goto L29;
        r22.close();
        return;
    L29:
        if (r22.moveToNext() == false) goto L39;
        ArrayList<String> r24 = r10.get(r22.getString(r23));     // Catch: Throwable -> L41
        if (r24 == null) goto L29;
        if (r22.isNull(0) == false) goto L36;
        String r25 = null;
    L37:
        r24.add(r25);     // Catch: Throwable -> L41
        goto L29
    L36:
        r25 = r22.getString(0);     // Catch: Throwable -> L41
        goto L37
    L39:
        r22.close();
        return;
    L41:
        th = move-exception;
        r22.close();
        throw th;
    }

    static /* synthetic */ RoomDatabase access$000(WorkSpecDao_Impl r10) {
        return r10.__db;
    }

    static /* synthetic */ void access$100(WorkSpecDao_Impl r10, ArrayMap r11) {
        r10.__fetchRelationshipWorkTagAsjavaLangString(r11);
    }

    static /* synthetic */ void access$200(WorkSpecDao_Impl r10, ArrayMap r11) {
        r10.__fetchRelationshipWorkProgressAsandroidxWorkData(r11);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfDelete.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int r71) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        r10.bindLong(1, r71);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L58
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L58
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r114 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r115 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r116 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r210 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r211 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r212 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r22;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r11.getInt(r13);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r36 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r37 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r20);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r21);     // Catch: Throwable -> L56
        int r43 = r30;
        long r51 = r11.getLong(r43);     // Catch: Throwable -> L56
        int r312 = r12;
        int r44 = r114;
        long r53 = r11.getLong(r44);     // Catch: Throwable -> L56
        r114 = r44;
        r115 = r115;
        if (r11.getInt(r115) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r116));     // Catch: Throwable -> L56
        r116 = r116;
        int r48 = r23;
        int r57 = r11.getInt(r48);     // Catch: Throwable -> L56
        r23 = r48;
        int r50 = r24;
        int r58 = r11.getInt(r50);     // Catch: Throwable -> L56
        r24 = r50;
        int r52 = r25;
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r11.getInt(r52));     // Catch: Throwable -> L56
        r25 = r52;
        r26 = r26;
        if (r11.getInt(r26) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r27) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r28) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r29) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r210);     // Catch: Throwable -> L56
        r210 = r210;
        int r54 = r211;
        long r67 = r11.getLong(r54);     // Catch: Throwable -> L56
        r211 = r54;
        int r59 = r212;
        if (r11.isNull(r59) == false) goto L51;
        byte[] r213 = null;
    L52:
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r213));     // Catch: Throwable -> L56
        r212 = r59;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r312;
        r30 = r43;
        goto L6
    L51:
        r213 = r11.getBlob(r59);     // Catch: Throwable -> L56
        goto L52
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
        r40 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r113.release();
        return r31;
    L56:
        th = th;
    L60:
        r11.close();
        r113.release();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L4:
        if (r11.moveToNext() == false) goto L12;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r11.close();
        r10.release();
        return r12;
    L14:
        th = move-exception;
        r11.close();
        r10.release();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L4:
        if (r11.moveToNext() == false) goto L12;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r11.close();
        r10.release();
        return r12;
    L14:
        th = move-exception;
        r11.close();
        r10.release();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new AnonymousClass14(this, r10));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int r71) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        r10.bindLong(1, r71);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L58
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L58
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r114 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r115 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r116 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r210 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r211 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r212 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r22;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r11.getInt(r13);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r36 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r37 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r20);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r21);     // Catch: Throwable -> L56
        int r43 = r30;
        long r51 = r11.getLong(r43);     // Catch: Throwable -> L56
        int r312 = r12;
        int r44 = r114;
        long r53 = r11.getLong(r44);     // Catch: Throwable -> L56
        r114 = r44;
        r115 = r115;
        if (r11.getInt(r115) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r116));     // Catch: Throwable -> L56
        r116 = r116;
        int r48 = r23;
        int r57 = r11.getInt(r48);     // Catch: Throwable -> L56
        r23 = r48;
        int r50 = r24;
        int r58 = r11.getInt(r50);     // Catch: Throwable -> L56
        r24 = r50;
        int r52 = r25;
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r11.getInt(r52));     // Catch: Throwable -> L56
        r25 = r52;
        r26 = r26;
        if (r11.getInt(r26) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r27) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r28) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r29) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r210);     // Catch: Throwable -> L56
        r210 = r210;
        int r54 = r211;
        long r67 = r11.getLong(r54);     // Catch: Throwable -> L56
        r211 = r54;
        int r59 = r212;
        if (r11.isNull(r59) == false) goto L51;
        byte[] r213 = null;
    L52:
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r213));     // Catch: Throwable -> L56
        r212 = r59;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r312;
        r30 = r43;
        goto L6
    L51:
        r213 = r11.getBlob(r59);     // Catch: Throwable -> L56
        goto L52
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
        r40 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r113.release();
        return r31;
    L56:
        th = th;
    L60:
        r11.close();
        r113.release();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        byte[] r14 = null;
    L14:
        r13.add(Data.fromByteArray(r14));     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getBlob(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(long r70) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        r10.bindLong(1, r70);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L58
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L58
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r113 = r10;
        int r71 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r114 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r115 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r116 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r210 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r211 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r212 = r22;
        ArrayList r30 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        if (r11.isNull(r12) == false) goto L11;
        String r31 = null;
    L12:
        int r32 = r11.getInt(r13);     // Catch: Throwable -> L56
        WorkTypeConverters r33 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r34 = WorkTypeConverters.intToState(r32);     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r35 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r36 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r37 = null;
    L24:
        Data r38 = Data.fromByteArray(r37);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r39 = null;
    L28:
        Data r310 = Data.fromByteArray(r39);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r312 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r44 = r11.getInt(r111);     // Catch: Throwable -> L56
        BackoffPolicy r45 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L56
        long r46 = r11.getLong(r20);     // Catch: Throwable -> L56
        long r48 = r11.getLong(r21);     // Catch: Throwable -> L56
        int r40 = r212;
        long r50 = r11.getLong(r40);     // Catch: Throwable -> L56
        int r213 = r12;
        int r42 = r71;
        long r52 = r11.getLong(r42);     // Catch: Throwable -> L56
        r71 = r42;
        r114 = r114;
        if (r11.getInt(r114) == 0) goto L31;
        boolean r54 = true;
    L32:
        OutOfQuotaPolicy r55 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r115));     // Catch: Throwable -> L56
        r115 = r115;
        int r43 = r116;
        int r56 = r11.getInt(r43);     // Catch: Throwable -> L56
        r116 = r43;
        int r47 = r23;
        int r57 = r11.getInt(r47);     // Catch: Throwable -> L56
        r23 = r47;
        int r49 = r24;
        NetworkType r59 = WorkTypeConverters.intToNetworkType(r11.getInt(r49));     // Catch: Throwable -> L56
        r24 = r49;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r60 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r61 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r62 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r63 = true;
    L48:
        long r64 = r11.getLong(r29);     // Catch: Throwable -> L56
        r29 = r29;
        int r51 = r210;
        long r66 = r11.getLong(r51);     // Catch: Throwable -> L56
        r210 = r51;
        int r53 = r211;
        if (r11.isNull(r53) == false) goto L51;
        byte[] r214 = null;
    L52:
        Constraints r410 = new Constraints(r59, r60, r61, r62, r63, r64, r66, WorkTypeConverters.byteArrayToSetOfTriggers(r214));     // Catch: Throwable -> L56
        r211 = r53;
        r30.add(new WorkSpec(r31, r34, r35, r36, r38, r310, r311, r312, r41, r410, r44, r45, r46, r48, r50, r52, r54, r55, r56, r57));     // Catch: Throwable -> L56
        r12 = r213;
        r212 = r40;
        goto L6
    L51:
        r214 = r11.getBlob(r53);     // Catch: Throwable -> L56
        goto L52
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
        r31 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r113.release();
        return r30;
    L56:
        th = th;
    L60:
        r11.close();
        r113.release();
        throw th;
    L58:
        th = th;
        r113 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L58
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L58
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r114 = r10;
        int r115 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r116 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r117 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r210 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r211 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r21;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r11.getInt(r13);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r36 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r37 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r20);     // Catch: Throwable -> L56
        int r43 = r30;
        long r51 = r11.getLong(r43);     // Catch: Throwable -> L56
        int r312 = r12;
        int r44 = r115;
        long r53 = r11.getLong(r44);     // Catch: Throwable -> L56
        r115 = r44;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r117));     // Catch: Throwable -> L56
        r117 = r117;
        int r48 = r22;
        int r57 = r11.getInt(r48);     // Catch: Throwable -> L56
        r22 = r48;
        int r50 = r23;
        int r58 = r11.getInt(r50);     // Catch: Throwable -> L56
        r23 = r50;
        int r52 = r24;
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r11.getInt(r52));     // Catch: Throwable -> L56
        r24 = r52;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r29);     // Catch: Throwable -> L56
        r29 = r29;
        int r54 = r210;
        long r67 = r11.getLong(r54);     // Catch: Throwable -> L56
        r210 = r54;
        int r59 = r211;
        if (r11.isNull(r59) == false) goto L51;
        byte[] r212 = null;
    L52:
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r212));     // Catch: Throwable -> L56
        r211 = r59;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r312;
        r30 = r43;
        goto L6
    L51:
        r212 = r11.getBlob(r59);     // Catch: Throwable -> L56
        goto L52
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
        r40 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r114.release();
        return r31;
    L56:
        th = th;
    L60:
        r11.close();
        r114.release();
        throw th;
    L58:
        th = th;
        r114 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<Long> getScheduleRequestedAtLiveData(String r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new AnonymousClass18(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L58
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L58
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L58
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L58
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L58
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L58
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L58
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L58
        int r113 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L58
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r114 = r10;
        int r115 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L56
        int r116 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L56
        int r117 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r210 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r211 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r21;
        ArrayList r31 = new ArrayList(r11.getCount());     // Catch: Throwable -> L56
    L6:
        if (r11.moveToNext() == false) goto L54;
        if (r11.isNull(r12) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r11.getInt(r13);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r11.isNull(r14) == false) goto L15;
        String r36 = null;
    L17:
        if (r11.isNull(r15) == false) goto L19;
        String r37 = null;
    L21:
        if (r11.isNull(r16) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r11.isNull(r17) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r11.getLong(r18);     // Catch: Throwable -> L56
        long r41 = r11.getLong(r19);     // Catch: Throwable -> L56
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L56
        int r45 = r11.getInt(r111);     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L56
        long r47 = r11.getLong(r113);     // Catch: Throwable -> L56
        long r49 = r11.getLong(r20);     // Catch: Throwable -> L56
        int r43 = r30;
        long r51 = r11.getLong(r43);     // Catch: Throwable -> L56
        int r312 = r12;
        int r44 = r115;
        long r53 = r11.getLong(r44);     // Catch: Throwable -> L56
        r115 = r44;
        r116 = r116;
        if (r11.getInt(r116) == 0) goto L31;
        boolean r55 = true;
    L32:
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r117));     // Catch: Throwable -> L56
        r117 = r117;
        int r48 = r22;
        int r57 = r11.getInt(r48);     // Catch: Throwable -> L56
        r22 = r48;
        int r50 = r23;
        int r58 = r11.getInt(r50);     // Catch: Throwable -> L56
        r23 = r50;
        int r52 = r24;
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r11.getInt(r52));     // Catch: Throwable -> L56
        r24 = r52;
        r25 = r25;
        if (r11.getInt(r25) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r11.getInt(r26) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r11.getInt(r27) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r11.getInt(r28) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r11.getLong(r29);     // Catch: Throwable -> L56
        r29 = r29;
        int r54 = r210;
        long r67 = r11.getLong(r54);     // Catch: Throwable -> L56
        r210 = r54;
        int r59 = r211;
        if (r11.isNull(r59) == false) goto L51;
        byte[] r212 = null;
    L52:
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r212));     // Catch: Throwable -> L56
        r211 = r59;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r12 = r312;
        r30 = r43;
        goto L6
    L51:
        r212 = r11.getBlob(r59);     // Catch: Throwable -> L56
        goto L52
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
        r40 = r11.getBlob(r17);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r11.getBlob(r16);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r11.getString(r15);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r11.getString(r14);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r11.getString(r12);     // Catch: Throwable -> L56
        goto L12
    L54:
        r11.close();
        r114.release();
        return r31;
    L56:
        th = th;
    L60:
        r11.close();
        r114.release();
        throw th;
    L58:
        th = th;
        r114 = r10;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State r12 = null;
        Cursor r13 = DBUtil.query(this.__db, r11, false, null);
    L19:
        th = move-exception;
        r13.close();
        r11.release();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L17:
        r13.close();
        r11.release();
        return r12;
    L10:
        if (r13.isNull(0) == false) goto L12;
        Integer r14 = null;
    L13:
        if (r14 == null) goto L17;
        WorkTypeConverters r15 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L19
        r12 = WorkTypeConverters.intToState(r14.intValue());     // Catch: Throwable -> L19
        goto L17
    L12:
        r14 = Integer.valueOf(r13.getInt(0));     // Catch: Throwable -> L19
        goto L13
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
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
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
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
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String r69) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (r69 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        int r12 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "state");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r11, "worker_class_name");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "input_merger_class_name");     // Catch: Throwable -> L62
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "input");     // Catch: Throwable -> L62
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "output");     // Catch: Throwable -> L62
        int r18 = CursorUtil.getColumnIndexOrThrow(r11, "initial_delay");     // Catch: Throwable -> L62
        int r19 = CursorUtil.getColumnIndexOrThrow(r11, "interval_duration");     // Catch: Throwable -> L62
        int r110 = CursorUtil.getColumnIndexOrThrow(r11, "flex_duration");     // Catch: Throwable -> L62
        int r111 = CursorUtil.getColumnIndexOrThrow(r11, "run_attempt_count");     // Catch: Throwable -> L62
        int r112 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_policy");     // Catch: Throwable -> L62
        int r20 = CursorUtil.getColumnIndexOrThrow(r11, "backoff_delay_duration");     // Catch: Throwable -> L62
        int r21 = CursorUtil.getColumnIndexOrThrow(r11, "last_enqueue_time");     // Catch: Throwable -> L62
        int r22 = CursorUtil.getColumnIndexOrThrow(r11, "minimum_retention_duration");     // Catch: Throwable -> L62
        RoomSQLiteQuery r113 = r10;
        int r23 = CursorUtil.getColumnIndexOrThrow(r11, "schedule_requested_at");     // Catch: Throwable -> L60
        int r24 = CursorUtil.getColumnIndexOrThrow(r11, "run_in_foreground");     // Catch: Throwable -> L60
        int r25 = CursorUtil.getColumnIndexOrThrow(r11, "out_of_quota_policy");     // Catch: Throwable -> L60
        int r26 = CursorUtil.getColumnIndexOrThrow(r11, "period_count");     // Catch: Throwable -> L60
        int r27 = CursorUtil.getColumnIndexOrThrow(r11, "generation");     // Catch: Throwable -> L60
        int r28 = CursorUtil.getColumnIndexOrThrow(r11, "required_network_type");     // Catch: Throwable -> L60
        int r29 = CursorUtil.getColumnIndexOrThrow(r11, "requires_charging");     // Catch: Throwable -> L60
        int r30 = CursorUtil.getColumnIndexOrThrow(r11, "requires_device_idle");     // Catch: Throwable -> L60
        int r31 = CursorUtil.getColumnIndexOrThrow(r11, "requires_battery_not_low");     // Catch: Throwable -> L60
        int r32 = CursorUtil.getColumnIndexOrThrow(r11, "requires_storage_not_low");     // Catch: Throwable -> L60
        int r33 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_content_update_delay");     // Catch: Throwable -> L60
        int r34 = CursorUtil.getColumnIndexOrThrow(r11, "trigger_max_content_delay");     // Catch: Throwable -> L60
        int r35 = CursorUtil.getColumnIndexOrThrow(r11, "content_uri_triggers");     // Catch: Throwable -> L60
        if (r11.moveToFirst() == true) goto L12;
        WorkSpec r36 = null;
    L58:
        r11.close();
        r113.release();
        return r36;
    L12:
        if (r11.isNull(r12) == false) goto L14;
        String r37 = null;
    L15:
        int r38 = r11.getInt(r13);     // Catch: Throwable -> L60
        WorkTypeConverters r39 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        WorkInfo.State r310 = WorkTypeConverters.intToState(r38);     // Catch: Throwable -> L60
        if (r11.isNull(r14) == false) goto L18;
        String r311 = null;
    L20:
        if (r11.isNull(r15) == false) goto L22;
        String r312 = null;
    L24:
        if (r11.isNull(r16) == false) goto L26;
        byte[] r40 = null;
    L27:
        Data r313 = Data.fromByteArray(r40);     // Catch: Throwable -> L60
        if (r11.isNull(r17) == false) goto L30;
        byte[] r41 = null;
    L31:
        Data r314 = Data.fromByteArray(r41);     // Catch: Throwable -> L60
        long r315 = r11.getLong(r18);     // Catch: Throwable -> L60
        long r316 = r11.getLong(r19);     // Catch: Throwable -> L60
        long r42 = r11.getLong(r110);     // Catch: Throwable -> L60
        int r43 = r11.getInt(r111);     // Catch: Throwable -> L60
        BackoffPolicy r44 = WorkTypeConverters.intToBackoffPolicy(r11.getInt(r112));     // Catch: Throwable -> L60
        long r45 = r11.getLong(r20);     // Catch: Throwable -> L60
        long r47 = r11.getLong(r21);     // Catch: Throwable -> L60
        long r49 = r11.getLong(r22);     // Catch: Throwable -> L60
        long r51 = r11.getLong(r23);     // Catch: Throwable -> L60
        if (r11.getInt(r24) == 0) goto L34;
        boolean r53 = true;
    L35:
        OutOfQuotaPolicy r54 = WorkTypeConverters.intToOutOfQuotaPolicy(r11.getInt(r25));     // Catch: Throwable -> L60
        int r55 = r11.getInt(r26);     // Catch: Throwable -> L60
        int r56 = r11.getInt(r27);     // Catch: Throwable -> L60
        NetworkType r58 = WorkTypeConverters.intToNetworkType(r11.getInt(r28));     // Catch: Throwable -> L60
        if (r11.getInt(r29) == 0) goto L38;
        boolean r59 = true;
    L40:
        if (r11.getInt(r30) == 0) goto L42;
        boolean r60 = true;
    L44:
        if (r11.getInt(r31) == 0) goto L46;
        boolean r61 = true;
    L48:
        if (r11.getInt(r32) == 0) goto L50;
        boolean r62 = true;
    L51:
        long r63 = r11.getLong(r33);     // Catch: Throwable -> L60
        long r65 = r11.getLong(r34);     // Catch: Throwable -> L60
        if (r11.isNull(r35) == false) goto L54;
        byte[] r46 = null;
    L55:
        r36 = new WorkSpec(r37, r310, r311, r312, r313, r314, r315, r316, r42, new Constraints(r58, r59, r60, r61, r62, r63, r65, WorkTypeConverters.byteArrayToSetOfTriggers(r46)), r43, r44, r45, r47, r49, r51, r53, r54, r55, r56);     // Catch: Throwable -> L60
        goto L58
    L54:
        r46 = r11.getBlob(r35);     // Catch: Throwable -> L60
        goto L55
    L50:
        r62 = false;
        goto L51
    L46:
        r61 = false;
        goto L48
    L42:
        r60 = false;
        goto L44
    L38:
        r59 = false;
        goto L40
    L34:
        r53 = false;
        goto L35
    L30:
        r41 = r11.getBlob(r17);     // Catch: Throwable -> L60
        goto L31
    L26:
        r40 = r11.getBlob(r16);     // Catch: Throwable -> L60
        goto L27
    L22:
        r312 = r11.getString(r15);     // Catch: Throwable -> L60
        goto L24
    L18:
        r311 = r11.getString(r14);     // Catch: Throwable -> L60
        goto L20
    L14:
        r37 = r11.getString(r12);     // Catch: Throwable -> L60
    L60:
        th = th;
    L64:
        r11.close();
        r113.release();
        throw th;
    L62:
        th = th;
        r113 = r10;
        goto L64
    L5:
        r10.bindString(1, r69);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        int r15 = r12.getInt(1);     // Catch: Throwable -> L18
        WorkTypeConverters r16 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L18
        r13.add(new WorkSpec.IdAndState(r14, WorkTypeConverters.intToState(r15)));     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String r18) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?", 1);
        if (r18 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        WorkSpec.WorkInfoPojo r11 = null;
        byte[] r12 = null;
        Cursor r13 = DBUtil.query(this.__db, r10, true, null);     // Catch: Throwable -> L41
        ArrayMap<String, ArrayList<String>> r14 = new ArrayMap();     // Catch: Throwable -> L38
        ArrayMap<String, ArrayList<Data>> r15 = new ArrayMap();     // Catch: Throwable -> L38
    L10:
        if (r13.moveToNext() == false) goto L17;
        String r16 = r13.getString(0);     // Catch: Throwable -> L38
        if (r14.get(r16) != null) goto L14;
        r14.put(r16, new ArrayList());     // Catch: Throwable -> L38
    L14:
        String r17 = r13.getString(0);     // Catch: Throwable -> L38
        if (r15.get(r17) != null) goto L10;
        r15.put(r17, new ArrayList());     // Catch: Throwable -> L38
        goto L10
    L17:
        r13.moveToPosition(-1);     // Catch: Throwable -> L38
        __fetchRelationshipWorkTagAsjavaLangString(r14);     // Catch: Throwable -> L38
        __fetchRelationshipWorkProgressAsandroidxWorkData(r15);     // Catch: Throwable -> L38
        if (r13.moveToFirst() == true) goto L20;
    L34:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L38
        r13.close();     // Catch: Throwable -> L41
        r10.release();     // Catch: Throwable -> L41
        this.__db.endTransaction();
        return r11;
    L20:
        if (r13.isNull(0) == false) goto L22;
        String r19 = null;
    L23:
        int r20 = r13.getInt(1);     // Catch: Throwable -> L38
        WorkTypeConverters r21 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L38
        WorkInfo.State r110 = WorkTypeConverters.intToState(r20);     // Catch: Throwable -> L38
        if (r13.isNull(2) == true) goto L27;
        r12 = r13.getBlob(2);     // Catch: Throwable -> L38
    L27:
        Data r111 = Data.fromByteArray(r12);     // Catch: Throwable -> L38
        int r112 = r13.getInt(3);     // Catch: Throwable -> L38
        int r113 = r13.getInt(4);     // Catch: Throwable -> L38
        ArrayList<String> r22 = r14.get(r13.getString(0));     // Catch: Throwable -> L38
        if (r22 != null) goto L30;
        r22 = new ArrayList();     // Catch: Throwable -> L38
    L30:
        ArrayList<String> r114 = r22;
        ArrayList<Data> r23 = r15.get(r13.getString(0));     // Catch: Throwable -> L38
        if (r23 != null) goto L33;
        r23 = new ArrayList();     // Catch: Throwable -> L38
    L33:
        r11 = new WorkSpec.WorkInfoPojo(r19, r110, r111, r112, r113, r114, r23);     // Catch: Throwable -> L38
        goto L34
    L22:
        r19 = r13.getString(0);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L41
        r10.release();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r10.bindString(1, r18);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> r19) {
        StringBuilder r10 = StringUtil.newStringBuilder();
        r10.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r11 = r19.size();
        StringUtil.appendPlaceholders(r10, r11);
        r10.append(")");
        RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire(r10.toString(), r11 + 0);
        Iterator<String> r13 = r19.iterator();
        int r14 = 1;
    L4:
        if (r13.hasNext() == false) goto L10;
        String r15 = r13.next();
        if (r15 != null) goto L8;
        r12.bindNull(r14);
    L9:
        r14 = r14 + 1;
        goto L4
    L8:
        r12.bindString(r14, r15);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r16 = DBUtil.query(this.__db, r12, true, null);     // Catch: Throwable -> L46
        ArrayMap<String, ArrayList<String>> r17 = new ArrayMap();     // Catch: Throwable -> L43
        ArrayMap<String, ArrayList<Data>> r18 = new ArrayMap();     // Catch: Throwable -> L43
    L14:
        if (r16.moveToNext() == false) goto L21;
        String r20 = r16.getString(0);     // Catch: Throwable -> L43
        if (r17.get(r20) != null) goto L18;
        r17.put(r20, new ArrayList());     // Catch: Throwable -> L43
    L18:
        String r21 = r16.getString(0);     // Catch: Throwable -> L43
        if (r18.get(r21) != null) goto L14;
        r18.put(r21, new ArrayList());     // Catch: Throwable -> L43
        goto L14
    L21:
        r16.moveToPosition(-1);     // Catch: Throwable -> L43
        __fetchRelationshipWorkTagAsjavaLangString(r17);     // Catch: Throwable -> L43
        __fetchRelationshipWorkProgressAsandroidxWorkData(r18);     // Catch: Throwable -> L43
        ArrayList r22 = new ArrayList(r16.getCount());     // Catch: Throwable -> L43
    L23:
        if (r16.moveToNext() == false) goto L39;
        if (r16.isNull(0) == false) goto L27;
        String r110 = null;
    L28:
        int r23 = r16.getInt(1);     // Catch: Throwable -> L43
        WorkTypeConverters r111 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L43
        WorkInfo.State r112 = WorkTypeConverters.intToState(r23);     // Catch: Throwable -> L43
        if (r16.isNull(2) == false) goto L31;
        byte[] r24 = null;
    L32:
        Data r113 = Data.fromByteArray(r24);     // Catch: Throwable -> L43
        int r114 = r16.getInt(3);     // Catch: Throwable -> L43
        int r115 = r16.getInt(4);     // Catch: Throwable -> L43
        ArrayList<String> r25 = r17.get(r16.getString(0));     // Catch: Throwable -> L43
        if (r25 != null) goto L35;
        r25 = new ArrayList();     // Catch: Throwable -> L43
    L35:
        ArrayList<String> r116 = r25;
        ArrayList<Data> r26 = r18.get(r16.getString(0));     // Catch: Throwable -> L43
        if (r26 != null) goto L38;
        r26 = new ArrayList();     // Catch: Throwable -> L43
    L38:
        r22.add(new WorkSpec.WorkInfoPojo(r110, r112, r113, r114, r115, r116, r26));     // Catch: Throwable -> L43
        goto L23
    L31:
        r24 = r16.getBlob(2);     // Catch: Throwable -> L43
        goto L32
    L27:
        r110 = r16.getString(0);     // Catch: Throwable -> L43
        goto L28
    L39:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L43
        r16.close();     // Catch: Throwable -> L46
        r12.release();     // Catch: Throwable -> L46
        this.__db.endTransaction();
        return r22;
    L43:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L46
        r12.release();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String r19) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r19 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, true, null);     // Catch: Throwable -> L42
        ArrayMap<String, ArrayList<String>> r12 = new ArrayMap();     // Catch: Throwable -> L39
        ArrayMap<String, ArrayList<Data>> r13 = new ArrayMap();     // Catch: Throwable -> L39
    L10:
        if (r11.moveToNext() == false) goto L17;
        String r14 = r11.getString(0);     // Catch: Throwable -> L39
        if (r12.get(r14) != null) goto L14;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L39
    L14:
        String r15 = r11.getString(0);     // Catch: Throwable -> L39
        if (r13.get(r15) != null) goto L10;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L39
        goto L10
    L17:
        r11.moveToPosition(-1);     // Catch: Throwable -> L39
        __fetchRelationshipWorkTagAsjavaLangString(r12);     // Catch: Throwable -> L39
        __fetchRelationshipWorkProgressAsandroidxWorkData(r13);     // Catch: Throwable -> L39
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L39
    L19:
        if (r11.moveToNext() == false) goto L35;
        if (r11.isNull(0) == false) goto L23;
        String r17 = null;
    L24:
        int r18 = r11.getInt(1);     // Catch: Throwable -> L39
        WorkTypeConverters r110 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L39
        WorkInfo.State r111 = WorkTypeConverters.intToState(r18);     // Catch: Throwable -> L39
        if (r11.isNull(2) == false) goto L27;
        byte[] r20 = null;
    L28:
        Data r112 = Data.fromByteArray(r20);     // Catch: Throwable -> L39
        int r113 = r11.getInt(3);     // Catch: Throwable -> L39
        int r114 = r11.getInt(4);     // Catch: Throwable -> L39
        ArrayList<String> r21 = r12.get(r11.getString(0));     // Catch: Throwable -> L39
        if (r21 != null) goto L31;
        r21 = new ArrayList();     // Catch: Throwable -> L39
    L31:
        ArrayList<String> r115 = r21;
        ArrayList<Data> r22 = r13.get(r11.getString(0));     // Catch: Throwable -> L39
        if (r22 != null) goto L34;
        r22 = new ArrayList();     // Catch: Throwable -> L39
    L34:
        r16.add(new WorkSpec.WorkInfoPojo(r17, r111, r112, r113, r114, r115, r22));     // Catch: Throwable -> L39
        goto L19
    L27:
        r20 = r11.getBlob(2);     // Catch: Throwable -> L39
        goto L28
    L23:
        r17 = r11.getString(0);     // Catch: Throwable -> L39
        goto L24
    L35:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L39
        r11.close();     // Catch: Throwable -> L42
        r10.release();     // Catch: Throwable -> L42
        this.__db.endTransaction();
        return r16;
    L39:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L42
        r10.release();     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r10.bindString(1, r19);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String r19) {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r19 != null) goto L5;
        r10.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, true, null);     // Catch: Throwable -> L42
        ArrayMap<String, ArrayList<String>> r12 = new ArrayMap();     // Catch: Throwable -> L39
        ArrayMap<String, ArrayList<Data>> r13 = new ArrayMap();     // Catch: Throwable -> L39
    L10:
        if (r11.moveToNext() == false) goto L17;
        String r14 = r11.getString(0);     // Catch: Throwable -> L39
        if (r12.get(r14) != null) goto L14;
        r12.put(r14, new ArrayList());     // Catch: Throwable -> L39
    L14:
        String r15 = r11.getString(0);     // Catch: Throwable -> L39
        if (r13.get(r15) != null) goto L10;
        r13.put(r15, new ArrayList());     // Catch: Throwable -> L39
        goto L10
    L17:
        r11.moveToPosition(-1);     // Catch: Throwable -> L39
        __fetchRelationshipWorkTagAsjavaLangString(r12);     // Catch: Throwable -> L39
        __fetchRelationshipWorkProgressAsandroidxWorkData(r13);     // Catch: Throwable -> L39
        ArrayList r16 = new ArrayList(r11.getCount());     // Catch: Throwable -> L39
    L19:
        if (r11.moveToNext() == false) goto L35;
        if (r11.isNull(0) == false) goto L23;
        String r17 = null;
    L24:
        int r18 = r11.getInt(1);     // Catch: Throwable -> L39
        WorkTypeConverters r110 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L39
        WorkInfo.State r111 = WorkTypeConverters.intToState(r18);     // Catch: Throwable -> L39
        if (r11.isNull(2) == false) goto L27;
        byte[] r20 = null;
    L28:
        Data r112 = Data.fromByteArray(r20);     // Catch: Throwable -> L39
        int r113 = r11.getInt(3);     // Catch: Throwable -> L39
        int r114 = r11.getInt(4);     // Catch: Throwable -> L39
        ArrayList<String> r21 = r12.get(r11.getString(0));     // Catch: Throwable -> L39
        if (r21 != null) goto L31;
        r21 = new ArrayList();     // Catch: Throwable -> L39
    L31:
        ArrayList<String> r115 = r21;
        ArrayList<Data> r22 = r13.get(r11.getString(0));     // Catch: Throwable -> L39
        if (r22 != null) goto L34;
        r22 = new ArrayList();     // Catch: Throwable -> L39
    L34:
        r16.add(new WorkSpec.WorkInfoPojo(r17, r111, r112, r113, r114, r115, r22));     // Catch: Throwable -> L39
        goto L19
    L27:
        r20 = r11.getBlob(2);     // Catch: Throwable -> L39
        goto L28
    L23:
        r17 = r11.getString(0);     // Catch: Throwable -> L39
        goto L24
    L35:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L39
        r11.close();     // Catch: Throwable -> L42
        r10.release();     // Catch: Throwable -> L42
        this.__db.endTransaction();
        return r16;
    L39:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L42
        r10.release();     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r10.bindString(1, r19);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> r10) {
        StringBuilder r11 = StringUtil.newStringBuilder();
        r11.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r12 = r10.size();
        StringUtil.appendPlaceholders(r11, r12);
        r11.append(")");
        final RoomSQLiteQuery r13 = RoomSQLiteQuery.acquire(r11.toString(), r12 + 0);
        Iterator<String> r14 = r10.iterator();
        int r15 = 1;
    L4:
        if (r14.hasNext() == false) goto L11;
        String r16 = r14.next();
        if (r16 != null) goto L8;
        r13.bindNull(r15);
    L9:
        r15 = r15 + 1;
        goto L4
    L8:
        r13.bindString(r15, r16);
        goto L9
    L11:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new AnonymousClass15(this, r13));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new AnonymousClass17(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new AnonymousClass16(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean hasUnfinishedWork() {
        boolean r10 = false;
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
    L10:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L4:
        if (r12.moveToFirst() == false) goto L8;
        if (r12.getInt(0) == 0) goto L8;
        r10 = true;
    L8:
        r12.close();
        r11.release();
        return r10;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfIncrementGeneration.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementGeneration.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementGeneration.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementPeriodCount.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementPeriodCount.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(r11);
        return r12;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkSpec.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String r10, long r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r12 = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        r12.bindLong(1, r11);
        if (r10 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r13 = r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfMarkWorkSpecScheduled.release(r12);
        return r13;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkWorkSpecScheduled.release(r12);
        throw th;
    L5:
        r12.bindString(2, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r10 = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(r10);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r10 = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        int r11 = r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetScheduledState.release(r10);
        return r11;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetScheduledState.release(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(r11);
        return r12;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueuedTime(String r10, long r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r12 = this.__preparedStmtOfSetLastEnqueuedTime.acquire();
        r12.bindLong(1, r11);
        if (r10 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.__db.beginTransaction();
        r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfSetLastEnqueuedTime.release(r12);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetLastEnqueuedTime.release(r12);
        throw th;
    L5:
        r12.bindString(2, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String r10, Data r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r12 = this.__preparedStmtOfSetOutput.acquire();
        byte[] r13 = Data.toByteArrayInternal(r11);
        if (r13 != null) goto L5;
        r12.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r12.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r12.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfSetOutput.release(r12);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetOutput.release(r12);
        throw th;
    L9:
        r12.bindString(2, r10);
        goto L10
    L5:
        r12.bindBlob(1, r13);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State r10, String r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r12 = this.__preparedStmtOfSetState.acquire();
        WorkTypeConverters r13 = WorkTypeConverters.INSTANCE;
        r12.bindLong(1, WorkTypeConverters.stateToInt(r10));
        if (r11 != null) goto L5;
        r12.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r14 = r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfSetState.release(r12);
        return r14;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetState.release(r12);
        throw th;
    L5:
        r12.bindString(2, r11);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(WorkSpec r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfWorkSpec.handle(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
