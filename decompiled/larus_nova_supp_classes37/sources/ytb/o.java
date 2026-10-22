package ytb;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class o implements com.ss.android.lark.chat.core.api.d {
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        Intrinsics.checkNotNullParameter(r3, "chatId");
    }

    @Inject
    public o() {
        kotlinx.coroutines.flow.e.a(SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null));
    }
}
