package com.bytedance.ai.applet.render.core.relax.monitor;

import a1.a;
import androidx.annotation.Keep;
import com.google.common.reflect.w;
import com.relax.RelaxView;
import com.relax.embedding.InvokeMethod;
import com.relax.embedding.module.NativeModuleCallback;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import oo.j;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001JE\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJE\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJE\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/applet/render/core/relax/monitor/RelaxViewMonitorModule;", "", "", "method", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "args", "Lcom/relax/embedding/module/NativeModuleCallback;", "callback", "", "initConfig", "(Ljava/lang/String;Ljava/util/HashMap;Lcom/relax/embedding/module/NativeModuleCallback;)V", "reportRTSError", "customReport", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRelaxViewMonitorModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RelaxViewMonitorModule.kt\ncom/bytedance/ai/applet/render/core/relax/monitor/RelaxViewMonitorModule\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,89:1\n1863#2,2:90\n216#3,2:92\n*S KotlinDebug\n*F\n+ 1 RelaxViewMonitorModule.kt\ncom/bytedance/ai/applet/render/core/relax/monitor/RelaxViewMonitorModule\n*L\n71#1:90,2\n79#1:92,2\n*E\n"})
public final class RelaxViewMonitorModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f1796a;

    public RelaxViewMonitorModule(RelaxView r5) {
        this.f1796a = new w(r5);
    }

    public static Object a(Object r5) {
        if (r5 != null) goto L6;
        return JSONObject.NULL;
    L6:
        if ((r5 instanceof JSONObject) == false) goto L8;
        return r5;
    L8:
        if ((r5 instanceof JSONArray) == false) goto L11;
        return r5;
    L11:
        if ((r5 instanceof Collection) == false) goto L18;
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) r5).iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r10.put(a(r11.next()));
        goto L14
    L16:
        return r10;
    L18:
        if ((r5 instanceof Map) == false) goto L25;
        JSONObject r12 = new JSONObject();
        Iterator r13 = ((Map) r5).entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r14 = (Map.Entry) r13.next();
        Object r15 = r14.getKey();
        Object r16 = r14.getValue();
        r12.put(String.valueOf(r15), a(r16));
        goto L21
    L23:
        return r12;
    L25:
        if ((r5 instanceof Boolean) == false) goto L27;
        return r5;
    L27:
        if ((r5 instanceof Number) == false) goto L29;
        return r5;
    L29:
        if ((r5 instanceof String) == false) goto L32;
        return r5;
    L32:
        return r5.toString();
    }

    @InvokeMethod
    @Keep
    public final void customReport(String r10, HashMap<String, Object> r11, NativeModuleCallback r12) {
        String r5 = "";
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "args");
        String r13 = "customReport: args = " + r11;
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a.f43a.i("RelaxViewMonitorModule", r13);
        w r14 = this.f1796a;     // Catch: Exception -> L7
        Object r15 = a(r11);     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L7
        r14.h((JSONObject) r15);     // Catch: Exception -> L7
        if (r12 == null) goto L18;
        r12.onSucceeded(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("message", "")}));     // Catch: Exception -> L7
        return;
    L18:
        return;
    L7:
        e = move-exception;
        String r16 = e.getMessage();
        if (r16 == null) goto L12;
        r5 = r16;
    L12:
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a.f43a.e("RelaxViewMonitorModule", r5, e);
        if (r12 == null) goto L19;
        r12.onFailed(-1, e.getMessage());
        return;
    }

    @InvokeMethod
    @Keep
    public final void initConfig(String r10, HashMap<String, Object> r11, NativeModuleCallback r12) {
        String r5 = "";
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "args");
        String r13 = "initConfig: args = " + r11;
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a.f43a.i("RelaxViewMonitorModule", r13);
        Object r14 = a(r11);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L6
        JSONObject r15 = j.f((JSONObject) r14);     // Catch: Exception -> L6
        w r16 = this.f1796a;     // Catch: Exception -> L6
        r16.getClass();     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(r15, "value");     // Catch: Exception -> L6
        if (StringsKt.isBlank((String) r16.f9376b) == false) goto L8;
        String r17 = r15.optString("bid");     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L6
        r16.f9376b = r17;     // Catch: Exception -> L6
    L8:
        r16.d = qo.a.q((JSONObject) r16.d, r15);     // Catch: Exception -> L6
        if (r12 == null) goto L22;
        r12.onSucceeded(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("message", "")}));     // Catch: Exception -> L6
        return;
    L22:
        return;
    L6:
        e = move-exception;
        String r18 = e.getMessage();
        if (r18 == null) goto L16;
        r5 = r18;
    L16:
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a.f43a.e("RelaxViewMonitorModule", r5, e);
        if (r12 == null) goto L23;
        r12.onFailed(-1, e.getMessage());
        return;
    }

    @InvokeMethod
    @Keep
    public final void reportRTSError(String r10, HashMap<String, Object> r11, NativeModuleCallback r12) {
        String r5 = "";
        Intrinsics.checkNotNullParameter(r10, "method");
        Intrinsics.checkNotNullParameter(r11, "args");
        String r13 = "reportRTSError: args = " + r11;
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r13, "msg");
        a.f43a.i("RelaxViewMonitorModule", r13);
        w r14 = this.f1796a;     // Catch: Exception -> L7
        Object r15 = a(r11);     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L7
        r14.k((JSONObject) r15);     // Catch: Exception -> L7
        if (r12 == null) goto L18;
        r12.onSucceeded(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("message", "")}));     // Catch: Exception -> L7
        return;
    L18:
        return;
    L7:
        e = move-exception;
        String r16 = e.getMessage();
        if (r16 == null) goto L12;
        r5 = r16;
    L12:
        Intrinsics.checkNotNullParameter("RelaxViewMonitorModule", "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        a.f43a.e("RelaxViewMonitorModule", r5, e);
        if (r12 == null) goto L19;
        r12.onFailed(-1, e.getMessage());
        return;
    }
}
