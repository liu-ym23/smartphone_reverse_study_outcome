package xgb;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.internal.Intrinsics;
import r7b.b;
import r7b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends e {
    public final r7b.a.a b;
    public final r7b.a.b c;

    public final boolean a() {
        return this.b.a();
    }

    public final int j() {
        return this.c.b();
    }

    public a(b<ThreadTopic> r2, r7b.a.a r3, r7b.a.b r4) {
        Intrinsics.checkNotNullParameter(r2, "datasource");
        Intrinsics.checkNotNullParameter(r3, "backToBottomDependency");
        Intrinsics.checkNotNullParameter(r4, "fetcher");
        super(r2);
        this.b = r3;
        this.c = r4;
    }
}
