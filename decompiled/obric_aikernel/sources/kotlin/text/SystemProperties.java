package kotlin.text;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class SystemProperties {
    public static final SystemProperties INSTANCE = null;

    @JvmField
    public static final String LINE_SEPARATOR = null;

    static {
        INSTANCE = new SystemProperties();
        String r10 = System.getProperty("line.separator");
        Intrinsics.checkNotNull(r10);
        LINE_SEPARATOR = r10;
    }

    private SystemProperties() {
    }
}
