package h2b;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends a {
    public final Map<String, PreviewHangPoint> a;
    public final int b;
    public final Map<String, xcb.b> c;
    public final List<String> d;
    public final boolean e;

    @Override // h2b.a
    public int getType() {
        return this.b;
    }

    public c(Map r2, Map r3, List r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "renderMap");
        Intrinsics.checkNotNullParameter(r4, "elementIds");
        this.a = r2;
        this.b = 4;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
