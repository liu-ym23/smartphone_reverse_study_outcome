package x20;

import ac2.s;
import ac2.z;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.ss.ugc.live.sdk.msg.network.HttpMethod;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.sendByteLinkApiRequest", owner = "JiangXZ")
public final class e extends a implements h {
    public final void release() {
    }

    public e() {
    }

    public static com.ss.ugc.live.sdk.msg.network.f a(IBDXBridgeContext r7, a.b r8, HttpMethod r9) {
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "method");
        LinkedHashMap r0 = new LinkedHashMap();
        Map<String, Object> r1 = r8.getHeaders();
        if (r1 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Object> r3 = r2.next();
        r0.put(r3.getKey(), r3.getValue().toString());
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        Map<String, Object> r5 = r8.getQueryParams();
        if (r5 == null) goto L14;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, Object> r11 = r6.next();
        r4.put(r11.getKey(), r11.getValue().toString());
    L14:
        IMiddlewareNetworkService r12 = k.f(IMiddlewareNetworkService.class);
        if (r12 == null) goto L17;
        r4.putAll(r12.getCommonParams());
    L17:
        IMiddlewareHostNetwork r13 = k.f(IMiddlewareHostNetwork.class);
        if (r13 == null) goto L20;
        r4.putAll(r13.getCommonParams());
    L20:
        String r14 = r8.getHttpURL();
        boolean r15 = false;
        byte[] r16 = null;
        if (r14 != null) goto L23;
    L31:
        Set r17 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r18 = "x-security-argus";
        if ("x-security-argus".length() <= 0) goto L34;
        boolean r19 = true;
    L35:
        if (r19 == true) goto L38;
        r18 = null;
    L38:
        String r21 = SecurityContextUtils.d(r7);
        if (r21.length() <= 0) goto L41;
        r15 = true;
    L41:
        if (r15 == true) goto L44;
        r21 = null;
    L44:
        if (r18 == null) goto L47;
        if (r21 == null) goto L47;
        String r22 = (String) r0.put(r18, r21);
    L47:
        com.ss.ugc.live.sdk.msg.network.f.a r23 = new com.ss.ugc.live.sdk.msg.network.f.a();
        String r24 = r8.getHttpURL();
        if (r24 != null) goto L50;
        r24 = "";
    L50:
        com.ss.ugc.live.sdk.msg.network.f r25 = r23.a;
        r25.b = r24;
        r25.c = r0;
        com.ss.ugc.live.sdk.msg.network.f.a r26 = r23.query(r4);
        r26.a.a = r9;
        Number r27 = r8.getTimeout();
        if (r27 == null) goto L53;
        long r28 = r27.longValue();
    L54:
        com.ss.ugc.live.sdk.msg.network.f r29 = r26.a;
        r29.i = r28;
        r29.g = "application/json";
        r29.l = true;
        String r31 = r8.getPayload();
        if (r31 == null) goto L57;
        r16 = r31.getBytes(Charsets.UTF_8);
    L57:
        r26.a.e = r16;
        return r26.a();
    L53:
        r28 = 2000;
        goto L54
    L34:
        r19 = false;
        goto L35
    L23:
        if (r14.length() <= 0) goto L25;
        boolean r32 = true;
    L26:
        if (r32 == true) goto L29;
        r14 = null;
    L29:
        if (r14 == null) goto L31;
        r0.putAll(s.a(r14, false));
        goto L31
    L25:
        r32 = false;
        goto L26
    }

    public final void handle(IBDXBridgeContext r5, XBaseParamModel r6, CompletionBlock r7) {
        a.b r8 = (a.b) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Number r0 = r8.getMethod();
        if (Intrinsics.areEqual(r0, 1) == false) goto L6;
        com.ss.ugc.live.sdk.msg.network.f r9 = a(r5, r8, HttpMethod.GET);
    L8:
        long r1 = r8.getServiceID().longValue();
        z r2 = ac2.c.a;
        Intrinsics.checkNotNullParameter(r9, "httpRequest");
        Logger.i("LiveUplink", "start sendRequest");
        Observable.create(new ac2.b(r1, r9)).subscribeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(new c(r7, r8), new d(r7, r8));
        return;
    L6:
        if (Intrinsics.areEqual(r0, 2) == false) goto L9;
        r9 = a(r5, r8, HttpMethod.POST);
        goto L8
    L9:
        r7.onFailure(0, "Method isNot Support", ne7.e.b(a.c.class));
    }
}
