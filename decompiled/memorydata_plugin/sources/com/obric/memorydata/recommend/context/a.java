package com.obric.memorydata.recommend.context;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.awareness.location.LocationProcessor;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.recommend.ui.list.ContextItemType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\nJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/recommend/context/ContextLoader;", "", "subItemType", "Lcom/obric/memorydata/recommend/ui/list/ContextItemType;", "onContextLoadFinish", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "", "<init>", "(Lcom/obric/memorydata/recommend/ui/list/ContextItemType;Lkotlin/jvm/functions/Function1;)V", "beginLoadContext", "getCommuteClusterResult", "Lcom/obric/memorydata/sdk/awareness/CommuteClusterResult;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0667a f12502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContextItemType f12503b;
    private final Function1<String, Unit> c;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.context.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/context/ContextLoader$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0667a {
        private C0667a() {
        }

        public /* synthetic */ C0667a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12504a = null;

        static {
            int[] r0 = new int[ContextItemType.values().length];
            r0[ContextItemType.SLEEP_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[ContextItemType.WAKEUP_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[ContextItemType.LEAVE_HOME_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[ContextItemType.ARRIVE_COMPANY_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[ContextItemType.LEAVE_COMPANY_TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[ContextItemType.ARRIVE_HOME_TIME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[ContextItemType.HOME_LOCATIONS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[ContextItemType.COMPANY_LOCATIONS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[ContextItemType.DAY_TYPE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[ContextItemType.LOCATION_TYPE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[ContextItemType.LOCATION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f12504a = r0;
        }
    }

    static {
        f12502a = new C0667a(null);
    }

    public a(ContextItemType r3, Function1<? super String, Unit> r4) {
        Function1<String, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "subItemType");
        Intrinsics.checkNotNullParameter(r5, "onContextLoadFinish");
        this.f12503b = r3;
        this.c = r5;
    }

    private final com.obric.memorydata.sdk.awareness.a b() {
        Object r0 = FeatureManager.INSTANCE.getFeature("commute_cluster_result");
        if (r0 != null) goto L5;
        return null;
    L5:
        com.obric.memorydata.sdk.awareness.a r1 = com.obric.memorydata.sdk.awareness.a.f12817a.a(r0);
        if (r1 != null) goto L9;
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextLoader", "parse commute cluster result failed", null, 4, null);
        return null;
    L9:
        return r1;
    }

    public final void a() {
        boolean r6 = true;
        String r8 = null;
        String r10 = "";
        switch(b.f12504a[this.f12503b.ordinal()]) {
            case 1: goto L81;
            case 2: goto L80;
            case 3: goto L73;
            case 4: goto L68;
            case 5: goto L63;
            case 6: goto L58;
            case 7: goto L44;
            case 8: goto L31;
            case 9: goto L27;
            case 10: goto L13;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        this.c.invoke(r10);
        return;
    L5:
        List<Double> r0 = LocationSnapshot.INSTANCE.getLocation(300000);
        if (r0 == null) goto L4;
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L4;
        String r1 = LocationProcessor.INSTANCE.getAddressByGps(((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue());
        if (r1 == null) goto L4;
    L12:
        r10 = r1;
        goto L4
    L13:
        List<Double> r2 = LocationSnapshot.INSTANCE.getLocation(300000);
        if (r2 == null) goto L4;
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L4;
        Object r3 = FeatureManager.INSTANCE.getFeature("commute_state");
        if (r3 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L25;
        r6 = false;
    L25:
        if (r6 == false) goto L4;
        Function1 r12 = this.c;
    L82:
        r12.invoke(r3);
        return;
    L27:
        r12 = this.c;
        if (ContextManager.INSTANCE.isWorkingDay(System.currentTimeMillis()) == false) goto L30;
        r3 = "工作日";
        goto L82
    L30:
        r3 = "节假日";
        goto L82
    L31:
        Object r4 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (r4 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L4;
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L4;
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("auto_learn_common_address", false) == true) goto L41;
        r12 = this.c;
        LocationProcessor r5 = LocationProcessor.INSTANCE;
        String r7 = "公司";
    L54:
        r3 = r5.getUserSetAddress(r7);
        goto L82
    L41:
        LocationProcessor r9 = LocationProcessor.INSTANCE;
        Object r11 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).get(0);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Double");
        double r13 = ((Double) ZeusTransformUtils.preCheckCast(r11, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r14 = ((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).get(1);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Double");
        r1 = r9.getAddressByGps(r13, ((Double) ZeusTransformUtils.preCheckCast(r14, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        if (r1 != null) goto L12;
    L44:
        Object r15 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        if (r15 == null) goto L4;
        if (ZeusTransformUtils.instanceOf(r15, List.class) == false) goto L4;
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L4;
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("auto_learn_common_address", false) == true) goto L55;
        r12 = this.c;
        r5 = LocationProcessor.INSTANCE;
        r7 = "家";
        goto L54
    L55:
        LocationProcessor r16 = LocationProcessor.INSTANCE;
        Object r17 = ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).get(0);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Double");
        double r18 = ((Double) ZeusTransformUtils.preCheckCast(r17, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r19 = ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).get(1);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Double");
        r1 = r16.getAddressByGps(r18, ((Double) ZeusTransformUtils.preCheckCast(r19, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        if (r1 != null) goto L12;
    L58:
        Function1<String, Unit> r20 = this.c;
        com.obric.memorydata.sdk.awareness.a r110 = b();
        if (r110 == null) goto L61;
        r8 = r110.d();
    L61:
        if (r8 == null) goto L79;
    L78:
        r10 = r8;
    L79:
        r20.invoke(r10);
        return;
    L63:
        r20 = this.c;
        com.obric.memorydata.sdk.awareness.a r111 = b();
        if (r111 == null) goto L66;
        r8 = r111.c();
    L66:
        if (r8 != null) goto L78;
    L68:
        r20 = this.c;
        com.obric.memorydata.sdk.awareness.a r112 = b();
        if (r112 == null) goto L71;
        r8 = r112.b();
    L71:
        if (r8 != null) goto L78;
    L73:
        r20 = this.c;
        com.obric.memorydata.sdk.awareness.a r113 = b();
        if (r113 == null) goto L76;
        r8 = r113.a();
    L76:
        if (r8 != null) goto L78;
    L80:
        r12 = this.c;
        r3 = com.obric.memorydata.recommend.context.b.c();
        goto L82
    L81:
        r12 = this.c;
        r3 = com.obric.memorydata.recommend.context.b.b();
        goto L82
    }
}
