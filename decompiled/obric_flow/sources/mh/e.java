package mh;

import ai.j0;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.lego.init.k;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import okhttp3.h0;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static boolean d = false;
    public static boolean e = false;
    public static xg.b f = null;
    public static a7.c g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f20096h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static we.a f20097i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f20099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HtmlPlugin f20100c;

    public /* synthetic */ e(HtmlPlugin r5, AtomicInteger r10, int r11) {
        this.f20098a = r11;
        this.f20100c = r5;
        this.f20099b = r10;
    }

    public static int a(int r5) {
        if (r5 < 1000) goto L8;
        if (r5 >= 1100) goto L8;
        return 30103;
    L8:
        if (r5 < 1100) goto L11;
        if (r5 >= 1200) goto L11;
        return 30196;
    L11:
        if (r5 >= 1200) goto L13;
    L16:
        return 30196;
    L13:
        if (r5 >= 1300) goto L16;
        return 30102;
    }

    public static int b(Throwable r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        if ((r5 instanceof ConnectTimeoutException) == false) goto L9;
        return 1101;
    L9:
        if ((r5 instanceof SocketTimeoutException) == false) goto L13;
        return 1102;
    L13:
        if ((r5 instanceof ConnectException) == false) goto L17;
        return 1103;
    L17:
        if ((r5 instanceof BindException) == false) goto L21;
        return 1104;
    L21:
        if ((r5 instanceof NoRouteToHostException) == false) goto L25;
        return 1105;
    L25:
        if ((r5 instanceof PortUnreachableException) == false) goto L29;
        return 1106;
    L29:
        if ((r5 instanceof UnknownHostException) == false) goto L33;
        return 1107;
    L33:
        if ((r5 instanceof SocketException) == false) goto L37;
        return 1108;
    L37:
        if ((r5 instanceof IllegalArgumentException) == false) goto L41;
        return LynxErrorCode.LYNX_ERROR_MAIN_FLOW;
    L41:
        if ((r5 instanceof IllegalStateException) == false) goto L45;
        return 1202;
    L45:
        if ((r5 instanceof RuntimeException) == false) goto L49;
        return 1203;
    L49:
        if ((r5 instanceof InterruptedException) == false) goto L53;
        return 1204;
    L53:
        if ((r5 instanceof FileNotFoundException) == false) goto L57;
        return 1205;
    L57:
        if ((r5 instanceof IOException) == false) goto L75;
        String r10 = r5.getMessage();
        if (r10 != null) goto L61;
        return 1206;
    L61:
        if (r10.length() != 0) goto L63;
        return 1206;
    L63:
        if (r10.contains("canceled") == false) goto L65;
        return 1001;
    L65:
        if (r10.contains("Canceled") == false) goto L68;
        return 1001;
    L68:
        if (r10.contains("network not available") == false) goto L79;
        return PointerIconCompat.TYPE_HAND;
    L79:
        return 1206;
    L75:
        return -1;
    }

    public static int c(JSONObject r5, int r10, String... r11) {
        JSONObject r12 = q(r5, r11);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return r12.optInt(r11[r11.length - 1], r10);
    }

    public static String d(Uri r11, rc.f r12) {
        if (r12 == null) goto L5;
        String r5 = r12.getBid();
    L6:
        if (r11 != null) goto L8;
    L63:
        return null;
    L8:
        if (r11.isHierarchical() == false) goto L10;
        Uri r10 = r11;
    L11:
        if (r10 == null) goto L63;
        String r13 = r10.getQueryParameter("groupId");
        if (r13 == null) goto L63;
        String r14 = r11.getQueryParameter("cardId");
        String r15 = r11.getQueryParameter("gecko_format");
        wc.g r16 = new wc.g("");
        if (r12 == null) goto L17;
        Map r17 = r12.getAllDependency();
    L18:
        r16.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r17);
        String r18 = r11.getQueryParameter("accessKey");
        if (r18 == null) goto L21;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.f22836a = r18;
    L21:
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r16.f22840i = "sub_resource";
        if (r12 == null) goto L24;
        wc.a r19 = (wc.a) r12.b(wc.a.class);
    L25:
        wc.a r110 = cl.a.i(r19);
        if (r110 != null) goto L28;
        r110 = new wc.a(true);
    L28:
        List r20 = CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.f5993a, LoaderType.f5994b});
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r110.f22822b = r20;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r16.f22837b = r110;
        we.a r111 = f20097i;
        if (r111 == null) goto L37;
        if (r14 == null) goto L37;
        Intrinsics.checkNotNull(r111);
        p000if.a r112 = (p000if.a) ((HashMap) r111.f22857a).get(r14);
        if (r112 == null) goto L37;
        String r113 = e(r112, r11.toString(), r13.concat("_resource"), r15, r16);
        if (r113 == null) goto L37;
        return Uri.fromFile(new File(r113)).toString();
    L37:
        com.bytedance.ies.bullet.kit.resourceloader.h r114 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r5);
        String r21 = new Uri.Builder().scheme("local_file").authority("relative").path(r13).build().toString();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r16.f = r13;
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r16.f22840i = "sub_resource";
        Unit r22 = Unit.INSTANCE;
        a0 r115 = r114.c(r21, r16);
        if (r115 == null) goto L63;
        StringBuilder r23 = new StringBuilder();
        r23.append(r115.f5933b);
        File r24 = new File(j0.q(r23, File.separator, "config.json"));
        if (r24.exists() == true) goto L43;
        r24 = null;
    L43:
        if (r24 == null) goto L63;
        FileInputStream r116 = new FileInputStream(r24);
        we.a r25 = com.bytedance.apm.util.a.e(r116);     // Catch: Throwable -> L56
        if (r25 == null) goto L58;
        f20097i = r25;     // Catch: Throwable -> L56
        if (r14 == null) goto L58;
        p000if.a r26 = (p000if.a) ((HashMap) r25.f22857a).get(r14);     // Catch: Throwable -> L56
        if (r26 == null) goto L58;
        String r117 = e(r26, r11.toString(), r13.concat("_resource"), r15, r16);     // Catch: Throwable -> L56
        if (r117 == null) goto L58;
        String r118 = Uri.fromFile(new File(r117)).toString();     // Catch: Throwable -> L56
        CloseableKt.closeFinally(r116, null);
        return r118;
    L58:
        CloseableKt.closeFinally(r116, null);
    L56:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);
        throw th;
    L24:
        r19 = null;
        goto L25
    L17:
        r17 = null;
        goto L18
    L10:
        r10 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }

    public static String e(p000if.a r5, String r10, String r11, String r12, wc.g r13) {
        Iterator r14 = r5.f17570a.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r15 = r14.next();
        if (StringsKt.P(r10, (String) r15) == false) goto L4;
    L9:
        String r16 = (String) r15;
        if (r16 == null) goto L16;
        int r17 = r16.length();
        if (r10 == null) goto L15;
        String r18 = StringsKt.W(r10.substring(r17), '?');
    L17:
        if (r18 == null) goto L32;
        if (r12 != null) goto L20;
    L23:
        ConcurrentHashMap r19 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        com.bytedance.ies.bullet.kit.resourceloader.h r20 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r13.f22838c);
        String r21 = new Uri.Builder().scheme("local_file").authority("relative").path(r11).build().toString();
        Intrinsics.checkNotNullParameter("sub_resource", "<set-?>");
        r13.f22840i = "sub_resource";
        Unit r22 = Unit.INSTANCE;
        a0 r23 = r20.c(r21, r13);
        if (r23 == null) goto L32;
        StringBuilder r24 = new StringBuilder();
        r24.append(r23.f5933b);
        File r25 = new File(j0.q(r24, File.separator, r18));
        if (r25.exists() == true) goto L29;
        r25 = null;
    L29:
        if (r25 == null) goto L32;
        return r25.getAbsolutePath();
    L20:
        if (r12.length() == 0) goto L23;
        r18 = StringsKt.G(r18, r12);
    L32:
        return null;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        r18 = null;
        goto L17
    L8:
        r15 = null;
        goto L9
    }

    public static JSONArray f(JSONObject r5, String... r10) {
        JSONObject r11 = q(r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.optJSONArray(r10[r10.length - 1]);
    }

    public static JSONObject g(Object r5, String r10, JSONObject r11) {
        if (r11 == null) goto L8;
        if (r5 == null) goto L8;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        r11.put(r10, r5);     // Catch: JSONException -> L9
    L8:
        return r11;
    }

    public static void j(JSONObject r5, JSONObject r10) {
        Iterator<String> r11 = r10.keys();
    L11:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next();     // Catch: Throwable -> L10
        if (r5.has(r12) == true) goto L11;
        r5.put(r12, r10.opt(r12));     // Catch: Throwable -> L10
    L18:
        return;
    }

    public static void k(JSONObject r5, Object... r10) {
        if (r5 != null) goto L4;
    L13:
        io.reactivex.exceptions.a.e("JSONUtils", "Err use of addKVs!!!!!");
        return;
    L4:
        if ((r10.length % 2) != 0) goto L13;
        if (r10.length == 0) goto L13;
        int r11 = 0;
    L10:
        if (r11 >= r10.length) goto L12;
        String r12 = String.valueOf(r10[r11]);
        g(r10[r11 + 1], r12, r5);
        r11 = r11 + 2;
        goto L10
    }

    public static boolean l(h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (Intrinsics.areEqual(r5.f20658b, MessageIndication.CONTENT_TYPE_TEXT) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r5.f20658b, "application") == true) goto L7;
        return false;
    L7:
        if (ArraysKt.contains(new String[]{"html", "xml"}, r5.f20659c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean m(JSONArray r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean n(JSONObject r5) {
        if (r5 != null) goto L4;
        return true;
    L4:
        if (r5.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static JSONArray p(JSONArray r5) {
        if (r5.length() > 384) goto L5;
        return r5;
    L5:
        JSONArray r10 = new JSONArray();
        int r11 = 0;
    L6:
        int r12 = 256;
        if (r11 >= 256) goto L9;
        r10.put(r5.opt(r11));
        r11 = r11 + 1;
        goto L6
    L9:
        r10.put("... skip " + (r5.length() - 384) + " lines");
    L10:
        if (r12 >= 384) goto L12;
        r10.put(r5.opt(r5.length() - (384 - r12)));
        r12 = r12 + 1;
        goto L10
    L12:
        return r10;
    }

    public static JSONObject q(JSONObject r5, String... r10) {
        if (r5 != null) goto L6;
        io.reactivex.exceptions.a.d("err get JsonFromParent: null json", new RuntimeException());
        return null;
    L6:
        int r11 = 0;
    L8:
        if (r11 >= (r10.length - 1)) goto L14;
        r5 = r5.optJSONObject(r10[r11]);
        if (r5 == null) goto L11;
        r11 = r11 + 1;
        goto L8
    L11:
        io.reactivex.exceptions.a.d("JSONUtil", "err get json: not found node:" + r10[r11]);
        return null;
    L14:
        return r5;
    }

    public static final com.squareup.kotlinpoet.c r(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isPrimitive() == true) goto L22;
        if (Intrinsics.areEqual(Void.TYPE, r5) == true) goto L20;
        if (r5.isArray() == true) goto L18;
        ArrayList r10 = new ArrayList();
    L9:
        r10.add(r5.getSimpleName());
        Class<?> r11 = r5.getEnclosingClass();
        if (r11 == null) goto L11;
        r5 = r11;
        goto L9
    L11:
        int r12 = StringsKt.t(r5.getName(), '.', 0, 6);
        if (r12 == (-1)) goto L14;
        r10.add(r5.getName().substring(0, r12));
    L14:
        CollectionsKt.reverse(r10);
        return new com.squareup.kotlinpoet.c(r10);
    L18:
        throw new IllegalArgumentException("array types cannot be represented as a ClassName");
    L20:
        throw new IllegalArgumentException("'void' type cannot be represented as a ClassName");
    L22:
        throw new IllegalArgumentException("primitive types cannot be represented as a ClassName");
    }

    public static final com.squareup.kotlinpoet.c s(KClass r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r5 = r10.getQualifiedName();
        if (r5 == null) goto L34;
        Intrinsics.checkNotNullParameter(r5, "classNameString");
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L6:
        if (r12 >= r5.length()) goto L14;
        if (Character.isLowerCase(r5.codePointAt(r12)) == false) goto L14;
        r12 = StringsKt.q(r5, '.', r12, 4) + 1;
        if (r12 != 0) goto L6;
        throw new IllegalArgumentException("couldn't make a guess for ".concat(r5).toString());
    L14:
        if (r12 == 0) goto L16;
        String r13 = r5.substring(0, r12 - 1);
    L17:
        r11.add(r13);
        Iterator r14 = StringsKt.J(r5.substring(r12), new char[]{'.'}, 0, 6).iterator();
    L19:
        if (r14.hasNext() == false) goto L28;
        String r15 = (String) r14.next();
        if (r15.length() <= 0) goto L26;
        if (Character.isUpperCase(r15.codePointAt(0)) == false) goto L26;
        r11.add(r15);
    L26:
        throw new IllegalArgumentException("couldn't make a guess for ".concat(r5).toString());
    L28:
        if (r11.size() < 2) goto L32;
        return new com.squareup.kotlinpoet.c(r11);
    L32:
        throw new IllegalArgumentException("couldn't make a guess for ".concat(r5).toString());
    L16:
        r13 = "";
        goto L17
    L34:
        throw new IllegalArgumentException(r10 + " cannot be represented as a ClassName");
    }

    public static final void t(Function0 r5) {
        k.f6741c.getClass();
        KProperty r10 = k.f6739a[0];
        ((ThreadPoolExecutor) k.f6740b.getValue()).execute(new com.bytedance.lego.init.a(r5, 2));
    }

    public static synchronized void u() {
        monitor-enter(e.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (d == true) goto L9;
        monitor-exit(e.class);
        return;
    L9:
        d = false;     // Catch: Throwable -> L15
        xg.b r5 = f;     // Catch: Throwable -> L15
        EvilMethodSwitcher.isLimitEvilMethodDepth();     // Catch: Throwable -> L15
        r5.getClass();     // Catch: Throwable -> L15
        long r10 = EvilMethodSwitcher.getEvilThresholdMs();     // Catch: Throwable -> L15
        if (r10 >= 70) goto L12;
        r10 = 1000;
    L12:
        xg.b.f23140i = r10;     // Catch: Throwable -> L15
        com.bytedance.apm.block.b.f3854c = true;     // Catch: Throwable -> L15
        com.bytedance.apm.block.b.f3852a.remove("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L15
        monitor-exit(e.class);
    }

    public static void v(String r5, String r10, Object... r11) {
        if (r11.length == 0) goto L6;
        r10 = String.format(r10, r11);
    L6:
        Log.w(r5, r10);
    }

    public final void h(int r5, boolean r10) {
        switch(this.f20098a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        int r11 = this.f20099b.get();
        if (r5 >= r11) goto L12;
        this.f20100c.f20236b.f20239j.b(0, "html_stream_truncate", com.lynx.tasm.base.h.b(r5, r11, "from=copy,length=", ",origin="));
        return;
    L12:
        return;
    L8:
        this.f20099b.compareAndSet(0, r5);
        if (r10 == true) goto L13;
        this.f20100c.f20236b.f20239j.b(0, "html_stream_truncate", "from=origin,length=" + r5);
        return;
    }

    public void i(Throwable r5) {
        switch(this.f20098a) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        this.f20100c.f20236b.f20239j.b(0, "html_stream_exception", Log.getStackTraceString(r5));
    }

    public final void o(Throwable r5) {
    }
}
