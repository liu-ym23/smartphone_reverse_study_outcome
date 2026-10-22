package com.bytedance.forest.model;

import ai.j0;
import androidx.annotation.Keep;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 `2\u00020\u0001:\u0001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\nH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\nH\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010!\u001a\u00020\nH\u0010¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u001cJ\u0019\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J7\u0010-\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0010¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0010¢\u0006\u0004\b.\u0010/J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103JC\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b042\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u0010\u0010J\u0017\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\nH\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010:J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010:J\u000f\u0010>\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010\u001cR*\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00048\u0010@PX\u0090\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010LR\u001a\u0010Y\u001a\u00020X8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_¨\u0006b"}, d2 = {"Lcom/bytedance/forest/model/ForestBuffer;", "Lcom/bytedance/forest/model/q;", "Lcom/bytedance/forest/model/a;", "bytesProvider", "Lcom/bytedance/forest/utils/e;", "ctx", "<init>", "(Lcom/bytedance/forest/model/a;Lcom/bytedance/forest/utils/e;)V", "", "initialSize", "", "initCache$forest_release", "(Ljava/lang/Integer;)Z", "initCache", "", "close", "()V", "size", "()I", "", "provideBytes", "()[B", "Ljava/io/InputStream;", "inputStream", "replaceOriginInputStream$forest_release", "(Ljava/io/InputStream;)Z", "replaceOriginInputStream", "isCacheProvided$forest_release", "()Z", "isCacheProvided", "isCacheReady$forest_release", "isCacheReady", "isCacheClear$forest_release", "isCacheClear", "supportReuse", "Lcom/bytedance/forest/model/w;", "response", "provideInputStream", "(Lcom/bytedance/forest/model/w;)Ljava/io/InputStream;", "index", "bytes", "off", "len", "getBytesAtRange$forest_release", "(I[BIILcom/bytedance/forest/model/w;)I", "getBytesAtRange", "tryLoadToMemory$forest_release", "(Lcom/bytedance/forest/model/w;)V", "tryLoadToMemory", "", "toString", "()Ljava/lang/String;", "Lkotlin/Pair;", "tryLoadFromOriginInputStream", "(I[BIILcom/bytedance/forest/model/w;)Lkotlin/Pair;", "finish", "closeOriginInputStream", "clear", "(Z)V", "closeInternally", "throwError", "doClose", "countDown", "value", "context", "Lcom/bytedance/forest/utils/e;", "getContext$forest_release", "()Lcom/bytedance/forest/utils/e;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/e;)V", "originInputStream", "Ljava/io/InputStream;", "Lcom/bytedance/forest/model/f;", "meta", "Lcom/bytedance/forest/model/f;", "ptr", "I", "Ljava/util/concurrent/atomic/AtomicBoolean;", "exceptionHandlerHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/bytedance/forest/model/e;", "exceptionHandler", "Lcom/bytedance/forest/model/e;", "getExceptionHandler$forest_release", "()Lcom/bytedance/forest/model/e;", "setExceptionHandler$forest_release", "(Lcom/bytedance/forest/model/e;)V", "estimatedSize", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getReferenceCount$forest_release", "()Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/bytedance/forest/model/ForestBuffer$Companion$State;", "state", "Lcom/bytedance/forest/model/ForestBuffer$Companion$State;", "Companion", "com/bytedance/forest/model/g", "forest_release"}, k = 1, mv = {1, 4, 0})
public class ForestBuffer extends q {
    public static final g Companion = null;
    public static final String TAG = "ForestBuffer";
    private static final int UNDEFINED = -1;
    private com.bytedance.forest.utils.e context;
    private int estimatedSize;
    private e exceptionHandler;
    private final AtomicBoolean exceptionHandlerHandled;
    private volatile f meta;
    private InputStream originInputStream;
    private volatile int ptr;
    private final AtomicInteger referenceCount;
    private volatile ForestBuffer$Companion$State state;

    static {
        Companion = new g();
    }

    public ForestBuffer(a r5, com.bytedance.forest.utils.e r10) {
        super(r5);
        this.context = r10;
        this.exceptionHandlerHandled = new AtomicBoolean(false);
        this.exceptionHandler = new h(this);
        this.estimatedSize = -1;
        this.referenceCount = new AtomicInteger(0);
        this.state = ForestBuffer$Companion$State.f4315a;
    }

    public static final /* synthetic */ AtomicBoolean access$getExceptionHandlerHandled$p(ForestBuffer r5) {
        return r5.exceptionHandlerHandled;
    }

    public static final /* synthetic */ InputStream access$getOriginInputStream$p(ForestBuffer r5) {
        return r5.originInputStream;
    }

    public static final /* synthetic */ int access$getPtr$p(ForestBuffer r5) {
        return r5.ptr;
    }

    public static final /* synthetic */ ForestBuffer$Companion$State access$getState$p(ForestBuffer r5) {
        return r5.state;
    }

    public static final /* synthetic */ void access$setOriginInputStream$p(ForestBuffer r5, InputStream r10) {
        r5.originInputStream = r10;
    }

    public static final /* synthetic */ void access$setPtr$p(ForestBuffer r5, int r10) {
        r5.ptr = r10;
    }

    public static final /* synthetic */ void access$setState$p(ForestBuffer r5, ForestBuffer$Companion$State r10) {
        r5.state = r10;
    }

    private final void clear(boolean r10) {
        if (isCacheReady$forest_release() == false) goto L5;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "clear after forest buffer finished", true, null, null, 48);
    L5:
        this.estimatedSize = -1;
        this.state = ForestBuffer$Companion$State.d;
        f r5 = this.meta;
        if (r5 == null) goto L8;
        r5.f4373b = null;
    L8:
        if (r10 == false) goto L22;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L12
        InputStream r12 = this.originInputStream;     // Catch: Throwable -> L12
        if (r12 == null) goto L14;
        r12.close();     // Catch: Throwable -> L12
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L15:
        Result.m124constructorimpl(r13);     // Catch: Throwable -> L12
    L18:
        this.originInputStream = null;
        return;
    L14:
        r13 = null;
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final boolean countDown() {
        int r5 = this.referenceCount.decrementAndGet();
        if (r5 >= 0) goto L5;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, j0.h(r5, "unexpected close count, count: ", " less than 0"), true, null, null, 48);
    L5:
        if (r5 != 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final void doClose(boolean r11) {
        InputStream r5 = this.originInputStream;     // Catch: Throwable -> L7
        if (r5 == null) goto L10;
        r5.close();     // Catch: Throwable -> L7
    L10:
        if (isCacheReady$forest_release() == true) goto L29;
        clear(false);
        return;
    L29:
        return;
    L7:
        th = move-exception;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "close origin input stream failed", true, th, null, 32);     // Catch: Throwable -> L20
        if (r11 == false) goto L16;
        throw th;     // Catch: Throwable -> L20
    L16:
        if (isCacheReady$forest_release() == true) goto L30;
        clear(false);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        if (isCacheReady$forest_release() == true) goto L24;
        clear(false);
    L24:
        throw th;
    }

    private final void finish() {
        this.estimatedSize = this.ptr;
        f r5 = this.meta;
        if (r5 == null) goto L7;
        d r10 = r5.f4373b;
        if (r10 == null) goto L7;
        r10.b();
    L7:
        this.state = ForestBuffer$Companion$State.f4317c;
        onFulFilled();
    }

    private final Pair<Integer, Integer> tryLoadFromOriginInputStream(int r11, byte[] r12, int r13, int r14, w r15) {
        if (isCacheReady$forest_release() == true) goto L61;
        int r5 = r11 + r14;
        if (r5 <= this.ptr) goto L61;
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (isCacheReady$forest_release() == false) goto L11;
    L55:
        Pair<Integer, Integer> r16 = new Pair(Integer.valueOf(this.ptr), 0);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r16;
    L11:
        if (r5 <= this.ptr) goto L55;
        InputStream r10 = this.originInputStream;     // Catch: Throwable -> L25
        if (r10 == null) goto L54;
        if (this.ptr >= r11) goto L18;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "read index is larger than ptr", true, null, null, 48);     // Catch: Throwable -> L25
        throw new IOException("read index is larger than ptr");     // Catch: Throwable -> L25
    L18:
        int r17 = this.ptr - r11;
        int r18 = r13 + r17;
        int r19 = r10.read(r12, r18, r14 - r17);     // Catch: Throwable -> L48
    L21:
        if (r19 != (-1)) goto L65;
        finish();     // Catch: Throwable -> L25
        Pair<Integer, Integer> r110 = new Pair(Integer.valueOf(this.ptr), 0);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r110;
    L65:
        f r111 = this.meta;     // Catch: Throwable -> L32 OutOfMemoryError -> L34
        if (r111 == null) goto L41;
        int r20 = this.ptr;     // Catch: Throwable -> L32 OutOfMemoryError -> L34
        if (r111.f4373b != null) goto L36;
        r111.f4373b = new d(r111.f4374c, r111.f4372a);     // Catch: Throwable -> L32 OutOfMemoryError -> L34
    L36:
        d r112 = r111.f4373b;     // Catch: Throwable -> L32 OutOfMemoryError -> L34
        if (r112 != null) goto L39;
        Intrinsics.throwNpe();     // Catch: Throwable -> L32 OutOfMemoryError -> L34
    L39:
        r112.d(r20, r12, r18, r19);     // Catch: Throwable -> L32 OutOfMemoryError -> L34
        this.estimatedSize = RangesKt.coerceAtLeast(this.estimatedSize, this.ptr + r19);     // Catch: Throwable -> L32 OutOfMemoryError -> L34
    L45:
        this.ptr += r19;     // Catch: Throwable -> L25
        Pair<Integer, Integer> r113 = new Pair(Integer.valueOf(this.ptr - r19), Integer.valueOf(r19));     // Catch: Throwable -> L25
        monitor-exit(this);
        return r113;
    L41:
        throw new IOException("meta is null");     // Catch: Throwable -> L32 OutOfMemoryError -> L34
    L34:
        e = move-exception;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "add bytes failed", true, e, null, 32);     // Catch: Throwable -> L25
        clear(false);     // Catch: Throwable -> L25
    L32:
        th = move-exception;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "add bytes failed", true, th, null, 32);     // Catch: Throwable -> L25
        clear(true);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L48:
        th = move-exception;
        clear(true);     // Catch: Throwable -> L25
        ((h) this.exceptionHandler).a(r15);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L54:
        throw new IOException("origin input stream is null");     // Catch: Throwable -> L25
    L61:
        return new Pair(Integer.valueOf(this.ptr), 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(false);
    }

    @Override // com.bytedance.forest.model.q
    public int getBytesAtRange$forest_release(int r10, byte[] r11, int r12, int r13, w r14) {
        if (isCacheClear$forest_release() == false) goto L33;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (isCacheClear$forest_release() == true) goto L13;
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        goto L33
    L13:
        if (r10 != this.ptr) goto L29;
        InputStream r15 = this.originInputStream;     // Catch: Throwable -> L10
        if (r15 == null) goto L17;
        Integer r16 = Integer.valueOf(r15.read(r11, r12, r13));     // Catch: Throwable -> L10
    L18:
        if (r16 != null) goto L20;
    L22:
        if (r16 == null) goto L27;
        int r17 = r16.intValue();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r17;
    L27:
        throw new IOException("origin input stream and meta is null");     // Catch: Throwable -> L10
    L20:
        if (r16.intValue() == (-1)) goto L22;
        this.ptr += r16.intValue();     // Catch: Throwable -> L10
        goto L22
    L17:
        r16 = null;
        goto L18
    L29:
        throw new IOException("origin input stream and meta is null");     // Catch: Throwable -> L10
    L33:
        if (isCacheReady$forest_release() == true) goto L35;
    L37:
        Pair<Integer, Integer> r18 = tryLoadFromOriginInputStream(r10, r11, r12, r13, r14);
        if (isCacheReady$forest_release() == false) goto L43;
        if (this.estimatedSize > r10) goto L43;
        return -1;
    L43:
        if (r18.getFirst().intValue() == r10) goto L45;
        int r19 = RangesKt.coerceAtMost(r13, r18.getFirst().intValue() - r10);
        if (r19 < 0) goto L57;
        f r20 = this.meta;
        if (r20 == null) goto L56;
        d r21 = r20.f4373b;
        if (r21 == null) goto L54;
        System.arraycopy(r21.e(), r10, r11, r12, r19);
    L54:
        return r18.getSecond().intValue() + r19;
    L56:
        throw new IOException("meta is null");
    L57:
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "rest size is less than 0", true, null, null, 48);
        throw new IOException("rest size is less than 0");
    L45:
        return r18.getSecond().intValue();
    L35:
        if (this.estimatedSize > r10) goto L37;
        return -1;
    }

    @Override // com.bytedance.forest.model.p
    public com.bytedance.forest.utils.e getContext$forest_release() {
        return this.context;
    }

    public final e getExceptionHandler$forest_release() {
        return this.exceptionHandler;
    }

    public final AtomicInteger getReferenceCount$forest_release() {
        return this.referenceCount;
    }

    @Override // com.bytedance.forest.model.q
    public synchronized boolean initCache$forest_release(Integer r10) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (isCacheProvided$forest_release() == false) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.originInputStream == null) goto L11;
    L52:
        com.bytedance.forest.utils.d.c(getContext$forest_release().g, 6, TAG, null, null, new ForestBuffer$initCache$1(this), 24);     // Catch: Throwable -> L31
        monitor-exit(this);
        return false;
    L11:
        if (this.state != ForestBuffer$Companion$State.f4315a) goto L52;
        if (this.ptr != 0) goto L52;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L20
        InputStream r11 = getBytesProvider().a();     // Catch: Throwable -> L20
        if (r11 == null) goto L25;
        this.originInputStream = r11;     // Catch: Throwable -> L20
        if (r10 == null) goto L22;
        int r12 = r10.intValue();     // Catch: Throwable -> L20
    L23:
        this.meta = new f(r12, getContext$forest_release());     // Catch: Throwable -> L20
        Object r13 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L29:
        if (Result.m131isSuccessimpl(r13) == false) goto L33;
        Unit r14 = (Unit) r13;     // Catch: Throwable -> L31
        this.state = ForestBuffer$Companion$State.f4316b;     // Catch: Throwable -> L31
    L33:
        Throwable r15 = Result.m127exceptionOrNullimpl(r13);     // Catch: Throwable -> L31
        if (r15 == null) goto L49;
        f r16 = this.meta;     // Catch: Throwable -> L31
        if (r16 == null) goto L38;
        r16.f4373b = null;     // Catch: Throwable -> L31
    L38:
        this.state = ForestBuffer$Companion$State.d;     // Catch: Throwable -> L31
        InputStream r17 = this.originInputStream;     // Catch: Throwable -> L42
        if (r17 == null) goto L44;
        r17.close();     // Catch: Throwable -> L42
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L45:
        Result.m124constructorimpl(r18);     // Catch: Throwable -> L42
    L48:
        this.originInputStream = null;     // Catch: Throwable -> L31
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "initCache failed", true, r15, null, 32);     // Catch: Throwable -> L31
        goto L49
    L44:
        r18 = null;
    L42:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L31
        Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
    L49:
        boolean r110 = Result.m131isSuccessimpl(r13);     // Catch: Throwable -> L31
        monitor-exit(this);
        return r110;
    L22:
        r12 = RangesKt.coerceAtLeast(r11.available(), 4096);     // Catch: Throwable -> L20
        goto L23
    L25:
        monitor-exit(this);
        return false;
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L31
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
        goto L29
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheClear$forest_release() {
        if (this.state != ForestBuffer$Companion$State.d) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheProvided$forest_release() {
        if (this.state == ForestBuffer$Companion$State.f4316b) goto L7;
        if (this.state == ForestBuffer$Companion$State.f4317c) goto L7;
        return false;
    L7:
        if (this.meta == null) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public boolean isCacheReady$forest_release() {
        if (this.state != ForestBuffer$Companion$State.f4317c) goto L11;
        f r5 = this.meta;
        if (r5 == null) goto L7;
        d r10 = r5.f4373b;
    L8:
        if (r10 == null) goto L13;
        return true;
    L13:
        return false;
    L7:
        r10 = null;
        goto L8
    L11:
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public byte[] provideBytes() {
        if (isCacheReady$forest_release() == false) goto L14;
        f r5 = this.meta;
        if (r5 == null) goto L9;
        d r10 = r5.f4373b;
        if (r10 == null) goto L9;
        byte[] r11 = r10.e();
    L10:
        if (r11 == null) goto L14;
        if (r11.length != this.ptr) goto L14;
        return r11;
    L9:
        r11 = null;
    L14:
        return null;
    }

    @Override // com.bytedance.forest.model.p
    public InputStream provideInputStream(w r5) {
        if (isCacheReady$forest_release() == false) goto L14;
        f r10 = this.meta;
        if (r10 == null) goto L14;
        d r11 = r10.f4373b;
        if (r11 == null) goto L9;
        byte[] r12 = r11.e();
    L10:
        if (r12 == null) goto L14;
        return new ByteArrayInputStream(r12);
    L9:
        r12 = null;
    L14:
        if (isCacheProvided$forest_release() == false) goto L18;
        this.referenceCount.incrementAndGet();
        return new com.bytedance.forest.utils.io.c(this, r5);
    L18:
        return getBytesProvider().a();
    }

    public final synchronized boolean replaceOriginInputStream$forest_release(InputStream r11) {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (isCacheClear$forest_release() == true) goto L40;
        monitor-exit(this);
        return false;
    L40:
        byte[] r5 = new byte[this.ptr];     // Catch: Throwable -> L22
        this.originInputStream = r11;     // Catch: Throwable -> L22
        this.state = ForestBuffer$Companion$State.f4316b;     // Catch: Throwable -> L22
        int r10 = 0;
    L10:
        int r12 = r11.read(r5, r10, this.ptr - r10);     // Catch: Throwable -> L22
        if (r12 == (-1)) goto L16;
        r10 = r10 + r12;     // Catch: Throwable -> L22
        if (r10 < this.ptr) goto L10;
    L16:
        if (r10 < this.ptr) goto L33;
        f r13 = this.meta;     // Catch: Throwable -> L22
        if (r13 == null) goto L31;
        int r14 = this.ptr;     // Catch: Throwable -> L22
        if (r13.f4373b != null) goto L24;
        r13.f4373b = new d(r13.f4374c, r13.f4372a);     // Catch: Throwable -> L22
    L24:
        d r15 = r13.f4373b;     // Catch: Throwable -> L22
        if (r15 != null) goto L27;
        Intrinsics.throwNpe();     // Catch: Throwable -> L22
    L27:
        r15.d(0, r5, 0, r14);     // Catch: Throwable -> L22
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, TAG, "replace original input stream successfully", false, null, null, 56);     // Catch: Throwable -> L22
        monitor-exit(this);
        return true;
    L31:
        throw new IOException("meta is null");     // Catch: Throwable -> L22
    L33:
        throw new IOException("except read " + this.ptr + ", but receive " + r10);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "error happens when replaceOriginInputStream", true, th, null, 32);     // Catch: Throwable -> L37
        clear(true);     // Catch: Throwable -> L37
        return false;
    }

    @Override // com.bytedance.forest.model.p
    public void setContext$forest_release(com.bytedance.forest.utils.e r5) {
        f r10 = this.meta;
        if (r10 == null) goto L8;
        d r11 = r10.f4373b;
        if (r11 == null) goto L7;
        r11.f4371b = r5;
    L7:
        r10.f4372a = r5;
    L8:
        this.context = r5;
    }

    public final void setExceptionHandler$forest_release(e r5) {
        this.exceptionHandler = r5;
    }

    @Override // com.bytedance.forest.model.p
    public int size() {
        if (isCacheProvided$forest_release() == true) goto L6;
        return 0;
    L6:
        return RangesKt.coerceAtLeast(this.estimatedSize, 0);
    }

    @Override // com.bytedance.forest.model.p
    public boolean supportReuse() {
        if (isCacheProvided$forest_release() == false) goto L5;
        return true;
    L5:
        if (getBytesProvider().b() == true) goto L11;
        return false;
    L11:
        return true;
    }

    public String toString() {
        return super.toString() + "(inputStreamProvider=" + getBytesProvider() + ", originInputStream=" + this.originInputStream + ", meta=" + this.meta + ", ptr=" + this.ptr + ", exceptionHandler=" + this.exceptionHandler + ", estimatedSize=" + this.estimatedSize + ", referenceCount=" + this.referenceCount + ", state=" + this.state + ')';
    }

    @Override // com.bytedance.forest.model.p
    public void tryLoadToMemory$forest_release(w r11) {
        if (isCacheClear$forest_release() == false) goto L5;
        return;
    L5:
        if (isCacheReady$forest_release() == true) goto L63;
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L9:
        if (isCacheClear$forest_release() == false) goto L11;
    L52:
        monitor-exit(this);
        return;
    L11:
        if (isCacheReady$forest_release() == true) goto L52;
        if (q.initCache$forest_release$default(this, null, 1, null) == false) goto L50;
        InputStream r5 = this.originInputStream;     // Catch: Throwable -> L42
        if (r5 == null) goto L48;
        f r10 = this.meta;     // Catch: Throwable -> L42
        if (r10 == null) goto L47;
        d r12 = r10.f4373b;     // Catch: Throwable -> L42
        if (r12 == null) goto L47;
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L25
        int r14 = r5.read(r13);     // Catch: Throwable -> L25
    L23:
        if (r14 < 0) goto L27;
        r12.d(this.ptr, r13, 0, r14);     // Catch: Throwable -> L25
        this.ptr += r14;     // Catch: Throwable -> L25
        r14 = r5.read(r13);     // Catch: Throwable -> L25
        goto L23
    L27:
        finish();     // Catch: Throwable -> L25
        close(true);     // Catch: Throwable -> L25
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L31:
        th = move-exception;
        com.bytedance.forest.utils.d.c(getContext$forest_release().g, 6, TAG, th, null, new ForestBuffer$tryLoadToMemory$$inlined$synchronized$lambda$1(this), 16);     // Catch: Throwable -> L42
        clear(true);     // Catch: Throwable -> L42
        if (((h) this.exceptionHandler).a(r11) == false) goto L44;
        tryLoadToMemory$forest_release(r11);     // Catch: Throwable -> L42
        return;
    L44:
        getContext$forest_release().f4619a.getClass();     // Catch: Throwable -> L42
        com.bytedance.forest.b.d(r11, th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L47:
        throw new IOException("meta is null");     // Catch: Throwable -> L42
    L48:
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "response: " + r11.f4442r + ", " + r11.A + ", " + r11.f4443t + ", buffer: " + this.state + ", " + this.ptr, true, new IOException("origin input stream is null"), null, 32);     // Catch: Throwable -> L42
        throw new IOException("origin input stream is null");     // Catch: Throwable -> L42
    L50:
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "init cache buffer failed when load to memory", true, null, null, 48);     // Catch: Throwable -> L42
        throw new IOException("init cache buffer failed");     // Catch: Throwable -> L42
    }

    private final void close(boolean r10) {
        if (isCacheClear$forest_release() == false) goto L7;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "forest buffer is closed in Clear state", false, null, null, 56);
        countDown();
        return;
    L7:
        if (isCacheProvided$forest_release() == true) goto L9;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 6, TAG, "forest buffer is closed in unfinished state", true, null, null, 48);
    L9:
        if (r10 == false) goto L13;
        this.referenceCount.set(0);
        doClose(false);
        return;
    L13:
        if (countDown() == false) goto L16;
        doClose(true);
        return;
    }
}
