package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowFollowingSelectLine;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTipTextView", "Landroid/widget/TextView;", "mExceedLimitDialog", "Landroid/app/Dialog;", "selectLimit", "getSelectLimit", "()I", "setSelectLimit", "(I)V", "value", "currentSelectCount", "getCurrentSelectCount", "setCurrentSelectCount", "selectTipClickListener", "Landroid/view/View$OnClickListener;", "getSelectTipClickListener", "()Landroid/view/View$OnClickListener;", "setSelectTipClickListener", "(Landroid/view/View$OnClickListener;)V", "initViews", "", "setupTextTip", "showSelectCountLimitExceededDialog", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowFollowingSelectLine extends FrameLayout {
    public TextView a;
    public LKUIDialog b;
    public int c;
    public int d;
    public View.OnClickListener e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FlowFollowingSelectLine a;

        public b(FlowFollowingSelectLine r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.getSelectTipClickListener();
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    static {
    }

    public final void a() {
        int r0 = UIHelper.dp2px(12.0f);
        setPaddingRelative(r0, 0, r0, 0);
        TextView r1 = new TextView(getContext());
        r1.setTextSize(14.0f);
        r1.setTextColor(v2c.a.b(r1.getContext(), 2131102040));
        r1.setBackgroundResource(2131231981);
        r1.setCompoundDrawablePadding(UIHelper.dp2px(4.0f));
        int r3 = UIHelper.dp2px(14.0f);
        Drawable r4 = AppCompatResources.getDrawable(r1.getContext(), 2131235446);
        TextView r5 = null;
        if (r4 == null) goto L7;
        Drawable r6 = r4.mutate();
        if (r6 == null) goto L7;
        r6.setBounds(0, 0, r3, r3);
    L8:
        r1.setCompoundDrawablesRelative(r6, null, null, null);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.gravity = 16;
        r2.setMarginStart(UIHelper.dp2px(34.0f));
        r1.setLayoutParams(r2);
        r1.setGravity(16);
        int r7 = UIHelper.dp2px(14.0f);
        int r8 = UIHelper.dp2px(8.0f);
        r1.setPaddingRelative(r7, r8, r7, r8);
        r1.setOnClickListener(new b(this));
        this.a = r1;
        addView(r1);
        TextView r9 = this.a;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
    L12:
        r5.setText(2131890170);
        return;
    L11:
        r5 = r9;
    L7:
        r6 = null;
        goto L8
    }

    public final int getCurrentSelectCount() {
        return this.d;
    }

    public final int getSelectLimit() {
        return this.c;
    }

    public final View.OnClickListener getSelectTipClickListener() {
        return this.e;
    }

    public FlowFollowingSelectLine(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    public final void setCurrentSelectCount(int r6) {
        if (this.d != r6) goto L5;
        return;
    L5:
        if (r6 < this.c) goto L23;
        boolean r1 = true;
        if (this.b != null) goto L9;
        com.larksuite.component.ui.dialog.d r0 = new com.larksuite.component.ui.dialog.d(getContext());
        r0.c.message(2131890158);
        r0.c.titleLineCount(3);
        r0.a(2131378551, 2131891840, FlowFollowingSelectLine$showSelectCountLimitExceededDialog$1.a);
        r0.c.cancelable(true);
        this.b = r0.c();
    L9:
        LKUIDialog r2 = this.b;
        if (r2 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L23;
        LKUIDialog r3 = this.b;
        if (r3 == null) goto L23;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r3);
        goto L23
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L22:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        goto L23
    L12:
        if (r2.isShowing() == true) goto L14;
    L23:
        this.d = r6;
    }

    public final void setSelectLimit(int r1) {
        this.c = r1;
    }

    public final void setSelectTipClickListener(View.OnClickListener r1) {
        this.e = r1;
    }

    public FlowFollowingSelectLine(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        a();
    }

    public FlowFollowingSelectLine(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
