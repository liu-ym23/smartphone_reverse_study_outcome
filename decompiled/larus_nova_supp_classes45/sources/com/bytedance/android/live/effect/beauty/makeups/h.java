package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements ILiveEffectComposerManager.h {
    public final /* synthetic */ d a;

    public static final class a implements k.f {
        public final /* synthetic */ h a;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r1, Sticker r2) {
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r3, Sticker r4) {
            this.a.a.a(r4, "restore_download_success_", true);
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r2, Sticker r3, ExceptionResult r4) {
            this.a.a.a(r3, "restore_download_fail_", true);
        }
    }

    public h(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.h
    public final void a(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        String r5 = (String) CollectionsKt.firstOrNull(r4);
        Iterator<Sticker> r0 = this.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Sticker r1 = r0.next();
        if (Intrinsics.areEqual(r1.getResourceId(), r5) == false) goto L4;
    L9:
        Sticker r2 = r1;
        if (r2 == null) goto L19;
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.getType()).b().r().q(r2) == false) goto L14;
        this.a.a(r2, "restore_", true);
        return;
    L14:
        LiveEffectContext.a.a(this.a.getType()).b().r().g(d0.k, r2, new a(this));
        return;
    L19:
        return;
    L8:
        r1 = null;
        goto L9
    }
}
