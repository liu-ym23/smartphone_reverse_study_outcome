package ha1;

import android.text.TextUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.c;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c {
    public a() {
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r5, WebcastRedirectReportInfo r6, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r7, Function3<? super Integer, ? super String, ? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r6, "reportInfo");
        Intrinsics.checkNotNullParameter(r7, "success");
        Intrinsics.checkNotNullParameter(r8, "fail");
        r6.a("schema_source", "default");
        String r0 = r5.f;
        if (r0 == null) goto L10;
        String r2 = UriProtector.parse(r0).getHost();
        if (TextUtils.equals(r2, "webcast_lynxview") == false) goto L7;
    L8:
        r6.a("get_type", "default");
        r7.invoke(new com.bytedance.android.live.schema.api.a(r0));
        return;
    L7:
        if (TextUtils.equals(r2, "webcast_webview") == true) goto L8;
    L10:
        r8.invoke(Integer.valueOf(WebcastRedirectException.MISS_REDIRECT_RULE), "default schema " + r5.f, Boolean.FALSE);
    }
}
