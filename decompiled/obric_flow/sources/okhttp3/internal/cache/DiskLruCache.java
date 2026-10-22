package okhttp3.internal.cache;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.serval.svg.SVGRenderEngine;
import f4.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import nu.a0;
import nu.c0;
import nu.f;
import nu.k;
import nu.w;
import nu.x;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u000f*\u0001c\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004mnopB9\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u001e\u0010\u0018\u001a\b\u0018\u00010\u0017R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010%\u001a\u00020\u00102\n\u0010 \u001a\u00060\u001bR\u00020\u00002\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J\u001b\u0010,\u001a\u00020!2\n\u0010)\u001a\u00060(R\u00020\u0000H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0010H\u0016¢\u0006\u0004\b-\u0010\u0012J\r\u0010.\u001a\u00020!¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u0012J\r\u00101\u001a\u00020\u0010¢\u0006\u0004\b1\u0010\u0012J\r\u00102\u001a\u00020\u0010¢\u0006\u0004\b2\u0010\u0012J\r\u00103\u001a\u00020\u0010¢\u0006\u0004\b3\u0010\u0012J\u0017\u00105\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u000004¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0010H\u0002¢\u0006\u0004\b7\u0010\u0012J\u000f\u00109\u001a\u000208H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0010H\u0002¢\u0006\u0004\b>\u0010\u0012J\u000f\u0010?\u001a\u00020!H\u0002¢\u0006\u0004\b?\u0010/J\u000f\u0010@\u001a\u00020\u0010H\u0002¢\u0006\u0004\b@\u0010\u0012J\u000f\u0010A\u001a\u00020!H\u0002¢\u0006\u0004\bA\u0010/J\u0017\u0010B\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\bB\u0010=R*\u0010\u000b\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010D\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010IR\u0014\u0010K\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010DR\u0018\u0010L\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR*\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u00060(R\u00020\u00000N8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010X\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010VR\"\u0010Y\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010/\"\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010VR\u0016\u0010^\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010VR\u0016\u0010_\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010DR\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010f\u001a\u0004\bg\u0010hR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010I\u001a\u0004\bi\u0010jR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010TR\u001a\u0010\t\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010T\u001a\u0004\bk\u0010l¨\u0006q"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Ljava/io/File;", "directory", "", "appVersion", "valueCount", "", "maxSize", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "", "initialize", "()V", "rebuildJournal$okhttp", "rebuildJournal", "", STGroup.DICT_KEY, "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "", "success", "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "()Z", "close", "trimToSize", Constant.ClientMessageType.DELETE, "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "readJournal", "Lnu/k;", "newJournalWriter", "()Lnu/k;", SVGRenderEngine.LINE, "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "journalRebuildRequired", "checkNotClosed", "removeOldestEntry", "validateKey", "value", "J", "getMaxSize", "setMaxSize", "(J)V", "journalFile", "Ljava/io/File;", "journalFileTmp", "journalFileBackup", "journalWriter", "Lnu/k;", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "redundantOpCount", "I", "hasJournalErrors", "Z", "civilizedFileSystem", "initialized", "closed", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "mostRecentTrimFailed", "mostRecentRebuildFailed", "nextSequenceNumber", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "getDirectory", "()Ljava/io/File;", "getValueCount$okhttp", "()I", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class DiskLruCache implements Closeable, Flushable {

    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = 0;

    @JvmField
    public static final String CLEAN = null;
    public static final Companion Companion = null;

    @JvmField
    public static final String DIRTY = null;

    @JvmField
    public static final String JOURNAL_FILE = null;

    @JvmField
    public static final String JOURNAL_FILE_BACKUP = null;

    @JvmField
    public static final String JOURNAL_FILE_TEMP = null;

    @JvmField
    public static final Regex LEGAL_KEY_PATTERN = null;

    @JvmField
    public static final String MAGIC = null;

    @JvmField
    public static final String READ = null;

    @JvmField
    public static final String REMOVE = null;

    @JvmField
    public static final String VERSION_1 = null;
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private k journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "", "detach$okhttp", "()V", "detach", "", "index", "Lnu/c0;", "newSource", "(I)Lnu/c0;", "Lnu/a0;", "newSink", "(I)Lnu/a0;", "commit", "abort", "", "written", "[Z", "getWritten$okhttp", "()[Z", "", "done", "Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache r5, Entry r10) {
            Intrinsics.checkNotNullParameter(r10, "entry");
            this.this$0 = r5;
            this.entry = r10;
            if (r10.getReadable$okhttp() == false) goto L5;
            boolean[] r11 = null;
        L6:
            this.written = r11;
            return;
        L5:
            r11 = new boolean[r5.getValueCount$okhttp()];
            goto L6
        }

        public final void abort() throws IOException {
            DiskLruCache r5 = this.this$0;
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L15;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == false) goto L11;
            this.this$0.completeEdit$okhttp(this, false);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r5);
            return;
        L15:
            throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L9
        }

        public final void commit() throws IOException {
            DiskLruCache r5 = this.this$0;
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L15;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == false) goto L11;
            this.this$0.completeEdit$okhttp(this, true);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r5);
            return;
        L15:
            throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L9
        }

        public final void detach$okhttp() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == true) goto L5;
            return;
        L5:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L7;
            this.this$0.completeEdit$okhttp(this, false);
            return;
        L7:
            this.entry.setZombie$okhttp(true);
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final a0 newSink(final int r5) {
            DiskLruCache r10 = this.this$0;
            monitor-enter(r10);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L25;
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == true) goto L12;
            f r11 = new f();     // Catch: Throwable -> L14
            monitor-exit(r10);
            return r11;
        L12:
            if (this.entry.getReadable$okhttp() == true) goto L16;
            boolean[] r12 = this.written;     // Catch: Throwable -> L14
            Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L14
            r12[r5] = true;     // Catch: Throwable -> L14
        L16:
            File r13 = this.entry.getDirtyFiles$okhttp().get(r5);     // Catch: Throwable -> L14
            a0 r14 = this.this$0.getFileSystem$okhttp().sink(r13);     // Catch: Throwable -> L14 FileNotFoundException -> L21
            FaultHidingSink r15 = new FaultHidingSink(r14, new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, r5));     // Catch: Throwable -> L14
            monitor-exit(r10);
            return r15;
        L23:
            return new f();
        L25:
            throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L14
        }

        public final c0 newSource(int r5) {
            DiskLruCache r10 = this.this$0;
            monitor-enter(r10);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L22;
            c0 r11 = null;
            if (this.entry.getReadable$okhttp() == true) goto L9;
        L19:
            monitor-exit(r10);
            return null;
        L9:
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) == false) goto L19;
            if (this.entry.getZombie$okhttp() == true) goto L19;
            r11 = this.this$0.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(r5));     // Catch: Throwable -> L15 FileNotFoundException -> L25
        L17:
            monitor-exit(r10);
            return r11;
        L22:
            throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L15
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001d\u001a\b\u0018\u00010\u0019R\u00020\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\"\u0010,\u001a\u00020+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R(\u00106\u001a\b\u0018\u000105R\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010I\u001a\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", STGroup.DICT_KEY, "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "", "strings", "", "invalidLengths", "(Ljava/util/List;)Ljava/lang/Void;", "", "index", "Lnu/c0;", "newSource", "(I)Lnu/c0;", "", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Lnu/k;", "writer", "writeLengths$okhttp", "(Lnu/k;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "", "lengths", "[J", "getLengths$okhttp", "()[J", "", "Ljava/io/File;", "cleanFiles", "Ljava/util/List;", "getCleanFiles$okhttp", "()Ljava/util/List;", "dirtyFiles", "getDirtyFiles$okhttp", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "lockingSourceCount", "I", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, STGroup.DICT_KEY);
            this.this$0 = r10;
            this.key = r11;
            this.lengths = new long[r10.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder r5 = new StringBuilder(r11);
            r5.append('.');
            int r12 = r5.length();
            int r13 = r10.getValueCount$okhttp();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r5.append(r14);
            this.cleanFiles.add(new File(r10.getDirectory(), r5.toString()));
            r5.append(".tmp");
            this.dirtyFiles.add(new File(r10.getDirectory(), r5.toString()));
            r5.setLength(r12);
            r14 = r14 + 1;
            goto L3
        }

        private final Void invalidLengths(List<String> r5) throws IOException {
            throw new IOException("unexpected journal line: " + r5);
        }

        private final c0 newSource(int r5) {
            final c0 r10 = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(r5));
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L5;
            return r10;
        L5:
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(this, r10, r10);
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

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor r5) {
            this.currentEditor = r5;
        }

        public final void setLengths$okhttp(List<String> r10) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "strings");
            if (r10.size() == this.this$0.getValueCount$okhttp()) goto L13;
            invalidLengths(r10);
            throw new KotlinNothingValueException();
        L13:
            int r5 = r10.size();     // Catch: NumberFormatException -> L9
            int r11 = 0;
        L5:
            if (r11 >= r5) goto L8;
            this.lengths[r11] = Long.parseLong(r10.get(r11));     // Catch: NumberFormatException -> L9
            r11 = r11 + 1;
            goto L5
        L8:
            return;
        L9:
            invalidLengths(r10);
            throw new KotlinNothingValueException();
        }

        public final void setLockingSourceCount$okhttp(int r5) {
            this.lockingSourceCount = r5;
        }

        public final void setReadable$okhttp(boolean r5) {
            this.readable = r5;
        }

        public final void setSequenceNumber$okhttp(long r5) {
            this.sequenceNumber = r5;
        }

        public final void setZombie$okhttp(boolean r5) {
            this.zombie = r5;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache r5 = this.this$0;
            if (Util.assertionsEnabled == false) goto L10;
            if (Thread.holdsLock(r5) == true) goto L10;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r5);
        L10:
            if (this.readable == true) goto L13;
            return null;
        L13:
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == false) goto L15;
        L19:
            ArrayList r10 = new ArrayList();
            long[] r11 = (long[]) this.lengths.clone();
            int r12 = this.this$0.getValueCount$okhttp();     // Catch: FileNotFoundException -> L25
            int r13 = 0;
        L21:
            if (r13 >= r12) goto L23;
            r10.add(newSource(r13));     // Catch: FileNotFoundException -> L25
            r13 = r13 + 1;     // Catch: FileNotFoundException -> L25
            goto L21
        L23:
            return new Snapshot(this.this$0, this.key, this.sequenceNumber, r10, r11);
        L25:
            Iterator r14 = r10.iterator();
        L27:
            if (r14.hasNext() == false) goto L32;
            Util.closeQuietly((c0) r14.next());
            goto L27
        L32:
            this.this$0.removeEntry$okhttp(this);     // Catch: IOException -> L31
        L30:
            return null;
        L15:
            if (this.currentEditor == null) goto L17;
        L18:
            return null;
        L17:
            if (this.zombie == false) goto L19;
            goto L18
        }

        public final void writeLengths$okhttp(k r10) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "writer");
            long[] r5 = this.lengths;
            int r11 = r5.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            long r13 = r5[r12];
            r10.writeByte(32).t(r13);
            r12 = r12 + 1;
            goto L3
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u0013\u0010\u0010\u001a\b\u0018\u00010\u000eR\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001e¨\u0006\u001f"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", STGroup.DICT_KEY, "", "sequenceNumber", "", "Lnu/c0;", "sources", "", "lengths", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "index", "getSource", "(I)Lnu/c0;", "getLength", "(I)J", "", "close", "()V", "Ljava/lang/String;", "J", "Ljava/util/List;", "[J", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<c0> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache r5, String r10, long r11, List<? extends c0> r12, long[] r13) {
            Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
            Intrinsics.checkNotNullParameter(r12, "sources");
            Intrinsics.checkNotNullParameter(r13, "lengths");
            this.this$0 = r5;
            this.key = r10;
            this.sequenceNumber = r11;
            this.sources = r12;
            this.lengths = r13;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<c0> r5 = this.sources.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Util.closeQuietly(r5.next());
            goto L4
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int r5) {
            return this.lengths[r5];
        }

        public final c0 getSource(int r5) {
            return this.sources.get(r5);
        }

        public final String key() {
            return this.key;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\r\u0010\u000b\u001a\u00060\u0002R\u00020\u0003H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R$\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012 \u0006*\b\u0018\u00010\u0005R\u00020\u00030\u0005R\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\u0002R\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"okhttp3/internal/cache/DiskLruCache$snapshots$1", "", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "delegate", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "kotlin.jvm.PlatformType", "nextSnapshot", "removeSnapshot", "hasNext", "", "next", "remove", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 implements Iterator<Snapshot>, KMutableIterator {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;
        final /* synthetic */ DiskLruCache this$0;

        public AnonymousClass1(DiskLruCache r5) {
            this.this$0 = r5;
            this.delegate = new ArrayList(r5.getLruEntries$okhttp().values()).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextSnapshot == null) goto L5;
            return true;
        L5:
            DiskLruCache r5 = this.this$0;
            monitor-enter(r5);
        L21:
            th = move-exception;
            throw th;
        L9:
            if (this.this$0.getClosed$okhttp() == false) goto L13;
            monitor-exit(r5);
            return false;
        L13:
            if (this.delegate.hasNext() == false) goto L23;
            Entry r10 = this.delegate.next();     // Catch: Throwable -> L21
            if (r10 == null) goto L13;
            Snapshot r11 = r10.snapshot$okhttp();     // Catch: Throwable -> L21
            if (r11 == null) goto L13;
            this.nextSnapshot = r11;     // Catch: Throwable -> L21
            monitor-exit(r5);
            return true;
        L23:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r5);
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Snapshot next() {
            return next2();
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot r5 = this.removeSnapshot;
            if (r5 == null) goto L12;
            this.this$0.remove(r5.key());     // Catch: IOException -> L13 Throwable -> L7
        L7:
            th = move-exception;
            this.removeSnapshot = null;
            throw th;
        L6:
            this.removeSnapshot = null;
            return;
        L12:
            throw new IllegalStateException("remove() before next()");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Snapshot next2() {
            if (hasNext() == false) goto L7;
            Snapshot r5 = this.nextSnapshot;
            this.removeSnapshot = r5;
            this.nextSnapshot = null;
            Intrinsics.checkNotNull(r5);
            return r5;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new Companion(null);
        JOURNAL_FILE = "journal";
        JOURNAL_FILE_TEMP = "journal.tmp";
        JOURNAL_FILE_BACKUP = "journal.bkp";
        MAGIC = "libcore.io.DiskLruCache";
        VERSION_1 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        ANY_SEQUENCE_NUMBER = -1;
        LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
        CLEAN = "CLEAN";
        DIRTY = "DIRTY";
        REMOVE = "REMOVE";
        READ = "READ";
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem r5, File r10, int r11, int r12, long r13, TaskRunner r14) {
        Intrinsics.checkNotNullParameter(r5, "fileSystem");
        Intrinsics.checkNotNullParameter(r10, "directory");
        Intrinsics.checkNotNullParameter(r14, "taskRunner");
        this.fileSystem = r5;
        this.directory = r10;
        this.appVersion = r11;
        this.valueCount = r12;
        this.maxSize = r13;
        boolean r15 = false;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupQueue = r14.newQueue();
        final String r16 = j0.q(new StringBuilder(), Util.okHttpName, " Cache");
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, r16);
        if (r13 <= 0) goto L5;
        boolean r17 = true;
    L6:
        if (r17 == false) goto L15;
        if (r12 <= 0) goto L9;
        r15 = true;
    L9:
        if (r15 == false) goto L13;
        this.journalFile = new File(r10, JOURNAL_FILE);
        this.journalFileTmp = new File(r10, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r10, JOURNAL_FILE_BACKUP);
        return;
    L13:
        throw new IllegalArgumentException("valueCount <= 0");
    L15:
        throw new IllegalArgumentException("maxSize <= 0");
    L5:
        r17 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$getCivilizedFileSystem$p(DiskLruCache r5) {
        return r5.civilizedFileSystem;
    }

    public static final /* synthetic */ boolean access$getHasJournalErrors$p(DiskLruCache r5) {
        return r5.hasJournalErrors;
    }

    public static final /* synthetic */ boolean access$getInitialized$p(DiskLruCache r5) {
        return r5.initialized;
    }

    public static final /* synthetic */ k access$getJournalWriter$p(DiskLruCache r5) {
        return r5.journalWriter;
    }

    public static final /* synthetic */ boolean access$getMostRecentRebuildFailed$p(DiskLruCache r5) {
        return r5.mostRecentRebuildFailed;
    }

    public static final /* synthetic */ boolean access$getMostRecentTrimFailed$p(DiskLruCache r5) {
        return r5.mostRecentTrimFailed;
    }

    public static final /* synthetic */ int access$getRedundantOpCount$p(DiskLruCache r5) {
        return r5.redundantOpCount;
    }

    public static final /* synthetic */ boolean access$journalRebuildRequired(DiskLruCache r5) {
        return r5.journalRebuildRequired();
    }

    public static final /* synthetic */ void access$setCivilizedFileSystem$p(DiskLruCache r5, boolean r10) {
        r5.civilizedFileSystem = r10;
    }

    public static final /* synthetic */ void access$setHasJournalErrors$p(DiskLruCache r5, boolean r10) {
        r5.hasJournalErrors = r10;
    }

    public static final /* synthetic */ void access$setInitialized$p(DiskLruCache r5, boolean r10) {
        r5.initialized = r10;
    }

    public static final /* synthetic */ void access$setJournalWriter$p(DiskLruCache r5, k r10) {
        r5.journalWriter = r10;
    }

    public static final /* synthetic */ void access$setMostRecentRebuildFailed$p(DiskLruCache r5, boolean r10) {
        r5.mostRecentRebuildFailed = r10;
    }

    public static final /* synthetic */ void access$setMostRecentTrimFailed$p(DiskLruCache r5, boolean r10) {
        r5.mostRecentTrimFailed = r10;
    }

    public static final /* synthetic */ void access$setRedundantOpCount$p(DiskLruCache r5, int r10) {
        r5.redundantOpCount = r10;
    }

    private final synchronized void checkNotClosed() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.closed == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L9
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache r5, String r10, long r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L6;
        r11 = ANY_SEQUENCE_NUMBER;
    L6:
        return r5.edit(r10, r11);
    }

    private final boolean journalRebuildRequired() {
        int r5 = this.redundantOpCount;
        if (r5 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r5 < this.lruEntries.size()) goto L7;
        return true;
    }

    private final k newJournalWriter() throws FileNotFoundException {
        return b.d(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r5 = this.lruEntries.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Entry r10 = r5.next();
        int r11 = 0;
        if (r10.getCurrentEditor$okhttp() == null) goto L7;
        r10.setCurrentEditor$okhttp(null);
        int r12 = this.valueCount;
    L11:
        if (r11 >= r12) goto L13;
        this.fileSystem.delete(r10.getCleanFiles$okhttp().get(r11));
        this.fileSystem.delete(r10.getDirtyFiles$okhttp().get(r11));
        r11 = r11 + 1;
        goto L11
    L13:
        r5.remove();
        goto L4
    L7:
        int r13 = this.valueCount;
    L8:
        if (r11 >= r13) goto L4;
        this.size += r10.getLengths$okhttp()[r11];
        r11 = r11 + 1;
        goto L8
    }

    private final void readJournal() throws IOException {
        x r5 = b.e(this.fileSystem.source(this.journalFile));
        String r10 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L16
        String r11 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L16
        String r12 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L16
        String r13 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L16
        String r14 = r5.c(Long.MAX_VALUE);     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(MAGIC, r10) == false) goto L26;
        if (Intrinsics.areEqual(VERSION_1, r11) == false) goto L26;
        if (Intrinsics.areEqual(String.valueOf(this.appVersion), r12) == false) goto L26;
        if (Intrinsics.areEqual(String.valueOf(this.valueCount), r13) == false) goto L26;
        if (r14.length() > 0) goto L26;
        int r15 = 0;
    L32:
        readJournalLine(r5.c(Long.MAX_VALUE));     // Catch: Throwable -> L16 EOFException -> L18
        r15 = r15 + 1;
        goto L32
    L18:
        this.redundantOpCount = r15 - this.lruEntries.size();     // Catch: Throwable -> L16
        if (r5.y() == true) goto L21;
        rebuildJournal$okhttp();     // Catch: Throwable -> L16
    L22:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r5, null);
        return;
    L21:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L16
    L26:
        throw new IOException("unexpected journal header: [" + r10 + ", " + r11 + ", " + r13 + ", " + r14 + ']');     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }

    private final void readJournalLine(String r13) throws IOException {
        int r5 = StringsKt.q(r13, ' ', 0, 6);
        if (r5 == (-1)) goto L47;
        int r10 = r5 + 1;
        int r11 = StringsKt.q(r13, ' ', r10, 4);
        if (r11 != (-1)) goto L15;
        if (r13 == null) goto L14;
        String r12 = r13.substring(r10);
        String r14 = REMOVE;
        if (r5 == r14.length()) goto L10;
    L17:
        Entry r15 = this.lruEntries.get(r12);
        if (r15 != null) goto L20;
        r15 = new Entry(this, r12);
        this.lruEntries.put(r12, r15);
    L20:
        if (r11 == (-1)) goto L30;
        String r16 = CLEAN;
        if (r5 != r16.length()) goto L30;
        if (StringsKt.P(r13, r16) == false) goto L30;
        int r17 = r11 + 1;
        if (r13 == null) goto L29;
        List<String> r18 = StringsKt.J(r13.substring(r17), new char[]{' '}, 0, 6);
        r15.setReadable$okhttp(true);
        r15.setCurrentEditor$okhttp(null);
        r15.setLengths$okhttp(r18);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L30:
        if (r11 != (-1)) goto L36;
        String r19 = DIRTY;
        if (r5 != r19.length()) goto L36;
        if (StringsKt.P(r13, r19) == false) goto L36;
        r15.setCurrentEditor$okhttp(new Editor(this, r15));
        return;
    L36:
        if (r11 != (-1)) goto L43;
        String r110 = READ;
        if (r5 != r110.length()) goto L43;
        if (StringsKt.P(r13, r110) == false) goto L43;
        return;
    L43:
        throw new IOException(j0.C("unexpected journal line: ", r13));
    L10:
        if (StringsKt.P(r13, r14) == false) goto L17;
        this.lruEntries.remove(r12);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L15:
        if (r13 == null) goto L45;
        r12 = r13.substring(r10, r11);
        goto L17
    L45:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L47:
        throw new IOException(j0.C("unexpected journal line: ", r13));
    }

    private final boolean removeOldestEntry() {
        Iterator<Entry> r5 = this.lruEntries.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Entry r10 = r5.next();
        if (r10.getZombie$okhttp() == true) goto L4;
        removeEntry$okhttp(r10);
        return true;
    L9:
        return false;
    }

    private final void validateKey(String r5) {
        if (LEGAL_KEY_PATTERN.matches(r5) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(a.p("keys must match regex [a-z0-9_-]{1,120}: \"", Typography.quote, r5).toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L25:
        this.closed = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L25;
        int r5 = 0;
        Object[] r10 = this.lruEntries.values().toArray(new Entry[0]);     // Catch: Throwable -> L17
        if (r10 == null) goto L24;
        Entry[] r11 = (Entry[]) r10;     // Catch: Throwable -> L17
        int r12 = r11.length;     // Catch: Throwable -> L17
    L11:
        if (r5 >= r12) goto L20;
        Entry r13 = r11[r5];     // Catch: Throwable -> L17
        if (r13.getCurrentEditor$okhttp() == null) goto L19;
        Editor r14 = r13.getCurrentEditor$okhttp();     // Catch: Throwable -> L17
        if (r14 == null) goto L19;
        r14.detach$okhttp();     // Catch: Throwable -> L17
    L19:
        r5 = r5 + 1;     // Catch: Throwable -> L17
        goto L11
    L20:
        trimToSize();     // Catch: Throwable -> L17
        k r15 = this.journalWriter;     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L17
        r15.close();     // Catch: Throwable -> L17
        this.journalWriter = null;     // Catch: Throwable -> L17
        this.closed = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L17
    }

    public final synchronized void completeEdit$okhttp(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "editor");     // Catch: Throwable -> L18
        Entry r5 = r10.getEntry$okhttp();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r5.getCurrentEditor$okhttp(), r10) == false) goto L55;
        int r12 = 0;
        if (r11 == true) goto L8;
    L23:
        int r13 = this.valueCount;     // Catch: Throwable -> L18
    L24:
        if (r12 >= r13) goto L34;
        File r14 = r5.getDirtyFiles$okhttp().get(r12);     // Catch: Throwable -> L18
        if (r11 == true) goto L28;
    L32:
        this.fileSystem.delete(r14);     // Catch: Throwable -> L18
    L33:
        r12 = r12 + 1;     // Catch: Throwable -> L18
        goto L24
    L28:
        if (r5.getZombie$okhttp() == true) goto L32;
        if (this.fileSystem.exists(r14) == false) goto L33;
        File r15 = r5.getCleanFiles$okhttp().get(r12);     // Catch: Throwable -> L18
        this.fileSystem.rename(r14, r15);     // Catch: Throwable -> L18
        long r16 = r5.getLengths$okhttp()[r12];     // Catch: Throwable -> L18
        long r17 = this.fileSystem.size(r15);     // Catch: Throwable -> L18
        r5.getLengths$okhttp()[r12] = r17;     // Catch: Throwable -> L18
        this.size = (this.size - r16) + r17;     // Catch: Throwable -> L18
        goto L33
    L34:
        r5.setCurrentEditor$okhttp(null);     // Catch: Throwable -> L18
        if (r5.getZombie$okhttp() == false) goto L39;
        removeEntry$okhttp(r5);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L39:
        this.redundantOpCount++;     // Catch: Throwable -> L18
        k r18 = this.journalWriter;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L18
        if (r5.getReadable$okhttp() == true) goto L44;
        if (r11 == true) goto L44;
        this.lruEntries.remove(r5.getKey$okhttp());     // Catch: Throwable -> L18
        r18.l(REMOVE).writeByte(32);     // Catch: Throwable -> L18
        r18.l(r5.getKey$okhttp());     // Catch: Throwable -> L18
        r18.writeByte(10);     // Catch: Throwable -> L18
    L47:
        r18.flush();     // Catch: Throwable -> L18
        if (this.size <= this.maxSize) goto L50;
    L51:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L18
    L52:
        monitor-exit(this);
        return;
    L50:
        if (journalRebuildRequired() == false) goto L52;
    L44:
        r5.setReadable$okhttp(true);     // Catch: Throwable -> L18
        r18.l(CLEAN).writeByte(32);     // Catch: Throwable -> L18
        r18.l(r5.getKey$okhttp());     // Catch: Throwable -> L18
        r5.writeLengths$okhttp(r18);     // Catch: Throwable -> L18
        r18.writeByte(10);     // Catch: Throwable -> L18
        if (r11 == false) goto L47;
        long r19 = this.nextSequenceNumber;     // Catch: Throwable -> L18
        this.nextSequenceNumber = 1 + r19;     // Catch: Throwable -> L18
        r5.setSequenceNumber$okhttp(r19);     // Catch: Throwable -> L18
        goto L47
    L8:
        if (r5.getReadable$okhttp() == true) goto L23;
        int r20 = this.valueCount;     // Catch: Throwable -> L18
        int r21 = 0;
    L10:
        if (r21 >= r20) goto L23;
        boolean[] r22 = r10.getWritten$okhttp();     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L18
        if (r22[r21] == false) goto L21;
        if (this.fileSystem.exists(r5.getDirtyFiles$okhttp().get(r21)) == false) goto L15;
        r21 = r21 + 1;
        goto L10
    L15:
        r10.abort();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L21:
        r10.abort();     // Catch: Throwable -> L18
        throw new IllegalStateException("Newly created entry didn't create value for index " + r21);     // Catch: Throwable -> L18
    L55:
        throw new IllegalStateException("Check failed.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @JvmOverloads
    public final Editor edit(String r10) throws IOException {
        return edit$default(this, r10, 0, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L8
        Object[] r5 = this.lruEntries.values().toArray(new Entry[0]);     // Catch: Throwable -> L8
        if (r5 == null) goto L14;
        Entry[] r10 = (Entry[]) r5;     // Catch: Throwable -> L8
        int r11 = r10.length;     // Catch: Throwable -> L8
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L10;
        removeEntry$okhttp(r10[r12]);     // Catch: Throwable -> L8
        r12 = r12 + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        checkNotClosed();     // Catch: Throwable -> L10
        trimToSize();     // Catch: Throwable -> L10
        k r5 = this.journalWriter;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L10
        r5.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized Snapshot get(String r10) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);     // Catch: Throwable -> L11
        initialize();     // Catch: Throwable -> L11
        checkNotClosed();     // Catch: Throwable -> L11
        validateKey(r10);     // Catch: Throwable -> L11
        Entry r5 = this.lruEntries.get(r10);     // Catch: Throwable -> L11
        if (r5 == null) goto L17;
        Snapshot r11 = r5.snapshot$okhttp();     // Catch: Throwable -> L11
        if (r11 == null) goto L15;
        this.redundantOpCount++;     // Catch: Throwable -> L11
        k r12 = this.journalWriter;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        r12.l(READ).writeByte(32).l(r10).writeByte(10);     // Catch: Throwable -> L11
        if (journalRebuildRequired() == false) goto L13;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return r11;
    L15:
        monitor-exit(this);
        return null;
    L17:
        monitor-exit(this);
        return null;
    L11:
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
        long r5 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Util.assertionsEnabled == false) goto L14;
        if (Thread.holdsLock(this) == true) goto L14;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);     // Catch: Throwable -> L11
    L14:
        if (this.initialized == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (this.fileSystem.exists(this.journalFileBackup) == true) goto L20;
    L23:
        this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);     // Catch: Throwable -> L11
        if (this.fileSystem.exists(this.journalFile) == true) goto L45;
    L37:
        rebuildJournal$okhttp();     // Catch: Throwable -> L11
        this.initialized = true;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L45:
        readJournal();     // Catch: Throwable -> L11 IOException -> L29
        processJournal();     // Catch: Throwable -> L11 IOException -> L29
        this.initialized = true;     // Catch: Throwable -> L11 IOException -> L29
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);     // Catch: Throwable -> L11
        delete();     // Catch: Throwable -> L34
        this.closed = false;     // Catch: Throwable -> L11
        goto L37
    L34:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L20:
        if (this.fileSystem.exists(this.journalFile) == false) goto L22;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L11
        goto L23
    L22:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L11
        goto L23
    }

    public final synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r5 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        monitor-enter(this);
        k r5 = this.journalWriter;     // Catch: Throwable -> L6
        if (r5 == null) goto L8;
        r5.close();     // Catch: Throwable -> L6
    L8:
        w r10 = b.d(this.fileSystem.sink(this.journalFileTmp));     // Catch: Throwable -> L6
        r10.l(MAGIC);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        r10.l(VERSION_1);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        r10.t(this.appVersion);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        r10.t(this.valueCount);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        Iterator<Entry> r11 = this.lruEntries.values().iterator();     // Catch: Throwable -> L15
    L11:
        if (r11.hasNext() == false) goto L18;
        Entry r12 = r11.next();     // Catch: Throwable -> L15
        if (r12.getCurrentEditor$okhttp() != null) goto L14;
        r10.l(CLEAN);     // Catch: Throwable -> L15
        r10.writeByte(32);     // Catch: Throwable -> L15
        r10.l(r12.getKey$okhttp());     // Catch: Throwable -> L15
        r12.writeLengths$okhttp(r10);     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        goto L11
    L14:
        r10.l(DIRTY);     // Catch: Throwable -> L15
        r10.writeByte(32);     // Catch: Throwable -> L15
        r10.l(r12.getKey$okhttp());     // Catch: Throwable -> L15
        r10.writeByte(10);     // Catch: Throwable -> L15
        goto L11
    L18:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L20:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L6
        if (this.fileSystem.exists(this.journalFile) == false) goto L23;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L6
    L23:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L6
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L6
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L6
        this.hasJournalErrors = false;     // Catch: Throwable -> L6
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean remove(String r10) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);     // Catch: Throwable -> L11
        initialize();     // Catch: Throwable -> L11
        checkNotClosed();     // Catch: Throwable -> L11
        validateKey(r10);     // Catch: Throwable -> L11
        Entry r11 = this.lruEntries.get(r10);     // Catch: Throwable -> L11
        if (r11 == null) goto L15;
        boolean r12 = removeEntry$okhttp(r11);     // Catch: Throwable -> L11
        if (r12 == true) goto L8;
    L13:
        monitor-exit(this);
        return r12;
    L8:
        if (this.size > this.maxSize) goto L13;
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L11
        goto L13
    L15:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean removeEntry$okhttp(Entry r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "entry");
        if (this.civilizedFileSystem == false) goto L5;
    L15:
        Editor r5 = r11.getCurrentEditor$okhttp();
        if (r5 == null) goto L18;
        r5.detach$okhttp();
    L18:
        int r10 = this.valueCount;
        int r12 = 0;
    L19:
        if (r12 >= r10) goto L21;
        this.fileSystem.delete(r11.getCleanFiles$okhttp().get(r12));
        this.size -= r11.getLengths$okhttp()[r12];
        r11.getLengths$okhttp()[r12] = 0;
        r12 = r12 + 1;
        goto L19
    L21:
        this.redundantOpCount++;
        k r13 = this.journalWriter;
        if (r13 == null) goto L24;
        r13.l(REMOVE);
        r13.writeByte(32);
        r13.l(r11.getKey$okhttp());
        r13.writeByte(10);
    L24:
        this.lruEntries.remove(r11.getKey$okhttp());
        if (journalRebuildRequired() == false) goto L27;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
    L27:
        return true;
    L5:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L10;
        k r14 = this.journalWriter;
        if (r14 == null) goto L10;
        r14.l(DIRTY);
        r14.writeByte(32);
        r14.l(r11.getKey$okhttp());
        r14.writeByte(10);
        r14.flush();
    L10:
        if (r11.getLockingSourceCount$okhttp() <= 0) goto L12;
    L13:
        r11.setZombie$okhttp(true);
        return true;
    L12:
        if (r11.getCurrentEditor$okhttp() == null) goto L15;
        goto L13
    }

    public final void setClosed$okhttp(boolean r5) {
        this.closed = r5;
    }

    public final synchronized void setMaxSize(long r10) {
        monitor-enter(this);
        this.maxSize = r10;     // Catch: Throwable -> L7
        if (this.initialized == false) goto L9;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized long size() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r5 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        AnonymousClass1 r5 = new AnonymousClass1(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L7;
        if (removeOldestEntry() == true) goto L3;
        return;
    L7:
        this.mostRecentTrimFailed = false;
    }

    @JvmOverloads
    public final synchronized Editor edit(String r10, long r11) throws IOException {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);     // Catch: Throwable -> L10
        initialize();     // Catch: Throwable -> L10
        checkNotClosed();     // Catch: Throwable -> L10
        validateKey(r10);     // Catch: Throwable -> L10
        Entry r5 = this.lruEntries.get(r10);     // Catch: Throwable -> L10
        if (r11 == ANY_SEQUENCE_NUMBER) goto L14;
        if (r5 != null) goto L8;
    L12:
        monitor-exit(this);
        return null;
    L8:
        if (r5.getSequenceNumber$okhttp() != r11) goto L12;
    L14:
        if (r5 == null) goto L17;
        Editor r12 = r5.getCurrentEditor$okhttp();     // Catch: Throwable -> L10
    L18:
        if (r12 == null) goto L21;
        monitor-exit(this);
        return null;
    L21:
        if (r5 == null) goto L27;
        if (r5.getLockingSourceCount$okhttp() == 0) goto L27;
        monitor-exit(this);
        return null;
    L27:
        if (this.mostRecentTrimFailed == false) goto L29;
    L40:
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return null;
    L29:
        if (this.mostRecentRebuildFailed == true) goto L40;
        k r13 = this.journalWriter;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L10
        r13.l(DIRTY).writeByte(32).l(r10).writeByte(10);     // Catch: Throwable -> L10
        r13.flush();     // Catch: Throwable -> L10
        if (this.hasJournalErrors == false) goto L35;
        monitor-exit(this);
        return null;
    L35:
        if (r5 != null) goto L37;
        r5 = new Entry(this, r10);     // Catch: Throwable -> L10
        this.lruEntries.put(r10, r5);     // Catch: Throwable -> L10
    L37:
        Editor r14 = new Editor(this, r5);     // Catch: Throwable -> L10
        r5.setCurrentEditor$okhttp(r14);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r14;
    L17:
        r12 = null;
    L10:
        th = move-exception;
        throw th;
    }
}
