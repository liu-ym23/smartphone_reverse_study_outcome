package y8;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements ComponentCallbacks2 {
    public static final e a = null;
    public static int b;
    public static final Object c = null;

    public e() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
    }

    static {
        a = new e();
        c = new Object();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        int r0 = d.a;
        d.a(DegradeStatus.lowMemory, 0, 6);
    }

    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r0 = c;
        monitor-enter(r0);
        int r1 = b;     // Catch: Throwable -> L15
        if (r1 > 0) goto L8;
        monitor-exit(r0);
        return;
    L8:
        int r11 = r1 - 1;
        b = r11;     // Catch: Throwable -> L15
        if (r11 != 0) goto L12;
        r10.unregisterComponentCallbacks(this);     // Catch: Throwable -> L15
    L12:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r10) {
        if (r10 == 10) goto L9;
        if (r10 != 15) goto L14;
        int r11 = d.a;
        d.a(DegradeStatus.lowMemory, 0, 6);
        return;
    L14:
        return;
    L9:
        if (AnnieConfigSettingKeys.ANNIE_LOW_MEMORY_USE_LEVEL_NORMAL.a().booleanValue() == false) goto L13;
        int r12 = d.a;
        d.a(DegradeStatus.lowMemory, 0, 6);
        return;
    }
}
