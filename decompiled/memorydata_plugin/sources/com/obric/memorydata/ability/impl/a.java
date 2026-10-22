package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.ability.data.AudioAppInfo;
import com.obric.memorydata.ability.data.DeviceAudioStandardData;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\u00060\u000fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/ability/impl/AudioStateAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "subscriberCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "playbackListener", "Lcom/obric/memorydata/ability/impl/AudioStateAbility$AudioManagerPlaybackListener;", "getPlaybackListener", "()Lcom/obric/memorydata/ability/impl/AudioStateAbility$AudioManagerPlaybackListener;", "playbackListener$delegate", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "callbackHandler$delegate", "cachedData", "Lcom/obric/memorydata/ability/data/DeviceAudioStandardData;", "onCreate", "", "iAbilityContext", "onSubscribe", "", "key", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onQuery", "onDestroy", "Companion", "AudioManagerPlaybackListener", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8366b;
    private AtomicInteger c;
    private final Lazy d;
    private final Lazy e;
    private final Lazy f;
    private DeviceAudioStandardData g;

    /* JADX INFO: renamed from: com.obric.memorydata.ability.impl.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/ability/impl/AudioStateAbility$AudioManagerPlaybackListener;", "Landroid/media/AudioManager$AudioPlaybackCallback;", "<init>", "(Lcom/obric/memorydata/ability/impl/AudioStateAbility;)V", "onPlaybackConfigChanged", "", "configs", "", "Landroid/media/AudioPlaybackConfiguration;", "usageToString", "", "usage", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class C0419a extends AudioManager.AudioPlaybackCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8367a;

        public C0419a(a r1) {
            this.f8367a = r1;
        }

        private final String a(int r1) {
            if (r1 != 1) goto L5;
            return "media";
        L5:
            if (r1 != 2) goto L7;
            return "IM";
        L7:
            if (r1 != 4) goto L9;
            return NotificationCompat.CATEGORY_ALARM;
        L9:
            if (r1 != 5) goto L11;
            return "notification";
        L11:
            if (r1 != 6) goto L13;
            return "ringtone";
        L13:
            if (r1 == 10) goto L26;
            return null;
        L26:
            return "notification";
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> r28) {
            List<AudioPlaybackConfiguration> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
            super.onPlaybackConfigChanged(r1);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AudioStateAbility", "onPlaybackConfigChanged", false, 4, null);
            List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            long r14 = System.currentTimeMillis();
            HashSet r13 = new HashSet();
            if (r1 != null) goto L5;
            return;
        L5:
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
            a r12 = this.f8367a;
            Iterator r4 = r2.iterator();
        L6:
            Object r6 = null;
            if (r4.hasNext() == false) goto L53;
            AudioPlaybackConfiguration r5 = (AudioPlaybackConfiguration) ZeusTransformUtils.preCheckCast(r4.next(), AudioPlaybackConfiguration.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.utils.c r8 = com.obric.memorydata.utils.c.f13193a;
            Object r9 = ao.call(r5, "getClientUid", new Object[0]);
            Intrinsics.checkNotNullExpressionValue(r9, "call(...)");
            String r10 = r8.a(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue());
            if (r10 == null) goto L51;
            Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(ao.call(r5, "isActive", new Object[0]), Boolean.class, "com.obric.memorydata.plugin");
            String r15 = a(r5.getAudioAttributes().getUsage());
            AudioDeviceInfo r7 = r5.getAudioDeviceInfo();
            if (r7 == null) goto L13;
            Integer r16 = Integer.valueOf(r7.getType());
        L14:
            if (r16 != null) goto L17;
        L18:
            if (r16 == null) goto L51;
            if (r15 == null) goto L51;
            r13.add(r10);
            if (r11.booleanValue() == false) goto L25;
            a r17 = r12;
            Iterator r29 = r4;
            HashSet r18 = r13;
            AudioAppInfo r19 = new AudioAppInfo(true, r10, r15, r16.intValue(), r14, null, 32, null);
        L24:
            r3.add(r19);
        L52:
            r13 = r18;
            r12 = r17;
            r4 = r29;
            goto L6
        L25:
            r29 = r4;
            r17 = r12;
            r18 = r13;
            DeviceAudioStandardData r20 = a.a(r17);
            if (r20 == null) goto L48;
            List<AudioAppInfo> r21 = r20.getAppList();
            if (r21 == null) goto L48;
            Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L31:
            if (r22.hasNext() == false) goto L47;
            Object r110 = r22.next();
            AudioAppInfo r111 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r110, AudioAppInfo.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r111.getPackageName(), r10) == true) goto L35;
        L44:
            boolean r23 = false;
        L45:
            if (r23 == false) goto L31;
            r6 = r110;
            goto L47
        L35:
            if (r111.getActive() == false) goto L44;
            int r112 = r111.getOutputType();
            if (r16 == null) goto L44;
            if (r112 != r16.intValue()) goto L44;
            if (Intrinsics.areEqual(r111.getAudioType(), r15) == false) goto L44;
            r23 = true;
        L47:
            r6 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r6, AudioAppInfo.class, "com.obric.memorydata.plugin");
        L48:
            AudioAppInfo r113 = r6;
            if (r113 == 0) goto L52;
            r19 = AudioAppInfo.copy$default(r113, false, null, null, 0, 0, Long.valueOf(r14), 30, null);
            goto L24
        L17:
            if (r16.intValue() == 0) goto L51;
        L13:
            r16 = null;
        L51:
            r29 = r4;
            r17 = r12;
            r18 = r13;
            goto L52
        L53:
            HashSet r24 = r13;
            DeviceAudioStandardData r25 = a.a(this.f8367a);
            if (r25 == null) goto L69;
            List<AudioAppInfo> r26 = r25.getAppList();
            if (r26 == null) goto L69;
            Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin");
            Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r31 = r27.iterator();
        L59:
            if (r31.hasNext() == false) goto L68;
            Object r32 = r31.next();
            AudioAppInfo r33 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r32, AudioAppInfo.class, "com.obric.memorydata.plugin");
            if (r24.contains(r33.getPackageName()) == false) goto L63;
        L65:
            boolean r34 = false;
        L66:
            if (r34 == false) goto L59;
            r30.add(r32);
            goto L59
        L63:
            if (r33.getActive() == false) goto L65;
            r34 = true;
            goto L66
        L68:
            r6 = (List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin");
        L69:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AudioStateAbility", "missAudioState " + r6, false, 4, null);
            if (r6 == null) goto L75;
            Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L73:
            if (r35.hasNext() == false) goto L75;
            r3.add(AudioAppInfo.copy$default((AudioAppInfo) ZeusTransformUtils.preCheckCast(r35.next(), AudioAppInfo.class, "com.obric.memorydata.plugin"), false, null, null, 0, 0, Long.valueOf(r14), 30, null));
        L75:
            DeviceAudioStandardData r36 = new DeviceAudioStandardData(r3);
            a.a(this.f8367a, r36);
            com.obric.memorydata.ability.j r0 = a.b(this.f8367a);
            if (r0 == null) goto L94;
            r0.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r36, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ability/impl/AudioStateAbility$Companion;", "", "<init>", "()V", "TAG", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8365a = new b(null);
    }

    public a() {
        this.c = new AtomicInteger(0);
        this.d = LazyKt.lazy($$Lambda$a$6xrnI1u1IgDntTegN1dPMyTdD4.INSTANCE);
        this.e = LazyKt.lazy(new $$Lambda$a$cvT89smPNgXPhNOiOBfzvPX8JS8(this));
        this.f = LazyKt.lazy($$Lambda$a$Yp8fWlGL3yPks8ePJql6dhczbJU.INSTANCE);
    }

    public static final /* synthetic */ DeviceAudioStandardData a(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ void a(a r0, DeviceAudioStandardData r1) {
        r0.g = r1;
    }

    private final AudioManager b() {
        return (AudioManager) ZeusTransformUtils.preCheckCast(this.d.getValue(), AudioManager.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ com.obric.memorydata.ability.j b(a r0) {
        return r0.f8366b;
    }

    private final C0419a c() {
        return (C0419a) ZeusTransformUtils.preCheckCast(this.e.getValue(), C0419a.class, "com.obric.memorydata.plugin");
    }

    private static final C0419a c(a r1) {
        return new C0419a(r1);
    }

    private final Handler d() {
        return (Handler) ZeusTransformUtils.preCheckCast(this.f.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    private static final AudioManager e() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("audio");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) ZeusTransformUtils.preCheckCast(r0, AudioManager.class, "com.obric.memorydata.plugin");
    }

    private static final Handler f() {
        HandlerThread r0 = new HandlerThread("audio_track");
        r0.start();
        return new Handler(r0.getLooper());
    }

    /* JADX INFO: renamed from: lambda$6xrnI1u1IgD-ntTegN1dPMyTdD4, reason: not valid java name */
    public static /* synthetic */ AudioManager m435lambda$6xrnI1u1IgDntTegN1dPMyTdD4() {
        return e();
    }

    public static /* synthetic */ Handler lambda$Yp8fWlGL3yPks8ePJql6dhczbJU() {
        return f();
    }

    public static /* synthetic */ C0419a lambda$cvT89smPNgXPhNOiOBfzvPX8JS8(a r0) {
        return c(r0);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        d().removeCallbacksAndMessages(null);
        d().getLooper().quit();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8366b = r4;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r4, com.obric.memorydata.ability.f r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        i.a.b(this, r4, r5);
        if (this.c.incrementAndGet() != 1) goto L5;
        b().registerAudioPlaybackCallback((AudioManager.AudioPlaybackCallback) ZeusTransformUtils.preCheckCast(c(), AudioManager.AudioPlaybackCallback.class, "com.obric.memorydata.plugin"), d());
    L5:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        i.a.c(this, r2, r3);
        if (this.c.decrementAndGet() != 0) goto L7;
        b().unregisterAudioPlaybackCallback((AudioManager.AudioPlaybackCallback) ZeusTransformUtils.preCheckCast(c(), AudioManager.AudioPlaybackCallback.class, "com.obric.memorydata.plugin"));
        return true;
    L7:
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r2, com.obric.memorydata.ability.f r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        DeviceAudioStandardData r4 = this.g;
        if (r4 == null) goto L8;
        com.obric.memorydata.ability.j r1 = this.f8366b;
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.a((com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L8:
        return false;
    }
}
