package kcb;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.util.share_preference.UserSP;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.f(new com.ss.android.lark.storage.a("core"), "dynamic_config", new n6c.a(eac.a.a()));
    }

    public static com.ss.android.lark.storage.kv.repo.a c() {
        return LarkKVStorage.o(new com.ss.android.lark.storage.a("core"), "dynamic_config", new n6c.a(UserSP.getInstance()));
    }

    public static com.ss.android.lark.storage.kv.repo.a b(String r3) {
        LarkKVStorage.KVStorageBuilder r0 = new LarkKVStorage.KVStorageBuilder(LarkContext.getApplication());
        r0.b = "lark";
        LarkKVStorage.b r1 = LarkKVStorage.r(r0.b());
        com.ss.android.lark.storage.a r2 = new com.ss.android.lark.storage.a("core_mmkv");
        Intrinsics.checkNotNullParameter(r2, "domain");
        r1.b = r2;
        r1.c = r3;
        return r1.a();
    }
}
