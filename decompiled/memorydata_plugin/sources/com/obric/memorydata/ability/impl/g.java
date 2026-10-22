package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J0\u0010%\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\fj\b\u0012\u0004\u0012\u00020\u000b`\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/ability/impl/FloatWindowAbility;", "Landroid/content/BroadcastReceiver;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "context", "Landroid/content/Context;", "mode2Keys", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "cacheData", "Lcom/obric/memorydata/ability/data/FloatWindowStandardData;", "handler", "Landroid/os/Handler;", "onReceive", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "iAbilityContext", "onQuery", "", "key", TrackerImpl.PARAMS, "Lcom/obric/memorydata/ability/AbilityParams;", "onSubscribe", "onUnsubscribe", "onDestroy", "registerReceiver", "unregisterReceiver", "addSubscribeKey", "mode", "removeSubscribeKey", "publishStateData", "state", ObricMemoryConstants.KEY_PACKAGE_NAME, "title", "versionName", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g extends PluginBroadcastReceiver implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8378a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8379b;
    private Context c;
    private final ConcurrentHashMap<String, HashSet<String>> d;
    private com.obric.memorydata.ability.data.f e;
    private final Handler f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/ability/impl/FloatWindowAbility$Companion;", "", "<init>", "()V", "TAG", "", "ENTER_FLOAT_WINDOW_INTENT", "EXIT_FLOAT_WINDOW_INTENT", "mode", "show", "dismiss", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8378a = new a(null);
    }

    public g() {
        this.d = new ConcurrentHashMap();
        this.f = new Handler(Looper.getMainLooper());
    }

    private final void a(String r4, String r5) {
        if (this.d.get(r4) != null) goto L5;
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r4, new HashSet());
    L5:
        HashSet<String> r3 = this.d.get(r4);
        Intrinsics.checkNotNull(r3);
        ((HashSet) ZeusTransformUtils.preCheckCast(r3, HashSet.class, "com.obric.memorydata.plugin")).add(r5);
    }

    private final void b(String r4, String r5) {
        if (this.d.get(r4) == null) goto L11;
        HashSet<String> r0 = this.d.get(r4);
        Intrinsics.checkNotNull(r0);
        if (((HashSet) ZeusTransformUtils.preCheckCast(r0, HashSet.class, "com.obric.memorydata.plugin")).contains(r5) == false) goto L13;
        HashSet<String> r1 = this.d.get(r4);
        Intrinsics.checkNotNull(r1);
        ((HashSet) ZeusTransformUtils.preCheckCast(r1, HashSet.class, "com.obric.memorydata.plugin")).remove(r5);
        HashSet<String> r6 = this.d.get(r4);
        Intrinsics.checkNotNull(r6);
        if (((HashSet) ZeusTransformUtils.preCheckCast(r6, HashSet.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
        this.d.remove(r4);
        return;
    L12:
        return;
    L13:
        return;
    }

    private final void registerReceiver() {
    }

    private final void unregisterReceiver() {
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        unregisterReceiver();
        this.c = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");
        this.e = null;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r3) {
        com.obric.memorydata.ability.j r4 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "iAbilityContext");
        this.f8379b = r4;
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = null;
        registerReceiver();
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r3, com.obric.memorydata.ability.f r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Object r5 = r4.b().getOrDefault("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        if (Intrinsics.areEqual(r5, "show") == false) goto L6;
        a("show", r3);
        return true;
    L6:
        if (Intrinsics.areEqual(r5, "dismiss") == true) goto L9;
        a("show", r3);
    L9:
        a("dismiss", r3);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r3, com.obric.memorydata.ability.f r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
        Object r5 = r4.b().getOrDefault("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
        if (Intrinsics.areEqual(r5, "show") == false) goto L6;
        b("show", r3);
        return true;
    L6:
        if (Intrinsics.areEqual(r5, "dismiss") == true) goto L9;
        b("show", r3);
    L9:
        b("dismiss", r3);
        return true;
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r1, com.obric.memorydata.ability.f r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, TrackerImpl.PARAMS);
        return false;
    }

    public void onReceive(Context r1, Intent r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }
}
