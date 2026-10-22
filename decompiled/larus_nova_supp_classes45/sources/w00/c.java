package w00;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements o, q00.a {
    public final /* synthetic */ q00.b a;

    @Override // q00.a
    public final boolean a() {
        return this.a.a();
    }

    @Override // q00.a
    public final boolean c() {
        return this.a.c();
    }

    @Override // q00.a
    public final void d(boolean r2) {
        this.a.d(r2);
    }

    public final void onStop() {
    }

    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalCommerceEffectService onStart");
    }

    public c() {
        this.a = new q00.b();
    }
}
