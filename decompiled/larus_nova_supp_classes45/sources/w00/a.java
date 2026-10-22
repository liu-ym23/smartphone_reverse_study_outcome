package w00;

import com.bytedance.android.live.broadcast.BroadcastEffectService;
import com.bytedance.android.live.broadcast.effect.EffectHostLiveService;
import com.bytedance.android.live.broadcast.h;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements o, h {
    public final q00.a a;
    public final /* synthetic */ BroadcastEffectService b;

    @Override // com.bytedance.android.live.broadcast.h
    public final EffectHostLiveService a() {
        return this.b.a();
    }

    public final void onStop() {
    }

    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalBroadcastEffectService onStart " + hashCode());
    }

    public a(q00.a r2) {
        Intrinsics.checkNotNullParameter(r2, "commerceEffectService");
        this.b = new BroadcastEffectService();
        this.a = r2;
    }
}
