package com.obric.aiagent.product.feature.b;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crypto.platform.PlatformConst;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.platform.a.c;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.feature.FeatureConfig;
import com.obric.aiagent.product.feature.FeatureListConfig;
import com.obric.aiagent.product.feature.ProductInfoConfig;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import com.obric.aiagent.product.feature.bean.FeatureConfigWrap;
import com.obric.aiagent.product.feature.bean.FeatureStateConfigItem;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0006H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0016J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060-2\u0006\u0010*\u001a\u00020\u0006H\u0016J\u001a\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0012\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0006H\u0002J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\b\u00109\u001a\u00020\u000eH\u0016J\b\u0010:\u001a\u00020\u000eH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d¨\u0006<"}, d2 = {"Lcom/obric/aiagent/product/feature/impl/FeatureServiceImpl;", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "<init>", "()V", "productMap", "", "", "Lcom/obric/aiagent/product/feature/ProductInfoConfig;", "Lcom/obric/aiagent/product/feature/ProductInfoMap;", "featureListConfigBoolean", "Lcom/obric/aiagent/product/feature/FeatureListConfig;", "featureListConfigSingle", "featureListConfigGroup", "obricOs", "", "getObricOs", "()Z", "obricOs$delegate", "Lkotlin/Lazy;", "emulatorOs", "getEmulatorOs", "emulatorOs$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "osProductName", "getOsProductName", "()Ljava/lang/String;", "osProductName$delegate", "getJsonFromAssets", "Lorg/json/JSONObject;", "fileName", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "initFeatureInfo", "initFeatureInfoV2", "initProductInfo", "destroy", "isObricFeatureEnable", "isFeatureEnable", "featureKey", "getFeatureState", "getFeatureStateList", "", "mergeDefaultAndCloudConfig", "cloudSettingKey", "isCurConfigMatch", "item", "Lcom/obric/aiagent/product/feature/bean/FeatureStateConfigItem;", "convertVersionStringToInt", "", "version", "appVariant", "getObricProductName", "isObricOs", "isEmulatorOs", "isGlobalEffectStopLayerEffective", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.aiagent.product.feature.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0245a f5977b = null;
    private static final Lazy<a> k = null;
    private Map<String, ProductInfoConfig> c;
    private FeatureListConfig d;
    private FeatureListConfig e;
    private FeatureListConfig f;
    private final Lazy g;
    private final Lazy h;
    private final Lazy i;
    private final Lazy j;

    /* JADX INFO: renamed from: com.obric.aiagent.product.feature.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/product/feature/impl/FeatureServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_FEATURE_FILE_NAME", "DEFAULT_PRODUCT_FILE_NAME", "DEFAULT_FEATURE_FILE_NAME_SINGLE", "DEFAULT_FEATURE_FILE_NAME_GROUP", "OBRIC_PREFIX", "FEATURE_GLOBAL_EFFECT_STOP_LAYER_EFFECTIVE", "DEFAULT_IS_OBRIC", "", "instance", "Lcom/obric/aiagent/product/feature/impl/FeatureServiceImpl;", "getInstance", "()Lcom/obric/aiagent/product/feature/impl/FeatureServiceImpl;", "instance$delegate", "Lkotlin/Lazy;", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0245a {
        private C0245a() {
        }

        public /* synthetic */ C0245a(DefaultConstructorMarker r1) {
            this();
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.j().getValue(), a.class, "com.obric.memorydata.plugin");
        }

        public final synchronized com.obric.aiagent.product.feature.a.a a() {
            monitor-enter(this);
            com.obric.aiagent.product.feature.a.a r0 = (com.obric.aiagent.product.feature.a.a) ZeusTransformUtils.preCheckCast(b(), com.obric.aiagent.product.feature.a.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/obric/aiagent/product/feature/impl/FeatureServiceImpl$initProductInfo$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/obric/aiagent/product/feature/ProductInfoConfig;", "Lcom/obric/aiagent/product/feature/ProductInfoMap;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends ProductInfoConfig>> {
        b() {
        }
    }

    static {
        f5977b = new C0245a(null);
        k = LazyKt.lazy($$Lambda$a$ye2_d0Smbay7zVpPMbQVo7BzDh8.INSTANCE);
    }

    public a() {
        this.c = MapsKt.emptyMap();
        this.g = LazyKt.lazy($$Lambda$a$nuPsgMczCzikNGOrTzjywDY4Mrg.INSTANCE);
        this.h = LazyKt.lazy($$Lambda$a$mfRS0qkw5zy4rxQObNMdlffphg8.INSTANCE);
        this.i = LazyKt.lazy($$Lambda$a$ij3RrCoh40_yZJaMTTmbfDwB3Ec.INSTANCE);
        this.j = LazyKt.lazy($$Lambda$a$PB_OaaDbHB0IkKyvksTOMXFVBEY.INSTANCE);
    }

    private final FeatureListConfig a(String r10, String r11) {
        d.f5954a.b("FeatureServiceImpl", "merge default and cloud config");
        FeatureListConfig r1 = null;
        Gson r3 = new Gson();     // Catch: Exception -> L18
        JSONObject r9 = d(r10);     // Catch: Exception -> L18
        if (r9 != null) goto L6;
        r9 = new JSONObject();     // Catch: Exception -> L18
    L6:
        FeatureListConfig r12 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r3.fromJson(r9.toString(), FeatureListConfig.class), FeatureListConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        d.f5954a.b("FeatureServiceImpl", "merge default and cloud config, defaultJsonStr: " + r9);     // Catch: Exception -> L18
        JSONObject r13 = c.f5952a.a(r11);     // Catch: Exception -> L18
        FeatureListConfig r14 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r3.fromJson(String.valueOf(r13), FeatureListConfig.class), FeatureListConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        d.f5954a.b("FeatureServiceImpl", "merge default and cloud config, cloudJsonStr: " + r13);     // Catch: Exception -> L18
        boolean r15 = false;
        if (r14 == null) goto L13;
        Map<String, FeatureConfigWrap> r4 = r14.getFeatureConfigWraps();     // Catch: Exception -> L18
        if (r4 == null) goto L13;
        if ((!r4.isEmpty()) != true) goto L13;
        r15 = true;
    L13:
        if (r15 == false) goto L15;
        r1 = new FeatureListConfig(r14.getVersion(), null, MapsKt.plus(r12.getFeatureConfigWraps(), r14.getFeatureConfigWraps()), 2, null);     // Catch: Exception -> L18
    L16:
        d.f5954a.b("FeatureServiceImpl", "merge default and cloud config, merge result: " + r1);     // Catch: Exception -> L18
    L20:
        return r1;
    L15:
        r1 = r12;
    L18:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "merge default and cloud config failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L20
    }

    private final boolean a(FeatureStateConfigItem r15) {
        if (r15 != null) goto L43;
        return false;
    L43:
        String r14 = c();     // Catch: Exception -> L40
        if (r15.getProductList().contains(r14) == false) goto L8;
        return true;
    L8:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r15.getProductSpecialList().get(r14), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L40
        if (r16 != null) goto L11;
        return false;
    L11:
        d.f5954a.b("FeatureServiceImpl", "isCurConfigMatch, productSpecialConfig: " + r16);     // Catch: Exception -> L40
        ProductSpecialConfig r17 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r16.get(Build.MODEL), ProductSpecialConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L40
        if (r17 != null) goto L14;
        return false;
    L14:
        d.f5954a.b("FeatureServiceImpl", "isCurConfigMatch, model: " + Build.MODEL + ", modelSpecialConfig: " + r17);     // Catch: Exception -> L40
        String r3 = r17.getMinRomVersion();     // Catch: Exception -> L40
        String r5 = r17.getMaxRomVersion();     // Catch: Exception -> L40
        String r6 = RomInfo.INSTANCE.getShortOSVersion();     // Catch: Exception -> L40
        long r7 = com.obric.aiagent.product.a.b.f5965a.d(r6);     // Catch: Exception -> L40
        long r9 = com.obric.aiagent.product.a.b.f5965a.d(r3);     // Catch: Exception -> L40
        long r11 = com.obric.aiagent.product.a.b.f5965a.d(r5);     // Catch: Exception -> L40
        d.f5954a.b("FeatureServiceImpl", "isCurConfigMatch, osVersion: " + r6 + ", osVersionLong: " + r7 + ", minRomVersionLong: " + r9 + ", maxRomVersionLong: " + r11);     // Catch: Exception -> L40
        if (r17.getRomVersionBlackList().contains(r6) == false) goto L17;
    L39:
        return false;
    L17:
        if (r9 <= 0) goto L21;
        if (r7 < r9) goto L39;
    L21:
        if (r11 > 0) goto L23;
    L25:
        int r4 = RomInfo.INSTANCE.getOSReleaseDate();     // Catch: Exception -> L40
        long r8 = r17.getMinRomReleaseDate();     // Catch: Exception -> L40
        long r10 = r17.getMaxRomReleaseDate();     // Catch: Exception -> L40
        d.f5954a.b("FeatureServiceImpl", "isCurConfigMatch, osReleaseDate: " + r4 + ", minRomReleaseDate: " + r8 + ", maxRomReleaseDate: " + r10);     // Catch: Exception -> L40
        if (r8 <= 0) goto L31;
        if (r4 >= r8) goto L31;
    L37:
        return false;
    L31:
        if (1 <= r10) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == true) goto L37;
        return true;
    L33:
        if (r10 >= r4) goto L35;
        r18 = true;
        goto L36
    L23:
        if (r7 <= r11) goto L25;
    L40:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "isCurConfigMatch failed, item = " + r15, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final JSONObject d(String r4) {
        InputStream r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getAssets().open(r4);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r3, "open(...)");     // Catch: Throwable -> L16
        Reader r5 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r3, Charsets.UTF_8), Reader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r5, BufferedReader.class) == false) goto L6;
        BufferedReader r6 = (BufferedReader) ZeusTransformUtils.preCheckCast(r5, BufferedReader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L7:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r8 = TextStreamsKt.readText((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r7, BufferedReader.class, "com.obric.memorydata.plugin"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L16
        return new JSONObject(r8);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L6:
        r6 = new BufferedReader(r5, 8192);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        d.f5954a.b("FeatureServiceImpl", "load settings failed", th);
        return null;
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.i.getValue(), Context.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Lazy j() {
        return k;
    }

    private final boolean k() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.g.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final String l() {
        return (String) ZeusTransformUtils.preCheckCast(this.j.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ String lambda$PB_OaaDbHB0IkKyvksTOMXFVBEY() {
        return p();
    }

    public static /* synthetic */ Context lambda$ij3RrCoh40_yZJaMTTmbfDwB3Ec() {
        return o();
    }

    public static /* synthetic */ boolean lambda$mfRS0qkw5zy4rxQObNMdlffphg8() {
        return n();
    }

    public static /* synthetic */ boolean lambda$nuPsgMczCzikNGOrTzjywDY4Mrg() {
        return m();
    }

    public static /* synthetic */ a lambda$ye2_d0Smbay7zVpPMbQVo7BzDh8() {
        return q();
    }

    private static final boolean m() {
        String r3 = com.obric.aiagent.product.a.c.f5967a.a("ro.system_ext.o_product.type", "unknown");     // Catch: Exception -> L9
        if (Intrinsics.areEqual(r3, "unknown") == false) goto L6;
        r3 = com.obric.aiagent.product.a.c.f5967a.a(PlatformConst.PROP_PRODUCT_TYPE, "unknown");     // Catch: Exception -> L9
        Intrinsics.areEqual(r3, "unknown");     // Catch: Exception -> L9
        boolean r1 = true;
    L7:
        d.f5954a.b("FeatureServiceImpl", "obricOs init: " + r3 + ", obricOS: " + r1);     // Catch: Exception -> L9
        return r1;
    L6:
        r1 = false;
    L9:
        e = move-exception;
        d.f5954a.a("FeatureServiceImpl", "obricOS init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return true;
    }

    private static final boolean n() {
        String r3 = com.obric.aiagent.product.a.c.f5967a.a("ro.system_ext.o_product.type", "unknown");     // Catch: Exception -> L12
        if (Intrinsics.areEqual(r3, "unknown") == false) goto L7;
        r3 = com.obric.aiagent.product.a.c.f5967a.a(PlatformConst.PROP_PRODUCT_TYPE, "unknown");     // Catch: Exception -> L12
    L7:
        if (Intrinsics.areEqual(r3, "emulator") == false) goto L9;
        boolean r1 = true;
    L10:
        d.f5954a.b("FeatureServiceImpl", "emulatorOs init: " + r3 + ", isEmulatorOs: " + r1);     // Catch: Exception -> L12
        return r1;
    L9:
        r1 = false;
    L12:
        e = move-exception;
        d.f5954a.a("FeatureServiceImpl", "emulatorOs init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    private static final Context o() {
        Object r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.aiagent.platform.a.a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = 0;
    L9:
        if (r0 != 0) goto L13;
        r0 = com.obric.aiagent.platform.b.f5959a.a("base");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.Context");
    L13:
        return (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin");
    L5:
        r2 = false;
        goto L6
    }

    private static final String p() {
        String r2 = com.obric.aiagent.product.a.c.f5967a.a("ro.system_ext.o_product.type", "unknown");     // Catch: Exception -> L8
        if (Intrinsics.areEqual(r2, "unknown") == false) goto L6;
        r2 = com.obric.aiagent.product.a.c.f5967a.a(PlatformConst.PROP_PRODUCT_TYPE, "unknown");     // Catch: Exception -> L8
    L6:
        d.f5954a.b("FeatureServiceImpl", "osProductName init: " + r2);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        d.f5954a.a("FeatureServiceImpl", "osProductName init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "unknown";
    }

    private static final a q() {
        return new a();
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public void a() {
        h();
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aiagent.product.feature.a.a
    public boolean a(String r22) {
        Intrinsics.checkNotNullParameter(r22, "featureKey");
        Object r6 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        JSONObject r2 = c.f5952a.a(r22);     // Catch: Throwable -> L11
        if (r2 == null) goto L6;
        String r3 = r2.toString();     // Catch: Throwable -> L11
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        Object r4 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r4);     // Catch: Exception -> L106
        if (r8 == null) goto L18;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r22 + ", ICloudConfig.Companion.getSettingsConfig() failed, " + r8.getMessage(), r8);     // Catch: Exception -> L106
    L18:
        if (Result.m1427isFailureimpl(r4) == false) goto L20;
        r4 = null;
    L20:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L106
        if (r5 != null) goto L23;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L40;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Object r9 = Result.m1421constructorimpl((FeatureConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r5, FeatureConfig.class), FeatureConfig.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L35:
        if (Result.m1427isFailureimpl(r9) == true) goto L38;
        r6 = r9;
    L38:
        FeatureConfig r12 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r6, FeatureConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L106
    L48:
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r22 + ", featureConfig: " + r12);     // Catch: Exception -> L106
        if (r12 != 0) goto L54;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", featureConfig is null");     // Catch: Exception -> L106
        return false;
    L54:
        if (r12.getEnabled() == true) goto L57;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", featureConfig.enabled is false");     // Catch: Exception -> L106
        return false;
    L57:
        String r13 = c();     // Catch: Exception -> L106
        if (r12.getProductWhiteList().contains(r13) == false) goto L62;
        d.f5954a.a("FeatureServiceImpl", "isFeatureEnable return true, featureKey: " + r22 + ", is in productWhiteList, productName: " + r13);     // Catch: Exception -> L106
        return true;
    L62:
        if (r12.getProductBlackList().contains(r13) == false) goto L67;
        d.f5954a.a("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", is in productBlackList, productName: " + r13);     // Catch: Exception -> L106
        return false;
    L67:
        if (com.obric.aiagent.product.a.a.f5964a.a(r12.getDependencyOsFeatureList()) == true) goto L70;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", os is not supported, dependencyOsFeatureList: " + r12.getDependencyOsFeatureList() + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L70:
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(r12.getProductSpecialList().get(r13), Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L106
        if (r14 != null) goto L76;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return defaultState, featureKey: " + r22 + ", defaultState: " + r12.getDefaultState() + ", productName: " + r13);     // Catch: Exception -> L106
        if (Intrinsics.areEqual(r12.getDefaultState(), "enabled") == false) goto L75;
        return true;
    L75:
        return false;
    L76:
        ProductSpecialConfig r15 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r14.get(Build.MODEL), ProductSpecialConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L106
        if (r15 != null) goto L80;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", modelSpecialConfig is null, model: " + Build.MODEL + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L80:
        String r16 = r15.getMinRomVersion();     // Catch: Exception -> L106
        String r17 = r15.getMaxRomVersion();     // Catch: Exception -> L106
        String r18 = RomInfo.INSTANCE.getShortOSVersion();     // Catch: Exception -> L106
        long r19 = com.obric.aiagent.product.a.b.f5965a.d(r18);     // Catch: Exception -> L106
        long r110 = com.obric.aiagent.product.a.b.f5965a.d(r16);     // Catch: Exception -> L106
        long r111 = com.obric.aiagent.product.a.b.f5965a.d(r17);     // Catch: Exception -> L106
        if (r15.getRomVersionBlackList().contains(r18) == false) goto L83;
    L104:
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable return false, featureKey: " + r22 + ", osVersion: " + r18 + " is in romVersionBlackList, model: " + Build.MODEL + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L83:
        if (r110 <= 0) goto L87;
        if (r19 < r110) goto L104;
    L87:
        if (r111 > 0) goto L89;
    L91:
        int r20 = RomInfo.INSTANCE.getOSReleaseDate();     // Catch: Exception -> L106
        long r112 = r15.getMinRomReleaseDate();     // Catch: Exception -> L106
        long r113 = r15.getMaxRomReleaseDate();     // Catch: Exception -> L106
        d.f5954a.a("FeatureServiceImpl", "isFeatureEnable, featureKey: " + r22 + ", osReleaseDate: " + r20 + ", minRomReleaseDate: " + r112 + ", maxRomReleaseDate: " + r113);     // Catch: Exception -> L106
        if (r112 <= 0) goto L96;
        if (r20 >= r112) goto L96;
    L102:
        return false;
    L96:
        if (1 <= r113) goto L98;
    L100:
        boolean r21 = false;
    L101:
        if (r21 == true) goto L102;
        return true;
    L98:
        if (r113 >= r20) goto L100;
        r21 = true;
        goto L101
    L89:
        if (r19 <= r111) goto L91;
    L32:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Exception -> L106
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L106
        goto L35
    L40:
        if (this.d != null) goto L42;
        g();     // Catch: Exception -> L106
    L42:
        FeatureListConfig r24 = this.d;     // Catch: Exception -> L106
        if (r24 == null) goto L47;
        Map<String, FeatureConfig> r25 = r24.getFeatureConfigs();     // Catch: Exception -> L106
        if (r25 == null) goto L47;
        r6 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r25.get(r22), FeatureConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L106
    L47:
        r12 = r6;
        goto L48
    L23:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L25;
        boolean r114 = true;
    L26:
        if (r114 != true) goto L28;
        r10 = true;
        goto L29
    L25:
        r114 = false;
        goto L26
    L6:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Exception -> L106
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L106
    L106:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable failed, featureKey: " + r22, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public String b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "featureKey");
    L27:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable failed, featureKey: " + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    L4:
        if (this.e != null) goto L6;
        this.e = a("default_feature_config_single.json", "obric_feature_config_single");     // Catch: Exception -> L27
        d.f5954a.b("FeatureServiceImpl", "init obric feature v2, feature list config single: " + this.e);     // Catch: Exception -> L27
    L6:
        FeatureListConfig r3 = this.e;     // Catch: Exception -> L27
        if (r3 == null) goto L11;
        Map<String, FeatureConfigWrap> r4 = r3.getFeatureConfigWraps();     // Catch: Exception -> L27
        if (r4 == null) goto L11;
        FeatureConfigWrap r5 = (FeatureConfigWrap) ZeusTransformUtils.preCheckCast(r4.get(r8), FeatureConfigWrap.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
    L12:
        d.f5954a.b("FeatureServiceImpl", "getFeatureState, featureKey: " + r8 + ", featureConfig: " + r5);     // Catch: Exception -> L27
        if (r5 != null) goto L15;
    L26:
        return "";
    L15:
        if (r5.getEnabled() == false) goto L26;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getFeatureStateConfigList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L27
    L19:
        if (r6.hasNext() == false) goto L25;
        FeatureStateConfigItem r7 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r6.next(), FeatureStateConfigItem.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        if (a(r7) == false) goto L19;
        return r7.getState();
    L25:
        return r5.getDefaultState();
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public void b() {
        d.f5954a.b("FeatureServiceImpl", "destroy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    @Override // com.obric.aiagent.product.feature.a.a
    public String c() {
        String r0 = l();
        String r2 = "emulator";
        switch(r0.hashCode()) {
            case -2002884280: goto L28;
            case -2002884275: goto L24;
            case -1048984789: goto L20;
            case -807117175: goto L17;
            case -80147032: goto L13;
            case 3440915: goto L9;
            case 1336193813: goto L6;
            default: goto L259;
        };
    L259:
        r2 = "unknown";
    L32:
        boolean r1 = Intrinsics.areEqual(r2, "nerida");
        ?? r3 = r2;
        if (r1 == false) goto L39;
        r3 = r2;
        if (Build.VERSION.SDK_INT < 31) goto L39;
        r3 = r2;
        if (Intrinsics.areEqual(Build.SOC_MODEL, "SM8845") == false) goto L39;
        r3 = "nerida-lite";
    L39:
        d.f5954a.a("FeatureServiceImpl", "getObricProductName, osProductName=" + l() + ", productName=" + r3);
        if (Intrinsics.areEqual(r3, "unknown") == true) goto L42;
        return r3;
    L42:
        Iterator<Map.Entry<String, ProductInfoConfig>> r15 = this.c.entrySet().iterator();
    L44:
        if (r15.hasNext() == false) goto L227;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        d.b r9 = d.f5954a;
        StringBuilder r10 = new StringBuilder().append("getObricProductName, key: ").append((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")).append(", manufacturer: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer()).append(", brand: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand()).append(", model: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel()).append(", device: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice()).append(" , ");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice(), Collection.class, "com.obric.memorydata.plugin");
        boolean r12 = false;
        if (r11 != null) goto L48;
    L51:
        boolean r13 = true;
    L52:
        StringBuilder r14 = r10.append(r13).append(", name:").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName()).append(", ");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName(), Collection.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L55;
    L58:
        boolean r17 = true;
    L59:
        r9.b("FeatureServiceImpl", r14.append(r17).append(", policy: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getPolicy()).toString());
        if (Intrinsics.areEqual(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getPolicy(), "and") == true) goto L61;
        if (Intrinsics.areEqual(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getPolicy(), "or") == false) goto L44;
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer(), Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L154;
    L157:
        boolean r6 = true;
    L158:
        if (r6 == true) goto L166;
        List<String> r7 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer();
        if (r7 != null) goto L162;
    L164:
        boolean r8 = false;
    L165:
        if (r8 == false) goto L166;
    L225:
        d.f5954a.b("FeatureServiceImpl", "getObricProductName or, key: " + ((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) + ", manufacturer: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer() + ", brand: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand() + ", model: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel() + ", device: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice());
    L226:
        r3 = r4.getKey();
        goto L44
    L162:
        if (r7.contains(Build.MANUFACTURER) != true) goto L164;
        r8 = true;
    L166:
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand(), Collection.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L169;
    L172:
        boolean r19 = true;
    L173:
        if (r19 == true) goto L181;
        List<String> r20 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand();
        if (r20 != null) goto L177;
    L179:
        boolean r21 = false;
    L180:
        if (r21 == true) goto L225;
    L177:
        if (r20.contains(Build.BRAND) != true) goto L179;
        r21 = true;
    L181:
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel(), Collection.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L184;
    L187:
        boolean r23 = true;
    L188:
        if (r23 == true) goto L196;
        List<String> r24 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel();
        if (r24 != null) goto L192;
    L194:
        boolean r25 = false;
    L195:
        if (r25 == true) goto L225;
    L192:
        if (r24.contains(Build.MODEL) != true) goto L194;
        r25 = true;
    L196:
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName(), Collection.class, "com.obric.memorydata.plugin");
        if (r26 != null) goto L199;
    L202:
        boolean r27 = true;
    L203:
        if (r27 == true) goto L211;
        List<String> r28 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName();
        if (r28 != null) goto L207;
    L209:
        boolean r29 = false;
    L210:
        if (r29 == true) goto L225;
    L207:
        if (r28.contains(Build.PRODUCT) != true) goto L209;
        r29 = true;
    L211:
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice(), Collection.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L214;
    L217:
        boolean r31 = true;
    L218:
        if (r31 == true) goto L44;
        List<String> r32 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice();
        if (r32 != null) goto L222;
    L224:
        if (r12 == false) goto L44;
    L222:
        if (r32.contains(Build.DEVICE) != true) goto L224;
        r12 = true;
        goto L224
    L214:
        if (r30.isEmpty() == true) goto L217;
        r31 = false;
        goto L218
    L199:
        if (r26.isEmpty() == true) goto L202;
        r27 = false;
        goto L203
    L184:
        if (r22.isEmpty() == true) goto L187;
        r23 = false;
        goto L188
    L169:
        if (r18.isEmpty() == true) goto L172;
        r19 = false;
        goto L173
    L154:
        if (r5.isEmpty() == true) goto L157;
        r6 = false;
        goto L158
    L61:
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer(), Collection.class, "com.obric.memorydata.plugin");
        if (r33 != null) goto L64;
    L67:
        boolean r34 = true;
    L68:
        if (r34 == true) goto L76;
        List<String> r35 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer();
        if (r35 != null) goto L72;
    L74:
        boolean r36 = false;
    L75:
        if (r36 == false) goto L44;
    L72:
        if (r35.contains(Build.MANUFACTURER) != true) goto L74;
        r36 = true;
    L76:
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand(), Collection.class, "com.obric.memorydata.plugin");
        if (r37 != null) goto L79;
    L82:
        boolean r38 = true;
    L83:
        if (r38 == true) goto L91;
        List<String> r39 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand();
        if (r39 != null) goto L87;
    L89:
        boolean r40 = false;
    L90:
        if (r40 == false) goto L44;
    L87:
        if (r39.contains(Build.BRAND) != true) goto L89;
        r40 = true;
    L91:
        Collection r41 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel(), Collection.class, "com.obric.memorydata.plugin");
        if (r41 != null) goto L94;
    L97:
        boolean r42 = true;
    L98:
        if (r42 == true) goto L106;
        List<String> r43 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel();
        if (r43 != null) goto L102;
    L104:
        boolean r44 = false;
    L105:
        if (r44 == false) goto L44;
    L102:
        if (r43.contains(Build.MODEL) != true) goto L104;
        r44 = true;
    L106:
        Collection r45 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName(), Collection.class, "com.obric.memorydata.plugin");
        if (r45 != null) goto L109;
    L112:
        boolean r46 = true;
    L113:
        if (r46 == true) goto L121;
        List<String> r47 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName();
        if (r47 != null) goto L117;
    L119:
        boolean r48 = false;
    L120:
        if (r48 == false) goto L44;
    L117:
        if (r47.contains(Build.PRODUCT) != true) goto L119;
        r48 = true;
    L121:
        Collection r49 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice(), Collection.class, "com.obric.memorydata.plugin");
        if (r49 != null) goto L124;
    L127:
        boolean r50 = true;
    L128:
        if (r50 == true) goto L136;
        List<String> r51 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice();
        if (r51 != null) goto L132;
    L134:
        boolean r52 = false;
    L135:
        if (r52 == false) goto L44;
    L132:
        if (r51.contains(Build.DEVICE) != true) goto L134;
        r52 = true;
    L136:
        d.b r53 = d.f5954a;
        StringBuilder r54 = new StringBuilder().append("getObricProductName and, key: ").append((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")).append(", manufacturer: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getManufacturer()).append(", brand: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getBrand()).append(", model: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getModel()).append(", device: ");
        Collection r55 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getDevice(), Collection.class, "com.obric.memorydata.plugin");
        if (r55 != null) goto L139;
    L142:
        boolean r56 = true;
    L143:
        StringBuilder r57 = r54.append(r56).append(", name: ");
        Collection r58 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r4.getValue(), ProductInfoConfig.class, "com.obric.memorydata.plugin")).getName(), Collection.class, "com.obric.memorydata.plugin");
        if (r58 != null) goto L146;
    L147:
        r12 = true;
    L148:
        r53.b("FeatureServiceImpl", r57.append(r12).toString());
        goto L226
    L146:
        if (r58.isEmpty() == false) goto L148;
    L139:
        if (r55.isEmpty() == true) goto L142;
        r56 = false;
        goto L143
    L124:
        if (r49.isEmpty() == true) goto L127;
        r50 = false;
        goto L128
    L109:
        if (r45.isEmpty() == true) goto L112;
        r46 = false;
        goto L113
    L94:
        if (r41.isEmpty() == true) goto L97;
        r42 = false;
        goto L98
    L79:
        if (r37.isEmpty() == true) goto L82;
        r38 = false;
        goto L83
    L64:
        if (r33.isEmpty() == true) goto L67;
        r34 = false;
        goto L68
    L55:
        if (r16.isEmpty() == true) goto L58;
        r17 = false;
        goto L59
    L48:
        if (r11.isEmpty() == true) goto L51;
        r13 = false;
        goto L52
    L227:
        d.f5954a.b("FeatureServiceImpl", "getObricProductName, productName: " + ((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin")) + ", manufacturer: " + Build.MANUFACTURER + ", brand: " + Build.BRAND + ", model: " + Build.MODEL + ", device: " + Build.DEVICE + ", name: " + Build.PRODUCT);
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L6:
        if (r0.equals("emulator") == true) goto L32;
        r2 = "unknown";
        goto L32
    L9:
        if (r0.equals("pike") == false) goto L261;
        r2 = "pike";
        goto L32
    L261:
        r2 = "unknown";
        goto L32
    L13:
        if (r0.equals("genesis") == false) goto L262;
        r2 = "genesis";
        goto L32
    L262:
        r2 = "unknown";
        goto L32
    L17:
        if (r0.equals("pacific") == false) goto L31;
        r2 = "pacific";
        goto L32
    L31:
        r2 = "unknown";
        goto L32
    L20:
        if (r0.equals("nerida") == false) goto L263;
        r2 = "nerida";
        goto L32
    L263:
        r2 = "unknown";
        goto L32
    L24:
        if (r0.equals("Genesis-R") == false) goto L264;
        r2 = "Genesis-R";
        goto L32
    L264:
        r2 = "unknown";
        goto L32
    L28:
        if (r0.equals("Genesis-M") == false) goto L265;
        r2 = "Genesis-M";
        goto L32
    L265:
        r2 = "unknown";
        goto L32
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public List<String> c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "featureKey");
    L28:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "isFeatureEnable failed, featureKey: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return CollectionsKt.emptyList();
    L4:
        if (this.f != null) goto L6;
        this.f = a("default_feature_config_group.json", "obric_feature_config_group");     // Catch: Exception -> L28
        d.f5954a.b("FeatureServiceImpl", "init obric feature v2, feature list config group: " + this.f);     // Catch: Exception -> L28
    L6:
        FeatureListConfig r2 = this.f;     // Catch: Exception -> L28
        if (r2 == null) goto L11;
        Map<String, FeatureConfigWrap> r3 = r2.getFeatureConfigWraps();     // Catch: Exception -> L28
        if (r3 == null) goto L11;
        FeatureConfigWrap r4 = (FeatureConfigWrap) ZeusTransformUtils.preCheckCast(r3.get(r7), FeatureConfigWrap.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
    L12:
        d.f5954a.b("FeatureServiceImpl", "getFeatureStateList, featureKey: " + r7 + ", featureConfig: " + r4);     // Catch: Exception -> L28
        if (r4 == null) goto L27;
        if (r4.getEnabled() == false) goto L27;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getFeatureStateConfigList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L28
    L19:
        if (r5.hasNext() == false) goto L25;
        FeatureStateConfigItem r6 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r5.next(), FeatureStateConfigItem.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (a(r6) == false) goto L19;
        return r6.getStateList();
    L25:
        return r4.getDefaultStateList();
    L27:
        return CollectionsKt.emptyList();
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public String d() {
        if (i() == false) goto L5;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.platform.a.b.f5950a.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        r2 = "obric";
    L13:
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")) + '_' + Build.BRAND + '_' + Build.MODEL;
    L9:
        r0 = false;
        goto L10
    L5:
        return com.obric.aiagent.platform.a.b.f5950a.a();
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public boolean e() {
        return k();
    }

    @Override // com.obric.aiagent.product.feature.a.a
    public boolean f() {
        return a("obric_feature_global_effect_stop_layer_effective");
    }

    public final void g() {
        d.f5954a.b("FeatureServiceImpl", "initFeatureInfo");
    L11:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "int obric feature info failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (this.d == null) goto L6;
        return;
    L6:
        JSONObject r1 = d("default_feature_config.json");     // Catch: Exception -> L11
        if (r1 != null) goto L9;
        r1 = new JSONObject();     // Catch: Exception -> L11
    L9:
        this.d = (FeatureListConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r1.toString(), FeatureListConfig.class), FeatureListConfig.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        d.f5954a.a("FeatureServiceImpl", "init obric feature info, featureListConfigBoolean: " + this.d + ", json: " + r1);     // Catch: Exception -> L11
    }

    public final void h() {
        Object r0 = "";
        d.f5954a.b("FeatureServiceImpl", "initProductInfo");
        Gson r3 = new Gson();     // Catch: Exception -> L46
        Type r5 = new b().getType();     // Catch: Exception -> L46
        JSONObject r6 = d("default_product_info.json");     // Catch: Exception -> L46
        if (r6 == null) goto L7;
        String r7 = r6.toString();     // Catch: Exception -> L46
        if (r7 == null) goto L7;
    L53:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r10 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(r3.fromJson(r7, r5), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L12:
        Map r11 = MapsKt.emptyMap();     // Catch: Exception -> L46
        if (Result.m1427isFailureimpl(r10) == false) goto L15;
        r10 = r11;
    L15:
        Map<String, ProductInfoConfig> r12 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L46
        d.f5954a.a("FeatureServiceImpl", "init obric product info, defaultProductMap: " + r12 + ", json: " + r7);     // Catch: Exception -> L46
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L24
        a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        JSONObject r15 = c.f5952a.a("obric_product_info_config");     // Catch: Throwable -> L24
        if (r15 == null) goto L19;
        String r16 = r15.toString();     // Catch: Throwable -> L24
    L20:
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        Object r17 = Result.m1421constructorimpl(r16);     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r17) == true) goto L30;
        r0 = r17;
    L30:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L46
        d.f5954a.b("FeatureServiceImpl", "init obric product info, cloudJsonStr: " + r1);     // Catch: Exception -> L46
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == true) goto L49;
        this.c = r12;     // Catch: Exception -> L46
    L44:
        d.f5954a.b("FeatureServiceImpl", "init obric product info, productMap: " + this.c);     // Catch: Exception -> L46
        return;
    L49:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L37
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Object r4 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(r3.fromJson(r1, r5), Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L39:
        Map r20 = MapsKt.emptyMap();     // Catch: Exception -> L46
        if (Result.m1427isFailureimpl(r4) == false) goto L42;
        r4 = r20;
    L42:
        this.c = MapsKt.plus(r12, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L46
        goto L44
    L37:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Exception -> L46
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
        goto L39
    L33:
        r18 = false;
        goto L34
    L19:
        r16 = null;
    L24:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Exception -> L46
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
        goto L27
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Exception -> L46
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L46
    L7:
        r7 = "{}";
    L46:
        e = move-exception;
        d.f5954a.b("FeatureServiceImpl", "int obric product info failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public boolean i() {
        String r5 = com.obric.aiagent.platform.a.b.f5950a.a();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return true;
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        return false;
    L17:
        if (StringsKt.startsWith$default(r5, "obric", false, 2, null) == true) goto L19;
        return false;
    L19:
        return true;
    L14:
        r2 = false;
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
