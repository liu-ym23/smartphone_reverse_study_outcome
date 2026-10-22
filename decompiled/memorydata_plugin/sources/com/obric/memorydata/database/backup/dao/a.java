package com.obric.memorydata.database.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/backup/dao/BackUpAutoMemoryProSnapShotDao;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/backup/entity/BackUpAutoMemoryProSnapShotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a extends e<com.obric.memorydata.database.backup.a.b> {

    /* JADX INFO: renamed from: com.obric.memorydata.database.backup.dao.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0455a {
        public static int a(a r2, String r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.backup.a.b a(a r2, long r3) {
            return (com.obric.memorydata.database.backup.a.b) ZeusTransformUtils.preCheckCast(e.a.a((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.b.class, "com.obric.memorydata.plugin");
        }

        public static String a(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            return "BackUpAutoMemoryProSnapShot";
        }

        public static List<com.obric.memorydata.database.backup.a.b> a(a r2, int r3, int r4) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.backup.a.b> a(a r2, String r3, int r4, int r5) {
            a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.backup.a.b> a(a r2, List<Long> r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.backup.a.b> b(a r2) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.backup.a.b> b(a r2, String r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.b((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(a r2) {
            return e.a.b((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.b c(a r2, String r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.backup.a.b) ZeusTransformUtils.preCheckCast(e.a.c((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.b.class, "com.obric.memorydata.plugin");
        }

        public static int d(a r2) {
            return e.a.c((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.b e(a r2) {
            return (com.obric.memorydata.database.backup.a.b) ZeusTransformUtils.preCheckCast(e.a.d((e) ZeusTransformUtils.preCheckCast((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.backup.a.b.class, "com.obric.memorydata.plugin");
        }
    }
}
