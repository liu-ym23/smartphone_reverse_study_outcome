package com.obric.memorydata.database.legacy.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/backup/dao/BackUpSlmAgentWatermarkDaoOld;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpSlmAgentWatermarkEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface s extends com.obric.memorydata.database.backup.dao.e<com.obric.memorydata.database.legacy.backup.a.s> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(s r2, String r3) {
            s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.legacy.backup.a.s a(s r2, long r3) {
            return (com.obric.memorydata.database.legacy.backup.a.s) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.s.class, "com.obric.memorydata.plugin");
        }

        public static String a(s r2) {
            s r3 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            return "BackUpSlmAgentWatermark";
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.s> a(s r2, int r3, int r4) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.s> a(s r2, String r3, int r4, int r5) {
            s r6 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.s> a(s r2, List<Long> r3) {
            s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.s> b(s r2) {
            return com.obric.memorydata.database.backup.dao.e.a.a((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.legacy.backup.a.s> b(s r2, String r3) {
            s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(s r2) {
            return com.obric.memorydata.database.backup.dao.e.a.b((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.s c(s r2, String r3) {
            s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.legacy.backup.a.s) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.legacy.backup.a.s.class, "com.obric.memorydata.plugin");
        }

        public static int d(s r2) {
            return com.obric.memorydata.database.backup.dao.e.a.c((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.legacy.backup.a.s e(s r2) {
            return (com.obric.memorydata.database.legacy.backup.a.s) ZeusTransformUtils.preCheckCast(com.obric.memorydata.database.backup.dao.e.a.d((com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast((s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.memorydata.plugin"), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.legacy.backup.a.s.class, "com.obric.memorydata.plugin");
        }
    }
}
