package com.bytedance.android.live.recharge.exchange.saas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/saas/CashExchangeDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CashExchangeDialog extends AppCompatDialog {
    public View a;
    public HSImageView b;
    public View c;
    public TextView d;
    public View e;
    public TextView f;
    public ToggleButton g;
    public View h;
    public Button i;
    public Button j;
    public int k;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L14;
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams();
        r1.copyFrom(r0.getAttributes());
        r1.width = s1.f(280.0f);
        r1.height = -2;
        r0.setAttributes(r1);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public CashExchangeDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, 0);
        init(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context r3) {
        View r4 = LayoutInflater.from(getContext()).inflate(2131565416, null);
        this.a = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        setContentView(r4);
        View r5 = this.a;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        this.b = r5.findViewById(2131373724);
        View r6 = this.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        this.c = r6.findViewById(2131374733);
        View r7 = this.a;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        this.d = (TextView) r7.findViewById(2131388772);
        View r8 = this.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        this.e = r8.findViewById(2131367862);
        View r9 = this.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        this.f = (TextView) r9.findViewById(2131367794);
        View r10 = this.a;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L23:
        this.g = (ToggleButton) r10.findViewById(2131389031);
        View r12 = this.a;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L26:
        this.h = r12.findViewById(2131389032);
        View r13 = this.a;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L29:
        this.i = (Button) r13.findViewById(2131365028);
        View r14 = this.a;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L32:
        this.j = (Button) r14.findViewById(2131365046);
    }

    public CashExchangeDialog(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1, 2131954708);
        init(r1);
    }
}
