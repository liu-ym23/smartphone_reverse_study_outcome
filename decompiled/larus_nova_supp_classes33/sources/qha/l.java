package qha;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarSkillHolderBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l extends BaseActionBarHolder {
    public final ObricItemPhoneOperationActionbarSkillHolderBinding a;
    public final t1 b;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public final void U3(boolean r5) {
        ConstraintLayout.LayoutParams r0 = this.a.c.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = r0;
        if (r5 == false) goto L5;
        r1.startToEnd = -1;
        r1.startToStart = 0;
        r1.setMarginStart(((RecyclerView.ViewHolder) this).itemView.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971255, ((RecyclerView.ViewHolder) this).itemView.getContext(), 2131166880)));
    L6:
        this.a.c.setLayoutParams(r1);
        return;
    L5:
        r1.startToEnd = -1;
        r1.startToStart = 0;
        r1.setMarginStart(0);
        goto L6
    }

    public l(ObricItemPhoneOperationActionbarSkillHolderBinding r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
