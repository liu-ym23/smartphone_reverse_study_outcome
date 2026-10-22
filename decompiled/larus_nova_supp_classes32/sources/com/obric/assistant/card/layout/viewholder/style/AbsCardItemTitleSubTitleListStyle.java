package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleSubtitleListBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rca.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0015¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleListStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleSubtitleListBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleListStyle$StyleData;", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleListStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleSubTitleListStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleSubtitleListBinding> {
    public static final /* synthetic */ int l = 0;

    public static final class a {
        public final lca.a a;
        public final String b;
        public final List<String> c;
        public final lca.a d;
        public final String e;

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
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            lca.a r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.a + ", title=" + this.b + ", subTitleList=" + this.c + ", iconRes=" + this.d + ", telephoneNumber=" + this.e + ')';
        }

        public a(lca.a r2, String r3, List<String> r4, lca.a r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "avatarRes");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "subTitleList");
            Intrinsics.checkNotNullParameter(r6, "telephoneNumber");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public abstract a a4(MessageExtraForViewHolder r1, Object r2);

    public AbsCardItemTitleSubTitleListStyle(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        ConstraintLayout r12 = LayoutInflater.from(r11.getContext()).inflate(2131563963, r11, false);
        int r0 = 2131371889;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131371889);
        if (r4 == null) goto L15;
        r0 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r12, 2131374718);
        if (r5 == null) goto L15;
        r0 = 2131376297;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r12, 2131376297);
        if (r6 == null) goto L15;
        r0 = 2131376298;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131376298);
        if (r7 == null) goto L15;
        ConstraintLayout r8 = r12;
        r0 = 2131388772;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, 2131388772);
        if (r9 == null) goto L15;
        super(new ObricCardItemStyleTitleSubtitleListBinding(r8, r4, r5, r6, r7, r8, r9));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r3, T r4, int r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "messageExtra");
        final a r8 = a4(r3, r4);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleTitleSubtitleListBinding) this.a).c, r8.a);
        ((ObricCardItemStyleTitleSubtitleListBinding) this.a).g.setText(r8.b);
        ((ObricCardItemStyleTitleSubtitleListBinding) this.a).b.removeAllViews();
        LinearLayout r9 = ((ObricCardItemStyleTitleSubtitleListBinding) this.a).e;
        if (r8.d == null) goto L5;
        int r10 = 0;
    L6:
        r9.setVisibility(r10);
        lca.a r11 = r8.d;
        if (r11 == null) goto L15;
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleTitleSubtitleListBinding) this.a).d, r11);
        LinearLayout r12 = ((ObricCardItemStyleTitleSubtitleListBinding) this.a).e;
        if (Intrinsics.areEqual(r3.c, "Phone_Call") == true) goto L11;
    L13:
        View.OnClickListener r13 = null;
    L14:
        r12.setOnClickListener(r13);
        goto L15
    L11:
        if (o0.d(r8.e) == false) goto L13;
        r13 = new i(r8);
    L15:
        LayoutInflater r14 = LayoutInflater.from(((ObricCardItemStyleTitleSubtitleListBinding) this.a).f.getContext());
        Iterator<T> r15 = r8.c.iterator();
        int r16 = 0;
    L17:
        if (r15.hasNext() == false) goto L26;
        T r17 = r15.next();
        int r0 = r16 + 1;
        if (r16 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        String r18 = (String) r17;
        LinearLayout r19 = ((ObricCardItemStyleTitleSubtitleListBinding) this.a).b;
        View r1 = r14.inflate(2131563964, r19, false);
        r19.addView(r1);
        if (r1 == null) goto L25;
        ((TextView) r1).setText(r18);
        r16 = r0;
        goto L17
    L25:
        throw new NullPointerException("rootView");
    L26:
        return;
    L5:
        r10 = 8;
        goto L6
    }
}
