package com.obric.assistant.card.layout.viewholder.style;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleSubtitleBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleSubtitleBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleSubTitleStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleSubTitleStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleSubtitleBinding> {

    public static final class a {
        public final lca.a a;
        public final String b;
        public final boolean c;
        public final String d;
        public final Integer e;
        public final String f;

        public a() {
            this(null, null, false, null, null, 63);
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
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.d.hashCode()) * 31;
            Integer r3 = this.e;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return ((r2 + r4) * 31) + this.f.hashCode();
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.a + ", title=" + this.b + ", isTitleColorRed=" + this.c + ", subTitle=" + this.d + ", subTitleRightIconResId=" + this.e + ", time=" + this.f + ')';
        }

        public a(lca.a r4, String r5, boolean r6, String r7, String r8, int r9) {
            if ((r9 & 1) == 0) goto L6;
            r4 = new lca.a(null, null, 7);
        L6:
            if ((r9 & 2) == 0) goto L9;
            r5 = NameKeys.UnloadStrategy_No_Strategy;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r6 = false;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r7 = NameKeys.UnloadStrategy_No_Strategy;
        L15:
            if ((r9 & 32) == 0) goto L17;
            r8 = NameKeys.UnloadStrategy_No_Strategy;
        L17:
            Intrinsics.checkNotNullParameter(r4, "avatarRes");
            Intrinsics.checkNotNullParameter(r5, "title");
            Intrinsics.checkNotNullParameter(r7, "subTitle");
            Intrinsics.checkNotNullParameter(r8, "time");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = null;
            this.f = r8;
        }
    }

    public abstract a a4(Object r1);

    public AbsCardItemTitleSubTitleStyle(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        ConstraintLayout r11 = LayoutInflater.from(r10.getContext()).inflate(2131563962, r10, false);
        int r0 = 2131374718;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r11, 2131374718);
        if (r4 == null) goto L15;
        ConstraintLayout r3 = r11;
        r0 = 2131385694;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131385694);
        if (r5 == null) goto L15;
        r0 = 2131385697;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, 2131385697);
        if (r6 == null) goto L15;
        r0 = 2131388654;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131388654);
        if (r7 == null) goto L15;
        r0 = 2131388772;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, 2131388772);
        if (r8 == null) goto L15;
        super(new ObricCardItemStyleTitleSubtitleBinding(r3, r4, r5, r6, r7, r8));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r1, T r2, int r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        a r6 = a4(r2);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleTitleSubtitleBinding) this.a).b, r6.a);
        ((ObricCardItemStyleTitleSubtitleBinding) this.a).f.setText(r6.b);
        TextView r7 = ((ObricCardItemStyleTitleSubtitleBinding) this.a).f;
        Context r8 = getContext();
        if (r6.c == false) goto L5;
        int r9 = 2131103800;
    L6:
        r7.setTextColor(ContextCompat.getColor(r8, r9));
        ((ObricCardItemStyleTitleSubtitleBinding) this.a).c.setText(r6.d);
        ImageView r10 = ((ObricCardItemStyleTitleSubtitleBinding) this.a).d;
        Integer r11 = r6.e;
        int r12 = 0;
        if (r11 == null) goto L9;
        int r13 = r11.intValue();
    L10:
        r10.setImageResource(r13);
        ((ObricCardItemStyleTitleSubtitleBinding) this.a).e.setText(r6.f);
        ImageView r14 = ((ObricCardItemStyleTitleSubtitleBinding) this.a).d;
        Integer r15 = r6.e;
        if (r15 == null) goto L13;
        int r16 = r15.intValue();
    L15:
        if (r16 != 0) goto L17;
        int r17 = 8;
    L18:
        r14.setVisibility(r17);
        TextView r18 = ((ObricCardItemStyleTitleSubtitleBinding) this.a).e;
        if (r6.f.length() != 0) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L24;
        r12 = 8;
    L24:
        r18.setVisibility(r12);
        return;
    L21:
        r19 = false;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L15
    L9:
        r13 = 0;
        goto L10
    L5:
        r9 = 2131103681;
        goto L6
    }
}
