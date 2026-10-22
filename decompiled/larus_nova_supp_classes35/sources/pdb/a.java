package pdb;

import com.ss.android.lark.g;
import com.ss.android.lark.storage.LarkKVStorage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.g(new com.ss.android.lark.storage.a("core"), "fg", false);
    }

    public static com.ss.android.lark.storage.kv.repo.a b(String r4) {
        return LarkKVStorage.n(g.getContext(), r4, new com.ss.android.lark.storage.a("core"), "fg", null);
    }
}
