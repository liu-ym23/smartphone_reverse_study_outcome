package com.obric.aiagent.product.platform.api.app;

import android.content.Context;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.impl.app.AssistantActivityTaskManagerImpl;
import com.obric.aiagent.product.platform.impl.app.CommonObricActivityTaskManager;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityTaskManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricActivityTaskManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricActivityTaskManager";
    private static IObricActivityTaskManager instance;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0017J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0013H\u0017J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricActivityTaskManager$Companion;", "Lcom/obric/aiagent/product/platform/api/app/IObricActivityTaskManager;", "<init>", "()V", "TAG", "", "instance", "registerAppSwitchListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/app/ObricAppSwitchListener;", "unregisterAppSwitchListener", "registerActivitySwitchListener", "Lcom/obric/aiagent/product/platform/api/app/ObricActivitySwitchListener;", "unregisterActivitySwitchListener", "registerFocusListener", "Lcom/obric/aiagent/product/platform/api/app/ObricFocusListener;", "unregisterFocusListener", "registerSystemAnimationListener", "Lcom/obric/aiagent/product/platform/api/app/ObricSystemAnimationListener;", "unregisterSystemAnimationListener", "finishAndRemoveAllTask", "context", "Landroid/content/Context;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricActivityTaskManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean finishAndRemoveAllTask(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            IObricActivityTaskManager r3 = ObricActivityTaskManager.access$getInstance$cp();
            if (r3 != null) goto L7;
            return false;
        L7:
            return r3.finishAndRemoveAllTask(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean registerActivitySwitchListener(ObricActivitySwitchListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerActivitySwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean registerAppSwitchListener(ObricAppSwitchListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerAppSwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean registerFocusListener(ObricFocusListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerFocusListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean registerSystemAnimationListener(ObricSystemAnimationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerSystemAnimationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterActivitySwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean unregisterAppSwitchListener(ObricAppSwitchListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterAppSwitchListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean unregisterFocusListener(ObricFocusListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterFocusListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager
        @JvmStatic
        public boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricActivityTaskManager r0 = ObricActivityTaskManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterSystemAnimationListener(r1);
        }
    }

    static {
        Companion = new Companion(null);
    L9:
        th = move-exception;
        d.f5954a.b(TAG, "bind ObricActivityTaskManager failed", th);
    L11:
        instance = (IObricActivityTaskManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricActivityTaskManager.class, false), IObricActivityTaskManager.class, "com.obric.memorydata.plugin");
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r1 = f.a();     // Catch: Throwable -> L9
        Class<IObricActivityTaskManager> r2 = IObricActivityTaskManager.class;
        g r3 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricActivityTaskManager$cCkVbX5QOIZEIfjx3n1frEvFA9o.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L6:
        r1.a(r2, r3);     // Catch: Throwable -> L9
        goto L11
    L7:
        r1 = f.a();     // Catch: Throwable -> L9
        r2 = IObricActivityTaskManager.class;
        r3 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricActivityTaskManager$fpRK0mS2DWbaDTtL0vNJhGu1ts.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        goto L6
    }

    public ObricActivityTaskManager() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantActivityTaskManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricActivityTaskManager();
    }

    public static final /* synthetic */ IObricActivityTaskManager access$getInstance$cp() {
        return instance;
    }

    @JvmStatic
    public static boolean finishAndRemoveAllTask(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Companion.finishAndRemoveAllTask(r3);
    }

    public static /* synthetic */ Object lambda$cCkVbX5QOIZEIfjx3n1frEvFA9o() {
        return _init_$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$fpRK0mS2DWbaDTtL0vNJhGu1-ts, reason: not valid java name */
    public static /* synthetic */ Object m152lambda$fpRK0mS2DWbaDTtL0vNJhGu1ts() {
        return _init_$lambda$1();
    }

    @JvmStatic
    public static boolean registerActivitySwitchListener(ObricActivitySwitchListener r1) {
        return Companion.registerActivitySwitchListener(r1);
    }

    @JvmStatic
    public static boolean registerAppSwitchListener(ObricAppSwitchListener r1) {
        return Companion.registerAppSwitchListener(r1);
    }

    @JvmStatic
    public static boolean registerFocusListener(ObricFocusListener r1) {
        return Companion.registerFocusListener(r1);
    }

    @JvmStatic
    public static boolean registerSystemAnimationListener(ObricSystemAnimationListener r1) {
        return Companion.registerSystemAnimationListener(r1);
    }

    @JvmStatic
    public static boolean unregisterActivitySwitchListener(ObricActivitySwitchListener r1) {
        return Companion.unregisterActivitySwitchListener(r1);
    }

    @JvmStatic
    public static boolean unregisterAppSwitchListener(ObricAppSwitchListener r1) {
        return Companion.unregisterAppSwitchListener(r1);
    }

    @JvmStatic
    public static boolean unregisterFocusListener(ObricFocusListener r1) {
        return Companion.unregisterFocusListener(r1);
    }

    @JvmStatic
    public static boolean unregisterSystemAnimationListener(ObricSystemAnimationListener r1) {
        return Companion.unregisterSystemAnimationListener(r1);
    }
}
