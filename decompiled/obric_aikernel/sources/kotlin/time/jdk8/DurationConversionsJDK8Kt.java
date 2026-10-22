package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.ExperimentalTime;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "DurationConversionsJDK8Kt")
@SourceDebugExtension({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n731#2,2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34,2\n*E\n"})
public final class DurationConversionsJDK8Kt {
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* JADX INFO: renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m1546toJavaDurationLRDsOJo(long r10) {
        Duration r11 = Duration.ofSeconds(kotlin.time.Duration.m1405getInWholeSecondsimpl(r10), kotlin.time.Duration.m1407getNanosecondsComponentimpl(r10));
        Intrinsics.checkNotNullExpressionValue(r11, "toJavaDuration-LRDsOJo");
        return r11;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    private static final long toKotlinDuration(Duration r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return kotlin.time.Duration.m1420plusLRDsOJo(DurationKt.toDuration(r10.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(r10.getNano(), DurationUnit.NANOSECONDS));
    }
}
