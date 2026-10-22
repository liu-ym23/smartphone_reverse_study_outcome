package jb;

import com.bytedance.crash.upload.l;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.sync.SyncSDK;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18314a = null;

    static {
        f18314a = new b();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        d r5 = d.f18316a;
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.c(LogLevel.f5954b, "BulletByteSyncManager： initByteSync");
        l r11 = new l(3);
        c r12 = c.f18315a;
        ((ArrayList) r11.f4139c).add(r12);
        if (r11.f4138b < 0) goto L7;
        SyncSDK.a(new qj.b(r11));
        return Unit.INSTANCE;
    L7:
        throw new IllegalArgumentException("bizId < 0");
    }
}
