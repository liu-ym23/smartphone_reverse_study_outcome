package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.fx;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ContactHistoryEntityDao_Impl implements ContactHistoryEntityDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ContactHistoryEntity> __deletionAdapterOfContactHistoryEntity;
    private final EntityInsertionAdapter<ContactHistoryEntity> __insertionAdapterOfContactHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<ContactHistoryEntity> __updateAdapterOfContactHistoryEntity;

    public ContactHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfContactHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfContactHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfContactHistoryEntity = new AnonymousClass3(this, r2);
    }

    private ContactHistoryEntity __entityCursorConverter_comObricMemorydataDatabaseDaoContactHistoryEntity(Cursor r84) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r84, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "contact_id");
        int r3 = CursorUtil.getColumnIndex(r0, "contact_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "contact_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "contact_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "contact_type");
        int r7 = CursorUtil.getColumnIndex(r0, "contact_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "contact_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "contact_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "contact_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "contact_name");
        int r12 = CursorUtil.getColumnIndex(r0, "contact_telephones");
        int r13 = CursorUtil.getColumnIndex(r0, "contact_telephonesValues");
        int r14 = CursorUtil.getColumnIndex(r0, "contact_avatar");
        int r15 = CursorUtil.getColumnIndex(r0, "contact_note");
        int r16 = CursorUtil.getColumnIndex(r0, "contact_gender");
        int r17 = CursorUtil.getColumnIndex(r0, "contact_credentialNumbers");
        int r18 = CursorUtil.getColumnIndex(r0, "contact_credentialValues");
        int r19 = CursorUtil.getColumnIndex(r0, "contact_emails");
        int r110 = CursorUtil.getColumnIndex(r0, "contact_emailsValues");
        int r111 = CursorUtil.getColumnIndex(r0, "contact_addresses");
        int r112 = CursorUtil.getColumnIndex(r0, "contact_addressesValues");
        int r113 = CursorUtil.getColumnIndex(r0, "contact_company");
        int r114 = CursorUtil.getColumnIndex(r0, "contact_instantMessagings");
        int r115 = CursorUtil.getColumnIndex(r0, "contact_anniversaries");
        int r116 = CursorUtil.getColumnIndex(r0, "contact_anniversariesValues");
        int r117 = CursorUtil.getColumnIndex(r0, "contact_voip");
        int r118 = CursorUtil.getColumnIndex(r0, "contact_relationShips");
        int r119 = CursorUtil.getColumnIndex(r0, "contact_relationShipsValues");
        int r120 = CursorUtil.getColumnIndex(r0, "contact_fullContent");
        int r121 = CursorUtil.getColumnIndex(r0, "contact_department");
        int r122 = CursorUtil.getColumnIndex(r0, "contact_jobTitle");
        int r123 = CursorUtil.getColumnIndex(r0, "contact_subNote");
        int r124 = CursorUtil.getColumnIndex(r0, "contact_website");
        int r125 = CursorUtil.getColumnIndex(r0, "contact_telephoneStandardMap");
        int r126 = CursorUtil.getColumnIndex(r0, "contact_poison_label");
        int r127 = CursorUtil.getColumnIndex(r0, "contact_poison_label_version");
        int r128 = CursorUtil.getColumnIndex(r0, "contact_content_hash");
        long r37 = 0;
        if (r1 != (-1)) goto L5;
        long r42 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r45 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r47 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r48 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r50 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r52 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r37 = r0.getLong(r7);
    L29:
        long r53 = r37;
        if (r8 != (-1)) goto L33;
    L31:
        String r55 = null;
    L36:
        if (r9 == (-1)) goto L39;
        r21 = r0.getInt(r9);
    L39:
        int r56 = r21;
        if (r10 != (-1)) goto L43;
    L41:
        String r57 = null;
    L46:
        if (r11 != (-1)) goto L49;
    L47:
        String r58 = null;
    L52:
        if (r12 != (-1)) goto L55;
    L53:
        String r59 = null;
    L58:
        if (r13 != (-1)) goto L61;
    L59:
        String r60 = null;
    L64:
        if (r14 != (-1)) goto L67;
    L65:
        String r61 = null;
    L70:
        if (r83 != (-1)) goto L73;
    L71:
        String r62 = null;
    L76:
        if (r84 != (-1)) goto L80;
    L77:
        String r63 = null;
    L83:
        if (r17 != (-1)) goto L87;
    L84:
        String r64 = null;
    L90:
        if (r18 != (-1)) goto L94;
    L91:
        String r65 = null;
    L97:
        if (r19 != (-1)) goto L101;
    L98:
        String r66 = null;
    L104:
        if (r110 != (-1)) goto L108;
    L105:
        String r67 = null;
    L111:
        if (r111 != (-1)) goto L115;
    L112:
        String r68 = null;
    L118:
        if (r112 != (-1)) goto L122;
    L119:
        String r69 = null;
    L125:
        if (r113 != (-1)) goto L129;
    L126:
        String r70 = null;
    L132:
        if (r114 != (-1)) goto L136;
    L133:
        String r71 = null;
    L139:
        if (r115 != (-1)) goto L143;
    L140:
        String r72 = null;
    L146:
        if (r116 != (-1)) goto L150;
    L147:
        String r73 = null;
    L153:
        if (r117 != (-1)) goto L157;
    L154:
        String r74 = null;
    L160:
        if (r118 != (-1)) goto L164;
    L161:
        String r75 = null;
    L167:
        if (r119 != (-1)) goto L171;
    L168:
        String r76 = null;
    L174:
        if (r120 != (-1)) goto L178;
    L175:
        String r77 = null;
    L181:
        if (r121 != (-1)) goto L185;
    L182:
        String r78 = null;
    L188:
        if (r122 != (-1)) goto L192;
    L189:
        String r79 = null;
    L195:
        if (r123 != (-1)) goto L199;
    L196:
        String r80 = null;
    L202:
        if (r124 != (-1)) goto L206;
    L203:
        String r81 = null;
    L209:
        if (r125 != (-1)) goto L212;
    L210:
        String r82 = null;
    L215:
        fx r22 = new fx(r45, r47, r48, r50, r52, r53, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82);
        if (r126 == (-1)) goto L223;
        if (r0.isNull(r126) == false) goto L220;
        Integer r23 = null;
    L221:
        r22.setPoisonLabel(r23);
        goto L223
    L220:
        r23 = Integer.valueOf(r0.getInt(r126));
    L223:
        if (r127 == (-1)) goto L230;
        if (r0.isNull(r127) == false) goto L227;
        Integer r24 = null;
    L228:
        r22.setPoisonLabelVersion(r24);
        goto L230
    L227:
        r24 = Integer.valueOf(r0.getInt(r127));
    L230:
        if (r128 == (-1)) goto L237;
        if (r0.isNull(r128) == true) goto L235;
        r20 = r0.getString(r128);
    L235:
        r22.setContentHash(r20);
    L237:
        return new ContactHistoryEntity(r42, r22);
    L212:
        if (r0.isNull(r125) == true) goto L210;
        r82 = r0.getString(r125);
        goto L215
    L206:
        if (r0.isNull(r124) == true) goto L203;
        r81 = r0.getString(r124);
        goto L209
    L199:
        if (r0.isNull(r123) == true) goto L196;
        r80 = r0.getString(r123);
        goto L202
    L192:
        if (r0.isNull(r122) == true) goto L189;
        r79 = r0.getString(r122);
        goto L195
    L185:
        if (r0.isNull(r121) == true) goto L182;
        r78 = r0.getString(r121);
        goto L188
    L178:
        if (r0.isNull(r120) == true) goto L175;
        r77 = r0.getString(r120);
        goto L181
    L171:
        if (r0.isNull(r119) == true) goto L168;
        r76 = r0.getString(r119);
        goto L174
    L164:
        if (r0.isNull(r118) == true) goto L161;
        r75 = r0.getString(r118);
        goto L167
    L157:
        if (r0.isNull(r117) == true) goto L154;
        r74 = r0.getString(r117);
        goto L160
    L150:
        if (r0.isNull(r116) == true) goto L147;
        r73 = r0.getString(r116);
        goto L153
    L143:
        if (r0.isNull(r115) == true) goto L140;
        r72 = r0.getString(r115);
        goto L146
    L136:
        if (r0.isNull(r114) == true) goto L133;
        r71 = r0.getString(r114);
        goto L139
    L129:
        if (r0.isNull(r113) == true) goto L126;
        r70 = r0.getString(r113);
        goto L132
    L122:
        if (r0.isNull(r112) == true) goto L119;
        r69 = r0.getString(r112);
        goto L125
    L115:
        if (r0.isNull(r111) == true) goto L112;
        r68 = r0.getString(r111);
        goto L118
    L108:
        if (r0.isNull(r110) == true) goto L105;
        r67 = r0.getString(r110);
        goto L111
    L101:
        if (r0.isNull(r19) == true) goto L98;
        r66 = r0.getString(r19);
        goto L104
    L94:
        if (r0.isNull(r18) == true) goto L91;
        r65 = r0.getString(r18);
        goto L97
    L87:
        if (r0.isNull(r17) == true) goto L84;
        r64 = r0.getString(r17);
        goto L90
    L80:
        if (r0.isNull(r84) == true) goto L77;
        r63 = r0.getString(r16);
        goto L83
    L73:
        if (r0.isNull(r83) == true) goto L71;
        r62 = r0.getString(r15);
        goto L76
    L67:
        if (r0.isNull(r14) == true) goto L65;
        r61 = r0.getString(r14);
        goto L70
    L61:
        if (r0.isNull(r13) == true) goto L59;
        r60 = r0.getString(r13);
        goto L64
    L55:
        if (r0.isNull(r12) == true) goto L53;
        r59 = r0.getString(r12);
        goto L58
    L49:
        if (r0.isNull(r11) == true) goto L47;
        r58 = r0.getString(r11);
        goto L52
    L43:
        if (r0.isNull(r10) == true) goto L41;
        r57 = r0.getString(r10);
        goto L46
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r55 = r0.getString(r8);
        goto L36
    L25:
        r52 = r0.getInt(r6);
        goto L26
    L21:
        r50 = r0.getLong(r5);
        goto L22
    L18:
        r48 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r47 = r0.getString(r3);
        goto L16
    L8:
        r45 = r0.getLong(r2);
        goto L9
    L5:
        r42 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ContactHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfContactHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ContactHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfContactHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(ContactHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfContactHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ContactHistoryEntity) ZeusTransformUtils.preCheckCast(r3, ContactHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ContactHistoryEntityDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return ContactHistoryEntityDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return ContactHistoryEntityDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return ContactHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return ContactHistoryEntityDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.ContactHistoryEntityDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return ContactHistoryEntityDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.ContactHistoryEntityDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ContactHistoryEntityDao.DefaultImpls.getTableName(this);
    }

    public long insert(ContactHistoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfContactHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ContactHistoryEntity) ZeusTransformUtils.preCheckCast(r3, ContactHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ContactHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfContactHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ContactHistoryEntity> queryAll() {
        return ContactHistoryEntityDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ContactHistoryEntityDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ContactHistoryEntity> queryByEntityId(String r1, String r2) {
        return ContactHistoryEntityDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ContactHistoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return ContactHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ContactHistoryEntity queryById(long r1) {
        return ContactHistoryEntityDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ContactHistoryEntity> queryByIds(List<Long> r3) {
        return ContactHistoryEntityDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ContactHistoryEntity queryByUUID(String r1) {
        return ContactHistoryEntityDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ContactHistoryEntity queryOne() {
        return ContactHistoryEntityDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ContactHistoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return ContactHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ContactHistoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseDaoContactHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ContactHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfContactHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ContactHistoryEntity) ZeusTransformUtils.preCheckCast(r3, ContactHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ContactHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfContactHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
