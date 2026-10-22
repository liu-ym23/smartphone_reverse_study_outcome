package com.obric.memorydata.union.build.export;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import android.util.JsonWriter;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.keva.KevaImpl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.af;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.g;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002_`B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ>\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002JF\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J6\u0010 \u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J&\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J6\u0010%\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J6\u0010(\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J6\u0010*\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J%\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0000¢\u0006\u0002\b1J%\u00102\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0000¢\u0006\u0002\b3J\u000e\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050/2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0002J6\u0010;\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002JV\u0010=\u001a\u0002H>\"\u0004\b\u0000\u0010>2\u0006\u0010?\u001a\u00020\u000528\u0010@\u001a4\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H>0AH\u0082\b¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020H2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0005H\u0002J \u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020K2\u0006\u0010\"\u001a\u00020#2\u0006\u0010L\u001a\u00020\u001bH\u0002J\u0018\u0010M\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2\u0006\u0010L\u001a\u00020\u001bH\u0002J.\u0010N\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0002J&\u0010P\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J.\u0010Q\u001a\u00020H2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\bH\u0002J\u0010\u0010S\u001a\u00020T2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010U\u001a\u00020\u0005H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0005H\u0002J\u0010\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0002J\u001a\u0010\\\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010]\u001a\u00020^H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPreviewPackageExporter;", "", "<init>", "()V", "TAG", "", "export", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "destFile", "exportDbTables", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dbConfig", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "zip", "Ljava/util/zip/ZipOutputStream;", "writtenEntries", "", "tableStats", "Lorg/json/JSONArray;", "exportTableJson", "", "tableConfig", "Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "sql", "entryName", "exportTableCsv", "collectConfiguredResources", "cursor", "Landroid/database/Cursor;", "out", "copyResource", "tableName", "raw", "copyAppOwnedFileResource", "rawPath", "copyRelativeScreenshotResource", "resolveAppOwnedRelativePath", "Lcom/obric/memorydata/union/build/export/MemoryBuildDataPreviewPackageExporter$OwnedRelativePath;", "file", "roots", "", "Lcom/obric/memorydata/union/build/export/MemoryBuildDataPreviewPackageExporter$PreviewResourceRoot;", "resolveAppOwnedRelativePath$memory_build_obricRelease", "resolveRelativeScreenshotResource", "resolveRelativeScreenshotResource$memory_build_obricRelease", "previewFileForPackage", "packageFile", "buildRelativeScreenshotCandidates", "rel", "appOwnedRoots", "buildAppOwnedResourceEntryName", "rootName", "copyContentResource", "rawUri", "withDb", ExifInterface.GPS_DIRECTION_TRUE, "dbName", "block", "Lkotlin/Function2;", "Landroidx/room/RoomDatabase;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "roomDb", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "tableExists", "", "writeJsonValue", "writer", "Landroid/util/JsonWriter;", "index", "cursorValueAsString", "putTextEntry", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "putEntry", "copyFileEntry", "src", "buildManifest", "Lorg/json/JSONObject;", "buildReadme", "csvEscape", EventBody.KEY_VALUE, "isSafeRelativePath", "path", "safeEntryName", "sha256", "queryDisplayName", "uri", "Landroid/net/Uri;", "PreviewResourceRoot", "OwnedRelativePath", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13082a = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPreviewPackageExporter$OwnedRelativePath;", "", "rootName", "", "relativePath", "file", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getRootName", "()Ljava/lang/String;", "getRelativePath", "getFile", "()Ljava/io/File;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13084b;
        private final File c;

        public a(String r2, String r3, File r4) {
            Intrinsics.checkNotNullParameter(r2, "rootName");
            Intrinsics.checkNotNullParameter(r3, "relativePath");
            Intrinsics.checkNotNullParameter(r4, "file");
            this.f13083a = r2;
            this.f13084b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f13083a;
        }

        public final String b() {
            return this.f13084b;
        }

        public final File c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13083a, r6.f13083a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13084b, r6.f13084b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f13083a.hashCode() * 31) + this.f13084b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "OwnedRelativePath(rootName=" + this.f13083a + ", relativePath=" + this.f13084b + ", file=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPreviewPackageExporter$PreviewResourceRoot;", "", "rootName", "", "root", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "getRootName", "()Ljava/lang/String;", "getRoot", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f13086b;

        public b(String r2, File r3) {
            Intrinsics.checkNotNullParameter(r2, "rootName");
            Intrinsics.checkNotNullParameter(r3, "root");
            this.f13085a = r2;
            this.f13086b = r3;
        }

        public final String a() {
            return this.f13085a;
        }

        public final File b() {
            return this.f13086b;
        }

        public final File c() {
            return this.f13086b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13085a, r6.f13085a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13086b, r6.f13086b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13085a.hashCode() * 31) + this.f13086b.hashCode();
        }

        public String toString() {
            return "PreviewResourceRoot(rootName=" + this.f13085a + ", root=" + this.f13086b + ')';
        }
    }

    static {
        f13082a = new e();
    }

    private e() {
    }

    private final int a(Context r20, SupportSQLiteDatabase r21, ai r22, String r23, ZipOutputStream r24, Set<String> r25, String r26) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r21, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r25, Set.class, "com.obric.memorydata.plugin");
        LinkedHashSet r2 = new LinkedHashSet();
        a(r24, r9, r26);
        JsonWriter r3 = new JsonWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(r24, OutputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8), Writer.class, "com.obric.memorydata.plugin"));
        r3.beginArray();
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r1.query(r23), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        int r10 = 0;
    L5:
        if (r5.moveToNext() == false) goto L10;
        r3.beginObject();     // Catch: Throwable -> L16
        int r6 = r5.getColumnCount();     // Catch: Throwable -> L16
        int r11 = 0;
    L7:
        if (r11 >= r6) goto L9;
        r3.name(r5.getColumnName(r11));     // Catch: Throwable -> L16
        f13082a.a(r3, r5, r11);     // Catch: Throwable -> L16
        r11 = r11 + 1;     // Catch: Throwable -> L16
        goto L7
    L9:
        r3.endObject();     // Catch: Throwable -> L16
        f13082a.a(r22, r5, (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        r10 = r10 + 1;     // Catch: Throwable -> L16
        goto L5
    L10:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r4, null);
        r3.endArray();
        r3.flush();
        r24.closeEntry();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview table json done, table=" + r22.a() + ", rows=" + r10 + ", resources=" + r2.size() + ", resourceColumns=" + r22.c().keySet(), false, 4, null);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        f13082a.a(r8, r22.a(), (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"), r24, r9);
        goto L13
    L15:
        return r10;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    private final int a(SupportSQLiteDatabase r20, String r21, ZipOutputStream r22, Set<String> r23, String r24) {
        SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r20, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        a(r22, (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.memorydata.plugin"), r24);
        OutputStreamWriter r4 = new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(r22, OutputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8);
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2.query(r21), Closeable.class, "com.obric.memorydata.plugin");
        final Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.getColumnCount()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L14
    L5:
        if (r7.hasNext() == false) goto L7;
        r8.add(r5.getColumnName(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt()));     // Catch: Throwable -> L14
        goto L5
    L7:
        r4.write(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$A7hToZS30u_jDJf52wYjztUKw.INSTANCE, 30, null));     // Catch: Throwable -> L14
        r4.write(10);     // Catch: Throwable -> L14
        int r9 = 0;
    L9:
        if (r5.moveToNext() == false) goto L11;
        r4.write(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.getColumnCount()), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, new $$Lambda$e$9mogAcE7VeeTWJ75QbEQJTabz6I(r5), 30, null));     // Catch: Throwable -> L14
        r4.write(10);     // Catch: Throwable -> L14
        r9 = r9 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r3, null);
        r4.flush();
        r22.closeEntry();
        return r9;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a() + ':' + r2.b().getAbsolutePath(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String a() {
        return "Memory build data preview package.\n\nThis zip is for debug preview only and cannot be imported by the app.\nUse the sibling .mempkg file for import.\n\nDirectory:\n- tables/: JSON and CSV data exported with the same table filters as the .mempkg package.\n- screenshots/: screenshot files copied from RawObservation.payload.screenshot_path when available.\n- resources/app_files/: app-owned files copied from configured resource columns.\n- resources/content/: content:// resources copied from configured resource columns when available.\n- manifest.json: table row counts and file paths.";
    }

    private final String a(Context r10, Uri r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        e r9 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Cursor r13 = ZeusProviderTransform.query(r12.getContentResolver(), r11, new String[]{"_display_name"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r13 == null) goto L18;
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(r13, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r14, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r15.moveToFirst() == false) goto L10;
        String r16 = r15.getString(0);     // Catch: Throwable -> L13
    L11:
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L21
    L19:
        Object r17 = Result.m1421constructorimpl(r16);     // Catch: Throwable -> L21
    L24:
        if (Result.m1427isFailureimpl(r17) == true) goto L28;
        r0 = r17;
    L28:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L10:
        r16 = null;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L18:
        r16 = null;
    L21:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    private final String a(Cursor r3, int r4) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r5 = r2.getType(r4);
        if (r5 != 0) goto L5;
        return "";
    L5:
        if (r5 == 4) goto L10;
        String r6 = r2.getString(r4);
        if (r6 != null) goto L13;
        return "";
    L13:
        return r6;
    L10:
        String r0 = Base64.encodeToString(r2.getBlob(r4), 2);
        Intrinsics.checkNotNullExpressionValue(r0, "encodeToString(...)");
        return r0;
    }

    private final String a(String r11, String r12) {
        String r3 = StringsKt.substringAfterLast$default(r12, '/', null, 2, null);
        boolean r5 = false;
        if (StringsKt.startsWith$default(r12, "Screenshots/", false, 2, null) == false) goto L5;
    L8:
        r5 = true;
    L9:
        if (r5 == false) goto L13;
        StringBuilder r10 = new StringBuilder().append("screenshots/").append(d(r3));
    L12:
        return r10.toString();
    L13:
        r10 = new StringBuilder().append("resources/app_files/").append(r11).append('/').append(r12);
        goto L12
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("/Screenshots/", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
        if (StringsKt.startsWith(r3, "screenshot_", true) == false) goto L9;
        goto L8
    }

    private final List<b> a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        b[] r8 = new b[5];
        File r2 = r6.getDataDir();
        Intrinsics.checkNotNullExpressionValue(r2, "getDataDir(...)");
        r8[0] = new b("data", r2);
        File r3 = r6.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(r3, "getFilesDir(...)");
        r8[1] = new b(KevaImpl.PrivateConstants.FILES_DIR_NAME, r3);
        File r4 = r6.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(r4, "getCacheDir(...)");
        r8[2] = new b("cache", r4);
        b r1 = null;
        File r5 = r6.getExternalFilesDir(null);
        if (r5 == null) goto L5;
        b r9 = new b("external_files", r5);
    L6:
        r8[3] = r9;
        File r10 = r6.getExternalCacheDir();
        if (r10 == null) goto L9;
        r1 = new b("external_cache", r10);
    L9:
        r8[4] = r1;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r8), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r12 = new HashSet();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L11:
        if (r14.hasNext() == false) goto L24;
        Object r15 = r14.next();
        File r16 = ((b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.memorydata.plugin")).c();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        Object r18 = Result.m1421constructorimpl(r16.getCanonicalPath());     // Catch: Throwable -> L15
    L17:
        String r19 = r16.getAbsolutePath();
        if (Result.m1427isFailureimpl(r18) == false) goto L21;
        r18 = r19;
    L21:
        if (r12.add((String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin")) == false) goto L11;
        r13.add(r15);
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L5:
        r9 = null;
        goto L6
    }

    private final List<String> a(String r7) {
        String r6 = StringsKt.substringAfterLast$default(r7, '/', null, 2, null);
        List r2 = CollectionsKt.createListBuilder();
        r2.add(r7);
        if (StringsKt.startsWith$default(r7, "Screenshots/", false, 2, null) == true) goto L6;
        r2.add("Screenshots/" + r6);
    L6:
        if (StringsKt.startsWith$default(r7, "Pictures/Screenshots/", false, 2, null) == true) goto L9;
        r2.add("Pictures/Screenshots/" + r6);
    L9:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r2), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final JSONObject a(JSONArray r4) {
        JSONObject r3 = new JSONObject().put("format", "MemoryBuildDataPreviewPackage").put("generatedAt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date())).put("tables", r4);
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v3 */
    private final void a(Context r24, SupportSQLiteDatabase r25, g r26, ZipOutputStream r27, Set<String> r28, JSONArray r29) {
        String r2 = "com.obric.memorydata.plugin";
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r11 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r28, Set.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r26.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L3:
        int r13 = 1;
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((ai) ZeusTransformUtils.preCheckCast(r6, ai.class, "com.obric.memorydata.plugin")).a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L3;
        r4.add(r6);
        goto L3
    L8:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r8 = new HashSet();
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L10:
        if (r10.hasNext() == false) goto L14;
        Object r14 = r10.next();
        if (r8.add(((ai) ZeusTransformUtils.preCheckCast(r14, ai.class, "com.obric.memorydata.plugin")).a()) == false) goto L10;
        r9.add(r14);
        goto L10
    L14:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r15.hasNext() == false) goto L35;
        ai r16 = (ai) ZeusTransformUtils.preCheckCast(r15.next(), ai.class, r2);
        String r17 = r16.a();
        JSONObject r18 = new JSONObject().put("db", r26.a()).put("table", r17);
        e r19 = f13082a;
        if (r19.a(r11, r17) == true) goto L20;
        r18.put("rowCount", 0).put("skipped", "table not found");
        r29.put(r18);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r2), "MemoryBuildPreview", "preview skip table not found, db=" + r26.a() + ", table=" + r17, null, 4, null);
        String r20 = r2;
    L34:
        r15 = r15;
        r2 = r20;
        r1 = r1;
        r13 = 1;
        goto L16
    L20:
        String r21 = r16.b();
        if (r21 == null) goto L32;
        String r22 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, r2)).toString();
        if (r22 == null) goto L32;
        char[] r23 = new char[r13];
        r23[0] = ';';
        String r30 = StringsKt.trimEnd(r22, r23);
        if (r30 == null) goto L32;
        if (StringsKt.startsWith(r30, "select", r13) == true) goto L30;
        r30 = null;
    L30:
        if (r30 == null) goto L32;
    L33:
        String r31 = r30;
        String r32 = r19.d(r17);
        int r33 = r19.a(r1, r11, r16, r31, r27, r12, "tables/" + r32 + ".json");
        r18.put("rowCount", Math.max(r33, r19.a(r11, r31, r27, r12, "tables/" + r32 + ".csv"))).put("json", "tables/" + r32 + ".json").put("csv", "tables/" + r32 + ".csv");
        r29.put(r18);
        r20 = r2;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r20), "MemoryBuildPreview", "preview export table done, db=" + r26.a() + ", table=" + r17 + ", rows=" + r33 + ", sql=" + r31, false, 4, null);
    L32:
        r30 = "SELECT * FROM `" + r17 + '`';
        goto L33
    }

    private final void a(Context r9, String r10, String r11, ZipOutputStream r12, Set<String> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview resource skip blank, table=" + r10, null, 4, null);
        return;
    L7:
        if (StringsKt.startsWith$default(r11, "/", false, 2, null) == false) goto L11;
        String r5 = r11;
    L9:
        b(r3, r10, r5, r12, r7);
        return;
    L11:
        if (StringsKt.startsWith$default(r11, "file://", false, 2, null) == false) goto L29;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L14
        e r15 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r16 = Result.m1421constructorimpl(Uri.parse(r11).getPath());     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r16) == false) goto L19;
        r16 = null;
    L19:
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L22;
    L24:
        r5 = null;
    L25:
        if (r5 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview resource skip invalid file uri, table=" + r10 + ", raw=" + r11, null, 4, null);
        return;
    L22:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L24;
        r5 = r17;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L29:
        if (StringsKt.startsWith$default(r11, "content://", false, 2, null) == false) goto L31;
        d(r3, r10, r11, r12, r7);
        return;
    L31:
        c(r3, r10, r11, r12, r7);
    }

    private final void a(JsonWriter r3, Cursor r4, int r5) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
        int r6 = r2.getType(r5);
        if (r6 != 0) goto L5;
        r3.nullValue();
        return;
    L5:
        if (r6 != 1) goto L7;
        r3.value(r2.getLong(r5));
        return;
    L7:
        if (r6 != 2) goto L9;
        r3.value(r2.getDouble(r5));
        return;
    L9:
        if (r6 == 4) goto L12;
        String r7 = r2.getString(r5);
    L11:
        r3.value(r7);
        return;
    L12:
        r7 = Base64.encodeToString(r2.getBlob(r5), 2);
        goto L11
    }

    private final void a(ai r19, Cursor r20, Set<String> r21) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r20, Cursor.class, "com.obric.memorydata.plugin");
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, af>> r3 = r19.c().entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        af r6 = (af) ZeusTransformUtils.preCheckCast(r4.getValue(), af.class, "com.obric.memorydata.plugin");
        int r7 = r0.getColumnIndex(r5);
        if (r7 < 0) goto L7;
        if (r0.isNull(r7) == true) goto L10;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.extractPath(r0.getString(r7)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r8.hasNext() == false) goto L4;
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L18;
        r9 = null;
    L18:
        if (r9 == null) goto L13;
        RunLog.INSTANCE.debug("MemoryBuildPreview", "preview resource collected, table=" + r19.a() + ", column=" + r5 + ", raw=" + r9);
        r2.add(r9);
        goto L13
    L10:
        RunLog.INSTANCE.debug("MemoryBuildPreview", "preview resource column null, table=" + r19.a() + ", column=" + r5);
        goto L4
    L7:
        IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("preview resource column missing, table=").append(r19.a()).append(", column=").append(r5).append(", columns=");
        String[] r12 = r0.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(r12, "getColumnNames(...)");
        IRunLog.a.a(r10, "MemoryBuildPreview", r11.append(ArraysKt.joinToString$default((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null)).toString(), null, 4, null);
        goto L4
    }

    private final void a(ZipOutputStream r2, Set<String> r3, String r4) {
        if (((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin")).add(r4) == true) goto L5;
        return;
    L5:
        r2.putNextEntry(new ZipEntry(r4));
    }

    private final void a(ZipOutputStream r3, Set<String> r4, String r5, String r6) {
        a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), r5);
        OutputStreamWriter r2 = new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(r3, OutputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8);
        r2.write(r6);
        r2.flush();
        r3.closeEntry();
    }

    private final boolean a(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        e r3 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? LIMIT 1", new String[]{r5}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        boolean r8 = ((Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L13
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r9) == false) goto L19;
        r9 = false;
    L19:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final boolean a(ZipOutputStream r3, Set<String> r4, String r5, File r6) {
        if (((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin")).add(r5) == true) goto L5;
        return false;
    L5:
        r3.putNextEntry(new ZipEntry(r5));
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.memorydata.plugin");
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r2, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r3, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r2, null);
        r3.closeEntry();
        return true;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private static final CharSequence b(Cursor r2, int r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        e r0 = f13082a;
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.b(r0.a(r4, r3)), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final String b(String r12) {
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        int r1 = 0;
    L4:
        if (r1 >= r11.length()) goto L19;
        char r2 = r11.charAt(r1);
        if (r2 != '\"') goto L8;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L17;
        r1 = r1 + 1;
        goto L4
    L17:
        r0 = true;
        goto L19
    L8:
        if (r2 == ',') goto L15;
        if (r2 == '\n') goto L15;
        if (r2 == '\r') goto L15;
        r3 = false;
    L19:
        if (r0 == true) goto L22;
        return r12;
    L22:
        return Typography.quote + StringsKt.replace$default(r12, "\"", "\"\"", false, 4, null) + Typography.quote;
    }

    private final void b(Context r14, String r15, String r16, ZipOutputStream r17, Set<String> r18) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.memorydata.plugin");
        File r0 = new File(r16);
        if (r0.isFile() == true) goto L31;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r2 = null;
        int r3 = 4;
        Object r4 = null;
        IRunLog r13 = r1;
        String r19 = "MemoryBuildPreview";
        String r110 = "preview resource skip missing file, table=" + r15 + ", path=" + r16 + ", exists=" + r0.exists() + ", isFile=" + r0.isFile();
    L5:
        Throwable r111 = r2;
        int r112 = r3;
    L6:
        IRunLog.a.a(r13, r19, r110, r111, r112, r4);
        return;
    L31:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        e r9 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r5 = Result.m1421constructorimpl(r0.getCanonicalFile());     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r5) == false) goto L15;
        r5 = null;
    L15:
        File r10 = (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L19;
        e r11 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");
        IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r20 = new StringBuilder().append("preview resource skip canonical failed, table=").append(r15).append(", path=").append(r16);
    L18:
        r2 = null;
        r3 = 4;
        r4 = null;
        r13 = r12;
        r19 = "MemoryBuildPreview";
        r110 = r20.toString();
        goto L5
    L19:
        a r21 = a(r10, a(r6));
        if (r21 != null) goto L22;
        e r22 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");
        IRunLog r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = null;
        r13 = r23;
        r19 = "MemoryBuildPreview";
        r110 = "preview resource skip not app-owned, table=" + r15 + ", path=" + r10.getAbsolutePath() + ", roots=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r22.a(r6), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$e$Bmg3PObVAVMF7y2yTIefHiSyuUc.INSTANCE, 31, null);
        r111 = null;
        r112 = 4;
        goto L6
    L22:
        String r24 = r21.b();
        if (c(r24) == true) goto L25;
        r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r20 = new StringBuilder().append("preview resource skip unsafe relative path, table=").append(r15).append(", rel=").append(r24);
        goto L18
    L25:
        String r25 = a(r21.a(), r24);
        if (a(r17, r7, r25, r10) == false) goto L28;
        IRunLog r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r27 = new StringBuilder();
        String r28 = "preview resource copied, table=";
    L29:
        IRunLog.a.a(r26, "MemoryBuildPreview", r27.append(r28).append(r15).append(", entry=").append(r25).append(", path=").append(r10.getAbsolutePath()).toString(), false, 4, null);
        return;
    L28:
        r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r27 = new StringBuilder();
        r28 = "preview resource skip duplicate entry, table=";
    L10:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void c(Context r7, String r8, String r9, ZipOutputStream r10, Set<String> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        a r14 = a(r9, a(r12));
        if (r14 != null) goto L6;
        e r6 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview resource skip relative not found, table=" + r8 + ", raw=" + r9, null, 4, null);
        return;
    L6:
        String r15 = a(r14.a(), r14.b());
        if (a(r10, r13, r15, r14.c()) == false) goto L9;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder();
        String r1 = "preview relative resource copied, table=";
    L10:
        IRunLog.a.a(r0, "MemoryBuildPreview", r16.append(r1).append(r8).append(", entry=").append(r15).append(", path=").append(r14.c().getAbsolutePath()).toString(), false, 4, null);
        return;
    L9:
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder();
        r1 = "preview relative resource skip duplicate entry, table=";
        goto L10
    }

    private final boolean c(String r7) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("..", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L12;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == true) goto L12;
        if (StringsKt.startsWith$default(r7, "/", false, 2, null) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private final String d(String r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(new Regex("[^A-Za-z0-9._-]").replace(r2, "_"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L6;
        r4 = "unnamed";
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    }

    private final void d(Context r21, String r22, String r23, ZipOutputStream r24, Set<String> r25) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r25, Set.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        e r1 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(Uri.parse(r23));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L10;
        r2 = null;
    L10:
        Uri r3 = (Uri) ZeusTransformUtils.preCheckCast(r2, Uri.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        e r4 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview content resource skip invalid uri, table=" + r22 + ", raw=" + r23, null, 4, null);
        return;
    L14:
        String r9 = a(r7, r3);
        if (r9 == null) goto L17;
        String r10 = f13082a.d(r9);
    L19:
        if (r10 != null) goto L21;
    L25:
        r10 = StringsKt.take(e(r23), 16);
    L26:
        String r11 = "resources/content/" + StringsKt.take(e(r23), 16) + '_' + r10;
        if (r8.add(r11) == true) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview content resource skip duplicate entry, table=" + r22 + ", entry=" + r11, false, 4, null);
        return;
    L30:
        r24.putNextEntry(new ZipEntry(r11));
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L47
        e r5 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        InputStream r6 = r7.getContentResolver().openInputStream(r3);     // Catch: Throwable -> L47
        if (r6 == null) goto L44;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        long r14 = ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r13, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r24, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L47
    L45:
        Object r15 = Result.m1421constructorimpl(Long.valueOf(r14));     // Catch: Throwable -> L47
    L49:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview content resource copy failed, table=" + r22 + ", uri=" + r23 + ", err=" + r16.getMessage(), null, 4, null);
        r15 = 0L;
    L53:
        long r17 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue();
        r24.closeEntry();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview content resource copied, table=" + r22 + ", entry=" + r11 + ", bytes=" + r17 + ", uri=" + r23, false, 4, null);
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L44:
        r14 = 0;
    L47:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L24;
        r10 = null;
    L24:
        if (r10 != null) goto L26;
    L17:
        r10 = null;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final String e(String r11) {
        MessageDigest r10 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r12 = r11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r12, "getBytes(...)");
        byte[] r1 = r10.digest(r12);
        Intrinsics.checkNotNullExpressionValue(r1, "digest(...)");
        return ArraysKt.joinToString$default(r1, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$e$Ebh8Yh8gRH4KVgJwiEbUYYUrY.INSTANCE, 30, null);
    }

    private static final CharSequence f(String r2) {
        e r0 = f13082a;
        Intrinsics.checkNotNull(r2);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0.b(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$-A7hToZS30u_-jDJf52wYjztUKw, reason: not valid java name */
    public static /* synthetic */ CharSequence m1231lambda$A7hToZS30u_jDJf52wYjztUKw(String r0) {
        return f(r0);
    }

    public static /* synthetic */ CharSequence lambda$9mogAcE7VeeTWJ75QbEQJTabz6I(Cursor r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$Bmg3PObVAVMF7y2yTIefHiSyuUc(b r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$Ebh8Yh8gRH4-KVgJwiEbU-YYUrY, reason: not valid java name */
    public static /* synthetic */ CharSequence m1232lambda$Ebh8Yh8gRH4KVgJwiEbUYYUrY(byte r0) {
        return a(r0);
    }

    public final z<File> a(Context r18, com.obric.memorydata.migration.sdk.b r19, File r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r19, "backupConfig");
        Intrinsics.checkNotNullParameter(r20, "destFile");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L44
        e r10 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview export start, dest=" + r20.getAbsolutePath(), false, 4, null);     // Catch: Throwable -> L44
        File r4 = r20.getParentFile();     // Catch: Throwable -> L44
        if (r4 == null) goto L7;
        r4.mkdirs();     // Catch: Throwable -> L44
    L7:
        if (r20.exists() == false) goto L9;
        r20.delete();     // Catch: Throwable -> L44
    L9:
        LinkedHashSet r11 = new LinkedHashSet();     // Catch: Throwable -> L44
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L44
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r20), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        ZipOutputStream r14 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r13, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        r10.a(r14, (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin"), "README.txt", r10.a());     // Catch: Throwable -> L37
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L37
    L12:
        if (r15.hasNext() == false) goto L34;
        g r6 = (g) ZeusTransformUtils.preCheckCast(r15.next(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r5 = r6.a();     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r5, MemoryDbEngine.ENCRYPT_DB_NAME) == false) goto L18;
        SupportSQLiteDatabase r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getReadableDatabase();     // Catch: Throwable -> L37
    L16:
        Pair r8 = TuplesKt.to(null, r7);     // Catch: Throwable -> L37
    L21:
        MemoryFrameDb r9 = (MemoryFrameDb) ZeusTransformUtils.preCheckCast(r8.component1(), MemoryFrameDb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        SupportSQLiteDatabase r16 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r8.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        RoomDatabase r17 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r9, RoomDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        MemoryFrameDb r110 = r9;
        r10.a(r0, r16, r6, r14, (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin"), r12);     // Catch: Throwable -> L27
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L27
        if (r110 == null) goto L12;
        r110.close();     // Catch: Throwable -> L37
    L27:
        th = th;
    L31:
        if (r110 == null) goto L33;
        r110.close();     // Catch: Throwable -> L37
    L33:
        throw th;     // Catch: Throwable -> L37
    L29:
        th = th;
        r110 = r9;
        goto L31
    L18:
        if (Intrinsics.areEqual(r5, MemoryDbEngine.USER_LOGIC_DB_NAME) == false) goto L20;
        r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper().getReadableDatabase();     // Catch: Throwable -> L37
        goto L16
    L20:
        MemoryFrameDb r22 = MemoryDbEngine.INSTANCE.buildDatabaseEngine(r5);     // Catch: Throwable -> L37
        r8 = TuplesKt.to(r22, r22.getOpenHelper().getReadableDatabase());     // Catch: Throwable -> L37
        goto L21
    L34:
        Set<String> r1 = (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r23 = r10.a(r12).toString(2);     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r23, "toString(...)");     // Catch: Throwable -> L37
        r10.a(r14, r1, "manifest.json", r23);     // Catch: Throwable -> L37
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L44
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildPreview", "preview export success, dest=" + r20.getAbsolutePath() + ", size=" + r20.length(), false, 4, null);     // Catch: Throwable -> L44
        Object r24 = Result.m1421constructorimpl(new z.b(r20));     // Catch: Throwable -> L44
    L46:
        Throwable r25 = Result.m1424exceptionOrNullimpl(r24);
        if (r25 == null) goto L54;
        RunLog.INSTANCE.error("MemoryBuildPreview", "preview export failed, dest=" + r20.getAbsolutePath(), r25);
        MigrationErrorCode r26 = MigrationErrorCode.OTHER;
        StringBuilder r27 = new StringBuilder().append("预览包导出失败: ");
        String r28 = r25.getMessage();
        if (r28 != null) goto L52;
        r28 = "";
    L52:
        r24 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r26, r27.append(r28).toString(), r25)), z.class, "com.obric.memorydata.plugin");
    L54:
        return (z) ZeusTransformUtils.preCheckCast(r24, z.class, "com.obric.memorydata.plugin");
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L46
    }

    public final a a(File r13, List<b> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "file");
        Intrinsics.checkNotNullParameter(r15, "roots");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        e r12 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r16 = Result.m1421constructorimpl(r13.getCanonicalFile());     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r16) == false) goto L10;
        r16 = null;
    L10:
        File r17 = (File) ZeusTransformUtils.preCheckCast(r16, File.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L14;
        return null;
    L14:
        if (r17.isFile() == true) goto L16;
        return null;
    L16:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r18.hasNext() == false) goto L49;
        b r19 = (b) ZeusTransformUtils.preCheckCast(r18.next(), b.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        Object r3 = Result.m1421constructorimpl(r19.b().getCanonicalFile());     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r3) == false) goto L27;
        r3 = null;
    L27:
        File r4 = (File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L30;
    L29:
        a r5 = null;
    L37:
        if (r5 == null) goto L18;
        return r5;
    L30:
        String r6 = r4.getPath() + File.separator;
        String r7 = r17.getPath();
        Intrinsics.checkNotNullExpressionValue(r7, "getPath(...)");
        if (StringsKt.startsWith$default(r7, r6, false, 2, null) == false) goto L29;
        String r8 = FilesKt.relativeTo(r17, r4).getPath();
        Intrinsics.checkNotNullExpressionValue(r8, "getPath(...)");
        String r9 = StringsKt.replace$default(r8, '\\', '/', false, 4, null);
        if (f13082a.c(r9) == false) goto L29;
        r5 = new a(r19.a(), r9, r17);
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L49:
        return null;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final a a(String r9, List<b> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "rawPath");
        Intrinsics.checkNotNullParameter(r11, "roots");
        String r12 = StringsKt.trimStart(StringsKt.replace$default(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString(), '\\', '/', false, 4, null), new char[]{'/'});
        if (c(r12) == true) goto L5;
        return null;
    L5:
        List<String> r8 = a(r12);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r13.hasNext() == false) goto L25;
        b r14 = (b) ZeusTransformUtils.preCheckCast(r13.next(), b.class, "com.obric.memorydata.plugin");
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L14;
        a r3 = f13082a.a(new File(r14.b(), (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")), CollectionsKt.listOf(r14));
        if (r3 == null) goto L10;
    L15:
        if (r3 == null) goto L7;
        return r3;
    L14:
        r3 = null;
        goto L15
    L25:
        return null;
    }

    public final File a(File r4) {
        Intrinsics.checkNotNullParameter(r4, "packageFile");
        String r3 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        String r5 = StringsKt.removeSuffix(StringsKt.removeSuffix(r3, (CharSequence) ZeusTransformUtils.preCheckCast(".mempkg", CharSequence.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(".zip", CharSequence.class, "com.obric.memorydata.plugin"));
        File r6 = r4.getParentFile();
        if (r6 != null) goto L6;
        r6 = new File(".");
    L6:
        return new File(r6, r5 + ".preview.zip");
    }
}
