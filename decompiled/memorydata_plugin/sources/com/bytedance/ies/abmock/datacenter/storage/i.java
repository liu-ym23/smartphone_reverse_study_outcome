package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.ies.abmock.SaveConfigType;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0002\b\u0003\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u0017H\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020&2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020&H\u0016J\u001a\u0010'\u001a\u00020(2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020(H\u0016J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020\u0012J!\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010/2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u00100J\u001e\u00101\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J \u00102\u001a\u0004\u0018\u00010*2\u0006\u0010\u0018\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u001aH\u0016J\u001a\u00106\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u0017H\u0016J\u001a\u00108\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\"H\u0016J\u001a\u00109\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020$H\u0016J\u001a\u0010:\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020&H\u0016J\u0016\u0010;\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,J\u001a\u0010<\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020(H\u0016J)\u0010=\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u0010>J\u001c\u0010?\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014¨\u0006A"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/LibraConfigCenterRepo;", "Lcom/bytedance/ies/abmock/datacenter/storage/IConfigRepo;", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "interceptor", "Lcom/bytedance/ies/abmock/datacenter/storage/IRepoInterceptor;", "getInterceptor", "()Lcom/bytedance/ies/abmock/datacenter/storage/IRepoInterceptor;", "setInterceptor", "(Lcom/bytedance/ies/abmock/datacenter/storage/IRepoInterceptor;)V", "libraConfigRepo", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "getLibraConfigRepo", "()Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "libraConfigRepo$delegate", "contains", "", "key", "erase", "", "getAll", "", "getAllKey", "", "getBooleanValue", "defaultValue", "getDoubleValue", "", "getFloatValue", "", "getIntValue", "", "getLongValue", "", "getMockValue", "", "type", "Lcom/bytedance/ies/abmock/SaveConfigType$ConfigType;", "getRepo", "getStringArrayValue", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getStringValue", "getValue", "targetType", "Ljava/lang/Class;", "load", "storeBooleanValue", EventBody.KEY_VALUE, "storeDoubleValue", "storeFloatValue", "storeIntValue", "storeLaunchValue", "storeLongValue", "storeStringArrayValue", "(Ljava/lang/String;[Ljava/lang/String;)V", "storeStringValue", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f2723b = null;
    public static boolean c;
    private final String d;
    private final Lazy e;
    private final Lazy f;
    private f g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/LibraConfigCenterRepo$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/ies/abmock/datacenter/storage/LibraConfigCenterRepo;", "needInterceptor", "", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2724a = null;

        static {
            int[] r0 = new int[SaveConfigType.ConfigType.values().length];
            r0[SaveConfigType.ConfigType.BOOLEAN.ordinal()] = 1;
            r0[SaveConfigType.ConfigType.INT.ordinal()] = 2;
            r0[SaveConfigType.ConfigType.LONG.ordinal()] = 3;
            r0[SaveConfigType.ConfigType.DOUBLE.ordinal()] = 4;
            r0[SaveConfigType.ConfigType.FLOAT.ordinal()] = 5;
            r0[SaveConfigType.ConfigType.STRING.ordinal()] = 6;
            r0[SaveConfigType.ConfigType.STRING_ARRAY.ordinal()] = 7;
            r0[SaveConfigType.ConfigType.OBJECT.ordinal()] = 8;
            f2724a = r0;
        }
    }

    static {
        f2722a = new a(null);
        f2723b = new i();
        c = true;
    }

    public i() {
        this.d = "LibraConfigCenterRepo";
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(LibraConfigCenterRepo$libraConfigRepo$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.f = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(LibraConfigCenterRepo$gson$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.g = (f) ZeusTransformUtils.preCheckCast(new h.a(), f.class, "com.obric.memorydata.plugin");
    }

    private static final Object a(i r2, String r3, Class r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$key");
        return r2.a().fromJson(r2.c().a(r3, null), (Type) ZeusTransformUtils.preCheckCast(r4, Type.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(i r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        com.bytedance.ies.abmock.datacenter.k r0 = com.bytedance.ies.abmock.datacenter.d.a().c();
        if (c == true) goto L5;
    L7:
        if (r0 != null) goto L9;
    L12:
        r2.c().c(r3);
    L14:
        return Unit.INSTANCE;
    L9:
        if (r0.d() == false) goto L12;
        if (r2.c().a(r3) == false) goto L14;
    L5:
        if (r2.g.a(r3) == false) goto L7;
        r2.g.b(r3);
        goto L7
    }

    private final e c() {
        return (e) ZeusTransformUtils.preCheckCast(this.e.getValue(), e.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Object lambda$7na0hXo8cQbKxkbI4OmX5UolcPA(i r0, String r1, Class r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$MJwAauZY5KYLjZxMDUVNUL5NJg8(i r0, String r1) {
        return a(r0, r1);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public double a(String r1, double r2) {
        return c().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public float a(String r1, float r2) {
        return c().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public int a(String r1, int r2) {
        return c().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public long a(String r1, long r2) {
        return c().a(r1, r2);
    }

    public final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.f.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public Object a(final String r5, final Class<?> r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r1 = this.d;
        return new $$Lambda$i$7na0hXo8cQbKxkbI4OmX5UolcPA(this, r5, r6).call();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), r1);
        return null;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String a(String r1, String r2) {
        return c().a(r1, r2);
    }

    public final void a(String r3, SaveConfigType.ConfigType r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "type");
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L22;
        Object r0 = b(r3, r4);
        if (r0 != null) goto L10;
        return;
    L10:
        switch(b.f2724a[r4.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L30;
        };
    L12:
        this.g.a(r3, a().toJson(r0));
        return;
    L13:
        this.g.a(r3, (String[]) ZeusTransformUtils.preCheckCast(r0, String[].class, "com.obric.memorydata.plugin"));
        return;
    L14:
        this.g.a(r3, (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        this.g.a(r3, ((Float) ZeusTransformUtils.preCheckCast(r0, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L16:
        this.g.a(r3, ((Double) ZeusTransformUtils.preCheckCast(r0, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L17:
        this.g.a(r3, ((Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L18:
        this.g.a(r3, ((Integer) ZeusTransformUtils.preCheckCast(r0, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L19:
        this.g.a(r3, ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L30:
        return;
    }

    public void a(String r3, String[] r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        this.g.a(r3, (String[]) ZeusTransformUtils.preCheckCast(com.bytedance.ies.abmock.datacenter.d.a().a(r3, String[].class, r4), String[].class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean a(String r1, boolean r2) {
        return c().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String[] a(String r2) {
        return c().a(r2, null);
    }

    public final e b() {
        return c();
    }

    public final Object b(String r2, SaveConfigType.ConfigType r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "type");
        if (r3 != SaveConfigType.ConfigType.STRING_ARRAY) goto L6;
        return com.bytedance.ies.abmock.datacenter.d.a().a(r2, String[].class, null);
    L6:
        return com.bytedance.ies.abmock.datacenter.d.a().a(r2, null, null);
    }

    public void b(String r3, double r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        f r2 = this.g;
        Object r5 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, Double.valueOf(r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Double");
        r2.a(r3, ((Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    }

    public void b(String r3, float r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        f r2 = this.g;
        Object r5 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, Float.valueOf(r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        r2.a(r3, ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    }

    public void b(String r3, int r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        f r2 = this.g;
        Object r5 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, Integer.valueOf(r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r2.a(r3, ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    }

    public void b(String r3, long r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        f r2 = this.g;
        Object r5 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, Long.valueOf(r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Long");
        r2.a(r3, ((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    }

    public void b(String r3, String r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L14;
        Object r0 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, r4);
        if (r0 != null) goto L9;
    L11:
        this.g.a(r3, r4);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L11;
        r4 = a().toJson(r0);
        goto L11
    }

    public void b(String r3, boolean r4) {
        c().b(r3, r4);
        if (c == true) goto L5;
        return;
    L5:
        if (this.g.a(r3) == false) goto L9;
        f r2 = this.g;
        Object r5 = com.bytedance.ies.abmock.datacenter.d.a().a(r3, null, Boolean.valueOf(r4));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        r2.a(r3, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean b(String r1) {
        return c().a(r1);
    }

    public void c(final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        String r1 = this.d;
        new $$Lambda$i$MJwAauZY5KYLjZxMDUVNUL5NJg8(this, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: erase", th), r1);
    }
}
