package com.obric.memorydata.database.manager;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DowngradeBackupOpenHelperFactory;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006* \n\r\u0010\u0013\u0016\u0019\u001c\u001f\"%(+.147:=ADGJMPTWZ^adsv\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00052\u0006\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u00052\u0006\u0010n\u001a\u00020\u00052\u0006\u0010o\u001a\u00020\u00052\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0083\u0001\u001a\u00020\u007f2\u0007\u0010\u0084\u0001\u001a\u00020\u0005J\u0007\u0010\u0085\u0001\u001a\u00020gJ\u0007\u0010\u0086\u0001\u001a\u00020yJ\u0010\u0010\u0087\u0001\u001a\u00020y2\u0007\u0010\u0084\u0001\u001a\u00020\u0005J\u001e\u0010\u0088\u0001\u001a\u00020g2\u0007\u0010\u0084\u0001\u001a\u00020\u00052\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u001e\u0010\u008b\u0001\u001a\u00020g2\u0007\u0010\u0084\u0001\u001a\u00020\u00052\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J0\u0010\u008c\u0001\u001a\u00020g2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u00052\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J!\u0010\u0090\u0001\u001a\u00030\u008a\u0001*\u00030\u008e\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u0005H\u0002J\u0018\u0010\u0092\u0001\u001a\u00030\u008a\u0001*\u00030\u008e\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u0016\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\n\n\u0002\u0010?\u0012\u0004\b>\u0010\u0003R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u0010\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010ER\u0010\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0004\n\u0002\u0010HR\u0010\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0004\n\u0002\u0010KR\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR\u0016\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\n\n\u0002\u0010R\u0012\u0004\bQ\u0010\u0003R\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u0010\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\n\n\u0002\u0010\\\u0012\u0004\b[\u0010\u0003R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010eR\u0010\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0004\n\u0002\u0010tR\u0010\u0010u\u001a\u00020vX\u0082\u0004¢\u0006\u0004\n\u0002\u0010wR\u001b\u0010x\u001a\u00020y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\bz\u0010{R\u001e\u0010~\u001a\u00020\u007f8FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010}\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/obric/memorydata/database/manager/MemoryDbEngine;", "", "<init>", "()V", "TAG", "", "ENCRYPT_DB_NAME", "USER_LOGIC_DB_NAME", "OSE_KEYWORD_INDEX_DB_NAME", "migration_1_2", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_1_2$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_1_2$1;", "migration_2_3", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_2_3$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_2_3$1;", "migration_3_4", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_3_4$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_3_4$1;", "migration_4_5", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_4_5$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_4_5$1;", "migration_5_6", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_5_6$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_5_6$1;", "migration_6_7", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_6_7$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_6_7$1;", "migration_7_8", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_7_8$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_7_8$1;", "migration_8_9", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_8_9$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_8_9$1;", "migration_9_10", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_9_10$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_9_10$1;", "migration_10_11", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_10_11$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_10_11$1;", "migration_11_12", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_11_12$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_11_12$1;", "migration_12_13", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_12_13$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_12_13$1;", "migration_13_14", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_13_14$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_13_14$1;", "migration_14_15", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_14_15$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_14_15$1;", "migration_15_16", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_15_16$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_15_16$1;", "migration_19_20", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_19_20$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_19_20$1;", "migration_21_22", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_21_22$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_21_22$1;", "migration_33_34", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_33_34$1", "getMigration_33_34$annotations", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_33_34$1;", "migration_37_38", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_37_38$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_37_38$1;", "migration_39_40", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_39_40$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_39_40$1;", "migration_42_43", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_42_43$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_42_43$1;", "migration_43_44", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_43_44$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_43_44$1;", "migration_51_52", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_51_52$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_51_52$1;", "migration_54_55", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_54_55$1", "getMigration_54_55$annotations", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_54_55$1;", "migration_56_57", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_56_57$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_56_57$1;", "migration_61_62", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_61_62$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_61_62$1;", "migration_67_68", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_67_68$1", "getMigration_67_68$annotations", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_67_68$1;", "migration_71_72", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_71_72$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_71_72$1;", "migration_77_78", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_77_78$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_77_78$1;", "migration_80_81", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_80_81$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_80_81$1;", "migrateSemanticProductType", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "unionTableName", "unionEntityIdColumn", "unionProductTypeColumn", "proactiveTableName", "proactiveSemanticIdColumn", "proactiveProductTypeColumn", "unionUserIdColumn", "proactiveUserIdColumn", "migration_85_86", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_85_86$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_85_86$1;", "migration_89_90", "com/obric/memorydata/database/manager/MemoryDbEngine$migration_89_90$1", "Lcom/obric/memorydata/database/manager/MemoryDbEngine$migration_89_90$1;", "globalDbEngine", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "getGlobalDbEngine", "()Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "globalDbEngine$delegate", "Lkotlin/Lazy;", "personalDbEngine", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "getPersonalDbEngine", "()Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "personalDbEngine$delegate", "buildPersonalDatabaseEngine", "dbName", "registerRoomDbOpeners", "buildDatabaseEngineWrapper", "buildDatabaseEngine", "backupDb", "deleteAfterBackup", "", "backupOseDb", "backupDatabaseFiles", "dbDir", "Ljava/io/File;", "backupDir", "isDatabaseFile", "actualDbName", "isDatabaseFileByName", "targetDbName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryDbEngine {
    public static final String ENCRYPT_DB_NAME = "memory_data_database_encrypt.db";
    public static final MemoryDbEngine INSTANCE = null;
    private static final String OSE_KEYWORD_INDEX_DB_NAME = "OSE_memory_keyword_content_index.db";
    private static final String TAG = "MemoryDbEngine";
    public static final String USER_LOGIC_DB_NAME = "memory_data_database_personal.db";
    private static final Lazy globalDbEngine$delegate = null;
    private static final MemoryDbEngine$migration_10_11$1 migration_10_11 = null;
    private static final MemoryDbEngine$migration_11_12$1 migration_11_12 = null;
    private static final MemoryDbEngine$migration_12_13$1 migration_12_13 = null;
    private static final MemoryDbEngine$migration_13_14$1 migration_13_14 = null;
    private static final MemoryDbEngine$migration_14_15$1 migration_14_15 = null;
    private static final MemoryDbEngine$migration_15_16$1 migration_15_16 = null;
    private static final MemoryDbEngine$migration_19_20$1 migration_19_20 = null;
    private static final MemoryDbEngine$migration_1_2$1 migration_1_2 = null;
    private static final MemoryDbEngine$migration_21_22$1 migration_21_22 = null;
    private static final MemoryDbEngine$migration_2_3$1 migration_2_3 = null;
    private static final MemoryDbEngine$migration_33_34$1 migration_33_34 = null;
    private static final MemoryDbEngine$migration_37_38$1 migration_37_38 = null;
    private static final MemoryDbEngine$migration_39_40$1 migration_39_40 = null;
    private static final MemoryDbEngine$migration_3_4$1 migration_3_4 = null;
    private static final MemoryDbEngine$migration_42_43$1 migration_42_43 = null;
    private static final MemoryDbEngine$migration_43_44$1 migration_43_44 = null;
    private static final MemoryDbEngine$migration_4_5$1 migration_4_5 = null;
    private static final MemoryDbEngine$migration_51_52$1 migration_51_52 = null;
    private static final MemoryDbEngine$migration_54_55$1 migration_54_55 = null;
    private static final MemoryDbEngine$migration_56_57$1 migration_56_57 = null;
    private static final MemoryDbEngine$migration_5_6$1 migration_5_6 = null;
    private static final MemoryDbEngine$migration_61_62$1 migration_61_62 = null;
    private static final MemoryDbEngine$migration_67_68$1 migration_67_68 = null;
    private static final MemoryDbEngine$migration_6_7$1 migration_6_7 = null;
    private static final MemoryDbEngine$migration_71_72$1 migration_71_72 = null;
    private static final MemoryDbEngine$migration_77_78$1 migration_77_78 = null;
    private static final MemoryDbEngine$migration_7_8$1 migration_7_8 = null;
    private static final MemoryDbEngine$migration_80_81$1 migration_80_81 = null;
    private static final MemoryDbEngine$migration_85_86$1 migration_85_86 = null;
    private static final MemoryDbEngine$migration_89_90$1 migration_89_90 = null;
    private static final MemoryDbEngine$migration_8_9$1 migration_8_9 = null;
    private static final MemoryDbEngine$migration_9_10$1 migration_9_10 = null;
    private static final Lazy personalDbEngine$delegate = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_1_2$1] */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_10_11$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_11_12$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_12_13$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_13_14$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_14_15$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_15_16$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_19_20$1] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_21_22$1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_33_34$1] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_37_38$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_39_40$1] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_42_43$1] */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_43_44$1] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_51_52$1] */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_54_55$1] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_56_57$1] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_61_62$1] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_67_68$1] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_71_72$1] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_77_78$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_3_4$1] */
    /* JADX WARN: Type inference failed for: r0v30, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_80_81$1] */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_85_86$1] */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_89_90$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_4_5$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_7_8$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_8_9$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.memorydata.database.manager.MemoryDbEngine$migration_9_10$1] */
    static {
        INSTANCE = new MemoryDbEngine();
        migration_1_2 = new MemoryDbEngine$migration_1_2$1();
        migration_2_3 = new MemoryDbEngine$migration_2_3$1();
        migration_3_4 = new MemoryDbEngine$migration_3_4$1();
        migration_4_5 = new MemoryDbEngine$migration_4_5$1();
        migration_5_6 = new MemoryDbEngine$migration_5_6$1();
        migration_6_7 = new MemoryDbEngine$migration_6_7$1();
        migration_7_8 = new MemoryDbEngine$migration_7_8$1();
        migration_8_9 = new MemoryDbEngine$migration_8_9$1();
        migration_9_10 = new MemoryDbEngine$migration_9_10$1();
        migration_10_11 = new MemoryDbEngine$migration_10_11$1();
        migration_11_12 = new MemoryDbEngine$migration_11_12$1();
        migration_12_13 = new MemoryDbEngine$migration_12_13$1();
        migration_13_14 = new MemoryDbEngine$migration_13_14$1();
        migration_14_15 = new MemoryDbEngine$migration_14_15$1();
        migration_15_16 = new MemoryDbEngine$migration_15_16$1();
        migration_19_20 = new MemoryDbEngine$migration_19_20$1();
        migration_21_22 = new MemoryDbEngine$migration_21_22$1();
        migration_33_34 = new MemoryDbEngine$migration_33_34$1();
        migration_37_38 = new MemoryDbEngine$migration_37_38$1();
        migration_39_40 = new MemoryDbEngine$migration_39_40$1();
        migration_42_43 = new MemoryDbEngine$migration_42_43$1();
        migration_43_44 = new MemoryDbEngine$migration_43_44$1();
        migration_51_52 = new MemoryDbEngine$migration_51_52$1();
        migration_54_55 = new MemoryDbEngine$migration_54_55$1();
        migration_56_57 = new MemoryDbEngine$migration_56_57$1();
        migration_61_62 = new MemoryDbEngine$migration_61_62$1();
        migration_67_68 = new MemoryDbEngine$migration_67_68$1();
        migration_71_72 = new MemoryDbEngine$migration_71_72$1();
        migration_77_78 = new MemoryDbEngine$migration_77_78$1();
        migration_80_81 = new MemoryDbEngine$migration_80_81$1();
        migration_85_86 = new MemoryDbEngine$migration_85_86$1();
        migration_89_90 = new MemoryDbEngine$migration_89_90$1();
        globalDbEngine$delegate = LazyKt.lazy($$Lambda$MemoryDbEngine$ImqZFLrMhvb9k6FxcgL_pWyW2M.INSTANCE);
        personalDbEngine$delegate = LazyKt.lazy($$Lambda$MemoryDbEngine$EPQqSUTuhzhpiQpvBcyOUTThdNg.INSTANCE);
        com.obric.memorydata.middleware.database.b.f11646a.a(USER_LOGIC_DB_NAME);
    }

    private MemoryDbEngine() {
    }

    public static final /* synthetic */ void access$migrateSemanticProductType(MemoryDbEngine r11, SupportSQLiteDatabase r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        r11.migrateSemanticProductType((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r12, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r13, r14, r15, r16, r17, r18, r19, r20);
    }

    private final void backupDatabaseFiles(File r11, File r12, String r13, boolean r14) {
        File r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDatabasePath(r13);
        String r1 = r10.getName();
        File[] r2 = r11.listFiles();
        if (r2 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backupDatabaseFiles failed, listFiles is null, dbName=" + r13 + ", actualDbPath=" + r10.getAbsolutePath() + ", dbDir=" + r11.getAbsolutePath(), null, 4, null);
        return;
    L6:
        int r15 = 0;
        int r16 = r2.length;
    L7:
        if (r15 >= r16) goto L22;
        File r0 = r2[r15];
        MemoryDbEngine r3 = INSTANCE;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r1);
        if (r3.isDatabaseFile(r0, r1, r13) == false) goto L21;
        File r9 = new File(r12, r0.getName());
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        FilesKt.copyTo$default(r0, r9, true, 0, 4, null);     // Catch: Throwable -> L16
        if (r14 == false) goto L14;
        r0.delete();     // Catch: Throwable -> L16
    L14:
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L21;
        RunLog.INSTANCE.error(TAG, "backupDatabaseFiles copy failed, source=" + r0.getAbsolutePath() + ", destination=" + r9.getAbsolutePath(), r6);
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        r15 = r15 + 1;
        goto L7
    }

    private final void backupDb(String r11, boolean r12) {
        if (Intrinsics.areEqual(r11, OSE_KEYWORD_INDEX_DB_NAME) == false) goto L6;
        backupOseDb(r11, r12);
        return;
    L6:
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDatabasePath(r11);
        if (r0 == null) goto L9;
        File r1 = r0.getParentFile();
    L10:
        if (r1 != null) goto L12;
        r1 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDataDir().getAbsolutePath() + "/databases");
    L12:
        File r3 = new File(r1.getAbsolutePath() + "/backup");
        if (r3.exists() == false) goto L20;
        if (r3.isDirectory() == true) goto L20;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder();
        String r13 = "backup db failed, backup path is not directory: ";
    L17:
        IRunLog.a.b(r4, TAG, r10.append(r13).append(r3.getAbsolutePath()).toString(), null, 4, null);
        return;
    L20:
        if (r3.exists() == false) goto L22;
    L24:
        backupDatabaseFiles(r1, r3, r11, r12);
        if (Intrinsics.areEqual(r11, ENCRYPT_DB_NAME) == false) goto L32;
        if (r12 == false) goto L33;
        File r14 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "vectorDataBase");
        if (r14.exists() == false) goto L30;
        FilesKt.deleteRecursively(r14);
    L30:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("contact_sms_entity_donated", false);
        return;
    L33:
        return;
    L32:
        return;
    L22:
        if (r3.mkdirs() == true) goto L24;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder();
        r13 = "backup db failed, mkdirs failed: ";
        goto L17
    L9:
        r1 = null;
        goto L10
    }

    static /* synthetic */ void backupDb$default(MemoryDbEngine r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.backupDb(r1, r2);
    }

    private final void backupOseDb(final String r1, final boolean r2) {
        y.a(null, new $$Lambda$MemoryDbEngine$0HFop_YoXw3wMkDPE5D81PMLGOE(r1, r2), 1, null);
    }

    static /* synthetic */ void backupOseDb$default(MemoryDbEngine r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.backupOseDb(r1, r2);
    }

    private static final Unit backupOseDb$lambda$12(String r11, boolean r12) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        File r2 = r0.getDatabasePath(r11);
        if (r2 == null) goto L6;
        File r3 = r2.getParentFile();
        if (r3 == null) goto L6;
    L14:
        if (r3 != null) goto L19;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backupOseDb: cannot resolve native databases dir", null, 4, null);
    L17:
        return Unit.INSTANCE;
    L19:
        if (r3.exists() == true) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backupOseDb: native db dir not exist: " + r3.getAbsolutePath(), null, 4, null);
        goto L17
    L21:
        final File r1 = new File(r3, "backup");
        if (r1.exists() == false) goto L27;
        if (r1.isDirectory() == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backupOseDb: backupDir is not a directory, delete it: " + r1.getAbsolutePath(), null, 4, null);
        y.a(null, new $$Lambda$MemoryDbEngine$AUXHLxp0IbXpE0Qhbe1qaM3VcA(r1), 1, null);
    L27:
        if (r1.exists() == false) goto L29;
    L31:
        INSTANCE.backupDatabaseFiles(r3, r1, r11, r12);
        goto L17
    L29:
        if (r1.mkdirs() == true) goto L31;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "backupOseDb: mkdirs failed: " + r1.getAbsolutePath(), null, 4, null);
    L6:
        File r4 = r0.getFilesDir();
        if (r4 == null) goto L13;
        File r5 = r4.getParentFile();
        if (r5 == null) goto L13;
        File r6 = r5.getParentFile();
        if (r6 == null) goto L13;
        r3 = new File(r6, "databases");
    L13:
        r3 = null;
        goto L14
    }

    private static final boolean backupOseDb$lambda$12$lambda$11(File r0) {
        return r0.delete();
    }

    private static final Unit buildDatabaseEngine$lambda$8(String r1, int r2, int r3) {
        MemoryDbEngine r4 = INSTANCE;
        r4.backupDb(r1, false);
        if (Intrinsics.areEqual(r1, ENCRYPT_DB_NAME) == false) goto L6;
        r4.backupDb(OSE_KEYWORD_INDEX_DB_NAME, false);
    L6:
        return Unit.INSTANCE;
    }

    private static final boolean buildDatabaseEngine$lambda$9(MemoryFrameDb r4) {
        r4.getInvalidationTracker().refreshVersionsAsync();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        RunLog.INSTANCE.warn(TAG, r4.getOpenHelper().getDatabaseName() + " refreshVersionsAsync error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final Unit buildPersonalDatabaseEngine$lambda$3(String r0, int r1, int r2) {
        INSTANCE.backupDb(r0, false);
        return Unit.INSTANCE;
    }

    private static final boolean buildPersonalDatabaseEngine$lambda$5$lambda$4(PersonalMemoryFrameDb r4) {
        r4.getInvalidationTracker().notifyObserversByTableNames(new String[]{"UnionSemanticMemory", "ShortMemory", "SemanticState"});     // Catch: Exception -> L4
        r4.getInvalidationTracker().refreshVersionsAsync();     // Catch: Exception -> L4
        return true;
    L4:
        e = move-exception;
        RunLog.INSTANCE.warn(TAG, r4.getOpenHelper().getDatabaseName() + " refreshVersionsAsync error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static /* synthetic */ void getMigration_33_34$annotations() {
    }

    private static /* synthetic */ void getMigration_54_55$annotations() {
    }

    private static /* synthetic */ void getMigration_67_68$annotations() {
    }

    private static final MemoryFrameDb globalDbEngine_delegate$lambda$1() {
        return INSTANCE.buildDatabaseEngineWrapper();
    }

    private final boolean isDatabaseFile(File r1, String r2, String r3) {
        if (isDatabaseFileByName(r1, r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (isDatabaseFileByName(r1, r3) == true) goto L8;
        return false;
    }

    private final boolean isDatabaseFileByName(File r3, String r4) {
        if (Intrinsics.areEqual(r3.getName(), r4) == true) goto L6;
        String r2 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "getName(...)");
        if (StringsKt.startsWith$default(r2, r4 + '-', false, 2, null) == true) goto L6;
        return false;
    L6:
        return true;
    }

    public static /* synthetic */ Unit lambda$0HFop_YoXw3wMkDPE5D81PMLGOE(String r0, boolean r1) {
        return backupOseDb$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$AUX-HLxp0IbXpE0Qhbe1qaM3VcA, reason: not valid java name */
    public static /* synthetic */ boolean m569lambda$AUXHLxp0IbXpE0Qhbe1qaM3VcA(File r0) {
        return backupOseDb$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ PersonalMemoryFrameDb lambda$EPQqSUTuhzhpiQpvBcyOUTThdNg() {
        return personalDbEngine_delegate$lambda$2();
    }

    public static /* synthetic */ boolean lambda$H1np8vDHUirMFtkmL6cFGsr3ubo(MemoryFrameDb r0) {
        return buildDatabaseEngine$lambda$9(r0);
    }

    /* JADX INFO: renamed from: lambda$ImqZFLrMhvb9k-6FxcgL_pWyW2M, reason: not valid java name */
    public static /* synthetic */ MemoryFrameDb m570lambda$ImqZFLrMhvb9k6FxcgL_pWyW2M() {
        return globalDbEngine_delegate$lambda$1();
    }

    public static /* synthetic */ Unit lambda$_tqhLdzXq7Ht8JRHJ20Y2yHj5Bo(String r0, int r1, int r2) {
        return buildDatabaseEngine$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$f9Zc_lOHygVNfzrcrXopyan_2CI() {
        return registerRoomDbOpeners$lambda$7();
    }

    public static /* synthetic */ boolean lambda$fNYnEcKL6jiOHvlShRdRF3ltCaA(PersonalMemoryFrameDb r0) {
        return buildPersonalDatabaseEngine$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit lambda$jKmggse5Rq8RjWG5qLDDJ52ERMI(String r0, int r1, int r2) {
        return buildPersonalDatabaseEngine$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$zllxk6y87LqUY8FFQjkpwReakDA() {
        return registerRoomDbOpeners$lambda$6();
    }

    private final void migrateSemanticProductType(SupportSQLiteDatabase r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r24, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (r31 != null) goto L5;
        boolean r10 = true;
    L6:
        if (r32 != null) goto L8;
        boolean r11 = true;
    L9:
        if (r10 != r11) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == false) goto L24;
        String r13 = "";
        if (r31 == null) goto L16;
        String r14 = "AND backupDbVersion > 76";
    L17:
        String r7 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Integer[]{1001, 1002, 1003, 1004}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if (r31 == null) goto L21;
        if (r32 == null) goto L21;
        r13 = " AND unionTable." + r31 + " = proactiveTable." + r32;
    L21:
        StringBuilder r4 = new StringBuilder();
        r4.append("\n            UPDATE ").append(r28).append(" AS proactiveTable\n            SET ").append(r30).append(" = (\n                SELECT unionTable.").append(r27).append("\n                FROM ").append(r25).append(" AS unionTable\n                WHERE unionTable.").append(r26).append(" = proactiveTable.").append(r29).append(r13).append("\n            )\n            WHERE EXISTS (\n                SELECT 1\n                FROM ").append(r25).append(" AS unionTable\n                WHERE unionTable.").append(r26).append(" = proactiveTable.").append(r29).append(r13).append("\n                    AND unionTable.").append(r27).append(" NOT IN (");
        r4.append(r7).append(")\n            )\n            ");
        r6.execSQL(StringsKt.trimIndent(r4.toString()));
        StringBuilder r1 = new StringBuilder();
        r1.append("\n            UPDATE ").append(r25).append("\n            SET ").append(r27).append(" = CASE\n                WHEN ").append(r27).append(" = 11 THEN ").append(1001).append("\n                WHEN ").append(r27).append(" IN (").append(r7).append(") THEN ").append(r27).append("\n                ELSE ").append(1003).append("\n            END\n            WHERE (").append(r27).append(" NOT IN (").append(r7).append(")) ").append(r14).append("\n            ");
        r6.execSQL(StringsKt.trimIndent(r1.toString()));
        return;
    L16:
        r14 = "";
        goto L17
    L24:
        throw new IllegalArgumentException("unionUserIdColumn and proactiveUserIdColumn must be both null or both non-null".toString());
    L11:
        r12 = false;
        goto L12
    L8:
        r11 = false;
        goto L9
    L5:
        r10 = false;
        goto L6
    }

    static /* synthetic */ void migrateSemanticProductType$default(MemoryDbEngine r12, SupportSQLiteDatabase r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r13, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if ((r22 & 128) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r22 & 256) == 0) goto L9;
        String r11 = null;
    L10:
        r12.migrateSemanticProductType(r3, r14, r15, r16, r17, r18, r19, r10, r11);
        return;
    L9:
        r11 = r21;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }

    private static final PersonalMemoryFrameDb personalDbEngine_delegate$lambda$2() {
        return INSTANCE.buildPersonalDatabaseEngine(com.obric.memorydata.middleware.database.b.f11646a.b(USER_LOGIC_DB_NAME));
    }

    private static final Unit registerRoomDbOpeners$lambda$6() {
        INSTANCE.getGlobalDbEngine();
        return Unit.INSTANCE;
    }

    private static final Unit registerRoomDbOpeners$lambda$7() {
        INSTANCE.getPersonalDbEngine();
        return Unit.INSTANCE;
    }

    public final MemoryFrameDb buildDatabaseEngine(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "dbName");
        final MemoryFrameDb r4 = (MemoryFrameDb) ZeusTransformUtils.preCheckCast(Room.databaseBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), MemoryFrameDb.class, r5).openHelperFactory((SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new DowngradeBackupOpenHelperFactory(r5, com.obric.memorydata.middleware.database.d.f11652a.a(r5), new $$Lambda$MemoryDbEngine$_tqhLdzXq7Ht8JRHJ20Y2yHj5Bo(r5)), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin")).fallbackToDestructiveMigrationOnDowngrade().addCallback((RoomDatabase.Callback) ZeusTransformUtils.preCheckCast(new MemoryDbEngine$buildDatabaseEngine$db$2(r5), RoomDatabase.Callback.class, "com.obric.memorydata.plugin")).addMigrations(new Migration[]{migration_1_2}).addMigrations(new Migration[]{migration_2_3}).addMigrations(new Migration[]{migration_3_4}).addMigrations(new Migration[]{migration_4_5}).addMigrations(new Migration[]{migration_5_6}).addMigrations(new Migration[]{migration_6_7}).addMigrations(new Migration[]{migration_7_8}).addMigrations(new Migration[]{migration_8_9}).addMigrations(new Migration[]{migration_9_10}).addMigrations(new Migration[]{migration_10_11}).addMigrations(new Migration[]{migration_11_12}).addMigrations(new Migration[]{migration_12_13}).addMigrations(new Migration[]{migration_13_14}).addMigrations(new Migration[]{migration_14_15}).addMigrations(new Migration[]{migration_15_16}).addMigrations(new Migration[]{migration_19_20}).addMigrations(new Migration[]{migration_21_22}).addMigrations(new Migration[]{migration_33_34}).addMigrations(new Migration[]{migration_37_38}).addMigrations(new Migration[]{migration_39_40}).addMigrations(new Migration[]{migration_42_43}).addMigrations(new Migration[]{migration_43_44}).addMigrations(new Migration[]{migration_51_52}).addMigrations(new Migration[]{migration_54_55}).addMigrations(new Migration[]{migration_56_57}).addMigrations(new Migration[]{migration_61_62}).addMigrations(new Migration[]{migration_67_68}).addMigrations(new Migration[]{migration_71_72}).addMigrations(new Migration[]{migration_77_78}).addMigrations(new Migration[]{migration_80_81}).addMigrations(new Migration[]{migration_85_86}).addMigrations(new Migration[]{migration_89_90}).addMigrations(new Migration[]{GlobalContentTimeIndexCleanupMigration.INSTANCE}).build(), MemoryFrameDb.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.database.c r6 = com.obric.memorydata.middleware.database.c.f11648a;
        String r0 = r4.getOpenHelper().getDatabaseName();
        Intrinsics.checkNotNull(r0);
        r6.a(r0, r4.getOpenHelper().getWritableDatabase(), new $$Lambda$MemoryDbEngine$H1np8vDHUirMFtkmL6cFGsr3ubo(r4));
        return r4;
    }

    public final MemoryFrameDb buildDatabaseEngineWrapper() {
        return buildDatabaseEngine(ENCRYPT_DB_NAME);
    L5:
        e = move-exception;
        backupDb$default(this, ENCRYPT_DB_NAME, false, 2, null);
        backupDb$default(this, OSE_KEYWORD_INDEX_DB_NAME, false, 2, null);
        throw e;
    }

    public final PersonalMemoryFrameDb buildPersonalDatabaseEngine(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "dbName");
        RoomDatabase r5 = Room.databaseBuilder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), PersonalMemoryFrameDb.class, r6).openHelperFactory((SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.preCheckCast(new DowngradeBackupOpenHelperFactory(r6, com.obric.memorydata.middleware.database.d.f11652a.a(r6), new $$Lambda$MemoryDbEngine$jKmggse5Rq8RjWG5qLDDJ52ERMI(r6)), SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin")).addMigrations(new Migration[]{PersonalMemoryInAppMigration.INSTANCE}).addMigrations(new Migration[]{PersonalContentTimeIndexCleanupMigration.INSTANCE}).fallbackToDestructiveMigrationOnDowngrade().addCallback((RoomDatabase.Callback) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r6), RoomDatabase.Callback.class, "com.obric.memorydata.plugin")).addCallback(j.f9572a.b()).addMigrations(new Migration[]{j.f9572a.a()}).build();
        final PersonalMemoryFrameDb r7 = (PersonalMemoryFrameDb) ZeusTransformUtils.preCheckCast(r5, PersonalMemoryFrameDb.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.database.c r1 = com.obric.memorydata.middleware.database.c.f11648a;
        String r2 = r7.getOpenHelper().getDatabaseName();
        Intrinsics.checkNotNull(r2);
        r1.a(r2, r7.getOpenHelper().getWritableDatabase(), new $$Lambda$MemoryDbEngine$fNYnEcKL6jiOHvlShRdRF3ltCaA(r7));
        return (PersonalMemoryFrameDb) ZeusTransformUtils.preCheckCast(r5, PersonalMemoryFrameDb.class, "com.obric.memorydata.plugin");
    }

    public final MemoryFrameDb getGlobalDbEngine() {
        return (MemoryFrameDb) ZeusTransformUtils.preCheckCast(globalDbEngine$delegate.getValue(), MemoryFrameDb.class, "com.obric.memorydata.plugin");
    }

    public final PersonalMemoryFrameDb getPersonalDbEngine() {
        return (PersonalMemoryFrameDb) ZeusTransformUtils.preCheckCast(personalDbEngine$delegate.getValue(), PersonalMemoryFrameDb.class, "com.obric.memorydata.plugin");
    }

    public final void registerRoomDbOpeners() {
        com.obric.memorydata.middleware.database.c.f11648a.a(ENCRYPT_DB_NAME, $$Lambda$MemoryDbEngine$zllxk6y87LqUY8FFQjkpwReakDA.INSTANCE);
        com.obric.memorydata.middleware.database.c.f11648a.a(USER_LOGIC_DB_NAME, $$Lambda$MemoryDbEngine$f9Zc_lOHygVNfzrcrXopyan_2CI.INSTANCE);
    }
}
