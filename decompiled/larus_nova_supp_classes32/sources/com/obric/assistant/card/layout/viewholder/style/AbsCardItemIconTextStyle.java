package com.obric.assistant.card.layout.viewholder.style;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardItemStyleIconTextBinding;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle;", "T", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemBaseStyle;", "Lcom/obric/assistant/card/databinding/ObricCardItemStyleIconTextBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", NameKeys.UnloadStrategy_No_Strategy, "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "(Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;Lcom/obric/capabilitykit/entity/app/AppEntity;IZZ)V", "generateStyleData", "Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle$StyleData;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;I)Lcom/obric/assistant/card/layout/viewholder/style/AbsCardItemIconTextStyle$StyleData;", "StyleData", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCardItemIconTextStyle<T extends AppEntity> extends AbsCardItemBaseStyle<T, ObricCardItemStyleIconTextBinding> {

    public static final class a {
        public final lca.a a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "StyleData(iconRes=" + this.a + ", text=" + this.b + ')';
        }

        public a(lca.a r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "iconRes");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.a = r2;
            this.b = r3;
        }
    }

    public abstract a a4(AppEntity r1);

    public AbsCardItemIconTextStyle(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ConstraintLayout r6 = LayoutInflater.from(r5.getContext()).inflate(2131563957, r5, false);
        int r0 = 2131374718;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r6, 2131374718);
        if (r1 == null) goto L10;
        ConstraintLayout r2 = r6;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, 2131388367);
        if (r3 == null) goto L8;
        super(new ObricCardItemStyleIconTextBinding(r2, r1, r3));
        return;
    L8:
        r0 = 2131388367;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r1, Object r2, int r3, boolean r4, boolean r5) {
        AppEntity r6 = (AppEntity) r2;
        Intrinsics.checkNotNullParameter(r1, "messageExtra");
        Intrinsics.checkNotNullParameter(r6, "entity");
        a r7 = a4(r6);
        AbsCardItemBaseStyle.Z3(((ObricCardItemStyleIconTextBinding) this.a).b, r7.a);
        ((ObricCardItemStyleIconTextBinding) this.a).c.setText(StringsKt.trim(r7.b, new char[]{'\n'}));
    }
}
