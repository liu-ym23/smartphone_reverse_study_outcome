package com.bytedance.android.ec.core.hybrid.bridges;

import android.text.TextUtils;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.n;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECReportCpsMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECReportCpsMethod extends ECBaseBridgeMethod {
    public final EcomShowInfoUploadApi e;
    public final String f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECBaseBridgeMethod.a a;

        public a(ECBaseBridgeMethod.a r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            CommerceBaseResponse r11 = (CommerceBaseResponse) r10;
            this.a.onSuccess(null);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECBaseBridgeMethod.a a;

        public b(ECBaseBridgeMethod.a r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            this.a.onFailed(-1, "request fail");
        }
    }

    public ECReportCpsMethod() {
        this.e = (EcomShowInfoUploadApi) n.a.create("https://report.snssdk.com/", EcomShowInfoUploadApi.class);
        this.f = "ec.CPSTrack";
    }

    public final String getName() {
        return this.f;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("cpsTrack");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r11.onFailed(0, "cps track empty");
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("cps_track", r0);
        String r12 = r10.optString("roomID");
        if (TextUtils.isEmpty(r12) == true) goto L8;
        r1.put(com.bytedance.android.ec.core.event.a.KEY_ROOM_ID, r12);
    L8:
        String r13 = r10.optString("productID").toString();
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r1.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_ID, r13);
    L11:
        r1.put("source", "1");
        r1.put("client_ts", String.valueOf(System.currentTimeMillis()));
        r1.put("sdk_version", "25.7.0.1");
        this.e.requestWithParams(r1, 0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r11), new b(r11));
    }
}
