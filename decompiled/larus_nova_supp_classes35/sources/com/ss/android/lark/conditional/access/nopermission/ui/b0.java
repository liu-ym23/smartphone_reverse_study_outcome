package com.ss.android.lark.conditional.access.nopermission.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.ss.android.lark.conditional.access.nopermission.manager.DialogButtonTypeFunction;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 extends UDDialogController {
    public CustomDisplayTemplate a;
    public InternalSecurityAction b;

    public static final class a {
    }

    static {
    }

    public final int getDefaultContentRes() {
        return 2131568092;
    }

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 == null) goto L48;
        if (this.a != null) goto L7;
    L46:
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131391788);
        TextView r2 = (TextView) r0.findViewById(2131391790);
        TextView r3 = (TextView) r0.findViewById(2131391789);
        Intrinsics.checkNotNull(r1);
        t4c.b.a(r1);
        goto L48
    L7:
        if (this.b == null) goto L46;
        ViewGroup r4 = (ViewGroup) r0.findViewById(2131368374);
        CustomDisplayTemplate r5 = this.a;
        if (r5 == null) goto L16;
        List r6 = r5.content_list;
        if (r6 == null) goto L16;
        boolean r7 = true;
        if ((!r6.isEmpty()) != true) goto L16;
    L17:
        if (r7 == false) goto L45;
        Intrinsics.checkNotNull(r4);
        t4c.b.b(r4);
        CustomDisplayTemplate r8 = this.a;
        if (r8 == null) goto L23;
        List r9 = r8.content_list;
        if (r9 == null) goto L23;
        int r10 = r9.size();
    L24:
        CustomDisplayTemplate r11 = this.a;
        if (r11 == null) goto L48;
        List r12 = r11.content_list;
        if (r12 == null) goto L48;
        Iterator r13 = r12.iterator();
        int r14 = 0;
    L30:
        if (r13.hasNext() == false) goto L48;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        CustomDisplayContent r17 = (CustomDisplayContent) r15;
        if (this.b == null) goto L44;
        if (r14 >= (r10 - 1)) goto L39;
        int r18 = 8;
    L40:
        u8b.a r19 = new u8b.a(getContext(), r18);
        Intrinsics.checkNotNull(r17);
        InternalSecurityAction r20 = this.b;
        if (r20 != null) goto L43;
        r20 = com.ss.android.lark.conditional.access.traffic.f.a;
    L43:
        r19.b(r17, r20, DialogButtonTypeFunction.a, CustomDisplayPageUiMode.LARK);
        r19.setId(View.generateViewId());
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-1, -2);
        r21.topMargin = (int) h18.d.b(getContext(), 8);
        r21.bottomMargin = (int) h18.d.b(getContext(), 8);
        Unit r22 = Unit.INSTANCE;
        r4.addView(r19, r21);
        goto L44
    L39:
        r18 = 0;
    L44:
        r14 = r16;
    L23:
        r10 = 0;
        goto L24
    L45:
        Intrinsics.checkNotNull(r4);
        t4c.b.a(r4);
    L16:
        r7 = false;
    L48:
        if (TextUtils.isEmpty(getMMessage()) == false) goto L54;
        if (r0 == null) goto L51;
        TextView r23 = (TextView) r0.findViewById(2131391794);
    L52:
        if (r23 == null) goto L54;
        t4c.b.a(r23);
        goto L54
    L51:
        r23 = null;
    L54:
        return r0;
    }

    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (TextUtils.isEmpty(getMMessage()) == false) goto L6;
        if (r0 == null) goto L6;
        r0.setPadding(0, (int) h18.d.b(getContext(), 12), 0, 0);
    L6:
        return r0;
    }

    public b0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r3, UDDialog r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        if ((r3 instanceof q) == false) goto L5;
        q r0 = (q) r3;
        this.a = r0.b();
        this.b = r0.c();
    L5:
        super.apply(r3, r4);
        CustomDisplayTemplate r5 = this.a;
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.b == null) goto L21;
        if (r5 == null) goto L13;
        String r6 = r5.title;
        if (r6 == null) goto L13;
    L14:
        setMTitle(r6);
        setMTitleGravity(8388611);
        setMTitleSize(20);
        setMTitleTextColor(2131106622);
        CustomDisplayTemplate r7 = this.a;
        if (r7 == null) goto L17;
        String r8 = r7.text;
    L18:
        setMMessage(r8);
        setMMessageGravity(8388611);
        setMMessageSize(14);
        setMMessageTextColor(2131106607);
        return;
    L17:
        r8 = null;
    L13:
        r6 = BuildConfig.FLAVOR;
        goto L14
    }
}
