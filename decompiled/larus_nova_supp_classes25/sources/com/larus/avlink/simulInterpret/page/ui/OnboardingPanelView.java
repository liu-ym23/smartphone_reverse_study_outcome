package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LayoutOnboardingPanelViewBinding;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/OnboardingPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutOnboardingPanelViewBinding;", "onSetShortcutClick", "Lkotlin/Function0;", "", "getOnSetShortcutClick", "()Lkotlin/jvm/functions/Function0;", "setOnSetShortcutClick", "(Lkotlin/jvm/functions/Function0;)V", "setShortcutText", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "setShortcutViewVisibility", "visibility", "updateOnboardingContent", "isConference", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OnboardingPanelView extends ConstraintLayout {
    public final LayoutOnboardingPanelViewBinding a;
    public Function0<Unit> b;

    public OnboardingPanelView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OnboardingPanelView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getOnSetShortcutClick() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r3) {
        if (r3 == false) goto L4;
        this.a.c.setImageResource(2131240396);
        this.a.d.setText(getContext().getString(2131904089));
        this.a.b.setText(getContext().getString(2131904091));
        return;
    L4:
        this.a.c.setImageResource(2131240397);
        this.a.d.setText(getContext().getString(2131904090));
        this.a.b.setText(getContext().getString(2131904092));
    }

    public final void setOnSetShortcutClick(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setShortcutText(DoraDeviceType r2) {
        Intrinsics.checkNotNullParameter(r2, "deviceType");
        this.a.b.setText(r2.getOnboardingDescription());
    }

    public final void setShortcutViewVisibility(int r2) {
        this.a.e.setVisibility(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnboardingPanelView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        ConstraintLayout r10 = LayoutInflater.from(r7).inflate(2131563379, this, false);
        addView(r10);
        int r11 = 2131381463;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r10, 2131381463);
        if (r2 == null) goto L13;
        r11 = 2131381465;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r10, 2131381465);
        if (r3 == null) goto L13;
        r11 = 2131381467;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131381467);
        if (r4 == null) goto L13;
        r11 = 2131385965;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r10, 2131385965);
        if (r12 == null) goto L13;
        this.a = new LayoutOnboardingPanelViewBinding(r10, r2, r3, r4, r12);
        r12.setOnClickListener(new q(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ OnboardingPanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
