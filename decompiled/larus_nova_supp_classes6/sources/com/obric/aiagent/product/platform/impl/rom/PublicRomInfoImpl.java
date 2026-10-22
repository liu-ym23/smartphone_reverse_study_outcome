package com.obric.aiagent.product.platform.impl.rom;

import android.os.Build;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\rH\u0016J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0018H\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PublicRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "sysDeviceId", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryInit", "", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getDeviceBrand", "getDeviceModel", "getFwkApiVersion", "", "getOSReleaseDate", "getOSVersion", "getRomBuildType", "getRomReleaseRegion", "getShortOSVersion", "isOautoModelPreinstalled", "", "context", "Landroid/content/Context;", "isUTRom", "useAssistantApi", "Companion", "product-platform_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PublicRomInfoImpl implements IRomInfo {
    public static final /* synthetic */ int d = 0;
    public final /* synthetic */ CommonRomInfoImpl a;
    public volatile String b;
    public final MutexImpl c;

    static {
    }

    public final String b() {
        return this.a.b();
    }

    public final int c() {
        return this.a.c();
    }

    public final boolean d() {
        return this.a.d();
    }

    public final boolean e() {
        this.a.getClass();
        return false;
    }

    public final String f() {
        return this.a.f();
    }

    public final String g() {
        return this.a.g();
    }

    public final int h() {
        return this.a.h();
    }

    public final String a() {
        ILogDepend.a.i("PublicRomInfoImpl", "getOSDeviceIdFromCache: " + this.b);
        return this.b;
    }

    public final String getDeviceBrand() {
        this.a.getClass();
        return Build.BRAND;
    }

    public final String getDeviceModel() {
        this.a.getClass();
        return Build.MODEL;
    }

    public final String getOSVersion() {
        this.a.getClass();
        return Build.VERSION.INCREMENTAL;
    }

    public final void i() {
        Function1 r0 = new b();
        Intrinsics.checkNotNullParameter(r0, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new getOSDeviceIdAsync.1(this, r0, null), 3, null);
    }

    public PublicRomInfoImpl() {
        this.a = new CommonRomInfoImpl();
        this.c = kotlinx.coroutines.sync.b.a();
    }
}
