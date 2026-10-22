package com.obric.memorydata.memory.inapptrace;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 !2\u00020\u0001:\u0002 !BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter;", "", "rootDir", "Ljava/io/File;", "maxEvents", "", "maxBytes", "", "maxDurationMs", "clock", "Lkotlin/Function0;", "onZipCompleted", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/inapptrace/CompletedTraceZip;", "", "<init>", "(Ljava/io/File;IJJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "openBatch", "Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter$OpenBatch;", "appendBatch", "json", "", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "createBatch", "shouldRotate", "batch", "rotate", "", "closeAndDelete", "recoverOrphanedParts", "recoverPart", "partFile", "OpenBatch", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f10161b;
    private final int c;
    private final long d;
    private final long e;
    private final Function0<Long> f;
    private final Function1<com.obric.memorydata.memory.inapptrace.a, Boolean> g;
    private b h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter$Companion;", "", "<init>", "()V", "PART_SUFFIX", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003Jc\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\rHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010#R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010#R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010#¨\u00067"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceBatchFileWriter$OpenBatch;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "partFile", "Ljava/io/File;", "output", "Ljava/io/FileOutputStream;", "writer", "Ljava/io/BufferedWriter;", "createdAt", "", "eventCount", "", "bytes", "startTimestamp", "endTimestamp", "<init>", "(Ljava/lang/String;Ljava/io/File;Ljava/io/FileOutputStream;Ljava/io/BufferedWriter;JIJJJ)V", "getSessionId", "()Ljava/lang/String;", "getPartFile", "()Ljava/io/File;", "getOutput", "()Ljava/io/FileOutputStream;", "getWriter", "()Ljava/io/BufferedWriter;", "getCreatedAt", "()J", "getEventCount", "()I", "setEventCount", "(I)V", "getBytes", "setBytes", "(J)V", "getStartTimestamp", "setStartTimestamp", "getEndTimestamp", "setEndTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f10163b;
        private final FileOutputStream c;
        private final BufferedWriter d;
        private final long e;
        private int f;
        private long g;
        private long h;
        private long i;

        public b(String r2, File r3, FileOutputStream r4, BufferedWriter r5, long r6, int r8, long r9, long r11, long r13) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r3, "partFile");
            Intrinsics.checkNotNullParameter(r4, "output");
            Intrinsics.checkNotNullParameter(r5, "writer");
            this.f10162a = r2;
            this.f10163b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r11;
            this.i = r13;
        }

        public /* synthetic */ b(String r17, File r18, FileOutputStream r19, BufferedWriter r20, long r21, int r23, long r24, long r26, long r28, int r30, DefaultConstructorMarker r31) {
            if ((r30 & 32) == 0) goto L5;
            int r9 = 0;
        L7:
            if ((r30 & 64) == 0) goto L9;
            long r10 = 0;
        L11:
            if ((r30 & 128) == 0) goto L13;
            long r12 = Long.MAX_VALUE;
        L15:
            if ((r30 & 256) == 0) goto L17;
            long r14 = Long.MIN_VALUE;
        L18:
            this(r17, r18, r19, r20, r21, r9, r10, r12, r14);
            return;
        L17:
            r14 = r28;
            goto L18
        L13:
            r12 = r26;
            goto L15
        L9:
            r10 = r24;
            goto L11
        L5:
            r9 = r23;
            goto L7
        }

        public final String a() {
            return this.f10162a;
        }

        public final void a(int r1) {
            this.f = r1;
        }

        public final void a(long r1) {
            this.g = r1;
        }

        public final File b() {
            return this.f10163b;
        }

        public final void b(long r1) {
            this.h = r1;
        }

        public final FileOutputStream c() {
            return this.c;
        }

        public final void c(long r1) {
            this.i = r1;
        }

        public final BufferedWriter d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10162a, r10.f10162a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10163b, r10.f10163b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (this.i == r10.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public final long h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((this.f10162a.hashCode() * 31) + this.f10163b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i);
        }

        public final long i() {
            return this.i;
        }

        public String toString() {
            return "OpenBatch(sessionId=" + this.f10162a + ", partFile=" + this.f10163b + ", output=" + this.c + ", writer=" + this.d + ", createdAt=" + this.e + ", eventCount=" + this.f + ", bytes=" + this.g + ", startTimestamp=" + this.h + ", endTimestamp=" + this.i + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.inapptrace.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0498c<T> implements Comparator {
        public C0498c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.memorydata.plugin")).lastModified()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((File) ZeusTransformUtils.preCheckCast(r3, File.class, "com.obric.memorydata.plugin")).lastModified()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10160a = new a(null);
    }

    public c(File r3, int r4, long r5, long r7, Function0<Long> r9, Function1<? super com.obric.memorydata.memory.inapptrace.a, Boolean> r10) {
        Function0<Long> r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function1<com.obric.memorydata.memory.inapptrace.a, Boolean> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        Intrinsics.checkNotNullParameter(r11, "clock");
        Intrinsics.checkNotNullParameter(r12, "onZipCompleted");
        this.f10161b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r11;
        this.g = r12;
        c();
    }

    public /* synthetic */ c(File r13, int r14, long r15, long r17, Function0 r19, Function1 r20, int r21, DefaultConstructorMarker r22) {
        Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        if ((r21 & 16) == 0) goto L5;
        r0 = (Function0) ZeusTransformUtils.preCheckCast(InAppTraceBatchFileWriter$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        this(r13, r14, r15, r17, r0, r11);
    }

    private final void a(File r18) {
        String r0 = r18.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "getName(...)");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.removeSuffix(StringsKt.substringAfter(StringsKt.removePrefix(r0, (CharSequence) ZeusTransformUtils.preCheckCast("in_app_trace_", CharSequence.class, "com.obric.memorydata.plugin")), '_', ""), (CharSequence) ZeusTransformUtils.preCheckCast(".jsonl.part", CharSequence.class, "com.obric.memorydata.plugin")), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r1) == false) goto L5;
        r1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
    L5:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        ArrayList r5 = new ArrayList();
        long r8 = Long.MAX_VALUE;
        long r10 = Long.MIN_VALUE;
        Charset r2 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r2, "UTF_8");
        Reader r3 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader((InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r18), InputStream.class, "com.obric.memorydata.plugin"), r2), Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, BufferedReader.class) == false) goto L8;
        BufferedReader r4 = (BufferedReader) ZeusTransformUtils.preCheckCast(r3, BufferedReader.class, "com.obric.memorydata.plugin");
    L9:
        Reader r6 = (Reader) ZeusTransformUtils.preCheckCast(r4, Reader.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, BufferedReader.class) == false) goto L12;
        BufferedReader r9 = (BufferedReader) ZeusTransformUtils.preCheckCast(r6, BufferedReader.class, "com.obric.memorydata.plugin");
    L13:
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
        Iterator<String> r13 = TextStreamsKt.lineSequence((BufferedReader) ZeusTransformUtils.preCheckCast(r12, BufferedReader.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L74
    L15:
        Object r15 = null;
        if (r13.hasNext() == false) goto L33;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L74
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        c r16 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r17 = Result.m1421constructorimpl(new JSONObject(r11));     // Catch: Throwable -> L20
    L23:
        if (Result.m1427isFailureimpl(r17) == true) goto L26;
        r15 = r17;
    L26:
        JSONObject r19 = (JSONObject) ZeusTransformUtils.preCheckCast(r15, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L74
        if (r19 != null) goto L29;
        Iterator<String> r110 = r13;
    L32:
        r13 = r110;
        goto L15
    L29:
        r110 = r13;
        long r20 = r19.optLong("eventTimeMs", 0);     // Catch: Throwable -> L74
        if (r20 <= 0) goto L32;
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).add(r19.toString());     // Catch: Throwable -> L74
        r8 = Math.min(r8, r20);     // Catch: Throwable -> L74
        r10 = Math.max(r10, r20);     // Catch: Throwable -> L74
    L20:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L74
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L74
        goto L23
    L33:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L74
        CloseableKt.closeFinally(r12, null);
        if (r5.isEmpty() == false) goto L38;
        r18.delete();
        return;
    L38:
        String r23 = "in_app_trace_" + r8 + '_' + r10 + '_' + r7 + ".zip";
        File r24 = new File(this.f10161b, r23);
        if (r24.exists() == true) goto L66;
        File r25 = new File(this.f10161b, r23 + ".tmp");
        Closeable r111 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r25), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        ZipOutputStream r26 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r111, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        r26.putNextEntry(new ZipEntry("events.jsonl"));     // Catch: Throwable -> L59
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L59
    L43:
        if (r112.hasNext() == false) goto L45;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        Charset r114 = StandardCharsets.UTF_8;     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r114, "UTF_8");     // Catch: Throwable -> L59
        byte[] r115 = r113.getBytes(r114);     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r115, "getBytes(...)");     // Catch: Throwable -> L59
        r26.write(r115);     // Catch: Throwable -> L59
        r26.write(10);     // Catch: Throwable -> L59
        goto L43
    L45:
        r26.closeEntry();     // Catch: Throwable -> L59
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L59
        CloseableKt.closeFinally(r111, null);
        Closeable r28 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r25, true), Closeable.class, "com.obric.memorydata.plugin");
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r28, FileOutputStream.class, "com.obric.memorydata.plugin")).getFD().sync();     // Catch: Throwable -> L53
        Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L53
        CloseableKt.closeFinally(r28, null);
        if (r25.renameTo(r24) == true) goto L66;
        throw new IllegalStateException(("rename recovered trace zip failed: " + r25.getAbsolutePath()).toString());
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        CloseableKt.closeFinally(r28, th);
        throw th;
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);
        throw th;
    L66:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.g.invoke(new com.obric.memorydata.memory.inapptrace.a(r24, r7, r8, r10, r5.size())), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L73;
        if (r18.delete() == false) goto L71;
        return;
    L71:
        throw new IllegalStateException(("delete recovered trace part failed: " + r18.getAbsolutePath()).toString());
    L73:
        throw new IllegalStateException(("persist recovered trace zip failed: " + r24.getAbsolutePath()).toString());
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L12:
        r9 = new BufferedReader(r6, 8192);
        goto L13
    L8:
        r4 = new BufferedReader(r3, 8192);
        goto L9
    }

    private final boolean a(b r5) {
        if (r5.f() < this.c) goto L5;
    L10:
        return true;
    L5:
        if (r5.g() >= this.d) goto L10;
        if ((((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r5.e()) >= this.e) goto L10;
        return false;
    }

    private final b b() {
        this.f10161b.mkdirs();
        String r3 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        File r4 = new File(this.f10161b, "in_app_trace_" + ((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() + '_' + r3 + ".jsonl.part");
        FileOutputStream r5 = new FileOutputStream(r4, true);
        return new b(r3, r4, r5, new BufferedWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(r5, OutputStream.class, "com.obric.memorydata.plugin"), StandardCharsets.UTF_8), Writer.class, "com.obric.memorydata.plugin")), ((Number) ZeusTransformUtils.preCheckCast(this.f.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue(), 0, 0, 0, 0, 480, null);
    }

    private final void b(b r14) {
        r14.d().flush();
        r14.c().getFD().sync();
        r14.d().close();
        String r0 = "in_app_trace_" + r14.h() + '_' + r14.i() + '_' + r14.a() + ".zip";
        File r1 = new File(this.f10161b, r0 + ".tmp");
        File r2 = new File(this.f10161b, r0);
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        ZipOutputStream r4 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r3, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        r4.putNextEntry(new ZipEntry("events.jsonl"));     // Catch: Throwable -> L31
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r14.b()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r5, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r4, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L31
        r4.closeEntry();     // Catch: Throwable -> L31
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r3, null);
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r1, true), Closeable.class, "com.obric.memorydata.plugin");
        ((FileOutputStream) ZeusTransformUtils.preCheckCast(r7, FileOutputStream.class, "com.obric.memorydata.plugin")).getFD().sync();     // Catch: Throwable -> L21
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r7, null);
        if (r1.renameTo(r2) == false) goto L20;
        this.h = null;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.g.invoke(new com.obric.memorydata.memory.inapptrace.a(r2, r14.a(), r14.h(), r14.i(), r14.f())), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L18;
        if (r14.b().delete() == false) goto L16;
        return;
    L16:
        throw new IllegalStateException(("delete trace part failed: " + r14.b().getAbsolutePath()).toString());
    L18:
        throw new IllegalStateException(("persist completed trace zip failed: " + r2.getAbsolutePath()).toString());
    L20:
        throw new IllegalStateException(("rename trace zip failed: " + r1.getAbsolutePath()).toString());
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    private static final boolean b(File r4) {
        String r5 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "getName(...)");
        return StringsKt.endsWith$default(r5, ".jsonl.part", false, 2, null);
    }

    private final void c() {
        if (this.f10161b.isDirectory() == true) goto L5;
        return;
    L5:
        File[] r0 = this.f10161b.listFiles($$Lambda$c$wbbLgb9rJ4pLoSz2WgpkZvJQ6as.INSTANCE);
        if (r0 != null) goto L8;
        r0 = new File[0];
    L8:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.sortedWith(r0, (Comparator) ZeusTransformUtils.preCheckCast(new C0498c(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r1.next(), File.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L14
        r4.a(r2);     // Catch: Throwable -> L14
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void c(b r2) {
        r2.d().close();
        r2.b().delete();
        this.h = null;
    }

    public static /* synthetic */ boolean lambda$wbbLgb9rJ4pLoSz2WgpkZvJQ6as(File r0) {
        return b(r0);
    }

    public final boolean a() {
        b r1 = this.h;
        if (r1 != null) goto L18;
        return true;
    L18:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        c r4 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1.f() <= 0) goto L8;
        r4.b(r1);     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L11
    L14:
        if (Result.m1427isFailureimpl(r5) == false) goto L17;
        r5 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        r4.c(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean a(String r15) {
        Intrinsics.checkNotNullParameter(r15, "json");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        c r3 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r16 = Result.m1421constructorimpl(new JSONArray(r15));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r16) == false) goto L10;
        r16 = null;
    L10:
        JSONArray r17 = (JSONArray) ZeusTransformUtils.preCheckCast(r16, JSONArray.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L14;
        return false;
    L14:
        if (r17.length() != 0) goto L16;
        return true;
    L16:
        ArrayList r4 = new ArrayList(r17.length());
        int r5 = r17.length();
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L25;
        JSONObject r7 = r17.optJSONObject(r6);
        if (r7 == null) goto L20;
        long r11 = r7.optLong("eventTimeMs", 0);
        if (r11 <= 0) goto L23;
        ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(r7.toString(), Long.valueOf(r11)));
        r6 = r6 + 1;
        goto L17
    L23:
        return false;
    L20:
        return false;
    L25:
        b r18 = this.h;
        if (r18 != null) goto L46;
        r18 = b();
        this.h = r18;
    L46:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L37
        c r14 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L37
    L30:
        if (r0.hasNext() == false) goto L32;
        Pair r9 = (Pair) ZeusTransformUtils.preCheckCast(r0.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r9.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L37
        r18.d().write(r10);     // Catch: Throwable -> L37
        r18.d().newLine();     // Catch: Throwable -> L37
        r18.a(r18.f() + 1);     // Catch: Throwable -> L37
        long r13 = r18.g();     // Catch: Throwable -> L37
        Charset r19 = StandardCharsets.UTF_8;     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r19, "UTF_8");     // Catch: Throwable -> L37
        byte[] r20 = r10.getBytes(r19);     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r20, "getBytes(...)");     // Catch: Throwable -> L37
        r18.a(r13 + (((long) r20.length) + 1));     // Catch: Throwable -> L37
        r18.b(Math.min(r18.h(), r12));     // Catch: Throwable -> L37
        r18.c(Math.max(r18.i(), r12));     // Catch: Throwable -> L37
        goto L30
    L32:
        r18.d().flush();     // Catch: Throwable -> L37
        if (r14.a(r18) == false) goto L35;
        r14.b(r18);     // Catch: Throwable -> L37
    L35:
        Object r110 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L37
    L40:
        if (Result.m1427isFailureimpl(r110) == false) goto L43;
        r110 = false;
    L43:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r110, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L37:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
