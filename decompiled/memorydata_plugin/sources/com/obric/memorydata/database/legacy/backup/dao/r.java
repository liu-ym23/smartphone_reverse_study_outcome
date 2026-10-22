package com.obric.memorydata.database.legacy.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/dao/BackUpRawUserProfileDaoOld;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpRawUserProfileEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface r extends com.obric.memorydata.database.backup.dao.e<com.obric.memorydata.database.legacy.backup.a.r> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(r r2, String r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.legacy.backup.a.r a(r r2, long r3) {
            return (com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin");
        }

        public static String a(r r2) {
            r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            return "BackUpRawUserProfileEntity";
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.r> a(r r2, int r3, int r4) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.r> a(r r2, String r3, int r4, int r5) {
            r r6 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.r> a(r r2, List<Long> r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.r> b(r r2) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.r> b(r r2, String r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(r r2) {
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.r c(r r2, String r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin");
        }

        public static int d(r r2) {
            return com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.r e(r r2) {
            return (com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.d((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin");
        }
    }
}
