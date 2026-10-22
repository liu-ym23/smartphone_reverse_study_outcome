package okio;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\nJ\r\u0010\u0011\u001a\u00020\nH\u0007¢\u0006\u0002\b J\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b!J&\u0010\"\u001a\u00020\u001f*\u00020\n2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0$¢\u0006\u0002\b%H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u00020\u00198\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006&"}, d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$jvm", "()Lokio/Buffer;", "foldedSink", "Lokio/Sink;", "getFoldedSink$jvm", "()Lokio/Sink;", "setFoldedSink$jvm", "(Lokio/Sink;)V", "getMaxBufferSize$jvm", "()J", "sink", "sinkClosed", "", "getSinkClosed$jvm", "()Z", "setSinkClosed$jvm", "(Z)V", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$jvm", "setSourceClosed$jvm", "fold", "", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "jvm"}, k = 1, mv = {1, 1, 11})
public final class Pipe {
    private final Buffer buffer;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long r3) {
        this.maxBufferSize = r3;
        this.buffer = new Buffer();
        if (r3 < 1) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        this.sink = (Sink) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Sink.class, "com.obric.memorydata.plugin");
        this.source = (Source) ZeusTransformUtils.preCheckCast(new C12911(this), Source.class, "com.obric.memorydata.plugin");
        return;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("maxBufferSize < 1: " + r3).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    public static final /* synthetic */ void access$forward(Pipe r2, Sink r3, Function1 r4) {
        r2.forward((Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"));
    }

    private final void forward(Sink r12, Function1<? super Sink, Unit> r13) {
        Sink r14 = (Sink) ZeusTransformUtils.wrapperContextForParams(r12, Sink.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        Timeout r0 = r14.timeout();
        Timeout r11 = sink().timeout();
        long r1 = r0.timeoutNanos();
        r0.timeout(Timeout.Companion.minTimeout(r11.timeoutNanos(), r0.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (r0.hasDeadline() == false) goto L18;
        long r5 = r0.deadlineNanoTime();
        if (r11.hasDeadline() == false) goto L34;
        r0.deadlineNanoTime(Math.min(r0.deadlineNanoTime(), r11.deadlineNanoTime()));
    L34:
        r15.invoke(r14);     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L24;
        r0.deadlineNanoTime(r5);
    L24:
        InlineMarker.finallyEnd(1);
        return;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L15;
        r0.deadlineNanoTime(r5);
    L15:
        InlineMarker.finallyEnd(1);
        throw th;
    L18:
        if (r11.hasDeadline() == false) goto L32;
        r0.deadlineNanoTime(r11.deadlineNanoTime());
    L32:
        r15.invoke(r14);     // Catch: Throwable -> L26
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L24;
        r0.clearDeadline();
    L26:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.timeout(r1, TimeUnit.NANOSECONDS);
        if (r11.hasDeadline() == false) goto L30;
        r0.clearDeadline();
    L30:
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    /* JADX INFO: renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m3065deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = AILabCheckPermissionTask.KEY_SOURCE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_source, reason: not valid java name */
    public final Source m3066deprecated_source() {
        return this.source;
    }

    public final void fold(Sink r8) {
        Sink r9 = (Sink) ZeusTransformUtils.wrapperContextForParams(r8, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "sink");
    L3:
        Buffer r0 = this.buffer;
        monitor-enter(r0);
    L41:
        th = move-exception;
        throw th;
    L6:
        if (this.foldedSink != null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L40;
        if (this.buffer.exhausted() == true) goto L12;
        boolean r2 = this.sinkClosed;     // Catch: Throwable -> L41
        Buffer r3 = new Buffer();     // Catch: Throwable -> L41
        Buffer r4 = this.buffer;     // Catch: Throwable -> L41
        r3.write(r4, r4.size());     // Catch: Throwable -> L41
        Buffer r5 = this.buffer;     // Catch: Throwable -> L41
        if (r5 == null) goto L38;
        ZeusTransformUtils.preCheckCast(r5, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L41
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r0);
        r9.write(r3, r3.size());     // Catch: Throwable -> L24
        if (r2 == true) goto L21;
        r9.flush();     // Catch: Throwable -> L24
        goto L3
    L21:
        r9.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        monitor-enter(this.buffer);
        this.sourceClosed = true;     // Catch: Throwable -> L34
        Buffer r7 = this.buffer;     // Catch: Throwable -> L34
        if (r7 == null) goto L30;
        ZeusTransformUtils.preCheckCast(r7, Object.class, "com.obric.memorydata.plugin").notifyAll();     // Catch: Throwable -> L34
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L34
        throw th;
    L30:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L38:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L41
    L12:
        this.sourceClosed = true;     // Catch: Throwable -> L41
        this.foldedSink = r9;     // Catch: Throwable -> L41
        monitor-exit(r0);
        return;
    L40:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("sink already folded".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
    L8:
        r1 = false;
        goto L9
    }

    public final Buffer getBuffer$jvm() {
        return this.buffer;
    }

    public final Sink getFoldedSink$jvm() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$jvm() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$jvm() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$jvm() {
        return this.sourceClosed;
    }

    public final void setFoldedSink$jvm(Sink r3) {
        this.foldedSink = (Sink) ZeusTransformUtils.wrapperContextForParams(r3, Sink.class, "com.obric.memorydata.plugin");
    }

    public final void setSinkClosed$jvm(boolean r1) {
        this.sinkClosed = r1;
    }

    public final void setSourceClosed$jvm(boolean r1) {
        this.sourceClosed = r1;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
