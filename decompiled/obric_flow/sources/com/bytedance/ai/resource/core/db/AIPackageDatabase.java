package com.bytedance.ai.resource.core.db;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s0.c;
import w2.g;

/* JADX INFO: loaded from: classes2.dex */
@TypeConverters({g.class})
@Database(entities = {Widget.class, Applet.class}, exportSchema = false, version = 8)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/resource/core/db/AIPackageDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "userDao", "Lcom/bytedance/ai/resource/core/db/AIPackageDao;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AIPackageDatabase extends RoomDatabase {
    public static final Companion Companion = null;
    private static final AIPackageDatabase$Companion$MIGRATION_1_2$1 MIGRATION_1_2 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_2_3$1 MIGRATION_2_3 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_3_4$1 MIGRATION_3_4 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_4_5$1 MIGRATION_4_5 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_5_6$1 MIGRATION_5_6 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_6_7$1 MIGRATION_6_7 = null;
    private static final AIPackageDatabase$Companion$MIGRATION_7_8$1 MIGRATION_7_8 = null;
    private static final String TAG = "AIPackageDatabase";
    private static AIPackageDatabase instance;

    @Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0007\n\r\u0010\u0013\u0016\u0019\u001c\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion;", "", "<init>", "()V", "instance", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase;", "TAG", "", "get", "MIGRATION_1_2", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1;", "MIGRATION_2_3", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_2_3$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_2_3$1;", "MIGRATION_3_4", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_3_4$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_3_4$1;", "MIGRATION_4_5", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_4_5$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_4_5$1;", "MIGRATION_5_6", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_5_6$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_5_6$1;", "MIGRATION_6_7", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_6_7$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_6_7$1;", "MIGRATION_7_8", "com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_7_8$1", "Lcom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_7_8$1;", "clearDatabase", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final void clearDatabase() {
            SupportSQLiteDatabase r5 = get().getOpenHelper().getWritableDatabase();
            r5.execSQL("DELETE FROM ai_widget_info");
            r5.execSQL("DELETE FROM ai_applet_info");
        }

        public final AIPackageDatabase get() {
            if (AIPackageDatabase.access$getInstance$cp() != null) goto L15;
            Application r5 = c.a();
            u0.a r10 = s0.a.f21800c;
            if (r10 != null) goto L7;
        L9:
            if (r10 != null) goto L11;
        L13:
            String r11 = "ai_package_prod.db";
        L14:
            AIPackageDatabase.access$setInstance$cp((AIPackageDatabase) Room.databaseBuilder(r5, AIPackageDatabase.class, r11).fallbackToDestructiveMigration().addCallback(new AIPackageDatabase$Companion$get$1()).addMigrations(new Migration[]{AIPackageDatabase.access$getMIGRATION_1_2$cp(), AIPackageDatabase.access$getMIGRATION_2_3$cp(), AIPackageDatabase.access$getMIGRATION_3_4$cp(), AIPackageDatabase.access$getMIGRATION_4_5$cp(), AIPackageDatabase.access$getMIGRATION_5_6$cp(), AIPackageDatabase.access$getMIGRATION_6_7$cp(), AIPackageDatabase.access$getMIGRATION_7_8$cp()}).build());
            goto L15
        L11:
            if (r10.f22205p != true) goto L13;
        L12:
            r11 = "ai_package_test.db";
            goto L14
        L7:
            if (r10.f22203n != true) goto L9;
        L15:
            AIPackageDatabase r12 = AIPackageDatabase.access$getInstance$cp();
            Intrinsics.checkNotNull(r12);
            return r12;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_3_4$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_4_5$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_7_8$1] */
    static {
        Companion = new Companion(null);
        MIGRATION_1_2 = new AIPackageDatabase$Companion$MIGRATION_1_2$1();
        MIGRATION_2_3 = new AIPackageDatabase$Companion$MIGRATION_2_3$1();
        MIGRATION_3_4 = new AIPackageDatabase$Companion$MIGRATION_3_4$1();
        MIGRATION_4_5 = new AIPackageDatabase$Companion$MIGRATION_4_5$1();
        MIGRATION_5_6 = new AIPackageDatabase$Companion$MIGRATION_5_6$1();
        MIGRATION_6_7 = new AIPackageDatabase$Companion$MIGRATION_6_7$1();
        MIGRATION_7_8 = new AIPackageDatabase$Companion$MIGRATION_7_8$1();
    }

    public AIPackageDatabase() {
    }

    public static final /* synthetic */ AIPackageDatabase access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_1_2$1 access$getMIGRATION_1_2$cp() {
        return MIGRATION_1_2;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_2_3$1 access$getMIGRATION_2_3$cp() {
        return MIGRATION_2_3;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_3_4$1 access$getMIGRATION_3_4$cp() {
        return MIGRATION_3_4;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_4_5$1 access$getMIGRATION_4_5$cp() {
        return MIGRATION_4_5;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_5_6$1 access$getMIGRATION_5_6$cp() {
        return MIGRATION_5_6;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_6_7$1 access$getMIGRATION_6_7$cp() {
        return MIGRATION_6_7;
    }

    public static final /* synthetic */ AIPackageDatabase$Companion$MIGRATION_7_8$1 access$getMIGRATION_7_8$cp() {
        return MIGRATION_7_8;
    }

    public static final /* synthetic */ void access$setInstance$cp(AIPackageDatabase r5) {
        instance = r5;
    }

    public abstract AIPackageDao userDao();
}
