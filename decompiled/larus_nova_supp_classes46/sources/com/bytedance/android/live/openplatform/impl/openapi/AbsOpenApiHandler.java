package com.bytedance.android.live.openplatform.impl.openapi;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.vd0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yo0.c;
import yo0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class AbsOpenApiHandler implements c {
    public final Map<String, yo0.a> a;
    public final Map<String, Queue<Long>> b;
    public final OpenPlatformContext c;
    public final String d;

    public AbsOpenApiHandler(OpenPlatformContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        this.c = r2;
        this.d = r3;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        b("getRoomInfo", new AnonymousClass1(this));
        b("getUserInfo", new AnonymousClass2(this));
        b("isFollowingAnchor", new AnonymousClass3(this));
    }

    @Override // yo0.c
    public final void a(JSONObject r12, yo0.a.InterfaceC0296a r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r0 = r12.optString("eventName");
        yo0.a r1 = (yo0.a) ((LinkedHashMap) this.a).get(r0);
        boolean r3 = true;
        if (this.c.isAnchor() == false) goto L7;
        List r2 = ((uc1) ee0.a.getValue()).a();
        if (r2 == null) goto L10;
        boolean r4 = r2.contains(r0);
    L11:
        if (r1 == null) goto L54;
        if (r4 == false) goto L54;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        yo0.a.b r5 = new yo0.a.b(r13);
        String r14 = r1.b();
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r5, "callback");     // Catch: Throwable -> L51
        Intrinsics.checkNotNullParameter(r14, "method");     // Catch: Throwable -> L51
        if (v.a() == true) goto L19;
    L22:
        BootConfigContextService.b r6 = ((BootConfigContextService) r1.b.getService(BootConfigContextService.class)).f(r1.d, r14);     // Catch: Throwable -> L51
        if (r6 != null) goto L27;
        yo0.a.b.b(r5, OpenApiErrorInfo.NO_REQUEST_PERMISSION);     // Catch: Throwable -> L51
        monitor-exit(r1);
    L44:
        r3 = false;
    L49:
        if (r3 == false) goto L57;
        r1.call(r12, r5);
        return;
    L57:
        return;
    L27:
        int r7 = r6.a;     // Catch: Throwable -> L51
        int r8 = r6.b;     // Catch: Throwable -> L51
        if (((ArrayList) r1.a).contains(r14) == true) goto L48;
        if (r8 == 0) goto L48;
        if (r7 != 0) goto L35;
        yo0.a.b.b(r5, OpenApiErrorInfo.NO_REQUEST_PERMISSION);     // Catch: Throwable -> L51
        monitor-exit(r1);
        goto L44
    L35:
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (r1.c.size() >= r7) goto L41;
        r1.c.offer(Long.valueOf(r9));     // Catch: Throwable -> L51
        monitor-exit(r1);
        goto L49
    L41:
        if ((r9 - r1.c.peek().longValue()) > (r8 * 1000)) goto L45;
        yo0.a.b.b(r5, OpenApiErrorInfo.EXCEED_FREQ_LIMIT);     // Catch: Throwable -> L51
        monitor-exit(r1);
        goto L44
    L45:
        r1.c.poll();     // Catch: Throwable -> L51
        r1.c.offer(Long.valueOf(r9));     // Catch: Throwable -> L51
        monitor-exit(r1);
    L48:
        monitor-exit(r1);
        goto L49
    L19:
        if (Intrinsics.areEqual(vd0.a.getValue(), Boolean.FALSE) == false) goto L22;
        monitor-exit(r1);
    L51:
        th = move-exception;
        throw th;
    L54:
        d.a.d.getClass();
        r13.a(d.a.C0297a.a(-2, "Function " + r0 + " is not registered.", null).a());
        return;
    L10:
        r4 = true;
        goto L11
    L7:
        List r10 = ((uc1) ee0.a.getValue()).b();
        if (r10 == null) goto L10;
        r4 = r10.contains(r0);
        goto L11
    }

    public final void b(String r4, Function1<? super Queue<Long>, ? extends yo0.a> r5) {
        Intrinsics.checkNotNullParameter(r4, "methodName");
        Intrinsics.checkNotNullParameter(r5, "methodProvider");
        Map<String, yo0.a> r0 = this.a;
        LinkedHashMap r1 = (LinkedHashMap) this.b;
        Object r2 = r1.get(r4);
        if (r2 != null) goto L5;
        r2 = new LinkedList();
        r1.put(r4, r2);
    L5:
        r0.put(r4, (yo0.a) r5.invoke(r2));
    }

    @Override // yo0.c
    public final void sendEvent(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        IHostLiveOpenPlatform r1 = TTLiveSDK.hostService().hostOpenPlatform();
        String r2 = this.d;
        JSONObject r3 = new JSONObject();
        r3.put("eventName", r5);
        r3.put("data", r6);
        Unit r7 = Unit.INSTANCE;
        r1.dispatchHostEvent(r2, "live_open_api", r3);
    }
}
