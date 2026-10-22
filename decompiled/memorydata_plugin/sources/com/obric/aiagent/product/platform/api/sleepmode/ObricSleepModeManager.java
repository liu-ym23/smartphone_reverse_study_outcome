package com.obric.aiagent.product.platform.api.sleepmode;

import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.a;
import com.obric.aiagent.product.platform.impl.sleepmode.AssistantSleepModeManagerImpl;
import com.obric.aiagent.product.platform.impl.sleepmode.CommonObricSleepModeManager;
import com.ss.android.ugc.aweme.framework.services.f;
import com.ss.android.ugc.aweme.framework.services.g;
import com.ss.android.ugc.aweme.framework.services.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/aiagent/product/platform/api/sleepmode/ObricSleepModeManager;", "", "<init>", "()V", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricSleepModeManager {
    public static final Companion Companion = null;
    private static final String TAG = "ObricSleepModeManager";
    private static IObricSleepModeManager instance;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0017J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/product/platform/api/sleepmode/ObricSleepModeManager$Companion;", "Lcom/obric/aiagent/product/platform/api/sleepmode/IObricSleepModeManager;", "<init>", "()V", "TAG", "", "instance", "inSleepMode", "", "forceExitSleepMode", "", "pkgName", "event", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements IObricSleepModeManager {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
        @JvmStatic
        public void forceExitSleepMode(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "pkgName");
            Intrinsics.checkNotNullParameter(r2, "event");
            IObricSleepModeManager r0 = ObricSleepModeManager.access$getInstance$cp();
            if (r0 == null) goto L6;
            r0.forceExitSleepMode(r1, r2);
            return;
        }

        @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
        @JvmStatic
        public boolean inSleepMode() {
            IObricSleepModeManager r0 = ObricSleepModeManager.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.inSleepMode();
        }
    }

    static {
        Companion = new Companion(null);
    L10:
        th = move-exception;
        d.f5954a.b(TAG, "bind SleepModeManager failed", th);
    L12:
        instance = (IObricSleepModeManager) ZeusTransformUtils.preCheckCast(f.a().a(IObricSleepModeManager.class, false), IObricSleepModeManager.class, "com.obric.memorydata.plugin");
        return;
    L4:
        if (a.f5964a.a() == false) goto L7;
        f r2 = f.a();     // Catch: Throwable -> L10
        Class<IObricSleepModeManager> r3 = IObricSleepModeManager.class;
        g r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricSleepModeManager$moVNdFGPPHfXsMRM4yeoHiROGs.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        r2.a(r3, r4);     // Catch: Throwable -> L10
        d.f5954a.b(TAG, "bind SleepModeManager success");     // Catch: Throwable -> L10
        goto L12
    L7:
        r2 = f.a();     // Catch: Throwable -> L10
        r3 = IObricSleepModeManager.class;
        r4 = (g) ZeusTransformUtils.preCheckCast(new h($$Lambda$ObricSleepModeManager$SVH8lhFhg7J45Jn8nE1d6rYXVQ.INSTANCE), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        goto L6
    }

    public ObricSleepModeManager() {
    }

    private static final Object _init_$lambda$0() {
        return new AssistantSleepModeManagerImpl();
    }

    private static final Object _init_$lambda$1() {
        return new CommonObricSleepModeManager();
    }

    public static final /* synthetic */ IObricSleepModeManager access$getInstance$cp() {
        return instance;
    }

    @JvmStatic
    public static void forceExitSleepMode(String r1, String r2) {
        Companion.forceExitSleepMode(r1, r2);
    }

    @JvmStatic
    public static boolean inSleepMode() {
        return Companion.inSleepMode();
    }

    /* JADX INFO: renamed from: lambda$SVH8lhFhg-7J45Jn8nE1d6rYXVQ, reason: not valid java name */
    public static /* synthetic */ Object m171lambda$SVH8lhFhg7J45Jn8nE1d6rYXVQ() {
        return _init_$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$m-oVNdFGPPHfXsMRM4yeoHiROGs, reason: not valid java name */
    public static /* synthetic */ Object m172lambda$moVNdFGPPHfXsMRM4yeoHiROGs() {
        return _init_$lambda$0();
    }
}
