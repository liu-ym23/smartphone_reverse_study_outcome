package com.larksuite.framework.http.call;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {

    public static class a<T> {
        public final T a;
        public final ErrorResult b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseResponse r1) {
            this.a = r1;
        }

        public a(ErrorResult r1) {
            this.b = r1;
        }
    }

    public static void a(z18.a r3, String r4) {
        StringBuilder r0 = new StringBuilder("X-BaseRequest-ID:");
        r0.append(r3.a().get("X-BaseRequest-ID"));
        r0.append(", request url:");
        r0.append(r3.b());
        r0.append(", statusCode:0");
        if (r4 != null) goto L5;
        Log.i(r3.f, r0.toString());
        return;
    L5:
        Log.e(r3.f, r0.toString(), new RuntimeException(r4));
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 22 */
    public static a b(Class r8, z18.a r9, final Response r10) {
        int r11 = r10.code();
        int r1 = r10.code();
        HashMap r2 = new HashMap();
        Headers r3 = r10.headers();
        if (r3 == null) goto L10;
        Iterator r4 = r3.names().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        String r5 = (String) r4.next();
        List r6 = r3.values(r5);
        if (CollectionUtils.isNotEmpty(r6) == false) goto L6;
        r2.put(r5, (String) ListProtector.get(r6, 0));
    L10:
        BaseResponse r0 = new BaseResponse(r1, r2, new CallProcessor$1(r10));
        r9.getClass();
        if (r11 >= 200) goto L13;
    L30:
        String r12 = r0.message();     // Catch: IOException -> L22
    L25:
        if (TextUtils.isEmpty(r12) == false) goto L27;
        r12 = "http status code:" + r11 + " server error";
        int r13 = -2;
    L29:
        return new a(new ErrorResult(r13, r11, r12));
    L27:
        r13 = -3;
    L22:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L25
    L13:
        if (r11 >= 300) goto L30;
        return new a(r0);
    }
}
