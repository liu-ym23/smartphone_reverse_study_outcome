package caa;

import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements z9a.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // z9a.a
    public final void a(FeedbackType r2) {
        Intrinsics.checkNotNullParameter(r2, "feedbackType");
        Lazy r0 = h.a;
        h.b(r2.getTypeName());
    }
}
