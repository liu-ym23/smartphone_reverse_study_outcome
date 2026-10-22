package okhttp3.internal.cache;

import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010)\n\u0002\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0004VWXYB7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0016J!\u00107\u001a\u0002052\n\u00108\u001a\u000609R\u00020\u00002\u0006\u0010:\u001a\u00020\u0012H\u0000¢\u0006\u0002\b;J\u0006\u0010<\u001a\u000205J \u0010=\u001a\b\u0018\u000109R\u00020\u00002\u0006\u0010>\u001a\u00020$2\b\b\u0002\u0010?\u001a\u00020\u000bH\u0007J\u0006\u0010@\u001a\u000205J\b\u0010A\u001a\u000205H\u0016J\u0017\u0010B\u001a\b\u0018\u00010CR\u00020\u00002\u0006\u0010>\u001a\u00020$H\u0086\u0002J\u0006\u0010D\u001a\u000205J\u0006\u0010E\u001a\u00020\u0012J\b\u0010F\u001a\u00020\u0012H\u0002J\b\u0010G\u001a\u00020!H\u0002J\b\u0010H\u001a\u000205H\u0002J\b\u0010I\u001a\u000205H\u0002J\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020$H\u0002J\r\u0010L\u001a\u000205H\u0000¢\u0006\u0002\bMJ\u000e\u0010N\u001a\u00020\u00122\u0006\u0010>\u001a\u00020$J\u0019\u0010O\u001a\u00020\u00122\n\u0010P\u001a\u00060%R\u00020\u0000H\u0000¢\u0006\u0002\bQJ\u0006\u00101\u001a\u00020\u000bJ\u0010\u0010R\u001a\f\u0012\b\u0012\u00060CR\u00020\u00000SJ\u0006\u0010T\u001a\u000205J\u0010\u0010U\u001a\u0002052\u0006\u0010>\u001a\u00020$H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u00000#X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R&\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006Z"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "executor", "Ljava/util/concurrent/Executor;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLjava/util/concurrent/Executor;)V", "cleanupRunnable", "Ljava/lang/Runnable;", "closed", "", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", EventBody.KEY_VALUE, "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", IslandSession.REOPEN_VALUE_CLOSE, "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final Companion Companion = null;
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final Regex LEGAL_KEY_PATTERN = null;
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    private boolean closed;
    private final File directory;
    private final Executor executor;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "create", "Lokhttp3/internal/cache/DiskLruCache;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final DiskLruCache create(FileSystem r15, File r16, int r17, int r18, long r19) {
            FileSystem r3 = (FileSystem) ZeusTransformUtils.wrapperContextForParams(r15, FileSystem.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r3, "fileSystem");
            Intrinsics.checkParameterIsNotNull(r16, "directory");
            boolean r2 = false;
            if (r19 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L15;
            if (r18 <= 0) goto L9;
            r2 = true;
        L9:
            if (r2 == false) goto L13;
            return new DiskLruCache(r3, r16, r17, r18, r19, (Executor) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), Util.threadFactory("OkHttp DiskLruCache", true)), Executor.class, "com.obric.memorydata.plugin"));
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("valueCount <= 0".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L15:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("maxSize <= 0".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache r2, Entry r3) {
            Intrinsics.checkParameterIsNotNull(r3, "entry");
            this.this$0 = r2;
            this.entry = r3;
            if (r3.getReadable$okhttp() == false) goto L5;
            boolean[] r4 = null;
        L6:
            this.written = r4;
            return;
        L5:
            r4 = new boolean[r2.getValueCount$okhttp()];
            goto L6
        }

        public final void abort() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L13;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), (Editor) ZeusTransformUtils.preCheckCast(this, Editor.class, "com.obric.memorydata.plugin")) == false) goto L9;
            this.this$0.completeEdit$okhttp(this, false);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        }

        public final void commit() {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L13;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), (Editor) ZeusTransformUtils.preCheckCast(this, Editor.class, "com.obric.memorydata.plugin")) == false) goto L9;
            this.this$0.completeEdit$okhttp(this, true);     // Catch: Throwable -> L14
        L9:
            this.done = true;     // Catch: Throwable -> L14
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        }

        public final void detach$okhttp() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), (Editor) ZeusTransformUtils.preCheckCast(this, Editor.class, "com.obric.memorydata.plugin")) == false) goto L15;
            int r1 = 0;
            int r3 = this.this$0.getValueCount$okhttp();
        L5:
            if (r1 >= r3) goto L8;
            this.this$0.getFileSystem$okhttp().delete((File) ZeusTransformUtils.preCheckCast(this.entry.getDirtyFiles$okhttp().get(r1), File.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L10
        L7:
            r1 = r1 + 1;
            goto L5
        L8:
            this.entry.setCurrentEditor$okhttp((Editor) ZeusTransformUtils.preCheckCast(null, Editor.class, "com.obric.memorydata.plugin"));
            return;
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final Sink newSink(final int r6) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L27:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L26;
            if ((!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), (Editor) ZeusTransformUtils.preCheckCast(this, Editor.class, "com.obric.memorydata.plugin"))) == false) goto L12;
            Sink r5 = Okio.blackhole();     // Catch: Throwable -> L27
            monitor-exit(r0);
            return r5;
        L12:
            if (this.entry.getReadable$okhttp() == true) goto L31;
            boolean[] r1 = this.written;     // Catch: Throwable -> L27
            if (r1 != null) goto L16;
            Intrinsics.throwNpe();     // Catch: Throwable -> L27
        L16:
            r1[r6] = true;     // Catch: Throwable -> L27
        L31:
            Sink r7 = (Sink) ZeusTransformUtils.preCheckCast(new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink((File) ZeusTransformUtils.preCheckCast(this.entry.getDirtyFiles$okhttp().get(r6), File.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, r6), Function1.class, "com.obric.memorydata.plugin")), Sink.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            monitor-exit(r0);
            return r7;
        L24:
            return Okio.blackhole();
        L26:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        }

        public final Source newSource(int r6) {
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if ((!this.done) == false) goto L18;
            Source r2 = null;
            if (this.entry.getReadable$okhttp() == true) goto L10;
        L15:
            monitor-exit(r0);
            return null;
        L10:
            if ((!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), (Editor) ZeusTransformUtils.preCheckCast(this, Editor.class, "com.obric.memorydata.plugin"))) == true) goto L15;
            r2 = this.this$0.getFileSystem$okhttp().source((File) ZeusTransformUtils.preCheckCast(this.entry.getCleanFiles$okhttp().get(r6), File.class, "com.obric.memorydata.plugin"));     // Catch: FileNotFoundException -> L22 Throwable -> L19
        L13:
            monitor-exit(r0);
            return r2;
        L18:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0002J\u001b\u0010)\u001a\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030(H\u0000¢\u0006\u0002\b+J\u0013\u0010,\u001a\b\u0018\u00010-R\u00020\fH\u0000¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b2R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00063"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Ljava/io/File;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "invalidLengths", "Ljava/io/IOException;", "strings", "", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache r9, String r10) {
            Intrinsics.checkParameterIsNotNull(r10, "key");
            this.this$0 = r9;
            this.key = r10;
            this.lengths = new long[r9.getValueCount$okhttp()];
            this.cleanFiles = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.dirtyFiles = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            StringBuilder r11 = new StringBuilder(r10).append('.');
            int r0 = r11.length();
            int r1 = r9.getValueCount$okhttp();
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r11.append(r3);
            ((Collection) ZeusTransformUtils.preCheckCast(this.cleanFiles, Collection.class, "com.obric.memorydata.plugin")).add(new File(r9.getDirectory(), r11.toString()));
            r11.append(".tmp");
            ((Collection) ZeusTransformUtils.preCheckCast(this.dirtyFiles, Collection.class, "com.obric.memorydata.plugin")).add(new File(r9.getDirectory(), r11.toString()));
            r11.setLength(r0);
            r3 = r3 + 1;
            goto L3
        }

        private final IOException invalidLengths(List<String> r4) {
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unexpected journal line: " + ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"))), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setCurrentEditor$okhttp(Editor r1) {
            this.currentEditor = r1;
        }

        public final void setLengths$okhttp(List<String> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r8, "strings");
            if (r8.size() != this.this$0.getValueCount$okhttp()) goto L13;
            int r0 = 0;
            int r2 = ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).size();     // Catch: NumberFormatException -> L10
        L6:
            if (r0 >= r2) goto L9;
            this.lengths[r0] = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r8.get(r0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L6
        L9:
            return;
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(invalidLengths(r8), Throwable.class, "com.obric.memorydata.plugin"));
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(invalidLengths(r8), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void setReadable$okhttp(boolean r1) {
            this.readable = r1;
        }

        public final void setSequenceNumber$okhttp(long r1) {
            this.sequenceNumber = r1;
        }

        public final Snapshot snapshot$okhttp() {
            Thread.holdsLock(this.this$0);
            List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            long[] r9 = (long[]) ZeusTransformUtils.preCheckCast(this.lengths.clone(), long[].class, "com.obric.memorydata.plugin");
            int r1 = 0;
            int r3 = this.this$0.getValueCount$okhttp();     // Catch: FileNotFoundException -> L8
        L4:
            if (r1 >= r3) goto L6;
            ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).add(this.this$0.getFileSystem$okhttp().source((File) ZeusTransformUtils.preCheckCast(this.cleanFiles.get(r1), File.class, "com.obric.memorydata.plugin")));     // Catch: FileNotFoundException -> L8
            r1 = r1 + 1;     // Catch: FileNotFoundException -> L8
            goto L4
        L6:
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, r0, r9);
        L8:
            Iterator r2 = r0.iterator();
        L10:
            if (r2.hasNext() == false) goto L18;
            Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast((Source) ZeusTransformUtils.preCheckCast(r2.next(), Source.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin"));
            goto L10
        L18:
            this.this$0.removeEntry$okhttp(this);     // Catch: IOException -> L15
            return null;
        L21:
            return null;
        }

        public final void writeLengths$okhttp(BufferedSink r6) {
            BufferedSink r7 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSink.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, "writer");
            long[] r5 = this.lengths;
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            long r2 = r5[r1];
            r7.writeByte(32).writeDecimalLong(r2);
            r1 = r1 + 1;
            goto L3
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", IslandSession.REOPEN_VALUE_CLOSE, "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"}, k = 1, mv = {1, 1, 15})
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache r3, String r4, long r5, List<? extends Source> r7, long[] r8) {
            List<Source> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "key");
            Intrinsics.checkParameterIsNotNull(r9, "sources");
            Intrinsics.checkParameterIsNotNull(r8, "lengths");
            this.this$0 = r3;
            this.key = r4;
            this.sequenceNumber = r5;
            this.sources = r9;
            this.lengths = r8;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<Source> r3 = this.sources.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Util.closeQuietly((Closeable) ZeusTransformUtils.preCheckCast((Source) ZeusTransformUtils.preCheckCast(r3.next(), Source.class, "com.obric.memorydata.plugin"), Closeable.class, "com.obric.memorydata.plugin"));
            goto L4
        }

        public final Editor edit() {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int r1) {
            return this.lengths[r1];
        }

        public final Source getSource(int r2) {
            return (Source) ZeusTransformUtils.preCheckCast(this.sources.get(r2), Source.class, "com.obric.memorydata.plugin");
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0002J\r\u0010\u0013\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R'\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012 \u0006*\b\u0018\u00010\u0005R\u00020\u00030\u0005R\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0016"}, d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "getDelegate", "()Ljava/util/Iterator;", "nextSnapshot", "getNextSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "setNextSnapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)V", "removeSnapshot", "getRemoveSnapshot", "setRemoveSnapshot", "hasNext", "", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class AnonymousClass1 implements Iterator<Snapshot>, KMutableIterator {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;
        final /* synthetic */ DiskLruCache this$0;

        AnonymousClass1(DiskLruCache r2) {
            this.this$0 = r2;
            Iterator<Entry> r3 = new ArrayList(r2.getLruEntries$okhttp().values()).iterator();
            Intrinsics.checkExpressionValueIsNotNull(r3, "ArrayList(lruEntries.values).iterator()");
            this.delegate = r3;
        }

        public final Iterator<Entry> getDelegate() {
            return this.delegate;
        }

        public final Snapshot getNextSnapshot() {
            return this.nextSnapshot;
        }

        public final Snapshot getRemoveSnapshot() {
            return this.removeSnapshot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextSnapshot == null) goto L5;
            return true;
        L5:
            DiskLruCache r0 = this.this$0;
            monitor-enter(r0);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.this$0.getClosed$okhttp() == false) goto L13;
            monitor-exit(r0);
            return false;
        L13:
            if (this.delegate.hasNext() == false) goto L24;
            Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(this.delegate.next(), Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
            if (r2 == null) goto L13;
            if (r2.getReadable$okhttp() == false) goto L13;
            Snapshot r3 = r2.snapshot$okhttp();     // Catch: Throwable -> L27
            if (r3 == null) goto L13;
            this.nextSnapshot = r3;     // Catch: Throwable -> L27
            monitor-exit(r0);
            return true;
        L24:
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L27
            monitor-exit(r0);
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Snapshot next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Snapshot next2() {
            if (hasNext() == false) goto L9;
            this.removeSnapshot = this.nextSnapshot;
            this.nextSnapshot = (Snapshot) ZeusTransformUtils.preCheckCast(null, Snapshot.class, "com.obric.memorydata.plugin");
            Snapshot r3 = this.removeSnapshot;
            if (r3 != null) goto L7;
            Intrinsics.throwNpe();
        L7:
            return r3;
        L9:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot r0 = this.removeSnapshot;
            if (r0 == null) goto L13;
            this.this$0.remove(r0.key());     // Catch: Throwable -> L7 IOException -> L14
        L7:
            th = move-exception;
            this.removeSnapshot = (Snapshot) ZeusTransformUtils.preCheckCast(null, Snapshot.class, "com.obric.memorydata.plugin");
            throw th;
        L10:
            this.removeSnapshot = (Snapshot) ZeusTransformUtils.preCheckCast(null, Snapshot.class, "com.obric.memorydata.plugin");
            return;
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("remove() before next()".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void setNextSnapshot(Snapshot r1) {
            this.nextSnapshot = r1;
        }

        public final void setRemoveSnapshot(Snapshot r1) {
            this.removeSnapshot = r1;
        }
    }

    static {
        Companion = new Companion(null);
        JOURNAL_FILE = "journal";
        JOURNAL_FILE_TEMP = "journal.tmp";
        JOURNAL_FILE_BACKUP = "journal.bkp";
        MAGIC = "libcore.io.DiskLruCache";
        VERSION_1 = "1";
        ANY_SEQUENCE_NUMBER = -1;
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
        CLEAN = "CLEAN";
        DIRTY = "DIRTY";
        REMOVE = "REMOVE";
        READ = "READ";
    }

    public DiskLruCache(FileSystem r3, File r4, int r5, int r6, long r7, Executor r9) {
        FileSystem r8 = (FileSystem) ZeusTransformUtils.wrapperContextForParams(r3, FileSystem.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, "fileSystem");
        Intrinsics.checkParameterIsNotNull(r4, "directory");
        Intrinsics.checkParameterIsNotNull(r10, "executor");
        this.fileSystem = r8;
        this.directory = r4;
        this.appVersion = r5;
        this.valueCount = r6;
        this.executor = r10;
        this.maxSize = r7;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupRunnable = (Runnable) ZeusTransformUtils.preCheckCast(new DiskLruCache$cleanupRunnable$1(this), Runnable.class, "com.obric.memorydata.plugin");
        this.journalFile = new File(r4, JOURNAL_FILE);
        this.journalFileTmp = new File(r4, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r4, JOURNAL_FILE_BACKUP);
    }

    public static final /* synthetic */ boolean access$getHasJournalErrors$p(DiskLruCache r0) {
        return r0.hasJournalErrors;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache r0) {
        return r0.initialized;
    }

    public static final /* synthetic */ BufferedSink access$getJournalWriter$p(DiskLruCache r0) {
        return r0.journalWriter;
    }

    public static final /* synthetic */ boolean access$getMostRecentRebuildFailed$p(DiskLruCache r0) {
        return r0.mostRecentRebuildFailed;
    }

    public static final /* synthetic */ boolean access$getMostRecentTrimFailed$p(DiskLruCache r0) {
        return r0.mostRecentTrimFailed;
    }

    public static final /* synthetic */ int access$getRedundantOpCount$p(DiskLruCache r0) {
        return r0.redundantOpCount;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache r0) {
        return r0.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache r0, boolean r1) {
        r0.hasJournalErrors = r1;
    }

    public static final /* synthetic */ void access$setInitialized$p(DiskLruCache r0, boolean r1) {
        r0.initialized = r1;
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache r2, BufferedSink r3) {
        r2.journalWriter = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache r0, boolean r1) {
        r0.mostRecentRebuildFailed = r1;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache r0, boolean r1) {
        r0.mostRecentTrimFailed = r1;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache r0, int r1) {
        r0.redundantOpCount = r1;
    }

    private final synchronized void checkNotClosed() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((!this.closed) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("cache is closed".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = ANY_SEQUENCE_NUMBER;
    L6:
        return r0.edit(r1, r2);
    }

    private final boolean journalRebuildRequired() {
        int r0 = this.redundantOpCount;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.lruEntries.size()) goto L7;
        return true;
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer((Sink) ZeusTransformUtils.preCheckCast(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), (Function1) ZeusTransformUtils.preCheckCast(new DiskLruCache$newJournalWriter$faultHidingSink$1(this), Function1.class, "com.obric.memorydata.plugin")), Sink.class, "com.obric.memorydata.plugin"));
    }

    private final void processJournal() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r0 = this.lruEntries.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Entry r1 = r0.next();
        Intrinsics.checkExpressionValueIsNotNull(r1, "i.next()");
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(r1, Entry.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (r2.getCurrentEditor$okhttp() == null) goto L7;
        r2.setCurrentEditor$okhttp((Editor) ZeusTransformUtils.preCheckCast(null, Editor.class, "com.obric.memorydata.plugin"));
        int r3 = this.valueCount;
    L11:
        if (r4 >= r3) goto L13;
        this.fileSystem.delete((File) ZeusTransformUtils.preCheckCast(r2.getCleanFiles$okhttp().get(r4), File.class, "com.obric.memorydata.plugin"));
        this.fileSystem.delete((File) ZeusTransformUtils.preCheckCast(r2.getDirtyFiles$okhttp().get(r4), File.class, "com.obric.memorydata.plugin"));
        r4 = r4 + 1;
        goto L11
    L13:
        r0.remove();
        goto L4
    L7:
        int r5 = this.valueCount;
    L8:
        if (r4 >= r5) goto L4;
        this.size += r2.getLengths$okhttp()[r4];
        r4 = r4 + 1;
        goto L8
    }

    private final void readJournal() {
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(Okio.buffer(this.fileSystem.source(this.journalFile)), Closeable.class, "com.obric.memorydata.plugin");
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");
        BufferedSource r4 = (BufferedSource) ZeusTransformUtils.preCheckCast(r1, BufferedSource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        String r5 = r4.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r6 = r4.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r7 = r4.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r8 = r4.readUtf8LineStrict();     // Catch: Throwable -> L28
        String r9 = r4.readUtf8LineStrict();     // Catch: Throwable -> L28
        boolean r11 = true;
        if ((!Intrinsics.areEqual(MAGIC, r5)) == true) goto L27;
        if ((!Intrinsics.areEqual(VERSION_1, r6)) == true) goto L27;
        if ((!Intrinsics.areEqual(String.valueOf(this.appVersion), r7)) == true) goto L27;
        if ((!Intrinsics.areEqual(String.valueOf(this.valueCount), r8)) == true) goto L27;
        int r10 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L16;
        r11 = false;
    L16:
        if (r11 == true) goto L27;
    L36:
        readJournalLine(r4.readUtf8LineStrict());     // Catch: EOFException -> L19 Throwable -> L28
        r10 = r10 + 1;
        goto L36
    L19:
        this.redundantOpCount = r10 - this.lruEntries.size();     // Catch: Throwable -> L28
        if (r4.exhausted() == true) goto L22;
        rebuildJournal$okhttp();     // Catch: Throwable -> L28
    L23:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r1, r2);
        return;
    L22:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L28
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unexpected journal header: [" + r5 + ", " + r6 + ", " + r8 + ", " + r9 + ']'), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    private final void readJournalLine(String r15) {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), ' ', 0, false, 6, null);
        if (r0 == (-1)) goto L47;
        int r10 = r0 + 1;
        int r4 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"), ' ', r10, false, 4, null);
        if (r4 != (-1)) goto L15;
        if (r15 == null) goto L14;
        String r11 = r15.substring(r10);
        Intrinsics.checkExpressionValueIsNotNull(r11, "(this as java.lang.String).substring(startIndex)");
        String r12 = REMOVE;
        if (r0 == r12.length()) goto L10;
    L17:
        Entry r13 = (Entry) ZeusTransformUtils.preCheckCast(this.lruEntries.get(r11), Entry.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L20;
        r13 = new Entry(this, r11);
        ((Map) ZeusTransformUtils.preCheckCast(this.lruEntries, Map.class, "com.obric.memorydata.plugin")).put(r11, r13);
    L20:
        if (r4 == (-1)) goto L30;
        String r14 = CLEAN;
        if (r0 != r14.length()) goto L30;
        if (StringsKt.startsWith$default(r15, r14, false, 2, null) == false) goto L30;
        int r5 = r4 + 1;
        if (r15 == null) goto L29;
        String r16 = r15.substring(r5);
        Intrinsics.checkExpressionValueIsNotNull(r16, "(this as java.lang.String).substring(startIndex)");
        List<String> r17 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{' '}, false, 0, 6, null);
        r13.setReadable$okhttp(true);
        r13.setCurrentEditor$okhttp((Editor) ZeusTransformUtils.preCheckCast(null, Editor.class, "com.obric.memorydata.plugin"));
        r13.setLengths$okhttp(r17);
        return;
    L29:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L30:
        if (r4 != (-1)) goto L36;
        String r6 = DIRTY;
        if (r0 != r6.length()) goto L36;
        if (StringsKt.startsWith$default(r15, r6, false, 2, null) == false) goto L36;
        r13.setCurrentEditor$okhttp(new Editor(this, r13));
        return;
    L36:
        if (r4 != (-1)) goto L43;
        String r18 = READ;
        if (r0 != r18.length()) goto L43;
        if (StringsKt.startsWith$default(r15, r18, false, 2, null) == false) goto L43;
        return;
    L43:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unexpected journal line: " + r15), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        if (StringsKt.startsWith$default(r15, r12, false, 2, null) == false) goto L17;
        this.lruEntries.remove(r11);
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L15:
        if (r15 == null) goto L45;
        r11 = r15.substring(r10, r4);
        Intrinsics.checkExpressionValueIsNotNull(r11, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        goto L17
    L45:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L47:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("unexpected journal line: " + r15), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void validateKey(String r3) {
        if (LEGAL_KEY_PATTERN.matches((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return;
    L6:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + Typography.quote).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L27:
        this.closed = true;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L27;
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L30
        Intrinsics.checkExpressionValueIsNotNull(r0, "lruEntries.values");     // Catch: Throwable -> L30
        int r2 = 0;
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L30
        if (r1 == null) goto L26;
        Entry[] r3 = (Entry[]) ZeusTransformUtils.preCheckCast(r1, Entry[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        int r4 = r3.length;     // Catch: Throwable -> L30
    L11:
        if (r2 >= r4) goto L19;
        Entry r5 = r3[r2];     // Catch: Throwable -> L30
        if (r5.getCurrentEditor$okhttp() == null) goto L18;
        Editor r6 = r5.getCurrentEditor$okhttp();     // Catch: Throwable -> L30
        if (r6 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L30
    L17:
        r6.abort();     // Catch: Throwable -> L30
    L18:
        r2 = r2 + 1;     // Catch: Throwable -> L30
        goto L11
    L19:
        trimToSize();     // Catch: Throwable -> L30
        BufferedSink r7 = this.journalWriter;     // Catch: Throwable -> L30
        if (r7 != null) goto L22;
        Intrinsics.throwNpe();     // Catch: Throwable -> L30
    L22:
        r7.close();     // Catch: Throwable -> L30
        this.journalWriter = (BufferedSink) ZeusTransformUtils.preCheckCast(null, BufferedSink.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        this.closed = true;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L26:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L30
    }

    public final synchronized void completeEdit$okhttp(Editor r9, boolean r10) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r9, "editor");     // Catch: Throwable -> L53
        Entry r0 = r9.getEntry$okhttp();     // Catch: Throwable -> L53
        if (Intrinsics.areEqual(r0.getCurrentEditor$okhttp(), r9) == false) goto L52;
        int r1 = 0;
        if (r10 == true) goto L8;
    L24:
        int r11 = this.valueCount;     // Catch: Throwable -> L53
    L25:
        if (r1 >= r11) goto L33;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r0.getDirtyFiles$okhttp().get(r1), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        if (r10 == true) goto L29;
        this.fileSystem.delete(r2);     // Catch: Throwable -> L53
    L32:
        r1 = r1 + 1;     // Catch: Throwable -> L53
        goto L25
    L29:
        if (this.fileSystem.exists(r2) == false) goto L32;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r0.getCleanFiles$okhttp().get(r1), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        this.fileSystem.rename(r2, r3);     // Catch: Throwable -> L53
        long r4 = r0.getLengths$okhttp()[r1];     // Catch: Throwable -> L53
        long r5 = this.fileSystem.size(r3);     // Catch: Throwable -> L53
        r0.getLengths$okhttp()[r1] = r5;     // Catch: Throwable -> L53
        this.size = (this.size - r4) + r5;     // Catch: Throwable -> L53
        goto L32
    L33:
        this.redundantOpCount++;     // Catch: Throwable -> L53
        r0.setCurrentEditor$okhttp((Editor) ZeusTransformUtils.preCheckCast(null, Editor.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
        BufferedSink r12 = this.journalWriter;     // Catch: Throwable -> L53
        if (r12 != null) goto L37;
        Intrinsics.throwNpe();     // Catch: Throwable -> L53
    L37:
        if (r0.getReadable$okhttp() == true) goto L41;
        if (r10 == true) goto L41;
        this.lruEntries.remove(r0.getKey$okhttp());     // Catch: Throwable -> L53
        r12.writeUtf8(REMOVE).writeByte(32);     // Catch: Throwable -> L53
        r12.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L53
        r12.writeByte(10);     // Catch: Throwable -> L53
    L44:
        r12.flush();     // Catch: Throwable -> L53
        if (this.size <= this.maxSize) goto L47;
    L48:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L53
    L49:
        monitor-exit(this);
        return;
    L47:
        if (journalRebuildRequired() == false) goto L49;
    L41:
        r0.setReadable$okhttp(true);     // Catch: Throwable -> L53
        r12.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L53
        r12.writeUtf8(r0.getKey$okhttp());     // Catch: Throwable -> L53
        r0.writeLengths$okhttp(r12);     // Catch: Throwable -> L53
        r12.writeByte(10);     // Catch: Throwable -> L53
        if (r10 == false) goto L44;
        long r6 = this.nextSequenceNumber;     // Catch: Throwable -> L53
        this.nextSequenceNumber = 1 + r6;     // Catch: Throwable -> L53
        r0.setSequenceNumber$okhttp(r6);     // Catch: Throwable -> L53
        goto L44
    L8:
        if (r0.getReadable$okhttp() == true) goto L24;
        int r7 = this.valueCount;     // Catch: Throwable -> L53
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L24;
        boolean[] r13 = r9.getWritten$okhttp();     // Catch: Throwable -> L53
        if (r13 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L53
    L15:
        if (r13[r8] == false) goto L22;
        if (this.fileSystem.exists((File) ZeusTransformUtils.preCheckCast(r0.getDirtyFiles$okhttp().get(r8), File.class, "com.obric.memorydata.plugin")) == false) goto L18;
        r8 = r8 + 1;
        goto L10
    L18:
        r9.abort();     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L22:
        r9.abort();     // Catch: Throwable -> L53
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Newly created entry didn't create value for index " + r8), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
    L52:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    }

    public final void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String r7) {
        return edit$default(this, r7, 0, 2, null);
    }

    public final synchronized Editor edit(String r6, long r7) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r6, "key");     // Catch: Throwable -> L38
        initialize();     // Catch: Throwable -> L38
        checkNotClosed();     // Catch: Throwable -> L38
        validateKey(r6);     // Catch: Throwable -> L38
        Entry r0 = (Entry) ZeusTransformUtils.preCheckCast(this.lruEntries.get(r6), Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r7 == ANY_SEQUENCE_NUMBER) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (r0.getSequenceNumber$okhttp() != r7) goto L9;
    L11:
        if (r0 == null) goto L14;
        Editor r8 = r0.getCurrentEditor$okhttp();     // Catch: Throwable -> L38
    L15:
        if (r8 == null) goto L19;
        monitor-exit(this);
        return null;
    L19:
        if (this.mostRecentTrimFailed == false) goto L21;
    L35:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L38
        monitor-exit(this);
        return null;
    L21:
        if (this.mostRecentRebuildFailed == true) goto L35;
        BufferedSink r9 = this.journalWriter;     // Catch: Throwable -> L38
        if (r9 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Throwable -> L38
    L26:
        r9.writeUtf8(DIRTY).writeByte(32).writeUtf8(r6).writeByte(10);     // Catch: Throwable -> L38
        r9.flush();     // Catch: Throwable -> L38
        if (this.hasJournalErrors == false) goto L30;
        monitor-exit(this);
        return null;
    L30:
        if (r0 != null) goto L32;
        r0 = new Entry(this, r6);     // Catch: Throwable -> L38
        ((Map) ZeusTransformUtils.preCheckCast(this.lruEntries, Map.class, "com.obric.memorydata.plugin")).put(r6, r0);     // Catch: Throwable -> L38
    L32:
        Editor r10 = new Editor(this, r0);     // Catch: Throwable -> L38
        r0.setCurrentEditor$okhttp(r10);     // Catch: Throwable -> L38
        monitor-exit(this);
        return r10;
    L14:
        r8 = null;
    L38:
        th = move-exception;
        throw th;
    }

    public final synchronized void evictAll() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L13
        Collection<Entry> r0 = this.lruEntries.values();     // Catch: Throwable -> L13
        Intrinsics.checkExpressionValueIsNotNull(r0, "lruEntries.values");     // Catch: Throwable -> L13
        Object[] r1 = r0.toArray(new Entry[0]);     // Catch: Throwable -> L13
        if (r1 == null) goto L12;
        Entry[] r2 = (Entry[]) ZeusTransformUtils.preCheckCast(r1, Entry[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        int r3 = r2.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        Entry r5 = r2[r4];     // Catch: Throwable -> L13
        Intrinsics.checkExpressionValueIsNotNull(r5, "entry");     // Catch: Throwable -> L13
        removeEntry$okhttp(r5);     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L6
    L8:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        checkNotClosed();     // Catch: Throwable -> L13
        trimToSize();     // Catch: Throwable -> L13
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L13
        if (r0 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L13
    L10:
        r0.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public final synchronized Snapshot get(String r4) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r4, "key");     // Catch: Throwable -> L23
        initialize();     // Catch: Throwable -> L23
        checkNotClosed();     // Catch: Throwable -> L23
        validateKey(r4);     // Catch: Throwable -> L23
        Entry r0 = (Entry) ZeusTransformUtils.preCheckCast(this.lruEntries.get(r4), Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r0 == null) goto L21;
        Intrinsics.checkExpressionValueIsNotNull(r0, "lruEntries[key] ?: return null");     // Catch: Throwable -> L23
        if (r0.getReadable$okhttp() == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Snapshot r1 = r0.snapshot$okhttp();     // Catch: Throwable -> L23
        if (r1 == null) goto L19;
        this.redundantOpCount++;     // Catch: Throwable -> L23
        BufferedSink r2 = this.journalWriter;     // Catch: Throwable -> L23
        if (r2 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L23
    L14:
        r2.writeUtf8(READ).writeByte(32).writeUtf8(r4).writeByte(10);     // Catch: Throwable -> L23
        if (journalRebuildRequired() == false) goto L17;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L23
    L17:
        monitor-exit(this);
        return r1;
    L19:
        monitor-exit(this);
        return null;
    L21:
        monitor-exit(this);
        return null;
    L23:
        th = move-exception;
        throw th;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        monitor-enter(this);
        long r0 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() {
        monitor-enter(this);
        Thread.holdsLock(this);     // Catch: Throwable -> L30
        if (this.initialized == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.fileSystem.exists(this.journalFileBackup) == false) goto L15;
        if (this.fileSystem.exists(this.journalFile) == false) goto L12;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L30
        goto L15
    L12:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L30
    L15:
        if (this.fileSystem.exists(this.journalFile) == true) goto L34;
    L27:
        rebuildJournal$okhttp();     // Catch: Throwable -> L30
        this.initialized = true;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L34:
        readJournal();     // Catch: IOException -> L19 Throwable -> L30
        processJournal();     // Catch: IOException -> L19 Throwable -> L30
        this.initialized = true;     // Catch: IOException -> L19 Throwable -> L30
        monitor-exit(this);
        return;
    L19:
        e = move-exception;
        Platform.Companion.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L30
        delete();     // Catch: Throwable -> L24
        this.closed = false;     // Catch: Throwable -> L30
        goto L27
    L24:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r0 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void rebuildJournal$okhttp() {
        monitor-enter(this);
        BufferedSink r0 = this.journalWriter;     // Catch: Throwable -> L27
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L27
    L6:
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(Okio.buffer(this.fileSystem.sink(this.journalFileTmp)), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        Throwable r2 = (Throwable) ZeusTransformUtils.preCheckCast(null, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        BufferedSink r3 = (BufferedSink) ZeusTransformUtils.preCheckCast(r1, BufferedSink.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r3.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L22
        r3.writeUtf8(VERSION_1).writeByte(10);     // Catch: Throwable -> L22
        r3.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L22
        r3.writeDecimalLong(this.valueCount).writeByte(10);     // Catch: Throwable -> L22
        r3.writeByte(10);     // Catch: Throwable -> L22
        Iterator<Entry> r4 = this.lruEntries.values().iterator();     // Catch: Throwable -> L22
    L9:
        if (r4.hasNext() == false) goto L15;
        Entry r5 = (Entry) ZeusTransformUtils.preCheckCast(r4.next(), Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r5.getCurrentEditor$okhttp() == null) goto L14;
        r3.writeUtf8(DIRTY).writeByte(32);     // Catch: Throwable -> L22
        r3.writeUtf8(r5.getKey$okhttp());     // Catch: Throwable -> L22
    L13:
        r3.writeByte(10);     // Catch: Throwable -> L22
        goto L9
    L14:
        r3.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L22
        r3.writeUtf8(r5.getKey$okhttp());     // Catch: Throwable -> L22
        r5.writeLengths$okhttp(r3);     // Catch: Throwable -> L22
        goto L13
    L15:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r1, r2);     // Catch: Throwable -> L27
        if (this.fileSystem.exists(this.journalFile) == false) goto L19;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L27
    L19:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L27
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L27
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L27
        this.hasJournalErrors = false;     // Catch: Throwable -> L27
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean remove(String r6) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r6, "key");     // Catch: Throwable -> L14
        initialize();     // Catch: Throwable -> L14
        checkNotClosed();     // Catch: Throwable -> L14
        validateKey(r6);     // Catch: Throwable -> L14
        Entry r7 = (Entry) ZeusTransformUtils.preCheckCast(this.lruEntries.get(r6), Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r7 == null) goto L12;
        Intrinsics.checkExpressionValueIsNotNull(r7, "lruEntries[key] ?: return false");     // Catch: Throwable -> L14
        boolean r8 = removeEntry$okhttp(r7);     // Catch: Throwable -> L14
        if (r8 == true) goto L8;
    L10:
        monitor-exit(this);
        return r8;
    L8:
        if (this.size > this.maxSize) goto L10;
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean removeEntry$okhttp(Entry r7) {
        Intrinsics.checkParameterIsNotNull(r7, "entry");
        Editor r0 = r7.getCurrentEditor$okhttp();
        if (r0 == null) goto L5;
        r0.detach$okhttp();
    L5:
        int r1 = 0;
        int r2 = this.valueCount;
    L6:
        if (r1 >= r2) goto L8;
        this.fileSystem.delete((File) ZeusTransformUtils.preCheckCast(r7.getCleanFiles$okhttp().get(r1), File.class, "com.obric.memorydata.plugin"));
        this.size -= r7.getLengths$okhttp()[r1];
        r7.getLengths$okhttp()[r1] = 0;
        r1 = r1 + 1;
        goto L6
    L8:
        this.redundantOpCount++;
        BufferedSink r3 = this.journalWriter;
        if (r3 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r3.writeUtf8(REMOVE).writeByte(32).writeUtf8(r7.getKey$okhttp()).writeByte(10);
        this.lruEntries.remove(r7.getKey$okhttp());
        if (journalRebuildRequired() == false) goto L14;
        this.executor.execute(this.cleanupRunnable);
    L14:
        return true;
    }

    public final void setClosed$okhttp(boolean r1) {
        this.closed = r1;
    }

    public final synchronized void setMaxSize(long r1) {
        monitor-enter(this);
        this.maxSize = r1;     // Catch: Throwable -> L8
        if (this.initialized == false) goto L6;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized long size() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r0 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Iterator<Snapshot> snapshots() {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        Iterator<Snapshot> r0 = (Iterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Iterator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void trimToSize() {
    L3:
        if (this.size <= this.maxSize) goto L5;
        Entry r0 = this.lruEntries.values().iterator().next();
        Intrinsics.checkExpressionValueIsNotNull(r0, "lruEntries.values.iterator().next()");
        removeEntry$okhttp((Entry) ZeusTransformUtils.preCheckCast(r0, Entry.class, "com.obric.memorydata.plugin"));
        goto L3
    L5:
        this.mostRecentTrimFailed = false;
    }
}
