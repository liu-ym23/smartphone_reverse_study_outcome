package df;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.l;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f16654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f16655b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList f16656c = null;

    static {
        f16654a = new CopyOnWriteArraySet();
        f16655b = new ConcurrentHashMap();
        f16656c = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(IGeckoRegister r10, boolean r11) {
        int r5 = 0;
        Object[] r12 = 0;
        c.f16652i.a();
        GeckoGlobalConfig r13 = c.f;
        GeckoGlobalConfig.ENVType r14 = r13.getEnv();
        String r15 = r10.getClass().getName();
        CopyOnWriteArrayList r16 = GeckoLogger.f4756a;
        GeckoLogger.a(ReportNode.GECKO_REGISTER_BY_IREGISTER, "register gecko by IGeckoRegister, env: " + r14 + ", class: " + r15);
        ka.a r17 = (ka.a) r10.getClass().getAnnotation(ka.a.class);
        if (r17 != null) goto L6;
        GeckoLogger.b("GeckoRegister is invalid, class is ".concat(r15));
        return;
    L6:
        CopyOnWriteArraySet r18 = f16654a;
        if (r18.contains(r15) == false) goto L10;
        GeckoLogger.b("GeckoRegister already register, class is ".concat(r15));
        return;
    L10:
        r18.add(r15);
        String r19 = r17.testAccessKey();
        String r20 = r17.boeAccessKey();
        String r21 = r17.prodAccessKey();
        if (r14 == null) goto L23;
        int r22 = d.f16653a[r14.ordinal()];
        if (r22 == 1) goto L23;
        if (r22 != 2) goto L18;
        r19 = r21;
        goto L23
    L18:
        if (r22 != 3) goto L23;
        r19 = r20;
    L23:
        if (r19.length() != 0) goto L26;
        GeckoLogger.b("GeckoRegister access key is empty, class is ".concat(r15));
        return;
    L26:
        Map<String, OptionCheckUpdateParams.CustomValue> r23 = r10.registerCustomParams();
        if (r23 != null) goto L29;
    L53:
        String r24 = r10.registerRootDir(r13.getContext());
        if (r24 != null) goto L56;
    L59:
        GeckoLogger.b("GeckoRegister root dir is empty, class is ".concat(r15));
    L60:
        if (r11 == true) goto L62;
        return;
    L62:
        if (c.f16648a.get() == false) goto L84;
        AtomicBoolean r25 = gf.a.f17089b;
        if (r25.get() == false) goto L67;
        RequestBodyUpdate r26 = new RequestBodyUpdate(ReqType.REGISTER_LATE);
        r26.initCustom(CollectionsKt.listOf(r19));
        r25.set(true);
        new g(r26).e();
    L67:
        ConcurrentHashMap r27 = (ConcurrentHashMap) f16655b.get(r19);
        if (r27 == null) goto L70;
        String r28 = (String) r27.get("business_version");
    L72:
        if (Intrinsics.areEqual(r28, c.e.getAppVersion()) == true) goto L83;
        GlobalConfigSettings r29 = com.bytedance.iesgurd.settings.d.f6692a;
        ((ThreadPoolExecutor) com.bytedance.geckox.utils.c.f4791a.getValue()).execute(new com.bytedance.iesgurd.settings.b(r5, r12 == true ? 1 : 0, ReqType.REGISTER_LATE));
        return;
    L83:
        return;
    L70:
        r28 = null;
        goto L72
    L84:
        return;
    L56:
        if (r24.length() == 0) goto L59;
        l.a(r19, r24);
        goto L60
    L29:
        if (r23.isEmpty() == true) goto L53;
        GeckoLogger.a(ReportNode.GECKO_REGISTER_CUSTOM_PARAMS, "register custom params: " + r19 + ", " + r23);
        ConcurrentHashMap r30 = f16655b;
        if (r30.get(r19) != null) goto L44;
        monitor-enter(r30);
    L37:
        th = move-exception;
        throw th;
    L35:
        if (r30.get(r19) != null) goto L39;
        r30.put(r19, new ConcurrentHashMap());     // Catch: Throwable -> L37
    L39:
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r30);
    L44:
        Object r32 = r30.get(r19);
        if (r32 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        ConcurrentHashMap r33 = (ConcurrentHashMap) r32;
        Iterator<Map.Entry<String, OptionCheckUpdateParams.CustomValue>> r34 = r23.entrySet().iterator();
    L49:
        if (r34.hasNext() == false) goto L53;
        Map.Entry<String, OptionCheckUpdateParams.CustomValue> r35 = r34.next();
        Object r36 = r35.getValue().getValue();
        if (r36 == null) goto L49;
        r33.put(r35.getKey(), r36.toString());
        goto L49
    }
}
