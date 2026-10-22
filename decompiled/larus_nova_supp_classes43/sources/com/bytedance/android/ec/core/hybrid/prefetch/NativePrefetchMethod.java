package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.common.utility.Logger;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/NativePrefetchMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NativePrefetchMethod extends ECBaseBridgeMethod {
    public static final /* synthetic */ int f = 0;
    public final String e;

    public static final class a {
        public static void a(ECBaseBridgeMethod.a r10, String r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r10, "$this$onFinish");
            Intrinsics.checkNotNullParameter(r11, "errMsg");
            Intrinsics.checkNotNullParameter(r12, "data");
            JSONObject r1 = new JSONObject();
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
            r1.putOpt("code", 0);     // Catch: Throwable -> L5
            r1.putOpt(com.bytedance.android.ec.core.event.a.KEY_STATUS, 2);     // Catch: Throwable -> L5
            r1.putOpt("errorMessage", r11);     // Catch: Throwable -> L5
            Result.constructor-impl(r1.putOpt("data", r12));     // Catch: Throwable -> L5
        L7:
            r10.a(r1);
            return;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class b implements ECBaseBridgeMethod.a {
        public final /* synthetic */ NativePrefetchMethod a;
        public final /* synthetic */ ECBaseBridgeMethod.a b;
        public final /* synthetic */ JSONObject c;

        public final void a(JSONObject r10) {
            NativePrefetchMethod r0 = this.a;
            JSONObject r1 = this.c;
            int r11 = NativePrefetchMethod.f;
            r0.getClass();
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
            boolean r13 = false;
            if (r1 == null) goto L6;
            Integer r14 = Integer.valueOf(r1.optInt("jsb_invoke_back_mode", 0));     // Catch: Throwable -> L17
        L8:
            if (r14 != null) goto L10;
        L12:
            if (r13 == false) goto L15;
            if (r10 == null) goto L15;
            r10.putOpt("__jsb_invoke_back_mode", 1);     // Catch: Throwable -> L17
        L15:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            this.b.a(r10);
            return;
        L10:
            if (r14.intValue() <= 0) goto L12;
            r13 = true;
            goto L12
        L6:
            r14 = null;
        L17:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L19
        }

        public final void b(Object r10) {
            this.b.b(r10);
        }

        public final void onSuccess(Object r10) {
            this.b.onSuccess(r10);
        }

        public final void onFailed(int r10, String r11) {
            this.b.onFailed(r10, r11);
        }

        public b(NativePrefetchMethod r1, ECBaseBridgeMethod.a r10, JSONObject r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    static {
    }

    public NativePrefetchMethod() {
        this(0);
    }

    public final String getName() {
        return this.e;
    }

    public NativePrefetchMethod(int r10) {
        Intrinsics.checkNotNullParameter("nativePrefetch", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.e = "nativePrefetch";
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("requestId");
        String r1 = r10.optString("api_key");
        boolean r12 = r10.optBoolean("fix_callback", false);
        if (com.bytedance.forest.utils.h.a(r0) == true) goto L5;
    L45:
        Logger.i("NativePrefetchMethod", "get data error request id is " + r0 + ", api_key is " + r1);
        if (r12 == false) goto L52;
        a.a(r11, "invalid params! request_id=" + r0 + ", api_key=" + r1, new JSONObject());
        return;
    L52:
        return;
    L5:
        if (com.bytedance.forest.utils.h.a(r1) == false) goto L45;
        ConcurrentHashMap<String, NativePrefetch> r13 = NativePrefetchUtil.a;
        b r14 = new b(this, r11, r10);
        Intrinsics.checkNotNullParameter(r0, "requestId");
        Intrinsics.checkNotNullParameter(r1, "apiKey");
        Intrinsics.checkNotNullParameter(r14, "callback");
        NativePrefetch r15 = NativePrefetchUtil.a.get(r0);
        if (r15 != null) goto L10;
        if (r12 == false) goto L10;
        a.a(r14, "prefetch task not found! request_id=" + r0 + ", api_key=" + r1, new JSONObject());
        return;
    L10:
        if (r15 == null) goto L51;
        monitor-enter(r15);
        Intrinsics.checkNotNullParameter(r1, "apiKey");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r14, "callback");     // Catch: Throwable -> L42
        q r16 = r15.r(r1);     // Catch: Throwable -> L42
        r16.e(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        NativePrefetch.a r17 = (NativePrefetch.a) ((LinkedHashMap) r15.c).get(r1);     // Catch: Throwable -> L42
        if (r17 == null) goto L16;
        r17.c = r16;     // Catch: Throwable -> L42
    L16:
        if (r15.c.containsKey(r1) == false) goto L39;
        NativePrefetch.a r18 = (NativePrefetch.a) ((LinkedHashMap) r15.c).get(r1);     // Catch: Throwable -> L42
        if (r18 == null) goto L20;
        o r19 = r18.b;     // Catch: Throwable -> L42
    L21:
        if (r19 != null) goto L25;
        NativePrefetch.a r20 = (NativePrefetch.a) ((LinkedHashMap) r15.c).get(r1);     // Catch: Throwable -> L42
        if (r20 == null) goto L36;
        r20.a = r14;     // Catch: Throwable -> L42
    L36:
        NativePrefetch.a r21 = (NativePrefetch.a) ((LinkedHashMap) r15.c).get(r1);     // Catch: Throwable -> L42
        if (r21 == null) goto L40;
        r21.b = null;     // Catch: Throwable -> L42
    L40:
        monitor-exit(r15);
        return;
    L25:
        int r22 = r19.b;     // Catch: Throwable -> L42
        if (r22 != 1) goto L31;
        q r23 = r15.r(r1);     // Catch: Throwable -> L42
        r23.d(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L42
        NativePrefetch.a r24 = (NativePrefetch.a) ((LinkedHashMap) r15.c).get(r1);     // Catch: Throwable -> L42
        if (r24 == null) goto L30;
        r24.c = r23;     // Catch: Throwable -> L42
    L30:
        r15.G(r1, r19, r14);     // Catch: Throwable -> L42
        goto L36
    L31:
        Integer r25 = Integer.valueOf(r22);     // Catch: Throwable -> L42
        if (r25 == null) goto L34;
        int r26 = r25.intValue();     // Catch: Throwable -> L42
    L35:
        r15.l(r1, r26, r14, "");     // Catch: Throwable -> L42
        goto L36
    L34:
        r26 = 2;
        goto L35
    L20:
        r19 = null;
        goto L21
    L39:
        r15.l(r1, 3, r14, "not find this request id");     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }
}
