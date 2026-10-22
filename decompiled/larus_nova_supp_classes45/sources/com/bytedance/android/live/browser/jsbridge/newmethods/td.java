package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.e10;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class td extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final /* synthetic */ zd a;

    public final void onTerminate() {
    }

    public td(zd r1) {
        this.a = r1;
    }

    public final void invoke(Object r26, CallContext r27) {
        JSONObject r1 = (JSONObject) r26;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r27, "context");
        this.a.getClass();
        zd.b("connect message manager");
        zd.a(this.a);
        JSONObject r2 = new JSONObject();
        Long r4 = StringsKt.toLongOrNull(r1.optString("roomID", ""));
        if (r4 != null) goto L5;
        r2.put("code", 0);
        finishWithResult(r2);
        return;
    L5:
        String r7 = r1.optString("scene", "venue");
        int r9 = r1.optInt("service", 0);
        int r6 = r1.optInt("method", 0);
        JSONObject r3 = r1.optJSONObject("custom_params");
        HashMap r11 = new HashMap();
        if (r3 == null) goto L12;
        Iterator<String> r12 = r3.keys();
        if (r12 == null) goto L12;
    L10:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        r11.put(r13, r3.get(r13).toString());
    L12:
        r11.put("room_id", String.valueOf(r4.longValue()));
        zd r5 = this.a;
        Integer r18 = null;
        if (r9 <= 0) goto L16;
        if (r6 <= 0) goto L16;
        r27.getContext();
        st2.b.b r8 = com.bytedance.android.livesdk.utils.z4.c(r9, r6, r11);
    L46:
        r5.a = r8;
        vlc.d r14 = this.a.a;
        if (r14 == null) goto L49;
        r14.startMessage();
    L49:
        zd r15 = this.a;
        StringBuilder r16 = new StringBuilder("create and start message manager: ");
        vlc.d r17 = this.a.a;
        if (r17 == null) goto L52;
        r18 = Integer.valueOf(r17.hashCode());
    L52:
        r16.append(r18);
        r16.append(", roomId: ");
        r16.append(r4);
        String r19 = r16.toString();
        r15.getClass();
        zd.b(r19);
        r2.put("code", 1);
        finishWithResult(r2);
        return;
    L16:
        Context r110 = r27.getContext();
        long r111 = r4.longValue();
        Map r112 = MapsKt.emptyMap();
        String r113 = jc1.k.f(IMiddlewareUserService.class).user().n();
        ArrayList r21 = new ArrayList();
        r21.add(new com.bytedance.android.livesdk.message.interceptor.d(r111));
        vlc.j r22 = com.bytedance.android.livesdk.utils.z4.d();
        if (r22 == null) goto L19;
        r21.add(r22);
    L19:
        ArrayList r114 = new ArrayList();
        if ((r22 instanceof vlc.j) == false) goto L22;
        r114.add(r22);
    L22:
        hm2.n r23 = new hm2.n(r110, r7, r111, r113, r112, r21, r114);
        int r24 = vs1.d.a;
        Intrinsics.checkNotNullParameter(r7, "scene");
        List r25 = ((vs1.e) e10.a.getValue()).a();
        if (r25 == null) goto L36;
        Iterator r28 = r25.iterator();
    L26:
        if (r28.hasNext() == false) goto L34;
        Object r29 = r28.next();
        vs1.d r115 = (vs1.d) r29;
        if (r115 == null) goto L30;
        String r116 = r115.b();
    L32:
        if (Intrinsics.areEqual(r116, r7) == false) goto L26;
    L35:
        vs1.d r31 = (vs1.d) r29;
    L37:
        if (r31 != null) goto L39;
    L45:
        r8 = amc.f.a(r23);
        goto L46
    L39:
        if (r31.d() == false) goto L45;
        if (r31.c() <= 0) goto L45;
        if (r31.a() <= 0) goto L45;
        r8 = st2.b.a(r31.c(), r31.a(), r23.f(), r21, r114, Collections.emptyList());
        goto L46
    L30:
        r116 = null;
        goto L32
    L34:
        r29 = null;
        goto L35
    L36:
        r31 = null;
        goto L37
    }
}
