package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0015\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H'J\b\u0010\b\u001a\u00020\tH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H'J\b\u0010\u000e\u001a\u00020\tH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH'J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\rH'J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH'J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\tH'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH'Jp\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\u0010H\u0016J6\u0010'\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010 \u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\u0019H'J\b\u0010+\u001a\u00020\u0019H'J\b\u0010,\u001a\u00020\u0019H\u0017J\b\u0010-\u001a\u00020\tH'¨\u0006."}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryRuleDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "getTableName", "", "observeAllRules", "Lkotlinx/coroutines/flow/Flow;", "", "isUpdating", "", "queryMyCollections", "excludeSource", "queryAllIds", "", "hasPendingRuleSettingsUpgrade", "countClientModelRules", "", "excludeRuleId", "deleteById", OaidModel.KEY_ID, "updateLastExposedAutoMemoryId", "lastExposedAutoMemoryId", "updatePausedState", "isPaused", "updateUseClientModel", "", "use", "insertMyCollection", "title", Params.CONTENT, "appPackages", AILabCheckPermissionTask.KEY_SOURCE, "useClientModel", "iconKey", "iconColorKey", "iconGenerateVersion", "isFromPreset", "canDisplay", "ruleSettingsVersion", "updateMyCollection", "updateMemoryRuleCountById", "ruleId", "clearTable", "resetSequence", "clearTableAndResetId", "hasPendingRuleGenerator", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryRuleDao extends BaseDao<MemoryRuleEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clearTableAndResetId(MemoryRuleDao r2) {
            MemoryRuleDao r3 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            r3.clearTable();
            r3.resetSequence();
        }

        public static int deleteAll(MemoryRuleDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryRuleDao r2) {
            MemoryRuleDao r3 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            return "MemoryRule";
        }

        public static long insertMyCollection(MemoryRuleDao r33, String r34, String r35, String r36, String r37, boolean r38, String r39, String r40, String r41, boolean r42, boolean r43, int r44) {
            MemoryRuleDao r15 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r33, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r34, "title");
            Intrinsics.checkNotNullParameter(r35, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r36, "appPackages");
            Intrinsics.checkNotNullParameter(r37, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r39, "iconKey");
            Intrinsics.checkNotNullParameter(r40, "iconColorKey");
            Intrinsics.checkNotNullParameter(r41, "iconGenerateVersion");
            return r15.insert(new MemoryRuleEntity(0, r34, r35, r36, null, null, null, null, r38, 0, r37, null, null, null, false, false, r42, r43, r44, 0, 0, r39, r40, r41, 0, 18414321, null));
        }

        public static /* synthetic */ long insertMyCollection$default(MemoryRuleDao r14, String r15, String r16, String r17, String r18, boolean r19, String r20, String r21, String r22, boolean r23, boolean r24, int r25, int r26, Object r27) {
            MemoryRuleDao r2 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r14, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            if (r27 != null) goto L39;
            if ((r26 & 8) == 0) goto L7;
            String r6 = "";
        L9:
            if ((r26 & 16) == 0) goto L11;
            boolean r7 = false;
        L13:
            if ((r26 & 32) == 0) goto L15;
            String r8 = "";
        L17:
            if ((r26 & 64) == 0) goto L19;
            String r9 = "";
        L21:
            if ((r26 & 128) == 0) goto L23;
            String r10 = "";
        L25:
            if ((r26 & 256) == 0) goto L27;
            boolean r11 = false;
        L29:
            if ((r26 & 512) == 0) goto L31;
            boolean r12 = true;
        L33:
            if ((r26 & 1024) == 0) goto L35;
            int r13 = 1;
        L37:
            return r2.insertMyCollection(r15, r16, r17, r6, r7, r8, r9, r10, r11, r12, r13);
        L35:
            r13 = r25;
            goto L37
        L31:
            r12 = r24;
            goto L33
        L27:
            r11 = r23;
            goto L29
        L23:
            r10 = r22;
            goto L25
        L19:
            r9 = r21;
            goto L21
        L15:
            r8 = r20;
            goto L17
        L11:
            r7 = r19;
            goto L13
        L7:
            r6 = r18;
            goto L9
        L39:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertMyCollection");
        }

        public static List<MemoryRuleEntity> queryAll(MemoryRuleDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryRuleDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static MemoryRuleEntity queryById(MemoryRuleDao r2, long r3) {
            return (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MemoryRuleEntity> queryByIds(MemoryRuleDao r2, List<Long> r3) {
            MemoryRuleDao r4 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static MemoryRuleEntity queryByUUID(MemoryRuleDao r2, String r3) {
            MemoryRuleDao r4 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        }

        public static MemoryRuleEntity queryOne(MemoryRuleDao r2) {
            return (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MemoryRuleEntity> queryWithLimitAndOffset(MemoryRuleDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static void updateMemoryRuleCountById(MemoryRuleDao r2, long r3) {
            MemoryRuleDao r4 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            MemoryRuleEntity r5 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryById(r3), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L6;
            r5.setMemoryCount(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByRuleId(r3));
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().update(r5);
            return;
        }

        public static int updateMyCollection(MemoryRuleDao r32, long r33, String r35, String r36, String r37, boolean r38) {
            MemoryRuleDao r10 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r32, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r36, Params.CONTENT);
            MemoryRuleEntity r0 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r10.queryById(r33), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L7;
            return 0;
        L7:
            if (Intrinsics.areEqual(r0.getContent(), r36) == true) goto L10;
            r0.setClientModelQuery("");
            r0.setClientModelVersion("");
            r0.setImageFilterQuery("");
            r0.setImageFilterModelVersion("");
            r0.setTriggerMode("");
            r0.setCronExpression("");
            r0.setIconGenerateVersion("");
        L10:
            if (r35 != null) goto L12;
            String r3 = r0.getTitle();
        L13:
            if (r37 != null) goto L15;
            String r5 = r0.getAppPackages();
        L17:
            return r10.update(MemoryRuleEntity.copy$default(r0, 0, r3, r36, r5, null, null, null, null, r38, 0, null, null, null, null, false, false, false, false, 0, 0, 0, null, null, null, 0, 33554161, null));
        L15:
            r5 = r37;
            goto L17
        L12:
            r3 = r35;
            goto L13
        }

        public static /* synthetic */ int updateMyCollection$default(MemoryRuleDao r7, long r8, String r10, String r11, String r12, boolean r13, int r14, Object r15) {
            MemoryRuleDao r0 = (MemoryRuleDao) ZeusTransformUtils.wrapperContextForParams(r7, MemoryRuleDao.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 16) == 0) goto L8;
            r13 = false;
        L8:
            return r0.updateMyCollection(r8, r10, r11, r12, r13);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMyCollection");
        }
    }

    void clearTable();

    void clearTableAndResetId();

    int countClientModelRules(long r1);

    int deleteById(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    boolean hasPendingRuleGenerator();

    boolean hasPendingRuleSettingsUpgrade();

    long insertMyCollection(String r1, String r2, String r3, String r4, boolean r5, String r6, String r7, String r8, boolean r9, boolean r10, int r11);

    boolean isUpdating();

    i<List<MemoryRuleEntity>> observeAllRules();

    List<Long> queryAllIds();

    List<MemoryRuleEntity> queryMyCollections(String r1);

    void resetSequence();

    int updateLastExposedAutoMemoryId(long r1, long r3);

    void updateMemoryRuleCountById(long r1);

    int updateMyCollection(long r1, String r3, String r4, String r5, boolean r6);

    int updatePausedState(long r1, boolean r3);

    void updateUseClientModel(boolean r1);
}
