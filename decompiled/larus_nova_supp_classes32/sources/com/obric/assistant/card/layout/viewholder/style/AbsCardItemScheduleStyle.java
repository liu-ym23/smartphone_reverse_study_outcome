package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleScheduleBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleScheduleBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemScheduleStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemScheduleStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleScheduleBinding> {

    public static final class a {
        public final lca.a a;
        public final int b;
        public final String c;
        public final CharSequence d;
        public final CharSequence e;

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
            if (this.b == r6.b) goto L15;
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
            return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.a + ", avatarCoverResId=" + this.b + ", name=" + this.c + ", subLine1=" + this.d + ", subLine2=" + this.e + ')';
        }

        public a(lca.a r2, int r3, String r4, CharSequence r5, CharSequence r6) {
            Intrinsics.checkNotNullParameter(r2, "iconRes");
            Intrinsics.checkNotNullParameter(r4, EasyGoDbTable.Server.NAME);
            Intrinsics.checkNotNullParameter(r5, "subLine1");
            Intrinsics.checkNotNullParameter(r6, "subLine2");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public /* synthetic */ a(lca.a r7, String r8, CharSequence r9, CharSequence r10, int r11) {
            if ((r11 & 4) == 0) goto L5;
            String r3 = NameKeys.UnloadStrategy_No_Strategy;
        L7:
            if ((r11 & 8) == 0) goto L9;
            CharSequence r4 = NameKeys.UnloadStrategy_No_Strategy;
        L11:
            if ((r11 & 16) == 0) goto L13;
            CharSequence r5 = NameKeys.UnloadStrategy_No_Strategy;
        L14:
            this(r7, 0, r3, r4, r5);
            return;
        L13:
            r5 = r10;
            goto L14
        L9:
            r4 = r9;
            goto L11
        L5:
            r3 = r8;
            goto L7
        }
    }

    public abstract a a4(Object r1);

    public AbsCardItemScheduleStyle(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r10 = LayoutInflater.from(r9.getContext()).inflate(2131563958, r9, false);
        int r0 = 2131374718;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r10, 2131374718);
        if (r4 == null) goto L13;
        r0 = 2131380593;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131380593);
        if (r5 == null) goto L13;
        ConstraintLayout r3 = r10;
        r0 = 2131387513;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131387513);
        if (r6 == null) goto L13;
        r0 = 2131387514;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, 2131387514);
        if (r7 == null) goto L13;
        super(new ObricCardItemStyleScheduleBinding(r3, r4, r5, r6, r7));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r2, T r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "messageExtra");
        a r7 = a4(r3);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleScheduleBinding) this.a).b, r7.a);
        TextView r8 = ((ObricCardItemStyleScheduleBinding) this.a).c;
        String r9 = r7.c;
        boolean r10 = true;
        int r0 = 0;
        if (r9.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        r9 = "无主题";
    L8:
        r8.setText(r9);
        ((ObricCardItemStyleScheduleBinding) this.a).d.setText(r7.d);
        ((ObricCardItemStyleScheduleBinding) this.a).e.setText(r7.e);
        TextView r12 = ((ObricCardItemStyleScheduleBinding) this.a).d;
        CharSequence r13 = r7.d;
        if (r13 != null) goto L11;
    L14:
        boolean r14 = true;
    L16:
        if (r14 == false) goto L18;
        int r15 = 8;
    L19:
        r12.setVisibility(r15);
        TextView r16 = ((ObricCardItemStyleScheduleBinding) this.a).e;
        CharSequence r17 = r7.e;
        if (r17 != null) goto L22;
    L25:
        if (r10 == false) goto L27;
        r0 = 8;
    L27:
        r16.setVisibility(r0);
        return;
    L22:
        if (r17.length() == 0) goto L25;
        r10 = false;
        goto L25
    L18:
        r15 = 0;
        goto L19
    L11:
        if (r13.length() == 0) goto L14;
        r14 = false;
        goto L16
    L5:
        r11 = false;
        goto L6
    }
}
