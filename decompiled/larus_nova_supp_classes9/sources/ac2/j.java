package ac2;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements com.ss.ugc.live.sdk.msg.network.n {
    public final Type a;

    public j(Type r1) {
        this.a = r1;
    }

    public static <T> T c(Class<T> r2) {
        return r2.newInstance();
    L4:
        e = move-exception;
        e.printStackTrace();
        LocalTestManager.a(new Class[]{wy.a.class});
        return null;
    }

    public static RequestError e(ho0.a r2) {
        RequestError r0 = new RequestError();
        r0.message = r2.b;
        r0.prompts = r2.c;
        r0.alert = r2.d;
        return r0;
    }

    public final Object decode(byte[] r11) {
        Type r0 = this.a;
        Response r2 = null;
        if ((r0 instanceof ParameterizedType) == true) goto L5;
        return null;
    L5:
        ParameterizedType r1 = (ParameterizedType) r0;
        Type r3 = r1.getRawType();
        if ((r3 instanceof Class) == true) goto L8;
        return null;
    L8:
        Type[] r4 = r1.getActualTypeArguments();
        Class[] r5 = new Class[2];
        if (r4.length < 1) goto L15;
        Type r6 = r4[0];
        if ((r6 instanceof Class) == true) goto L13;
        return null;
    L13:
        r5[0] = (Class) r6;
    L15:
        if (r4.length != 2) goto L21;
        Type r7 = r4[1];
        if ((r7 instanceof Class) == true) goto L19;
        return null;
    L19:
        r5[1] = (Class) r7;
    L23:
        Class r8 = (Class) r3;
        if (r8 != Response.class) goto L26;
    L32:
        am3.g r9 = new am3.g();
        r9.k(new am3.b(r11));
        ho0.b r13 = ho0.b.a(r9);     // Catch: Throwable -> L53
        byte[] r10 = r13.body;     // Catch: Throwable -> L53
        if (r10 == null) goto L37;
        r9.k(new am3.b(r10));     // Catch: Throwable -> L53
    L37:
        if (r13.body != null) goto L40;
        r9 = null;
    L40:
        if (r8 != Response.class) goto L43;
        Response r14 = f(r5[0], r9, r13.header);     // Catch: Throwable -> L53
    L48:
        r2 = r14;
        BaseListResponse r15 = null;
    L50:
        if (r2 == null) goto L52;
        return r2;
    L52:
        return r15;
    L43:
        if (r8 != ListResponse.class) goto L46;
        r15 = d(r5[0], r9, r13.header);     // Catch: Throwable -> L53
        goto L50
    L46:
        if (r8 != BaseResponse.class) goto L49;
        r14 = b(r5[0], r5[1], r9, r13.header);     // Catch: Throwable -> L53
        goto L48
    L49:
        r15 = a(r5[0], r5[1], r9, r13.header);     // Catch: Throwable -> L53
    L53:
        return null;
    L26:
        if (r8 == ListResponse.class) goto L32;
        if (r8 == BaseResponse.class) goto L32;
        if (r8 == BaseListResponse.class) goto L32;
        return null;
    L21:
        if (r4.length <= 2) goto L23;
        return null;
    }

    public static ListResponse d(Class r4, am3.g r5, ho0.a r6) throws Exception {
        ListResponse r0 = new ListResponse();
        ((BaseListResponse) r0).statusCode = r6.a;
        Extra r1 = new Extra();
        r1.now = r6.e;
        ((BaseListResponse) r0).extra = r1;
        if (r6.a != 0) goto L14;
        ((BaseListResponse) r0).data = new ArrayList();
        if (r5 == null) goto L15;
        long r2 = r5.c();
    L7:
        int r7 = r5.f();
        if (r7 == (-1)) goto L13;
        if (r7 == 1) goto L11;
        am3.h.e(r5);
        goto L7
    L11:
        ((BaseListResponse) r0).data.add(jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r4).decode(r5));
        goto L7
    L13:
        r5.d(r2);
    L15:
        return r0;
    L14:
        ((BaseListResponse) r0).error = e(r6);
        goto L15
    }

    public static Response f(Class r4, am3.g r5, ho0.a r6) throws Exception {
        Response r0 = new Response();
        ((BaseResponse) r0).statusCode = r6.a;
        Extra r1 = new Extra();
        r1.now = r6.e;
        ((BaseResponse) r0).extra = r1;
        if (r6.a != 0) goto L16;
        if (r5 == null) goto L15;
        long r2 = r5.c();
    L6:
        int r7 = r5.f();
        if (r7 == (-1)) goto L12;
        if (r7 == 1) goto L10;
        am3.h.e(r5);
        goto L6
    L10:
        ((BaseResponse) r0).data = jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r4).decode(r5);
        goto L6
    L12:
        r5.d(r2);
        if (((BaseResponse) r0).data != null) goto L17;
        ((BaseResponse) r0).data = c(r4);
    L17:
        return r0;
    L15:
        ((BaseResponse) r0).data = c(r4);
        goto L17
    L16:
        ((BaseResponse) r0).error = e(r6);
        goto L17
    }

    public static BaseListResponse a(Class r6, Class r7, am3.g r8, ho0.a r9) throws Exception {
        BaseListResponse r0 = new BaseListResponse();
        int r1 = r9.a;
        r0.statusCode = r1;
        if (r1 != 0) goto L20;
        r0.data = new ArrayList();
        if (r8 == null) goto L19;
        long r2 = r8.c();
    L7:
        int r3 = r8.f();
        if (r3 == (-1)) goto L16;
        if (r3 != 1) goto L12;
        r0.data.add(jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r6).decode(r8));
        goto L7
    L12:
        if (r3 != 2) goto L13;
        Extra r4 = (Extra) jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r7).decode(r8);
        r0.extra = r4;
        r4.now = r9.e;
        goto L7
    L13:
        am3.h.e(r8);
        goto L7
    L16:
        r8.d(r2);
        if (r0.extra != null) goto L25;
        r0.extra = (Extra) c(r7);
    L25:
        return r0;
    L19:
        r0.extra = (Extra) c(r7);
        goto L25
    L20:
        r0.error = e(r9);
        if (TextUtils.isEmpty(r9.f) == false) goto L23;
        Extra r10 = null;
    L24:
        r0.extra = r10;
        goto L25
    L23:
        r10 = (Extra) GsonProtectorUtils.fromJson(GsonHelper.get(), r9.f, r7);
        goto L24
    }

    public static BaseResponse b(Class r6, Class r7, am3.g r8, ho0.a r9) throws Exception {
        BaseResponse r0 = new BaseResponse();
        int r1 = r9.a;
        r0.statusCode = r1;
        if (r1 != 0) goto L22;
        if (r8 == null) goto L21;
        long r2 = r8.c();
    L6:
        int r3 = r8.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L11;
        r0.data = jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r6).decode(r8);
        goto L6
    L11:
        if (r3 != 2) goto L12;
        Extra r4 = (Extra) jc1.k.f(IMiddlewareNetworkService.class).getProtoDecoder(r7).decode(r8);
        r0.extra = r4;
        r4.now = r9.e;
        goto L6
    L12:
        am3.h.e(r8);
        goto L6
    L15:
        r8.d(r2);
        if (r0.data != null) goto L19;
        r0.data = c(r6);
    L19:
        if (r0.extra != null) goto L27;
        r0.extra = (Extra) c(r7);
    L27:
        return r0;
    L21:
        r0.data = c(r6);
        r0.extra = (Extra) c(r7);
        goto L27
    L22:
        r0.error = e(r9);
        if (TextUtils.isEmpty(r9.f) == false) goto L25;
        Extra r10 = null;
    L26:
        r0.extra = r10;
        goto L27
    L25:
        r10 = (Extra) GsonProtectorUtils.fromJson(GsonHelper.get(), r9.f, r7);
        goto L26
    }
}
