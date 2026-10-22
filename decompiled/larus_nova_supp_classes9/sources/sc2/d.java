package sc2;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.virtualinteract.api.VirtualInteractRetrofitApi;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "interactionCommand")
public final class d extends com.bytedance.ies.web.jsbridge2.f<a, com.bytedance.android.livesdk.interactivity.virtualinteract.model.d> {
    public Disposable a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lsc2/d$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", BuildConfig.FLAVOR, "gameType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "commandType", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("command_type")
        private final String commandType;

        @SerializedName("game_type")
        private final String gameType;

        @SerializedName("room_id")
        private final Long roomId;

        public final String a() {
            return this.commandType;
        }

        public final String b() {
            return this.gameType;
        }

        public final Long c() {
            return this.roomId;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d() {
    }

    public final void invoke(Object r6, CallContext r7) {
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        VirtualInteractRetrofitApi r9 = (VirtualInteractRetrofitApi) com.bytedance.android.live.network.c.b().e(VirtualInteractRetrofitApi.class);
        Disposable r0 = null;
        if (r9 == null) goto L11;
        Pair[] r2 = new Pair[3];
        Long r3 = r8.c();
        if (r3 == null) goto L7;
        String r4 = String.valueOf(r3.longValue());
    L8:
        r2[0] = TuplesKt.to("room_id", r4);
        r2[1] = TuplesKt.to("game_type", r8.b());
        r2[2] = TuplesKt.to("command_type", r8.a());
        Observable<Response<com.bytedance.android.livesdk.interactivity.virtualinteract.model.c>> r10 = r9.sendInteractionCommand(new HashMap(MapsKt.mapOf(r2)));
        if (r10 == null) goto L11;
        Observable r11 = r10.subscribeOn(Schedulers.io());
    L12:
        if (r11 == null) goto L16;
        Observable r13 = r11.observeOn(AndroidSchedulers.mainThread());
        if (r13 == null) goto L16;
        r0 = r13.subscribe(new e(this, r8), new f(this));
    L16:
        this.a = r0;
        return;
    L7:
        r4 = null;
    L11:
        r11 = null;
        goto L12
    }
}
