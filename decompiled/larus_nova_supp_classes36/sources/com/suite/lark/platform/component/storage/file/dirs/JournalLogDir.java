package com.suite.lark.platform.component.storage.file.dirs;

import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Deprecated(message = " temporary using, may refactor in the future")
public final class JournalLogDir {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static String c;

    static {
        a = LazyKt.lazy(JournalLogDir$internalPath$2.INSTANCE);
        b = LazyKt.lazy(JournalLogDir$externalPath$2.INSTANCE);
    }
}
