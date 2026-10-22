package com.larus.avlink.record.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.c;
import com.larus.avlink.impl.databinding.LayoutRecordLoadingOrRetryViewBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesLoadingOrRetryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordLoadingOrRetryViewBinding;", "onRetryClick", "Lkotlin/Function0;", "", "getOnRetryClick", "()Lkotlin/jvm/functions/Function0;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function0;)V", "showLoadingView", "showRetryView", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesLoadingOrRetryView extends ConstraintLayout {
    public final LayoutRecordLoadingOrRetryViewBinding a;
    public Function0<Unit> b;

    public RecordMinutesLoadingOrRetryView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordMinutesLoadingOrRetryView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        this.a.b.setVisibility(0);
        this.a.c.setVisibility(0);
        this.a.e.setVisibility(8);
        this.a.d.setVisibility(8);
    }

    public final void S5() {
        this.a.b.setVisibility(8);
        this.a.c.setVisibility(8);
        this.a.e.setVisibility(0);
        this.a.d.setVisibility(0);
    }

    public final Function0<Unit> getOnRetryClick() {
        return this.b;
    }

    public final void setOnRetryClick(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesLoadingOrRetryView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        ConstraintLayout r10 = LayoutInflater.from(r7).inflate(2131563398, this, false);
        addView(r10);
        int r11 = 2131378977;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r10, 2131378977);
        if (r2 == null) goto L13;
        r11 = 2131379082;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131379082);
        if (r3 == null) goto L13;
        r11 = 2131384468;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r10, 2131384468);
        if (r12 == null) goto L13;
        r11 = 2131384471;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131384471);
        if (r5 == null) goto L13;
        this.a = new LayoutRecordLoadingOrRetryViewBinding(r10, r2, r3, r12, r5);
        r12.setOnClickListener(new c(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public /* synthetic */ RecordMinutesLoadingOrRetryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
