package t6b;

import com.ss.android.lark.biz.im.api.m1;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends e {
    public final m1 c;
    public List<e.b<?>> d;

    @Override // t6b.e
    public final jya.b d() {
        return null;
    }

    @Override // t6b.e
    public final List<e.b<?>> c() {
        return this.d;
    }

    @Override // t6b.e
    public final m1 e() {
        return this.c;
    }

    public f(e r3) {
        Intrinsics.checkNotNullParameter(r3, "base");
        List<e.b<?>> r0 = null;
        super(null, null, null);
        this.c = r3.e();
        r3.d();
        List<e.b<?>> r4 = r3.c();
        if (r4 == null) goto L5;
        r0 = CollectionsKt.toMutableList(r4);
    L5:
        this.d = r0;
    }
}
