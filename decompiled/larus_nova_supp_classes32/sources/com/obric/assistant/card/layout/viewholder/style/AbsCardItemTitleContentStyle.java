package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleTitleContentBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.NoteEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleTitleContentBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemTitleContentStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemTitleContentStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleTitleContentBinding> {

    public static final class a {
        public final lca.a a;
        public final Integer b;
        public final String c;
        public final String d;
        public final String e;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            Object[] r1 = 0 == true ? 1 : 0;
            this(null, r0, r1, 31);
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
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.a + ", avatarCoverResId=" + this.b + ", title=" + this.c + ", content=" + this.d + ", time=" + this.e + ')';
        }

        public /* synthetic */ a(lca.a r9, String r10, String r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            r9 = new lca.a(null, null, 7);
        L5:
            lca.a r3 = r9;
            if ((r12 & 4) == 0) goto L8;
            String r5 = NameKeys.UnloadStrategy_No_Strategy;
        L10:
            if ((r12 & 8) == 0) goto L12;
            String r6 = NameKeys.UnloadStrategy_No_Strategy;
        L14:
            if ((r12 & 16) == 0) goto L16;
            String r7 = NameKeys.UnloadStrategy_No_Strategy;
        L17:
            this(r3, null, r5, r6, r7);
            return;
        L16:
            r7 = null;
            goto L17
        L12:
            r6 = r11;
            goto L14
        L8:
            r5 = r10;
            goto L10
        }

        public a(lca.a r2, Integer r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "avatarRes");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, LynxAccessibilityModule.MSG_CONTENT);
            Intrinsics.checkNotNullParameter(r6, "time");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public abstract a a4(Object r1);

    public AbsCardItemTitleContentStyle(ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        ConstraintLayout r13 = LayoutInflater.from(r12.getContext()).inflate(2131563959, r12, false);
        int r0 = 2131367822;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r13, 2131367822);
        if (r4 == null) goto L17;
        r0 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r13, 2131374718);
        if (r5 == null) goto L17;
        r0 = 2131374741;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, 2131374741);
        if (r6 == null) goto L17;
        ConstraintLayout r7 = r13;
        r0 = 2131385694;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131385694);
        if (r8 == null) goto L17;
        r0 = 2131388654;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, 2131388654);
        if (r9 == null) goto L17;
        r0 = 2131388772;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, 2131388772);
        if (r10 == null) goto L17;
        super(new ObricCardItemStyleTitleContentBinding(r7, r4, r5, r6, r7, r8, r9, r10));
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r5, T r6, int r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "messageExtra");
        a r10 = a4(r6);
        boolean r11 = r6 instanceof NoteEntity;
        int r12 = 0;
        if (r11 == false) goto L5;
        int r13 = 0;
    L6:
        RelativeLayout r14 = ((ObricCardItemStyleTitleContentBinding) this.a).b;
        ViewGroup.LayoutParams r0 = r14.getLayoutParams();
        if (r0 == null) goto L52;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.setMarginStart(r13);
        r14.setLayoutParams(r1);
        SimpleDraweeView r15 = ((ObricCardItemStyleTitleContentBinding) this.a).c;
        if (r11 == false) goto L11;
        int r2 = 8;
    L12:
        r15.setVisibility(r2);
        SimpleDraweeView r16 = ((ObricCardItemStyleTitleContentBinding) this.a).c;
        if (r11 == false) goto L15;
        lca.a r3 = null;
    L16:
        AbsCardItemBaseStyle.Z3(r16, r3);
        ImageView r17 = ((ObricCardItemStyleTitleContentBinding) this.a).d;
        Integer r4 = r10.b;
        if (r4 == null) goto L19;
        int r18 = r4.intValue();
    L20:
        r17.setImageResource(r18);
        ((ObricCardItemStyleTitleContentBinding) this.a).h.setText(r10.c);
        boolean r19 = true;
        ((ObricCardItemStyleTitleContentBinding) this.a).f.setText(StringsKt.trim(r10.d, new char[]{'\n'}));
        ((ObricCardItemStyleTitleContentBinding) this.a).g.setText(r10.e);
        ImageView r20 = ((ObricCardItemStyleTitleContentBinding) this.a).d;
        if (r10.b == null) goto L25;
        if (r11 == true) goto L25;
        int r21 = 0;
    L26:
        r20.setVisibility(r21);
        TextView r22 = ((ObricCardItemStyleTitleContentBinding) this.a).g;
        if (r10.e.length() != 0) goto L29;
        boolean r23 = true;
    L30:
        if (r23 == false) goto L32;
        int r24 = 8;
    L33:
        r22.setVisibility(r24);
        String r25 = r10.d;
        if (r25 != null) goto L36;
    L39:
        if (r19 == false) goto L41;
        int r26 = 8;
    L42:
        ((ObricCardItemStyleTitleContentBinding) this.a).f.setVisibility(r26);
        TextView r27 = ((ObricCardItemStyleTitleContentBinding) this.a).h;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L50;
        RelativeLayout.LayoutParams r29 = (RelativeLayout.LayoutParams) r28;
        if (r26 != 8) goto L47;
        r12 = -1;
    L47:
        r29.addRule(15, r12);
        r27.setLayoutParams(r29);
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L41:
        r26 = 0;
        goto L42
    L36:
        if (r25.length() == 0) goto L39;
        r19 = false;
        goto L39
    L32:
        r24 = 0;
        goto L33
    L29:
        r23 = false;
    L25:
        r21 = 8;
        goto L26
    L19:
        r18 = 0;
        goto L20
    L15:
        r3 = r10.a;
        goto L16
    L11:
        r2 = 0;
        goto L12
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r13 = ((ObricCardItemStyleTitleContentBinding) this.a).e.getResources().getDimensionPixelSize(2131165877);
        goto L6
    }
}
