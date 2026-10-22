package ac2;

import android.util.Log;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ long a;
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.f b;

    /* JADX INFO: renamed from: ac2.a$a, reason: collision with other inner class name */
    public static final class C0002a implements com.ss.ugc.live.sdk.msg.network.e {
        public final /* synthetic */ a a;
        public final /* synthetic */ ObservableEmitter b;

        public final void a(com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, ? extends Exception> r14) {
            Intrinsics.checkNotNullParameter(r14, "result");
            if ((r14 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L70;
            com.ss.ugc.live.sdk.msg.network.g r15 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r14).b;
            Object r1 = r15.e;
            int r9 = r15.f;
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
            z r3 = c.a;
            com.ss.ugc.live.sdk.msg.network.f r4 = this.a.b;
            JSONObject r5 = new JSONObject();
            r5.put("url", r4.b);
            r5.put("request_type", r15.f);
            r5.put("log_id", c.a(r15));
            r5.put("response", GsonProtectorUtils.toJson(GsonHelper.get(), r15.e));
            Logger.i("LiveUplink", r5.toString());
        L7:
            byte[] r2 = r15.d;
            if (r2 == null) goto L19;
            if (r2.length != 0) goto L12;
            boolean r6 = true;
        L13:
            if (r6 != true) goto L19;
            if (this.b.isDisposed() == true) goto L85;
            this.b.onNext(Unit.INSTANCE);
            this.b.onComplete();
            return;
        L85:
            return;
        L12:
            r6 = false;
        L19:
            if ((r1 instanceof BaseResponse) == false) goto L22;
            ((BaseResponse) r1).requestType = r9;
        L77:
            IMiddlewareNetworkService r7 = jc1.k.f(IMiddlewareNetworkService.class);     // Catch: Exception -> L62
            if (r7 == null) goto L59;
            String r8 = this.a.b.b;     // Catch: Exception -> L62
            String r10 = c.a(r15);     // Catch: Exception -> L62
            Intrinsics.checkNotNullParameter(r15, "httpResponse");     // Catch: Exception -> L62
            List r11 = r15.c;     // Catch: Exception -> L62
            T r13 = null;
            String r16 = "not exist";
            if (r11 == null) goto L42;
            Iterator<T> r17 = r11.iterator();     // Catch: Exception -> L62
        L31:
            if (r17.hasNext() == false) goto L35;
            T r18 = r17.next();     // Catch: Exception -> L62
            if (StringsKt.equals("rpc-persist-webcast-trace-id", ((com.ss.ugc.live.sdk.msg.network.d) r18).a, true) == false) goto L31;
        L36:
            com.ss.ugc.live.sdk.msg.network.d r19 = (com.ss.ugc.live.sdk.msg.network.d) r18;     // Catch: Exception -> L62
            if (r19 == null) goto L42;
            String r20 = r19.b;     // Catch: Exception -> L62
            if (r20 == null) goto L42;
            String r110 = r20;
        L43:
            Intrinsics.checkNotNullParameter(r15, "httpResponse");     // Catch: Exception -> L62
            List r111 = r15.c;     // Catch: Exception -> L62
            if (r111 == null) goto L57;
            Iterator<T> r112 = r111.iterator();     // Catch: Exception -> L62
        L47:
            if (r112.hasNext() == false) goto L51;
            T r0 = r112.next();     // Catch: Exception -> L62
            if (StringsKt.equals("tt_stable", ((com.ss.ugc.live.sdk.msg.network.d) r0).a, true) == false) goto L47;
            r13 = r0;
        L51:
            com.ss.ugc.live.sdk.msg.network.d r21 = (com.ss.ugc.live.sdk.msg.network.d) r13;     // Catch: Exception -> L62
            if (r21 == null) goto L57;
            String r113 = r21.b;     // Catch: Exception -> L62
            if (r113 == null) goto L57;
            r16 = r113;
        L57:
            r7.interceptResponseBody(r8, r1, r10, r110, r16);     // Catch: Exception -> L62
            goto L59
        L35:
            r18 = null;
        L42:
            r110 = "not exist";
        L59:
            if (this.b.isDisposed() == true) goto L86;
            ObservableEmitter r114 = this.b;     // Catch: Exception -> L62
            Intrinsics.checkNotNull(r1);     // Catch: Exception -> L62
            r114.onNext(r1);     // Catch: Exception -> L62
            this.b.onComplete();     // Catch: Exception -> L62
            return;
        L86:
            return;
        L62:
            e = move-exception;
            if ((e instanceof ApiException) == false) goto L67;
            e.setRequestType(r9);
        L67:
            if (this.b.isDisposed() == true) goto L87;
            this.b.onError(e);
            return;
        L87:
            return;
        L22:
            if ((r1 instanceof ExtraResponse) == false) goto L77;
            ((ExtraResponse) r1).a = r9;
            goto L77
        L70:
            if ((r14 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L76;
            Exception r115 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r14).b;
            Logger.i("LiveUplink", "e=" + Log.getStackTraceString(r115));
            if (this.b.isDisposed() == true) goto L89;
            this.b.onError(r115);
            return;
        L89:
            return;
        L76:
            throw new NoWhenBranchMatchedException();
        }

        public C0002a(a r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public a(long r1, com.ss.ugc.live.sdk.msg.network.f r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void subscribe(ObservableEmitter<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        z r0 = c.a;
        c.b.f(this.a, this.b, new C0002a(this, r6));
    }
}
