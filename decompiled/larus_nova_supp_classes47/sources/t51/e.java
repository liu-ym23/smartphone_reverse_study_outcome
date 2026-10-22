package t51;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lt51/e;", "Lt51/b;", "", "", "rtcPushMode", "Ljava/util/Map;", "q", "()Ljava/util/Map;", "t", "(Ljava/util/Map;)V", "liveCorePushMode", "p", "r", "pushInfoIndex", "I", "getPushInfoIndex", "()I", "s", "(I)V", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e extends b {

    @SerializedName("liveCore_push_mode")
    private Map<Integer, Integer> liveCorePushMode;

    @SerializedName("push_info_index")
    private int pushInfoIndex;

    @SerializedName("rtc_push_mode")
    private Map<Integer, Integer> rtcPushMode;

    public final void s() {
        this.pushInfoIndex = 2;
    }

    @Override // t51.b
    public final String toString() {
        return "Region(x=" + e() + ", y=" + f() + ", w=" + d() + ", h=" + a() + ", position=" + b() + ", zOrder=" + g() + ", visible=" + c() + ", rtcPushMode=" + this.rtcPushMode + ", liveCorePushMode=" + this.liveCorePushMode + ')';
    }

    public e() {
        this.rtcPushMode = MapsKt.mapOf(TuplesKt.to(0, 0));
        this.liveCorePushMode = MapsKt.mapOf(TuplesKt.to(0, 0));
        this.pushInfoIndex = -1;
    }

    public final Map<Integer, Integer> p() {
        return this.liveCorePushMode;
    }

    public final Map<Integer, Integer> q() {
        return this.rtcPushMode;
    }

    public final void r(Map<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.liveCorePushMode = r2;
    }

    public final void t(Map<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rtcPushMode = r2;
    }
}
