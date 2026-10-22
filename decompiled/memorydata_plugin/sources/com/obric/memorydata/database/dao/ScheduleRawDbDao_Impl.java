package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.hl;
import com.obric.memorydata.database.entity.hz;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduleRawDbDao_Impl implements ScheduleRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hl> __deletionAdapterOfRawScheduleEntity;
    private final EntityInsertionAdapter<hl> __insertionAdapterOfRawScheduleEntity;
    private final EntityDeletionOrUpdateAdapter<hl> __updateAdapterOfRawScheduleEntity;

    /* JADX INFO: renamed from: com.obric.memorydata.database.dao.ScheduleRawDbDao_Impl$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$capabilitykit$entity$enums$CalendarTypeEnum = null;

        static {
            int[] r0 = new int[CalendarTypeEnum.values().length];
            $SwitchMap$com$obric$capabilitykit$entity$enums$CalendarTypeEnum = r0;
            r0[CalendarTypeEnum.CALENDAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$capabilitykit$entity$enums$CalendarTypeEnum[CalendarTypeEnum.TODO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public ScheduleRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawScheduleEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawScheduleEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawScheduleEntity = new AnonymousClass3(this, r2);
    }

    private String __CalendarTypeEnum_enumToString(CalendarTypeEnum r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r2 = AnonymousClass4.$SwitchMap$com$obric$capabilitykit$entity$enums$CalendarTypeEnum[r3.ordinal()];
        if (r2 != 1) goto L8;
        return "CALENDAR";
    L8:
        if (r2 != 2) goto L12;
        return PendingMemoryCalendar.TYPE_TODO;
    L12:
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + r3);
    }

    private CalendarTypeEnum __CalendarTypeEnum_stringToEnum(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        r3.hashCode();
        if (r3.equals(PendingMemoryCalendar.TYPE_TODO) == true) goto L14;
        if (r3.equals("CALENDAR") == true) goto L12;
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + r3);
    L12:
        return CalendarTypeEnum.CALENDAR;
    L14:
        return CalendarTypeEnum.TODO;
    }

    private hl __entityCursorConverter_comObricMemorydataDatabaseEntityRawScheduleEntity(Cursor r78) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r78, Cursor.class, "com.obric.memorydata.plugin");
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
        int r11 = CursorUtil.getColumnIndex(r0, MemoryKeyInfoEntity.KEY_ADDRESS);
        int r12 = CursorUtil.getColumnIndex(r0, "attendeesIds");
        int r13 = CursorUtil.getColumnIndex(r0, "repeatDescription");
        int r14 = CursorUtil.getColumnIndex(r0, "allDay");
        int r15 = CursorUtil.getColumnIndex(r0, "note");
        int r16 = CursorUtil.getColumnIndex(r0, "completed");
        int r17 = CursorUtil.getColumnIndex(r0, "isFavorite");
        int r18 = CursorUtil.getColumnIndex(r0, "reminderDesc");
        int r19 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r110 = CursorUtil.getColumnIndex(r0, "url");
        int r111 = CursorUtil.getColumnIndex(r0, "attendeesText");
        int r112 = CursorUtil.getColumnIndex(r0, "organizer");
        int r113 = CursorUtil.getColumnIndex(r0, "priority");
        int r114 = CursorUtil.getColumnIndex(r0, "categories");
        int r115 = CursorUtil.getColumnIndex(r0, "icsId");
        int r116 = CursorUtil.getColumnIndex(r0, "recurrenceId");
        int r117 = CursorUtil.getColumnIndex(r0, "rawRrule");
        int r118 = CursorUtil.getColumnIndex(r0, "calendarType");
        int r119 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r120 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r121 = CursorUtil.getColumnIndex(r0, "content_hash");
        int r122 = CursorUtil.getColumnIndex(r0, "startTimestamp");
        int r123 = CursorUtil.getColumnIndex(r0, "endTimestamp");
        int r124 = CursorUtil.getColumnIndex(r0, "startDateTimestamp");
        int r125 = CursorUtil.getColumnIndex(r0, "endDateTimestamp");
        int r126 = CursorUtil.getColumnIndex(r0, "deltaDay");
        int r127 = CursorUtil.getColumnIndex(r0, "deltaMonth");
        int r128 = CursorUtil.getColumnIndex(r0, "deltaYear");
        long r38 = 0;
        if (r1 != (-1)) goto L5;
        long r44 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r46 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r47 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r49 = 0;
    L19:
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r51 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r52 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r54 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r55 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r56 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r57 = null;
    L47:
        if (r11 != (-1)) goto L50;
    L48:
        String r58 = null;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r59 = null;
    L59:
        if (r13 != (-1)) goto L62;
    L60:
        String r60 = null;
    L66:
        if (r14 != (-1)) goto L69;
        boolean r61 = false;
    L73:
        if (r78 != (-1)) goto L77;
    L74:
        String r62 = null;
    L80:
        if (r16 != (-1)) goto L84;
        Boolean r63 = null;
    L95:
        if (r17 != (-1)) goto L98;
    L96:
        boolean r64 = r21;
        if (r18 != (-1)) goto L104;
    L101:
        String r65 = null;
    L107:
        if (r19 != (-1)) goto L111;
    L108:
        String r66 = null;
    L114:
        if (r110 != (-1)) goto L118;
    L115:
        String r67 = null;
    L121:
        if (r111 != (-1)) goto L125;
    L122:
        String r68 = null;
    L128:
        if (r112 != (-1)) goto L132;
    L129:
        String r69 = null;
    L135:
        if (r113 != (-1)) goto L139;
    L136:
        String r70 = null;
    L142:
        if (r114 != (-1)) goto L146;
    L143:
        String r71 = null;
    L149:
        if (r115 != (-1)) goto L153;
    L150:
        String r72 = null;
    L156:
        if (r116 != (-1)) goto L160;
    L157:
        String r73 = null;
    L163:
        if (r117 != (-1)) goto L167;
    L164:
        String r74 = null;
    L170:
        if (r118 != (-1)) goto L172;
        CalendarTypeEnum r76 = null;
    L174:
        if (r122 != (-1)) goto L176;
        long r129 = 0;
    L177:
        if (r33 != (-1)) goto L179;
        long r130 = 0;
    L180:
        if (r34 != (-1)) goto L182;
        long r22 = 0;
    L183:
        if (r35 == (-1)) goto L186;
        r38 = r0.getLong(r125);
    L186:
        long r23 = r38;
        if (r126 != (-1)) goto L191;
    L188:
        Integer r25 = null;
    L194:
        if (r127 != (-1)) goto L198;
    L195:
        Integer r26 = null;
    L201:
        if (r128 != (-1)) goto L204;
    L202:
        Integer r27 = null;
    L207:
        hl r24 = new hl(r44, r46, r47, r49, r51, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, new hz(r129, r130, r22, r23, r25, r26, r27), r76);
        if (r119 == (-1)) goto L215;
        if (r0.isNull(r119) == false) goto L212;
        Integer r28 = null;
    L213:
        r24.setPoisonLabel(r28);
        goto L215
    L212:
        r28 = Integer.valueOf(r0.getInt(r119));
    L215:
        if (r120 == (-1)) goto L222;
        if (r0.isNull(r120) == false) goto L219;
        Integer r29 = null;
    L220:
        r24.setPoisonLabelVersion(r29);
        goto L222
    L219:
        r29 = Integer.valueOf(r0.getInt(r120));
    L222:
        if (r121 != (-1)) goto L224;
    L228:
        return r24;
    L224:
        if (r0.isNull(r121) == true) goto L227;
        r20 = r0.getString(r121);
    L227:
        r24.setContentHash(r20);
        goto L228
    L204:
        if (r0.isNull(r128) == true) goto L202;
        r27 = Integer.valueOf(r0.getInt(r128));
        goto L207
    L198:
        if (r0.isNull(r127) == true) goto L195;
        r26 = Integer.valueOf(r0.getInt(r127));
        goto L201
    L191:
        if (r0.isNull(r126) == true) goto L188;
        r25 = Integer.valueOf(r0.getInt(r126));
        goto L194
    L182:
        r22 = r0.getLong(r124);
        goto L183
    L179:
        r130 = r0.getLong(r123);
        goto L180
    L176:
        r129 = r0.getLong(r122);
        goto L177
    L172:
        r76 = __CalendarTypeEnum_stringToEnum(r0.getString(r118));
        goto L174
    L167:
        if (r0.isNull(r117) == true) goto L164;
        r74 = r0.getString(r117);
        goto L170
    L160:
        if (r0.isNull(r116) == true) goto L157;
        r73 = r0.getString(r116);
        goto L163
    L153:
        if (r0.isNull(r115) == true) goto L150;
        r72 = r0.getString(r115);
        goto L156
    L146:
        if (r0.isNull(r114) == true) goto L143;
        r71 = r0.getString(r114);
        goto L149
    L139:
        if (r0.isNull(r113) == true) goto L136;
        r70 = r0.getString(r113);
        goto L142
    L132:
        if (r0.isNull(r112) == true) goto L129;
        r69 = r0.getString(r112);
        goto L135
    L125:
        if (r0.isNull(r111) == true) goto L122;
        r68 = r0.getString(r111);
        goto L128
    L118:
        if (r0.isNull(r110) == true) goto L115;
        r67 = r0.getString(r110);
        goto L121
    L111:
        if (r0.isNull(r19) == true) goto L108;
        r66 = r0.getString(r19);
        goto L114
    L104:
        if (r0.isNull(r18) == true) goto L101;
        r65 = r0.getString(r18);
        goto L107
    L98:
        if (r0.getInt(r17) == 0) goto L96;
        r21 = true;
        goto L96
    L84:
        if (r0.isNull(r16) == false) goto L86;
        Integer r30 = null;
    L87:
        if (r30 != null) goto L90;
        Boolean r31 = null;
    L94:
        r63 = r31;
        goto L95
    L90:
        if (r30.intValue() == 0) goto L92;
        boolean r32 = true;
    L93:
        r31 = Boolean.valueOf(r32);
        goto L94
    L92:
        r32 = false;
        goto L93
    L86:
        r30 = Integer.valueOf(r0.getInt(r16));
        goto L87
    L77:
        if (r0.isNull(r78) == true) goto L74;
        r62 = r0.getString(r15);
        goto L80
    L69:
        if (r0.getInt(r14) == 0) goto L71;
        boolean r33 = true;
    L72:
        r61 = r33;
        goto L73
    L71:
        r33 = false;
        goto L72
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r60 = r0.getString(r13);
        goto L66
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r59 = r0.getString(r12);
        goto L59
    L50:
        if (r0.isNull(r11) == true) goto L48;
        r58 = r0.getString(r11);
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r57 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r56 = r0.getString(r9);
        goto L41
    L34:
        r55 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r54 = r0.getString(r7);
        goto L32
    L25:
        r52 = r0.getLong(r6);
        goto L26
    L22:
        r51 = r0.getInt(r5);
        goto L23
    L18:
        r49 = r0.getLong(r4);
        goto L19
    L15:
        r47 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r46 = r0.getString(r2);
        goto L13
    L5:
        r44 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ String access$000(ScheduleRawDbDao_Impl r0, CalendarTypeEnum r1) {
        return r0.__CalendarTypeEnum_enumToString(r1);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return ScheduleRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawScheduleEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawScheduleEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(hl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawScheduleEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hl) ZeusTransformUtils.preCheckCast(r3, hl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ScheduleRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return ScheduleRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return ScheduleRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return ScheduleRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return ScheduleRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return ScheduleRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return ScheduleRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return ScheduleRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.ScheduleRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ScheduleRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hl r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawScheduleEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hl) ZeusTransformUtils.preCheckCast(r3, hl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawScheduleEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hl> queryAll() {
        return ScheduleRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ScheduleRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByEntityId(String r1, String r2) {
        return ScheduleRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByEntityIdList(List<String> r3) {
        return ScheduleRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return ScheduleRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.ScheduleRawDbDao
    public List<hl> queryByIcsId(String r1, String r2) {
        return ScheduleRawDbDao.DefaultImpls.queryByIcsId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.ScheduleRawDbDao
    public List<hl> queryByIcsIdList(List<String> r3, String r4) {
        return ScheduleRawDbDao.DefaultImpls.queryByIcsIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hl queryById(long r1) {
        return ScheduleRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByIdAndTimestamp(long r1, long r3) {
        return ScheduleRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hl> queryByIds(List<Long> r3) {
        return ScheduleRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return ScheduleRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByPackageName(String r1) {
        return ScheduleRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return ScheduleRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return ScheduleRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hl queryByUUID(String r1) {
        return ScheduleRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hl queryOne() {
        return ScheduleRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hl> queryRecentByPackageName(String r1, long r2) {
        return ScheduleRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.ScheduleRawDbDao
    public List<String> queryScheduleIdsByIcsIdList(List<String> r3, String r4) {
        return ScheduleRawDbDao.DefaultImpls.queryScheduleIdsByIcsIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hl> queryWithLimitAndOffset(int r1, int r2) {
        return ScheduleRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hl> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawScheduleEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawScheduleEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hl) ZeusTransformUtils.preCheckCast(r3, hl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawScheduleEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return ScheduleRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
