package com.larus.avlink.env.diary.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LarusViewDiaryFeedbackEntryBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import k98.a;
import k98.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/avlink/env/diary/feedback/ui/DiaryFeedbackEntryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusViewDiaryFeedbackEntryBinding;", "value", "selectedActionType", "getSelectedActionType", "()I", "onLikeClick", "Lkotlin/Function0;", "", "getOnLikeClick", "()Lkotlin/jvm/functions/Function0;", "setOnLikeClick", "(Lkotlin/jvm/functions/Function0;)V", "onDislikeClick", "getOnDislikeClick", "setOnDislikeClick", "bind", "model", "Lcom/larus/avlink/env/diary/feedback/model/DiaryFeedbackEntryUiModel;", "updateSelectedActionType", "actionType", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryFeedbackEntryView extends ConstraintLayout {
    public final LarusViewDiaryFeedbackEntryBinding a;
    public int b;
    public Function0<Unit> c;
    public Function0<Unit> d;

    public DiaryFeedbackEntryView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DiaryFeedbackEntryView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getOnDislikeClick() {
        return this.d;
    }

    public final Function0<Unit> getOnLikeClick() {
        return this.c;
    }

    public final int getSelectedActionType() {
        return this.b;
    }

    public final void setOnDislikeClick(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnLikeClick(Function0<Unit> r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiaryFeedbackEntryView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        ConstraintLayout r15 = LayoutInflater.from(r12).inflate(2131563208, this, false);
        addView(r15);
        int r16 = 2131369537;
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131369537)) == null) goto L23;
        r16 = 2131369538;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r15, 2131369538);
        if (r2 == null) goto L23;
        r16 = 2131369539;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131369539);
        if (r17 == null) goto L23;
        r16 = 2131369540;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r15, 2131369540);
        if (r4 == null) goto L23;
        r16 = 2131369541;
        View r5 = ViewBindings.findChildViewById(r15, 2131369541);
        if (r5 == null) goto L23;
        r16 = 2131369542;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r15, 2131369542);
        if (r6 == null) goto L23;
        r16 = 2131369543;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131369543);
        if (r10 == null) goto L23;
        r16 = 2131369544;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, 2131369544);
        if (r8 == null) goto L23;
        r16 = 2131369546;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131369546);
        if (r9 == null) goto L23;
        this.a = new LarusViewDiaryFeedbackEntryBinding(r15, r2, r17, r4, r5, r6, r10, r8, r9);
        r10.setOnClickListener(new a(this));
        r17.setOnClickListener(new b(this));
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public /* synthetic */ DiaryFeedbackEntryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
