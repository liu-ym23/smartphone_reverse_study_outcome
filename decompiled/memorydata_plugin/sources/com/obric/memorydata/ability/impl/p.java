package com.obric.memorydata.ability.impl;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u001c\u0010\u001e\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J \u0010&\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/ability/impl/ScreenStateAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "registered", "", "context", "Landroid/content/Context;", "mode2Keys", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/CopyOnWriteArraySet;", "lastData", "Lcom/obric/memorydata/ability/data/ScreenStateStandardData;", "state", "offTs", "", "onCreate", "", "iAbilityContext", "onSubscribe", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onUnsubscribe", "onQuery", "onDestroy", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", AwarenessManagerImpl.ACTION_SUBSCRIBE, "mode", "addSubscribeKey", "unsubscribe", "removeSubscribeKey", "publishStateData", InfoRequestQPSOptTraceLogger.REASON, "registerScreenOnBroadcast", "registerScreenOffBroadcast", "registerScreenUnlockBroadcast", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8407b;
    private boolean c;
    private Context d;
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<String>> e;
    private com.obric.memorydata.ability.data.p f;
    private String g;
    private long h;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/ability/impl/ScreenStateAbility$Companion;", "", "<init>", "()V", "TAG", "", "BROADCAST_ACTION_SCREEN_ON", "BROADCAST_ACTION_SCREEN_OFF", "BROADCAST_ACTION_SCREEN_UNLOCK", "STATE_ON", "STATE_OFF", "STATE_UNLOCK", "STATE_ALL", "UNKNOWN", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8406a = new a(null);
    }

    public p() {
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = new ConcurrentHashMap();
        this.g = "";
    }

    private final void a(String r5, String r6, String r7) {
        CopyOnWriteArraySet r8 = (CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(this.e.get(r5), CopyOnWriteArraySet.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        com.obric.memorydata.ability.data.p r0 = new com.obric.memorydata.ability.data.p(r6, r7);
        r0.a(this.h);
        if (Intrinsics.areEqual(r6, "unlock") == false) goto L19;
        com.obric.memorydata.ability.data.p r9 = this.f;
        if (r9 == null) goto L10;
        String r10 = r9.a();
    L12:
        if (Intrinsics.areEqual(r10, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L19;
        com.obric.memorydata.ability.data.p r11 = this.f;
        if (r11 == null) goto L17;
        String r12 = r11.b();
        if (r12 == null) goto L17;
    L18:
        r0.a(r12);
    L17:
        r12 = "unknown";
        goto L18
    L10:
        r10 = null;
    L19:
        this.f = r0;
        Iterator r13 = r8.iterator();
        Intrinsics.checkNotNullExpressionValue(r13, "iterator(...)");
    L21:
        if (r13.hasNext() == false) goto L23;
        com.obric.memorydata.ability.j r14 = this.f8407b;
        Intrinsics.checkNotNull(r14);
        Object r15 = r13.next();
        Intrinsics.checkNotNullExpressionValue(r15, "next(...)");
        r14.a((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
        goto L21
    }

    private final boolean a(String r4, String r5) {
        int r0 = r5.hashCode();
        if (r0 == (-840442044)) goto L23;
        if (r0 == 3551) goto L17;
        if (r0 == 109935) goto L10;
        return false;
    L10:
        if (r5.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L13;
        return false;
    L13:
        if (b(r5, r4) == true) goto L15;
        return true;
    L15:
        return c();
    L17:
        if (r5.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L19;
        return false;
    L19:
        if (b(r5, r4) == true) goto L21;
        return true;
    L21:
        return b();
    L23:
        if (r5.equals("unlock") == true) goto L27;
        return false;
    L27:
        if (b(r5, r4) == true) goto L29;
        return true;
    L29:
        return d();
    }

    private final boolean b() {
        this.c = true;
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.SCREEN_ON");
        ZeusTransformUtils.registerReceiver(this.d, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");
        return true;
    }

    private final boolean b(String r4, String r5) {
        if (this.e.get(r4) != null) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put(r4, new CopyOnWriteArraySet());
        boolean r0 = true;
    L6:
        CopyOnWriteArraySet<String> r3 = this.e.get(r4);
        Intrinsics.checkNotNull(r3);
        ((CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r3, CopyOnWriteArraySet.class, "com.obric.memorydata.plugin")).add(r5);
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean c() {
        this.c = true;
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.SCREEN_OFF");
        ZeusTransformUtils.registerReceiver(this.d, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");
        return true;
    }

    private final boolean c(String r3, String r4) {
        int r0 = r4.hashCode();
        if (r0 == (-840442044)) goto L19;
        if (r0 == 3551) goto L15;
        if (r0 == 109935) goto L10;
        return false;
    L10:
        if (r4.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L13;
        return false;
    L13:
        return d(r4, r3);
    L15:
        if (r4.equals(com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L17;
        return false;
    L17:
        return d(r4, r3);
    L19:
        if (r4.equals("unlock") == true) goto L23;
        return false;
    L23:
        return d(r4, r3);
    }

    private final boolean d() {
        this.c = true;
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.USER_PRESENT");
        ZeusTransformUtils.registerReceiver(this.d, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 2, "com.obric.memorydata.plugin");
        return true;
    }

    private final boolean d(String r7, String r8) {
        if (this.e.get(r7) == null) goto L12;
        CopyOnWriteArraySet<String> r0 = this.e.get(r7);
        Intrinsics.checkNotNull(r0);
        if (((CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r0, CopyOnWriteArraySet.class, "com.obric.memorydata.plugin")).contains(r8) == false) goto L15;
        CopyOnWriteArraySet<String> r1 = this.e.get(r7);
        Intrinsics.checkNotNull(r1);
        ((CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r1, CopyOnWriteArraySet.class, "com.obric.memorydata.plugin")).remove(r8);
        CopyOnWriteArraySet<String> r9 = this.e.get(r7);
        Intrinsics.checkNotNull(r9);
        if (((CopyOnWriteArraySet) ZeusTransformUtils.preCheckCast(r9, CopyOnWriteArraySet.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
        this.e.remove(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenStateAbility", "keySet empty of mode: " + r7, false, 4, null);
        return true;
    L14:
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        if (this.c == false) goto L6;
        ZeusTransformUtils.unregisterReceiver(this.d, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.c = false;
        return;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8407b = r4;
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f = null;
        this.g = "";
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r4, com.obric.memorydata.ability.f r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        Object r6 = r5.b().getOrDefault("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.String");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r7, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L14;
        if (a(r4, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L7;
    L11:
        return false;
    L7:
        if (a(r4, com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L11;
        if (a(r4, "unlock") == false) goto L11;
        return true;
    L14:
        return a(r4, r7);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r4, com.obric.memorydata.ability.f r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, TrackerImpl.PARAMS);
        Object r6 = r5.b().getOrDefault("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.String");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r7, LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL) == false) goto L13;
        if (c(r4, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L7;
    L11:
        return false;
    L7:
        if (c(r4, com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L11;
        if (c(r4, "unlock") == false) goto L11;
        return true;
    L13:
        return c(r4, r7);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r5, com.obric.memorydata.ability.f r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
        Object r7 = this.d.getSystemService("power");
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) ZeusTransformUtils.preCheckCast(r7, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive() == false) goto L8;
        Object r8 = this.d.getSystemService("keyguard");
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) ZeusTransformUtils.preCheckCast(r8, KeyguardManager.class, "com.obric.memorydata.plugin")).isDeviceLocked() == false) goto L7;
        String r9 = com.tom_roush.pdfbox.pdmodel.a.d.f.f;
    L10:
        if (Intrinsics.areEqual(r9, com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L12;
        this.h = System.currentTimeMillis();
    L12:
        com.obric.memorydata.ability.data.p r0 = this.f;
        if (r0 != null) goto L15;
    L20:
        com.obric.memorydata.ability.j r4 = this.f8407b;
        if (r4 == null) goto L23;
        r4.a(r5, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.ability.data.p(r9, "unknown"), com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L23:
        return true;
    L15:
        if (Intrinsics.areEqual(r0.a(), r9) == false) goto L20;
        com.obric.memorydata.ability.j r10 = this.f8407b;
        if (r10 == null) goto L19;
        r10.a(r5, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L19:
        return true;
    L7:
        r9 = "unlock";
        goto L10
    L8:
        r9 = com.tom_roush.pdfbox.pdmodel.a.d.f.g;
        goto L10
    }

    public void onReceive(Context r8, Intent r9) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")) == null) goto L27;
        if (r9 == null) goto L33;
        Bundle r10 = r9.getExtras();
        if (r10 == null) goto L10;
        String r11 = r10.getString(InfoRequestQPSOptTraceLogger.REASON);
        if (r11 == null) goto L10;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenStateAbility", "broadcast onReceive: " + r9.getAction() + ' ' + r11, false, 4, null);
        if (Intrinsics.areEqual("android.intent.action.SCREEN_ON", r9.getAction()) == false) goto L18;
        String r12 = this.g;
        String r0 = com.tom_roush.pdfbox.pdmodel.a.d.f.f;
        if (Intrinsics.areEqual(r12, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == true) goto L28;
    L15:
        this.g = r0;
    L16:
        a(r0, r0, r11);
        return;
    L28:
        return;
    L18:
        if (Intrinsics.areEqual("android.intent.action.SCREEN_OFF", r9.getAction()) == false) goto L23;
        String r13 = this.g;
        r0 = com.tom_roush.pdfbox.pdmodel.a.d.f.g;
        if (Intrinsics.areEqual(r13, com.tom_roush.pdfbox.pdmodel.a.d.f.g) == true) goto L30;
        this.g = com.tom_roush.pdfbox.pdmodel.a.d.f.g;
        this.h = System.currentTimeMillis();
        goto L16
    L30:
        return;
    L23:
        if (Intrinsics.areEqual("android.intent.action.USER_PRESENT", r9.getAction()) == false) goto L31;
        r0 = "unlock";
        if (Intrinsics.areEqual(this.g, "unlock") == false) goto L15;
        return;
    L31:
        return;
    L10:
        r11 = "unknown";
        goto L11
    L33:
        return;
    }
}
