package ac2;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ vlc.e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.f c;

    public static final class a implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ f a;
        public final /* synthetic */ ObservableEmitter b;

        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r14) {
            Intrinsics.checkNotNullParameter(r14, "result");
            if ((r14 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L56;
            com.ss.ugc.live.sdk.msg.network.g r15 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r14).b;
            Object r7 = r15.e;
            int r8 = r15.f;
            if ((r7 instanceof BaseResponse) == false) goto L8;
            ((BaseResponse) r7).requestType = r8;
        L11:
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L61;
            int r1 = g.a;
            com.ss.ugc.live.sdk.msg.network.f r2 = this.a.c;
            JSONObject r3 = new JSONObject();
            r3.put("url", r2.b);
            r3.put("request_type", r15.f);
            r3.put("log_id", g.a.a(r15));
            r3.put("response", GsonProtectorUtils.toJson(GsonHelper.get(), r15.e));
            Logger.i("LiveUplink", r3.toString());
        L61:
            IMiddlewareNetworkService r4 = jc1.k.f(IMiddlewareNetworkService.class);     // Catch: Exception -> L50
            if (r4 == null) goto L48;
            String r5 = this.a.c.b;     // Catch: Exception -> L50
            int r6 = g.a;     // Catch: Exception -> L50
            String r9 = g.a.a(r15);     // Catch: Exception -> L50
            Intrinsics.checkNotNullParameter(r15, "httpResponse");     // Catch: Exception -> L50
            List r10 = r15.c;     // Catch: Exception -> L50
            T r11 = null;
            if (r10 == null) goto L31;
            Iterator<T> r13 = r10.iterator();     // Catch: Exception -> L50
        L20:
            if (r13.hasNext() == false) goto L24;
            T r16 = r13.next();     // Catch: Exception -> L50
            if (StringsKt.equals("rpc-persist-webcast-trace-id", ((com.ss.ugc.live.sdk.msg.network.d) r16).a, true) == false) goto L20;
        L25:
            com.ss.ugc.live.sdk.msg.network.d r17 = (com.ss.ugc.live.sdk.msg.network.d) r16;     // Catch: Exception -> L50
            if (r17 == null) goto L31;
            String r18 = r17.b;     // Catch: Exception -> L50
            if (r18 == null) goto L31;
            String r19 = r18;
        L32:
            int r20 = g.a;     // Catch: Exception -> L50
            Intrinsics.checkNotNullParameter(r15, "httpResponse");     // Catch: Exception -> L50
            List r110 = r15.c;     // Catch: Exception -> L50
            if (r110 == null) goto L46;
            Iterator<T> r111 = r110.iterator();     // Catch: Exception -> L50
        L36:
            if (r111.hasNext() == false) goto L40;
            T r0 = r111.next();     // Catch: Exception -> L50
            if (StringsKt.equals("tt_stable", ((com.ss.ugc.live.sdk.msg.network.d) r0).a, true) == false) goto L36;
            r11 = r0;
        L40:
            com.ss.ugc.live.sdk.msg.network.d r21 = (com.ss.ugc.live.sdk.msg.network.d) r11;     // Catch: Exception -> L50
            if (r21 == null) goto L46;
            String r112 = r21.b;     // Catch: Exception -> L50
            if (r112 == null) goto L46;
            String r23 = r112;
        L47:
            r4.interceptResponseBody(r5, r7, r9, r19, r23);     // Catch: Exception -> L50
        L46:
            r23 = "not exist";
            goto L47
        L24:
            r16 = null;
        L31:
            r19 = "not exist";
        L48:
            ObservableEmitter r113 = this.b;     // Catch: Exception -> L50
            Intrinsics.checkNotNull(r7);     // Catch: Exception -> L50
            r113.onNext(r7);     // Catch: Exception -> L50
            this.b.onComplete();     // Catch: Exception -> L50
            return;
        L50:
            e = move-exception;
            if ((e instanceof ApiException) == false) goto L54;
            e.setRequestType(r8);
        L54:
            this.b.onError(e);
            return;
        L8:
            if ((r7 instanceof ExtraResponse) == false) goto L11;
            ((ExtraResponse) r7).a = r8;
            goto L11
        L56:
            if ((r14 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L60;
            this.b.onError((Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r14).b);
            return;
        L60:
            throw new NoWhenBranchMatchedException();
        }

        public a(f r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public f(vlc.e r1, long r2, com.ss.ugc.live.sdk.msg.network.f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void subscribe(ObservableEmitter<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        this.a.z(this.b, this.c, new a(this, r6));
    }
}
