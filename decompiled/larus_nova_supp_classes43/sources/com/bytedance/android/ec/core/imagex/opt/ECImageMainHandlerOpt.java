package com.bytedance.android.ec.core.imagex.opt;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.opt.ab.ColdLaunchExpFilter;
import com.bytedance.android.ec.core.opt.ab.LazyFastSDKSettings;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageMainHandlerOpt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final LazyOptGetSettings d = null;
    public static yl.b e;
    public static final ECImageMainHandlerOpt f = null;

    public static final class URIStruct {
        public final Map<String, String> a;
        public final Lazy b;
        public final ImageRequest c;
        public final String d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof URIStruct) == false) goto L10;
            URIStruct r11 = (URIStruct) r10;
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ImageRequest r0 = this.c;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            String r12 = this.d;
            if (r12 == null) goto L10;
            r1 = r12.hashCode();
        L10:
            return r11 + r1;
        L5:
            r10 = 0;
            goto L6
        }

        private final String query() {
            String r0 = this.d;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L10:
            if (r1 == false) goto L12;
            return "";
        L12:
            int r10 = StringsKt.indexOf$default(this.d, "?", 0, false, 6, null);
            if (r10 >= 0) goto L15;
        L22:
            return "";
        L15:
            if (this.d.length() <= 1) goto L22;
            String r11 = this.d;
            int r12 = r10 + 1;
            if (r11 == null) goto L21;
            return r11.substring(r12);
        L21:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L10
        }

        public final String toString() {
            String r0 = this.d;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public URIStruct(ImageRequest r10) {
            Intrinsics.checkNotNullParameter(r10, "imageRequest");
            this(r10, r10.getSourceUri().toString());
        }

        public static final Map a(URIStruct r14) {
            r14.getClass();
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r15 = StringsKt.split$default(r14.query(), new String[]{"&"}, false, 0, 6, null).iterator();
        L4:
            if (r15.hasNext() == false) goto L12;
            String r1 = (String) r15.next();
            List r13 = StringsKt.split$default(r1, new String[]{"="}, false, 0, 6, null);
            boolean r10 = false;
            String r11 = (String) CollectionsKt.getOrNull(StringsKt.split$default(r1, new String[]{"="}, false, 0, 6, null), 0);
            if (r11 != null) goto L8;
        L9:
            r10 = true;
        L10:
            if (r10 == true) goto L4;
            r0.put(r11, CollectionsKt.getOrNull(r13, 1));
            goto L4
        L8:
            if (StringsKt.isBlank(r11) == false) goto L10;
        L12:
            return r0;
        }

        public final String b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Map<String, String> r0 = this.a;
            if (r0 == null) goto L7;
            String r1 = r0.get(r10);
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (String) ((Map) this.b.getValue()).get(r10);
        }

        public URIStruct(ImageRequest r1, String r10) {
            this.c = r1;
            this.d = r10;
            if (r1 == null) goto L5;
            Map<String, String> r11 = r1.getCustomParam();
        L6:
            this.a = r11;
            this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECImageMainHandlerOpt$URIStruct$cache$2(this));
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ BaseDataSubscriber a;
        public final /* synthetic */ DataSource b;
        public final /* synthetic */ URIStruct c;
        public final /* synthetic */ yl.a d;
        public final /* synthetic */ Ref.BooleanRef e;
        public final /* synthetic */ Ref.BooleanRef f;
        public final /* synthetic */ long g;

        public a(BaseDataSubscriber r1, DataSource r10, URIStruct r11, yl.a r12, Ref.BooleanRef r13, Ref.BooleanRef r14, long r15) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
        }

        public final void a() {
            long r1 = System.nanoTime();
            this.a.onNewResult(this.b);
            long r10 = System.nanoTime();
            ECImageMainHandlerOpt r0 = ECImageMainHandlerOpt.f;
            URIStruct r11 = this.c;
            yl.a r12 = this.d;
            boolean r13 = this.e.element;
            boolean r14 = this.f.element;
            long r15 = this.g;
            r0.getClass();
            ((ExecutorService) ECImageMainHandlerOpt.b.getValue()).execute(new r(r1, r15, r10, r11, r13, r14, r12));
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

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ECImageMainHandlerOpt.class, "configKeys", "getConfigKeys()Ljava/util/List;", 0))};
        ECImageMainHandlerOpt r0 = new ECImageMainHandlerOpt();
        f = r0;
        b = LazyKt.lazy(ECImageMainHandlerOpt$executor$2.INSTANCE);
        c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ECImageMainHandlerOpt$enable$2.INSTANCE);
        final String r10 = "ec_image_main_handler_opt_configs";
        final ArrayList r11 = new ArrayList();
        ECImageMainHandlerOpt$configKeys$2 r12 = ECImageMainHandlerOpt$configKeys$2.INSTANCE;
        ECImageMainHandlerOpt$configKeys$3 r13 = new ECImageMainHandlerOpt$configKeys$3(r0);
        if (z.b() == false) goto L5;
        LazyOptGetSettings r1 = new LazyFastSDKSettings("ec_image_main_handler_opt_configs", r11, null, r12, r13, new ECImageMainHandlerOpt$$special$$inlined$lazyImageXSettings$1(r10, r11));
    L6:
        d = r1;
        return;
    L5:
        r1 = com.bytedance.android.ec.core.opt.ab.h.a("ec_image_main_handler_opt_configs", r11, null, r12, r13);
        goto L6
    }

    public ECImageMainHandlerOpt() {
    }

    public final boolean a(BaseDataSubscriber<?> r14, Object r15) {
        yl.a r1 = null;
        if ((r15 instanceof DataSource) == true) goto L5;
        Object r0 = null;
    L6:
        DataSource r10 = (DataSource) r0;
        if (r10 != null) goto L10;
        return false;
    L10:
        if ((r14 instanceof BaseDataSubscriber) == true) goto L12;
        BaseDataSubscriber<?> r11 = null;
    L13:
        if (r11 != null) goto L16;
        return false;
    L16:
        if (r15 == null) goto L31;
        Method r12 = com.bytedance.android.shopping.api.image.c0.a;
        Intrinsics.checkNotNullParameter(r15, "dataSource");
        if (StringsKt.contains$default(r15.getClass().getName(), "IncreasingQualityDataSource", false, 2, null) == false) goto L31;
        Intrinsics.checkNotNullParameter(r15, "dataSource");
        Method r13 = com.bytedance.android.shopping.api.image.c0.a;     // Catch: Throwable -> L28
        if (r13 != null) goto L23;
        r13 = r15.getClass().getDeclaredMethod("getDataSourceWithResult", new Class[0]);     // Catch: Throwable -> L28
        com.bytedance.android.shopping.api.image.c0.a = r13;     // Catch: Throwable -> L28
    L23:
        if (r13 == null) goto L25;
        r13.setAccessible(true);     // Catch: Throwable -> L28
    L25:
        if (r13 == null) goto L29;
        r15 = r13.invoke(r15, new Object[0]);     // Catch: Throwable -> L28
    L29:
        r15 = null;
    L31:
        if ((r15 instanceof HasImageRequest) == false) goto L36;
        ImageRequest r16 = ((HasImageRequest) r15).getImageRequest();
        if (r16 == null) goto L59;
        URIStruct r17 = new URIStruct(r16);
    L60:
        if (r17 != null) goto L62;
        return false;
    L62:
        Ref.BooleanRef r18 = new Ref.BooleanRef();
        r18.element = false;
        yl.b r19 = e;
        if (r19 != null) goto L65;
        List r20 = (List) d.getValue(this, a[0]);
    L147:
        if (r1 == null) goto L155;
        Handler r110 = new Handler(Looper.getMainLooper());
        long r21 = System.nanoTime();
        Ref.BooleanRef r111 = new Ref.BooleanRef();
        r111.element = false;
        Message r22 = Message.obtain(r110, new a(r11, r10, r17, r1, r18, r111, r21));
        if (Build.VERSION.SDK_INT >= 22) goto L151;
    L153:
        r18.element = r110.sendMessageAtFrontOfQueue(r22);
        goto L155
    L151:
        if ((!Intrinsics.areEqual(r1.e(), Boolean.FALSE)) == false) goto L153;
        r22.setAsynchronous(true);
        r111.element = true;
    L155:
        return r18.element;
    L65:
        List r23 = r19.a();
        if (r23 != null) goto L68;
        r23 = CollectionsKt.emptyList();
    L68:
        Iterator r24 = r23.iterator();
    L70:
        if (r24.hasNext() == false) goto L147;
        yl.a r25 = (yl.a) r24.next();
        Map r26 = r25.c();
        if (r26 != null) goto L74;
    L77:
        boolean r27 = true;
    L78:
        if (r27 == false) goto L96;
        String r28 = r25.d();
        if (r28 != null) goto L82;
    L85:
        boolean r29 = true;
    L86:
        if (r29 == false) goto L96;
        String r30 = r25.a();
        if (r30 != null) goto L90;
    L93:
        boolean r31 = true;
    L94:
        if (r31 == false) goto L96;
        boolean r32 = false;
    L97:
        Boolean r33 = r25.b();
        if (r32 == true) goto L100;
    L109:
        String r34 = r25.d();
        if (r32 == false) goto L121;
        if (r34 != null) goto L113;
    L116:
        boolean r112 = true;
    L117:
        if (r112 == true) goto L121;
        if (StringsKt.startsWith$default(r17.toString(), r34, false, 2, null) == true) goto L121;
        r32 = false;
        goto L121
    L113:
        if (r34.length() == 0) goto L116;
        r112 = false;
    L121:
        String r35 = r25.a();
        if (r32 == false) goto L133;
        if (r35 != null) goto L125;
    L128:
        boolean r113 = true;
    L129:
        if (r113 == true) goto L133;
        if (StringsKt.contains$default(r17.toString(), r35, false, 2, null) == true) goto L133;
        r32 = false;
        goto L133
    L125:
        if (r35.length() == 0) goto L128;
        r113 = false;
    L133:
        Map r36 = r25.c();
        if (r32 == false) goto L145;
        if (r36 == null) goto L145;
        Iterator r37 = r36.entrySet().iterator();
    L138:
        if (r37.hasNext() == false) goto L142;
        Object r114 = r37.next();
        Map.Entry r115 = (Map.Entry) r114;
        if ((!CollectionsKt.contains((List) r115.getValue(), r17.b((String) r115.getKey()))) == false) goto L138;
    L143:
        if (r114 == null) goto L145;
        r32 = false;
        goto L145
    L142:
        r114 = null;
    L145:
        if (r32 == false) goto L70;
        r1 = r25;
        goto L147
    L100:
        if (Intrinsics.areEqual(r33, Boolean.TRUE) == false) goto L109;
        ColdLaunchExpFilter.e.getClass();
        if (ColdLaunchExpFilter.a() == true) goto L104;
    L106:
        boolean r38 = false;
    L107:
        if (r38 == false) goto L109;
        r32 = false;
        goto L109
    L104:
        if (ColdLaunchExpFilter.b == true) goto L106;
        r38 = true;
        goto L107
    L90:
        if (r30.length() == 0) goto L93;
        r31 = false;
        goto L94
    L82:
        if (r28.length() == 0) goto L85;
        r29 = false;
    L96:
        r32 = true;
        goto L97
    L74:
        if (r26.isEmpty() == true) goto L77;
        r27 = false;
    L59:
        r17 = null;
        goto L60
    L36:
        if ((r15 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L59;
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource r116 = (FirstAvailableDataSourceSupplier.FirstAvailableDataSource) r15;
        AbstractDraweeControllerBuilder.CustomSupplier r39 = r116.getCurrentSupplier();
        if ((r39 instanceof AbstractDraweeControllerBuilder.CustomSupplier) == false) goto L45;
        Object r117 = r39.getRequest();
        if ((r117 instanceof ImageRequest) == true) goto L42;
        r117 = null;
    L42:
        ImageRequest r118 = (ImageRequest) r117;
        if (r118 == null) goto L59;
        r17 = new URIStruct(r118);
        goto L60
    L45:
        String r119 = r116.getCurrentSupplier().toString();
        int r40 = StringsKt.indexOf$default(r119, "uri=", 0, false, 6, null);
        if (r40 <= 0) goto L51;
        if (r119 == null) goto L50;
        String r120 = r119.substring(r40);
    L52:
        if (r120 == null) goto L56;
        int r41 = StringsKt.indexOf$default(r120, ",", 0, false, 6, null);
        if (r41 <= 0) goto L57;
        r120 = r120.substring(0, r41);
    L57:
        if (r120 == null) goto L59;
        Intrinsics.checkNotNullParameter(r120, "uriString");
        r17 = new URIStruct(null, r120);
        goto L60
    L56:
        r120 = null;
        goto L57
    L50:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L51:
        r120 = null;
        goto L52
    L12:
        r11 = r14;
        goto L13
    L5:
        r0 = r15;
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00aa -> B:21:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00be -> B:21:0x00c1). Please report as a decompilation issue!!! */
    public final Object b(List<String> r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof ECImageMainHandlerOpt$onInitConfig$1) == false) goto L7;
        ECImageMainHandlerOpt$onInitConfig$1 r1 = (ECImageMainHandlerOpt$onInitConfig$1) r21;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r1.label;
        long r13 = 0;
        int r14 = 0;
        int r15 = 1;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        int r16 = r1.I$1;
        int r17 = r1.I$0;
        Long[] r18 = (Long[]) r1.L$3;
        List r19 = (List) r1.L$2;
        List r110 = (List) r1.L$1;
        yl.b r111 = (yl.b) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L21:
        int r112 = r19.size() - r15;
    L22:
        if (r112 < 0) goto L562;
        String r113 = (String) CollectionsKt.getOrNull(r19, r112);
        if (r113 != null) goto L575;
    L557:
        ECImageMainHandlerOpt$onInitConfig$1 r22 = r1;
    L558:
        boolean r23 = false;
    L559:
        if (r23 == true) goto L561;
        ListProtector.remove(r19, r112);
    L561:
        r112 = r112 - 1;
        r1 = r22;
        r14 = 0;
        goto L22
    L575:
        int r24 = h0.a;     // Catch: Throwable -> L555
        Object r114 = null;
        if (z.b() == true) goto L607;
        int r25 = com.bytedance.android.ec.core.opt.ab.n.a;     // Catch: Throwable -> L555
        int r26 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L555
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L197
        Object r28 = com.bytedance.android.ec.base.settings.d.a().get(r113);     // Catch: Throwable -> L172
        if (r28 != null) goto L124;
    L169:
        Object r29 = null;
    L170:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L172
    L174:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L197
        if (r31 == null) goto L178;
        EnsureManager.ensureNotReachHere(r31);     // Catch: Throwable -> L197
    L178:
        if (Result.isFailure-impl(r30) == false) goto L181;
        r30 = null;
    L181:
        if ((r30 instanceof yl.b) == true) goto L183;
        r30 = null;
    L183:
        Object r32 = (yl.b) r30;     // Catch: Throwable -> L197
        if (r32 != null) goto L204;
        IHybridHostService r33 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L197
        if (r33 == null) goto L189;
        Object r34 = r33.getHostABValue(r113, r111);     // Catch: Throwable -> L197
    L190:
        if (r34 != null) goto L192;
    L203:
        r32 = r111;
        goto L204
    L192:
        if ((r34 instanceof yl.b) == true) goto L194;
        r34 = null;
    L194:
        r32 = (yl.b) r34;     // Catch: Throwable -> L197
        if (r32 != null) goto L204;
    L189:
        r34 = null;
    L204:
        yl.b r35 = (yl.b) r32;     // Catch: Throwable -> L555
        if (r35 != r111) goto L552;
        int r36 = h0.a;     // Catch: Throwable -> L555
        String r37 = r113 + "_enable";     // Catch: Throwable -> L555
        Object r38 = Boxing.boxInt(r14);     // Catch: Throwable -> L555
        if (z.b() == false) goto L385;
        int r39 = com.bytedance.android.ec.base.settings.b.a;     // Catch: Throwable -> L555
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L376
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L376
        SDKSettingsCacheManager r115 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L376
        r115.getClass();     // Catch: Throwable -> L264
        Object r41 = SDKSettingsCacheManager.b().get(r37);     // Catch: Throwable -> L264
        if (r41 != null) goto L214;
        r22 = r1;
    L259:
        Object r42 = null;
    L605:
        Object r43 = Result.constructor-impl(r42);     // Catch: Throwable -> L262
    L587:
        Throwable r44 = Result.exceptionOrNull-impl(r43);     // Catch: Throwable -> L374
        if (r44 == null) goto L271;
        EnsureManager.ensureNotReachHere(r44);     // Catch: Throwable -> L374
    L271:
        if (Result.isFailure-impl(r43) == false) goto L274;
        r43 = null;
    L274:
        if ((r43 instanceof Integer) == true) goto L276;
        r43 = null;
    L276:
        Object r45 = (Integer) r43;     // Catch: Throwable -> L374
        if (r45 != null) goto L283;
        r115.getClass();     // Catch: Throwable -> L374
        Object r46 = SDKSettingsCacheManager.c().get(r37);     // Catch: Throwable -> L374
        if ((r46 instanceof Integer) == true) goto L282;
        r46 = null;
    L282:
        r45 = (Integer) r46;     // Catch: Throwable -> L374
    L283:
        if (r45 != null) goto L579;
        int r47 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L374
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L336
        Object r48 = SDKSettingsCacheManager.b().get(r37);     // Catch: Throwable -> L336
        if (r48 != null) goto L291;
    L333:
        Object r49 = null;
    L334:
        Object r50 = Result.constructor-impl(r49);     // Catch: Throwable -> L336
    L338:
        Throwable r51 = Result.exceptionOrNull-impl(r50);     // Catch: Throwable -> L362
        if (r51 == null) goto L342;
        EnsureManager.ensureNotReachHere(r51);     // Catch: Throwable -> L362
    L342:
        if (Result.isFailure-impl(r50) == false) goto L345;
        r50 = null;
    L345:
        if ((r50 instanceof Integer) == true) goto L347;
        r50 = null;
    L347:
        r45 = (Integer) r50;     // Catch: Throwable -> L362
        if (r45 != null) goto L372;
        Object r52 = jj4.a.a(r37, Integer.class, r38, jj4.b.b.a());     // Catch: Throwable -> L362
        if (r52 != null) goto L354;
        Intrinsics.throwNpe();     // Catch: Throwable -> L362
    L354:
        if ((r52 instanceof Integer) == false) goto L357;
        r114 = r52;
    L357:
        Object r116 = (Integer) r114;     // Catch: Throwable -> L362
        if (r116 != null) goto L360;
        r116 = r38;
    L360:
        r45 = Result.constructor-impl(r116);     // Catch: Throwable -> L362
    L365:
        if (Result.exceptionOrNull-impl(r45) == null) goto L372;
        r45 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r37, Integer.class, r38);     // Catch: Throwable -> L369
    L370:
        if (r45 != null) goto L372;
        r45 = r38;
    L369:
        r45 = r38;
    L372:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L374
        SDKSettingsCacheManager.e(r37, r45);     // Catch: Throwable -> L374
        goto L579
    L291:
        if ((r48 instanceof Integer) == true) goto L293;
        Object r53 = null;
    L294:
        r49 = (Integer) r53;     // Catch: Throwable -> L336
        if (r49 != null) goto L334;
        if ((r48 instanceof Number) == false) goto L321;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L306;
        Float r54 = Boxing.boxFloat(((Number) r48).floatValue());     // Catch: Throwable -> L336
        if ((r54 instanceof Integer) == true) goto L304;
        r54 = null;
    L304:
        r49 = (Integer) r54;     // Catch: Throwable -> L336
        goto L334
    L306:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L312;
        Double r55 = Boxing.boxDouble(((Number) r48).doubleValue());     // Catch: Throwable -> L336
        if ((r55 instanceof Integer) == true) goto L310;
        r55 = null;
    L310:
        r49 = (Integer) r55;     // Catch: Throwable -> L336
        goto L334
    L312:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L315;
        r49 = Boxing.boxInt(((Number) r48).intValue());     // Catch: Throwable -> L336
        goto L334
    L315:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L321;
        Long r56 = Boxing.boxLong(((Number) r48).longValue());     // Catch: Throwable -> L336
        if ((r56 instanceof Integer) == true) goto L319;
        r56 = null;
    L319:
        r49 = (Integer) r56;     // Catch: Throwable -> L336
    L321:
        if ((r48 instanceof JSONObject) == false) goto L323;
    L571:
        Object r57 = SDKSettingsCacheManager.a().fromJson(r48.toString(), Integer.class);     // Catch: Throwable -> L329
        if ((r57 instanceof Integer) == true) goto L327;
        r57 = null;
    L327:
        Object r58 = Result.constructor-impl((Integer) r57);     // Catch: Throwable -> L329
    L331:
        r49 = r58;
        if (Result.isFailure-impl(r49) == false) goto L334;
    L329:
        th = move-exception;
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L336
        r58 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L336
        goto L331
    L323:
        if ((r48 instanceof JSONArray) == false) goto L333;
    L293:
        r53 = r48;
        goto L294
    L336:
        th = move-exception;
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L362
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L362
        goto L338
    L362:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L374
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L374
    L579:
        if (((Number) r45).intValue() != 1) goto L553;
        Logger.d("ECImageMainHandlerOpt-initConfig", "need retry key: " + r113);     // Catch: Throwable -> L568
        r23 = true;
    L553:
        r35.b(r110, r113);     // Catch: Throwable -> L568
    L374:
        th = th;
    L378:
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L568
        Object r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L568
        Throwable r64 = Result.exceptionOrNull-impl(r63);     // Catch: Throwable -> L568
        if (r64 == null) goto L382;
        EnsureManager.ensureNotReachHere(r64);     // Catch: Throwable -> L568
    L382:
        if (Result.isFailure-impl(r63) == true) goto L548;
    L384:
        r38 = r63;
    L548:
        r45 = r38;
    L262:
        th = th;
    L266:
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L374
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L374
        goto L587
    L214:
        if ((r41 instanceof Integer) == true) goto L216;
        Object r66 = null;
    L217:
        r42 = (Integer) r66;     // Catch: Throwable -> L264
        if (r42 == null) goto L221;
        r22 = r1;
        goto L605
    L221:
        if ((r41 instanceof Number) == false) goto L245;
        r22 = r1;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L231;
        Float r67 = Boxing.boxFloat(((Number) r41).floatValue());     // Catch: Throwable -> L262
        if ((r67 instanceof Integer) == true) goto L229;
        r67 = null;
    L229:
        r42 = (Integer) r67;     // Catch: Throwable -> L262
        goto L605
    L231:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L237;
        Double r68 = Boxing.boxDouble(((Number) r41).doubleValue());     // Catch: Throwable -> L262
        if ((r68 instanceof Integer) == true) goto L235;
        r68 = null;
    L235:
        r42 = (Integer) r68;     // Catch: Throwable -> L262
        goto L605
    L237:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L240;
        r42 = Boxing.boxInt(((Number) r41).intValue());     // Catch: Throwable -> L262
        goto L605
    L240:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L247;
        Long r69 = Boxing.boxLong(((Number) r41).longValue());     // Catch: Throwable -> L262
        if ((r69 instanceof Integer) == true) goto L244;
        r69 = null;
    L244:
        r42 = (Integer) r69;     // Catch: Throwable -> L262
    L247:
        if ((r41 instanceof JSONObject) == false) goto L249;
    L583:
        Object r70 = SDKSettingsCacheManager.a().fromJson(r41.toString(), Integer.class);     // Catch: Throwable -> L255
        if ((r70 instanceof Integer) == true) goto L253;
        r70 = null;
    L253:
        Object r71 = Result.constructor-impl((Integer) r70);     // Catch: Throwable -> L255
    L257:
        r42 = r71;
        if (Result.isFailure-impl(r42) == false) goto L605;
    L255:
        th = move-exception;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L262
        r71 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L262
        goto L257
    L249:
        if ((r41 instanceof JSONArray) == false) goto L259;
    L245:
        r22 = r1;
        goto L247
    L216:
        r66 = r41;
    L264:
        th = th;
        r22 = r1;
    L376:
        th = th;
        r22 = r1;
        goto L378
    L385:
        r22 = r1;
        int r73 = com.bytedance.android.ec.core.opt.ab.n.a;     // Catch: Throwable -> L568
        int r74 = com.bytedance.android.ec.base.settings.a.a;     // Catch: Throwable -> L568
        Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L542
        goto L558
    L617:
        Object r76 = com.bytedance.android.ec.base.settings.d.a().get(r37);     // Catch: Throwable -> L436
        if (r76 != null) goto L391;
    L433:
        Object r77 = null;
    L434:
        Object r78 = Result.constructor-impl(r77);     // Catch: Throwable -> L436
    L438:
        Throwable r79 = Result.exceptionOrNull-impl(r78);     // Catch: Throwable -> L542
        if (r79 == null) goto L442;
        EnsureManager.ensureNotReachHere(r79);     // Catch: Throwable -> L542
    L442:
        if (Result.isFailure-impl(r78) == false) goto L445;
        r78 = null;
    L445:
        if ((r78 instanceof Integer) == true) goto L447;
        r78 = null;
    L447:
        r45 = (Integer) r78;     // Catch: Throwable -> L542
        if (r45 != null) goto L454;
        Object r80 = com.bytedance.android.ec.base.settings.d.b().get(r37);     // Catch: Throwable -> L542
        if ((r80 instanceof Integer) == true) goto L453;
        r80 = null;
    L453:
        r45 = (Integer) r80;     // Catch: Throwable -> L542
    L454:
        if (r45 != null) goto L579;
        int r81 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L542
        Object r82 = com.bytedance.android.ec.base.settings.d.a().get(r37);     // Catch: Throwable -> L506
        if (r82 != null) goto L461;
    L503:
        Object r83 = null;
    L504:
        Object r84 = Result.constructor-impl(r83);     // Catch: Throwable -> L506
    L603:
        Throwable r85 = Result.exceptionOrNull-impl(r84);     // Catch: Throwable -> L533
        if (r85 == null) goto L512;
        EnsureManager.ensureNotReachHere(r85);     // Catch: Throwable -> L533
    L512:
        if (Result.isFailure-impl(r84) == false) goto L515;
        r84 = null;
    L515:
        if ((r84 instanceof Integer) == true) goto L517;
        r84 = null;
    L517:
        r45 = (Integer) r84;     // Catch: Throwable -> L533
        if (r45 != null) goto L540;
        IHybridHostService r86 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L533
        if (r86 == null) goto L523;
        Object r87 = r86.getHostABValue(r37, r38);     // Catch: Throwable -> L533
    L524:
        if (r87 != null) goto L526;
    L539:
        r45 = r38;
        goto L540
    L526:
        if ((r87 instanceof Integer) == false) goto L529;
        r114 = r87;
    L529:
        Integer r117 = (Integer) r114;     // Catch: Throwable -> L533
        if (r117 == null) goto L539;
        r45 = r117;
        goto L540
    L523:
        r87 = null;
    L540:
        com.bytedance.android.ec.base.settings.d.d(r37, r45);     // Catch: Throwable -> L542
        goto L579
    L533:
        th = move-exception;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L542
        r45 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L542
        Throwable r89 = Result.exceptionOrNull-impl(r45);     // Catch: Throwable -> L542
        if (r89 == null) goto L538;
        EnsureManager.ensureNotReachHere(r89);     // Catch: Throwable -> L542
    L538:
        if (Result.isFailure-impl(r45) == false) goto L540;
    L461:
        if ((r82 instanceof Integer) == true) goto L463;
        Object r90 = null;
    L464:
        r83 = (Integer) r90;     // Catch: Throwable -> L506
        if (r83 != null) goto L504;
        if ((r82 instanceof Number) == false) goto L491;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L476;
        Float r91 = Boxing.boxFloat(((Number) r82).floatValue());     // Catch: Throwable -> L506
        if ((r91 instanceof Integer) == true) goto L474;
        r91 = null;
    L474:
        r83 = (Integer) r91;     // Catch: Throwable -> L506
        goto L504
    L476:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L482;
        Double r92 = Boxing.boxDouble(((Number) r82).doubleValue());     // Catch: Throwable -> L506
        if ((r92 instanceof Integer) == true) goto L480;
        r92 = null;
    L480:
        r83 = (Integer) r92;     // Catch: Throwable -> L506
        goto L504
    L482:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L485;
        r83 = Boxing.boxInt(((Number) r82).intValue());     // Catch: Throwable -> L506
        goto L504
    L485:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L491;
        Long r93 = Boxing.boxLong(((Number) r82).longValue());     // Catch: Throwable -> L506
        if ((r93 instanceof Integer) == true) goto L489;
        r93 = null;
    L489:
        r83 = (Integer) r93;     // Catch: Throwable -> L506
    L491:
        if ((r82 instanceof JSONObject) == false) goto L493;
    L577:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L499
        Object r94 = SDKSettingsCacheManager.a().fromJson(r82.toString(), Integer.class);     // Catch: Throwable -> L499
        if ((r94 instanceof Integer) == true) goto L497;
        r94 = null;
    L497:
        Object r95 = Result.constructor-impl((Integer) r94);     // Catch: Throwable -> L499
    L501:
        r83 = r95;
        if (Result.isFailure-impl(r83) == false) goto L504;
    L499:
        th = move-exception;
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L506
        r95 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L506
        goto L501
    L493:
        if ((r82 instanceof JSONArray) == false) goto L503;
    L463:
        r90 = r82;
        goto L464
    L506:
        th = move-exception;
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L533
        r84 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L533
        goto L603
    L391:
        if ((r76 instanceof Integer) == true) goto L393;
        Object r98 = null;
    L394:
        r77 = (Integer) r98;     // Catch: Throwable -> L436
        if (r77 != null) goto L434;
        if ((r76 instanceof Number) == false) goto L421;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L406;
        Float r99 = Boxing.boxFloat(((Number) r76).floatValue());     // Catch: Throwable -> L436
        if ((r99 instanceof Integer) == true) goto L404;
        r99 = null;
    L404:
        r77 = (Integer) r99;     // Catch: Throwable -> L436
        goto L434
    L406:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L412;
        Double r100 = Boxing.boxDouble(((Number) r76).doubleValue());     // Catch: Throwable -> L436
        if ((r100 instanceof Integer) == true) goto L410;
        r100 = null;
    L410:
        r77 = (Integer) r100;     // Catch: Throwable -> L436
        goto L434
    L412:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L415;
        r77 = Boxing.boxInt(((Number) r76).intValue());     // Catch: Throwable -> L436
        goto L434
    L415:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L421;
        Long r101 = Boxing.boxLong(((Number) r76).longValue());     // Catch: Throwable -> L436
        if ((r101 instanceof Integer) == true) goto L419;
        r101 = null;
    L419:
        r77 = (Integer) r101;     // Catch: Throwable -> L436
    L421:
        if ((r76 instanceof JSONObject) == false) goto L423;
    L591:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L429
        Object r102 = SDKSettingsCacheManager.a().fromJson(r76.toString(), Integer.class);     // Catch: Throwable -> L429
        if ((r102 instanceof Integer) == true) goto L427;
        r102 = null;
    L427:
        Object r103 = Result.constructor-impl((Integer) r102);     // Catch: Throwable -> L429
    L431:
        r77 = r103;
        if (Result.isFailure-impl(r77) == false) goto L434;
    L429:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L436
        r103 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L436
        goto L431
    L423:
        if ((r76 instanceof JSONArray) == false) goto L433;
    L393:
        r98 = r76;
        goto L394
    L436:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L542
        r78 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L542
    L542:
        th = move-exception;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L568
        r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L568
        Throwable r107 = Result.exceptionOrNull-impl(r63);     // Catch: Throwable -> L568
        if (r107 == null) goto L547;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L568
    L547:
        if (Result.isFailure-impl(r63) == false) goto L384;
    L552:
        r22 = r1;
        goto L553
    L124:
        if ((r28 instanceof yl.b) == true) goto L126;
        Object r108 = null;
    L127:
        r29 = (yl.b) r108;     // Catch: Throwable -> L172
        if (r29 != null) goto L170;
        if ((r28 instanceof Number) == false) goto L157;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L139;
        Float r109 = Boxing.boxFloat(((Number) r28).floatValue());     // Catch: Throwable -> L172
        if ((r109 instanceof yl.b) == true) goto L137;
        r109 = null;
    L137:
        r29 = (yl.b) r109;     // Catch: Throwable -> L172
        goto L170
    L139:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L145;
        Double r118 = Boxing.boxDouble(((Number) r28).doubleValue());     // Catch: Throwable -> L172
        if ((r118 instanceof yl.b) == true) goto L143;
        r118 = null;
    L143:
        r29 = (yl.b) r118;     // Catch: Throwable -> L172
        goto L170
    L145:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L151;
        Integer r119 = Boxing.boxInt(((Number) r28).intValue());     // Catch: Throwable -> L172
        if ((r119 instanceof yl.b) == true) goto L149;
        r119 = null;
    L149:
        r29 = (yl.b) r119;     // Catch: Throwable -> L172
        goto L170
    L151:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L157;
        Long r120 = Boxing.boxLong(((Number) r28).longValue());     // Catch: Throwable -> L172
        if ((r120 instanceof yl.b) == true) goto L155;
        r120 = null;
    L155:
        r29 = (yl.b) r120;     // Catch: Throwable -> L172
    L157:
        if ((r28 instanceof JSONObject) == false) goto L159;
    L585:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L165
        Object r121 = SDKSettingsCacheManager.a().fromJson(r28.toString(), yl.b.class);     // Catch: Throwable -> L165
        if ((r121 instanceof yl.b) == true) goto L163;
        r121 = null;
    L163:
        Object r122 = Result.constructor-impl((yl.b) r121);     // Catch: Throwable -> L165
    L167:
        r29 = r122;
        if (Result.isFailure-impl(r29) == false) goto L170;
    L165:
        th = move-exception;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L172
        r122 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L172
        goto L167
    L159:
        if ((r28 instanceof JSONArray) == false) goto L169;
    L126:
        r108 = r28;
        goto L127
    L172:
        th = move-exception;
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L197
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L197
        goto L174
    L197:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L555
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L555
        Throwable r126 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L555
        if (r126 == null) goto L202;
        EnsureManager.ensureNotReachHere(r126);     // Catch: Throwable -> L117
    L202:
        if (Result.isFailure-impl(r32) == false) goto L204;
    L607:
        int r127 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L117
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L107
        goto L557
    L615:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L82
        Object r129 = SDKSettingsCacheManager.b().get(r113);     // Catch: Throwable -> L82
        if (r129 != null) goto L34;
    L32:
        Object r130 = null;
    L80:
        Object r131 = Result.constructor-impl(r130);     // Catch: Throwable -> L82
    L84:
        Throwable r132 = Result.exceptionOrNull-impl(r131);     // Catch: Throwable -> L107
        if (r132 == null) goto L88;
        EnsureManager.ensureNotReachHere(r132);     // Catch: Throwable -> L107
    L88:
        if (Result.isFailure-impl(r131) == false) goto L91;
        r131 = null;
    L91:
        if ((r131 instanceof yl.b) == true) goto L93;
        r131 = null;
    L93:
        r32 = (yl.b) r131;     // Catch: Throwable -> L107
        if (r32 != null) goto L204;
        Object r133 = jj4.a.a(r113, yl.b.class, r111, jj4.b.b.a());     // Catch: Throwable -> L107
        if (r133 != null) goto L100;
        Intrinsics.throwNpe();     // Catch: Throwable -> L107
    L100:
        if ((r133 instanceof yl.b) == true) goto L102;
        r133 = null;
    L102:
        yl.b r134 = (yl.b) r133;     // Catch: Throwable -> L107
        if (r134 != null) goto L105;
        r134 = r111;
    L105:
        r32 = Result.constructor-impl(r134);     // Catch: Throwable -> L107
    L110:
        if (Result.exceptionOrNull-impl(r32) == null) goto L204;
        r32 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r113, yl.b.class, r111);     // Catch: Throwable -> L114
    L115:
        if (r32 != null) goto L204;
    L114:
        r32 = r111;
        goto L115
    L34:
        if ((r129 instanceof yl.b) == true) goto L36;
        Object r135 = null;
    L37:
        r130 = (yl.b) r135;     // Catch: Throwable -> L82
        if (r130 != null) goto L80;
        if ((r129 instanceof Number) == false) goto L67;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L49;
        Float r136 = Boxing.boxFloat(((Number) r129).floatValue());     // Catch: Throwable -> L82
        if ((r136 instanceof yl.b) == true) goto L47;
        r136 = null;
    L47:
        r130 = (yl.b) r136;     // Catch: Throwable -> L82
        goto L80
    L49:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L55;
        Double r137 = Boxing.boxDouble(((Number) r129).doubleValue());     // Catch: Throwable -> L82
        if ((r137 instanceof yl.b) == true) goto L53;
        r137 = null;
    L53:
        r130 = (yl.b) r137;     // Catch: Throwable -> L82
        goto L80
    L55:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L61;
        Integer r138 = Boxing.boxInt(((Number) r129).intValue());     // Catch: Throwable -> L82
        if ((r138 instanceof yl.b) == true) goto L59;
        r138 = null;
    L59:
        r130 = (yl.b) r138;     // Catch: Throwable -> L82
        goto L80
    L61:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(yl.b.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L67;
        Long r139 = Boxing.boxLong(((Number) r129).longValue());     // Catch: Throwable -> L82
        if ((r139 instanceof yl.b) == true) goto L65;
        r139 = null;
    L65:
        r130 = (yl.b) r139;     // Catch: Throwable -> L82
    L67:
        if ((r129 instanceof JSONObject) == false) goto L69;
    L589:
        Object r140 = SDKSettingsCacheManager.a().fromJson(r129.toString(), yl.b.class);     // Catch: Throwable -> L75
        if ((r140 instanceof yl.b) == true) goto L73;
        r140 = null;
    L73:
        Object r141 = Result.constructor-impl((yl.b) r140);     // Catch: Throwable -> L75
    L77:
        r130 = r141;
        if (Result.isFailure-impl(r130) == false) goto L80;
    L75:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L82
        r141 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L82
        goto L77
    L69:
        if ((r129 instanceof JSONArray) == false) goto L32;
    L36:
        r135 = r129;
        goto L37
    L82:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L107
        r131 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L117
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L117
    L555:
        r22 = r1;
        goto L558
    L562:
        ECImageMainHandlerOpt$onInitConfig$1 r210 = r1;
        e = new yl.b(new ArrayList(r110));
        if (r19.isEmpty() == true) goto L567;
        r17 = r17 + 1;
        r1 = r210;
        r13 = 0;
        r14 = 0;
        r15 = 1;
    L15:
        if (r17 >= r16) goto L567;
        long r145 = r18[r17].longValue();
        if (r145 <= r13) goto L21;
        r1.L$0 = r111;
        r1.L$1 = r110;
        r1.L$2 = r19;
        r1.L$3 = r18;
        r1.I$0 = r17;
        r1.I$1 = r16;
        r1.label = r15;
        if (DelayKt.delay(r145, r1) != r11) goto L21;
        return r11;
    L567:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        yl.b r146 = new yl.b(0);
        ArrayList r147 = new ArrayList();
        ArrayList r148 = new ArrayList(r20);
        r111 = r146;
        r110 = r147;
        r18 = new Long[]{Boxing.boxLong(0), Boxing.boxLong(2000), Boxing.boxLong(4000), Boxing.boxLong(8000), Boxing.boxLong(12000), Boxing.boxLong(24000)};
        r16 = 6;
        r19 = r148;
        r17 = 0;
    L7:
        r1 = new ECImageMainHandlerOpt$onInitConfig$1(this, r21);
        goto L8
    }
}
