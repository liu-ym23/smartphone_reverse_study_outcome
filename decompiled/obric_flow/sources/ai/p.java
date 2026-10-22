package ai;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.ServiceProvider;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.google.gson.JsonObject;
import com.ivy.ivykit.plugin.impl.bullet.IBulletNetworkApi;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter$ExecutionPriority;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.x0;
import kotlinx.serialization.internal.y0;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.bumptech.glide.load.resource.bitmap.k, qg.a, pt.b, mt.j, y0, dh.e, ta.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f288c;

    public /* synthetic */ p(int r5, Object r10, Object r11) {
        this.f286a = r5;
        this.f287b = r10;
        this.f288c = r11;
    }

    public static p d(String r5, String r10) {
        int r11 = 7;
        return new p(r11, r10, r5.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Object g(Class r5) {
        p r10 = zg.a.f23437a;
        Object r11 = r10.f288c;
        if (r11 == null) goto L11;
        Method r12 = (Method) r10.f287b;
        if (r12 == null) goto L11;
        return r12.invoke(r11, new Object[]{r5});
    L9:
        th = move-exception;
        Log.e("PiaCoreApi", "Get api failed:", th);
    L11:
        return null;
    }

    @Override // ta.b
    public ta.c a(String r10, String r11) {
        Pattern r5 = okhttp3.h0.e;
        okhttp3.q0 r12 = okhttp3.q0.create(okhttp3.z.j("application/json; charset=utf-8"), r11);
        okhttp3.n0 r13 = new okhttp3.n0();
        r13.g(r10);
        Intrinsics.checkNotNullParameter(r12, "body");
        r13.d("POST", r12);
        Request r14 = r13.b();
        okhttp3.s0 r15 = ((OkHttpClient) this.f287b).a(r14).execute();
        okhttp3.c0 r16 = r15.g;
        HashMap r17 = new HashMap();
        r16.getClass();
        TreeSet r18 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r19 = r16.size();
        int r20 = 0;
    L3:
        if (r20 >= r19) goto L5;
        r18.add(r16.c(r20));
        r20 = r20 + 1;
        goto L3
    L5:
        Iterator r21 = Collections.unmodifiableSet(r18).iterator();
    L7:
        if (r21.hasNext() == false) goto L9;
        String r22 = (String) r21.next();
        r17.put(r22, r16.b(r22));
        goto L7
    L9:
        int r23 = r15.e;
        if (r23 != 200) goto L12;
        String r24 = r15.f20748h.string();
    L14:
        return new ta.c(r17, r24, r23, r15.d);
    L12:
        r24 = null;
        goto L14
    }

    @Override // pt.b
    public void accept(Object r5, Object r10) {
        ((Map) r5).put(((pt.o) this.f288c).apply(r10), ((pt.o) this.f287b).apply(r10));
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // kotlinx.serialization.internal.y0
    public Object b(KClass r10, ArrayList r11) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r11, "types");
        ConcurrentHashMap r5 = (ConcurrentHashMap) this.f288c;
        Class r12 = JvmClassMappingKt.getJavaClass(r10);
        Object r13 = r5.get(r12);
        if (r13 != null) goto L8;
        r13 = new x0();
        Object r14 = r5.putIfAbsent(r12, r13);
        if (r14 == null) goto L8;
        r13 = r14;
    L8:
        x0 r15 = (x0) r13;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r11));
        Iterator r17 = r11.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        r16.add(new kotlinx.serialization.internal.j0((KType) r17.next()));
        goto L10
    L12:
        ConcurrentHashMap r18 = r15.f19369a;
        Object r19 = r18.get(r16);
        if (r19 != null) goto L23;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L16
        Object r21 = Result.m124constructorimpl((kotlinx.serialization.c) ((Lambda) this.f287b).mo2invoke(r10, r11));     // Catch: Throwable -> L16
    L18:
        Result r22 = Result.m123boximpl(r21);
        Object r23 = r18.putIfAbsent(r16, r22);
        if (r23 != null) goto L21;
        r19 = r22;
        goto L23
    L21:
        r19 = r23;
    L16:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r21 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L23:
        return ((Result) r19).m133unboximpl();
    }

    @Override // ta.b
    public void c(String r10, na.b r11) {
        int r5 = 0;
        okhttp3.n0 r12 = new okhttp3.n0();     // Catch: Throwable -> L19 Exception -> L25
        r12.d("GET", null);     // Catch: Throwable -> L19 Exception -> L25
        r12.g(r10);     // Catch: Throwable -> L19 Exception -> L25
        okhttp3.s0 r13 = ((OkHttpClient) this.f288c).a(r12.b()).execute();     // Catch: Throwable -> L19 Exception -> L25
        int r14 = r13.e;     // Catch: Throwable -> L19 Exception -> L25
        if (r14 != 200) goto L24;
        BufferedInputStream r15 = new BufferedInputStream(r13.f20748h.byteStream());     // Catch: Throwable -> L19 Exception -> L21
        byte[] r16 = new byte[2048];     // Catch: Throwable -> L13 Exception -> L15
    L9:
        int r17 = r15.read(r16, 0, 2048);     // Catch: Throwable -> L13 Exception -> L15
        if (r17 == (-1)) goto L17;
        r11.d.write(r16, 0, r17);     // Catch: Throwable -> L13 Exception -> L15
        r11.b(r17);     // Catch: Throwable -> L13 Exception -> L15
    L17:
        com.bytedance.geckox.utils.d.c(r15);
        return;
    L15:
        e = e;
    L28:
        throw new RuntimeException("downloadFile failed, code: " + r14 + ", caused by:" + e.getMessage(), e);     // Catch: Throwable -> L19
    L13:
        th = th;
    L30:
        com.bytedance.geckox.utils.d.c(r15);
        throw th;
    L24:
        throw new RuntimeException("response code error: " + r14);     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = e;
        r5 = r14;
    L26:
        r14 = r5;
    L19:
        th = th;
        r15 = null;
    L25:
        e = e;
        goto L26
    }

    @Override // com.bumptech.glide.load.resource.bitmap.k
    public void e() {
        com.bumptech.glide.load.resource.bitmap.s r5 = (com.bumptech.glide.load.resource.bitmap.s) this.f287b;
        monitor-enter(r5);
        r5.f1633c = r5.f1631a.length;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BidInfo$BidConfig f(String r10) {
        HashMap r5 = (HashMap) this.f287b;
        if (r5.containsKey(r10) == false) goto L7;
        return (BidInfo$BidConfig) r5.get(r10);
    L7:
        if (r5.containsKey("__hybrid_default") == false) goto L10;
        d5.b.f("BidInfo", "Not found bidConfig for " + r10 + ", use __hybrid_default");
        return (BidInfo$BidConfig) r5.get("__hybrid_default");
    L10:
        d5.b.f("BidInfo", "Not found bidConfig for " + r10 + ", use __hybrid_default");
        return new BidInfo$BidConfig("__hybrid_default");
    }

    @Override // dh.e
    public Map getRequestHeaders() {
        return (HashMap) this.f287b;
    }

    @Override // dh.e
    public Uri getUrl() {
        return ((HtmlPlugin) this.f288c).f20236b.g;
    }

    public void h(JsonObject r10) {
        JsonObject r5 = (JsonObject) this.f288c;
        monitor-enter(r5);
        ((JsonObject) this.f288c).add("manifest", com.bytedance.pia.core.utils.i.a().toJsonTree(r10));     // Catch: Throwable -> L6
        fn.c r11 = qh.a.f21514a;     // Catch: Throwable -> L6
        String r12 = (String) this.f287b;     // Catch: Throwable -> L6
        String r13 = ((JsonObject) this.f288c).toString();     // Catch: Throwable -> L6
        ((Keva) r11.f16949c).storeLong(r12, System.currentTimeMillis());     // Catch: Throwable -> L6
        ((Keva) r11.f16948b).storeString(r12, r13);     // Catch: Throwable -> L6
        r11.d();     // Catch: Throwable -> L6
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L6:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[PageStorage]Put page info error: ", "message");     // Catch: Throwable -> L10
        com.bytedance.pia.core.utils.j.x("[PageStorage]Put page info error: ", th);     // Catch: Throwable -> L10
        goto L8
    }

    public void i(hm.a r5) {
        hm.b r10 = new hm.b(r5, UIAnimaXPropsPrioritySetter$ExecutionPriority.f9695c);
        ((PriorityQueue) this.f287b).add(r10);
    }

    public void j(hm.a r5, UIAnimaXPropsPrioritySetter$ExecutionPriority r10) {
        hm.b r11 = new hm.b(r5, r10);
        ((PriorityQueue) this.f287b).add(r11);
    }

    public void k(String r18, Map r19, ug.d r20) {
        Intrinsics.checkNotNullParameter(r18, "actionName");
        Intrinsics.checkNotNullParameter(r19, "realArguments");
        Intrinsics.checkNotNullParameter(r20, "airSolutionContext");
        if (r18.length() != 0) goto L6;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_ActionDispatcher", "jsb action failed, reason: action name is empty", null, 12);
        return;
    L6:
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AirSolution_ActionDispatcher", "handleLifecycle: annieXLynxView: " + ((AnnieXLynxView) this.f287b) + ", actionName: " + r18 + ", realArguments: " + r19, null, 12);
        Map r10 = (Map) r20.f22357b;
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r12 = (com.bytedance.sdk.xbridge.cn.platform.lynx.a) this.f288c;
        String r11 = "";
        if (r10 != null) goto L9;
    L31:
        Map r13 = (Map) r20.f22358c;
        if (r13 != null) goto L34;
    L41:
        JavaOnlyMap r14 = new JavaOnlyMap(r19);
        LynxView r15 = (LynxView) ((View) r12.t().e.get());
        if (r15 == null) goto L47;
        String r16 = r15.getTemplateUrl();
        if (r16 == null) goto L47;
        r11 = r16;
    L47:
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r17 = new com.bytedance.sdk.xbridge.cn.platform.lynx.b(r18, r11, r14);
        r12.m(r17, new j4.a(r17, new ug.d(r20, null, r18, this, r19, r18, 8), this));
        return;
    L34:
        if (r13.containsKey(r18) != true) goto L41;
        Map r21 = (Map) r20.f22358c;
        if (r21 == null) goto L52;
        l4.b r22 = (l4.b) r21.get(r18);
        if (r22 == null) goto L53;
        l(r19, r22, r20);
        return;
    L53:
        return;
    L52:
        return;
    L9:
        if (r10.containsKey(r18) != true) goto L31;
        Map r23 = (Map) r20.f22357b;
        if (r23 == null) goto L49;
        l4.c r110 = (l4.c) r23.get(r18);
        if (r110 == null) goto L50;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AirSolution_ActionDispatcher", "handleJSBAction, actionName:" + r18 + ", jsb:" + r110, null, 12);
        String r24 = r110.b();
        if (r24 == null) goto L27;
        com.lynx.tasm.behavior.ui.utils.n r25 = (com.lynx.tasm.behavior.ui.utils.n) r20.e;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r110, "jsb");
        LinkedHashMap r26 = new LinkedHashMap();
        Map r27 = r110.c();
        if (r27 == null) goto L19;
        JavaOnlyMap r28 = r25.m(r27, r19);
    L20:
        l4.b r29 = r110.a();
        LynxView r30 = (LynxView) ((View) r12.t().e.get());
        if (r30 == null) goto L26;
        String r31 = r30.getTemplateUrl();
        if (r31 == null) goto L26;
        r11 = r31;
    L26:
        com.bytedance.sdk.xbridge.cn.platform.lynx.b r111 = new com.bytedance.sdk.xbridge.cn.platform.lynx.b(r24, r11, r28);
        r12.m(r111, new j4.a(r111, new ug.d(r20, r29, r18, this, r19, r24, 8), this));
        Unit r32 = Unit.INSTANCE;
    L28:
        if (r32 != null) goto L51;
        com.bytedance.ies.bullet.base.utils.logger.a.d("AirSolution_ActionDispatcher", "invalid jsb: " + r110, null, 12);
        return;
    L51:
        return;
    L19:
        r28 = com.lynx.tasm.behavior.v0.f(0, r26);
        goto L20
    L27:
        r32 = null;
        goto L28
    L50:
        return;
    }

    public void l(Map r10, l4.b r11, ug.d r12) {
        Intrinsics.checkNotNullParameter(r11, "highExec");
        Intrinsics.checkNotNullParameter(r12, "airSolutionContext");
        com.lynx.tasm.behavior.x0 r13 = (com.lynx.tasm.behavior.x0) r12.f;
        r13.getClass();
        Intrinsics.checkNotNullParameter(this, "actionDispatcher");
        Intrinsics.checkNotNullParameter(r11, "highExec");
        List r5 = r11.b();
        ug.d r14 = (ug.d) r13.f10812a;
        if (r5 == null) goto L8;
        Iterator r15 = r5.iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        l4.d r16 = (l4.d) r15.next();
        ((zm.z) r14.g).c(this, r16, r10);
    L8:
        l4.a r17 = r11.c();
        if (r17 == null) goto L47;
        zm.z r18 = (zm.z) r14.g;
        List r19 = r17.a();
        r18.getClass();
        boolean r20 = false;
        if (r19 == null) goto L30;
        l4.d r21 = (l4.d) r19.get(0);
        if (Intrinsics.areEqual("op", r21.a()) == false) goto L30;
        com.lynx.tasm.behavior.ui.utils.n r22 = (com.lynx.tasm.behavior.ui.utils.n) ((ug.d) r18.f23549a).e;
        LinkedHashMap r23 = new LinkedHashMap();
        String r24 = r21.a();
        if (r24 == null) goto L18;
        r23.put("$t", r24);
    L18:
        String r25 = r21.b();
        if (r25 == null) goto L21;
        r23.put("n", r25);
    L21:
        Object r26 = r21.c();
        if (r26 == null) goto L24;
        r23.put(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, r26);
    L24:
        Object r27 = r22.o(new JSONObject(r23).toString(), r10);
        if ((r27 instanceof Boolean) == false) goto L27;
        Boolean r28 = (Boolean) r27;
    L28:
        if (r28 == null) goto L30;
        r20 = r28.booleanValue();
        goto L30
    L27:
        r28 = null;
    L30:
        if (r20 == false) goto L39;
        l4.a r29 = r11.d();
        if (r29 == null) goto L51;
        List r30 = r29.a();
        if (r30 == null) goto L52;
        Iterator r31 = r30.iterator();
    L37:
        if (r31.hasNext() == false) goto L55;
        l4.d r32 = (l4.d) r31.next();
        ((zm.z) r14.g).c(this, r32, r10);
        goto L37
    L55:
        return;
    L52:
        return;
    L51:
        return;
    L39:
        l4.a r33 = r11.a();
        if (r33 == null) goto L53;
        List r34 = r33.a();
        if (r34 == null) goto L54;
        Iterator r35 = r34.iterator();
    L45:
        if (r35.hasNext() == false) goto L56;
        l4.d r36 = (l4.d) r35.next();
        ((zm.z) r14.g).c(this, r36, r10);
        goto L45
    L56:
        return;
    L54:
        return;
    L53:
        return;
    }

    public void m(String r10) {
        monitor-enter(this);
        Object r5 = ((HashMap) this.f287b).get(r10);     // Catch: Throwable -> L22
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");     // Catch: Throwable -> L22
        b0.b r11 = (b0.b) r5;     // Catch: Throwable -> L22
        int r12 = r11.f806b;     // Catch: Throwable -> L22
        if (r12 < 1) goto L28;
        int r13 = r12 - 1;     // Catch: Throwable -> L22
        r11.f806b = r13;     // Catch: Throwable -> L22
        if (r13 != 0) goto L24;
        b0.b r14 = (b0.b) ((HashMap) this.f287b).remove(r10);     // Catch: Throwable -> L22
        if (r14.equals(r11) == false) goto L21;
        r6.a r15 = (r6.a) this.f288c;     // Catch: Throwable -> L22
        ArrayDeque r16 = (ArrayDeque) r15.f21695a;     // Catch: Throwable -> L22
        monitor-enter(r16);     // Catch: Throwable -> L22
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L13:
        if (((ArrayDeque) r15.f21695a).size() >= 10) goto L15;
        ((ArrayDeque) r15.f21695a).offer(r14);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r16);     // Catch: Throwable -> L17
    L21:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r11 + ", but actually removed: " + r14 + ", safeKey: " + r10);     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);     // Catch: Throwable -> L22
        r11.f805a.unlock();
        return;
    L28:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r10 + ", interestedThreads: " + r11.f806b);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // mt.j
    public void onComplete() {
        ((mt.j) this.f287b).onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        ((mt.j) this.f287b).onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce((AtomicReference) this.f288c, r5);
    }

    @Override // mt.j
    public void onSuccess(Object r5) {
        ((mt.j) this.f287b).onSuccess(r5);
    }

    public String toString() {
        switch(this.f286a) {
            case 0: goto L10;
            case 1: goto L9;
            case 15: goto L7;
            default: goto L5;
        };
    L10:
        Method r5 = (Method) this.f287b;
        return String.format("%s.%s() %s", new Object[]{r5.getDeclaringClass().getName(), r5.getName(), (List) this.f288c});
    L5:
        return super.toString();
    L7:
        return ((JsonObject) this.f288c).toString();
    L9:
        return "BidInfo{bidInfoMap=" + ((HashMap) this.f287b) + ", regexList=" + ((ArrayList) this.f288c) + '}';
    }

    public p(int r5) {
        this.f286a = r5;
        switch(r5) {
            case 2: goto L20;
            case 4: goto L19;
            case 9: goto L16;
            case 16: goto L14;
            case 17: goto L12;
            case 18: goto L6;
            default: goto L4;
        };
    L4:
        this.f287b = new HashMap();
        this.f288c = new ArrayList();
        return;
    L6:
        this.f288c = null;
        this.f287b = null;
        this.f288c = ServiceProvider.class.newInstance();     // Catch: Throwable -> L9
        this.f287b = ServiceProvider.class.getMethod("get", new Class[]{Class.class});     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Log.e("PiaCoreApi", "Initialize Pia-Core API failed:", th);
        return;
    L12:
        this.f287b = new AtomicBoolean(false);
        this.f288c = new Object();
        return;
    L14:
        okhttp3.l0 r10 = new okhttp3.l0();
        TimeUnit r11 = TimeUnit.SECONDS;
        r10.a(10, r11);
        r10.c(10, r11);
        r10.d(10, r11);
        this.f287b = new OkHttpClient(r10);
        okhttp3.l0 r12 = new okhttp3.l0();
        r12.a(10, r11);
        r12.c(30, r11);
        r12.d(30, r11);
        this.f288c = new OkHttpClient(r12);
        return;
    L16:
        this.f287b = new PriorityQueue();
        return;
    L20:
        this.f287b = new HashMap();
        this.f288c = new r6.a(1, false);
        return;
    }

    @Override // qg.a
    public qg.b a() {
        boolean r5 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, "SettingsRequestServiceImpl:startRequest");
        Application r10 = com.bytedance.ies.bullet.core.h.g.f5316b;
        StringBuilder r11 = new StringBuilder("https://is.snssdk.com/service/settings/v3/");
        StringBuilder r12 = new StringBuilder("?aid=");
        c5.a r13 = (c5.a) this.f287b;
        r12.append(((xc.a) r13.f1119c).f23012a);
        r11.append(r12.toString());
        xc.a r14 = (xc.a) r13.f1119c;
        r11.append("&app_version=".concat(r14.f23013b));
        r11.append("&iid=".concat(r14.f23014c));
        r11.append("&device_id=".concat(r14.d));
        r11.append("&channel=&device_platform=android&version_code=9.0.0&caller_name=Bullet");
        r11.append("&ctx_infos=" + ((String) this.f288c));
        if (r10 != null) goto L60;
    L8:
        r11.append("&os_version=" + Build.VERSION.SDK_INT);
        StringBuilder r15 = new StringBuilder("&device_type=");
        List r16 = nb.a.f20224a;
        r15.append(Build.MODEL);
        r11.append(r15.toString());
        Lazy r17 = com.bytedance.ies.bullet.base.storage.a.f5225a;
        Intrinsics.checkNotNullParameter("settings_time", STGroup.DICT_KEY);
        Lazy r18 = com.bytedance.ies.bullet.base.storage.a.f5225a;
        SharedPreferences r19 = (SharedPreferences) r18.getValue();
        if (r19 == null) goto L11;
        String r20 = r19.getString("settings_time", null);
    L12:
        if (r20 != null) goto L14;
        r20 = "0";
    L14:
        r11.append("&settings_time=".concat(r20));
        boolean r21 = com.bytedance.ies.bullet.service.base.b.f5956a;
        LogLevel r110 = LogLevel.f5954b;
        com.bytedance.ies.bullet.service.base.b.c(r110, "SettingsRequestServiceImpl:startRequest:url = " + r11);
        w8.f r22 = (w8.f) r13.d;
        String r23 = r11.toString();
        LinkedHashMap r24 = new LinkedHashMap();
        r24.put("Content-Type", "application/json");
        r24.put("mimeType", "application/json");
        Unit r111 = Unit.INSTANCE;
        LinkedHashMap r112 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r23, "url");
        Intrinsics.checkNotNullParameter(r24, "headers");
        Intrinsics.checkNotNullParameter(r112, "body");
        if (((IBulletNetworkApi) r22.f22816a) != null) goto L17;
        g0 r113 = new g0(0);
        r113.g("https://is.snssdk.com/service/settings/v3/");
        r113.f210b = new com.bytedance.ai.resource.core.net.a(14);
        r113.c(aa.a.f());
        r113.g = new h.a(3);
        r22.f22816a = (IBulletNetworkApi) r113.e().b(IBulletNetworkApi.class);
    L17:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r24.entrySet().iterator();
    L19:
        if (r26.hasNext() == false) goto L21;
        Map.Entry r114 = (Map.Entry) r26.next();
        r25.add(new bi.c((String) r114.getKey(), (String) r114.getValue()));
        goto L19
    L21:
        r25.add(new bi.c("X-Tt-Request-Tag", "t=0"));
        IBulletNetworkApi r27 = (IBulletNetworkApi) r22.f22816a;     // Catch: Throwable -> L30
        if (r27 == null) goto L32;
        c r28 = r27.doPost(r23, r112, r25);     // Catch: Throwable -> L30
        if (r28 == null) goto L32;
        q0 r29 = r28.execute();     // Catch: Throwable -> L30
        if (r29 == null) goto L32;
        com.bytedance.salamander.anniex.n r30 = new com.bytedance.salamander.anniex.n(5);     // Catch: Throwable -> L30
        r30.f7269c = (String) r29.f291b;     // Catch: Throwable -> L30
        r30.f7268b = r29.f290a.f930b;     // Catch: Throwable -> L30
    L33:
        com.bytedance.ies.bullet.service.base.b.c(r110, "SettingsRequestServiceImpl:startRequest:result = " + r30.f7269c);
        qg.b r31 = new qg.b();
        r31.f21508a = false;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L52
        if (r30.f7268b < 200) goto L54;
        String r33 = r30.f7269c;     // Catch: Throwable -> L52
        if (r33 == null) goto L54;
        JSONObject r34 = new JSONObject(r33);     // Catch: Throwable -> L52
        if (Intrinsics.areEqual(r34.optString("message"), "success") == false) goto L54;
        JSONObject r35 = r34.optJSONObject("data");     // Catch: Throwable -> L52
        if (r35 == null) goto L54;
        JSONObject r36 = r35.optJSONObject("settings");     // Catch: Throwable -> L52
        if (r36 == null) goto L54;
        r31.f21509b = new qg.c(UUID.randomUUID().toString(), r36, null);     // Catch: Throwable -> L52
        r35.optJSONObject("vid_info");     // Catch: Throwable -> L52
        String r37 = r35.optString("ctx_infos");     // Catch: Throwable -> L52
        r31.f21510c = r37;     // Catch: Throwable -> L52
        this.f288c = r37;     // Catch: Throwable -> L52
        long r38 = r35.optLong("settings_time");     // Catch: Throwable -> L52
        r31.d = r38;     // Catch: Throwable -> L52
        String r39 = String.valueOf(r38);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("settings_time", STGroup.DICT_KEY);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r39, "value");     // Catch: Throwable -> L52
        SharedPreferences r40 = (SharedPreferences) r18.getValue();     // Catch: Throwable -> L52
        if (r40 == null) goto L51;
        SharedPreferences.Editor r41 = r40.edit();     // Catch: Throwable -> L52
        if (r41 == null) goto L51;
        SharedPreferences.Editor r42 = r41.putString("settings_time", r39);     // Catch: Throwable -> L52
        if (r42 == null) goto L51;
        r42.apply();     // Catch: Throwable -> L52
    L51:
        r31.f21508a = true;     // Catch: Throwable -> L52
    L54:
        Result.m124constructorimpl(r111);     // Catch: Throwable -> L52
    L57:
        return r31;
    L52:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    L32:
        r30 = new com.bytedance.salamander.anniex.n(5);
    L30:
        th = move-exception;
        com.bytedance.ies.bullet.service.base.b.i(th, "bullet settings request");
        goto L32
    L11:
        r20 = null;
        goto L12
    L60:
        r11.append("&resolution=" + nb.a.j(r10) + '*' + nb.a.h(r10));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        int r44 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("SettingsRequestServiceImpl", "exception happens when append resolution, e=" + th.getMessage(), null, 12);
        goto L8
    }

    public p(Context r5) {
        this.f286a = 8;
        this.f288c = new ContentValues();
        this.f287b = r5.getApplicationContext();
    }

    public p(c5.a r5) {
        this.f286a = 5;
        Intrinsics.checkNotNullParameter(r5, "config");
        this.f287b = r5;
        this.f288c = "";
    }

    public p(AnnieXLynxView r5, com.bytedance.sdk.xbridge.cn.platform.lynx.a r10) {
        this.f286a = 12;
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "lynxBDXBridge");
        this.f287b = r5;
        this.f288c = r10;
    }

    public p(HtmlPlugin r5, HashMap r10) {
        this.f286a = 14;
        this.f288c = r5;
        this.f287b = r10;
    }

    public p(String r10) {
        this.f286a = 15;
        this.f287b = r10;
        fn.c r5 = qh.a.f21514a;
        Keva r11 = (Keva) r5.f16948b;
        boolean r12 = r11.contains(r10);
        Keva r13 = (Keva) r5.f16949c;
        String r14 = "";
        if (r12 == false) goto L5;
        r13.storeLong(r10, System.currentTimeMillis());
        r14 = r11.getString(r10, "");
    L16:
    L9:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[PageStorage]The info is invalid, fallback to empty: ", "message");
        com.bytedance.pia.core.utils.j.x("[PageStorage]The info is invalid, fallback to empty: ", th);
        JsonObject r15 = new JsonObject();
    L14:
        this.f288c = r15;
        return;
    L7:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        r15 = new JsonObject();     // Catch: Throwable -> L9
        goto L14
    L11:
        r15 = com.bytedance.pia.core.utils.i.f7152b.parse(r14).getAsJsonObject();     // Catch: Throwable -> L9
        goto L14
    L5:
        r13.storeLong(r10, System.currentTimeMillis());
        r11.storeString(r10, "");
        r5.d();
        goto L16
    }

    public p(Method r5, ArrayList r10) {
        this.f286a = 0;
        this.f287b = r5;
        this.f288c = Collections.unmodifiableList(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(Function2 r5) {
        this.f286a = 13;
        Intrinsics.checkNotNullParameter(r5, "compute");
        this.f287b = (Lambda) r5;
        this.f288c = new ConcurrentHashMap();
    }

    @Override // com.bumptech.glide.load.resource.bitmap.k
    public void a(Bitmap r5, com.bumptech.glide.load.engine.bitmap_recycle.a r10) {
        IOException r11 = ((q0.d) this.f288c).f21450b;
        if (r11 == null) goto L7;
        if (r5 == null) goto L8;
        r10.b(r5);
        throw r11;
    L8:
        throw r11;
    }
}
