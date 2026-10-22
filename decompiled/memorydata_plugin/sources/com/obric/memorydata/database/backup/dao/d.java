package com.obric.memorydata.database.backup.dao;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/backup/dao/BackUpUnionSemanticMemorySnapShotDao;", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "Lcom/obric/memorydata/database/backup/entity/BackUpUnionSemanticMemorySnapShotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface d extends e<com.obric.memorydata.database.backup.a.e> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(d r2, String r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static com.obric.memorydata.database.backup.a.e a(d r2, long r3) {
            return (com.obric.memorydata.database.backup.a.e) ZeusTransformUtils.preCheckCast(e.a.a((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.e.class, "com.obric.memorydata.plugin");
        }

        public static String a(d r2) {
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            return "BackUpUnionSemanticMemorySnapShot";
        }

        public static List<com.obric.memorydata.database.backup.a.e> a(d r2, int r3, int r4) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.memorydata.database.backup.a.e> a(d r2, String r3, int r4, int r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<com.obric.memorydata.database.backup.a.e> a(d r2, List<Long> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return e.a.a((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.memorydata.database.backup.a.e> b(d r2) {
            return e.a.a((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static List<com.obric.memorydata.database.backup.a.e> b(d r2, String r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "userId");
            return e.a.b((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int c(d r2) {
            return e.a.b((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.e c(d r2, String r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.memorydata.database.backup.a.e) ZeusTransformUtils.preCheckCast(e.a.c((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin"), r3), com.obric.memorydata.database.backup.a.e.class, "com.obric.memorydata.plugin");
        }

        public static int d(d r2) {
            return e.a.c((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.memorydata.database.backup.a.e e(d r2) {
            return (com.obric.memorydata.database.backup.a.e) ZeusTransformUtils.preCheckCast(e.a.d((e) ZeusTransformUtils.preCheckCast((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.backup.a.e.class, "com.obric.memorydata.plugin");
        }
    }
}
