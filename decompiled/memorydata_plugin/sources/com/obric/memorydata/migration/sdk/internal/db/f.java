package com.obric.memorydata.migration.sdk.internal.db;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002\u001a\u001a\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"PRIVATE_FILES_PREFIX", "", "backupPrivateRawPathResource", "context", "Landroid/content/Context;", "rawPath", "privateFilesDir", "Ljava/io/File;", "restorePrivateRawPathResource", "restoreDir", "relPath", "resolveBackupEntry", "src", "resolveRestoreTarget", "rel", "privateFileRoots", "", "Lcom/obric/memorydata/migration/sdk/internal/db/PrivateFileRoot;", "privateFileRoot", "packagePrefix", "dir", "isSafeRelativePath", "", "path", "copyFile", "", "dest", "migration_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.memorydata.plugin")).b().getPath().length()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.memorydata.plugin")).b().getPath().length()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    private static final g a(String r3, File r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        File r5 = r4.getCanonicalFile();     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.m1421constructorimpl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r6) == false) goto L14;
        r6 = null;
    L14:
        File r7 = (File) ZeusTransformUtils.preCheckCast(r6, File.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L18;
        return null;
    L18:
        return new g(r3, r7);
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final File a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(a(r7), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin");
        String r4 = r3.a();
        if (r4 == null) goto L8;
        Pair r8 = TuplesKt.to(r4, r3.b());
    L9:
        if (r8 == null) goto L4;
        r2.add(r8);
        goto L4
    L8:
        r8 = null;
        goto L9
    L11:
        Map r9 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        String r10 = StringsKt.substringBefore(r6, '/', "");
        String r11 = StringsKt.substringAfter(r6, '/', "");
        File r12 = (File) ZeusTransformUtils.preCheckCast(r9.get(r10), File.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        if (a(r11) == false) goto L17;
        return new File(r12, r11);
    L17:
        return new File(r7.getDataDir(), r6);
    }

    private static final String a(Context r12, File r13) {
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L17;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r14.next(), g.class, "com.obric.memorydata.plugin");
        String r3 = r0.b().getPath() + File.separator;
        String r4 = r13.getPath();
        Intrinsics.checkNotNullExpressionValue(r4, "getPath(...)");
        if (StringsKt.startsWith$default(r4, r3, false, 2, null) == false) goto L4;
        String r6 = FilesKt.relativeTo(r13, r0.b()).getPath();
        Intrinsics.checkNotNullExpressionValue(r6, "getPath(...)");
        String r15 = StringsKt.replace$default(r6, '\\', '/', false, 4, null);
        if (a(r15) == true) goto L10;
        return null;
    L10:
        String r16 = r0.a();
        if (r16 == null) goto L21;
        String r17 = r16 + '/' + r15;
        if (r17 != null) goto L16;
        return r15;
    L16:
        return r17;
    L21:
        return r15;
    L17:
        return null;
    }

    public static final String a(Context r11, File r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r12, "restoreDir");
        Intrinsics.checkNotNullParameter(r13, "relPath");
        if (StringsKt.startsWith$default(r13, "private_files/", false, 2, null) == true) goto L5;
        return null;
    L5:
        String r0 = StringsKt.replace$default(StringsKt.removePrefix(r13, (CharSequence) ZeusTransformUtils.preCheckCast("private_files/", CharSequence.class, "com.obric.memorydata.plugin")), '\\', '/', false, 4, null);
        if (a(r0) == true) goto L8;
        return null;
    L8:
        File r1 = new File(r12, r13);
        if (r1.isFile() == true) goto L11;
        return null;
    L11:
        File r15 = a(r14, r0);
        if (r15 != null) goto L14;
        return null;
    L14:
        a(r1, r15);
        return r15.getAbsolutePath();
    }

    public static final String a(Context r5, String r6, File r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r6, "rawPath");
        Intrinsics.checkNotNullParameter(r7, "privateFilesDir");
        if (StringsKt.startsWith$default(r6, "/", false, 2, null) == true) goto L26;
        return null;
    L26:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r9 = Result.m1421constructorimpl(new File(r6).getCanonicalFile());     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r9) == false) goto L12;
        r9 = null;
    L12:
        File r10 = (File) ZeusTransformUtils.preCheckCast(r9, File.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L16;
        return null;
    L16:
        if (r10.isFile() == true) goto L18;
        return null;
    L18:
        String r11 = a(r8, r10);
        if (r11 != null) goto L21;
        return null;
    L21:
        File r1 = new File(r7, r11);
        File r12 = r1.getParentFile();
        if (r12 == null) goto L24;
        r12.mkdirs();
    L24:
        a(r10, r1);
        return "private_files/" + r11;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final List<g> a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        g[] r0 = new g[5];
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(r7.getFilesDir());     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = null;
    L10:
        r0[0] = a(KevaImpl.PrivateConstants.FILES_DIR_NAME, (File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin"));
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        Object r5 = Result.m1421constructorimpl(r7.getCacheDir());     // Catch: Throwable -> L13
    L16:
        if (Result.m1427isFailureimpl(r5) == false) goto L18;
        r5 = null;
    L18:
        r0[1] = a("cache", (File) ZeusTransformUtils.preCheckCast(r5, File.class, "com.obric.memorydata.plugin"));
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L21
        Object r9 = Result.m1421constructorimpl(r7.getExternalFilesDir(null));     // Catch: Throwable -> L21
    L24:
        if (Result.m1427isFailureimpl(r9) == false) goto L26;
        r9 = null;
    L26:
        r0[2] = a("external_files", (File) ZeusTransformUtils.preCheckCast(r9, File.class, "com.obric.memorydata.plugin"));
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L29
        Object r11 = Result.m1421constructorimpl(r7.getExternalCacheDir());     // Catch: Throwable -> L29
    L32:
        if (Result.m1427isFailureimpl(r11) == false) goto L34;
        r11 = null;
    L34:
        r0[3] = a("external_cache", (File) ZeusTransformUtils.preCheckCast(r11, File.class, "com.obric.memorydata.plugin"));
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L37
        Object r13 = Result.m1421constructorimpl(r7.getDataDir());     // Catch: Throwable -> L37
    L40:
        if (Result.m1427isFailureimpl(r13) == false) goto L42;
        r13 = null;
    L42:
        r0[4] = a(null, (File) ZeusTransformUtils.preCheckCast(r13, File.class, "com.obric.memorydata.plugin"));
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(r0), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r1 = new HashSet();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L44:
        if (r16.hasNext() == false) goto L49;
        Object r17 = r16.next();
        if (r1.add(((g) ZeusTransformUtils.preCheckCast(r17, g.class, "com.obric.memorydata.plugin")).b().getPath()) == false) goto L44;
        r15.add(r17);
        goto L44
    L49:
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
    L37:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L29:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L13:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
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

    private static final boolean a(String r9) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r9, "/", false, 2, null) == false) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == true) goto L35;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{'/'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L12;
    L14:
        Iterator r1 = r0.iterator();
    L16:
        if (r1.hasNext() == false) goto L34;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L20;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == false) goto L16;
        return false;
    L20:
        if (Intrinsics.areEqual(r3, ".") == true) goto L25;
        if (Intrinsics.areEqual(r3, "..") == true) goto L25;
        r4 = false;
    L34:
        return true;
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
    L35:
        return false;
    }
}
