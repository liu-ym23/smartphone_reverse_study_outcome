package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements ILiveEffectComposerManager.h {
    public final /* synthetic */ LiveComposerFilterHelper a;
    public final /* synthetic */ String b;

    public static final class a implements k.f {
        public final /* synthetic */ h a;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r1, Sticker r2) {
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r8, Sticker r9) {
            h r11 = this.a;
            LiveComposerFilterHelper.a(r11.a, r9, "restore_download_success_", r11.b, false, true, 24);
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r8, Sticker r9, ExceptionResult r11) {
            h r12 = this.a;
            LiveComposerFilterHelper.a(r12.a, null, "restore_download_fail_", r12.b, false, true, 24);
        }
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.h
    public final void a(List<String> r11) {
        Intrinsics.checkNotNullParameter(r11, "list");
        String r12 = (String) CollectionsKt.firstOrNull(r11);
        Iterator r0 = ((ArrayList) this.a.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Sticker) r1).getResourceId(), r12) == false) goto L4;
    L9:
        Sticker r3 = (Sticker) r1;
        if (r3 == null) goto L19;
        List<String> r13 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.getType()).b().r().q(r3) == false) goto L14;
        LiveComposerFilterHelper.a(this.a, r3, "restore_", this.b, false, true, 24);
        return;
    L14:
        LiveEffectContext.a.a(this.a.getType()).b().r().g(d0.a, r3, new a(this));
        return;
    L19:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public h(LiveComposerFilterHelper r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
