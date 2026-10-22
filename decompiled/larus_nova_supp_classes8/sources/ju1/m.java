package ju1;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements h {
    public final String a;
    public final int b;

    @Override // ju1.h
    public final String d() {
        return "SimpleStrategy";
    }

    @Override // ju1.h
    public final boolean f() {
        return true;
    }

    @Override // ju1.h
    public final Object a() {
        return Integer.valueOf(this.b);
    }

    @Override // ju1.h
    public final List<String> c() {
        return CollectionsKt.emptyList();
    }

    @Override // ju1.h
    public final List<String> e() {
        return CollectionsKt.emptyList();
    }

    @Override // ju1.h
    public final String b() {
        return this.a;
    }

    public m(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        this.a = r2;
        this.b = r3;
    }
}
