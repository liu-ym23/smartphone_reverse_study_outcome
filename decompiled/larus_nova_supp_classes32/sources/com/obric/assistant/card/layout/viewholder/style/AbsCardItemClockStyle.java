package com.obric.assistant.card.layout.viewholder.style;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleClockBinding;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rca.b;
import rca.c;
import rca.d;
import rca.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001.B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001aH\u0014J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001aH\u0002J \u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001aH\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001aH\u0003J%\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\nH&¢\u0006\u0002\u0010-R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle;", "T", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleClockBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "defaultMinimumHeight", NameKeys.UnloadStrategy_No_Strategy, "defaultPaddingStart", "defaultPaddingTop", "defaultPaddingEnd", "defaultPaddingBottom", "defaultTitleTextColor", "defaultTitleBottomToTop", "defaultTitleVerticalChainStyle", "defaultSecondTitleBottomToBottom", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;IZZ)V", "onEnabledStateChanged", "isEnabled", "bindAlarmSwitch", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "isChecked", "applyClockLayout", "useShowAllAlarmStyle", "applyShowAllAlarmTextConstraints", "bindSecondTitle", "title", NameKeys.UnloadStrategy_No_Strategy, "prioritizedExtra", "alignExtraToTitle", "updateInteractiveState", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemClockStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemClockStyle<T extends AppEntity> extends AbsCardItemBaseStyle<T, ObricCardItemStyleClockBinding> {
    public static final /* synthetic */ int u = 0;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;

    public static final class a {
        public final lca.a a;
        public final String b;
        public final CharSequence c;
        public final CharSequence d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.a + ", title=" + this.b + ", secondTitle=" + this.c + ", secondTitleExtra=" + this.d + ", isEnabled=" + this.e + ')';
        }

        public a(lca.a r2, String r3, CharSequence r4, CharSequence r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r2, "iconRes");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "secondTitle");
            Intrinsics.checkNotNullParameter(r5, "secondTitleExtra");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public abstract a a4(MessageExtraForViewHolder r1, AppEntity r2);

    public AbsCardItemClockStyle(ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r14, "parent");
        ConstraintLayout r15 = LayoutInflater.from(r14.getContext()).inflate(2131563955, r14, false);
        int r0 = 2131362147;
        Barrier r4 = ViewBindings.findChildViewById(r15, 2131362147);
        if (r4 == null) goto L21;
        r0 = 2131371651;
        OSwitch r5 = ViewBindings.findChildViewById(r15, 2131371651);
        if (r5 == null) goto L21;
        ConstraintLayout r6 = r15;
        r0 = 2131385694;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r15, 2131385694);
        if (r7 == null) goto L21;
        r0 = 2131385695;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131385695);
        if (r8 == null) goto L21;
        r0 = 2131385696;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, 2131385696);
        if (r9 == null) goto L21;
        r0 = 2131385698;
        View r10 = ViewBindings.findChildViewById(r15, 2131385698);
        if (r10 == null) goto L21;
        r0 = 2131388453;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r15, 2131388453);
        if (r11 == null) goto L21;
        r0 = 2131388772;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r15, 2131388772);
        if (r12 == null) goto L21;
        super(new ObricCardItemStyleClockBinding(r6, r4, r5, r6, r7, r8, r9, r10, r11, r12));
        this.l = ((ObricCardItemStyleClockBinding) this.a).d.getMinimumHeight();
        this.m = ((ObricCardItemStyleClockBinding) this.a).d.getPaddingStart();
        this.n = ((ObricCardItemStyleClockBinding) this.a).d.getPaddingTop();
        this.o = ((ObricCardItemStyleClockBinding) this.a).d.getPaddingEnd();
        this.p = ((ObricCardItemStyleClockBinding) this.a).d.getPaddingBottom();
        this.q = ((ObricCardItemStyleClockBinding) this.a).j.getCurrentTextColor();
        ConstraintLayout.LayoutParams r16 = ((ObricCardItemStyleClockBinding) this.a).j.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.r = r16.bottomToTop;
        ConstraintLayout.LayoutParams r17 = ((ObricCardItemStyleClockBinding) this.a).j.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.s = r17.verticalChainStyle;
        ConstraintLayout.LayoutParams r18 = ((ObricCardItemStyleClockBinding) this.a).f.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.t = r18.bottomToBottom;
        ((ObricCardItemStyleClockBinding) this.a).b.setReferencedIds(new int[]{2131371651, 2131388453});
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.style.AbsCardItemBaseStyle
    public final void X3(boolean r1) {
        b4(r1);
    }

    public final void b4(boolean r3) {
        ((ObricCardItemStyleClockBinding) this.a).c.setEnabled(true);
        ((ObricCardItemStyleClockBinding) this.a).c.setClickable(r3);
        ((ObricCardItemStyleClockBinding) this.a).c.setFocusable(r3);
        OSwitch r0 = ((ObricCardItemStyleClockBinding) this.a).c;
        if (r3 == false) goto L5;
        View.OnTouchListener r4 = null;
    L6:
        r0.setOnTouchListener(r4);
        return;
    L5:
        r4 = new b();
        goto L6
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r9, Object r10, int r11, final boolean r12, final boolean r13) {
        final AlarmEntity r14 = (AppEntity) r10;
        Intrinsics.checkNotNullParameter(r9, "messageExtra");
        Intrinsics.checkNotNullParameter(r14, "entity");
        a r15 = a4(r9, r14);
        AppEntityListAdapter.PageType r16 = this.f;
        if (r16 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r16 = null;
    L6:
        int r3 = 0;
        if (r16 == AppEntityListAdapter.PageType.ShowAllPage) goto L9;
    L11:
        boolean r17 = false;
    L12:
        ConstraintLayout r1 = ((ObricCardItemStyleClockBinding) this.a).d;
        if (r17 == false) goto L15;
        int r4 = getContext().getResources().getDimensionPixelSize(2131166256);
    L16:
        r1.setMinimumHeight(r4);
        if (r17 == false) goto L19;
        Integer r5 = Integer.valueOf(getContext().getResources().getDimensionPixelSize(2131165877));
    L20:
        if (r17 == false) goto L22;
        Integer r6 = Integer.valueOf(getContext().getResources().getDimensionPixelSize(2131165877));
    L23:
        if (r5 == null) goto L25;
        int r7 = r5.intValue();
    L26:
        if (r6 == null) goto L28;
        int r8 = r6.intValue();
    L29:
        if (r5 == null) goto L31;
        int r18 = r5.intValue();
    L32:
        if (r6 == null) goto L34;
        int r19 = r6.intValue();
    L35:
        r1.setPaddingRelative(r7, r8, r18, r19);
        TextView r2 = ((ObricCardItemStyleClockBinding) this.a).j;
        Resources r20 = getContext().getResources();
        if (r17 == false) goto L38;
        int r21 = 2131166020;
    L39:
        r2.setTextSize(0, r20.getDimension(r21));
        TextView r22 = ((ObricCardItemStyleClockBinding) this.a).j;
        if (r17 == false) goto L42;
        int r23 = getContext().getResources().getColor(2131104350);
    L43:
        r22.setTextColor(r23);
        Resources r24 = getContext().getResources();
        if (r17 == false) goto L46;
        int r25 = 2131104359;
    L47:
        int r26 = r24.getColor(r25);
        ((ObricCardItemStyleClockBinding) this.a).e.setTextColor(r26);
        ((ObricCardItemStyleClockBinding) this.a).g.setTextColor(r26);
        ViewGroup.LayoutParams r27 = ((ObricCardItemStyleClockBinding) this.a).j.getLayoutParams();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        if (r17 == false) goto L50;
        int r29 = 2131385695;
    L51:
        ((ConstraintLayout.LayoutParams) r28).bottomToTop = r29;
        if (r17 == false) goto L54;
        int r30 = 2;
    L55:
        ((ConstraintLayout.LayoutParams) r28).verticalChainStyle = r30;
        ((ObricCardItemStyleClockBinding) this.a).j.setLayoutParams(r28);
        ViewGroup.LayoutParams r31 = ((ObricCardItemStyleClockBinding) this.a).f.getLayoutParams();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r32 = (ConstraintLayout.LayoutParams) r31;
        if (r17 == false) goto L58;
        int r33 = 0;
    L59:
        ((ConstraintLayout.LayoutParams) r32).bottomToBottom = r33;
        ((ObricCardItemStyleClockBinding) this.a).f.setLayoutParams(r32);
        ViewGroup.LayoutParams r34 = ((ObricCardItemStyleClockBinding) this.a).e.getLayoutParams();
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r35 = (LinearLayout.LayoutParams) r34;
        if (r17 == false) goto L62;
        int r36 = -2;
    L63:
        r35.width = r36;
        if (r17 == false) goto L66;
        float r37 = 0.0f;
    L67:
        r35.weight = r37;
        ((ObricCardItemStyleClockBinding) this.a).e.setLayoutParams(r35);
        ((ObricCardItemStyleClockBinding) this.a).j.setText(r15.b);
        ((ObricCardItemStyleClockBinding) this.a).d.setOnClickListener(new c(r12, this, r13, r14));
        if ((r14 instanceof AlarmEntity) == false) goto L70;
        final AlarmEntity r110 = r14;
        boolean r38 = r15.e;
        ((ObricCardItemStyleClockBinding) this.a).c.setOnCheckedChangeListener(null);
        ((ObricCardItemStyleClockBinding) this.a).c.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).c.setChecked(r38);
        ((ObricCardItemStyleClockBinding) this.a).c.setOnCheckedChangeListener(new d(r110));
        ((ObricCardItemStyleClockBinding) this.a).i.setVisibility(8);
    L71:
        if (r12 == false) goto L73;
        ((ObricCardItemStyleClockBinding) this.a).i.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).i.setText(getContext().getResources().getString(2131911959));
        ((ObricCardItemStyleClockBinding) this.a).c.setVisibility(8);
    L75:
        CharSequence r111 = StringsKt.trim(r15.c, new char[]{'\n'});
        CharSequence r39 = StringsKt.trim(r15.d, new char[]{'\n'});
        ((ObricCardItemStyleClockBinding) this.a).e.setText(r111);
        ((ObricCardItemStyleClockBinding) this.a).g.setText(r39);
        ((ObricCardItemStyleClockBinding) this.a).e.setMaxWidth(Integer.MAX_VALUE);
        if (r39.length() != 0) goto L78;
        boolean r112 = true;
    L79:
        if (r112 == false) goto L94;
        LinearLayout r40 = ((ObricCardItemStyleClockBinding) this.a).f;
        if (r111.length() != 0) goto L83;
        boolean r113 = true;
    L84:
        if (r113 == false) goto L86;
        int r114 = 8;
    L87:
        r40.setVisibility(r114);
        TextView r41 = ((ObricCardItemStyleClockBinding) this.a).e;
        if (r111.length() != 0) goto L90;
        boolean r115 = true;
    L91:
        if (r115 == false) goto L93;
        r3 = 8;
    L93:
        r41.setVisibility(r3);
        ((ObricCardItemStyleClockBinding) this.a).h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).g.setVisibility(8);
    L124:
        b4(true);
        return;
    L90:
        r115 = false;
        goto L91
    L86:
        r114 = 0;
        goto L87
    L83:
        r113 = false;
        goto L84
    L94:
        ((ObricCardItemStyleClockBinding) this.a).f.setVisibility(4);
        TextView r116 = ((ObricCardItemStyleClockBinding) this.a).e;
        if (r111.length() != 0) goto L97;
        boolean r0 = true;
    L98:
        if (r0 == false) goto L100;
        int r42 = 8;
    L101:
        r116.setVisibility(r42);
        ((ObricCardItemStyleClockBinding) this.a).h.setVisibility(4);
        ((ObricCardItemStyleClockBinding) this.a).g.setVisibility(4);
        LinearLayout r117 = ((ObricCardItemStyleClockBinding) this.a).f;
        if (r117.isLaidOut() == true) goto L104;
    L123:
        r117.addOnLayoutChangeListener(new e(this, r39, r111, r17));
        goto L124
    L104:
        if (r117.isLayoutRequested() == true) goto L123;
        int r118 = ((ObricCardItemStyleClockBinding) this.a).f.getWidth();
        float r43 = ((ObricCardItemStyleClockBinding) this.a).g.getPaint().measureText(r39.toString());
        ViewGroup.LayoutParams r119 = ((ObricCardItemStyleClockBinding) this.a).h.getLayoutParams();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        int r44 = (((ObricCardItemStyleClockBinding) this.a).h.getMeasuredWidth() + r120.getMarginStart()) + r120.getMarginEnd();
        int r121 = getContext().getResources().getDimensionPixelSize(2131166020);
        if (r118 <= 0) goto L122;
        float r122 = r118;
        if (r43 > r122) goto L122;
        if (r111.length() != 0) goto L113;
        boolean r123 = true;
    L114:
        if (r123 == true) goto L121;
        float r124 = r44;
        if (((r43 + r124) + r121) > r122) goto L121;
        if (r17 == false) goto L120;
        ((ObricCardItemStyleClockBinding) this.a).e.setMaxWidth((int) ((r122 - r43) - r124));
    L120:
        ((ObricCardItemStyleClockBinding) this.a).f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).e.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).h.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).g.setVisibility(0);
    L121:
        ((ObricCardItemStyleClockBinding) this.a).f.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).g.setVisibility(0);
        goto L124
    L113:
        r123 = false;
    L122:
        ((ObricCardItemStyleClockBinding) this.a).f.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).e.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).h.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).g.setVisibility(8);
        goto L124
    L100:
        r42 = 4;
        goto L101
    L97:
        r0 = false;
        goto L98
    L78:
        r112 = false;
        goto L79
    L73:
        if (r13 == false) goto L75;
        ((ObricCardItemStyleClockBinding) this.a).i.setVisibility(0);
        ((ObricCardItemStyleClockBinding) this.a).i.setText(getContext().getResources().getString(2131911960));
        ((ObricCardItemStyleClockBinding) this.a).c.setVisibility(8);
        goto L75
    L70:
        ((ObricCardItemStyleClockBinding) this.a).c.setOnCheckedChangeListener(null);
        ((ObricCardItemStyleClockBinding) this.a).c.setVisibility(8);
        ((ObricCardItemStyleClockBinding) this.a).i.setVisibility(8);
        goto L71
    L66:
        r37 = 1.0f;
        goto L67
    L62:
        r36 = 0;
        goto L63
    L58:
        r33 = this.t;
        goto L59
    L54:
        r30 = this.s;
        goto L55
    L50:
        r29 = this.r;
        goto L51
    L46:
        r25 = 2131103684;
        goto L47
    L42:
        r23 = this.q;
        goto L43
    L38:
        r21 = 2131166064;
        goto L39
    L34:
        r19 = this.p;
        goto L35
    L31:
        r18 = this.o;
        goto L32
    L28:
        r8 = this.n;
        goto L29
    L25:
        r7 = this.m;
        goto L26
    L22:
        r6 = null;
        goto L23
    L19:
        r5 = null;
        goto L20
    L15:
        r4 = this.l;
        goto L16
    L9:
        if ((r14 instanceof AlarmEntity) == false) goto L11;
        r17 = true;
        goto L12
    }
}
