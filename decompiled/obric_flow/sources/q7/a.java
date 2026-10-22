package q7;

import ai.e;
import ai.l;
import ai.m;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import com.airbnb.lottie.network.FileExtension;
import com.bytedance.ai.lynx.i;
import com.bytedance.ai.resource.e0;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import com.bytedance.retrofit2.SsHttpCall;
import com.google.common.reflect.w;
import com.lynx.component.svg.parser.SVGParseException;
import com.lynx.component.svg.parser.n0;
import com.lynx.tasm.a0;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import d9.b;
import i9.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipInputStream;
import ko.r;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.r1;
import m9.d;
import mt.b0;
import mt.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sj.k;
import z8.c;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e, go.a, g1.e, d, j, b0, kotlinx.coroutines.selects.d {
    public static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f21489c;

    public /* synthetic */ a(int r5) {
        this.f21487a = r5;
    }

    public static String j(HttpURLConnection r5) {
        r5.getResponseCode();
        BufferedReader r10 = new BufferedReader(new InputStreamReader(r5.getErrorStream()));
        StringBuilder r11 = new StringBuilder();
    L21:
        String r12 = r10.readLine();     // Catch: Throwable -> L7 Exception -> L9
        if (r12 == null) goto L19;
        r11.append(r12);     // Catch: Throwable -> L7 Exception -> L9
        r11.append('\n');     // Catch: Throwable -> L7 Exception -> L9
    L19:
        r10.close();     // Catch: Exception -> L17
    L13:
        return r11.toString();
    L7:
        th = move-exception;
        r10.close();     // Catch: Exception -> L18
    L16:
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    }

    public static a k() {
        if (d != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        a r5 = new a(0);     // Catch: Throwable -> L9
        r5.f21488b = new CopyOnWriteArraySet();     // Catch: Throwable -> L9
        r5.f21489c = new ConcurrentHashMap();     // Catch: Throwable -> L9
        d = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    @Override // ai.e
    public Object a(SsHttpCall r5) {
        return new l(((m) this.f21489c).f280a, r5);
    }

    public Object b(String r5, Continuation r10) {
        String r11 = Uri.parse(r5).getQueryParameter("forest_session_id");
        if (r11 == null) goto L6;
        this.f21488b = r11;
    L6:
        return i.b((String) this.f21488b, r5, (ContinuationImpl) r10);
    }

    @Override // m9.d
    public c c(int r10, c r11) {
        String r5 = "true";
        if (r10 == 1) goto L18;
        if (r10 != 2) goto L6;
        JSONArray r12 = a.a.p();
        long r13 = SystemClock.uptimeMillis();
        JSONObject r14 = a.a.f();
        JSONArray r15 = a.a.e(r13);
        mh.e.g(r12, "history_message", r11.f23416a);
        mh.e.g(r14, "current_message", r11.f23416a);
        mh.e.g(r15, "pending_messages", r11.f23416a);
        String r16 = String.valueOf(l9.c.b());
        c.l(r11.b(), "filters", "disable_looper_monitor", r16);
        mh.e.g(f.h(), "alive_pids", r11.f23416a);
        return r11;
    L6:
        if (r10 != 3) goto L8;
        JSONObject r17 = l9.c.e();
        if (mh.e.c(r17, -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native"}) != 1) goto L15;
        mh.e.g(h.d((String) this.f21488b), "all_thread_stacks", r11.f23416a);
        c.l(r11.b(), "filters", "has_all_thread_stack", "true");
    L15:
        return r11;
    L8:
        if (r10 != 4) goto L15;
        ym.m.g(n.f4057a, r11.f23416a);
        return r11;
    L18:
        String r18 = (String) this.f21488b;
        if (r18 != null) goto L21;
    L41:
        boolean r19 = p.f4081a;
        if (b.f16613h == true) goto L45;
        r5 = "false";
    L45:
        c.l(r11.b(), "filters", "crash_after_crash", r5);
        z5.a.c(g.f(n.f4057a), CrashType.NATIVE);
        return r11;
    L21:
        if (r18.isEmpty() == true) goto L41;
        String r20 = (String) this.f21488b;
        String r21 = "";
        if (TextUtils.isEmpty(r20) == false) goto L26;
    L40:
        mh.e.g(r21, "java_data", r11.f23416a);
        goto L41
    L26:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equalsIgnoreCase(r20) == false) goto L28;
        r21 = h.c(Looper.getMainLooper().getThread().getStackTrace());
        goto L40
    L28:
        ThreadGroup r22 = Looper.getMainLooper().getThread().getThreadGroup();
        int r23 = r22.activeCount();
        Thread[] r24 = new Thread[(r23 / 2) + r23];
        int r25 = r22.enumerate(r24);
        int r26 = 0;
    L29:
        if (r26 >= r25) goto L40;
        String r27 = r24[r26].getName();
        if (TextUtils.isEmpty(r27) == true) goto L39;
        if (r27.equals(r20) == true) goto L38;
        if (r27.startsWith(r20) == true) goto L38;
        if (r27.endsWith(r20) == false) goto L39;
    L38:
        r21 = h.c(r24[r26].getStackTrace());
    L39:
        r26 = r26 + 1;
        goto L29
    }

    @Override // m9.d
    public c d(int r5, c r10) {
        cl.a.q(new File(((File) this.f21489c).getAbsolutePath() + '.' + r5), r10.f23416a);
        if (r5 != 0) goto L5;
        v8.a.d().getClass();
    L5:
        return r10;
    }

    public void e(String r5, Function1 r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "onSuccess");
        Intrinsics.checkNotNullParameter(r11, "onFailure");
        if (r5.length() != 0) goto L6;
        r11.invoke(new Exception("url is empty"));
        return;
    L6:
        String r12 = "loadResourceAsync: start to load ".concat(r5);
        Intrinsics.checkNotNullParameter("DefaultLynxResourceLoader", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L9;
        r13.i("DefaultLynxResourceLoader", r12);
    L9:
        String r14 = (String) this.f21489c;
        if (r14 != null) goto L12;
    L15:
        LruCache r15 = e0.f2711a;
        e0.k((String) this.f21488b, r5, new com.bytedance.ai.model.widgets.d(9, r10, r11), new com.bytedance.ai.bridge.method.router.h(3, r11), false);
        return;
    L12:
        if (r14.length() == 0) goto L15;
        r5 = e0.m(r5, r14);
        goto L15
    }

    @Override // go.a
    public void f(w r5) {
        switch(this.f21487a) {
            case 4: goto L19;
            default: goto L4;
        };
    L4:
        LynxResourceResponse$ResponseState r10 = (LynxResourceResponse$ResponseState) r5.f9377c;
        LynxResourceResponse$ResponseState r11 = LynxResourceResponse$ResponseState.f10948b;
        k r12 = (k) this.f21488b;
        if (r10 != r11) goto L13;
        Object r13 = r5.f9376b;
        if (r13 != null) goto L27;
        r12.i("data is empty!");
        return;
    L27:
        r12.h(n0.e(new String((byte[]) r13, StandardCharsets.UTF_8)));     // Catch: SVGParseException -> L11
        return;
    L11:
        e = move-exception;
        r12.i(e.toString());
        return;
    L13:
        Throwable r14 = (Throwable) r5.d;
        if (r14 == null) goto L16;
        String r15 = r14.toString();
    L17:
        r12.i(r15);
        return;
    L16:
        r15 = "svg fetch src failed! " + ((String) this.f21489c);
        goto L17
    L19:
        int r16 = ((LynxResourceResponse$ResponseState) r5.f9377c).ordinal();
        a0 r17 = (a0) this.f21488b;
        if (r16 != 0) goto L22;
        r17.a(((Throwable) r5.d).getMessage());
        return;
    L22:
        if (r16 != 1) goto L33;
        r17.b((byte[]) r5.f9376b);
        return;
    }

    public com.airbnb.lottie.a0 g() {
        u.b.a();
        String r5 = (String) this.f21488b;
        HttpURLConnection r10 = (HttpURLConnection) new URL(r5).openConnection();
        r10.setRequestMethod("GET");
        r10.connect();     // Catch: Throwable -> L11 Exception -> L13
        if (r10.getErrorStream() == null) goto L6;
    L15:
        com.airbnb.lottie.a0 r11 = new com.airbnb.lottie.a0(new IllegalArgumentException("Unable to fetch " + r5 + ". Failed with " + r10.getResponseCode() + "\n" + j(r10)));     // Catch: Throwable -> L11 Exception -> L13
        r10.disconnect();
        return r11;
    L6:
        if (r10.getResponseCode() != 200) goto L15;
        com.airbnb.lottie.a0 r12 = o(r10);     // Catch: Throwable -> L11 Exception -> L13
        u.b.a();     // Catch: Throwable -> L11 Exception -> L13
        r10.disconnect();
        return r12;
    L11:
        th = move-exception;
        r10.disconnect();
        throw th;
    L13:
        e = move-exception;
        com.airbnb.lottie.a0 r13 = new com.airbnb.lottie.a0(e);     // Catch: Throwable -> L11
        r10.disconnect();
        return r13;
    }

    public List h() {
        ConcurrentHashMap r5 = fa.c.f16887a;
        String r10 = (String) this.f21488b;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        ConcurrentHashMap r11 = fa.c.f16887a;
        if (r11.get(r10) == null) goto L7;
        return ((fa.b) r11.get(r10)).e();
    L7:
        return null;
    }

    public synchronized com.lynx.tasm.behavior.d i() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (((com.lynx.tasm.behavior.d) this.f21488b) != null) goto L8;
        this.f21488b = new com.lynx.tasm.behavior.d(13);     // Catch: Throwable -> L6
    L8:
        com.lynx.tasm.behavior.d r5 = (com.lynx.tasm.behavior.d) this.f21488b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    }

    public synchronized ib.d l() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (((ib.d) this.f21489c) != null) goto L8;
        this.f21489c = new ib.d(1);     // Catch: Throwable -> L6
    L8:
        ib.d r5 = (ib.d) this.f21489c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    }

    public JSONObject m(boolean r5) {
        JSONObject r10 = new JSONObject();
        Iterator r11 = ((ConcurrentHashMap) this.f21489c).entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r11.hasNext() == false) goto L7;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L11
        r10.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r10.put("RealRefreshRate", String.valueOf(com.bytedance.apm.util.e.e));     // Catch: JSONException -> L11
        r10.put("RealMaxRefreshRate", String.valueOf(com.bytedance.apm.util.e.e));     // Catch: JSONException -> L11
        if (r5 == false) goto L10;
        com.bytedance.apm.util.c.f3909a.getClass();     // Catch: JSONException -> L11
    L10:
        return r10;
    }

    public String n() {
        ha.b r5 = (ha.b) this.f21489c;
        if (TextUtils.isEmpty(r5.f17295i) == true) goto L11;
        List r10 = h();
        if (r10 != null) goto L7;
        return null;
    L7:
        if (r10.size() > 0) goto L14;
        return null;
    L14:
        return "https://" + r5.f17295i + new URL((String) r10.get(0)).getPath();
    L18:
        return null;
    L11:
        return null;
    }

    public com.airbnb.lottie.a0 o(HttpURLConnection r5) {
        String r10 = r5.getContentType();
        if (r10 != null) goto L5;
        r10 = "application/json";
    L5:
        boolean r11 = r10.contains("application/zip");
        String r12 = (String) this.f21488b;
        r r13 = (r) this.f21489c;
        if (r11 == false) goto L13;
        u.b.a();
        FileExtension r14 = FileExtension.ZIP;
        ZipInputStream r15 = new ZipInputStream(new FileInputStream(r13.v(r5.getInputStream(), r14)));
        com.airbnb.lottie.a0 r16 = com.airbnb.lottie.n.d(r15, r12);     // Catch: Throwable -> L10
        u.f.b(r15);
    L15:
        if (r16.f1247a == null) goto L19;
        File r17 = new File(((Context) r13.f18728b).getCacheDir(), r.q((String) r13.f18729c, r14, true));
        File r18 = new File(r17.getAbsolutePath().replace(".temp", ""));
        boolean r19 = r17.renameTo(r18);
        r18.toString();
        u.b.a();
        if (r19 == true) goto L19;
        u.b.b("Unable to rename cache file " + r17.getAbsolutePath() + " to " + r18.getAbsolutePath() + ".");
    L19:
        return r16;
    L10:
        th = move-exception;
        u.f.b(r15);
        throw th;
    L13:
        u.b.a();
        r14 = FileExtension.JSON;
        r16 = com.airbnb.lottie.n.b(new FileInputStream(new File(r13.v(r5.getInputStream(), r14).getAbsolutePath())), r12);
        goto L15
    }

    @Override // mt.j
    public void onComplete() {
        ((j) this.f21489c).onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        switch(this.f21487a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        ((b0) this.f21489c).onError(r5);
        return;
    L6:
        ((j) this.f21489c).onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        switch(this.f21487a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.replace((AtomicReference) this.f21488b, r5);
        return;
    L6:
        DisposableHelper.replace((AtomicReference) this.f21488b, r5);
    }

    @Override // mt.j
    public void onSuccess(Object r5) {
        switch(this.f21487a) {
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        ((b0) this.f21489c).onSuccess(r5);
        return;
    L6:
        ((j) this.f21489c).onSuccess(r5);
    }

    public long p() {
        ConcurrentHashMap r5 = fa.c.f16887a;
        String r10 = (String) this.f21488b;
        if (TextUtils.isEmpty(r10) == true) goto L7;
        ConcurrentHashMap r11 = fa.c.f16887a;
        if (r11.get(r10) == null) goto L7;
        int r12 = ((fa.b) r11.get(r10)).h() * 1000;
    L9:
        return r12;
    L7:
        r12 = 15000;
        goto L9
    }

    @Override // ai.e
    public Type responseType() {
        return (Type) this.f21488b;
    }

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f21487a = r5;
        this.f21489c = r10;
        this.f21488b = r11;
    }

    public /* synthetic */ a(int r5, Object r10, boolean r11, Object r12) {
        this.f21487a = r5;
        this.f21488b = r10;
        this.f21489c = r12;
    }

    public a(String r5, String r10) {
        this.f21487a = 5;
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        this.f21488b = r5;
        this.f21489c = r10;
    }

    public a(Context r5, String r10) {
        this.f21487a = 14;
        Context r11 = r5.getApplicationContext();
        this.f21488b = r10;
        this.f21489c = new r(r11, r10);
    }

    public a(r1 r5, Function3 r10) {
        this.f21487a = 11;
        this.f21488b = r10;
        this.f21489c = null;
    }
}
