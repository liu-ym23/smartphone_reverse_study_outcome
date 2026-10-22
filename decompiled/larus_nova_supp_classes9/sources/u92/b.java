package u92;

import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.r0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.message.model.o7;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements j {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "textMessage");
        if (Intrinsics.areEqual(r10.y(), k.n(IMiddlewareUserService.class).user().n()) == false) goto L5;
        return false;
    L5:
        h7 r11 = r10.b;
        if ((r11 instanceof o7) == true) goto L12;
        if ((r11 instanceof kc2.b) == true) goto L12;
        if ((r11 instanceof r0) == true) goto L12;
    L15:
        if ((r11 instanceof h7) == true) goto L17;
    L23:
        boolean r0 = r11 instanceof l4;
        if (r0 == true) goto L26;
    L30:
        if (r0 == true) goto L32;
    L38:
        return false;
    L32:
        if (this.d == false) goto L38;
        l4 r13 = (l4) r11;
        if (r13.getAction() != 1) goto L36;
    L37:
        return true;
    L36:
        if (r13.getAction() != 2) goto L38;
    L26:
        if (this.c == false) goto L30;
        if (((l4) r11).getAction() != 3) goto L30;
        return true;
    L17:
        if (this.b == false) goto L23;
        h7 r1 = r11;
        if (r1.getAction() != 1) goto L21;
    L22:
        return true;
    L21:
        if (r1.getAction() != 2) goto L23;
    L12:
        if (this.a == false) goto L15;
        return true;
    }

    public b(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
