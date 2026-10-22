package yc2;

import am2.c0;
import am2.n;
import am2.x;
import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "reportUser")
public final class c extends com.bytedance.ies.web.jsbridge2.g<a, Unit> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006&"}, d2 = {"Lyc2/c$a;", "Lzg1/u;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "l", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "k", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", BuildConfig.FLAVOR, "fromSource", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setFromSource", "(Ljava/lang/String;)V", "reportSource", "i", "setReportSource", BuildConfig.FLAVOR, "vertical", "Z", "getVertical", "()Z", "setVertical", "(Z)V", "reportType", "j", "setReportType", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends u {

        @SerializedName("from_source")
        private String fromSource;

        @SerializedName("report_source")
        private String reportSource;

        @SerializedName("report_type")
        private String reportType;

        @SerializedName("room")
        private Room room;

        @SerializedName("user")
        private User user;

        @SerializedName("is_vertical")
        private boolean vertical;

        public a() {
            this.vertical = true;
        }

        public final String h() {
            return this.fromSource;
        }

        public final String i() {
            return this.reportSource;
        }

        public final String j() {
            return this.reportType;
        }

        public final Room k() {
            return this.room;
        }

        public final User l() {
            return this.user;
        }
    }

    public c() {
    }

    public final Object invoke(Object r10, CallContext r11) {
        a r13 = (a) r10;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        Context r14 = r11.getContext();
        int r0 = ita.i.a;
        if (NetworkUtils.isNetworkAvailable(r14) == false) goto L17;
        IReportService r1 = k.f(IReportService.class);
        if (r1 == null) goto L7;
        r1.report(ReportConstant.BusinessSource.ReportJSB, r13.l(), r13.k(), r13.h(), r13.i(), r13.j(), r13);
    L7:
        User r15 = r13.l();
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNull(r13.k());
        String r2 = r13.h();
        Intrinsics.checkNotNull(r2);
        String r16 = r15.getIdString();
        String r17 = r13.j();
        if (Intrinsics.areEqual("personal_profile", r2) == false) goto L10;
    L13:
        boolean r3 = true;
    L14:
        lc0.c r4 = k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        com.bytedance.android.livesdk.log.g r5 = com.bytedance.android.livesdk.log.u.l();
        Map r18 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("report_type", k.n(IReportService.class).getReportType(r2, r17, r3)), TuplesKt.to("to_user_id", r16), TuplesKt.to("request_page", k.n(IReportService.class).getRequestPage(r2, r17))});
        int r19 = c0.b;
        r5.sendLog("livesdk_live_user_report", r18, new Object[]{Room.class, new x(), n.f(), c0.a.a(r4.v())});
        return Unit.INSTANCE;
    L10:
        if (Intrinsics.areEqual("live_barrage", r2) == true) goto L13;
        r3 = false;
        goto L14
    L17:
        throw new IllegalStateException("Check failed.".toString());
    }
}
