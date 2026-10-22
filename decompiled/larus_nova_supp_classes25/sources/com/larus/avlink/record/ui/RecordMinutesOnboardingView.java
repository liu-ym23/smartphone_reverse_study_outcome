package com.larus.avlink.record.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.d;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesOnboardingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordMinutesOnboardingBinding;", "onShortcutClick", "Lkotlin/Function0;", "", "getOnShortcutClick", "()Lkotlin/jvm/functions/Function0;", "setOnShortcutClick", "(Lkotlin/jvm/functions/Function0;)V", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesOnboardingView extends ConstraintLayout {
    public Function0<Unit> a;

    public RecordMinutesOnboardingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordMinutesOnboardingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getOnShortcutClick() {
        return this.a;
    }

    public final void setOnShortcutClick(Function0<Unit> r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesOnboardingView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ConstraintLayout r6 = LayoutInflater.from(r3).inflate(2131563401, this, false);
        addView(r6);
        int r7 = 2131368849;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131368849)) == null) goto L13;
        r7 = 2131374718;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r6, 2131374718);
        if (r8 == null) goto L13;
        r7 = 2131386366;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131386366);
        if (r0 == null) goto L13;
        r7 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131388772)) == null) goto L13;
        r0.setOnClickListener(new d(this));
        r8.setImageResource(DoraGResourceServiceDelegate.b.i());
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public /* synthetic */ RecordMinutesOnboardingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
