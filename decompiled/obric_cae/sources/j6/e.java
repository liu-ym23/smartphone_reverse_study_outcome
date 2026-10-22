package j6;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8729c;

    public interface a {
    }

    public e(Context r8, WeakHandler r10, j6.a r11) {
        this.f8727a = r8;
        this.f8728b = r11;
        a();
        d r12 = new d(this, r10);
        r8.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.a(r8, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, r12);     // Catch: Throwable -> L5
        return;
    }

    public final void a() {
        boolean r8 = com.bytedance.common.wschannel.a.a(this.f8727a).f3869a.a(WsConstants.KEY_FRONTIER_ENABLED, true);     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r8);     // Catch: Throwable -> L10
    L7:
        if (r8 == this.f8729c) goto L13;
        this.f8729c = r8;     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }
}
