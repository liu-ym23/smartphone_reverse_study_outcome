package com.obric.memorydata.recommend.screenshotupload.sampling;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/CameraForegroundSamplingController;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "sampler", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;", "isEffectiveCollectionPackage", "Lkotlin/Function1;", "", "", "addAppSwitchListener", "", "removeAppSwitchListener", "currentPackageProvider", "Lkotlin/Function0;", "currentAppNameProvider", "initiallyEnabled", "<init>", "(Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "nativeCameraPackages", "", "enabled", "setFeatureEnabled", "syncCurrentForeground", "onAppOpen", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "startSampling", "stopSampling", "shouldSample", "stopAll", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements af.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0679a f12561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f12562b;
    private final Function1<String, Boolean> c;
    private final Function1<af.a, Unit> d;
    private final Function1<af.a, Unit> e;
    private final Function0<String> f;
    private final Function0<String> g;
    private final Set<String> h;
    private boolean i;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.screenshotupload.sampling.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/CameraForegroundSamplingController$Companion;", "", "<init>", "()V", "CAMERA_FOREGROUND_FIRST_CAPTURE_DELAY_MS", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0679a {
        private C0679a() {
        }

        public /* synthetic */ C0679a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12561a = new C0679a(null);
    }

    public a(c r3, Function1<? super String, Boolean> r4, Function1<? super af.a, Unit> r5, Function1<? super af.a, Unit> r6, Function0<String> r7, Function0<String> r8, boolean r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1<af.a, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Function1<af.a, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Function0<String> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0<String> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "sampler");
        Intrinsics.checkNotNullParameter(r11, "isEffectiveCollectionPackage");
        Intrinsics.checkNotNullParameter(r12, "addAppSwitchListener");
        Intrinsics.checkNotNullParameter(r13, "removeAppSwitchListener");
        Intrinsics.checkNotNullParameter(r14, "currentPackageProvider");
        Intrinsics.checkNotNullParameter(r15, "currentAppNameProvider");
        this.f12562b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = SetsKt.setOf(new String[]{"com.obric.camera2", "com.android.camera"});
        this.i = r9;
    }

    public /* synthetic */ a(c r6, Function1 r7, Function1 r8, Function1 r9, Function0 r10, Function0 r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        c r15 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function1 r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function0 r19 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Function0 r110 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        if ((r13 & 2) == 0) goto L5;
        r16 = $$Lambda$a$_TUGudBoVy9tSdQ74DpfeG1KbBo.INSTANCE;
    L5:
        Function1 r111 = r16;
        if ((r13 & 4) == 0) goto L8;
        Function1 r0 = $$Lambda$a$Fq076E9gsBfaSzfoJwXGsBx0NmE.INSTANCE;
    L10:
        if ((r13 & 8) == 0) goto L12;
        Function1 r1 = $$Lambda$a$1feHT4YhWDcyEiH0F5cQBKJoO2M.INSTANCE;
    L14:
        if ((r13 & 16) == 0) goto L16;
        Function0 r2 = $$Lambda$a$zlqmnsqCK1N05eJXgdRjBgo9kN0.INSTANCE;
    L18:
        if ((r13 & 32) == 0) goto L20;
        Function0 r3 = $$Lambda$a$ntkBQHbYmFchlCudQ4hyvC_A0nI.INSTANCE;
    L22:
        if ((r13 & 64) == 0) goto L24;
        r12 = false;
    L24:
        boolean r4 = r12;
        this(r15, r111, r0, r1, r2, r3, r4);
        return;
    L20:
        r3 = r110;
        goto L22
    L16:
        r2 = r19;
        goto L18
    L12:
        r1 = r18;
        goto L14
    L8:
        r0 = r17;
        goto L10
    }

    private static final Unit a(af.a r2) {
        af.a r3 = (af.a) ZeusTransformUtils.wrapperContextForParams(r2, af.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        af.f13160a.a(r3);
        return Unit.INSTANCE;
    }

    private final void a(String r3) {
        this.f12562b.a("camera:" + r3);
    }

    private static final Unit b(af.a r2) {
        af.a r3 = (af.a) ZeusTransformUtils.wrapperContextForParams(r2, af.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        af.f13160a.b(r3);
        return Unit.INSTANCE;
    }

    private final void b() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private final boolean b(String r2) {
        if (this.h.contains(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(r2), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }

    private static final String c() {
        return af.f13160a.b();
    }

    private final void c(String r14, String r15) {
        c.a.a(this.f12562b, "camera:" + r15, r14, r15, TriggerUploadType.CameraForegroundSample, $$Lambda$a$8FcrSE_hMAFxOjd8YBI6LrX0Z0c.INSTANCE, $$Lambda$a$gqbPzE4pRp7hCRbzsds8yJ3U0b4.INSTANCE, 2000, 0, 128, null);
    }

    private static final boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pkg");
        return com.obric.memorydata.recommend.screenshotupload.b.f12542a.a(r1);
    }

    private static final String d() {
        return af.f13160a.a();
    }

    private static final Map e() {
        return MapsKt.mapOf(TuplesKt.to("capture_reason", "camera_foreground"));
    }

    private static final ScreenshotOption f() {
        return d.f12586a.a();
    }

    public static /* synthetic */ Unit lambda$1feHT4YhWDcyEiH0F5cQBKJoO2M(af.a r0) {
        return b(r0);
    }

    public static /* synthetic */ Map lambda$8FcrSE_hMAFxOjd8YBI6LrX0Z0c() {
        return e();
    }

    public static /* synthetic */ Unit lambda$Fq076E9gsBfaSzfoJwXGsBx0NmE(af.a r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$_TUGudBoVy9tSdQ74DpfeG1KbBo(String r0) {
        return c(r0);
    }

    public static /* synthetic */ ScreenshotOption lambda$gqbPzE4pRp7hCRbzsds8yJ3U0b4() {
        return f();
    }

    public static /* synthetic */ String lambda$ntkBQHbYmFchlCudQ4hyvC_A0nI() {
        return d();
    }

    public static /* synthetic */ String lambda$zlqmnsqCK1N05eJXgdRjBgo9kN0() {
        return c();
    }

    public final void a() {
        if (this.i == true) goto L5;
        return;
    L5:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f.invoke(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        b();
        return;
    L10:
        if (b(r0) == false) goto L12;
        c((String) ZeusTransformUtils.preCheckCast(this.g.invoke(), String.class, "com.obric.memorydata.plugin"), r0);
        return;
    L12:
        b();
    }

    @Override // com.obric.memorydata.utils.af.a
    public void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (this.i == true) goto L6;
        return;
    L6:
        if (b(r3) == true) goto L9;
        b();
        return;
    L9:
        c(r2, r3);
    }

    public final void a(boolean r2) {
        if (this.i != r2) goto L7;
        if (r2 == false) goto L13;
        a();
        return;
    L13:
        return;
    L7:
        this.i = r2;
        if (r2 == true) goto L11;
        b();
        this.e.invoke(this);
        return;
    L11:
        this.d.invoke(this);
        a();
    }

    @Override // com.obric.memorydata.utils.af.a
    public void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "appName");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        a(r3);
    }
}
