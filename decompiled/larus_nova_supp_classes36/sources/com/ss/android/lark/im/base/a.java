package com.ss.android.lark.im.base;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final com.ss.android.lark.storage.a a = null;
    public static final com.ss.android.lark.storage.a b = null;

    static {
        a = new com.ss.android.lark.storage.a("IM");
        b = new com.ss.android.lark.storage.a("Common");
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.q(a, true);
    }

    @JvmStatic
    public static final h b() {
        VFSFiles.b.getClass();
        return VFSFiles.b(true);
    }
}
