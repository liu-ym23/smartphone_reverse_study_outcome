package ha1;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements c {
    public b() {
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r2, WebcastRedirectReportInfo r3, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r4, Function3<? super Integer, ? super String, ? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "reportInfo");
        Intrinsics.checkNotNullParameter(r4, "success");
        Intrinsics.checkNotNullParameter(r5, "fail");
        r3.a("schema_source", "unknown");
        r5.invoke(Integer.valueOf(WebcastRedirectException.MISS_REDIRECT_RULE), "", Boolean.TRUE);
    }
}
