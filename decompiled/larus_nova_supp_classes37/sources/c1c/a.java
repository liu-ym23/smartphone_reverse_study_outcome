package c1c;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public com.ss.android.lark.storage.kv.repo.a a;
    public long b;

    /* JADX INFO: renamed from: c1c.a$a, reason: collision with other inner class name */
    public static class C0003a {
        public long a;
        public long b;
        public long c;
        public long d;

        public C0003a() {
        }

        public final String toString() {
            return this.a + "#" + this.b + "#" + this.c + "#" + this.d;
        }
    }

    public final KVRepo a() {
        if (this.a != null) goto L6;
        this.a = LarkKVStorage.p(new com.ss.android.lark.storage.a("core"), "launch_preload_config", false);
    L6:
        return this.a;
    }

    public a() {
    }
}
