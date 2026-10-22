package com.bytedance.ai.resource.core.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/resource/core/db/AIPackageDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "userDao", "Lcom/bytedance/ai/resource/core/db/AIPackageDao;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AIPackageDatabase extends RoomDatabase {
    public static final Companion a = null;
    public static volatile AIPackageDatabase b;
    public static final AIPackageDatabase$Companion$MIGRATION_1_2$1 c = null;
    public static final AIPackageDatabase$Companion$MIGRATION_2_3$1 d = null;
    public static final AIPackageDatabase$Companion$MIGRATION_3_4$1 e = null;
    public static final AIPackageDatabase$Companion$MIGRATION_4_5$1 f = null;
    public static final AIPackageDatabase$Companion$MIGRATION_5_6$1 g = null;
    public static final AIPackageDatabase$Companion$MIGRATION_6_7$1 h = null;
    public static final AIPackageDatabase$Companion$MIGRATION_7_8$1 i = null;
    public static final AIPackageDatabase$Companion$MIGRATION_8_9$1 j = null;
    public static final AIPackageDatabase$Companion$MIGRATION_9_10$1 k = null;
    public static final AIPackageDatabase$Companion$MIGRATION_10_11$1 l = null;
    public static final AIPackageDatabase$Companion$MIGRATION_11_12$1 m = null;
    public static final AIPackageDatabase$Companion$MIGRATION_12_13$1 n = null;
    public static final AIPackageDatabase$Companion$MIGRATION_13_14$1 o = null;
    public static final AIPackageDatabase$Companion$MIGRATION_14_15$1 p = null;
    public static final AIPackageDatabase$Companion$MIGRATION_15_16$1 q = null;

    public static final class Companion {
        public final AIPackageDatabase b() {
            AIPackageDatabase r0 = AIPackageDatabase.b;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = AIPackageDatabase.b;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            Companion r1 = AIPackageDatabase.a;     // Catch: Throwable -> L9
            r0 = a();     // Catch: Throwable -> L9
            AIPackageDatabase.b = r0;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public static AIPackageDatabase a() {
            Context r0 = f2.k.a();
            int r10 = com.bytedance.ai.utils.a.a;
            h2.a r11 = f2.b.c;
            if (r11 != null) goto L5;
        L7:
            boolean r12 = false;
        L8:
            if (r12 == true) goto L17;
            if (r11 != null) goto L11;
        L13:
            boolean r13 = false;
        L14:
            if (r13 == true) goto L17;
            String r14 = "ai_package_prod.db";
        L19:
            return (AIPackageDatabase) Room.databaseBuilder(r0, AIPackageDatabase.class, r14).fallbackToDestructiveMigration().addCallback(new AIPackageDatabase$Companion$createDatabase$1()).addMigrations(new Migration[]{AIPackageDatabase.c, AIPackageDatabase.d, AIPackageDatabase.e, AIPackageDatabase.f, AIPackageDatabase.g, AIPackageDatabase.h, AIPackageDatabase.i, AIPackageDatabase.j, AIPackageDatabase.k, AIPackageDatabase.l, AIPackageDatabase.m, AIPackageDatabase.n, AIPackageDatabase.o, AIPackageDatabase.p, AIPackageDatabase.q}).build();
        L11:
            if (r11.p != true) goto L13;
            r13 = true;
        L17:
            r14 = "ai_package_test.db";
            goto L19
        L5:
            if (r11.n != true) goto L7;
            r12 = true;
            goto L8
        }

        public Companion() {
        }
    }

    public abstract AIPackageDao c();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_1_2$1] */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_10_11$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_11_12$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_12_13$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_13_14$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_14_15$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_15_16$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_3_4$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_4_5$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_7_8$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_8_9$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_9_10$1] */
    static {
        a = new Companion();
        c = new AIPackageDatabase$Companion$MIGRATION_1_2$1();
        d = new AIPackageDatabase$Companion$MIGRATION_2_3$1();
        e = new AIPackageDatabase$Companion$MIGRATION_3_4$1();
        f = new AIPackageDatabase$Companion$MIGRATION_4_5$1();
        g = new AIPackageDatabase$Companion$MIGRATION_5_6$1();
        h = new AIPackageDatabase$Companion$MIGRATION_6_7$1();
        i = new AIPackageDatabase$Companion$MIGRATION_7_8$1();
        j = new AIPackageDatabase$Companion$MIGRATION_8_9$1();
        k = new AIPackageDatabase$Companion$MIGRATION_9_10$1();
        l = new AIPackageDatabase$Companion$MIGRATION_10_11$1();
        m = new AIPackageDatabase$Companion$MIGRATION_11_12$1();
        n = new AIPackageDatabase$Companion$MIGRATION_12_13$1();
        o = new AIPackageDatabase$Companion$MIGRATION_13_14$1();
        p = new AIPackageDatabase$Companion$MIGRATION_14_15$1();
        q = new AIPackageDatabase$Companion$MIGRATION_15_16$1();
    }

    public AIPackageDatabase() {
    }
}
