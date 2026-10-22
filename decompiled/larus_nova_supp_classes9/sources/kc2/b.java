package kc2;

import ca0.j;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends c implements u3 {
    public IBaseUser a;
    public long b;
    public String c;
    public h2 d;
    public int e;
    public long f;
    public IPublicAreaCommon g;
    public boolean h;
    public long i;
    public boolean j;

    @Override // kc2.c
    public final boolean canText() {
        return true;
    }

    public final byte[] getRawPayload() {
        return null;
    }

    public final h2 d() {
        h2 r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = h.a;
        return h.d(j.class).findLiteGiftById(this.b);
    }

    public final IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this.g != null) goto L6;
        this.g = f.c(IPublicAreaCommon.class);
    L6:
        return this.g;
    }

    public b() {
        this.j = false;
        setMessageMethod("GiftGroupMessage");
    }

    @Override // kc2.c
    public final boolean supportDisplayText() {
        if (getBaseMessage() != null) goto L5;
    L7:
        return false;
    L5:
        if (getBaseMessage().supportDisplayText() == false) goto L7;
        return true;
    }

    public final IBaseUser getUserInMessage() {
        return this.a;
    }

    @Override // kc2.c
    public final boolean isCurrentRoom(long r4) {
        if (this.i != r4) goto L5;
        return true;
    L5:
        return false;
    }
}
