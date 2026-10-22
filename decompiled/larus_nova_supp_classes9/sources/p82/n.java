package p82;

import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.user.IUserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements com.bytedance.android.live.liveinteract.plantform.base.i.c {
    public final /* synthetic */ o a;
    public final /* synthetic */ User b;

    public n(o r1, User r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(n0 r3) {
        boolean r1 = false;
        if (Intrinsics.areEqual(this.b.getIdString(), jc1.k.n(IUserService.class).user().n()) == false) goto L7;
        if (r3 != null) goto L7;
        this.a.g = false;
        return;
    L7:
        o r0 = this.a;
        if (r3 == null) goto L10;
        r1 = true;
    L10:
        r0.e = Boolean.valueOf(r1);
        if (Intrinsics.areEqual(this.a.e, Boolean.TRUE) == false) goto L15;
        TextView r4 = this.a.f;
        if (r4 == null) goto L19;
        r4.setText(2131915871);
        return;
    L19:
        return;
    L15:
        TextView r5 = this.a.f;
        if (r5 == null) goto L21;
        r5.setText(2131915880);
        return;
    }
}
