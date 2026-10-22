package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.databinding.LarusLayoutItemLeftEditAreaBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/LeftCreationEditItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutItemLeftEditAreaBinding;", "onBindView", "", "iconRes", "textRes", "isRedDot", "", "(ILjava/lang/Integer;Ljava/lang/Boolean;)V", "updateTextAlpha", "alpha", "", "refreshRedDot", "isShowRedDot", "getIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "updateLayoutForTextVisibility", "isTextVisible", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LeftCreationEditItemView extends ConstraintLayout {
    public final LarusLayoutItemLeftEditAreaBinding a;

    public LeftCreationEditItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LeftCreationEditItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean R5() {
        if (this.a.c.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final AppCompatImageView getIconView() {
        return this.a.b;
    }

    public final void T5(boolean r2) {
        RoundTextView r0 = this.a.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LeftCreationEditItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562843, this);
        int r5 = 2131376350;
        AppCompatImageView r6 = ViewBindings.findChildViewById(this, 2131376350);
        if (r6 == null) goto L11;
        r5 = 2131376351;
        RoundTextView r7 = ViewBindings.findChildViewById(this, 2131376351);
        if (r7 == null) goto L11;
        r5 = 2131390855;
        AppCompatTextView r0 = ViewBindings.findChildViewById(this, 2131390855);
        if (r0 == null) goto L11;
        this.a = new LarusLayoutItemLeftEditAreaBinding(this, r6, r7, r0);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(int r10, Integer r11, Boolean r12) {
        this.a.b.setImageResource(r10);
        if (r11 == null) goto L5;
        this.a.d.setText(getContext().getString(r11.intValue()));
        this.a.d.setShadowLayer(c7.c(2), 0.0f, 0.0f, ColorProtector.parseColor("#80000000"));
    L7:
        if (r11 == null) goto L9;
        boolean r13 = true;
    L10:
        ConstraintSet r6 = new ConstraintSet();
        r6.clone(this);
        if (r13 == false) goto L13;
        r6.connect(2131376350, 3, 0, 3, getResources().getDimensionPixelSize(v19.c.b(2130971517, null, 2131167404)));
        r6.clear(2131376350, 4);
    L14:
        r6.applyTo(this);
        T5(Intrinsics.areEqual(r12, Boolean.TRUE));
        return;
    L13:
        r6.connect(2131376350, 3, 0, 3);
        r6.connect(2131376350, 4, 0, 4);
        goto L14
    L9:
        r13 = false;
        goto L10
    L5:
        e1.o(this.a.d);
        goto L7
    }

    public /* synthetic */ LeftCreationEditItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
