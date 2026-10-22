package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.DslTemplate;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileComponentManagerImp {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public ProfileComponentManagerImp() {
        this.a = LazyKt.lazy(ProfileComponentManagerImp$businessOpenAreaDescriptions$2.INSTANCE);
        this.b = LazyKt.lazy(ProfileComponentManagerImp$componentDescriptions$2.INSTANCE);
    }

    public static com.bytedance.android.live.profile.ui.base.g a(com.bytedance.android.live.profile.ui.base.l r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        com.bytedance.android.live.profile.profilecontext.a r0 = r3.b();
        if (r0 == null) goto L7;
        NewProfileUser r1 = r0.getTargetUser();
        if (r1 == null) goto L7;
        DslTemplate r2 = r1.ecomBottomCardDsl;
    L8:
        boolean r4 = false;
        if (r2 == null) goto L18;
        String r5 = r2.template;
        if (r5 == null) goto L18;
        if (r5.length() <= 0) goto L15;
        boolean r6 = true;
    L16:
        if (r6 != true) goto L18;
        r4 = true;
        goto L18
    L15:
        r6 = false;
    L18:
        if (r4 == true) goto L27;
        Integer r7 = (Integer) j0.a.getValue();
        if (r7 == null) goto L28;
        if (r7.intValue() == 1) goto L27;
    L28:
        return new com.bytedance.android.live.profile.ui.component.s(r3);
    L27:
        return new com.bytedance.android.live.profile.ui.component.i(r3);
    L7:
        r2 = null;
        goto L8
    }
}
