package com.bytedance.ies.abmock.datacenter;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0002\b\u0003\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J3\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0006H\u0016J\u0012\u0010!\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\"\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\bH\u0016J\u001a\u0010$\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u0013H\u0016J\u001a\u0010%\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u0015H\u0016J\u001a\u0010&\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u0017H\u0016J\u001a\u0010'\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020\u0019H\u0016J\u001c\u0010(\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0016J)\u0010)\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/DataStorageProxy;", "Lcom/bytedance/ies/abmock/datacenter/storage/IDataStorage;", "keva", "Lcom/bytedance/keva/Keva;", "(Lcom/bytedance/keva/Keva;)V", "clear", "", "contains", "", "key", "", "erase", "getAll", "", "getAllKey", "", "getBoolean", "defaultValue", "getDouble", "", "getFloat", "", "getInt", "", "getLong", "", "getName", "getString", "getStringArray", "", "defValue", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "load", "needUseDefault", "storeBoolean", EventBody.KEY_VALUE, "storeDouble", "storeFloat", "storeInt", "storeLong", "storeString", "storeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements com.bytedance.ies.abmock.datacenter.storage.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Keva f2683b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/DataStorageProxy$Companion;", "", "()V", "TAG", "", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f2682a = new a(null);
    }

    public f(Keva r2) {
        Intrinsics.checkNotNullParameter(r2, "keva");
        this.f2683b = r2;
    }

    private static final Boolean a(f r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Boolean.valueOf(r1.f2683b.contains(r2));
    }

    private static final Boolean a(f r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Boolean.valueOf(r1.f2683b.getBoolean(r2, r3));
    }

    private static final Double a(f r1, String r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Double.valueOf(r1.f2683b.getDouble(r2, r3));
    }

    private static final Float a(f r1, String r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Float.valueOf(r1.f2683b.getFloat(r2, r3));
    }

    private static final Integer a(f r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Integer.valueOf(r1.f2683b.getInt(r2, r3));
    }

    private static final Long a(f r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Long.valueOf(r1.f2683b.getLong(r2, r3));
    }

    private static final String a(f r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.f2683b.getString(r2, r3);
    }

    private static final Unit a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.clear();
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1, String r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r1 == null) goto L7;
        r3.f2683b.storeString(r2, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("value is null, key: " + r2);
    }

    private static final Unit a(String[] r1, String r2, f r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r1 == null) goto L7;
        r3.f2683b.storeStringArray(r2, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("value is null, key: " + r2);
    }

    private static final String[] a(f r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.f2683b.getStringArray(r2, r3);
    }

    private static final Set b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Map<String, ?> r3 = r2.f2683b.getAll();
        if (r3 == null) goto L7;
        Set<String> r4 = r3.keySet();
        if (r4 == null) goto L7;
        return CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    L7:
        return null;
    }

    private static final Unit b(f r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.erase(r2);
        return Unit.INSTANCE;
    }

    private static final Unit b(f r1, String r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.storeDouble(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(f r1, String r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.storeFloat(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(f r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.storeInt(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(f r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.storeLong(r2, r3);
        return Unit.INSTANCE;
    }

    private static final Unit b(f r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.f2683b.storeBoolean(r2, r3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$-KKYzUfgBNUQnUgoi2CQ1-tMn5E, reason: not valid java name */
    public static /* synthetic */ String m95lambda$KKYzUfgBNUQnUgoi2CQ1tMn5E(f r0, String r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$0i6plW3AUiir8wW3UJzr294_oqE(f r0, String r1, float r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$2Iz4d2-H6BTLSfA4poqh2EQWqzk, reason: not valid java name */
    public static /* synthetic */ Unit m96lambda$2Iz4d2H6BTLSfA4poqh2EQWqzk(f r0, String r1, double r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Bea6PjRtztzvTv6j69EleY-bRZw, reason: not valid java name */
    public static /* synthetic */ Float m97lambda$Bea6PjRtztzvTv6j69EleYbRZw(f r0, String r1, float r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$GUbmx-usQrSmtZJ3Wj8nOxM5HMw, reason: not valid java name */
    public static /* synthetic */ String[] m98lambda$GUbmxusQrSmtZJ3Wj8nOxM5HMw(f r0, String r1, String[] r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$QrQWBpUHDPMR_OFuVczU5K924aQ(f r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$RvnjABdw2lciJ2O-o2aRPZcpzaQ, reason: not valid java name */
    public static /* synthetic */ Unit m99lambda$RvnjABdw2lciJ2Oo2aRPZcpzaQ(f r0, String r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ Long lambda$UU7yaLfDek6BvlFH4VSIkbQGe1s(f r0, String r1, long r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$VhU6Yshv1BNDFcs5HEooJ6fKbqg(f r0, String r1, long r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Double lambda$W9J8J2GHdIFPE2SkYeA3fxH9MA4(f r0, String r1, double r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$YJ-4TPrDvER1A5Cfw85pfB1k3ng, reason: not valid java name */
    public static /* synthetic */ Boolean m100lambda$YJ4TPrDvER1A5Cfw85pfB1k3ng(f r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$_70i6Gtv_C_uzyjyqkuyVr4gCGU(f r0, String r1, int r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Set lambda$_rchJMpD6BhHPko3zM2kR4w6q1Y(f r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$jK5HFKw9elcNO2Fi09lWIxgQsS8(f r0, String r1, boolean r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ Integer lambda$nBLabqmXcoMyrff4VNPk7R1CVdQ(f r0, String r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ouiW7DtA11MpV5Hv9_UH6njK-MU, reason: not valid java name */
    public static /* synthetic */ Boolean m101lambda$ouiW7DtA11MpV5Hv9_UH6njKMU(f r0, String r1, boolean r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$u1j3w5JUmQDvwwtm8PGxdS8JKk8(String[] r0, String r1, f r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$xj7lQPN5JoykW6CQEtfbPoaRQC0(String r0, String r1, f r2) {
        return a(r0, r1, r2);
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public double a(final String r5, final double r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$f$W9J8J2GHdIFPE2SkYeA3fxH9MA4(this, r5, r6).call();     // Catch: Throwable -> L5
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
        Object r4 = new $$Lambda$f$Bea6PjRtztzvTv6j69EleYbRZw(this, r5, r6).call();     // Catch: Throwable -> L5
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
        Object r4 = new $$Lambda$f$nBLabqmXcoMyrff4VNPk7R1CVdQ(this, r5, r6).call();     // Catch: Throwable -> L5
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
        Object r4 = new $$Lambda$f$UU7yaLfDek6BvlFH4VSIkbQGe1s(this, r5, r6).call();     // Catch: Throwable -> L5
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
        Object r3 = new $$Lambda$f$KKYzUfgBNUQnUgoi2CQ1tMn5E(this, r4, r5).call();     // Catch: Throwable -> L5
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
        new $$Lambda$f$QrQWBpUHDPMR_OFuVczU5K924aQ(this).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: null", th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public boolean a(final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$f$YJ4TPrDvER1A5Cfw85pfB1k3ng(this, r5).call();     // Catch: Throwable -> L5
    L8:
        return Intrinsics.areEqual(r4, true);
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public boolean a(final String r5, final boolean r6) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        Object r4 = new $$Lambda$f$ouiW7DtA11MpV5Hv9_UH6njKMU(this, r5, r6).call();     // Catch: Throwable -> L5
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
        Object r3 = new $$Lambda$f$GUbmxusQrSmtZJ3Wj8nOxM5HMw(this, r4, r5).call();     // Catch: Throwable -> L5
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
        com.bytedance.ies.abmock.datacenter.event.b r1 = new $$Lambda$f$_rchJMpD6BhHPko3zM2kR4w6q1Y(this);
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
        new $$Lambda$f$2Iz4d2H6BTLSfA4poqh2EQWqzk(this, r3, r4).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r3, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final float r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$0i6plW3AUiir8wW3UJzr294_oqE(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final int r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$_70i6Gtv_C_uzyjyqkuyVr4gCGU(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r3, final long r4) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$VhU6Yshv1BNDFcs5HEooJ6fKbqg(this, r3, r4).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r3, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final String r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$xj7lQPN5JoykW6CQEtfbPoaRQC0(r5, r4, this).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final boolean r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$jK5HFKw9elcNO2Fi09lWIxgQsS8(this, r4, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r4, th), "DataStorageProvider");
    }

    @Override // com.bytedance.ies.abmock.datacenter.storage.e
    public void b(final String r4, final String[] r5) {
        com.bytedance.ies.abmock.datacenter.event.a.C0135a r0 = com.bytedance.ies.abmock.datacenter.event.a.f2680a;
        new $$Lambda$f$u1j3w5JUmQDvwwtm8PGxdS8JKk8(r5, r4, this).call();     // Catch: Throwable -> L5
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
        new $$Lambda$f$RvnjABdw2lciJ2Oo2aRPZcpzaQ(this, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: " + r5, th), "DataStorageProvider");
    }
}
