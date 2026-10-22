package e00;

import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.live.core.privacy.av.api.b {
    public final /* synthetic */ Function2 b;

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void c(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r2, String r3, String r4, Map<String, String> r5, com.bytedance.android.live.core.privacy.av.api.a r6) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
    }

    public a(Function2 r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r2, String r3, String r4, Map r5, com.bytedance.android.live.core.privacy.av.api.a r6, AudioAndVideoException r7) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "sense");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "exception");
        Function2 r8 = this.b;
        if (r8 == null) goto L6;
        Unit r9 = (Unit) r8.invoke(r4, r7);
        return;
    }
}
