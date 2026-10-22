package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@JvmName(name = "DurationApi26Impl")
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(Duration r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.toMillis();
    }
}
