package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.utils.af;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\fJ\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060&*\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/VideoPlaybackSamplingController;", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "sampler", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;", "isEffectiveCollectionPackage", "Lkotlin/Function1;", "", "", "foregroundPackage", "Lkotlin/Function0;", "currentAppName", "addAppSwitchListener", "", "removeAppSwitchListener", "initiallyEnabled", "<init>", "(Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "activeKeysByPackage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "packageByKey", "enabled", "onCodecLifecycleEvent", "event", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleEvent;", "setFeatureEnabled", "onAppOpen", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "stopAll", "stopIneligiblePackages", "startIfEligible", "stop", "resolvePackageName", "samplingKey", ObricMemoryConstants.KEY_SESSION_ID, "toExtraMeta", "", "intervalMs", "", "stopPackage", "stopPackagesExcept", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements af.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f12579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.recommend.screenshotupload.sampling.c f12580b;
    private final Function1<String, Boolean> c;
    private final Function0<String> d;
    private final Function0<String> e;
    private final Function1<af.a, Unit> f;
    private final Function1<af.a, Unit> g;
    private final ConcurrentHashMap<String, Set<String>> h;
    private final ConcurrentHashMap<String, String> i;
    private boolean j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/VideoPlaybackSamplingController$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12581a = null;

        static {
            int[] r0 = new int[AIMediaCodecLifecycleKind.values().length];
            r0[AIMediaCodecLifecycleKind.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AIMediaCodecLifecycleKind.RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AIMediaCodecLifecycleKind.PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AIMediaCodecLifecycleKind.STOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f12581a = r0;
        }
    }

    static {
        f12579a = new a(null);
    }

    public k(com.obric.memorydata.recommend.screenshotupload.sampling.c r3, Function1<? super String, Boolean> r4, Function0<String> r5, Function0<String> r6, Function1<? super af.a, Unit> r7, Function1<? super af.a, Unit> r8, boolean r9) {
        com.obric.memorydata.recommend.screenshotupload.sampling.c r10 = (com.obric.memorydata.recommend.screenshotupload.sampling.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.recommend.screenshotupload.sampling.c.class, "com.obric.memorydata.plugin");
        Function1<String, Boolean> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function0<String> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function0<String> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function1<af.a, Unit> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function1<af.a, Unit> r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "sampler");
        Intrinsics.checkNotNullParameter(r11, "isEffectiveCollectionPackage");
        Intrinsics.checkNotNullParameter(r12, "foregroundPackage");
        Intrinsics.checkNotNullParameter(r13, "currentAppName");
        Intrinsics.checkNotNullParameter(r14, "addAppSwitchListener");
        Intrinsics.checkNotNullParameter(r15, "removeAppSwitchListener");
        this.f12580b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = r9;
    }

    public /* synthetic */ k(com.obric.memorydata.recommend.screenshotupload.sampling.c r6, Function1 r7, Function0 r8, Function0 r9, Function1 r10, Function1 r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        com.obric.memorydata.recommend.screenshotupload.sampling.c r15 = (com.obric.memorydata.recommend.screenshotupload.sampling.c) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.recommend.screenshotupload.sampling.c.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Function0 r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function0 r18 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function1 r19 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Function1 r110 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        if ((r13 & 2) == 0) goto L5;
        r16 = $$Lambda$k$ksbCp3Dx7w4s6VygXEiEaBTwoR8.INSTANCE;
    L5:
        Function1 r111 = r16;
        if ((r13 & 4) == 0) goto L8;
        Function0 r0 = $$Lambda$k$ZRuyzjr_3BWnBvlQpRr4TLA1Bxs.INSTANCE;
    L10:
        if ((r13 & 8) == 0) goto L12;
        Function0 r1 = $$Lambda$k$IXe4TioHHVtb3en7wCyXTHos5y8.INSTANCE;
    L14:
        if ((r13 & 16) == 0) goto L16;
        Function1 r2 = $$Lambda$k$CZMWZLe88j2ezLOgdAVR2iIqjWU.INSTANCE;
    L18:
        if ((r13 & 32) == 0) goto L20;
        Function1 r3 = $$Lambda$k$Q75pem_wyb2NsXZZNSPJxkpjU.INSTANCE;
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

    private final Map<String, String> a(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r7, long r8) {
        boolean r1 = false;
        LinkedHashMap r6 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("capture_reason", "video_playback"), TuplesKt.to("media_key_event", r7.b()), TuplesKt.to("media_sequence_number", String.valueOf(r7.c())), TuplesKt.to("video_sampling_interval_ms", String.valueOf(r8)), TuplesKt.to("media_encoder", String.valueOf(r7.g())), TuplesKt.to("media_use_surface", String.valueOf(r7.h()))});
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7.d(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("media_session_id", r7.d());
    L5:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("mime", r7.i());
    L14:
        Long r11 = r7.m();
        if (r11 == null) goto L17;
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue();
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("video_duration_us", String.valueOf(r12));
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("video_duration_minutes", String.valueOf((r12 / 60) / TimeUtils.NANOSECONDS_PER_MILLISECOND));
    L17:
        Long r13 = r7.j();
        if (r13 == null) goto L20;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("video_width", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue()));
    L20:
        Long r14 = r7.k();
        if (r14 == null) goto L23;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("video_height", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue()));
    L23:
        Long r15 = r7.l();
        if (r15 == null) goto L26;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("frame_rate", String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).longValue()));
    L26:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.n(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L29;
    L30:
        r1 = true;
    L31:
        if (r1 == true) goto L34;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put("stall_reason", r7.n());
    L34:
        return (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
    L29:
        if (StringsKt.isBlank(r16) == false) goto L31;
    L8:
        if (StringsKt.isBlank(r9) == true) goto L11;
        r10 = false;
        goto L12
    }

    private static final Map a(k r0, com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r1, long r2) {
        return r0.a(r1, r2);
    }

    private static final Unit a(af.a r2) {
        af.a r3 = (af.a) ZeusTransformUtils.wrapperContextForParams(r2, af.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        af.f13160a.a(r3);
        return Unit.INSTANCE;
    }

    private final void a(String r4) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        Set r5 = (Set) ZeusTransformUtils.preCheckCast(this.h.remove(r4), Set.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        this.i.remove(r0);
        this.f12580b.a(r0);
        goto L9
    L13:
        return;
    }

    private static final Unit b(af.a r2) {
        af.a r3 = (af.a) ZeusTransformUtils.wrapperContextForParams(r2, af.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        af.f13160a.b(r3);
        return Unit.INSTANCE;
    }

    private final void b(final com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r22) {
        if (this.j == true) goto L6;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=feature_disabled session=" + r22.d());
        return;
    L6:
        String r7 = d(r22);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=blank_package session=" + r22.d());
        return;
    L10:
        String r5 = c(r7, r22.d());
        if (this.i.containsKey(r5) == false) goto L14;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=already_active key=" + r5 + " pkg=" + r7 + " session=" + r22.d());
        return;
    L14:
        String r2 = l.a(l.f12582a, r22, false, 2, null);
        if (r2 == null) goto L19;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=" + r2 + " pkg=" + r7 + " session=" + r22.d());
        return;
    L19:
        if (r22.f() == true) goto L23;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=not_video pkg=" + r7 + " session=" + r22.d());
        return;
    L23:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(r7), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L26;
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip start reason=not_collect_package pkg=" + r7 + " session=" + r22.d());
        return;
    L26:
        final long r13 = m.f12583a.a(r22.m(), com.obric.memorydata.recommend.screenshotupload.sampling.e.f12587a.a());
        ConcurrentMap r3 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(this.h, ConcurrentMap.class, "com.obric.memorydata.plugin");
        Object r4 = r3.get(r7);
        if (r4 != null) goto L32;
        r4 = (Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin");
        Object r6 = r3.putIfAbsent(r7, r4);
        if (r6 == null) goto L32;
        r4 = r6;
    L32:
        ((Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin")).add(r5);
        ((Map) ZeusTransformUtils.preCheckCast(this.i, Map.class, "com.obric.memorydata.plugin")).put(r5, r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VideoPlaybackSamplingController", "start sampling key=" + r5 + " pkg=" + r7 + " intervalMs=" + r13 + " durationUs=" + r22.m() + " kind=" + r22.a(), false, 4, null);
        com.obric.memorydata.recommend.screenshotupload.sampling.c r8 = this.f12580b;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.e.invoke(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r9) == false) goto L35;
        r9 = r7;
    L35:
        r8.a(r5, (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), r7, TriggerUploadType.VideoPlaybackSample, new $$Lambda$k$5MkajQ8z77Wu4nWu8YjRrq7hPw(this, r22, r13), $$Lambda$k$Emy_TQYIZOO7e7DWcC0lVtP1Jnw.INSTANCE, 0, r13);
    }

    private final void b(String r6) {
        Set<String> r0 = this.h.keySet();
        Intrinsics.checkNotNullExpressionValue(r0, "<get-keys>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), r6)) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        a((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    private static final String c() {
        return af.f13160a.b();
    }

    private final String c(String r2, String r3) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        StringBuilder r1 = new StringBuilder().append("video:").append(r3);
    L7:
        return r1.toString();
    L5:
        r1 = new StringBuilder().append("video:").append(r2);
        goto L7
    }

    private final void c(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r13) {
        String r0 = d(r13);
        String r1 = c(r0, r13.d());
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.i.remove(r1), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        k r12 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "skip stop reason=not_active key=" + r1 + " pkg=" + r0 + " kind=" + r13.a());
        return;
    L6:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(this.h.get(r2), Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        r3.remove(r1);
        if (r3.isEmpty() == false) goto L11;
        this.h.remove(r2);
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VideoPlaybackSamplingController", "stop sampling key=" + r1 + " pkg=" + r2 + " kind=" + r13.a(), false, 4, null);
        this.f12580b.a(r1);
    }

    private static final boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pkg");
        return com.obric.memorydata.recommend.screenshotupload.b.f12542a.a(r1);
    }

    private static final String d() {
        return af.f13160a.a();
    }

    private final String d(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L6;
        r4 = (String) ZeusTransformUtils.preCheckCast(this.d.invoke(), String.class, "com.obric.memorydata.plugin");
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    }

    private static final ScreenshotOption e() {
        return com.obric.memorydata.recommend.screenshotupload.sampling.d.f12586a.a();
    }

    /* JADX INFO: renamed from: lambda$5MkajQ8z77Wu4nWu8YjRr-q7hPw, reason: not valid java name */
    public static /* synthetic */ Map m1124lambda$5MkajQ8z77Wu4nWu8YjRrq7hPw(k r0, com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r1, long r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$CZMWZLe88j2ezLOgdAVR2iIqjWU(af.a r0) {
        return a(r0);
    }

    public static /* synthetic */ ScreenshotOption lambda$Emy_TQYIZOO7e7DWcC0lVtP1Jnw() {
        return e();
    }

    public static /* synthetic */ String lambda$IXe4TioHHVtb3en7wCyXTHos5y8() {
        return d();
    }

    /* JADX INFO: renamed from: lambda$Q--75pem_wyb2NsXZZNSPJxkpjU, reason: not valid java name */
    public static /* synthetic */ Unit m1125lambda$Q75pem_wyb2NsXZZNSPJxkpjU(af.a r0) {
        return b(r0);
    }

    public static /* synthetic */ String lambda$ZRuyzjr_3BWnBvlQpRr4TLA1Bxs() {
        return c();
    }

    public static /* synthetic */ boolean lambda$ksbCp3Dx7w4s6VygXEiEaBTwoR8(String r0) {
        return c(r0);
    }

    public final synchronized void a() {
        monitor-enter(this);
        Collection<Set<String>> r0 = this.h.values();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");     // Catch: Throwable -> L10
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.f12580b.a(r2);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.h.clear();     // Catch: Throwable -> L10
        this.i.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(com.obric.memorydata.recommend.screenshotupload.sampling.aimedia.a r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "event");     // Catch: Throwable -> L18
        RunLog.INSTANCE.debug("VideoPlaybackSamplingController", "codec lifecycle kind=" + r5.a() + " key=" + r5.b() + " pkg=" + r5.e() + " session=" + r5.d() + " video=" + r5.f() + " encoder=" + r5.g() + " useSurface=" + r5.h());     // Catch: Throwable -> L18
        int r0 = b.f12581a[r5.a().ordinal()];     // Catch: Throwable -> L18
        if (r0 != 1) goto L6;
    L15:
        b(r5);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L6:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L10;
    L14:
        c(r5);     // Catch: Throwable -> L18
        goto L16
    L10:
        if (r0 == 4) goto L14;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.utils.af.a
    public synchronized void a(String r2, String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "appName");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L6
        b(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(boolean r8) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.j != r8) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.j = r8;     // Catch: Throwable -> L13
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VideoPlaybackSamplingController", "feature enabled=" + r8, false, 4, null);     // Catch: Throwable -> L13
        if (r8 == false) goto L10;
        this.f.invoke(this);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        this.g.invoke(this);     // Catch: Throwable -> L13
        a();     // Catch: Throwable -> L13
        goto L11
    }

    public final synchronized void b() {
        monitor-enter(this);
        Set<String> r0 = this.h.keySet();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r0, "<get-keys>(...)");     // Catch: Throwable -> L21
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L21
    L5:
        if (r3.hasNext() == false) goto L9;
        Object r4 = r3.next();     // Catch: Throwable -> L21
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Function1<String, Boolean> r6 = this.c;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L21
        if (((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(r5), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
        r2.add(r4);     // Catch: Throwable -> L21
        goto L5
    L9:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
    L10:
        if (r7.hasNext() == false) goto L19;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Set r9 = (Set) ZeusTransformUtils.preCheckCast(this.h.remove(r8), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r9 == null) goto L10;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
    L16:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        this.i.remove(r11);     // Catch: Throwable -> L21
        this.f12580b.a(r11);     // Catch: Throwable -> L21
        goto L16
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.utils.af.a
    public synchronized void b(String r2, String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "appName");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L6
        a(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
