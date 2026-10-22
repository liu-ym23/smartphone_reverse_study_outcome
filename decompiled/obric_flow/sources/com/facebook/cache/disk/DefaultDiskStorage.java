package com.facebook.cache.disk;

import ai.j0;
import android.os.Environment;
import android.util.Log;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.time.SystemClock;
import dn.a;
import f4.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultDiskStorage implements DiskStorage {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f7580i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f7581j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f7582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f7584c;
    public final File d;
    public final File e;
    public final File f;
    public final NoOpCacheErrorLogger g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SystemClock f7585h;

    public class ConfigEntriesCollector implements FileTreeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileCategory f7587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DefaultDiskStorage f7588c;

        public ConfigEntriesCollector(DefaultDiskStorage r5, FileCategory r10) {
            this.f7588c = r5;
            this.f7586a = new ArrayList();
            this.f7587b = r10;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void a(File r5) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void b(File r5) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void c(File r10) {
            if (this.f7587b != FileCategory.f7595b) goto L16;
            DefaultDiskStorage r5 = this.f7588c;
            int r11 = DefaultDiskStorage.f7581j;
            r5.getClass();
            FileInfo r12 = FileInfo.a(r10);
            if (r12 == null) goto L10;
            String r13 = String.valueOf(Math.abs(r12.f7598b.hashCode() % 100));
            StringBuilder r14 = new StringBuilder();
            r14.append(r5.d);
            if (new File(j0.q(r14, File.separator, r13)).equals(r10.getParentFile()) == false) goto L10;
        L11:
            if (r12 != null) goto L13;
            return;
        L13:
            if (r12.f7597a != ".cnt") goto L25;
            this.f7586a.add(new EntryImpl(r12.f7598b, r10));
            return;
        L25:
            return;
        L10:
            r12 = null;
            goto L11
        L16:
            FileInfo r15 = DefaultDiskStorage.a(this.f7588c, r10);
            if (r15 == null) goto L26;
            String r16 = r15.f7597a;
            if (r16 != ".cnt") goto L21;
        L22:
            this.f7586a.add(new EntryImpl(r15.f7598b, r10));
            return;
        L21:
            if (r16 == ".tmp") goto L22;
            return;
        }
    }

    public class EntriesCollector implements FileTreeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DefaultDiskStorage f7590b;

        public EntriesCollector(DefaultDiskStorage r5) {
            this.f7590b = r5;
            this.f7589a = new ArrayList();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void a(File r5) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void b(File r5) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void c(File r5) {
            FileInfo r10 = DefaultDiskStorage.a(this.f7590b, r5);
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.f7597a != ".cnt") goto L9;
            this.f7589a.add(new EntryImpl(r10.f7598b, r5));
            return;
        }
    }

    public static class EntryImpl implements DiskStorage.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileBinaryResource f7592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7593c;
        public long d;

        public EntryImpl(String r5, File r10) {
            r5.getClass();
            this.f7591a = r5;
            this.f7592b = new FileBinaryResource(r10);
            this.f7593c = -1;
            this.d = -1;
        }

        public final long a() {
            if (this.d >= 0) goto L6;
            this.d = this.f7592b.f7574a.lastModified();
        L6:
            return this.d;
        }
    }

    public static final enum FileCategory extends Enum<FileCategory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FileCategory f7594a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final FileCategory f7595b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ FileCategory[] f7596c = null;

        static {
            FileCategory r5 = new FileCategory("IMAGE_CACHE_FILE", 0);
            f7594a = r5;
            FileCategory r10 = new FileCategory("CONFIG_FILE", 1);
            f7595b = r10;
            f7596c = new FileCategory[]{r5, r10};
        }

        public FileCategory(String r5, int r10) {
            super(r5, r10);
        }

        public static FileCategory valueOf(String r5) {
            return (FileCategory) Enum.valueOf(FileCategory.class, r5);
        }

        public static FileCategory[] values() {
            return (FileCategory[]) f7596c.clone();
        }
    }

    public static class FileInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7598b;

        public FileInfo(String r5, String r10) {
            this.f7597a = r5;
            this.f7598b = r10;
        }

        public static FileInfo a(File r10) {
            String r11 = r10.getName();
            int r5 = r11.lastIndexOf(46);
            if (r5 > 0) goto L5;
            return null;
        L5:
            String r12 = r11.substring(r5);
            int r13 = DefaultDiskStorage.f7581j;
            String r14 = ".cnt";
            if (".cnt".equals(r12) == false) goto L9;
        L12:
            if (r14 != null) goto L14;
            return null;
        L14:
            String r15 = r11.substring(0, r5);
            if (r14.equals(".tmp") == false) goto L21;
            int r16 = r15.lastIndexOf(46);
            if (r16 > 0) goto L19;
            return null;
        L19:
            r15 = r15.substring(0, r16);
        L21:
            return new FileInfo(r14, r15);
        L9:
            if (".tmp".equals(r12) == false) goto L11;
            r14 = ".tmp";
            goto L12
        L11:
            r14 = null;
            goto L12
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder();
            r5.append(this.f7597a);
            r5.append("(");
            return j0.q(r5, this.f7598b, ")");
        }
    }

    public static class IncompleteFileException extends IOException {
        public IncompleteFileException(long r5, long r10) {
            StringBuilder r11 = a.K(r5, "File was not written completely. Expected: ", ", found: ");
            r11.append(r10);
            super(r11.toString());
        }
    }

    public class InserterImpl implements DiskStorage.Inserter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f7600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DefaultDiskStorage f7601c;

        public InserterImpl(DefaultDiskStorage r5, String r10, File r11) {
            this.f7601c = r5;
            this.f7599a = r10;
            this.f7600b = r11;
        }

        public final void a(WriterCallback r10) {
            FileOutputStream r5 = new FileOutputStream(this.f7600b);     // Catch: FileNotFoundException -> L12
            CountingOutputStream r11 = new CountingOutputStream(r5);     // Catch: Throwable -> L9
            r10.a(r11);     // Catch: Throwable -> L9
            r11.flush();     // Catch: Throwable -> L9
            long r12 = r11.f7650a;     // Catch: Throwable -> L9
            r5.close();
            if (this.f7600b.length() != r12) goto L8;
            return;
        L8:
            throw new IncompleteFileException(r12, this.f7600b.length());
        L9:
            th = move-exception;
            r5.close();
            throw th;
        L12:
            e = move-exception;
            NoOpCacheErrorLogger r13 = this.f7601c.g;
            int r14 = DefaultDiskStorage.f7581j;
            r13.getClass();
            throw e;
        }

        public final FileBinaryResource a() {
            File r5 = this.f7601c.a(this.f7599a);
            FileUtils.a(this.f7600b, r5);     // Catch: FileUtils.RenameException -> L9
            if (r5.exists() == false) goto L8;
            this.f7601c.f7585h.getClass();
            r5.setLastModified(System.currentTimeMillis());
        L8:
            return new FileBinaryResource(r5);
        L9:
            e = move-exception;
            Throwable r10 = e.getCause();
            if (r10 != null) goto L13;
        L15:
            NoOpCacheErrorLogger r11 = this.f7601c.g;
            int r12 = DefaultDiskStorage.f7581j;
            r11.getClass();
            throw e;
        L13:
            if ((r10 instanceof FileUtils.ParentDirNotFoundException) == true) goto L15;
            boolean r13 = r10 instanceof FileNotFoundException;
            goto L15
        }
    }

    public class PurgingVisitor implements FileTreeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DefaultDiskStorage f7603b;

        public PurgingVisitor(DefaultDiskStorage r5) {
            this.f7603b = r5;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void a(File r5) {
            if (this.f7602a == false) goto L5;
            return;
        L5:
            if (r5.equals(this.f7603b.f7584c) == false) goto L9;
            this.f7602a = true;
            return;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void b(File r5) {
            if (this.f7603b.f7582a.equals(r5) == true) goto L8;
            if (this.f7602a == true) goto L8;
            r5.delete();
        L8:
            if (this.f7602a == true) goto L10;
            return;
        L10:
            if (r5.equals(this.f7603b.f7584c) == false) goto L14;
            this.f7602a = false;
            return;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public final void c(File r10) {
            if (this.f7602a == false) goto L17;
            FileInfo r5 = DefaultDiskStorage.a(this.f7603b, r10);
            if (r5 == null) goto L17;
            String r11 = r5.f7597a;
            if (r11 != ".tmp") goto L13;
            long r12 = r10.lastModified();
            this.f7603b.f7585h.getClass();
            if (r12 <= (System.currentTimeMillis() - DefaultDiskStorage.f7580i)) goto L17;
            return;
        L13:
            if (r11 != ".cnt") goto L16;
            return;
        L16:
            throw new IllegalStateException();
        L17:
            r10.delete();
        }
    }

    static {
        f7580i = TimeUnit.MINUTES.toMillis(30);
    }

    public DefaultDiskStorage(File r5, File r10, int r11, NoOpCacheErrorLogger r12) {
        this.f7582a = r5;
        this.f = r10;
        File r13 = Environment.getExternalStorageDirectory();     // Catch: Exception -> L10
        if (r13 != null) goto L34;
    L11:
        boolean r14 = false;
    L12:
        this.f7583b = r14;
        File r15 = new File(this.f7582a, j0.g(r11, "v2.ols100."));
        this.f7584c = r15;
        this.e = new File(this.f7582a, ("v2.ols100." + r11).concat("-config"));
        this.d = new File(this.f, ("v2.ols100." + r11).concat("-config"));
        this.g = r12;
        if (this.f7582a.exists() == true) goto L16;
    L38:
        FileUtils.a(r15);     // Catch: FileUtils.CreateDirectoryException -> L20
    L22:
        if (this.f7582a.exists() == true) goto L25;
    L32:
        FileUtils.a(this.f7584c);     // Catch: FileUtils.CreateDirectoryException -> L29
    L30:
        this.f7585h = SystemClock.f7693a;
        return;
    L29:
        NoOpCacheErrorLogger r16 = this.g;
        Objects.toString(this.f7584c);
        r16.getClass();
        goto L30
    L25:
        if (this.f7584c.exists() == true) goto L30;
        FileTree.a(this.f7582a);
    L20:
        NoOpCacheErrorLogger r17 = this.g;
        Objects.toString(this.f7584c);
        r17.getClass();
        goto L22
    L16:
        if (r15.exists() == true) goto L22;
        FileTree.a(this.f7582a);
        goto L38
    L34:
        r14 = r5.getCanonicalPath().contains(r13.toString());     // Catch: IOException -> L8 Exception -> L10
    L8:
        r12.getClass();     // Catch: Exception -> L10
    L10:
        r12.getClass();
        goto L11
    }

    public static FileInfo a(DefaultDiskStorage r5, File r10) {
        r5.getClass();
        FileInfo r11 = FileInfo.a(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        if (new File(r5.b(r11.f7598b)).equals(r10.getParentFile()) == false) goto L8;
        return r11;
    L8:
        return null;
    }

    public final String b(String r5) {
        String r10 = String.valueOf(Math.abs(r5.hashCode() % 100));
        StringBuilder r11 = new StringBuilder();
        r11.append(this.f7584c);
        return j0.q(r11, File.separator, r10);
    }

    public final DiskStorage.Inserter c(String r5, CacheKey r10) {
        File r11 = new File(b(r5));
        if (r11.exists() == true) goto L16;
        FileUtils.a(r11);     // Catch: FileUtils.CreateDirectoryException -> L6
    L6:
        e = move-exception;
        this.g.getClass();
        throw e;
    L16:
        File r12 = File.createTempFile(r5.concat("."), ".tmp", r11);     // Catch: IOException -> L11
        d(r5, r10);     // Catch: IOException -> L11
        return new InserterImpl(this, r5, r12);
    L11:
        e = move-exception;
        this.g.getClass();
        throw e;
    }

    public final void d(String r10, CacheKey r11) {
        if ((r11 instanceof DiskWrapperCacheKey) == false) goto L30;
        Map r12 = ((DiskWrapperCacheKey) r11).f7634b;
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.isEmpty() == true) goto L29;
        String r5 = String.valueOf(Math.abs(r10.hashCode() % 100));
        StringBuilder r13 = new StringBuilder();
        r13.append(this.d);
        String r14 = File.separator;
        File r15 = new File(j0.q(r13, r14, r5));
        if (r15.exists() == false) goto L25;
    L16:
        StringBuilder r16 = new StringBuilder();
        r16.append(this.d + r14 + String.valueOf(Math.abs(r10.hashCode() % 100)));
        File r17 = new File(b.b(r16, r14, r10, ".cnt"));
        if (r17.exists() == true) goto L19;
        r17.createNewFile();
    L19:
        StringBuilder r18 = new StringBuilder();
        FileWriter r19 = new FileWriter(r17, false);
        Iterator r20 = r12.entrySet().iterator();
    L21:
        if (r20.hasNext() == false) goto L23;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        String r23 = (String) r21.getValue();
        r18.append(r22);
        r18.append("=");
        r18.append(r23);
        r18.append(System.lineSeparator());
        goto L21
    L23:
        r19.write(r18.toString());
        r19.close();
        return;
    L25:
        FileUtils.a(r15);     // Catch: FileUtils.CreateDirectoryException -> L13
    L13:
        e = move-exception;
        this.g.getClass();
        throw e;
    L29:
        return;
    }

    public final File a(String r5) {
        return new File(b.b(sk.a.a(b(r5)), File.separator, r5, ".cnt"));
    }

    public final Map b(String r10, CacheKey r11) {
        String r12 = String.valueOf(Math.abs(r10.hashCode() % 100));
        StringBuilder r5 = new StringBuilder();
        r5.append(this.e);
        String r13 = File.separator;
        HashMap r14 = a(new File(androidx.room.jarjarred.org.antlr.runtime.a.q(j0.q(r5, r13, r12), r13, r10, ".cnt")));
        StringBuilder r15 = new StringBuilder();
        r15.append(this.d + r13 + String.valueOf(Math.abs(r10.hashCode() % 100)));
        r14.putAll(a(new File(b.b(r15, r13, r10, ".cnt"))));
        return r14;
    }

    public final BinaryResource a(String r5, CacheKey r10) {
        File r11 = a(r5);
        if (r11.exists() == false) goto L6;
        this.f7585h.getClass();
        r11.setLastModified(System.currentTimeMillis());
        return new FileBinaryResource(r11);
    L6:
        return null;
    }

    public final long c(String r10) {
        String r5 = String.valueOf(Math.abs(r10.hashCode() % 100));
        StringBuilder r11 = new StringBuilder();
        r11.append(this.e);
        String r12 = File.separator;
        File r13 = new File(androidx.room.jarjarred.org.antlr.runtime.a.q(j0.q(r11, r12, r5), r12, r10, ".cnt"));
        if (r13.exists() == false) goto L6;
        r13.length();
        r13.delete();
    L6:
        StringBuilder r14 = new StringBuilder();
        r14.append(this.d + r12 + String.valueOf(Math.abs(r10.hashCode() % 100)));
        File r15 = new File(b.b(r14, r12, r10, ".cnt"));
        if (r15.exists() == true) goto L10;
        return 0;
    L10:
        long r16 = r15.length();
        if (r15.delete() == false) goto L13;
        return r16;
    L13:
        return -1;
    }

    public final long a(DiskStorage.Entry r5) {
        File r10 = ((EntryImpl) r5).f7592b.f7574a;
        if (r10.exists() == true) goto L6;
        return 0;
    L6:
        long r11 = r10.length();
        if (r10.delete() == false) goto L9;
        return r11;
    L9:
        return -1;
    }

    public static HashMap a(File r5) {
        HashMap r10 = new HashMap();
        if (r5.exists() == false) goto L23;
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L16 IOException -> L29
    L36:
        String r13 = r12.readLine();     // Catch: Throwable -> L10 IOException -> L15
        if (r13 == null) goto L12;
        int r14 = r13.lastIndexOf("=");     // Catch: Throwable -> L10 IOException -> L15
        r10.put(r13.substring(0, r14), r13.substring(r14 + 1));     // Catch: Throwable -> L10 IOException -> L15
        goto L36
    L12:
        r12.close();     // Catch: Throwable -> L10 IOException -> L15
        r12.close();     // Catch: IOException -> L30
        return r10;
    L15:
        r11 = r12;
    L10:
        th = th;
    L25:
        if (r12 != null) goto L32;
    L27:
        throw th;
    L32:
        r12.close();     // Catch: IOException -> L28
    L16:
        th = th;
        r12 = r11;
    L19:
        if (FLogDefaultLoggingDelegate.f7658a.a(5) == false) goto L21;
        Log.println(5, FLogDefaultLoggingDelegate.a("DefaultDiskStorage"), "fileToMap: file not found");     // Catch: Throwable -> L16
    L21:
        if (r11 == null) goto L23;
        r11.close();     // Catch: IOException -> L30
    L23:
        return r10;
    }

    public final List b() {
        ConfigEntriesCollector r5 = new ConfigEntriesCollector(this, FileCategory.f7594a);
        FileTree.a(this.f7584c, r5);
        return Collections.unmodifiableList(r5.f7586a);
    }

    public final Collection a() {
        ConfigEntriesCollector r5 = new ConfigEntriesCollector(this, FileCategory.f7595b);
        FileTree.a(this.d, r5);
        return Collections.unmodifiableList(r5.f7586a);
    }

    public final Collection c() {
        EntriesCollector r5 = new EntriesCollector(this);
        FileTree.a(this.f7584c, r5);
        return Collections.unmodifiableList(r5.f7589a);
    }
}
