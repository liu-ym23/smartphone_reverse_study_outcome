package cyb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.opmonitor.trace.OPTraceGSONParser;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static d a;
    public static List<String> b;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/ss/android/lark/opmonitor/config/MinaConfigKt$getTracingConfig$types$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/ss/android/lark/opmonitor/config/TraceConfig;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class a extends TypeToken<d> {
        public a() {
        }
    }

    public static final d a() {
        if (a != null) goto L10;
        int r0 = iyb.a.a;
        int r1 = iyb.a.a;
        Intrinsics.checkNotNullParameter("optrace_batch_config", "configKey");
        if (TextUtils.isEmpty("") == true) goto L8;
        Type r2 = new a().getType();
        Gson r3 = OPTraceGSONParser.a;
        a = (d) GsonProtectorUtils.fromJson(OPTraceGSONParser.a, "", r2);
    L8:
        if (a != null) goto L10;
        a = new d();
    L10:
        d r4 = a;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.opmonitor.config.TraceConfig");
        return r4;
    }
}
