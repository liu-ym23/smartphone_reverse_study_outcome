package geb;

import com.bytedance.lark.molten_livequery_wrapper.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void w(String r3) {
        Intrinsics.checkNotNullParameter("livequery_wrapper", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        c.d("FeedMolten_livequery_wrapper", r3);
    }
}
