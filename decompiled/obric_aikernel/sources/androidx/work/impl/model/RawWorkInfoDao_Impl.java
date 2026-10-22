package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.WorkInfo;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase r10) {
        this.__db = r10;
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

    static /* synthetic */ RoomDatabase access$000(RawWorkInfoDao_Impl r10) {
        return r10.__db;
    }

    static /* synthetic */ void access$100(RawWorkInfoDao_Impl r10, ArrayMap r11) {
        r10.__fetchRelationshipWorkTagAsjavaLangString(r11);
    }

    static /* synthetic */ void access$200(RawWorkInfoDao_Impl r10, ArrayMap r11) {
        r10.__fetchRelationshipWorkProgressAsandroidxWorkData(r11);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery r21) {
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r21, true, null);
        int r11 = CursorUtil.getColumnIndex(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L48
        int r12 = CursorUtil.getColumnIndex(r10, "state");     // Catch: Throwable -> L48
        int r13 = CursorUtil.getColumnIndex(r10, "output");     // Catch: Throwable -> L48
        int r14 = CursorUtil.getColumnIndex(r10, "run_attempt_count");     // Catch: Throwable -> L48
        int r15 = CursorUtil.getColumnIndex(r10, "generation");     // Catch: Throwable -> L48
        ArrayMap<String, ArrayList<String>> r16 = new ArrayMap();     // Catch: Throwable -> L48
        ArrayMap<String, ArrayList<Data>> r17 = new ArrayMap();     // Catch: Throwable -> L48
    L5:
        if (r10.moveToNext() == false) goto L12;
        String r18 = r10.getString(r11);     // Catch: Throwable -> L48
        if (r16.get(r18) != null) goto L9;
        r16.put(r18, new ArrayList());     // Catch: Throwable -> L48
    L9:
        String r19 = r10.getString(r11);     // Catch: Throwable -> L48
        if (r17.get(r19) != null) goto L5;
        r17.put(r19, new ArrayList());     // Catch: Throwable -> L48
        goto L5
    L12:
        r10.moveToPosition(-1);     // Catch: Throwable -> L48
        __fetchRelationshipWorkTagAsjavaLangString(r16);     // Catch: Throwable -> L48
        __fetchRelationshipWorkProgressAsandroidxWorkData(r17);     // Catch: Throwable -> L48
        ArrayList r20 = new ArrayList(r10.getCount());     // Catch: Throwable -> L48
    L13:
        if (r10.moveToNext() == false) goto L46;
        if (r11 != (-1)) goto L18;
    L16:
        String r110 = null;
    L21:
        if (r12 != (-1)) goto L23;
        WorkInfo.State r111 = null;
    L24:
        if (r13 != (-1)) goto L27;
        Data r112 = null;
    L31:
        int r113 = 0;
        if (r14 != (-1)) goto L34;
        int r114 = 0;
    L35:
        if (r15 != (-1)) goto L37;
    L36:
        int r115 = r113;
        ArrayList<String> r116 = r16.get(r10.getString(r11));     // Catch: Throwable -> L48
        if (r116 != null) goto L41;
        r116 = new ArrayList();     // Catch: Throwable -> L48
    L41:
        ArrayList<String> r117 = r116;
        ArrayList<Data> r118 = r17.get(r10.getString(r11));     // Catch: Throwable -> L48
        if (r118 != null) goto L44;
        r118 = new ArrayList();     // Catch: Throwable -> L48
    L44:
        r20.add(new WorkSpec.WorkInfoPojo(r110, r111, r112, r114, r115, r117, r118));     // Catch: Throwable -> L48
        goto L13
    L37:
        r113 = r10.getInt(r15);     // Catch: Throwable -> L48
        goto L36
    L34:
        r114 = r10.getInt(r14);     // Catch: Throwable -> L48
        goto L35
    L27:
        if (r10.isNull(r13) == false) goto L29;
        byte[] r119 = null;
    L30:
        r112 = Data.fromByteArray(r119);     // Catch: Throwable -> L48
        goto L31
    L29:
        r119 = r10.getBlob(r13);     // Catch: Throwable -> L48
        goto L30
    L23:
        int r120 = r10.getInt(r12);     // Catch: Throwable -> L48
        WorkTypeConverters r121 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L48
        r111 = WorkTypeConverters.intToState(r120);     // Catch: Throwable -> L48
        goto L24
    L18:
        if (r10.isNull(r11) == true) goto L16;
        r110 = r10.getString(r11);     // Catch: Throwable -> L48
        goto L21
    L46:
        r10.close();
        return r20;
    L48:
        th = move-exception;
        r10.close();
        throw th;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery r10) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new AnonymousClass1(this, r10));
    }
}
