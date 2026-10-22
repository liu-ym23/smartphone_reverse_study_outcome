package kotlin.system;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "ProcessKt")
public final class ProcessKt {
    @InlineOnly
    private static final Void exitProcess(int r10) {
        System.exit(r10);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
