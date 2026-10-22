package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.checkbox.OCheckBox;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "only for o demo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "Landroid/widget/TextView;", "getNormalTextView", "getLinkTextView", "", "onAttachedToWindow", "Landroid/widget/RelativeLayout;", "linkContainer", "Landroid/widget/RelativeLayout;", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "tvNormal", "Landroid/widget/TextView;", "tvLink", "Landroid/view/ViewGroup;", "clickContainer", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogConfirmView extends ConstraintLayout {
    private final OCheckBox checkBox;
    private final ViewGroup clickContainer;
    private final RelativeLayout linkContainer;
    private final TextView tvLink;
    private final TextView tvNormal;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DialogConfirmView f6468c;

        a(DialogConfirmView r10) {
            this.f6468c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            DialogConfirmView.access$getTvLink$p(this.f6468c).performClick();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DialogConfirmView f6469c;

        b(DialogConfirmView r10) {
            this.f6469c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6469c.getCheckBox().performClick();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DialogConfirmView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public DialogConfirmView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_layout_dialog_options, this);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 5, r12.getDisplayMetrics()));
        setPadding(r13, r13, r13, 0);
        View r14 = findViewById(f.radio);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.radio)");
        this.checkBox = (OCheckBox) r14;
        View r15 = findViewById(f.tv_normal);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_normal)");
        this.tvNormal = (TextView) r15;
        View r16 = findViewById(f.tv_link);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.tv_link)");
        this.tvLink = (TextView) r16;
        View r17 = findViewById(f.link_text_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.link_text_container)");
        this.linkContainer = (RelativeLayout) r17;
        View r18 = findViewById(f.click_container);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.click_container)");
        this.clickContainer = (ViewGroup) r18;
    }

    public /* synthetic */ DialogConfirmView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ TextView access$getTvLink$p(DialogConfirmView r10) {
        return r10.tvLink;
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final TextView getLinkTextView() {
        return this.tvLink;
    }

    public final TextView getNormalTextView() {
        return this.tvNormal;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r10 = getParent();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r11 = (ViewGroup) r10;
        this.linkContainer.setPadding(0, r11.getPaddingTop(), 0, r11.getPaddingBottom());
        this.linkContainer.setOnClickListener(new a(this));
        r11.setPadding(r11.getPaddingLeft(), 0, r11.getPaddingRight(), 0);
        this.clickContainer.setOnClickListener(new b(this));
        return;
    }
}
