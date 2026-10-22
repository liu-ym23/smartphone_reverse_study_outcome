package com.bytedance.android.ec.core.monitor.param;

import android.net.Uri;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.core.event.EventActionImpl;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECParamTracker extends EventActionImpl implements a {
    public final Map<String, JSONObject> c;
    public List<b> d;
    public final String e;
    public final String f;
    public final ParamReportConfigSetting g;

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void a(final Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        r10.buildUpon().toString();
        p("enter_page", new ECParamTracker$enterPage$1(this, r10));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void b(Function0<? extends JSONObject> r10) {
        Intrinsics.checkNotNullParameter(r10, "dataBuilder");
        p("enter_page", r10);
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void j(Function0 r10) {
        Intrinsics.checkNotNullParameter("buyNow", AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r10, "dataBuilder");
        p("outer_buyNow", r10);
    }

    public static final JSONObject o(ECParamTracker r10, Uri r11) {
        r10.getClass();
        JSONObject r0 = x0.c(r11);
        KtSafeMethodExtensionKt.safePut(r0, "schema_host", r11.getHost());
        List<String> r12 = r10.g.getFilterKeys();
        if (r12 == null) goto L8;
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r0.remove((String) r13.next());
    L8:
        return r0;
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void f(String r10, final Uri r11) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        p("outer_".concat(r10), new ECParamTracker$outer$2(this, r11));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void g(String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        p("outer_".concat(r10), new ECParamTracker$outer$1(this, r11));
    }

    @Override // com.bytedance.android.ec.core.monitor.param.a
    public final void l(String r10, Function0<? extends JSONObject> r11) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "dataBuilder");
        if (StringsKt.startsWith$default(r10, "/", false, 2, null) == false) goto L5;
        String r12 = StringsKt.replace$default(StringsKt.removePrefix(r10, "/"), "/", "_", false, 4, null);
    L6:
        p("request_" + r12, r11);
        return;
    L5:
        r12 = StringsKt.replace$default(r10, "/", "_", false, 4, null);
        goto L6
    }

    public final void p(final String r10, final Function0<? extends JSONObject> r11) {
        b2.b(new ECParamTracker$putParams$1(this, r11, r10));
    }

    public ECParamTracker(String r10, String r11, ParamReportConfigSetting r12) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "sampleConfig");
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.c = new ConcurrentHashMap();
        this.d = new ArrayList();
        initEventContext(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r10), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r11), TuplesKt.to("init_time", String.valueOf(System.currentTimeMillis()))});
        kh.a r13 = new kh.a(r10, r11);
        Intrinsics.checkNotNullParameter(r13, "listener");
        ((ArrayList) this.d).add(r13);
    }
}
