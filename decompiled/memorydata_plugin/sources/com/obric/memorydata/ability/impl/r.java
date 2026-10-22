package com.obric.memorydata.ability.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.provider.Settings;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.ao;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u001e\u0010\u001c\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u001c\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010-\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/ability/impl/StreamVolumeAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "subscriberCount", "", "isRegisterVolumeChangeReceiver", "", "key2Mode", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mode2keys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "modeList", "", "onCreate", "", "iAbilityContext", "onDestroy", "publishToMode", "streamVolumeStandardData", "Lcom/obric/memorydata/ability/data/StreamVolumeStandardData;", "getCurrentStreamVolume", "getVibrationEnable", "onQuery", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "registerVolumeChangeReceiver", "unregisterVolumeChangeReceiver", "onReceive", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onSubscribe", "onUnsubscribe", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8412a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8413b;
    private final Lazy c;
    private int d;
    private boolean e;
    private final ConcurrentHashMap<String, String> f;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<String, Boolean>> g;
    private final List<String> h;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/ability/impl/StreamVolumeAbility$Companion;", "", "<init>", "()V", "TAG", "", "MODE_KEY", "MODE_STREAM_VOLUME", "MODE_RINGER_MODE", "MODE_ALL", "ACTION_VOLUME_CHANGED", "EXTRA_VOLUME_STREAM_TYPE", "STREAM_ASSISTANT", "", "GLOBAL_VIBRATION_ENABLED", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8412a = new a(null);
    }

    public r() {
        this.c = LazyKt.lazy($$Lambda$r$UtaZLETiUHJSAaYgeGAlTKxrDmc.INSTANCE);
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = CollectionsKt.listOf(new String[]{"stream_volume", "ringer_mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
    }

    private static final Integer a(r r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamVolumeAbility", "ReflectUtils.call: getRingerModeInternal", false, 4, null);
        return (Integer) ZeusTransformUtils.preCheckCast(ao.call(r9.b(), "getRingerModeInternal", new Object[0]), Integer.class, "com.obric.memorydata.plugin");
    }

    private static final Integer a(r r4, Exception r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        RunLog.INSTANCE.error("StreamVolumeAbility", "on Error: " + r5.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
        return Integer.valueOf(r4.b().getRingerMode());
    }

    private final void a(List<String> r6, com.obric.memorydata.ability.data.r r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r1 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.g.get(r0), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        Iterator r2 = r1.iterator();
        Intrinsics.checkNotNullExpressionValue(r2, "iterator(...)");
    L9:
        if (r2.hasNext() == false) goto L4;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r4 = this.f8413b;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        r4.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L9
    }

    private final AudioManager b() {
        return (AudioManager) ZeusTransformUtils.preCheckCast(this.c.getValue(), AudioManager.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.ability.data.r c() {
        AudioManager r1 = b();
        int r8 = (int) ((((double) r1.getStreamVolume(0)) * 100.0d) / ((double) r1.getStreamMaxVolume(0)));
        int r9 = (int) ((((double) r1.getStreamVolume(1)) * 100.0d) / ((double) r1.getStreamMaxVolume(1)));
        int r10 = (int) ((((double) r1.getStreamVolume(2)) * 100.0d) / ((double) r1.getStreamMaxVolume(2)));
        int r11 = (int) ((((double) r1.getStreamVolume(3)) * 100.0d) / ((double) r1.getStreamMaxVolume(3)));
        int r12 = (int) ((((double) r1.getStreamVolume(4)) * 100.0d) / ((double) r1.getStreamMaxVolume(4)));
        int r13 = (int) ((((double) r1.getStreamVolume(5)) * 100.0d) / ((double) r1.getStreamMaxVolume(5)));
        int r15 = (int) ((((double) r1.getStreamVolume(11)) * 100.0d) / ((double) r1.getStreamMaxVolume(11)));
        int r16 = d();
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$r$dyi7N19CdO7D0Na1krfs3IK8dU(this), new $$Lambda$r$xyZW0Uthzi7DSgiDKQUx6ekBoco(this)), Integer.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        int r0 = r2.intValue();
    L6:
        int r14 = r0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamVolumeAbility", "ringerMode: " + r14, false, 4, null);
        return new com.obric.memorydata.ability.data.r(r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L5:
        r0 = b().getRingerMode();
        goto L6
    }

    private final int d() {
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L6;
        return Settings.Global.getInt(r2, "global_vibration_enabled", 0);
    L6:
        return Settings.System.getInt(r2, "haptic_feedback_enabled", 0);
    }

    private final void e() {
        if (this.e == false) goto L5;
        return;
    L5:
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.media.VOLUME_CHANGED_ACTION");
        r0.addAction("android.media.RINGER_MODE_CHANGED");
        com.obric.memorydata.ability.j r1 = this.f8413b;
        Intrinsics.checkNotNull(r1);
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
        this.e = true;
    }

    private final void f() {
        if (this.e == true) goto L5;
        return;
    L5:
        com.obric.memorydata.ability.j r0 = this.f8413b;
        Intrinsics.checkNotNull(r0);
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = false;
    }

    private static final AudioManager g() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("audio");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) ZeusTransformUtils.preCheckCast(r0, AudioManager.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ AudioManager lambda$UtaZLETiUHJSAaYgeGAlTKxrDmc() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$dyi7N19Cd-O7D0Na1krfs3IK8dU, reason: not valid java name */
    public static /* synthetic */ Integer m442lambda$dyi7N19CdO7D0Na1krfs3IK8dU(r r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Integer lambda$xyZW0Uthzi7DSgiDKQUx6ekBoco(r r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.d = 0;
        this.f.clear();
        Iterator<String> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r2 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.g.get(r1), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r2.clear();
        goto L4
    L8:
        this.g.clear();
        f();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r5) {
        com.obric.memorydata.ability.j r6 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "iAbilityContext");
        this.f8413b = r6;
        Iterator<String> r7 = this.h.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.memorydata.plugin")).put(r0, ConcurrentHashMap.newKeySet());
        goto L4
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r7 = null;
        int r8 = 4;
        Object r9 = null;
        String r5 = "StreamVolumeAbility";
        String r6 = "onSubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.f.containsKey(r11) == false) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "StreamVolumeAbility";
        r6 = "onSubscribe: this key has not unsubscribe.";
        goto L8
    L14:
        if (this.h.contains(r14) == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "StreamVolumeAbility";
        r6 = "onSubscribe: mode error.";
        goto L8
    L16:
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.memorydata.plugin")).put(r11, r14);
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.g.get(r14);
        Intrinsics.checkNotNull(r15);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r11);
        int r16 = this.d + 1;
        this.d = r16;
        if (r16 != 1) goto L19;
        e();
    L19:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r7 = null;
        int r8 = 4;
        Object r9 = null;
        String r5 = "StreamVolumeAbility";
        String r6 = "onUnsubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.f.containsKey(r11) == true) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "StreamVolumeAbility";
        r6 = "onUnsubscribe: this key has not subscribe";
        goto L8
    L14:
        if (this.h.contains(r14) == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "StreamVolumeAbility";
        r6 = "onUnsubscribe: mode error.";
        goto L8
    L16:
        this.f.remove(r11);
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.g.get(r14);
        Intrinsics.checkNotNull(r15);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).remove(r11);
        int r16 = this.d - 1;
        this.d = r16;
        if (r16 != 0) goto L19;
        f();
    L19:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r3, com.obric.memorydata.ability.f r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        com.obric.memorydata.ability.j r5 = this.f8413b;
        Intrinsics.checkNotNull(r5);
        r5.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(c(), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public void onReceive(Context r7, Intent r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamVolumeAbility", "onReceive intent is null,return.", null, 4, null);
        return;
    L6:
        String r10 = r8.getAction();
        if (r10 == null) goto L23;
        int r0 = r10.hashCode();
        if (r0 == (-1940635523)) goto L19;
        if (r0 == 2070024785) goto L14;
        return;
    L14:
        if (r10.equals("android.media.RINGER_MODE_CHANGED") == false) goto L28;
        List<String> r11 = CollectionsKt.listOf(new String[]{"ringer_mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
    L17:
        a(r11, c());
        return;
    L28:
        return;
    L19:
        if (r10.equals("android.media.VOLUME_CHANGED_ACTION") == false) goto L25;
        int r12 = r8.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
        if (CollectionsKt.listOf(new Integer[]{0, 1, 2, 3, 4, 5, 11}).contains(Integer.valueOf(r12)) == false) goto L26;
        r11 = CollectionsKt.listOf(new String[]{"stream_volume", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
        goto L17
    L26:
        return;
    L25:
        return;
    }
}
