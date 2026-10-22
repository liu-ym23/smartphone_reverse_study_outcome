package w00;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.gift.GiftEffectResourceServiceHolder;
import com.bytedance.android.scope.o;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements o, g00.e {
    public e() {
    }

    public final void onStop() {
    }

    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalResourceDownloadService onStart ");
    }

    @Override // g00.e
    public final void downloadRequirements(List<String> r3) {
        if (DownloadableModelSupport.isInitialized() == false) goto L10;
        if (r3 == null) goto L13;
        DownloadableModelSupport r0 = DownloadableModelSupport.getInstance();     // Catch: Exception -> L11
        Object[] r4 = r3.toArray(new String[0]);     // Catch: Exception -> L11
        if (r4 == null) goto L9;
        r0.fetchResourcesNeededByRequirements((String[]) r4, null);     // Catch: Exception -> L11
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L11
    L13:
        return;
    L10:
        return;
    }

    @Override // g00.e
    public final boolean isRequirementsDownloaded(List<String> r5) {
        if (DownloadableModelSupport.isInitialized() == true) goto L18;
        return false;
    L18:
        DownloadableModelSupport r3 = null;
        Effect r0 = new Effect(null, 1, null);     // Catch: Throwable -> L15
        if (r5 != null) goto L8;
        r5 = new ArrayList();     // Catch: Throwable -> L15
    L8:
        r0.setRequirements(r5);     // Catch: Throwable -> L15
        Lazy r6 = GiftEffectResourceServiceHolder.a;     // Catch: Throwable -> L15
        com.bytedance.android.live.effect.gift.e r7 = GiftEffectResourceServiceHolder.a.a();     // Catch: Throwable -> L15
        if (r7 == null) goto L11;
        r3 = r7.b();     // Catch: Throwable -> L15
    L11:
        if (r3 == null) goto L14;
        List<String> r8 = LiveEffectContext.h;     // Catch: Throwable -> L15
        EffectManager r9 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d();     // Catch: Throwable -> L15
        r9.markEffectUsed(r0);     // Catch: Throwable -> L15
        return r3.areRequirementsReady(r9, r0);
    L14:
        return false;
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
