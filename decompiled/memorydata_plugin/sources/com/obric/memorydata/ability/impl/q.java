package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u000f\u0018\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u001e\u0010#\u001a\u00020 2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020 H\u0002J\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/ability/impl/SettingsChangedAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "key2Mode", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mode2keys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "modeList", "", "airplaneModeContentObserver", "com/obric/memorydata/ability/impl/SettingsChangedAbility$airplaneModeContentObserver$2$1", "getAirplaneModeContentObserver", "()Lcom/obric/memorydata/ability/impl/SettingsChangedAbility$airplaneModeContentObserver$2$1;", "airplaneModeContentObserver$delegate", "Lkotlin/Lazy;", "isRegisterAirplaneModeMonitor", "powerManager", "Landroid/os/PowerManager;", "powerSaveModeBroadcastReceiver", "com/obric/memorydata/ability/impl/SettingsChangedAbility$powerSaveModeBroadcastReceiver$2$1", "getPowerSaveModeBroadcastReceiver", "()Lcom/obric/memorydata/ability/impl/SettingsChangedAbility$powerSaveModeBroadcastReceiver$2$1;", "powerSaveModeBroadcastReceiver$delegate", "isRegisterPowerSaveModeMonitor", "prePowerSaveModeValue", "", "onCreate", "", "iAbilityContext", "onDestroy", "publishToMode", "settingsChangedStandardData", "Lcom/obric/memorydata/ability/data/SettingsChangedStandardData;", "registerAirplaneModeMonitor", "unregisterAirplaneModeMonitor", "registerPowerSaveModeMonitor", "unregisterPowerSaveModeMonitor", "onSubscribe", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8409b;
    private final ConcurrentHashMap<String, String> c;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<String, Boolean>> d;
    private final List<String> e;
    private final Lazy f;
    private boolean g;
    private PowerManager h;
    private final Lazy i;
    private boolean j;
    private int k;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/ability/impl/SettingsChangedAbility$Companion;", "", "<init>", "()V", "TAG", "", "MODE_KEY", "MODE_AIRPLANE", "MODE_POWER_SAVE", "MODE_ALL", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/ability/impl/SettingsChangedAbility$airplaneModeContentObserver$2$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f8410a;

        b(q r1, Handler r2) {
            this.f8410a = r1;
            super(r2);
        }

        private static final void a(q r4) {
            com.obric.memorydata.ability.j r0 = q.a(r4);
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
            r0 = null;
        L5:
            int r1 = Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "airplane_mode_on", -1);
            RunLog.INSTANCE.debug("SettingsChangedAbility", "airplaneModeContentObserver onChange called.Now value is " + r1);
            q.a(r4, CollectionsKt.listOf(new String[]{"airplane", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL}), new com.obric.memorydata.ability.data.q("airplane", r1));
        }

        /* JADX INFO: renamed from: lambda$bI-yNetF_FiRPS3Yfjsjnl89ImY, reason: not valid java name */
        public static /* synthetic */ void m441lambda$bIyNetF_FiRPS3Yfjsjnl89ImY(q r0) {
            a(r0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            ThreadPoolContainer r3 = ThreadPoolContainer.Companion.getInstance();
            final q r1 = this.f8410a;
            r3.execute(new $$Lambda$q$b$bIyNetF_FiRPS3Yfjsjnl89ImY(r1));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/ability/impl/SettingsChangedAbility$powerSaveModeBroadcastReceiver$2$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f8411a;

        c(q r1) {
            this.f8411a = r1;
        }

        private static final void a(q r4) {
            PowerManager r0 = q.b(r4);
            Intrinsics.checkNotNull(r0);
            boolean r1 = r0.isPowerSaveMode();
            if (q.c(r4) != r1) goto L5;
            return;
        L5:
            q.a(r4, r1 ? 1 : 0);
            RunLog.INSTANCE.debug("SettingsChangedAbility", "powerSaveModeBroadcastReceiver onReceive called.Now value is " + (r1 ? 1 : 0));
            q.a(r4, CollectionsKt.listOf(new String[]{"power_save", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL}), new com.obric.memorydata.ability.data.q("power_save", r1 ? 1 : 0));
        }

        public static /* synthetic */ void lambda$nnAR2CN6Bsl2JxDv7zUQpOF5wHY(q r0) {
            a(r0);
        }

        public void onReceive(Context r2, Intent r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            ThreadPoolContainer r5 = ThreadPoolContainer.Companion.getInstance();
            final q r1 = this.f8411a;
            r5.execute(new $$Lambda$q$c$nnAR2CN6Bsl2JxDv7zUQpOF5wHY(r1));
        }
    }

    static {
        f8408a = new a(null);
    }

    public q() {
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = CollectionsKt.listOf(new String[]{"airplane", "power_save", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL});
        this.f = LazyKt.lazy(new $$Lambda$q$yBreAlkbCqpuetVL8uwKDDikVY(this));
        this.i = LazyKt.lazy(new $$Lambda$q$0cu5kc8lhCM3tK4pMw26I9bdbY(this));
        this.k = -1;
    }

    public static final /* synthetic */ com.obric.memorydata.ability.j a(q r0) {
        return r0.f8409b;
    }

    public static final /* synthetic */ void a(q r0, int r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ void a(q r2, List r3, com.obric.memorydata.ability.data.q r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(List<String> r6, com.obric.memorydata.ability.data.q r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r1 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.d.get(r0), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L4;
        Iterator r2 = r1.iterator();
        Intrinsics.checkNotNullExpressionValue(r2, "iterator(...)");
    L9:
        if (r2.hasNext() == false) goto L4;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.ability.j r4 = this.f8409b;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r4 = null;
    L13:
        Intrinsics.checkNotNull(r3);
        r4.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L9
    }

    public static final /* synthetic */ PowerManager b(q r0) {
        return r0.h;
    }

    private final b b() {
        return (b) ZeusTransformUtils.preCheckCast(this.f.getValue(), b.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ int c(q r0) {
        return r0.k;
    }

    private final c c() {
        return (c) ZeusTransformUtils.preCheckCast(this.i.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private static final b d(q r2) {
        return new b(r2, new Handler(Looper.getMainLooper()));
    }

    private final void d() {
        if (this.g == false) goto L5;
        return;
    L5:
        this.g = true;
        com.obric.memorydata.ability.j r0 = this.f8409b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r0 = null;
    L8:
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Settings.Global.getUriFor("airplane_mode_on"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(b(), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private static final c e(q r1) {
        return new c(r1);
    }

    private final void e() {
        if (this.g == true) goto L5;
        return;
    L5:
        this.g = false;
        com.obric.memorydata.ability.j r0 = this.f8409b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r0 = null;
    L8:
        ZeusProviderTransform.unregisterContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), (ContentObserver) ZeusTransformUtils.preCheckCast(b(), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private final void f() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        IntentFilter r0 = new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED");
        com.obric.memorydata.ability.j r1 = this.f8409b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r1 = null;
    L8:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(c(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r0, 2, "com.obric.memorydata.plugin");
    }

    private final void g() {
        if (this.j == true) goto L5;
        return;
    L5:
        this.j = false;
        com.obric.memorydata.ability.j r0 = this.f8409b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r0 = null;
    L8:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(c(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$0cu5kc8lhCM3tK4pM-w26I9bdbY, reason: not valid java name */
    public static /* synthetic */ c m439lambda$0cu5kc8lhCM3tK4pMw26I9bdbY(q r0) {
        return e(r0);
    }

    /* JADX INFO: renamed from: lambda$yBreAlkbCq-puetVL8uwKDDikVY, reason: not valid java name */
    public static /* synthetic */ b m440lambda$yBreAlkbCqpuetVL8uwKDDikVY(q r0) {
        return d(r0);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        this.c.clear();
        Iterator<String> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        ConcurrentHashMap.KeySetView r2 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.d.get(r1), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r2.clear();
        goto L4
    L8:
        this.d.clear();
        this.h = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r5) {
        com.obric.memorydata.ability.j r6 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "iAbilityContext");
        this.f8409b = r6;
        Iterator<String> r7 = this.e.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r0, ConcurrentHashMap.newKeySet());
        goto L4
    L6:
        com.obric.memorydata.ability.j r8 = this.f8409b;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("abilityContext");
        r8 = null;
    L9:
        Object r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.os.PowerManager");
        this.h = (PowerManager) ZeusTransformUtils.preCheckCast(r9, PowerManager.class, "com.obric.memorydata.plugin");
        this.k = -1;
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
        String r5 = "SettingsChangedAbility";
        String r6 = "onSubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.c.containsKey(r11) == false) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "SettingsChangedAbility";
        r6 = "onSubscribe: this key has not unsubscribe.";
        goto L8
    L14:
        if (this.e.contains(r14) == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "SettingsChangedAbility";
        r6 = "onSubscribe: mode error.";
        goto L8
    L16:
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r11, r14);
        ConcurrentHashMap.KeySetView<String, Boolean> r1 = this.d.get(r14);
        Intrinsics.checkNotNull(r1);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r1, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r11);
        if (Intrinsics.areEqual(r14, "airplane") == false) goto L19;
    L20:
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.d.get("airplane");
        Intrinsics.checkNotNull(r15);
        int r16 = ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size();
        ConcurrentHashMap.KeySetView<String, Boolean> r2 = this.d.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r2);
        if ((r16 + ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r2, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size()) != 1) goto L24;
        d();
    L24:
        if (Intrinsics.areEqual(r14, "power_save") == false) goto L26;
    L27:
        ConcurrentHashMap.KeySetView<String, Boolean> r17 = this.d.get("power_save");
        Intrinsics.checkNotNull(r17);
        int r18 = ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r17, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size();
        ConcurrentHashMap.KeySetView<String, Boolean> r19 = this.d.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r19);
        if ((r18 + ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r19, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size()) != 1) goto L30;
        f();
    L30:
        return true;
    L26:
        if (Intrinsics.areEqual(r14, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L30;
    L19:
        if (Intrinsics.areEqual(r14, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L24;
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
        String r5 = "SettingsChangedAbility";
        String r6 = "onUnsubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.c.containsKey(r11) == true) goto L14;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "SettingsChangedAbility";
        r6 = "onUnsubscribe: this key has not subscribe";
        goto L8
    L14:
        if (this.e.contains(r14) == true) goto L16;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "SettingsChangedAbility";
        r6 = "onUnsubscribe: mode error.";
        goto L8
    L16:
        this.c.remove(r11);
        ConcurrentHashMap.KeySetView<String, Boolean> r1 = this.d.get(r14);
        Intrinsics.checkNotNull(r1);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r1, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).remove(r11);
        if (Intrinsics.areEqual(r14, "airplane") == false) goto L19;
    L20:
        ConcurrentHashMap.KeySetView<String, Boolean> r15 = this.d.get("airplane");
        Intrinsics.checkNotNull(r15);
        int r16 = ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r15, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size();
        ConcurrentHashMap.KeySetView<String, Boolean> r2 = this.d.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r2);
        if ((r16 + ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r2, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size()) != 0) goto L24;
        e();
    L24:
        if (Intrinsics.areEqual(r14, "power_save") == false) goto L26;
    L27:
        ConcurrentHashMap.KeySetView<String, Boolean> r17 = this.d.get("power_save");
        Intrinsics.checkNotNull(r17);
        int r18 = ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r17, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size();
        ConcurrentHashMap.KeySetView<String, Boolean> r19 = this.d.get(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r19);
        if ((r18 + ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r19, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).size()) != 0) goto L30;
        g();
    L30:
        return true;
    L26:
        if (Intrinsics.areEqual(r14, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L30;
    L19:
        if (Intrinsics.areEqual(r14, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L24;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        return i.a.a(this, r1, r2);
    }
}
