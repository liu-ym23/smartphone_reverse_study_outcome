package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class CloudExecutor {
    public static final /* synthetic */ int d = 0;
    public final ConcurrentLinkedQueue<a> a;
    public final Lazy b;
    public final String c;

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor$a$a, reason: collision with other inner class name */
        public static final class C0060a {
            public static void a(CloudResultType$ClientResultType r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "clientResultType");
                Intrinsics.checkNotNullParameter(r3, "errMsg");
                ALogger.d("CloudExecutor_CloudRequestListener", "onFail, clientResultType:" + r2 + ", errNo:" + r2.getErrNo() + ", message:" + r3);
            }
        }

        void a(CloudResultType$ClientResultType r1, String r2);

        void onSuccess();
    }

    public static final class b {
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ CloudExecutor a;

        public c(CloudExecutor r1) {
            this.a = r1;
        }

        public final Object apply(Object r9) {
            Intrinsics.checkNotNullParameter((String) r9, "it");
            Lazy r11 = CloudSPHelper.a;
            if (CloudSPHelper.c(this.a.c) == true) goto L6;
            ALogger.i("CloudExecutor_refreshSid", "not login");
            this.a.a(CloudResultType$ClientResultType.NotLogin, null, null);
        L10:
            return Unit.INSTANCE;
        L6:
            if (CloudSPHelper.b(this.a.c) <= (System.currentTimeMillis() / ((long) 1000))) goto L8;
            ALogger.i("CloudExecutor_refreshSid", "not expired");
            this.a.b(null);
            goto L10
        L8:
            ALogger.i("CloudExecutor_refreshSid", "sid expired, do request");
            f.d(this.a.d(), "https://dycloud.volces.com", CloudConstant$Method.GET, "/api/gateway/refresh_session/", MapsKt.mapOf(TuplesKt.to("X-TT-APPID", this.a.c)), MapsKt.mapOf(TuplesKt.to("sid", CloudSPHelper.a(this.a.c))), new CloudExecutor$refreshSid$2$1(this), new CloudExecutor$refreshSid$2$2(this));
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CloudExecutor a;

        public e(CloudExecutor r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            ALogger.d("CloudExecutor_refreshSid", r9.getMessage());
            if ((r9 instanceof TimeoutException) == false) goto L5;
            CloudResultType$ClientResultType r0 = CloudResultType$ClientResultType.NetworkTimeOut;
        L6:
            CloudExecutor r1 = this.a;
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            r1.a(r0, String.format(r0.getErrMsg(), Arrays.copyOf(new Object[]{o1.a(r9), Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r9))}, 2)), null);
            return;
        L5:
            r0 = CloudResultType$ClientResultType.NetworkError;
            goto L6
        }
    }

    public final f d() {
        return (f) this.b.getValue();
    }

    static {
        new CloudExecutor("");
    }

    public CloudExecutor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        this.c = r2;
        this.a = new ConcurrentLinkedQueue();
        this.b = LazyKt.lazy(CloudExecutor$cloudNetworkExecutor$2.INSTANCE);
    }

    public final void b(a r2) {
        if (r2 == null) goto L4;
        r2.onSuccess();
    L4:
        if (r2 != null) goto L12;
        Iterator<T> r3 = this.a.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ((a) r3.next()).onSuccess();
        goto L7
    L9:
        this.a.clear();
        return;
    }

    public final void e(a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ALogger.i("CloudExecutor_refreshSid", "refreshSid start");
        if (this.a.isEmpty() == false) goto L5;
        this.a.add(r3);
        Single.just(this.c).subscribeOn(Schedulers.io()).map(new c(this)).subscribe(d.a, new e(this));
        return;
    L5:
        ALogger.i("CloudExecutor_refreshSid", "refresh task already exist");
        this.a.add(r3);
    }

    public final void a(CloudResultType$ClientResultType r3, String r4, a r5) {
        if (r5 == null) goto L7;
        if (r4 != null) goto L5;
        String r0 = r3.getErrMsg();
    L6:
        r5.a(r3, r0);
        goto L7
    L5:
        r0 = r4;
    L7:
        if (r5 != null) goto L21;
        Iterator<T> r6 = this.a.iterator();
    L10:
        if (r6.hasNext() == false) goto L16;
        a r1 = (a) r6.next();
        if (r4 != null) goto L14;
        String r2 = r3.getErrMsg();
    L15:
        r1.a(r3, r2);
        goto L10
    L14:
        r2 = r4;
        goto L15
    L16:
        this.a.clear();
        return;
    }

    public final void c(int r11, String r12, String r13, final a r14, boolean r15) {
        ALogger.i("CloudExecutor_dealWithSidResponse", "statusCode:" + r11 + ", reason:" + r12);
        if (r11 != 200) goto L31;
        int r16 = j.d;
        JSONObject r17 = new JSONObject(r13);
        Intrinsics.checkNotNullParameter(r17, "json");
        Long r5 = null;
        j r6 = new j(JSONObjectProtectorUtils.getInt(r17, "status_code"), r17.optString("status_message", null));
        JSONObject r18 = r17.optJSONObject("data");
        if (r18 == null) goto L7;
        int r0 = j.b.c;
        Intrinsics.checkNotNullParameter(r18, "json");
        j.b r19 = new j.b();
        String r1 = r18.optString("sid");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r19.a = r1;
        r19.b = r18.optLong("expire_in");
        r6.a = r19;
    L7:
        ALogger.i("CloudExecutor_dealWithSidResponse", "response: " + r6);
        if (r6.b != CloudResultType$OpenPlatformServerResultType.Success.getErrNo()) goto L21;
        Lazy r110 = CloudSPHelper.a;
        String r111 = this.c;
        j.b r112 = r6.a;
        if (r112 == null) goto L12;
        String r113 = r112.a;
    L13:
        if (r112 == null) goto L15;
        r5 = Long.valueOf(r112.b);
    L15:
        Intrinsics.checkNotNullParameter(r111, "appId");
        JSONObject r114 = new JSONObject();
        r114.put("sid", r113);     // Catch: JSONException -> L18
        r114.put("expiredTime", r5);     // Catch: JSONException -> L18
    L20:
        ((SharedPrefHelper) CloudSPHelper.a.getValue()).m(r111, r114.toString());
        ALogger.d("CloudSPHelper_saveSId", "appId:" + r111 + ", sid:" + r113 + ", expiredTime:" + r5);
        b(r14);
        return;
    L18:
        e = move-exception;
        ALogger.e("CloudSPHelper_saveSid", e);
        goto L20
    L12:
        r113 = null;
        goto L13
    L21:
        ALogger.i("CloudExecutor_dealWithSidResponse", "server error: errNo = " + r6.b + ", errMsg = " + r6.c);
        if (r6.b != CloudResultType$OpenPlatformServerResultType.NotFaasFunction.getErrNo()) goto L24;
        boolean r115 = true;
    L25:
        if (r115 == false) goto L27;
        ALogger.i("CloudExecutor_dealWithSidResponse", "not available faas function");
    L27:
        if (r15 == false) goto L30;
        if (r115 == true) goto L30;
        int r116 = CloudLoginService.a;
        CloudLoginService.a(this, new CloudExecutor$dealWithSidResponse$1(this, r14), new CloudExecutor$dealWithSidResponse$2(this, r14));
        return;
    L30:
        CloudResultType$ClientResultType r117 = CloudResultType$ClientResultType.ServerError;
        StringCompanionObject r118 = StringCompanionObject.INSTANCE;
        a(r117, String.format(r117.getErrMsg(), Arrays.copyOf(new Object[]{r6.c, Integer.valueOf(r6.b)}, 2)), r14);
        return;
    L24:
        r115 = false;
        goto L25
    L31:
        CloudResultType$ClientResultType r119 = CloudResultType$ClientResultType.NetworkUnavailable;
        StringCompanionObject r120 = StringCompanionObject.INSTANCE;
        a(r119, String.format(r119.getErrMsg(), Arrays.copyOf(new Object[]{r12, Integer.valueOf(r11)}, 2)), r14);
    }
}
