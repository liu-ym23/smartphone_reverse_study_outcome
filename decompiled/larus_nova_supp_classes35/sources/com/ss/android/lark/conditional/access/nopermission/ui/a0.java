package com.ss.android.lark.conditional.access.nopermission.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.conditional.access.nopermission.manager.DialogButtonTypeFunction;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 extends q {
    public CustomDisplayTemplate b;
    public InternalSecurityAction c;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ CustomDisplayHandler a;
        public final /* synthetic */ InternalSecurityAction b;
        public final /* synthetic */ a0 c;

        public a(CustomDisplayHandler r1, InternalSecurityAction r2, a0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            DialogButtonTypeFunction r5 = DialogButtonTypeFunction.a;
            CustomDisplayHandler r6 = this.a;
            Intrinsics.checkNotNull(r6);
            InternalSecurityAction r0 = this.b;
            Context r1 = this.c.getContext();
            r5.getClass();
            com.ss.android.lark.conditional.access.nopermission.ui.custom.a.C0157a.a(r5, r6, r0, r1);
            ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "primary button click.");
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ CustomDisplayHandler a;
        public final /* synthetic */ InternalSecurityAction b;
        public final /* synthetic */ a0 c;

        public b(CustomDisplayHandler r1, InternalSecurityAction r2, a0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            DialogButtonTypeFunction r5 = DialogButtonTypeFunction.a;
            CustomDisplayHandler r6 = this.a;
            Intrinsics.checkNotNull(r6);
            InternalSecurityAction r0 = this.b;
            Context r1 = this.c.getContext();
            r5.getClass();
            com.ss.android.lark.conditional.access.nopermission.ui.custom.a.C0157a.a(r5, r6, r0, r1);
            ScsLogger.d("SecurityPolicy_SecurityPolicyDialogActionManager", "secondary button click.");
        }
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final CustomDisplayTemplate b() {
        return this.b;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final InternalSecurityAction c() {
        return this.c;
    }

    public a0(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        marginInDp(36);
        maxWidth(new UDDimension.Dp(303));
        controller(new b0(getContext()));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final q a(com.ss.android.lark.conditional.access.nopermission.manager.v r3) {
        return (q) super.addActionButton(2131391777, 2131890728, new z(r3));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.q
    public final void d(CustomDisplayTemplate r5, InternalSecurityAction r6) {
        Intrinsics.checkNotNullParameter(r5, "displayTemplate");
        Intrinsics.checkNotNullParameter(r6, Keys.API_PARAM_KEY_ACTION);
        this.b = r5;
        this.c = r6;
        List r7 = r5.handler_list;
        if (r7 == null) goto L19;
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        Object r1 = r8.next();
        CustomDisplayHandler r2 = (CustomDisplayHandler) r1;
        Intrinsics.checkNotNull(r2);
        if (com.ss.android.lark.conditional.access.utils.b.a(r2) == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        Iterator r9 = r0.iterator();
    L12:
        if (r9.hasNext() == false) goto L19;
        CustomDisplayHandler r3 = (CustomDisplayHandler) r9.next();
        if (Intrinsics.areEqual(r3.style, "primary") == false) goto L17;
        addActionButton(2131391777, r3.name, new a(r3, r6, this));
    L17:
        if (Intrinsics.areEqual(r3.style, "secondary") == false) goto L12;
        addActionButton(2131391778, r3.name, new b(r3, r6, this));
    L19:
        actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
    }
}
