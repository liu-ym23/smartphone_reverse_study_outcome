package com.bytedance.ai.resource.core.db;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageDatabase.kt\ncom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,184:1\n1863#2:185\n1863#2,2:186\n1863#2,2:188\n1863#2,2:190\n1864#2:192\n*S KotlinDebug\n*F\n+ 1 AIPackageDatabase.kt\ncom/bytedance/ai/resource/core/db/AIPackageDatabase$Companion$MIGRATION_1_2$1\n*L\n51#1:185\n77#1:186,2\n87#1:188,2\n93#1:190,2\n51#1:192\n*E\n"})
public final class AIPackageDatabase$Companion$MIGRATION_1_2$1 extends Migration {
    public AIPackageDatabase$Companion$MIGRATION_1_2$1() {
        super(1, 2);
    }

    public static /* synthetic */ String a(Exception r5) {
        return migrate$lambda$7(r5);
    }

    private static final String migrate$lambda$7(Exception r5) {
        return ExceptionsKt.stackTraceToString(r5);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase r14) {
        Intrinsics.checkNotNullParameter(r14, "database");
        Iterator r5 = CollectionsKt.mutableListOf(new String[]{"ai_widget_info", "ai_applet_info"}).iterator();     // Catch: Exception -> L17
    L5:
        if (r5.hasNext() == false) goto L50;
        String r10 = (String) r5.next();     // Catch: Exception -> L17
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L17
        Cursor r12 = r14.query("PRAGMA table_info(" + r10 + ')');     // Catch: Exception -> L17
        if (r12 != null) goto L9;
    L25:
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L17
        r13.append("CREATE TABLE temp_table (");     // Catch: Exception -> L17
        Iterator r15 = r11.iterator();     // Catch: Exception -> L17
    L28:
        if (r15.hasNext() == false) goto L30;
        AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column r16 = (AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column) r15.next();     // Catch: Exception -> L17
        r13.append(r16.getName() + ' ' + r16.getType() + ' ' + r16.getNotNull() + ' ' + r16.getDefaultValue() + ", ");     // Catch: Exception -> L17
        goto L28
    L30:
        r13.append("PRIMARY KEY (id))");     // Catch: Exception -> L17
        String r17 = r13.toString();     // Catch: Exception -> L17
        String r18 = "===========>>>>> " + r17;     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageDatabase", "tag");     // Catch: Exception -> L17
        d r19 = c.f2846a;     // Catch: Exception -> L17
        if (r19 == null) goto L33;
        r19.d("AIPackageDatabase", r18);     // Catch: Exception -> L17
    L33:
        r14.execSQL(r17);     // Catch: Exception -> L17
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L17
        r20.append("INSERT INTO temp_table(");     // Catch: Exception -> L17
        Iterator r21 = r11.iterator();     // Catch: Exception -> L17
    L36:
        if (r21.hasNext() == false) goto L40;
        AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column r22 = (AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column) r21.next();     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r22.getName(), "id") == true) goto L36;
        r20.append(r22.getName() + ", ");     // Catch: Exception -> L17
        goto L36
    L40:
        r20.append("id) SELECT ");     // Catch: Exception -> L17
        Iterator r23 = r11.iterator();     // Catch: Exception -> L17
    L42:
        if (r23.hasNext() == false) goto L46;
        AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column r24 = (AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column) r23.next();     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r24.getName(), "id") == true) goto L42;
        r20.append(r24.getName() + ", ");     // Catch: Exception -> L17
        goto L42
    L46:
        r20.append("id FROM " + r10);     // Catch: Exception -> L17
        String r25 = r20.toString();     // Catch: Exception -> L17
        String r26 = "===========>>>>> " + r25;     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageDatabase", "tag");     // Catch: Exception -> L17
        d r27 = c.f2846a;     // Catch: Exception -> L17
        if (r27 == null) goto L49;
        r27.d("AIPackageDatabase", r26);     // Catch: Exception -> L17
    L49:
        r14.execSQL(r25);     // Catch: Exception -> L17
        r14.execSQL("DROP TABLE " + r10);     // Catch: Exception -> L17
        r14.execSQL("ALTER TABLE temp_table RENAME TO " + r10);     // Catch: Exception -> L17
        r14.execSQL("ALTER TABLE " + r10 + " ADD COLUMN manifest_version TEXT NOT NULL DEFAULT ''");     // Catch: Exception -> L17
    L9:
        if (r12.moveToNext() == false) goto L24;
        String r28 = r12.getString(r12.getColumnIndexOrThrow("name"));     // Catch: Exception -> L17
        if (Intrinsics.areEqual(r28, "type") == true) goto L9;
        String r29 = r12.getString(r12.getColumnIndexOrThrow("type"));     // Catch: Exception -> L17
        String r110 = "";
        if (Intrinsics.areEqual(r12.getString(r12.getColumnIndexOrThrow("dflt_value")), "null") == false) goto L19;
        String r30 = "DEFAULT ''";
    L21:
        if (r12.getInt(r12.getColumnIndexOrThrow("notnull")) != 1) goto L23;
        r110 = "NOT NULL";
    L23:
        Intrinsics.checkNotNull(r28);     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r29);     // Catch: Exception -> L17
        r11.add(new AIPackageDatabase$Companion$MIGRATION_1_2$1$migrate$Column(r28, r29, r110, r30));     // Catch: Exception -> L17
        goto L9
    L19:
        r30 = "";
        goto L21
    L24:
        r12.close();     // Catch: Exception -> L17
        goto L25
    L50:
        r14.execSQL("ALTER TABLE ai_applet_info ADD COLUMN applet_entry TEXT NOT NULL DEFAULT ''");     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        String r111 = "MIGRATION_1_2 error : " + new b(e, 0);
        Intrinsics.checkNotNullParameter("AIPackageDatabase", "tag");
        d r112 = c.f2846a;
        if (r112 == null) goto L78;
        r112.e("AIPackageDatabase", r111);
        return;
    }
}
