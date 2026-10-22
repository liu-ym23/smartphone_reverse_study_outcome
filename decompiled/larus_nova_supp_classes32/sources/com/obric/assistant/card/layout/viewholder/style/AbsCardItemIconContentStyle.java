package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleIconContentBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000eH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconContentStyle;", "T", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleIconContentBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Ljava/lang/Object;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconContentStyle$StyleData;", "(Ljava/lang/Object;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconContentStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemIconContentStyle<T> extends AbsCardItemBaseStyle<T, ObricCardItemStyleIconContentBinding> {

    public static final class a {
        public final lca.a a;
        public final String b;
        public final String c;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "StyleData(avatarRes=" + this.a + ", name=" + this.b + ", content=" + this.c + ')';
        }

        public a() {
            this(new lca.a(null, null, 7), NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy);
        }

        public a(lca.a r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "avatarRes");
            Intrinsics.checkNotNullParameter(r3, EasyGoDbTable.Server.NAME);
            Intrinsics.checkNotNullParameter(r4, LynxAccessibilityModule.MSG_CONTENT);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public abstract a a4(Object r1);

    public AbsCardItemIconContentStyle(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r10 = LayoutInflater.from(r9.getContext()).inflate(2131563956, r9, false);
        int r0 = 2131365006;
        if (((ViewStub) ViewBindings.findChildViewById(r10, 2131365006)) == null) goto L15;
        r0 = 2131367794;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131367794);
        if (r4 == null) goto L15;
        r0 = 2131367812;
        if (ViewBindings.findChildViewById(r10, 2131367812) == null) goto L15;
        r0 = 2131374718;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r10, 2131374718);
        if (r5 == null) goto L15;
        r0 = 2131380593;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131380593);
        if (r6 == null) goto L15;
        ConstraintLayout r7 = r10;
        super(new ObricCardItemStyleIconContentBinding(r7, r4, r5, r6, r7));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public void T3(MessageExtraForViewHolder r1, T r2, int r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        a r6 = a4(r2);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleIconContentBinding) this.a).c, r6.a);
        ((ObricCardItemStyleIconContentBinding) this.a).d.setText(r6.b);
        ((ObricCardItemStyleIconContentBinding) this.a).b.setText(StringsKt.trim(r6.c, new char[]{'\n'}));
    }
}
