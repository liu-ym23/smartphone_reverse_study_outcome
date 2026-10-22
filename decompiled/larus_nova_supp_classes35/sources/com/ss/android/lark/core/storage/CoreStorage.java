package com.ss.android.lark.core.storage;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CoreStorage {
    public static final com.ss.android.lark.storage.a a = null;
    public static final Lazy b = null;

    static {
        a = new com.ss.android.lark.storage.a("CORE");
        b = LazyKt.lazy(CoreStorage$isCoreUniFileStorageEnabled$2.INSTANCE);
    }

    @JvmStatic
    public static final h a() {
        VFSFiles r0 = VFSFiles.b;
        boolean r1 = ((Boolean) b.getValue()).booleanValue();
        r0.getClass();
        return VFSFiles.b(r1);
    }
}
