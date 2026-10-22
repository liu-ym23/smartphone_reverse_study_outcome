package rca;

import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.card.databinding.ObricCardItemStyleClockBinding;
import com.obric.assistant.card.layout.viewholder.style.AbsCardItemClockStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements View.OnLayoutChangeListener {
    public final /* synthetic */ AbsCardItemClockStyle a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ CharSequence c;
    public final /* synthetic */ boolean d;

    public e(AbsCardItemClockStyle r1, CharSequence r2, CharSequence r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        AbsCardItemClockStyle r10 = this.a;
        int r11 = AbsCardItemClockStyle.u;
        int r12 = ((ObricCardItemStyleClockBinding) r10.a).f.getWidth();
        float r13 = ((ObricCardItemStyleClockBinding) this.a.a).g.getPaint().measureText(this.b.toString());
        ViewGroup.LayoutParams r14 = ((ObricCardItemStyleClockBinding) this.a.a).h.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        int r16 = (((ObricCardItemStyleClockBinding) this.a.a).h.getMeasuredWidth() + r15.getMarginStart()) + r15.getMarginEnd();
        int r17 = this.a.getContext().getResources().getDimensionPixelSize(2131166020);
        if (r12 <= 0) goto L20;
        float r18 = r12;
        if (r13 > r18) goto L20;
        if (this.c.length() != 0) goto L10;
        boolean r19 = true;
    L11:
        if (r19 == true) goto L19;
        float r20 = r16;
        if (((r13 + r20) + r17) > r18) goto L19;
        if (this.d == false) goto L18;
        ((ObricCardItemStyleClockBinding) this.a.a).e.setMaxWidth((int) ((r18 - r13) - r20));
    L18:
        ((ObricCardItemStyleClockBinding) this.a.a).f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a.a).e.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a.a).h.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a.a).g.setVisibility(0);
        return;
    L19:
        ((ObricCardItemStyleClockBinding) this.a.a).f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a.a).e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a.a).h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a.a).g.setVisibility(0);
        return;
    L10:
        r19 = false;
    L20:
        ((ObricCardItemStyleClockBinding) this.a.a).f.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a.a).e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a.a).h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a.a).g.setVisibility(8);
    }
}
