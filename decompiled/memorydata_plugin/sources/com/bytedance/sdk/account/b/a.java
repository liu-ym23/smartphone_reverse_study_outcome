package com.bytedance.sdk.account.b;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3100b;
    public final Map<String, String> c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.b.a$a, reason: collision with other inner class name */
    public static class C0160a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3102b;
        private Map<String, String> c;

        public C0160a() {
        }

        public C0160a a(String r1) {
            this.f3101a = r1;
            return this;
        }

        public C0160a a(String r2, String r3) {
            if (this.c != null) goto L5;
            this.c = new HashMap();
        L5:
            this.c.put(r2, r3);
            return this;
        }

        public C0160a a(Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            if (this.c != null) goto L5;
            this.c = r6;
        L10:
            return this;
        L5:
            if (r6 == null) goto L10;
            Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Map<String, String> r2 = this.c;
            Object r3 = r0.getKey();
            r2.put((String) r3, (String) r0.getValue());
            goto L8
        }

        public a a() {
            this.f3102b = "get";
            return new a(this.f3101a, this.f3102b, this.c);
        }

        public a b() {
            this.f3102b = CozeCloudExt.API_KEY_HTTP_POST_METHOD;
            return new a(this.f3101a, this.f3102b, this.c);
        }
    }

    public a(String r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.f3099a = r3;
        this.f3100b = r4;
        this.c = r6;
        this.d = null;
        this.e = null;
    }
}
