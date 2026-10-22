package j6;

import android.database.ContentObserver;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f8726a;

    public d(e r8, WeakHandler r10) {
        this.f8726a = r8;
        super(r10);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r8) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
    L5:
        e r10 = this.f8726a;
        r10.getClass();
        boolean r11 = r10.f8729c;     // Catch: Exception -> L12
        r10.a();     // Catch: Exception -> L12
        boolean r12 = r10.f8729c;     // Catch: Exception -> L12
        if (r11 == r12) goto L15;
        e.a r13 = r10.f8728b;     // Catch: Exception -> L12
        if (r13 == null) goto L16;
        ((a) r13).g(r12);     // Catch: Exception -> L12
        return;
    L16:
        return;
    L15:
        return;
    }
}
