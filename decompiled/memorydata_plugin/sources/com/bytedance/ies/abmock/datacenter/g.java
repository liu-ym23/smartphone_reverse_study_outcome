package com.bytedance.ies.abmock.datacenter;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\u0018\u0000 *2\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J3\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010!\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u001a\u0010#\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u001a\u0010$\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u001a\u0010&\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u001c\u0010'\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J)\u0010(\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/DataStorageProxyProvider;", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "provider", "(Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;)V", "clear", "", "contains", "", "key", "", "erase", "getAll", "", "getAllKey", "", "getBoolean", "defaultValue", "getDouble", "", "getFloat", "", "getInt", "", "getLong", "", "getName", "getString", "getStringArray", "", "defValue", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "load", "needUseDefault", "storeBoolean", EventBody.KEY_VALUE, "storeDouble", "storeFloat", "storeInt", "storeLong", "storeString", "storeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements com.bytedance.ies.abmock.datacenter.storage.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.ies.abmock.datacenter.storage.e f2685b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/DataStorageProxyProvider$Companion;", "", "()V", "TAG", "", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f2684a = new a(null);
    }

    public g(com.bytedance.ies.abmock.datacenter.storage.e r3) {
        com.bytedance.ies.abmock.datacenter.storage.e r4 = (com.bytedance.ies.abmock.datacenter.storage.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.ies.abmock.datacenter.storage.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "provider");
        this.f2685b = r4;
    }

    private static final Boolean a(g r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Boolean.valueOf(r1.f2685b.a(r2));
    }

    private static final Boolean a(g r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Boolean.valueOf(r1.f2685b.a(r2, r3));
    }

    private static final Double a(g r1, String r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Double.valueOf(r1.f2685b.a(r2, r3));
    }

    private static final Float a(g r1, String r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Float.valueOf(r1.f2685b.a(r2, r3));
    }

    private static final Integer a(g r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Integer.valueOf(r1.f2685b.a(r2, r3));
    }

    private static final Long a(g r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Long.valueOf(r1.f2685b.a(r2, r3));
    }

    private static final String a(g r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.f2685b.a(r2, r3);
    }

    private static final Unit a(g r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.a();
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1, String r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r1 == null) goto L7;
        r3.f2685b.b(r2, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("value is null, key: " + r2);
    }

    private static final Unit a(String[] r1, String r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r1 == null) goto L7;
        r3.f2685b.b(r2, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("value is null, key: " + r2);
    }

    private static final String[] a(g r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.f2685b.a(r2, r3);
    }

    private static final Set b(g r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.f2685b.b();
    }

    private static final Unit b(g r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.c(r2);
        return Unit.INSTANCE;
    }

    private static final Unit b(g r1, String r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.b(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(g r1, String r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.b(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(g r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.b(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(g r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.b(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(g r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2685b.b(r2, r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Float lambda$3dIpWRFd4LWyqnNKTw8alHO6CfM(g r0, String r1, float r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$3o3oghJJiusCdQx98jVz9GNBVuU(g r0, String r1, float r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$5oVX3Nw7EniXnHc6EVs8ob1hcLY(String r0, String r1, g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Double lambda$F9tBLAbtpH6nRRPTwDKkve58FZA(g r0, String r1, double r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$HoSTciOQqO5KUh6VIHu1hAU3lqY(g r0, String r1, double r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Integer lambda$KLNhMAlFHBporY08Df3p6J5FATw(g r0, String r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$M7J_LHy-Bm18_fmH5kjZXjF3OH8, reason: not valid java name */
    public static /* synthetic */ Unit m102lambda$M7J_LHyBm18_fmH5kjZXjF3OH8(g r0, String r1, long r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Boolean lambda$Ts0ER_0g2ZAE3eolxH2DoZPGM_E(g r0, String r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UK8J-unjHCtxJgrbl_tj5I1MLwg, reason: not valid java name */
    public static /* synthetic */ Unit m103lambda$UK8JunjHCtxJgrbl_tj5I1MLwg(String[] r0, String r1, g r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Long lambda$Yd3OpPl4b6AiobH5eOHtMPiLwSg(g r0, String r1, long r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$a7snbXinSV-EYvTUixAVSI0um-8, reason: not valid java name */
    public static /* synthetic */ Set m104lambda$a7snbXinSVEYvTUixAVSI0um8(g r0) {
        return b(r0);
    }

    public static /* synthetic */ Boolean lambda$a8X9f5pl5VMnwgaJNOgpKx7m0kg(g r0, String r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$hfmg6GKgvBLUDCjocZZOv18Kyvk(g r0, String r1, boolean r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$kXZww-s6gR2GOwIElxAwYnFdaok, reason: not valid java name */
    public static /* synthetic */ Unit m105lambda$kXZwws6gR2GOwIElxAwYnFdaok(g r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ String[] lambda$nC0q5OYpujEZGX6QbpnSnq1SDmg(g r0, String r1, String[] r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$nVICG18bZbWXikqdoT2sbtzGu0c(g r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$wvsorlWQ8syX1EJB78jRoJqx34Y(g r0, String r1, int r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$xDex7SPKc8oPOwc1aS2AVr4Fjvo(g r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public double a(final String r5, final double r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$g$F9tBLAbtpH6nRRPTwDKkve58FZA(this, r5, r6).call();     // Catch: Throwable -> L5
    L7:
        Double r7 = (Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return r6;
    L10:
        return r7.doubleValue();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public float a(final String r5, final float r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$g$3dIpWRFd4LWyqnNKTw8alHO6CfM(this, r5, r6).call();     // Catch: Throwable -> L5
    L7:
        Float r7 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return r6;
    L10:
        return r7.floatValue();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public int a(final String r5, final int r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$g$KLNhMAlFHBporY08Df3p6J5FATw(this, r5, r6).call();     // Catch: Throwable -> L5
    L7:
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return r6;
    L10:
        return r7.intValue();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public long a(final String r5, final long r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$g$Yd3OpPl4b6AiobH5eOHtMPiLwSg(this, r5, r6).call();     // Catch: Throwable -> L5
    L7:
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return r6;
    L10:
        return r7.longValue();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public String a(final String r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r3 = new $$Lambda$g$xDex7SPKc8oPOwc1aS2AVr4Fjvo(this, r4, r5).call();     // Catch: Throwable -> L5
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void a() {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$nVICG18bZbWXikqdoT2sbtzGu0c(this).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: null", th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public boolean a(final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        com.bytedance.ies.abmock.datacenter.event.b r1 = new $$Lambda$g$Ts0ER_0g2ZAE3eolxH2DoZPGM_E(this, r5);
        Object r4 = null;
        r4 = r1.call();     // Catch: Throwable -> L5
    L8:
        return Intrinsics.areEqual(r4, true);
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: null", th), "DataStorageProvider");
        goto L8
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public boolean a(final String r5, final boolean r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$g$a8X9f5pl5VMnwgaJNOgpKx7m0kg(this, r5, r6).call();     // Catch: Throwable -> L5
    L7:
        Boolean r7 = (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return r6;
    L10:
        return r7.booleanValue();
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public String[] a(final String r4, final String[] r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r3 = new $$Lambda$g$nC0q5OYpujEZGX6QbpnSnq1SDmg(this, r4, r5).call();     // Catch: Throwable -> L5
    L8:
        return (String[]) ZeusTransformUtils.preCheckCast(r3, String[].class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public Set<String> b() {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        com.bytedance.ies.abmock.datacenter.event.b r1 = new $$Lambda$g$a7snbXinSVEYvTUixAVSI0um8(this);
        Object r5 = null;
        r5 = r1.call();     // Catch: Throwable -> L5
    L7:
        Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        return r6;
    L10:
        return (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: null", th), "DataStorageProvider");
        goto L7
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r3, final double r4) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$HoSTciOQqO5KUh6VIHu1hAU3lqY(this, r3, r4).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r3, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final float r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$3o3oghJJiusCdQx98jVz9GNBVuU(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final int r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$wvsorlWQ8syX1EJB78jRoJqx34Y(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r3, final long r4) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$M7J_LHyBm18_fmH5kjZXjF3OH8(this, r3, r4).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r3, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$5oVX3Nw7EniXnHc6EVs8ob1hcLY(r5, r4, this).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final boolean r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$hfmg6GKgvBLUDCjocZZOv18Kyvk(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final String[] r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$UK8JunjHCtxJgrbl_tj5I1MLwg(r5, r4, this).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public boolean b(String r1) {
        return !a(r1);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void c(final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$g$kXZwws6gR2GOwIElxAwYnFdaok(this, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
    }
}
