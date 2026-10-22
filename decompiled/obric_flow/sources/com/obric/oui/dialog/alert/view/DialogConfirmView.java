package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.checkbox.OCheckBox;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mr.a;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "only for o demo")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "Landroid/widget/TextView;", "getNormalTextView", "()Landroid/widget/TextView;", "getLinkTextView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogConfirmView extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f13074l = 0;
    public final OCheckBox g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f13075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f13076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RelativeLayout f13077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f13078k;

    @JvmOverloads
    public DialogConfirmView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final OCheckBox getCheckBox() {
        return this.g;
    }

    public final TextView getLinkTextView() {
        return this.f13076i;
    }

    public final TextView getNormalTextView() {
        return this.f13075h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r5 = getParent();
        if (r5 == null) goto L10;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = r10.getPaddingTop();
        int r12 = r10.getPaddingBottom();
        RelativeLayout r13 = this.f13077j;
        r13.setPadding(0, r11, 0, r12);
        final int r14 = 0;
        r13.setOnClickListener(new a(this, r14));
        r10.setPadding(r10.getPaddingLeft(), 0, r10.getPaddingRight(), 0);
        final int r15 = 1;
        View.OnClickListener r16 = new a(this, r15);
        this.f13078k.setOnClickListener(r16);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @JvmOverloads
    public DialogConfirmView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        View.inflate(r5, R$layout.o_layout_dialog_options, this);
        int r11 = com.lynx.tasm.utils.a.B(5, this);
        setPadding(r11, r11, r11, 0);
        this.g = (OCheckBox) findViewById(R$id.radio);
        this.f13075h = (TextView) findViewById(R$id.tv_normal);
        this.f13076i = (TextView) findViewById(R$id.tv_link);
        this.f13077j = (RelativeLayout) findViewById(R$id.link_text_container);
        this.f13078k = (ViewGroup) findViewById(R$id.click_container);
    }
}
