package e9;

import android.text.TextUtils;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import ha.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList<Interceptor> f7208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l7.d<String, Retrofit> f7209b = null;

    static {
        f7208a = new CopyOnWriteArrayList();
        Retrofit.setCommonInterceptor(f7208a);
        f7209b = new l7.d(10);
        new l7.d(10);
    }

    public static synchronized Retrofit a(ArrayList r8, ArrayList r10, c r11, String r12) {
        monitor-enter(d.class);
        Retrofit.Builder r13 = new Retrofit.Builder().setEndpoint(r12).client(r11).httpExecutor(new i7.c());     // Catch: Throwable -> L33
        if (r8 != null) goto L8;
        r8 = new ArrayList();     // Catch: Throwable -> L33
    L8:
        if (r8.isEmpty() == false) goto L10;
        r8.add(new j7.a(new j()));     // Catch: Throwable -> L33
    L10:
        Iterator r14 = r8.iterator();     // Catch: Throwable -> L33
    L12:
        if (r14.hasNext() == false) goto L14;
        r13.addConverterFactory((Converter.Factory) r14.next());     // Catch: Throwable -> L33
        goto L12
    L14:
        if (r10 != null) goto L16;
    L21:
        LinkedList r15 = new LinkedList();     // Catch: Throwable -> L33
        r15.add(0, new c9.a());     // Catch: Throwable -> L33
        if (f7208a != null) goto L24;
    L26:
        r15.add(new i7.b());     // Catch: Throwable -> L33
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L33
    L28:
        if (r16.hasNext() == false) goto L30;
        r13.addInterceptor((Interceptor) r16.next());     // Catch: Throwable -> L33
        goto L28
    L30:
        Retrofit r17 = r13.build();     // Catch: Throwable -> L33
        monitor-exit(d.class);
        return r17;
    L24:
        if (f7208a.size() <= 0) goto L26;
        r15.addAll(f7208a);     // Catch: Throwable -> L33
        goto L26
    L16:
        if (r10.isEmpty() == true) goto L21;
        Iterator r18 = r10.iterator();     // Catch: Throwable -> L33
    L19:
        if (r18.hasNext() == false) goto L21;
        r13.addCallAdapterFactory((CallAdapter.Factory) r18.next());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit b(String r8) {
        monitor-enter(d.class);
        c r10 = new c();     // Catch: Throwable -> L14
        monitor-enter(d.class);     // Catch: Throwable -> L14
        Retrofit r11 = a(null, null, r10, r8);     // Catch: Throwable -> L11
        monitor-exit(d.class);     // Catch: Throwable -> L14
        monitor-exit(d.class);
        return r11;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static synchronized Object c(Class r8, String r10) {
        monitor-enter(d.class);
        Retrofit r11 = e(r10);     // Catch: Throwable -> L17
        monitor-enter(d.class);     // Catch: Throwable -> L17
        if (r11 != null) goto L20;
        monitor-exit(d.class);     // Catch: Throwable -> L17
        Object r12 = null;
    L15:
        monitor-exit(d.class);
        return r12;
    L20:
        r12 = r11.create(r8);     // Catch: Throwable -> L10
        monitor-exit(d.class);     // Catch: Throwable -> L17
        goto L15
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static String d(String r8, List r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L23;
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L15;
        Header r12 = (Header) r11.next();
        if (r8.equalsIgnoreCase(r12.getName()) == false) goto L10;
        return r12.getValue();
    L15:
        return "";
    L23:
        return null;
    }

    public static synchronized Retrofit e(String r8) {
        monitor-enter(d.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f.b(r8) == false) goto L9;
        monitor-exit(d.class);
        return null;
    L9:
        l7.d<String, Retrofit> r10 = f7209b;     // Catch: Throwable -> L16
        Retrofit r11 = r10.b(r8);     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        monitor-exit(d.class);
        return r11;
    L13:
        Retrofit r12 = b(r8);     // Catch: Throwable -> L16
        r10.d(r8, r12);     // Catch: Throwable -> L16
        monitor-exit(d.class);
        return r12;
    }
}
