package com.ss.android.lark.contact.customized.externalcontact.view;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
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
public final class ContactItemDeleteDialogBuilder extends UDBaseDialogBuilder<ContactItemDeleteDialogBuilder> {
    public static final /* synthetic */ int j = 0;
    public final Function0<Unit> a;
    public final Function0<Unit> b;
    public final int c;
    public final int d;
    public final int e;
    public Function0<Unit> f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ContactItemDeleteDialogBuilder a;

        public a(ContactItemDeleteDialogBuilder r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            Function0<Unit> r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public final UDDialog a() {
        final UDDialog r0 = super.build();
        this.f = new ContactItemDeleteDialogBuilder$buildDialog$1(r0);
        return r0;
    }

    public ContactItemDeleteDialogBuilder(final Context r4, final View r5, Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "itemView");
        Intrinsics.checkNotNullParameter(r6, "deleteAction");
        super(r4);
        this.a = r6;
        this.b = r7;
        int r8 = UIHelper.dp2px(10.0f);
        this.c = r8;
        this.d = UIHelper.dp2px(30.0f);
        this.e = UIHelper.dp2px(8.0f);
        Rect r9 = new Rect();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        Lazy r1 = LazyKt.lazy(r0, new ContactItemDeleteDialogBuilder$menuHeight$2(this));
        this.g = r1;
        Lazy r10 = LazyKt.lazy(r0, new ContactItemDeleteDialogBuilder$isMenuOnBottom$2(r4, this, r5));
        this.h = r10;
        Lazy r2 = LazyKt.lazy(r0, new ContactItemDeleteDialogBuilder$contentView$2(this, r5));
        this.i = r2;
        r5.getGlobalVisibleRect(r9);
        gravity(48);
        int r11 = UIHelper.px2dp(UIUtils.calcViewScreenLocation(r5).top);
        Rect r3 = new Rect();
        r5.getWindowVisibleDisplayFrame(r3);
        int r12 = UIHelper.px2dp(r3.top);
        if (((Boolean) r10.getValue()).booleanValue() == true) goto L6;
        r11 = r11 - UIHelper.px2dp(((Number) r1.getValue()).intValue() + r8);
    L6:
        translationOnY(r11 - r12);
        contentLayout((View) r2.getValue());
        int r13 = r5.getMeasuredWidth();
        width(r13);
        maxWidth(new UDDimension.a(r13));
        backgroundColor(R.color.transparent);
        onDismissListener(new a(this));
    }
}
