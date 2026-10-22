package j62;

import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.service.messagelist.c;
import com.bytedance.android.livesdk.interactivity.service.messagelist.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements d {
    public final LimitQueue a;

    public a() {
        this.a = new LimitQueue(50);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.d
    public final boolean a(c r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        long r0 = r7.getId();
        boolean r2 = r7 instanceof i62.a;
        boolean r4 = true;
        if (r2 == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        long r3 = r7.getId();
        if (r2 == false) goto L17;
        i62.a r8 = (i62.a) r7;
        if (r8.f() == false) goto L15;
    L18:
        if (r4 == true) goto L20;
        return false;
    L20:
        if (r3 == (-1)) goto L25;
        this.a.add(Long.valueOf(r3));
        return false;
    L25:
        return false;
    L15:
        if (r8.a == true) goto L18;
    L17:
        r4 = false;
        goto L18
    L5:
        if (this.a.contains(Long.valueOf(r0)) == false) goto L7;
        r1 = true;
        goto L8
    }
}
