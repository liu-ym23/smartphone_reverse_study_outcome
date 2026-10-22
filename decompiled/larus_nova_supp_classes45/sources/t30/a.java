package t30;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import com.bytedance.android.live.schema.api.b;
import com.bytedance.android.live.schema.api.c;
import com.bytedance.android.livesdk.config.kg1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements c {
    public a() {
    }

    public final void c(b r3, WebcastRedirectReportInfo r4, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r5, Function3<? super Integer, ? super String, ? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "reportInfo");
        Intrinsics.checkNotNullParameter(r5, "success");
        Intrinsics.checkNotNullParameter(r6, "fail");
        r4.a("schema_source", "setting");
        Map r0 = (Map) kg1.a.getValue();
        String r7 = (String) r0.get(r3.c);
        if (r7 == null) goto L6;
        r4.a("get_type", IInteractGameMonitorService.LOCAL_SOURCE);
        r5.invoke(new com.bytedance.android.live.schema.api.a(r7));
        return;
    L6:
        r6.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "webcast settings has " + r0.size() + " rules", Boolean.FALSE);
    }
}
