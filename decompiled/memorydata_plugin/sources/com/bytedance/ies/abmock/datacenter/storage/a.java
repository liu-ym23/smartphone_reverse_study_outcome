package com.bytedance.ies.abmock.datacenter.storage;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u001fH\u0016J!\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010!2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010*\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u000fH\u0016J\u001a\u0010,\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u0019H\u0016J\u001a\u0010-\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u001bH\u0016J\u001a\u0010.\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u001dH\u0016J\u001a\u0010/\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u001fH\u0016J)\u00100\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010!H\u0016¢\u0006\u0002\u00101J\u001c\u00102\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u00064"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/ConfigCenterRepo;", "Lcom/bytedance/ies/abmock/datacenter/storage/IConfigRepo;", "()V", "configRepo", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "getConfigRepo", "()Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "configRepo$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "contains", "", "key", "", "erase", "", "getAllKey", "", "getBooleanValue", "defaultValue", "getDoubleValue", "", "getFloatValue", "", "getIntValue", "", "getLongValue", "", "getStringArrayValue", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getStringValue", "getValue", "", "targetType", "Ljava/lang/Class;", "load", "needUseDefault", "storeBooleanValue", EventBody.KEY_VALUE, "storeDoubleValue", "storeFloatValue", "storeIntValue", "storeLongValue", "storeStringArrayValue", "(Ljava/lang/String;[Ljava/lang/String;)V", "storeStringValue", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0138a f2705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2706b = null;
    public static boolean c;
    private final Lazy d;
    private final Lazy e;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.storage.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/storage/ConfigCenterRepo$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/ies/abmock/datacenter/storage/ConfigCenterRepo;", "mergeRepoOpt", "", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0138a {
        private C0138a() {
        }

        public /* synthetic */ C0138a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f2705a = new C0138a(null);
        f2706b = new a();
        c = true;
    }

    public a() {
        this.d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ConfigCenterRepo$configRepo$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.e = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(ConfigCenterRepo$gson$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final Object a(a r2, String r3, Class r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$key");
        return r2.a().fromJson(r2.b().a(r3, null), (Type) ZeusTransformUtils.preCheckCast(r4, Type.class, "com.obric.memorydata.plugin"));
    }

    private final e b() {
        return (e) ZeusTransformUtils.preCheckCast(this.d.getValue(), e.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Object lambda$5ovEgSBwNe80mQC_UptjUxT5LKg(a r0, String r1, Class r2) {
        return a(r0, r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public double a(String r1, double r2) {
        return b().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public float a(String r1, float r2) {
        return b().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public int a(String r1, int r2) {
        return b().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public long a(String r1, long r2) {
        return b().a(r1, r2);
    }

    public final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.e.getValue(), Gson.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public Object a(final String r4, final Class<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        return new $$Lambda$a$5ovEgSBwNe80mQC_UptjUxT5LKg(this, r4, r5).call();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "IConfigRepo");
        return null;
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String a(String r1, String r2) {
        return b().a(r1, r2);
    }

    public void a(String r1, String[] r2) {
        b().b(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean a(String r1, boolean r2) {
        return b().a(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public String[] a(String r2) {
        return b().a(r2, null);
    }

    public void b(String r1, double r2) {
        b().b(r1, r2);
    }

    public void b(String r1, float r2) {
        b().b(r1, r2);
    }

    public void b(String r1, int r2) {
        b().b(r1, r2);
    }

    public void b(String r1, long r2) {
        b().b(r1, r2);
    }

    public void b(String r1, String r2) {
        b().b(r1, r2);
    }

    public void b(String r1, boolean r2) {
        b().b(r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.d
    public boolean b(String r1) {
        return b().a(r1);
    }

    public final boolean c(String r1) {
        return b().b(r1);
    }

    public void d(String r2) {
        com.bytedance.ies.abmock.datacenter.k r0 = com.bytedance.ies.abmock.datacenter.d.a().c();
        if (r0 != null) goto L5;
    L8:
        b().c(r2);
        return;
    L5:
        if (r0.d() == false) goto L8;
        if (b().a(r2) == true) goto L8;
    }
}
