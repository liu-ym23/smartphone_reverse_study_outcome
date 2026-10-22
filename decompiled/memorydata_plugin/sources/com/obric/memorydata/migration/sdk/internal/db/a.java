package com.obric.memorydata.migration.sdk.internal.db;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.keva.KevaImpl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.migration.sdk.DbRole;
import com.obric.memorydata.migration.sdk.af;
import com.obric.memorydata.migration.sdk.ag;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.t;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0004H\u0000\u001a\u001a\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u000b0\n*\u00020\u0004H\u0000\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0000\u001a)\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u0012*\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u000bH\u0002\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\u001a \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0000\u001a \u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0000\u001a \u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020%H\u0000\u001a\"\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\n0\u00102\u0006\u0010)\u001a\u00020%H\u0002\u001a\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0002\u001aj\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020%2\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001042$\u00105\u001a \u0012\u0004\u0012\u00020\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0001060404H\u0000\u001a \u00107\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00108\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0000\u001an\u00109\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020%2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001042\u0006\u00101\u001a\u0002022\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010604H\u0002\u001a\"\u0010@\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010=\u001a\u00020%H\u0002\u001a\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0001H\u0002\u001a\"\u0010D\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\u0006\u0010>\u001a\u00020%H\u0002\u001a\u001a\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020FH\u0002\u001a \u0010H\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020F2\u0006\u0010-\u001a\u00020%H\u0002\"\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"tempMigrationDbName", "", "originDbName", "resolvePhysicalDbName", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "openRoomDatabase", "Landroidx/room/RoomDatabase;", "physicalDbName", "liveRoomDatabase", "openLiveTargetDb", "Lkotlin/Pair;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "resolveKeepTables", "", "db", "requestedTables", "", "withForeignKeysDisabled", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isForeignKeysEnabled", "", "parentsOf", "table", "tableExists", "dbSidecarSuffixes", "copyDatabaseFileSet", "", "context", "Landroid/content/Context;", "fromDbName", "toDbName", "copyDatabaseFilesToDir", "dbName", "outDir", "Ljava/io/File;", "restoreDatabaseFilesFromDir", "snapshotDir", "deleteDatabaseFileSet", "dbFile", "listSidecarFiles", "copyFile", "src", "dest", "backupDbResources", "dbConfig", "backupRootDir", "fileUriMapper", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;", "pathMapping", "", "publicMediaColumns", "", "restoreDbPrivateFiles", "restoreDir", "backupResourcesForTable", "tableConfig", "Lcom/obric/memorydata/migration/sdk/TableBackupConfig;", "filesDir", "privateFilesDir", "publicMediaDir", "publicMediaColumnsByTable", "backupPrivateAbsolutePath", "rawPath", "looksLikeResourceColumn", ActivityLifecycle.NAME, "backupMediaStoreToPrivate", "uri", "Landroid/net/Uri;", "queryDisplayName", "copyUriToFile", "migration_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f11913a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.db.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0645a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11914a = null;

        static {
            int[] r0 = new int[DbRole.values().length];
            r0[DbRole.GLOBAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DbRole.USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11914a = r0;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\"\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"com/obric/memorydata/migration/sdk/internal/db/DbExporterKt$backupResourcesForTable$Col", "", ActivityLifecycle.NAME, "", "idx", "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getIdx", "()I", "component1", "component2", "copy", "(Ljava/lang/String;I)Lcom/obric/memorydata/migration/sdk/internal/db/DbExporterKt$backupResourcesForTable$Col;", "equals", "", "other", "hashCode", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11916b;

        public b(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            this.f11915a = r2;
            this.f11916b = r3;
        }

        public final String a() {
            return this.f11915a;
        }

        public final int b() {
            return this.f11916b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11915a, r6.f11915a) == true) goto L12;
            return false;
        L12:
            if (this.f11916b == r6.f11916b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11915a.hashCode() * 31) + Integer.hashCode(this.f11916b);
        }

        public String toString() {
            return "Col(name=" + this.f11915a + ", idx=" + this.f11916b + ')';
        }
    }

    static {
        f11913a = CollectionsKt.listOf(new String[]{"-wal", "-shm", "-journal"});
    }

    public static final RoomDatabase a(com.obric.memorydata.migration.sdk.g r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "physicalDbName");
        DbRole r4 = r2.b();
        int r5 = C0645a.f11914a[r4.ordinal()];
        if (r5 != 1) goto L5;
        Object r6 = MemoryDbEngine.INSTANCE.buildDatabaseEngine(r3);
    L11:
        return (RoomDatabase) ZeusTransformUtils.preCheckCast(r6, RoomDatabase.class, "com.obric.memorydata.plugin");
    L5:
        if (r5 != 2) goto L8;
        r6 = MemoryDbEngine.INSTANCE.buildPersonalDatabaseEngine(r3);
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(ai r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(Map.Entry r11) {
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r11, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<destruct>");
        return (CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin")) + "=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(r12.getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ']', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final String a(Context r10, Uri r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
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

    private static final String a(Context r20, Uri r21, File r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        String r4 = a(r2, r21);
        if (r4 == null) goto L9;
        String r5 = StringsKt.substringAfterLast(r4, '.', "");
        if (r5 == null) goto L9;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
    L10:
        MessageDigest r9 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        File r10 = new File(r22, "tmp_" + System.nanoTime());
        File r11 = r10.getParentFile();
        if (r11 == null) goto L79;
        r11.mkdirs();
    L79:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L42
        InputStream r0 = r2.getContentResolver().openInputStream(r21);     // Catch: Throwable -> L42
        if (r0 == null) goto L40;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        InputStream r1 = (InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r10), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        FileOutputStream r14 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r13, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        byte[] r15 = new byte[8192];     // Catch: Throwable -> L26
    L19:
        int r16 = r1.read(r15);     // Catch: Throwable -> L26
        if (r16 == (-1)) goto L22;
        r9.update(r15, 0, r16);     // Catch: Throwable -> L26
        r14.write(r15, 0, r16);     // Catch: Throwable -> L26
        goto L19
    L22:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L33
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L42
        goto L40
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L40:
        Object r8 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L42
    L45:
        if (Result.m1427isFailureimpl(r8) == false) goto L48;
        r8 = false;
    L48:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L50;
    L72:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L67
        Result.m1421constructorimpl(Boolean.valueOf(r10.delete()));     // Catch: Throwable -> L67
    L69:
        return null;
    L67:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L69
    L50:
        if (r10.exists() == false) goto L72;
        byte[] r19 = r9.digest();
        Intrinsics.checkNotNullExpressionValue(r19, "digest(...)");
        String r23 = ArraysKt.joinToString$default(r19, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$hcmuXAF4kSawcwheNB0hyrOsC4w.INSTANCE, 30, null);
        if (r5 == null) goto L55;
        r23 = r23 + '.' + r5;
    L55:
        File r24 = new File(r22, r23);
        if (r24.exists() == true) goto L77;
        Serializable r25 = (Serializable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(r10.renameTo(r24)), Serializable.class, "com.obric.memorydata.plugin");
    L64:
        return "public_media/" + r24.getName();
    L77:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L59
        Object r27 = Result.m1421constructorimpl(Boolean.valueOf(r10.delete()));     // Catch: Throwable -> L59
    L61:
        Result.m1420boximpl(r27);
    L59:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L42:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L9:
        r5 = null;
        goto L10
    }

    public static final String a(com.obric.memorydata.migration.sdk.g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DbRole r0 = r2.b();
        int r1 = C0645a.f11914a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return com.obric.memorydata.middleware.database.b.f11646a.b(r2.a());
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return r2.a();
    }

    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "originDbName");
        return "migration_tmp_" + r2;
    }

    private static final Set<String> a(SupportSQLiteDatabase r6, String r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set r0 = SetsKt.createSetBuilder();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8.query("PRAGMA foreign_key_list(`" + r7 + "`)"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        int r3 = r10.getColumnIndex("table");     // Catch: Throwable -> L17
    L5:
        String r4 = null;
        if (r10.moveToNext() == false) goto L14;
        String r5 = r10.getString(r3);     // Catch: Throwable -> L17
        if (r5 == null) goto L5;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        r4 = r5;
    L12:
        if (r4 == null) goto L5;
        r0.add(r4);     // Catch: Throwable -> L17
        goto L5
    L14:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L22
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        return SetsKt.build(r0);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static final Set<String> a(SupportSQLiteDatabase r6, List<String> r7) {
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "db");
        Intrinsics.checkNotNullParameter(r9, "requestedTables");
        LinkedHashSet r0 = new LinkedHashSet();
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r3 = r11.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Iterator r4 = r12.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r0.add((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        goto L10
    L12:
        ArrayDeque r5 = new ArrayDeque((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r8, (String) ZeusTransformUtils.preCheckCast(r5.removeFirst(), String.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r13.hasNext() == false) goto L14;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (r0.add(r14) == false) goto L17;
        r5.addLast(r14);
        goto L17
    L22:
        return (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin");
    }

    private static final void a(Context r34, SupportSQLiteDatabase r35, ai r36, File r37, File r38, File r39, Map<String, String> r40, com.obric.memorydata.migration.sdk.internal.file.b r41, Map<String, Set<String>> r42) {
        String r1 = ",";
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r34, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r0 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r35, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r40, Map.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.b r5 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r41, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r42, Map.class, "com.obric.memorydata.plugin");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r36.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (b(r0, r7) == true) goto L6;
        t.f11981a.a("backup: skip resources, missing table=" + r7);
        return;
    L6:
        String r8 = r36.b();
        if (r8 != null) goto L232;
        r8 = "SELECT * FROM `" + r7 + '`';
    L232:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = Result.m1421constructorimpl(r0.query(r8));     // Catch: Throwable -> L11
    L13:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r2);
        if (r10 != null) goto L224;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast((Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r12 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L217
        List r13 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L217
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r12.getColumnCount()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L217
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L217
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L217
    L19:
        if (r16.hasNext() == false) goto L29;
        Object r17 = r16.next();     // Catch: Throwable -> L25
        String r18 = r12.getColumnName(((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L25
        Iterator r43 = r16;
        if (r18 != null) goto L23;
        r18 = "";
    L23:
        String r19 = r18.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r19, "toLowerCase(...)");     // Catch: Throwable -> L25
        r15.put(r19, r17);     // Catch: Throwable -> L25
        r16 = r43;
    L25:
        th = move-exception;
        Throwable r20 = th;
        Closeable r21 = r11;
    L236:
        throw r20;     // Catch: Throwable -> L221
    L221:
        th = move-exception;
        CloseableKt.closeFinally(r21, r20);
        throw th;
    L29:
        if ((!r36.c().isEmpty()) == false) goto L37;
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r36.c().keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L25
    L32:
        if (r110.hasNext() == false) goto L47;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        String r112 = r111.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r112, "toLowerCase(...)");     // Catch: Throwable -> L25
        Iterator r44 = r110;
        Integer r113 = (Integer) ZeusTransformUtils.preCheckCast(r15.get(r112), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r113 == null) goto L36;
        r13.add(new b(r111, r113.intValue()));     // Catch: Throwable -> L25
    L36:
        r110 = r44;
    L47:
        List r114 = CollectionsKt.build(r13);     // Catch: Throwable -> L217
        boolean r115 = r36.c().isEmpty();     // Catch: Throwable -> L217
        t r22 = t.f11981a;     // Catch: Throwable -> L217
        StringBuilder r23 = new StringBuilder().append("backup: resources table begin, table=").append(r7).append(", sql=").append(r8).append(", totalColumns=").append(r12.getColumnCount()).append(", mode=");     // Catch: Throwable -> L217
        if (r115 == false) goto L51;
        String r116 = "auto-discover";
    L52:
        r22.a(r23.append(r116).append(", initialColumnCount=").append(r114.size()).append(", initialColumns=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$b7gOMooISvdSKbwpX01i5vylNZs.INSTANCE, 30, null)).toString());     // Catch: Throwable -> L217
        if (r114.isEmpty() == false) goto L59;
        if (r115 == true) goto L59;
        t.f11981a.a("backup: resources table skip, table=" + r7 + ", declared columns none matched");     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r11, null);
        return;
    L59:
        af r117 = ag.f11885a.a();     // Catch: Throwable -> L217
        int r118 = r4.size();     // Catch: Throwable -> L217
        Set r24 = (Set) ZeusTransformUtils.preCheckCast(r6.get(r7), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L217
        if (r24 != null) goto L62;
        int r119 = 0;
    L64:
        LinkedHashSet r25 = new LinkedHashSet();     // Catch: Throwable -> L217
        int r120 = 0;
        int r26 = 0;
        int r27 = 0;
        int r28 = 0;
        int r29 = 0;
    L65:
        if (r12.moveToNext() == false) goto L203;
        Closeable r121 = r11;
        String r30 = "file://";
        String r122 = r1;
        String r31 = "content://";
        int r210 = r119;
        if (r115 == true) goto L70;
    L96:
        Map r32 = r4;
        com.obric.memorydata.migration.sdk.internal.file.b r211 = r5;
        Map r212 = r6;
        String r33 = r7;
    L97:
        if (r115 == true) goto L100;
        List r45 = r114;
    L125:
        if (r115 == true) goto L127;
    L131:
        boolean r46 = false;
    L132:
        Iterator r47 = r45.iterator();     // Catch: Throwable -> L201
    L134:
        if (r47.hasNext() == false) goto L200;
        b r48 = (b) ZeusTransformUtils.preCheckCast(r47.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L138
        Object r50 = Result.m1421constructorimpl(r12.getString(r48.b()));     // Catch: Throwable -> L138
    L141:
        if (Result.m1427isFailureimpl(r50) == false) goto L143;
        r50 = null;
    L143:
        String r51 = (String) ZeusTransformUtils.preCheckCast(r50, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        if (r46 == false) goto L151;
        if (r51 == null) goto L151;
        String r213 = r31;
        boolean r310 = r46;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r51, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L149;
    L152:
        af r52 = (af) ZeusTransformUtils.preCheckCast(r36.c().get(r48.a()), af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        if (r52 != null) goto L155;
        r52 = r117;
    L155:
        boolean r53 = ag.f11885a.a(r52);     // Catch: Throwable -> L201
        Iterator r54 = ((Iterable) ZeusTransformUtils.preCheckCast(r52.extractPath(r51), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L201
    L157:
        if (r54.hasNext() == false) goto L198;
        String r55 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r54.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L201
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r55, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L161;
        boolean r56 = true;
    L162:
        if (r56 == true) goto L196;
        r26 = r26 + 1;     // Catch: Throwable -> L201
        if (r53 == false) goto L173;
        String r123 = b(r3, r55, r38);     // Catch: Throwable -> L201
        if (r123 == null) goto L173;
        Map r124 = r32;
        r124.put(r55, r123);     // Catch: Throwable -> L201
        Map r125 = r212;
        String r57 = r33;
        Object r214 = r125.get(r57);     // Catch: Throwable -> L201
        if (r214 != null) goto L170;
        Object r58 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        r125.put(r57, r58);     // Catch: Throwable -> L201
    L171:
        ((Set) ZeusTransformUtils.preCheckCast(r58, Set.class, "com.obric.memorydata.plugin")).add(r48.a());     // Catch: Throwable -> L201
        r28 = r28 + 1;     // Catch: Throwable -> L201
        String r59 = r57;
        Iterator r215 = r47;
        String r311 = r30;
    L183:
        Cursor r312 = r12;
    L197:
        r12 = r312;
        r47 = r215;
        r54 = r54;
        r30 = r311;
        r33 = r59;
        r212 = r125;
        r53 = r53;
        r32 = r124;
        goto L157
    L170:
        r58 = r214;
    L173:
        r125 = r212;
        r124 = r32;
        r53 = r53;
        r59 = r33;
        r54 = r54;
        com.obric.memorydata.migration.sdk.internal.file.b r60 = r211;
        String r61 = r60.a(r55);     // Catch: Throwable -> L201
        r211 = r60;
        if (r61 == null) goto L185;
        r215 = r47;
        r311 = r30;
        File r62 = new File(r37, r61);     // Catch: Throwable -> L201
        File r63 = r62.getParentFile();     // Catch: Throwable -> L201
        if (r63 == null) goto L180;
        Boolean.valueOf(r63.mkdirs());     // Catch: Throwable -> L201
    L180:
        Uri r64 = Uri.parse(r55);     // Catch: Throwable -> L201
        Intrinsics.checkNotNullExpressionValue(r64, "parse(...)");     // Catch: Throwable -> L201
        if (b(r3, r64, r62) == false) goto L184;
        r27 = r27 + 1;     // Catch: Throwable -> L201
        goto L183
    L184:
        Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L201
        Unit r66 = Unit.INSTANCE;     // Catch: Throwable -> L201
    L186:
        r312 = r12;
        if (StringsKt.startsWith$default(r55, "content://media/", false, 2, null) == false) goto L197;
        Uri r67 = Uri.parse(r55);     // Catch: Throwable -> L201
        Intrinsics.checkNotNullExpressionValue(r67, "parse(...)");     // Catch: Throwable -> L201
        String r68 = a(r3, r67, r39);     // Catch: Throwable -> L201
        if (r68 == null) goto L197;
        r124.put(r55, r68);     // Catch: Throwable -> L201
        Object r69 = r125.get(r59);     // Catch: Throwable -> L201
        if (r69 != null) goto L193;
        r69 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        r125.put(r59, r69);     // Catch: Throwable -> L201
    L193:
        ((Set) ZeusTransformUtils.preCheckCast(r69, Set.class, "com.obric.memorydata.plugin")).add(r48.a());     // Catch: Throwable -> L201
        r29 = r29 + 1;     // Catch: Throwable -> L201
        Unit r70 = Unit.INSTANCE;     // Catch: Throwable -> L201
        Unit r71 = Unit.INSTANCE;     // Catch: Throwable -> L201
        goto L197
    L185:
        r215 = r47;
        r311 = r30;
        goto L186
    L196:
        r311 = r30;
        r312 = r12;
        r125 = r212;
        r124 = r32;
        r53 = r53;
        r215 = r47;
        r59 = r33;
        r54 = r54;
        goto L197
    L161:
        r56 = false;
        goto L162
    L198:
        r12 = r12;
    L199:
        r31 = r213;
        r46 = r310;
        goto L134
    L149:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r51, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L152;
    L151:
        r213 = r31;
        r310 = r46;
    L138:
        th = move-exception;
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L201
        r50 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L201
    L201:
        th = move-exception;
        r20 = th;
        r21 = r121;
        goto L236
    L200:
        r120 = r120 + 1;
        r12 = r12;
        r7 = r33;
        r6 = r212;
        r4 = r32;
        r11 = r121;
        r1 = r122;
        r119 = r210;
        r118 = r118;
        r5 = r211;
        goto L65
    L127:
        if (r114.isEmpty() == false) goto L131;
        if (r25.isEmpty() == false) goto L131;
        r46 = true;
        goto L132
    L100:
        Collection r72 = (Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Iterable r73 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Collection r74 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r73, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Iterator r75 = r73.iterator();     // Catch: Throwable -> L201
    L102:
        if (r75.hasNext() == false) goto L107;
        int r76 = ((Number) ZeusTransformUtils.preCheckCast(r75.next(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L201
        String r127 = r12.getColumnName(r76);     // Catch: Throwable -> L201
        if (r127 != null) goto L106;
        r127 = "";
    L106:
        r74.add(new b(r127, r76));     // Catch: Throwable -> L201
        goto L102
    L107:
        Iterable r77 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus(r72, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r74, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        HashSet r78 = new HashSet();     // Catch: Throwable -> L201
        ArrayList r79 = new ArrayList();     // Catch: Throwable -> L201
        Iterator r80 = r77.iterator();     // Catch: Throwable -> L201
    L109:
        if (r80.hasNext() == false) goto L113;
        Object r81 = r80.next();     // Catch: Throwable -> L201
        if (r78.add(Integer.valueOf(((b) ZeusTransformUtils.preCheckCast(r81, b.class, "com.obric.memorydata.plugin")).b())) == false) goto L109;
        r79.add(r81);     // Catch: Throwable -> L201
        goto L109
    L113:
        r45 = (List) ZeusTransformUtils.preCheckCast(r79, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        if (r45.isEmpty() == false) goto L125;
        if (r120 >= 500) goto L125;
        Iterable r82 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r12.getColumnCount()), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Collection r83 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r82, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        Iterator r84 = r82.iterator();     // Catch: Throwable -> L201
    L119:
        if (r84.hasNext() == false) goto L124;
        int r85 = ((IntIterator) ZeusTransformUtils.preCheckCast(r84, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();     // Catch: Throwable -> L201
        String r128 = r12.getColumnName(r85);     // Catch: Throwable -> L201
        if (r128 != null) goto L123;
        r128 = "";
    L123:
        r83.add(new b(r128, r85));     // Catch: Throwable -> L201
        goto L119
    L124:
        r45 = (List) ZeusTransformUtils.preCheckCast(r83, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        goto L125
    L70:
        if (r120 >= 500) goto L96;
        if (r25.size() >= 12) goto L96;
        int r129 = r12.getColumnCount();     // Catch: Throwable -> L201
        int r130 = 0;
    L74:
        if (r130 >= r129) goto L95;
        if (r25.contains(Integer.valueOf(r130)) == false) goto L239;
        Map r313 = r4;
        com.obric.memorydata.migration.sdk.internal.file.b r216 = r5;
        Map r217 = r6;
        String r314 = r7;
        r129 = r129;
    L94:
        r130 = r130 + 1;     // Catch: Throwable -> L201
        r129 = r129;
        r5 = r216;
        r6 = r217;
        r7 = r314;
        r4 = r313;
        goto L74
    L239:
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L79
        Object r87 = Result.m1421constructorimpl(r12.getString(r130));     // Catch: Throwable -> L79
    L82:
        if (Result.m1427isFailureimpl(r87) == false) goto L85;
        r87 = null;
    L85:
        String r88 = (String) ZeusTransformUtils.preCheckCast(r87, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L201
        if (r88 != null) goto L88;
        r313 = r4;
        r216 = r5;
        r217 = r6;
        r314 = r7;
        goto L94
    L88:
        r216 = r5;
        r313 = r4;
        r217 = r6;
        r314 = r7;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r88, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("content://", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L91;
    L92:
        r25.add(Integer.valueOf(r130));     // Catch: Throwable -> L201
        goto L94
    L91:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r88, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("file://", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L94;
    L79:
        th = move-exception;
        Result.Companion r218 = Result.Companion;     // Catch: Throwable -> L201
        r87 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L201
        goto L82
    L95:
        r32 = r4;
        r211 = r5;
        r212 = r6;
        r33 = r7;
        goto L97
    L203:
        String r131 = r1;
        r121 = r11;
        int r219 = r118;
        int r220 = r119;
        Map r132 = r4;
        String r89 = r7;
        Set r90 = (Set) ZeusTransformUtils.preCheckCast(r6.get(r89), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L215
        if (r90 != null) goto L207;
        r90 = SetsKt.emptySet();     // Catch: Throwable -> L201
    L207:
        t r91 = t.f11981a;     // Catch: Throwable -> L215
        StringBuilder r92 = new StringBuilder();     // Catch: Throwable -> L215
        StringBuilder r93 = r92.append("backup: resources table end, table=").append(r89).append(", rowCount=").append(r120).append(", scannedColumnCount=");     // Catch: Throwable -> L215
        Iterable r94 = (Iterable) ZeusTransformUtils.preCheckCast(r114, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L215
        Collection r95 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r94, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L215
        Iterator r96 = r94.iterator();     // Catch: Throwable -> L215
    L209:
        if (r96.hasNext() == false) goto L212;
        r95.add(Integer.valueOf(((b) ZeusTransformUtils.preCheckCast(r96.next(), b.class, "com.obric.memorydata.plugin")).b()));     // Catch: Throwable -> L201
        goto L209
    L212:
        r93.append(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r95, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).size()).append(", dynamicDiscoveredCount=").append(r25.size()).append(", extractedUriCount=").append(r26).append(", copiedFilesCount=").append(r27).append(", privateAbsCount=").append(r28).append(", mediaStoreCount=").append(r29).append(", newPathMappings=").append(r132.size() - r219).append(", pathMappingTotal=").append(r132.size()).append(", newMediaColumns=").append(r90.size() - r220).append(", mediaColumns=[");     // Catch: Throwable -> L215
        r92.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r90, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r131, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(']');     // Catch: Throwable -> L215
        r91.a(r92.toString());     // Catch: Throwable -> L215
        Unit r97 = Unit.INSTANCE;     // Catch: Throwable -> L215
        CloseableKt.closeFinally(r121, null);
        return;
    L215:
        th = th;
        r21 = r121;
    L219:
        r20 = th;
        goto L236
    L62:
        r119 = r24.size();     // Catch: Throwable -> L25
        goto L64
    L51:
        r116 = "declared";
        goto L52
    L37:
        int r133 = r12.getColumnCount();     // Catch: Throwable -> L217
        int r134 = 0;
    L39:
        if (r134 >= r133) goto L47;
        String r135 = r12.getColumnName(r134);     // Catch: Throwable -> L25
        if (r135 != null) goto L44;
        r135 = "";
    L44:
        if (b(r135) == false) goto L46;
        r13.add(new b(r135, r134));     // Catch: Throwable -> L25
    L46:
        r134 = r134 + 1;
    L217:
        th = th;
        r21 = r11;
        goto L219
    L224:
        t.f11981a.a("backup: query resources failed, table=" + r7 + " sql=" + r8, r10);
        return;
    L11:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static final void a(Context r29, SupportSQLiteDatabase r30, com.obric.memorydata.migration.sdk.g r31, File r32, com.obric.memorydata.migration.sdk.internal.file.b r33, Map<String, String> r34, Map<String, Map<String, Set<String>>> r35) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r29, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r12 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r30, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.b r13 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r33, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r12, "db");
        Intrinsics.checkNotNullParameter(r31, "dbConfig");
        Intrinsics.checkNotNullParameter(r32, "backupRootDir");
        Intrinsics.checkNotNullParameter(r13, "fileUriMapper");
        Intrinsics.checkNotNullParameter(r14, "pathMapping");
        Intrinsics.checkNotNullParameter(r3, "publicMediaColumns");
        File r15 = new File(r32, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        r15.mkdirs();
        File r11 = new File(r32, "private_files");
        r11.mkdirs();
        File r10 = new File(r32, "public_media");
        r10.mkdirs();
        String r0 = r31.a();
        Object r4 = r3.get(r0);
        if (r4 != null) goto L5;
        r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r3.put(r0, r4);
    L5:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r31.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L6:
        boolean r17 = false;
        if (r7.hasNext() == false) goto L15;
        Object r8 = r7.next();
        ai r9 = (ai) ZeusTransformUtils.preCheckCast(r8, ai.class, "com.obric.memorydata.plugin");
        if ((!r9.c().isEmpty()) == false) goto L11;
    L12:
        r17 = true;
    L13:
        if (r17 == false) goto L6;
        r6.add(r8);
        goto L6
    L11:
        if (r9.d() == false) goto L13;
    L15:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        t r19 = t.f11981a;
        String r20 = ", resourceTablesCount=";
        String r21 = ", resourceTables=";
        StringBuilder r22 = new StringBuilder().append("backup: resources begin, db=").append(r0).append(", totalTables=").append(r31.c().size()).append(", resourceTablesCount=").append(r18.size()).append(", resourceTables=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$VDIlyngz7bxxpiEwGgSeS9XlmM4.INSTANCE, 30, null)).append(", pathMappingBefore=").append(r14.size()).append(", publicMediaDbKeysBefore=").append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r3.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null)).append(", publicMediaColumnEntriesBefore=");
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r24 = 0;
    L16:
        String r36 = r21;
        if (r23.hasNext() == false) goto L19;
        r24 = r24 + ((Set) ZeusTransformUtils.preCheckCast(r23.next(), Set.class, "com.obric.memorydata.plugin")).size();
        r21 = r36;
        r23 = r23;
        goto L16
    L19:
        r19.a(r22.append(r24).toString());
        if (r18.isEmpty() == false) goto L23;
        t.f11981a.a("backup: resources skipped, db=" + r0 + ", no resource-eligible table");
        return;
    L23:
        int r110 = r14.size();
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r111.hasNext() == false) goto L35;
        ai r25 = (ai) ZeusTransformUtils.preCheckCast(r111.next(), ai.class, "com.obric.memorydata.plugin");
        int r26 = r14.size();
        Iterator r27 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r28 = 0;
    L28:
        if (r27.hasNext() == false) goto L30;
        r28 = r28 + ((Set) ZeusTransformUtils.preCheckCast(r27.next(), Set.class, "com.obric.memorydata.plugin")).size();
        goto L28
    L30:
        Context r210 = r1;
        SupportSQLiteDatabase r211 = r12;
        String r112 = r36;
        File r37 = r15;
        String r113 = r20;
        List r38 = r18;
        File r212 = r10;
        File r213 = r11;
        a(r1, r12, r25, r15, r11, r10, r14, r13, r16);
        t r39 = t.f11981a;
        StringBuilder r2 = new StringBuilder().append("backup: resources table done, db=").append(r0).append(", table=").append(r25.a()).append(", newPathMappings=").append(r14.size() - r26).append(", newPublicMediaColumns=");
        Iterator r40 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r41 = 0;
    L32:
        if (r40.hasNext() == false) goto L34;
        r41 = r41 + ((Set) ZeusTransformUtils.preCheckCast(r40.next(), Set.class, "com.obric.memorydata.plugin")).size();
        goto L32
    L34:
        r39.a(r2.append(r41 - r28).toString());
        r18 = r38;
        r20 = r113;
        r1 = r210;
        r10 = r212;
        r11 = r213;
        r15 = r37;
        r12 = r211;
        r36 = r112;
        goto L25
    L35:
        List r310 = r18;
        String r42 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ; ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$E_424tn59L0snXMr568txyd12vM.INSTANCE, 30, null);
        t r43 = t.f11981a;
        StringBuilder r44 = new StringBuilder().append("backup: resources done, db=").append(r0).append(r20).append(r310.size()).append(r36).append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r310, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$TIzqyuxsyat7Dx68Cmld2mRO9Q4.INSTANCE, 30, null)).append(", newPathMappings=").append(r14.size() - r110).append(", pathMappingTotal=").append(r14.size()).append(", publicMediaColumnTablesCount=").append(r16.size()).append(", publicMediaColumnEntries=");
        Iterator r45 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r46 = 0;
    L37:
        if (r45.hasNext() == false) goto L39;
        r46 = r46 + ((Set) ZeusTransformUtils.preCheckCast(r45.next(), Set.class, "com.obric.memorydata.plugin")).size();
        goto L37
    L39:
        r43.a(r44.append(r46).append(", publicMediaColumns={").append(r42).append('}').toString());
    }

    public static final void a(Context r9, File r10, com.obric.memorydata.migration.sdk.internal.file.b r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.b r13 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r10, "restoreDir");
        Intrinsics.checkNotNullParameter(r13, "fileUriMapper");
        File r0 = new File(r10, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        if (r0.exists() == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        Iterator r14 = ((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r0), Sequence.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r14.hasNext() == false) goto L34;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r14.next(), File.class, "com.obric.memorydata.plugin");
        if (r3.isFile() == false) goto L10;
        String r4 = FilesKt.relativeTo(r3, r0).getPath();
        Intrinsics.checkNotNull(r4);
        File r5 = r13.a(r12, r4);
        if (r5 == null) goto L10;
        File r6 = r5.getParentFile();
        if (r6 == null) goto L19;
        r6.mkdirs();
    L19:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r3), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r5), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r15, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L29
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r7, null);
        goto L10
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static final void a(Context r5, File r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "snapshotDir");
        Intrinsics.checkNotNullParameter(r7, "dbName");
        File r9 = r8.getDatabasePath(r7);
        Intrinsics.checkNotNull(r9);
        a(r9);
        File r0 = new File(r6, r7);
        a(r0, r9);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Pair r11 = (Pair) ZeusTransformUtils.preCheckCast(r10.next(), Pair.class, "com.obric.memorydata.plugin");
        a((File) ZeusTransformUtils.preCheckCast(r11.component1(), File.class, "com.obric.memorydata.plugin"), new File(r9.getAbsolutePath() + ((String) ZeusTransformUtils.preCheckCast(r11.component2(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    }

    public static final void a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r3, "dbName");
        File r5 = r4.getDatabasePath(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "getDatabasePath(...)");
        a(r5);
    }

    public static final void a(Context r5, String r6, File r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "dbName");
        Intrinsics.checkNotNullParameter(r7, "outDir");
        File r9 = r8.getDatabasePath(r6);
        Intrinsics.checkNotNull(r9);
        a(r9, new File(r7, r6));
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r9), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r10.next(), Pair.class, "com.obric.memorydata.plugin");
        a((File) ZeusTransformUtils.preCheckCast(r0.component1(), File.class, "com.obric.memorydata.plugin"), new File(r7, r6 + ((String) ZeusTransformUtils.preCheckCast(r0.component2(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    }

    public static final void a(Context r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "fromDbName");
        Intrinsics.checkNotNullParameter(r7, "toDbName");
        a(r8, r7);
        File r9 = r8.getDatabasePath(r6);
        File r10 = r8.getDatabasePath(r7);
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNull(r10);
        a(r9, r10);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r9), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Pair r12 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        a((File) ZeusTransformUtils.preCheckCast(r12.component1(), File.class, "com.obric.memorydata.plugin"), new File(r10.getAbsolutePath() + ((String) ZeusTransformUtils.preCheckCast(r12.component2(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    }

    public static final void a(File r3) {
        Intrinsics.checkNotNullParameter(r3, "dbFile");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Boolean.valueOf(r3.delete()));     // Catch: Throwable -> L5
    L7:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r3), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        File r1 = (File) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r4.next(), Pair.class, "com.obric.memorydata.plugin")).component1(), File.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Result.m1421constructorimpl(Boolean.valueOf(r1.delete()));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void a(File r5, File r6) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        File r0 = r6.getParentFile();
        if (r0 == null) goto L8;
        r0.mkdirs();
    L8:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        OutputStream r2 = (OutputStream) ZeusTransformUtils.preCheckCast(r8, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r1, InputStream.class, "com.obric.memorydata.plugin"), r2, 0, 2, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static final /* synthetic */ boolean a(SupportSQLiteDatabase r2) {
        return b((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    public static final RoomDatabase b(com.obric.memorydata.migration.sdk.g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DbRole r3 = r2.b();
        int r4 = C0645a.f11914a[r3.ordinal()];
        if (r4 != 1) goto L5;
        Object r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
    L11:
        return (RoomDatabase) ZeusTransformUtils.preCheckCast(r5, RoomDatabase.class, "com.obric.memorydata.plugin");
    L5:
        if (r4 != 2) goto L8;
        r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private static final CharSequence b(ai r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final String b(Context r2, String r3, File r4) {
        String r5 = f.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
        if (r5 != null) goto L10;
        return null;
    L10:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L6
        t.f11981a.a("backup: backupPrivateAbsolutePath copied, raw=" + r3 + ", entry=" + r5);     // Catch: Throwable -> L6
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return r5;
    L6:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return r5;
    }

    private static final List<Pair<File, String>> b(File r7) {
        String r8 = r7.getAbsolutePath();
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f11913a, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        File r4 = new File(r8 + r3);
        Pair r6 = null;
        if (r4.exists() == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L11;
        r6 = TuplesKt.to(r4, r3);
    L11:
        if (r6 == null) goto L4;
        r1.add(r6);
        goto L4
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    private static final boolean b(Context r4, Uri r5, File r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.m1421constructorimpl(r7.getContentResolver().openInputStream(r5));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r8) == false) goto L10;
        r8 = null;
    L10:
        InputStream r9 = (InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L27;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
        InputStream r2 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        ByteStreamsKt.copyTo$default(r2, (OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r10, null);
        return true;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L27:
        return false;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final boolean b(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query("PRAGMA foreign_keys"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        boolean r5 = false;
        if (r3.moveToFirst() == false) goto L10;
        if (r3.getInt(0) == 0) goto L10;
        r5 = true;
        goto L10
    L10:
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L17
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L17
    L20:
        if (Result.m1427isFailureimpl(r9) == false) goto L23;
        r9 = true;
    L23:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    private static final boolean b(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L26;
        return false;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT 1 FROM sqlite_master WHERE type='table' AND name=? LIMIT 1", new String[]{r5}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        boolean r1 = ((Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L15
        Object r8 = Result.m1421constructorimpl(Boolean.valueOf(r1));     // Catch: Throwable -> L15
    L18:
        if (Result.m1427isFailureimpl(r8) == false) goto L21;
        r8 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private static final boolean b(String r7) {
        String r8 = r7.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r8, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("screenshot", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
    L22:
        return true;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("image", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("media", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("uri", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("url", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("path", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("file", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("cover", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("thumb", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("avatar", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L22;
        return false;
    }

    public static final Pair<RoomDatabase, SupportSQLiteDatabase> c(com.obric.memorydata.migration.sdk.g r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return TuplesKt.to(null, b(r1).getOpenHelper().getWritableDatabase());
    }

    public static /* synthetic */ CharSequence lambda$E_424tn59L0snXMr568txyd12vM(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$TIzqyuxsyat7Dx68Cmld2mRO9Q4(ai r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$VDIlyngz7bxxpiEwGgSeS9XlmM4(ai r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$b7gOMooISvdSKbwpX01i5vylNZs(b r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$hcmuXAF4kSawcwheNB0hyrOsC4w(byte r0) {
        return a(r0);
    }
}
