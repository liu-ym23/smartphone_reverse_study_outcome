package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.util.LruCache;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.opt.DeviceScore;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/ImageMonitor;", "Landroidx/lifecycle/LifecycleObserver;", "", "onForeground", "onBackground", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageMonitor implements LifecycleObserver {
    public static Point a;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final AtomicBoolean d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final ImageMonitor g = null;

    public static final class a {
        public final long a;
        public long b;

        public a(long r1) {
            this.a = r1;
            this.b = -1;
        }
    }

    private ImageMonitor() {
    }

    public static long e() {
        return ((Number) b.getValue()).longValue();
    }

    static {
        g = new ImageMonitor();
        b = LazyKt.lazy(ImageMonitor$thresholdLargeImageMemorySize$2.INSTANCE);
        c = LazyKt.lazy(ImageMonitor$requestedImages$2.INSTANCE);
        d = new AtomicBoolean(false);
        e = LazyKt.lazy(ImageMonitor$calculateBackgroundDurationEnable$2.INSTANCE);
        f = LazyKt.lazy(ImageMonitor$backgroundTimeRanges$2.INSTANCE);
    }

    public static boolean c() {
        if (ECAppInfoService.e.isLocalTest() == false) goto L5;
    L8:
        return true;
    L5:
        if (((int) (Math.random() * ((double) 100))) < ((int) (((Number) ImageSettings.n.getValue()).floatValue() * 100))) goto L8;
        return false;
    }

    public final Point j() {
        if (a != null) goto L10;
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 == null) goto L7;
        Point r1 = com.bytedance.android.ec.core.utils.l0.f(r0);
    L8:
        a = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onBackground() {
        Lazy r0 = f;
        if (((LinkedList) r0.getValue()).size() < ((Number) ImageSettings.m.getValue()).intValue()) goto L5;
        ((LinkedList) r0.getValue()).removeFirst();
    L5:
        ((LinkedList) r0.getValue()).addLast(new a(SystemClock.elapsedRealtime()));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onForeground() {
        a r0 = (a) ((LinkedList) f.getValue()).peekLast();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b != (-1)) goto L9;
        r0.b = SystemClock.elapsedRealtime();
        return;
    }

    public static long a(LongRange r13) {
        Iterator r0 = ((LinkedList) f.getValue()).iterator();
        long r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L59;
        a r11 = (a) r0.next();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "range");
        if (r13.getLast() <= r13.getFirst()) goto L57;
        boolean r12 = true;
        if (r13.getLast() <= r13.getFirst()) goto L18;
        long r14 = r11.b;
        long r15 = r11.a;
        if (r14 <= r15) goto L18;
        if (r15 < r13.getFirst()) goto L18;
        if (r11.b > r13.getLast()) goto L18;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L22;
        long r17 = r11.b;
        long r18 = r11.a;
    L56:
        long r19 = r17 - r18;
    L58:
        r10 = r10 + r19;
        goto L4
    L22:
        if (r13.getLast() <= r13.getFirst()) goto L31;
        long r20 = r11.b;
        long r21 = r11.a;
        if (r20 <= r21) goto L31;
        if (r21 > r13.getFirst()) goto L31;
        if (r11.b < r13.getLast()) goto L31;
    L32:
        if (r12 == false) goto L34;
        r17 = r13.getLast();
        r18 = r13.getFirst();
        goto L56
    L34:
        long r22 = r11.a;
        long r23 = r11.b;
        long r110 = r13.getFirst();
        if (r22 <= r110) goto L38;
    L40:
        long r24 = r11.a;
        long r25 = r11.b;
        long r111 = r13.getLast();
        if (r24 > r111) goto L47;
        if (r25 < r111) goto L47;
        r17 = r13.getLast();
        r18 = r11.a;
    L47:
        if (r11.a <= 0) goto L57;
        if (r11.b > 0) goto L57;
        if (r13.getFirst() <= r11.a) goto L54;
        r17 = r13.getLast();
        r18 = r13.getFirst();
        goto L56
    L54:
        if (r13.getLast() <= r11.a) goto L57;
        r17 = r13.getLast();
        r18 = r11.a;
        goto L56
    L38:
        if (r23 < r110) goto L40;
        r17 = r11.b;
        r18 = r13.getFirst();
    L31:
        r12 = false;
    L18:
        r16 = false;
    L57:
        r19 = 0;
        goto L58
    L59:
        return r10;
    }

    public static JSONObject b(JSONObject r10) {
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r11 = r1.next();
        Object r12 = r10.opt(r11);
        if (r12 == null) goto L4;
        r0.put(r11, r12);
        goto L4
    L8:
        return r0;
    }

    public static long d(JSONObject r10) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        long r11 = r10.optLong("producer_start", -1);
        long r12 = r10.optLong("producer_end", -1);
        if (r11 >= 0) goto L8;
    L11:
        return -1;
    L8:
        if (r12 < 0) goto L11;
        return r12 - r11;
    }

    public static boolean f(Uri r1) {
        if (r1 == null) goto L9;
        String r10 = r1.getPath();
        if (r10 == null) goto L9;
        if (((LruCache) c.getValue()).get(r10) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static void g(Uri r10) {
        if (r10 == null) goto L8;
        String r11 = r10.getPath();
        if (r11 == null) goto L9;
        ((LruCache) c.getValue()).put(r11, "1");
        return;
    L9:
        return;
    }

    public static void i(String r1, Map r10) {
        if (StringsKt.isBlank(r1) == false) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L10;
        EnsureManager.ensureNotReachHere(r1, r10);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(ImageRequest r42, r r43, JSONObject r44, boolean r45, boolean r46, boolean r47) {
        m0.c("ImageMonitorHook.report()");
        if (((Boolean) e.getValue()).booleanValue() == false) goto L8;
        if (d.compareAndSet(false, true) == false) goto L8;
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    L8:
        if (r45 == true) goto L11;
        if (r47 == true) goto L11;
        boolean r14 = true;
    L12:
        boolean r15 = !r46;
        if (r42 == null) goto L15;
        Uri r10 = r42.getSourceUri();
    L16:
        String r11 = String.valueOf(r10);
        if (StringsKt.startsWith$default(r11, "res:///", false, 2, null) == false) goto L19;
        return;
    L19:
        boolean r12 = r43 instanceof u;
        if (r12 == true) goto L22;
        r r0 = null;
    L23:
        u r1 = (u) r0;
        if (r1 != null) goto L26;
    L28:
        boolean r13 = false;
    L29:
        if (r42 == null) goto L33;
        Map r16 = r42.getCustomParam();
        if (r16 == null) goto L33;
        String r17 = (String) r16.get("ec_use_multi_image_size_cache");
    L34:
        boolean r18 = Intrinsics.areEqual(r17, "1");
        if (r18 == false) goto L38;
        if (r45 == true) goto L38;
        boolean r19 = false;
    L39:
        if (r42 == null) goto L43;
        Map r20 = r42.getCustomParam();
        if (r20 == null) goto L43;
        String r21 = (String) r20.get("use_image_cache_weak_net");
    L45:
        if (Intrinsics.areEqual(r21, "1") == false) goto L49;
        if (r19 == false) goto L49;
        if (r45 == true) goto L49;
        boolean r22 = false;
    L50:
        if (r13 == true) goto L57;
        if (r15 == true) goto L55;
        if (r45 == false) goto L55;
    L56:
        boolean r23 = true;
    L58:
        if (r23 == false) goto L61;
        if (r45 == false) goto L61;
        g(r10);
    L61:
        if (r23 == true) goto L66;
        if (r15 == false) goto L66;
        if (c() == true) goto L66;
        return;
    L66:
        if (r44 == null) goto L70;
        Object r24 = r44.opt("applied_image_size");
        if (r24 == null) goto L70;
        String r110 = r24.toString();
    L72:
        if (r44 == null) goto L74;
        Object r25 = r44.opt("image_count");
    L76:
        if ((r25 instanceof Number) == true) goto L78;
        r25 = null;
    L78:
        Number r26 = (Number) r25;
        if (r26 == null) goto L81;
        int r111 = r26.intValue();
    L82:
        if (r44 == null) goto L84;
        Object r27 = r44.opt("net_timing_detail");
    L86:
        if ((r27 instanceof JSONObject) == true) goto L88;
        r27 = null;
    L88:
        JSONObject r112 = (JSONObject) r27;
        if (r44 == null) goto L91;
        Object r28 = r44.opt("download_duration");
    L93:
        if ((r28 instanceof Number) == true) goto L95;
        r28 = null;
    L95:
        Number r29 = (Number) r28;
        long r210 = -1;
        if (r29 == null) goto L98;
        long r30 = r29.longValue();
    L99:
        JSONObject r31 = new JSONObject();
        if (r43 == null) goto L103;
        String r32 = r43.getBizTag();
        if (r32 == null) goto L103;
    L104:
        r31.put("biz_tag", r32);
        String r33 = "unknown";
        if (r43 == null) goto L111;
        String r211 = r43.a();
        if (r211 == null) goto L111;
        r33 = r211;
    L111:
        r31.put("scene_tag", r33);
        if (r43 == null) goto L117;
        String r34 = r43.d();
        if (r34 == null) goto L117;
    L118:
        r31.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r34);
        if (r10 == null) goto L121;
        String r35 = r10.getHost();
    L122:
        r31.put("host", r35);
        if (r10 == null) goto L129;
        String r36 = j1.c(r10, "biz_tag");
        if (r36 == null) goto L129;
        String r37 = a2.d(r36);
        if (r37 == null) goto L129;
        r31.put("url_biz", r37);
    L129:
        if (r10 == null) goto L967;
        String r38 = j1.c(r10, "scene_tag");
        if (r38 == null) goto L967;
        String r39 = a2.d(r38);
        if (r39 == null) goto L967;
        r31.put("url_scene", r39);
    L967:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L160
        if (r10 == null) goto L138;
        String r41 = r10.getPath();     // Catch: Throwable -> L160
    L139:
        if (r41 != null) goto L141;
    L144:
        boolean r48 = true;
    L145:
        if (r48 == false) goto L147;
    L157:
        CharSequence r49 = null;
    L158:
        Object r50 = Result.constructor-impl(r49);     // Catch: Throwable -> L160
    L163:
        if (Result.isFailure-impl(r50) == false) goto L165;
        r50 = null;
    L165:
        CharSequence r51 = (CharSequence) r50;
        r31.put("template", r51);
        if (r51 != null) goto L973;
    L180:
        String r52 = null;
    L181:
        Object r53 = Result.constructor-impl(r52);     // Catch: Throwable -> L178
    L185:
        if (Result.isFailure-impl(r53) == false) goto L187;
        r53 = null;
    L187:
        String r54 = (String) r53;
        if (r54 == null) goto L192;
        int r55 = 1;
        if ((!StringsKt.isBlank(r54)) == true) goto L194;
    L193:
        r54 = null;
    L194:
        r31.put("service_id", r54);
        if (r111 <= r55) goto L197;
        boolean r56 = true;
    L198:
        r31.put("is_animated_image", r56);
        r31.put(com.bytedance.android.ec.core.event.a.KEY_IS_SUCCESS, r45);
        r31.put("is_cancel", r47);
        r31.put("from_cache", r15);
        r31.put("is_preload", r13);
        r31.put("first_request", r23);
        if (((Boolean) ImageSettings.f.getValue()).booleanValue() == false) goto L207;
        if (r12 == true) goto L202;
        r r57 = null;
    L203:
        u r58 = (u) r57;
        if (r58 == null) goto L206;
        boolean r59 = r58.x();
    L211:
        r31.put("is_transformed", r59);
        if (r43 == null) goto L214;
        String r60 = r43.e();
    L215:
        r31.put("view_type", r60);
        r31.put("ec_default_priority", Priority.MEDIUM.ordinal());
        r31.put("is_multi_size_image_cache_request", r18 ? 1 : 0);
        if (r12 == true) goto L218;
        r r61 = null;
    L219:
        u r62 = (u) r61;
        if (r62 == null) goto L224;
        String r63 = r62.o();
        if (r63 == null) goto L224;
        r31.put("load_from", r63);
    L224:
        if (r12 == true) goto L226;
        r r64 = null;
    L227:
        u r65 = (u) r64;
        if (r65 == null) goto L232;
        Integer r66 = r65.q();
        if (r66 == null) goto L232;
        r31.put("ec_priority", r66.intValue());
    L232:
        if (r43 == null) goto L236;
        Object r67 = r43.b("transform_stage");
        if (r67 == null) goto L236;
        r31.put("transform_stage", r67);
    L236:
        if (r43 == null) goto L240;
        Object r68 = r43.b("rules_version");
        if (r68 == null) goto L240;
        r31.put("rules_version", r68);
    L240:
        if (r112 == 0) goto L249;
        JSONObject r69 = r112;
        Object r70 = r69.opt("timing_isSocketReused");
        if (r70 == null) goto L251;
        if ((r70 instanceof Boolean) == true) goto L247;
        r70 = null;
    L247:
        if (r70 == null) goto L251;
        r31.put("socket_reused", r70);
    L251:
        if (r44 == null) goto L255;
        Object r71 = r44.opt("extra_bitmap_config");
        if (r71 == null) goto L255;
        r31.put("extra_bitmap_config", r71);
    L255:
        if (r44 == null) goto L259;
        Object r72 = r44.opt("image_type");
        if (r72 == null) goto L259;
        r31.put("image_type", r72);
    L259:
        if (r43 == null) goto L263;
        Object r73 = r43.b("use_image_sr");
        if (r73 == null) goto L263;
        r31.put("use_image_sr", r73);
    L263:
        if (r43 == null) goto L268;
        Object r74 = r43.b("slow_or_fast_enable_sr");
        if (r74 == null) goto L268;
        r31.put("slow_or_fast_enable_sr", r74);
    L268:
        if (r42 == null) goto L274;
        Map r75 = r42.getCustomParam();
        if (r75 == null) goto L274;
        String r76 = (String) r75.get("use_image_sr_weak_net");
        if (r76 == null) goto L274;
        r31.put("use_image_sr_weak_net", r76);
    L274:
        if (r44 == null) goto L278;
        Object r77 = r44.opt("sr_type");
        if (r77 == null) goto L278;
        r31.put("sr_type", r77);
    L278:
        if (r44 == null) goto L282;
        Object r78 = r44.opt("sr_status");
        if (r78 == null) goto L282;
        r31.put("sr_status", r78);
    L282:
        if (r44 == null) goto L286;
        Object r79 = r44.opt("sr_duration");
        if (r79 == null) goto L286;
        r31.put("sr_duration", r79);
    L286:
        if (r44 == null) goto L290;
        Object r80 = r44.opt("sr_width");
        if (r80 == null) goto L290;
        r31.put("sr_width", r80);
    L290:
        if (r44 == null) goto L294;
        Object r81 = r44.opt("sr_height");
        if (r81 == null) goto L294;
        r31.put("sr_height", r81);
    L294:
        if (r44 == null) goto L298;
        Object r82 = r44.opt("sr_stretch");
        if (r82 == null) goto L298;
        r31.put("sr_stretch", r82);
    L298:
        if (r44 == null) goto L302;
        Object r83 = r44.opt("sr_err");
        if (r83 == null) goto L302;
        r31.put("sr_err", r83);
    L302:
        if (r44 == null) goto L306;
        Object r84 = r44.opt("sr_scale_type");
        if (r84 == null) goto L306;
        r31.put("scale_type", r84);
    L306:
        if (r44 == null) goto L310;
        Object r85 = r44.opt("sr_is_enable_all");
        if (r85 == null) goto L310;
        r31.put("enable_all", r85);
    L310:
        if (r44 == null) goto L314;
        Object r86 = r44.opt("sr_max_width");
        if (r86 == null) goto L314;
        r31.put("sr_max_width", r86);
    L314:
        if (r44 == null) goto L318;
        Object r87 = r44.opt("sr_max_height");
        if (r87 == null) goto L318;
        r31.put("sr_max_height", r87);
    L318:
        if (r44 == null) goto L322;
        Object r88 = r44.opt("hit_cdn_cache");
        if (r88 == null) goto L322;
        r31.put("hit_cdn_cache", r88);
    L322:
        if (r44 == null) goto L326;
        Object r89 = r44.opt("server_ip");
        if (r89 == null) goto L326;
        r31.put("server_ip", r89);
    L326:
        if (r44 == null) goto L330;
        Object r90 = r44.opt("network_quality");
        if (r90 == null) goto L330;
        r31.put("network_quality", r90);
    L330:
        if (r44 == null) goto L335;
        Object r91 = r44.opt("image_sdk_version");
        if (r91 == null) goto L335;
        r31.put("image_sdk_version", r91);
    L335:
        if (r44 == null) goto L339;
        Object r92 = r44.opt("err_code");
        if (r92 == null) goto L339;
        r31.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, r92);
    L339:
        if (r44 == null) goto L343;
        Object r93 = r44.opt("fail_phase");
        if (r93 == null) goto L343;
        r31.put("fail_phase", r93);
    L343:
        if (r43 == null) goto L347;
        Object r94 = r43.b("multi_size_image_reuse_type");
        if (r94 == null) goto L347;
        r31.put("multi_size_image_reuse_type", r94);
    L347:
        if (r43 == null) goto L351;
        Object r95 = r43.b("multi_size_image_reuse_origin");
        if (r95 == null) goto L351;
        r31.put("multi_size_image_reuse_origin", r95);
    L351:
        if (r43 == null) goto L359;
        Map<String, Object> r96 = r43.c();
        if (r96 == null) goto L359;
        Iterator<Map.Entry<String, Object>> r97 = r96.entrySet().iterator();
    L356:
        if (r97.hasNext() == false) goto L358;
        Map.Entry<String, Object> r98 = r97.next();
        r31.put(r98.getKey(), r98.getValue());
        r97 = r97;
        goto L356
    L358:
        Unit r99 = Unit.INSTANCE;
    L359:
        ImageExperiments.G.getClass();
        Iterator r100 = ImageExperiments.b().entrySet().iterator();
    L361:
        if (r100.hasNext() == false) goto L363;
        Map.Entry r101 = (Map.Entry) r100.next();
        r31.put((String) r101.getKey(), ((Number) r101.getValue()).intValue());
        r100 = r100;
        goto L361
    L363:
        JSONObject r102 = new JSONObject();
        if (r45 == false) goto L775;
        String r310 = "err_code";
        double r103 = -1;
        if (r43 == null) goto L368;
        Object r104 = r43.b("ec_local_duration");
        double r212 = r103;
    L370:
        if ((r104 instanceof Number) == true) goto L372;
        r104 = null;
    L372:
        Number r105 = (Number) r104;
        if (r105 == null) goto L375;
        double r106 = r105.doubleValue();
    L376:
        r102.put("ec_local_duration", r106);
        if (r43 == null) goto L379;
        Object r113 = r43.b("ec_local_preload_async_duration");
    L381:
        if ((r113 instanceof Number) == true) goto L383;
        r113 = null;
    L383:
        Number r114 = (Number) r113;
        if (r114 == null) goto L386;
        Double r107 = Double.valueOf(r114.doubleValue());
    L387:
        double r115 = 0;
        if (r106 < r115) goto L393;
        if (r107 == null) goto L393;
        if (r107.doubleValue() <= r115) goto L393;
        r106 = r106 + r107.doubleValue();
    L393:
        r102.put("ec_local_preload_async_duration", r106);
        if (r44 == null) goto L396;
        Object r108 = r44.opt(com.bytedance.android.ec.core.event.a.KEY_DURATION);
    L398:
        if ((r108 instanceof Number) == true) goto L400;
        r108 = null;
    L400:
        Number r109 = (Number) r108;
        if (r109 == null) goto L403;
        double r116 = r109.doubleValue();
    L404:
        r102.put("ec_sdk_duration", r116);
        if (r116 <= r115) goto L407;
        double r117 = RangesKt.coerceAtLeast(r106, r115) + r116;
    L409:
        if (r117 <= r115) goto L411;
        long r118 = (long) r117;
    L412:
        if (r43 == null) goto L414;
        Object r119 = r43.b("ec_local_set_controller_duration");
    L416:
        if ((r119 instanceof Number) == true) goto L418;
        r119 = null;
    L418:
        Number r120 = (Number) r119;
        if (r120 == null) goto L421;
        r102.put("ec_local_set_controller_duration", r120.doubleValue());
    L421:
        if (r43 == null) goto L423;
        Object r121 = r43.b("ec_slice_local_duration");
    L425:
        if ((r121 instanceof Number) == true) goto L427;
        r121 = null;
    L427:
        Number r122 = (Number) r121;
        if (r122 == null) goto L430;
        r102.put("ec_slice_local_duration", r122.doubleValue());
    L430:
        if (r43 == null) goto L432;
        Object r123 = r43.b("ec_local_duration_request");
    L434:
        if ((r123 instanceof Number) == true) goto L436;
        r123 = null;
    L436:
        Number r124 = (Number) r123;
        if (r124 == null) goto L439;
        r102.put("ec_local_duration_request", r124.doubleValue());
    L439:
        if (r43 == null) goto L441;
        Object r125 = r43.b("ec_local_duration_async_build_init");
    L443:
        if ((r125 instanceof Number) == true) goto L445;
        r125 = null;
    L445:
        Number r126 = (Number) r125;
        if (r126 == null) goto L448;
        r102.put("ec_local_duration_async_build_init", r126.doubleValue());
    L448:
        if (r43 == null) goto L450;
        Object r127 = r43.b("ec_local_duration_async_context_init");
    L452:
        if ((r127 instanceof Number) == true) goto L454;
        r127 = null;
    L454:
        Number r128 = (Number) r127;
        if (r128 == null) goto L457;
        r102.put("ec_local_duration_async_context_init", r128.doubleValue());
    L457:
        if (r43 == null) goto L459;
        Object r129 = r43.b("ec_local_duration_load_controller_before");
    L461:
        if ((r129 instanceof Number) == true) goto L463;
        r129 = null;
    L463:
        Number r130 = (Number) r129;
        if (r130 == null) goto L466;
        r102.put("ec_local_duration_load_controller_before", r130.doubleValue());
    L466:
        if (r43 == null) goto L468;
        Object r131 = r43.b("ec_local_duration_load_controller");
    L470:
        if ((r131 instanceof Number) == true) goto L472;
        r131 = null;
    L472:
        Number r132 = (Number) r131;
        if (r132 == null) goto L475;
        r102.put("ec_local_duration_load_controller", r132.doubleValue());
    L475:
        if (r43 == null) goto L477;
        Object r133 = r43.b("ec_local_duration_request_core_build");
    L479:
        if ((r133 instanceof Number) == true) goto L481;
        r133 = null;
    L481:
        Number r134 = (Number) r133;
        if (r134 == null) goto L484;
        r102.put("ec_local_duration_request_core_build", r134.doubleValue());
    L484:
        if (r43 == null) goto L486;
        Object r135 = r43.b("ec_local_duration_request_secondary_build");
    L488:
        if ((r135 instanceof Number) == true) goto L490;
        r135 = null;
    L490:
        Number r136 = (Number) r135;
        if (r136 == null) goto L493;
        r102.put("ec_local_duration_request_secondary_build", r136.doubleValue());
    L493:
        if (r43 == null) goto L495;
        Object r137 = r43.b("ec_local_duration_load_controller_build");
    L497:
        if ((r137 instanceof Number) == true) goto L499;
        r137 = null;
    L499:
        Number r138 = (Number) r137;
        if (r138 == null) goto L502;
        r102.put("ec_local_duration_load_controller_build", r138.doubleValue());
    L502:
        if (r43 == null) goto L504;
        Object r139 = r43.b("ec_local_duration_url_edit");
    L506:
        if ((r139 instanceof Number) == true) goto L508;
        r139 = null;
    L508:
        Number r140 = (Number) r139;
        if (r140 == null) goto L511;
        r102.put("ec_local_duration_url_edit", r140.doubleValue());
    L511:
        if (r43 == null) goto L513;
        Object r141 = r43.b("ec_local_duration_url_parser");
    L515:
        if ((r141 instanceof Number) == true) goto L517;
        r141 = null;
    L517:
        Number r142 = (Number) r141;
        if (r142 == null) goto L520;
        r102.put("ec_local_duration_url_parser", r142.doubleValue());
    L520:
        if (r43 == null) goto L522;
        Object r143 = r43.b("ec_local_duration_url_transform");
    L524:
        if ((r143 instanceof Number) == true) goto L526;
        r143 = null;
    L526:
        Number r144 = (Number) r143;
        if (r144 == null) goto L529;
        r102.put("ec_local_duration_url_transform", r144.doubleValue());
    L529:
        if (r43 == null) goto L531;
        Object r145 = r43.b("ec_local_duration_url_query_build");
    L533:
        if ((r145 instanceof Number) == true) goto L535;
        r145 = null;
    L535:
        Number r146 = (Number) r145;
        if (r146 == null) goto L538;
        r102.put("ec_local_duration_url_query_build", r146.doubleValue());
    L538:
        if (r43 == null) goto L540;
        Object r147 = r43.b("ec_local_duration_url_find_cache");
    L542:
        if ((r147 instanceof Number) == true) goto L544;
        r147 = null;
    L544:
        Number r148 = (Number) r147;
        if (r148 == null) goto L547;
        r102.put("ec_local_duration_url_find_cache", r148.doubleValue());
    L547:
        if (r43 == null) goto L549;
        Object r149 = r43.b("ec_local_duration_url_build");
    L551:
        if ((r149 instanceof Number) == true) goto L553;
        r149 = null;
    L553:
        Number r150 = (Number) r149;
        if (r150 == null) goto L556;
        r102.put("ec_local_duration_url_build", r150.doubleValue());
    L556:
        if (r12 == true) goto L558;
        r r151 = null;
    L559:
        u r152 = (u) r151;
        if (r152 == null) goto L564;
        Boolean r153 = r152.v();
        if (r153 == null) goto L564;
        r102.put("ec_local_duration_url_main_thread", r153.booleanValue());
    L564:
        if (r12 == true) goto L566;
        r r154 = null;
    L567:
        u r155 = (u) r154;
        if (r155 == null) goto L572;
        String r156 = r155.p();
        if (r156 == null) goto L572;
        r102.put("origin_url", r156);
    L572:
        if (r12 == true) goto L574;
        r r157 = null;
    L575:
        u r158 = (u) r157;
        if (r158 == null) goto L580;
        String r159 = r158.l();
        if (r159 == null) goto L580;
        r102.put("edited_url", r159);
    L580:
        if (r12 == true) goto L582;
        r r160 = null;
    L583:
        u r161 = (u) r160;
        if (r161 == null) goto L590;
        com.bytedance.android.shopping.api.image.r r162 = r161.m();
        if (r162 == null) goto L590;
        String r163 = r162.c();
        if (r163 == null) goto L590;
        r102.put("bucket_name", r163);
    L590:
        Double r164 = (Double) DeviceScore.b.getValue();
        if (r164 == null) goto L593;
        r102.put("device_overall_score", r164.doubleValue());
    L593:
        if (r44 == null) goto L595;
        long r165 = r44.optLong("na_mall_card_load_duration");
    L596:
        double r166 = r117 - r165;
        if (r166 < r115) goto L599;
        r117 = r166;
    L599:
        r102.put("ec_biz_duration", r117);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        if (r44 == null) goto L603;
        Object r167 = r44.opt("queue_duration");
        if (r167 == null) goto L603;
    L604:
        r102.put("ec_queue_duration", r167);
        long r213 = r30;
        r102.put("ec_download_duration", r213);
        if (r44 == null) goto L608;
        Object r168 = r44.opt("decode_duration");
        if (r168 == null) goto L608;
    L609:
        r102.put("ec_decode_duration", r168);
        if (r44 == null) goto L612;
        Object r169 = r44.opt("image_monitor_data");
    L614:
        if ((r169 instanceof JSONObject) == true) goto L616;
        r169 = null;
    L616:
        JSONObject r170 = (JSONObject) r169;
        ImageMonitor r171 = g;
        if (r170 == null) goto L619;
        Object r172 = r170.opt("BackgroundThreadHandoffProducer");
    L621:
        if ((r172 instanceof JSONObject) == true) goto L623;
        r172 = null;
    L623:
        r171.getClass();
        r102.put("thread_off_producer_duration", d((JSONObject) r172));
        if (r170 == null) goto L626;
        Object r173 = r170.opt("DiskCacheProducer");
    L628:
        if ((r173 instanceof JSONObject) == true) goto L630;
        r173 = null;
    L630:
        r102.put("disk_cache_producer_duration", d((JSONObject) r173));
        if (r170 == null) goto L634;
        Object r174 = r170.opt("decode_queue_duration");
        if (r174 == null) goto L634;
    L635:
        r102.put("ec_decode_queue_duration", r174);
        boolean r175 = ECServiceManager.a;
        r102.put("ec_first_launch", ((s83.g) ECServiceManager.c(s83.g.class)).c0() ? 1 : 0);
        if (r10 == null) goto L638;
        String r176 = j1.c(r10, "is_from_mall_cache");
    L640:
        if (a2.b(r176) == true) goto L642;
    L644:
        int r177 = 0;
    L645:
        r102.put("ec_from_mall_cache", r177);
        int r178 = r111;
        r102.put("image_count", r178);
        if (r69 == null) goto L695;
        Object r179 = r69.opt("timing_dns");
        if (r179 != null) goto L650;
    L655:
        Object r180 = r69.opt("timing_connect");
        if (r180 != null) goto L658;
    L663:
        Object r181 = r69.opt("timing_ssl");
        if (r181 != null) goto L666;
    L671:
        Object r182 = r69.opt("timing_send");
        if (r182 != null) goto L674;
    L679:
        Object r183 = r69.opt("timing_wait");
        if (r183 != null) goto L682;
    L687:
        Object r184 = r69.opt("timing_receive");
        if (r184 == null) goto L695;
        if ((r184 instanceof Number) == true) goto L693;
        r184 = null;
    L693:
        if (r184 == null) goto L695;
        r102.put("ec_net_receive_duration", r184);
        goto L695
    L682:
        if ((r183 instanceof Number) == true) goto L685;
        r183 = null;
    L685:
        if (r183 == null) goto L687;
        r102.put("ec_net_wait_duration", r183);
        goto L687
    L674:
        if ((r182 instanceof Number) == true) goto L677;
        r182 = null;
    L677:
        if (r182 == null) goto L679;
        r102.put("ec_net_send_duration", r182);
        goto L679
    L666:
        if ((r181 instanceof Number) == true) goto L669;
        r181 = null;
    L669:
        if (r181 == null) goto L671;
        r102.put("ec_net_ssl_duration", r181);
        goto L671
    L658:
        if ((r180 instanceof Number) == true) goto L661;
        r180 = null;
    L661:
        if (r180 == null) goto L663;
        r102.put("ec_net_connect_duration", r180);
        goto L663
    L650:
        if ((r179 instanceof Number) == true) goto L653;
        r179 = null;
    L653:
        if (r179 == null) goto L655;
        r102.put("ec_net_dns_duration", r179);
    L695:
        String r185 = r110;
        r102.put("ec_applied_image_size", r185);
        if (r12 == true) goto L698;
        r r186 = null;
    L699:
        u r187 = (u) r186;
        if (r187 == null) goto L702;
        String r188 = r187.t();
    L703:
        r102.put("ec_intended_image_size", r188);
        Result.Companion r189 = Result.Companion;     // Catch: Throwable -> L716
        if (r185 == null) goto L707;
        List r190 = StringsKt.split$default(r185, new String[]{"x"}, true, 0, 4, null);     // Catch: Throwable -> L716
    L708:
        if (r190 != null) goto L710;
    L713:
        Long r191 = null;
    L714:
        Object r192 = Result.constructor-impl(r191);     // Catch: Throwable -> L716
    L719:
        if (Result.isFailure-impl(r192) == false) goto L721;
        r192 = null;
    L721:
        Long r193 = (Long) r192;
        r102.put("ec_image_pixel", r193);
        if (r44 == null) goto L724;
        Object r194 = r44.opt("file_size");
    L726:
        if ((r194 instanceof Number) == true) goto L728;
        r194 = null;
    L728:
        Number r195 = (Number) r194;
        if (r195 == null) goto L731;
        long r196 = r195.longValue();
    L732:
        r102.put("ec_file_size", r196);
        if (r196 <= 1048576) goto L735;
        boolean r214 = true;
        int r197 = 1;
    L736:
        if (r44 == null) goto L738;
        Object r198 = r44.opt("image_ram_size");
    L739:
        r102.put("ec_image_ram_size", r198);
        if (r193 == null) goto L742;
        long r199 = r193.longValue();
    L743:
        Point r1100 = g.j();
        if (r1100 == null) goto L746;
        long r200 = r1100.x * r1100.y;
    L747:
        if (r12 == true) goto L749;
        r r1101 = null;
    L750:
        u r1102 = (u) r1101;
        if (r1102 == null) goto L753;
        long r201 = r1102.s();
    L754:
        r102.put("ec_image_view_pixel", r201);
        JSONObject r215 = r102;
        JSONObject r1103 = r69;
        long r202 = 2;
        long r203 = r200 * r202;
        if (1 > r203) goto L761;
        if (r199 <= r203) goto L761;
        r197 = r197 | 2;
        r214 = true;
    L761:
        if (r199 > 160000) goto L763;
    L767:
        int r204 = 1;
    L768:
        if (r178 <= r204) goto L774;
        if (r193 == null) goto L772;
        r210 = r193.longValue();
    L772:
        if (((r210 * ((long) r178)) * ((long) 4)) <= e()) goto L774;
        r197 = r197 | 8;
        r210 = r118;
        r214 = true;
        JSONObject r216 = r215;
    L776:
        r31.put("large_image_type", r197);
        JSONObject r205 = new JSONObject();
        if (r10 == null) goto L779;
        r205.put(com.bytedance.android.ec.core.event.a.KEY_URL, r10.toString());
        r205.put("url_path", r10.getPath());
    L779:
        if (r44 == null) goto L783;
        String r206 = r310;
        Object r207 = r44.opt(r206);
        if (r207 == null) goto L783;
        r205.put(r206, r207);
    L783:
        if (r44 == null) goto L788;
        Object r208 = r44.opt("err_desc");
        if (r208 == null) goto L788;
        r205.put("err_desc", r208);
    L788:
        if (r15 == true) goto L796;
        if (r14 == false) goto L791;
    L792:
        if (r1103 == null) goto L796;
        JSONObject r209 = r1103;
        Object r217 = r209.opt("request_log");
        if (r217 == null) goto L798;
        r205.put("request_log", r217);
    L798:
        if (ImageSettings.d() == false) goto L808;
        Iterator<String> r218 = r205.keys();
        if (r218 != null) goto L802;
    L807:
        JSONObject r1104 = null;
    L810:
        if (((Boolean) e.getValue()).booleanValue() == false) goto L820;
        if (r12 == true) goto L813;
        r r219 = null;
    L814:
        u r220 = (u) r219;
        if (r220 == null) goto L817;
        long r221 = r220.r();
    L818:
        r31.put("ec_background_duration", a(new LongRange(r221, r221 + r210)));
        goto L820
    L817:
        r221 = Long.MAX_VALUE;
        goto L818
    L813:
        r219 = r43;
    L820:
        if (r22 == false) goto L822;
        m0.c("ImageMonitorHook.report() monitorEvent ecom_image_monitor");
        int r222 = ECMonitorService.b;
        JSONObject r223 = r216;
        ECMonitorService.a.a("ecom_image_monitor", r31, r223, r1104);
        JSONObject r224 = r223;
    L824:
        if (r18 != true) goto L826;
        int r225 = ECMonitorService.b;
        ECMonitorService.a.a("ecom_image_reuse_cache_opt_monitor", r31, r224, r1104);
    L826:
        Uri r1105 = r10;
        boolean r1106 = r23;
        int r226 = r197;
        JSONObject r1107 = r224;
        ECImageTrackHandler.b.c(r42, r43, r44, r31, r224, r1104);
        if (r1106 == true) goto L831;
        if (r15 == false) goto L831;
        boolean r227 = false;
    L832:
        if (r227 == true) goto L836;
        if (r14 != 0) goto L836;
        String r228 = null;
    L840:
        if (r227 == false) goto L851;
        dm.a.a("IMAGE_MONITOR_INFO").i(r228);
        if (r213 <= 1000) goto L851;
        if (r209 == null) goto L851;
        String r229 = r209.optString("request_log");
        if (r229 == null) goto L851;
        if (r213 <= 3000) goto L849;
        String r230 = "IMAGE_MONITOR_DOWNLOAD_OVER_3S";
    L850:
        dm.a.a(r230).i(r229);
        Unit r231 = Unit.INSTANCE;
        goto L851
    L849:
        r230 = "IMAGE_MONITOR_DOWNLOAD_OVER_1S";
    L851:
        if (r14 == 0) goto L858;
        int r232 = ECMonitorService.b;
        ECMonitorService.a.a("ecom_image_error_monitor", r31, r1107, r1104);
        dm.b.a.a(dm.a.a("IMAGE_MONITOR_ERROR"), r228);
        if (r15 == true) goto L858;
        if (r209 == null) goto L858;
        String r233 = r209.optString("request_log");
        if (r233 == null) goto L858;
        dm.b.a.a(dm.a.a("IMAGE_MONITOR_DOWNLOAD_FAILED"), r233);
        Unit r234 = Unit.INSTANCE;
    L858:
        if (r1105 == null) goto L864;
        String r235 = r1105.getPath();
        if (r235 == null) goto L864;
        String r236 = a2.d(r235);
        if (r236 == null) goto L864;
        Object r237 = ImageSettings.c().get(r236);
    L865:
        if (r237 == null) goto L867;
        boolean r238 = true;
    L868:
        if (r214 == false) goto L963;
        if (r238 == true) goto L963;
        if (r15 == true) goto L963;
        JSONObject r239 = b(r31);
        JSONObject r240 = b(r1107);
        if (r12 == true) goto L874;
        r r241 = null;
    L875:
        u r242 = (u) r241;
        if (r242 == null) goto L975;
        Point r243 = r242.u();
        if (r243 == null) goto L975;
        r240.put("view_width", r243.x);
        r240.put("view_height", r243.y);
    L975:
        Result.Companion r244 = Result.Companion;     // Catch: Throwable -> L896
        if (r185 == null) goto L883;
        List r245 = StringsKt.split$default(r185, new String[]{"x"}, true, 0, 4, null);     // Catch: Throwable -> L896
    L884:
        if (r245 != null) goto L886;
    L891:
        Point r246 = null;
    L892:
        Object r247 = Result.constructor-impl(r246);     // Catch: Throwable -> L894
    L899:
        Object r248 = r247;
        if (Result.isFailure-impl(r248) == false) goto L902;
        r248 = null;
    L902:
        Point r249 = (Point) r248;
        if (r249 == null) goto L905;
        r240.put("image_width", r249.x);
        r240.put("image_height", r249.y);
    L905:
        if (r1104 == null) goto L907;
        g.getClass();
        JSONObject r250 = b(r1104);
    L908:
        int r251 = ECMonitorService.b;
        ECMonitorService.a.a("ecom_large_image_monitor", r239, r240, r250);
        dm.a.b r252 = dm.a.a("IMAGE_MONITOR_LARGE");
        JSONObject r253 = new JSONObject();
        r253.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r239);
        r253.put("metric", r240);
        if (r250 == null) goto L911;
        r253.put("extra", r250);
    L911:
        dm.b.a.a(r252, r253.toString());
        if (r226 == 4) goto L914;
        boolean r254 = true;
    L915:
        if (r254 == false) goto L963;
        LinkedHashMap r255 = new LinkedHashMap();
        Iterator<String> r256 = r239.keys();
    L918:
        if (r256.hasNext() == false) goto L932;
        String r257 = r256.next();
        String r258 = r239.optString(r257, null);
        if (r258 != null) goto L922;
    L925:
        boolean r1108 = true;
    L927:
        if ((!r1108) == true) goto L930;
        r258 = null;
    L930:
        if (r258 == null) goto L918;
        r255.put(r257, r258);
        Unit r259 = Unit.INSTANCE;
        goto L918
    L922:
        if (StringsKt.isBlank(r258) == true) goto L925;
        r1108 = false;
        goto L927
    L932:
        Iterator<String> r260 = r240.keys();
    L934:
        if (r260.hasNext() == false) goto L948;
        String r261 = r260.next();
        String r262 = r240.optString(r261, null);
        if (r262 != null) goto L938;
    L941:
        boolean r1109 = true;
    L943:
        if ((!r1109) == true) goto L946;
        r262 = null;
    L946:
        if (r262 == null) goto L934;
        r255.put(r261, r262);
        Unit r263 = Unit.INSTANCE;
        goto L934
    L938:
        if (StringsKt.isBlank(r262) == true) goto L941;
        r1109 = false;
        goto L943
    L948:
        r255.put("ec_image_url", r11);
        r r264 = r43;
        if (r264 == null) goto L951;
        String r265 = r264.f + '_' + r264.g;
    L952:
        StringBuilder r266 = new StringBuilder("ec_image_large");
        if (r265 != null) goto L955;
    L958:
        boolean r1110 = true;
    L959:
        if (r1110 == true) goto L961;
        String r267 = "_" + r265;
    L962:
        r266.append(r267);
        i(r266.toString(), r255);
    L964:
        if (r12 == false) goto L994;
        UrlModifyConfDowngrade.n.h(r42, r45, r1106, (u) r264);
        return;
    L994:
        return;
    L961:
        r267 = "";
        goto L962
    L955:
        if (StringsKt.isBlank(r265) == true) goto L958;
        r1110 = false;
        goto L959
    L951:
        r265 = null;
        goto L952
    L914:
        r254 = false;
        goto L915
    L907:
        r250 = null;
    L894:
        th = th;
    L898:
        Result.Companion r268 = Result.Companion;
        r247 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L899
    L886:
        if (r245.size() != 2) goto L891;
        r246 = new Point(CastIntegerProtector.parseInt((String) ListProtector.get(r245, 0)), CastIntegerProtector.parseInt((String) ListProtector.get(r245, 1)));     // Catch: Throwable -> L894
        goto L892
    L883:
        r245 = null;
    L896:
        th = th;
        goto L898
    L874:
        r241 = r43;
    L963:
        r264 = r43;
        goto L964
    L867:
        r238 = false;
    L864:
        r237 = null;
    L836:
        JSONObject r269 = new JSONObject();
        r269.put(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY, r31);
        r269.put("metric", r1107);
        if (r1104 == null) goto L839;
        r269.put("extra", r1104);
    L839:
        r228 = r269.toString();
    L831:
        r227 = true;
        goto L832
    L822:
        r224 = r216;
    L802:
        if (r218.hasNext() == false) goto L806;
        String r270 = r218.next();
        Object r271 = r205.opt(r270);
        if (r271 == null) goto L802;
        r31.put("extra_" + r270, r271);
        Unit r272 = Unit.INSTANCE;
        goto L802
    L806:
        Unit r273 = Unit.INSTANCE;
        goto L807
    L808:
        r1104 = r205;
        goto L810
    L791:
        if (r210 > 8000) goto L792;
    L796:
        r209 = r1103;
    L774:
        r210 = r118;
        r216 = r215;
        goto L776
    L763:
        if (r201 <= 0) goto L767;
        if (r199 <= (r201 * r202)) goto L767;
        r197 = r197 | 4;
        r204 = 1;
        r214 = true;
        goto L768
    L753:
        r201 = -1;
        goto L754
    L749:
        r1101 = r43;
        goto L750
    L746:
        r200 = -1;
        goto L747
    L742:
        r199 = -1;
        goto L743
    L738:
        r198 = null;
        goto L739
    L735:
        r214 = false;
        r197 = 0;
        goto L736
    L731:
        r196 = -1;
        goto L732
    L724:
        r194 = null;
        goto L726
    L710:
        if (r190.size() != 2) goto L713;
        r191 = Long.valueOf(CastLongProtector.parseLong((String) ListProtector.get(r190, 0)) * CastLongProtector.parseLong((String) ListProtector.get(r190, 1)));     // Catch: Throwable -> L716
        goto L714
    L707:
        r190 = null;
    L716:
        th = move-exception;
        Result.Companion r274 = Result.Companion;
        r192 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L719
    L702:
        r188 = null;
        goto L703
    L698:
        r186 = r43;
        goto L699
    L642:
        if (Intrinsics.areEqual(r176, "1") == false) goto L644;
        r177 = 1;
        goto L645
    L638:
        r176 = null;
    L634:
        r174 = -1;
        goto L635
    L626:
        r173 = null;
        goto L628
    L619:
        r172 = null;
        goto L621
    L612:
        r169 = null;
    L608:
        r168 = -1;
    L603:
        r167 = -1;
        goto L604
    L595:
        r165 = 0;
        goto L596
    L582:
        r160 = r43;
        goto L583
    L574:
        r157 = r43;
        goto L575
    L566:
        r154 = r43;
        goto L567
    L558:
        r151 = r43;
        goto L559
    L549:
        r149 = null;
        goto L551
    L540:
        r147 = null;
        goto L542
    L531:
        r145 = null;
        goto L533
    L522:
        r143 = null;
        goto L524
    L513:
        r141 = null;
        goto L515
    L504:
        r139 = null;
        goto L506
    L495:
        r137 = null;
        goto L497
    L486:
        r135 = null;
        goto L488
    L477:
        r133 = null;
        goto L479
    L468:
        r131 = null;
        goto L470
    L459:
        r129 = null;
        goto L461
    L450:
        r127 = null;
        goto L452
    L441:
        r125 = null;
        goto L443
    L432:
        r123 = null;
        goto L434
    L423:
        r121 = null;
        goto L425
    L414:
        r119 = null;
        goto L416
    L411:
        r118 = -1;
        goto L412
    L407:
        r117 = r212;
        goto L409
    L403:
        r116 = r212;
        goto L404
    L396:
        r108 = null;
        goto L398
    L386:
        r107 = null;
        goto L387
    L379:
        r113 = null;
        goto L381
    L375:
        r106 = r212;
        goto L376
    L368:
        r212 = r103;
        r104 = null;
        goto L370
    L775:
        r310 = "err_code";
        r12 = r12;
        r23 = r23;
        r216 = r102;
        r1103 = r69;
        r18 = r18 ? 1 : 0;
        r15 = r15;
        r185 = r110;
        r213 = r30;
        r197 = 0;
        r214 = false;
        goto L776
    L249:
        r69 = r112;
        goto L251
    L226:
        r64 = r43;
        goto L227
    L218:
        r61 = r43;
        goto L219
    L214:
        r60 = null;
        goto L215
    L206:
        r59 = false;
        goto L211
    L202:
        r57 = r43;
        goto L203
    L207:
        if (r10 == null) goto L209;
        String r275 = j1.c(r10, "iesec_transformed");
    L210:
        r59 = Intrinsics.areEqual(r275, "1");
        goto L211
    L209:
        r275 = null;
        goto L210
    L197:
        r56 = false;
        goto L198
    L192:
        r55 = 1;
    L178:
        th = move-exception;
        Result.Companion r276 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L185
    L973:
        List r277 = StringsKt.split$default(r51, new String[]{"-"}, false, 0, 6, null);     // Catch: Throwable -> L178
        if (r277 == null) goto L180;
        if (r277.size() < 2) goto L172;
        boolean r278 = true;
    L173:
        if (r278 == true) goto L176;
        r277 = null;
    L176:
        if (r277 == null) goto L180;
        r52 = (String) ListProtector.get(r277, 1);     // Catch: Throwable -> L178
        goto L181
    L172:
        r278 = false;
        goto L173
    L147:
        if (r41 == null) goto L157;
        Integer r279 = Integer.valueOf(StringsKt.indexOf$default(r41, "~tplv-", 0, false, 6, null));     // Catch: Throwable -> L160
        if (r279.intValue() < 0) goto L151;
        boolean r280 = true;
    L152:
        if (r280 == true) goto L155;
        r279 = null;
    L155:
        if (r279 == null) goto L157;
        r49 = r41.subSequence(r279.intValue(), r41.length());     // Catch: Throwable -> L160
        goto L158
    L151:
        r280 = false;
        goto L152
    L141:
        if (StringsKt.isBlank(r41) == true) goto L144;
        r48 = false;
        goto L145
    L138:
        r41 = null;
    L160:
        th = move-exception;
        Result.Companion r281 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L163
    L121:
        r35 = null;
    L117:
        r34 = "unknown";
    L103:
        r32 = "ec_default";
        goto L104
    L98:
        r30 = -1;
        goto L99
    L91:
        r28 = null;
        goto L93
    L84:
        r27 = null;
        goto L86
    L81:
        r111 = -1;
        goto L82
    L74:
        r25 = null;
    L70:
        r110 = null;
    L55:
        if (f(r10) == false) goto L56;
    L57:
        r23 = false;
    L49:
        r22 = r19;
    L43:
        r21 = null;
    L38:
        r19 = true;
    L33:
        r17 = null;
        goto L34
    L26:
        if (r1.w() != true) goto L28;
        r13 = true;
        goto L29
    L22:
        r0 = r43;
        goto L23
    L15:
        r10 = null;
    L11:
        r14 = false;
        goto L12
    }
}
