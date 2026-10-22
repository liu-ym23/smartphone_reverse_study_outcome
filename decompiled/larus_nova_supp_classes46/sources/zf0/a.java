package zf0;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a {
    public final String a;
    public final py.k b;
    public final long c;

    public final String toString() {
        return "name:" + this.a + ", id:" + this.c + ", icon:" + ((String) ListProtector.get(this.b.getUrls(), 0));
    }

    public a(String r2, py.k r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "icon");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
