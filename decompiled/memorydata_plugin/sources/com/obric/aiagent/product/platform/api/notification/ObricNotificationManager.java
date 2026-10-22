package com.obric.aiagent.product.platform.api.notification;

import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.impl.notification.AssistantNotificationManagerImpl;
import com.obric.aiagent.product.platform.impl.notification.CommonObricNotificationManager;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricNotificationManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricNotificationManager";
    private static IObricNotificationManager instance;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\bH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationManager$Companion;", "Lcom/obric/aiagent/product/platform/api/notification/IObricNotificationManager;", "<init>", "()V", "TAG", "", "instance", "registerNotificationListener", "", "listener", "Lcom/obric/aiagent/product/platform/api/notification/ObricNotificationListener;", "unregisterNotificationListener", "registerToastShowListener", "Lcom/obric/aiagent/product/platform/api/notification/ObricToastShowListener;", "unregisterToastShowListener", "isPanelShown", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricNotificationManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        @JvmStatic
        public boolean isPanelShown() {
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isPanelShown();
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        @JvmStatic
        public boolean registerNotificationListener(ObricNotificationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerNotificationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        @JvmStatic
        public boolean registerToastShowListener(ObricToastShowListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerToastShowListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        @JvmStatic
        public boolean unregisterNotificationListener(ObricNotificationListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterNotificationListener(r1);
        }

        @Override // com.obric.aiagent.product.platform.api.notification.IObricNotificationManager
        @JvmStatic
        public boolean unregisterToastShowListener(ObricToastShowListener r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            IObricNotificationManager r0 = ObricNotificationManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterToastShowListener(r1);
        }
    }

    static {
        Companion = new Companion(null);
    L10:
        th = move-exception;
        d.f5954a.b(TAG, "bind NotificationManager failed", th);
    L12:
        instance = (IObricNotificationManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricNotificationManager.class, false), IObricNotificationManager.class, "com.obric.memorydata.plugin");
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L10
        Class<IObricNotificationManager> r3 = IObricNotificationManager.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricNotificationManager$_aHqouhVeraalx9huZJhtVOYKEE.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L10
        d.f5954a.b(TAG, "bind NotificationManager assistantApi=" + a.f5964a.a());     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = f.a();     // Catch: Throwable -> L10
        r3 = IObricNotificationManager.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricNotificationManager$V4AfgAVHfb0N3Ba5TW0muNkWC5M.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        goto L6
    }

    public ObricNotificationManager() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantNotificationManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricNotificationManager();
    }

    public static final /* synthetic */ IObricNotificationManager access$getInstance$cp() {
        return instance;
    }

    @JvmStatic
    public static boolean isPanelShown() {
        return Companion.isPanelShown();
    }

    public static /* synthetic */ Object lambda$V4AfgAVHfb0N3Ba5TW0muNkWC5M() {
        return _init_$lambda$1();
    }

    public static /* synthetic */ Object lambda$_aHqouhVeraalx9huZJhtVOYKEE() {
        return _init_$lambda$0();
    }

    @JvmStatic
    public static boolean registerNotificationListener(ObricNotificationListener r1) {
        return Companion.registerNotificationListener(r1);
    }

    @JvmStatic
    public static boolean registerToastShowListener(ObricToastShowListener r1) {
        return Companion.registerToastShowListener(r1);
    }

    @JvmStatic
    public static boolean unregisterNotificationListener(ObricNotificationListener r1) {
        return Companion.unregisterNotificationListener(r1);
    }

    @JvmStatic
    public static boolean unregisterToastShowListener(ObricToastShowListener r1) {
        return Companion.unregisterToastShowListener(r1);
    }
}
