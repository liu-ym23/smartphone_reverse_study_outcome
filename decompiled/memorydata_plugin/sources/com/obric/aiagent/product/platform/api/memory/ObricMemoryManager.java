package com.obric.aiagent.product.platform.api.memory;

import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.impl.memory.AssistantMemoryManagerImpl;
import com.obric.aiagent.product.platform.impl.memory.CommonObricMemoryManager;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricMemoryManager {
    public static final Companion Companion = null;
    private static final Lazy<String> KEY_IMAGE_URI$delegate = null;
    private static final Lazy<String> KEY_PACKAGE$delegate = null;
    private static final Lazy<String> KEY_TEXT$delegate = null;
    private static final Lazy<String> KEY_TIMESTAMP$delegate = null;
    private static final String TAG = "ObricMemoryManager";
    private static IObricMemoryManager instance;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0017J\b\u0010!\u001a\u00020\u0016H\u0017J \u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020&H\u0017J\b\u0010'\u001a\u00020\u0016H\u0017J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020,H\u0017J\b\u0010-\u001a\u00020\u0016H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u001b\u0010\u0012\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\t¨\u0006."}, d2 = {"Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryManager$Companion;", "Lcom/obric/aiagent/product/platform/api/memory/IObricMemoryManager;", "<init>", "()V", "TAG", "", "instance", "KEY_TEXT", "getKEY_TEXT", "()Ljava/lang/String;", "KEY_TEXT$delegate", "Lkotlin/Lazy;", "KEY_IMAGE_URI", "getKEY_IMAGE_URI", "KEY_IMAGE_URI$delegate", "KEY_PACKAGE", "getKEY_PACKAGE", "KEY_PACKAGE$delegate", "KEY_TIMESTAMP", "getKEY_TIMESTAMP", "KEY_TIMESTAMP$delegate", "doMemoryActionIfEnabled", "", "from", "", "extras", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "doMemoryAction", "registerMemoryActionCallback", "callback", "Lcom/obric/aiagent/product/platform/api/memory/ObricMemoryActionCallback;", "unregisterMemoryActionCallback", "reportSystemEvent", "event", "state", "registerSystemEventCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricSystemEventCallback;", "unregisterSystemEventCallback", "doScenePerceptionAction", "type", "reportScenePerceptionEvent", "registerScenePerceptionCallback", "Lcom/obric/aiagent/product/platform/api/memory/ObricScenePerceptionCallback;", "unregisterScenePerceptionCallback", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricMemoryManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void doMemoryAction(int r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.doMemoryAction(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "extras");
            Intrinsics.checkNotNullParameter(r1, "context");
            IObricMemoryManager r5 = ObricMemoryManager.access$getInstance$cp();
            if (r5 == null) goto L6;
            r5.doMemoryActionIfEnabled(r2, r3, r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void doScenePerceptionAction(int r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.doScenePerceptionAction(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_IMAGE_URI() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_IMAGE_URI$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_PACKAGE() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_PACKAGE$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_TEXT() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_TEXT$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        public String getKEY_TIMESTAMP() {
            return (String) ZeusTransformUtils.preCheckCast(ObricMemoryManager.access$getKEY_TIMESTAMP$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void registerMemoryActionCallback(ObricMemoryActionCallback r1) {
            Intrinsics.checkNotNullParameter(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerMemoryActionCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void registerScenePerceptionCallback(ObricScenePerceptionCallback r1) {
            Intrinsics.checkNotNullParameter(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerScenePerceptionCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void registerSystemEventCallback(ObricSystemEventCallback r1) {
            Intrinsics.checkNotNullParameter(r1, "callback");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.registerSystemEventCallback(r1);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void reportScenePerceptionEvent(int r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.reportScenePerceptionEvent(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void reportSystemEvent(int r1, int r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r3, "extras");
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.reportSystemEvent(r1, r2, r3);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void unregisterMemoryActionCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterMemoryActionCallback();
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void unregisterScenePerceptionCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterScenePerceptionCallback();
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.memory.IObricMemoryManager
        @JvmStatic
        public void unregisterSystemEventCallback() {
            IObricMemoryManager r0 = ObricMemoryManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.unregisterSystemEventCallback();
            return;
        }
    }

    static {
        Companion = new Companion(null);
    L10:
        th = move-exception;
        d.f5954a.b(TAG, "bind ObricMemoryManager failed", th);
    L12:
        instance = (IObricMemoryManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricMemoryManager.class, false), IObricMemoryManager.class, "com.obric.memorydata.plugin");
        d.f5954a.b(TAG, "ObricMemoryManager instance: " + instance);
        KEY_TEXT$delegate = LazyKt.lazy($$Lambda$ObricMemoryManager$ez16sigmcRNntUJCrG5fZwGdAR0.INSTANCE);
        KEY_IMAGE_URI$delegate = LazyKt.lazy($$Lambda$ObricMemoryManager$Jq8WIg68n06O0zwIHXfP_fIjnB8.INSTANCE);
        KEY_PACKAGE$delegate = LazyKt.lazy($$Lambda$ObricMemoryManager$JwZnDZSMnSmSDQmnfKrsEMTxvtk.INSTANCE);
        KEY_TIMESTAMP$delegate = LazyKt.lazy($$Lambda$ObricMemoryManager$3UUBangrkzoOxseQMzO3DXDkU.INSTANCE);
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L10
        Class<IObricMemoryManager> r3 = IObricMemoryManager.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricMemoryManager$J5lNKAzayfUmoe6SraeWLVGN9mc.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L10
        d.f5954a.b(TAG, "bind MemoryManager assistantApi= " + a.f5964a.a());     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = f.a();     // Catch: Throwable -> L10
        r3 = IObricMemoryManager.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricMemoryManager$fCTyfp1TUaL3d4osrH9miI1A8.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        goto L6
    }

    public ObricMemoryManager() {
    }

    private static final String KEY_IMAGE_URI_delegate$lambda$3() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_IMAGE_URI();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_PACKAGE_delegate$lambda$4() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_PACKAGE();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_TEXT_delegate$lambda$2() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_TEXT();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final String KEY_TIMESTAMP_delegate$lambda$5() {
        IObricMemoryManager r0 = instance;
        if (r0 == null) goto L6;
        String r1 = r0.getKEY_TIMESTAMP();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    private static final Object _init_$lambda$0() {
        return new AssistantMemoryManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricMemoryManager();
    }

    public static final /* synthetic */ IObricMemoryManager access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ Lazy access$getKEY_IMAGE_URI$delegate$cp() {
        return KEY_IMAGE_URI$delegate;
    }

    public static final /* synthetic */ Lazy access$getKEY_PACKAGE$delegate$cp() {
        return KEY_PACKAGE$delegate;
    }

    public static final /* synthetic */ Lazy access$getKEY_TEXT$delegate$cp() {
        return KEY_TEXT$delegate;
    }

    public static final /* synthetic */ Lazy access$getKEY_TIMESTAMP$delegate$cp() {
        return KEY_TIMESTAMP$delegate;
    }

    @JvmStatic
    public static void doMemoryAction(int r1, Bundle r2) {
        Companion.doMemoryAction(r1, r2);
    }

    @JvmStatic
    public static void doMemoryActionIfEnabled(int r2, Bundle r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Companion.doMemoryActionIfEnabled(r2, r3, r5);
    }

    @JvmStatic
    public static void doScenePerceptionAction(int r1, Bundle r2) {
        Companion.doScenePerceptionAction(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$3UUBangrkzoOx-s-eQMzO3DXDkU, reason: not valid java name */
    public static /* synthetic */ String m159lambda$3UUBangrkzoOxseQMzO3DXDkU() {
        return KEY_TIMESTAMP_delegate$lambda$5();
    }

    public static /* synthetic */ Object lambda$J5lNKAzayfUmoe6SraeWLVGN9mc() {
        return _init_$lambda$0();
    }

    public static /* synthetic */ String lambda$Jq8WIg68n06O0zwIHXfP_fIjnB8() {
        return KEY_IMAGE_URI_delegate$lambda$3();
    }

    public static /* synthetic */ String lambda$JwZnDZSMnSmSDQmnfKrsEMTxvtk() {
        return KEY_PACKAGE_delegate$lambda$4();
    }

    public static /* synthetic */ String lambda$ez16sigmcRNntUJCrG5fZwGdAR0() {
        return KEY_TEXT_delegate$lambda$2();
    }

    /* JADX INFO: renamed from: lambda$fC-T-yfp1TUaL3d4osrH9miI1A8, reason: not valid java name */
    public static /* synthetic */ Object m160lambda$fCTyfp1TUaL3d4osrH9miI1A8() {
        return _init_$lambda$1();
    }

    @JvmStatic
    public static void registerMemoryActionCallback(ObricMemoryActionCallback r1) {
        Companion.registerMemoryActionCallback(r1);
    }

    @JvmStatic
    public static void registerScenePerceptionCallback(ObricScenePerceptionCallback r1) {
        Companion.registerScenePerceptionCallback(r1);
    }

    @JvmStatic
    public static void registerSystemEventCallback(ObricSystemEventCallback r1) {
        Companion.registerSystemEventCallback(r1);
    }

    @JvmStatic
    public static void reportScenePerceptionEvent(int r1, Bundle r2) {
        Companion.reportScenePerceptionEvent(r1, r2);
    }

    @JvmStatic
    public static void reportSystemEvent(int r1, int r2, Bundle r3) {
        Companion.reportSystemEvent(r1, r2, r3);
    }

    @JvmStatic
    public static void unregisterMemoryActionCallback() {
        Companion.unregisterMemoryActionCallback();
    }

    @JvmStatic
    public static void unregisterScenePerceptionCallback() {
        Companion.unregisterScenePerceptionCallback();
    }

    @JvmStatic
    public static void unregisterSystemEventCallback() {
        Companion.unregisterSystemEventCallback();
    }
}
