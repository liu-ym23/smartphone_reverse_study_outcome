package yo0;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.openplatform.impl.base.api.response.OpenPlatformRespExtra;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.openapi.OpenApiErrorInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public final List<String> a;
    public final OpenPlatformContext b;
    public final Queue<Long> c;
    public final String d;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a e;

    /* JADX INFO: renamed from: yo0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0296a {
        void a(d r1);

        void b(d r1);
    }

    public static final class b {
        public final InterfaceC0296a a;

        public b(InterfaceC0296a r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.a = r2;
        }

        public final void a(Throwable r5) {
            InterfaceC0296a r0 = this.a;
            d.a.d.getClass();
            if ((r5 instanceof CustomApiServerException) == false) goto L27;
            CustomApiServerException r6 = (CustomApiServerException) r5;
            Intrinsics.checkNotNullParameter(r6, "error");
            String r7 = r6.getExtra();
            if (r7 != null) goto L7;
        L25:
            d.a r8 = d.a.C0297a.b(OpenApiErrorInfo.INTERNAL_ERROR, null);
        L30:
            r0.a(r8.a());
            return;
        L7:
            if (r7.length() <= 0) goto L9;
            boolean r1 = true;
        L10:
            if (r1 != true) goto L25;
            JsonElement r9 = GsonHelper.parser().parse(r7);     // Catch: Exception -> L32
            if (r9 == null) goto L25;
            JsonObject r10 = r9.getAsJsonObject();     // Catch: Exception -> L32
            if (r10 == null) goto L25;
            OpenPlatformRespExtra r11 = (OpenPlatformRespExtra) GsonHelper.get().fromJson(r10, OpenPlatformRespExtra.class);     // Catch: Exception -> L32
            if (r11 == null) goto L18;
            int r2 = r11.errorCode;     // Catch: Exception -> L32
        L19:
            if (r11 == null) goto L22;
            String r12 = r11.errorMsg;     // Catch: Exception -> L32
            if (r12 == null) goto L22;
        L23:
            r8 = d.a.C0297a.a(r2, r12, null);     // Catch: Exception -> L32
        L22:
            r12 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorMsg();     // Catch: Exception -> L32
            goto L23
        L18:
            r2 = OpenApiErrorInfo.INTERNAL_ERROR.getErrorCode();     // Catch: Exception -> L32
            goto L19
        L9:
            r1 = false;
            goto L10
        L27:
            if ((r5 instanceof NetworkErrorException) == false) goto L29;
            r8 = d.a.C0297a.b(OpenApiErrorInfo.NETWORK_ERROR, null);
            goto L30
        L29:
            r8 = d.a.C0297a.b(OpenApiErrorInfo.INTERNAL_ERROR, null);
            goto L30
        }

        public final void c(JSONObject r4) {
            InterfaceC0296a r0 = this.a;
            d.a.d.getClass();
            d.a r1 = new d.a(OpenApiErrorInfo.SUCCESS.getErrorCode());
            r1.b = r4;
            r0.b(r1.a());
        }

        public static void b(b r1, OpenApiErrorInfo r2) {
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "errorInfo");
            InterfaceC0296a r3 = r1.a;
            d.a.d.getClass();
            r3.a(d.a.C0297a.b(r2, null).a());
        }
    }

    public static final class c {
    }

    public final void a(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.e.a(r2);
    }

    public abstract String b();

    public abstract void call(JSONObject r1, b r2);

    static {
        OpenApiErrorInfo.INCORRECT_PARAMS.getErrorCode();
    }

    public a(OpenPlatformContext r2, Queue<Long> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "callHistory");
        Intrinsics.checkNotNullParameter(r4, "appId");
        this.e = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ArrayList();
    }
}
