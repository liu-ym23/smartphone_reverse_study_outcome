package v3b;

import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements d<w3b.b, ChatMessageResponse> {
    public final AtomicInteger a;

    @Inject
    public c() {
        this.a = new AtomicInteger(0);
    }

    @Override // v3b.d
    public final String a(w3b.d r2) {
        w3b.b r3 = (w3b.b) r2;
        Intrinsics.checkNotNullParameter(r3, "task");
        return r3.a() + '_' + this.a.incrementAndGet();
    }
}
