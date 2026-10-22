package bjb;

import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.http.request.FormBody;
import com.larksuite.framework.http.request.HttpMethod;
import com.larksuite.framework.http.request.RequestBody;
import com.larksuite.framework.http.response.BaseResponse;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.g;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends NetworkClient {
    public static int b;
    public final x18.b a;

    public b(x18.b r1) {
        this.a = r1;
    }

    public static ArrayMap<String, String> a(Map<String, String> r3) {
        if (r3 == null) goto L4;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
        ArrayMap<String, String> r0 = new ArrayMap();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r4.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L7
    L9:
        return r0;
    L4:
        return new ArrayMap();
    }

    public static boolean b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        Log.e("BytedanceNetworkClient", "enableDidRegisterPath url is null");
        return false;
    L7:
        return "/service/2/device_register/".equals(UriProtector.parse(r1).getPath());
    }

    public final String get(String r1) throws Exception {
        return super.get(r1);
    }

    public static void c(String r4, Map r5) {
        if (b(r4) == false) goto L32;
        if (r5 == null) goto L31;
        String r6 = (String) r5.get("set-cookie");
        ArrayList<String> r0 = c.a;
        Intrinsics.checkNotNullParameter(r4, "url");
        if (TextUtils.isEmpty(r6) == false) goto L8;
        Log.w("DeviceRegisterCookieUtil", "saveNeedyCookies CookieStr is nullOrEmpty");
        return;
    L8:
        HttpUrl r1 = HttpUrl.parse(r4);
        if (r1 != null) goto L11;
        Log.w("DeviceRegisterCookieUtil", "saveNeedyCookies httpUrl is nullOrEmpty");
        return;
    L11:
        if (r6 == null) goto L39;
        g r7 = g.c(r1, r6);
        if (r7 == null) goto L36;
        a28.a.a r2 = new a28.a.a();
        r2.c(r7.a);
        r2.e(r7.b);
        r2.b(r7.c);
        r2.a(r7.d);
        r2.d(r7.e);
        if (r7.f == false) goto L19;
        r2.f = true;
    L19:
        if (r7.g == false) goto L22;
        r2.g = true;
    L22:
        if (r7.i == false) goto L25;
        r2.g = true;
    L25:
        if (r7.h == false) goto L27;
        r2.g = true;
    L27:
        ArrayList r8 = new ArrayList();
        a28.a r3 = new a28.a(r2);
        if (c.a.contains(r3.a) == false) goto L30;
        Intrinsics.checkNotNull(r3);
        r8.add(r3);
        Log.i("DeviceRegisterCookieUtil", "saveNeedyCookies cookie.name = " + r3.a + ", cookie.domain = " + r3.d);
    L30:
        e.a().b(r4, r8);
        return;
    L36:
        return;
    L39:
        return;
    L31:
        Log.e("BytedanceNetworkClient", "result header = null");
        return;
    L32:
        Log.d("BytedanceNetworkClient", "enableDidRegisterPath = false");
    }

    public static void d(String r14, Map r15) {
        if (r15 != null) goto L5;
        r15 = new HashMap();
    L5:
        if (b(r14) == false) goto L34;
        ArrayList<String> r0 = c.a;
        Intrinsics.checkNotNullParameter(r14, "url");
        List r16 = e.a().a(r14);
        List r1 = r16;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        Log.i("DeviceRegisterCookieUtil", "getNeedyCookieHeader = empty");
        String r17 = null;
    L28:
        if (TextUtils.isEmpty(r17) == true) goto L42;
        String r3 = (String) r15.get("cookie");
        if (TextUtils.isEmpty(r3) == false) goto L32;
        r15.put("cookie", r17);
    L33:
        Log.d("BytedanceNetworkClient", "setCookieForDidRegister,cookieHeader= " + r17);
        return;
    L32:
        r15.put("cookie", r3.trim() + "; " + r17);
        goto L33
    L42:
        return;
    L16:
        ArrayList r4 = new ArrayList();
        Iterator r18 = r16.iterator();
    L18:
        if (r18.hasNext() == false) goto L22;
        Object r5 = r18.next();
        if (c.a.contains(((a28.a) r5).a) == false) goto L18;
        r4.add(r5);
        goto L18
    L22:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r19 = r4.iterator();
    L24:
        if (r19.hasNext() == false) goto L26;
        a28.a r7 = (a28.a) r19.next();
        r6.add(r7.a + '=' + r7.b);
        goto L24
    L26:
        r17 = CollectionsKt.joinToString$default(r6, "; ", null, null, 0, null, null, 62, null);
        Log.i("DeviceRegisterCookieUtil", "getNeedyCookieHeader = " + r17);
        goto L28
    L9:
        if (r1.isEmpty() == true) goto L12;
        r2 = false;
        goto L14
    L34:
        Log.d("BytedanceNetworkClient", "setCookieForDidRegister,enableDidRegisterPath = false");
    }

    public final String post(String r1, List<Pair<String, String>> r2) throws CommonHttpException {
        return super.post(r1, r2);
    }

    public final String get(String r5, Map<String, String> r6, NetworkClient.ReqContext r7) throws Exception {
        ArrayMap<String, String> r8 = a(r6);
        z18.a r9 = new z18.a();
        r9.c = r5;
        int r10 = r8.size();
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L5;
        r9.a().put((String) r8.keyAt(r0), (String) r8.valueAt(r0));
        r0 = r0 + 1;
        goto L3
    L5:
        BaseResponse r11 = c28.a.a(this.a, r9);
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.body().string();
    }

    public final String post(String r6, byte[] r7, Map<String, String> r8, NetworkClient.ReqContext r9) throws CommonHttpException {
        int r0 = 0;
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L9:
        boolean r10 = false;
    L11:
        if (r10 == false) goto L25;
        Log.i("BytedanceNetworkClient", "getDidByRustProxy");
        d(r6, r8);
        SendHttpRequest.Builder r11 = new SendHttpRequest.Builder();
        r11.url(r6);
        r11.headers(r8);
        r11.method(SendHttpRequest.Method.POST);
        r11.body(ByteString.of(r7));
        SdkSender.d r12 = SdkSender.syncSendMayError(Command.SEND_HTTP, r11, new a());
        if (r12 == null) goto L23;
        Object r13 = r12.a;
        if (r13 == null) goto L23;
        SendHttpResponse r14 = (SendHttpResponse) r13;
        if (r14.json_body == null) goto L23;
        if (r12.b == null) goto L22;
        Log.e("BytedanceNetworkClient", "result error: " + r12.b.getDebugMsg() + r12.b.getDisplayMsg());
        b = b + 1;
        return null;
    L22:
        c(r6, r14.headers);
        return ((SendHttpResponse) r12.a).json_body;
    L23:
        Log.e("BytedanceNetworkClient", "result empty");
        b++;
        return null;
    L25:
        d(r6, r8);
        if (r8 == null) goto L28;
        String r1 = r8.get(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
        r8.remove(HttpHeaders.HEAD_KEY_CONTENT_TYPE);
    L29:
        ArrayMap<String, String> r15 = a(r8);
        HttpMethod r3 = HttpMethod.POST;
        z18.a r16 = new z18.a(r3, r6);
        if (r7 == null) goto L33;
        if (r1 == null) goto L33;
        RequestBody r17 = RequestBody.create(r1, r7);
        r16.d = r3;
        r16.e = r17;
    L33:
        int r18 = r15.size();
    L34:
        if (r0 >= r18) goto L36;
        r16.b.put((String) r15.keyAt(r0), (String) r15.valueAt(r0));
        r0 = r0 + 1;
        goto L34
    L36:
        BaseResponse r19 = c28.a.a(this.a, r16);
        if (r19 != null) goto L50;
    L43:
        if (r19 != null) goto L45;
    L49:
        return null;
    L45:
        if (r19.body() == null) goto L49;
        return r19.body().string();
    L41:
        e = move-exception;
        Log.e("Lark", e.getMessage(), e);
        goto L49
    L50:
        if (r19.headers() == null) goto L43;
        c(r6, r19.headers());     // Catch: IOException -> L41
        goto L43
    L28:
        r1 = null;
        goto L29
    L5:
        if ("/service/2/device_register/".equals(UriProtector.parse(r6).getPath()) == false) goto L9;
        if (b >= 3) goto L9;
        r10 = true;
        goto L11
    }

    public final String post(String r5, List<Pair<String, String>> r6, Map<String, String> r7, NetworkClient.ReqContext r8) throws CommonHttpException {
        ArrayMap<String, String> r9 = a(r7);
        z18.a r10 = new z18.a(HttpMethod.POST, r5);
        HashMap r11 = new HashMap();
        if (r6 == null) goto L16;
        Iterator<Pair<String, String>> r12 = r6.iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        Pair<String, String> r1 = r12.next();
        String r2 = (String) r1.first;
        String r3 = (String) r1.second;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        r11.put(r2, r3);
        goto L6
    L12:
        throw new NullPointerException("value == null");
    L14:
        throw new NullPointerException("name == null");
    L15:
        FormBody r13 = new FormBody(r11, null);
        r10.d = HttpMethod.POST;
        r10.e = r13;
    L16:
        int r14 = r9.size();
        int r15 = 0;
    L17:
        if (r15 >= r14) goto L19;
        String r4 = (String) r9.keyAt(r15);
        String r16 = (String) r9.valueAt(r15);
        r10.b.put(r4, r16);
        r15 = r15 + 1;
        goto L17
    L19:
        BaseResponse r17 = c28.a.a(this.a, r10);
        if (r17 != null) goto L28;
    L27:
        return null;
    L28:
    L25:
        e = move-exception;
        Log.e("Lark", e.getMessage(), e);
        goto L27
    L22:
        if (r17.body() == null) goto L27;
        return r17.body().string();
    }

    public final String post(String r1, byte[] r2, boolean r3, String r4, boolean r5) throws CommonHttpException {
        return super.post(r1, r2, r3, r4, r5);
    }
}
