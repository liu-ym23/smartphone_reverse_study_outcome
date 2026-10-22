package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ContactRawDbDao_Impl implements ContactRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fx> __deletionAdapterOfRawContactEntity;
    private final EntityInsertionAdapter<fx> __insertionAdapterOfRawContactEntity;
    private final EntityDeletionOrUpdateAdapter<fx> __updateAdapterOfRawContactEntity;

    public ContactRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawContactEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawContactEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawContactEntity = new AnonymousClass3(this, r2);
    }

    private fx __entityCursorConverter_comObricMemorydataDatabaseEntityRawContactEntity(Cursor r81) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r81, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r11 = CursorUtil.getColumnIndex(r0, "telephones");
        int r12 = CursorUtil.getColumnIndex(r0, "telephonesValues");
        int r13 = CursorUtil.getColumnIndex(r0, "avatar");
        int r14 = CursorUtil.getColumnIndex(r0, "note");
        int r15 = CursorUtil.getColumnIndex(r0, "gender");
        int r16 = CursorUtil.getColumnIndex(r0, "credentialNumbers");
        int r17 = CursorUtil.getColumnIndex(r0, "credentialValues");
        int r18 = CursorUtil.getColumnIndex(r0, "emails");
        int r19 = CursorUtil.getColumnIndex(r0, "emailsValues");
        int r110 = CursorUtil.getColumnIndex(r0, "addresses");
        int r111 = CursorUtil.getColumnIndex(r0, "addressesValues");
        int r112 = CursorUtil.getColumnIndex(r0, "company");
        int r113 = CursorUtil.getColumnIndex(r0, "instantMessagings");
        int r114 = CursorUtil.getColumnIndex(r0, "anniversaries");
        int r115 = CursorUtil.getColumnIndex(r0, "anniversariesValues");
        int r116 = CursorUtil.getColumnIndex(r0, "voip");
        int r117 = CursorUtil.getColumnIndex(r0, "relationShips");
        int r118 = CursorUtil.getColumnIndex(r0, "relationShipsValues");
        int r119 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r120 = CursorUtil.getColumnIndex(r0, "department");
        int r121 = CursorUtil.getColumnIndex(r0, "jobTitle");
        int r122 = CursorUtil.getColumnIndex(r0, "subNote");
        int r123 = CursorUtil.getColumnIndex(r0, "website");
        int r124 = CursorUtil.getColumnIndex(r0, "telephoneStandardMap");
        int r125 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r126 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r127 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r36 = 0;
        if (r1 != (-1)) goto L5;
        long r42 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r44 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r45 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r47 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r49 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r36 = r0.getLong(r6);
    L26:
        long r50 = r36;
        if (r7 != (-1)) goto L30;
    L28:
        String r52 = null;
    L33:
        if (r8 == (-1)) goto L36;
        r21 = r0.getInt(r8);
    L36:
        int r53 = r21;
        if (r9 != (-1)) goto L40;
    L38:
        String r54 = null;
    L43:
        if (r10 != (-1)) goto L46;
    L44:
        String r55 = null;
    L49:
        if (r11 != (-1)) goto L52;
    L50:
        String r56 = null;
    L55:
        if (r12 != (-1)) goto L58;
    L56:
        String r57 = null;
    L61:
        if (r13 != (-1)) goto L64;
    L62:
        String r58 = null;
    L67:
        if (r14 != (-1)) goto L70;
    L68:
        String r59 = null;
    L73:
        if (r80 != (-1)) goto L76;
    L74:
        String r60 = null;
    L79:
        if (r81 != (-1)) goto L83;
    L80:
        String r61 = null;
    L86:
        if (r17 != (-1)) goto L90;
    L87:
        String r62 = null;
    L93:
        if (r18 != (-1)) goto L97;
    L94:
        String r63 = null;
    L100:
        if (r19 != (-1)) goto L104;
    L101:
        String r64 = null;
    L107:
        if (r110 != (-1)) goto L111;
    L108:
        String r65 = null;
    L114:
        if (r111 != (-1)) goto L118;
    L115:
        String r66 = null;
    L121:
        if (r112 != (-1)) goto L125;
    L122:
        String r67 = null;
    L128:
        if (r113 != (-1)) goto L132;
    L129:
        String r68 = null;
    L135:
        if (r114 != (-1)) goto L139;
    L136:
        String r69 = null;
    L142:
        if (r115 != (-1)) goto L146;
    L143:
        String r70 = null;
    L149:
        if (r116 != (-1)) goto L153;
    L150:
        String r71 = null;
    L156:
        if (r117 != (-1)) goto L160;
    L157:
        String r72 = null;
    L163:
        if (r118 != (-1)) goto L167;
    L164:
        String r73 = null;
    L170:
        if (r119 != (-1)) goto L174;
    L171:
        String r74 = null;
    L177:
        if (r120 != (-1)) goto L181;
    L178:
        String r75 = null;
    L184:
        if (r121 != (-1)) goto L188;
    L185:
        String r76 = null;
    L191:
        if (r122 != (-1)) goto L195;
    L192:
        String r77 = null;
    L198:
        if (r123 != (-1)) goto L202;
    L199:
        String r78 = null;
    L205:
        if (r124 != (-1)) goto L208;
    L206:
        String r79 = null;
    L211:
        fx r22 = new fx(r42, r44, r45, r47, r49, r50, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79);
        if (r125 == (-1)) goto L219;
        if (r0.isNull(r125) == false) goto L216;
        Integer r23 = null;
    L217:
        r22.setPoisonLabel(r23);
        goto L219
    L216:
        r23 = Integer.valueOf(r0.getInt(r125));
    L219:
        if (r126 == (-1)) goto L226;
        if (r0.isNull(r126) == false) goto L223;
        Integer r24 = null;
    L224:
        r22.setPoisonLabelVersion(r24);
        goto L226
    L223:
        r24 = Integer.valueOf(r0.getInt(r126));
    L226:
        if (r127 != (-1)) goto L228;
    L232:
        return r22;
    L228:
        if (r0.isNull(r127) == true) goto L231;
        r20 = r0.getString(r127);
    L231:
        r22.setContentHash(r20);
        goto L232
    L208:
        if (r0.isNull(r124) == true) goto L206;
        r79 = r0.getString(r124);
        goto L211
    L202:
        if (r0.isNull(r123) == true) goto L199;
        r78 = r0.getString(r123);
        goto L205
    L195:
        if (r0.isNull(r122) == true) goto L192;
        r77 = r0.getString(r122);
        goto L198
    L188:
        if (r0.isNull(r121) == true) goto L185;
        r76 = r0.getString(r121);
        goto L191
    L181:
        if (r0.isNull(r120) == true) goto L178;
        r75 = r0.getString(r120);
        goto L184
    L174:
        if (r0.isNull(r119) == true) goto L171;
        r74 = r0.getString(r119);
        goto L177
    L167:
        if (r0.isNull(r118) == true) goto L164;
        r73 = r0.getString(r118);
        goto L170
    L160:
        if (r0.isNull(r117) == true) goto L157;
        r72 = r0.getString(r117);
        goto L163
    L153:
        if (r0.isNull(r116) == true) goto L150;
        r71 = r0.getString(r116);
        goto L156
    L146:
        if (r0.isNull(r115) == true) goto L143;
        r70 = r0.getString(r115);
        goto L149
    L139:
        if (r0.isNull(r114) == true) goto L136;
        r69 = r0.getString(r114);
        goto L142
    L132:
        if (r0.isNull(r113) == true) goto L129;
        r68 = r0.getString(r113);
        goto L135
    L125:
        if (r0.isNull(r112) == true) goto L122;
        r67 = r0.getString(r112);
        goto L128
    L118:
        if (r0.isNull(r111) == true) goto L115;
        r66 = r0.getString(r111);
        goto L121
    L111:
        if (r0.isNull(r110) == true) goto L108;
        r65 = r0.getString(r110);
        goto L114
    L104:
        if (r0.isNull(r19) == true) goto L101;
        r64 = r0.getString(r19);
        goto L107
    L97:
        if (r0.isNull(r18) == true) goto L94;
        r63 = r0.getString(r18);
        goto L100
    L90:
        if (r0.isNull(r17) == true) goto L87;
        r62 = r0.getString(r17);
        goto L93
    L83:
        if (r0.isNull(r81) == true) goto L80;
        r61 = r0.getString(r16);
        goto L86
    L76:
        if (r0.isNull(r80) == true) goto L74;
        r60 = r0.getString(r15);
        goto L79
    L70:
        if (r0.isNull(r14) == true) goto L68;
        r59 = r0.getString(r14);
        goto L73
    L64:
        if (r0.isNull(r13) == true) goto L62;
        r58 = r0.getString(r13);
        goto L67
    L58:
        if (r0.isNull(r12) == true) goto L56;
        r57 = r0.getString(r12);
        goto L61
    L52:
        if (r0.isNull(r11) == true) goto L50;
        r56 = r0.getString(r11);
        goto L55
    L46:
        if (r0.isNull(r10) == true) goto L44;
        r55 = r0.getString(r10);
        goto L49
    L40:
        if (r0.isNull(r9) == true) goto L38;
        r54 = r0.getString(r9);
        goto L43
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r52 = r0.getString(r7);
        goto L33
    L22:
        r49 = r0.getInt(r5);
        goto L23
    L18:
        r47 = r0.getLong(r4);
        goto L19
    L15:
        r45 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r44 = r0.getString(r2);
        goto L13
    L5:
        r42 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return ContactRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fx> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawContactEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fx> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawContactEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int delete(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    public int delete(fx r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawContactEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(Object r3) {
        return delete((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ContactRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return ContactRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCount(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageName(String r1) {
        return ContactRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return ContactRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return ContactRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(SupportSQLiteQuery r8) {
        SupportSQLiteQuery r9 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r9, false, null);
        int r10 = CursorUtil.getColumnIndex(r7, "entityId");     // Catch: Throwable -> L20
        int r2 = CursorUtil.getColumnIndex(r7, "hashCodeValue");     // Catch: Throwable -> L20
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L4:
        if (r7.moveToNext() == false) goto L18;
        if (r10 != (-1)) goto L10;
    L8:
        String r5 = null;
    L13:
        if (r2 != (-1)) goto L15;
        int r4 = 0;
    L16:
        r3.add(new c(r5, r4));     // Catch: Throwable -> L20
        goto L4
    L15:
        r4 = r7.getInt(r2);     // Catch: Throwable -> L20
        goto L16
    L10:
        if (r7.isNull(r10) == true) goto L8;
        r5 = r7.getString(r10);     // Catch: Throwable -> L20
        goto L13
    L18:
        r7.close();
        return r3;
    L20:
        th = move-exception;
        r7.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return ContactRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return ContactRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Long getMaxValue(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        return r1;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r1 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return ContactRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.ContactRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ContactRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(fx r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawContactEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(Object r3) {
        return insert((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fx> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawContactEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fx> queryAll() {
        return ContactRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ContactRawDbDao
    public List<String> queryAllContactName() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT name FROM RawContactEntity WHERE name != '' AND name IS NOT NULL", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ContactRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.ContactRawDbDao
    public List<fx> queryByContactNameAndPhoneNumber(String r3, List<MetaTelephone> r4) {
        return ContactRawDbDao.DefaultImpls.queryByContactNameAndPhoneNumber(this, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByEntityId(String r1, String r2) {
        return ContactRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByEntityIdList(List<String> r3) {
        return ContactRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return ContactRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fx queryById(long r1) {
        return ContactRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByIdAndTimestamp(long r1, long r3) {
        return ContactRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fx> queryByIds(List<Long> r3) {
        return ContactRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return ContactRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByPackageName(String r1) {
        return ContactRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return ContactRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return ContactRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.ContactRawDbDao
    public List<fx> queryByPhoneNumber(List<String> r3, String r4) {
        return ContactRawDbDao.DefaultImpls.queryByPhoneNumber(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fx queryByUUID(String r1) {
        return ContactRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.ContactRawDbDao
    public List<String> queryContactNameWithLimit(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT name FROM RawContactEntity WHERE name != '' AND name IS NOT NULL LIMIT ?", 1);
        r0.bindLong(1, r5);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L14
    L4:
        if (r4.moveToNext() == false) goto L12;
        if (r4.isNull(0) == false) goto L9;
        String r3 = null;
    L10:
        r2.add(r3);     // Catch: Throwable -> L14
        goto L4
    L9:
        r3 = r4.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r4.close();
        r0.release();
        return r2;
    L14:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fx queryOne() {
        return ContactRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fx> queryRecentByPackageName(String r1, long r2) {
        return ContactRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fx> queryWithLimitAndOffset(int r1, int r2) {
        return ContactRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fx> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawContactEntity(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public Cursor rawQueryForCursor(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int rawQueryForInt(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public long rawQueryForLong(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r0 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        return r0;
    L7:
        r0 = 0;
        goto L8
    }

    public int update(fx r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawContactEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(Object r3) {
        return update((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fx> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawContactEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor updateByRawQuery(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int updatePoisonLabelIfContentHashMatches(String r1, String r2, int r3, Integer r4) {
        return ContactRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
