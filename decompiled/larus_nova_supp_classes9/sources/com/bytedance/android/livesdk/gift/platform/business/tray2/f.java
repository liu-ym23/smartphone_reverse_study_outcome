package com.bytedance.android.livesdk.gift.platform.business.tray2;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends o {
    public final /* synthetic */ e a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ String c;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r4) {
        List<NormalGiftMessage> r0 = this.a.a.remove(this.c);
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        NormalGiftMessage r2 = (NormalGiftMessage) r1.next();
        GiftTrayMessageManager r3 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().g(r2);
    L8:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftTrayMessageService", "effect download cancel, uniqueKey is " + this.c + ", resourceId is " + r4);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "t");
        List<NormalGiftMessage> r0 = this.a.a.remove(this.c);
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        NormalGiftMessage r2 = (NormalGiftMessage) r1.next();
        GiftTrayMessageManager r3 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().g(r2);
    L8:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("GiftTrayMessageService", "effect download failed, uniqueKey is " + this.c + ", throwable is " + r4);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "path");
        super.c(r5, r7);
        iy1.a r0 = new iy1.a(r7, this.b.getResourceType());
        List<NormalGiftMessage> r1 = this.a.a.remove(this.c);
        if (r1 == null) goto L8;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        NormalGiftMessage r3 = (NormalGiftMessage) r2.next();
        r3.z = r0;
        GiftTrayMessageManager r4 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().g(r3);
    L8:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GiftTrayMessageService", "effect download complete, uniqueKey is " + this.c + ", resourceId is " + r5 + ", path is " + r7);
    }

    public f(e r1, com.bytedance.android.live.core.resources.e r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
