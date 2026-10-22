package com.larus.avlink.record.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import ba8.e;
import com.larus.avlink.impl.databinding.LarusLayoutRecordMinutesSyncHeaderBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.offline.record.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesSyncHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusLayoutRecordMinutesSyncHeaderBinding;", "rotateAnimator", "Landroid/animation/ValueAnimator;", "rotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", "render", "", "state", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "hide", "initRotateDrawable", "startRotationAnimation", "stopRotationAnimation", "onDetachedFromWindow", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesSyncHeaderView extends ConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final LarusLayoutRecordMinutesSyncHeaderBinding a;
    public ValueAnimator b;
    public RotateDrawable c;

    public RecordMinutesSyncHeaderView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordMinutesSyncHeaderView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ValueAnimator r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        this.b = null;
        RotateDrawable r1 = this.c;
        if (r1 == null) goto L11;
        r1.setLevel(0);
        return;
    L11:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        r0.cancel();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(d r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        boolean r2 = false;
        if (r9.a == true) goto L13;
        setVisibility(8);
        ValueAnimator r10 = this.b;
        if (r10 != null) goto L7;
    L9:
        this.b = null;
        RotateDrawable r11 = this.c;
        if (r11 == null) goto L25;
        r11.setLevel(0);
        return;
    L25:
        return;
    L7:
        if (r10.isRunning() == false) goto L9;
        r10.cancel();
        goto L9
    L13:
        setVisibility(0);
        this.a.c.setText(getContext().getString(2131902005, new Object[]{Integer.valueOf(r9.c), Integer.valueOf(r9.b)}));
        this.a.b.setProgress(RangesKt.coerceIn(r9.d, 0, 100));
        ValueAnimator r12 = this.b;
        if (r12 != null) goto L16;
    L18:
        if (r2 == true) goto L26;
        final RotateDrawable r13 = this.c;
        if (r13 == null) goto L27;
        this.a.c.setCompoundDrawablesWithIntrinsicBounds(r13, null, null, null);
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{0, 10000});
        r0.setDuration(1000);
        r0.setRepeatCount(-1);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new e(r13));
        r0.start();
        this.b = r0;
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r12.isRunning() != true) goto L18;
        r2 = true;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesSyncHeaderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ConstraintLayout r5 = LayoutInflater.from(r2).inflate(2131562876, this, false);
        addView(r5);
        int r6 = 2131387962;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r5, 2131387962);
        if (r7 == null) goto L9;
        r6 = 2131387967;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r5, 2131387967);
        if (r0 == null) goto L9;
        this.a = new LarusLayoutRecordMinutesSyncHeaderBinding(r5, r7, r0);
        setVisibility(8);
        Drawable r8 = ContextCompat.getDrawable(getContext(), 2131240821);
        RotateDrawable r9 = new RotateDrawable();
        r9.setDrawable(r8);
        r9.setFromDegrees(0.0f);
        r9.setToDegrees(360.0f);
        r9.setPivotXRelative(true);
        r9.setPivotYRelative(true);
        r9.setPivotX(0.5f);
        r9.setPivotY(0.5f);
        this.c = r9;
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public /* synthetic */ RecordMinutesSyncHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
