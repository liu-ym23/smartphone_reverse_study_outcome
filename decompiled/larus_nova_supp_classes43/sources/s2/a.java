package s2;

import com.bytedance.ai.widget.cache.b;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateBundle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import q2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends c {
    public final b e;

    @Override // q2.c, w2.d
    public final Object a(String r10, Continuation<? super TemplateBundle> r11) {
        UriProtector.getQueryParameter(UriProtector.parse(r10), "forest_session_id");
        return this.e.c(r11);
    }

    public a(b r10, String r11, boolean r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        super(r11, r12, r13, r14);
        this.e = r10;
    }
}
