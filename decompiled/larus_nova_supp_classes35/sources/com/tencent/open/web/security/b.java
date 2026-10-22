package com.tencent.open.web.security;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.tencent.open.log.SLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class b extends com.tencent.open.b {
    public b() {
    }

    public boolean a(WebView r14, String r15) {
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl---url = " + r15);
        if (r15 != null) goto L6;
        return false;
    L6:
        if (UriProtector.parse(r15).getScheme().equals("jsbridge") == true) goto L8;
        return false;
    L8:
        ArrayList r3 = new ArrayList(Arrays.asList(r15.concat("/#").split("/")));
        if (r3.size() >= 7) goto L11;
        return false;
    L11:
        String r2 = (String) ListProtector.get(r3, 2);
        String r4 = (String) ListProtector.get(r3, 3);
        String r5 = (String) ListProtector.get(r3, 4);
        String r12 = (String) ListProtector.get(r3, 5);
        SLog.i("openSDK_LOG.SecureJsBridge", "-->canHandleUrl, objectName: " + r2 + " | methodName: " + r4 + " | snStr: " + r5);
        if (TextUtils.isEmpty(r2) == false) goto L14;
    L21:
        return false;
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L21;
        if (TextUtils.isEmpty(r5) == true) goto L21;
        a(r2, r4, r3.subList(6, r3.size() - 1), new c(r14, CastLongProtector.parseLong(r5), r15, r12));
        return true;
    }

    public void a(String r6, String r7, List<String> r8, com.tencent.open.b.a r9) {
        SLog.v("openSDK_LOG.SecureJsBridge", "-->getResult, objectName: " + r6 + " | methodName: " + r7);
        int r0 = r8.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        ListProtector.set(r8, r2, URLDecoder.decode((String) ListProtector.get(r8, r2), "UTF-8"));     // Catch: UnsupportedEncodingException -> L6
    L8:
        r2 = r2 + 1;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L9:
        com.tencent.open.b.b r1 = (com.tencent.open.b.b) ((com.tencent.open.b) this).a.get(r6);
        if (r1 == null) goto L12;
        SLog.d("openSDK_LOG.SecureJsBridge", "-->handler != null");
        r1.call(r7, r8, r9);
        return;
    L12:
        SLog.e("openSDK_LOG.SecureJsBridge", "-->handler == null objName: " + r6);
        if (r9 == null) goto L22;
        r9.a();
        return;
    }
}
