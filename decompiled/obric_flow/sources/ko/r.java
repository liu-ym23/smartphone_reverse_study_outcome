package ko;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Consumer;
import com.airbnb.lottie.network.FileExtension;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.view.popup.anim.AnimController$AnimProcessType;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.service.IServiceProvider;
import com.obric.oui.orecyclerview.widget.c1;
import com.obric.oui.orecyclerview.widget.f0;
import com.obric.oui.orecyclerview.widget.x0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mt.b0;
import nu.u;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements ai.i, mt.b, b0, o1.f, dh.e {
    public static volatile r d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f18728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f18729c;

    public /* synthetic */ r(int r5, Object r10, Object r11) {
        this.f18727a = r5;
        this.f18728b = r10;
        this.f18729c = r11;
    }

    public static ILocalSettings d(Class r5, pg.d r10) {
        vg.a r11 = (vg.a) r10.f21352c.f5321c;
        Constructor<?> r12 = Class.forName(r5.getName().concat("$$Impl"), true, r5.getClassLoader()).getConstructor(new Class[]{qg.d.class});     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        rg.a r13 = (rg.a) r5.getAnnotation(rg.a.class);     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        if (r13 == null) goto L23;
        tg.a r14 = tg.a.f22131a;     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        String r15 = r13.storageKey();     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        r13.isSupportMultiProcess();     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        r11.getClass();     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        ConcurrentHashMap r16 = vg.a.f22577a;     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        vg.b r17 = (vg.b) r16.get(r15);     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        if (r17 != null) goto L9;
        r17 = new vg.b(ug.a.b(), r15);     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
        r16.put(r15, r17);     // Catch: Throwable -> L11 InvocationTargetException -> L13 InstantiationException -> L15 IllegalAccessException -> L17 NoSuchMethodException -> L19 ClassNotFoundException -> L21
    L9:
        return (ILocalSettings) r12.newInstance(new Object[]{r17});
    L23:
        e = null;
    L31:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", e);
    L21:
        e = e;
        e.printStackTrace();
    L17:
        e = e;
        e.printStackTrace();
    L15:
        e = e;
        e.printStackTrace();
    L19:
        e = e;
        e.printStackTrace();
    L13:
        e = e;
        e.printStackTrace();
    L11:
        th = move-exception;
        throw th;
    }

    public static r g() {
        if (d != null) goto L16;
        monitor-enter(r.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new r(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public static r h(Uri r13) {
        int r5 = 13;
        Object r10 = null;
        if (r13 == null) goto L7;
        String r11 = r13.getHost();
        if (r11 == null) goto L7;
        List r12 = StringsKt.J(r11, new char[]{'.'}, 0, 6);
    L8:
        if (r12 != null) goto L10;
        r12 = CollectionsKt.emptyList();
    L10:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L17;
        Object r16 = r15.next();
        if (((String) r16).length() <= 0) goto L12;
        r14.add(r16);
        goto L12
    L17:
        if (r14.isEmpty() == false) goto L19;
        return null;
    L19:
        r14.add("/");
        if (r13 == null) goto L22;
        List<String> r17 = r13.getPathSegments();
    L23:
        if (r17 != null) goto L25;
        r17 = CollectionsKt.emptyList();
    L25:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L27:
        if (r19.hasNext() == false) goto L35;
        List r20 = StringsKt.J((String) r19.next(), new char[]{'.'}, 0, 6);
        ArrayList r110 = new ArrayList();
        Iterator r21 = r20.iterator();
    L30:
        if (r21.hasNext() == false) goto L34;
        Object r111 = r21.next();
        if (((String) r111).length() <= 0) goto L30;
        r110.add(r111);
        goto L30
    L34:
        CollectionsKt.a(r18, r110);
        goto L27
    L35:
        r14.addAll(r18);
        Set<String> r112 = r13.getQueryParameterNames();
        if (r112.isEmpty() == false) goto L40;
        return new r(r5, r14, r10);
    L40:
        return new r(r5, r14, new ArrayList(r112));
    L22:
        r17 = null;
    L7:
        r12 = null;
        goto L8
    }

    public static String q(String r5, FileExtension r10, boolean r11) {
        StringBuilder r12 = new StringBuilder("lottie_cache_");
        r12.append(r5.replaceAll("\\W+", ""));
        if (r11 == false) goto L5;
        String r13 = r10.tempExtension();
    L6:
        r12.append(r13);
        return r12.toString();
    L5:
        r13 = r10.extension;
        goto L6
    }

    public static r r(String... r12) {
        ByteString[] r5 = new ByteString[r12.length];     // Catch: IOException -> L25
        nu.j r10 = new nu.j();     // Catch: IOException -> L25
        int r11 = 0;
    L4:
        if (r11 >= r12.length) goto L27;
        String r13 = r12[r11];     // Catch: IOException -> L25
        String[] r14 = com.airbnb.lottie.parser.moshi.a.e;     // Catch: IOException -> L25
        r10.T(34);     // Catch: IOException -> L25
        int r15 = r13.length();     // Catch: IOException -> L25
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L22;
        char r18 = r13.charAt(r16);     // Catch: IOException -> L25
        if (r18 >= 128) goto L13;
        String r19 = r14[r18];     // Catch: IOException -> L25
        if (r19 == null) goto L21;
    L18:
        if (r17 >= r16) goto L20;
        r10.a0(r17, r16, r13);     // Catch: IOException -> L25
    L20:
        r10.b0(r19);     // Catch: IOException -> L25
        r17 = r16 + 1;     // Catch: IOException -> L25
    L21:
        r16 = r16 + 1;     // Catch: IOException -> L25
        goto L6
    L13:
        if (r18 != 8232) goto L16;
        r19 = "\\u2028";
        goto L18
    L16:
        if (r18 != 8233) goto L21;
        r19 = "\\u2029";
        goto L18
    L22:
        if (r17 >= r15) goto L24;
        r10.a0(r17, r15, r13);     // Catch: IOException -> L25
    L24:
        r10.T(34);     // Catch: IOException -> L25
        r10.readByte();     // Catch: IOException -> L25
        r5[r11] = r10.v(r10.f20328b);     // Catch: IOException -> L25
        r11 = r11 + 1;     // Catch: IOException -> L25
        goto L4
    L27:
        String[] r110 = (String[]) r12.clone();     // Catch: IOException -> L25
        int r20 = u.f20340c;     // Catch: IOException -> L25
        return new r(2, r110, f8.b.n(r5));
    L25:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // o1.f
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r5, "msg");
        AIBridgeMethod$Error r10 = new AIBridgeMethod$Error(r5, null);
        ((Consumer) this.f18729c).accept(r10);
    }

    @Override // o1.f
    public void b(ResultModel r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r10, "msg");
        JsonObject r11 = r5.toJson();
        JsonObject r12 = new JsonObject();
        r12.addProperty("code", 1);
        r12.add("data", r11);
        r12.addProperty("msg", r10);
        ((Consumer) this.f18728b).accept(r12);
    }

    @Override // o1.f
    public void c(String r5, ResultModel r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (r10 == null) goto L5;
        JsonObject r11 = r10.toJson();
    L6:
        Intrinsics.checkNotNullParameter(r5, "msg");
        AIBridgeMethod$Error r12 = new AIBridgeMethod$Error(r5, r11);
        ((Consumer) this.f18729c).accept(r12);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // ai.i
    public Object convert(Object r5) {
        fi.i r10 = (fi.i) r5;
        if (r10.a() == null) goto L5;
        String r11 = fi.d.a(r10.a());
    L6:
        InputStreamReader r12 = new InputStreamReader(r10.c(), r11);
        JsonReader r13 = ((Gson) this.f18728b).newJsonReader(r12);
        Object r14 = ((TypeAdapter) this.f18729c).read(r13);     // Catch: Throwable -> L10
        r12.close();     // Catch: IOException -> L13
    L9:
        return r14;
    L10:
        th = move-exception;
        r12.close();     // Catch: IOException -> L14
    L12:
        throw th;
    L5:
        r11 = "UTF-8";
        goto L6
    }

    public IServiceProvider e(Class r5) {
        q r10 = (q) ((ConcurrentHashMap) this.f18729c).get(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.f18726b == true) goto L10;
        Log.w("LynxServiceCenter", "Service " + r5 + " hasn't been initialized");
        return null;
    L10:
        return r10.f18725a;
    }

    public Object f(String r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        if (r5.length() != 0) goto L5;
        return null;
    L5:
        HashMap r10 = (HashMap) this.f18729c;
        if (r10.containsKey(r5) == true) goto L8;
        JSONObject r11 = (JSONObject) this.f18728b;
        if (r11.has(r5) == false) goto L15;
        Object r12 = r11.opt(r5);
        if (r10.containsKey(r5) == true) goto L14;
        r10.put(r5, r12);
    L14:
        return r12;
    L15:
        int r13 = StringsKt.u(r5, ".");
        if (r13 >= 0) goto L18;
        return null;
    L18:
        Object r14 = f(r5.substring(0, r13));
        if (r14 != null) goto L21;
    L28:
        return null;
    L21:
        if ((r14 instanceof JSONObject) == false) goto L28;
        Object r15 = ((JSONObject) r14).opt(r5.substring(r13 + 1));
        if (r15 != null) goto L25;
    L27:
        return r15;
    L25:
        if (r10.containsKey(r5) == true) goto L27;
        r10.put(r5, r15);
        goto L27
    L8:
        return r10.get(r5);
    }

    @Override // dh.e
    public Map getRequestHeaders() {
        HashMap r5 = new HashMap();
        Map r10 = (Map) this.f18729c;
        if (r10 == null) goto L8;
        Iterator r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        r5.put(r12.getKey(), r12.getValue());
    L8:
        return r5;
    }

    @Override // dh.e
    public Uri getUrl() {
        return (Uri) this.f18728b;
    }

    public void i() {
        long r5 = System.currentTimeMillis();
    L3:
        PriorityQueue r10 = (PriorityQueue) this.f18729c;
        if (r10.isEmpty() == true) goto L8;
        if (((Number) ((Pair) r10.peek()).getFirst()).longValue() > r5) goto L11;
        Pair r11 = (Pair) r10.poll();
        ((HashMap) this.f18728b).remove(r11.getSecond());
        goto L3
    L11:
        return;
    }

    public void j(Application r5) {
        this.f18728b = r5;
        monitor-enter(q.class);
        Iterator r10 = ((ConcurrentHashMap) this.f18729c).entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L12;
        q r11 = (q) ((Map.Entry) r10.next()).getValue();     // Catch: Throwable -> L10
        if (r11.f18726b == true) goto L6;
        r11.f18726b = true;     // Catch: Throwable -> L10
        r11.f18725a.onInitialize(r5);     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(q.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void k(IServiceProvider r5) {
        Class<? extends IServiceProvider> r10 = r5.getServiceClass();
        if (r10.isInstance(r5) == true) goto L6;
        Log.e("LynxServiceCenter", "Incorrect service type: ".concat(r10.getSimpleName()));
        return;
    L6:
        q r11 = new q(r5);
        Application r12 = (Application) this.f18728b;
        if (r12 == null) goto L9;
        r11.f18726b = true;
        r5.onInitialize(r12);
    L9:
        ((ConcurrentHashMap) this.f18729c).put(r10, r11);
    }

    public void l(sg.a r18) {
        int r5 = -1;
    L3:
        BufferedInputStream r10 = (BufferedInputStream) this.f18728b;
        int r11 = r10.read();
        if (r11 == r5) goto L97;
        byte r12 = (byte) r11;
        if ((r12 & ByteCompanionObject.MIN_VALUE) == 0) goto L8;
        boolean r13 = true;
    L9:
        byte r14 = (byte) (r12 & 15);
        int r15 = r10.read();
        if (r15 == r5) goto L95;
        byte r16 = (byte) r15;
        if ((r16 & ByteCompanionObject.MIN_VALUE) == 0) goto L14;
        boolean r17 = true;
    L15:
        int r19 = (byte) (r16 & ByteCompanionObject.MAX_VALUE);
        if (r19 > 125) goto L19;
    L17:
        long r110 = r19;
    L38:
        if (r17 == false) goto L46;
        int r20 = 4;
        byte[] r21 = new byte[4];
        int r111 = 0;
    L40:
        if (r20 <= 0) goto L47;
        int r112 = r10.read(r21, r111, r20);
        if (r112 == (-1)) goto L45;
        r20 = r20 - r112;
        r111 = r111 + r112;
        goto L40
    L45:
        throw new EOFException();
    L47:
        int r22 = (int) r110;
        byte[] r23 = new byte[r22];
        int r113 = r22;
        int r114 = 0;
    L48:
        if (r113 <= 0) goto L54;
        int r115 = r10.read(r23, r114, r113);
        if (r115 == (-1)) goto L53;
        r113 = r113 - r115;
        r114 = r114 + r115;
        goto L48
    L53:
        throw new EOFException();
    L54:
        int r24 = r22;
        int r116 = 0;
        int r117 = 0;
    L55:
        int r118 = r24 - 1;
        if (r24 <= 0) goto L58;
        r23[r116] = (byte) (r21[r117 % r21.length] ^ r23[r116]);
        r116 = r116 + 1;
        r24 = r118;
        r117 = r117 + 1;
        goto L55
    L58:
        ((ByteArrayOutputStream) this.f18729c).write(r23, 0, r22);
        if (r13 == false) goto L89;
        byte[] r25 = ((ByteArrayOutputStream) this.f18729c).toByteArray();
        int r26 = r25.length;
        r18.getClass();
        if (r14 != 1) goto L63;
        zm.c r27 = ((ek.d) r18.f21902a).f16828c;
        ((bk.c) r27.f23470b).b(new String(r25, 0, r26));
    L87:
        ((ByteArrayOutputStream) this.f18729c).reset();
        goto L89
    L63:
        if (r14 == 2) goto L85;
        switch(r14) {
            case 8: goto L69;
            case 9: goto L67;
            case 10: goto L87;
            default: goto L65;
        };
    L65:
        ((ek.d) r18.f21902a).b(new IOException(com.lynx.jsbridge.a.d(r14, "Unsupported frame opcode=")));
        goto L87
    L67:
        ek.d r28 = (ek.d) r18.f21902a;
        ek.a r29 = new ek.a();
        r29.f16821a = true;
        r29.f16822b = 10;
        r29.f16823c = r26;
        r29.d = r25;
        r28.a(r29);
        goto L87
    L69:
        if (r26 < 2) goto L74;
        byte r30 = r25[0];
        byte r31 = r25[1];
        if (r26 <= 2) goto L73;
        String r32 = new String(r25, 2, r26 - 2);
    L76:
        if (((ek.d) r18.f21902a).e == true) goto L84;
        ek.d r33 = (ek.d) r18.f21902a;
        r33.getClass();
        int r34 = ek.b.f16824a;
        byte[] r35 = "Received close frame".getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L80
        int r36 = r35.length + 2;
        byte[] r37 = new byte[r36];
        r37[0] = (byte) 3;
        r37[1] = (byte) 232;
        System.arraycopy(r35, 0, r37, 2, r35.length);
        ek.a r38 = new ek.a();
        r38.f16821a = true;
        r38.f16822b = 8;
        r38.f16823c = r36;
        r38.d = r37;
        r33.a(r38);
        r33.e = true;
    L80:
        e = move-exception;
        throw new RuntimeException(e);
    L84:
        ((ek.d) r18.f21902a).c(r32);
        goto L87
    L73:
        r32 = null;
        goto L76
    L74:
        r32 = "Unparseable close frame";
        goto L76
    L85:
        ((ek.d) r18.f21902a).f16828c.getClass();
        Log.e("ChromeDevtoolsServer", "onMessage: byte");
    L89:
        if (r14 == 8) goto L90;
        r5 = -1;
        goto L3
    L90:
        return;
    L46:
        r21 = null;
        goto L47
    L19:
        if (r19 != 126) goto L30;
        int r39 = r10.read();
        if (r39 == r5) goto L28;
        int r40 = (((byte) r39) & UByte.MAX_VALUE) << 8;
        int r119 = r10.read();
        if (r119 == r5) goto L26;
        r19 = r40 | (((byte) r119) & UByte.MAX_VALUE);
        goto L17
    L26:
        throw new EOFException();
    L28:
        throw new EOFException();
    L30:
        if (r19 != 127) goto L93;
        r110 = 0;
        int r41 = 0;
    L32:
        if (r41 >= 8) goto L38;
        long r120 = r110 << 8;
        int r121 = r10.read();
        if (r121 == r5) goto L37;
        r110 = r120 | ((long) (((byte) r121) & UByte.MAX_VALUE));
        r41 = r41 + 1;
        r5 = -1;
        goto L32
    L37:
        throw new EOFException();
    L93:
        throw new IOException(com.lynx.jsbridge.a.d(r19, "Unexpected length byte: "));
    L14:
        r17 = false;
        goto L15
    L95:
        throw new EOFException();
    L8:
        r13 = false;
        goto L9
    L97:
        throw new EOFException();
    }

    public void m(boolean r5) {
        AnimController$AnimProcessType r10 = AnimController$AnimProcessType.f2881c;
        Intrinsics.checkNotNullParameter(r10, "processType");
        if (r5 == false) goto L6;
        this.f18728b = r10;
        return;
    L6:
        this.f18729c = r10;
    }

    public void n(x0 r5, f0 r10) {
        SimpleArrayMap r11 = (SimpleArrayMap) this.f18728b;
        c1 r12 = (c1) r11.get(r5);
        if (r12 != null) goto L5;
        r12 = c1.a();
        r11.put(r5, r12);
    L5:
        r12.f13799c = r10;
        r12.f13797a |= 8;
    }

    public Long o(String r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        Object r10 = f(r5);
        if (r10 != null) goto L6;
    L9:
        return 0L;
    L6:
        if ((r10 instanceof Number) == false) goto L9;
        return Long.valueOf(((Number) r10).longValue());
    }

    @Override // mt.b
    public void onComplete() {
        ((mt.b) this.f18729c).onComplete();
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        switch(this.f18727a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        ((b0) this.f18728b).onError(r5);
        return;
    L6:
        ((mt.b) this.f18729c).onError(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        switch(this.f18727a) {
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        DisposableHelper.setOnce((AtomicReference) this.f18729c, r5);
        return;
    L6:
        DisposableHelper.replace((AtomicReference) this.f18728b, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(Object r5) {
        ((b0) this.f18728b).onSuccess(r5);
    }

    public String p(String r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        Object r10 = f(r5);
        if (r10 != null) goto L6;
        return "";
    L6:
        if ((r10 instanceof String) == true) goto L8;
        return "";
    L8:
        return (String) r10;
    }

    public f0 s(x0 r5, int r10) {
        SimpleArrayMap r11 = (SimpleArrayMap) this.f18728b;
        int r12 = r11.indexOfKey(r5);
        if (r12 >= 0) goto L5;
        return null;
    L5:
        c1 r13 = (c1) r11.valueAt(r12);
        if (r13 == null) goto L21;
        int r14 = r13.f13797a;
        if ((r14 & r10) == 0) goto L21;
        int r15 = r14 & (~r10);
        r13.f13797a = r15;
        if (r10 != 4) goto L13;
        f0 r16 = r13.f13798b;
    L16:
        if ((r15 & 12) != 0) goto L18;
        r11.removeAt(r12);
        r13.f13797a = 0;
        r13.f13798b = null;
        r13.f13799c = null;
        c1.d.release(r13);
    L18:
        return r16;
    L13:
        if (r10 != 8) goto L20;
        r16 = r13.f13799c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    public void t(x0 r5) {
        c1 r10 = (c1) ((SimpleArrayMap) this.f18728b).get(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.f13797a &= -2;
    }

    public void u(x0 r5) {
        LongSparseArray r10 = (LongSparseArray) this.f18729c;
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r5 == r10.valueAt(r11)) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        r10.removeAt(r11);
    L8:
        c1 r12 = (c1) ((SimpleArrayMap) this.f18728b).remove(r5);
        if (r12 == null) goto L14;
        r12.f13797a = 0;
        r12.f13798b = null;
        r12.f13799c = null;
        c1.d.release(r12);
        return;
    }

    public File v(InputStream r5, FileExtension r10) {
        String r11 = q((String) this.f18729c, r10, true);
        File r12 = new File(((Context) this.f18728b).getCacheDir(), r11);
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: Throwable -> L15
        byte[] r14 = new byte[1024];     // Catch: Throwable -> L9
    L6:
        int r15 = r5.read(r14);     // Catch: Throwable -> L9
        if (r15 == (-1)) goto L11;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L9
        goto L6
    L11:
        r13.flush();     // Catch: Throwable -> L9
        r13.close();     // Catch: Throwable -> L15
        r5.close();
        return r12;
    L9:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r5.close();
        throw th;
    }

    public /* synthetic */ r(int r5, boolean r10) {
        this.f18727a = r5;
    }

    public r(int r5) {
        this.f18727a = r5;
        switch(r5) {
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 16: goto L6;
            default: goto L4;
        };
    L4:
        this.f18729c = new ConcurrentHashMap();
        return;
    L6:
        this.f18729c = new ConcurrentHashMap();
        this.f18728b = new ConcurrentHashMap();
        return;
    L8:
        this.f18728b = new SimpleArrayMap();
        this.f18729c = new LongSparseArray();
        return;
    L10:
        this.f18728b = new HashMap(10);
        this.f18729c = new PriorityQueue(10, com.bytedance.pia.nsr.k.f7200a);
        return;
    L12:
        this.f18728b = "";
        this.f18729c = new Handler(Looper.getMainLooper());
    }

    @Override // o1.f
    public void a(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        AIBridgeMethod$Error r11 = new AIBridgeMethod$Error(r10);
        ((Consumer) this.f18729c).accept(r11);
    }

    public r(ck.a r5) {
        this.f18727a = 7;
        this.f18729c = new ByteArrayOutputStream();
        this.f18728b = new BufferedInputStream(r5, 1024);
    }

    public r(JSONObject r5) {
        this.f18727a = 12;
        Intrinsics.checkNotNullParameter(r5, "data");
        this.f18728b = r5;
        this.f18729c = new HashMap();
    }

    public r(Context r5, String r10) {
        this.f18727a = 15;
        this.f18728b = r5.getApplicationContext();
        this.f18729c = r10;
    }
}
