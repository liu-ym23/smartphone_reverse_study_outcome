package com.bytedance.android.live.broadcastgame.openplatform.api;

import am3.g;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\b\tJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/api/MiniAppPreModifyCheckApi;", "", "Lcom/bytedance/android/live/broadcastgame/openplatform/api/MiniAppPreModifyCheckApi$a;", "body", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/openplatform/api/MiniAppPreModifyCheckApi$b;", "preCheck", "a", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniAppPreModifyCheckApi {

    @ProtoMessage("webcast.api.stamp.PreModifyCheckRequest")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/api/MiniAppPreModifyCheckApi$a;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName(OpenPlatformBaseDebugger.APP_ID)
        protected String appId;

        public a(String r1) {
            this.appId = r1;
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.appId, ((a) r2).appId) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.appId;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "PreModifyCheckRequest(appId=" + this.appId + ")";
        }

        public a() {
            this.appId = null;
        }

        public a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.appId = am3.h.c(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
            if (this.appId != null) goto L19;
            this.appId = null;
            return;
        }
    }

    @ProtoMessage("webcast.api.stamp.PreModifyCheckResponse.Data")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/api/MiniAppPreModifyCheckApi$b;", "", "", "grayTip", "Z", "a", "()Z", "setGrayTip", "(Z)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("gray_tip")
        protected boolean grayTip;

        public b() {
        }

        public b(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 2) goto L7;
            this.grayTip = am3.h.a(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }

        public final boolean a() {
            return this.grayTip;
        }
    }

    @Headers({"Content-Type: application/json"})
    @POST("/webcast/microapp/pre_modify_check/")
    Single<e<b>> preCheck(@Body a r1);
}
