package com.obric.assistant.card.layout.viewholder.style;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.o0;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleDropdownListBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rca.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0015¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleDropdownListStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleDropdownListBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleDropdownListStyle$StyleData;", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleDropdownListStyle$StyleData;", "StyleData", "DropDownItem", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleDropdownListStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleDropdownListBinding> {
    public static final /* synthetic */ int l = 0;

    public static final class a {
        public final lca.a a;
        public final String b;
        public final String c;
        public final String d;

        public a() {
            this(null, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy);
        }

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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            lca.a r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "DropDownItem(iconResId=" + this.a + ", content=" + this.b + ", extraInfo=" + this.c + ", telephoneNumber=" + this.d + ')';
        }

        public a(lca.a r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
            Intrinsics.checkNotNullParameter(r4, "extraInfo");
            Intrinsics.checkNotNullParameter(r5, "telephoneNumber");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b {
        public final lca.a a;
        public final String b;
        public final int c;
        public final List<a> d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "StyleData(avatarResId=" + this.a + ", title=" + this.b + ", preCount=" + this.c + ", dropDownList=" + this.d + ')';
        }

        public b() {
            this(new lca.a(null, null, 7), NameKeys.UnloadStrategy_No_Strategy, 0, CollectionsKt.emptyList());
        }

        public b(lca.a r2, String r3, int r4, List<a> r5) {
            Intrinsics.checkNotNullParameter(r2, "avatarResId");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r5, "dropDownList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public abstract b a4(MessageExtraForViewHolder r1, Object r2);

    public AbsCardItemTitleDropdownListStyle(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r10 = LayoutInflater.from(r9.getContext()).inflate(2131563960, r9, false);
        int r0 = 2131371889;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131371889);
        if (r4 == null) goto L11;
        r0 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r10, 2131374718);
        if (r5 == null) goto L11;
        ConstraintLayout r6 = r10;
        r0 = 2131388772;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131388772);
        if (r7 == null) goto L11;
        super(new ObricCardItemStyleTitleDropdownListBinding(r6, r4, r5, r6, r7));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r18, T r19, int r20, boolean r21, boolean r22) {
        AbsCardItemTitleDropdownListStyle<T> r0 = this;
        Intrinsics.checkNotNullParameter(r18, "messageExtra");
        b r2 = a4(r18, r19);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleTitleDropdownListBinding) r0.a).c, r2.a);
        if (r20 != 0) goto L5;
        Resources r3 = ((ObricCardItemStyleTitleDropdownListBinding) r0.a).d.getContext().getResources();
        float r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
        ConstraintLayout r5 = ((ObricCardItemStyleTitleDropdownListBinding) r0.a).d;
        r5.setPadding(r5.getPaddingLeft(), (int) (16 * r4), ((ObricCardItemStyleTitleDropdownListBinding) r0.a).d.getPaddingRight(), ((ObricCardItemStyleTitleDropdownListBinding) r0.a).d.getPaddingBottom());
    L5:
        ((ObricCardItemStyleTitleDropdownListBinding) r0.a).e.setText(r2.b);
        ((ObricCardItemStyleTitleDropdownListBinding) r0.a).b.removeAllViews();
        LayoutInflater r6 = LayoutInflater.from(((ObricCardItemStyleTitleDropdownListBinding) r0.a).d.getContext());
        Iterator<T> r7 = r2.d.iterator();
        boolean r8 = false;
        int r9 = 0;
    L7:
        if (r7.hasNext() == false) goto L57;
        T r10 = r7.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        final a r12 = (a) r10;
        LinearLayout r13 = ((ObricCardItemStyleTitleDropdownListBinding) r0.a).b;
        ConstraintLayout r14 = r6.inflate(2131563961, r13, r8);
        r13.addView(r14);
        int r15 = 2131376297;
        SimpleDraweeView r16 = ViewBindings.findChildViewById(r14, 2131376297);
        if (r16 == null) goto L56;
        r15 = 2131376298;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131376298);
        if (r17 == null) goto L56;
        ConstraintLayout r23 = r14;
        View r110 = ViewBindings.findChildViewById(r14, 2131385938);
        if (r110 == null) goto L54;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r14, 2131390392);
        if (r111 == null) goto L53;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r14, 2131390393);
        if (r24 == null) goto L52;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r14, 2131391017);
        if (r112 == null) goto L51;
        Resources r113 = r23.getContext().getResources();
        r23.getLayoutParams().height = (int) (48 * WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).density);
        int r25 = 8;
        if (r12.a == null) goto L26;
        int r1 = 0;
    L27:
        r17.setVisibility(r1);
        lca.a r26 = r12.a;
        if (r26 == null) goto L36;
        AbsCardItemBaseStyle.Z3(r16, r26);
        if (Intrinsics.areEqual(r18.c, "Phone_Call") == true) goto L32;
    L34:
        View.OnClickListener r27 = null;
    L35:
        r17.setOnClickListener(r27);
        goto L36
    L32:
        if (o0.d(r12.d) == false) goto L34;
        r27 = new h(r12);
    L36:
        r112.setText(String.valueOf((r2.c + r9) + 1));
        r111.setText(r12.b);
        r24.setText(r12.c);
        String r28 = r12.c;
        if (r28 != null) goto L39;
    L42:
        boolean r29 = true;
    L43:
        if (r29 == false) goto L45;
        int r30 = 8;
    L46:
        r24.setVisibility(r30);
        if (r9 == (r2.d.size() - 1)) goto L50;
        r25 = 0;
    L50:
        r110.setVisibility(r25);
        r0 = this;
        r9 = r11;
        r8 = false;
        goto L7
    L45:
        r30 = 0;
        goto L46
    L39:
        if (r28.length() == 0) goto L42;
        r29 = false;
        goto L43
    L26:
        r1 = 8;
        goto L27
    L51:
        r15 = 2131391017;
        goto L56
    L52:
        r15 = 2131390393;
        goto L56
    L53:
        r15 = 2131390392;
        goto L56
    L54:
        r15 = 2131385938;
    L56:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
