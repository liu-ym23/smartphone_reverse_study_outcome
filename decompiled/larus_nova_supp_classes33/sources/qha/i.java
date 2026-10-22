package qha;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarHolderBinding;
import com.obric.assistant.impl.databinding.ObricItemPhoneOperationActionbarSkillHolderBinding;
import com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i extends BaseActionBarHolder {
    public final ObricItemPhoneOperationActionbarHolderBinding a;
    public final LayoutInflater b;
    public final t1 c;
    public final boolean d;
    public ObricActionBarSegmentCell e;
    public ObricItemCustomActionbarNormalHolderBinding f;
    public l g;
    public ObricItemPhoneOperationActionbarSkillHolderBinding h;

    public static final class a {
    }

    static {
    }

    public final void U3(RoundConstraintLayout r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.a.b.getChildAt(0) != r3) goto L7;
        return;
    L7:
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L10;
        ViewGroup r1 = (ViewGroup) r0;
    L11:
        if (r1 == null) goto L13;
        r1.removeView(r3);
    L13:
        this.a.b.removeAllViews();
        this.a.b.addView(r3);
        return;
    L10:
        r1 = null;
        goto L11
    }

    public i(ObricItemPhoneOperationActionbarHolderBinding r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        super(r2.a);
        this.a = r2;
        this.b = LayoutInflater.from(r2.a.getContext());
        this.c = r3;
        this.d = r4;
    }
}
