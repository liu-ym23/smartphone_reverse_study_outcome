package org.terracotta.utilities.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes8.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f20290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f20291b = false;
    private static final Pattern c = null;

    /* JADX INFO: renamed from: org.terracotta.utilities.io.a$a, reason: collision with other inner class name */
    private static class C0904a implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f20292a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Thread f20293b;
        private final Phaser c;
        private final AtomicBoolean d;

        static {
            f20292a = d.a(C0904a.class);
        }

        private C0904a(Path r5, boolean r6) {
            final Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
            this.c = new Phaser(2);
            this.d = new AtomicBoolean(false);
            Objects.requireNonNull(r7, "path");
            BasicFileAttributes r0 = java.nio.file.Files.readAttributes(r7, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
            if (r0.isRegularFile() == false) goto L8;
            if (r6 == false) goto L6;
            Runnable r8 = new $$Lambda$a$a$1YTr2zSb1fJDPJ1pgGHwJpiHqSI(this, r7);
        L10:
            this.f20293b = new Thread(r8, "Files$PathHolder - " + r7);
            return;
        L6:
            r8 = new $$Lambda$a$a$ownFa50ai5wgBPqtuUT1Wy06Reo(this, r7);
            goto L10
        L8:
            if (r0.isDirectory() == false) goto L13;
            r8 = new $$Lambda$a$a$hgMKbCb5fX7sNrSb_vDG6P7IJDc(this, r7);
            goto L10
        L13:
            throw new AssertionError("Cannot handle path of type " + a.a(r0) + " - " + r7);
        }

        /* synthetic */ C0904a(Path r2, boolean r3, AnonymousClass1 r4) {
            this((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), r3);
        }

        private void a(Path r4) {
            Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
            f20292a.trace("Hold on \"{}\" beginning", r5);
            RandomAccessFile r0 = new RandomAccessFile(r5.toFile(), "r");     // Catch: Throwable -> L15 Exception -> L17
            r0.read();     // Catch: Throwable -> L7
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L7
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L7
            r0.close();     // Catch: Throwable -> L15 Exception -> L17
        L19:
            this.c.arriveAndDeregister();
            f20292a.trace("Hold ended on \"{}\"", r5);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L12
        L14:
            throw th;     // Catch: Throwable -> L15 Exception -> L17
        L12:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L15 Exception -> L17
        L17:
            e = move-exception;
            f20292a.warn("Error attempting to hold \"{}\"", r5, e);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            this.c.arriveAndDeregister();
            throw th;
        }

        private void b(Path r5) {
            Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
            f20292a.trace("Lock on \"{}\" beginning", r6);
            RandomAccessFile r0 = new RandomAccessFile(r6.toFile(), "rw");     // Catch: Throwable -> L27 Exception -> L29
            FileLock r1 = r0.getChannel().lock();     // Catch: Throwable -> L19
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L10
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L10
            if (r1 == null) goto L8;
            r1.close();     // Catch: Throwable -> L19
        L8:
            r0.close();     // Catch: Throwable -> L27 Exception -> L29
        L31:
            this.c.arriveAndDeregister();
            f20292a.trace("Lock ended on \"{}\"", r6);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (r1 != null) goto L35;
        L18:
            throw th;     // Catch: Throwable -> L19
        L35:
            r1.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L24
        L26:
            throw th;     // Catch: Throwable -> L27 Exception -> L29
        L24:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L27 Exception -> L29
        L27:
            th = move-exception;
            this.c.arriveAndDeregister();
            throw th;
        L29:
            e = move-exception;
            f20292a.warn("Error attempting to lock \"{}\"", r6, e);     // Catch: Throwable -> L27
            goto L31
        }

        private void c(Path r5) {
            Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
            f20292a.trace("Hold on \"{}\" beginning", r6);
            DirectoryStream<Path> r0 = java.nio.file.Files.newDirectoryStream(r6);     // Catch: Throwable -> L19 Exception -> L21
            Iterator<Path> r2 = r0.iterator();     // Catch: Throwable -> L10
            if (r2.hasNext() == false) goto L7;
            Path r1 = (Path) ZeusTransformUtils.preCheckCast(r2.next(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L10
            this.c.arriveAndAwaitAdvance();     // Catch: Throwable -> L10
        L7:
            if (r0 == null) goto L23;
            r0.close();     // Catch: Throwable -> L19 Exception -> L21
        L23:
            this.c.arriveAndDeregister();
            f20292a.trace("Hold ended on \"{}\"", r6);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (r0 != null) goto L27;
        L18:
            throw th;     // Catch: Throwable -> L19 Exception -> L21
        L27:
            r0.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L19 Exception -> L21
        L21:
            e = move-exception;
            f20292a.warn("Error attempting to hold \"{}\"", r6, e);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.c.arriveAndDeregister();
            throw th;
        }

        private /* synthetic */ void d(Path r3) {
            c((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"));
        }

        private /* synthetic */ void e(Path r3) {
            a((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"));
        }

        private /* synthetic */ void f(Path r3) {
            b((Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void lambda$1YTr2zSb1fJDPJ1pgGHwJpiHqSI(C0904a r0, Path r1) {
            r0.f(r1);
        }

        public static /* synthetic */ void lambda$hgMKbCb5fX7sNrSb_vDG6P7IJDc(C0904a r0, Path r1) {
            r0.d(r1);
        }

        public static /* synthetic */ void lambda$ownFa50ai5wgBPqtuUT1Wy06Reo(C0904a r0, Path r1) {
            r0.e(r1);
        }

        public void a() {
            this.f20293b.setDaemon(true);
            this.f20293b.start();
            this.d.set(true);
            this.c.arriveAndAwaitAdvance();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.d.compareAndSet(true, false) == false) goto L10;
            this.c.arriveAndDeregister();
            this.f20293b.join();     // Catch: InterruptedException -> L7
            return;
        L11:
            return;
        }
    }

    static {
        f20290a = d.a(a.class);
        f20291b = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).startsWith("win");
        c = Pattern.compile("(.*): => (.*)");
    }

    a() {
    }

    static List<String> a(BasicFileAttributes r2) {
        BasicFileAttributes r3 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r2, BasicFileAttributes.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        if (r3.isDirectory() == false) goto L6;
        r0.add("dir");
    L6:
        if (r3.isRegularFile() == false) goto L9;
        r0.add("file");
    L9:
        if (r3.isSymbolicLink() == false) goto L12;
        r0.add("link");
    L12:
        if (r3.isOther() == false) goto L14;
        r0.add("other");
    L14:
        return r0;
    }

    static Set<String> a() {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<String> r1 = d().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        f20290a.trace("Retry reason = {}", r0);
        return Collections.unmodifiableSet(r0);
    }

    static Set<String> a(Path r13) {
        Path r14 = (Path) ZeusTransformUtils.wrapperContextForParams(r13, Path.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        Path r4 = java.nio.file.Files.createDirectory(r14.resolve("dir"), new FileAttribute[0]);     // Catch: Throwable -> L90
        Path r6 = java.nio.file.Files.createFile(r4.resolve("file1"), new FileAttribute[0]);     // Catch: Throwable -> L90
        java.nio.file.Files.write(r6, Collections.singleton("file1"), StandardCharsets.UTF_8, new OpenOption[0]);     // Catch: Throwable -> L90
        Path r2 = java.nio.file.Files.createFile(r4.resolve("file2"), new FileAttribute[0]);     // Catch: Throwable -> L90
        java.nio.file.Files.write(r6, Collections.singleton("file2"), StandardCharsets.UTF_8, new OpenOption[0]);     // Catch: Throwable -> L90
        LinkedHashSet r0 = new LinkedHashSet();     // Catch: Throwable -> L90
        AnonymousClass1 r7 = null;
        boolean r8 = true;
        C0904a r9 = new C0904a(r6, r5, r7);     // Catch: Exception -> L17 FileSystemException -> L19 Throwable -> L90
        r9.a();     // Catch: Throwable -> L9
        r6 = java.nio.file.Files.move(r6, r6.resolveSibling("file1_renamed1"), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: Throwable -> L9
        r9.close();     // Catch: Exception -> L17 FileSystemException -> L19 Throwable -> L90
    L135:
        C0904a r10 = new C0904a(r6, r5, r7);     // Catch: Exception -> L33 FileSystemException -> L35 Throwable -> L90
        r10.a();     // Catch: Throwable -> L25
        r4 = java.nio.file.Files.move(r4, r4.resolveSibling("dir_renamed1"), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: Throwable -> L25
        r6 = r4.resolve(r6.getFileName());     // Catch: Throwable -> L25
        r2 = r4.resolve(r2.getFileName());     // Catch: Throwable -> L25
        r10.close();     // Catch: Exception -> L33 FileSystemException -> L35 Throwable -> L90
    L133:
        C0904a r11 = new C0904a(r6, r8, r7);     // Catch: Exception -> L49 FileSystemException -> L51 Throwable -> L90
        r11.a();     // Catch: Throwable -> L41
        r6 = java.nio.file.Files.move(r6, r6.resolveSibling("file1_renamed2"), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: Throwable -> L41
        r11.close();     // Catch: Exception -> L49 FileSystemException -> L51 Throwable -> L90
    L132:
        C0904a r12 = new C0904a(r6, r8, r7);     // Catch: Exception -> L65 FileSystemException -> L67 Throwable -> L90
        r12.a();     // Catch: Throwable -> L57
        r4 = java.nio.file.Files.move(r4, r4.resolveSibling("dir_renamed2"), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: Throwable -> L57
        r6 = r4.resolve(r6.getFileName());     // Catch: Throwable -> L57
        r4.resolve(r2.getFileName());     // Catch: Throwable -> L57
        r12.close();     // Catch: Exception -> L65 FileSystemException -> L67 Throwable -> L90
    L134:
        C0904a r3 = new C0904a(r4, r5, r7);     // Catch: IOException -> L81 FileSystemException -> L83 Throwable -> L90
        r3.a();     // Catch: Throwable -> L73
        java.nio.file.Files.move(r6, r6.resolveSibling("file1_renamed3"), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: Throwable -> L73
        f20290a.trace("Succeeded dir/file rename");     // Catch: Throwable -> L73
        r3.close();     // Catch: IOException -> L81 FileSystemException -> L83 Throwable -> L90
    L96:
        java.nio.file.Files.walkFileTree(r14, new AnonymousClass1());     // Catch: IOException -> L87
    L89:
        return r0;
    L87:
        e = move-exception;
        f20290a.trace("Cannot delete {}", r14, e);
    L73:
        th = move-exception;
        throw th;     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L78
    L80:
        throw th;     // Catch: IOException -> L81 FileSystemException -> L83 Throwable -> L90
    L78:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L81 FileSystemException -> L83 Throwable -> L90
    L83:
        e = move-exception;
        r0.add(e.getReason());     // Catch: Throwable -> L90
        f20290a.trace("Observed for dir/file rename {} '{}'", e.getClass().getSimpleName(), e.getReason());     // Catch: Throwable -> L90
    L81:
        e = move-exception;
        f20290a.trace("Unexpected IOException renaming {}", r6, e);     // Catch: Throwable -> L90
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L62
    L64:
        throw th;     // Catch: Exception -> L65 FileSystemException -> L67 Throwable -> L90
    L62:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L65 FileSystemException -> L67 Throwable -> L90
    L67:
        e = move-exception;
        r0.add(e.getReason());     // Catch: Throwable -> L90
        f20290a.trace("Observed for file/dir LOCKED rename {} '{}'", e.getClass().getSimpleName(), e.getReason());     // Catch: Throwable -> L90
    L65:
        e = move-exception;
        f20290a.trace("Unexpected IOException renaming {}", r4, e);     // Catch: Throwable -> L90
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L46
    L48:
        throw th;     // Catch: Exception -> L49 FileSystemException -> L51 Throwable -> L90
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L49 FileSystemException -> L51 Throwable -> L90
    L51:
        e = move-exception;
        r0.add(e.getReason());     // Catch: Throwable -> L90
        f20290a.trace("Observed for file/file LOCKED rename {} '{}'", e.getClass().getSimpleName(), e.getReason());     // Catch: Throwable -> L90
    L49:
        e = move-exception;
        f20290a.trace("Unexpected IOException renaming {}", r6, e);     // Catch: Throwable -> L90
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Exception -> L33 FileSystemException -> L35 Throwable -> L90
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L33 FileSystemException -> L35 Throwable -> L90
    L35:
        e = move-exception;
        r0.add(e.getReason());     // Catch: Throwable -> L90
        f20290a.trace("Observed for file/dir OPEN rename {} '{}'", e.getClass().getSimpleName(), e.getReason());     // Catch: Throwable -> L90
    L33:
        e = move-exception;
        f20290a.trace("Unexpected IOException renaming {}", r4, e);     // Catch: Throwable -> L90
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r9.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Exception -> L17 FileSystemException -> L19 Throwable -> L90
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L17 FileSystemException -> L19 Throwable -> L90
    L19:
        e = move-exception;
        r0.add(e.getReason());     // Catch: Throwable -> L90
        f20290a.trace("Observed for file/file OPEN rename {} '{}'", e.getClass().getSimpleName(), e.getReason());     // Catch: Throwable -> L90
    L17:
        e = move-exception;
        f20290a.trace("Unexpected IOException renaming {}", r6, e);     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        java.nio.file.Files.walkFileTree(r14, new AnonymousClass1());     // Catch: IOException -> L93
    L95:
        throw th;
    L93:
        e = move-exception;
        f20290a.trace("Cannot delete {}", r14, e);
        goto L95
    }

    static Map<Path, Path> b() {
        if (f20291b == false) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L21
        Iterator<String> r1 = org.terracotta.utilities.a.a.a(org.terracotta.utilities.a.a.C0903a.f20281a, new String[]{"subst"}).iterator();     // Catch: Exception -> L21
    L8:
        if (r1.hasNext() == false) goto L19;
        Matcher r2 = c.matcher((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L21
        if (r2.matches() == false) goto L8;
        Path r4 = Paths.get(r2.group(1), new String[0]);     // Catch: Exception -> L21
        String r3 = r2.group(2);     // Catch: Exception -> L21
        Path r5 = Paths.get(r3, new String[0]);     // Catch: InvalidPathException -> L17 Exception -> L21
    L14:
        if (java.nio.file.Files.exists(r5, new LinkOption[0]) == false) goto L15;
        r0.put(r4, r5);     // Catch: Exception -> L21
        goto L8
    L15:
        f20290a.warn("Cannot determine mapping for drive {}: \"{}\" does not exist", r4, r3);     // Catch: Exception -> L21
    L17:
        e = move-exception;
        f20290a.warn("Cannot determine mapping for drive {}: \"{}\" contains character not mapped in charset {}", new Object[]{r4, r3, org.terracotta.utilities.a.a.C0903a.f20281a, e});     // Catch: Exception -> L21
        goto L8
    L19:
        return Collections.unmodifiableMap(r0);
    L21:
        e = move-exception;
        f20290a.info("Failed to determine drive substitutions", e);
        return Collections.emptyMap();
    L5:
        return Collections.emptyMap();
    }

    static /* synthetic */ c c() {
        return f20290a;
    }

    private static Set<String> d() {
        return a(java.nio.file.Files.createTempDirectory("top", new FileAttribute[0]));
    L4:
        e = move-exception;
        f20290a.trace("Unexpected I/O error constructing failure reasons", e);
        return Collections.emptySet();
    }
}
