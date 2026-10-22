package com.obric.aiagent.product.platform.impl.sleepmode;

import android.os.IBinder;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/sleepmode/CommonObricSleepModeManager;", "Lcom/obric/aiagent/product/platform/api/sleepmode/IObricSleepModeManager;", "<init>", "()V", "powerAdvisor", "", "inSleepMode", "", "forceExitSleepMode", "", "pkgName", "", "event", "getPowerAdvisor", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonObricSleepModeManager implements IObricSleepModeManager {
    public static final Companion Companion = null;
    public static final String TAG = "CommonObricSleepModeManager";
    private Object powerAdvisor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/sleepmode/CommonObricSleepModeManager$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CommonObricSleepModeManager() {
    }

    private final Object getPowerAdvisor() {
        monitor-enter(this);
        Object r0 = this.powerAdvisor;     // Catch: Throwable -> L18
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        Object r1 = null;
        Method r2 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r2.invoke(null, new Object[]{"poweradvisor"});     // Catch: Throwable -> L14
        Object r4 = ZeusTransformUtils.forName("android.os.IPowerAdvisor$Stub", "com.obric.memorydata.plugin").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r3});     // Catch: Throwable -> L14
        if (r4 == null) goto L12;
        this.powerAdvisor = r4;     // Catch: Throwable -> L14
        r1 = r4;
        goto L12
    L12:
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
    public void forceExitSleepMode(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "pkgName");
        Intrinsics.checkNotNullParameter(r9, "event");
        Object r7 = getPowerAdvisor();     // Catch: Throwable -> L8
        if (r7 != null) goto L6;
        return;
    L6:
        Method r0 = r7.getClass().getMethod("forceExitSleepMode", new Class[]{String.class, String.class});     // Catch: Throwable -> L8
        r0.setAccessible(true);     // Catch: Throwable -> L8
        r0.invoke(r7, new Object[]{r8, r9});     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager
    public boolean inSleepMode() {
        Object r4 = getPowerAdvisor();     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        return false;
    L6:
        Method r1 = r4.getClass().getMethod("inSleepMode", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r5 = r1.invoke(r4, new Object[0]);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L8
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
