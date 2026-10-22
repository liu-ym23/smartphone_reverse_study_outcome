package jc2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements j {
    public final DataCenter a;

    public c(DataCenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(f<?> r8) {
        Intrinsics.checkNotNullParameter(r8, "textMessage");
        va r9 = r8.b;
        String r1 = null;
        if ((r9 instanceof va) == true) goto L5;
        r9 = null;
    L5:
        va r10 = r9;
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.getAction() == 1) goto L12;
        return true;
    L12:
        IBaseUser r11 = r10.getUser();
        if (r11 == null) goto L16;
        r1 = r11.getIdString();
    L16:
        if (Intrinsics.areEqual(r1, k.n(IMiddlewareUserService.class).user().n()) == false) goto L23;
        DataCenter r13 = this.a;
        if (r13 == null) goto L24;
        Boolean r14 = (Boolean) r13.get("data_is_need_to_filter_self_enter_msg", Boolean.FALSE);
        if (r14 != null) goto L22;
        return false;
    L22:
        return r14.booleanValue();
    L24:
        return false;
    L23:
        return false;
    }
}
