package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.util.e;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<Interceptor> f3324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile List<Interceptor> f3325b;
    private static e<String, Retrofit> c;
    private static e<String, Retrofit> d;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r2) {
            return (CompressType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompressType.class, r2), CompressType.class, "com.obric.memorydata.plugin");
        }

        public static CompressType[] values() {
            return (CompressType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompressType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f3324a = new CopyOnWriteArrayList();
        Retrofit.setCommonInterceptor(f3324a);
        c = new e(10);
        d = new e(10);
    }

    public RetrofitUtils() {
    }

    public static Pair<String, String> a(String r3) {
        String r0 = null;
        if (r3 != null) goto L17;
        return null;
    L17:
        MimeType r1 = new MimeType(r3);     // Catch: Throwable -> L10
        String r4 = r1.getBaseType();     // Catch: Throwable -> L10
        r0 = r1.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r4, r0);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r4 = null;
        goto L12
    }

    public static synchronized Retrofit a(String r3, List<Interceptor> r4, Converter.Factory r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5, null);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit a(String r3, List<Interceptor> r4, Converter.Factory r5, CallAdapter.Factory r6) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r7 = a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5, r6, new AnonymousClass1());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit a(String r3, List<Interceptor> r4, Converter.Factory r5, CallAdapter.Factory r6, Client.Provider r7) {
        monitor-enter(RetrofitUtils.class);
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Client.Provider r9 = (Client.Provider) ZeusTransformUtils.wrapperContextForParams(r7, Client.Provider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        ArrayList r1 = null;
        if (r5 == null) goto L7;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        r2.add(r5);     // Catch: Throwable -> L13
    L8:
        if (r6 == null) goto L10;
        r1 = new ArrayList();     // Catch: Throwable -> L13
        r1.add(r6);     // Catch: Throwable -> L13
    L10:
        Retrofit r10 = a(r8, r2, r1, r9, r3);     // Catch: Throwable -> L13
        monitor-exit(RetrofitUtils.class);
        return r10;
    L7:
        r2 = null;
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit a(List<Interceptor> r4, List<Converter.Factory> r5, List<CallAdapter.Factory> r6, Client.Provider r7, String r8) {
        monitor-enter(RetrofitUtils.class);
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Client.Provider r12 = (Client.Provider) ZeusTransformUtils.wrapperContextForParams(r7, Client.Provider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r12 != null) goto L7;
        r12 = new AnonymousClass2();     // Catch: Throwable -> L54
    L7:
        Retrofit.Builder r13 = new Retrofit.Builder().setEndpoint(r8).client(r12).httpExecutor(new com.bytedance.frameworks.baselib.network.http.c.c());     // Catch: Throwable -> L54
        if (r10 != null) goto L11;
        r10 = new ArrayList();     // Catch: Throwable -> L54
    L11:
        if (r10.isEmpty() == false) goto L13;
        r10.add(com.bytedance.frameworks.baselib.network.http.c.a.a.a.a());     // Catch: Throwable -> L54
    L13:
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L54
    L15:
        if (r14.hasNext() == false) goto L17;
        r13.addConverterFactory((Converter.Factory) ZeusTransformUtils.preCheckCast(r14.next(), Converter.Factory.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        goto L15
    L17:
        if (r11 != null) goto L19;
    L24:
        LinkedList r15 = new LinkedList();     // Catch: Throwable -> L54
        if (r9 != null) goto L27;
    L39:
        boolean r16 = false;
    L40:
        if (r16 == true) goto L43;
        r15.add(0, new com.bytedance.ttnet.retrofit.b());     // Catch: Throwable -> L54
    L43:
        if (f3324a != null) goto L45;
    L47:
        r15.add(new com.bytedance.frameworks.baselib.network.http.c.b());     // Catch: Throwable -> L54
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L54
    L49:
        if (r17.hasNext() == false) goto L51;
        r13.addInterceptor((Interceptor) ZeusTransformUtils.preCheckCast(r17.next(), Interceptor.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        goto L49
    L51:
        Retrofit r18 = r13.build();     // Catch: Throwable -> L54
        monitor-exit(RetrofitUtils.class);
        return r18;
    L45:
        if (f3324a.size() <= 0) goto L47;
        r15.addAll(f3324a);     // Catch: Throwable -> L54
        goto L47
    L27:
        if (r9.size() <= 0) goto L39;
        Iterator r19 = r9.iterator();     // Catch: Throwable -> L54
        r16 = false;
    L30:
        if (r19.hasNext() == false) goto L40;
        Interceptor r1 = (Interceptor) ZeusTransformUtils.preCheckCast(r19.next(), Interceptor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.ttnet.retrofit.b.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.frameworks.baselib.network.http.c.b.class) == true) goto L30;
    L38:
        r15.add(r1);     // Catch: Throwable -> L54
        goto L30
    L33:
        if (r16 == true) goto L30;
        r15.add(r1);     // Catch: Throwable -> L54
        r16 = true;
        goto L38
    L19:
        if (r11.isEmpty() == true) goto L24;
        Iterator r20 = r11.iterator();     // Catch: Throwable -> L54
    L22:
        if (r20.hasNext() == false) goto L24;
        r13.addCallAdapterFactory((CallAdapter.Factory) ZeusTransformUtils.preCheckCast(r20.next(), CallAdapter.Factory.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S a(Retrofit r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        if (r1 == null) goto L12;
        S r3 = (S) r1.create(r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(RetrofitUtils.class);
        return null;
    }

    public static synchronized <S> S a(String r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        S r3 = (S) a(b(r1), r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static String a(List<Header> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L16;
        Header r0 = (Header) ZeusTransformUtils.preCheckCast(r6.next(), Header.class, "com.obric.memorydata.plugin");
        if (r4.equalsIgnoreCase(r0.getName()) == false) goto L11;
        return r0.getValue();
    L16:
        return "";
    L24:
        return null;
    }

    private static List<Interceptor> a() {
        List<Interceptor> r0 = f3325b;
        if (r0 != null) goto L15;
        monitor-enter(RetrofitUtils.class);
        r0 = f3325b;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = b();     // Catch: Throwable -> L11
        f3325b = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetrofitUtils.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return new ArrayList(r0);
    }

    public static synchronized Retrofit b(String r5) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (h.a(r5) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r1 = (Retrofit) ZeusTransformUtils.preCheckCast(c.a(r5), Retrofit.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r1;
    L13:
        Retrofit r2 = a(r5, null, null, null);     // Catch: Throwable -> L16
        c.a(r5, r2);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r2;
    }

    private static List<Interceptor> b() {
        if (f3324a != null) goto L5;
        int r0 = 0;
    L6:
        ArrayList r1 = new ArrayList(r0 + 2);
        r1.add(new com.bytedance.ttnet.retrofit.b());
        if (r0 <= 0) goto L9;
        r1.addAll(f3324a);
    L9:
        r1.add(new com.bytedance.frameworks.baselib.network.http.c.b());
        return r1;
    L5:
        r0 = f3324a.size();
        goto L6
    }

    public static List<Interceptor> c(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        String r0 = d(r2);
        if (TextUtils.isEmpty(r0) == true) goto L10;
        r2 = r0;
    L10:
        Retrofit r3 = e(r2);
        if (r3 == null) goto L18;
        List<Interceptor> r4 = r3.interceptors();
        if (r4 == null) goto L16;
        return r4;
    L16:
        return a();
    L18:
        return a();
    L5:
        return a();
    }

    private static String d(String r2) {
        URI r3 = i.a(r2);     // Catch: Throwable -> L12
        if (r3 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3.getScheme()) == false) goto L7;
        String r0 = LocationInfoConst.HTTPS;
    L8:
        String r4 = r3.getRawAuthority();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r4) == true) goto L18;
        return r0 + "://" + r4 + "/";
    L18:
        return null;
    L7:
        r0 = r3.getScheme();     // Catch: Throwable -> L12
    L12:
        Logger.w("RetrofitUtils", "url invalid");
        return null;
    }

    private static Retrofit e(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L16;
        e<String, Retrofit> r0 = c;
        if (r0 == null) goto L18;
        Retrofit r1 = (Retrofit) ZeusTransformUtils.preCheckCast(r0.a(r3), Retrofit.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        return r1;
    L11:
        if (r3.endsWith("/") == false) goto L13;
        String r4 = r3.substring(0, r3.length() - 1);
    L15:
        return (Retrofit) ZeusTransformUtils.preCheckCast(c.a(r4), Retrofit.class, "com.obric.memorydata.plugin");
    L13:
        r4 = r3 + "/";
        goto L15
    L18:
        return null;
    L16:
        return null;
    }
}
