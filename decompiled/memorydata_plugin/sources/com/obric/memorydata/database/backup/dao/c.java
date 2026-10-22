package com.obric.memorydata.database.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/backup/dao/BackUpRawMemoryDao;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/backup/entity/BackUpRawMemoryEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface c extends e<com.obric.memorydata.database.backup.a.d> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(c r2, String r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.backup.a.d a(c r2, long r3) {
            return (com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(e.a.a((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin");
        }

        public static String a(c r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            return "BackUpRawMemoryEntity";
        }

        public static List<com.obric.memorydata.database.backup.a.d> a(c r2, int r3, int r4) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.backup.a.d> a(c r2, String r3, int r4, int r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.backup.a.d> a(c r2, List<Long> r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.backup.a.d> b(c r2) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.backup.a.d> b(c r2, String r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.b((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(c r2) {
            return e.a.b((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.d c(c r2, String r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(e.a.c((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin");
        }

        public static int d(c r2) {
            return e.a.c((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.d e(c r2) {
            return (com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(e.a.d((e) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin");
        }
    }
}
