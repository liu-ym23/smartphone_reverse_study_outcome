package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"trace", ExifInterface.GPS_DIRECTION_TRUE, "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TraceKt {
    public static final <T> T trace(String r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "sectionName");
        Intrinsics.checkNotNullParameter(r10, "block");
        Trace r11 = Trace.INSTANCE;
        Object r12 = r11.beginSection(r5);
        T r13 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r11.endSection(r12);
        InlineMarker.finallyEnd(1);
        return r13;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        Trace.INSTANCE.endSection(r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
