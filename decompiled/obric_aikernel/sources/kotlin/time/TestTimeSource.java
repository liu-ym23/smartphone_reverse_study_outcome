package kotlin.time;

import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.9")
@WasExperimental(markerClass = {ExperimentalTime.class})
@SourceDebugExtension({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n80#2:201\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n173#1:200\n180#1:201\n*E\n"})
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1519overflowLRDsOJo(long r10) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt__DurationUnitKt.shortName(getUnit()) + " is advanced by " + Duration.m1433toStringimpl(r10) + '.');
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1520plusAssignLRDsOJo(long r12) {
        long r10 = Duration.m1430toLongimpl(r12, getUnit());
        boolean r11 = true;
        if (((r10 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L13;
        long r14 = this.reading;
        long r15 = r14 + r10;
        if ((r10 ^ r14) >= 0) goto L10;
    L12:
        this.reading = r15;
        return;
    L10:
        if ((r14 ^ r15) >= 0) goto L12;
        m1519overflowLRDsOJo(r12);
        goto L12
    L13:
        long r16 = Duration.m1387divUwyO8pc(r12, 2);
        if ((1 | (Duration.m1430toLongimpl(r16, getUnit()) - 1)) == Long.MAX_VALUE) goto L17;
        r11 = false;
    L17:
        if (r11 == true) goto L24;
        long r17 = this.reading;
        m1520plusAssignLRDsOJo(r16);     // Catch: IllegalStateException -> L21
        m1520plusAssignLRDsOJo(Duration.m1419minusLRDsOJo(r12, r16));     // Catch: IllegalStateException -> L21
        return;
    L21:
        e = move-exception;
        this.reading = r17;
        throw e;
    L24:
        m1519overflowLRDsOJo(r12);
        return;
    L5:
        r13 = false;
        goto L6
    }

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }
}
