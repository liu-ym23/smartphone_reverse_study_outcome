package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 extends com.ss.android.lark.conditional.access.nopermission.ui.q {
    public CustomDisplayTemplate b;
    public InternalSecurityAction c;

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final CustomDisplayTemplate b() {
        return this.b;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final InternalSecurityAction c() {
        return this.c;
    }

    public a0(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        super(r3);
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
        controller(new CustomSecurityDialogController(r3));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final com.ss.android.lark.conditional.access.nopermission.ui.q a(com.ss.android.lark.conditional.access.nopermission.manager.v r3) {
        return (com.ss.android.lark.conditional.access.nopermission.ui.q) super.addActionButton(2131391777, 2131890728, new z(r3));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final void d(CustomDisplayTemplate r2, InternalSecurityAction r3) {
        Intrinsics.checkNotNullParameter(r2, "displayTemplate");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        this.b = r2;
        this.c = r3;
    }
}
