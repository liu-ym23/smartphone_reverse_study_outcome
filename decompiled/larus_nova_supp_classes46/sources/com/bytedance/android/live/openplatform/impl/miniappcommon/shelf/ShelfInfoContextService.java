package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf;

import am2.n;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappcommon.api.MiniAppEntranceApi;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0002H\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/ShelfInfoContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lkotlin/Function1;", "Ltq0/a;", "", "onSuccess", "", "onFail", "requestShelfInfo", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ShelfInfoContextService extends OpenPlatformContextService {
    public static final a Companion = null;
    public static final String TAG = "ShelfInfoContextService";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function1 b;

        public b(Function1 r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r6) {
            e r7 = (e) r6;
            int r0 = qo0.a.a;
            qo0.a.c(ShelfInfoContextService.TAG, "request shelf/info success, data: " + ((tq0.a) r7.data));
            DATA r8 = r7.data;
            ShelfInfo r1 = ((tq0.a) r8).shelfInfo;
            if (r1 != null) goto L5;
        L8:
            this.a.invoke(r8);
            return;
        L5:
            if (r1.status != 3) goto L8;
            this.b.invoke("invalid shelf/info");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            qo0.a.b(ShelfInfoContextService.TAG, "request shelf/info failed", r4);
            Function1 r0 = this.a;
            String r5 = r4.getMessage();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r0.invoke(r5);
        }
    }

    static {
        Companion = new a();
    }

    public ShelfInfoContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final void requestShelfInfo(Function1<? super tq0.a, Unit> r13, Function1<? super String, Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "onSuccess");
        Intrinsics.checkNotNullParameter(r14, "onFail");
        qo0.a.c(TAG, "request shelf/info");
        Lazy r0 = LiveOpenPlatformClient.c;
        MiniAppEntranceApi r1 = (MiniAppEntranceApi) LiveOpenPlatformClient.a.a().a(MiniAppEntranceApi.class);
        long r2 = getOpenPlatformContext().getRoomId();
        Room r3 = getOpenPlatformContext().getRoom();
        String r4 = "";
        if (r3 == null) goto L61;
        Intrinsics.checkNotNullParameter(r3, "$this$getClientExtraJson");
        JSONObject r5 = new JSONObject();
        String r6 = r3.getRequestId();
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        r5.put("req_id", r6);
        if (((wc1) de0.a.getValue()).o() == true) goto L57;
        JSONObject r7 = new JSONObject();
        String r8 = n.f().a();
        boolean r9 = true;
        if (r8.length() <= 0) goto L12;
        boolean r10 = true;
    L13:
        String r11 = null;
        if (r10 == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L19;
        r7.put("aid", r8);
    L19:
        String r12 = n.f().c();
        if (r12.length() <= 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == true) goto L26;
        r12 = null;
    L26:
        if (r12 == null) goto L63;
        r7.put("cid", r12);
    L63:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L30
        Object r17 = Result.constructor-impl(new JSONObject(n.f().d()));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r17) == false) goto L35;
        r17 = null;
    L35:
        JSONObject r18 = (JSONObject) r17;
        if (r18 == null) goto L48;
        String r19 = r18.optString("clickid");
        if (r19 == null) goto L48;
        if (r19.length() <= 0) goto L42;
        boolean r110 = true;
    L43:
        if (r110 == true) goto L46;
        r19 = null;
    L46:
        if (r19 == null) goto L48;
        r7.put("clickid", r19);
        goto L48
    L42:
        r110 = false;
    L48:
        String r20 = n.f().d();
        if (r20.length() > 0) goto L52;
        r9 = false;
    L52:
        if (r9 == false) goto L54;
        r11 = r20;
    L54:
        if (r11 == null) goto L56;
        r7.put("log_extra", r11);
    L56:
        Unit r21 = Unit.INSTANCE;
        r5.put("ad_params", r7.toString());
    L30:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L22:
        r15 = false;
        goto L23
    L12:
        r10 = false;
    L57:
        String r23 = r5.toString();
        if (r23 == null) goto L61;
        r4 = r23;
    L61:
        autoDispose(r1.getShelfInfo(r2, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r13, r14), new c(r14)));
    }
}
