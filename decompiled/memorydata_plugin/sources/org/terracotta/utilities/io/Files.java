package org.terracotta.utilities.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilePermission;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystemException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes8.dex */
public final class Files {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f20284a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final Duration f20285b = null;
    private static final c c = null;
    private static final Duration d = null;
    private static final Duration e = null;
    private static final Set<String> f = null;
    private static final Set<CopyOption> g = null;
    private static final ExecutorService h = null;
    private static final SecureRandom i = null;
    private static final ThreadLocal<Map<Path, FileStore>> j = null;
    private static final ThreadLocal<Map<Path, Path>> k = null;

    public static final enum ExtendedOption extends Enum<ExtendedOption> implements CopyOption {
        private static final /* synthetic */ ExtendedOption[] $VALUES = null;
        public static final ExtendedOption DEEP_COPY = null;
        public static final ExtendedOption NOSPAN_FILESTORES = null;
        public static final ExtendedOption RECURSIVE = null;

        static {
            ExtendedOption r0 = new ExtendedOption("RECURSIVE", 0);
            RECURSIVE = r0;
            ExtendedOption r1 = new ExtendedOption("NOSPAN_FILESTORES", 1);
            NOSPAN_FILESTORES = r1;
            ExtendedOption r3 = new ExtendedOption("DEEP_COPY", 2);
            DEEP_COPY = r3;
            $VALUES = new ExtendedOption[]{r0, r1, r3};
        }

        private ExtendedOption(String r1, int r2) {
            super(r1, r2);
        }

        public static ExtendedOption valueOf(String r2) {
            return (ExtendedOption) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExtendedOption.class, r2), ExtendedOption.class, "com.obric.memorydata.plugin");
        }

        public static ExtendedOption[] values() {
            return (ExtendedOption[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExtendedOption[].class, "com.obric.memorydata.plugin");
        }
    }

    public static class FileStoreConstraintException extends FileSystemException {
        private static final long serialVersionUID = 1639103038640071760L;

        public FileStoreConstraintException(String r1, String r2, String r3) {
            super(r1, r2, r3);
        }
    }

    private static class a extends FutureTask<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f20288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callable<Void> f20289b;
        private final Path c;
        private final boolean d;
        private final Runnable e;
        private final Predicate<FileSystemException> f;

        private a(ExecutorService r3, Callable<Void> r4, Path r5, boolean r6, Runnable r7) {
            ExecutorService r8 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
            Callable<Void> r9 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            Path r10 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
            Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            super(r9);
            final HashMap r0 = new HashMap();
            this.f = new $$Lambda$Files$a$tmo3qIYHGvwQEanaGEZdVz6YiJA(r0);
            this.f20288a = r8;
            this.f20289b = r9;
            this.c = r10;
            this.d = r6;
            this.e = r11;
        }

        /* synthetic */ a(ExecutorService r8, Callable r9, Path r10, boolean r11, Runnable r12, AnonymousClass1 r13) {
            this((ExecutorService) ZeusTransformUtils.wrapperContextForParams(r8, ExecutorService.class, "com.obric.memorydata.plugin"), (Callable) ZeusTransformUtils.wrapperContextForParams(r9, Callable.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.memorydata.plugin"), r11, (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin"));
        }

        private static /* synthetic */ Predicate a(Class r1) {
            final HashMap r2 = new HashMap();
            return new $$Lambda$Files$a$_LDwRIzl6JUp2nBcCfNNRUwy34(r2);
        }

        private void a(FileSystemException r3) {
            if (this.f.test(r3) == false) goto L6;
            Files.a().warn("Failed to delete \"{}\" - retrying", this.c, r3);
            return;
        }

        private static /* synthetic */ boolean a(Map r4, String r5) {
            if ((((Integer) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).merge(r5, 1, $$Lambda$Files$a$PLyH_8zRx7lwjaMeeJ3EDjz5kyk.INSTANCE), Integer.class, "com.obric.memorydata.plugin")).intValue() % 10) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private static /* synthetic */ boolean a(Map r3, FileSystemException r4) {
            return ((Predicate) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")).computeIfAbsent(r4.getClass(), $$Lambda$Files$a$Ri_PtzApXl1outs23VeWOt8GYOQ.INSTANCE), Predicate.class, "com.obric.memorydata.plugin")).test(r4.getReason());
        }

        public static /* synthetic */ int lambda$PLyH_8zRx7lwjaMeeJ3EDjz5kyk(int r0, int r1) {
            return Integer.sum(r0, r1);
        }

        public static /* synthetic */ Predicate lambda$Ri_PtzApXl1outs23VeWOt8GYOQ(Class r0) {
            return a(r0);
        }

        /* JADX INFO: renamed from: lambda$_LDw-RIzl6JUp2nBcCfNNRUwy34, reason: not valid java name */
        public static /* synthetic */ boolean m3212lambda$_LDwRIzl6JUp2nBcCfNNRUwy34(Map r0, String r1) {
            return a(r0, r1);
        }

        public static /* synthetic */ boolean lambda$tmo3qIYHGvwQEanaGEZdVz6YiJA(Map r0, FileSystemException r1) {
            return a(r0, r1);
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            boolean r4 = false;
            boolean r5 = true;
            this.f20289b.call();     // Catch: Exception -> L5 FileSystemException -> L8 DirectoryNotEmptyException -> L16
            Files.a().debug("Deletion complete for \"{}\"", this.c);     // Catch: Exception -> L5 FileSystemException -> L8 DirectoryNotEmptyException -> L16
            set(null);     // Catch: Exception -> L5 FileSystemException -> L8 DirectoryNotEmptyException -> L16
            return;
        L16:
            e = move-exception;
            if (this.d == false) goto L20;
            a(e);
        L22:
            if (isCancelled() == false) goto L24;
            Files.a().warn("Background deletion for \"{}\" canceled - manual cleanup needed", this.c);
            set(null);
        L25:
            if (r4 == true) goto L47;
            return;
        L47:
            this.e.run();     // Catch: Throwable -> L31
            this.f20288a.execute(this);     // Catch: RejectedExecutionException -> L29
            Files.a().info("Submitted background deletion task for \"{}\"", this.c);     // Catch: RejectedExecutionException -> L29
            return;
        L29:
            e = move-exception;
            setException(e);
            Files.a().warn("Background deletion for \"{}\" failed - manual cleanup needed", this.c, e);
            return;
        L31:
            th = move-exception;
            Files.a().warn("Progress helper failed during rename of \"{}\": {}", this.c, th);     // Catch: Throwable -> L34
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            this.f20288a.execute(this);     // Catch: RejectedExecutionException -> L37
            Files.a().info("Submitted background deletion task for \"{}\"", this.c);     // Catch: RejectedExecutionException -> L37
        L39:
            throw th;
        L37:
            e = move-exception;
            setException(e);
            Files.a().warn("Background deletion for \"{}\" failed - manual cleanup needed", this.c, e);
            goto L39
        L24:
            r4 = r5;
            goto L25
        L20:
            Files.a().warn("Background deletion of \"{}\" failed - manual cleanup needed", this.c, e);
            setException(e);
        L7:
            r5 = false;
        L8:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e, AccessDeniedException.class) == false) goto L12;
        L15:
            a(e);
            goto L22
        L12:
            if (Files.b().contains(e.getReason()) == true) goto L15;
            setException(e);
        L5:
            e = move-exception;
            Files.a().warn("Background deletion of \"{}\" failed - manual cleanup needed", this.c, e);
            setException(e);
            goto L7
        }
    }

    static {
        c = d.a(Files.class);
        f20284a = System.getProperty("os.name", "").toLowerCase(Locale.ROOT).startsWith("win");
        d = Duration.ofMillis(50);
        Duration r0 = Duration.ofMillis(2500);
        e = r0;
        f20285b = r0.dividedBy(4);
        f = org.terracotta.utilities.io.a.a();
        HashSet r1 = new HashSet(EnumSet.allOf(ExtendedOption.class));
        r1.add(StandardCopyOption.COPY_ATTRIBUTES);
        r1.add(StandardCopyOption.REPLACE_EXISTING);
        r1.add(LinkOption.NOFOLLOW_LINKS);
        g = Collections.unmodifiableSet(r1);
        ThreadPoolExecutor r2 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new AnonymousClass1());
        r2.allowCoreThreadTimeOut(true);
        h = r2;
        i = new SecureRandom();
        j = ThreadLocal.withInitial($$Lambda$Files$Q3Ak6ic9absS3KtebcCGrvx5gsE.INSTANCE);
        k = ThreadLocal.withInitial($$Lambda$Lz20MUn0bXSOyFg4_cy78LS3ZX4.INSTANCE);
    }

    private Files() {
    }

    private static long a(Duration r3) {
        Duration r0 = d;
        if (r0.compareTo(r3) <= 0) goto L6;
        return -1;
    L6:
        Duration r4 = r3.dividedBy(10);
        if (r4.compareTo(r0) >= 0) goto L11;
        return r0.toNanos();
    L11:
        return r4.toNanos();
    }

    private static String a(String r4) {
        long r0 = i.nextLong();
        StringBuilder r5 = new StringBuilder().append(r4);
        if (r0 != Long.MIN_VALUE) goto L5;
        long r1 = 0;
    L7:
        return r5.append(r1).toString();
    L5:
        r1 = Math.abs(r0);
        goto L7
    }

    private static /* synthetic */ Path a(Path r3, Supplier r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Supplier r6 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin");
        return r5.resolveSibling(r5.getFileSystem().getPath((String) ZeusTransformUtils.preCheckCast(r6.get(), String.class, "com.obric.memorydata.plugin"), new String[0]));
    }

    private static Path a(Path r2, Supplier<String> r3, Duration r4, Runnable r5) {
        final Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        final Supplier r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        return b(r6, new $$Lambda$Files$sXySlyFJ_SU2jyz5lBQkdu1g0lE(r6, r7), r4, r8);
    }

    static /* synthetic */ c a() {
        return c;
    }

    private static void a(Path r2) {
        java.nio.file.Files.walkFileTree((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), new AnonymousClass2());
    }

    private static void a(Path r9, boolean r10, Runnable r11) {
        final Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        new a(h, new $$Lambda$Files$kCR6MQzjodoxzMt1J5FrYYBdWk(r5), r5, r10, r7, null).run();
    }

    private static void a(Path r2, boolean r3, Duration r4, Runnable r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        c r0 = c;
        if (r0.isDebugEnabled() == false) goto L5;
        r0.debug("[deleteTreeWithRetry] Deleting \"{}\"", r6);
    L5:
        Path r8 = a(r6, $$Lambda$Files$Li22jpYoQemptfUTtClXH2iMNE.INSTANCE, r4, r7);
        r0.debug("Deleting \"{}\" renamed from \"{}\"", r8, r6);
        a(r8, r3, r7);
    }

    private static /* synthetic */ Void b(Path r2) {
        a((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"));
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static Path b(Path r21, Supplier<Path> r22, Duration r23, Runnable r24) {
        String r1 = "Unexpected IOException renaming \"{}\" to \"{}\"; elapsedTime={}";
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r21, Path.class, "com.obric.memorydata.plugin");
        Supplier r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r22, Supplier.class, "com.obric.memorydata.plugin");
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r24, Runnable.class, "com.obric.memorydata.plugin");
        if (r23.isNegative() == true) goto L74;
        boolean r6 = Thread.interrupted();
        long r7 = System.nanoTime();     // Catch: Throwable -> L69
        long r9 = r23.toNanos() + r7;     // Catch: Throwable -> L69
        long r11 = a(r23);     // Catch: Throwable -> L69
    L85:
        Path r13 = (Path) ZeusTransformUtils.preCheckCast(r4.get(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        c r0 = c;     // Catch: Throwable -> L67
        if (r0.isDebugEnabled() == false) goto L83;
        r0.debug("Renaming \"{}\" to \"{}\"", r3, r13);     // Catch: Throwable -> L69
    L83:
        java.nio.file.Files.move(r3, r13, new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: IOException -> L15 FileSystemException -> L18 AtomicMoveNotSupportedException -> L62 Throwable -> L69
    L12:
        if (r6 == false) goto L14;
        Thread.currentThread().interrupt();
    L14:
        return r13;
    L15:
        e = move-exception;
        c.warn(r1, new Object[]{r3, r13, Duration.ofNanos(System.nanoTime() - r7), e});     // Catch: Throwable -> L69
        throw e;     // Catch: Throwable -> L69
    L62:
        e = move-exception;
        throw e;     // Catch: Throwable -> L65
    L18:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, AccessDeniedException.class) == true) goto L28;
        boolean r25 = r6;
    L65:
        th = th;
        r6 = r25;
    L70:
        if (r6 == false) goto L72;
        Thread.currentThread().interrupt();
    L72:
        throw th;
    L24:
        if (f.contains(e.getReason()) == false) goto L26;
    L81:
        r5.run();     // Catch: Throwable -> L58
        TimeUnit.NANOSECONDS.sleep(r11);     // Catch: InterruptedException -> L32 Throwable -> L65
        r6 = r25;
    L33:
        c r2 = c;     // Catch: Throwable -> L69
        if (r2.isTraceEnabled() == false) goto L38;
        r2.trace("Retrying rename of \"{}\"; elapsedTime={}, interrupted={}", new Object[]{r3, Duration.ofNanos(System.nanoTime() - r7), Boolean.valueOf(r6)});     // Catch: Throwable -> L69
    L38:
        if ((r9 - System.nanoTime()) < 0) goto L39;
        r1 = r1;
        goto L85
    L39:
        Path r8 = (Path) ZeusTransformUtils.preCheckCast(r4.get(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
        if (r2.isDebugEnabled() == false) goto L75;
        r2.debug("Renaming \"{}\" to \"{}\"", r3, r8);     // Catch: Throwable -> L69
    L75:
        java.nio.file.Files.move(r3, r8, new CopyOption[]{StandardCopyOption.ATOMIC_MOVE});     // Catch: FileSystemException -> L47 Throwable -> L69
        if (r6 == false) goto L46;
        Thread.currentThread().interrupt();
    L46:
        return r8;
    L47:
        e = move-exception;
        c r10 = c;     // Catch: Throwable -> L69
        Object[] r12 = new Object[5];     // Catch: Throwable -> L69
        if (ZeusTransformUtils.instanceOf(e, AccessDeniedException.class) == false) goto L51;
    L54:
        String r14 = "Persistent";
    L55:
        r12[0] = r14;     // Catch: Throwable -> L69
        r12[1] = r3;     // Catch: Throwable -> L69
        r12[2] = r8;     // Catch: Throwable -> L69
        r12[3] = Duration.ofNanos(System.nanoTime() - r7);     // Catch: Throwable -> L69
        r12[4] = e;     // Catch: Throwable -> L69
        r10.warn("{} IOException renaming \"{}\" to \"{}\"; elapsedTime={}", r12);     // Catch: Throwable -> L69
        throw e;     // Catch: Throwable -> L69
    L51:
        if (f.contains(e.getReason()) == true) goto L54;
        r14 = "Unexpected";
    L32:
        r6 = true;
        goto L33
    L58:
        th = move-exception;
        c.warn("Progress helper failed during rename of \"{}\": {}", r3, th);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L26:
        c.warn(r1, new Object[]{r3, r13, Duration.ofNanos(System.nanoTime() - r7), e});     // Catch: Throwable -> L65
        throw e;     // Catch: Throwable -> L65
    L28:
        r25 = r6;
    L67:
        th = th;
    L69:
        th = th;
        goto L70
    L74:
        throw new IllegalArgumentException("renameTimeLimit must be greater than 0");
    }

    static /* synthetic */ Set b() {
        return f;
    }

    private static /* synthetic */ String c() {
        return a("del");
    }

    private static /* synthetic */ void d() {
    }

    public static void delete(Path r2) {
        delete((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), e);
    }

    public static void delete(Path r2, Duration r3) {
        delete((Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin"), r3, $$Lambda$Files$H9kdH9CMqX1OQ_gZEHzQJYQeYw0.INSTANCE);
    }

    public static void delete(Path r4, Duration r5, Runnable r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "path must be non-null");
        Objects.requireNonNull(r5, "renameTimeLimit must be non-null");
        Objects.requireNonNull(r8, "progressHelper must be non-null");
        SecurityManager r0 = System.getSecurityManager();
        if (r0 == null) goto L5;
        r0.checkPermission(new FilePermission(r7.toString(), "read,write,delete"));
    L5:
        Path r9 = r7.toRealPath(new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        if (java.nio.file.Files.readAttributes(r9, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}).isDirectory() == false) goto L23;
        DirectoryStream<Path> r1 = java.nio.file.Files.newDirectoryStream(r9);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r1 != null) goto L25;
    L22:
        throw th;
    L25:
        r1.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L9:
        if (r1.iterator().hasNext() == true) goto L12;
        if (r1 == null) goto L23;
        r1.close();
        goto L23
    L12:
        c.debug("Failing to delete \"{}\"; directory not empty", r9);     // Catch: Throwable -> L14
        throw new DirectoryNotEmptyException(r9.toString());     // Catch: Throwable -> L14
    L23:
        a(r9, false, r5, r8);
    }

    public static /* synthetic */ void lambda$H9kdH9CMqX1OQ_gZEHzQJYQeYw0() {
        d();
    }

    /* JADX INFO: renamed from: lambda$Li2-2jpYoQemptfUTtClXH2iMNE, reason: not valid java name */
    public static /* synthetic */ String m3210lambda$Li22jpYoQemptfUTtClXH2iMNE() {
        return c();
    }

    public static /* synthetic */ WeakHashMap lambda$Q3Ak6ic9absS3KtebcCGrvx5gsE() {
        return new WeakHashMap();
    }

    /* JADX INFO: renamed from: lambda$kCR6MQzjodo-xzMt1J5FrYYBdWk, reason: not valid java name */
    public static /* synthetic */ Void m3211lambda$kCR6MQzjodoxzMt1J5FrYYBdWk(Path r0) {
        return b(r0);
    }

    public static /* synthetic */ Path lambda$sXySlyFJ_SU2jyz5lBQkdu1g0lE(Path r0, Supplier r1) {
        return a(r0, r1);
    }
}
