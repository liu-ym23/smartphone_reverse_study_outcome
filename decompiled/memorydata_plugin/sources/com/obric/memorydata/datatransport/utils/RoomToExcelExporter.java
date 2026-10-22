package com.obric.memorydata.datatransport.utils;

import android.content.Context;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007MNOPQRSB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0005H\u0002J \u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J&\u0010/\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\b\b\u0002\u00101\u001a\u00020\u0017J>\u00102\u001a\u0002032\u0006\u00104\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J@\u00108\u001a\u0002032\u0006\u00109\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0002J>\u0010=\u001a\u0002032\u0006\u0010>\u001a\u00020?2\u0006\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J$\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020A0\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020EH\u0002J\u001e\u0010F\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0002J*\u0010H\u001a\u00020\u00172\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010L\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter;", "", "<init>", "()V", "TAG", "", "EXCEL_CELL_TEXT_MAX", "", "exportAllTables", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseExportResult;", "roomDb", "Landroidx/room/RoomDatabase;", "fileName", "databaseScope", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "groupByColumns", "", "onTableCompleted", "Lkotlin/Function1;", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "", "shouldContinue", "Lkotlin/Function0;", "", "queryUserTables", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "MAX_ROWS_PER_SHEET", "exportTableToZip", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableWriteResult;", "zos", "Ljava/util/zip/ZipOutputStream;", "tableName", "groupByColumn", "queryTableColumns", "writeCursorRow", "row", "Lorg/apache/poi/ss/usermodel/Row;", "cursor", "Landroid/database/Cursor;", "columnCount", "ensureTargetFile", "Ljava/io/File;", "rawFileName", "safeSheetName", ActivityLifecycle.NAME, "clearTables", "tables", "resetAutoIncrement", "importFromXlsx", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$ImportResult;", "file", "whitelist", "", "sheetNameToTable", "importFromZip", "zipFile", "parseSplitExcelName", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$SplitExcelName;", "entryName", "importFromXlsxInternal", "input", "Ljava/io/InputStream;", "getTableInfo", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$ColInfo;", "table", "normalizeHeader", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lorg/apache/poi/ss/usermodel/Cell;", "buildInsertSql", "cols", "bindCell", "stmt", "Landroidx/sqlite/db/SupportSQLiteStatement;", "index", "colType", "DatabaseScope", "TableExportResult", "TableWriteResult", "DatabaseExportResult", "ImportResult", "SplitExcelName", "ColInfo", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RoomToExcelExporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RoomToExcelExporter f9813a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "", "<init>", "(Ljava/lang/String;I)V", "UNSPECIFIED", "GLOBAL", "PERSONAL", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum DatabaseScope extends Enum<DatabaseScope> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DatabaseScope[] $VALUES = null;
        public static final DatabaseScope GLOBAL = null;
        public static final DatabaseScope PERSONAL = null;
        public static final DatabaseScope UNSPECIFIED = null;

        private static final /* synthetic */ DatabaseScope[] $values() {
            return new DatabaseScope[]{UNSPECIFIED, GLOBAL, PERSONAL};
        }

        static {
            UNSPECIFIED = new DatabaseScope("UNSPECIFIED", 0);
            GLOBAL = new DatabaseScope("GLOBAL", 1);
            PERSONAL = new DatabaseScope("PERSONAL", 2);
            DatabaseScope[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DatabaseScope(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DatabaseScope> getEntries() {
            return $ENTRIES;
        }

        public static DatabaseScope valueOf(String r2) {
            return (DatabaseScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(DatabaseScope.class, r2), DatabaseScope.class, "com.obric.memorydata.plugin");
        }

        public static DatabaseScope[] values() {
            return (DatabaseScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DatabaseScope[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$ColInfo;", "", ActivityLifecycle.NAME, "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9815b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "type");
            this.f9814a = r2;
            this.f9815b = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9814a, r6.f9814a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9815b, r6.f9815b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getType() {
            return this.f9815b;
        }

        public int hashCode() {
            return (this.f9814a.hashCode() * 31) + this.f9815b.hashCode();
        }

        public String toString() {
            return "ColInfo(name=" + this.f9814a + ", type=" + this.f9815b + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseExportResult;", "", Params.FILE_PATH, "", "tableResults", "", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getFilePath", "()Ljava/lang/String;", "getTableResults", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<e> f9817b;

        public b(String r3, List<e> r4) {
            List<e> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Params.FILE_PATH);
            Intrinsics.checkNotNullParameter(r5, "tableResults");
            this.f9816a = r3;
            this.f9817b = r5;
        }

        public final List<e> a() {
            return this.f9817b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9816a, r6.f9816a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9817b, r6.f9817b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9816a.hashCode() * 31) + this.f9817b.hashCode();
        }

        public String toString() {
            return "DatabaseExportResult(filePath=" + this.f9816a + ", tableResults=" + this.f9817b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J5\u0010\u000e\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$ImportResult;", "", "insertedPerTable", "", "", "", "errors", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getInsertedPerTable", "()Ljava/util/Map;", "getErrors", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Integer> f9818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, String> f9819b;

        public c(Map<String, Integer> r3, Map<String, String> r4) {
            Map<String, Integer> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "insertedPerTable");
            Intrinsics.checkNotNullParameter(r6, "errors");
            this.f9818a = r5;
            this.f9819b = r6;
        }

        public final Map<String, Integer> a() {
            return this.f9818a;
        }

        public final Map<String, String> b() {
            return this.f9819b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9818a, r6.f9818a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9819b, r6.f9819b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9818a.hashCode() * 31) + this.f9819b.hashCode();
        }

        public String toString() {
            return "ImportResult(insertedPerTable=" + this.f9818a + ", errors=" + this.f9819b + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$SplitExcelName;", "", "baseName", "", "partIndex", "", "<init>", "(Ljava/lang/String;I)V", "getBaseName", "()Ljava/lang/String;", "getPartIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9821b;

        public d(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "baseName");
            this.f9820a = r2;
            this.f9821b = r3;
        }

        public final String a() {
            return this.f9820a;
        }

        public final int b() {
            return this.f9821b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9820a, r6.f9820a) == true) goto L12;
            return false;
        L12:
            if (this.f9821b == r6.f9821b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f9820a.hashCode() * 31) + Integer.hashCode(this.f9821b);
        }

        public String toString() {
            return "SplitExcelName(baseName=" + this.f9820a + ", partIndex=" + this.f9821b + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "", "tableName", "", "exportedRowCount", "", "groupedRowCounts", "", "errorMessage", "databaseScope", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "<init>", "(Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;)V", "getTableName", "()Ljava/lang/String;", "getExportedRowCount", "()J", "getGroupedRowCounts", "()Ljava/util/Map;", "getErrorMessage", "getDatabaseScope", "()Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$DatabaseScope;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9823b;
        private final Map<String, Long> c;
        private final String d;
        private final DatabaseScope e;

        public e(String r3, long r4, Map<String, Long> r6, String r7, DatabaseScope r8) {
            Map<String, Long> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "tableName");
            Intrinsics.checkNotNullParameter(r9, "groupedRowCounts");
            Intrinsics.checkNotNullParameter(r8, "databaseScope");
            this.f9822a = r3;
            this.f9823b = r4;
            this.c = r9;
            this.d = r7;
            this.e = r8;
        }

        public /* synthetic */ e(String r8, long r9, Map r11, String r12, DatabaseScope r13, int r14, DefaultConstructorMarker r15) {
            Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
            if ((r14 & 4) == 0) goto L5;
            r16 = MapsKt.emptyMap();
        L5:
            Map r4 = r16;
            if ((r14 & 8) == 0) goto L8;
            r12 = null;
        L8:
            String r5 = r12;
            if ((r14 & 16) == 0) goto L11;
            r13 = DatabaseScope.UNSPECIFIED;
        L11:
            this(r8, r9, r4, r5, r13);
        }

        public final String a() {
            return this.f9822a;
        }

        public final long b() {
            return this.f9823b;
        }

        public final Map<String, Long> c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final DatabaseScope e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9822a, r10.f9822a) == true) goto L12;
            return false;
        L12:
            if (this.f9823b == r10.f9823b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f9822a.hashCode() * 31) + Long.hashCode(this.f9823b)) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TableExportResult(tableName=" + this.f9822a + ", exportedRowCount=" + this.f9823b + ", groupedRowCounts=" + this.c + ", errorMessage=" + this.d + ", databaseScope=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableWriteResult;", "", "exportedRowCount", "", "groupedRowCounts", "", "", "<init>", "(JLjava/util/Map;)V", "getExportedRowCount", "()J", "getGroupedRowCounts", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Long> f9825b;

        public f(long r3, Map<String, Long> r5) {
            Map<String, Long> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "groupedRowCounts");
            this.f9824a = r3;
            this.f9825b = r6;
        }

        public final long a() {
            return this.f9824a;
        }

        public final Map<String, Long> b() {
            return this.f9825b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
            return false;
        L8:
            f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
            if (this.f9824a == r10.f9824a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9825b, r10.f9825b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f9824a) * 31) + this.f9825b.hashCode();
        }

        public String toString() {
            return "TableWriteResult(exportedRowCount=" + this.f9824a + ", groupedRowCounts=" + this.f9825b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9826a = null;

        static {
            int[] r0 = new int[CellType.values().length];
            r0[CellType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CellType.NUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CellType.BLANK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CellType._NONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f9826a = r0;
        }
    }

    static {
        f9813a = new RoomToExcelExporter();
    }

    private RoomToExcelExporter() {
    }

    public static /* synthetic */ c a(RoomToExcelExporter r1, File r2, SupportSQLiteDatabase r3, Set r4, Function1 r5, int r6, Object r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Function1<? super String, String> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r10 = $$Lambda$RoomToExcelExporter$XpShYZWlRHPLTq7abinkJ5w_g.INSTANCE;
    L9:
        return r1.a(r2, r8, r9, r10);
    }

    private final f a(SupportSQLiteDatabase r28, ZipOutputStream r29, String r30, String r31, Function0<Boolean> r32) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r28, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r32, Function0.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomToExcelExporter", "start export table " + r30, false, 4, null);
        List<String> r6 = a(r3, r30);
        long r8 = 0;
        if (r6.isEmpty() == true) goto L5;
        String r7 = "SELECT * FROM `" + r30 + '`';
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L14;
        Integer r2 = Integer.valueOf(r6.indexOf(r31));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
    L15:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query(r7), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r9 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L87
        int r210 = r6.size();     // Catch: Throwable -> L87
        int r11 = 1;
        XSSFWorkbook r15 = null;
        int r16 = 0;
        Sheet r17 = null;
        int r18 = 0;
        long r13 = 0;
    L19:
        if (r9.moveToNext() == false) goto L60;
        if ((r13 % 100) == r8) goto L24;
    L28:
        if (r15 != null) goto L37;
        r15 = new XSSFWorkbook();     // Catch: Throwable -> L87
        Sheet r12 = (Sheet) ZeusTransformUtils.preCheckCast(r15.createSheet(f9813a.b(r30)), Sheet.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L87
        XSSFRow r19 = ((XSSFSheet) ZeusTransformUtils.preCheckCast(r12, XSSFSheet.class, "com.obric.memorydata.plugin")).createRow(0);     // Catch: Throwable -> L87
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L87
        int r21 = 0;
    L31:
        if (r20.hasNext() == false) goto L36;
        XSSFWorkbook r110 = r15;
        Object r111 = r20.next();     // Catch: Throwable -> L87
        int r22 = r21 + 1;     // Catch: Throwable -> L87
        if (r21 >= 0) goto L35;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L87
    L35:
        Iterator r23 = r20;
        r19.createCell(r21).setCellValue((String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L87
        r15 = r110;
        r21 = r22;
        r20 = r23;
        goto L31
    L36:
        Sheet r24 = r12;
        int r25 = 1;
    L38:
        Intrinsics.checkNotNull(r24);     // Catch: Throwable -> L87
        r16 = r25 + 1;     // Catch: Throwable -> L87
        Row r26 = r24.createRow(r25);     // Catch: Throwable -> L87
        RoomToExcelExporter r27 = f9813a;     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L87
        r17 = r24;
        int r33 = r210;
        r27.a(r26, r9, r33);     // Catch: Throwable -> L87
        r210 = r33;
        int r34 = r18 + 1;     // Catch: Throwable -> L87
        r13 = r13 + 1;     // Catch: Throwable -> L87
        if (r2 == null) goto L51;
        int r35 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L87
        if (r9.isNull(r35) == false) goto L43;
        String r36 = "";
    L44:
        Long r37 = (Long) ZeusTransformUtils.preCheckCast(r10.get(r36), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L87
        if (r37 == null) goto L47;
        long r211 = r37.longValue();     // Catch: Throwable -> L87
    L48:
        r10.put(r36, Long.valueOf(r211 + 1));     // Catch: Throwable -> L87
        goto L51
    L47:
        r211 = 0;
        goto L48
    L43:
        r36 = r9.getString(r35);     // Catch: Throwable -> L87
    L51:
        if (r34 >= 6000) goto L53;
        r18 = r34;
        r8 = 0;
        goto L19
    L53:
        if (r11 != 1) goto L56;
        StringBuilder r38 = new StringBuilder().append(r27.b(r30)).append(".xlsx");     // Catch: Throwable -> L87
    L57:
        r29.putNextEntry(new ZipEntry(r38.toString()));     // Catch: Throwable -> L87
        r15.write((OutputStream) ZeusTransformUtils.preCheckCast(r29, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L87
        r29.closeEntry();     // Catch: Throwable -> L87
        r15.close();     // Catch: Throwable -> L87
        r11 = r11 + 1;     // Catch: Throwable -> L87
        r8 = 0;
        r15 = null;
        r17 = null;
        r18 = 0;
        goto L19
    L56:
        r38 = new StringBuilder().append(r27.b(r30)).append('_').append(r11).append(".xlsx");     // Catch: Throwable -> L87
        goto L57
    L37:
        r25 = r16;
        r24 = r17;
        goto L38
    L24:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L28;
        throw new CancellationException("data export account changed");     // Catch: Throwable -> L87
    L60:
        if (r15 == null) goto L67;
        if (r11 != 1) goto L64;
        StringBuilder r1 = new StringBuilder().append(f9813a.b(r30)).append(".xlsx");     // Catch: Throwable -> L87
    L65:
        r29.putNextEntry(new ZipEntry(r1.toString()));     // Catch: Throwable -> L87
        r15.write((OutputStream) ZeusTransformUtils.preCheckCast(r29, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L87
        r29.closeEntry();     // Catch: Throwable -> L87
        r15.close();     // Catch: Throwable -> L87
    L84:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L87
        CloseableKt.closeFinally(r4, null);
        return new f(r13, r10);
    L64:
        r1 = new StringBuilder().append(f9813a.b(r30)).append('_').append(r11).append(".xlsx");     // Catch: Throwable -> L87
        goto L65
    L67:
        if (r11 != 1) goto L84;
        XSSFWorkbook r39 = new XSSFWorkbook();     // Catch: Throwable -> L80
        int r40 = 0;
        XSSFRow r41 = ((XSSFSheet) ZeusTransformUtils.preCheckCast((Sheet) ZeusTransformUtils.preCheckCast(r39.createSheet(f9813a.b(r30)), Sheet.class, "com.obric.memorydata.plugin"), XSSFSheet.class, "com.obric.memorydata.plugin")).createRow(0);     // Catch: Throwable -> L78
        Iterator r42 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L78
    L71:
        if (r42.hasNext() == false) goto L76;
        Object r43 = r42.next();     // Catch: Throwable -> L78
        int r44 = r40 + 1;     // Catch: Throwable -> L78
        if (r40 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L78
    L75:
        r41.createCell(r40).setCellValue((String) ZeusTransformUtils.preCheckCast(r43, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L78
        r40 = r44;
        goto L71
    L76:
        r29.putNextEntry(new ZipEntry(f9813a.b(r30) + ".xlsx"));     // Catch: Throwable -> L78
        r39.write((OutputStream) ZeusTransformUtils.preCheckCast(r29, OutputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L78
        r29.closeEntry();     // Catch: Throwable -> L78
        r39.close();     // Catch: Throwable -> L87
    L78:
        th = th;
        r15 = r39;
    L81:
        if (r15 == null) goto L83;
        r15.close();     // Catch: Throwable -> L87
    L83:
        throw th;     // Catch: Throwable -> L87
    L80:
        th = th;
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L11:
        r14 = false;
    L14:
        r2 = null;
        goto L15
    L5:
        return new f(0, MapsKt.emptyMap());
    }

    private final File a(String r5) {
        File r0 = com.obric.memorydata.datatransport.api.d.f9726a.b();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r5 = "room_backup_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
    L11:
        File r3 = new File(r0, r5 + ".zip");
        if (r3.exists() == true) goto L18;
    L17:
        return r3;
    L18:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        RoomToExcelExporter r4 = (RoomToExcelExporter) ZeusTransformUtils.preCheckCast(this, RoomToExcelExporter.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Boolean.valueOf(r3.delete()));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private static final Comparable a(ZipEntry r2) {
        RoomToExcelExporter r0 = f9813a;
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        return (Comparable) ZeusTransformUtils.preCheckCast(r0.c(r3).a(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r12, List<String> r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$RoomToExcelExporter$IE4CmGPNKRw6VXwLoYdvj_rS30c.INSTANCE, 30, null);
        int r15 = r11.size();
        ArrayList r1 = new ArrayList(r15);
        int r2 = 0;
    L3:
        if (r2 >= r15) goto L6;
        r1.add("?");
        r2 = r2 + 1;
        goto L3
    L6:
        return "INSERT INTO `" + r12 + "` (" + r14 + ") VALUES (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')';
    }

    private final String a(Cell r4) {
        Cell r3 = (Cell) ZeusTransformUtils.wrapperContextForParams(r4, Cell.class, "com.obric.memorydata.plugin");
        CellType r5 = r3.getCellType();
        if (r5 != null) goto L5;
        int r6 = -1;
    L6:
        String r2 = "";
        if (r6 != 1) goto L9;
        String r7 = r3.getStringCellValue();
        if (r7 == null) goto L25;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L26:
        if (r8 == null) goto L29;
        r2 = r8;
    L29:
        String r9 = r2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "toLowerCase(...)");
        return r9;
    L25:
        r8 = null;
        goto L26
    L9:
        if (r6 != 2) goto L11;
        r2 = String.valueOf(r3.getNumericCellValue());
        goto L29
    L11:
        if (r6 == 3) goto L18;
        if (r6 == 4) goto L29;
        if (r6 == 5) goto L29;
        r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3.toString(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        goto L29
    L18:
        if (r3.getBooleanCellValue() == false) goto L20;
        r2 = "1";
        goto L29
    L20:
        r2 = "0";
        goto L29
    L5:
        r6 = g.f9826a[r5.ordinal()];
        goto L6
    }

    private final List<String> a(SupportSQLiteDatabase r4) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query("SELECT name FROM sqlite_master \nWHERE type='table' \n  AND name NOT LIKE 'android_%'\n  AND name NOT LIKE 'sqlite_%'\n  AND name NOT IN ('room_master_table')\nORDER BY name"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r6, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L5:
        if (r0.moveToNext() == false) goto L7;
        String r1 = r0.getString(0);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L10
        r5.add(r1);     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r6, null);
        return r5;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    private final List<String> a(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query("PRAGMA table_info(`" + r5 + "`)"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        int r0 = r8.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L10
    L5:
        if (r8.moveToNext() == false) goto L7;
        String r1 = r8.getString(r0);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L10
        r6.add(r1);     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);
        return r6;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static /* synthetic */ void a(RoomToExcelExporter r1, SupportSQLiteDatabase r2, List r3, boolean r4, int r5, Object r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = true;
    L5:
        r1.a(r7, r8, r4);
    }

    private final void a(Row r10, Cursor r11, int r12) {
        Row r9 = (Row) ZeusTransformUtils.wrapperContextForParams(r10, Row.class, "com.obric.memorydata.plugin");
        Cursor r13 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r11, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        if (r1 >= r12) goto L36;
        Cell r2 = r9.createCell(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "createCell(...)");
        int r3 = r13.getType(r1);
        String r4 = "";
        if (r3 != 0) goto L7;
    L34:
        r2.setCellValue(r4);
    L35:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 != 1) goto L9;
        double r5 = r13.getLong(r1);
    L33:
        r2.setCellValue(r5);
        goto L35
    L9:
        if (r3 != 2) goto L11;
        r5 = r13.getDouble(r1);
        goto L33
    L11:
        if (r3 != 3) goto L13;
        String r6 = r13.getString(r1);
        if (r6 == null) goto L28;
        r4 = r6;
    L28:
        if (r4.length() <= 32767) goto L34;
        String r7 = r4.substring(0, 32767);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        r2.setCellValue(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomToExcelExporter", "truncate large text", null, 4, null);
        goto L35
    L13:
        if (r3 == 4) goto L18;
        String r8 = r13.getString(r1);
        if (r8 == null) goto L34;
        r4 = r8;
        goto L34
    L18:
        byte[] r14 = r13.getBlob(r1);
        StringBuilder r15 = new StringBuilder().append("[BLOB ");
        if (r14 == null) goto L21;
        int r16 = r14.length;
    L22:
        r2.setCellValue(r15.append(r16).append(" bytes]").toString());
        goto L35
    L21:
        r16 = 0;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(SupportSQLiteStatement r11, int r12, Cell r13, String r14) {
        SupportSQLiteStatement r10 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        Cell r15 = (Cell) ZeusTransformUtils.wrapperContextForParams(r13, Cell.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L5;
    L100:
        r10.bindNull(r12);
        return false;
    L5:
        if (r15.getCellType() == CellType.BLANK) goto L100;
        if (r15.getCellType() == CellType._NONE) goto L100;
        Long r4 = null;
        String r5 = null;
        Double r6 = null;
        int r7 = -1;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("INT", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L12;
    L79:
        CellType r16 = r15.getCellType();
        if (r16 == null) goto L83;
        r7 = g.f9826a[r16.ordinal()];
    L83:
        if (r7 == 1) goto L93;
        if (r7 == 2) goto L91;
        if (r7 == 3) goto L88;
    L94:
        if (r4 != null) goto L96;
        r10.bindNull(r12);
    L97:
        if (r4 != null) goto L99;
        return false;
    L99:
        return true;
    L96:
        r10.bindLong(r12, r4.longValue());
        goto L97
    L88:
        if (r15.getBooleanCellValue() == false) goto L90;
        long r0 = 1;
    L92:
        r4 = Long.valueOf(r0);
        goto L94
    L90:
        r0 = 0;
        goto L92
    L91:
        r0 = (long) r15.getNumericCellValue();
        goto L92
    L93:
        String r17 = r15.getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(r17, "getStringCellValue(...)");
        r4 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L94
    L12:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("BOOL", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L79;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TINY", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L79;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("SMALL", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L79;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("BIG", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L79;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("REAL", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L23;
    L59:
        CellType r18 = r15.getCellType();
        if (r18 == null) goto L63;
        r7 = g.f9826a[r18.ordinal()];
    L63:
        if (r7 == 1) goto L73;
        if (r7 == 2) goto L71;
        if (r7 == 3) goto L68;
    L74:
        if (r6 != null) goto L76;
        r10.bindNull(r12);
    L77:
        if (r6 != null) goto L99;
        return false;
    L76:
        r10.bindDouble(r12, r6.doubleValue());
        goto L77
    L68:
        if (r15.getBooleanCellValue() == false) goto L70;
        double r1 = 1.0d;
    L72:
        r6 = Double.valueOf(r1);
        goto L74
    L70:
        r1 = 0.0d;
        goto L72
    L71:
        r1 = r15.getNumericCellValue();
        goto L72
    L73:
        String r19 = r15.getStringCellValue();
        Intrinsics.checkNotNullExpressionValue(r19, "getStringCellValue(...)");
        r6 = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L74
    L23:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("FLOA", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L59;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("DOUB", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L59;
        CellType r110 = r15.getCellType();
        if (r110 == null) goto L31;
        r7 = g.f9826a[r110.ordinal()];
    L31:
        if (r7 == 1) goto L46;
        if (r7 == 2) goto L39;
        if (r7 == 3) goto L36;
        String r111 = r15.toString();
    L47:
        if (r111 == null) goto L49;
        r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L49:
        CharSequence r112 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L52;
    L55:
        Object[] r113 = true;
    L56:
        if (r113 == false) goto L58;
        r10.bindString(r12, "");
        return false;
    L58:
        r10.bindString(r12, r5);
        goto L99
    L52:
        if (r112.length() == 0) goto L55;
        r113 = false;
        goto L56
    L36:
        if (r15.getBooleanCellValue() == false) goto L38;
        r111 = "1";
        goto L47
    L38:
        r111 = "0";
        goto L47
    L39:
        double r2 = r15.getNumericCellValue();
        if (Math.floor(r2) != r2) goto L42;
        Object[] r114 = true;
    L43:
        if (r114 == false) goto L45;
        r111 = String.valueOf((long) r2);
        goto L47
    L45:
        r111 = String.valueOf(r2);
        goto L47
    L42:
        r114 = false;
        goto L43
    L46:
        r111 = r15.getStringCellValue();
        goto L47
    }

    private final c b(File r18, SupportSQLiteDatabase r19, Set<String> r20, Function1<? super String, String> r21) {
        SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r19, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r20, Set.class, "com.obric.memorydata.plugin");
        Function1<? super String, String> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipFile(r18), Closeable.class, "com.obric.memorydata.plugin");
        ZipFile r8 = (ZipFile) ZeusTransformUtils.preCheckCast(r7, ZipFile.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        Enumeration<? extends ZipEntry> r0 = r8.entries();     // Catch: Throwable -> L107
        Intrinsics.checkNotNullExpressionValue(r0, "entries(...)");     // Catch: Throwable -> L107
        ArrayList r1 = Collections.list(r0);     // Catch: Throwable -> L107
        Intrinsics.checkNotNullExpressionValue(r1, "list(...)");     // Catch: Throwable -> L107
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L107
    L5:
        String r12 = ".xlsx";
        boolean r13 = true;
        if (r11.hasNext() == false) goto L15;
        Object r14 = r11.next();     // Catch: Throwable -> L107
        ZipEntry r15 = (ZipEntry) ZeusTransformUtils.preCheckCast(r14, ZipEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        if (r15.isDirectory() == true) goto L12;
        String r16 = r15.getName();     // Catch: Throwable -> L107
        Intrinsics.checkNotNullExpressionValue(r16, "getName(...)");     // Catch: Throwable -> L107
        if (StringsKt.endsWith(r16, ".xlsx", true) == false) goto L12;
    L13:
        if (r13 == false) goto L5;
        r10.add(r14);     // Catch: Throwable -> L107
    L12:
        r13 = false;
        goto L13
    L15:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        Iterator r23 = r17.iterator();     // Catch: Throwable -> L107
    L17:
        if (r23.hasNext() == false) goto L28;
        Object r110 = r23.next();     // Catch: Throwable -> L107
        ZipEntry r111 = (ZipEntry) ZeusTransformUtils.preCheckCast(r110, ZipEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        if (r3 == null) goto L24;
        RoomToExcelExporter r112 = f9813a;     // Catch: Throwable -> L107
        String r113 = r111.getName();     // Catch: Throwable -> L107
        Intrinsics.checkNotNullExpressionValue(r113, "getName(...)");     // Catch: Throwable -> L107
        if (r3.contains(r112.c(r113).a()) == true) goto L24;
        boolean r114 = false;
    L25:
        if (r114 == false) goto L17;
        r22.add(r110);     // Catch: Throwable -> L107
    L24:
        r114 = true;
        goto L25
    L28:
        Iterator r115 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$RoomToExcelExporter$zryzjsdqnie1SmUUSgNzo3lQKuE.INSTANCE, $$Lambda$RoomToExcelExporter$by_8FbRVZUbSIfIKidulitWPVIg.INSTANCE})).iterator();     // Catch: Throwable -> L107
    L30:
        if (r115.hasNext() == false) goto L104;
        ZipEntry r116 = (ZipEntry) ZeusTransformUtils.preCheckCast(r115.next(), ZipEntry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L107
        File r117 = File.createTempFile("import_", r12);     // Catch: Throwable -> L107
        Closeable r24 = (Closeable) ZeusTransformUtils.preCheckCast(r8.getInputStream(r116), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L96 Exception -> L98
        InputStream r25 = (InputStream) ZeusTransformUtils.preCheckCast(r24, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L86
        Closeable r118 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r117), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L86
        FileOutputStream r119 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r118, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L75
        ZipFile r26 = r8;
        Iterator r120 = r115;
        String r121 = r12;
        ByteStreamsKt.copyTo$default(r25, (OutputStream) ZeusTransformUtils.preCheckCast(r119, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L71
        CloseableKt.closeFinally(r118, null);     // Catch: Throwable -> L84
        CloseableKt.closeFinally(r24, null);     // Catch: Exception -> L94 Throwable -> L96
        Closeable r27 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r117), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L94 Throwable -> L96
        c r28 = f9813a.a((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r27, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"), r2, r3, r4);     // Catch: Exception -> L55 Throwable -> L64
        Iterator<Map.Entry<String, Integer>> r29 = r28.a().entrySet().iterator();     // Catch: Exception -> L55 Throwable -> L64
    L44:
        if (r29.hasNext() == false) goto L50;
        Map.Entry r122 = (Map.Entry) ZeusTransformUtils.preCheckCast(r29.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55 Throwable -> L64
        String r123 = (String) ZeusTransformUtils.preCheckCast(r122.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55 Throwable -> L64
        int r124 = ((Number) ZeusTransformUtils.preCheckCast(r122.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L55 Throwable -> L64
        Integer r125 = (Integer) ZeusTransformUtils.preCheckCast(r5.get(r123), Integer.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55 Throwable -> L64
        if (r125 == null) goto L48;
        int r126 = r125.intValue();     // Catch: Exception -> L55 Throwable -> L64
    L49:
        r5.put(r123, Integer.valueOf(r126 + r124));     // Catch: Exception -> L55 Throwable -> L64
        goto L44
    L48:
        r126 = 0;
        goto L49
    L50:
        Iterator<Map.Entry<String, String>> r30 = r28.b().entrySet().iterator();     // Catch: Exception -> L55 Throwable -> L64
    L52:
        if (r30.hasNext() == false) goto L60;
        Map.Entry r31 = (Map.Entry) ZeusTransformUtils.preCheckCast(r30.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55 Throwable -> L64
        r6.put(r116.getName() + ':' + ((String) ZeusTransformUtils.preCheckCast(r31.getKey(), String.class, "com.obric.memorydata.plugin")), (String) ZeusTransformUtils.preCheckCast(r31.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L55 Throwable -> L64
    L60:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r27, null);     // Catch: Exception -> L94 Throwable -> L96
    L101:
        r117.delete();     // Catch: Throwable -> L107
        r115 = r120;
        r12 = r121;
        r8 = r26;
    L55:
        e = move-exception;
        String r33 = r116.getName();     // Catch: Throwable -> L64
        String r127 = e.getMessage();     // Catch: Throwable -> L64
        if (r127 != null) goto L59;
        r127 = e.toString();     // Catch: Throwable -> L64
    L59:
        r6.put(r33, r127);     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        CloseableKt.closeFinally(r27, th);     // Catch: Exception -> L94 Throwable -> L96
        throw th;     // Catch: Exception -> L94 Throwable -> L96
    L94:
        e = e;
    L100:
        r6.put(r116.getName(), "Extract failed: " + e.getMessage());     // Catch: Throwable -> L96
    L84:
        th = th;
    L88:
        Throwable r34 = th;
        throw r34;     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        CloseableKt.closeFinally(r24, r34);     // Catch: Exception -> L94 Throwable -> L96
        throw th;     // Catch: Exception -> L94 Throwable -> L96
    L71:
        th = th;
    L78:
        Throwable r35 = th;
        throw r35;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        CloseableKt.closeFinally(r118, r35);     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L73:
        th = th;
    L75:
        th = th;
    L86:
        th = th;
    L98:
        e = e;
        r26 = r8;
        r120 = r115;
        r121 = r12;
    L96:
        th = move-exception;
        r117.delete();     // Catch: Throwable -> L107
        throw th;     // Catch: Throwable -> L107
    L104:
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r7, null);
        return new c(r5, r6);
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private static final Comparable b(ZipEntry r2) {
        RoomToExcelExporter r0 = f9813a;
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        return (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r0.c(r3).b()), Comparable.class, "com.obric.memorydata.plugin");
    }

    private final String b(String r9) {
        char[] r0 = {'\\', '/', '?', '*', '[', ']'};
        String r2 = r9;
        int r10 = 0;
    L3:
        if (r10 >= 6) goto L6;
        r2 = StringsKt.replace$default(r2, String.valueOf(r0[r10]), "_", false, 4, null);
        r10 = r10 + 1;
        goto L3
    L6:
        if (r2.length() <= 31) goto L10;
        String r3 = r2.substring(0, 31);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        return r3;
    L10:
        return r2;
    }

    private final Map<String, a> b(SupportSQLiteDatabase r9, String r10) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r9, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        LinkedHashMap r11 = new LinkedHashMap();
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r8.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("PRAGMA table_info(`" + r10 + "`)"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r13 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        int r1 = r13.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L16
        int r2 = r13.getColumnIndex("type");     // Catch: Throwable -> L16
    L5:
        if (r13.moveToNext() == false) goto L13;
        String r3 = r13.getString(r1);     // Catch: Throwable -> L16
        if (r3 == null) goto L5;
        String r4 = r13.getString(r2);     // Catch: Throwable -> L16
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        String r5 = r4.toUpperCase(Locale.ROOT);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r5, "toUpperCase(...)");     // Catch: Throwable -> L16
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r7 = r3.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");     // Catch: Throwable -> L16
        r6.put(r7, new a(r3, r5));     // Catch: Throwable -> L16
        goto L5
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r12, null);
        return (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private final d c(String r5) {
        String r4 = StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(r5, '/', null, 2, null), '\\', null, 2, null), (CharSequence) ZeusTransformUtils.preCheckCast(".xlsx", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(".XLSX", CharSequence.class, "com.obric.memorydata.plugin"));
        MatchResult r6 = new Regex("^(.*)_([0-9]+)$").matchEntire((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        int r0 = 1;
        if (r6 == null) goto L9;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin");
        Integer r8 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r6.getGroupValues().get(2), String.class, "com.obric.memorydata.plugin"));
        if (r8 == null) goto L10;
        r0 = r8.intValue();
    L10:
        return new d(r7, r0);
    L9:
        return new d(r4, 1);
    }

    private static final String d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final CharSequence e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast('`' + r2 + '`', CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$IE4CmGPNKRw6VXwLoYdvj_rS30c(String r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$XpShYZWlRHPLTq7abi-nkJ-5w_g, reason: not valid java name */
    public static /* synthetic */ String m648lambda$XpShYZWlRHPLTq7abinkJ5w_g(String r0) {
        return d(r0);
    }

    public static /* synthetic */ Comparable lambda$by_8FbRVZUbSIfIKidulitWPVIg(ZipEntry r0) {
        return b(r0);
    }

    public static /* synthetic */ Comparable lambda$zryzjsdqnie1SmUUSgNzo3lQKuE(ZipEntry r0) {
        return a(r0);
    }

    public final b a(RoomDatabase r25, String r26, DatabaseScope r27, Map<String, String> r28, Function1<? super e, Unit> r29, Function0<Boolean> r30) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r30, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r25, "roomDb");
        Intrinsics.checkNotNullParameter(r27, "databaseScope");
        Intrinsics.checkNotNullParameter(r1, "groupByColumns");
        Intrinsics.checkNotNullParameter(r3, "onTableCompleted");
        Intrinsics.checkNotNullParameter(r4, "shouldContinue");
        SupportSQLiteDatabase r14 = r25.getOpenHelper().getReadableDatabase();
        List<String> r5 = a(r14);
        if (r5.isEmpty() == true) goto L86;
        File r13 = a(r26);
        List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r13), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L81
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast((FileOutputStream) ZeusTransformUtils.preCheckCast(r11, FileOutputStream.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L71
        ZipOutputStream r16 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r10, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        Iterator<String> r17 = r5.iterator();     // Catch: Throwable -> L61
    L8:
        if (r17.hasNext() == false) goto L50;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
        String r24 = r9;
        Closeable r18 = r10;
        f r0 = f9813a.a(r14, r16, r9, (String) ZeusTransformUtils.preCheckCast(r1.get(r9), String.class, "com.obric.memorydata.plugin"), r4);     // Catch: Throwable -> L26 Exception -> L28 CancellationException -> L30
        Closeable r21 = r11;
        List r22 = r12;
        File r23 = r13;
        SupportSQLiteDatabase r19 = r14;
        e r6 = new e(r24, r0.a(), r0.b(), null, r27, 8, null);     // Catch: Exception -> L22 CancellationException -> L24 Throwable -> L46
        List r15 = r22;
        r15.add(r6);     // Catch: Exception -> L20 CancellationException -> L24 Throwable -> L46
        r3.invoke(r6);     // Catch: Exception -> L20 CancellationException -> L24 Throwable -> L46
    L19:
        r12 = r15;
        r10 = r18;
        r14 = r19;
        r11 = r21;
        r13 = r23;
    L20:
        e = e;
    L35:
        String r110 = r24;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomToExcelExporter", "Failed to export table " + r110 + ": " + e.getMessage(), null, 4, null);     // Catch: Throwable -> L46
        long r8 = 0;
        Map r111 = null;
        String r7 = e.getMessage();     // Catch: Throwable -> L46
        if (r7 != null) goto L38;
        String r112 = e.getClass().getSimpleName();     // Catch: Throwable -> L46
    L39:
        Map r210 = r1;
        List r2 = r15;
        e r20 = new e(r110, r8, r111, r112, r27, 4, null);     // Catch: Throwable -> L46
        r2.add(r20);     // Catch: Throwable -> L46
        r3.invoke(r20);     // Catch: Throwable -> L46
        r12 = r2;
        r10 = r18;
        r14 = r19;
        r11 = r21;
        r13 = r23;
        r1 = r210;
        goto L8
    L38:
        r112 = r7;
    L24:
        e = move-exception;
        throw e;     // Catch: Throwable -> L46
    L22:
        e = e;
        r15 = r22;
    L46:
        th = move-exception;
        Throwable r31 = th;
        Closeable r32 = r18;
        Closeable r33 = r21;
    L107:
        throw r31;     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        CloseableKt.closeFinally(r32, r31);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L69:
        th = th;
    L73:
        Throwable r34 = th;
        throw r34;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        CloseableKt.closeFinally(r33, r34);     // Catch: Exception -> L79
        throw th;     // Catch: Exception -> L79
    L30:
        e = e;
    L43:
        throw e;     // Catch: Throwable -> L46
    L28:
        e = e;
    L34:
        r21 = r11;
        r23 = r13;
        r19 = r14;
        r15 = r12;
    L26:
        th = move-exception;
        r23 = r13;
        r31 = th;
        r33 = r11;
        r32 = r18;
        goto L107
    L40:
        e = e;
    L32:
        e = e;
        r24 = r9;
        r18 = r10;
        goto L34
    L45:
        throw new CancellationException("data export account changed");     // Catch: Throwable -> L46
    L48:
        th = move-exception;
        r23 = r13;
        r31 = th;
        r32 = r10;
        r33 = r11;
        goto L107
    L50:
        Closeable r113 = r10;
        Closeable r211 = r11;
        List r35 = r12;
        r23 = r13;
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L59
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L57
        Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L57
        CloseableKt.closeFinally(r211, null);     // Catch: Exception -> L79
        String r38 = r23.getAbsolutePath();     // Catch: Exception -> L79
        Intrinsics.checkNotNullExpressionValue(r38, "getAbsolutePath(...)");     // Catch: Exception -> L79
        return new b(r38, r35);
    L57:
        th = th;
        r33 = r211;
    L59:
        th = th;
        r32 = r113;
        r33 = r211;
    L63:
        r31 = th;
    L61:
        th = th;
        r32 = r10;
        r33 = r11;
        r23 = r13;
    L71:
        th = th;
        r33 = r11;
        r23 = r13;
    L81:
        e = e;
        r23 = r13;
    L83:
        r23.delete();
        throw e;
    L79:
        e = e;
        goto L83
    L86:
        throw new IllegalStateException(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.data_transport_room_to_excel_no_export_tables, TypedValues.Custom.S_STRING, "data_transport_room_to_excel_no_export_tables")));
    }

    public final c a(File r5, SupportSQLiteDatabase r6, Set<String> r7, Function1<? super String, String> r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Function1<? super String, String> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r9, "db");
        Intrinsics.checkNotNullParameter(r11, "sheetNameToTable");
        String r0 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        if (StringsKt.endsWith(r0, ".zip", true) == true) goto L5;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        c r12 = f9813a.a((InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin"), r9, r10, r11);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);
        return r12;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L5:
        return b(r5, r9, r10, r11);
    }

    public final c a(InputStream r31, SupportSQLiteDatabase r32, Set<String> r33, Function1<? super String, String> r34) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r32, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r33, Set.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r34, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r31, "input");
        Intrinsics.checkNotNullParameter(r1, "db");
        Intrinsics.checkNotNullParameter(r4, "sheetNameToTable");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new XSSFWorkbook(r31), Closeable.class, "com.obric.memorydata.plugin");
        XSSFWorkbook r8 = (XSSFWorkbook) ZeusTransformUtils.preCheckCast(r7, XSSFWorkbook.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L123
        r1.beginTransaction();     // Catch: Throwable -> L123
        int r9 = r8.getNumberOfSheets();     // Catch: Throwable -> L117
        int r11 = 0;
    L5:
        if (r11 >= r9) goto L109;
        XSSFSheet r12 = r8.getSheetAt(r11);     // Catch: Throwable -> L117
        if (r12 != null) goto L10;
    L8:
        Set r35 = r3;
        Function1 r36 = r4;
        XSSFWorkbook r16 = r8;
    L9:
        int r18 = r9;
    L148:
        r11 = r11 + 1;     // Catch: Throwable -> L115
        r3 = r35;
        r4 = r36;
        r8 = r16;
        r9 = r18;
        r7 = r7;
    L115:
        th = th;
        Closeable r2 = r7;
    L134:
        r1.endTransaction();     // Catch: Throwable -> L121
        throw th;     // Catch: Throwable -> L121
    L121:
        th = th;
    L125:
        Throwable r10 = th;
        throw r10;     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        CloseableKt.closeFinally(r2, r10);
        throw th;
    L10:
        String r13 = r12.getSheetName();     // Catch: Throwable -> L117
        if (r13 == null) goto L13;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L117
    L14:
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == true) goto L8;
        if (r3 != null) goto L23;
    L25:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r4.invoke(r14), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L117
        Map<String, a> r19 = f9813a.b(r1, r17);     // Catch: Throwable -> L99
        if (r19.isEmpty() == true) goto L8;
        XSSFRow r0 = r12.getRow(r12.getFirstRowNum());     // Catch: Throwable -> L99
        if (r0 == null) goto L8;
        r35 = r3;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(r0.getFirstCellNum(), r0.getLastCellNum()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L97
        r36 = r4;
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L95
    L38:
        if (r22.hasNext() == false) goto L46;
        XSSFCell r110 = r0.getCell(((IntIterator) ZeusTransformUtils.preCheckCast(r22, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());     // Catch: Throwable -> L95
        if (r110 == null) goto L42;
        String r23 = f9813a.a((Cell) ZeusTransformUtils.preCheckCast(r110, Cell.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L95
    L43:
        if (r23 == null) goto L45;
        r21.add(r23);     // Catch: Throwable -> L95
    L45:
        r0 = r0;
        r22 = r22;
        goto L38
    L42:
        r23 = null;
        goto L43
    L46:
        List r24 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L95
        Set<String> r25 = r19.keySet();     // Catch: Throwable -> L95
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        r16 = r8;
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        Iterator r28 = r26.iterator();     // Catch: Throwable -> L93
    L50:
        if (r28.hasNext() == false) goto L55;
        Object r111 = r28.next();     // Catch: Throwable -> L93
        Iterator r112 = r28;
        if (r25.contains((String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin")) == false) goto L54;
        r27.add(r111);     // Catch: Throwable -> L93
    L54:
        r28 = r112;
        goto L50
    L55:
        List<String> r29 = (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        if (r29.isEmpty() == true) goto L9;
        SupportSQLiteStatement r30 = r1.compileStatement(f9813a.a(r17, r29));     // Catch: Throwable -> L93
        int r37 = r12.getFirstRowNum() + 1;     // Catch: Throwable -> L93
        int r113 = r12.getLastRowNum();     // Catch: Throwable -> L93
        if (r37 > r113) goto L84;
        r18 = r9;
        int r114 = 0;
    L136:
        XSSFRow r38 = r12.getRow(r37);     // Catch: Throwable -> L82
        if (r38 != null) goto L64;
        List r210 = r24;
        List<String> r211 = r29;
        r7 = r7;
        XSSFSheet r212 = r12;
    L80:
        if (r37 == r113) goto L85;
        r37 = r37 + 1;     // Catch: Throwable -> L91
        r29 = r211;
        r12 = r212;
        r7 = r7;
        r24 = r210;
    L91:
        th = th;
    L104:
        th.printStackTrace();     // Catch: Throwable -> L115
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomToExcelExporter", "import table " + r17 + " failed for " + th.getMessage(), null, 4, null);     // Catch: Throwable -> L115
        String r39 = th.getMessage();     // Catch: Throwable -> L115
        if (r39 != null) goto L107;
        r39 = th.toString();     // Catch: Throwable -> L115
    L107:
        r6.put(r14, r39);     // Catch: Throwable -> L115
    L85:
        Integer r40 = (Integer) ZeusTransformUtils.preCheckCast(r5.get(r17), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        if (r40 == null) goto L88;
        int r41 = r40.intValue();     // Catch: Throwable -> L91
    L89:
        r5.put(r17, Integer.valueOf(r41 + r114));     // Catch: Throwable -> L91
        goto L148
    L88:
        r41 = 0;
        goto L89
    L64:
        Iterator<String> r115 = r29.iterator();     // Catch: Throwable -> L82
        r211 = r29;
        int r42 = 1;
        boolean r213 = true;
    L66:
        if (r115.hasNext() == false) goto L77;
        XSSFSheet r214 = r12;
        Closeable r215 = r7;
        String r43 = (String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L91
        int r116 = r24.indexOf(r43);     // Catch: Throwable -> L91
        if (r116 < 0) goto L72;
        XSSFCell r117 = r38.getCell(r116);     // Catch: Throwable -> L91
    L73:
        a r44 = r19.get(r43);     // Catch: Throwable -> L91
        Intrinsics.checkNotNull(r44);     // Catch: Throwable -> L91
        List r216 = r24;
        XSSFRow r217 = r38;
        if (f9813a.a(r30, r42, (Cell) ZeusTransformUtils.preCheckCast(r117, Cell.class, "com.obric.memorydata.plugin"), ((a) ZeusTransformUtils.preCheckCast(r44, a.class, "com.obric.memorydata.plugin")).getType()) == false) goto L76;
        r213 = false;
    L76:
        r42 = r42 + 1;     // Catch: Throwable -> L91
        r12 = r214;
        r7 = r215;
        r24 = r216;
        r38 = r217;
        goto L66
    L72:
        r117 = null;
        goto L73
    L77:
        r210 = r24;
        r7 = r7;
        r212 = r12;
        if (r213 == true) goto L80;
        r30.executeInsert();     // Catch: Throwable -> L91
        r114 = r114 + 1;     // Catch: Throwable -> L91
    L82:
        th = th;
        r7 = r7;
        goto L104
    L84:
        r7 = r7;
        r18 = r9;
        r114 = 0;
    L93:
        th = th;
    L103:
        r18 = r9;
    L95:
        th = th;
    L102:
        r16 = r8;
    L97:
        th = th;
    L101:
        r36 = r4;
    L99:
        th = th;
        r35 = r3;
        goto L101
    L23:
        if (r3.contains(r14) == true) goto L25;
    L19:
        r15 = false;
        goto L20
    L13:
        r14 = null;
        goto L14
    L109:
        r7 = r7;
        r1.setTransactionSuccessful();     // Catch: Throwable -> L115
        r1.endTransaction();     // Catch: Throwable -> L113
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L113
        CloseableKt.closeFinally(r7, null);
        return new c(MapsKt.toMap(r5), MapsKt.toMap(r6));
    L113:
        th = th;
        r2 = r7;
    L117:
        th = th;
        r2 = r7;
    L123:
        th = th;
        r2 = r7;
        goto L125
    }

    public final void a(SupportSQLiteDatabase r4, List<String> r5, boolean r6) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "db");
        Intrinsics.checkNotNullParameter(r7, "tables");
        r3.beginTransaction();
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L12
    L5:
        if (r8.hasNext() == false) goto L9;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r3.execSQL("DELETE FROM `" + r9 + '`');     // Catch: Throwable -> L12
        if (r6 == false) goto L5;
        r3.execSQL("DELETE FROM sqlite_sequence WHERE name='" + r9 + '\'');     // Catch: Throwable -> L12
        goto L5
    L9:
        r3.setTransactionSuccessful();     // Catch: Throwable -> L12
        r3.endTransaction();
        return;
    L12:
        th = move-exception;
        r3.endTransaction();
        throw th;
    }
}
