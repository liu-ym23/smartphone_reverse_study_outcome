package com.bytedance.android.live.revlink.impl.multianchor.precisefind;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revlink.impl.global.b;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Ref.IntRef c;

    public a(int r1, List r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        int r6 = (int) ((Long) r5).longValue();
        StringBuilder r0 = new StringBuilder("currentSecond=");
        r0.append(r6);
        r0.append(" avatarCountDownTs=");
        r0.append(this.a);
        r0.append(", currentSecond % avatarCountDownTs == 0=");
        if ((r6 % this.a) != 0) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        ALogger.i("MultiPkPreciseFindWidget", r0.toString());
        if ((r6 % this.a) != 0) goto L15;
        i r7 = b.h0();
        if (r7 == null) goto L11;
        r7.e3(((IBaseUser) ListProtector.get(this.b, this.c.element)).getAvatarThumbKt());
    L11:
        Ref.IntRef r8 = this.c;
        int r2 = r8.element + 1;
        r8.element = r2;
        if (r2 < this.b.size()) goto L16;
        this.c.element = 0;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = false;
        goto L6
    }
}
