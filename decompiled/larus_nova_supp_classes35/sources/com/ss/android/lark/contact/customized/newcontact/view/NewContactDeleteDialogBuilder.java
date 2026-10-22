package com.ss.android.lark.contact.customized.newcontact.view;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewContactDeleteDialogBuilder extends UDBaseDialogBuilder<NewContactDeleteDialogBuilder> {
    public static final /* synthetic */ int i = 0;
    public final Function0<Unit> a;
    public final int b;
    public final int c;
    public final int d;
    public Function0<Unit> e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final UDDialog a() {
        final UDDialog r0 = super.build();
        this.e = new NewContactDeleteDialogBuilder$buildDialog$1(r0);
        return r0;
    }

    public NewContactDeleteDialogBuilder(final Context r5, final View r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "itemView");
        Intrinsics.checkNotNullParameter(r7, "deleteAction");
        super(r5);
        this.a = r7;
        int r8 = UIHelper.dp2px(10.0f);
        this.b = r8;
        this.c = UIHelper.dp2px(30.0f);
        this.d = UIHelper.dp2px(8.0f);
        Rect r0 = new Rect();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.NONE;
        Lazy r2 = LazyKt.lazy(r1, new NewContactDeleteDialogBuilder$menuHeight$2(this));
        this.f = r2;
        Lazy r9 = LazyKt.lazy(r1, new NewContactDeleteDialogBuilder$isMenuOnBottom$2(r5, this, r6));
        this.g = r9;
        Lazy r3 = LazyKt.lazy(r1, new NewContactDeleteDialogBuilder$contentView$2(this, r6));
        this.h = r3;
        r6.getGlobalVisibleRect(r0);
        gravity(48);
        int r4 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r6).top);
        Rect r10 = new Rect();
        r6.getWindowVisibleDisplayFrame(r10);
        int r11 = UIHelper.px2dp(r10.top);
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L6;
        r4 = r4 - UIHelper.px2dp(((Number) r2.getValue()).intValue() + r8);
    L6:
        translationOnY(r4 - r11);
        contentLayout((View) r3.getValue());
        int r12 = r6.getMeasuredWidth();
        width(r12);
        maxWidth(new UDDimension.a(r12));
        backgroundColor(R.color.transparent);
    }
}
