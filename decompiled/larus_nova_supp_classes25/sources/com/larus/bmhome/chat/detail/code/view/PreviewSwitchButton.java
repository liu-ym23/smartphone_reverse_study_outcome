package com.larus.bmhome.chat.detail.code.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import re8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/view/PreviewSwitchButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnState1", "Landroid/widget/TextView;", "btnState2", "indicator", "Landroid/view/View;", "isState1Selected", "", "onStateChangeListener", "Lcom/larus/bmhome/chat/detail/code/view/PreviewSwitchButton$OnStateChangeListener;", "setState", "", "switchToState1", "switchToState2", "setOnStateChangeListener", "listener", "OnStateChangeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PreviewSwitchButton extends ConstraintLayout {
    public final TextView a;
    public final TextView b;
    public final View c;
    public boolean d;
    public a e;

    public interface a {
        void a(boolean r1);
    }

    public PreviewSwitchButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PreviewSwitchButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        this.d = true;
        View r1 = this.c;
        Typeface r2 = null;
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L7:
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        r4.startToStart = 2131364846;
        r4.endToEnd = 2131364846;
        this.c.setLayoutParams(r4);
        TextView r5 = this.a;
        if (r5 == null) goto L20;
        if (r5 == null) goto L18;
        Typeface r6 = r5.getTypeface();
        if (r6 == null) goto L18;
        Typeface r0 = Typeface.create(r6, 1);
    L19:
        r5.setTypeface(r0);
    L18:
        r0 = null;
    L20:
        TextView r7 = this.b;
        if (r7 == null) goto L28;
        if (r7 == null) goto L26;
        Typeface r8 = r7.getTypeface();
        if (r8 == null) goto L26;
        r2 = Typeface.create(r8, 0);
    L26:
        r7.setTypeface(r2);
        return;
    L28:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final void S5() {
        this.d = false;
        View r1 = this.c;
        Typeface r2 = null;
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L7:
        if ((r3 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
    L10:
        if (r4 != null) goto L12;
        return;
    L12:
        r4.startToStart = 2131364847;
        r4.endToEnd = 2131364847;
        this.c.setLayoutParams(r4);
        TextView r5 = this.a;
        if (r5 == null) goto L20;
        if (r5 == null) goto L18;
        Typeface r6 = r5.getTypeface();
        if (r6 == null) goto L18;
        Typeface r0 = Typeface.create(r6, 0);
    L19:
        r5.setTypeface(r0);
    L18:
        r0 = null;
    L20:
        TextView r7 = this.b;
        if (r7 == null) goto L28;
        if (r7 == null) goto L26;
        Typeface r8 = r7.getTypeface();
        if (r8 == null) goto L26;
        r2 = Typeface.create(r8, 1);
    L26:
        r7.setTypeface(r2);
        return;
    L28:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final void setOnStateChangeListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e = r2;
    }

    public final void setState(boolean r2) {
        if (r2 != this.d) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        R5();
        return;
    L7:
        S5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewSwitchButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = true;
        ViewGroup.inflate(r2, 2131562864, this);
        TextView r5 = (TextView) findViewById(2131364846);
        this.a = r5;
        TextView r6 = (TextView) findViewById(2131364847);
        this.b = r6;
        this.c = findViewById(2131375226);
        if (r5 == null) goto L5;
        r5.setOnClickListener(new re8.a(this));
    L5:
        if (r6 == null) goto L8;
        r6.setOnClickListener(new b(this));
        return;
    }

    public /* synthetic */ PreviewSwitchButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
