package e1;

import android.net.Uri;
import com.bytedance.ai.widget.cache.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends q7.a {
    public final com.bytedance.ai.widget.cache.b e;

    public b(com.bytedance.ai.widget.cache.b r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "loader");
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        super(r10, r11);
        this.e = r5;
    }

    @Override // q7.a, g1.e
    public final Object b(String r5, Continuation r10) {
        Uri.parse(r5).getQueryParameter("forest_session_id");
        e r11 = (e) this.e;
        r11.getClass();
        return e.f(r11, (ContinuationImpl) r10);
    }
}
