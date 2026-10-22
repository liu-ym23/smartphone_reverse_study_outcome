package com.bytedance.android.annie.bridge.method;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.method.abs.SaveTemplateResultModel;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "saveTemplate")
public final class SaveTemplateMethod extends e7.x<e7.t0, SaveTemplateResultModel> {
    public static final List<String> u = null;
    public static final List<String> v = null;
    public final IHybridComponent a;
    public final com.bytedance.android.annie.container.fragment.q b;
    public final double c;
    public double d;
    public boolean e;
    public int f;
    public int g;
    public String h;
    public Bitmap.CompressFormat i;
    public int j;
    public HybridCard k;
    public WeakReference<Context> l;
    public volatile boolean m;
    public final SaveTemplateMethod$lifecycleObserver$1 n;
    public volatile boolean o;
    public volatile boolean p;
    public final Handler q;
    public final d r;
    public final b s;
    public final c t;

    public static final class a {
    }

    public static final class b implements JsEventSubscriber {
        public final /* synthetic */ SaveTemplateMethod a;

        public b(SaveTemplateMethod r1) {
            this.a = r1;
        }

        public final void onReceiveJsEvent(Js2NativeEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "jsEvent");
            SaveTemplateMethod r11 = this.a;
            r11.q.post(r11.t);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SaveTemplateMethod a;

        public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {
            public final /* synthetic */ Context a;
            public final /* synthetic */ String b;
            public final /* synthetic */ SaveTemplateMethod c;
            public final /* synthetic */ String d;

            @Override // com.bytedance.android.annie.bridge.method.permission.b
            public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
                Intrinsics.checkNotNullParameter(r11, "permissions");
                Intrinsics.checkNotNullParameter(r12, "grantResults");
                if (ContextCompat.checkSelfPermission(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L10;
                int r13 = com.bytedance.android.annie.util.k.a;
                Uri r0 = null;
                Pair r14 = com.bytedance.android.annie.util.k.a(this.a, this.b, true, null, null);
                if (r14 == null) goto L7;
                r0 = (Uri) r14.getFirst();
            L7:
                if (r0 == null) goto L9;
                SaveTemplateMethod r15 = this.c;
                SaveTemplateResultModel r16 = new SaveTemplateResultModel();
                String r1 = this.b;
                String r17 = this.d;
                r16.a(SaveTemplateResultModel.Code.Success);
                r16.c("Success");
                SaveTemplateResultModel.a r18 = new SaveTemplateResultModel.a();
                r18.a(r1);
                r18.b(StringsKt.replace$default(r1, r17 + '/', "", false, 4, null));
                r16.b(r18);
                List<String> r19 = SaveTemplateMethod.u;
                r15.finishWithResult(r16);
                return;
            L9:
                SaveTemplateMethod.p(this.c, "save image to gallery fail");
                return;
            L10:
                SaveTemplateMethod r20 = this.c;
                SaveTemplateResultModel.Code r21 = SaveTemplateResultModel.Code.NO_PERMISSION;
                List<String> r110 = SaveTemplateMethod.u;
                r20.o("save image to gallery fail for permission rejected", r21);
            }

            public a(Context r1, String r10, SaveTemplateMethod r11, String r12) {
                this.a = r1;
                this.b = r10;
                this.c = r11;
                this.d = r12;
            }
        }

        public c(SaveTemplateMethod r1) {
            this.a = r1;
        }

        public final void a() {
            boolean r10 = false;
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate create bitmap begin", false);     // Catch: Throwable -> L89 Exception -> L91
            HybridCard r11 = this.a.k;     // Catch: Throwable -> L89 Exception -> L91
            if (r11 == null) goto L95;
            View r12 = r11.getHybridView();     // Catch: Throwable -> L89 Exception -> L91
            if (r12 == null) goto L95;
            SaveTemplateMethod r13 = this.a;     // Catch: Throwable -> L89 Exception -> L91
            Bitmap r14 = SaveTemplateMethod.k(r13, r12, (int) r13.c, (int) r13.d);     // Catch: Throwable -> L89 Exception -> L91
            if (r14 != null) goto L13;
            SaveTemplateMethod.p(this.a, "createBitmap fail");     // Catch: Throwable -> L89 Exception -> L91
        L11:
            this.a.n();
            return;
        L13:
            WeakReference<Context> r15 = this.a.l;     // Catch: Throwable -> L89 Exception -> L91
            if (r15 == null) goto L94;
            Context r16 = r15.get();     // Catch: Throwable -> L89 Exception -> L91
            if (r16 == null) goto L94;
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate create bitmap done", false);     // Catch: Throwable -> L89 Exception -> L91
            this.a.getClass();     // Catch: Throwable -> L89 Exception -> L91
            File r17 = r16.getExternalCacheDir();     // Catch: Throwable -> L89 Exception -> L91
            if (r17 != null) goto L21;
            r17 = r16.getCacheDir();     // Catch: Throwable -> L89 Exception -> L91
        L21:
            Integer r18 = null;
            if (r17 == null) goto L24;
            String r19 = r17.getAbsolutePath();     // Catch: Throwable -> L89 Exception -> L91
        L26:
            if (r19 != null) goto L28;
        L31:
            boolean r20 = true;
        L32:
            if (r20 == false) goto L34;
            SaveTemplateMethod.p(this.a, "can't get cache dir");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L34:
            String r110 = r19 + '/' + this.a.h;     // Catch: Throwable -> L89 Exception -> L91
            PolarisFileWrapper r21 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateMethod r111 = this.a;     // Catch: Throwable -> L89 Exception -> L91
            if (com.bytedance.android.annie.util.g.b(r14, r21, r111.g, r111.i) == true) goto L37;
            SaveTemplateMethod.p(this.a, "save image to cache dir fail");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L37:
            x8.a.d("Annie_SaveTemplateMethod", "saveTemplate file done", false);     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateMethod r0 = this.a;     // Catch: Throwable -> L89 Exception -> L91
            if (r0.e == false) goto L93;
            Ref.ObjectRef r1 = new Ref.ObjectRef();     // Catch: Throwable -> L89 Exception -> L91
            IHybridComponent r22 = this.a.a;     // Catch: Throwable -> L89 Exception -> L91
            if ((r22 instanceof com.bytedance.android.annie.container.fragment.o) == false) goto L43;
            com.bytedance.android.annie.container.fragment.o r23 = (com.bytedance.android.annie.container.fragment.o) r22;     // Catch: Throwable -> L89 Exception -> L91
        L44:
            if (r23 == null) goto L58;
            c7.a r24 = r23.getAnnieContext();     // Catch: Throwable -> L89 Exception -> L91
            if (r24 == null) goto L58;
            SaveTemplateMethod r112 = this.a;     // Catch: Throwable -> L89 Exception -> L91
            WeakReference<HybridFragment> r25 = AnnieFragmentManager.b(r24.getUuid());     // Catch: Throwable -> L89 Exception -> L91
            if (r25 == null) goto L50;
            a7.b r26 = (HybridFragment) r25.get();     // Catch: Throwable -> L89 Exception -> L91
        L52:
            if ((r26 instanceof com.bytedance.android.annie.container.fragment.q) == false) goto L54;
            com.bytedance.android.annie.container.fragment.q r27 = (com.bytedance.android.annie.container.fragment.q) r26;     // Catch: Throwable -> L89 Exception -> L91
        L55:
            if (r27 != null) goto L57;
            r27 = r112.b;     // Catch: Throwable -> L89 Exception -> L91
        L57:
            r1.element = r27;     // Catch: Throwable -> L89 Exception -> L91
            goto L58
        L54:
            r27 = null;
            goto L55
        L50:
            r26 = null;
        L58:
            String r28 = ae7.c.a;     // Catch: Throwable -> L89 Exception -> L91
            if (Build.VERSION.SDK_INT < 29) goto L61;
            boolean r29 = true;
        L62:
            if (r29 == false) goto L64;
            Pair r30 = com.bytedance.android.annie.util.k.b(r16, r110, true);     // Catch: Throwable -> L89 Exception -> L91
        L65:
            if (r30 == null) goto L67;
            Uri r31 = (Uri) r30.getFirst();     // Catch: Throwable -> L89 Exception -> L91
        L68:
            if (r30 == null) goto L70;
            r18 = (Integer) r30.getSecond();     // Catch: Throwable -> L89 Exception -> L91
        L70:
            if (r31 == null) goto L72;
            boolean r32 = true;
        L73:
            if (r31 != null) goto L79;
            if (r18 == null) goto L79;
            if (r18.intValue() != (-1)) goto L79;
            boolean r33 = true;
        L81:
            if (ContextCompat.checkSelfPermission(r16, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L83;
            r10 = true;
        L83:
            if (r32 == false) goto L85;
            SaveTemplateMethod r34 = this.a;     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel r35 = new SaveTemplateResultModel();     // Catch: Throwable -> L89 Exception -> L91
            r35.a(SaveTemplateResultModel.Code.Success);     // Catch: Throwable -> L89 Exception -> L91
            r35.c("Success");     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel.a r36 = new SaveTemplateResultModel.a();     // Catch: Throwable -> L89 Exception -> L91
            r36.a(r110);     // Catch: Throwable -> L89 Exception -> L91
            r36.b(StringsKt.replace$default(r110, r19 + '/', "", false, 4, null));     // Catch: Throwable -> L89 Exception -> L91
            r35.b(r36);     // Catch: Throwable -> L89 Exception -> L91
            r34.finishWithResult(r35);     // Catch: Throwable -> L89 Exception -> L91
        L98:
            this.a.n();
            return;
        L85:
            if (r10 == false) goto L87;
            SaveTemplateMethod.p(this.a, "save image to gallery fail");     // Catch: Throwable -> L89 Exception -> L91
            goto L11
        L87:
            if (r33 == true) goto L98;
            this.a.o("save image to gallery fail for no permission", SaveTemplateResultModel.Code.NO_PERMISSION);     // Catch: Throwable -> L89 Exception -> L91
        L79:
            r33 = false;
            goto L81
        L72:
            r32 = false;
            goto L73
        L67:
            r31 = null;
            goto L68
        L64:
            int r37 = com.bytedance.android.annie.util.k.a;     // Catch: Throwable -> L89 Exception -> L91
            r30 = com.bytedance.android.annie.util.k.a(r16, r110, true, (com.bytedance.android.annie.container.fragment.q) r1.element, new a(r16, r110, this.a, r19));     // Catch: Throwable -> L89 Exception -> L91
            goto L65
        L61:
            r29 = false;
            goto L62
        L43:
            r23 = null;
            goto L44
        L93:
            SaveTemplateResultModel r38 = new SaveTemplateResultModel();     // Catch: Throwable -> L89 Exception -> L91
            r38.a(SaveTemplateResultModel.Code.Success);     // Catch: Throwable -> L89 Exception -> L91
            r38.c("Success");     // Catch: Throwable -> L89 Exception -> L91
            SaveTemplateResultModel.a r39 = new SaveTemplateResultModel.a();     // Catch: Throwable -> L89 Exception -> L91
            r39.a(r110);     // Catch: Throwable -> L89 Exception -> L91
            r39.b(StringsKt.replace$default(r110, r19 + '/', "", false, 4, null));     // Catch: Throwable -> L89 Exception -> L91
            r38.b(r39);     // Catch: Throwable -> L89 Exception -> L91
            r0.finishWithResult(r38);     // Catch: Throwable -> L89 Exception -> L91
            goto L98
        L28:
            if (StringsKt.isBlank(r19) == true) goto L31;
            r20 = false;
            goto L32
        L24:
            r19 = null;
        L94:
            SaveTemplateMethod.p(this.a, "can't get context in ref");     // Catch: Throwable -> L89 Exception -> L91
        L95:
            SaveTemplateMethod.p(this.a, "can't get hybridView");     // Catch: Throwable -> L89 Exception -> L91
        L91:
            e = move-exception;
            SaveTemplateMethod.p(this.a, "Exception when save bit map : " + e);     // Catch: Throwable -> L89
        L89:
            th = move-exception;
            this.a.n();
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ SaveTemplateMethod a;

        public d(SaveTemplateMethod r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SaveTemplateMethod r0 = this.a;     // Catch: Throwable -> L4
            SaveTemplateResultModel r1 = new SaveTemplateResultModel();     // Catch: Throwable -> L4
            r1.a(SaveTemplateResultModel.Code.Timeout);     // Catch: Throwable -> L4
            r1.c("timeout");     // Catch: Throwable -> L4
            r0.finishWithResult(r1);     // Catch: Throwable -> L4
            this.a.n();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        u = CollectionsKt.listOf("webcast_lynxview");
        v = CollectionsKt.listOf(new String[]{".png", ".jpg", ".jpeg", ".webp"});
    }

    public final void n() {
        x8.a.d("Annie_SaveTemplateMethod", "release resources begin", false);
        if (this.m == false) goto L5;
        EventCenter.unregisterJsEventSubscriber("saveTemplateStart", this.s);
        this.m = false;
    L5:
        this.q.removeCallbacksAndMessages(null);
        WeakReference<Context> r1 = this.l;
        if (r1 == null) goto L24;
        FragmentActivity r10 = (Context) r1.get();
        if (r10 == null) goto L24;
        if ((r10 instanceof FragmentActivity) == false) goto L15;
        if (this.o == false) goto L15;
        r10.getLifecycle().removeObserver(this.n);
        this.o = false;
    L15:
        if ((r10 instanceof Activity) == true) goto L17;
    L21:
        WeakReference<Context> r11 = this.l;
        if (r11 == null) goto L24;
        r11.clear();
        goto L24
    L17:
        if (this.k == null) goto L21;
        if (this.p == false) goto L21;
        ((ViewGroup) j(((Activity) r10).getWindow()).getRootView().findViewById(R.id.content)).removeView(this.k);
        this.p = false;
    L24:
        this.l = null;
        HybridCard r12 = this.k;
        if (r12 == null) goto L27;
        r12.close();
        r12.release();
    L27:
        this.k = null;
        x8.a.d("Annie_SaveTemplateMethod", "release resources done", false);
    }

    public final void onTerminate() {
        n();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.annie.bridge.method.SaveTemplateMethod$lifecycleObserver$1] */
    public SaveTemplateMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        com.bytedance.android.annie.util.p r0 = com.bytedance.android.annie.util.p.a;
        this.c = r0.e();
        this.d = r0.d();
        this.f = ServerInfo.ERROR_BIND_SERVICE;
        this.g = 100;
        this.h = "";
        this.i = Bitmap.CompressFormat.PNG;
        this.j = 1073741824;
        this.n = new SaveTemplateMethod$lifecycleObserver$1(this);
        this.q = new Handler(Looper.getMainLooper());
        this.r = new d(this);
        this.s = new b(this);
        this.t = new c(this);
        IHybridComponent r1 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r1 == null) goto L5;
        this.a = r1;
    L5:
        com.bytedance.android.annie.container.fragment.q r11 = (com.bytedance.android.annie.container.fragment.q) r10.c(com.bytedance.android.annie.container.fragment.q.class);
        if (r11 == null) goto L9;
        this.b = r11;
        return;
    }

    public static View j(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static Uri l(e7.t0 r10) {
        Uri r0 = UriProtector.parse(r10.g());
        if (r10.c() == null) goto L6;
        String r1 = UUID.randomUUID().toString();
        Lazy r11 = ContainerInitialPropsManager.a;
        JsonObject r12 = r10.c();
        Intrinsics.checkNotNullParameter(r1, "key");
        ((HashMap) ContainerInitialPropsManager.a.getValue()).put(r1, r12);
        Uri.Builder r13 = r0.buildUpon();
        r13.appendQueryParameter("__initialProps_data_key", r1);
        Uri r14 = r13.build();
        int r15 = x8.a.a;
        x8.a.d("Annie_SaveTemplateMethod", "BuildUri: " + r14, false);
        return r14;
    L6:
        int r16 = x8.a.a;
        x8.a.d("Annie_SaveTemplateMethod", "BuildUri: " + r0, false);
        return r0;
    }

    public final void m(e7.t0 r10) {
        String r0 = r10.g();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L19;
        String r12 = r10.g();
        if (r12 != null) goto L13;
    L16:
        boolean r13 = true;
    L17:
        if (r13 == true) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L120;
        if ((r10.i() instanceof Number) == false) goto L26;
        Integer r15 = r10.i();
        Intrinsics.checkNotNull(r15);
        if (r15.intValue() <= 0) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L118;
        if ((r10.b() instanceof Number) == false) goto L33;
        Integer r17 = r10.b();
        Intrinsics.checkNotNull(r17);
        if (r17.intValue() <= 0) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == false) goto L116;
        String r19 = r10.g();
        Intrinsics.checkNotNull(r19);
        Uri r20 = UriProtector.parse(r19);
        List<String> r21 = u;
        String r22 = r20.getHost();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.String");
        if (r21.contains(r22) == false) goto L114;
        double r23 = this.c;
        Integer r24 = r10.b();
        Intrinsics.checkNotNull(r24);
        double r25 = r24.intValue();
        Integer r26 = r10.i();
        Intrinsics.checkNotNull(r26);
        this.d = r23 * (r25 / ((double) r26.intValue()));
        Integer r27 = r10.h();
        if (r27 == null) goto L40;
        this.f = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r27.intValue(), 0), 60000);
    L40:
        Integer r28 = r10.e();
        if (r28 == null) goto L43;
        this.g = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r28.intValue(), 0), 100);
    L43:
        String r29 = r10.a();
        if (r29 == null) goto L82;
        Integer r30 = Integer.valueOf(StringsKt.lastIndexOf$default(r29, '.', 0, false, 6, null));
        if (r30.intValue() <= 0) goto L48;
        boolean r31 = true;
    L49:
        String r32 = null;
        if (r31 == true) goto L53;
        r30 = null;
    L53:
        if (r30 == null) goto L82;
        int r33 = r30.intValue();
        String r34 = r10.a();
        if (r34 == null) goto L60;
        String r35 = r34.substring(r33);
        if (r35 == null) goto L60;
        r32 = r35.toLowerCase(Locale.getDefault());
    L60:
        if (CollectionsKt.contains(v, r32) == false) goto L82;
        String r36 = r10.a();
        Intrinsics.checkNotNull(r36);
        this.h = r36;
        if (r32 == null) goto L82;
        switch(r32.hashCode()) {
            case 1475827: goto L78;
            case 1481531: goto L74;
            case 45750678: goto L71;
            case 46127306: goto L67;
            default: goto L82;
        };
    L67:
        if (r32.equals(".webp") == false) goto L82;
        this.i = Bitmap.CompressFormat.WEBP;
        goto L82
    L71:
        if (r32.equals(".jpeg") == false) goto L82;
    L80:
        this.i = Bitmap.CompressFormat.JPEG;
        goto L82
    L74:
        if (r32.equals(".png") == false) goto L82;
        this.i = Bitmap.CompressFormat.PNG;
        goto L82
    L78:
        if (r32.equals(".jpg") == true) goto L80;
    L48:
        r31 = false;
    L82:
        if (this.h.length() == 0) goto L85;
        r1 = false;
    L85:
        if (r1 == false) goto L88;
        this.h = "save_template_" + System.currentTimeMillis() + 'x' + MathKt.roundToInt(Math.random() * ((double) 10)) + ".png";
        this.i = Bitmap.CompressFormat.PNG;
    L88:
        if (r10.f() == null) goto L90;
        Boolean r37 = r10.f();
        Intrinsics.checkNotNull(r37);
        boolean r38 = r37.booleanValue();
    L91:
        this.e = r38;
        String r110 = r10.d();
        if (r110 == null) goto L121;
        String r111 = r110.toUpperCase(Locale.getDefault());
        int r39 = r111.hashCode();
        if (r39 == (-605282132)) goto L109;
        if (r39 == 53152783) goto L105;
        if (r39 == 526786327) goto L101;
        return;
    L101:
        if (r111.equals("UNSPECIFIED") == false) goto L125;
        this.j = 0;
        return;
    L125:
        return;
    L105:
        if (r111.equals("AT_MOST") == false) goto L126;
        this.j = Integer.MIN_VALUE;
        return;
    L126:
        return;
    L109:
        if (r111.equals("EXACTLY") == false) goto L127;
        this.j = 1073741824;
        return;
    L127:
        return;
    L121:
        return;
    L90:
        r38 = false;
        goto L91
    L114:
        throw new IllegalStateException("Invalid schema host".toString());
    L116:
        throw new IllegalStateException("Invalid height".toString());
    L33:
        r18 = false;
        goto L34
    L118:
        throw new IllegalStateException("Invalid width".toString());
    L26:
        r16 = false;
        goto L27
    L120:
        throw new IllegalStateException("Invalid schema".toString());
    L13:
        if (r12.length() == 0) goto L16;
        r13 = false;
    L19:
        r14 = false;
        goto L20
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r11 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.annie.bridge.method.SaveTemplateMethod$lifecycleObserver$1] */
    public SaveTemplateMethod(IHybridComponent r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridComponent");
        com.bytedance.android.annie.util.p r0 = com.bytedance.android.annie.util.p.a;
        this.c = r0.e();
        this.d = r0.d();
        this.f = ServerInfo.ERROR_BIND_SERVICE;
        this.g = 100;
        this.h = "";
        this.i = Bitmap.CompressFormat.PNG;
        this.j = 1073741824;
        this.n = new SaveTemplateMethod$lifecycleObserver$1(this);
        this.q = new Handler(Looper.getMainLooper());
        this.r = new d(this);
        this.s = new b(this);
        this.t = new c(this);
        this.a = r10;
    }

    public static /* synthetic */ void p(SaveTemplateMethod r1, String r10) {
        r1.o(r10, SaveTemplateResultModel.Code.Failed);
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.t0 r12 = (e7.t0) r10;
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r11, "context");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        m(r12);     // Catch: Throwable -> L5
        x8.a.d("Annie_SaveTemplateMethod", "Parameters check done", false);     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L33;
        x8.a.b("Annie_SaveTemplateMethod", "Parameters invalid", false);
        SaveTemplateResultModel r16 = new SaveTemplateResultModel();
        r16.c(r15.getMessage());
        r16.a(SaveTemplateResultModel.Code.InvalidParam);
        finishWithResult(r16);
        return;
    L33:
        FragmentActivity r17 = r11.getContext();     // Catch: Throwable -> L25
        this.l = new WeakReference(r17);     // Catch: Throwable -> L25
        if ((r17 instanceof FragmentActivity) == false) goto L13;
        r17.getLifecycle().addObserver(this.n);     // Catch: Throwable -> L25
        this.o = true;     // Catch: Throwable -> L25
    L13:
        HybridCard r18 = Annie.with(r11.getContext(), l(r12), r11.a()).a();     // Catch: Throwable -> L25
        if (r18 == null) goto L19;
        r18.setAlpha(0.0f);     // Catch: Throwable -> L25
        r18.setClickable(false);     // Catch: Throwable -> L25
        r18.setFocusable(false);     // Catch: Throwable -> L25
        r18.setTranslationY(com.bytedance.android.annie.util.p.a.d());     // Catch: Throwable -> L25
        Context r19 = r11.getContext();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L25
        ((ViewGroup) j(((Activity) r19).getWindow()).getRootView().findViewById(R.id.content)).addView(r18);     // Catch: Throwable -> L25
        this.p = true;     // Catch: Throwable -> L25
        a7.a.a(r18, null, null, 3);     // Catch: Throwable -> L25
        if (this.m == true) goto L18;
        EventCenter.registerJsEventSubscriber("saveTemplateStart", this.s);     // Catch: Throwable -> L25
        this.m = true;     // Catch: Throwable -> L25
    L18:
        this.q.postDelayed(this.r, this.f);     // Catch: Throwable -> L25
    L20:
        this.k = r18;     // Catch: Throwable -> L25
        if (r18 != null) goto L23;
        x8.a.b("Annie_SaveTemplateMethod", "Invoke Annie.getHybridCreate failed", false);     // Catch: Throwable -> L25
        p(this, "Invoke Annie.getHybridCreate failed");     // Catch: Throwable -> L25
        n();     // Catch: Throwable -> L25
    L23:
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L36;
        x8.a.b("Annie_SaveTemplateMethod", "Invoke receive fail", false);
        p(this, r21.getMessage());
        n();
        return;
    L36:
        return;
    L19:
        r18 = null;
    L25:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void o(String r10, SaveTemplateResultModel.Code r11) {
        SaveTemplateResultModel r0 = new SaveTemplateResultModel();
        if (r11 != null) goto L5;
        r11 = SaveTemplateResultModel.Code.Failed;
    L5:
        r0.a(r11);
        r0.c(r10);
        finishWithResult(r0);
        int r12 = x8.a.a;
        x8.a.b("Annie_SaveTemplateMethod", "SaveTemplateFailCallback: " + r10, false);
    }

    public static final Bitmap k(SaveTemplateMethod r1, View r10, int r11, int r12) {
        r10.measure(View.MeasureSpec.makeMeasureSpec(r11, r1.j), View.MeasureSpec.makeMeasureSpec(r12, r1.j));
        r10.layout(0, 0, r10.getMeasuredWidth(), r10.getMeasuredHeight());
        int r13 = x8.a.a;
        x8.a.d("Annie_SaveTemplateMethod", "createBitmap measured, width: " + r10.getMeasuredWidth() + ", height: " + r10.getMeasuredHeight() + '.', false);
        Bitmap r14 = Bitmap.createBitmap(r10.getWidth(), r10.getHeight(), Bitmap.Config.ARGB_8888);
        r10.draw(new Canvas(r14));
        return r14;
    }
}
