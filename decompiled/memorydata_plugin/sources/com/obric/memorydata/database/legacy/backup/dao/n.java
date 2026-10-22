package com.obric.memorydata.database.legacy.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryRuleDaoOld;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpMemoryRuleEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface n extends com.obric.memorydata.database.backup.dao.e<com.obric.memorydata.database.legacy.backup.a.n> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(n r2, String r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.legacy.backup.a.n a(n r2, long r3) {
            return (com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin");
        }

        public static String a(n r2) {
            n r3 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            return "BacupMemoryRule";
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.n> a(n r2, int r3, int r4) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.n> a(n r2, String r3, int r4, int r5) {
            n r6 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.n> a(n r2, List<Long> r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.n> b(n r2) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.n> b(n r2, String r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(n r2) {
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.n c(n r2, String r3) {
            n r4 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin");
        }

        public static int d(n r2) {
            return com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.n e(n r2) {
            return (com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.d((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin");
        }
    }
}
