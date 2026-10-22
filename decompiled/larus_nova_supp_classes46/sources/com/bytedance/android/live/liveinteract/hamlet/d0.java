package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.model.message.w5;
import com.bytedance.android.live.base.model.message.x5;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ HamletAvatarWidget c;

    public d0(com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r1, Ref.ObjectRef r2, HamletAvatarWidget r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Integer r9 = (Integer) sh6.c.b((sh6.b) r8);
        if (r9 != null) goto L6;
        return;
    L6:
        if (r9.intValue() != 2) goto L35;
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a r10 = this.a;
        Long r0 = null;
        if (r10 == null) goto L10;
        Boolean r11 = r10.a;
    L12:
        if ((!Intrinsics.areEqual(r11, Boolean.TRUE)) == false) goto L24;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r12 = this.c.g;
        if (r12 == null) goto L16;
        r0 = Long.valueOf(r12.getLastVersion());
    L16:
        if (r0 == null) goto L24;
        long r4 = r0.longValue();
        HamletAvatarWidget r1 = this.c;
        x5 r13 = r1.t;
        if (r13 == null) goto L22;
        w5 r14 = r13.getHamletAvatarInit();
        if (r14 == null) goto L22;
        long r2 = r14.getAvatarId();
    L23:
        r1.Mq(r2, r4, null);
    L22:
        r2 = 0;
    L24:
        x5 r15 = this.c.t;
        if (r15 == null) goto L31;
        w5 r16 = r15.getHamletAvatarInit();
        if (r16 == null) goto L31;
        List<Long> r17 = r16.getAllAvatarIds();
        if (r17 == null) goto L31;
        this.c.Yc(r17);
    L31:
        Disposable r18 = (Disposable) this.b.element;
        if (r18 == null) goto L36;
        r18.dispose();
        return;
    L36:
        return;
    L10:
        r11 = null;
        goto L12
    }
}
