package b8;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.retrofit2.a0;
import com.bytedance.retrofit2.t;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.aikernel.res.legacy.CommonPostService;
import com.obric.aikernel.runtime.utils.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.u;
import okhttp3.y;
import r4.e;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q4.a f539b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        SharedPreferences r11 = r10.getSharedPreferences("pty_user_types", 0);
        if (r11.getInt("has_set_user", 0) != 0) goto L5;
        this.f538a = true;
    L5:
        r11.edit().putInt("has_set_user", 1).apply();
        this.f539b = new b(this);
    }

    public static /* synthetic */ a0 a(c r10, q4.a.InterfaceC0283a r11) {
        return b(r10, r11);
    }

    private static final a0 b(c r10, q4.a.InterfaceC0283a r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        ArrayList r12 = new ArrayList();
        List<n4.b> r13 = r11.a().v();
        Intrinsics.checkNotNullExpressionValue(r13, "chain.request().headers");
        r12.addAll(r13);
        r12.add(new n4.b("x-tt-request-tag", "t=0;n=" + (r10.f538a ? 1 : 0)));
        r12.add(new n4.b("X-Distribute", "ai_kernel"));
        r12.add(new n4.b("x-use-ppe", NetConst.ENCRYPT_VERISON_CODE));
        return r11.c(r11.a().O().b(r12).a());
    }

    public final byte[] c(String r13, byte[] r14) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r14, "body");
        t r10 = RetrofitUtils.i(r13);
        if (r10 != null) goto L8;
        d r11 = d.f5417a;
        int r12 = 0;
        int r15 = 4;
        Object r16 = null;
        String r17 = "TTNetHttpClientImpl";
        String r18 = "url is empty";
    L5:
        com.obric.aikernel.runtime.utils.c.a.a(r11, r17, r18, r12, r15, r16);
        return null;
    L8:
        if (r10.i().contains(this.f539b) == true) goto L10;
        r10.i().add(this.f539b);
    L10:
        a5.d r19 = new a5.d();
        r19.f11422c = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        r19.f11423d = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        r19.f11424e = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        r19.f11429j = true;
        com.bytedance.retrofit2.b<e> r110 = ((CommonPostService) r10.e(CommonPostService.class)).request(r13, y.d(u.g(NetConst.CONTENT_TYPE), r14), r19);
        d r111 = d.f5417a;
        com.obric.aikernel.runtime.utils.c.a.a(r111, "TTNetHttpClientImpl", "start post " + r13, 0, 4, null);
        a0<e> r112 = r110.execute();
        int r113 = r112.b();
        StringBuilder r20 = new StringBuilder();
        r20.append("end post header info: ");
        List<n4.b> r21 = r112.e();
        Intrinsics.checkNotNullExpressionValue(r21, "rawResponse.headers()");
        r20.append(CollectionsKt.joinToString$default(r21, null, null, null, 0, null, null, 63, null));
        com.obric.aikernel.runtime.utils.c.a.a(r111, "TTNetHttpClientImpl", r20.toString(), 0, 4, null);
        if (r112.f() == true) goto L13;
        InputStream r22 = r112.d().c();
        Intrinsics.checkNotNullExpressionValue(r22, "rawResponse.errorBody().`in`()");
        r18 = r113 + ", " + r112.g() + "\n " + new String(ByteStreamsKt.readBytes(r22), Charsets.UTF_8);
        r12 = 0;
        r15 = 4;
        r16 = null;
        r17 = "TTNetHttpClientImpl";
        r11 = r111;
        goto L5
    L13:
        InputStream r114 = r112.a().c();
        Intrinsics.checkNotNullExpressionValue(r114, "rawResponse.body().`in`()");
        byte[] r115 = ByteStreamsKt.readBytes(r114);
        com.obric.aikernel.runtime.utils.c.a.a(r111, "TTNetHttpClientImpl", "post success " + r113 + ' ' + r115.length, 0, 4, null);
        return r115;
    }
}
