package com.obric.memorydata.database.legacy.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/dao/BackUpProactiveSemanticRelevantDataDaoOld;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpProactiveSemanticRelevantDataEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface q extends com.obric.memorydata.database.backup.dao.e<com.obric.memorydata.database.legacy.backup.a.q> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(q r2, String r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.legacy.backup.a.q a(q r2, long r3) {
            return (com.obric.memorydata.database.legacy.backup.a.q) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.q.class, "com.obric.memorydata.plugin");
        }

        public static String a(q r2) {
            q r3 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            return "BackUpProactiveSemanticRelevantData";
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.q> a(q r2, int r3, int r4) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.q> a(q r2, String r3, int r4, int r5) {
            q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.q> a(q r2, List<Long> r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.q> b(q r2) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.q> b(q r2, String r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(q r2) {
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.q c(q r2, String r3) {
            q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.backup.a.q) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.q.class, "com.obric.memorydata.plugin");
        }

        public static int d(q r2) {
            return com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.q e(q r2) {
            return (com.obric.memorydata.database.legacy.backup.a.q) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.d((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.wrapperContextForParams(r2, q.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.backup.a.q.class, "com.obric.memorydata.plugin");
        }
    }
}
