package toc;

import android.content.Context;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final com.ss.android.lark.storage.a a = null;

    static {
        a = new com.ss.android.lark.storage.a("media");
    }

    @JvmStatic
    public static final com.ss.android.lark.storage.kv.repo.a a(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "name");
        LarkKVStorage.KVStorageBuilder r0 = new LarkKVStorage.KVStorageBuilder(r3);
        r0.b = "lark";
        return com.ss.android.lark.storage.kv.storage.a.b(r0.b(), a, r4, null, 4);
    }
}
