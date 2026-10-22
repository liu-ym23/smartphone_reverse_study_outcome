package com.obric.memorydata.awareness.impl.gate;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\t\b\u0000\u0018\u0000 $2\u00020\u0001:\u0002#$BU\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J*\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0011H\u0002J\f\u0010!\u001a\u00020\b*\u00020\tH\u0002J\b\u0010\"\u001a\u00020\bH\u0002R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider;", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;", "intReader", "Lkotlin/Function2;", "", "", "observationFactory", "Lkotlin/Function0;", "", "Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$FeatureSwitchObservation;", "failureReporter", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "lock", "", "observations", "", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "onChanged", "Lkotlin/Function1;", "getBoolean", "", "repo", "key", "defaultValue", "getInt", "replaceObservedKeys", "keys", "", "release", "readIntOrDefault", "createObservation", "switchKey", "releaseSafely", "reportFailureSafely", "FeatureSwitchObservation", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f8688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<String, Integer, Integer> f8689b;
    private final Function2<String, Function0<Unit>, b> c;
    private final Function0<Unit> d;
    private final Object e;
    private final Map<c, b> f;
    private volatile Function1<? super c, Unit> g;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$Companion;", "", "<init>", "()V", "DISABLED_INT_VALUE", "", "ENABLED_INT_VALUE", "observeSystemSetting", "Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$FeatureSwitchObservation;", "key", "", "onChanged", "Lkotlin/Function0;", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.g$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$Companion$observeSystemSetting$observer$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0443a extends ContentObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f8690a;

            C0443a(Function0<Unit> r3) {
                this.f8690a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
                super(null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean r1) {
                this.f8690a.invoke();
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final void a(ContentResolver r2, C0443a r3) {
            ZeusProviderTransform.unregisterContentObserver(r2, (ContentObserver) ZeusTransformUtils.preCheckCast(r3, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ void lambda$5Mgc5qBtryk7ZkJdzXzHJKPi0Z4(ContentResolver r0, C0443a r1) {
            a(r0, r1);
        }

        public final b a(String r4, Function0<Unit> r5) {
            Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r3, "onChanged");
            final ContentResolver r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
            final C0443a r1 = new C0443a(r3);
            ZeusProviderTransform.registerContentObserver(r6, Settings.System.getUriFor(r4), false, (ContentObserver) ZeusTransformUtils.preCheckCast(r1, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            return new $$Lambda$g$a$5Mgc5qBtryk7ZkJdzXzHJKPi0Z4(r6, r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/SystemSettingsFeatureSwitchValueProvider$FeatureSwitchObservation;", "", "release", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void release();
    }

    static {
        f8688a = new a(null);
    }

    public g() {
        this(null, null, null, 7, null);
    }

    public g(Function2<? super String, ? super Integer, Integer> r3, Function2<? super String, ? super Function0<Unit>, ? extends b> r4, Function0<Unit> r5) {
        Function2<String, Integer, Integer> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function2<String, Function0<Unit>, b> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "intReader");
        Intrinsics.checkNotNullParameter(r7, "observationFactory");
        Intrinsics.checkNotNullParameter(r8, "failureReporter");
        this.f8689b = r6;
        this.c = r7;
        this.d = r8;
        this.e = new Object();
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.g = $$Lambda$g$ZnF2FhnSnd4XAPvjzhwpRsqryE.INSTANCE;
    }

    public /* synthetic */ g(Function2 r2, Function2 r3, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = $$Lambda$g$TpsxgF45nMHuhxcAsroUn8jdYfg.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = (Function2) ZeusTransformUtils.preCheckCast(new SystemSettingsFeatureSwitchValueProvider$2(f8688a), Function2.class, "com.obric.memorydata.plugin");
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = $$Lambda$g$5TdaW4ih2ieWNUK2DiwmHOIzmI.INSTANCE;
    L11:
        this(r7, r8, r9);
    }

    private final int a(String r3, int r4) {
        return ((Number) ZeusTransformUtils.preCheckCast(this.f8689b.invoke(r3, Integer.valueOf(r4)), Number.class, "com.obric.memorydata.plugin")).intValue();
    L4:
        a();
        return r4;
    }

    private final b a(final c r4) {
        return (b) ZeusTransformUtils.preCheckCast(this.c.invoke(r4.b(), new $$Lambda$g$hhoSLRKcxItGibJ2XQROf2JZaU(this, r4)), b.class, "com.obric.memorydata.plugin");
    L4:
        a();
        return null;
    }

    private static final Unit a(g r0, c r1) {
        r0.g.invoke(r1);
        return Unit.INSTANCE;
    }

    private final void a() {
        this.d.invoke();     // Catch: Exception -> L4
        return;
    }

    private final void a(b r3) {
        ((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")).release();     // Catch: Exception -> L5
        return;
    L5:
        a();
    }

    private static final int b(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, r4);
    }

    private static final Unit b() {
        o r0 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        r1.a("provider", "android_settings_system");
        r0.a("feature_switch_read_failed", "Feature 开关读取或监听失败，已使用默认值", r7, r1.a());
        return Unit.INSTANCE;
    }

    private static final Unit b(c r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$5TdaW4ih2ieWNUK2Di-wmHOIzmI, reason: not valid java name */
    public static /* synthetic */ Unit m515lambda$5TdaW4ih2ieWNUK2DiwmHOIzmI() {
        return b();
    }

    public static /* synthetic */ int lambda$TpsxgF45nMHuhxcAsroUn8jdYfg(String r0, int r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZnF2FhnSnd4XAPvjzh-wpRsqryE, reason: not valid java name */
    public static /* synthetic */ Unit m516lambda$ZnF2FhnSnd4XAPvjzhwpRsqryE(c r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$hhoSLR-KcxItGibJ2XQROf2JZaU, reason: not valid java name */
    public static /* synthetic */ Unit m517lambda$hhoSLRKcxItGibJ2XQROf2JZaU(g r0, c r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public int a(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "key");
        return a(r3, r4);
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public void a(Set<c> r5, Function1<? super c, Unit> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Function1<? super c, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "keys");
        Intrinsics.checkNotNullParameter(r8, "onChanged");
        Object r0 = this.e;
        monitor-enter(r0);
        this.g = r8;     // Catch: Throwable -> L19
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(this.f.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L19
    L6:
        if (r9.hasNext() == false) goto L10;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f.remove(r1), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r2 == null) goto L6;
        a(r2);     // Catch: Throwable -> L19
        goto L6
    L10:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L19
    L12:
        if (r10.hasNext() == false) goto L16;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        b r3 = a(r11);     // Catch: Throwable -> L19
        if (r3 == null) goto L12;
        this.f.put(r11, r3);     // Catch: Throwable -> L19
        goto L12
    L16:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public boolean a(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (a(r3, r4 ? 1 : 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
